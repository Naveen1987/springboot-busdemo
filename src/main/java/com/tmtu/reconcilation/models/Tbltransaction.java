

package com.tmtu.reconcilation.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tmtu.allocation.models.Tblwaybill;

@Entity(name="tbltransaction")
public class Tbltransaction implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long transactionid;
    @Column(length=45)
    private String fromstopage;
    @Column(length=45)
    private String tostopage;
    @Column(precision=19)
    private long totaltickets;
    @Column(precision=17, scale=17)
    private double totalamount;
    @Column(length=45)
    private String paymenttype;
    @Column(precision=19)
    private long createdby;
    @Column(precision=19)
    private long lastModifiedBy;
    @Column(precision=19)
    private long concessiontype;
    private Calendar createdOn;
    private Calendar lastModifiedOn;
    @OneToMany(mappedBy="tbltransaction",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
    @JsonManagedReference
    private List<Tbltickets> tbltickets=new ArrayList<Tbltickets>();
    
    @ManyToOne
    @JoinColumn(name="waybillnumber",foreignKey=@ForeignKey(name="tblwaybill_waybillnumber"))
    @JsonBackReference
    private Tblwaybill tblwaybill;

    /** Default constructor. */
    public Tbltransaction() {
        super();
    }

    /**
     * Access method for transactionid.
     *
     * @return the current value of transactionid
     */
    public long getTransactionid() {
        return transactionid;
    }

    /**
     * Setter method for transactionid.
     *
     * @param aTransactionid the new value for transactionid
     */
    public void setTransactionid(long aTransactionid) {
        transactionid = aTransactionid;
    }

    /**
     * Access method for fromstopage.
     *
     * @return the current value of fromstopage
     */
    public String getFromstopage() {
        return fromstopage;
    }

    /**
     * Setter method for fromstopage.
     *
     * @param aFromstopage the new value for fromstopage
     */
    public void setFromstopage(String aFromstopage) {
        fromstopage = aFromstopage;
    }

    /**
     * Access method for tostopage.
     *
     * @return the current value of tostopage
     */
    public String getTostopage() {
        return tostopage;
    }

    /**
     * Setter method for tostopage.
     *
     * @param aTostopage the new value for tostopage
     */
    public void setTostopage(String aTostopage) {
        tostopage = aTostopage;
    }

    /**
     * Access method for totaltickets.
     *
     * @return the current value of totaltickets
     */
    public long getTotaltickets() {
        return totaltickets;
    }

    /**
     * Setter method for totaltickets.
     *
     * @param aTotaltickets the new value for totaltickets
     */
    public void setTotaltickets(long aTotaltickets) {
        totaltickets = aTotaltickets;
    }

    /**
     * Access method for totalamount.
     *
     * @return the current value of totalamount
     */
    public double getTotalamount() {
        return totalamount;
    }

    /**
     * Setter method for totalamount.
     *
     * @param aTotalamount the new value for totalamount
     */
    public void setTotalamount(double aTotalamount) {
        totalamount = aTotalamount;
    }

    /**
     * Access method for paymenttype.
     *
     * @return the current value of paymenttype
     */
    public String getPaymenttype() {
        return paymenttype;
    }

    /**
     * Setter method for paymenttype.
     *
     * @param aPaymenttype the new value for paymenttype
     */
    public void setPaymenttype(String aPaymenttype) {
        paymenttype = aPaymenttype;
    }

    /**
     * Access method for createdby.
     *
     * @return the current value of createdby
     */
    public long getCreatedby() {
        return createdby;
    }

    /**
     * Setter method for createdby.
     *
     * @param aCreatedby the new value for createdby
     */
    public void setCreatedby(long aCreatedby) {
        createdby = aCreatedby;
    }

    /**
     * Access method for lastModifiedBy.
     *
     * @return the current value of lastModifiedBy
     */
    public long getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * Setter method for lastModifiedBy.
     *
     * @param aLastModifiedBy the new value for lastModifiedBy
     */
    public void setLastModifiedBy(long aLastModifiedBy) {
        lastModifiedBy = aLastModifiedBy;
    }

    /**
     * Access method for createdOn.
     *
     * @return the current value of createdOn
     */
    public Calendar getCreatedOn() {
        return createdOn;
    }

    /**
     * Setter method for createdOn.
     *
     * @param aCreatedOn the new value for createdOn
     */
    public void setCreatedOn(Calendar aCreatedOn) {
        createdOn = aCreatedOn;
    }

    /**
     * Access method for lastModifiedOn.
     *
     * @return the current value of lastModifiedOn
     */
    public Calendar getLastModifiedOn() {
        return lastModifiedOn;
    }

    /**
     * Setter method for lastModifiedOn.
     *
     * @param aLastModifiedOn the new value for lastModifiedOn
     */
    public void setLastModifiedOn(Calendar aLastModifiedOn) {
        lastModifiedOn = aLastModifiedOn;
    }

    /**
     * Access method for tbltickets.
     *
     * @return the current value of tbltickets
     */
    public List<Tbltickets> getTbltickets() {
        return tbltickets;
    }

    /**
     * Setter method for tbltickets.
     *
     * @param aTbltickets the new value for tbltickets
     */
    public void setTbltickets(List<Tbltickets> aTbltickets) {
        tbltickets = aTbltickets;
    }

    /**
     * Access method for tblwaybill.
     *
     * @return the current value of tblwaybill
     */
    public Tblwaybill getTblwaybill() {
        return tblwaybill;
    }

    /**
     * Setter method for tblwaybill.
     *
     * @param aTblwaybill the new value for tblwaybill
     */
    public void setTblwaybill(Tblwaybill aTblwaybill) {
        tblwaybill = aTblwaybill;
    }

    /**
     * Access method for concessiontype.
     *
     * @return the current value of concessiontype
     */
    public long getConcessiontype() {
		return concessiontype;
	}


    /**
     * Setter method for concessiontype.
     *
     * @param aTblwaybill the new value for concessiontype
     */
	public void setConcessiontype(long concessiontype) {
		this.concessiontype = concessiontype;
	}

	/**
     * Compares the key for this instance with another Tbltransaction.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tbltransaction and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tbltransaction)) {
            return false;
        }
        Tbltransaction that = (Tbltransaction) other;
        if (this.getTransactionid() != that.getTransactionid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tbltransaction.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tbltransaction)) return false;
        return this.equalKeys(other) && ((Tbltransaction)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getTransactionid() ^ (getTransactionid()>>>32));
        result = 37*result + i;
        return result;
    }

    

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
  
    @Override
	public String toString() {
		return "Tbltransaction [transactionid=" + transactionid + ", fromstopage=" + fromstopage + ", tostopage="
				+ tostopage + ", totaltickets=" + totaltickets + ", totalamount=" + totalamount + ", paymenttype="
				+ paymenttype + ", createdby=" + createdby + ", lastModifiedBy=" + lastModifiedBy + ", concessiontype="
				+ concessiontype + ", createdOn=" + createdOn + ", lastModifiedOn=" + lastModifiedOn + ", tbltickets="
				+ tbltickets + ", tblwaybill=" + tblwaybill + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("transactionid", new Long(getTransactionid()));
        return ret;
    }

    
    /*
     * 
     * For adding the dependency of foreign key for Tblcollection
     * 
     * */
        public void addTickets(Tbltickets tickets) {
            if (tickets != null) {
            	tbltickets.add(tickets);
            	tickets.setTbltransaction(this);
            }
         }
}
