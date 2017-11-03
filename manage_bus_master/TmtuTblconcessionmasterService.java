package com.tmtu.services.manage_bus_master;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.tmtu.models.manage_bus_master.Tblconcessionmaster;
import com.tmtu.repositories.manage_bus_master.TmtuTblconcessionmasterRepository;

@Service
public class TmtuTblconcessionmasterService {

	
	@Autowired
	TmtuTblconcessionmasterRepository tmtuTblconcessionmasterRepository;
	
	public Tblconcessionmaster save(String concessionName, String concessionCode, long createdBy) {
		return tmtuTblconcessionmasterRepository.save(concessionName, concessionCode, createdBy);
	}
	public Tblconcessionmaster update(long concessionid, String concessionName, String concessionCode, long modifiedby) {
		return tmtuTblconcessionmasterRepository.update(concessionid, concessionName, concessionCode, modifiedby);
	}
	
	public List<Map<String, Object>> findbyName( String concessionName){
		List<Map<String, Object>> listconcession=new ArrayList<Map<String, Object>>();
		List<Tblconcessionmaster> master=tmtuTblconcessionmasterRepository.findbyName(concessionName);
		master.forEach(record->{
			Map<String, Object> concession=new HashMap<String, Object>();
			concession.put("msg", "found");
			concession.put("concessionid",record.getConcessionid());
			concession.put("concessioncode", record.getConcessionCode());
			concession.put("concessionname",record.getConcessionName());
			listconcession.add(concession);
		});
		return listconcession;
	}
	
	public List<Map<String, Object>> findbyCode( String concessioncode){
		List<Map<String, Object>> listconcession=new ArrayList<Map<String, Object>>();
		List<Tblconcessionmaster> master=tmtuTblconcessionmasterRepository.findbyCode(concessioncode);
		master.forEach(record->{
			Map<String, Object> concession=new HashMap<String, Object>();
			concession.put("msg", "found");
			concession.put("concessionid",record.getConcessionid());
			concession.put("concessioncode", record.getConcessionCode());
			concession.put("concessionname",record.getConcessionName());
			listconcession.add(concession);
		});
		return listconcession;
		
	}
	
	
	public List<Map<String, Object>> findall( ){
		List<Map<String, Object>> listconcession=new ArrayList<Map<String, Object>>();
		Iterable<Tblconcessionmaster> master=tmtuTblconcessionmasterRepository.findAll();
		master.forEach(record->{
			Map<String, Object> concession=new HashMap<String, Object>();
			concession.put("msg", "found");
			concession.put("concessionid",record.getConcessionid());
			concession.put("concessioncode", record.getConcessionCode());
			concession.put("concessionname",record.getConcessionName());
			listconcession.add(concession);
		});
		return listconcession;
		
	}
}
