package com.tmtu.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.models.Tbllogin;
import com.tmtu.models.Tblrole;
import com.tmtu.models.Tbluserreporting;
import com.tmtu.repositories.TmtuTblloginRepository;
import com.tmtu.repositories.TmtuTbluserreportingRepository;

/**
 * This service for login
 *
 */
@Service
public class TmtuTblloginService {
@Autowired
TmtuTblloginRepository tmtuTblloginRepository;

@Autowired
TmtuTbluserreportingRepository tmtuTbluserreportingRepository;


private static final Logger logger=LoggerFactory.getLogger("Login Service");
public List<Map<String, String>> getByuserName(String userName) {
	List<Map<String, String>> listUser=new ArrayList<Map<String, String>>();
			List<Tbllogin> users=tmtuTblloginRepository.findByuserName(userName);
			users.forEach(record->{
				Map<String,String> usr=new HashMap<String,String>();
				usr.put("id",record.getTblloginId()+"");
				usr.put("username", record.getUserName());
				usr.put("roleid", record.getTblrole().getRoleId()+"");
				usr.put("displayname", record.getDisplayName());
				usr.put("isactive",record.getIsActive());
				Tbluserreporting tbluserreporting=tmtuTbluserreportingRepository.getReportingManagerByLoginId(record.getTblloginId());
				if(tbluserreporting!=null) {
				usr.put("reportid",tbluserreporting.getUserreportingid()+"");
				usr.put("reportingto",tbluserreporting.getReportingTo()+"");
				usr.put("datefrom",tbluserreporting.getDateFrom().getTimeInMillis()+"");
				usr.put("dateto",tbluserreporting.getDateTo().getTimeInMillis()+"");
				}
				else {
					usr.put("reportmsg","No reporting Manager Assign");
					
					}
				listUser.add(usr);
			});
			return listUser;
}
public List<Tbllogin> getBycreatedBy(long createdBy){
	return tmtuTblloginRepository.findBycreatedBy(createdBy);
	}
public List<Tbllogin> getBycreatedOn(Calendar createdOn){
	return tmtuTblloginRepository.findBycreatedOn(createdOn);
	}
public List<Tbllogin> getBydisplayName(String displayName){
	return tmtuTblloginRepository.findBydisplayName(displayName);
	}
public List<Tbllogin> getByemail(String email){
	return tmtuTblloginRepository.findByemail(email);
	}
public List<Tbllogin> getByflag(long flag){
	return tmtuTblloginRepository.findByflag(flag);
	}
public List<Tbllogin> getByisActive(String isActive){
	return tmtuTblloginRepository.findByisActive(isActive);
	}
public List<Tbllogin> getBylastModifiedBy(long lastModifiedBy){
	return tmtuTblloginRepository.findBylastModifiedBy(lastModifiedBy);
	}
public List<Tbllogin> getBylastModifiedOn(Calendar lastModifiedOn){
	return tmtuTblloginRepository.findBylastModifiedOn(lastModifiedOn);
	}
public List<Tbllogin> getBytblrole(Tblrole tblrole){
	return tmtuTblloginRepository.findBytblrole(tblrole);
	}
public Tbllogin getLoginUserNameAndPasswordAndIsActive(String userName,String password,String isActive){
	List<Tbllogin> logins=tmtuTblloginRepository.findByUserNameAndPasswordAndIsActive(userName, password, isActive);
	if(!logins.isEmpty()) {
		return logins.get(0);
	}
	else {
		return null;
	}
	}
public void deleteByemail(String email){
	tmtuTblloginRepository.deleteByemail(email);
}
public void deleteByuserName(String userName){
	tmtuTblloginRepository.deleteByuserName(userName);
}
public Tbllogin save(String userName,String password,String displayName,String email,long createdby,long roleId) {
	return tmtuTblloginRepository.save(userName, password, displayName, email, createdby,roleId);
}

public Tbllogin update(long loginid,String username,String password,String email,String display,long modifiedby) {
	Tbllogin tbllogin=tmtuTblloginRepository.findOne(loginid);
	if(tbllogin==null) {
		logger.error("User is not exist with id-"+loginid);
		return null;
	}
	else {
		tbllogin.setUserName(username);
		tbllogin.setLastModifiedBy(modifiedby);
		tbllogin.setLastModifiedOn(Calendar.getInstance());
		tbllogin.setPassword(password);
		tbllogin.setEmail(email);
		tbllogin.setDisplayName(display);
		
	}
	try {
		tmtuTblloginRepository.save(tbllogin);
		logger.info("Role updated successfully LoginId-"+loginid);
		return tbllogin;
	}catch (Exception e) {
		logger.error("Role can not be update because-"+e.getMessage());
		return null;
	}
	
}

public Tbllogin update(long loginid,String password,String email,String display,long modifiedby) {
	Tbllogin tbllogin=tmtuTblloginRepository.findOne(loginid);
	if(tbllogin==null) {
		logger.error("User is not exist with id-"+loginid);
		return null;
	}
	else {
		tbllogin.setLastModifiedBy(modifiedby);
		tbllogin.setLastModifiedOn(Calendar.getInstance());
		tbllogin.setPassword(password);
		tbllogin.setEmail(email);
		tbllogin.setDisplayName(display);
		
	}
	try {
		tmtuTblloginRepository.save(tbllogin);
		logger.info("User updated successfully LoginId-"+loginid);
		return tbllogin;
	}catch (Exception e) {
		logger.error("Role can not be update because-"+e.getMessage());
		return null;
	}
	
}

public Tbllogin DeActive(long loginid,long modifiedby) {
	Tbllogin tbllogin=tmtuTblloginRepository.findOne(loginid);
	if(tbllogin==null) {
		logger.error("User is not exist with id-"+loginid);
		return null;
	}
	else {
		tbllogin.setLastModifiedBy(modifiedby);
		tbllogin.setLastModifiedOn(Calendar.getInstance());
		tbllogin.setIsActive("0");
		
	}
	try {
		tmtuTblloginRepository.save(tbllogin);
		logger.info("User Deactivated successfully LoginId-"+loginid);
		return tbllogin;
	}catch (Exception e) {
		logger.error("User can Deactivated because-"+e.getMessage());
		return null;
	}
}

public Tbllogin active(long loginid,long modifiedby) {
	Tbllogin tbllogin=tmtuTblloginRepository.findOne(loginid);
	if(tbllogin==null) {
		logger.error("User is not exist with id-"+loginid);
		return null;
	}
	else {
		tbllogin.setLastModifiedBy(modifiedby);
		tbllogin.setLastModifiedOn(Calendar.getInstance());
		tbllogin.setIsActive("1");
		
	}
	try {
		tmtuTblloginRepository.save(tbllogin);
		logger.info("User activated successfully LoginId-"+loginid);
		return tbllogin;
	}catch (Exception e) {
		logger.error("User can activated because-"+e.getMessage());
		return null;
	}
}

public Tbllogin updateRole(long loginid,long roleid,long modifiedby) {
	return tmtuTblloginRepository.updateRole(loginid, roleid, modifiedby);
}

public Tbllogin getuser(long loginid) {
	Tbllogin tbllogin=tmtuTblloginRepository.findOne(loginid);
	return tbllogin;
}

public List<Tbllogin> getAll(){
	try {
		return (List<Tbllogin>) tmtuTblloginRepository.findAll();
	}catch (Exception e) {
		logger.info(e.getMessage());
		return null;
	}
	
}

}
