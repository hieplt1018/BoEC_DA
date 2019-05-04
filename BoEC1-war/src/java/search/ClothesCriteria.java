/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package search;

import entity.Book;
import entity.Clothes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.ClothesFacadeLocal;

/**
 *
 *  filter pattern
 */
public class ClothesCriteria implements Criteria<Clothes>{
    ClothesFacadeLocal clothesFacade = lookupClothesFacadeLocal();

    private ClothesFacadeLocal lookupClothesFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (ClothesFacadeLocal) c.lookup("java:global/BoEC1/BoEC1-ejb/ClothesFacade!session.ClothesFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Override
    public List<Clothes> meetCriteria(String name) {
        return clothesFacade.findName(name);
    }
    
}
