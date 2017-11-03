package com.tmtu.repositories.etim;

import com.tmtu.models.etim.Tbletimmaster;

public interface TmtuTbletimmasterRepositoryCustom {
public Tbletimmaster save(String imei,String etimName,String serialNumber,String version,Long createdBy);
public Tbletimmaster update(String imei,String etimName,String serialNumber,String version,Long modifiedBy);
public Tbletimmaster stauschange(String imei,Boolean status);
}
