package com.maggioni.components;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class LibrarySessionBean {

    private static final Logger log = Logger.getLogger("root.librarySessionBean");
    private List<String> bookShelf;
    
    @Resource
    SessionContext sessionContext;

    public LibrarySessionBean() {
        bookShelf = new ArrayList<>();
    }
    
    @PostConstruct
    public void initBean() {
        log.info("-->> initBean() called");
        log.info("SessionBean : " + this.toString());
        log.info("SessionContext : "+ sessionContext.toString());
    }
    
    @PreDestroy
    public void remove() {
        log.info("-->> remove() called");
        
    }
    public synchronized void addBook(String bookname) {
        bookShelf.add(bookname);
    }

    public List getBooks() {
        //log.info("-->> getbooks ->> bookSheld size : " + bookShelf.size());
        return bookShelf;
    }
    
}
