package com.tmtu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.repositories.TmtuTblmenutaskRepository;

@Service
public class TmtuTblmenutaskService {

	@Autowired
	TmtuTblmenutaskRepository tmtuTblmenutaskRepositor;
}
