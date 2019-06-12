/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WINDOWS 10
 */
@Entity
@Table(name = "ASSET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asset.findAll", query = "SELECT a FROM Asset a")
    , @NamedQuery(name = "Asset.findById", query = "SELECT a FROM Asset a WHERE a.id = :id")
    , @NamedQuery(name = "Asset.findByName", query = "SELECT a FROM Asset a WHERE a.name = :name")
    , @NamedQuery(name = "Asset.findByQuantity", query = "SELECT a FROM Asset a WHERE a.quantity = :quantity")
    , @NamedQuery(name = "Asset.findByCategory", query = "SELECT a FROM Asset a WHERE a.category = :category")
    , @NamedQuery(name = "Asset.findByNote", query = "SELECT a FROM Asset a WHERE a.note = :note")})
public class Asset implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "QUANTITY")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "CATEGORY")
    private String category;
    @Basic(optional = false)
    @Column(name = "NOTE")
    private String note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asset", fetch = FetchType.LAZY)
    private List<Loaning> loaningList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asset", fetch = FetchType.LAZY)
    private List<Repair> repairList;

    public Asset() {
    }

    public Asset(Long id) {
        this.id = id;
    }

    public Asset(Long id, String name, int quantity, String category, String note) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @XmlTransient
    public List<Loaning> getLoaningList() {
        return loaningList;
    }

    public void setLoaningList(List<Loaning> loaningList) {
        this.loaningList = loaningList;
    }

    @XmlTransient
    public List<Repair> getRepairList() {
        return repairList;
    }

    public void setRepairList(List<Repair> repairList) {
        this.repairList = repairList;
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
        if (!(object instanceof Asset)) {
            return false;
        }
        Asset other = (Asset) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Asset[ id=" + id + " ]";
    }
    
}
