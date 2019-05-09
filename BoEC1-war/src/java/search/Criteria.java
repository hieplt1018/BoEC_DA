/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package search;

import java.util.List;

/**
 *
 * @author asus
 */

/*
    su dung filter pattern 
*/

public interface Criteria<T> {
    public List<T> meetCriteria(String name);
}
