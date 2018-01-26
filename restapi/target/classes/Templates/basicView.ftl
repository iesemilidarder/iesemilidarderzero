<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.min.css" crossorigin="anonymous">
    <title>${title!""}</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Inicio</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="http://bfy.tw/Ffa2">Mejores Restaurantes <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="http://www.latlmes.com/food/restaurantes-de-mallorca-1">Other actions</a>
            </li>
        </ul>
    </div>
</nav>
<main role="main" class="container">
    <div class="row featurette">
        <div class="col-md-7">
            <h1>${title!""}</h1>
            <h2 class="featurette-heading">${subtitle!""}
                <br/><span class="text-muted">Porque molo mogollón.</span>
            </h2>
        </div>
        <div class="col-md-5">
            <img src="http://lorempixel.com/500/150"/>
        </div>
    </div>
<#if posts??>
    <div class="row center mt-2">
        <#list posts as item>
            <div class="col-md-3">
                <div class="media mt-5 ml-5">
                    c
                         <img src="${item.imagen!""}" width="100" height="100"/>
                    <div class="media-body">
                        <h5 class="mt-0">${item.nombre!""}</h5>
                        <p>Codigo: ${item.codigo!""}</p>
                        <p>Direccion: ${item.direccion!""}</p>
                        <p>Pagina Web: ${item.web!""}</p>
                        <p>Telefono: ${item.telefono!""}</p>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</#if>
</main>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
        integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
        crossorigin="anonymous"></script>
</body>
</html>