package com.tmtu.allocation.repositories;

import com.tmtu.allocation.models.Tbldepotmaster;

public interface TmtuTbldepotmasterRepositoryCustom {
	
	public Tbldepotmaster save(String depotName,String depotcode,Long createdBy);
		
}
