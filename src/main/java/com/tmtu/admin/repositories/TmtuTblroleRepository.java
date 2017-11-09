package com.tmtu.admin.repositories;


import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.admin.models.Tbllogin;
import com.tmtu.admin.models.Tblrole;

/**
 * This Repository Class for Tblrole Model
 *
 */
@Repository
public interface TmtuTblroleRepository extends CrudRepository<Tblrole, Long>,TmtuTblroleRepositoryCustom {
public Tblrole findByroleName(String roleName);
public List<Tblrole> findBycreatedBy(long createdBy);
public List<Tblrole> findBycreatedOn(Calendar createdOn);
public List<Tblrole> findBylastModifiedBy(long lastModifiedBy);
public List<Tblrole> findBylastModifiedOn(Calendar lastModifiedOn);
public List<Tblrole> findBytblloginIn(Set<Tbllogin> aTbllogin);

public Tblrole findByRoleId(long roleId);
}
