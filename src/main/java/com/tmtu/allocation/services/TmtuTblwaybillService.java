package com.tmtu.allocation.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tmtu.allocation.models.Tblwaybill;
import com.tmtu.allocation.repositories.TmtuTblwaybillRepository;

@Service
public class TmtuTblwaybillService {

	@Autowired
	TmtuTblwaybillRepository tmtuTblwaybillRepository;
	
	public Tblwaybill save(
			Long dutyAllocationId,
			Long issuedTickets,
			Long issuedRoll,
			Long createdBy
			) {
		return tmtuTblwaybillRepository.save(dutyAllocationId, issuedTickets, issuedRoll, createdBy);
	}
	
	public Tblwaybill cancel(
			Long waywillnumber,
			Long modifiedby
			) {
		return tmtuTblwaybillRepository.cancel(waywillnumber, modifiedby);
	}
	
	public  Page<Map<String,Object>> findAllActive(Pageable page){
		Page<Tblwaybill> records=tmtuTblwaybillRepository.findAllActiveWayWill(page);
		Page<Map<String, Object>> data=records.map(new Converter<Tblwaybill, Map<String,Object>>() {

			@Override
			public Map<String, Object> convert(Tblwaybill tbl) {
				Map<String,Object>json=new HashMap<String,Object>();
				json.put("waybillnumber", tbl.getWaybillnumber());
				json.put("waybilldate", tbl.getWayBillDate().getTimeInMillis());
				json.put("issuedtickets", tbl.getIssuedTickets());
				json.put("issuedroll", tbl.getIssuedRoll());
				json.put("status", tbl.getStatus());
				json.put("createdon",tbl.getCreatedOn().getTimeInMillis());
				Map<String,Object>jsonInner=new HashMap<String,Object>();
				jsonInner.put("dutyid", tbl.getTbldutyallocation().getDutyallocationid());
				jsonInner.put("conductorid", tbl.getTbldutyallocation().getConductorId());
				jsonInner.put("routenumber", tbl.getTbldutyallocation().getRouteNumber());
				jsonInner.put("machinenumber", tbl.getTbldutyallocation().getMachineNumber());
				jsonInner.put("fromdate", tbl.getTbldutyallocation().getFromDate().getTimeInMillis());
				jsonInner.put("todate", tbl.getTbldutyallocation().getToDate().getTimeInMillis());
				jsonInner.put("startstoppage", tbl.getTbldutyallocation().getStartStoppage());
				jsonInner.put("endstoppage", tbl.getTbldutyallocation().getEndStoppage());
				jsonInner.put("starttime", tbl.getTbldutyallocation().getStartTime().getTimeInMillis());
				jsonInner.put("endtime",tbl.getTbldutyallocation().getEndTime().getTimeInMillis());
				jsonInner.put("depotcode", tbl.getTbldutyallocation().getDepotcode());
				jsonInner.put("depotname", tbl.getTbldutyallocation().getDepotName());
				jsonInner.put("busnumber", tbl.getTbldutyallocation().getBusNumber());
				jsonInner.put("shifttype", tbl.getTbldutyallocation().getShiftType());
				jsonInner.put("driverid", tbl.getTbldutyallocation().getDriverid());
				jsonInner.put("status", tbl.getTbldutyallocation().getStatus());
				jsonInner.put("createon", tbl.getTbldutyallocation().getCreatedOn());
				json.put("duty", jsonInner);
				return json;
			}
		
		});
		return data;
	}
	
