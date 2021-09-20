package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import repository.AppointmentRepository;
import repository.ScheduleRepository;
import java.sql.ResultSet;

public final class doctorHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    String userName = null;
    if(session != null){
        userName = String.valueOf(session.getAttribute("userName"));
    }else{
        response.sendRedirect("index.jsp");
    }

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/header.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/button.css\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"h1\">E-Channeling System</div>\n");
      out.write("        <div class=\"ul\">\n");
      out.write("            <div class=\"li\" style=\"background-color: #18514a\"><a href=\"doctorHome.jsp\">Home</a></div>\n");
      out.write("            <div class=\"li\"><a href=\"doctorProfile.jsp\">Profile</a></div>\n");
      out.write("            <div class=\"li\" style=\"float:right\"><a href=\"logout.jsp\">LOGOUT</a></div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <!--<center>-->\n");
      out.write("        <div class=\"tableBox\">\n");
      out.write("            <div class=\"add\">\n");
      out.write("                <input style=\"width: 170px\" type=\"button\" value=\"Add Shedule\" onclick=\"window.location.href='makeSchedule.jsp';\">\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <h1 style=\"text-align: center\">Schedule Details</h1>\n");
      out.write("            <table  id=\"scheduleDetailRow\">\n");
      out.write("                <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>#</th>\n");
      out.write("                    <th>Schedule Date</th>\n");
      out.write("                    <th>Schedule Time</th>\n");
      out.write("                    <th>Schedule Patients</th>\n");
      out.write("                    <th>Active Patients</th>\n");
      out.write("                    <th>Action</th>\n");
      out.write("                </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        ResultSet rs = ScheduleRepository.getScheduleDetails(userName);
                        int rowNo = 1;
                        while(rs.next()){
                    
      out.write("  \n");
      out.write("                <form action=\"updateSchedule.jsp\">\n");
      out.write("                     ");

                        int activePatients = 0;
                        ResultSet rs2 = AppointmentRepository.getAppointmentCount(rs.getString("userName"), rs.getString("channelingDate"));
                        while(rs2.next()){
                            activePatients = rs2.getInt("activePatients");
                        }
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            ");
      out.print( rowNo);
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td style=\"width: 120px\">\n");
      out.write("                            <input name=\"date\" type=\"text\" readonly=\"true\" value=\"");
      out.print( rs.getString("channelingDate"));
      out.write("\" style=\"border: 0; background-color: transparent; width: 100%\">\n");
      out.write("                        </td>\n");
      out.write("                        <td style=\"width: 120px\">\n");
      out.write("                            <input name=\"time\" type=\"text\" readonly=\"true\" value=\"");
      out.print( rs.getString("channelingTime"));
      out.write("\" style=\"border: 0; background-color: transparent; width: 100%\">\n");
      out.write("                        </td>\n");
      out.write("                        <td style=\"width: 140px\">\n");
      out.write("                            <input name=\"scheduledPatients\" type=\"text\" readonly=\"true\" value=\"");
      out.print( rs.getString("noOfPatients"));
      out.write("\" style=\"border: 0; background-color: transparent; width: 100%\">\n");
      out.write("                        </td>\n");
      out.write("                        <td style=\"width: 150px\">\n");
      out.write("                            <input name=\"appointedPatients\" type=\"text\" readonly=\"true\" value=\"");
      out.print( activePatients);
      out.write("\" style=\"border: 0; background-color: transparent; width: 100%\">\n");
      out.write("                        </td>\n");
      out.write("                        <td style=\"width: auto\">\n");
      out.write("                            <div class=\"btnTable\">\n");
      out.write("                                <input type=\"submit\" name=\"edit\" value=\"Edit\">\n");
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
      out.write("    <!--</center>-->\n");
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
