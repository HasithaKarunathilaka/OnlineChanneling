package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class doctorRegister_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/login.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/button.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/header.css\">\n");
      out.write("        \n");
      out.write("        <script language=\"javascript\">\n");
      out.write("            \n");
      out.write("            function datavalid(){\n");
      out.write("          \n");
      out.write("                if(document.user_signup_form.password.value!=document.user_signup_form.cpw.value) {\n");
      out.write("                    alert(\"Password and Confirmation does not match\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    return confirm;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"h1\">E-Channeling System</div>\n");
      out.write("        <div class=\"ul\">\n");
      out.write("            <div class=\"li\"><a href=\"index.jsp\">Login</a></div>\n");
      out.write("            <div class=\"li\" style=\"float:right; background-color: #18514a\"><a href=\"doctorRegister.jsp\">Doctor Registration</a></div>\n");
      out.write("            <div class=\"li\" style=\"float:right\"><a href=\"patientRegister.jsp\">Patient Registration</a></div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"signBox\">\n");
      out.write("            <form action=\"doctorCntrl.jsp\" name=\"user_signup_form\"   onsubmit=\"return datavalid()\"  method=\"POST\">\n");
      out.write("                <h1>Doctor Sign Up</h1>\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td width=\"50%\">Name</td>\n");
      out.write("                        <td><input type=\"text\" name=\"name\" placeholder=\"Full Name\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>User ID</td>\n");
      out.write("                        <td><input type=\"text\" name=\"userID\" placeholder=\"User ID\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Phone</td>\n");
      out.write("                        <td><input type=\"text\" name=\"phone\" placeholder=\"07XXXXXXXX\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Specialization</td>\n");
      out.write("                        <td><select style=\"background: rgba(5, 1, 26, 0.7)\" name=\"specialization\" required>\n");
      out.write("\t\t\t\t<option selected>General</option>\n");
      out.write("                                <option>Family Medicine</option>\n");
      out.write("\t\t\t\t<option>Emergency Medicine</option>\n");
      out.write("\t\t\t\t<option>Psychiatry</option>\n");
      out.write("\t\t\t\t<option>Surgery</option>\n");
      out.write("\t\t\t\t<option>Cardiology</option>\n");
      out.write("\t\t\t</select></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Password</td>\n");
      out.write("                        <td><input type=\"password\" name=\"password\" placeholder=\"Password\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Confirm Password</td>\n");
      out.write("                        <td><input type=\"password\" name=\"cpw\" placeholder=\"Re-Enter Password\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                <center><input type=\"submit\" name=\"button\" value=\"Sign Up\"></center>\n");
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
