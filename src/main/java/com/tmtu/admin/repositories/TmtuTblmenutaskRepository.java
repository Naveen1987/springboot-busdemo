package com.tmtu.admin.repositories;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.admin.models.Tblmenutask;

/**
 *This Repository Class for Tblmenutask Model
 *
 */
@Repository
public interface TmtuTblmenutaskRepository extends CrudRepository<Tblmenutask, Long>,TmtuTblmenutaskRepositoryCustom {
	public List<Tblmenutask> findBycreatedBy(long createdBy);
	public List<Tblmenutask> findBycreatedOn(Calendar createdOn);
	public List<Tblmenutask> findBylastModifiedBy(long ModifiedBy);
	public List<Tblmenutask> findBylastModifiedOn(Calendar ModifiedOn);
	public List<Tblmenutask> findBymenuName(String menuName);
	public List<Tblmenutask> findByredirectPage(String redirectPage);
}
