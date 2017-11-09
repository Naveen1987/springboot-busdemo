package com.tmtu.bus_master.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.bus_master.models.Tblluggagemaster;
import com.tmtu.bus_master.repositories.TmtuTblluggagemasterRepository;

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
			json.put("msg", "found");
			json.put("luggageid", record.getLuggageid());
			Map<String,Object> fare=new HashMap<String,Object>();
			if(record.getTblfarechartmaster()!=null) {
				fare.put("fareid",record.getTblfarechartmaster().getFarechartid());
				fare.put("amount",record.getTblfarechartmaster().getTotalAmount());
				fare.put("startkm",record.getTblfarechartmaster().getStartKm());
				fare.put("tillkm",record.getTblfarechartmaster().getTillKm());
				Map<String,Object> concession=new HashMap<String,Object>();
				concession.put("concessionid", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionid());
				concession.put("concessioncode", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionCode());
				concession.put("concessionname", record.getTblfarechartmaster().getTblconcessionmaster().getConcessionName());
				fare.put("concession", concession);
				Map<String,Object> bustype=new HashMap<String,Object>();
				bustype.put("bustypeid", record.getTblfarechartmaster().getTlbbustypemaster().getBustypeid());
				bustype.put("servicecode", record.getTblfarechartmaster().getTlbbustypemaster().getServicetypeCode());
				bustype.put("servicename", record.getTblfarechartmaster().getTlbbustypemaster().getServiceTypeName());
				fare.put("bustype", bustype);
				}
			json.put("fares", fare);
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
