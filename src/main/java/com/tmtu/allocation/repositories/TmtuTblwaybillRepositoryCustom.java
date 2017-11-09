package com.tmtu.allocation.repositories;

import com.tmtu.allocation.models.Tblwaybill;

public interface TmtuTblwaybillRepositoryCustom {

	
	public Tblwaybill save(
			Long dutyAllocationId,
			Long issuedTickets,
			Long issuedRoll,
			Long createdBy
			);
	
	public Tblwaybill cancel(
			Long waywillnumber,
			Long modifiedby
			);
}
