package com.tmtu.reconcilation.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.reconcilation.models.Tbltickets;
import com.tmtu.reconcilation.repositories.TmtuTblticketsRepository;

@Service
public class TmtuTblticketsService {

	@Autowired
	TmtuTblticketsRepository tmtuTblticketsRepository;
	public Tbltickets save(Long ticketid, Long transactionid, String tickettype, Double fare, Long concessiontype,
			Long createdby, Long createdOn, Long modifiedby) {
		Calendar cCreatedOn=Calendar.getInstance();
		cCreatedOn.setTimeInMillis(createdOn);
		return tmtuTblticketsRepository.save(ticketid, transactionid, tickettype, fare, concessiontype, createdby, cCreatedOn, modifiedby);
	}
}
