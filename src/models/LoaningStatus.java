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
@Table(name = "LOANING_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaningStatus.findAll", query = "SELECT l FROM LoaningStatus l")
    , @NamedQuery(name = "LoaningStatus.findById", query = "SELECT l FROM LoaningStatus l WHERE l.id = :id")
    , @NamedQuery(name = "LoaningStatus.findByDateLoaning", query = "SELECT l FROM LoaningStatus l WHERE l.dateLoaning = :dateLoaning")})
public class LoaningStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "DATE_LOANING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLoaning;
    @JoinColumn(name = "LOANING", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Loaning loaning;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;

    public LoaningStatus() {
    }

    public LoaningStatus(Long id) {
        this.id = id;
    }

    public LoaningStatus(Long id, Date dateLoaning) {
        this.id = id;
        this.dateLoaning = dateLoaning;
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

    public Loaning getLoaning() {
        return loaning;
    }

    public void setLoaning(Loaning loaning) {
        this.loaning = loaning;
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
        if (!(object instanceof LoaningStatus)) {
            return false;
        }
        LoaningStatus other = (LoaningStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.LoaningStatus[ id=" + id + " ]";
    }
    
}
