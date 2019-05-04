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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "ClothesCatergory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClothesCatergory.findAll", query = "SELECT c FROM ClothesCatergory c"),
    @NamedQuery(name = "ClothesCatergory.findById", query = "SELECT c FROM ClothesCatergory c WHERE c.id = :id"),
    @NamedQuery(name = "ClothesCatergory.findByName", query = "SELECT c FROM ClothesCatergory c WHERE c.name = :name")})
public class ClothesCatergory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;

    private ClothesCatergory() {
    }

    public ClothesCatergory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof ClothesCatergory)) {
            return false;
        }
        ClothesCatergory other = (ClothesCatergory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClothesCatergory[ id=" + id + " ]";
    }
    
    public static class ClothesCatergoryBuilder {
        
        private String name;
        private int id;

        public ClothesCatergoryBuilder() {
        }
        
        public ClothesCatergoryBuilder name(String username) {
            this.name = username;
            return this;
        }
        
        public ClothesCatergoryBuilder iD(int ID) {
            this.id = ID;
            return this;
        }
        
        public ClothesCatergory build() {
            ClothesCatergory catergory = new ClothesCatergory();
            catergory.id = this.id;
            catergory.name = this.name;
            
            return catergory;
        }
    }
}
