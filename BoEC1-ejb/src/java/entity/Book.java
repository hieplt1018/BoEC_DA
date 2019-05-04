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
@Table(name = "Book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByType", query = "SELECT b FROM Book b WHERE b.type = :type"),
    @NamedQuery(name = "Book.findByEpisode", query = "SELECT b FROM Book b WHERE b.episode = :episode"),
    @NamedQuery(name = "Book.findByQuantity", query = "SELECT b FROM Book b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "Book.findByEdition", query = "SELECT b FROM Book b WHERE b.edition = :edition"),
    @NamedQuery(name = "Book.findByPublishedYear", query = "SELECT b FROM Book b WHERE b.publishedYear = :publishedYear"),
    @NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id"),
    @NamedQuery(name = "Book.findByName", query = "SELECT b FROM Book b WHERE b.name = :name"),
    @NamedQuery(name = "Book.findByDes", query = "SELECT b FROM Book b WHERE b.des = :des"),
    @NamedQuery(name = "Book.findByPrice", query = "SELECT b FROM Book b WHERE b.price = :price"),
    @NamedQuery(name = "Book.findByDiscountID", query = "SELECT b FROM Book b WHERE b.discountID = :discountID"),
    @NamedQuery(name = "Book.findByImage", query = "SELECT b FROM Book b WHERE b.image = :image"),
    @NamedQuery(name = "Book.findByBookCategoryID", query = "SELECT b FROM Book b WHERE b.bookCategoryID = :bookCategoryID"),
    @NamedQuery(name = "Book.findByPublisherID", query = "SELECT b FROM Book b WHERE b.publisherID = :publisherID"),
    @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author")})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Type")
    private String type;
    @Column(name = "Episode")
    private Integer episode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Edition")
    private int edition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PublishedYear")
    private int publishedYear;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "BookCategoryID")
    private int bookCategoryID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PublisherID")
    private int publisherID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Author")
    private String author;

    public Book() {
    }

    public Book(String id) {
        this.id = id;
    }

    public Book(String id, String type, int quantity, int edition, int publishedYear, float price, int discountID, int bookCategoryID, int publisherID, String author) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.edition = edition;
        this.publishedYear = publishedYear;
        this.price = price;
        this.discountID = discountID;
        this.bookCategoryID = bookCategoryID;
        this.publisherID = publisherID;
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
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

    public int getBookCategoryID() {
        return bookCategoryID;
    }

    public void setBookCategoryID(int bookCategoryID) {
        this.bookCategoryID = bookCategoryID;
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Book[ id=" + id + " ]";
    }
    
}
