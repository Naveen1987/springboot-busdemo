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
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="tblbusmaster",
indexes={
		@Index(name="tblbusmaster_BusNo_IX", columnList="BusNo")
},
uniqueConstraints= {
@UniqueConstraint(columnNames="busNo",name="BusNo_unique")		
}
		)
public class Tblbusmaster implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=19)
    private long busid;
    @Column(name="RegistedOn")
    private Calendar registedOn;
    @Column(name="BusNo", length=45)
    private String busNo;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar lastModifiedOn;
    @ManyToOne
    @JoinColumn(name="bustypeId",foreignKey=@ForeignKey(name="tblbustype_bustypeId_fk_1"))
    @JsonBackReference
    private Tblbustypemaster tblbustypemaster;

    /** Default constructor. */
    public Tblbusmaster() {
        super();
    }

    /**
     * Access method for busid.
     *
     * @return the current value of busid
     */
    public long getBusid() {
        return busid;
    }

    /**
     * Setter method for busid.
     *
     * @param aBusid the new value for busid
     */
    public void setBusid(long aBusid) {
        busid = aBusid;
    }

    /**
     * Access method for registedOn.
     *
     * @return the current value of registedOn
     */
    public Calendar getRegistedOn() {
        return registedOn;
    }

    /**
     * Setter method for registedOn.
     *
     * @param aRegistedOn the new value for registedOn
     */
    public void setRegistedOn(Calendar aRegistedOn) {
        registedOn = aRegistedOn;
    }

    /**
     * Access method for busNo.
     *
     * @return the current value of busNo
     */
    public String getBusNo() {
        return busNo;
    }

    /**
     * Setter method for busNo.
     *
     * @param aBusNo the new value for busNo
     */
    public void setBusNo(String aBusNo) {
        busNo = aBusNo;
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
     * Compares the key for this instance with another Tblbusmaster.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblbusmaster and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblbusmaster)) {
            return false;
        }
        Tblbusmaster that = (Tblbusmaster) other;
        if (this.getBusid() != that.getBusid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblbusmaster.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblbusmaster)) return false;
        return this.equalKeys(other) && ((Tblbusmaster)other).equalKeys(this);
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
        i = (int)(getBusid() ^ (getBusid()>>>32));
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
		return "Tblbusmaster [busid=" + busid + ", registedOn=" + registedOn + ", busNo=" + busNo + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn="
				+ lastModifiedOn + ", Tblbustypemaster=" + tblbustypemaster + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("busid", new Long(getBusid()));
        return ret;
    }

}
