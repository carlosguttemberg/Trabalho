<%-- 
    Document   : cadastro
    Created on : 20/12/2015, 10:01:29
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro do Usuário</title>
    </head>
    
    
    <body background="brushedmetal103.jpg">
          <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Gerenciamento de Livros</a>
            </div>
               
            </div>
        </nav>
        
        
<!--
         <div class="container-fluid">    
          <div class="col-xs-7 col-sm-6">
          <p class="pull-right visible-xs">

             
      <form class="form-signin">
        <h2 class="form-signin-heading">Cadastro</h2>
        <label for="inputEmail" required class="sr-only">Email address</label>
        <input type="email" id="inputEmail" required class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Cadastrar-se</button>
        <button class="btn btn-lg btn-primary btn-block" type="reset">Limpar</button>
      </form>
          </div>
    </div>
    -->
    
    
    
    
      <div class="container-fluid">    
            <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                <div class="panel panel-success" >
                    <div class="panel-heading">
                        <div class="panel-title"><b>Cadastre-se</b></div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                        <form id="loginform" class="form-horizontal" role="form" action="srvLogin?cmd=incluir" method="POST" >

                            <div class="form-group">
                                <label for="firstname" class="col-md-3 control-label">Nome Completo</label>
                                <div class="col-md-9">
                                    <input type="text" required class="form-control" name="nome" placeholder="Como consta no seu CPF">
                                </div>
                            </div>
                            
                            
                            <div class="form-group">
                                <label for="email" class="col-md-3 control-label">E-mail</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="email" placeholder="exemplo@gmail.com">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="login" class="col-md-3 control-label">Login</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="login" placeholder="">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="password" class="col-md-3 control-label">Senha</label>
                                <div class="col-md-9">
                                    <input type="password" class="form-control" name="senha" placeholder="">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="password" class="col-md-3 control-label">Caminho para a foto</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="caminho" placeholder="">
                                </div>
                            </div>
                            
                            <!--
                             <div class="form-group">
                                <label for="password" class="col-md-3 control-label">Foto de Perfil</label>
                                <div class="col-md-9">
                                    <input type="file" class="field" accept="image/jpeg; image/gif; image/bmp; image/png" name="arquivo" placeholder="">
                                </div>
                                
                            </div>
                            -->
                           
                                
                            
                            <div style="margin-top:10px" class="form-group">
                                <!-- Button -->

                                <div class="col-sm-12 controls">
                                     <div style="float:right; font-size: 80%; position: relative; top:-10px"></div>
                                    <div style="padding-top:15px" class="panel-body" >
                                        
                                    
                                    <button class="btn btn-lg btn-primary btn-success" type="submit">Cadastrar</button>
                                    <button class="btn btn-lg btn-primary btn-success" type="reset">Limpar</button>
                                    <a class="btn btn-lg btn-primary btn-success" href="index.jsp">Cancelar</a>
                                    <!--<a id="btn-fblogin" href="#" class="btn btn-primary">Login comcebook</a>-->
                                    </div>
                                </div>
                            </div>
                        </form>
                       </div>
                            
                                  



                    </div>                     
                </div>
            </div>
        
        
        
        <script src="bootstrap/js/jquery-1.11.3.js"></script>    
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
