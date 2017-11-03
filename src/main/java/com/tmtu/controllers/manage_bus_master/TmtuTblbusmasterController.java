package com.tmtu.controllers.manage_bus_master;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import com.tmtu.services.manage_bus_master.TmtuTblbusmasterService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblbusmasterController {

	
	@Autowired
	TmtuTblbusmasterService tmtuTblbusmasterService;
	
	@PostMapping("/addbus")
public ResponseEntity<Map<String, String>> saveBus(
		@RequestParam("busno") String busno,
		@RequestParam("registeron") Long registeron,
		@RequestParam("createdby") Long createdby,
		@RequestParam("bustypeid") Long	bustypeid
		){
	Map<String, String> json=new TreeMap<String,String>();
	Tblbusmaster tblbusmaster =tmtuTblbusmasterService.save(busno, registeron, createdby, bustypeid);
	if(tblbusmaster!=null) {
	 json.put("msg", "Successfully added");
	 json.put("busno", tblbusmaster.getBusNo());
	 json.put("busid", tblbusmaster.getBusid()+"");
	 json.put("bustypeid", tblbusmaster.getTlbbustypemaster().getBustypeid()+"");
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	else { 
		 json.put("msg", "Not added already exits");
			return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
	}

}
	/*
	 *Update multiple attribute 
	 */
	/*@PostMapping("/updatebus")
	public ResponseEntity<Map<String, String>> updateBus(
			@RequestParam("busid") Long busid,
			@RequestParam("busno") String busno,
			@RequestParam("registeron") Long registeron,
			@RequestParam("modifiedby") Long modifiedby,
			@RequestParam("bustypeid") Long	bustypeid
			){
		Map<String, String> json=new TreeMap<String,String>();
		Tblbusmaster tblbusmaster =tmtuTblbusmasterService.update(busid, busno, registeron, modifiedby, bustypeid);
		if(tblbusmaster!=null) {
		 json.put("msg", "Successfully updated");
		 json.put("busno", tblbusmaster.getBusNo());
		 json.put("busid", tblbusmaster.getBusid()+"");
		 json.put("bustypeid", tblbusmaster.getTlbbustypemaster().getBustypeid()+"");
			return new ResponseEntity<>(json, HttpStatus.OK);
		}
		else {
			 json.put("msg", "Not Updated please check BusId or BusTypeId");
				return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
		}
	}*/
	/*
	 * Update only bus type
	 */
	@PostMapping("/updatebus")
	public ResponseEntity<Map<String, String>> updateBus(
			@RequestParam("busid") Long busid,
			@RequestParam("modifiedby") Long modifiedby,
			@RequestParam("bustypeid") Long	bustypeid
			){
		Map<String, String> json=new TreeMap<String,String>();
		Tblbusmaster tblbusmaster =tmtuTblbusmasterService.update(busid, modifiedby, bustypeid);
		if(tblbusmaster!=null) {
		 json.put("msg", "Successfully updated");
		 json.put("busno", tblbusmaster.getBusNo());
		 json.put("busid", tblbusmaster.getBusid()+"");
		 json.put("bustypeid", tblbusmaster.getTlbbustypemaster().getBustypeid()+"");
			return new ResponseEntity<>(json, HttpStatus.OK);
		}
		else {
			 json.put("msg", "Not Updated please check BusId or BusTypeId");
				return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/busbybusno")
	public ResponseEntity<List<Map<String, Object>>> findbusno(@RequestParam("busno") String busno){
		Map<String, Object> json=new HashMap<String,Object>();
		List<Map<String, Object>> tblbusmaster =tmtuTblbusmasterService.findByBusNo(busno);
		if(tblbusmaster.size()>0) {
			 return new ResponseEntity<List<Map<String, Object>>>(tblbusmaster, HttpStatus.OK);
			}
			else {
				 json.put("msg", "Not Found");
				 tblbusmaster.add(json);
				 return new ResponseEntity<List<Map<String, Object>>>(tblbusmaster, HttpStatus.BAD_REQUEST);
			}
	}
	@GetMapping("/busbybusid")
	public ResponseEntity<Map<String, String>> findbusId(@RequestParam("busid") Long busid){
		Map<String, String> json=new TreeMap<String,String>();
		Tblbusmaster tblbusmaster =tmtuTblbusmasterService.findByBusId(busid);
		if(tblbusmaster!=null) {
			 json.put("msg", "Successfully updated");
			 json.put("busno", tblbusmaster.getBusNo());
			 json.put("busid", tblbusmaster.getBusid()+"");
			 json.put("bustypeid", tblbusmaster.getTlbbustypemaster().getBustypeid()+"");
				return new ResponseEntity<>(json, HttpStatus.OK);
			}
			else {
				 json.put("msg", "Not Found");
					return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
			}
	}
	
}
