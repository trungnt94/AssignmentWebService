/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HienTam68
 */
@Entity
@Table(name = "TRANSACTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")
    , @NamedQuery(name = "Transactions.findById", query = "SELECT t FROM Transactions t WHERE t.id = :id")
    , @NamedQuery(name = "Transactions.findByTransactionname", query = "SELECT t FROM Transactions t WHERE t.transactionname = :transactionname")
    , @NamedQuery(name = "Transactions.findByTransactionamount", query = "SELECT t FROM Transactions t WHERE t.transactionamount = :transactionamount")
    , @NamedQuery(name = "Transactions.findByReceiverid", query = "SELECT t FROM Transactions t WHERE t.receiverid = :receiverid")
    , @NamedQuery(name = "Transactions.findBySenderid", query = "SELECT t FROM Transactions t WHERE t.senderid = :senderid")
    , @NamedQuery(name = "Transactions.findByTransactionfee", query = "SELECT t FROM Transactions t WHERE t.transactionfee = :transactionfee")
    , @NamedQuery(name = "Transactions.findByTransactiondate", query = "SELECT t FROM Transactions t WHERE t.transactiondate = :transactiondate")
    , @NamedQuery(name = "Transactions.findByReceiveamount", query = "SELECT t FROM Transactions t WHERE t.receiveamount = :receiveamount")
    , @NamedQuery(name = "Transactions.findBySendamount", query = "SELECT t FROM Transactions t WHERE t.sendamount = :sendamount")
    , @NamedQuery(name = "Transactions.findByBillid", query = "SELECT t FROM Transactions t WHERE t.billid = :billid")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "TRANSACTIONNAME")
    private String transactionname;
    @Column(name = "TRANSACTIONAMOUNT")
    private Integer transactionamount;
    @Column(name = "RECEIVERID")
    private String receiverid;
    @Column(name = "SENDERID")
    private String senderid;
    @Column(name = "TRANSACTIONFEE")
    private Integer transactionfee;
    @Column(name = "TRANSACTIONDATE")
    @Temporal(TemporalType.DATE)
    private Date transactiondate;
    @Column(name = "RECEIVEAMOUNT")
    private Integer receiveamount;
    @Column(name = "SENDAMOUNT")
    private Integer sendamount;
    @Size(max = 20)
    @Column(name = "BILLID")
    private String billid;

    public Transactions() {
    }

    public Transactions(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionname() {
        return transactionname;
    }

    public void setTransactionname(String transactionname) {
        this.transactionname = transactionname;
    }

    public Integer getTransactionamount() {
        return transactionamount;
    }

    public void setTransactionamount(Integer transactionamount) {
        this.transactionamount = transactionamount;
    }

    public String getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public Integer getTransactionfee() {
        return transactionfee;
    }

    public void setTransactionfee(Integer transactionfee) {
        this.transactionfee = transactionfee;
    }

    public Date getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(Date transactiondate) {
        this.transactiondate = transactiondate;
    }

    public Integer getReceiveamount() {
        return receiveamount;
    }

    public void setReceiveamount(Integer receiveamount) {
        this.receiveamount = receiveamount;
    }

    public Integer getSendamount() {
        return sendamount;
    }

    public void setSendamount(Integer sendamount) {
        this.sendamount = sendamount;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
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
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Transactions[ id=" + id + " ]";
    }
    
}
