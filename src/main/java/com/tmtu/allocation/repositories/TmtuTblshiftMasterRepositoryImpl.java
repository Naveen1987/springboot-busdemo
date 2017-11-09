package com.tmtu.allocation.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.admin.models.Tbllogin;
import com.tmtu.admin.repositories.TmtuTblloginRepository;
import com.tmtu.allocation.models.TblshiftMaster;

public class TmtuTblshiftMasterRepositoryImpl implements TmtuTblshiftMasterRepositoryCustom {

	@Autowired
	TmtuTblshiftMasterRepository tmtuTblshiftMasterRepository;
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository;
	
	private static final Logger logger=LoggerFactory.getLogger("Shift Repository"); 
	@Override
	public TblshiftMaster save(Long shiftType, Long createdBy) {
		Tbllogin tbllogin=tmtuTblloginRepository.findOne(createdBy);
		if(tbllogin==null) {
			logger.error("Created by is not exists Id="+createdBy);
			return null;
		}
		TblshiftMaster tblshiftMaster=new TblshiftMaster();
		tblshiftMaster.setCreatedBy(createdBy);
		tblshiftMaster.setCreatedOn(Calendar.getInstance());
		tblshiftMaster.setShiftType(shiftType);
		try {
			tblshiftMaster=tmtuTblshiftMasterRepository.save(tblshiftMaster);
			logger.info("Shift saved Id is:"+tblshiftMaster.getShiftId());
			return tblshiftMaster;
		}
		catch (Exception e) {
		logger.error(e.getMessage());
		}
		return null;
	}

}
