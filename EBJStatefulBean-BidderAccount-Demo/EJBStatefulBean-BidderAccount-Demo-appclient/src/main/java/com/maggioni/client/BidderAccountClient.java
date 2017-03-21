package com.maggioni.client;

import com.maggioni.DefaultBidderAccountCreator;
import java.util.logging.Logger;
import javax.inject.Inject;

public class BidderAccountClient {

    private static Logger  log = Logger.getLogger("root.BidderAccountClient");
    @Inject
    DefaultBidderAccountCreator bidderAccount;
    
    public static void main(String[] args) {
        BidderAccountClient bidderAccountClient = new BidderAccountClient();
        bidderAccountClient.doSomething();
    }
    
    public void doSomething() {
        log.info("-->> doSomething");
        bidderAccount.addBillingInfo(null);
    }
}
