package com.tmtu.bus_master.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.bus_master.models.Tblrfidmaster;
import com.tmtu.bus_master.repositories.TmtuTblrfidmasterRepository;

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
