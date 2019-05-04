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
public class Memento {
    private ItemRepository item;

    public Memento() {
    }

    public Memento(ItemRepository item) {
        this.item = item;
    }

    public ItemRepository getItem() {
        return item;
    }

    public void setItem(ItemRepository item) {
        this.item = item;
    }
}
