/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package search;

import entity.Electronics;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.ElectronicsFacadeLocal;

/**
 *
 * filter pattern
 */
public class ElectronicsCriteria implements Criteria<Electronics>{
    ElectronicsFacadeLocal electronicsFacade = lookupElectronicsFacadeLocal();

    @Override
    public List<Electronics> meetCriteria(String name) {
        return electronicsFacade.findName(name);
    }

    private ElectronicsFacadeLocal lookupElectronicsFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (ElectronicsFacadeLocal) c.lookup("java:global/BoEC1/BoEC1-ejb/ElectronicsFacade!session.ElectronicsFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
