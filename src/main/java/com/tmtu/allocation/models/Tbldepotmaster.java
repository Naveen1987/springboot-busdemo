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
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="tbldepotmaster",
uniqueConstraints= {
		@UniqueConstraint(columnNames="depotcode",name="unquie_depotcode")
},
indexes={@Index(name="tbldepotmaster_depotcode_IX", columnList="depotcode")})
public class Tbldepotmaster implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long depotId;
    @Column(nullable=false, length=45)
    private String depotcode;
    @Column(length=45)
    private String depotName;
    @Column(precision=19)
    private long lastModifiedBy;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    private Calendar lastModifiedOn;

    /** Default constructor. */
    public Tbldepotmaster() {
        super();
    }

    /**
     * Access method for depotId.
     *
     * @return the current value of depotId
     */
    public long getDepotId() {
        return depotId;
    }

    /**
     * Setter method for depotId.
     *
     * @param aDepotId the new value for depotId
     */
    public void setDepotId(long aDepotId) {
        depotId = aDepotId;
    }

    /**
     * Access method for depotcode.
     *
     * @return the current value of depotcode
     */
    public String getDepotcode() {
        return depotcode;
    }

    /**
     * Setter method for depotcode.
     *
     * @param aDepotcode the new value for depotcode
     */
    public void setDepotcode(String aDepotcode) {
        depotcode = aDepotcode;
    }

    /**
     * Access method for depotName.
     *
     * @return the current value of depotName
     */
    public String getDepotName() {
        return depotName;
    }

    /**
     * Setter method for depotName.
     *
     * @param aDepotName the new value for depotName
     */
    public void setDepotName(String aDepotName) {
        depotName = aDepotName;
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
     * Compares the key for this instance with another Tbldepotmaster.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tbldepotmaster and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tbldepotmaster)) {
            return false;
        }
        Tbldepotmaster that = (Tbldepotmaster) other;
        if (this.getDepotId() != that.getDepotId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tbldepotmaster.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tbldepotmaster)) return false;
        return this.equalKeys(other) && ((Tbldepotmaster)other).equalKeys(this);
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
        i = (int)(getDepotId() ^ (getDepotId()>>>32));
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
		return "Tbldepotmaster [depotId=" + depotId + ", depotcode=" + depotcode + ", depotName=" + depotName
				+ ", lastModifiedBy=" + lastModifiedBy + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", lastModifiedOn=" + lastModifiedOn + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("depotId", new Long(getDepotId()));
        return ret;
    }

}
