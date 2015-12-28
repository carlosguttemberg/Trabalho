<%
       String imagem = session.getAttribute("imagem").toString();
       
       String listar = session.getAttribute("listar").toString();
       String lendo = session.getAttribute("lendo").toString();
       
       
       if(listar == null){
           listar ="";
       }
       
       String nome = session.getAttribute("nome").toString();
       
    %>



<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8"> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Colecao</title>

    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="bootstrap/css/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Bem vindo <%=nome%>!</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="index.jsp">Desconectar-se</a>
                    </li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
            
            
     
            

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Gerenciamento de Livros</p>
                <div class="list-group">
                    <img class="slide-image" width="256px" weidth="256px" src=<%=imagem%> alt="">
                    <a href="srvCadastroNovo?tipo=listar" class="list-group-item">Cadastro Livro</a>
                    <a href="srvEditarLivro?opcao=listar" class="list-group-item">Editar Coleção</a>
                    <a href="perfil.jsp" class="list-group-item">Foto Perfil</a>
                    <a href="editarUsuario.jsp" class="list-group-item">Alterar Dados</a>
                </div>
            </div>

                    
            
            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <label class="carousel-caption text-capitalize"><font size="5" color="FFD700">Reuna seus livros</font></label>
                                    <img class="slide-image" src="books.jpg" alt="">
                                </div>
                                <div class="item">
                                    <label class="carousel-caption text-capitalize"><font size="5" color="FFD700">Gerencie sua leitura</font></label>
                                    <img class="slide-image" src="lendo.jpg" alt="">
                                </div>
                                <div class="item">
                                    <label class="carousel-caption text-capitalize"><font size="5" color="FFD700">Desfrute da leitura</font></label>
                                    <img class="slide-image" src="leitura.jpg" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>

   
        <br><br>
        
        <div class="row">
            <div class="col-sm-2 col-lg-2 col-md-2">
                        <div class="thumbnail">                            
                            <div class="caption">                               
                                <h4><label>Lendo</label>
                                </h4>     
                                <h4><label><%=lendo%></label>
                                </h4>        
                            </div>                           
                        </div>
                    </div>
            
            
            <div class="col-sm-2 col-lg-2 col-md-2">
                        <div class="thumbnail">                            
                            <div class="caption">                               
                                <h4><label>Lido</label>
                                </h4>                               
                            </div>                           
                        </div>
            </div>
            
            
            <div class="col-sm-2 col-lg-2 col-md-2">
                        <div class="thumbnail">                            
                            <div class="caption">                               
                                <h4><label>Quero Ler</label>
                                </h4>                               
                            </div>                           
                        </div>
            </div>
            
            <div class="col-sm-2 col-lg-2 col-md-2">
                        <div class="thumbnail">                            
                            <div class="caption">                               
                                <h4><label>Relendo</label>
                                </h4>                               
                            </div>                           
                        </div>
            </div>
            
            
            <div class="col-sm-2 col-lg-2 col-md-2">
                        <div class="thumbnail">                            
                            <div class="caption">                               
                                <h4><label>Desisti</label>
                                </h4>                               
                            </div>                           
                        </div>
            </div>
            
        </div>
  
        <br><br>
                
        <%=listar%>
                
    

    <!-- jQuery -->
    <script src="bootstrap/js/jquery-1.11.3.js"></script> 

    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
