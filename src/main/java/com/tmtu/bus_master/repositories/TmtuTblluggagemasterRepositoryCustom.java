package com.tmtu.bus_master.repositories;

import com.tmtu.bus_master.models.Tblluggagemaster;

public interface TmtuTblluggagemasterRepositoryCustom {
public Tblluggagemaster save(long farechartid,long startkm,long tillkm, double amount,long createdby);
public Tblluggagemaster save(long startkm, long tillkm, double amount, long createdby);
public Tblluggagemaster updateluggagefarechart(long luggageid,long farechartid,long modifiedby);
public Tblluggagemaster updateluggageAmount(long luggageid,double amount,long modifiedby);
}
