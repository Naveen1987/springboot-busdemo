package com.tmtu.allocation.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.allocation.models.Tbletimmaster;
import com.tmtu.allocation.repositories.TmtuTbletimmasterRepository;

@Service
public class TmtuTbletimmasterService {

	
	@Autowired
	TmtuTbletimmasterRepository tmtuTbletimmasterRepository;
	public Tbletimmaster save(String imei,String etimName,String serialNumber,String version,Long createdBy) {
		return tmtuTbletimmasterRepository.save(imei, etimName, serialNumber, version, createdBy);
	}
	
	public Tbletimmaster update(String imei,String etimName,String serialNumber,String version,Long modifiedby) {
		return tmtuTbletimmasterRepository.update(imei, etimName, serialNumber, version, modifiedby);
	}
	
	public Tbletimmaster findEtim(String imei) {
		return tmtuTbletimmasterRepository.findByimei(imei);
	}
	
	public List<Map<String,Object>> findAllEtim() {
	 List<Map<String,Object>> json=new ArrayList<Map<String,Object>>();
	 Iterable<Tbletimmaster> etim=tmtuTbletimmasterRepository.findAll();
	 etim.forEach(record->{
		 Map<String,Object> data=new HashMap<String,Object>();
		 data.put("imei",record.getImei());
		 data.put("status", record.isStatus());
		 data.put("createdon",record.getCreatedOn().getTimeInMillis());
		 json.add(data);
	 });
		return json;
	}
	
	public List<Map<String,Object>> findAllEtimByStaus() {
		 List<Map<String,Object>> json=new ArrayList<Map<String,Object>>();
		 Iterable<Tbletimmaster> etim=tmtuTbletimmasterRepository.etimbystatus();
		 etim.forEach(record->{
			 Map<String,Object> data=new HashMap<String,Object>();
			 data.put("imei",record.getImei());
			 data.put("status", record.isStatus());
			 data.put("createdon",record.getCreatedOn().getTimeInMillis());
			 json.add(data);
		 });
			return json;
		}
	
	public Tbletimmaster changeStatus(String imei,Boolean status) {
		return tmtuTbletimmasterRepository.stauschange(imei, status);
	}
}
