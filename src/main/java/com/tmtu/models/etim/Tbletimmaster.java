package com.tmtu.models.etim;

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
@Table(name="tbletimmaster", 
uniqueConstraints= {
		@UniqueConstraint(columnNames="imei",name="unique_imei")	
	},
indexes={@Index(name="tbletimmaster_imei_IX", columnList="imei")})

public class Tbletimmaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=19)
    private long etimid;
    @Column(nullable=false, length=45)
    private String imei;
    @Column(length=45)
    private String etimName;
    @Column(length=45)
    private String serialNumber;
    @Column(length=45)
    private String version;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    private boolean status;
    private Calendar lastModifiedOn;
    

    /** Default constructor. */
    public Tbletimmaster() {
        super();
    }

    /**
     * Access method for imei.
     *
     * @return the current value of imei
     */
    public String getImei() {
        return imei;
    }

    /**
     * Setter method for imei.
     *
     * @param aImei the new value for imei
     */
    public void setImei(String aImei) {
        imei = aImei;
    }

    /**
     * Access method for etimName.
     *
     * @return the current value of etimName
     */
    public String getEtimName() {
        return etimName;
    }

    /**
     * Setter method for etimName.
     *
     * @param aEtimName the new value for etimName
     */
    public void setEtimName(String aEtimName) {
        etimName = aEtimName;
    }

    /**
     * Access method for serialNumber.
     *
     * @return the current value of serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Setter method for serialNumber.
     *
     * @param aSerialNumber the new value for serialNumber
     */
    public void setSerialNumber(String aSerialNumber) {
        serialNumber = aSerialNumber;
    }

    /**
     * Access method for version.
     *
     * @return the current value of version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Setter method for version.
     *
     * @param aVersion the new value for version
     */
    public void setVersion(String aVersion) {
        version = aVersion;
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
     * Access method for etimid.
     *
     * @return the current value of etimid
     */
    public long getEtimid() {
        return etimid;
    }

    /**
     * Setter method for etimid.
     *
     * @param aEtimid the new value for etimid
     */
    public void setEtimid(long aEtimid) {
        etimid = aEtimid;
    }

    public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
     * Compares the key for this instance with another Tbletimmaster.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tbletimmaster and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tbletimmaster)) {
            return false;
        }
        Tbletimmaster that = (Tbletimmaster) other;
        if (this.getEtimid() != that.getEtimid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tbletimmaster.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tbletimmaster)) return false;
        return this.equalKeys(other) && ((Tbletimmaster)other).equalKeys(this);
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
        i = (int)(getEtimid() ^ (getEtimid()>>>32));
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
        StringBuffer sb = new StringBuffer("[Tbletimmaster |");
        sb.append(" etimid=").append(getEtimid());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("etimid", new Long(getEtimid()));
        return ret;
    }

}
