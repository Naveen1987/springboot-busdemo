package com.tmtu.allocation.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.admin.models.Tbllogin;
import com.tmtu.admin.repositories.TmtuTblloginRepository;
import com.tmtu.allocation.models.Tbldutyallocation;

public class TmtuTbldutyallocationRepositoryImpl implements TmtuTbldutyallocationRepositoryCustom {

	@Autowired 
	TmtuTbldutyallocationRepository tmtuTbldutyallocationRepository;
	
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository;
	
	private static final Logger logger=LoggerFactory.getLogger("Duty Allocation Repository"); 
	
	@Override
	public Tbldutyallocation save(Long conductorId, Long routeNumber, String machineNumber, Calendar fromDate,
			Calendar toDate, String startStoppage, String endStoppage, Calendar startTime, Calendar endTime,
			String depotcode, String depotName, String busNumber, Long shiftType, Long driverid, Long createdBy) {
		
		Tbllogin conductor=tmtuTblloginRepository.findOne(conductorId);
		if(conductor==null) {
			logger.error("Conductor don't exists:"+conductorId);
			return null;
		}
		
		Tbllogin driver=tmtuTblloginRepository.findOne(driverid);
		if(driver==null) {
			logger.error("Driver don't exists:"+driverid);
			return null;
		}
		
		Tbllogin creator=tmtuTblloginRepository.findOne(createdBy);
		if(creator==null) {
			logger.error("User don't exists:"+createdBy);
			return null;
		}
		Tbldutyallocation tbldutyallocation=new Tbldutyallocation();
		tbldutyallocation.setBusNumber(busNumber);
		
		tbldutyallocation.setStatus(1);
		
		tbldutyallocation.setDepotcode(depotcode);
		tbldutyallocation.setDepotName(depotName);
		
		tbldutyallocation.setConductorId(conductorId);
		
		tbldutyallocation.setDriverid(driverid);
		
		tbldutyallocation.setMachineNumber(machineNumber);
		
		tbldutyallocation.setShiftType(shiftType);
		
		tbldutyallocation.setRouteNumber(routeNumber);
		
		tbldutyallocation.setFromDate(fromDate);
		tbldutyallocation.setToDate(toDate);
		
		tbldutyallocation.setStartStoppage(startStoppage);
		tbldutyallocation.setEndStoppage(endStoppage);
		
		tbldutyallocation.setStartTime(startTime);
		tbldutyallocation.setEndTime(endTime);
		
		tbldutyallocation.setCreatedBy(createdBy);
		tbldutyallocation.setCreatedOn(Calendar.getInstance());
		
		try {
			tbldutyallocation=tmtuTbldutyallocationRepository.save(tbldutyallocation);
			logger.info("Duty is saved Id:"+tbldutyallocation.getDutyallocationid());
			return tbldutyallocation;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return null;
	}

}
