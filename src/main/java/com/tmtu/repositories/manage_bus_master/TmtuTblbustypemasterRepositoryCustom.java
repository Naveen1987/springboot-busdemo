package com.tmtu.repositories.manage_bus_master;

import com.tmtu.models.manage_bus_master.Tblbustypemaster;

public interface TmtuTblbustypemasterRepositoryCustom {
public Tblbustypemaster save(String serviceTypeName,String servicetypeCode,long createdby);
public Tblbustypemaster update(String serviceTypeName,String servicetypeCode,long modifiedby,long bustypeid);
}
