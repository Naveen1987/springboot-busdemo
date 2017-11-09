package com.tmtu.bus_master.repositories;

import com.tmtu.bus_master.models.Tblconcessionmaster;

public interface TmtuTblconcessionmasterRepositoryCustom {
	public Tblconcessionmaster save(String concessionName,String concessionCode,long createdBy);
	public Tblconcessionmaster update(long concessionid, String concessionName,String concessionCode,long modifiedby);
}
