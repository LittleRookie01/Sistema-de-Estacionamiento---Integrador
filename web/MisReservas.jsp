<%@page import="Beans.MisReservas"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page session="true"%>
<%
    String dni = "";
    String usuario = "";
    String cargo = "";
    HttpSession sesionOk = request.getSession();

    if (sesionOk.getAttribute("usuario") == null) {
%>
<jsp:forward page="Login.jsp">
    <jsp:param name="msg2" value="Debe Loguearse Correctamente"/>
</jsp:forward>
<%
    } else {
        dni = (String) sesionOk.getAttribute("dni");
        usuario = (String) sesionOk.getAttribute("usuario");
        cargo = (String) sesionOk.getAttribute("cargo");
    }
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Hello, world!</title>
        <!-- Font Awesome -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            rel="stylesheet"
            />
        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
            />
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">

        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
                crossorigin="anonymous">
        </script>
        <style>

            ::-webkit-scrollbar {
                width: 5px;
            }

            /* Track */
            ::-webkit-scrollbar-track {
                box-shadow: inset 0 0 5px rgb(0, 0, 0, 0.1);
                border-radius: 10px;
            }

            /* Handle */
            ::-webkit-scrollbar-thumb {
                background: rgb(69, 162, 158, 0.2);
                border-radius: 10px;
            }

            /* Handle on hover */
            ::-webkit-scrollbar-thumb:hover {
                background: rgb(69, 162, 158, 0.6);
                cursor: pointer;
            }
            body {
                background-color: #e6e6e6;
            }
            .page .sidebar{
                background: linear-gradient(35deg, #66fcf1, #45a29e);
                position: fixed;
                top: 0;
                left: 0;
                width: 250px;
                height: 100vh;
                overflow-y: auto;
                overflow-x: hidden;
                transition: all 0.3s ease;
            }


            .page .content{
                margin-left: 250px;
                transition: all 0.3s ease;
            }

            .navigationBar {
                background-color: white;
                height: 50px;
                display: flex;
                padding: 38px 0px;
                align-items: center;
                box-shadow: 0 4px 2px -2px #c5c6c7;
            }

            .sidebarToggle {
                font-size: 16px;
                color: rgb(0, 0, 0, 0.8);
                margin-left: -20px;
                z-index: 999;
                border-radius: 50px;
                background-color: #e6e6e6;
                transition: all 0.3s ease;
                outline: none!important;
                box-shadow: none!important;
            }

            .sidebarToggle.active {
                margin-left: 10px;
            }

            .sidebarToggle:hover{
                color: white;
            }

            .page .content .container{
                margin: 30px;
                background: #fff;
                padding: 50px;
                line-height: 28px;
            }

            body.active .page .sidebar{
                left: -250px;
            }

            body.active .page .content{
                margin-left: 0;
                width: 100%;
            }
            .sidebar-header {
                padding: 10px 25px 10px 15px;
            }
            .sidebar-logo-container {
                background-color: rgb(0, 0, 0, 0.2);
                border-radius: 8px;
                padding-left: 3px;
                display: flex;
            }

            .logo-container {
                max-width: 40px;
                background-color: rgb(255, 255, 255, 0.1);
                border-radius: 5px;
                margin: 8px;
                padding: 6px 8px;
            }

            .brand-name-container {
                margin: 10px 55px 0px 2px;
                padding: 0px;
            }

            .logo-sidebar {
                width: 100%;
                height: auto;
            }

            .brand-name {
                color: white;
                margin: 0px;
                line-height: 1.1rem;
                font-size: 16px;
                letter-spacing: 1px;
                font-family: 'Roboto', sans-serif;
            }
            .brand-subname {
                font-weight: 300;
                font-size: 14px;
            }
            .navigation-list {
                list-style-type:none;
                padding: 0px 18px;
                margin-top: 30px;
            }
            .navigation-list-item {
                padding: 12px 18px 12px 25px;
                margin: 15px 0px;
                border-radius: 8px;

            }
            .navigation-list-item:hover {
                background: rgb(0, 0, 0, 0.05);
                box-shadow: 0 0 0.4em rgb(255, 255, 255, 0.1);
                cursor: pointer;
            }
            .navigation-list-item.active {
                background: rgb(0, 0, 0, 0.1);
                box-shadow: 0 0 0.4em rgb(255, 255, 255, 0.1);
            }
            .navigation-link {
                color: rgb(31, 40, 51, 0.8);
                letter-spacing: 0.5px;
                font-weight: 400;
                text-decoration: none;
                font-size: 16px;
                font-family: 'Roboto', sans-serif;
            }
            .navigation-link i {
                font-size: 18px;
            }
            .navigation-list-item:hover .navigation-link {
                color: rgb(255, 255, 255, 0.7);
            }
            .navigation-list-item.active .navigation-link {
                color: rgb(255, 255, 255, 0.8);
                font-weight: 500;
            }
            .teams-title-container {
                padding-left: 30px;
                margin-top: 25px;
                margin-bottom: 25px;
            }
            .teams-title {
                letter-spacing: 0.5px;
                font-size: 17px;
                color: rgb(31, 40, 51, 0.8);
                font-family: 'Roboto', sans-serif;
            }
            .teams-list {
                padding-left: 32px;
                list-style-type:none;
            }
            .teams-item {
                letter-spacing: 0.5px;
                font-size: 16px;
                color: rgb(31, 40, 51, 0.8);
                font-family: 'Roboto', sans-serif;
                margin-bottom: 30px;
            }
            .teams-item i {
                font-size: 12px;
            }
        </style>
    </head>

    <body>

        <div class="page">

            <div class="sidebar">
                <div class="sidebar-header">
                    <div class="sidebar-logo-container">
                        <div class="logo-container">
                            <img class="logo-sidebar" src="assets/img/logo.png" />
                        </div>
                        <div class="brand-name-container">
                            <p class="brand-name">
                                <%=usuario%><br />
                                <span class="brand-subname">
                                    <%=cargo%>
                                </span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="sidebar-body">
                    <ul class="navigation-list">
                        <li class="navigation-list-item">
                            <a class="navigation-link" href="Inicio.jsp">
                                <div class="row">
                                    <div class="col-2">
                                        <i class="fas fa-tachometer-alt"></i>
                                    </div>
                                    <div class="col-9">
                                        Dashboard
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="navigation-list-item">
                            <a class="navigation-link" href="Servlet_Vehiculos?op=listar&dni=<%=dni%>">
                                <div class="row">
                                    <div class="col-2">
                                        <i class="fas fa-car"></i>
                                    </div>
                                    <div class="col-9">
                                        Mis Vehiculos
                                    </div>
                                </div>
                            </a>
                        </li>

                        <li class="navigation-list-item">
                            <a class="navigation-link" href="Servlet_Reserva?op=listar&dni=<%=dni%>">
                                <div class="row">
                                    <div class="col-2">
                                        <i class="fas fa-parking"></i>
                                    </div>
                                    <div class="col-9">
                                        Estacionamiento
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="navigation-list-item active">
                            <a class="navigation-link" href="Servlet_MisReservas?op=listar&dni=<%=dni%>">
                                <div class="row">
                                    <div class="col-2">
                                        <i class="fas fa-calendar-alt"></i>
                                    </div>
                                    <div class="col-9">
                                        Mis Reservas
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="navigation-list-item">
                            <a class="navigation-link" href="Servlet_Tarifario?op=listar">
                                <div class="row">
                                    <div class="col-2">
                                        <i class="fas fa-money-bill"></i>
                                    </div>
                                    <div class="col-9">
                                        Tarifario
                                    </div>
                                </div>
                            </a>
                        </li>

                        <li class="navigation-list-item">
                            <a class="navigation-link" href="Perfil.jsp">
                                <div class="row">
                                    <div class="col-2">
                                        <i class="fas fa-user"></i>
                                    </div>
                                    <div class="col-9">
                                        Perfil
                                    </div>
                                </div>
                            </a>
                        </li>
                        
                        <li class="navigation-list-item">
                        <a class="navigation-link" href="Servlet_Login?opcion=cerrar_sesion">
                            <div class="row">
                                <div class="col-2">
                                    <i class="fas fa-user"></i>                                    
                                </div>
                                <div class="col-9">
                                    Cerrar Sesion
                                </div>
                            </div>
                        </a>
                    </li>
                    </ul>

                </div>
            </div>

            <div class="content">
                <div class="navigationBar">
                    <button id="sidebarToggle" class="btn sidebarToggle">
                        <i class="fas fa-bars"></i>
                        </a>
                </div>

                <div class="conataine-fluid mt-4">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <i class="fas fa-book"></i> Mis Reservas
                            </div>

                            <div class="card-body">
                                <table class="table-condensed table">
                                    <thead>
                                        <tr>
                                            <th scope="col">#</th>                                                                                        
                                            <th scope="col">Placa</th>
                                            <th scope="col">H.entrada</th>
                                            <th scope="col">H.Salida</th>
                                            <th scope="col">Espacio</th>                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                            ArrayList<MisReservas> lista = (ArrayList<MisReservas>) request.getAttribute("lista");
                            for (int i = 0; i < lista.size(); i++) {
                                MisReservas mr = lista.get(i);
                        %>
                                        <tr>
                                            <th scope="row">
                                                <%= i + 1 %>
                                            </th>
                                            <td>
                                                <%= mr.getPlaca()%>
                                            </td>
                                            <td>
                                                <%= mr.getH_entrada()%>
                                            </td>
                                            <td>
                                                <%= mr.getH_salida()%>
                                            </td>
                                            <td>
                                                <%= mr.getEs_zona()%>
                                            </td>
                                            <td><button type="button" class="btn btn-primary" disabled>Salida</button></td>                                            
                                        </tr>
                                        <% } %>
                                    </tbody> 
                                </table>
                            </div>
                        </div>                        
                    </div>                    
                </div>

            </div>

        </div>


        <script>
            let sidebarToggle = document.querySelector(".sidebarToggle");
            sidebarToggle.addEventListener("click", function () {
                document.querySelector("body").classList.toggle("active");
                document.getElementById("sidebarToggle").classList.toggle("active");
            })
        </script>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
        </script>
    </body>


</html>
