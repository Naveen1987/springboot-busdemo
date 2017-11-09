package com.tmtu.bus_master.repositories;

import com.tmtu.bus_master.models.Tblfarechartmaster;

public interface TmtuTblfarechartmasterRepositoryCustom {
public Tblfarechartmaster save(long startkm,long tillkm,double amount,long bustypeid,long concessionid,long createdby);
public Tblfarechartmaster updatebusType(long farechartid,long bustypeid,long modifiedby);
public Tblfarechartmaster updateStartTillKm(long farechartid,long startkm,long tillkm,long modifiedby);
public Tblfarechartmaster updateConcession(long farechartid,long concessionid,long modifiedby);
public Tblfarechartmaster updatefareamount(long farechartid, double amount, long modifiedby);
}
