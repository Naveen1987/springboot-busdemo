package com.tmtu.reconcilation.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tmtu.reconcilation.models.Tblcollection;
import com.tmtu.reconcilation.repositories.TmtuTblcollectionRepository;

@Service
public class TmtuTblcollectionService {

	@Autowired
	TmtuTblcollectionRepository tmtuTblcollectionRepository;
	
	public Tblcollection save(Long waybillid, Double dueamount, Double actualamount,
			Double balanceamount, String expensestype, Double expenseamount, Long createdby) {
		return tmtuTblcollectionRepository.save(waybillid, dueamount, actualamount, balanceamount, expensestype, expenseamount, createdby);
	}
	
	public Page<Map<String, Object>> getAllCollection(Pageable page){
		 Page<Tblcollection>collections=tmtuTblcollectionRepository.findAll(page);
		 Page<Map<String,Object>> collectiondata=collections.map(new Converter<Tblcollection, Map<String,Object>>() {

			@Override
			public Map<String, Object> convert(Tblcollection tblcollection) {
				Map<String, Object> json=new HashMap<String, Object>();
				json.put("collectionid",tblcollection.getCollectionid());
				json.put("waybillid",tblcollection.getTblwaybill().getWaybillnumber());
				json.put("dueamount",tblcollection.getDueamount());
				json.put("actualamount",tblcollection.getActualamount());
				json.put("balanceamount",tblcollection.getBalanceamount());
				json.put("expensestype",tblcollection.getExpensestype());
				json.put("expenseamount",tblcollection.getExpenseamount());
				json.put("createdby",tblcollection.getCreatedBy());
				json.put("createdon",tblcollection.getCreatedOn().getTimeInMillis());
				json.put("modifedby",tblcollection.getLastModifiedBy());
				return json;
			}
		
		 });
		 return collectiondata;
	}
}
