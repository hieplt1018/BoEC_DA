/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.StaffSalary;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author asus
 */
@Local
public interface StaffSalaryFacadeLocal {

    void create(StaffSalary staffSalary);

    void edit(StaffSalary staffSalary);

    void remove(StaffSalary staffSalary);

    StaffSalary find(Object id);

    List<StaffSalary> findAll();

    List<StaffSalary> findRange(int[] range);

    int count();
    
}
