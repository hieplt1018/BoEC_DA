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
@Table(name = "Reward")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reward.findAll", query = "SELECT r FROM Reward r"),
    @NamedQuery(name = "Reward.findById", query = "SELECT r FROM Reward r WHERE r.id = :id"),
    @NamedQuery(name = "Reward.findByStaffSalaryID", query = "SELECT r FROM Reward r WHERE r.staffSalaryID = :staffSalaryID"),
    @NamedQuery(name = "Reward.findByName", query = "SELECT r FROM Reward r WHERE r.name = :name"),
    @NamedQuery(name = "Reward.findByDescription", query = "SELECT r FROM Reward r WHERE r.description = :description"),
    @NamedQuery(name = "Reward.findByBonusMoney", query = "SELECT r FROM Reward r WHERE r.bonusMoney = :bonusMoney"),
    @NamedQuery(name = "Reward.findByDay", query = "SELECT r FROM Reward r WHERE r.day = :day")})
public class Reward implements Serializable {
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
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BonusMoney")
    private float bonusMoney;
    @Column(name = "Day")
    @Temporal(TemporalType.DATE)
    private Date day;

    public Reward() {
    }

    public Reward(Integer id) {
        this.id = id;
    }

    public Reward(Integer id, int staffSalaryID, float bonusMoney) {
        this.id = id;
        this.staffSalaryID = staffSalaryID;
        this.bonusMoney = bonusMoney;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getBonusMoney() {
        return bonusMoney;
    }

    public void setBonusMoney(float bonusMoney) {
        this.bonusMoney = bonusMoney;
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
        if (!(object instanceof Reward)) {
            return false;
        }
        Reward other = (Reward) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reward[ id=" + id + " ]";
    }
    
}
