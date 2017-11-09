package com.tmtu.allocation.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.tmtu.allocation.models.Tbldepotmaster;
*/
import com.tmtu.allocation.models.Tblexpenses;
import com.tmtu.allocation.repositories.TmtuTblexpensesRepository;

@Service
public class TmtuTblexpensesService {
@Autowired
TmtuTblexpensesRepository tmtuTblexpensesRepository;

public Tblexpenses save(String expensetype,Long createdBy) {
	return tmtuTblexpensesRepository.save(expensetype, createdBy);
}

public List<Map<String,Object>> findAll()
{
	Iterable<Tblexpenses> records=tmtuTblexpensesRepository.findAll();
	List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	records.forEach(tbl->{
		Map<String,Object>json=new HashMap<String,Object>();
		json.put("expensetype", tbl.getExpensetype());
		data.add(json);
	});
	return data;
	
}
/*public Page<Map<String, Object>>finadall(Pageable page){
	
	Page<Tblexpenses> records=tmtuTblexpensesRepository.findAll(page);
	Page<Map<String, Object>> data=records.map(new Converter<Tblexpenses, Map<String,Object>>() {
		@Override
		public Map<String, Object> convert(Tblexpenses tbl) {
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("expensetype", tbl.getExpensetype());
			return json;
		}
	});
	return data;
		
}*/
}
