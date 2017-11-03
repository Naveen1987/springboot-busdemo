package com.tmtu.models;

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


@Entity(name="tbluserreporting")
public class Tbluserreporting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=19)
    private long userreportingid;
    private Calendar dateFrom;
    private Calendar dateTo;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar lastModifiedOn;
    @Column(precision=19)
    private long reportingTo;
       
    @ManyToOne
    @JoinColumn(name="loginId",foreignKey=@ForeignKey(name="tbllogin_userId_fk_1"))
    @JsonBackReference
    private Tbllogin loginId;
    
    /** Default constructor. */
    public Tbluserreporting() {
        super();
    }

    /**
     * Access method for userreportingid.
     *
     * @return the current value of userreportingid
     */
    public long getUserreportingid() {
        return userreportingid;
    }

    /**
     * Setter method for userreportingid.
     *
     * @param aUserreportingid the new value for userreportingid
     */
    public void setUserreportingid(long aUserreportingid) {
        userreportingid = aUserreportingid;
    }

    /**
     * Access method for dateFrom.
     *
     * @return the current value of dateFrom
     */
    public Calendar getDateFrom() {
        return dateFrom;
    }

    /**
     * Setter method for dateFrom.
     *
     * @param aDateFrom the new value for dateFrom
     */
    public void setDateFrom(Calendar aDateFrom) {
        dateFrom = aDateFrom;
    }

    /**
     * Access method for dateTo.
     *
     * @return the current value of dateTo
     */
    public Calendar getDateTo() {
        return dateTo;
    }

    /**
     * Setter method for dateTo.
     *
     * @param aDateTo the new value for dateTo
     */
    public void setDateTo(Calendar aDateTo) {
        dateTo = aDateTo;
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
     * Access method for reportingTo.
     *
     * @return the current value of reportingTo
     */
    public long getReportingTo() {
        return reportingTo;
    }

    /**
     * Setter method for reportingTo.
     *
     * @param aReportingTo the new value for reportingTo
     */
    public void setReportingTo(long aReportingTo) {
        reportingTo = aReportingTo;
    }
    /**
     * Setter method for loginId.
     *
     * @param aReportingTo the new value for loginId
     */
    public Tbllogin getLoginId() {
		return loginId;
	}
    /**
     * Setter method for loginId.
     *
     * @param aReportingTo the new value for loginId
     */
	public void setLoginId(Tbllogin loginId) {
		this.loginId = loginId;
	}

	/**
     * Compares the key for this instance with another Tbluserreporting.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tbluserreporting and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tbluserreporting)) {
            return false;
        }
        Tbluserreporting that = (Tbluserreporting) other;
        if (this.getUserreportingid() != that.getUserreportingid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tbluserreporting.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tbluserreporting)) return false;
        return this.equalKeys(other) && ((Tbluserreporting)other).equalKeys(this);
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
        i = (int)(getUserreportingid() ^ (getUserreportingid()>>>32));
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
		return "Tbluserreporting [userreportingid=" + userreportingid + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedOn=" + lastModifiedOn + ", reportingTo=" + reportingTo + ", loginId=" + loginId + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("userreportingid", new Long(getUserreportingid()));
        return ret;
    }

}
