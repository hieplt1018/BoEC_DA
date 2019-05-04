/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Electronics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author asus
 */
@Stateless
public class ElectronicsFacade extends AbstractFacade<Electronics> implements ElectronicsFacadeLocal {
    @PersistenceContext(unitName = "BoEC1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ElectronicsFacade() {
        super(Electronics.class);
    }

    @Override
    public List<Electronics> findName(String name) {
        String jpql = "SELECT e FROM Electronics e WHERE e.name = :name";
        Query query = em.createQuery(jpql);
        query.setParameter("name", name);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }


    
    
}
