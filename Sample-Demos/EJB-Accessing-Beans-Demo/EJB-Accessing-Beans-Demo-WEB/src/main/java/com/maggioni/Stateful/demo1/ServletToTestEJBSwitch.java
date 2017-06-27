package com.maggioni.Stateful.demo1;

import com.maggioni.stateful.ejb.demo1.EJBSwitch;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletToTestEJBSwitch", urlPatterns = {"/ServletToTestEJBSwitch"})
public class ServletToTestEJBSwitch extends HttpServlet {

    @EJB
    EJBSwitch switchString;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String parameterSwitch = request.getParameter("Switch");
        if (parameterSwitch.equalsIgnoreCase("a")) {
            switchString.switch1();
        }
        if (parameterSwitch.equalsIgnoreCase("b")) {
            switchString.switch2();
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletToTestEJBSwitch</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletToTestEJBSwitch at " + request.getContextPath() + "</h1>");
            out.println("<br>" + switchString.getSwitch());
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
