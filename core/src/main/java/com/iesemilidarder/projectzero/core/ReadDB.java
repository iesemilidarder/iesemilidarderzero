package com.iesemilidarder.projectzero.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/*
Importamos las siguientes librerias para que funcione en programa
*/

/*
Creamos una clase llamada ReadDB y una arrayList para conectarnos a una base de datos de oracle
*/
public class ReadDB {
    /*
    en el arraylist readRestaurants le ponemos una string llamado consulta
     */
    public ArrayList readRestaurants(String consulta) {
        ArrayList rl = new ArrayList();
        try {
/*
Decimos que tipo de base de datos nos queremos conectar y a que IP, puerto, usuario y contraseña
*/
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            Statement stmt = con.createStatement();
/*
Creamos un select para poder visualizar la tabla y otra select para que encuentre el nnombre del restaurante escrito en el index.jsp
*/

            ResultSet rs;
            /*
            creamos un if y un else con la consulta del arraylist
            */
            if (consulta == null) {
                rs = stmt.executeQuery("SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, R.RES_URL_IMG, R.RES_MITJANA, T.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS T WHERE R.RES_TRS_CODI = T.TRS_CODI ORDER BY RES_MITJANA DESC ");
            } else {
                rs = stmt.executeQuery("SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, R.RES_URL_IMG, R.RES_MITJANA, T.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS T WHERE R.RES_TRS_CODI = T.TRS_CODI AND LOWER(RES_NOM) LIKE '%" + consulta.toLowerCase() + "%'");

            }
            while (rs.next()) {
                String codigo = rs.getString("RES_CODI");
                String nombre = rs.getString("RES_NOM");
                String direccion = rs.getString("RES_ADRECA");
                String web = rs.getString("RES_WEB");
                String telefono = rs.getString("RES_TELEFON");
                String imagen = rs.getString("RES_URL_IMG");
                String mitjana = rs.getString("RES_MITJANA");
                String descripcion = rs.getString("TRS_DESCRIPCIO");


                Restaurantes rst = new Restaurantes();
                rst.setCodigo(codigo);
                rst.setNombre(nombre);
                rst.setDireccion(direccion);
                rst.setWeb(web);
                rst.setTelefono(telefono);
                rst.setImagen(imagen);
                rst.setMitjana(mitjana);
                rst.setDescripcion(descripcion);

                //Restaurants rst = new Restaurants();
                //rst.setCodigo(codigo);
                //rst.setNombre(nombre);
                //rst.setDireccion(direccion);
                //rst.setWeb(web);
                //rst.setTelefono(telefono);
                //rst.setImagen(imagen);
                //rst.setMitjana(mitjana);
                //rst.setDescripcion(descripcion);

                rl.add(rst);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rl;
    }
/*
Creamos una clase llamada Restaurants y nos conectamos a una base de datos de oracle
*/

    public static Restaurantes readRestaurant(String id) {
        Restaurantes restaurante = null;
        try {
/*
Decimos que tipo de base de datos nos queremos conectar y a que IP, puerto, usuario y contraseña
*/
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            Statement stmt = con.createStatement();
/*
Creamos un select para poder visualizar la tabla y que se visualice en el mostrar.jsp
*/

            ResultSet rs;
            /*
            Ejecutamos la query que necesitemos
            */


            rs = stmt.executeQuery("SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON,\n" + "  R.RES_URL_IMG, R.RES_MITJANA, R.RES_LATITUD, R.RES_LONGITUD, T.TRS_DESCRIPCIO\n" + "FROM RESTAURANTS R\n" + "  JOIN TRESTAURANTS T ON R.RES_TRS_CODI=T.TRS_CODI\n" + "WHERE R.RES_CODI = " + id + "");

            if (rs.next()) {
                String codigo = rs.getString("RES_CODI");
                String nombre = rs.getString("RES_NOM");
                String direccion = rs.getString("RES_ADRECA");
                String web = rs.getString("RES_WEB");
                String telefono = rs.getString("RES_TELEFON");
                String imagen = rs.getString("RES_URL_IMG");
                String mitjana = rs.getString("RES_MITJANA");
                String latitud = rs.getString("RES_LATITUD");
                String longitud = rs.getString("RES_LONGITUD");
                String descripcion = rs.getString("TRS_DESCRIPCIO");


                restaurante = new Restaurantes();
                restaurante.setCodigo(codigo);
                restaurante.setNombre(nombre);
                restaurante.setDireccion(direccion);
                restaurante.setWeb(web);
                restaurante.setTelefono(telefono);
                restaurante.setImagen(imagen);
                restaurante.setMitjana(mitjana);
                restaurante.setLatitud(latitud);
                restaurante.setLongitud(longitud);
                restaurante.setDescripcion(descripcion);

                rs = stmt.executeQuery("SELECT O.OPI_OBSERVACIO, O.OPI_PUNTUACIO, U.USU_NOM FROM OPINIONS O JOIN USUARIS U ON U.USU_CODI = O.OPI_USU_CODI JOIN RESTAURANTS R ON O.OPI_RES_CODI = R.RES_CODI WHERE R.RES_CODI =" + id + "");

                //restaurante = new Restaurants();
                //restaurante.setCodigo(codigo);
                //restaurante.setNombre(nombre);
                //restaurante.setDireccion(direccion);
                //restaurante.setWeb(web);
                //restaurante.setTelefono(telefono);
                //restaurante.setImagen(imagen);
                //restaurante.setMitjana(mitjana);
                //restaurante.setLatitud(latitud);
                //restaurante.setLongitud(longitud);
                //restaurante.getOpiniones().add(op);
                //restaurante.setDescripcion(descripcion);

            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return restaurante;
    }

    public ArrayList readOpiniones(String id) {

        ArrayList arrayOpiniones = new ArrayList();

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            Statement stmt = con.createStatement();

            ResultSet rs;
            rs = stmt.executeQuery("SELECT O.OPI_OBSERVACIO, O.OPI_PUNTUACIO, U.USU_NOM FROM OPINIONS O JOIN USUARIS U ON U.USU_CODI = O.OPI_USU_CODI JOIN RESTAURANTS R ON O.OPI_RES_CODI = R.RES_CODI\n WHERE R.RES_CODI = " + id + "");

            while (rs.next()) {

                String observacion = rs.getString("OPI_OBSERVACIO");
                String puntuacion = rs.getString("OPI_PUNTUACIO");
                String usuario = rs.getString("USU_NOM");

                //Opinions op = new Opinions();
                //op.setObservacion(observacion);
                //op.setPuntuacion(puntuacion);
                //op.setUsuario(usuario);

                Opinions op = new Opinions();
                op.setObservacion(observacion);
                op.setPuntuacion(puntuacion);
                op.setUsuario(usuario);
                arrayOpiniones.add(op);

            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arrayOpiniones;
    }
/*
Arraylist para proyecto
*/



    public static List ReadRestaurantsAPI () {
        ArrayList LeerRestaurantes = new ArrayList();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari",  "usuari" );

            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT RES_CODI, RES_NOM, RES_ADRECA, RES_WEB, RES_TELEFON, RES_URL_IMG FROM RESTAURANTS");

            while (rs.next()) {
                String nombre = rs.getString("RES_NOM");
                String direccion = rs.getString("RES_ADRECA");
                String web = rs.getString("RES_WEB");
                String telefono = rs.getString("RES_TELEFON");
                String imagen = rs.getString("RES_URL_IMG");
                String codigo = rs.getString("RES_CODI");

                Restaurantes rest = new Restaurantes();
                rest.setNombre(nombre);
                rest.setDireccion(direccion);
                rest.setWeb(web);
                rest.setTelefono(telefono);
                rest.setImagen(imagen);
                rest.setCodigo(codigo);
                LeerRestaurantes.add(rest);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return LeerRestaurantes;

    }
}

/*
Tomás Sastre Cámara
2n ASIX
WAI
*/

