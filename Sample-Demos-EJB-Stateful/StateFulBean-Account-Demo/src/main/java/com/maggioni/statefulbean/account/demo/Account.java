package com.maggioni.statefulbean.account.demo;

import javax.ejb.Remote;
import javax.ejb.Remove;

@Remote
public interface Account {
    
    public float deposit(float amount);
    public float withdraw(float amount);
    @Remove
    public void remove();
}
