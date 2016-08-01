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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Жека
 */
@Entity
@Table(name = "duty_days")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DutyDays.findAll", query = "SELECT d FROM DutyDays d"),
    @NamedQuery(name = "DutyDays.findById", query = "SELECT d FROM DutyDays d WHERE d.id = :id"),
    @NamedQuery(name = "DutyDays.findByDate", query = "SELECT d FROM DutyDays d WHERE d.date = :date")})
public class DutyDays extends Entity1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "id_users", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users idUsers;

    public DutyDays() {
    }

    public DutyDays(Integer id) {
        this.id = id;
    }

    public DutyDays(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        if (!(object instanceof DutyDays)) {
            return false;
        }
        DutyDays other = (DutyDays) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.entity.DutyDays[ id=" + id + " ]";
    }
    
}
