/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Reward;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author asus
 */
@Local
public interface RewardFacadeLocal {

    void create(Reward reward);

    void edit(Reward reward);

    void remove(Reward reward);

    Reward find(Object id);

    List<Reward> findAll();

    List<Reward> findRange(int[] range);

    int count();
    
}
