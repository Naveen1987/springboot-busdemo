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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(
		name="tblconcessionmaster", 
		indexes={
				@Index(name="tblconcessionmaster_concessionCode_IX", columnList="concessionCode"),
				@Index(name="tblconcessionmaster_concessionname_ix", columnList="concessionName")
				},
		uniqueConstraints= {
				@UniqueConstraint(columnNames="concessionCode",name="concessioncode_unique")
		}
		)
public class Tblconcessionmaster implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=19)
    private long concessionid;
    @Column(length=45)
    private String concessionName;
    @Column(length=45)
    private String concessionCode;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar lastModifiedOn;
    @OneToMany(mappedBy="tblconcessionmaster",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
    @JsonManagedReference
    private List<Tblfarechartmaster> tblfarechartmaster=new ArrayList<Tblfarechartmaster>();

    /** Default constructor. */
    public Tblconcessionmaster() {
        super();
    }

    /**
     * Access method for concessionid.
     *
     * @return the current value of concessionid
     */
    public long getConcessionid() {
        return concessionid;
    }

    /**
     * Setter method for concessionid.
     *
     * @param aConcessionid the new value for concessionid
     */
    public void setConcessionid(long aConcessionid) {
        concessionid = aConcessionid;
    }

    /**
     * Access method for concessionName.
     *
     * @return the current value of concessionName
     */
    public String getConcessionName() {
        return concessionName;
    }

    /**
     * Setter method for concessionName.
     *
     * @param aConcessionName the new value for concessionName
     */
    public void setConcessionName(String aConcessionName) {
        concessionName = aConcessionName;
    }

    /**
     * Access method for concessionCode.
     *
     * @return the current value of concessionCode
     */
    public String getConcessionCode() {
        return concessionCode;
    }

    /**
     * Setter method for concessionCode.
     *
     * @param aConcessionCode the new value for concessionCode
     */
    public void setConcessionCode(String aConcessionCode) {
        concessionCode = aConcessionCode;
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
    public List<Tblfarechartmaster> getTblfarechartmaster() {
        return tblfarechartmaster;
    }

    /**
     * Setter method for tblfarechartmaster.
     *
     * @param aTblfarechartmaster the new value for tblfarechartmaster
     */
    public void setTblfarechartmaster(ArrayList<Tblfarechartmaster> aTblfarechartmaster) {
        tblfarechartmaster = aTblfarechartmaster;
    }

    /**
     * Compares the key for this instance with another Tblconcessionmaster.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblconcessionmaster and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblconcessionmaster)) {
            return false;
        }
        Tblconcessionmaster that = (Tblconcessionmaster) other;
        if (this.getConcessionid() != that.getConcessionid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblconcessionmaster.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblconcessionmaster)) return false;
        return this.equalKeys(other) && ((Tblconcessionmaster)other).equalKeys(this);
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
        i = (int)(getConcessionid() ^ (getConcessionid()>>>32));
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
		return "Tblconcessionmaster [concessionid=" + concessionid + ", concessionName=" + concessionName
				+ ", concessionCode=" + concessionCode + ", createdBy=" + createdBy + ", createdOn=" + createdOn
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
        ret.put("concessionid", new Long(getConcessionid()));
        return ret;
    }

    /*
     * For adding back reference 
     */
    

/*
 * 
 * For adding the dependency of foreign key for Tblfarechartmaster
 * 
 * */
    public void addTblfarechartmaster(Tblfarechartmaster tbl) {
        if (tbl != null) {
        	tblfarechartmaster.add(tbl);
        	tbl.setTblconcessionmaster(this);
        }
     }
}
