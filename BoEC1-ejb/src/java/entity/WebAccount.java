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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "WebAccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebAccount.findAll", query = "SELECT w FROM WebAccount w"),
    @NamedQuery(name = "WebAccount.findById", query = "SELECT w FROM WebAccount w WHERE w.id = :id"),
    @NamedQuery(name = "WebAccount.findByUsername", query = "SELECT w FROM WebAccount w WHERE w.username = :username"),
    @NamedQuery(name = "WebAccount.findByPassword", query = "SELECT w FROM WebAccount w WHERE w.password = :password"),
    @NamedQuery(name = "WebAccount.findByCreateDate", query = "SELECT w FROM WebAccount w WHERE w.createDate = :createDate")})
public class WebAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Username")
    private String username;
    @Size(max = 255)
    @Column(name = "Password")
    private String password;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    private WebAccount() {
    }

    public WebAccount(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public static class WebAccountBuilder {
        private String username;
        private String password;
        private Date createDate;
        private int ID;

        public WebAccountBuilder() {
        }
        
        public WebAccountBuilder username(String username) {
            this.username = username;
            return this;
        }
        
        public WebAccountBuilder password(String password) {
            this.password = password;
            return this;
        }
        
        public WebAccountBuilder createDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }
        
        public WebAccountBuilder iD(int ID) {
            this.ID = ID;
            return this;
        }
        
        public WebAccount build() {
            WebAccount account = new WebAccount();
            account.id = this.ID;
            account.createDate = this.createDate;
            account.username = this.username;
            account.password = this.password;
            
            return account;
        }
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
        if (!(object instanceof WebAccount)) {
            return false;
        }
        WebAccount other = (WebAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WebAccount[ id=" + id + " ]";
    }
    
}
