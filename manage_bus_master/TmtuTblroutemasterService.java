package com.tmtu.services.manage_bus_master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.models.manage_bus_master.Tblroutemaster;
import com.tmtu.repositories.manage_bus_master.TmtuTblroutemasterRepository;

@Service
public class TmtuTblroutemasterService {

	
	@Autowired
	TmtuTblroutemasterRepository tmtuTblroutemasterRepository;
	
	public Tblroutemaster save(long busTypeId, long routeNumber, String firstBusStopCode, String firstusStopName,
			long totalStopCount, String lastBusStopCode, String lastBusStopName, long createdBy) {
		return tmtuTblroutemasterRepository.save(busTypeId, routeNumber, firstBusStopCode, firstusStopName, totalStopCount, lastBusStopCode, lastBusStopName, createdBy);
	}
	public Tblroutemaster updateBusType(long routeId, long busTypeId, long modifiedby) {
		return tmtuTblroutemasterRepository.updateBusType(routeId, busTypeId, modifiedby);
   }
	public Tblroutemaster updateFirstStop(long routeId, String firstBusStopCode, String firstusStopName,
			long modifiedby) {
		return tmtuTblroutemasterRepository.updateFirstStop(routeId, firstBusStopCode, firstusStopName, modifiedby);
	}
	public Tblroutemaster updateLastStop(long routeId, String lastBusStopCode, String lastBusStopName,
			long modifiedby) {
		return tmtuTblroutemasterRepository.updateLastStop(routeId, lastBusStopCode, lastBusStopName, modifiedby);
	}
	public Tblroutemaster updateTotalStopCount(long routeId, long totalStopCount, long modifiedby) {
		return tmtuTblroutemasterRepository.updateTotalStopCount(routeId, totalStopCount, modifiedby);
	}
	
  public Tblroutemaster update(Long routeid, Long busTypeId, String firstBusStopCode, String firstusStopName,
				Long totalStopCount, String lastBusStopCode, String lastBusStopName, Long modifiedBy)
	   {
		   return tmtuTblroutemasterRepository.update(routeid, busTypeId, firstBusStopCode, firstusStopName, totalStopCount, lastBusStopCode, lastBusStopName, modifiedBy);  
	   }
  
   public Tblroutemaster findByRouteNo(long routeno) {
	   return tmtuTblroutemasterRepository.findByrouteNumber(routeno);
	}
	
  
   public Tblroutemaster findByRouteId(long routeid) {
	return tmtuTblroutemasterRepository.findOne(routeid);
	}
   
   public List<Map<String, Object>> allRoute(){
	   List<Map<String,Object>> listroutes=new ArrayList<Map<String,Object>>();
	   Iterable<Tblroutemaster> routes=tmtuTblroutemasterRepository.findAll();
	   routes.forEach(record->{
		   Map<String,Object>json=new HashMap<String,Object>();
		   json.put("routeid", record.getRouteid());
		   json.put("routenumber", record.getRouteNumber());
		   json.put("firststopcode", record.getFirstBusStopCode());
		   json.put("firststopname", record.getFirstBusStopName());
		   json.put("laststopcode", record.getLastBusStopCode());
		   json.put("laststopname", record.getLastBusStopName());
		   json.put("totalstop", record.getTotalStopCount());
		   Map<String,Object>bustype=new HashMap<String,Object>();
		   bustype.put("bustypeid", record.getTlbbustypemaster().getBustypeid());
		   bustype.put("servicename", record.getTlbbustypemaster().getServiceTypeName());
		   bustype.put("servicecode", record.getTlbbustypemaster().getServicetypeCode());
		   json.put("bustype",bustype);
		   List<Map<String,Object>>stops=new ArrayList<Map<String,Object>>();
		   record.getTblstopmaster().forEach(tblstopmaster->{
			   Map<String,Object> stopJson=new HashMap<String,Object>();
			   stopJson.put("stopid", tblstopmaster.getStopid());
			   stopJson.put("stopcode", tblstopmaster.getBusStopCode());
			   stopJson.put("stopname", tblstopmaster.getBusStopName());
			   stopJson.put("stopnumber", tblstopmaster.getBusStopNumber());
			   stopJson.put("interstate", tblstopmaster.getInterStateStop());
			   stopJson.put("sequenceno", tblstopmaster.getSequenceNumber());
			   stopJson.put("km", tblstopmaster.getKm());
			   stops.add(stopJson);
		   });
		   json.put("stops", stops);
		   listroutes.add(json);
	   });
	   return listroutes;
   }
}
