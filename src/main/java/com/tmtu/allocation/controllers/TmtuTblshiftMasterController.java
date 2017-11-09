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

import com.tmtu.allocation.models.TblshiftMaster;
import com.tmtu.allocation.services.TmtuTblshiftMasterService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblshiftMasterController {

	@Autowired
	TmtuTblshiftMasterService tmtuTblshiftMasterService;
	@PostMapping("/saveshift")
	public ResponseEntity<Map<String,Object>> save(@RequestParam("shifttype")Long shiftType, @RequestParam("createdby")Long createdBy) {
		TblshiftMaster tbl=tmtuTblshiftMasterService.save(shiftType, createdBy);
		if(tbl!=null) {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("shifttype", tbl.getShiftType());
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
		}
		Map<String,Object>json=new HashMap<String,Object>();
		json.put("msg", "Not Saved");
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/allshift")
	public ResponseEntity<List<Map<String,Object>>> findAll(){
		List<Map<String,Object>> data=tmtuTblshiftMasterService.findAll();
		if(data.size()<1) {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("msg", "Not Data");
			data.add(json);
			return new ResponseEntity<List<Map<String,Object>>>(data, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Map<String,Object>>>(data, HttpStatus.OK);
		
	}
	
}
