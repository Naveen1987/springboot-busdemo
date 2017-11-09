package com.tmtu.allocation.repositories;

import com.tmtu.allocation.models.Tbletimmaster;

public interface TmtuTbletimmasterRepositoryCustom {
public Tbletimmaster save(String imei,String etimName,String serialNumber,String version,Long createdBy);
public Tbletimmaster update(String imei,String etimName,String serialNumber,String version,Long modifiedBy);
public Tbletimmaster stauschange(String imei,Boolean status);
}
