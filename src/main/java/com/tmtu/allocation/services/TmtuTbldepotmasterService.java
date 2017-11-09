package com.tmtu.allocation.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;*/
import org.springframework.stereotype.Service;

import com.tmtu.allocation.models.Tbldepotmaster;
import com.tmtu.allocation.repositories.TmtuTbldepotmasterRepository;

@Service
public class TmtuTbldepotmasterService {

	@Autowired
	TmtuTbldepotmasterRepository tmtuTbldepotmasterRepository;
	public Tbldepotmaster save(String depotName,String depotcode,Long createdBy) {
		return tmtuTbldepotmasterRepository.save(depotName, depotcode, createdBy);
	}
	
	public List<Map<String,Object>> findAll()
	{
		Iterable<Tbldepotmaster> records=tmtuTbldepotmasterRepository.findAll();
		 List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		records.forEach(tbl->{
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("deportcode", tbl.getDepotcode());
			json.put("deportname", tbl.getDepotName());
			data.add(json);
		});
		return data;
	}
	
	/*public Page<Map<String,Object>> findAll(Pageable page){
		Page<Tbldepotmaster> records=tmtuTbldepotmasterRepository.findAll(page);
		Page<Map<String, Object>> data=records.map(new Converter<Tbldepotmaster, Map<String,Object>>() {

			@Override
			public Map<String, Object> convert(Tbldepotmaster tbl) {
				Map<String,Object>json=new HashMap<String,Object>();
				json.put("deportcode", tbl.getDepotcode());
				json.put("deportname", tbl.getDepotName());
				return json;
			}
		});
		return data;
		
		
	}*/
}
