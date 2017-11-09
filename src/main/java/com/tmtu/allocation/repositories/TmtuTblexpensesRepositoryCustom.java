package com.tmtu.allocation.repositories;

import com.tmtu.allocation.models.Tblexpenses;

public interface TmtuTblexpensesRepositoryCustom {

	public Tblexpenses save(String expensetype,Long createdBy);
	
}
