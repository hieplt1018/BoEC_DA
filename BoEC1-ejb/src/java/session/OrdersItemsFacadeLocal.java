/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.OrdersItems;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author asus
 */
@Local
public interface OrdersItemsFacadeLocal {

    void create(OrdersItems ordersItems);

    void edit(OrdersItems ordersItems);

    void remove(OrdersItems ordersItems);

    OrdersItems find(Object id);

    List<OrdersItems> findAll();

    List<OrdersItems> findRange(int[] range);

    int count();
    
}
