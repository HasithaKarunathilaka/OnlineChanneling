package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class updateShedule_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/header.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/button.css\"> \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"h1\">E-Channeling System</div>\n");
      out.write("        <div class=\"ul\">\n");
      out.write("            <div class=\"li\" style=\"background-color: #18514a\"><a href=\"\">Home</a></div>\n");
      out.write("            <div class=\"li\"><a href=\"\">Profile</a></div>\n");
      out.write("            <div class=\"li\" style=\"float:right\"><a href=\"\">LOGOUT</a></div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"formBox\">\n");
      out.write("            <form action=\"scheduleCntrl.jsp\" name=\"updateScheduleForm\" method=\"POST\">\n");
      out.write("                <h1>Make Schedule</h1>\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td width=\"150px\">Date</td>\n");
      out.write("                        <td><input type=\"date\" name=\"date\" value=\"");
      out.print( request.getParameter("date"));
      out.write("\" readonly=\"true\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Time</td>\n");
      out.write("                        <td><input type=\"time\" name=\"time\" value=\"");
      out.print( request.getParameter("time"));
      out.write("\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Scheduled Patients</td>\n");
      out.write("                        <td><input type=\"number\" name=\"scheduledPatients\" value=\"");
      out.print( request.getParameter("scheduledPatients"));
      out.write("\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Appointed Patients</td>\n");
      out.write("                        <td><input type=\"number\" name=\"appointedPatients\" value=\"");
      out.print( request.getParameter("appointedPatients"));
      out.write("\" readonly=\"true\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <div class=\"btnUpdate\">\n");
      out.write("                            <input type=\"submit\" name=\"button\" value=\"Update\">\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <form action=\"scheduleCntrl.jsp\" name=\"deleteScheduleForm\" method=\"POST\">\n");
      out.write("                                <input type=\"hidden\"  name=\"date\" value=\"");
      out.print( request.getParameter("date"));
      out.write("\">\n");
      out.write("                                <input type=\"submit\" style=\"float:right\" name=\"button\" value=\"Delete\">\n");
      out.write("                            </form>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                    \n");
      out.write("                          \n");
      out.write("                    \n");
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
