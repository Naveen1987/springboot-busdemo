package com.tmtu.allocation.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tmtu.allocation.models.Tblwaybill;
import com.tmtu.allocation.services.TmtuTblwaybillService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblwaybillController {

	@Autowired
	TmtuTblwaybillService tmtuTblwaybillService;
	
	@PostMapping("/savewaywill")
	public ResponseEntity<Map<String,Object>> save(
			@RequestParam("dutyallocationid") Long dutyAllocationId,
			@RequestParam("issuedtickets") Long issuedTickets,
			@RequestParam("issuedroll") Long issuedRoll,
			@RequestParam("createdby") Long createdBy
			) {
		Tblwaybill tbl=tmtuTblwaybillService.save(dutyAllocationId, issuedTickets, issuedRoll, createdBy);
		if(tbl!=null) {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("msg", "Not Saved");
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
			return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
		}
		else {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("msg", "Not Saved");
			return new ResponseEntity<Map<String,Object>>(json, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/cancelwaywill")
	public ResponseEntity<Map<String,Object>>  cancel(
			@RequestParam("waywillnumber") Long waywillnumber,
			@RequestParam("modifiedby") Long modifiedby
			) {
		Tblwaybill tbl=tmtuTblwaybillService.cancel(waywillnumber, modifiedby);
		if(tbl!=null) {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("msg", "Not Saved");
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
			return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
		}
		else {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("msg", "Not Saved");
			return new ResponseEntity<Map<String,Object>>(json, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/cancelwaywills")
	public  ResponseEntity<Page<Map<String,Object>>> findAllCancel(Pageable page){
		Page<Map<String,Object>> data=tmtuTblwaybillService.findAllCancel(page);
		return new ResponseEntity<Page<Map<String,Object>>>(data, HttpStatus.OK);
	}
	@GetMapping("/allwaywills")
	public  ResponseEntity<Page<Map<String,Object>>> findAll(Pageable page){
		Page<Map<String,Object>> data=tmtuTblwaybillService.findAll(page);
		return new ResponseEntity<Page<Map<String,Object>>>(data, HttpStatus.OK);
	}
	@GetMapping("/activewaywills")
	public  ResponseEntity<Page<Map<String,Object>>> findAllActive(Pageable page){
		Page<Map<String,Object>> data=tmtuTblwaybillService.findAllActive(page);
		return new ResponseEntity<Page<Map<String,Object>>>(data, HttpStatus.OK);
	}
	
	@GetMapping("/findwaywill")
	public  ResponseEntity<Map<String,Object>> findWayWill(@RequestParam("waywillno") Long waywillno){
		Tblwaybill tbl=tmtuTblwaybillService.findWayWill(waywillno);
		Map<String,Object>json=new HashMap<String,Object>();
		if(tbl==null) {
			json.put("msg", "Not found");
			return new ResponseEntity<Map<String,Object>>(json, HttpStatus.BAD_REQUEST);
		}
		
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
		return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
	}
	
}