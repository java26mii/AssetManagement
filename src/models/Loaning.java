/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WINDOWS 10
 */
@Entity
@Table(name = "LOANINGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loaning.findAll", query = "SELECT l FROM Loaning l")
    , @NamedQuery(name = "Loaning.findById", query = "SELECT l FROM Loaning l WHERE l.id = :id")
    , @NamedQuery(name = "Loaning.findByDateLoaning", query = "SELECT l FROM Loaning l WHERE l.dateLoaning = :dateLoaning")
    , @NamedQuery(name = "Loaning.findByDateReturn", query = "SELECT l FROM Loaning l WHERE l.dateReturn = :dateReturn")
    , @NamedQuery(name = "Loaning.findByNote", query = "SELECT l FROM Loaning l WHERE l.note = :note")
    , @NamedQuery(name = "Loaning.findByIsDelete", query = "SELECT l FROM Loaning l WHERE l.isDelete = :isDelete")})
public class Loaning implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "DATE_LOANING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLoaning;
    @Basic(optional = false)
    @Column(name = "DATE_RETURN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReturn;
    @Basic(optional = false)
    @Column(name = "NOTE")
    private String note;
    @Basic(optional = false)
    @Column(name = "IS_DELETE")
    private Character isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaning", fetch = FetchType.LAZY)
    private List<LoaningStatus> loaningStatusList;
    @JoinColumn(name = "ASSET", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asset asset;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public Loaning() {
    }

    public Loaning(Long id) {
        this.id = id;
    }

    public Loaning(Long id, Date dateLoaning, Date dateReturn, String note, Character isDelete) {
        this.id = id;
        this.dateLoaning = dateLoaning;
        this.dateReturn = dateReturn;
        this.note = note;
        this.isDelete = isDelete;
    }
    
        public Loaning(Long id, Date dateLoaning, Date dateReturn, String note, Asset asset, Employee employee, Character isDelete) {
        this.id = id;
        this.dateLoaning = dateLoaning;
        this.dateReturn = dateReturn;
        this.note = note;
        this.asset = asset;
        this.employee = employee;
        this.isDelete = isDelete;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateLoaning() {
        return dateLoaning;
    }

    public void setDateLoaning(Date dateLoaning) {
        this.dateLoaning = dateLoaning;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Character getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Character isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public List<LoaningStatus> getLoaningStatusList() {
        return loaningStatusList;
    }

    public void setLoaningStatusList(List<LoaningStatus> loaningStatusList) {
        this.loaningStatusList = loaningStatusList;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Loaning)) {
            return false;
        }
        Loaning other = (Loaning) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Loaning[ id=" + id + " ]";
    }
    
}
