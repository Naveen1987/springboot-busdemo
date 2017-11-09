package com.tmtu.bus_master.models;

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


@Entity(name="tblstopmaster")
public class Tblstopmaster implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=19)
    private long stopid;
    @Column(precision=19)
    private long busStopNumber;
    @Column(length=45)
    private String busStopCode;
    @Column(length=45)
    private String busStopName;
    @Column(precision=19)
    private long km;
    @Column(precision=19)
    private long sequenceNumber;
    @Column(length=1)
    private boolean interStateStop;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar lastModifiedOn;
    
    @ManyToOne
    @JoinColumn(name="routeId",foreignKey=@ForeignKey(name="tblroutemaster_routeId_fk_1"))
    @JsonBackReference
    private Tblroutemaster tblroutemaster;

    /** Default constructor. */
    public Tblstopmaster() {
        super();
    }

    /**
     * Access method for stopid.
     *
     * @return the current value of stopid
     */
    public long getStopid() {
        return stopid;
    }

    /**
     * Setter method for stopid.
     *
     * @param aStopid the new value for stopid
     */
    public void setStopid(long aStopid) {
        stopid = aStopid;
    }

    /**
     * Access method for busStopNumber.
     *
     * @return the current value of busStopNumber
     */
    public long getBusStopNumber() {
        return busStopNumber;
    }

    /**
     * Setter method for busStopNumber.
     *
     * @param aBusStopNumber the new value for busStopNumber
     */
    public void setBusStopNumber(long aBusStopNumber) {
        busStopNumber = aBusStopNumber;
    }

    /**
     * Access method for busStopCode.
     *
     * @return the current value of busStopCode
     */
    public String getBusStopCode() {
        return busStopCode;
    }

    /**
     * Setter method for busStopCode.
     *
     * @param aBusStopCode the new value for busStopCode
     */
    public void setBusStopCode(String aBusStopCode) {
        busStopCode = aBusStopCode;
    }

    /**
     * Access method for busStopName.
     *
     * @return the current value of busStopName
     */
    public String getBusStopName() {
        return busStopName;
    }

    /**
     * Setter method for busStopName.
     *
     * @param aBusStopName the new value for busStopName
     */
    public void setBusStopName(String aBusStopName) {
        busStopName = aBusStopName;
    }

    /**
     * Access method for km.
     *
     * @return the current value of km
     */
    public long getKm() {
        return km;
    }

    /**
     * Setter method for km.
     *
     * @param aKm the new value for km
     */
    public void setKm(long aKm) {
        km = aKm;
    }

    /**
     * Access method for sequenceNumber.
     *
     * @return the current value of sequenceNumber
     */
    public long getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Setter method for sequenceNumber.
     *
     * @param aSequenceNumber the new value for sequenceNumber
     */
    public void setSequenceNumber(long aSequenceNumber) {
        sequenceNumber = aSequenceNumber;
    }

    /**
     * Access method for interStateStop.
     *
     * @return true if and only if interStateStop is currently true
     */
    public boolean getInterStateStop() {
        return interStateStop;
    }

    /**
     * Setter method for interStateStop.
     *
     * @param aInterStateStop the new value for interStateStop
     */
    public void setInterStateStop(boolean aInterStateStop) {
        interStateStop = aInterStateStop;
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
     * Access method for tblroutemaster.
     *
     * @return the current value of tblroutemaster
     */
    public Tblroutemaster getTblroutemaster() {
        return tblroutemaster;
    }

    /**
     * Setter method for tblroutemaster.
     *
     * @param aTblroutemaster the new value for tblroutemaster
     */
    public void setTblroutemaster(Tblroutemaster aTblroutemaster) {
        tblroutemaster = aTblroutemaster;
    }

    /**
     * Compares the key for this instance with another Tblstopmaster.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblstopmaster and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblstopmaster)) {
            return false;
        }
        Tblstopmaster that = (Tblstopmaster) other;
        if (this.getStopid() != that.getStopid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblstopmaster.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblstopmaster)) return false;
        return this.equalKeys(other) && ((Tblstopmaster)other).equalKeys(this);
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
        i = (int)(getStopid() ^ (getStopid()>>>32));
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
		return "Tblstopmaster [stopid=" + stopid + ", busStopNumber=" + busStopNumber + ", busStopCode=" + busStopCode
				+ ", busStopName=" + busStopName + ", km=" + km + ", sequenceNumber=" + sequenceNumber
				+ ", interStateStop=" + interStateStop + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn=" + lastModifiedOn + ", tblroutemaster="
				+ tblroutemaster + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("stopid", new Long(getStopid()));
        return ret;
    }

}
