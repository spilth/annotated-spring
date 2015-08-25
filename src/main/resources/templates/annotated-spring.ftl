<#macro application>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <meta name="description" content="Spring Screencasts">
    <meta name="author" content="Brian Kelly">

    <title>Annotated Spring</title>

    <link rel='stylesheet' href='/webjars/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel='stylesheet' href='/stylesheets/annotated-spring.css'>
</head>

<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Annotated Spring</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Episodes</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="starter-template">
        <#nested>
    </div>
</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted"><a href="https://github.com/AnnotatedSpring/annotated-spring">Web Site Source Code</a></p>
    </div>
</footer>

</body>
</html>
</#macro>