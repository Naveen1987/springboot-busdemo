package com.tmtu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.repositories.TmtuTblmenugroupRepository;

@Service
public class TmtuTblmenugroupService {

	@Autowired
	TmtuTblmenugroupRepository	tmtuTblmenugroupRepository;
}
