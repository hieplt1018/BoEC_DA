/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import entity.Book;
import entity.Clothes;
import entity.Electronics;
import java.util.List;

/**
 *
 * Iterator pattern
 */
public class ItemRepository implements Container {

    public List<Object> list;
    public String type;
    public String name;

    public ItemRepository(String typeItem, String name) {
        this.type = typeItem.toUpperCase();
        this.name = name.toLowerCase();
        init();

    }

    public void init() {
        list = (List<Object>) ItemFacade.getInstance().searchByName(this.type, this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Iterator getIterator() {
        return new ItemIterator();
    }

    private class ItemIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if (index < list.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return list.get(index++);
            }
            return null;
        }
    }
}
