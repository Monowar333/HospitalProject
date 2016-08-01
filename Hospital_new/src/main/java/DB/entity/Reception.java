/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Жека
 */
@Entity
@Table(name = "reception")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reception.findAll", query = "SELECT r FROM Reception r"),
    @NamedQuery(name = "Reception.findById", query = "SELECT r FROM Reception r WHERE r.id = :id"),
    @NamedQuery(name = "Reception.findByTime", query = "SELECT r FROM Reception r WHERE r.time = :time"),
    @NamedQuery(name = "Reception.findByStatus", query = "SELECT r FROM Reception r WHERE r.status = :status"),
    @NamedQuery(name = "Reception.findByIdDuty", query = "SELECT r FROM Reception r WHERE r.idDuty = :idDuty")})
public class Reception extends Entity1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_duty")
    private int idDuty;
    @JoinColumn(name = "id_card", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Card idCard;
    @JoinColumn(name = "id_users", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users idUsers;

    public Reception() {
    }

    public Reception(Integer id) {
        this.id = id;
    }

    public Reception(Integer id, Date time, String status, int idDuty) {
        this.id = id;
        this.time = time;
        this.status = status;
        this.idDuty = idDuty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdDuty() {
        return idDuty;
    }

    public void setIdDuty(int idDuty) {
        this.idDuty = idDuty;
    }

    public Card getIdCard() {
        return idCard;
    }

    public void setIdCard(Card idCard) {
        this.idCard = idCard;
    }

    public Users getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Users idUsers) {
        this.idUsers = idUsers;
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
        if (!(object instanceof Reception)) {
            return false;
        }
        Reception other = (Reception) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.entity.Reception[ id=" + id + " ]";
    }
    
}
