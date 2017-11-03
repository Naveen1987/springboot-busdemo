package com.tmtu.services.manage_bus_master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.models.manage_bus_master.Tblluggagemaster;
import com.tmtu.repositories.manage_bus_master.TmtuTblluggagemasterRepository;

@Service
public class TmtuTblluggagemasterService {

	@Autowired
	TmtuTblluggagemasterRepository tmtuTblluggagemasterRepository;
	
	public Tblluggagemaster save(long farechartid, long startkm, long tillkm, double amount, long createdby) {
		return tmtuTblluggagemasterRepository.save(farechartid, startkm, tillkm, amount, createdby);
	}
	public Tblluggagemaster updateluggagefarechart(long luggageid, long farechartid, long modifiedby) {
		return tmtuTblluggagemasterRepository.updateluggagefarechart(luggageid, farechartid, modifiedby);
	}
	public Tblluggagemaster updateluggageAmount(long luggageid, double amount, long modifiedby) {
		return tmtuTblluggagemasterRepository.updateluggageAmount(luggageid, amount, modifiedby);
	}
	public Tblluggagemaster save(long startkm, long tillkm, double amount, long createdby) {
		return tmtuTblluggagemasterRepository.save(startkm, tillkm, amount, createdby);
	}
	public List<Map<String, Object>> getAllLuggage(){
		List<Map<String, Object>> listLuggage=new ArrayList<Map<String,Object>>();
		Iterable<Tblluggagemaster> luggaages=tmtuTblluggagemasterRepository.findAll();
		luggaages.forEach(record->{
			Map<String,Object> json=new HashMap<String,Object>();
			json.put("luggageid", record.getLuggageid());
			if(record.getTblfarechartmaster()!=null) {
				json.put("farechartid",record.getTblfarechartmaster().getFarechartid());
			}
			else {
				json.put("farechartid",null);
			}
			json.put("startkm", record.getStartKm());
			json.put("tillkm", record.getTillKm());
			json.put("amount", record.getTotalAmount());
			json.put("createdby",record.getCreatedBy());
			json.put("createdon", record.getCreatedOn().getTimeInMillis());
			listLuggage.add(json);
		});
		return listLuggage;
	}
	
	public Tblluggagemaster getLuggage(long luggageid){	
		return tmtuTblluggagemasterRepository.findOne(luggageid);
	}
}
