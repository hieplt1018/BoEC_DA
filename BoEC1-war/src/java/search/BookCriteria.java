/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package search;

import entity.Book;
import entity.Clothes;
import entity.Electronics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.BookFacadeLocal;
import session.ClothesFacadeLocal;

/**
 *
 * filter pattern
 */
public class BookCriteria implements Criteria<Book> {
    BookFacadeLocal bookFacade = lookupBookFacadeLocal();

    @Override
    public List<Book> meetCriteria(String name) {
        return bookFacade.searchCondition(name);
    }

    private BookFacadeLocal lookupBookFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (BookFacadeLocal) c.lookup("java:global/BoEC1/BoEC1-ejb/BookFacade!session.BookFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
}
