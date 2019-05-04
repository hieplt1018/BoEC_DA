/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package search;

/**
 *
 * pattern-memento
 */
public class Originator {
 
    private ItemRepository item;
 
    public Originator(ItemRepository item) {
        this.item = item;
    }

    public ItemRepository getItem() {
        return item;
    }

    public void setItem(ItemRepository item) {
        this.item = item;
    }
 
    public Memento save() {
        return new Memento(this.item);
    }
 
    public void undo(Memento mem) {
        this.item = mem.getItem();
    }

    @Override
    public String toString() {
        return "Originator{" + "item=" + item + '}';
    }
 
    
}
