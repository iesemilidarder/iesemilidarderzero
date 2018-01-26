package com.iesemilidarder.projectzero.restapi;

import  com.iesemilidarder.projectzero.core.Restaurantes;
import  com.iesemilidarder.projectzero.restapi.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iesemilidarder.projectzero.core.ReadDB;
import com.iesemilidarder.projectzero.core.Restaurantes;
import com.iesemilidarder.projectzero.core.User;
import freemarker.template.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
/**
 * dummies
 * com.iesemilidarder.fordummies.web
 * Created by alber in 14/12/2017.
 * Description:
 * <p>
 * User[] a;
 * <p>
 * a(10)
 */
public class Launcher {

    private static final Logger log = LoggerFactory.getLogger(Launcher.class);
    private static void init(){

    }
    /**
     * Method to check html output or not
     *
     * @param request
     * @return
     */
    private static boolean shouldReturnHtml(Request request) {
        String accept = request.headers("Accept");

        return StringUtils.contains(accept, "text/html");
        //return accept != null && accept.contains("text/html");
    }

    private static void setResponseHeader(Response response, boolean isHtml) {
        response.status(200);
        response.type(isHtml ? "text/html" : "application/json");
    }

    private static FreeMarkerEngine getFreemarkerEngine() {

        //as https://freemarker.apache.org/docs/pgui_quickstart_createconfiguration.html

        try {

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
            cfg.setClassForTemplateLoading(Launcher.class, "/templates");
            FreeMarkerEngine freemarker = new FreeMarkerEngine(cfg);

            return freemarker;

        } catch (Exception e) {

            log.error("Loading Freemarker Engine, loading default configuration", e);

            return new FreeMarkerEngine();
        }
    }

    public static void main(String... args) {
        staticFiles.location("/public");
        init();
        port(8090);

        /*
        if (localhost) {
            String projectDir = System.getProperty("user.dir");
            String staticDir = "/src/main/resources/public";
            staticFiles.externalLocation(projectDir + staticDir);
        } else {
            staticFiles.location("/public");
        }*/

        //hello world for dummies, via lambdas

        get("/hello", (req, res) -> "Hello World");
        //json response way1: via spark renderer
        get("/json", "application/json", (request, response) -> {
            Restaurantes restaurant  = new Restaurantes();
            restaurant.setNombre("Hello world!");
            return restaurant;

        }, new JsonTransformer());
        //biconditional response way2: via jackson

        get("/restaurantes", (request, response) -> {

            List <Restaurantes> RestaurantsAPI = ReadDB.ReadRestaurantsAPI();

            if (shouldReturnHtml(request)) {
                Map<String, Object> model = new HashMap<>();
                model.put("posts", RestaurantsAPI);
                model.put("title", "Restaurantes de Mallorca");
                model.put("subtitle", "Lista de todos los Restaurantes");
                return getFreemarkerEngine().render(
                        new ModelAndView(model, "basicView.ftl")
                );
            } else {
                CorsFilter.apply();
                ObjectMapper mapper = new ObjectMapper();
                setResponseHeader(response, false);
                return mapper.writeValueAsString(RestaurantsAPI);
            }
        });

        /*get("/scrap",(request,response)->{
            Map<String, Object> model = new HashMap<>();
            String query = ".center-content";
            String url = "https://www.meneame.net/";
            ScrappingCommand cmd = new ScrappingCommand(url, query);
            model.put("title", "Scrapping");
            model.put("url", url);
            model.put("element", query);
            model.put("content", cmd.getResult());
            return getFreemarkerEngine().render(
                    new ModelAndView(model, "scrapView.ftl")
            );
        });*/

    }

}