	public  Page<Map<String,Object>> findAllCancel(Pageable page){
		Page<Tblwaybill> records=tmtuTblwaybillRepository.findAllCancelWayWill(page);
		Page<Map<String, Object>> data=records.map(new Converter<Tblwaybill, Map<String,Object>>() {

			@Override
			public Map<String, Object> convert(Tblwaybill tbl) {
				Map<String,Object>json=new HashMap<String,Object>();
				json.put("waybillnumber", tbl.getWaybillnumber());
				json.put("waybilldate", tbl.getWayBillDate().getTimeInMillis());
				json.put("issuedtickets", tbl.getIssuedTickets());
				json.put("issuedroll", tbl.getIssuedRoll());
				json.put("status", tbl.getStatus());
				json.put("createdon",tbl.getCreatedOn().getTimeInMillis());
				Map<String,Object>jsonInner=new HashMap<String,Object>();
				jsonInner.put("dutyid", tbl.getTbldutyallocation().getDutyallocationid());
				jsonInner.put("conductorid", tbl.getTbldutyallocation().getConductorId());
				jsonInner.put("routenumber", tbl.getTbldutyallocation().getRouteNumber());
				jsonInner.put("machinenumber", tbl.getTbldutyallocation().getMachineNumber());
				jsonInner.put("fromdate", tbl.getTbldutyallocation().getFromDate().getTimeInMillis());
				jsonInner.put("todate", tbl.getTbldutyallocation().getToDate().getTimeInMillis());
				jsonInner.put("startstoppage", tbl.getTbldutyallocation().getStartStoppage());
				jsonInner.put("endstoppage", tbl.getTbldutyallocation().getEndStoppage());
				jsonInner.put("starttime", tbl.getTbldutyallocation().getStartTime().getTimeInMillis());
				jsonInner.put("endtime",tbl.getTbldutyallocation().getEndTime().getTimeInMillis());
				jsonInner.put("depotcode", tbl.getTbldutyallocation().getDepotcode());
				jsonInner.put("depotname", tbl.getTbldutyallocation().getDepotName());
				jsonInner.put("busnumber", tbl.getTbldutyallocation().getBusNumber());
				jsonInner.put("shifttype", tbl.getTbldutyallocation().getShiftType());
				jsonInner.put("driverid", tbl.getTbldutyallocation().getDriverid());
				jsonInner.put("status", tbl.getTbldutyallocation().getStatus());
				jsonInner.put("createon", tbl.getTbldutyallocation().getCreatedOn());
				json.put("duty", jsonInner);
				return json;
			}
		
		});
		return data;
	}
	
	public  Page<Map<String,Object>> findAll(Pageable page){
		Page<Tblwaybill> records=tmtuTblwaybillRepository.findAll(page);
		Page<Map<String, Object>> data=records.map(new Converter<Tblwaybill, Map<String,Object>>() {

			@Override
			public Map<String, Object> convert(Tblwaybill tbl) {
				Map<String,Object>json=new HashMap<String,Object>();
				json.put("waybillnumber", tbl.getWaybillnumber());
				json.put("waybilldate", tbl.getWayBillDate().getTimeInMillis());
				json.put("issuedtickets", tbl.getIssuedTickets());
				json.put("issuedroll", tbl.getIssuedRoll());
				json.put("status", tbl.getStatus());
				json.put("createdon",tbl.getCreatedOn().getTimeInMillis());
				Map<String,Object>jsonInner=new HashMap<String,Object>();
				jsonInner.put("dutyid", tbl.getTbldutyallocation().getDutyallocationid());
				jsonInner.put("conductorid", tbl.getTbldutyallocation().getConductorId());
				jsonInner.put("routenumber", tbl.getTbldutyallocation().getRouteNumber());
				jsonInner.put("machinenumber", tbl.getTbldutyallocation().getMachineNumber());
				jsonInner.put("fromdate", tbl.getTbldutyallocation().getFromDate().getTimeInMillis());
				jsonInner.put("todate", tbl.getTbldutyallocation().getToDate().getTimeInMillis());
				jsonInner.put("startstoppage", tbl.getTbldutyallocation().getStartStoppage());
				jsonInner.put("endstoppage", tbl.getTbldutyallocation().getEndStoppage());
				jsonInner.put("starttime", tbl.getTbldutyallocation().getStartTime().getTimeInMillis());
				jsonInner.put("endtime",tbl.getTbldutyallocation().getEndTime().getTimeInMillis());
				jsonInner.put("depotcode", tbl.getTbldutyallocation().getDepotcode());
				jsonInner.put("depotname", tbl.getTbldutyallocation().getDepotName());
				jsonInner.put("busnumber", tbl.getTbldutyallocation().getBusNumber());
				jsonInner.put("shifttype", tbl.getTbldutyallocation().getShiftType());
				jsonInner.put("driverid", tbl.getTbldutyallocation().getDriverid());
				jsonInner.put("status", tbl.getTbldutyallocation().getStatus());
				jsonInner.put("createon", tbl.getTbldutyallocation().getCreatedOn());
				json.put("duty", jsonInner);
				return json;
			}
		
		});
		return data;
	}
	
	public  Tblwaybill findWayWill(Long waywillnumber){
		return tmtuTblwaybillRepository.findOne(waywillnumber);
	}
	
}
