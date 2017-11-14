package com.tmtu.reconcilation.controllers;

import java.util.HashMap;
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

import com.tmtu.reconcilation.models.Tblcollection;
import com.tmtu.reconcilation.services.TmtuTblcollectionService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblcollectionController {

	@Autowired
	TmtuTblcollectionService tmtuTblcollectionService;

	@PostMapping("/savecollection")
	public ResponseEntity<Map<String,Object>> save(
			@RequestParam("waybillid") Long waybillid, 
			@RequestParam("dueamount") Double dueamount, 
			@RequestParam("actualamount") Double actualamount,
			@RequestParam("balanceamount") Double balanceamount, 
			@RequestParam("expensestype") String expensestype, 
			@RequestParam("expenseamount") Double expenseamount, 
			@RequestParam("createdby") Long createdby)
			{
		Tblcollection tblcollection= tmtuTblcollectionService.save(waybillid, dueamount, actualamount, balanceamount, expensestype, expenseamount, createdby);
		Map<String, Object> json=new HashMap<String,Object>();
		if(tblcollection==null) {
			json.put("msg", "Not saved");
			return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);	
		}
		else {
			json.put("collectionid",tblcollection.getCollectionid());
			json.put("waybillid",tblcollection.getTblwaybill().getWaybillnumber());
			json.put("dueamount",tblcollection.getDueamount());
			json.put("actualamount",tblcollection.getActualamount());
			json.put("balanceamount",tblcollection.getBalanceamount());
			json.put("expensestype",tblcollection.getExpensestype());
			json.put("expenseamount",tblcollection.getExpenseamount());
			json.put("createdby",tblcollection.getCreatedBy());
			json.put("createdon",tblcollection.getCreatedOn().getTimeInMillis());
			
		}
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);	
	}
	@GetMapping("/getcollections")
	public ResponseEntity<Page<Map<String, Object>>> getAllCollection(Pageable page){
		 Page<Map<String,Object>> collectiondata=tmtuTblcollectionService.getAllCollection(page);
		 return new ResponseEntity<Page<Map<String, Object>>>(collectiondata,HttpStatus.OK);
	}
}
