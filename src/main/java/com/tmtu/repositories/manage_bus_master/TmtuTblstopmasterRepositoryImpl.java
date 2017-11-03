package com.tmtu.repositories.manage_bus_master;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.models.Tbllogin;
import com.tmtu.models.manage_bus_master.Tblroutemaster;
import com.tmtu.models.manage_bus_master.Tblstopmaster;
import com.tmtu.repositories.TmtuTblloginRepository;

public class TmtuTblstopmasterRepositoryImpl implements TmtuTblstopmasterRepositoryCustom {
	@Autowired
	TmtuTblroutemasterRepository tmtuTblroutemasterRepository;
	@Autowired
	TmtuTblstopmasterRepository  tmtuTblstopmasterRepository;
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository;
	
	
	private static final Logger logger=LoggerFactory.getLogger("Stop Master Repository"); 
	
	public Tblstopmaster save(Long routeid,Long createdby, Long busstopno, String busstopcode,String busstopname,Long km,Long sequencenumber,Boolean interstatestop) {
		Tblroutemaster tblroutemaster=tmtuTblroutemasterRepository.findOne(routeid);
		if(tblroutemaster==null) {
		logger.error("route id Don't exists id:"+routeid);
		return null;
		}
		
		Tbllogin tbllogin= tmtuTblloginRepository.findOne(createdby);
		if(tbllogin==null) {
			logger.error("User don't exists id:"+createdby);
			return null;
		}
		Tblstopmaster tblstopmaster=tmtuTblstopmasterRepository.getByrouteidandBusstopcode(routeid, busstopcode);
		if(tblstopmaster!=null) {
			logger.error("Same Busstop on same route Stopid:"+tblstopmaster.getStopid());
			return null;
		}
		tblstopmaster=new Tblstopmaster();
		tblstopmaster.setCreatedBy(createdby);
		tblstopmaster.setCreatedOn(Calendar.getInstance());
		tblstopmaster.setBusStopNumber(busstopno);
		tblstopmaster.setBusStopCode(busstopcode);
		tblstopmaster.setBusStopName(busstopname);
		tblstopmaster.setKm(km);
		tblstopmaster.setSequenceNumber(sequencenumber);
		tblstopmaster.setInterStateStop(interstatestop);
		tblstopmaster.setTblroutemaster(tblroutemaster);
		//adding reference
		tblroutemaster.addTblstopmaster(tblstopmaster);
		try {
			tblstopmaster=tmtuTblstopmasterRepository.save(tblstopmaster);
			logger.info("stop saved:"+tblstopmaster.getStopid());
			return tblstopmaster;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return null;
	}
	
	
	public Tblstopmaster update(Long stopid,Long routeid,Long modifiedby, Long busstopno, String busstopcode,String busstopname,Long km,Long sequencenumber,Boolean interstatestop) {
		Tblstopmaster tblstopmaster=tmtuTblstopmasterRepository.findOne(stopid);
		if(tblstopmaster==null) {
			logger.error("Stop id Don't exists id:"+stopid);
			return null;
		}
		if(routeid!=null) {
			Tblroutemaster tblroutemaster=tmtuTblroutemasterRepository.findOne(routeid);
			if(tblroutemaster==null) {
				logger.error("route id Don't exists id:"+routeid);
				return null;
			}
			tblstopmaster.setTblroutemaster(tblroutemaster);
			//adding reference
			tblroutemaster.addTblstopmaster(tblstopmaster);
		}
		Tbllogin tbllogin= tmtuTblloginRepository.findOne(modifiedby);
		if(tbllogin==null) {
			logger.error("User don't exists id:"+modifiedby);
			return null;
		}
		tblstopmaster.setLastModifiedBy(modifiedby);
		tblstopmaster.setLastModifiedOn(Calendar.getInstance());
		if(busstopno!=null&&busstopcode!=null&&busstopname!=null) {
			tblstopmaster.setBusStopNumber(busstopno);
			tblstopmaster.setBusStopCode(busstopcode);
			tblstopmaster.setBusStopName(busstopname);
		}
		if(km!=null) {
		tblstopmaster.setKm(km);
		}
		if(sequencenumber!=null) {
		tblstopmaster.setSequenceNumber(sequencenumber);
		}
		if(interstatestop!=null) {
		tblstopmaster.setInterStateStop(interstatestop);
		}
		
		try {
			tblstopmaster=tmtuTblstopmasterRepository.save(tblstopmaster);
			logger.info("stop Updated:"+tblstopmaster.getStopid());
			return tblstopmaster;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return null;
	}
}
