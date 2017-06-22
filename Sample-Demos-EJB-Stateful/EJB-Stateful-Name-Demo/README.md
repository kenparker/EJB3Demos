Stateful Bean injected in a Servlet
===================================

The core demo here is the @Injection annotation.   

    @WebServlet(name = "NamesServlet", urlPatterns = "/NamesServlet")
    public class NamesServlet extends HttpServlet {

        @Inject
        private NamesBean names;
       
    }

also interesting the @PostConstruct method:   

    @Stateful
    @LocalBean
    public class NamesBean {

        private List<String> names;

        @PostConstruct
        private void initialize() {
            names = new ArrayList<>();
        }

    }
