/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Mistake;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author asus
 */
@Local
public interface MistakeFacadeLocal {

    void create(Mistake mistake);

    void edit(Mistake mistake);

    void remove(Mistake mistake);

    Mistake find(Object id);

    List<Mistake> findAll();

    List<Mistake> findRange(int[] range);

    int count();
    
}
