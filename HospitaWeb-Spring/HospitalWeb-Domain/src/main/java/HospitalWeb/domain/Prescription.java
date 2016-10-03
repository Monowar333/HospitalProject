/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Жека
 */
@Entity
@Table(name = "prescription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescription.findAll", query = "SELECT p FROM Prescription p"),
    @NamedQuery(name = "Prescription.findById", query = "SELECT p FROM Prescription p WHERE p.id = :id"),
    @NamedQuery(name = "Prescription.findByLinkprescription", query = "SELECT p FROM Prescription p WHERE p.linkprescription = :linkprescription")})
public class Prescription implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprescription", fetch = FetchType.LAZY)
    private List<Prescriptiondeteil> prescriptiondeteilList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 150)
    @Column(name = "linkprescription")
    private String linkprescription;
    @JoinColumn(name = "idreception", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Reception idreception;

    public Prescription() {
    }

    public Prescription(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkprescription() {
        return linkprescription;
    }

    public void setLinkprescription(String linkprescription) {
        this.linkprescription = linkprescription;
    }

    public Reception getIdreception() {
        return idreception;
    }

    public void setIdreception(Reception idreception) {
        this.idreception = idreception;
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
        if (!(object instanceof Prescription)) {
            return false;
        }
        Prescription other = (Prescription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HospitalWeb.domain.Prescription[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Prescriptiondeteil> getPrescriptiondeteilList() {
        return prescriptiondeteilList;
    }

    public void setPrescriptiondeteilList(List<Prescriptiondeteil> prescriptiondeteilList) {
        this.prescriptiondeteilList = prescriptiondeteilList;
    }
    
}
