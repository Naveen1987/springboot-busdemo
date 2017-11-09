package com.tmtu.admin.controllers;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tmtu.admin.models.Tbllogin;
import com.tmtu.admin.models.Tbluserreporting;
import com.tmtu.admin.services.TmtuTblloginService;
import com.tmtu.admin.services.TmtuTblroleService;
import com.tmtu.admin.services.TmtuTbluserreportingService;


@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblloginController {

	@Autowired
	TmtuTblloginService tmtuTblloginService;
	
	@Autowired
	TmtuTblroleService tmtuTblroleService; 
	
	@Autowired
	TmtuTbluserreportingService tmtuTbluserreportingService;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestParam("username") String userName,@RequestParam("password") String password)  {
		Map<String,String> json=new HashMap<String,String>();
		Tbllogin tbllogin=tmtuTblloginService.getLoginUserNameAndPasswordAndIsActive(userName, password, "1");
		if(tbllogin!=null) {
			json.put("msg", "login successfully");
			json.put("id", tbllogin.getTblloginId()+"");
			json.put("displayname", tbllogin.getDisplayName());
			json.put("email", tbllogin.getEmail());
			json.put("roleid", tbllogin.getTblrole().getRoleId()+"");
			json.put("username", tbllogin.getUserName());
			json.put("password", tbllogin.getPassword());
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);		
		}
		else {
			json.put("msg", "login failure ");
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<Map<String, String>> saveUser(
			@RequestParam("createdby") long createdBy,
			@RequestParam("email") String email,
			@RequestParam("displayname") String displayName,
			@RequestParam("username") String userName,
			@RequestParam("password") String password,
			@RequestParam("roleid") long roleId,
			@RequestParam(value="reportto",required=false) Long reportto,
			@RequestParam(value="datefrom",required=false) Long datefrom,
			@RequestParam(value="dateto",required=false) Long dateto
			){
		Map<String,String> json=new HashMap<String,String>();
		Tbllogin tbllogin=tmtuTblloginService.save(userName, password, displayName, email, createdBy,roleId);
		if(tbllogin==null) {
			json.put("msg", "fail due to username exist or role is not existed.");
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.BAD_REQUEST);
		}
		else {
			if(reportto!=null && datefrom!=null &&dateto!=null) {
				Tbluserreporting tbluserreporting=tmtuTbluserreportingService.save(tbllogin.getTblloginId(), createdBy, reportto, datefrom, dateto);
				if(tbluserreporting==null) {
					json.put("reportmsg", "Reporting Manager not added successfully");
				}
				else {
				json.put("reportmsg", "Reporting Manager added successfully");	
				}	
			}
			json.put("msg", "User Added successfully.");
			json.put("id", tbllogin.getTblloginId()+"");
			json.put("displayname", tbllogin.getDisplayName());
			json.put("email", tbllogin.getEmail());
			json.put("roleid", tbllogin.getTblrole().getRoleId()+"");
			json.put("username", tbllogin.getUserName());
			
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
		}
		
	}
	@PostMapping("/updateprofile")
	public ResponseEntity<Map<String, String>> updateprofile(
			@RequestParam("id") long id,
			@RequestParam("email") String email,
			@RequestParam("displayname") String displayName,
			@RequestParam("password") String password
			){	
		Map<String,String> json=new HashMap<String,String>();
		Tbllogin tbllogin=tmtuTblloginService.update(id, password, email, displayName, id);
		if(tbllogin==null) {
			json.put("msg", "failed due to username duplicate.");
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg", "User Updated successfully.");
			json.put("id", tbllogin.getTblloginId()+"");
			json.put("displayname", tbllogin.getDisplayName());
			json.put("email", tbllogin.getEmail());
			json.put("roleid", tbllogin.getTblrole().getRoleId()+"");
			json.put("username", tbllogin.getUserName());
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
		}
	}
	@PostMapping("/updateuserrole")
	public ResponseEntity<Map<String, String>> updateRole(
			@RequestParam("id") long id,
			@RequestParam("roleid") long roleid,
			@RequestParam("modifiedby") long modifiedby
			){
		Map<String,String> json=new HashMap<String,String>();
		Tbllogin tbllogin=tmtuTblloginService.updateRole(id, roleid, modifiedby);
		if(tbllogin==null) {
			json.put("msg", "User is not exist.");
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg", "User Role Updated successfully.");
			json.put("id", tbllogin.getTblloginId()+"");
			json.put("roleid", tbllogin.getTblrole().getRoleId()+"");
			json.put("username", tbllogin.getUserName());
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
		}
	}
	
	@PostMapping("/deactive")
	public ResponseEntity<Map<String, String>> deActive(
			@RequestParam("id") long id,
			@RequestParam("modifiedby") long modifiedby
			){
		Map<String,String> json=new HashMap<String,String>();
		Tbllogin tbllogin=tmtuTblloginService.DeActive(id, modifiedby);
		if(tbllogin==null) {
			json.put("msg", "User is not exist.");
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg", "User Deactivated Updated successfully.");
			json.put("id", tbllogin.getTblloginId()+"");
			json.put("isactive",tbllogin.getIsActive());
			json.put("username", tbllogin.getUserName());
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
		}
	}
	
	
	@PostMapping("/active")
	public ResponseEntity<Map<String, String>> active(
			@RequestParam("id") long id,
			@RequestParam("modifiedby") long modifiedby
			){
		Map<String,String> json=new HashMap<String,String>();
		Tbllogin tbllogin=tmtuTblloginService.active(id, modifiedby);
		if(tbllogin==null) {
			json.put("msg", "User is not exist.");
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg", "User Activated Updated successfully.");
			json.put("id", tbllogin.getTblloginId()+"");
			json.put("isactive",tbllogin.getIsActive());
			json.put("username", tbllogin.getUserName());
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<List<Map<String, String>>> getByUserName(
			@RequestParam("username") String userName
			){
		List<Map<String, String>> tbllogin=tmtuTblloginService.getByuserName(userName);
		
		if(tbllogin.size()<1) {
			Map<String,String> json=new HashMap<String,String>();
			json.put("msg", "User does not exist.");
			tbllogin.add(json);
			return new ResponseEntity<List<Map<String, String>>>(tbllogin, HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<List<Map<String, String>>>(tbllogin, HttpStatus.OK);
		}
	}
	
	/*
	 * Only for testing
	 * */
	@GetMapping("/getuserinfo")
	public ResponseEntity<Map<String, String>> getById(
			@RequestParam("id") long id
			){
		Map<String,String> json=new HashMap<String,String>();
		Tbllogin tbllogin=tmtuTblloginService.getuser(id);
		if(tbllogin==null) {
			json.put("msg", "User is not exist.");
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
		}
		else {
			json.put("msg", "User found.");
			json.put("id", tbllogin.getTblloginId()+"");
			json.put("displayname", tbllogin.getDisplayName());
			json.put("email", tbllogin.getEmail());
			json.put("roleid", tbllogin.getTblrole().getRoleId()+"");
			json.put("username", tbllogin.getUserName());
			json.put("password", tbllogin.getPassword());
			json.put("createdby", tbllogin.getCreatedBy()+"");
			json.put("modifiedby", tbllogin.getCreatedBy()+"");
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
		}
	}

	@GetMapping("/getusers")
	public List<Tbllogin> getAllUsers(){
		return tmtuTblloginService.getAll();
	}
}
