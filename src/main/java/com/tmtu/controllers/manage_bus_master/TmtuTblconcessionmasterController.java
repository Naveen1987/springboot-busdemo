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

import com.tmtu.models.manage_bus_master.Tblconcessionmaster;
import com.tmtu.services.manage_bus_master.TmtuTblconcessionmasterService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblconcessionmasterController {

	@Autowired
	TmtuTblconcessionmasterService tmtuTblconcessionmasterService;
	
	@PostMapping("/saveconcession")
	public ResponseEntity<Map<String, Object>> save(
			@RequestParam("concessionname") String concessionName, 
			@RequestParam("concessioncode") String concessionCode, 
			@RequestParam("createdby") Long createdBy)
	{
	Map<String, Object> json=new HashMap<String,Object>();
	Tblconcessionmaster tblconcessionmaster=tmtuTblconcessionmasterService.save(concessionName, concessionCode, createdBy);
	if(tblconcessionmaster!=null) {
		json.put("msg", "Saved");
		json.put("concessionid", tblconcessionmaster.getConcessionid());
		json.put("concessioncode", tblconcessionmaster.getConcessionCode());
		json.put("concessionname", tblconcessionmaster.getConcessionName());
		json.put("createon", tblconcessionmaster.getCreatedOn().getTimeInMillis());
		return new ResponseEntity<Map<String, Object>>(json,HttpStatus.OK);
	}
	else {
		json.put("msg", "Not saved");
		return new ResponseEntity<Map<String, Object>>(json,HttpStatus.BAD_REQUEST);
	}		
	}
	
	@PostMapping("/updateconcession")
	public ResponseEntity<Map<String, Object>> update(
			@RequestParam("concessionid") Long concessionid, 
			@RequestParam("concessionname") String concessionName, 
			@RequestParam("concessioncode") String concessionCode, 
			@RequestParam("modifiedby") Long modifiedby)
	{
	Map<String, Object> json=new HashMap<String,Object>();
	Tblconcessionmaster tblconcessionmaster=tmtuTblconcessionmasterService.update(concessionid, concessionName, concessionCode, modifiedby);
	if(tblconcessionmaster!=null) {
		json.put("msg", "Updated");
		json.put("concessionid", tblconcessionmaster.getConcessionid());
		json.put("concessioncode", tblconcessionmaster.getConcessionCode());
		json.put("concessionname", tblconcessionmaster.getConcessionName());
		json.put("createon", tblconcessionmaster.getCreatedOn().getTimeInMillis());
		return new ResponseEntity<Map<String, Object>>(json,HttpStatus.OK);
	}
	else {
		json.put("msg", "Not Updated");
		return new ResponseEntity<Map<String, Object>>(json,HttpStatus.BAD_REQUEST);
	}	
	}
	
	@GetMapping("/findbyname")
	public ResponseEntity<List<Map<String, Object>>> findbyname(@RequestParam("concessionname") String concessionName)
	{
	List<Map<String, Object>> json=tmtuTblconcessionmasterService.findbyName(concessionName);
	if(json.size()<1) {
		Map<String,Object>msg=new HashMap<String,Object>();
		msg.put("msg", "Not Found");
		json.add(msg);
		return new ResponseEntity<List<Map<String, Object>>>(json,HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<List<Map<String, Object>>>(json,HttpStatus.OK);
	}
	
	@GetMapping("/findconcession")
	public ResponseEntity<List<Map<String, Object>>> findConcession(@RequestParam("concession") String concession)
	{
	List<Map<String, Object>> json=tmtuTblconcessionmasterService.findConcesssion(concession);
	if(json.size()<1) {
		Map<String,Object>msg=new HashMap<String,Object>();
		msg.put("msg", "Not Found");
		json.add(msg);
		return new ResponseEntity<List<Map<String, Object>>>(json,HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<List<Map<String, Object>>>(json,HttpStatus.OK);
	}
	
	@GetMapping("/findbycode")
	public ResponseEntity<List<Map<String, Object>>> findbycode(@RequestParam("concessioncode") String concessionCode)
	{
	List<Map<String, Object>> json=tmtuTblconcessionmasterService.findbyCode(concessionCode);
	if(json.size()<1) {
		Map<String,Object>msg=new HashMap<String,Object>();
		msg.put("msg", "Not Found");
		json.add(msg);
		return new ResponseEntity<List<Map<String, Object>>>(json,HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<List<Map<String, Object>>>(json,HttpStatus.OK);
	}
	
	
	@GetMapping("/findallconcession")
	public ResponseEntity<List<Map<String, Object>>> findallconcession()
	{
	List<Map<String, Object>> json=tmtuTblconcessionmasterService.findall();
	if(json.size()<1) {
		Map<String,Object>msg=new HashMap<String,Object>();
		msg.put("msg", "Not Found");
		json.add(msg);
		return new ResponseEntity<List<Map<String, Object>>>(json,HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<List<Map<String, Object>>>(json,HttpStatus.OK);
	}
}
