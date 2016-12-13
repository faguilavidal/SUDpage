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
		<div class="contenedor">
			<div class="contenido">
				
			</div><!-- div Contenido-->
		</div><!-- div Contenedor-->
	</body> 
</html>
