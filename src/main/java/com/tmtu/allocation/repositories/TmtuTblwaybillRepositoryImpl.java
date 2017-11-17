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
	public Tblwaybill save(Long dutyAllocationId,
			Long conductorId,
			String machineNumber,
			Long driverid,
			String busNumber,
			Long shiftType,
			Long issuedTickets, Long issuedRoll, Long createdBy) {
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
		if(conductorId!=null||machineNumber!=null||driverid!=null||busNumber!=null||shiftType!=null) {
			if(conductorId!=null) {
				tbldutyallocation.setConductorId(conductorId);
			}
			if(machineNumber!=null) {
				tbldutyallocation.setMachineNumber(machineNumber);
			}
			if(driverid!=null) {
				tbldutyallocation.setDriverid(driverid);
			}
			if(busNumber!=null) {
				tbldutyallocation.setBusNumber(busNumber);
			}
			if(shiftType!=null) {
				tbldutyallocation.setShiftType(shiftType);
			}
			tbldutyallocation.setLastModifiedBy(createdBy);
			tbldutyallocation.setLastModifiedOn(Calendar.getInstance());
			try {
				tbldutyallocation=tmtuTbldutyallocationRepository.save(tbldutyallocation);
				logger.info("Duty Allocation updated successfully Id:"+tbldutyallocation.getDutyallocationid());
			}catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
		Tblwaybill tblwaybill=new Tblwaybill();
		tblwaybill.setWaybillnumber(dutyAllocationId);
		tblwaybill.setCreatedBy(createdBy);
		tblwaybill.setCreatedOn(Calendar.getInstance());
		tblwaybill.setIssuedRoll(issuedRoll);
		tblwaybill.setIssuedTickets(issuedTickets);
		tblwaybill.setStatus(1);
		tblwaybill.setWayBillDate(Calendar.getInstance());
		//Adding refrence
		tblwaybill.setTbldutyallocation(tbldutyallocation);
		//tbldutyallocation.addTblwaybill(tblwaybill);
		try {
			tblwaybill=tmtuTblwaybillRepository.save(tblwaybill);
			logger.info("Waybill successfuly created:"+tblwaybill.getWaybillnumber());
			return tblwaybill;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public String cancel(Long waywillnumber, Long modifiedby) {
		Tblwaybill tblwaybill=tmtuTblwaybillRepository.findOne(waywillnumber);
		if(tblwaybill==null) {
			logger.error("waybill don't exists Waybill number is:"+waywillnumber);
			return null;
		}
		tblwaybill.setStatus(2);
		tblwaybill.setLastModifiedBy(modifiedby);
		tblwaybill.setLastModifiedOn(Calendar.getInstance());
		//Change in duty Models
		Tbldutyallocation tblduty=tblwaybill.getTbldutyallocation();
		if(tblduty!=null)
		{
		try {
		tblduty.setStatus(1);
		tblduty.setLastModifiedBy(modifiedby);
		tblduty.setLastModifiedOn(Calendar.getInstance());
		tmtuTbldutyallocationRepository.save(tblduty);
		}catch (Exception e) {
			logger.info("Duty Allocation status successfully Id:"+tblduty.getDutyallocationid());
		}
		}
		try {
			
			//firstly delete old waybill and free duty
			tmtuTblwaybillRepository.delete(waywillnumber);
			//add agin with new Id so that record will exsits
			tblwaybill.setWaybillnumber(Calendar.getInstance().getTimeInMillis());
			tblwaybill=tmtuTblwaybillRepository.save(tblwaybill);
			logger.info("Successfully canceled Waybill Id:"+waywillnumber);
			return waywillnumber+"";
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Tblwaybill complete(Long waywillnumber, Long modifiedby) {
		
		Tblwaybill tblwaybill=tmtuTblwaybillRepository.findOne(waywillnumber);
		if(tblwaybill==null) {
			logger.error("waybill don't exists Waybill number is:"+waywillnumber);
			return null;
		}
		tblwaybill.setStatus(3);
		tblwaybill.setLastModifiedBy(modifiedby);
		tblwaybill.setLastModifiedOn(Calendar.getInstance());
		//Change in duty Models
		tblwaybill.getTbldutyallocation().setStatus(3);
		tblwaybill.getTbldutyallocation().setLastModifiedBy(modifiedby);
		tblwaybill.getTbldutyallocation().setLastModifiedOn(Calendar.getInstance());
		try {
			tblwaybill=tmtuTblwaybillRepository.save(tblwaybill);
			logger.info("Successfully Completed Waybill Id:"+waywillnumber);
			return tblwaybill;
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
}
