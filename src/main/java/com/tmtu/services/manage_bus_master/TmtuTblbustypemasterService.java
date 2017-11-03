package com.tmtu.services.manage_bus_master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.models.manage_bus_master.Tblbustypemaster;
import com.tmtu.repositories.manage_bus_master.TmtuTblbustypemasterRepository;

@Service
public class TmtuTblbustypemasterService {

	
	@Autowired
	TmtuTblbustypemasterRepository tmtuTblbustypemasterRepository;
	
	public Tblbustypemaster save(String serviceTypeName,String servicetypeCode,long createdby) {
		return tmtuTblbustypemasterRepository.save(serviceTypeName, servicetypeCode, createdby);
	}
	
	public Tblbustypemaster update(String serviceTypeName,String servicetypeCode,long modifiedby,long bustypeid) {
		return tmtuTblbustypemasterRepository.update(serviceTypeName, servicetypeCode, modifiedby, bustypeid);
	}
	public List<Map<String,Object>> getAllBusType(){
		List<Map<String,Object>> listbustypes=new ArrayList<Map<String,Object>>();
		Iterable<Tblbustypemaster> tblbustypes=tmtuTblbustypemasterRepository.findAll();
		tblbustypes.forEach(record->{
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("bustypeid", record.getBustypeid());
			json.put("servicename",record.getServiceTypeName());
			json.put("servicecode",record.getServicetypeCode());
			listbustypes.add(json);
		});
		return listbustypes;
	}
	
	public Tblbustypemaster getBusbyBusType(Long bustypeid){
		return tmtuTblbustypemasterRepository.findOne(bustypeid);
	}
}
