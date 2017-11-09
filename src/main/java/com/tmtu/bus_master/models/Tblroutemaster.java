package com.tmtu.bus_master.models;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.ForeignKey;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="tblroutemaster",
uniqueConstraints= {
		@UniqueConstraint(columnNames="routeNumber",name="routeNumber_unique")
},
indexes={
		@Index(name="tblroutemaster_routeNumber_IX", columnList="routeNumber")
		}

)
public class Tblroutemaster implements Serializable {

 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=19)
    private long routeid;
    @Column(length=45)
    private String firstBusStopCode;
    @Column(precision=19)
    private long routeNumber;
    @Column(precision=19)
    private long totalStopCount;
    @Column(length=45)
    private String firstBusStopName;
    @Column(length=45)
    private String lastBusStopCode;
    @Column(length=45)
    private String lastBusStopName;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar lastModifiedOn;
    @ManyToOne
    @JoinColumn(name="busTypeId",foreignKey=@ForeignKey(name="tblbustype_bustypeId_fk_1"))
    @JsonBackReference
    private Tblbustypemaster tblbustypemaster;
    
    @OneToMany(mappedBy="tblroutemaster",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
    @JsonManagedReference
    private List<Tblstopmaster> tblstopmaster=new ArrayList<Tblstopmaster>();

    /** Default constructor. */
    public Tblroutemaster() {
        super();
    }

    /**
     * Access method for routeid.
     *
     * @return the current value of routeid
     */
    public long getRouteid() {
        return routeid;
    }

    /**
     * Setter method for routeid.
     *
     * @param aRouteid the new value for routeid
     */
    public void setRouteid(long aRouteid) {
        routeid = aRouteid;
    }

    /**
     * Access method for firstBusStopCode.
     *
     * @return the current value of firstBusStopCode
     */
    public String getFirstBusStopCode() {
        return firstBusStopCode;
    }

    /**
     * Setter method for firstBusStopCode.
     *
     * @param aFirstBusStopCode the new value for firstBusStopCode
     */
    public void setFirstBusStopCode(String aFirstBusStopCode) {
        firstBusStopCode = aFirstBusStopCode;
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
     * Access method for totalStopCount.
     *
     * @return the current value of totalStopCount
     */
    public long getTotalStopCount() {
        return totalStopCount;
    }

    /**
     * Setter method for totalStopCount.
     *
     * @param aTotalStopCount the new value for totalStopCount
     */
    public void setTotalStopCount(long aTotalStopCount) {
        totalStopCount = aTotalStopCount;
    }

    /**
     * Access method for firstusStopName.
     *
     * @return the current value of firstusStopName
     */
    public String getFirstBusStopName() {
        return firstBusStopName;
    }

    /**
     * Setter method for firstusStopName.
     *
     * @param aFirstusStopName the new value for firstusStopName
     */
    public void setFirstBusStopName(String aFirstBusStopName) {
        firstBusStopName = aFirstBusStopName;
    }

    /**
     * Access method for lastBusStopCode.
     *
     * @return the current value of lastBusStopCode
     */
    public String getLastBusStopCode() {
        return lastBusStopCode;
    }

    /**
     * Setter method for lastBusStopCode.
     *
     * @param aLastBusStopCode the new value for lastBusStopCode
     */
    public void setLastBusStopCode(String aLastBusStopCode) {
        lastBusStopCode = aLastBusStopCode;
    }

    /**
     * Access method for lastBusStopName.
     *
     * @return the current value of lastBusStopName
     */
    public String getLastBusStopName() {
        return lastBusStopName;
    }

    /**
     * Setter method for lastBusStopName.
     *
     * @param aLastBusStopName the new value for lastBusStopName
     */
    public void setLastBusStopName(String aLastBusStopName) {
        lastBusStopName = aLastBusStopName;
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
     * Access method for Tblbustypemaster.
     *
     * @return the current value of Tblbustypemaster
     */
    public Tblbustypemaster getTlbbustypemaster() {
        return tblbustypemaster;
    }

    /**
     * Setter method for Tblbustypemaster.
     *
     * @param aTlbbustypemaster the new value for Tblbustypemaster
     */
    public void setTlbbustypemaster(Tblbustypemaster aTlbbustypemaster) {
        tblbustypemaster = aTlbbustypemaster;
    }

    /**
     * Access method for tblstopmaster.
     *
     * @return the current value of tblstopmaster
     */
    public List<Tblstopmaster> getTblstopmaster() {
        return tblstopmaster;
    }

    /**
     * Setter method for tblstopmaster.
     *
     * @param aTblstopmaster the new value for tblstopmaster
     */
    public void setTblstopmaster(ArrayList<Tblstopmaster> aTblstopmaster) {
        tblstopmaster = aTblstopmaster;
    }

    /**
     * Compares the key for this instance with another Tblroutemaster.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblroutemaster and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblroutemaster)) {
            return false;
        }
        Tblroutemaster that = (Tblroutemaster) other;
        if (this.getRouteid() != that.getRouteid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblroutemaster.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblroutemaster)) return false;
        return this.equalKeys(other) && ((Tblroutemaster)other).equalKeys(this);
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
        i = (int)(getRouteid() ^ (getRouteid()>>>32));
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
		return "Tblroutemaster [routeid=" + routeid + ", firstBusStopCode=" + firstBusStopCode + ", routeNumber="
				+ routeNumber + ", totalStopCount=" + totalStopCount + ", firstusStopName=" + firstBusStopName
				+ ", lastBusStopCode=" + lastBusStopCode + ", lastBusStopName=" + lastBusStopName + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn="
				+ lastModifiedOn + ", Tblbustypemaster=" + tblbustypemaster + ", tblstopmaster=" + tblstopmaster + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("routeid", new Long(getRouteid()));
        return ret;
    }

    /*
     * For adding back reference 
     */
    
    /*
     * 
     * For adding the dependency of foreign key for Tblstopmaster
     * 
     * */
        public void addTblstopmaster(Tblstopmaster tbl) {
            if (tbl != null) {
            	tblstopmaster.add(tbl);
            	tbl.setTblroutemaster(this);
            }
         }
}
