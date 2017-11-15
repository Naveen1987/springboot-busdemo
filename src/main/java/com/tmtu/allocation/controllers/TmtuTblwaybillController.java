package com.tmtu.allocation.controllers;

import java.util.ArrayList;
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
	
	@PostMapping("/savewaybill")
	public ResponseEntity<Map<String,Object>> save(
			@RequestParam("dutyallocationid") Long dutyAllocationId,
			@RequestParam(value="conductorid",required=false)Long conductorId,
			@RequestParam(value="machinenumber",required=false) String machineNumber,
			@RequestParam(value="driverid",required=false) Long driverid,
			@RequestParam(value="busnumber",required=false) String busNumber,
			@RequestParam(value="shifttype",required=false) Long shiftType,
			@RequestParam("issuedtickets") Long issuedTickets,
			@RequestParam("issuedroll") Long issuedRoll,
			@RequestParam("createdby") Long createdBy
			) {
		Tblwaybill tbl=tmtuTblwaybillService.save(dutyAllocationId,conductorId,machineNumber,driverid,busNumber,shiftType, issuedTickets, issuedRoll, createdBy);
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
			jsonInner.put("starttime", tbl.getTbldutyallocation().getStartTime());
			jsonInner.put("endtime",tbl.getTbldutyallocation().getEndTime());
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
	
	@PostMapping("/cancelwaybill")
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
			jsonInner.put("starttime", tbl.getTbldutyallocation().getStartTime());
			jsonInner.put("endtime",tbl.getTbldutyallocation().getEndTime());
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
	@GetMapping("/allwaybills")
	public  ResponseEntity<Page<Map<String,Object>>> findAll(Pageable page){
		Page<Map<String,Object>> data=tmtuTblwaybillService.findAll(page);
		return new ResponseEntity<Page<Map<String,Object>>>(data, HttpStatus.OK);
	}
	@GetMapping("/activewaybills")
	public  ResponseEntity<Page<Map<String,Object>>> findAllActive(Pageable page){
		Page<Map<String,Object>> data=tmtuTblwaybillService.findAllActive(page);
		return new ResponseEntity<Page<Map<String,Object>>>(data, HttpStatus.OK);
	}
	
	@GetMapping("/findwaybill")
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
		jsonInner.put("starttime", tbl.getTbldutyallocation().getStartTime());
		jsonInner.put("endtime",tbl.getTbldutyallocation().getEndTime());
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
	
	@GetMapping("/tranactionofwaybill")
	public ResponseEntity<Map<String,Object>>  tranactionofwaywill(
			@RequestParam("waywillnumber") Long waywillnumber
			) {
		Tblwaybill tbl=tmtuTblwaybillService.findWayWill(waywillnumber);
		if(tbl!=null) {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("msg", "Not Saved");
			json.put("waybillnumber", tbl.getWaybillnumber());
			json.put("waybilldate", tbl.getWayBillDate().getTimeInMillis());
			json.put("issuedtickets", tbl.getIssuedTickets());
			json.put("issuedroll", tbl.getIssuedRoll());
			json.put("status", tbl.getStatus());
			json.put("createdon",tbl.getCreatedOn().getTimeInMillis());
			ArrayList<Map<String,Object>> innerJson=new ArrayList<Map<String,Object>>();
			tbl.getTbltransaction().forEach(record->{
				Map<String,Object> transjson=new HashMap<String,Object>();
				transjson.put("transactionid", record.getTransactionid());
				transjson.put("fromstopage",record.getFromstopage());
				transjson.put("tostopage",record.getTostopage());
				transjson.put("totaltickets",record.getTotaltickets());
				transjson.put("totalamount",record.getTotalamount());
				transjson.put("paymenttype",record.getPaymenttype());
				transjson.put("createdby",record.getCreatedby());
				transjson.put("createdon",record.getCreatedOn().getTimeInMillis());
				transjson.put("modifiedby",record.getLastModifiedBy());
				innerJson.add(transjson);
			});
			json.put("tranactions", innerJson);
			return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
		}
		else {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("msg", "Not Saved");
			return new ResponseEntity<Map<String,Object>>(json, HttpStatus.BAD_REQUEST);
		}
	}
	
}
