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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "prescriptiondeteil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescriptiondeteil.findAll", query = "SELECT p FROM Prescriptiondeteil p"),
    @NamedQuery(name = "Prescriptiondeteil.findById", query = "SELECT p FROM Prescriptiondeteil p WHERE p.id = :id"),
    @NamedQuery(name = "Prescriptiondeteil.findByIndicationsforuse", query = "SELECT p FROM Prescriptiondeteil p WHERE p.indicationsforuse = :indicationsforuse")})
public class Prescriptiondeteil implements Serializable {

    @JoinColumn(name = "idprescription", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Prescription idprescription;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "indicationsforuse")
    private String indicationsforuse;
    @JoinColumn(name = "idmedication", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Medications idmedication;

    public Prescriptiondeteil() {
    }

    public Prescriptiondeteil(Integer id) {
        this.id = id;
    }

    public Prescriptiondeteil(Integer id, String indicationsforuse) {
        this.id = id;
        this.indicationsforuse = indicationsforuse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndicationsforuse() {
        return indicationsforuse;
    }

    public void setIndicationsforuse(String indicationsforuse) {
        this.indicationsforuse = indicationsforuse;
    }

    public Medications getIdmedication() {
        return idmedication;
    }

    public void setIdmedication(Medications idmedication) {
        this.idmedication = idmedication;
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
        if (!(object instanceof Prescriptiondeteil)) {
            return false;
        }
        Prescriptiondeteil other = (Prescriptiondeteil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HospitalWeb.domain.Prescriptiondeteil[ id=" + id + " ]";
    }

    public Prescription getIdprescription() {
        return idprescription;
    }

    public void setIdprescription(Prescription idprescription) {
        this.idprescription = idprescription;
    }
    
}
