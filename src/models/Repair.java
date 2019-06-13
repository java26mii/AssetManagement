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
@Table(name = "REPAIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repair.findAll", query = "SELECT r FROM Repair r")
    , @NamedQuery(name = "Repair.findById", query = "SELECT r FROM Repair r WHERE r.id = :id")
    , @NamedQuery(name = "Repair.findByDateRepair", query = "SELECT r FROM Repair r WHERE r.dateRepair = :dateRepair")
    , @NamedQuery(name = "Repair.findByCost", query = "SELECT r FROM Repair r WHERE r.cost = :cost")
    , @NamedQuery(name = "Repair.findByDetail", query = "SELECT r FROM Repair r WHERE r.detail = :detail")})
public class Repair implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repair", fetch = FetchType.LAZY)
    private List<Repairstatus> repairstatusList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "DATE_REPAIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRepair;
    @Basic(optional = false)
    @Column(name = "COST")
    private long cost;
    @Basic(optional = false)
    @Column(name = "DETAIL")
    private String detail;
    @JoinColumn(name = "ASSET", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asset asset;
    @JoinColumn(name = "MANAGER", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee manager;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;

    public Repair() {
    }

    public Repair(Long id) {
        this.id = id;
    }

    public Repair(Long id, Date dateRepair, long cost, String detail) {
        this.id = id;
        this.dateRepair = dateRepair;
        this.cost = cost;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateRepair() {
        return dateRepair;
    }

    public void setDateRepair(Date dateRepair) {
        this.dateRepair = dateRepair;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    @XmlTransient
    public List<Repairstatus> getRepairstatusList() {
        return repairstatusList;
    }

    public void setRepairstatusList(List<Repairstatus> repairstatusList) {
        this.repairstatusList = repairstatusList;
    }
    
}
