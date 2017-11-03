package com.tmtu.repositories.manage_bus_master;

import com.tmtu.models.manage_bus_master.Tblrfidmaster;

public interface TmtuTblrfidmasterRepositoryCustom {

	public Tblrfidmaster save(String keys,double amount,long createdby);
	public Tblrfidmaster statusChange(long rfid,long modifiedby,boolean status);
	public Tblrfidmaster amountChange(long rfid,long modifiedby,double amount) ;
}
