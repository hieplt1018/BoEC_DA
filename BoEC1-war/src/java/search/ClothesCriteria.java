/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package search;

import dao.ClothesDAO;
import dao.ClothesDaoImpl;
import entity.Clothes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 *  filter pattern
 */
public class ClothesCriteria implements Criteria<Clothes>{

    ClothesDAO clothesDAO = new ClothesDaoImpl();
    
    @Override
    public List<Clothes> meetCriteria(String name) {
        return clothesDAO.findName(name);
    }
    
}
