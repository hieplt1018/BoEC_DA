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
@Table(name = "Staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findById", query = "SELECT s FROM Staff s WHERE s.id = :id"),
    @NamedQuery(name = "Staff.findByPersonID", query = "SELECT s FROM Staff s WHERE s.personID = :personID"),
    @NamedQuery(name = "Staff.findByPositionID", query = "SELECT s FROM Staff s WHERE s.positionID = :positionID"),
    @NamedQuery(name = "Staff.findByDepartment", query = "SELECT s FROM Staff s WHERE s.department = :department"),
    @NamedQuery(name = "Staff.findByShiftTimeID", query = "SELECT s FROM Staff s WHERE s.shiftTimeID = :shiftTimeID")})
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonID")
    private int personID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PositionID")
    private int positionID;
    @Size(max = 255)
    @Column(name = "Department")
    private String department;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ShiftTimeID")
    private int shiftTimeID;

    public Staff() {
    }

    public Staff(Integer id) {
        this.id = id;
    }

    public Staff(Integer id, int personID, int positionID, int shiftTimeID) {
        this.id = id;
        this.personID = personID;
        this.positionID = positionID;
        this.shiftTimeID = shiftTimeID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getShiftTimeID() {
        return shiftTimeID;
    }

    public void setShiftTimeID(int shiftTimeID) {
        this.shiftTimeID = shiftTimeID;
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
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Staff[ id=" + id + " ]";
    }
    
}
