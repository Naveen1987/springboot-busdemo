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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name="tblfarechartmaster")
public class Tblfarechartmaster implements Serializable {

  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=19)
    private long farechartid;
    @Column(precision=19)
    private long startKm;
    @Column(precision=19)
    private long tillKm;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    @Column(precision=17, scale=17)
    private double totalAmount;   
    
    private Calendar lastModifiedOn;
    @ManyToOne
    @JoinColumn(name="busTypeId",foreignKey=@ForeignKey(name="tblbustype_bustypeId_fk_1"))
    @JsonBackReference
    private Tblbustypemaster tblbustypemaster;
   
    @ManyToOne
    @JoinColumn(name="concessionId",foreignKey=@ForeignKey(name="tblconcessionmaster_concessionId_fk_2"))
    @JsonBackReference
    private Tblconcessionmaster tblconcessionmaster;
   
    @OneToMany(mappedBy="tblfarechartmaster",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
    @JsonManagedReference
    private List<Tblluggagemaster> tblluggagemaster=new ArrayList<Tblluggagemaster>();

    /** Default constructor. */
    public Tblfarechartmaster() {
        super();
    }

    /**
     * Access method for farechartid.
     *
     * @return the current value of farechartid
     */
    public long getFarechartid() {
        return farechartid;
    }

    /**
     * Setter method for farechartid.
     *
     * @param aFarechartid the new value for farechartid
     */
    public void setFarechartid(long aFarechartid) {
        farechartid = aFarechartid;
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
     * Access method for TotalAmount.
     *
     * @return the current value of TotalAmount
     */
    public double getTotalAmount() {
		return totalAmount;
	}

    /**
     * Setter method for TotalAmount.
     *
     * @param aLastModifiedOn the new value for TotalAmount
     */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
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
     * Access method for tblconcessionmaster.
     *
     * @return the current value of tblconcessionmaster
     */
    public Tblconcessionmaster getTblconcessionmaster() {
        return tblconcessionmaster;
    }

    /**
     * Setter method for tblconcessionmaster.
     *
     * @param aTblconcessionmaster the new value for tblconcessionmaster
     */
    public void setTblconcessionmaster(Tblconcessionmaster aTblconcessionmaster) {
        tblconcessionmaster = aTblconcessionmaster;
    }

    /**
     * Access method for tblluggagemaster.
     *
     * @return the current value of tblluggagemaster
     */
    public List<Tblluggagemaster> getTblluggagemaster() {
        return tblluggagemaster;
    }

    /**
     * Setter method for tblluggagemaster.
     *
     * @param aTblluggagemaster the new value for tblluggagemaster
     */
    public void setTblluggagemaster(ArrayList<Tblluggagemaster> aTblluggagemaster) {
        tblluggagemaster = aTblluggagemaster;
    }

    /**
     * Compares the key for this instance with another Tblfarechartmaster.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblfarechartmaster and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblfarechartmaster)) {
            return false;
        }
        Tblfarechartmaster that = (Tblfarechartmaster) other;
        if (this.getFarechartid() != that.getFarechartid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblfarechartmaster.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblfarechartmaster)) return false;
        return this.equalKeys(other) && ((Tblfarechartmaster)other).equalKeys(this);
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
        i = (int)(getFarechartid() ^ (getFarechartid()>>>32));
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
		return "Tblfarechartmaster [farechartid=" + farechartid + ", startKm=" + startKm + ", tillKm=" + tillKm
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy
				+ ", totalAmount=" + totalAmount + ", lastModifiedOn=" + lastModifiedOn + ", tblbustypemaster="
				+ tblbustypemaster + ", tblconcessionmaster=" + tblconcessionmaster + ", tblluggagemaster="
				+ tblluggagemaster + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("farechartid", new Long(getFarechartid()));
        return ret;
    }

    /*
     * For adding back reference 
     */
    

/*
 * 
 * For adding the dependency of foreign key for Tblluggagemaster
 * 
 * */
    public void addTblluggagemaster(Tblluggagemaster tbl) {
        if (tbl != null) {
        	tblluggagemaster.add(tbl);
        	tbl.setTblfarechartmaster(this);
        }
     }
}
