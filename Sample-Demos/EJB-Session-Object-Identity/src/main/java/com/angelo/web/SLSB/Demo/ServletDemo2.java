package com.angelo.web.SLSB.Demo;

import com.angelo.beans.SLSBLocalView;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletDemo2", urlPatterns = {"/ServletDemo2"})
public class ServletDemo2 extends HttpServlet {

    @Inject
    SLSBLocalView beanA;
    
    @Inject
    SLSBLocalView beanB;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletDemo2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Test Session Object Identity Using @Inject</h1>");
            
            out.println("<br>" + beanA.getWelcome("Angelo") + "<br>");
            out.println("<br>beanA and beanB are equal : " + checkIfEqual(beanA, beanB)+ "<br>");
            out.println("<br>beanA : " + beanA.toString());
            out.println("<br>beanB : " + beanB.toString() + "<br>");
            out.println("<br>servlet : " + this.toString() + "<br>");
                        
            out.println("</body>");
            out.println("</html>");
        }
    }

    private Boolean checkIfEqual(SLSBLocalView beanA, SLSBLocalView beanB) {
        // The equals method always returns true when used to compare references to the same business interface type of the same stateless session bean.
        return beanA.equals(beanB);
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
