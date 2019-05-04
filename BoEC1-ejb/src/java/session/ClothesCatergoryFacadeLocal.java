/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.ClothesCatergory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author asus
 */
@Local
public interface ClothesCatergoryFacadeLocal {

    void create(ClothesCatergory clothesCatergory);

    void edit(ClothesCatergory clothesCatergory);

    void remove(ClothesCatergory clothesCatergory);

    ClothesCatergory find(Object id);

    List<ClothesCatergory> findAll();

    List<ClothesCatergory> findRange(int[] range);

    int count();
    
}
