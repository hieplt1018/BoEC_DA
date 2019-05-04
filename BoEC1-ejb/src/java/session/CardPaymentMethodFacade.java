/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.CardPaymentMethod;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author asus
 */
@Stateless
public class CardPaymentMethodFacade extends AbstractFacade<CardPaymentMethod> implements CardPaymentMethodFacadeLocal {
    @PersistenceContext(unitName = "BoEC1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CardPaymentMethodFacade() {
        super(CardPaymentMethod.class);
    }
    
}
