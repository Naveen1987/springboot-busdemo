package com.tmtu.bus_master.repositories;



import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.admin.models.Tbllogin;
import com.tmtu.admin.repositories.TmtuTblloginRepository;
import com.tmtu.bus_master.models.Tblbustypemaster;
import com.tmtu.bus_master.models.Tblroutemaster;

public class TmtuTblroutemasterRepositoryImpl implements TmtuTblroutemasterRepositoryCustom {

	@Autowired
	TmtuTblroutemasterRepository tmtuTblroutemasterRepository;  
	@Autowired
	TmtuTblbustypemasterRepository tmtuTblbustypemasterRepository;
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository;
	
	
	private static final Logger logger=LoggerFactory.getLogger("Route Master Repository");
	@Override
	public Tblroutemaster save(long busTypeId, long routeNumber, String firstBusStopCode, String firstusStopName,
			long totalStopCount, String lastBusStopCode, String lastBusStopName, long createdBy) {
		Tbllogin tbllogin=tmtuTblloginRepository.findOne(createdBy);
		if(tbllogin==null) {
			logger.error("Created By not exists:"+createdBy);
			return null;
		}
		Tblbustypemaster tblbustypemaster=tmtuTblbustypemasterRepository.findOne(busTypeId);
		if(tblbustypemaster==null) {
			logger.error("No Bustype is exists:"+busTypeId);
			return null;
		}
		Tblroutemaster tblroutemaster=new Tblroutemaster();
		tblroutemaster.setRouteNumber(routeNumber);
		tblroutemaster.setFirstBusStopCode(firstBusStopCode);
		tblroutemaster.setFirstBusStopName(firstusStopName);
		tblroutemaster.setLastBusStopCode(lastBusStopCode);
		tblroutemaster.setLastBusStopName(lastBusStopName);
		tblroutemaster.setTotalStopCount(totalStopCount);
		tblroutemaster.setCreatedBy(createdBy);
		tblroutemaster.setCreatedOn(Calendar.getInstance());
		tblroutemaster.setTlbbustypemaster(tblbustypemaster);
		//adding reference to bustype 
		tblbustypemaster.addTblroutemaster(tblroutemaster);
		try {
			tblroutemaster=tmtuTblroutemasterRepository.save(tblroutemaster);
			logger.info("Route no ("+routeNumber+") with id:"+tblroutemaster.getRouteid());
			return tblroutemaster;
			
		}catch (Exception e) {
		logger.error(e.getMessage());
		}
		
		return null;
	}

	
	@Override
	public Tblroutemaster update(Long routeid, Long busTypeId, String firstBusStopCode, String firstusStopName,
			Long totalStopCount, String lastBusStopCode, String lastBusStopName, Long modifiedBy) {
		
		Tblroutemaster tblroutemaster=tmtuTblroutemasterRepository.findOne(routeid);
		if(tblroutemaster==null) {
			logger.error("RouteId not exists:"+routeid);
			return null;
		}
		Tbllogin tbllogin=tmtuTblloginRepository.findOne(modifiedBy);
		if(tbllogin==null) {
			logger.error("Created By not exists:"+modifiedBy);
			return null;
		}
		
		if(busTypeId!=null) {
		Tblbustypemaster tblbustypemaster=tmtuTblbustypemasterRepository.findOne(busTypeId);
		if(tblbustypemaster==null) {
			logger.error("No Bustype is exists:"+busTypeId);
			return null;
		}
		else {
			tblroutemaster.setTlbbustypemaster(tblbustypemaster);
			//adding reference to bustype 
			tblbustypemaster.addTblroutemaster(tblroutemaster);
		 }
		}
		
		if(firstBusStopCode!=null&&firstusStopName!=null) {
		tblroutemaster.setFirstBusStopCode(firstBusStopCode);
		tblroutemaster.setFirstBusStopName(firstusStopName);
		}
		
		if(lastBusStopCode!=null&&lastBusStopName!=null) {
		tblroutemaster.setLastBusStopCode(lastBusStopCode);
		tblroutemaster.setLastBusStopName(lastBusStopName);
		}
		
		if(totalStopCount!=null) {
		tblroutemaster.setTotalStopCount(totalStopCount);
		}
		
		tblroutemaster.setLastModifiedBy(modifiedBy);
		tblroutemaster.setLastModifiedOn(Calendar.getInstance());
		
		try {
			tblroutemaster=tmtuTblroutemasterRepository.save(tblroutemaster);
			//logger.info("Route no ("+routeNumber+") with id:"+tblroutemaster.getRouteid());
			return tblroutemaster;
			
		}catch (Exception e) {
		logger.error(e.getMessage());
		}
    return null;
	}
	
	
	@Override
	public Tblroutemaster updateBusType(long routeId, long busTypeId, long modifiedby) {
		Tblroutemaster tblroutemaster=tmtuTblroutemasterRepository.findOne(routeId);
		if(tblroutemaster==null) {
			logger.error("RouteId not exists:"+routeId);
			return null;
		}
		Tbllogin tbllogin=tmtuTblloginRepository.findOne(modifiedby);
		if(tbllogin==null) {
			logger.error("Created By not exists:"+modifiedby);
			return null;
		}
		Tblbustypemaster tblbustypemaster=tmtuTblbustypemasterRepository.findOne(busTypeId);
		if(tblbustypemaster==null) {
			logger.error("No Bustype is exists:"+busTypeId);
			return null;
		}
		
		tblroutemaster.setLastModifiedBy(modifiedby);
		tblroutemaster.setLastModifiedOn(Calendar.getInstance());
		tblroutemaster.setTlbbustypemaster(tblbustypemaster);
		//adding reference to bustype 
		tblbustypemaster.addTblroutemaster(tblroutemaster);
		try {
			tblroutemaster=tmtuTblroutemasterRepository.save(tblroutemaster);
			logger.info("Updated Route no ("+tblroutemaster.getRouteNumber()+") with id:"+tblroutemaster.getRouteid());
			return tblroutemaster;
			
		}catch (Exception e) {
		logger.error(e.getMessage());
		}
		
		return null;
	}

