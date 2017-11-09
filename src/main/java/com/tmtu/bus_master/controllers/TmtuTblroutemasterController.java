package com.tmtu.bus_master.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tmtu.bus_master.models.Tblroutemaster;
import com.tmtu.bus_master.services.TmtuTblroutemasterService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblroutemasterController {

	@Autowired
	TmtuTblroutemasterService tmtuTblroutemasterService; 
	
	
	@PostMapping("/saveroute")
	public ResponseEntity<Map<String, Object>> save(
			@RequestParam("bustypeid") Long busTypeId, 
			@RequestParam("routenumber") Long routeNumber, 
			@RequestParam("firstbusstopcode") String firstBusStopCode, 
			@RequestParam("firstbusstopname") String firstusStopName,
			@RequestParam("totalstopcount") Long totalStopCount, 
			@RequestParam("lastbusstopcode") String lastBusStopCode, 
			@RequestParam("lastbusstopname") String lastBusStopName, 
			@RequestParam("createdby") Long createdBy) {
		Tblroutemaster record=tmtuTblroutemasterService.save(busTypeId, routeNumber, firstBusStopCode, firstusStopName, totalStopCount, lastBusStopCode, lastBusStopName, createdBy);
		Map<String, Object>json=new HashMap<String,Object>();
		if(record==null) {
			json.put("msg", "Not Saved");
			return new ResponseEntity<Map<String,Object>>(json, HttpStatus.BAD_REQUEST);
		}
           json.put("msg", "Saved");		
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
		   
		return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
	}
	
	@PostMapping("/updateroute")
	public ResponseEntity<Map<String, Object>> update(
			@RequestParam("routeid") Long routeId,
			@RequestParam(value="bustypeid",required=false) Long busTypeId, 
			@RequestParam(value="firstbusstopcode",required=false) String firstBusStopCode, 
			@RequestParam(value="firstbusstopname",required=false) String firstusStopName,
			@RequestParam(value="totalstopcount",required=false) Long totalStopCount, 
			@RequestParam(value="lastbusstopcode",required=false) String lastBusStopCode, 
			@RequestParam(value="lastbusstopname",required=false) String lastBusStopName, 
			@RequestParam("modifiedby") Long modifiedby) {
		Tblroutemaster record=tmtuTblroutemasterService.update(routeId, busTypeId, firstBusStopCode, firstusStopName, totalStopCount, lastBusStopCode, lastBusStopName, modifiedby);
		Map<String, Object>json=new HashMap<String,Object>();
		if(record==null) {
			json.put("msg", "Not Updated");
			return new ResponseEntity<Map<String,Object>>(json, HttpStatus.BAD_REQUEST);
		}
           json.put("msg", "Updated");		
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
		   
		return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
	}
	
	@GetMapping("/getbyrouteid")
	public ResponseEntity<Map<String, Object>> getByRouteId(
			@RequestParam("routeid") Long routeId
			) {
		Tblroutemaster record=tmtuTblroutemasterService.findByRouteId(routeId);
		Map<String, Object>json=new HashMap<String,Object>();
		if(record==null) {
			json.put("msg", "Not found");
			return new ResponseEntity<Map<String,Object>>(json, HttpStatus.BAD_REQUEST);
		}
           json.put("msg", "found");		
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
		   
		return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
	}
	
	@GetMapping("/getbyrouteno")
	public ResponseEntity<Map<String, Object>> getByRouteNumber(
			@RequestParam("routeno") Long routeno
			) {
		Tblroutemaster record=tmtuTblroutemasterService.findByRouteNo(routeno);
		Map<String, Object>json=new HashMap<String,Object>();
		if(record==null) {
			json.put("msg", "Not Found");
			return new ResponseEntity<Map<String,Object>>(json, HttpStatus.BAD_REQUEST);
		}
           json.put("msg", "found");		
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
		   
		return new ResponseEntity<Map<String,Object>>(json, HttpStatus.OK);
	}
	
	@GetMapping("/getallroutes")
	public ResponseEntity<List<Map<String, Object>>> getAllroutes() {
		List<Map<String, Object>> routes=tmtuTblroutemasterService.allRoute();
		if(routes.size()<1) {
			Map<String,Object> json=new HashMap<String,Object>();
			json.put("msg", "Not Found");
			routes.add(json);
			return new ResponseEntity<List<Map<String,Object>>>(routes, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<List<Map<String,Object>>>(routes, HttpStatus.OK);
	}
}
