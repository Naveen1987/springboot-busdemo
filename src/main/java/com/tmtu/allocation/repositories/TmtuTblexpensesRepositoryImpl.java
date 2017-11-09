package com.tmtu.allocation.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.admin.models.Tbllogin;
import com.tmtu.admin.repositories.TmtuTblloginRepository;
import com.tmtu.allocation.models.Tblexpenses;

public class TmtuTblexpensesRepositoryImpl implements TmtuTblexpensesRepositoryCustom {

	@Autowired
	TmtuTblexpensesRepository tmtuTblexpensesRepository;
	
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository;
	
	private static final Logger logger=LoggerFactory.getLogger("Expenses Repository"); 
	
	
	@Override
	public Tblexpenses save(String expensetype, Long createdBy) {
		Tbllogin tbllogin=tmtuTblloginRepository.findOne(createdBy);
		if(tbllogin==null) {
			logger.error("Created by is not exists Id="+createdBy);
			return null;
		}
		 Tblexpenses  tblexpenses=new Tblexpenses();
		 tblexpenses.setExpensetype(expensetype);
		 tblexpenses.setCreatedBy(createdBy);
		 tblexpenses.setCreatedOn(Calendar.getInstance());
		 try {
			 tblexpenses =tmtuTblexpensesRepository.save(tblexpenses);
			 logger.info("Expenses saved Id is="+tblexpenses.getExpenseid());
			 return tblexpenses;
		 }catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
