/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.WebAccount;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author asus
 */
@Stateless
public class WebAccountFacade extends AbstractFacade<WebAccount> implements WebAccountFacadeLocal {
    @PersistenceContext(unitName = "BoEC1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WebAccountFacade() {
        super(WebAccount.class);
    }

    @Override
    public boolean checkLogin(String username, String password) {
        String jpql = "SELECT w FROM WebAccount w WHERE w.username = :username"
                + " and w.password = :password";
        Query query = em.createQuery(jpql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        //3. Truy van vao object
        try {
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
