<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarse</title>
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
                background-image: url(IMG/bg-4.jpg);
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
                    <h2 class="fw-bold text-center py-5">Registrate</h2>
                    <style></style>

                    <!-- Registro -->
                    <form action="Servlet_Login">
                        <div class="mb-4">
                            <label for="text" class="form-label">DNI</label>
                            <input type="text" class="form-control" name="dni" required>
                        </div>
                        <div class="mb-4">
                            <label for="text" class="form-label">Nombre de Usuario</label>
                            <input type="text" class="form-control" name="usuario" required>
                        </div>                                                
                        <div class="mb-4">
                            <label for="text" class="form-label">Correo Electronico</label>
                            <input type="email" class="form-control" name="email" required>
                        </div>
                        <div class="mb-4">
                            <label for="email" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" name="password" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Guardar</button>
                        </div>
                        <div class="my-3">
                            <span>¿Ya tienes una cuenta? <a href="Login.jsp">Inicia Sesion</a></span><br>
                        </div>

                        <!-- Dando valor a la variable op segun la pagina -->
                        <input type="hidden" name="cargo" value="Cliente"/>
                        <input type="hidden" name="opcion" value="registrar"/>
                        
                        <!-- Mensaje de Alerta de Inicio de Sesion -->
                        <h6> 
                            <%
                                if (request.getAttribute("R_msg_E") != null) {
                                    String msg_E = request.getAttribute("R_msg_E").toString();
                            %>
                            <div class="alert alert-danger" role="alert">
                                <%= msg_E %>
                            </div>                            
                            <% } %>
                        </h6>                                                                     
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
