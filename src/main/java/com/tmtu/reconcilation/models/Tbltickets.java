
package com.tmtu.reconcilation.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity(name="tbltickets")
public class Tbltickets implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ticketid;
    @Column(length=45)
    private String tickettype;
    @Column(precision=17, scale=17)
    private double fare;
    @Column(precision=19)
    private long createdby;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar createdOn;
    private Calendar lastModifiedOn;
    @ManyToOne
    @JoinColumn(name="transactionid",foreignKey=@ForeignKey(name="tbltransaction_transactionid_fk"))
    @JsonBackReference
    private Tbltransaction tbltransaction;

    /** Default constructor. */
    public Tbltickets() {
        super();
    }

    /**
     * Access method for ticketid.
     *
     * @return the current value of ticketid
     */
    public long getTicketid() {
        return ticketid;
    }

    /**
     * Setter method for ticketid.
     *
     * @param aTicketid the new value for ticketid
     */
    public void setTicketid(long aTicketid) {
        ticketid = aTicketid;
    }

    /**
     * Access method for tickettype.
     *
     * @return the current value of tickettype
     */
    public String getTickettype() {
        return tickettype;
    }

    /**
     * Setter method for tickettype.
     *
     * @param aTickettype the new value for tickettype
     */
    public void setTickettype(String aTickettype) {
        tickettype = aTickettype;
    }

    /**
     * Access method for fare.
     *
     * @return the current value of fare
     */
    public double getFare() {
        return fare;
    }

    /**
     * Setter method for fare.
     *
     * @param aFare the new value for fare
     */
    public void setFare(double aFare) {
        fare = aFare;
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
     * Access method for tbltransaction.
     *
     * @return the current value of tbltransaction
     */
    public Tbltransaction getTbltransaction() {
        return tbltransaction;
    }

    /**
     * Setter method for tbltransaction.
     *
     * @param aTbltransaction the new value for tbltransaction
     */
    public void setTbltransaction(Tbltransaction aTbltransaction) {
        tbltransaction = aTbltransaction;
    }

    /**
     * Compares the key for this instance with another Tbltickets.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tbltickets and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tbltickets)) {
            return false;
        }
        Tbltickets that = (Tbltickets) other;
        if (this.getTicketid() != that.getTicketid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tbltickets.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tbltickets)) return false;
        return this.equalKeys(other) && ((Tbltickets)other).equalKeys(this);
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
        i = (int)(getTicketid() ^ (getTicketid()>>>32));
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
		return "Tbltickets [ticketid=" + ticketid + ", tickettype=" + tickettype + ", fare=" + fare + ", createdby="
				+ createdby + ", lastModifiedBy=" + lastModifiedBy + ", createdOn=" + createdOn + ", lastModifiedOn="
				+ lastModifiedOn + ", tbltransaction=" + tbltransaction + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("ticketid", new Long(getTicketid()));
        return ret;
    }

}
