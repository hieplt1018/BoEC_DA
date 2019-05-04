/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.BookCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author asus
 */
@Local
public interface BookCategoryFacadeLocal {

    void create(BookCategory bookCategory);

    void edit(BookCategory bookCategory);

    void remove(BookCategory bookCategory);

    BookCategory find(Object id);

    List<BookCategory> findAll();

    List<BookCategory> findRange(int[] range);

    int count();
    
}
