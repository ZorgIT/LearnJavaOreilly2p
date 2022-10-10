package pMyServletA;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *
 * @author  Stepan M
 * @version 2022.10.10
 * Servlet code -  RMI test
 */


public class MyServletA extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletExcetion, IOException {

        response.setContentType("text/html");
        PrinterWriter out = response.getWriter();
        String message = "If you read this text - all work correctly";
        out.println("<HTML><BODY>");
        out.println("<H1" + message + "</H1>");
        out.println("</BODY></HTML>");
        out.close();
    }
}
