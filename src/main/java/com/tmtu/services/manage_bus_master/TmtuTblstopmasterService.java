package com.tmtu.services.manage_bus_master;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.models.manage_bus_master.Tblstopmaster;
import com.tmtu.repositories.manage_bus_master.TmtuTblstopmasterRepository;

@Service
public class TmtuTblstopmasterService {

	
	@Autowired
	TmtuTblstopmasterRepository tmtuTblstopmasterRepository;
	
	@SuppressWarnings("unchecked")
	public List<Tblstopmaster> save(Map<String,Object> stops){
		List<Tblstopmaster> tblstopmaters=new ArrayList<Tblstopmaster>();
		stops.entrySet().stream().forEach(e->{
			if(e.getKey().equalsIgnoreCase("stops")) {
				List<Map<String,Object>> list=(List<Map<String, Object>>) e.getValue();
				list.forEach(ls->{
					Tblstopmaster tblstopmaster=	tmtuTblstopmasterRepository.save(
							new Long(stops.get("routeid").toString()), 
							new Long(stops.get("createdby").toString()), 
							new Long(ls.get("busstopnumber").toString()), 
							(String)ls.get("busstopcode"), 
							(String)ls.get("busstopname"), 
							new Long(ls.get("km").toString()), 
							new Long(ls.get("sequencenumber").toString()), 
							new Boolean(ls.get("interstatestop").toString()));				
					if(tblstopmaster!=null) {
						tblstopmaters.add(tblstopmaster);
					}
				});
				
			}
		});
		return tblstopmaters;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Tblstopmaster> update(Map<String,Object> stops){
		List<Tblstopmaster> tblstopmaters=new ArrayList<Tblstopmaster>();
		stops.entrySet().stream().forEach(e->{
			if(e.getKey().equalsIgnoreCase("stops")) {
				List<Map<String,Object>> list=(List<Map<String, Object>>) e.getValue();
				list.forEach(ls->{
					
					System.out.println(ls);
					if(ls.get("stopid")!=null) {
						Tblstopmaster tblstopmaster=	tmtuTblstopmasterRepository.update(
								new Long(ls.get("stopid").toString()),
								stops.get("routeid")!=null?new Long(stops.get("routeid").toString()):null, 
								new Long(stops.get("modifiedby").toString()), 
								ls.get("busstopnumber")!=null?new Long(ls.get("busstopnumber").toString()):null, 
								ls.get("busstopcode")!=null?(String)ls.get("busstopcode"):null, 
								ls.get("busstopname")!=null?(String)ls.get("busstopname"):null, 
								ls.get("km")!=null?new Long(ls.get("km").toString()):null, 
								ls.get("sequencenumber")!=null?new Long(ls.get("sequencenumber").toString()):null, 
								ls.get("interstatestop")!=null?new Boolean(ls.get("interstatestop").toString()):null);	
						if(tblstopmaster!=null) {
							tblstopmaters.add(tblstopmaster);
						}
					}
					
					if(ls.get("stopid")==null) {
						Tblstopmaster tblstopmaster=	tmtuTblstopmasterRepository.save(
						new Long(stops.get("routeid").toString()), 
						new Long(stops.get("modifiedby").toString()), 
						new Long(ls.get("busstopnumber").toString()), 
						(String)ls.get("busstopcode"), 
						(String)ls.get("busstopname"), 
						new Long(ls.get("km").toString()), 
						new Long(ls.get("sequencenumber").toString()), 
						new Boolean(ls.get("interstatestop").toString()));	
						if(tblstopmaster!=null) {
							tblstopmaters.add(tblstopmaster);
						}
					}
									
					
				});
				
			}
		});
		return tblstopmaters;	
	}
	
}
