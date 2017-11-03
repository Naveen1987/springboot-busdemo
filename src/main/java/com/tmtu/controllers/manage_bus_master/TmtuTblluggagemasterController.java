package com.tmtu.controllers.manage_bus_master;

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

import com.tmtu.models.manage_bus_master.Tblluggagemaster;
import com.tmtu.services.manage_bus_master.TmtuTblluggagemasterService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblluggagemasterController {

	@Autowired
	TmtuTblluggagemasterService tmtuTblluggagemasterService;
	
	
	@PostMapping("/saveluggage")
	public ResponseEntity<Map<String, Object>> save(
		@RequestParam(value="farechartid",required=false) Long farechartid, 
		@RequestParam("startkm") Long startkm, 
		@RequestParam("tillkm") Long tillkm, 
		@RequestParam("amount") Double amount, 
		@RequestParam("createdby") Long createdby){
		Tblluggagemaster record=null;
		if(farechartid==null) {
			record=tmtuTblluggagemasterService.save(startkm, tillkm, amount, createdby);
		}
		
		else {
			record=tmtuTblluggagemasterService.save(farechartid, startkm, tillkm, amount, createdby);
		}
		Map<String,Object> json=new HashMap<String,Object>();
		if(record==null) {
			json.put("msg", "Not Saved");
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
		}else
		{
			json.put("msg", "Saved");
			json.put("msg", "found");
			json.put("luggageid", record.getLuggageid());
			Map<String,Object> fare=new HashMap<String,Object>();
			if(record.getTblfarechartmaster()!=null) {
				fare.put("fareid",record.getTblfarechartmaster().getFarechartid());
				fare.put("amount",record.getTblfarechartmaster().getTotalAmount());
				fare.put("startkm",record.getTblfarechartmaster().getStartKm());
				fare.put("tillkm",record.getTblfarechartmaster().getTillKm());
				Map<String,Object> concession=new HashMap<String,Object>();
				concession.put("concessionid", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionid());
				concession.put("concessioncode", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionCode());
				concession.put("concessionname", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionName());
				fare.put("concession", concession);
				Map<String,Object> bustype=new HashMap<String,Object>();
				bustype.put("bustypeid", record.getTblfarechartmaster().getTlbbustypemaster().getBustypeid());
				bustype.put("servicecode", record.getTblfarechartmaster().getTlbbustypemaster().getServicetypeCode());
				bustype.put("servicename", record.getTblfarechartmaster().getTlbbustypemaster().getServiceTypeName());
				fare.put("bustype", bustype);
				}
			json.put("fares", fare);
			json.put("startkm", record.getStartKm());
			json.put("tillkm", record.getTillKm());
			json.put("amount", record.getTotalAmount());
			json.put("createdby",record.getCreatedBy());
			json.put("createdon", record.getCreatedOn().getTimeInMillis());
		}
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
	}
	@PostMapping("/updateluggagefarechart")
	public ResponseEntity<Map<String, Object>> updateluggagefarechart(
			@RequestParam("luggageid") Long luggageid, 
			@RequestParam("farechartid") Long farechartid, 
			@RequestParam("modifiedby") Long modifiedby) {
		
		Tblluggagemaster record=tmtuTblluggagemasterService.updateluggagefarechart(luggageid, farechartid, modifiedby);
		Map<String,Object> json=new HashMap<String,Object>();
		if(record==null) {
			json.put("msg", "Not Updated");
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
		}else
		{
			json.put("msg", "Updated");
			json.put("msg", "found");
			json.put("luggageid", record.getLuggageid());
			Map<String,Object> fare=new HashMap<String,Object>();
			if(record.getTblfarechartmaster()!=null) {
				fare.put("fareid",record.getTblfarechartmaster().getFarechartid());
				fare.put("amount",record.getTblfarechartmaster().getTotalAmount());
				fare.put("startkm",record.getTblfarechartmaster().getStartKm());
				fare.put("tillkm",record.getTblfarechartmaster().getTillKm());
				Map<String,Object> concession=new HashMap<String,Object>();
				concession.put("concessionid", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionid());
				concession.put("concessioncode", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionCode());
				concession.put("concessionname", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionName());
				fare.put("concession", concession);
				Map<String,Object> bustype=new HashMap<String,Object>();
				bustype.put("bustypeid", record.getTblfarechartmaster().getTlbbustypemaster().getBustypeid());
				bustype.put("servicecode", record.getTblfarechartmaster().getTlbbustypemaster().getServicetypeCode());
				bustype.put("servicename", record.getTblfarechartmaster().getTlbbustypemaster().getServiceTypeName());
				fare.put("bustype", bustype);
				}
			json.put("fares", fare);
			json.put("startkm", record.getStartKm());
			json.put("tillkm", record.getTillKm());
			json.put("amount", record.getTotalAmount());
			json.put("createdby",record.getCreatedBy());
			json.put("createdon", record.getCreatedOn().getTimeInMillis());
		}
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
	}
	
	@PostMapping("/updateluggageamount")
	public ResponseEntity<Map<String, Object>> updateluggageAmount(
			@RequestParam("luggageid") Long luggageid, 
			@RequestParam("amount") Double amount, 
			@RequestParam("modifiedby") Long modifiedby) {
		Tblluggagemaster record=tmtuTblluggagemasterService.updateluggageAmount(luggageid, amount, modifiedby);
		Map<String,Object> json=new HashMap<String,Object>();
		if(record==null) {
			json.put("msg", "Not Updated");
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
		}else
		{
			json.put("msg", "Updated");
			json.put("msg", "found");
			json.put("luggageid", record.getLuggageid());
			Map<String,Object> fare=new HashMap<String,Object>();
			if(record.getTblfarechartmaster()!=null) {
				fare.put("fareid",record.getTblfarechartmaster().getFarechartid());
				fare.put("amount",record.getTblfarechartmaster().getTotalAmount());
				fare.put("startkm",record.getTblfarechartmaster().getStartKm());
				fare.put("tillkm",record.getTblfarechartmaster().getTillKm());
				Map<String,Object> concession=new HashMap<String,Object>();
				concession.put("concessionid", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionid());
				concession.put("concessioncode", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionCode());
				concession.put("concessionname", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionName());
				fare.put("concession", concession);
				Map<String,Object> bustype=new HashMap<String,Object>();
				bustype.put("bustypeid", record.getTblfarechartmaster().getTlbbustypemaster().getBustypeid());
				bustype.put("servicecode", record.getTblfarechartmaster().getTlbbustypemaster().getServicetypeCode());
				bustype.put("servicename", record.getTblfarechartmaster().getTlbbustypemaster().getServiceTypeName());
				fare.put("bustype", bustype);
				}
			json.put("fares", fare);
			json.put("startkm", record.getStartKm());
			json.put("tillkm", record.getTillKm());
			json.put("amount", record.getTotalAmount());
			json.put("createdby",record.getCreatedBy());
			json.put("createdon", record.getCreatedOn().getTimeInMillis());
		}
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
	}
	@GetMapping("/getluggages")
	public ResponseEntity<List<Map<String, Object>>> getAllLuggage(){
		List<Map<String, Object>> luggages=tmtuTblluggagemasterService.getAllLuggage();
		if(luggages.size()<1) {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("msg", "Not Found");
			luggages.add(json);
			return new ResponseEntity<List<Map<String,Object>>>(luggages,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Map<String,Object>>>(luggages, HttpStatus.OK);
	}
	@GetMapping("/getluggage")
	public ResponseEntity<Map<String,Object>> getLuggage(
			@RequestParam("luggageid") Long luggageid){
		
		Map<String,Object> json=new HashMap<String,Object>();
		Tblluggagemaster record=  tmtuTblluggagemasterService.getLuggage(luggageid);
		if(record==null) {
			json.put("msg", "Not found");
			return new ResponseEntity<Map<String,Object>>(json, HttpStatus.BAD_REQUEST);
		}else
		{
			
			json.put("msg", "found");
			json.put("luggageid", record.getLuggageid());
			Map<String,Object> fare=new HashMap<String,Object>();
			if(record.getTblfarechartmaster()!=null) {
				fare.put("fareid",record.getTblfarechartmaster().getFarechartid());
				fare.put("amount",record.getTblfarechartmaster().getTotalAmount());
				fare.put("startkm",record.getTblfarechartmaster().getStartKm());
				fare.put("tillkm",record.getTblfarechartmaster().getTillKm());
				Map<String,Object> concession=new HashMap<String,Object>();
				concession.put("concessionid", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionid());
				concession.put("concessioncode", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionCode());
				concession.put("concessionname", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionName());
				fare.put("concession", concession);
				Map<String,Object> bustype=new HashMap<String,Object>();
				bustype.put("bustypeid", record.getTblfarechartmaster().getTlbbustypemaster().getBustypeid());
				bustype.put("servicecode", record.getTblfarechartmaster().getTlbbustypemaster().getServicetypeCode());
				bustype.put("servicename", record.getTblfarechartmaster().getTlbbustypemaster().getServiceTypeName());
				fare.put("bustype", bustype);
				}
			json.put("fares", fare);
			json.put("startkm", record.getStartKm());
			json.put("tillkm", record.getTillKm());
			json.put("amount", record.getTotalAmount());
			json.put("createdby",record.getCreatedBy());
			json.put("createdon", record.getCreatedOn().getTimeInMillis());
			
		}
		return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
	}
}
