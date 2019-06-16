/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WINDOWS 10
 */
@Entity
@Table(name = "REPAIR_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepairStatus.findAll", query = "SELECT r FROM RepairStatus r")
    , @NamedQuery(name = "RepairStatus.findById", query = "SELECT r FROM RepairStatus r WHERE r.id = :id")
    , @NamedQuery(name = "RepairStatus.findByDateRepair", query = "SELECT r FROM RepairStatus r WHERE r.dateRepair = :dateRepair")})
public class RepairStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "DATE_REPAIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRepair;
    @JoinColumn(name = "REPAIR", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Repair repair;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;

    public RepairStatus() {
    }

    public RepairStatus(Long id) {
        this.id = id;
    }

    public RepairStatus(Long id, Date dateRepair) {
        this.id = id;
        this.dateRepair = dateRepair;
    }

    public RepairStatus(Long id, Status status, Repair repair, Date dateRepair) {
        this.id = id;
        this.repair = repair;
        this.status = status;
        this.dateRepair = dateRepair;
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

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
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
        if (!(object instanceof RepairStatus)) {
            return false;
        }
        RepairStatus other = (RepairStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.RepairStatus[ id=" + id + " ]";
    }

}
