package com.tmtu.reconcilation.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.allocation.models.Tblwaybill;
import com.tmtu.allocation.repositories.TmtuTblwaybillRepository;
import com.tmtu.reconcilation.models.Tblcollection;

public class TmtuTblcollectionRepositoryImpl implements TmtuTblcollectionRepositoryCustom{

	
	@Autowired
	TmtuTblcollectionRepository tmtuTblcollectionRepository;
	@Autowired
	TmtuTblwaybillRepository  tmtuTblwaybillRepository;
	
	private static final Logger logger=LoggerFactory.getLogger("Collection Repository");
	
	@Override
	public Tblcollection save(Long waybillid, Double dueamount, Double actualamount,
			Double balanceamount, String expensestype, Double expenseamount, Long createdby) {
		Tblwaybill tblwaybill=tmtuTblwaybillRepository.findOne(waybillid);
		if(tblwaybill==null) {
			logger.error("No waywill exists for this Id:"+waybillid);
			return null;
		}
		Tblcollection tblcollection=new Tblcollection();
		tblcollection.setDueamount(dueamount);
		tblcollection.setActualamount(actualamount);
		tblcollection.setBalanceamount(balanceamount);
		tblcollection.setExpenseamount(expenseamount);
		tblcollection.setExpensestype(expensestype);
		tblcollection.setCreatedBy(createdby);
		tblcollection.setCreatedOn(Calendar.getInstance());
		tblcollection.setTblwaybill(tblwaybill);
		//add refrence
		tblwaybill.addCollection(tblcollection);
		try {
			tblcollection=tmtuTblcollectionRepository.save(tblcollection);
			logger.info("Collection saved with ID:"+tblcollection.getCollectionid());
			return tblcollection;
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
		return null;
	}

}
