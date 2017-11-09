package com.tmtu.admin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.admin.models.Tblmenugroup;

/**
 * This Repository Class for Tblmenugroup Model
 *
 */
@Repository
public interface TmtuTblmenugroupRepository extends CrudRepository<Tblmenugroup, Long>,TmtuTblmenugroupRepositoryCustom {
public Tblmenugroup findBygroupName(String groupName);
}
