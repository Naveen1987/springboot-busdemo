/**
 * 
 */
package com.tmtu.controllers;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tmtu.admin.controllers.TmtuTblroleController;
import com.tmtu.admin.services.TmtuTblroleService;



/**
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = TmtuTblroleController.class, secure = false)
public class TmtuTblroleControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TmtuTblroleService tmtuTblroleService; 
	
	
	/**
	 * Test method for {@link com.tmtu.admin.controllers.TmtuTblroleController#saveRole(java.lang.String, long)}.
	 */
	@Test
	public void testSaveRole() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.tmtu.admin.controllers.TmtuTblroleController#updateRole(java.lang.String, long, long)}.
	 */
	@Test
	public void testUpdateRole() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.tmtu.admin.controllers.TmtuTblroleController#getrole(long)}.
	 */
	@Test
	public void testGetrole() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.tmtu.admin.controllers.TmtuTblroleController#getAllRoles()}.
	 */
	@Test
	public void testGetAllRoles() {
		fail("Not yet implemented");
	}

}
