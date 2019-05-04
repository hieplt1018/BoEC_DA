/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.ClothesCatergory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author asus
 */
@Stateless
public class ClothesCatergoryFacade extends AbstractFacade<ClothesCatergory> implements ClothesCatergoryFacadeLocal {
    @PersistenceContext(unitName = "BoEC1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClothesCatergoryFacade() {
        super(ClothesCatergory.class);
    }
    
}
