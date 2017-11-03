package com.tmtu.repositories.manage_bus_master;

import com.tmtu.models.manage_bus_master.Tblconcessionmaster;

public interface TmtuTblconcessionmasterRepositoryCustom {
	public Tblconcessionmaster save(String concessionName,String concessionCode,long createdBy);
	public Tblconcessionmaster update(long concessionid, String concessionName,String concessionCode,long modifiedby);
}
