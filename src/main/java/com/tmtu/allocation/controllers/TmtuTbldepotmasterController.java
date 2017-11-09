package com.tmtu.allocation.controllers;

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

import com.tmtu.allocation.models.Tbldepotmaster;
import com.tmtu.allocation.services.TmtuTbldepotmasterService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTbldepotmasterController {

	@Autowired
	TmtuTbldepotmasterService tmtuTbldepotmasterService;
	@PostMapping("/savedepot")
	public ResponseEntity<Map<String,Object>> save(@RequestParam("depotname")String depotName,@RequestParam("depotcode")String depotcode,@RequestParam("createdby")Long createdBy) {
		Tbldepotmaster tbldepot=tmtuTbldepotmasterService.save(depotName, depotcode, createdBy);
		Map<String,Object>json=new HashMap<String,Object>();
		if(tbldepot!=null)
		{
	    json.put("msg", "Saved");
		json.put("deportcode", tbldepot.getDepotcode());
		json.put("deportname", tbldepot.getDepotName());	
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
		}
		else {
			json.put("msg", "Not saved");
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/alldepot")
	public ResponseEntity<List<Map<String,Object>>> findAll()
	{
		List<Map<String,Object>> data=tmtuTbldepotmasterService.findAll();
		if(data.size()<1) {
			Map<String, Object> json=new HashMap<String,Object>();
			json.put("msg", "No Data");
			data.add(json);
			return new ResponseEntity<List<Map<String,Object>>>(data,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Map<String,Object>>>(data,HttpStatus.OK);
	}
	
	
}
