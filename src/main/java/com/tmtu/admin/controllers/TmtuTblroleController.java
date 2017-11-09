package com.tmtu.admin.controllers;

import java.util.ArrayList;
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
import com.tmtu.admin.models.Tblrole;
import com.tmtu.admin.services.TmtuTblroleService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblroleController {

	@Autowired
	TmtuTblroleService tmtuTblroleService; 
	
	@PostMapping("/addrole")
	public ResponseEntity<Map<String, String>> saveRole(
			@RequestParam("rolename") String rolename,
			@RequestParam("createdby") long createdby) {
		
		Tblrole tblrole=tmtuTblroleService.saveRole(rolename,createdby);
		Map<String,String> json=new HashMap<String,String>();
		if(tblrole==null) {
			json.put("msg", "Role is existed.");
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg", "Role Successfully created");
			json.put("roleid", tblrole.getRoleId()+"");
			json.put("rolename", tblrole.getRoleName());
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/updaterole")
	public ResponseEntity<Map<String, String>> updateRole(
			@RequestParam("rolename") String rolename,
			@RequestParam("roleid") long roleid,
			@RequestParam("modifiedby") long modifiedby) {
	Tblrole tblrole=tmtuTblroleService.update(rolename, roleid, modifiedby);
	Map<String,String> json=new HashMap<String,String>();
	if(tblrole==null) {
		json.put("msg", "Role is not existed or Role name is not unique.");
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.BAD_REQUEST);
	}
	else {
		json.put("msg", "Role Successfully Updated");
		json.put("roleid", tblrole.getRoleId()+"");
		json.put("rolename", tblrole.getRoleName());
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}
		
	}
	@GetMapping("/role")
	public Tblrole getrole(
			@RequestParam("roleid") long roleid
			){
		Tblrole tbrole=tmtuTblroleService.getRole(roleid);
		return tbrole;
		} 
	
	@GetMapping("/roles")
	public ResponseEntity<List<Map<String,String>>> getAllRoles(){
		List<Map<String,String>> roles=tmtuTblroleService.getAllRoles();		
		return new ResponseEntity<List<Map<String, String>>>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/usersinrole")
	public ResponseEntity<Map<String,Object>> getroleByName(
			@RequestParam("rolename") String rolename
			){
		Tblrole tbrole=tmtuTblroleService.getByroleName(rolename);
		Map<String,Object> roles=new HashMap<String,Object>();
		if(tbrole!=null) {
			roles.put("roleid",tbrole.getRoleId()+"");
			roles.put("rolename",tbrole.getRoleName());
			ArrayList<Map<String,String>>arr=new ArrayList<Map<String,String>>();
			for(Tbllogin tbl:tbrole.getTbllogin()) {
				Map<String,String> users=new HashMap<String,String>();
				users.put("id", tbl.getTblloginId()+"");
				users.put("displayname", tbl.getDisplayName());
				users.put("email", tbl.getEmail());
				users.put("username", tbl.getUserName());
				arr.add(users);
			}
			roles.put("users", arr);
			roles.put("msg", "role found");
			return new ResponseEntity<Map<String, Object>>(roles, HttpStatus.OK);
		}
		roles.put("msg", "Not found");
		return new ResponseEntity<Map<String, Object>>(roles, HttpStatus.BAD_REQUEST);
		} 
	
	/*@GetMapping("/reportingto")
	public Tblrole getroleByName(
			@RequestParam("rolename") String rolename
			){
		Tblrole tbrole=tmtuTblroleService.getByroleName(rolename);
		return tbrole;
		} */
}
