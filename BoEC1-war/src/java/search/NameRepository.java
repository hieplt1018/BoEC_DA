/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.util.List;
import entity.Clothes;

/**
 *
 * Iterator pattern
 */
public class NameRepository implements Container {
   public List<Clothes> clothes;

   @Override
   public Iterator getIterator(String name) {
       clothes = ItemFacade.getInstance().searchByName(name);
      return new NameIterator();
   }

   private class NameIterator implements Iterator {

      int index;

      @Override
      public boolean hasNext() {
      
         if(index < clothes.size()){
            return true;
         }
         return false;
      }

      @Override
      public Object next() {
      
         if(this.hasNext()){
            return clothes.get(index++);
         }
         return null;
      }		
   }
}
