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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "Bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b"),
    @NamedQuery(name = "Bill.findById", query = "SELECT b FROM Bill b WHERE b.id = :id"),
    @NamedQuery(name = "Bill.findByStaffID", query = "SELECT b FROM Bill b WHERE b.staffID = :staffID"),
    @NamedQuery(name = "Bill.findByCustomerID", query = "SELECT b FROM Bill b WHERE b.customerID = :customerID"),
    @NamedQuery(name = "Bill.findByBillStatus", query = "SELECT b FROM Bill b WHERE b.billStatus = :billStatus"),
    @NamedQuery(name = "Bill.findByOrdersID", query = "SELECT b FROM Bill b WHERE b.ordersID = :ordersID"),
    @NamedQuery(name = "Bill.findByCreateDate", query = "SELECT b FROM Bill b WHERE b.createDate = :createDate"),
    @NamedQuery(name = "Bill.findByCost", query = "SELECT b FROM Bill b WHERE b.cost = :cost"),
    @NamedQuery(name = "Bill.findByPaymentMethod", query = "SELECT b FROM Bill b WHERE b.paymentMethod = :paymentMethod")})
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StaffID")
    private int staffID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CustomerID")
    private int customerID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BillStatus")
    private String billStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrdersID")
    private long ordersID;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cost")
    private float cost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PaymentMethod")
    private String paymentMethod;

    public Bill() {
    }

    public Bill(Integer id) {
        this.id = id;
    }

    public Bill(Integer id, int staffID, int customerID, String billStatus, long ordersID, float cost, String paymentMethod, Date date) {
        this.id = id;
        this.staffID = staffID;
        this.customerID = customerID;
        this.billStatus = billStatus;
        this.ordersID = ordersID;
        this.cost = cost;
        this.paymentMethod = paymentMethod;
        this.createDate = date;
    }
    
    public Bill(int customerID, String billStatus, long ordersID, float cost, String paymentMethod) {
        this.customerID = customerID;
        this.billStatus = billStatus;
        this.ordersID = ordersID;
        this.cost = cost;
        this.paymentMethod = paymentMethod;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public long getOrdersID() {
        return ordersID;
    }

    public void setOrdersID(long ordersID) {
        this.ordersID = ordersID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bill[ id=" + id + " ]";
    }
    
}
