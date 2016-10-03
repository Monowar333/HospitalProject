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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Жека
 */
@Entity
@Table(name = "medications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medications.findAll", query = "SELECT m FROM Medications m"),
    @NamedQuery(name = "Medications.findById", query = "SELECT m FROM Medications m WHERE m.id = :id"),
    @NamedQuery(name = "Medications.findByTradename", query = "SELECT m FROM Medications m WHERE m.tradename = :tradename"),
    @NamedQuery(name = "Medications.findByMnn", query = "SELECT m FROM Medications m WHERE m.mnn = :mnn"),
    @NamedQuery(name = "Medications.findByConditionsofsupply", query = "SELECT m FROM Medications m WHERE m.conditionsofsupply = :conditionsofsupply"),
    @NamedQuery(name = "Medications.findByCompositionofactivesubstances", query = "SELECT m FROM Medications m WHERE m.compositionofactivesubstances = :compositionofactivesubstances"),
    @NamedQuery(name = "Medications.findByClinicalpharmgroup", query = "SELECT m FROM Medications m WHERE m.clinicalpharmgroup = :clinicalpharmgroup"),
    @NamedQuery(name = "Medications.findByCountry", query = "SELECT m FROM Medications m WHERE m.country = :country"),
    @NamedQuery(name = "Medications.findByManufacturer", query = "SELECT m FROM Medications m WHERE m.manufacturer = :manufacturer"),
    @NamedQuery(name = "Medications.findByManufactureren", query = "SELECT m FROM Medications m WHERE m.manufactureren = :manufactureren"),
    @NamedQuery(name = "Medications.findByProduct", query = "SELECT m FROM Medications m WHERE m.product = :product")})
public class Medications implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmedication", fetch = FetchType.LAZY)
    private List<Prescriptiondeteil> prescriptiondeteilList;

  

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "tradename")
    private String tradename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "mnn")
    private String mnn;
    @Size(max = 1000)
    @Column(name = "conditionsofsupply")
    private String conditionsofsupply;
    @Size(max = 1000)
    @Column(name = "compositionofactivesubstances")
    private String compositionofactivesubstances;
    @Size(max = 1000)
    @Column(name = "clinicalpharmgroup")
    private String clinicalpharmgroup;
    @Size(max = 100)
    @Column(name = "country")
    private String country;
    @Size(max = 1000)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Size(max = 1000)
    @Column(name = "manufactureren")
    private String manufactureren;
    @Size(max = 1000)
    @Column(name = "Product")
    private String product;

    public Medications() {
    }

    public Medications(Integer id) {
        this.id = id;
    }

    public Medications(Integer id, String tradename, String mnn) {
        this.id = id;
        this.tradename = tradename;
        this.mnn = mnn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradename() {
        return tradename;
    }

    public void setTradename(String tradename) {
        this.tradename = tradename;
    }

    public String getMnn() {
        return mnn;
    }

    public void setMnn(String mnn) {
        this.mnn = mnn;
    }

    public String getConditionsofsupply() {
        return conditionsofsupply;
    }

    public void setConditionsofsupply(String conditionsofsupply) {
        this.conditionsofsupply = conditionsofsupply;
    }

    public String getCompositionofactivesubstances() {
        return compositionofactivesubstances;
    }

    public void setCompositionofactivesubstances(String compositionofactivesubstances) {
        this.compositionofactivesubstances = compositionofactivesubstances;
    }

    public String getClinicalpharmgroup() {
        return clinicalpharmgroup;
    }

    public void setClinicalpharmgroup(String clinicalpharmgroup) {
        this.clinicalpharmgroup = clinicalpharmgroup;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufactureren() {
        return manufactureren;
    }

    public void setManufactureren(String manufactureren) {
        this.manufactureren = manufactureren;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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
        if (!(object instanceof Medications)) {
            return false;
        }
        Medications other = (Medications) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HospitalWeb.domain.Medications[ id=" + id + " ]";
    }



    @XmlTransient
    public List<Prescriptiondeteil> getPrescriptiondeteilList() {
        return prescriptiondeteilList;
    }

    public void setPrescriptiondeteilList(List<Prescriptiondeteil> prescriptiondeteilList) {
        this.prescriptiondeteilList = prescriptiondeteilList;
    }
    
}
