package com.tmtu.reconcilation.repositories;

import com.tmtu.reconcilation.models.Tblcollection;

public interface TmtuTblcollectionRepositoryCustom {
 public Tblcollection save(
		 Long waybillid,
		 Double dueamount,
		 Double actualamount,
		 Double balanceamount,
		 String expensestype,
		 Double expenseamount,
		 Long createdby
		 );
}
