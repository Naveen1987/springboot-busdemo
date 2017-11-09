package com.tmtu.allocation.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.admin.models.Tbllogin;
import com.tmtu.admin.repositories.TmtuTblloginRepository;
import com.tmtu.allocation.models.Tbldutyallocation;
import com.tmtu.allocation.models.Tblwaybill;

public class TmtuTblwaybillRepositoryImpl  implements TmtuTblwaybillRepositoryCustom{

	@Autowired
	TmtuTblwaybillRepository tmtuTblwaybillRepository;
	
	@Autowired
	TmtuTbldutyallocationRepository tmtuTbldutyallocationRepository;
	
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository;
	
	private static final Logger logger=LoggerFactory.getLogger("Way Bill Repository");
	
	@Override
	public Tblwaybill save(Long dutyAllocationId, Long issuedTickets, Long issuedRoll, Long createdBy) {
		Tbllogin tbllogin=tmtuTblloginRepository.findOne(createdBy);
		if(tbllogin==null) {
			logger.error("Created by is not exists Id="+createdBy);
			return null;
		}
		Tbldutyallocation tbldutyallocation=tmtuTbldutyallocationRepository.findOne(dutyAllocationId);
		if(tbldutyallocation==null) {
			logger.error("Duty is not exists Id:"+dutyAllocationId);
			return null;
		}
		
		Tblwaybill tblwaybill=new Tblwaybill();
		tblwaybill.setWaybillnumber(dutyAllocationId);
		tblwaybill.setCreatedBy(createdBy);
		tblwaybill.setCreatedOn(Calendar.getInstance());
		tblwaybill.setIssuedRoll(issuedRoll);
		tblwaybill.setIssuedTickets(issuedTickets);
		tblwaybill.setStatus(true);
		tblwaybill.setWayBillDate(Calendar.getInstance());
		//Adding refrence
		tblwaybill.setTbldutyallocation(tbldutyallocation);
		//tbldutyallocation.addTblwaybill(tblwaybill);
		try {
			tblwaybill=tmtuTblwaybillRepository.save(tblwaybill);
			logger.info("Way will successfuly created:"+tblwaybill.getWaybillnumber());
			return tblwaybill;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Tblwaybill cancel(Long waywillnumber, Long modifiedby) {
		
		Tblwaybill tblwaybill=tmtuTblwaybillRepository.findOne(waywillnumber);
		if(tblwaybill==null) {
			logger.error("waybill don't exists Way will number is:"+waywillnumber);
			return null;
		}
		tblwaybill.setStatus(false);
		tblwaybill.setLastModifiedBy(modifiedby);
		tblwaybill.setLastModifiedOn(Calendar.getInstance());
		//Change in duty Models
		tblwaybill.getTbldutyallocation().setStatus(false);
		tblwaybill.getTbldutyallocation().setLastModifiedBy(modifiedby);
		tblwaybill.getTbldutyallocation().setLastModifiedOn(Calendar.getInstance());
		try {
			tblwaybill=tmtuTblwaybillRepository.save(tblwaybill);
			logger.info("Successfully canceled Way will Id:"+waywillnumber);
			return tblwaybill;
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
}
