package com.tmtu.controllers.manage_bus_master;

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

import com.tmtu.models.manage_bus_master.Tblbusmaster;
import com.tmtu.models.manage_bus_master.Tblbustypemaster;
import com.tmtu.services.manage_bus_master.TmtuTblbustypemasterService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblbustypemasterController {

	@Autowired
	TmtuTblbustypemasterService tmtuTblbustypemasterService;
	
	@PostMapping("/addbustype")
	public ResponseEntity<Map<String, String>> saveBusType(
			@RequestParam("servicetypename") String serviceTypeName,
			@RequestParam("servicetypecode") String servicetypeCode,
			@RequestParam("createdby") long createdBy
			){
		Map<String,String> json=new HashMap<String,String>();
		Tblbustypemaster tblbustypemaster=tmtuTblbustypemasterService.save(serviceTypeName, servicetypeCode, createdBy);
		if(tblbustypemaster==null) {
			json.put("msg", "Bus Type is existed.");
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg", "Bus Type Successfully created");
			json.put("bustypeid", tblbustypemaster.getBustypeid()+"");
			json.put("servicename", tblbustypemaster.getServiceTypeName());
			json.put("servicecode", tblbustypemaster.getServicetypeCode());
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/updatebustype")
	public ResponseEntity<Map<String, String>> updateBusType(
			@RequestParam("servicetypename") String serviceTypeName,
			@RequestParam("servicetypecode") String servicetypeCode,
			@RequestParam("modifiedby") long modifiedby,
			@RequestParam("bustypeid") long bustypeid 
			){
		Map<String,String> json=new HashMap<String,String>();
		Tblbustypemaster tblbustypemaster=tmtuTblbustypemasterService.update(serviceTypeName, servicetypeCode, modifiedby, bustypeid);
		if(tblbustypemaster==null) {
			json.put("msg", "Bus Type is Not existed.");
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg", "Bus Type Successfully Updated");
			json.put("bustypeid", tblbustypemaster.getBustypeid()+"");
			json.put("servicename", tblbustypemaster.getServiceTypeName());
			json.put("servicecode", tblbustypemaster.getServicetypeCode());
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
		}
	}
	
	@GetMapping("/allbustype")
	public ResponseEntity<List<Map<String,Object>>> getAllBusType(){
		List<Map<String,Object>> bustypes=tmtuTblbustypemasterService.getAllBusType();
		if(bustypes.size()<1) {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("msg", "Not found");
			bustypes.add(json);
			return new ResponseEntity<List<Map<String,Object>>>(bustypes,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Map<String,Object>>>(bustypes,HttpStatus.OK);
	}
	
	@GetMapping("/findbusbybustype")
	public ResponseEntity<Map<String, Object>> findBusbyBustype(
			@RequestParam("bustypeId") Long bustype
			){
		Map<String,Object> json=new HashMap<String,Object>();
		Tblbustypemaster tblbustypemaster=tmtuTblbustypemasterService.getBusbyBusType(bustype);
		if(tblbustypemaster==null) {
			json.put("msg", "Bus Type is Not existed.");
			return new ResponseEntity<Map<String, Object>>(json, HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg", "Bus Type Successfully Updated");
			json.put("bustypeid", tblbustypemaster.getBustypeid()+"");
			json.put("servicename", tblbustypemaster.getServiceTypeName());
			json.put("servicecode", tblbustypemaster.getServicetypeCode());
			
			List<Map<String,Object>> buses=new ArrayList<Map<String,Object>>();
			
			List<Tblbusmaster> tbus=tblbustypemaster.getTblbusmaster();
			tbus.forEach(bus->{
				Map<String,Object> jsonBus=new HashMap<String,Object>();
				jsonBus.put("busid", bus.getBusid());
				jsonBus.put("busno", bus.getBusNo());
				jsonBus.put("regiteron",bus.getRegistedOn());
				buses.add(jsonBus);
			});
			json.put("buses", buses);
			return new ResponseEntity<Map<String, Object>>(json, HttpStatus.OK);
		}
	}
}
