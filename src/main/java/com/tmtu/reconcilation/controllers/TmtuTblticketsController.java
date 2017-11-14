package com.tmtu.reconcilation.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tmtu.reconcilation.models.Tbltickets;
import com.tmtu.reconcilation.services.TmtuTblticketsService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblticketsController {

	@Autowired
	TmtuTblticketsService tmtuTblticketsService;
	
	@PostMapping("/saveticket")
	public ResponseEntity<Map<String, Object>> save(
			@RequestParam("ticketid") Long ticketid, 
			@RequestParam("transactionid") Long transactionid, 
			@RequestParam("tickettype") String tickettype, 
			@RequestParam("fare") Double fare, 
			@RequestParam("concessiontype") Long concessiontype,
			@RequestParam("createdby") Long createdby, 
			@RequestParam("createdon") Long createdOn, 
			@RequestParam(value="modifiedby",required=false) Long modifiedby) {
	Tbltickets ticket=tmtuTblticketsService.save(ticketid, transactionid, tickettype, fare, concessiontype, createdby, createdOn, modifiedby);
	Map<String,Object> json=new HashMap<String,Object>();
	if(ticket==null) {
		json.put("msg", "Not Saved Id:"+ticketid);
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.BAD_REQUEST);
	}else
	{
		json.put("ticketid",ticket.getTicketid());
		json.put("transactionid",ticket.getTbltransaction().getTransactionid());
		json.put("tickettype",ticket.getTickettype());
		json.put("fare",ticket.getFare());
		json.put("createdby",ticket.getCreatedby());
		json.put("createdOn",ticket.getCreatedOn().getTimeInMillis());
	}
		return new ResponseEntity<Map<String,Object>>(json,HttpStatus.OK);
	}
	
}
