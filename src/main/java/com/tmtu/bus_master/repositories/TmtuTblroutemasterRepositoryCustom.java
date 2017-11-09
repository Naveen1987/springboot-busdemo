package com.tmtu.bus_master.repositories;

import com.tmtu.bus_master.models.Tblroutemaster;

public interface TmtuTblroutemasterRepositoryCustom {
public Tblroutemaster save(long busTypeId,long routeNumber, String firstBusStopCode,String firstusStopName,long totalStopCount,String lastBusStopCode,String lastBusStopName,long createdBy);
public Tblroutemaster update(Long routeid,Long busTypeId, String firstBusStopCode,String firstusStopName,Long totalStopCount,String lastBusStopCode,String lastBusStopName,Long modifiedBy);
public Tblroutemaster updateBusType(long routeId,long busTypeId,long modifiedby);
public Tblroutemaster updateFirstStop(long routeId,String firstBusStopCode,String firstusStopName,long modifiedby);
public Tblroutemaster updateLastStop(long routeId, String lastBusStopCode,String lastBusStopName,long modifiedby);
public Tblroutemaster updateTotalStopCount(long routeId,long totalStopCount,long modifiedby);
}
