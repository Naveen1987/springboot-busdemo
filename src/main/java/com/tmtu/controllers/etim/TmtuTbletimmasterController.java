package com.tmtu.controllers.etim;

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

import com.tmtu.models.etim.Tbletimmaster;
import com.tmtu.services.etim.TmtuTbletimmasterService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTbletimmasterController {

	@Autowired
	TmtuTbletimmasterService tbletimmasterService;
	
	@PostMapping("/registeretim")
	public ResponseEntity<Map<String, Object>>saveEtim(
			@RequestParam("imei") String imei,
			@RequestParam(value="etimName",required=false) String etimName,
			@RequestParam(value="serialNumber",required=false) String serialNumber,
			@RequestParam(value="version",required=false) String version,
			@RequestParam(value="createdby",required=false) Long createdBy
			){
	Tbletimmaster tbletimmaster=tbletimmasterService.save(imei, etimName, serialNumber, version, createdBy);
	Map<String, Object>json=new HashMap<String,Object>();
	if(tbletimmaster!=null) {
		json.put("msg", "Saved");
		json.put("imei", tbletimmaster.getImei());
		if(tbletimmaster.getEtimName()!=null) {
			json.put("etimname", tbletimmaster.getEtimName());
		}
		if(tbletimmaster.getSerialNumber()!=null) {
			json.put("serialnumber", tbletimmaster.getSerialNumber());
		}
		if(tbletimmaster.getVersion()!=null) {
			json.put("version", tbletimmaster.getVersion());
		}
		json.put("status", tbletimmaster.isStatus());
		json.put("createdon", tbletimmaster.getCreatedOn().getTimeInMillis());
		return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
		}
		else {
			json.put("msg", "Not Saved etim exists");
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);		
		}
	
	
	}
	
	@PostMapping("/updateetim")
	public ResponseEntity<Map<String, Object>>updateEtim(
			@RequestParam("imei") String imei,
			@RequestParam(value="etimName",required=false) String etimName,
			@RequestParam(value="serialNumber",required=false) String serialNumber,
			@RequestParam(value="version",required=false) String version,
			@RequestParam("modifiedby") Long modifiedby
			){
	Tbletimmaster tbletimmaster=tbletimmasterService.update(imei, etimName, serialNumber, version, modifiedby);
	Map<String, Object>json=new HashMap<String,Object>();
	if(tbletimmaster!=null) {
		json.put("msg", "Updated");
		json.put("imei", tbletimmaster.getImei());
		if(tbletimmaster.getEtimName()!=null) {
			json.put("etimname", tbletimmaster.getEtimName());
		}
		if(tbletimmaster.getSerialNumber()!=null) {
			json.put("serialnumber", tbletimmaster.getSerialNumber());
		}
		if(tbletimmaster.getVersion()!=null) {
			json.put("version", tbletimmaster.getVersion());
		}
		json.put("modifiedby", tbletimmaster.getLastModifiedBy());
		json.put("modifiedon", tbletimmaster.getLastModifiedOn().getTimeInMillis());
		return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
		}
		else {
			json.put("msg", "Not Updated because Etim is not exists");
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);		
		}
	
	}
	
	@GetMapping("/findetim")
	public ResponseEntity<Map<String, Object>>findEtim(
			@RequestParam("imei") String imei
			
			){
	Tbletimmaster tbletimmaster=tbletimmasterService.findEtim(imei);
	Map<String, Object>json=new HashMap<String,Object>();
	if(tbletimmaster!=null) {
		json.put("msg", "Found");
		json.put("imei", tbletimmaster.getImei());
		if(tbletimmaster.getEtimName()!=null) {
			json.put("etimname", tbletimmaster.getEtimName());
		}
		if(tbletimmaster.getSerialNumber()!=null) {
			json.put("serialnumber", tbletimmaster.getSerialNumber());
		}
		if(tbletimmaster.getVersion()!=null) {
			json.put("version", tbletimmaster.getVersion());
		}
		json.put("status", tbletimmaster.isStatus());
		return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
		}
		else {
			json.put("msg", "Not Found");
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);		
		}
	
	}
	
	@GetMapping("/findalletim")
	public ResponseEntity<List<Map<String, Object>>>findAllEtim(){
		List<Map<String,Object>> tbletimmaster=tbletimmasterService.findAllEtim();
			if(tbletimmaster.size()>0) {
				return new ResponseEntity<List<Map<String,Object>>>(tbletimmaster,HttpStatus.OK);
			}
			else {
				 Map<String,Object> data=new HashMap<String,Object>();
				 data.put("msg", "No Data");
				 tbletimmaster.add(data);
			}
			return new ResponseEntity<List<Map<String,Object>>>(tbletimmaster,HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping("/deactivateetim")
	public ResponseEntity<Map<String, Object>>deactivate(
			@RequestParam("imei") String imei
			){
	Tbletimmaster tbletimmaster=tbletimmasterService.changeStatus(imei,false);
	Map<String, Object>json=new HashMap<String,Object>();
	if(tbletimmaster!=null) {
		json.put("msg", "Saved");
		json.put("imei", tbletimmaster.getImei());
		if(tbletimmaster.getEtimName()!=null) {
			json.put("etimname", tbletimmaster.getEtimName());
		}
		if(tbletimmaster.getSerialNumber()!=null) {
			json.put("serialnumber", tbletimmaster.getSerialNumber());
		}
		if(tbletimmaster.getVersion()!=null) {
			json.put("version", tbletimmaster.getVersion());
		}
		json.put("status", tbletimmaster.isStatus());
		json.put("modifiedon", tbletimmaster.getLastModifiedOn().getTimeInMillis());
		return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
		}
		else {
			json.put("msg", "Not Found");
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);		
		}
	
	}
	
	@PostMapping("/activateetim")
	public ResponseEntity<Map<String, Object>>active(
			@RequestParam("imei") String imei
			){
	Tbletimmaster tbletimmaster=tbletimmasterService.changeStatus(imei,true);
	Map<String, Object>json=new HashMap<String,Object>();
	if(tbletimmaster!=null) {
		json.put("msg", "saved");
		json.put("imei", tbletimmaster.getImei());
		if(tbletimmaster.getEtimName()!=null) {
			json.put("etimname", tbletimmaster.getEtimName());
		}
		if(tbletimmaster.getSerialNumber()!=null) {
			json.put("serialnumber", tbletimmaster.getSerialNumber());
		}
		if(tbletimmaster.getVersion()!=null) {
			json.put("version", tbletimmaster.getVersion());
		}
		json.put("status", tbletimmaster.isStatus());
		json.put("modifiedon", tbletimmaster.getLastModifiedOn().getTimeInMillis());
		return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
		}
		else {
			json.put("msg", "Not Found");
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);		
		}
	
	}
	
}
