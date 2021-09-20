package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import repository.UserRepository;
import java.sql.ResultSet;

public final class changePassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String userName = null;
    if(session != null){
        userName = String.valueOf(session.getAttribute("userName"));
    }else{
        response.sendRedirect("index.jsp");
    }
    
    ResultSet result = UserRepository.getUserDetails(userName);
    String spassword = null;
  
        if(result.next()){
            spassword = result.getString("password");
        }

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/header.css\">\n");
      out.write("       <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/button.css\">\n");
      out.write("       \n");
      out.write("       <script language=\"javascript\">\n");
      out.write("            \n");
      out.write("            function datavalid(){\n");
      out.write("          \n");
      out.write("                if(document.changePasswordForm.password.value!==document.changePasswordForm.confirmPassword.value) {\n");
      out.write("                    alert(\"Password and Confirmation does not match\");\n");
      out.write("                    return false;\n");
      out.write("                }else if(document.changePasswordForm.password.value!==spassword){\n");
      out.write("                    alert(\"Invalid Current Password\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    return confirm;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"h1\">E-Channeling System</div>\n");
      out.write("        <div class=\"ul\">\n");
      out.write("            <div class=\"li\"><a href=\"doctorHome.jsp\">Home</a></div>\n");
      out.write("            <div class=\"li\" style=\"background-color: #18514a\"><a href=\"doctorProfile.jsp\">Profile</a></div>\n");
      out.write("            <div class=\"li\" style=\"float:right\"><a href=\"logout.jsp\">LOGOUT</a></div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"formBox\">\n");
      out.write("            <form action=\"doctorCntrl.jsp\" onsubmit=\"return datavalid()\" name=\"changePasswordForm\" method=\"POST\">\n");
      out.write("                <h1>Change Password</h1>\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Current Password</td>\n");
      out.write("                        <td><input type=\"text\" name=\"currentPassword\" placeholder=\"Current Password\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>New Password</td>\n");
      out.write("                        <td><input type=\"text\" name=\"newPassword\" placeholder=\"New Password\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Confirm Password</td>\n");
      out.write("                        <td><input type=\"text\" name=\"confirmPassword\" placeholder=\"Re-enter new password\" required></td>\n");
      out.write("                    </tr>                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td><input style=\"margin-top: 15px;width: 180px\" type=\"submit\" name=\"button\" value=\"Change Password\"></td>\n");
      out.write("                        <td>\n");
      out.write("                                <input  style=\"float:right; width: 100px; margin-top: 10px\" type=\"button\" name=\"changePassword\" value=\"Back\" onclick=\"window.location.href = 'doctorProfile.jsp'\">\n");
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
