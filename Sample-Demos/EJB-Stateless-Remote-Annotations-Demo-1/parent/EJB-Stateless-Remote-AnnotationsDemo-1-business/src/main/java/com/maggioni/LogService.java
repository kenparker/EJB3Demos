package com.maggioni;

import com.example.myproject.common.ToStringBuilder;
import java.util.logging.Logger;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name = "Service")
@Remote(LogServiceRemote.class)
public class LogService implements LogServiceRemote{

    Logger logger = Logger.getLogger("Root.Service");
    
    @Override
    public void logTestString() {
        final String actual = new ToStringBuilder(this)
                .add("key1", "value")
                .add("key2", Boolean.FALSE)
                .add("key3", 442)
                .add("key4", false)
                .build();
        logger.info(actual);
        
    }
}
