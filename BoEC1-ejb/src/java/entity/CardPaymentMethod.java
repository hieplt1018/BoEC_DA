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
@Table(name = "CardPaymentMethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardPaymentMethod.findAll", query = "SELECT c FROM CardPaymentMethod c"),
    @NamedQuery(name = "CardPaymentMethod.findByCartPaymentType", query = "SELECT c FROM CardPaymentMethod c WHERE c.cartPaymentType = :cartPaymentType"),
    @NamedQuery(name = "CardPaymentMethod.findByCartNumber", query = "SELECT c FROM CardPaymentMethod c WHERE c.cartNumber = :cartNumber"),
    @NamedQuery(name = "CardPaymentMethod.findByExpiredDate", query = "SELECT c FROM CardPaymentMethod c WHERE c.expiredDate = :expiredDate"),
    @NamedQuery(name = "CardPaymentMethod.findByCcv", query = "SELECT c FROM CardPaymentMethod c WHERE c.ccv = :ccv"),
    @NamedQuery(name = "CardPaymentMethod.findById", query = "SELECT c FROM CardPaymentMethod c WHERE c.id = :id"),
    @NamedQuery(name = "CardPaymentMethod.findByAddressID", query = "SELECT c FROM CardPaymentMethod c WHERE c.addressID = :addressID"),
    @NamedQuery(name = "CardPaymentMethod.findByWebAccountID", query = "SELECT c FROM CardPaymentMethod c WHERE c.webAccountID = :webAccountID")})
public class CardPaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CartPaymentType")
    private String cartPaymentType;
    @Size(max = 255)
    @Column(name = "CartNumber")
    private String cartNumber;
    @Column(name = "ExpiredDate")
    @Temporal(TemporalType.DATE)
    private Date expiredDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ccv")
    private int ccv;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "AddressID")
    private Integer addressID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WebAccountID")
    private int webAccountID;

    public CardPaymentMethod() {
    }

    public CardPaymentMethod(Integer id) {
        this.id = id;
    }

    public CardPaymentMethod(Integer id, String cartPaymentType, int ccv, int webAccountID) {
        this.id = id;
        this.cartPaymentType = cartPaymentType;
        this.ccv = ccv;
        this.webAccountID = webAccountID;
    }

    public String getCartPaymentType() {
        return cartPaymentType;
    }

    public void setCartPaymentType(String cartPaymentType) {
        this.cartPaymentType = cartPaymentType;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public int getWebAccountID() {
        return webAccountID;
    }

    public void setWebAccountID(int webAccountID) {
        this.webAccountID = webAccountID;
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
        if (!(object instanceof CardPaymentMethod)) {
            return false;
        }
        CardPaymentMethod other = (CardPaymentMethod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CardPaymentMethod[ id=" + id + " ]";
    }
    
}
