/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.ShiftTime;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author asus
 */
@Local
public interface ShiftTimeFacadeLocal {

    void create(ShiftTime shiftTime);

    void edit(ShiftTime shiftTime);

    void remove(ShiftTime shiftTime);

    ShiftTime find(Object id);

    List<ShiftTime> findAll();

    List<ShiftTime> findRange(int[] range);

    int count();
    
}
