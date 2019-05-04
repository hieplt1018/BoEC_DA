/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.CardPaymentMethod;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author asus
 */
@Local
public interface CardPaymentMethodFacadeLocal {

    void create(CardPaymentMethod cardPaymentMethod);

    void edit(CardPaymentMethod cardPaymentMethod);

    void remove(CardPaymentMethod cardPaymentMethod);

    CardPaymentMethod find(Object id);

    List<CardPaymentMethod> findAll();

    List<CardPaymentMethod> findRange(int[] range);

    int count();
    
}
