Accessing a Stateful EJB in a JSF Page packaged in a ear file
=============================================================

core statemets in the demo are following:


    @Named(value = "info")  
    @SessionScoped   
    public class Info implements Serializable{

        @EJB
        InfoCreator infoCreator;

    }

    @Stateful 
    public class InfoCreator{   

        @Remove
        public String createAccount() {
            this.name = firstName+lastName;
            return name;
        }
    }
