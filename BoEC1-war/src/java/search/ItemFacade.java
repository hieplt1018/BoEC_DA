/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import entity.Clothes;
import java.util.List;

/**
 *
 * facade pattern
 */
public class ItemFacade {

    private static final ItemFacade INSTANCE = new ItemFacade();

    private ClothesCriteria clothesCri;
    
    private ItemFacade() {
        clothesCri = new ClothesCriteria();
    }

    public static ItemFacade getInstance() {
        return INSTANCE;
    }
    
    public List<Clothes> searchByName(String name) {
        return clothesCri.meetCriteria(name);
    }
    
//    public ItemFacade(ClothesCriteria clothes) {
//        this.clothesCri = clothes;
//    }

}
