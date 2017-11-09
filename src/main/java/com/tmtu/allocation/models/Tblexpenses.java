package com.tmtu.allocation.models;

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
@Table(name="tblexpenses",
uniqueConstraints= {
		@UniqueConstraint(columnNames="expensetype",name="unique_expenses")
}
, indexes={@Index(name="tblexpenses_expensetype_IX", columnList="expensetype")})
public class Tblexpenses implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long expenseid;
    @Column(length=45)
    private String expensetype;
    @Column(precision=19)
    private long createdBy;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar createdOn;
    private Calendar lastModifiedOn;

    /** Default constructor. */
    public Tblexpenses() {
        super();
    }

    /**
     * Access method for expenseid.
     *
     * @return the current value of expenseid
     */
    public long getExpenseid() {
        return expenseid;
    }

    /**
     * Setter method for expenseid.
     *
     * @param aExpenseid the new value for expenseid
     */
    public void setExpenseid(long aExpenseid) {
        expenseid = aExpenseid;
    }

    /**
     * Access method for expensetype.
     *
     * @return the current value of expensetype
     */
    public String getExpensetype() {
        return expensetype;
    }

    /**
     * Setter method for expensetype.
     *
     * @param aExpensetype the new value for expensetype
     */
    public void setExpensetype(String aExpensetype) {
        expensetype = aExpensetype;
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
     * Compares the key for this instance with another Tblexpenses.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblexpenses and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblexpenses)) {
            return false;
        }
        Tblexpenses that = (Tblexpenses) other;
        if (this.getExpenseid() != that.getExpenseid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblexpenses.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblexpenses)) return false;
        return this.equalKeys(other) && ((Tblexpenses)other).equalKeys(this);
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
        i = (int)(getExpenseid() ^ (getExpenseid()>>>32));
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
		return "Tblexpenses [expenseid=" + expenseid + ", expensetype=" + expensetype + ", createdBy=" + createdBy
				+ ", lastModifiedBy=" + lastModifiedBy + ", createdOn=" + createdOn + ", lastModifiedOn="
				+ lastModifiedOn + "]";
	}

	/**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("expenseid", new Long(getExpenseid()));
        return ret;
    }

}
