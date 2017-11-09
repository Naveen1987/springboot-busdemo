package com.tmtu.bus_master.repositories;

import com.tmtu.bus_master.models.Tblrfidmaster;

public interface TmtuTblrfidmasterRepositoryCustom {

	public Tblrfidmaster save(String keys,double amount,long createdby);
	public Tblrfidmaster statusChange(long rfid,long modifiedby,boolean status);
	public Tblrfidmaster amountChange(long rfid,long modifiedby,double amount) ;
}
