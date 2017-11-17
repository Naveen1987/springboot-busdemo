package com.tmtu.allocation.repositories;



import com.tmtu.allocation.models.Tblwaybill;

public interface TmtuTblwaybillRepositoryCustom {

	
	public Tblwaybill save(
			Long dutyAllocationId,
			Long conductorId,
			String machineNumber,
			Long driverid,
			String busNumber,
			Long shiftType,
			Long issuedTickets,
			Long issuedRoll,
			Long createdBy
			);
	
	public String cancel(
			Long waywillnumber,
			Long modifiedby
			);
	
	public Tblwaybill complete(Long waywillnumber, 
			Long modifiedby);
	
}
