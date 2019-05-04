/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.ElectronicCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author asus
 */
@Local
public interface ElectronicCategoryFacadeLocal {

    void create(ElectronicCategory electronicCategory);

    void edit(ElectronicCategory electronicCategory);

    void remove(ElectronicCategory electronicCategory);

    ElectronicCategory find(Object id);

    List<ElectronicCategory> findAll();

    List<ElectronicCategory> findRange(int[] range);

    int count();
    
}
