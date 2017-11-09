
package com.tmtu.allocation.models;

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
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tmtu.reconcilation.models.Tblcollection;
import com.tmtu.reconcilation.models.Tbltransaction;


@Entity(name="tblwaybill")
public class Tblwaybill implements Serializable {

    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    @Id
   //@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long waybillnumber;
    @Column(precision=19)
    private long issuedRoll;
    @Column(precision=19)
    private boolean status;
    @Column(precision=19)
    private long createdBy;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar wayBillDate;
    @Column(precision=19)
    private long issuedTickets;
    private Calendar createdOn;
    private Calendar lastModifiedOn;
    @ManyToOne
    @JoinColumn(name="dutyAllocationId",foreignKey=@ForeignKey(name="tbldutyallocation_dutyAllocationId"))
    @JsonBackReference
    private Tbldutyallocation tbldutyallocation;

    @OneToMany(mappedBy="tblwaybill",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
    @JsonManagedReference
    private List<Tblcollection> tblcollection=new ArrayList<Tblcollection>();
    @OneToMany(mappedBy="tblwaybill",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
    @JsonManagedReference
    private List<Tbltransaction> tbltransaction=new ArrayList<Tbltransaction>();
    
    /** Default constructor. */
    public Tblwaybill() {
        super();
    }

    /**
     * Access method for waybillnumber.
     *
     * @return the current value of waybillnumber
     */
    public long getWaybillnumber() {
        return waybillnumber;
    }

    /**
     * Setter method for waybillnumber.
     *
     * @param aWaybillnumber the new value for waybillnumber
     */
    public void setWaybillnumber(long aWaybillnumber) {
        waybillnumber = aWaybillnumber;
    }

    /**
     * Access method for issuedRoll.
     *
     * @return the current value of issuedRoll
     */
    public long getIssuedRoll() {
        return issuedRoll;
    }

    /**
     * Setter method for issuedRoll.
     *
     * @param aIssuedRoll the new value for issuedRoll
     */
    public void setIssuedRoll(long aIssuedRoll) {
        issuedRoll = aIssuedRoll;
    }

    /**
     * Access method for status.
     *
     * @return the current value of status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Setter method for status.
     *
     * @param aStatus the new value for status
     */
    public void setStatus(boolean aStatus) {
        status = aStatus;
    }

    /**
     * Access method for createdBy.
     *
     * @return the current value of createdBy
     */
    public long getCreatedBy() {
        return createdBy;
    }

    /**
     * Setter method for createdBy.
     *
     * @param aCreatedBy the new value for createdBy
     */
    public void setCreatedBy(long aCreatedBy) {
        createdBy = aCreatedBy;
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
     * Access method for wayBillDate.
     *
     * @return the current value of wayBillDate
     */
    public Calendar getWayBillDate() {
        return wayBillDate;
    }

    /**
     * Setter method for wayBillDate.
     *
     * @param aWayBillDate the new value for wayBillDate
     */
    public void setWayBillDate(Calendar aWayBillDate) {
        wayBillDate = aWayBillDate;
    }

    /**
     * Access method for issuedTickets.
     *
     * @return the current value of issuedTickets
     */
    public long getIssuedTickets() {
        return issuedTickets;
    }

    /**
     * Setter method for issuedTickets.
     *
     * @param aIssuedTickets the new value for issuedTickets
     */
    public void setIssuedTickets(long aIssuedTickets) {
        issuedTickets = aIssuedTickets;
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
     * Access method for tbldutyallocation.
     *
     * @return the current value of tbldutyallocation
     */
    public Tbldutyallocation getTbldutyallocation() {
        return tbldutyallocation;
    }

    /**
     * Setter method for tbldutyallocation.
     *
     * @param aTbldutyallocation the new value for tbldutyallocation
     */
    public void setTbldutyallocation(Tbldutyallocation aTbldutyallocation) {
        tbldutyallocation = aTbldutyallocation;
    }

    /**
     * Access method for tblcollection.
     *
     * @return the current value of tblcollection
     */
    public List<Tblcollection> getTblcollection() {
        return tblcollection;
    }

    /**
     * Setter method for tblcollection.
     *
     * @param aTblcollection the new value for tblcollection
     */
    public void setTblcollection(List<Tblcollection> aTblcollection) {
        tblcollection = aTblcollection;
    }

    /**
     * Access method for tbltransaction.
     *
     * @return the current value of tbltransaction
     */
    public List<Tbltransaction> getTbltransaction() {
        return tbltransaction;
    }

    /**
     * Setter method for tbltransaction.
     *
     * @param aTbltransaction the new value for tbltransaction
     */
    public void setTbltransaction(List<Tbltransaction> aTbltransaction) {
        tbltransaction = aTbltransaction;
    }

    
    /**
     * Compares the key for this instance with another Tblwaybill.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblwaybill and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblwaybill)) {
            return false;
        }
        Tblwaybill that = (Tblwaybill) other;
        if (this.getWaybillnumber() != that.getWaybillnumber()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblwaybill.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblwaybill)) return false;
        return this.equalKeys(other) && ((Tblwaybill)other).equalKeys(this);
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
        i = (int)(getWaybillnumber() ^ (getWaybillnumber()>>>32));
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
		return "Tblwaybill [waybillnumber=" + waybillnumber + ", issuedRoll=" + issuedRoll + ", status=" + status
				+ ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + ", wayBillDate=" + wayBillDate
				+ ", issuedTickets=" + issuedTickets + ", createdOn=" + createdOn + ", lastModifiedOn=" + lastModifiedOn
				+ ", tbldutyallocation=" + tbldutyallocation + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("waybillnumber", new Long(getWaybillnumber()));
        return ret;
    }

    /*
     * 
     * For adding the dependency of foreign key for Tbltransaction
     * 
     * */
        public void addTransaction(Tbltransaction transaction) {
            if (transaction != null) {
            	tbltransaction.add(transaction);
            	transaction.setTblwaybill(this);
            }
         }
       
        /*
         * 
         * For adding the dependency of foreign key for Tblcollection
         * 
         * */
            public void addCollection(Tblcollection collection) {
                if (collection != null) {
                	tblcollection.add(collection);
                	collection.setTblwaybill(this);
                }
             }
}
