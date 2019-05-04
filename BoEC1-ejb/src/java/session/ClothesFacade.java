/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Book;
import entity.Clothes;
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
public class ClothesFacade extends AbstractFacade<Clothes> implements ClothesFacadeLocal {
    @PersistenceContext(unitName = "BoEC1-ejbPU")
    private EntityManager em;

    private List clothes;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClothesFacade() {
        super(Clothes.class);
    }
    
    @Override
    public List<Clothes> findName(String name) {
        String jpql = "SELECT c FROM Clothes c WHERE c.name = :name";
        Query query = em.createQuery(jpql);
        query.setParameter("name", name);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Clothes> getAllClothesByCategory(int category) {
        return em.createNamedQuery("Clothes.findByClothesCatergoryID")
                .setParameter("clothesCatergoryID", category).getResultList();
    }
}
