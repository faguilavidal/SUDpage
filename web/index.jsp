<%@page import="BLL.Escribir"%>
<%@page import="BLL.Usuario"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="DAL.Conexion"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //Reanudamos la sesión 
    HttpSession ss = request.getSession(false);
    //Literalmente la destruimos por si queda alguna session activa antes de Iniciar la session
    ss.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SUD Sistema de gestion</title>
<link rel="stylesheet" href="Estilo.css" type="text/css">
</head>
<body>
    <div class="modal">
    <form class="modal-content animate" action="index.jsp" method="post">
        <div class="imgcontainer">
            <img src="http://www.w3schools.com/howto/img_avatar2.png" alt="Avatar" class="avatar">
        </div>
        <div class="container">
            <label><b>Usuario</b></label>
            <input type="text" placeholder="Ingresa Usuario" name="uname" id="uname" required>
            <label><b>Contraseña</b></label>
            <input type="password" placeholder="Ingresa Contraseña" name="psw" id="psw" required>
            <button type="submit" id="log" name="log">Iniciar sesión</button>
            <span class="span">Registrate <a href="RegistroUsuarios.jsp">Aqui</a></span>
        </div>
    </form>
    </div>
    <%
        if (request.getParameter("log") != null)
        {
            String us = request.getParameter("uname");
            String passEntregada = request.getParameter("psw");
            BLL.Usuario u = new BLL.Usuario().buscarUser(us);
            if(u != null)
            {
                String passDataBase = u.getContraseña();
                if (passEntregada.equals(passDataBase)) 
                {
                    //Acceso Validado
                    ss = request.getSession();
                    ss.setAttribute("autentica", "SIP");
                    ss.setAttribute("usuarioactual", u.getUsuario());
                    response.sendRedirect("Principal.jsp");
                }
                else{
                    Escribir.escribir("***Index.jsp: La contraseña no coincide con el usuario.");%>
                    <script>alert('La contraseña del usuario no es correcta.');</script>
                <%}    
            }       
            else{
                Escribir.escribir("***Index.jsp: El usuario '"+us+"' no existe.");%>
                <script>alert('El usuario indicado no existe.');</script>
            <%}
        }
    %>
</body>
</html>
