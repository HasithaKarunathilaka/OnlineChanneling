package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import repository.DoctorRepository;

public final class doctorProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");

//    String userName = String.valueOf(session.getAttribute("userName"));
    String userName = "d1";
    if(userName == null){ 

      out.write("\n");
      out.write("<script>\n");
      out.write("    ");
      if (true) {
        _jspx_page_context.forward("index.jsp");
        return;
      }
      out.write("\n");
      out.write("</script>\n");
        
    }
    ResultSet result = DoctorRepository.getDoctorDetails("d1");
    String name = null;
    String specialization = null;
    int phone = 0;
        if(result.next()){
            name = result.getString("name");
            specialization = result.getString("specialization");
            phone = result.getInt("phone");
        }

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("       <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/header.css\">\n");
      out.write("       <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/button.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"h1\">E-Channeling System</div>\n");
      out.write("        <div class=\"ul\">\n");
      out.write("            <div class=\"li\"><a href=\"doctorHome.jsp\">Home</a></div>\n");
      out.write("            <div class=\"li\" style=\"background-color: #18514a\"><a href=\"doctorProfile.jsp\">Profile</a></div>\n");
      out.write("            <div class=\"li\" style=\"float:right\"><a href=\"\">LOGOUT</a></div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        ");

            
            System.out.println("In");
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"formBox\">\n");
      out.write("            <form action=\"doctorCntrl.jsp\" name=\"user_signup_form\" method=\"POST\">\n");
      out.write("                <h1>My Details</h1>\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>User ID</td>\n");
      out.write("                        <td><input type=\"text\" name=\"userID\" placeholder=\"User ID\" readonly=\"true\" value=\"");
      out.print( userName);
      out.write("\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Name</td>\n");
      out.write("                        <td><input type=\"text\" name=\"name\" placeholder=\"Full Name\" value=\"");
      out.print( name);
      out.write("\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Phone</td>\n");
      out.write("                        <td><input type=\"text\" name=\"phone\" placeholder=\"07XXXXXXXX\" value=\"");
      out.print( phone);
      out.write("\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td  width=\"150px\">Specialization</td>\n");
      out.write("                        <td><select style=\"background: rgba(255, 255, 255, 0.7)\" name=\"specialization\" value=\"");
      out.print( specialization);
      out.write("\" required>\n");
      out.write("\t\t\t\t<option>General</option>\n");
      out.write("                                <option>Family Medicine</option>\n");
      out.write("\t\t\t\t<option>Emergency Medicine</option>\n");
      out.write("\t\t\t\t<option>Psychiatry</option>\n");
      out.write("\t\t\t\t<option>Surgery</option>\n");
      out.write("\t\t\t\t<option>Cardiology</option>\n");
      out.write("\t\t\t</select></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"submit\" name=\"button\" value=\"Update\"></td>\n");
      out.write("                        <td>\n");
      out.write("                            <!--<form action=\"changePassword.jsp\">-->\n");
      out.write("                                <!--<input type=\"hidden\" name=\"password\" required>-->\n");
      out.write("                                <input  style=\"float:right; width: 180px\" type=\"button\" name=\"changePassword\" value=\"Change Password\">\n");
      out.write("                            <!--</form>-->  \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
