package com.tmtu.reconcilation.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tmtu.reconcilation.models.Tbltransaction;
import com.tmtu.reconcilation.services.TmtuTbltransactionService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTbltransactionController {

	@Autowired 
	TmtuTbltransactionService tmtuTbltransactionService;
	
	/*@PostMapping("/savetranaction")
	public ResponseEntity<Map<String, Object>> save(
		@RequestParam("transactionid") Long transactionid,
		@RequestParam("waybillnumber") Long waybillnumber,
		@RequestParam("fromstopage") String fromstopage,
		@RequestParam("tostopage") String tostopage,
		@RequestParam("totaltickets") Long totaltickets,
		@RequestParam("totalamount") Double totalamount,
		@RequestParam("paymenttype") String paymenttype,
		@RequestParam("createdby") Long createdby,
		@RequestParam("createdon") Long createdOn,
		@RequestParam(value="modifiedby",required=false) Long modifiedby
			) {
	Tbltransaction tbltransaction= tmtuTbltransactionService.save(transactionid, waybillnumber, fromstopage, tostopage, totaltickets, totalamount, paymenttype, createdby, createdOn, modifiedby);
	Map<String, Object> json=new HashMap<String,Object>();
	if(tbltransaction==null) {
		json.put("msg", "Not Saved");
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
	}
	json.put("msg", "Saved");
	json.put("transactionid",tbltransaction.getTransactionid());
	Map<String,Object>waywill=new HashMap<String,Object>();
	waywill.put("waybillnumber",tbltransaction.getTblwaybill().getWaybillnumber());
	waywill.put("waywilldate",tbltransaction.getTblwaybill().getWayBillDate().getTimeInMillis());
	json.put("waywilldetail", waywill);
	json.put("fromstopage",tbltransaction.getFromstopage());
	json.put("tostopage",tbltransaction.getTostopage());
	json.put("totaltickets",tbltransaction.getTotaltickets());
	json.put("totalamount",tbltransaction.getTotalamount());
	json.put("paymenttype",tbltransaction.getPaymenttype());
	json.put("createdby",tbltransaction.getCreatedby());
	json.put("createdon",tbltransaction.getCreatedOn().getTimeInMillis());
	json.put("modifiedby",tbltransaction.getLastModifiedBy());
	return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
	}*/
	@PostMapping("/savetranaction")
	public ResponseEntity<Map<String, Object>> save(RequestEntity<ArrayList<Map<String,Object>>> transactions) {
	ArrayList<Map<String,Object>> tranactionJson=transactions.getBody();
	Tbltransaction tbltransaction= tmtuTbltransactionService.save(tranactionJson);
	Map<String, Object> json=new HashMap<String,Object>();
	if(tbltransaction==null) {
		json.put("msg", "Not Saved");
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
	}
	json.put("msg", "Saved");
	json.put("transactionid",tbltransaction.getTransactionid());
	Map<String,Object>waywill=new HashMap<String,Object>();
	waywill.put("waybillnumber",tbltransaction.getTblwaybill().getWaybillnumber());
	waywill.put("waywilldate",tbltransaction.getTblwaybill().getWayBillDate().getTimeInMillis());
	json.put("waywilldetail", waywill);
	json.put("fromstopage",tbltransaction.getFromstopage());
	json.put("tostopage",tbltransaction.getTostopage());
	json.put("totaltickets",tbltransaction.getTotaltickets());
	json.put("totalamount",tbltransaction.getTotalamount());
	json.put("paymenttype",tbltransaction.getPaymenttype());
	json.put("createdby",tbltransaction.getCreatedby());
	json.put("createdon",tbltransaction.getCreatedOn().getTimeInMillis());
	json.put("modifiedby",tbltransaction.getLastModifiedBy());
	return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
	}
	
	@GetMapping("/tranactiononwaywill")
	public ResponseEntity<Page<Map<String, Object>>> getTranactionByWayWill(@RequestParam("waywillno") Long waywillnumber,Pageable page){
		Page<Map<String, Object>> data=tmtuTbltransactionService.getTranactionByWayWill(waywillnumber, page);
		return new ResponseEntity<Page<Map<String,Object>>>(data, HttpStatus.OK);
	}
	
	@GetMapping("/tranactionbyid")
	public ResponseEntity<Map<String, Object>> getTiketUnderTranaction(@RequestParam("tranactionid")Long tranactionid){
		Map<String, Object> data=tmtuTbltransactionService.getTiketUnderTranaction(tranactionid);
		return new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);
	}
	
}
