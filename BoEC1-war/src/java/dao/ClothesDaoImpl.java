/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import connect.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.ClothesCatergory;
import entity.Clothes;

/**
 *
 * @author asus
 */
public class ClothesDaoImpl implements ClothesDAO {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb;

    public ClothesDaoImpl() {
        this.connectdb = new ConnectDB();
    }

//    @Override
//    public boolean insert(Clothes cloths) {
//    }
    @Override
    public Clothes getClothes(int id) {
        String sql = "SELECT * FROM Clothes WHERE ID = " + id;
        System.out.println(sql);
        Clothes cloth = null;
        String idText = String.valueOf(id);
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                int categoryId = rs.getInt("ClothesCatergoryID");
                String name = rs.getString("Name");
                String size = rs.getString("Size");
                float price = rs.getFloat("Price");
                String company = rs.getString("Company");
                String country = rs.getString("Country");
                String image = rs.getString("Image");
                cloth = new Clothes.ClothesBuilder().size(size).image(image)
                        .country(country).price(price).iD(idText)
                        .name(name).categoryID(categoryId).build();
                System.out.println("Get Clothes successful!");
            }
        } catch (Exception e) {
            System.out.println("get Clothes failed!");
        } finally {
            connectdb.closeConnect();
        }
        return cloth;
    }

    @Override
    public ArrayList<Clothes> getAllClothesByCategory(int CategoryId) {
        ArrayList<Clothes> list = new ArrayList<>();
        String sql = "SELECT * FROM Clothes WHERE ClothesCatergoryID= " + CategoryId;
        Clothes clothes = null;
        
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                int categoryId = rs.getInt("ClothesCatergoryID");
                String name = rs.getString("Name");
                String size = rs.getString("Size");
                float price = rs.getFloat("Price");
                String company = rs.getString("Company");
                String country = rs.getString("Country");
                String image = rs.getString("Image");
                clothes = new Clothes.ClothesBuilder().size(size).image(image)
                        .country(country).price(price).iD(ID)
                        .name(name).categoryID(categoryId).build();
                list.add(clothes);
            }
        } catch (SQLException ex) {
            System.out.println("Catch getList function");
        } finally {
//            connectdb.closeConnect();
        }
        return list;
    }

    @Override
    public Clothes update(Clothes cloths) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Clothes WHERE ID = " + id;
        System.out.println(sql);
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Delete Clothes success!");
        } catch (Exception e) {
            System.out.println("Delete Clothes is failed!");
        } finally {
            connectdb.closeConnect();
        }
    }

    @Override
    public boolean insert(Clothes cloths) {
        String sql = "INSERT INTO  Clothes (ClothesCatergoryID, Name, Size, Price, "
                + " Country, Image, ID, DiscountID) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.setInt(1, cloths.getClothesCatergoryID());
            stmt.setString(2, cloths.getName());
            stmt.setString(3, cloths.getSize());
            stmt.setFloat(4, cloths.getPrice());
            stmt.setString(5, cloths.getCountry());
            stmt.setString(6, cloths.getImage());
            stmt.setString(7, cloths.getId());
            stmt.setInt(8, 0);
            stmt.executeUpdate();
            System.out.println("Cloth inserted!");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Loi insert Clothes");
        } finally {
//            connectdb.closeConnect();
        }
        return false;
    }

    @Override
    public int getNumberClothesByCategory(int CategoryId) {
        String sql = "select count(*) FROM Clothes WHERE ClothesCatergoryID=" + CategoryId;
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                int soluong = rs.getInt("count(*)");
                return soluong;
            }
        } catch (SQLException ex) {
            System.out.println("Catch getNumberClothesByCategory function failed!");
        } finally {
//            connectdb.closeConnect();
        }
        return 0;
    }

    @Override
    public Clothes getClothesDetails(String clothid) {
        String sql = "SELECT * FROM Clothes WHERE ID = '" + clothid +"'";
        Clothes clothes = new Clothes.ClothesBuilder().build();
        System.out.println(sql);
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                clothes.setId(rs.getString("ID"));
                clothes.setClothesCatergoryID(rs.getInt("ClothesCatergoryID"));
                clothes.setName(rs.getString("Name"));
                clothes.setSize(rs.getString("Size"));
                clothes.setPrice(rs.getFloat("Price"));
                clothes.setCompany(rs.getString("Company"));
                clothes.setCountry(rs.getString("Country"));
                clothes.setImage(rs.getString("Image"));
                System.out.println("Get ClothesDetails successful!");
            }
        } catch (Exception e) {
            System.out.println("get ClothesDetails failed!");
        } finally {
//            connectdb.closeConnect();
        }
        return clothes;
    }

}
