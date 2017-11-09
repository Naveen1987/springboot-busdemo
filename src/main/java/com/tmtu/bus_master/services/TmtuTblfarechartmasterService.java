package com.tmtu.bus_master.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.bus_master.models.Tblfarechartmaster;
import com.tmtu.bus_master.repositories.TmtuTblfarechartmasterRepository;

@Service
public class TmtuTblfarechartmasterService {

	
	@Autowired
	TmtuTblfarechartmasterRepository tmtuTblfarechartmasterRepository;
	
	public Tblfarechartmaster save(long startkm,long tillkm,double amount,long bustypeid,long concessionid,long createdby){
		return tmtuTblfarechartmasterRepository.save(startkm, tillkm, amount, bustypeid, concessionid, createdby);
	}
	public Tblfarechartmaster updatebusType(long farechartid, long bustypeid, long modifiedby) {
		return tmtuTblfarechartmasterRepository.updatebusType(farechartid, bustypeid, modifiedby);
	}
	public Tblfarechartmaster updateStartTillKm(long farechartid, long startkm, long tillkm, long modifiedby) {
		return tmtuTblfarechartmasterRepository.updateStartTillKm(farechartid, startkm, tillkm, modifiedby);
	}
	public Tblfarechartmaster updateConcession(long farechartid, long concessionid, long modifiedby) {
		return tmtuTblfarechartmasterRepository.updateConcession(farechartid, concessionid, modifiedby);
	}
	
	public Tblfarechartmaster updatefareamount(long farechartid, double amount, long modifiedby) {
		return tmtuTblfarechartmasterRepository.updatefareamount(farechartid, amount, modifiedby);
	}
	public List<Map<String, Object>> getallfarechart(){
		List<Map<String, Object>> listfare=new ArrayList<Map<String, Object>>();
		Iterable<Tblfarechartmaster> tbIterable=tmtuTblfarechartmasterRepository.findAll();
		/*
		 * Convert Iterable to stream
		 * StreamSupport.stream(tbIterable.spliterator(), false).foreach();
		 * but directly can work
		 */
		tbIterable.forEach(record->{
			Map<String, Object> json=new HashMap<String,Object>();
			json.put("fareid",record.getFarechartid());
			json.put("startkm", record.getStartKm());
			json.put("tillkm", record.getTillKm());
			json.put("amount", record.getTotalAmount());
			json.put("createdby", record.getCreatedBy());
			json.put("createdon", record.getCreatedOn().getTimeInMillis());
			json.put("modifiedby", record.getLastModifiedBy());
			if(record.getLastModifiedOn()!=null) {
				json.put("modifiedon", record.getLastModifiedOn().getTimeInMillis());	
			}
			else {
				json.put("modifiedon", null);
			}
			Map<String,Object> bustype=new HashMap<String,Object>();
			bustype.put("bustypeid", record.getTlbbustypemaster().getBustypeid());
			bustype.put("servicecode", record.getTlbbustypemaster().getServicetypeCode());
			bustype.put("servicename", record.getTlbbustypemaster().getServiceTypeName());
			Map<String,Object> concession=new HashMap<String,Object>();
			
			concession.put("concessionid", record.getTblconcessionmaster().getConcessionid());
			concession.put("concessioncode", record.getTblconcessionmaster().getConcessionCode());
			concession.put("concessionname", record.getTblconcessionmaster().getConcessionName());
			
			json.put("bustype", bustype);
			json.put("concession", concession);
			listfare.add(json);
		});
		return listfare;
	}
	public Map<String, Object> getfarechart(long farechartid) {
		Map<String, Object> json=new HashMap<String,Object>();
		Tblfarechartmaster record=tmtuTblfarechartmasterRepository.findOne(farechartid);
		if(record!=null) {
			
			json.put("fareid",record.getFarechartid());
			json.put("startkm", record.getStartKm());
			json.put("tillkm", record.getTillKm());
			json.put("amount", record.getTotalAmount());
			json.put("createdby", record.getCreatedBy());
			json.put("createdon", record.getCreatedOn().getTimeInMillis());
			json.put("modifiedby", record.getLastModifiedBy());
			if(record.getLastModifiedOn()!=null) {
				json.put("modifiedon", record.getLastModifiedOn().getTimeInMillis());	
			}
			else {
				json.put("modifiedon", null);
			}
			Map<String,Object> bustype=new HashMap<String,Object>();
			bustype.put("bustypeid", record.getTlbbustypemaster().getBustypeid());
			bustype.put("servicecode", record.getTlbbustypemaster().getServicetypeCode());
			bustype.put("servicename", record.getTlbbustypemaster().getServiceTypeName());
			Map<String,Object> concession=new HashMap<String,Object>();
			
			concession.put("concessionid", record.getTblconcessionmaster().getConcessionid());
			concession.put("concessioncode", record.getTblconcessionmaster().getConcessionCode());
			concession.put("concessionname", record.getTblconcessionmaster().getConcessionName());
			
			json.put("bustype", bustype);
			json.put("concession", concession);
			
		}
		else {
			json.put("msg", "Not found");
		}
		return json;
	}
}
