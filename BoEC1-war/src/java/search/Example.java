/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package search;

/**
 *
 * @author asus
 */
public class Example {
 
    public static void main(String[] args) {
 
        CareTaker careTaker = new CareTaker();
        ItemRepository item = new ItemRepository("book", "toan");
        Originator originator = new Originator(item);
        
        System.out.println("State initial: " + originator);
         
        careTaker.saveMemento(originator.save(), "SAVE #1");
 
        item.setName("Vat Ly");
        item.setType("book");
        originator.setItem(item);
        System.out.println("State changed: " + originator);
         
        originator.undo(careTaker.getMemento("SAVE #1"));
        System.out.println("State after undo: " + originator);
 
        item.setName("ao so mi");
        item.setType("clothes");
        originator.setItem(item);
        careTaker.saveMemento(originator.save(), "SAVE #2");
        System.out.println("State changed: " + originator);
         
        item.setName("laptop dell");
        item.setType("electronics");
        originator.setItem(item);
        careTaker.saveMemento(originator.save(), "SAVE #3");
        System.out.println("State saved #3: " + originator);
        
        originator.undo(careTaker.getMemento("SAVE #2"));
        System.out.println("Retrieving at saved #2: " + originator);
    }   
}
