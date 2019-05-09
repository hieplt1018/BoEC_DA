/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Clothes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public interface ClothesDAO {
    public boolean insert(Clothes clothes);
    public Clothes getClothes(int id);
    public ArrayList<Clothes> getAllClothesByCategory(int CategoryId);
    public Clothes update(Clothes clothes);
    public void delete(int id);
    public int getNumberClothesByCategory(int CategoryId);
    public Clothes getClothesDetails(String clothid);
    public List<Clothes> findName(String name);
}
