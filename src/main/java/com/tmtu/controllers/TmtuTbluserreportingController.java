package com.tmtu.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tmtu.models.Tbluserreporting;
import com.tmtu.services.TmtuTbluserreportingService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTbluserreportingController {

	@Autowired
	TmtuTbluserreportingService tmtuTbluserreportingService;
	
	@PostMapping("/savereportingto")
	public ResponseEntity<Map<String,String>> saveReportingManager(
			@RequestParam("id") long loginid,
			@RequestParam("createdby") long createdby,
			@RequestParam("reportto") long reportto,
			@RequestParam("datefrom") long datefrom,
			@RequestParam("dateto") long dateto
			){
		Map<String,String> json=new HashMap<String,String>();
		Tbluserreporting tbluserreporting=tmtuTbluserreportingService.save(loginid, createdby, reportto, datefrom, dateto);
		if(tbluserreporting==null) {
			json.put("msg", "Reporting Manager not added successfully");
			return new ResponseEntity<Map<String,String>>(json,HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg", "Reporting Manager added successfully");
		}
		return new ResponseEntity<Map<String,String>>(json,HttpStatus.OK);
	}
	@PostMapping("/updatereporting")
	public ResponseEntity<Map<String,String>> updateToReportingManager(
			@RequestParam("reportid") long reportid,
			@RequestParam("id") long loginid,
			@RequestParam("modifiedby") long modifiedby,
			@RequestParam("reportto") long reportto,
			@RequestParam("datefrom") long datefrom,
			@RequestParam("dateto") long dateto
			){
		Map<String,String> json=new HashMap<String,String>();
		Tbluserreporting tbluserreporting=tmtuTbluserreportingService.update(reportid, loginid, modifiedby, reportto, datefrom, dateto);
		if(tbluserreporting==null) {
			json.put("msg", "Reporting Manager not updated successfully Id is not exists");
			return new ResponseEntity<Map<String,String>>(json,HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg", "Reporting Manager Updated successfully");
			json.put("reportid", tbluserreporting.getUserreportingid()+"");
			json.put("datefrom", tbluserreporting.getDateFrom().getTimeInMillis()+"");
			json.put("dateto", tbluserreporting.getDateTo().getTimeInMillis()+"");
			json.put("reportto", tbluserreporting.getReportingTo()+"");
		}
		return new ResponseEntity<Map<String,String>>(json,HttpStatus.OK);
	}
	
	
}
