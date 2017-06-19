Accessing Stateful Bean from a Servlet using JNDI
=================================================

The main goal of the demo is to demonstrate how to access a Stateful bean in a client using JNDI.  

Core statements in the demo are following:  
InitialContext ic = new InitialContext();  
accountBean = (Account) ic.lookup("java:global/state/AccountBean!com.maggioni.statefulbean.account.demo.Account");  

Injecting a Stateful Bean using @Inject is not working for a Servlet.  

## AccountBean
@Stateful(name = "AccountBean")
@Remote(Account.class)
public class AccountBean implements Account{

    ...

    @Remove
    @Override
    public void remove() {
        balance = 0;
    }
    
}



## getAccountBean from TestAccountBeanServlet
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
