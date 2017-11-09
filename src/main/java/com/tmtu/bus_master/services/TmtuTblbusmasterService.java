package com.tmtu.bus_master.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.bus_master.models.Tblbusmaster;
import com.tmtu.bus_master.repositories.TmtuTblbusmasterRepository;

@Service
public class TmtuTblbusmasterService {

	@Autowired
	TmtuTblbusmasterRepository tmtuTblbusmasterRepository;
	
	public Tblbusmaster save(String busno, long registeron, long createdby, long bustype) {
		return tmtuTblbusmasterRepository.save(busno, registeron, createdby, bustype);
	}
	public Tblbusmaster update(long busid, String busno, long registeron, long modifiedby, long bustype) {
	return tmtuTblbusmasterRepository.update(busid, busno, registeron, modifiedby, bustype);
	}
	
	public List<Map<String,Object>> findByBusNo(String busno) {
		List<Map<String, Object>> listbus=new ArrayList<Map<String, Object>>();
		List<Tblbusmaster> master=tmtuTblbusmasterRepository.findByBusNo(busno);
		master.forEach(record->{
			Map<String,Object> bus=new HashMap<String,Object>();
			bus.put("msg", "bus found");
			bus.put("busid", record.getBusid()+"");
			bus.put("busno", record.getBusNo());
			bus.put("registedon", record.getRegistedOn().getTimeInMillis()+"");
			Map<String,Object> busType=new HashMap<String,Object>();
			busType.put("bustypeid", record.getTlbbustypemaster().getBustypeid()+"");
			busType.put("servicename", record.getTlbbustypemaster().getServiceTypeName());
			busType.put("servicecode", record.getTlbbustypemaster().getServicetypeCode());
			bus.put("bustype", busType);
			listbus.add(bus);
			});
		return listbus;
	}
	
	public List<Map<String,Object>> findallBus() {
		List<Map<String, Object>> listbus=new ArrayList<Map<String, Object>>();
		Iterable<Tblbusmaster> master=tmtuTblbusmasterRepository.findAll();
		master.forEach(record->{
			Map<String,Object> bus=new HashMap<String,Object>();
			bus.put("msg", "bus found");
			bus.put("busid", record.getBusid()+"");
			bus.put("busno", record.getBusNo());
			bus.put("registedon", record.getRegistedOn().getTimeInMillis()+"");
			Map<String,Object> busType=new HashMap<String,Object>();
			busType.put("bustypeid", record.getTlbbustypemaster().getBustypeid()+"");
			busType.put("servicename", record.getTlbbustypemaster().getServiceTypeName());
			busType.put("servicecode", record.getTlbbustypemaster().getServicetypeCode());
			bus.put("bustype", busType);
			listbus.add(bus);
			});
		return listbus;
	}
	public Tblbusmaster findByBusId(long busId) {
		return tmtuTblbusmasterRepository.findOne(busId);
	}
	public Tblbusmaster update(long busid,long modifiedby,long bustype) {
		return tmtuTblbusmasterRepository.update(busid, modifiedby, bustype);
	}
}
