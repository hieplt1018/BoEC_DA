/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.WebAccount;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author asus
 */
@Local
public interface WebAccountFacadeLocal {

    void create(WebAccount webAccount);

    void edit(WebAccount webAccount);

    void remove(WebAccount webAccount);

    WebAccount find(Object id);

    List<WebAccount> findAll();

    List<WebAccount> findRange(int[] range);

    int count();

    boolean checkLogin(String username, String password);
    
    WebAccount findByUsername(String username);
}
