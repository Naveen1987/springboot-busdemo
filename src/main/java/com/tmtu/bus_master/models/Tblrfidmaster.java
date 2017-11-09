package com.tmtu.bus_master.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="tblrfidmaster",
indexes={
		@Index(name="tblrfidmaster_keys_IX", columnList="keys")
		},
uniqueConstraints= {
		@UniqueConstraint(columnNames="keys",name="keys_unique")
}
		)
public class Tblrfidmaster implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=19)
    private long rfidmasterid;
    @Column(length=45)
    private String keys;
    @Column(length=1)
    private boolean status;
    @Column(precision=17, scale=17)
    private double amount;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar lastModifiedOn;

    /** Default constructor. */
    public Tblrfidmaster() {
        super();
    }

    /**
     * Access method for rfidmasterid.
     *
     * @return the current value of rfidmasterid
     */
    public long getRfidmasterid() {
        return rfidmasterid;
    }

    /**
     * Setter method for rfidmasterid.
     *
     * @param aRfidmasterid the new value for rfidmasterid
     */
    public void setRfidmasterid(long aRfidmasterid) {
        rfidmasterid = aRfidmasterid;
    }

    /**
     * Access method for keys.
     *
     * @return the current value of keys
     */
    public String getKeys() {
        return keys;
    }

    /**
     * Setter method for keys.
     *
     * @param aKeys the new value for keys
     */
    public void setKeys(String aKeys) {
        keys = aKeys;
    }

    /**
     * Access method for status.
     *
     * @return true if and only if status is currently true
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
     * Access method for amount.
     *
     * @return the current value of amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter method for amount.
     *
     * @param aAmount the new value for amount
     */
    public void setAmount(double aAmount) {
        amount = aAmount;
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
     * Compares the key for this instance with another Tblrfidmaster.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblrfidmaster and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblrfidmaster)) {
            return false;
        }
        Tblrfidmaster that = (Tblrfidmaster) other;
        if (this.getRfidmasterid() != that.getRfidmasterid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblrfidmaster.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblrfidmaster)) return false;
        return this.equalKeys(other) && ((Tblrfidmaster)other).equalKeys(this);
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
        i = (int)(getRfidmasterid() ^ (getRfidmasterid()>>>32));
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
		return "Tblrfidmaster [rfidmasterid=" + rfidmasterid + ", keys=" + keys + ", status=" + status + ", amount="
				+ amount + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastModifiedBy="
				+ lastModifiedBy + ", lastModifiedOn=" + lastModifiedOn + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("rfidmasterid", new Long(getRfidmasterid()));
        return ret;
    }

}
