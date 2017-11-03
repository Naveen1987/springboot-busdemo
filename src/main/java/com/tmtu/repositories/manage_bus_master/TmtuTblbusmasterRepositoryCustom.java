package com.tmtu.repositories.manage_bus_master;

import com.tmtu.models.manage_bus_master.Tblbusmaster;

public interface TmtuTblbusmasterRepositoryCustom {
public Tblbusmaster save(String busno,long registeron,long createdby,long bustype);
public Tblbusmaster update(long busid,String busno,long registeron,long modifiedby,long bustype);
//update bus type only
public Tblbusmaster update(long busid,long modifiedby,long bustype);
}
