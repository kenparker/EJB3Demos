package com.angelo.web.SLSB.Demo;

import com.angelo.beans.SLSBLocalView;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;

public abstract class FormatOutputWithBeansIdentity extends HttpServlet {
    
    protected void formatOutput(final PrintWriter out, SLSBLocalView beanA, SLSBLocalView beanB) throws IllegalStateException {
        out.println("<br>" + beanA.getWelcome("Angelo") + "<br>");
        out.println("<br>beanA and beanB are equal : " + checkIfEqual(beanA, beanB) + "<br>");
        out.println("<br>beanA and beanA are equal : " + checkIfEqual(beanA, beanA) + "<br>");
        out.println("<br>beanA.toString()                                                   : " + beanA.toString());
        out.println("<br>beanA.getSessionContext().getBusinessObject(SLSBLocalView.class)   : " + beanA.getSessionContext().getBusinessObject(SLSBLocalView.class));
        out.println("<br>beanB.toString()                                                   : " + beanB.toString() + "<br>");
        out.println("<br>servlet : " + this.toString() + "<br>");
    }
    
    
    private Boolean checkIfEqual(SLSBLocalView beanA, SLSBLocalView beanB) {
        // The equals method always returns true when used to compare references to the same business interface type of the same stateless session bean.
        return beanA.equals(beanB);
    }
}
