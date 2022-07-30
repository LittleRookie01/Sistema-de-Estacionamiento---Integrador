<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recuperar Contraseña</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        
        <style>
            body {
                background: #ffe259;
                background: linear-gradient(to right, #ffa751, #ffe259);
            }

            .bg {
                background-image: url(IMG/bg-1.jpg);
                background-position: center center;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <div class="container w-75 bg-primary mt-5 rounded shadow">
            <div class="row align-items-stretch">
                <div class="col bg d-none d-lg-block col-md-5 col-lg-5 col-xl-6 rounded">

                </div>
                <div class="col bg-white p-5 rounded-end">
                    <div class="text-end">
                        <img src="IMG/icono.png" width="48" alt="">
                    </div>
                    <h2 class="fw-bold text-center py-4">Recuperar su contraseña</h2>
                    <style></style>
                    <!-- Login -->
                    <form action="Servlet_Login">
                        <div class="mb-4">
                            <label for="text" class="form-label">Digite su correo electronico actual</label>
                            <input type="email" class="form-control" name="email" placeholder="example@gmail.com">
                        </div>
                        <div class="mb-4">
                            <label for="email" class="form-label">Ingrese su nueva contraseña</label>
                            <input type="password" class="form-control" name="password" placeholder="*******">
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Recuperar</button>
                        </div>
                        <div class="my-2">
                            <span>¿No tienes cuenta? <a href="Registrarse.jsp">Registrate</a></span><br>
                        </div>
                        <div class="mb-1">
                            <span>¿Tienes una cuenta? <a href="Login.jsp">Inicia Sesion</a></span><br>
                        </div>

                        <!-- Dando valor a la variable op segun la pagina -->
                        <input type="hidden" name="opcion" value="recuperar">

                        <!-- Mensaje de Alerta de Inicio de Sesion -->
                        <h6> 
                            <%
                                if (request.getAttribute("Rp_msg_E") != null) {
                                    String Rp_msg_E = request.getAttribute("Rp_msg_E").toString();
                            %>
                            <div class="alert alert-danger" role="alert">
                                <%= Rp_msg_E %>
                            </div>                            
                            <% } %>
                        </h6>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
