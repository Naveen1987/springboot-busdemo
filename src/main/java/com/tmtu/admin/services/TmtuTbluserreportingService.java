package com.tmtu.admin.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.admin.models.Tbluserreporting;
import com.tmtu.admin.repositories.TmtuTbluserreportingRepository;

@Service
public class TmtuTbluserreportingService {

	@Autowired
	TmtuTbluserreportingRepository tmtuTbluserreportingRepository;
	
	public Tbluserreporting save(long loginid,long createdby,long reportto,long datefrom,long dateto) {
		Calendar datef=Calendar.getInstance();
		datef.setTimeInMillis(datefrom);
		Calendar datet=Calendar.getInstance();
		datef.setTimeInMillis(dateto);
		Tbluserreporting tbluserreporting=tmtuTbluserreportingRepository.save(loginid, createdby, reportto,datef , datet);
		return tbluserreporting;
	}
	public Tbluserreporting update(long reportid,long loginid,long modifiedby,long reportto,long datefrom,long dateto) {
		Calendar datef=Calendar.getInstance();
		datef.setTimeInMillis(datefrom);
		Calendar datet=Calendar.getInstance();
		datef.setTimeInMillis(dateto);
		Tbluserreporting tbluserreporting=tmtuTbluserreportingRepository.update(reportid, loginid, modifiedby, reportto, datef, datet);
		return tbluserreporting;
	}
	public Tbluserreporting getReportingManagerByLoginId(long loginid) {
		return tmtuTbluserreportingRepository.getReportingManagerByLoginId(loginid);
	}
}
