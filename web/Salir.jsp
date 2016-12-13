<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //Reanudamos la sesión 
    HttpSession ss = request.getSession(false);
    //Literalmente la destruimos
    ss.invalidate();
    //Redireccionamos a index.php (al inicio de sesión)
    response.sendRedirect("../SUDpage");
%>