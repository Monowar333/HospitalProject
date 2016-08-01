/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Жека
 */
@Entity
@Table(name = "card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c"),
    @NamedQuery(name = "Card.findById", query = "SELECT c FROM Card c WHERE c.id = :id"),
    @NamedQuery(name = "Card.findByName", query = "SELECT c FROM Card c WHERE c.name = :name"),
    @NamedQuery(name = "Card.findBySname", query = "SELECT c FROM Card c WHERE c.sname = :sname"),
    @NamedQuery(name = "Card.findByNumber", query = "SELECT c FROM Card c WHERE c.number = :number")})
public class Card extends Entity1 implements Serializable {

  

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "address")
    private String address;

   
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateRegistr")
    @Temporal(TemporalType.DATE)
    private Date dateRegistr;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateofBirthdey")
    @Temporal(TemporalType.DATE)
    private Date dateofBirthdey;
    
    @Size(max = 20)
    @Column(name = "Telephone")
    private String telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 25)
    @Column(name = "email")
    private String email;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sname")
    private String sname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "number")
    private String number;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCard", fetch = FetchType.LAZY)
    private Collection<Reception> receptionCollection;

    public Card() {
    }

    public Card(Integer id) {
        this.id = id;
    }

    public Card(String address, Date dateofBirth, boolean status, Date dateRegistr, String telephone, String email, Integer id, String name, String sname, String number, Collection<Reception> receptionCollection) {
        this.address = address;
        this.dateofBirthdey = dateofBirth;
        this.status = status;
        this.dateRegistr = dateRegistr;
        this.telephone = telephone;
        this.email = email;
        this.id = id;
        this.name = name;
        this.sname = sname;
        this.number = number;
        this.receptionCollection = receptionCollection;
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

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

  
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
     public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateRegistr() {
        return dateRegistr;
    }

    public void setDateRegistr(Date dateRegistr) {
        this.dateRegistr = dateRegistr;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateofBirthdey() {
        return dateofBirthdey;
    }

    public void setDateofBirthdey(Date dateofBirthdey) {
        this.dateofBirthdey = dateofBirthdey;
    }

    @XmlTransient
    public Collection<Reception> getReceptionCollection() {
        return receptionCollection;
    }

    public void setReceptionCollection(Collection<Reception> receptionCollection) {
        this.receptionCollection = receptionCollection;
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
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.entity.Card[ id=" + id + " ]";
    }

    

   
    
}
