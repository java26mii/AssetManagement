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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "REPAIRS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repair.findAll", query = "SELECT r FROM Repair r")
    , @NamedQuery(name = "Repair.findById", query = "SELECT r FROM Repair r WHERE r.id = :id")
    , @NamedQuery(name = "Repair.findByCost", query = "SELECT r FROM Repair r WHERE r.cost = :cost")
    , @NamedQuery(name = "Repair.findByNote", query = "SELECT r FROM Repair r WHERE r.note = :note")
    , @NamedQuery(name = "Repair.findByIsDelete", query = "SELECT r FROM Repair r WHERE r.isDelete = :isDelete")})
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "COST")
    private Long cost;
    @Basic(optional = false)
    @Column(name = "NOTE")
    private String note;
    @Basic(optional = false)
    @Column(name = "IS_DELETE")
    private Character isDelete;
    @JoinColumn(name = "ASSET", referencedColumnName = "ID")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Asset asset;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Employee employee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repair", fetch = FetchType.LAZY)
    private List<RepairStatus> repairStatusList;

    public Repair() {
    }

    public Repair(Long id) {
        this.id = id;
    }

    public Repair(Long id, long cost, String note, Character isDelete) {
        this.id = id;
        this.cost = cost;
        this.note = note;
        this.isDelete = isDelete;
    }
    
        public Repair(Long id, Long cost, String note, Asset asset, Employee employee, Character isDelete) {
        this.id = id;
        this.cost = cost;
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

    public long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
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

    @XmlTransient
    public List<RepairStatus> getRepairStatusList() {
        return repairStatusList;
    }

    public void setRepairStatusList(List<RepairStatus> repairStatusList) {
        this.repairStatusList = repairStatusList;
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
        if (!(object instanceof Repair)) {
            return false;
        }
        Repair other = (Repair) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Repair[ id=" + id + " ]";
    }
    
}
