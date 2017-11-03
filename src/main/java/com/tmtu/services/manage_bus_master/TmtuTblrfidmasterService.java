package com.tmtu.services.manage_bus_master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.models.manage_bus_master.Tblrfidmaster;
import com.tmtu.repositories.manage_bus_master.TmtuTblrfidmasterRepository;

@Service
public class TmtuTblrfidmasterService {

	
	@Autowired
	TmtuTblrfidmasterRepository tmtuTblrfidmasterRepository;
	
	public Tblrfidmaster amountChange(long rfid,long modifiedby,double amount) {
		return tmtuTblrfidmasterRepository.amountChange(rfid, modifiedby, amount);
	}
	public Tblrfidmaster statusChange(long rfid,long modifiedby,boolean status) {
		return tmtuTblrfidmasterRepository.statusChange(rfid, modifiedby, status);
	}
	public Tblrfidmaster save(String keys,double amount,long createdby) {
		return 	tmtuTblrfidmasterRepository.save(keys, amount, createdby);
	}
	
	public Tblrfidmaster getCardbyId(long rfid) {
		return tmtuTblrfidmasterRepository.findOne(rfid);
	}
	
	public Tblrfidmaster getCardByKey(String keys) {
		return tmtuTblrfidmasterRepository.findByKeys(keys);
	}
}
