package com.maggioni;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
public class BasicEJB {

    private static final Logger log = Logger.getLogger("root.BasicEBJ");

    public void sayHello() {
        log.info("-->> say Hello");
    }
}
