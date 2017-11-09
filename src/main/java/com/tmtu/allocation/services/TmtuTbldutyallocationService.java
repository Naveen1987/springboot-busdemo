package com.tmtu.allocation.services;

import java.util.Calendar;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tmtu.allocation.models.Tbldutyallocation;
import com.tmtu.allocation.repositories.TmtuTbldutyallocationRepository;
import java.util.Map;

@Service
public class TmtuTbldutyallocationService {

	@Autowired
	TmtuTbldutyallocationRepository tmtuTbldutyallocationRepository;
	
	public Tbldutyallocation save(
			Long conductorId,
			Long routeNumber,
			String machineNumber,
			Long fromDate,
			Long toDate,
			String startStoppage,
			String endStoppage,
			Long startTime,
			Long endTime,
			String depotcode,
			String depotName,
			String busNumber,
			Long shiftType,
			Long driverid,
			Long createdBy
			) {
		Calendar cfromDate=Calendar.getInstance();
		cfromDate.setTimeInMillis(fromDate);
		Calendar ctoDate=Calendar.getInstance();
		ctoDate.setTimeInMillis(toDate);
		Calendar cstartTime=Calendar.getInstance();
		cstartTime.setTimeInMillis(startTime);
		Calendar cendTime=Calendar.getInstance();
		cendTime.setTimeInMillis(endTime);
		return tmtuTbldutyallocationRepository.save(conductorId, routeNumber, machineNumber, cfromDate, ctoDate, startStoppage, endStoppage, cstartTime, cendTime, depotcode, depotName, busNumber, shiftType, driverid, createdBy);
	}
	
	public Page<Map<String,Object>> findAllActive(Pageable page){
		Page<Tbldutyallocation> records=tmtuTbldutyallocationRepository.findAllWithActive(page);
		Page<Map<String, Object>> data=records.map(new Converter<Tbldutyallocation, Map<String,Object>>() {
			@Override
			public Map<String, Object> convert(Tbldutyallocation tbl) {
				Map<String,Object>json=new HashMap<String,Object>();
				json.put("dutyid", tbl.getDutyallocationid());
				json.put("conductorid", tbl.getConductorId());
				json.put("routenumber", tbl.getRouteNumber());
				json.put("machinenumber", tbl.getMachineNumber());
				json.put("fromdate", tbl.getFromDate().getTimeInMillis());
				json.put("todate", tbl.getToDate().getTimeInMillis());
				json.put("startstoppage", tbl.getStartStoppage());
				json.put("endstoppage", tbl.getEndStoppage());
				json.put("starttime", tbl.getStartTime().getTimeInMillis());
				json.put("endtime",tbl.getEndTime().getTimeInMillis());
				json.put("depotcode", tbl.getDepotcode());
				json.put("depotname", tbl.getDepotName());
				json.put("busnumber", tbl.getBusNumber());
				json.put("shifttype", tbl.getShiftType());
				json.put("driverid", tbl.getDriverid());
				json.put("status", tbl.getStatus());
				json.put("createon", tbl.getCreatedOn());
				return json;
			}
		});
		return data;
	}
	
	public Page<Map<String,Object>> findAllCancel(Pageable page){
		Page<Tbldutyallocation> records=tmtuTbldutyallocationRepository.findAllWithCancel(page);
		Page<Map<String, Object>> data=records.map(new Converter<Tbldutyallocation, Map<String,Object>>() {
			@Override
			public Map<String, Object> convert(Tbldutyallocation tbl) {
				Map<String,Object>json=new HashMap<String,Object>();
				json.put("dutyid", tbl.getDutyallocationid());
				json.put("conductorid", tbl.getConductorId());
				json.put("routenumber", tbl.getRouteNumber());
				json.put("machinenumber", tbl.getMachineNumber());
				json.put("fromdate", tbl.getFromDate().getTimeInMillis());
				json.put("todate", tbl.getToDate().getTimeInMillis());
				json.put("startstoppage", tbl.getStartStoppage());
				json.put("endstoppage", tbl.getEndStoppage());
				json.put("starttime", tbl.getStartTime().getTimeInMillis());
				json.put("endtime",tbl.getEndTime().getTimeInMillis());
				json.put("depotcode", tbl.getDepotcode());
				json.put("depotname", tbl.getDepotName());
				json.put("busnumber", tbl.getBusNumber());
				json.put("shifttype", tbl.getShiftType());
				json.put("driverid", tbl.getDriverid());
				json.put("status", tbl.getStatus());
				json.put("createon", tbl.getCreatedOn());
				return json;
			}
		});
		return data;
	}
	
	public Page<Map<String,Object>> findAll(Pageable page){
		Page<Tbldutyallocation> records=tmtuTbldutyallocationRepository.findAll(page);
		Page<Map<String, Object>> data=records.map(new Converter<Tbldutyallocation, Map<String,Object>>() {
			@Override
			public Map<String, Object> convert(Tbldutyallocation tbl) {
				Map<String,Object>json=new HashMap<String,Object>();
				json.put("dutyid", tbl.getDutyallocationid());
				json.put("conductorid", tbl.getConductorId());
				json.put("routenumber", tbl.getRouteNumber());
				json.put("machinenumber", tbl.getMachineNumber());
				json.put("fromdate", tbl.getFromDate().getTimeInMillis());
				json.put("todate", tbl.getToDate().getTimeInMillis());
				json.put("startstoppage", tbl.getStartStoppage());
				json.put("endstoppage", tbl.getEndStoppage());
				json.put("starttime", tbl.getStartTime().getTimeInMillis());
				json.put("endtime",tbl.getEndTime().getTimeInMillis());
				json.put("depotcode", tbl.getDepotcode());
				json.put("depotname", tbl.getDepotName());
				json.put("busnumber", tbl.getBusNumber());
				json.put("shifttype", tbl.getShiftType());
				json.put("driverid", tbl.getDriverid());
				json.put("status", tbl.getStatus());
				json.put("createon", tbl.getCreatedOn());
				return json;
			}
		});
		return data;
	}
	
	public Tbldutyallocation findOne(Long dutyId) {
		return tmtuTbldutyallocationRepository.findOne(dutyId);
	}
}
