/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain;

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
 * @author Жека
 */
@Entity
@Table(name = "pre_entry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreEntry.findAll", query = "SELECT p FROM PreEntry p"),
    @NamedQuery(name = "PreEntry.findById", query = "SELECT p FROM PreEntry p WHERE p.id = :id"),
    @NamedQuery(name = "PreEntry.findByIdDutyDays", query = "SELECT p FROM PreEntry p WHERE p.idDutyDays = :idDutyDays"),
    @NamedQuery(name = "PreEntry.findByIdCards", query = "SELECT p FROM PreEntry p WHERE p.idCards = :idCards"),
    @NamedQuery(name = "PreEntry.findByTelephone", query = "SELECT p FROM PreEntry p WHERE p.telephone = :telephone")})
public class PreEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_duty_days")
    private int idDutyDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cards")
    private int idCards;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telephone")
    private String telephone;

    public PreEntry() {
    }

    public PreEntry(Integer id) {
        this.id = id;
    }

    public PreEntry(Integer id, int idDutyDays, int idCards, String telephone) {
        this.id = id;
        this.idDutyDays = idDutyDays;
        this.idCards = idCards;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdDutyDays() {
        return idDutyDays;
    }

    public void setIdDutyDays(int idDutyDays) {
        this.idDutyDays = idDutyDays;
    }

    public int getIdCards() {
        return idCards;
    }

    public void setIdCards(int idCards) {
        this.idCards = idCards;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
        if (!(object instanceof PreEntry)) {
            return false;
        }
        PreEntry other = (PreEntry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.entity.PreEntry[ id=" + id + " ]";
    }
    
}
