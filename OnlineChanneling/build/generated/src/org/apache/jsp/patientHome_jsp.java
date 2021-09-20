package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class patientHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String userName = String.valueOf(session.getAttribute("userName"));
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

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/header.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/button.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"h1\">E-Channeling System</div>\n");
      out.write("        <div class=\"ul\">\n");
      out.write("            <div class=\"li\" style=\"background-color: #18514a\"><a href=\"patientHome.jsp\">Home</a></div>\n");
      out.write("            <div class=\"li\"><a href=\"patientAppointments.jsp\">My Appointments</a></div>\n");
      out.write("            <div class=\"li\"><a href=\"patientProfile.jsp\">Profile</a></div>\n");
      out.write("            <div class=\"li\" style=\"float:right\"><a href=\"\">LOGOUT</a></div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"formBox\">\n");
      out.write("            <form action=\"searchResult.jsp\" name=\"\" method=\"POST\">\n");
      out.write("                <h1>Search Doctor</h1>\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td  width=\"130px\">Specialization</td>\n");
      out.write("                        <td><select style=\"background: rgba(255, 255, 255, 0.7)\" name=\"specialization\">\n");
      out.write("                                <option selected>All</option>\n");
      out.write("\t\t\t\t<option>General</option>\n");
      out.write("                                <option>Family Medicine</option>\n");
      out.write("\t\t\t\t<option>Emergency Medicine</option>\n");
      out.write("\t\t\t\t<option>Psychiatry</option>\n");
      out.write("\t\t\t\t<option>Surgery</option>\n");
      out.write("\t\t\t\t<option>Cardiology</option>\n");
      out.write("\t\t\t</select></td>\n");
      out.write("                    </tr>\n");
      out.write("                     <tr>\n");
      out.write("                        <td>Doctor Name</td>\n");
      out.write("                        <td><input type=\"text\" name=\"name\" placeholder=\"Ex - Saman Perera\" required=\"\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"2\"><center><input style=\"margin-top: 15px\" type=\"submit\" name=\"button\" value=\"Search\"></center></td>            \n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
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
