<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Seguridad.jsp"%>
<!DOCTYPE html>
<html> 
<head> 
<title>Principal</title> 
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="Estilo.css" type="text/css">
</head> 
	<body>
		<header>
			<!--BARRA DE NAVEGACION-->
			<ul>
			  <li style="background-color: #514;"><a style="color: white;" href="Principal.jsp">Registro de Personas</a></li>
			  <li><a href="Ingresos.jsp">Ingresos</a></li>
			  <li><a href="Egresos.jsp">Egresos</a></li>
			  <li><a href="Listas.jsp">Movimientos de Dinero</a></li>
			  <li style="float:right" class="dropdown"><a class="active dropbtn" style="width:auto;">Bienvenido <% out.println(request.getSession().getAttribute("usuarioactual").toString()); %></a>
			  <div class="dropdown-content">
			      <a href="Salir.jsp">Cerrar sesión</a>
			    </div>
			  </li>
			</ul>
			<!-- FIN BARRA DE NAVEGACION-->
		</header>
                <form action="Principal.jsp" method="post">
		<div class="contenedor">
                <label><b>Rut</b></label>
                <input type="text" placeholder="" name="rutin" id="rutin" required>
                <label><b>Nombre</b></label>
                <input type="text" placeholder="" name="nombre" id="nombre" required>
                <label><b>Contacto</b></label>
                <input type="text" placeholder="" name="contacto" id="contacto" required>
                <label><b>Folio</b></label>
                <input type="text" placeholder="" name="folio" id="folio" required>
                <label><b>Ciudad</b></label>
                <select name="ciudad" id="ciudad">
                    <% ResultSet values = new BLL.Ciudad().ciudades();
                      while(values.next()){ 
                    out.println("<option values\""+values.getString(1)+"\">"+values.getString(2)+"</option>");
                    }%>
                </select>
                <label><b>Local</b></label>
                <select name="local" id="local">
                    <%//Aqui se cargan los locales con un arreglo DAL.Local desde la base 
                    %><option><%%></option><%
                    %>
                </select>
                <label><b>Monto</b></label>
                <input type="text" placeholder="" name="monto" id="monto" required>
                <label><b>Observacion</b></label>
                <input type="text" placeholder="" name="observacion" id="observacion" required>
                <button type="submit" id="regis" name="regis">Registrar</button>
		</div><!-- div Contenedor-->
                </form><!-- form Contenedor-->
                <form action="Principal.jsp" method="post">
                    <div class="ciudad">
                        <label><b>ID</b></label>
                        <input type="text" name="idciudad" id="idciudad" value="<% out.println(new BLL.Ciudad().registroMaxCiudad()+1); %>" readonly>
                        <label><b>Ciudad</b></label>
                        <input type="text" placeholder="" name="nciudad" id="nciudad" required>
                        <button type="submit" id="regc" name="regc">Agregar ciudad</button>
                    </div><!-- div Ciudad-->
                </form><!-- form Ciudad-->
                <form action="action">
                    <div class="local">

                    </div><!-- div Local-->
                </form><!-- form Local-->
                <%
                
                    if (request.getParameter("regc") != null)
                    {
                        String idtxt = request.getParameter("idciudad");
                        int id = Integer.parseInt(idtxt);
                        String nciudad = request.getParameter("nciudad");
                        int result = new BLL.Ciudad().registrarNuevaCiudad(id, nciudad);
                        if (result == 1)
                        {
                            response.sendRedirect("Principal.jsp");
                        }
                        else
                        {
                            out.println("<h1>Fallo</h1>");
                        }
                    }
                
                %>
                
                </body> 
</html>
