
package com.maggioni.EJB_and_Servlet_splitted.web.demo;

import com.maggioni.EJB_and_Servlet_splitted.ejb.demo.BBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BServlet", urlPatterns = {"/BServlet"})
public class BServlet extends HttpServlet {

    @Inject
    BBean bBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BServlet at " + request.getContextPath() + "</h1>");
            
            bBean.setString("Hello");
            out.print("<br>" +  bBean.getString());
            bBean.setString("Hello there");
            out.print("<br>" +  bBean.getString());
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    
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

}
