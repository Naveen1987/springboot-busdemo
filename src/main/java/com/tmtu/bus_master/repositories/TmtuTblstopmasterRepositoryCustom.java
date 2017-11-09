package com.tmtu.bus_master.repositories;

import com.tmtu.bus_master.models.Tblstopmaster;

public interface TmtuTblstopmasterRepositoryCustom {

	public Tblstopmaster save(Long routeid,Long createdby, Long busstopno, String busstopcode,String busstopname,Long km,Long sequencenumber,Boolean interstatestop);
	public Tblstopmaster update(Long stopid,Long routeid,Long modifiedby, Long busstopno, String busstopcode,String busstopname,Long km,Long sequencenumber,Boolean interstatestop);
}
