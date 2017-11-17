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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="tbldutyallocation",
		indexes= {
		@Index(columnList="dutyallocationid",name="dutyallocation_ix")
})
public class Tbldutyallocation implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long dutyallocationid;
    @Column(precision=19)
    private long conductorId;
    @Column(precision=19)
    private long routeNumber;
    @Column(length=45)
    private String machineNumber;
    @Column(length=45)
    private String startStoppage;
    @Column(length=45)
    private String endStoppage;
    @Column(length=45)
    private String depotcode;
    @Column(length=45)
    private String depotName;
    @Column(length=45)
    private String busNumber;
    @Column(name="ShiftType", precision=19)
    private long shiftType;
    /** Status value
     * 1- create
     * 2- cancel
     * 3- complete
     */
    @Column(precision=19)
    private long status;
    @Column(precision=19)
    private long driverid;
    @Column(precision=19)
    private long createdBy;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar fromDate;
    private Calendar toDate;
    
    @Column(length=45)
    private Calendar startTime;
    @Column(length=45)
    private Calendar endTime;
    private Calendar createdOn;
    private Calendar lastModifiedOn;
    
    @OneToMany(mappedBy="tbldutyallocation",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
    @JsonManagedReference
    private List<Tblwaybill> tblwaybill=new ArrayList<Tblwaybill>();

    /** Default constructor. */
    public Tbldutyallocation() {
        super();
    }

    /**
     * Access method for dutyallocationid.
     *
     * @return the current value of dutyallocationid
     */
    public long getDutyallocationid() {
        return dutyallocationid;
    }

    /**
     * Setter method for dutyallocationid.
     *
     * @param aDutyallocationid the new value for dutyallocationid
     */
    public void setDutyallocationid(long aDutyallocationid) {
        dutyallocationid = aDutyallocationid;
    }

    /**
     * Access method for conductorId.
     *
     * @return the current value of conductorId
     */
    public long getConductorId() {
        return conductorId;
    }

    /**
     * Setter method for conductorId.
     *
     * @param aConductorId the new value for conductorId
     */
    public void setConductorId(long aConductorId) {
        conductorId = aConductorId;
    }

    /**
     * Access method for routeNumber.
     *
     * @return the current value of routeNumber
     */
    public long getRouteNumber() {
        return routeNumber;
    }

    /**
     * Setter method for routeNumber.
     *
     * @param aRouteNumber the new value for routeNumber
     */
    public void setRouteNumber(long aRouteNumber) {
        routeNumber = aRouteNumber;
    }

    /**
     * Access method for machineNumber.
     *
     * @return the current value of machineNumber
     */
    public String getMachineNumber() {
        return machineNumber;
    }

    /**
     * Setter method for machineNumber.
     *
     * @param aMachineNumber the new value for machineNumber
     */
    public void setMachineNumber(String aMachineNumber) {
        machineNumber = aMachineNumber;
    }

    /**
     * Access method for startStoppage.
     *
     * @return the current value of startStoppage
     */
    public String getStartStoppage() {
        return startStoppage;
    }

    /**
     * Setter method for startStoppage.
     *
     * @param aStartStoppage the new value for startStoppage
     */
    public void setStartStoppage(String aStartStoppage) {
        startStoppage = aStartStoppage;
    }

    /**
     * Access method for endStoppage.
     *
     * @return the current value of endStoppage
     */
    public String getEndStoppage() {
        return endStoppage;
    }

    /**
     * Setter method for endStoppage.
     *
     * @param aEndStoppage the new value for endStoppage
     */
    public void setEndStoppage(String aEndStoppage) {
        endStoppage = aEndStoppage;
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
     * Access method for busNumber.
     *
     * @return the current value of busNumber
     */
    public String getBusNumber() {
        return busNumber;
    }

    /**
     * Setter method for busNumber.
     *
     * @param aBusNumber the new value for busNumber
     */
    public void setBusNumber(String aBusNumber) {
        busNumber = aBusNumber;
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
     * Access method for status.
     *
     * @return the current value of status
     */
    public long getStatus() {
        return status;
    }

    /**
     * Setter method for status.
     *
     * @param aStatus the new value for status
     */
    public void setStatus(long aStatus) {
        status = aStatus;
    }

    /**
     * Access method for driverid.
     *
     * @return the current value of driverid
     */
    public long getDriverid() {
        return driverid;
    }

    /**
     * Setter method for driverid.
     *
     * @param aDriverid the new value for driverid
     */
    public void setDriverid(long aDriverid) {
        driverid = aDriverid;
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
     * Access method for fromDate.
     *
     * @return the current value of fromDate
     */
    public Calendar getFromDate() {
        return fromDate;
    }

    /**
     * Setter method for fromDate.
     *
     * @param aFromDate the new value for fromDate
     */
    public void setFromDate(Calendar aFromDate) {
        fromDate = aFromDate;
    }

    /**
     * Access method for toDate.
     *
     * @return the current value of toDate
     */
    public Calendar getToDate() {
        return toDate;
    }

    /**
     * Setter method for toDate.
     *
     * @param aToDate the new value for toDate
     */
    public void setToDate(Calendar aToDate) {
        toDate = aToDate;
    }

    /**
     * Access method for startTime.
     *
     * @return the current value of startTime
     */
    public Calendar getStartTime() {
        return startTime;
    }

    /**
     * Setter method for startTime.
     *
     * @param aStartTime the new value for startTime
     */
    public void setStartTime(Calendar aStartTime) {
        startTime = aStartTime;
    }

    /**
     * Access method for endTime.
     *
     * @return the current value of endTime
     */
    public Calendar getEndTime() {
        return endTime;
    }

    /**
     * Setter method for endTime.
     *
     * @param aEndTime the new value for endTime
     */
    public void setEndTime(Calendar aEndTime) {
        endTime = aEndTime;
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
     * Access method for tblwaybill.
     *
     * @return the current value of tblwaybill
     */
    public List<Tblwaybill> getTblwaybill() {
        return tblwaybill;
    }

    /**
     * Setter method for tblwaybill.
     *
     * @param aTblwaybill the new value for tblwaybill
     */
    public void setTblwaybill(List<Tblwaybill> aTblwaybill) {
        tblwaybill = aTblwaybill;
    }

    /**
     * Compares the key for this instance with another Tbldutyallocation.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tbldutyallocation and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tbldutyallocation)) {
            return false;
        }
        Tbldutyallocation that = (Tbldutyallocation) other;
        if (this.getDutyallocationid() != that.getDutyallocationid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tbldutyallocation.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tbldutyallocation)) return false;
        return this.equalKeys(other) && ((Tbldutyallocation)other).equalKeys(this);
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
        i = (int)(getDutyallocationid() ^ (getDutyallocationid()>>>32));
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
		return "Tbldutyallocation [dutyallocationid=" + dutyallocationid + ", conductorId=" + conductorId
				+ ", routeNumber=" + routeNumber + ", machineNumber=" + machineNumber + ", startStoppage="
				+ startStoppage + ", endStoppage=" + endStoppage + ", depotcode=" + depotcode + ", depotName="
				+ depotName + ", busNumber=" + busNumber + ", shiftType=" + shiftType + ", status=" + status
				+ ", driverid=" + driverid + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", createdOn=" + createdOn + ", lastModifiedOn=" + lastModifiedOn + ", tblwaybill=" + tblwaybill
				+ "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("dutyallocationid", new Long(getDutyallocationid()));
        return ret;
    }

    
    /*
     * 
     * For adding the dependency of foreign key for Tblwaybill
     * 
     * */
        public void addTblwaybill(Tblwaybill waybill) {
            if (waybill != null) {
            	tblwaybill.add(waybill);
            	waybill.setTbldutyallocation(this);
            }
         }
}
