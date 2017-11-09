package com.tmtu.bus_master.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tmtu.bus_master.models.Tblfarechartmaster;
import com.tmtu.bus_master.services.TmtuTblfarechartmasterService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblfarechartmasterController {

	@Autowired
	TmtuTblfarechartmasterService tmtuTblfarechartmasterService;
	
	@PostMapping("/savefare")
	public ResponseEntity<Map<String,Object>> save(
			@RequestParam("startkm") Long startkm, 
			@RequestParam("tillkm") Long tillkm, 
			@RequestParam("bustypeid") Long bustypeid, 
			@RequestParam("concessionid") Long concessionid,
			@RequestParam("amount") Double amount,
			@RequestParam("createdby") Long createdby) {
		Map<String, Object> json=new HashMap<String,Object>();
		Tblfarechartmaster record=tmtuTblfarechartmasterService.save(startkm, tillkm, amount, bustypeid, concessionid, createdby);
		if(record!=null) {
		json.put("msg", "Saved");
		json.put("fareid",record.getFarechartid());
		json.put("startkm", record.getStartKm());
		json.put("tillkm", record.getTillKm());
		json.put("amount", record.getTotalAmount());
		json.put("createdby", record.getCreatedBy());
		json.put("createdon", record.getCreatedOn().getTimeInMillis());
		json.put("modifiedby", record.getLastModifiedBy());
		if(record.getLastModifiedOn()!=null) {
			json.put("modifiedon", record.getLastModifiedOn().getTimeInMillis());	
		}
		else {
			json.put("modifiedon", null);
		}
		Map<String,Object> bustype=new HashMap<String,Object>();
		bustype.put("bustypeid", record.getTlbbustypemaster().getBustypeid());
		bustype.put("servicecode", record.getTlbbustypemaster().getServicetypeCode());
		bustype.put("servicename", record.getTlbbustypemaster().getServiceTypeName());
		Map<String,Object> concession=new HashMap<String,Object>();
		
		concession.put("concessionid", record.getTblconcessionmaster().getConcessionid());
		concession.put("concessioncode", record.getTblconcessionmaster().getConcessionCode());
		concession.put("concessionname", record.getTblconcessionmaster().getConcessionName());
		
		json.put("bustype", bustype);
		json.put("concession", concession);
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
		}else {
			json.put("msg", "Not Saved");
		}
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
	}
	//@PostMapping("/updatefarebustype")
	public ResponseEntity<Map<String,Object>> updatebusType(
			@RequestParam("farechartid") Long farechartid, 
			@RequestParam("bustypeid") Long bustypeid, 
			@RequestParam("modifiedby") Long modifiedby) {
		
		Map<String, Object> json=new HashMap<String,Object>();
		Tblfarechartmaster record=tmtuTblfarechartmasterService.updatebusType(farechartid, bustypeid, modifiedby);
		if(record!=null) {
		json.put("msg", "Saved");
		json.put("fareid",record.getFarechartid());
		json.put("startkm", record.getStartKm());
		json.put("tillkm", record.getTillKm());
		json.put("amount", record.getTotalAmount());
		json.put("createdby", record.getCreatedBy());
		json.put("createdon", record.getCreatedOn().getTimeInMillis());
		json.put("modifiedby", record.getLastModifiedBy());
		if(record.getLastModifiedOn()!=null) {
			json.put("modifiedon", record.getLastModifiedOn().getTimeInMillis());	
		}
		else {
			json.put("modifiedon", null);
		}
		Map<String,Object> bustype=new HashMap<String,Object>();
		bustype.put("bustypeid", record.getTlbbustypemaster().getBustypeid());
		bustype.put("servicecode", record.getTlbbustypemaster().getServicetypeCode());
		bustype.put("servicename", record.getTlbbustypemaster().getServiceTypeName());
		Map<String,Object> concession=new HashMap<String,Object>();
		
		concession.put("concessionid", record.getTblconcessionmaster().getConcessionid());
		concession.put("concessioncode", record.getTblconcessionmaster().getConcessionCode());
		concession.put("concessionname", record.getTblconcessionmaster().getConcessionName());
		
		json.put("bustype", bustype);
		json.put("concession", concession);
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
		}else {
			json.put("msg", "Not Saved");
		}
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
	
	}
	//@PostMapping("/updatefarestartendkm")
	public ResponseEntity<Map<String,Object>> updateStartTillKm(
			@RequestParam("farechartid") Long farechartid, 
			@RequestParam("startkm") Long startkm, 
			@RequestParam("tillkm") Long tillkm, 
			@RequestParam("modifiedby") Long modifiedby) {
		
		Map<String, Object> json=new HashMap<String,Object>();
		Tblfarechartmaster record=tmtuTblfarechartmasterService.updateStartTillKm(farechartid, startkm, tillkm, modifiedby);
		if(record!=null) {
		json.put("msg", "Saved");
		json.put("fareid",record.getFarechartid());
		json.put("startkm", record.getStartKm());
		json.put("tillkm", record.getTillKm());
		json.put("amount", record.getTotalAmount());
		json.put("createdby", record.getCreatedBy());
		json.put("createdon", record.getCreatedOn().getTimeInMillis());
		json.put("modifiedby", record.getLastModifiedBy());
		if(record.getLastModifiedOn()!=null) {
			json.put("modifiedon", record.getLastModifiedOn().getTimeInMillis());	
		}
		else {
			json.put("modifiedon", null);
		}
		Map<String,Object> bustype=new HashMap<String,Object>();
		bustype.put("bustypeid", record.getTlbbustypemaster().getBustypeid());
		bustype.put("servicecode", record.getTlbbustypemaster().getServicetypeCode());
		bustype.put("servicename", record.getTlbbustypemaster().getServiceTypeName());
		Map<String,Object> concession=new HashMap<String,Object>();
		
		concession.put("concessionid", record.getTblconcessionmaster().getConcessionid());
		concession.put("concessioncode", record.getTblconcessionmaster().getConcessionCode());
		concession.put("concessionname", record.getTblconcessionmaster().getConcessionName());
		
		json.put("bustype", bustype);
		json.put("concession", concession);
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
		}else {
			json.put("msg", "Not Saved");
		}
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
	}
	//@PostMapping("/updatefareconcession")
	public ResponseEntity<Map<String,Object>> updateConcession(
			@RequestParam("farechartid") Long farechartid, 
			@RequestParam("concessionid") Long concessionid, 
			@RequestParam("modifiedby") Long modifiedby) {
		
		Map<String, Object> json=new HashMap<String,Object>();
		Tblfarechartmaster record=tmtuTblfarechartmasterService.updateConcession(farechartid, concessionid, modifiedby);
		if(record!=null) {
		json.put("msg", "Saved");
		json.put("fareid",record.getFarechartid());
		json.put("startkm", record.getStartKm());
		json.put("tillkm", record.getTillKm());
		json.put("amount", record.getTotalAmount());
		json.put("createdby", record.getCreatedBy());
		json.put("createdon", record.getCreatedOn().getTimeInMillis());
		json.put("modifiedby", record.getLastModifiedBy());
		if(record.getLastModifiedOn()!=null) {
			json.put("modifiedon", record.getLastModifiedOn().getTimeInMillis());	
		}
		else {
			json.put("modifiedon", null);
		}
		Map<String,Object> bustype=new HashMap<String,Object>();
		bustype.put("bustypeid", record.getTlbbustypemaster().getBustypeid());
		bustype.put("servicecode", record.getTlbbustypemaster().getServicetypeCode());
		bustype.put("servicename", record.getTlbbustypemaster().getServiceTypeName());
		Map<String,Object> concession=new HashMap<String,Object>();
		
		concession.put("concessionid", record.getTblconcessionmaster().getConcessionid());
		concession.put("concessioncode", record.getTblconcessionmaster().getConcessionCode());
		concession.put("concessionname", record.getTblconcessionmaster().getConcessionName());
		
		json.put("bustype", bustype);
		json.put("concession", concession);
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
		}else {
			json.put("msg", "Not Saved");
		}
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/updatefareamount")
	public ResponseEntity<Map<String,Object>> updatefareamount(
			@RequestParam("farechartid") Long farechartid, 
			@RequestParam("amount") Double amount, 
			@RequestParam("modifiedby") Long modifiedby) {
		
		Map<String, Object> json=new HashMap<String,Object>();
		Tblfarechartmaster record=tmtuTblfarechartmasterService.updatefareamount(farechartid, amount, modifiedby);
		if(record!=null) {
		json.put("msg", "Saved");
		json.put("fareid",record.getFarechartid());
		json.put("startkm", record.getStartKm());
		json.put("tillkm", record.getTillKm());
		json.put("amount", record.getTotalAmount());
		json.put("createdby", record.getCreatedBy());
		json.put("createdon", record.getCreatedOn().getTimeInMillis());
		json.put("modifiedby", record.getLastModifiedBy());
		if(record.getLastModifiedOn()!=null) {
			json.put("modifiedon", record.getLastModifiedOn().getTimeInMillis());	
		}
		else {
			json.put("modifiedon", null);
		}
		Map<String,Object> bustype=new HashMap<String,Object>();
		bustype.put("bustypeid", record.getTlbbustypemaster().getBustypeid());
		bustype.put("servicecode", record.getTlbbustypemaster().getServicetypeCode());
		bustype.put("servicename", record.getTlbbustypemaster().getServiceTypeName());
		Map<String,Object> concession=new HashMap<String,Object>();
		
		concession.put("concessionid", record.getTblconcessionmaster().getConcessionid());
		concession.put("concessioncode", record.getTblconcessionmaster().getConcessionCode());
		concession.put("concessionname", record.getTblconcessionmaster().getConcessionName());
		
		json.put("bustype", bustype);
		json.put("concession", concession);
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
		}else {
			json.put("msg", "Not Saved");
		}
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@GetMapping("/allfarechart")
	public ResponseEntity<List<Map<String, Object>>> getallfarechart(){
		List<Map<String, Object>> farecharts=tmtuTblfarechartmasterService.getallfarechart();
		if(farecharts.size()<1) {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("msg", "Not found");
			farecharts.add(json);
			return new ResponseEntity<List<Map<String,Object>>>(farecharts,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Map<String,Object>>>(farecharts,HttpStatus.OK);
		//return new ResponseEntity<List<Map<String,Object>>>(HttpStatus.OK);
	}
	
	@GetMapping("/farechart")
	public ResponseEntity<Map<String, Object>> getfarechart(
			@RequestParam("farechartid") Long farechartid) {
		Map<String, Object> json=tmtuTblfarechartmasterService.getfarechart(farechartid);
		if(json.size()==1) {
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
	}
}
