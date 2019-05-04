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
@Table(name = "ShiftTime")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShiftTime.findAll", query = "SELECT s FROM ShiftTime s"),
    @NamedQuery(name = "ShiftTime.findById", query = "SELECT s FROM ShiftTime s WHERE s.id = :id"),
    @NamedQuery(name = "ShiftTime.findByDay", query = "SELECT s FROM ShiftTime s WHERE s.day = :day"),
    @NamedQuery(name = "ShiftTime.findByStarTime", query = "SELECT s FROM ShiftTime s WHERE s.starTime = :starTime"),
    @NamedQuery(name = "ShiftTime.findByFinishTime", query = "SELECT s FROM ShiftTime s WHERE s.finishTime = :finishTime")})
public class ShiftTime implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Day")
    @Temporal(TemporalType.DATE)
    private Date day;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StarTime")
    @Temporal(TemporalType.TIME)
    private Date starTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FinishTime")
    @Temporal(TemporalType.TIME)
    private Date finishTime;

    public ShiftTime() {
    }

    public ShiftTime(Integer id) {
        this.id = id;
    }

    public ShiftTime(Integer id, Date day, Date starTime, Date finishTime) {
        this.id = id;
        this.day = day;
        this.starTime = starTime;
        this.finishTime = finishTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Date getStarTime() {
        return starTime;
    }

    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
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
        if (!(object instanceof ShiftTime)) {
            return false;
        }
        ShiftTime other = (ShiftTime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ShiftTime[ id=" + id + " ]";
    }
    
}
