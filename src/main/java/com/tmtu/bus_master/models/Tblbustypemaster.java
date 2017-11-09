
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
@Table(name="tblbustypemaster", 
indexes={
		@Index(name="tblbustypemaster_servicetypeCode_IX", columnList="servicetypeCode"),
		@Index(name="tblbustypemaster_serviceTypeName_IX", columnList="serviceTypeName")
		},
uniqueConstraints= {
		@UniqueConstraint(columnNames="servicetypeCode",name="servicetypeCode_unique")
		}
		)
public class Tblbustypemaster implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=19)
    private long bustypeid;
    @Column(length=45)
    private String serviceTypeName;
    @Column(unique=true, length=45)
    private String servicetypeCode;
    @Column(precision=19)
    private long createdBy;
    private Calendar createdOn;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar lastModifiedOn;
   
    @OneToMany(mappedBy="tblbustypemaster",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
    @JsonManagedReference
    private List<Tblroutemaster> tblroutemaster=new ArrayList<Tblroutemaster>();
   
    @OneToMany(mappedBy="tblbustypemaster",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
    @JsonManagedReference
    private List<Tblfarechartmaster> tblfarechartmaster=new ArrayList<Tblfarechartmaster>();
    
    @OneToMany(mappedBy="tblbustypemaster",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
    @JsonManagedReference
    private List<Tblbusmaster> tblbusmaster=new ArrayList<Tblbusmaster>();

    /** Default constructor. */
    public Tblbustypemaster() {
        super();
    }

    /**
     * Access method for bustypeid.
     *
     * @return the current value of bustypeid
     */
    public long getBustypeid() {
        return bustypeid;
    }

    /**
     * Setter method for bustypeid.
     *
     * @param aBustypeid the new value for bustypeid
     */
    public void setBustypeid(long aBustypeid) {
        bustypeid = aBustypeid;
    }

    /**
     * Access method for serviceTypeName.
     *
     * @return the current value of serviceTypeName
     */
    public String getServiceTypeName() {
        return serviceTypeName;
    }

    /**
     * Setter method for serviceTypeName.
     *
     * @param aServiceTypeName the new value for serviceTypeName
     */
    public void setServiceTypeName(String aServiceTypeName) {
        serviceTypeName = aServiceTypeName;
    }

    /**
     * Access method for servicetypeCode.
     *
     * @return the current value of servicetypeCode
     */
    public String getServicetypeCode() {
        return servicetypeCode;
    }

    /**
     * Setter method for servicetypeCode.
     *
     * @param aServicetypeCode the new value for servicetypeCode
     */
    public void setServicetypeCode(String aServicetypeCode) {
        servicetypeCode = aServicetypeCode;
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
    public List<Tblroutemaster> getTblroutemaster() {
        return tblroutemaster;
    }

    /**
     * Setter method for tblroutemaster.
     *
     * @param aTblroutemaster the new value for tblroutemaster
     */
    public void setTblroutemaster(ArrayList<Tblroutemaster> aTblroutemaster) {
        tblroutemaster = aTblroutemaster;
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
     * ArrayListter method for tblfarechartmaster.
     *
     * @param aTblfarechartmaster the new value for tblfarechartmaster
     */
    public void setTblfarechartmaster(ArrayList<Tblfarechartmaster> aTblfarechartmaster) {
        tblfarechartmaster = aTblfarechartmaster;
    }

    /**
     * Access method for tblbusmaster.
     *
     * @return the current value of tblbusmaster
     */
    public List<Tblbusmaster> getTblbusmaster() {
        return tblbusmaster;
    }

    /**
     * Setter method for tblbusmaster.
     *
     * @param aTblbusmaster the new value for tblbusmaster
     */
    public void setTblbusmaster(ArrayList<Tblbusmaster> aTblbusmaster) {
        tblbusmaster = aTblbusmaster;
    }

    /**
     * Compares the key for this instance with another Tblbustypemaster.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblbustypemaster and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblbustypemaster)) {
            return false;
        }
        Tblbustypemaster that = (Tblbustypemaster) other;
        if (this.getBustypeid() != that.getBustypeid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblbustypemaster.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblbustypemaster)) return false;
        return this.equalKeys(other) && ((Tblbustypemaster)other).equalKeys(this);
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
        i = (int)(getBustypeid() ^ (getBustypeid()>>>32));
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
		return "Tblbustypemaster [bustypeid=" + bustypeid + ", serviceTypeName=" + serviceTypeName
				+ ", servicetypeCode=" + servicetypeCode + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn=" + lastModifiedOn + ", tblroutemaster="
				+ tblroutemaster + ", tblfarechartmaster=" + tblfarechartmaster + ", tblbusmaster=" + tblbusmaster
				+ "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("bustypeid", new Long(getBustypeid()));
        return ret;
    }

    /*
     * For adding back reference 
     */
   
    /*
     * 
     * For adding the dependency of foreign key for Tblroutemaster
     * 
     * */
        public void addTblroutemaster(Tblroutemaster tbl) {
            if (tbl != null) {
            	tblroutemaster.add(tbl);
            	tbl.setTlbbustypemaster(this);
            }
         }
      
     /*
         * 
         * For adding the dependency of foreign key for Tblfarechartmaster
         * 
         * */
            public void addTblfarechartmaster(Tblfarechartmaster tbl) {
                if (tbl != null) {
                	tblfarechartmaster.add(tbl);
                	tbl.setTlbbustypemaster(this);
                }
             }
            
       /*
             * 
             * For adding the dependency of foreign key for Tblbusmaster
             * 
             * */
                public void addTblbusmaster(Tblbusmaster tbl) {
                    if (tbl != null) {
                    	tblbusmaster.add(tbl);
                    	tbl.setTlbbustypemaster(this);
                    }
                 }
             
}
