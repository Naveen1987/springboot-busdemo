package com.tmtu.reconcilation.repositories;

import java.util.Calendar;

import com.tmtu.reconcilation.models.Tbltickets;

public interface TmtuTblticketsRepositoryCustom {

	public Tbltickets save(
			Long ticketid,
			Long transactionid,
			String tickettype,
			Double fare,
			Long concessiontype,
			Long createdby,
			Calendar createdOn,
			Long modifiedby
			);
}
