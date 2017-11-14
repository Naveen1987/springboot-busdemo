package com.tmtu.reconcilation.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tmtu.bus_master.models.Tblconcessionmaster;
import com.tmtu.bus_master.repositories.TmtuTblconcessionmasterRepository;
import com.tmtu.reconcilation.models.Tbltransaction;
import com.tmtu.reconcilation.repositories.TmtuTbltransactionRepository;

@Service
public class TmtuTbltransactionService {
	
	@Autowired
	TmtuTbltransactionRepository tmtuTbltransactionRepository;
	@Autowired
	TmtuTblconcessionmasterRepository tmtuTblconcessionmasterRepository ; 
	
	private static final Logger logger=LoggerFactory.getLogger("Transaction Service");
	
	public Tbltransaction save(
			Long transactionid,
			Long waybillnumber,
			String fromstopage,
			String tostopage,
			Long totaltickets,
			Double totalamount,
			String paymenttype,
			Long createdby,
			Long createdOn,
			Long modifiedby
			) {
		Calendar cCreatedOn=Calendar.getInstance();
		cCreatedOn.setTimeInMillis(createdOn);
		Tbltransaction tbltransaction=tmtuTbltransactionRepository.save(transactionid, waybillnumber, fromstopage, tostopage, totaltickets, totalamount, paymenttype, createdby, cCreatedOn, modifiedby);
		return tbltransaction;
	}
	
	public Tbltransaction save(ArrayList<Map<String,Object>> tranactions) {
		tranactions.forEach(tranaction->{
			tranaction.entrySet().stream().forEach(trans->{
				Long transactionid=null,waybillnumber=null,totaltickets=null,createdby=null,modifiedby=null;
				Double totalamount=null;
				Calendar createdOn=null;
				String fromstopage=null,paymenttype=null,tostopage=null;
				switch(trans.getKey().toString()) {
				case "transactionid":
					if(trans.getValue()!=null)
					{transactionid=new Long(trans.getValue().toString());}
					break;
				case "waybillnumber":
					if(trans.getValue()!=null)
					{waybillnumber=new Long(trans.getValue().toString());}
					break;
				case "totaltickets":
					if(trans.getValue()!=null)
					{totaltickets=new Long(trans.getValue().toString());}
					break;
				case "totalamount":
					if(trans.getValue()!=null)
					{totalamount=new Double(trans.getValue().toString());}
					break;
				case "createdby":
					if(trans.getValue()!=null)
					{createdby=new Long(trans.getValue().toString());}
					break;
				case "createdOn":
					if(trans.getValue()!=null)
					{
					 createdOn=Calendar.getInstance();
					 createdOn.setTimeInMillis(new Long(trans.getValue().toString()));
					 }
					break;	
				case "fromstopage":
					if(trans.getValue()!=null)
					{fromstopage=trans.getValue().toString();}
					break;
				case "paymenttype":
					if(trans.getValue()!=null)
					{paymenttype=trans.getValue().toString();}
					break;
				case "tostopage":
					if(trans.getValue()!=null)
					{tostopage=trans.getValue().toString();}
					break;		
				case "modifiedby":
					if(trans.getValue()!=null)
					{modifiedby=new Long(trans.getValue().toString());}
					break;
				}
				Tbltransaction tbltransaction=tmtuTbltransactionRepository.save(transactionid, waybillnumber, fromstopage, tostopage, totaltickets, totalamount, paymenttype, createdby, createdOn, modifiedby);
				if(tbltransaction!=null) {
					logger.info("Transaction saved Id:"+tbltransaction.getTransactionid());
				}
				else {
					logger.error("Transaction not saved Id:"+transactionid);
				}
				
				if(trans.getKey().equalsIgnoreCase("tickets")) {
					List<Map<String,Object>> tickets=(List<Map<String,Object>>)trans.getValue();
					tickets.stream().forEach(ticket->{
						ticket.entrySet().stream().forEach(tic->{
							Long ticketid=null,concessiontype=null,tcreatedby=null;
							Calendar tcreatedOn=Calendar.getInstance();
							String tickettype=null;
							Double fare=null;
							
							
							
						});
					});
			    }
				
			});
		});
		return null;
	}
	
	public Page<Map<String, Object>> getTranactionByWayWill(Long waywillnumber,Pageable page){
		Page<Tbltransaction> trans=tmtuTbltransactionRepository.getTranactionByWayWill(waywillnumber, page);
		Page<Map<String, Object>> data=trans.map(new Converter<Tbltransaction, Map<String, Object>>() {
			@Override
			public Map<String, Object> convert(Tbltransaction record) {
				Map<String, Object> json=new HashMap<String,Object>();
				json.put("transactionid", record.getTransactionid());
				json.put("waybillnumber",record.getTblwaybill().getWaybillnumber());
				json.put("waybilldate",record.getTblwaybill().getWayBillDate());
				json.put("fromstopage",record.getFromstopage());
				json.put("tostopage",record.getTostopage());
				json.put("totaltickets",record.getTotaltickets());
				json.put("totalamount",record.getTotalamount());
				json.put("paymenttype",record.getPaymenttype());
				json.put("createdby",record.getCreatedby());
				json.put("createdon",record.getCreatedOn().getTimeInMillis());
				json.put("modifiedby",record.getLastModifiedBy());
				return json;
			}
		
		});
		return data;
	}
	
	public Map<String, Object> getTiketUnderTranaction(Long tranactionid){
		Tbltransaction record=tmtuTbltransactionRepository.findOne(tranactionid);
		Map<String, Object> json=new HashMap<String,Object>();
				if(record==null) {
					json.put("msg", "Not found");
				}
				else {
					json.put("msg", "Found");
					json.put("transactionid", record.getTransactionid());
					json.put("waybillnumber",record.getTblwaybill().getWaybillnumber());
					json.put("waybilldate",record.getTblwaybill().getWayBillDate());
					json.put("fromstopage",record.getFromstopage());
					json.put("tostopage",record.getTostopage());
					json.put("totaltickets",record.getTotaltickets());
					json.put("totalamount",record.getTotalamount());
					json.put("paymenttype",record.getPaymenttype());
					json.put("createdby",record.getCreatedby());
					json.put("createdon",record.getCreatedOn().getTimeInMillis());
					json.put("modifiedby",record.getLastModifiedBy());
					ArrayList<Map<String, Object>> tickets=new ArrayList<Map<String,Object>>();
					record.getTbltickets().forEach(ticket->{
						Map<String,Object> tic=new HashMap<String,Object>();
						tic.put("ticketid",ticket.getTicketid());
						tic.put("transactionid",ticket.getTbltransaction().getTransactionid());
						tic.put("tickettype",ticket.getTickettype());
						tic.put("fare",ticket.getFare());
						Tblconcessionmaster concessionmaster =tmtuTblconcessionmasterRepository.findOne(ticket.getConcession());
						if(concessionmaster!=null) {
							tic.put("concessiontype",concessionmaster.getConcessionCode());
							tic.put("concessionname",concessionmaster.getConcessionName());
						}
						
						tic.put("createdby",ticket.getCreatedby());
						tic.put("createdOn",ticket.getCreatedOn().getTimeInMillis());
						tickets.add(tic);
					});
					json.put("tickets",tickets);
				}
		return json;
	}
}
