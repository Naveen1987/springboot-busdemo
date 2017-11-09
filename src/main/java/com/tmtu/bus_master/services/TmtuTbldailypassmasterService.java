package com.tmtu.bus_master.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.bus_master.repositories.TmtuTbldailypassmasterRepository;

@Service
public class TmtuTbldailypassmasterService {

	@Autowired
	TmtuTbldailypassmasterRepository tmtuTbldailypassmasterRepository;
}
