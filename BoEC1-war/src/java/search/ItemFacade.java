/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package search;

import entity.Book;
import entity.Clothes;
import java.util.List;

/**
 *
 * facade pattern
 */
public class ItemFacade {
    private static final ItemFacade INSTANCE = new ItemFacade();    
    
    private BookCriteria bookCri;
    private ClothesCriteria clothesCri;
    private ElectronicsCriteria electronicsCri;

    public ItemFacade(BookCriteria book, ClothesCriteria clothes, ElectronicsCriteria electronics) {
        this.bookCri = book;
        this.clothesCri = clothes;
        this.electronicsCri = electronics;
    }
    
    public static ItemFacade getInstance() {
        return INSTANCE;
    }    

    private ItemFacade() {
    }
    
    public Object searchByName(String typeItem, String name){
        if(typeItem.equals("BOOK"))
            return bookCri.meetCriteria(name);
        else if(typeItem.equals("CLOTHES"))
            return clothesCri.meetCriteria(name);
        else if(typeItem.equals("ELECTRONICS"))
            return electronicsCri.meetCriteria(name);
        return null;
    }
    
    
}
