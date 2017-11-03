package com.tmtu.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.models.Tbllogin;
import com.tmtu.models.Tbluserreporting;

public class TmtuTbluserreportingRepositoryImpl implements TmtuTbluserreportingRepositoryCustom {

	@Autowired
	TmtuTbluserreportingRepository tmtuTbluserreportingRepository;
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository;
	
	/*
	 * Logger for User creation and login
	 * */
	private static final Logger logger = LoggerFactory.getLogger("User Reporting Repository ");
	
	@Override
	public Tbluserreporting save(long loginid, long createdby, long reportto, Calendar datefrom, Calendar dateto) {
		Tbllogin tbllogin=  tmtuTblloginRepository.findOne(loginid);
		if(tbllogin==null)
		{
			return null;
		}
		Tbluserreporting tbluserreporting=new Tbluserreporting();
		tbluserreporting.setCreatedBy(createdby);
		tbluserreporting.setCreatedOn(Calendar.getInstance());
		tbluserreporting.setDateFrom(datefrom);
		tbluserreporting.setDateTo(dateto);
		tbluserreporting.setReportingTo(reportto);
		tbluserreporting.setLoginId(tbllogin);
		/*
		 * adding dependency foreign keys
		*/
		tbllogin.getTbluserreporting().add(tbluserreporting);
		try {
			tbluserreporting= tmtuTbluserreportingRepository.save(tbluserreporting);
			logger.info("Reporting Manager Successfully added id="+tbluserreporting.getUserreportingid());
			return tbluserreporting;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Tbluserreporting update(long reportid,long loginid, long modifiedby, long reportto, Calendar datefrom, Calendar dateto) {
		Tbllogin tbllogin=  tmtuTblloginRepository.findOne(loginid);
		if(tbllogin==null)
		{
			return null;
		}
		Tbluserreporting tbluserreporting=tmtuTbluserreportingRepository.findOne(reportid);
		if(tbluserreporting==null)
		{
			return null;
		}
		tbluserreporting.setDateFrom(datefrom);
		tbluserreporting.setDateTo(dateto);
		tbluserreporting.setReportingTo(reportto);
		tbluserreporting.setLoginId(tbllogin);
		tbluserreporting.setLastModifiedBy(modifiedby);
		tbluserreporting.setLastModifiedOn(Calendar.getInstance());
		try {
			tbluserreporting= tmtuTbluserreportingRepository.save(tbluserreporting);
			logger.info("Reporting Manager Successfully updated id="+tbluserreporting.getUserreportingid());
			return tbluserreporting;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
