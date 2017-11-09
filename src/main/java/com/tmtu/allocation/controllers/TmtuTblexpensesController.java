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

import com.tmtu.allocation.models.Tblexpenses;
import com.tmtu.allocation.services.TmtuTblexpensesService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblexpensesController {
@Autowired
TmtuTblexpensesService tmtuTblexpensesService;


	@PostMapping("/saveexpense")
	public ResponseEntity<Map<String,Object>> save(
		@RequestParam("expensetype")String expensetype,@RequestParam("createdby") Long createdBy) {
		
		Tblexpenses tblexpenses=tmtuTblexpensesService.save(expensetype, createdBy);
		Map<String,Object>json=new HashMap<String,Object>();
		if(tblexpenses!=null)
		{
	    json.put("msg", "Saved");
		json.put("expensetype", tblexpenses.getExpensetype());
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
		}
		else {
			json.put("msg", "Not saved");
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/allexpenses")
	public ResponseEntity<List<Map<String,Object>>> findAll()
	{
		
		List<Map<String,Object>> data=tmtuTblexpensesService.findAll();
		if(data.size()<1) {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("msg", "Not Data");
			data.add(json);
			return new ResponseEntity<List<Map<String,Object>>>(data, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Map<String,Object>>>(data,HttpStatus.OK);
	}
	
}
