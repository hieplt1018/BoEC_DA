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
@Table(name = "Mistake")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mistake.findAll", query = "SELECT m FROM Mistake m"),
    @NamedQuery(name = "Mistake.findById", query = "SELECT m FROM Mistake m WHERE m.id = :id"),
    @NamedQuery(name = "Mistake.findByStaffSalaryID", query = "SELECT m FROM Mistake m WHERE m.staffSalaryID = :staffSalaryID"),
    @NamedQuery(name = "Mistake.findByName", query = "SELECT m FROM Mistake m WHERE m.name = :name"),
    @NamedQuery(name = "Mistake.findByReason", query = "SELECT m FROM Mistake m WHERE m.reason = :reason"),
    @NamedQuery(name = "Mistake.findByPenaltyMoney", query = "SELECT m FROM Mistake m WHERE m.penaltyMoney = :penaltyMoney"),
    @NamedQuery(name = "Mistake.findByDay", query = "SELECT m FROM Mistake m WHERE m.day = :day")})
public class Mistake implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Staff_SalaryID")
    private int staffSalaryID;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "Reason")
    private String reason;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PenaltyMoney")
    private float penaltyMoney;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Day")
    @Temporal(TemporalType.DATE)
    private Date day;

    public Mistake() {
    }

    public Mistake(Integer id) {
        this.id = id;
    }

    public Mistake(Integer id, int staffSalaryID, float penaltyMoney, Date day) {
        this.id = id;
        this.staffSalaryID = staffSalaryID;
        this.penaltyMoney = penaltyMoney;
        this.day = day;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStaffSalaryID() {
        return staffSalaryID;
    }

    public void setStaffSalaryID(int staffSalaryID) {
        this.staffSalaryID = staffSalaryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public float getPenaltyMoney() {
        return penaltyMoney;
    }

    public void setPenaltyMoney(float penaltyMoney) {
        this.penaltyMoney = penaltyMoney;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
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
        if (!(object instanceof Mistake)) {
            return false;
        }
        Mistake other = (Mistake) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mistake[ id=" + id + " ]";
    }
    
}
