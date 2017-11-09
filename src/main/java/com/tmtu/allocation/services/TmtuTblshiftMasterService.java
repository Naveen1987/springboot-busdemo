package com.tmtu.allocation.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.allocation.models.TblshiftMaster;
import com.tmtu.allocation.repositories.TmtuTblshiftMasterRepository;
@Service
public class TmtuTblshiftMasterService {

	@Autowired
	TmtuTblshiftMasterRepository tmtuTblshiftMasterRepository;
	public TblshiftMaster save(Long shiftType, Long createdBy) {
		return tmtuTblshiftMasterRepository.save(shiftType, createdBy);
	}
	
	public List<Map<String,Object>> findAll(){
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		Iterable<TblshiftMaster> records=tmtuTblshiftMasterRepository.findAll();
		records.forEach(tbl->{
			Map<String,Object>json=new HashMap<String,Object>();
			json.put("shifttype", tbl.getShiftType());
			data.add(json);
		});
		return data;
	}
}
