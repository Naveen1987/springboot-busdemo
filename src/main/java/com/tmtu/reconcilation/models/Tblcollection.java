
package com.tmtu.reconcilation.models;

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
import com.tmtu.allocation.models.Tblwaybill;
@Entity(name="tblcollection")
public class Tblcollection implements Serializable {

  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long collectionid;
    @Column(precision=17, scale=17)
    private double dueamount;
    @Column(precision=17, scale=17)
    private double actualamount;
    @Column(precision=17, scale=17)
    private double balanceamount;
    @Column(length=45)
    private String expensestype;
    @Column(precision=17, scale=17)
    private double expenseamount;
    @Column(precision=19)
    private long createdBy;
    @Column(precision=19)
    private long lastModifiedBy;
    private Calendar createdOn;
    private Calendar lastModifiedOn;
    @ManyToOne
    @JoinColumn(name="waybillid",foreignKey=@ForeignKey(name="tblwaybill_waybillid"))
    @JsonBackReference
    private Tblwaybill tblwaybill;

    /** Default constructor. */
    public Tblcollection() {
        super();
    }

    /**
     * Access method for collectionid.
     *
     * @return the current value of collectionid
     */
    public long getCollectionid() {
        return collectionid;
    }

    /**
     * Setter method for collectionid.
     *
     * @param aCollectionid the new value for collectionid
     */
    public void setCollectionid(long aCollectionid) {
        collectionid = aCollectionid;
    }

    /**
     * Access method for dueamount.
     *
     * @return the current value of dueamount
     */
    public double getDueamount() {
        return dueamount;
    }

    /**
     * Setter method for dueamount.
     *
     * @param aDueamount the new value for dueamount
     */
    public void setDueamount(double aDueamount) {
        dueamount = aDueamount;
    }

    /**
     * Access method for actualamount.
     *
     * @return the current value of actualamount
     */
    public double getActualamount() {
        return actualamount;
    }

    /**
     * Setter method for actualamount.
     *
     * @param aActualamount the new value for actualamount
     */
    public void setActualamount(double aActualamount) {
        actualamount = aActualamount;
    }

    /**
     * Access method for balanceamount.
     *
     * @return the current value of balanceamount
     */
    public double getBalanceamount() {
        return balanceamount;
    }

    /**
     * Setter method for balanceamount.
     *
     * @param aBalanceamount the new value for balanceamount
     */
    public void setBalanceamount(double aBalanceamount) {
        balanceamount = aBalanceamount;
    }

    /**
     * Access method for expensestype.
     *
     * @return the current value of expensestype
     */
    public String getExpensestype() {
        return expensestype;
    }

    /**
     * Setter method for expensestype.
     *
     * @param aExpensestype the new value for expensestype
     */
    public void setExpensestype(String aExpensestype) {
        expensestype = aExpensestype;
    }

    /**
     * Access method for expenseamount.
     *
     * @return the current value of expenseamount
     */
    public double getExpenseamount() {
        return expenseamount;
    }

    /**
     * Setter method for expenseamount.
     *
     * @param aExpenseamount the new value for expenseamount
     */
    public void setExpenseamount(double aExpenseamount) {
        expenseamount = aExpenseamount;
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
     * Access method for tblwaybill.
     *
     * @return the current value of tblwaybill
     */
    public Tblwaybill getTblwaybill() {
        return tblwaybill;
    }

    /**
     * Setter method for tblwaybill.
     *
     * @param aTblwaybill the new value for tblwaybill
     */
    public void setTblwaybill(Tblwaybill aTblwaybill) {
        tblwaybill = aTblwaybill;
    }

    /**
     * Compares the key for this instance with another Tblcollection.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tblcollection and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tblcollection)) {
            return false;
        }
        Tblcollection that = (Tblcollection) other;
        if (this.getCollectionid() != that.getCollectionid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tblcollection.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tblcollection)) return false;
        return this.equalKeys(other) && ((Tblcollection)other).equalKeys(this);
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
        i = (int)(getCollectionid() ^ (getCollectionid()>>>32));
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
		return "Tblcollection [collectionid=" + collectionid + ", dueamount=" + dueamount + ", actualamount="
				+ actualamount + ", balanceamount=" + balanceamount + ", expensestype=" + expensestype
				+ ", expenseamount=" + expenseamount + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy
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
        ret.put("collectionid", new Long(getCollectionid()));
        return ret;
    }

}
