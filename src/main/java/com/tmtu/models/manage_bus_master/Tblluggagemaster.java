
package com.tmtu.models.manage_bus_master;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="tblluggagemaster")
public class Tblluggagemaster implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=19)
    private long luggageid;
    @Column(precision=19)
    private long startKm;
    @Column(precision=19)
    private long tillKm;
    @Column(precision=19)
    private double totalAmount;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar lastModifiedOn;
    @ManyToOne
    @JoinColumn(name="fareChartId",foreignKey=@ForeignKey(name="tblfarechartmaster_fareChartId_fk_1"))
    @JsonBackReference
    private Tblfarechartmaster tblfarechartmaster;

    /** Default constructor. */
    public Tblluggagemaster() {
        super();
    }

    /**
     * Access method for luggageid.
     *
     * @return the current value of luggageid
     */
    public long getLuggageid() {
        return luggageid;
    }

    /**
     * Setter method for luggageid.
     *
     * @param aLuggageid the new value for luggageid
     */
    public void setLuggageid(long aLuggageid) {
        luggageid = aLuggageid;
    }

    /**
     * Access method for startKm.
     *
     * @return the current value of startKm
     */
    public long getStartKm() {
        return startKm;
    }

    /**
     * Setter method for startKm.
     *
     * @param aStartKm the new value for startKm
     */
    public void setStartKm(long aStartKm) {
        startKm = aStartKm;
    }

    /**
     * Access method for tillKm.
     *
     * @return the current value of tillKm
     */
    public long getTillKm() {
        return tillKm;
    }

    /**
     * Setter method for tillKm.
     *
     * @param aTillKm the new value for tillKm
     */
    public void setTillKm(long aTillKm) {
        tillKm = aTillKm;
    }

    /**
     * Access method for totalAmount.
     *
     * @return the current value of totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Setter method for totalAmount.
     *
     * @param aTotalAmount the new value for totalAmount
     */
    public void setTotalAmount(double aTotalAmount) {
        totalAmount = aTotalAmount;
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
     * Access method for tblfarechartmaster.
     *
     * @return the current value of tblfarechartmaster
     */
    public Tblfarechartmaster getTblfarechartmaster() {
        return tblfarechartmaster;
    }

    /**
     * Setter method for tblfarechartmaster.
     *
     * @param aTblfarechartmaster the new value for tblfarechartmaster
     */
    public void setTblfarechartmaster(Tblfarechartmaster aTblfarechartmaster) {
        tblfarechartmaster = aTblfarechartmaster;
    }

    /**
     * Compares the key for this instance with another Tblluggagemaster.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblluggagemaster and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblluggagemaster)) {
            return false;
        }
        Tblluggagemaster that = (Tblluggagemaster) other;
        if (this.getLuggageid() != that.getLuggageid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblluggagemaster.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblluggagemaster)) return false;
        return this.equalKeys(other) && ((Tblluggagemaster)other).equalKeys(this);
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
        i = (int)(getLuggageid() ^ (getLuggageid()>>>32));
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
		return "Tblluggagemaster [luggageid=" + luggageid + ", startKm=" + startKm + ", tillKm=" + tillKm
				+ ", totalAmount=" + totalAmount + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn=" + lastModifiedOn + ", tblfarechartmaster="
				+ tblfarechartmaster + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("luggageid", new Long(getLuggageid()));
        return ret;
    }

}