	@Override
	public Tblroutemaster updateFirstStop(long routeId, String firstBusStopCode, String firstusStopName,
			long modifiedby) {
		Tblroutemaster tblroutemaster=tmtuTblroutemasterRepository.findOne(routeId);
		if(tblroutemaster==null) {
			logger.error("RouteId not exists:"+routeId);
			return null;
		}
		Tbllogin tbllogin=tmtuTblloginRepository.findOne(modifiedby);
		if(tbllogin==null) {
			logger.error("Created By not exists:"+modifiedby);
			return null;
		}
		
		tblroutemaster.setFirstBusStopCode(firstBusStopCode);
		tblroutemaster.setFirstBusStopName(firstusStopName);
		tblroutemaster.setLastModifiedBy(modifiedby);
		tblroutemaster.setLastModifiedOn(Calendar.getInstance());
		
		try {
			tblroutemaster=tmtuTblroutemasterRepository.save(tblroutemaster);
			logger.info("Updated Route no ("+tblroutemaster.getRouteNumber()+") with id:"+tblroutemaster.getRouteid());
			return tblroutemaster;
			
		}catch (Exception e) {
		logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Tblroutemaster updateLastStop(long routeId, String lastBusStopCode, String lastBusStopName,
			long modifiedby) {
		Tblroutemaster tblroutemaster=tmtuTblroutemasterRepository.findOne(routeId);
		if(tblroutemaster==null) {
			logger.error("RouteId not exists:"+routeId);
			return null;
		}
		Tbllogin tbllogin=tmtuTblloginRepository.findOne(modifiedby);
		if(tbllogin==null) {
			logger.error("Created By not exists:"+modifiedby);
			return null;
		}
		
		tblroutemaster.setLastBusStopCode(lastBusStopCode);
		tblroutemaster.setLastBusStopName(lastBusStopName);
		tblroutemaster.setLastModifiedBy(modifiedby);
		tblroutemaster.setLastModifiedOn(Calendar.getInstance());
		
		try {
			tblroutemaster=tmtuTblroutemasterRepository.save(tblroutemaster);
			logger.info("Updated Route no ("+tblroutemaster.getRouteNumber()+") with id:"+tblroutemaster.getRouteid());
			return tblroutemaster;
			
		}catch (Exception e) {
		logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Tblroutemaster updateTotalStopCount(long routeId, long totalStopCount, long modifiedby) {
		Tblroutemaster tblroutemaster=tmtuTblroutemasterRepository.findOne(routeId);
		if(tblroutemaster==null) {
			logger.error("RouteId not exists:"+routeId);
			return null;
		}
		Tbllogin tbllogin=tmtuTblloginRepository.findOne(modifiedby);
		if(tbllogin==null) {
			logger.error("Created By not exists:"+modifiedby);
			return null;
		}
		
		tblroutemaster.setTotalStopCount(totalStopCount);
		tblroutemaster.setLastModifiedBy(modifiedby);
		tblroutemaster.setLastModifiedOn(Calendar.getInstance());
		
		try {
			tblroutemaster=tmtuTblroutemasterRepository.save(tblroutemaster);
			logger.info("Updated Route no ("+tblroutemaster.getRouteNumber()+") with id:"+tblroutemaster.getRouteid());
			return tblroutemaster;
			
		}catch (Exception e) {
		logger.error(e.getMessage());
		}
		return null;
	}

	

}
