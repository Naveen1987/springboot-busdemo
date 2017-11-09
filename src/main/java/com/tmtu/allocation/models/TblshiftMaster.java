
package com.tmtu.allocation.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="tblshiftMaster")
public class TblshiftMaster implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long shiftId;
    @Column(name="ShiftType", precision=19)
    private long shiftType;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar lastModifiedOn;

    /** Default constructor. */
    public TblshiftMaster() {
        super();
    }

    /**
     * Access method for shiftId.
     *
     * @return the current value of shiftId
     */
    public long getShiftId() {
        return shiftId;
    }

    /**
     * Setter method for shiftId.
     *
     * @param aShiftId the new value for shiftId
     */
    public void setShiftId(long aShiftId) {
        shiftId = aShiftId;
    }

    /**
     * Access method for shiftType.
     *
     * @return the current value of shiftType
     */
    public long getShiftType() {
        return shiftType;
    }

    /**
     * Setter method for shiftType.
     *
     * @param aShiftType the new value for shiftType
     */
    public void setShiftType(long aShiftType) {
        shiftType = aShiftType;
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
     * Compares the key for this instance with another TblshiftMaster.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class TblshiftMaster and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof TblshiftMaster)) {
            return false;
        }
        TblshiftMaster that = (TblshiftMaster) other;
        if (this.getShiftId() != that.getShiftId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another TblshiftMaster.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TblshiftMaster)) return false;
        return this.equalKeys(other) && ((TblshiftMaster)other).equalKeys(this);
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
        i = (int)(getShiftId() ^ (getShiftId()>>>32));
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
		return "TblshiftMaster [shiftId=" + shiftId + ", shiftType=" + shiftType + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn="
				+ lastModifiedOn + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("shiftId", new Long(getShiftId()));
        return ret;
    }

}
