package com.angelo.web.SFSB.Demo;

import com.angelo.beans.SFSBLocalView;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletDemo3", urlPatterns = {"/ServletDemo3"})
public class ServletDemo3 extends HttpServlet {

    @EJB
    SFSBLocalView beanA;
    
    @EJB
    SFSBLocalView beanB;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletDemo1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Test Session Object Identity Using @EJB</h1>");
            
            out.println("<br>" + beanA.getCounter() + "<br>");
            out.println("<br>beanA and beanB are equal : " + checkIfEqual(beanA, beanB) + "<br>");
            out.println("<br>beanA : " + beanA.toString());
            out.println("<br>beanB : " + beanB.toString() + "<br>");
            out.println("<br>servlet : " + this.toString() + "<br>");
            
            beanA.addToCounter(1);
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    private Boolean checkIfEqual(SFSBLocalView beanA, SFSBLocalView beanB) {
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
