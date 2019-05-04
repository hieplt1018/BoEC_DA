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
@Table(name = "Staff_Salary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffSalary.findAll", query = "SELECT s FROM StaffSalary s"),
    @NamedQuery(name = "StaffSalary.findById", query = "SELECT s FROM StaffSalary s WHERE s.id = :id"),
    @NamedQuery(name = "StaffSalary.findByStaffID", query = "SELECT s FROM StaffSalary s WHERE s.staffID = :staffID"),
    @NamedQuery(name = "StaffSalary.findByMonth", query = "SELECT s FROM StaffSalary s WHERE s.month = :month"),
    @NamedQuery(name = "StaffSalary.findByWorkHours", query = "SELECT s FROM StaffSalary s WHERE s.workHours = :workHours"),
    @NamedQuery(name = "StaffSalary.findByUnit", query = "SELECT s FROM StaffSalary s WHERE s.unit = :unit"),
    @NamedQuery(name = "StaffSalary.findByType", query = "SELECT s FROM StaffSalary s WHERE s.type = :type")})
public class StaffSalary implements Serializable {
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
    @Column(name = "Month")
    private int month;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WorkHours")
    private float workHours;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Unit")
    private float unit;
    @Size(max = 255)
    @Column(name = "Type")
    private String type;

    public StaffSalary() {
    }

    public StaffSalary(Integer id) {
        this.id = id;
    }

    public StaffSalary(Integer id, int staffID, int month, float workHours, float unit) {
        this.id = id;
        this.staffID = staffID;
        this.month = month;
        this.workHours = workHours;
        this.unit = unit;
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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public float getWorkHours() {
        return workHours;
    }

    public void setWorkHours(float workHours) {
        this.workHours = workHours;
    }

    public float getUnit() {
        return unit;
    }

    public void setUnit(float unit) {
        this.unit = unit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof StaffSalary)) {
            return false;
        }
        StaffSalary other = (StaffSalary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StaffSalary[ id=" + id + " ]";
    }
    
}
