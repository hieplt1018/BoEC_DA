/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "Clothes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clothes.findAll", query = "SELECT c FROM Clothes c"),
    @NamedQuery(name = "Clothes.findById", query = "SELECT c FROM Clothes c WHERE c.id = :id"),
    @NamedQuery(name = "Clothes.findByName", query = "SELECT c FROM Clothes c WHERE c.name = :name"),
    @NamedQuery(name = "Clothes.findByDes", query = "SELECT c FROM Clothes c WHERE c.des = :des"),
    @NamedQuery(name = "Clothes.findByPrice", query = "SELECT c FROM Clothes c WHERE c.price = :price"),
    @NamedQuery(name = "Clothes.findByDiscountID", query = "SELECT c FROM Clothes c WHERE c.discountID = :discountID"),
    @NamedQuery(name = "Clothes.findByImage", query = "SELECT c FROM Clothes c WHERE c.image = :image"),
    @NamedQuery(name = "Clothes.findByGender", query = "SELECT c FROM Clothes c WHERE c.gender = :gender"),
    @NamedQuery(name = "Clothes.findBySize", query = "SELECT c FROM Clothes c WHERE c.size = :size"),
    @NamedQuery(name = "Clothes.findByClothesCatergoryID", query = "SELECT c FROM Clothes c WHERE c.clothesCatergoryID = :clothesCatergoryID"),
    @NamedQuery(name = "Clothes.findByCompany", query = "SELECT c FROM Clothes c WHERE c.company = :company"),
    @NamedQuery(name = "Clothes.findByCountry", query = "SELECT c FROM Clothes c WHERE c.country = :country")})
public class Clothes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ID")
    private String id;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "Des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private float price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DiscountID")
    private int discountID;
    @Size(max = 255)
    @Column(name = "Image")
    private String image;
    @Size(max = 10)
    @Column(name = "Gender")
    private String gender;
    @Size(max = 255)
    @Column(name = "Size")
    private String size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ClothesCatergoryID")
    private int clothesCatergoryID;
    @Size(max = 255)
    @Column(name = "Company")
    private String company;
    @Size(max = 255)
    @Column(name = "Country")
    private String country;

    private int quantity;

    
    private Clothes() {
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getClothesCatergoryID() {
        return clothesCatergoryID;
    }

    public void setClothesCatergoryID(int clothesCatergoryID) {
        this.clothesCatergoryID = clothesCatergoryID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clothes)) {
            return false;
        }
        Clothes other = (Clothes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Clothes[ id=" + id + " ]";
    }
    
    public static class ClothesBuilder {
        
        private String name;
        private float price;
        private String image;
        private int catergoryID;
        private String id;
        private String size;
        private String country;

        public ClothesBuilder() {
        }
        
        public ClothesBuilder name(String username) {
            this.name = username;
            return this;
        }
        
        public ClothesBuilder price(float price) {
            this.price = price;
            return this;
        }
        
        public ClothesBuilder image(String image) {
            this.image = image;
            return this;
        }
        
        public ClothesBuilder country(String country) {
            this.country = country;
            return this;
        }
        
        public ClothesBuilder size(String size) {
            this.size = size;
            return this;
        }
        
        public ClothesBuilder iD(String ID) {
            this.id = ID;
            return this;
        }
        
        public ClothesBuilder categoryID(int ID) {
            this.catergoryID = ID;
            return this;
        }
        
        public Clothes build() {
            Clothes clothes = new Clothes();
            clothes.id = this.id;
            clothes.clothesCatergoryID = this.catergoryID;
            clothes.name = this.name;
            clothes.image = this.image;
            clothes.country = this.country;
            clothes.price = this.price;
            clothes.size = this.size;
            
            return clothes;
        }
    }
}
