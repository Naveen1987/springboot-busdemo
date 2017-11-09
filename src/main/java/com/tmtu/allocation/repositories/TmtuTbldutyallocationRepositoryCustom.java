package com.tmtu.allocation.repositories;

import java.util.Calendar;

import com.tmtu.allocation.models.Tbldutyallocation;

public interface TmtuTbldutyallocationRepositoryCustom {
public Tbldutyallocation save(
		Long conductorId,
		Long routeNumber,
		String machineNumber,
		Calendar fromDate,
		Calendar toDate,
		String startStoppage,
		String endStoppage,
		Calendar startTime,
		Calendar endTime,
		String depotcode,
		String depotName,
		String busNumber,
		Long shiftType,
		Long driverid,
		Long createdBy
		);
}
