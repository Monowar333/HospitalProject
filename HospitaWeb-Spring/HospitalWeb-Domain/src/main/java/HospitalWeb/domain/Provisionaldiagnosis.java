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
@Table(name = "provisionaldiagnosis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provisionaldiagnosis.findAll", query = "SELECT p FROM Provisionaldiagnosis p"),
    @NamedQuery(name = "Provisionaldiagnosis.findById", query = "SELECT p FROM Provisionaldiagnosis p WHERE p.id = :id"),
    @NamedQuery(name = "Provisionaldiagnosis.findByGroupdiagnos", query = "SELECT p FROM Provisionaldiagnosis p WHERE p.groupdiagnos = :groupdiagnos"),
    @NamedQuery(name = "Provisionaldiagnosis.findByName", query = "SELECT p FROM Provisionaldiagnosis p WHERE p.name = :name"),
    @NamedQuery(name = "Provisionaldiagnosis.findByGroupid", query = "SELECT p FROM Provisionaldiagnosis p WHERE p.groupid = :groupid")})
public class Provisionaldiagnosis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "groupdiagnos")
    private String groupdiagnos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "groupid")
    private String groupid;

    public Provisionaldiagnosis() {
    }

    public Provisionaldiagnosis(Integer id) {
        this.id = id;
    }

    public Provisionaldiagnosis(Integer id, String groupdiagnos, String name, String groupid) {
        this.id = id;
        this.groupdiagnos = groupdiagnos;
        this.name = name;
        this.groupid = groupid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupdiagnos() {
        return groupdiagnos;
    }

    public void setGroupdiagnos(String groupdiagnos) {
        this.groupdiagnos = groupdiagnos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
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
        if (!(object instanceof Provisionaldiagnosis)) {
            return false;
        }
        Provisionaldiagnosis other = (Provisionaldiagnosis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HospitalWeb.domain.Provisionaldiagnosis[ id=" + id + " ]";
    }
    
}
