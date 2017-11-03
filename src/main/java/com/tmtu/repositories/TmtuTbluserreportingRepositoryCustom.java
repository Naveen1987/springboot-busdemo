package com.tmtu.repositories;

import java.util.Calendar;

import com.tmtu.models.Tbluserreporting;

public interface TmtuTbluserreportingRepositoryCustom {

	public Tbluserreporting save(long loginid,long createdby,long reportto,Calendar datefrom,Calendar dateto);
	public Tbluserreporting update(long reportid,long loginid,long modifiedby,long reportto,Calendar datefrom,Calendar dateto);
}
