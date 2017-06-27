package com.maggioni.Local_LocalBean_Remote_Annotations.Demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletToTestEJBDemo1", urlPatterns = {"/ServletToTestEJBDemo1"})
public class ServletToTestEJBDemo1 extends HttpServlet {

    @EJB
    LocalA local;
    
    @EJB
    RemoteA remoteA;
    
    @EJB
    EJBWithAnnotationsDemo1 localBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletToTestLocalAnnotation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet at " + request.getContextPath() + "</h1>");
            
            out.println("<br>" + local.localA());
            out.println("<br>" + remoteA.remoteA());
            out.println("<br>" + localBean.remoteA());
            out.println("<br>" + localBean.localA());
            
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
