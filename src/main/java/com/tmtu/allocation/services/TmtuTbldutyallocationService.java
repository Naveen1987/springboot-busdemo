package com.tmtu.allocation.services;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.joda.time.Days;
import org.joda.time.LocalDateTime;

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
	
	public List<Tbldutyallocation> save(
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
		List<Tbldutyallocation> tbls=new ArrayList<Tbldutyallocation>();
		List<Calendar> dutyDates=dutyDateList(fromDate,toDate);
		Calendar startt=Calendar.getInstance();
		startt.setTimeInMillis(startTime);
		Calendar endt=Calendar.getInstance();
		startt.setTimeInMillis(endTime);
		dutyDates.forEach(date->{
			Tbldutyallocation tbl=tmtuTbldutyallocationRepository.save(conductorId, routeNumber, machineNumber, date, date, startStoppage, endStoppage, startt, endt, depotcode, depotName, busNumber, shiftType, driverid, createdBy);
			if(tbl!=null) {
				tbls.add(tbl);
			}
		});
		return tbls;
	}
	
	public List<Calendar> dutyDateList(Long fromDate,Long toDate){
		LocalDateTime cfromDate=new LocalDateTime(fromDate);
		LocalDateTime ctoDate=new LocalDateTime(toDate);
		int days=Days.daysBetween(cfromDate, ctoDate).getDays();
		//It always show between days not added to and from like 1 to 5 it will give 3 days
		List<LocalDateTime> dates=new ArrayList<LocalDateTime>(days);
		//variable i start from zero so that cfromDate itself add other wise you can add it manual and start loop from 1
		//Start Date added
		dates.add(cfromDate);
		//Middle Date Added
		for(int i=1;i<=days;i++) {
			dates.add(cfromDate.plusDays(i));
		}
		//last Date Added
		dates.add(ctoDate);
		List<Calendar> dutyDates=new ArrayList<Calendar>();
		//Now Creating Dates
		dates.forEach(da->{
			Calendar cl=Calendar.getInstance();
			cl.setTime(da.toDate());
			cl.set( Calendar.HOUR_OF_DAY, 0 );
		    cl.set( Calendar.MINUTE, 0 );
		    cl.set( Calendar.SECOND, 0 );
		    cl.set( Calendar.MILLISECOND, 0 );
		    dutyDates.add(cl);
		});
		return dutyDates;
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
