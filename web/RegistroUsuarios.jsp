<%@page import="BLL.Validar"%>
<%@page import="BLL.Escribir"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //Reanudamos la sesión 
    HttpSession ss = request.getSession(false);
    //Literalmente la destruimos por si queda alguna session activa antes de Iniciar la session
    ss.invalidate();
%>
<html>
<head>
	<title>SUD Sistema de gestion - Registro de Usuarios</title>
	<link rel="stylesheet" href="Estilo.css" type="text/css">
</head>
<body>
    <div class="modal">
        <form class="modal-contentreg animate" action="RegistroUsuarios.jsp" method="post">

            <div class="imgcontainerreg">
                <img src="http://www.w3schools.com/howto/img_avatar2.png" alt="Avatar" class="avatarreg">
            </div>

            <div class="container">
                <label><b>Usuario</b></label>
                <input type="text" placeholder="Ingresa Usuario" name="uname" id="uname" required>
                <label><b>Contraseña</b></label>
                <input type="password" placeholder="Ingresa Contraseña" name="psw" id="psw" required>
                <label><b>Confirmar Contraseña</b></label>
                <input type="password" placeholder="Confirma Contraseña" name="psw2" id="psw2" required>
                <label><b>Rut(sin dígito verificador ni puntos)</b></label>
                <input type="text" placeholder="Ej: 12345678" name="rut" id="rut" required>
                <label><b>Nombre y apellido</b></label>
                <input type="text" placeholder="Ingresa Nombre" name="name" id="name" required>
                <button type="submit" id="reg" name="reg">Registrar</button>
                <span class="span"><a href="../SUDpage">Volver</a></span>
            </div>
        </form>
    </div>
    <%
        if (request.getParameter("reg") != null)
        {
            String us = request.getParameter("uname").trim();
            String pw = request.getParameter("psw").trim();
            String pwc = request.getParameter("psw2").trim();
            String ruts = request.getParameter("rut").trim();
            String nom = request.getParameter("name").trim();
            BLL.Usuario u = new BLL.Usuario().buscarUser(us);
            String alerta = "";
            boolean estado = true;
            int rut = 0;
            if (Validar.isNumeric(ruts))
            {
                rut = Integer.parseInt(ruts);
                if (new BLL.Usuario().buscarRutBLL(rut))
                {
                    alerta+="\\n- El rut ingresado ya existe.";
                    estado = false;
                }
            }
            else
            {
                alerta+="\\n- El rut debe ser solo numerico(sin digito verificador).";
                estado = false;
            }
            if (rut == 0)
            {
                alerta+="\\n- Ingrese un rut válido.";
                estado = false; 
            }
            if(u != null)
            {
                alerta+="\\n- El usuario ya existe.";
                estado = false;
            }
            if (!pw.equals(pwc))
            {
                alerta+="\\n- Las contraseñas no coinciden.";
                estado = false;
            }
            if (pw.length()< 6)
            {
                alerta+="\\n- Minimo 6 caracteres en la contraseña.";
                estado = false; 
            }
            
            //Registrar usuario
            if (estado)
            {
                int resultado = new BLL.Usuario().registrarUsuarioBLL(us, pw, rut, nom);
                if (resultado == 1)
                {
                    Escribir.escribir("El usuario: '"+us+"', rut: '"+rut+"', nombre: '"+nom+"' fue registrado exitosamente.");
                    %>  <script>
                            if (window.confirm('El usuario fue registrado exitosamente.')) {
                                window.location.href='http://localhost:7001/SUDpage/index.jsp';
                            }else{
                                window.location.href='http://localhost:7001/SUDpage/index.jsp';
                            }
                        </script>
                        <%
                }
                else
                {
                    Escribir.escribir("Error al intentar registrar el usuario. COD: " + resultado);
                    out.println("<script>alert('Error al intentar registrar el usuario.\\nCOD: "+resultado+"')</script>");
                }
            }
            else
            {
                Escribir.escribir("Revisar las siguientes alertas: "+alerta+"***intente nuevamente***");
                out.println("<script>alert('Revisar las siguientes alertas: "+alerta+"\\n         ***intente nuevamente***')</script>");
            }
        }
    %>
</body>
</html>
