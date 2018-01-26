<%@ page import="com.iesemilidarder.projectzero.core.ReadDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.iesemilidarder.projectzero.core.Restaurantes" %>
<%@ page import="com.iesemilidarder.projectzero.core.ShowRestaurantsServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ca">
<head>
    <title>Restaurantes</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.min.css" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<!-- Navigation bar -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="index.jsp">Inicio</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="http://bfy.tw/Ffa2">Mejores Restaurantes del Mundo <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="test">Trabaja con Nosotros</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="https://github.com/tsc00">Conócenos</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <!--En el input creamos un name y le ponemos un nombre-->
            <input class="form-control mr-sm-2" type="text" name="buscar" placeholder="Cercar" aria-label="Cercar">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cercar</button>
        </form>
    </div>
</nav>

<main role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">Restaurantes de Mallorca</h1>
            <p><h3>En esta pagina conoceremos los mejores restaurantes de Mallorca segun el criterio de los clientes.</h3>
            <h9>Les recordamos que las opiniones son 100% propias de los clientes y no nos hacemos responsable de sus comentarios</h9> </p>
            <p><a class="btn btn-primary btn-lg" href="test" role="button">Para más información llámenos al 654422516</a></p>
        </div>
    </div>


    <div class="container">

        <!--En el html escribimos codigo java para que con el parametro buscar visulaice todos los restaurantes de la base de datos-->
        <%
            ReadDB readDB = new ReadDB();
            /*
            Creamos una nueva conexion a la base de datos y un arraylist con los parametros deseados, que busque en la base de datos y visualice los 5 mejores restaurantes
             */
            ArrayList rl = readDB.readRestaurants(request.getParameter("buscar"));
            Iterator itr = rl.iterator();
            while (itr.hasNext()) {
                Restaurantes rst = (Restaurantes) itr.next();
                out.println("        <div class=\"row\">\n" +
                        "            <div class=\"col-md-4\">\n" +
                        "                <img class=\"img-fluid\" src=\""+rst.getImagen()+"\">" +
                        "            </div>" +
                        "            <div class=\"col-md-8\">\n" +
                        "                <h2>"+rst.getNombre()+"</h2>\n" +
                        "                <p>"+rst.getMitjana()+ " <img src=\"https://png.icons8.com/color/26/000000/fork.png\">"+"</p>\n" +
                        "                <p>"+rst.getDireccion()+"</p>\n" +
                        "                <p>"+rst.getWeb()+"</p>\n" +
                        "                <p>"+rst.getTelefono()+"</p>\n" +
                        "                <p>"+rst.getDescripcion()+"</p>\n" +
                        "                <p><a class=\"btn btn-secondary\" href=\"more?id="+rst.getCodigo()+"\" role=\"button\">Más Información &raquo;</a></p>\n" +
                        "            </div>\n" +
                        "        </div>");
            }
            out.println();
        %>


        <hr>

    </div> <!-- /container -->

</main>

<footer class="container">
    <p>&copy; Tomás Sastre Cámara 2018</p>
</footer>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>
<!--
Tomás Sastre Cámara
2n ASIX
WAI
-->
