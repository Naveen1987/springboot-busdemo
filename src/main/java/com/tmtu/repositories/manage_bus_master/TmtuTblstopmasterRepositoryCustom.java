package com.tmtu.repositories.manage_bus_master;

import com.tmtu.models.manage_bus_master.Tblstopmaster;

public interface TmtuTblstopmasterRepositoryCustom {

	public Tblstopmaster save(Long routeid,Long createdby, Long busstopno, String busstopcode,String busstopname,Long km,Long sequencenumber,Boolean interstatestop);
	public Tblstopmaster update(Long stopid,Long routeid,Long modifiedby, Long busstopno, String busstopcode,String busstopname,Long km,Long sequencenumber,Boolean interstatestop);
}
