package com.tmtu.allocation.repositories;

import com.tmtu.allocation.models.TblshiftMaster;

public interface TmtuTblshiftMasterRepositoryCustom {

	public TblshiftMaster save(Long shiftType, Long createdBy);
	
}
