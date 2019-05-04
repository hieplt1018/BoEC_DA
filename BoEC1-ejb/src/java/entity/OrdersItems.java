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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Orders_Items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdersItems.findAll", query = "SELECT o FROM OrdersItems o"),
    @NamedQuery(name = "OrdersItems.findById", query = "SELECT o FROM OrdersItems o WHERE o.id = :id"),
    @NamedQuery(name = "OrdersItems.findByOrderID", query = "SELECT o FROM OrdersItems o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "OrdersItems.findByItemsID", query = "SELECT o FROM OrdersItems o WHERE o.itemsID = :itemsID"),
    @NamedQuery(name = "OrdersItems.findByNumberOfItems", query = "SELECT o FROM OrdersItems o WHERE o.numberOfItems = :numberOfItems")})
public class OrdersItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderID")
    private int orderID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ItemsID")
    private String itemsID;
    @Column(name = "NumberOfItems")
    private Integer numberOfItems;

    public OrdersItems() {
    }

    public OrdersItems(Integer id) {
        this.id = id;
    }

    public OrdersItems(Integer id, int orderID, String itemsID) {
        this.id = id;
        this.orderID = orderID;
        this.itemsID = itemsID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getItemsID() {
        return itemsID;
    }

    public void setItemsID(String itemsID) {
        this.itemsID = itemsID;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
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
        if (!(object instanceof OrdersItems)) {
            return false;
        }
        OrdersItems other = (OrdersItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrdersItems[ id=" + id + " ]";
    }
    
}
