package com.tmtu.services.manage_bus_master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.repositories.manage_bus_master.TmtuTbldailypassmasterRepository;

@Service
public class TmtuTbldailypassmasterService {

	@Autowired
	TmtuTbldailypassmasterRepository tmtuTbldailypassmasterRepository;
}
