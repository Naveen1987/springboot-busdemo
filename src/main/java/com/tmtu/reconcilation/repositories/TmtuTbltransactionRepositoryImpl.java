package com.tmtu.reconcilation.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.allocation.models.Tblwaybill;
import com.tmtu.allocation.repositories.TmtuTblwaybillRepository;
import com.tmtu.reconcilation.models.Tbltransaction;

public class TmtuTbltransactionRepositoryImpl implements TmtuTbltransactionRepositoryCustom {

	@Autowired
	TmtuTblwaybillRepository tmtuTblwaybillRepository;
	
	@Autowired
	TmtuTbltransactionRepository tmtuTbltransactionRepository;
	
	private static final Logger logger=LoggerFactory.getLogger("Transaction Repository");
	
	@Override
	public Tbltransaction save(Long transactionid, Long waybillnumber, String fromstopage, String tostopage,
			Long totaltickets, Double totalamount, String paymenttype, Long createdby, Calendar createdOn,Long modifiedby) {
	Tblwaybill tblwaywill=tmtuTblwaybillRepository.findOne(waybillnumber);
	if(tblwaywill==null) {
		logger.error("Not correspondent Way will with waywill Number:"+waybillnumber);
		return null;
	}
	Tbltransaction tbltransaction=new Tbltransaction();
	tbltransaction.setTransactionid(transactionid);
	tbltransaction.setFromstopage(fromstopage);
	tbltransaction.setTostopage(tostopage);
	tbltransaction.setTotaltickets(totaltickets);
	tbltransaction.setPaymenttype(paymenttype);
	tbltransaction.setTotalamount(totalamount);
	tbltransaction.setCreatedby(createdby);
	tbltransaction.setCreatedOn(createdOn);
	if(modifiedby!=null) {
		tbltransaction.setLastModifiedBy(modifiedby);
		tbltransaction.setLastModifiedOn(Calendar.getInstance());
	}
	tbltransaction.setTblwaybill(tblwaywill);
	
	//add refrence
	//tblwaywill.addTransaction(tbltransaction);
	try {
		tbltransaction=tmtuTbltransactionRepository.save(tbltransaction);
		logger.info("Transaction save successfully ID:"+tbltransaction.getTransactionid());
		return tbltransaction;
		
	}catch(Exception e) {
		logger.error(e.getMessage());
	}
	return null;
	}
}
