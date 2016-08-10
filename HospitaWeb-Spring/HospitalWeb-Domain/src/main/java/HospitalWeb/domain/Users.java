/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.domain;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Жека
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findBySnme", query = "SELECT u FROM Users u WHERE u.snme = :snme"),
    @NamedQuery(name = "Users.findByExp", query = "SELECT u FROM Users u WHERE u.exp = :exp"),
    @NamedQuery(name = "Users.findByLogin", query = "SELECT u FROM Users u WHERE u.login = :login"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByTelephone", query = "SELECT u FROM Users u WHERE u.telephone = :telephone"),
    @NamedQuery(name = "Users.findByStatus", query = "SELECT u FROM Users u WHERE u.status = :status")})
public class Users implements Serializable {

    @Size(max = 50)
    @Column(name = "auntification")
    private String auntification;

    @Basic(optional = false)
    @NotNull
    @Column(name = "statusregistr")
    private boolean statusregistr;
    @Size(max = 150)
    @Column(name = "linkaccept")
    private String linkaccept;

    @Column(name = "status_work")
    private Boolean statusWork;

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
    @Column(name = "snme")
    private String snme;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exp")
    private int exp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsers", fetch = FetchType.LAZY)
    private Collection<DutyDays> dutyDaysCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsers", fetch = FetchType.LAZY)
    private Collection<Reception> receptionCollection;
    @JoinColumn(name = "idspecialization", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Spcialialization idspecialization;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Boolean statusregistr, String linkaccept, Boolean statusWork, Integer id, String name, String snme, int exp, String login, String password, String email, String telephone, String status, Collection<DutyDays> dutyDaysCollection, Collection<Reception> receptionCollection, Spcialialization idspecialization) {
        this.statusregistr = statusregistr;
        this.linkaccept = linkaccept;
        this.statusWork = statusWork;
        this.id = id;
        this.name = name;
        this.snme = snme;
        this.exp = exp;
        this.login = login;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.status = status;
        this.dutyDaysCollection = dutyDaysCollection;
        this.receptionCollection = receptionCollection;
        this.idspecialization = idspecialization;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
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

    public String getSnme() {
        return snme;
    }

    public void setSnme(String snme) {
        this.snme = snme;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Boolean getStatusWork() {
        return statusWork;
    }

    public void setStatusWork(Boolean statusWork) {
        this.statusWork = statusWork;
    }

    public void setStatusregistr(boolean statusregistr) {
        this.statusregistr = statusregistr;
    }
    
    public String getLinkaccept() {
        return linkaccept;
    }

    public void setLinkaccept(String linkaccept) {
        this.linkaccept = linkaccept;
    }

    public boolean getStatusregistr() {
        return statusregistr;
    }

    
    @XmlTransient
    public Collection<DutyDays> getDutyDaysCollection() {
        return dutyDaysCollection;
    }

    public void setDutyDaysCollection(Collection<DutyDays> dutyDaysCollection) {
        this.dutyDaysCollection = dutyDaysCollection;
    }
    
    public String getAuntification() {
        return auntification;
    }

    public void setAuntification(String auntification) {
        this.auntification = auntification;
    }

    @XmlTransient
    public Collection<Reception> getReceptionCollection() {
        return receptionCollection;
    }

    public void setReceptionCollection(Collection<Reception> receptionCollection) {
        this.receptionCollection = receptionCollection;
    }

    public Spcialialization getIdspecialization() {
        return idspecialization;
    }

    public void setIdspecialization(Spcialialization idspecialization) {
        this.idspecialization = idspecialization;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.entity.Users[ id=" + id + " ]";
    }

    
    
    
}
