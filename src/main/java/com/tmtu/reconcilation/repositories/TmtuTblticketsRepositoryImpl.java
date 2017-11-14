package com.tmtu.reconcilation.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.reconcilation.models.Tbltickets;
import com.tmtu.reconcilation.models.Tbltransaction;

public class TmtuTblticketsRepositoryImpl implements TmtuTblticketsRepositoryCustom{

	@Autowired
	TmtuTblticketsRepository tmtuTblticketsRepository;
	@Autowired
	TmtuTbltransactionRepository tmtuTbltransactionRepository;
	
	private static final Logger logger=LoggerFactory.getLogger("Tickets Repository");
	
	@Override
	public Tbltickets save(Long ticketid, Long transactionid, String tickettype, Double fare, Long concessiontype,
			Long createdby, Calendar createdOn, Long modifiedby) {
		Tbltransaction tbltransaction=tmtuTbltransactionRepository.findOne(transactionid);
		if(tbltransaction==null) {
			logger.error("No such type Tranaction Id:"+transactionid);
			return null;
		}
		Tbltickets tbltickets=new Tbltickets();
		tbltickets.setTicketid(ticketid);
		tbltickets.setTickettype(tickettype);
		tbltickets.setFare(fare);
		tbltickets.setConcession(concessiontype);
		tbltickets.setCreatedby(createdby);
		tbltickets.setCreatedOn(createdOn);
		if(modifiedby!=null) {
			tbltickets.setLastModifiedBy(modifiedby);
			tbltickets.setLastModifiedOn(Calendar.getInstance());
		}
		tbltickets.setTbltransaction(tbltransaction);
		//
		//tbltransaction.addTickets(tbltickets);
		try {
			tbltickets=tmtuTblticketsRepository.save(tbltickets);
			logger.info("Ticket saved id:"+tbltickets.getTicketid());
			return tbltickets;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
