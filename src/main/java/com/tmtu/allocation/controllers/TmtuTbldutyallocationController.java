package com.tmtu.allocation.controllers;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.tmtu.allocation.models.Tbldutyallocation;
import com.tmtu.allocation.services.TmtuTbldutyallocationService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTbldutyallocationController {
	
	@Autowired
	TmtuTbldutyallocationService tmtuTbldutyallocationService;
	
	
	@PostMapping("/saveduty")
	public ResponseEntity<List<Map<String, Object>>> save(
			@RequestParam("conductorid")Long conductorId,
			@RequestParam("routeno") Long routeNumber,
			@RequestParam("machinenumber") String machineNumber,
			@RequestParam("fromdate") Long fromDate,
			@RequestParam("todate") Long toDate,
			@RequestParam("startstoppage") String startStoppage,
			@RequestParam("endstoppage") String endStoppage,
			@RequestParam("starttime") Long startTime,
			@RequestParam("endtime") Long endTime,
			@RequestParam("depotcode") String depotcode,
			@RequestParam("depotname") String depotName,
			@RequestParam("busnumber") String busNumber,
			@RequestParam("shifttype") Long shiftType,
			@RequestParam("driverid") Long driverid,
			@RequestParam("createdby") Long createdBy
			) 
	{
		
		List<Tbldutyallocation> tbls=tmtuTbldutyallocationService.save(conductorId, routeNumber, machineNumber, fromDate, toDate, startStoppage, endStoppage, startTime, endTime, depotcode, depotName, busNumber, shiftType, driverid, createdBy);
		List<Map<String,Object>> tblist=new ArrayList<Map<String,Object>>() ;
		tbls.forEach(tbl->{
			Map<String,Object> json=new HashMap<String, Object>();
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
			tblist.add(json);
		});
		return new ResponseEntity<List<Map<String,Object>>>(tblist,HttpStatus.OK);
	}
	
	@GetMapping("/getduty")
	public ResponseEntity<Map<String, Object>> save(@RequestParam("dutyid")Long dutyid){
		Tbldutyallocation tbl=tmtuTbldutyallocationService.findOne(dutyid);
		Map<String,Object> json=new HashMap<String, Object>();
		if(tbl==null) {
			json.put("msg", "Not saved");
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
		}
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
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
	}
	@GetMapping("/getactiveduties")
	public ResponseEntity<Page<Map<String,Object>>> findAllActive(Pageable page){
		return new ResponseEntity<Page<Map<String,Object>>>(tmtuTbldutyallocationService.findAllActive(page), HttpStatus.OK);
	}
	@GetMapping("/getcancelduties")
	public ResponseEntity<Page<Map<String,Object>>> findAllCancel(Pageable page){
		return new ResponseEntity<Page<Map<String,Object>>>(tmtuTbldutyallocationService.findAllCancel(page), HttpStatus.OK);
	}
	@GetMapping("/getduties")
	public ResponseEntity<Page<Map<String,Object>>> findAll(Pageable page){
		return new ResponseEntity<Page<Map<String,Object>>>(tmtuTbldutyallocationService.findAll(page), HttpStatus.OK);
	}
	
	
}
