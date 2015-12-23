<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Auto Slideshow</title>
</head>
<body>
    
    
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="leitura.jpg" alt="Chania">
    </div>

    <div class="item">
      <img src="colecao.jpg" alt="Chania">
    </div>

    <div class="item">
      <img src="melina.jpg" alt="Flower">
    </div>

    <div class="item">
      <img src="zoeira.jpg" alt="Flower">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

    <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>    
    <script src="bootstrap/js/bootstrap.min.js"></script>
    
</body>
</html>
