package com.maggioni.statefulbean.account.demo;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful(name = "AccountBean")
@Remote(Account.class)
public class AccountBean implements Account{

    float balance = 0;
    
    @Override
    public float deposit(float amount) {
        balance += amount;
        return balance;
    }

    @Override
    public float withdraw(float amount) {
        balance -= amount;
        return balance;
    }

    @Remove
    @Override
    public void remove() {
        balance = 0;
    }
    
}
