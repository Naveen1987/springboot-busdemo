package com.tmtu.bus_master.repositories;

import com.tmtu.bus_master.models.Tblbustypemaster;

public interface TmtuTblbustypemasterRepositoryCustom {
public Tblbustypemaster save(String serviceTypeName,String servicetypeCode,long createdby);
public Tblbustypemaster update(String serviceTypeName,String servicetypeCode,long modifiedby,long bustypeid);
}
