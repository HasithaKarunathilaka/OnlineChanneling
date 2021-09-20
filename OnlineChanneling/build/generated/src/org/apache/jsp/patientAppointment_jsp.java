package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import repository.AppointmentRepository;
import java.sql.ResultSet;

public final class patientAppointment_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            <div class=\"li\"><a href=\"patientHome.jsp\">Home</a></div>\n");
      out.write("            <div class=\"li\" style=\"background-color: #18514a\"><a href=\"patientAppointment.jsp\">My Appointments</a></div>\n");
      out.write("            <div class=\"li\"><a href=\"patientProfile.jsp\">Profile</a></div>\n");
      out.write("            <div class=\"li\" style=\"float:right\"><a href=\"\">LOGOUT</a></div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"tableBox\">\n");
      out.write("            <h1 style=\"text-align: center\">My Appointments</h1>\n");
      out.write("            <table>\n");
      out.write("                <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>#</th>\n");
      out.write("                    <th>Doctor Name</th>\n");
      out.write("                    <th>Specialization</th>\n");
      out.write("                    <th>Date</th>\n");
      out.write("                    <th>Time</th>\n");
      out.write("                    <th>Action</th>\n");
      out.write("                </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        ResultSet rs = AppointmentRepository.getAppointmentDetails(userName);
                        int rowNo = 1;
                        while(rs.next()){
                    
      out.write("  \n");
      out.write("                <form action=\"appointmentCntrl.jsp\">\n");
      out.write("                    <input name=\"userName\" type=\"hidden\" value=\"");
      out.print( rs.getString("username"));
      out.write("\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            ");
      out.print( rowNo);
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td style=\"width: 120px\">\n");
      out.write("                            <input name=\"name\" type=\"text\" value=\"");
      out.print( rs.getString("name"));
      out.write("\" readonly=\"true\" style=\"border: 0; background-color: transparent; width: 100%\">\n");
      out.write("                        </td>\n");
      out.write("                        <td style=\"width: 120px\">\n");
      out.write("                            <input name=\"specialization\" type=\"text\" readonly=\"true\" value=\"");
      out.print( rs.getString("specialization"));
      out.write("\" style=\"border: 0; background-color: transparent; width: 100%\">\n");
      out.write("                        </td>\n");
      out.write("                        <td style=\"width: 140px\">\n");
      out.write("                            <input name=\"date\" type=\"text\" readonly=\"true\" value=\"");
      out.print( rs.getString("channelingDate"));
      out.write("\" style=\"border: 0; background-color: transparent; width: 100%\">\n");
      out.write("                        </td>\n");
      out.write("                        <td style=\"width: 150px\">\n");
      out.write("                            <input name=\"time\" type=\"text\" readonly=\"true\" value=\"");
      out.print( rs.getString("channelingTime"));
      out.write("\" style=\"border: 0; background-color: transparent; width: 100%\">\n");
      out.write("                        </td>\n");
      out.write("                        <td style=\"width: auto\">\n");
      out.write("                            <div class=\"btnTable\">\n");
      out.write("                                <input type=\"submit\" name=\"button\" value=\"Delete\">\n");
      out.write("                            </div>  \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </form>\n");
      out.write("                    ");

                        rowNo++;
                        }
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
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
