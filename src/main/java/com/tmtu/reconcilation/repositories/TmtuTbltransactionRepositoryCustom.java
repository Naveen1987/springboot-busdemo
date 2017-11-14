package com.tmtu.reconcilation.repositories;

import java.util.Calendar;
import com.tmtu.reconcilation.models.Tbltransaction;

public interface TmtuTbltransactionRepositoryCustom {
public Tbltransaction save(
		Long transactionid,
		Long waybillnumber,
		String fromstopage,
		String tostopage,
		Long totaltickets,
		Double totalamount,
		String paymenttype,
		Long createdby,
		Calendar createdOn,
		Long modifiedby
		);
}
