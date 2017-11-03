package com.tmtu.controllers.manage_bus_master;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmtu.models.manage_bus_master.Tblstopmaster;
import com.tmtu.services.manage_bus_master.TmtuTblstopmasterService;


@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblstopmasterController {

	@Autowired 
	TmtuTblstopmasterService tmtuTblstopmasterService;
	
	@PostMapping("/savestops")
	public ResponseEntity<List<Map<String, Object>>> save(RequestEntity<Map<String,Object>> stopdata ){
		List<Map<String, Object>> tblstopmasterJson=new ArrayList<Map<String, Object>>();		
		Map<String,Object> stops=stopdata.getBody();
		List<Tblstopmaster> tblstopmasters=tmtuTblstopmasterService.save(stops);
		if(tblstopmasters.size()>0) {
			tblstopmasters.forEach(tblstopmaster->{
				Map<String,Object> json=new HashMap<String,Object>();
				json.put("stopid", tblstopmaster.getStopid());
				json.put("stopcode", tblstopmaster.getBusStopCode());
				json.put("stopname", tblstopmaster.getBusStopName());
				json.put("stopnumber", tblstopmaster.getBusStopNumber());
				json.put("interstate", tblstopmaster.getInterStateStop());
				json.put("sequenceno", tblstopmaster.getSequenceNumber());
				json.put("km", tblstopmaster.getKm());
				Map<String,Object> route=new HashMap<String,Object>();
				route.put("routeid",tblstopmaster.getTblroutemaster().getRouteid());
				route.put("routenumber",tblstopmaster.getTblroutemaster().getRouteNumber());
				Map<String,Object> bustype=new HashMap<String,Object>();
				bustype.put("bustypeid",tblstopmaster.getTblroutemaster().getTlbbustypemaster().getBustypeid());
				bustype.put("servicecode",tblstopmaster.getTblroutemaster().getTlbbustypemaster().getServicetypeCode());
				bustype.put("servicename",tblstopmaster.getTblroutemaster().getTlbbustypemaster().getServiceTypeName());
				route.put("bustype", bustype);
				json.put("route", route);	
				tblstopmasterJson.add(json);
			});
		}
		else {
			Map<String,Object> json=new HashMap<String,Object>();
			json.put("msg", "Empty");
			tblstopmasterJson.add(json);
			return new ResponseEntity<List<Map<String,Object>>>(tblstopmasterJson, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Map<String,Object>>>(tblstopmasterJson, HttpStatus.OK);
	}
	
	@PostMapping("/updatestops")
	public ResponseEntity<List<Map<String, Object>>> update(RequestEntity<Map<String,Object>> stopdata ){
		List<Map<String, Object>> tblstopmasterJson=new ArrayList<Map<String, Object>>();		
		Map<String,Object> stops=stopdata.getBody();
		List<Tblstopmaster> tblstopmasters=tmtuTblstopmasterService.update(stops);
		if(tblstopmasters.size()>0) {
			tblstopmasters.forEach(tblstopmaster->{
				Map<String,Object> json=new HashMap<String,Object>();
				json.put("stopid", tblstopmaster.getStopid());
				json.put("stopcode", tblstopmaster.getBusStopCode());
				json.put("stopname", tblstopmaster.getBusStopName());
				json.put("stopnumber", tblstopmaster.getBusStopNumber());
				json.put("interstate", tblstopmaster.getInterStateStop());
				json.put("sequenceno", tblstopmaster.getSequenceNumber());
				json.put("km", tblstopmaster.getKm());
				Map<String,Object> route=new HashMap<String,Object>();
				route.put("routeid",tblstopmaster.getTblroutemaster().getRouteid());
				route.put("routenumber",tblstopmaster.getTblroutemaster().getRouteNumber());
				Map<String,Object> bustype=new HashMap<String,Object>();
				bustype.put("bustypeid",tblstopmaster.getTblroutemaster().getTlbbustypemaster().getBustypeid());
				bustype.put("servicecode",tblstopmaster.getTblroutemaster().getTlbbustypemaster().getServicetypeCode());
				bustype.put("servicename",tblstopmaster.getTblroutemaster().getTlbbustypemaster().getServiceTypeName());
				route.put("bustype", bustype);
				json.put("route", route);	
				tblstopmasterJson.add(json);
			});
		}
		else {
			Map<String,Object> json=new HashMap<String,Object>();
			json.put("msg", "Empty");
			tblstopmasterJson.add(json);
			return new ResponseEntity<List<Map<String,Object>>>(tblstopmasterJson, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Map<String,Object>>>(tblstopmasterJson, HttpStatus.OK);
	}
	
	
}
