/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "Orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id"),
    @NamedQuery(name = "Orders.findByOrdersStatus", query = "SELECT o FROM Orders o WHERE o.ordersStatus = :ordersStatus"),
    @NamedQuery(name = "Orders.findByReceiveDate", query = "SELECT o FROM Orders o WHERE o.receiveDate = :receiveDate"),
    @NamedQuery(name = "Orders.findByOrdersAprovingID", query = "SELECT o FROM Orders o WHERE o.ordersAprovingID = :ordersAprovingID")})
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrdersStatus")
    private int ordersStatus;
    @Column(name = "ReceiveDate")
    @Temporal(TemporalType.DATE)
    private Date receiveDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrdersAprovingID")
    private int ordersAprovingID;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Orders(Integer id, int ordersStatus, int ordersAprovingID) {
        this.id = id;
        this.ordersStatus = ordersStatus;
        this.ordersAprovingID = ordersAprovingID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(int ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public int getOrdersAprovingID() {
        return ordersAprovingID;
    }

    public void setOrdersAprovingID(int ordersAprovingID) {
        this.ordersAprovingID = ordersAprovingID;
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orders[ id=" + id + " ]";
    }
    
}
