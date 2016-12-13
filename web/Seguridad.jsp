<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    //Reanudamos la sesión
    HttpSession ss = request.getSession(false);
    //Validamos si existe realmente una sesión activa o no 
    if (ss.getAttribute("autentica") != "SIP" ) 
    {
        //Si no hay sesión activa, lo direccionamos al Index.jsp (inicio de sesión)
        response.sendRedirect("../SUDpage");
        return;
    }
%>
