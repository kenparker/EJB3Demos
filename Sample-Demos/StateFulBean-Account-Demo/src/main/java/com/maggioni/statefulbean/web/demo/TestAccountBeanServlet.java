package com.maggioni.statefulbean.web.demo;

import com.maggioni.statefulbean.account.demo.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TestAccountBeanServlet", urlPatterns = {"/TestAccountBeanServlet"})
public class TestAccountBeanServlet extends HttpServlet {

    static final Logger logger = Logger.getLogger("root.AccountBeanServlet");

    private static final long serialVersionUID = 1L;
    private static final String ACCOUNT_BEAN_KEY = "accountBean";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestAccountBeanServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestAccountBeanServlet at " + request.getContextPath() + "</h1>");

            Account accountBean;
            try {
                accountBean = getAccountBean(request);
                manageActions(request, accountBean, out);
            } catch (NamingException ex) {
                logger.severe("no bean found");
                out.println("no bean found");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    private void manageActions(HttpServletRequest request, Account accountBean, final PrintWriter out) {
        String parDeposit = request.getParameter("deposit");
        if (parDeposit != null && parDeposit.equalsIgnoreCase("yes")) {

            float deposit = accountBean.deposit(100);
            out.print("-->> deposit : >" + deposit + "<<br>");
        }

        String parWithdraw = request.getParameter("withdraw");
        if (parWithdraw != null && parWithdraw.equalsIgnoreCase("yes")) {

            float withdraw = accountBean.withdraw(5);
            out.print("-->> withdraw : >" + withdraw + "<<br>");
        }

        String parClose = request.getParameter("close");
        if (parClose != null && parClose.equalsIgnoreCase("yes")) {

            accountBean.remove();
            logger.info("-->> AccountBean closed");
            request.getSession().setAttribute(ACCOUNT_BEAN_KEY, null);
        }
    }

    private Account getAccountBean(HttpServletRequest request) throws NamingException {
        // Obtain the EJB from the HTTP session
        Account accountBean = (Account) request.getSession().getAttribute(ACCOUNT_BEAN_KEY);
        if (accountBean == null) {
            // EJB is not present in the HTTP session
            // so let's fetch a new one from the container
            try {
                InitialContext ic = new InitialContext();
                accountBean = (Account) ic.lookup("java:global/state/AccountBean!com.maggioni.statefulbean.account.demo.Account");

                // put EJB in HTTP session for future servlet calls
                request.getSession().setAttribute(ACCOUNT_BEAN_KEY, accountBean);

                logger.log(Level.INFO, "AccountBean : >{0}< acquired", accountBean);

            } catch (NamingException e) {
                logger.info("AccountBean NOT acquired");
                throw new NamingException();
            }
        }
        return accountBean;
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
