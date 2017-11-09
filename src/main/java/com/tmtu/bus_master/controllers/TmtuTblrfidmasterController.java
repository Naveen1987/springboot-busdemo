package com.tmtu.bus_master.controllers;

import java.util.HashMap;
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

import com.tmtu.bus_master.models.Tblrfidmaster;
import com.tmtu.bus_master.services.TmtuTblrfidmasterService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblrfidmasterController {

	@Autowired
	TmtuTblrfidmasterService tmtuTblrfidmasterService;
	
	@PostMapping("/saverfid")
	public ResponseEntity<Map<String, Object>> save(
			@RequestParam("keys") String keys,
			@RequestParam("amount") Double amount,
			@RequestParam("createdby") Long createdby
			){
		Map<String,Object> json=new HashMap<String,Object>();
		Tblrfidmaster tblrfidmaster=tmtuTblrfidmasterService.save(keys, amount, createdby);
		if(tblrfidmaster!=null) {
			json.put("msg", "saved");
			json.put("rfid", ""+tblrfidmaster.getRfidmasterid());
			json.put("amount", ""+tblrfidmaster.getAmount());
			json.put("rfidkey", ""+tblrfidmaster.getKeys());
			json.put("status", ""+tblrfidmaster.getStatus());
			return new  ResponseEntity<Map<String, Object>>(json,HttpStatus.OK); 
		}
		else {
			json.put("msg", "Not saved");
		}
		return new  ResponseEntity<Map<String, Object>>(json,HttpStatus.BAD_REQUEST); 
	}
	
	@PostMapping("/deactiverfid")
	public ResponseEntity<Map<String, Object>> deactive(
			@RequestParam("rfid") Long rfid,
			@RequestParam("modifiedby") Long modifiedby
			){
		Map<String,Object> json=new HashMap<String,Object>();
		Tblrfidmaster tblrfidmaster=tmtuTblrfidmasterService.statusChange(rfid, modifiedby, false);
		if(tblrfidmaster!=null) {
			json.put("msg", "saved");
			json.put("rfid", ""+tblrfidmaster.getRfidmasterid());
			json.put("amount", ""+tblrfidmaster.getAmount());
			json.put("rfidkey", ""+tblrfidmaster.getKeys());
			json.put("status", ""+tblrfidmaster.getStatus());
			return new  ResponseEntity<Map<String, Object>>(json,HttpStatus.OK); 
		}
		else {
			json.put("msg", "Not saved");
		}
		return new  ResponseEntity<Map<String, Object>>(json,HttpStatus.BAD_REQUEST); 
	}
	
	@PostMapping("/activerfid")
	public ResponseEntity<Map<String, Object>> active(
			@RequestParam("rfid") Long rfid,
			@RequestParam("modifiedby") Long modifiedby
			){
		Map<String,Object> json=new HashMap<String,Object>();
		Tblrfidmaster tblrfidmaster=tmtuTblrfidmasterService.statusChange(rfid, modifiedby, true);
		if(tblrfidmaster!=null) {
			json.put("msg", "saved");
			json.put("rfid", ""+tblrfidmaster.getRfidmasterid());
			json.put("amount", ""+tblrfidmaster.getAmount());
			json.put("rfidkey", ""+tblrfidmaster.getKeys());
			json.put("status", ""+tblrfidmaster.getStatus());
			return new  ResponseEntity<Map<String, Object>>(json,HttpStatus.OK); 
		}
		else {
			json.put("msg", "Not saved");
		}
		return new  ResponseEntity<Map<String, Object>>(json,HttpStatus.BAD_REQUEST); 
	}
	
	@GetMapping("/rfidbyid")
	public ResponseEntity<Map<String, Object>> rfidById(
			@RequestParam("rfid") Long rfid
			){
		Map<String,Object> json=new HashMap<String,Object>();
		Tblrfidmaster tblrfidmaster=tmtuTblrfidmasterService.getCardbyId(rfid);
		if(tblrfidmaster!=null) {
			json.put("msg", "Found");
			json.put("rfid", ""+tblrfidmaster.getRfidmasterid());
			json.put("amount", ""+tblrfidmaster.getAmount());
			json.put("rfidkey", ""+tblrfidmaster.getKeys());
			json.put("status", ""+tblrfidmaster.getStatus());
			return new  ResponseEntity<Map<String, Object>>(json,HttpStatus.OK); 
		}
		else {
			json.put("msg", "Not found");
		}
		return new  ResponseEntity<Map<String, Object>>(json,HttpStatus.BAD_REQUEST); 
	}
	
	@GetMapping("/rfidbykey")
	public ResponseEntity<Map<String, Object>> rfidByKey(
			@RequestParam("key") String keys
			){
		Map<String,Object> json=new HashMap<String,Object>();
		Tblrfidmaster tblrfidmaster=tmtuTblrfidmasterService.getCardByKey(keys);
		if(tblrfidmaster!=null) {
			json.put("msg", "Found");
			json.put("rfid", ""+tblrfidmaster.getRfidmasterid());
			json.put("amount", ""+tblrfidmaster.getAmount());
			json.put("rfidkey", ""+tblrfidmaster.getKeys());
			json.put("status", ""+tblrfidmaster.getStatus());
			return new  ResponseEntity<Map<String, Object>>(json,HttpStatus.OK); 
		}
		else {
			json.put("msg", "Not found");
		}
		return new  ResponseEntity<Map<String, Object>>(json,HttpStatus.BAD_REQUEST); 
	}
	
}
