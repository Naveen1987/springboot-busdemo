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


@Entity
@Table(name="tbldailypassmaster",
indexes= {
		@Index(columnList="dailyPassName",name="tbldailypassmaster_dailypassname_ix")
}
		)

public class Tbldailypassmaster implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=19)
    private long dailypassid;
    @Column(precision=19)
    private long dailyPassAmount;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar lastModifiedOn;
    private String dailyPassName;

    /** Default constructor. */
    public Tbldailypassmaster() {
        super();
    }

    /**
     * Access method for dailypassid.
     *
     * @return the current value of dailypassid
     */
    public long getDailypassid() {
        return dailypassid;
    }

    /**
     * Setter method for dailypassid.
     *
     * @param aDailypassid the new value for dailypassid
     */
    public void setDailypassid(long aDailypassid) {
        dailypassid = aDailypassid;
    }

    /**
     * Access method for dailyPassAmount.
     *
     * @return the current value of dailyPassAmount
     */
    public long getDailyPassAmount() {
        return dailyPassAmount;
    }

    /**
     * Setter method for dailyPassAmount.
     *
     * @param aDailyPassAmount the new value for dailyPassAmount
     */
    public void setDailyPassAmount(long aDailyPassAmount) {
        dailyPassAmount = aDailyPassAmount;
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
     * Access method for dailyPassName.
     *
     * @return the current value of dailyPassName
     */
    public String getDailyPassName() {
        return dailyPassName;
    }

    /**
     * Setter method for dailyPassName.
     *
     * @param aDailyPassName the new value for dailyPassName
     */
    public void setDailyPassName(String aDailyPassName) {
        dailyPassName = aDailyPassName;
    }

    /**
     * Compares the key for this instance with another Tbldailypassmaster.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tbldailypassmaster and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tbldailypassmaster)) {
            return false;
        }
        Tbldailypassmaster that = (Tbldailypassmaster) other;
        if (this.getDailypassid() != that.getDailypassid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tbldailypassmaster.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tbldailypassmaster)) return false;
        return this.equalKeys(other) && ((Tbldailypassmaster)other).equalKeys(this);
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
        i = (int)(getDailypassid() ^ (getDailypassid()>>>32));
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
		return "Tbldailypassmaster [dailypassid=" + dailypassid + ", dailyPassAmount=" + dailyPassAmount
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedOn=" + lastModifiedOn + ", dailyPassName=" + dailyPassName + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("dailypassid", new Long(getDailypassid()));
        return ret;
    }

}
