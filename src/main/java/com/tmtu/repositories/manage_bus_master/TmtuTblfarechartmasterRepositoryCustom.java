package com.tmtu.repositories.manage_bus_master;

import com.tmtu.models.manage_bus_master.Tblfarechartmaster;

public interface TmtuTblfarechartmasterRepositoryCustom {
public Tblfarechartmaster save(long startkm,long tillkm,double amount,long bustypeid,long concessionid,long createdby);
public Tblfarechartmaster updatebusType(long farechartid,long bustypeid,long modifiedby);
public Tblfarechartmaster updateStartTillKm(long farechartid,long startkm,long tillkm,long modifiedby);
public Tblfarechartmaster updateConcession(long farechartid,long concessionid,long modifiedby);
public Tblfarechartmaster updatefareamount(long farechartid, double amount, long modifiedby);
}
