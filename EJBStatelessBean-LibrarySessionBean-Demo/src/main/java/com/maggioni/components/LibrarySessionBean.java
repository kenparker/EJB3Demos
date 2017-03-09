package com.maggioni.components;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class LibrarySessionBean {

    List<String> bookShelf;

    public LibrarySessionBean() {
        bookShelf = new ArrayList<>();
    }
    
    
    public void addBook(String bookname) {
        bookShelf.add(bookname);
    }

    public List getBooks() {
        return bookShelf;
    }
    
}
