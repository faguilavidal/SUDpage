
package SL;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PersonaSL", urlPatterns = {"/PersonaSL"})
public class PersonaSL extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PersonaSL</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("");
            out.println("</body>");
            out.println("</html>");
        }
    }
//EScribir metodo para registrar persona en jsp
//    private void registrarPersonaSud(){
//        try
//        {
//            String rutDV = this.jtxtRutRegistro.getText();
//            int rut = Integer.parseInt(rutDV.substring(0,rutDV.length() - 2));
//            String nombre = jtxtNombreRegistro.getText().trim();
//            if(nombre.length() == 0)
//            {
//                nombre = null;
//            }
//            int contacto = Integer.parseInt(jtxtContacto.getText());
//            int folio = Integer.parseInt(jtxtFolio.getText());
//            String alojamiento = jtxtAlojamiento.getText().trim();
//            if(alojamiento.length() == 0)
//            {
//                alojamiento = null;
//            }
//            int idciudad = new BLL.Ciudad().obtenerIdCiudad(jcboCiudad.getSelectedItem().toString());
//            int idiglesia = new BLL.Iglesia().obtenerIdIglesia(jcboIglesia.getSelectedItem().toString());
//            int año = Integer.parseInt(jcboAñoRegistro.getSelectedItem().toString());
//            int resultado = new BLL.Persona().registrarPersona(rut, nombre, contacto, folio, alojamiento, idciudad, idiglesia, año);
//            switch (resultado) 
//            {
//                case 1: JOptionPane.showMessageDialog(jButtonIngresarRegistro, "Persona registrada exitosamente", "Registros", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Imagenes/Add-Male-User4848.png"));
//                        listadoPersonasSud();
//                        registrarMovimientoResgistro();
//                        reestablecerFormularioRegistroPersona();
//                        break;
//                case 1048: jlblBarraEstadoRegistro.setText("Debe ingresar todos los campos"); 
//                           break;
//                case 1062: jlblBarraEstadoRegistro.setText("Rut y/o Folio ya Registrado(s)"); 
//                           this.jtxtRutRegistro.setBackground(Color.gray);
//                           this.jtxtFolio.setBackground(Color.gray);
//                           break;
//                case 1406: jlblBarraEstadoRegistro.setText("Datos exceden la longitud máxima permitida"); 
//                           break;
//                case 1452: jlblBarraEstadoRegistro.setText("Año del Evento Incorrecto");
//                           jcboAñoRegistro.setBackground(Color.cyan);
//                           break;
//                default: JOptionPane.showMessageDialog(jButtonIngresarRegistro, "Error desconocido. Contacte el administrador: " + resultado, "Registros", JOptionPane.ERROR_MESSAGE); 
//                           break;
//            }
//        }
//        catch(NumberFormatException e)
//        {
//            JOptionPane.showMessageDialog(this.jtxtRutRegistro, "Debe Ingresar: \n-Rut.\n-Contacto.\n-Folio.\n-Monto.","Registros SUD",JOptionPane.WARNING_MESSAGE);
//        }
//        catch(NullPointerException e)
//        {
//            JOptionPane.showMessageDialog(this.jtxtRutRegistro, "Debe seleccionar: \n-Ciudad\n-Iglesia","Registros SUD",JOptionPane.WARNING_MESSAGE);
//        }
//    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
