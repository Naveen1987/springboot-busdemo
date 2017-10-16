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

import com.tmtu.services.TmtuTblloginService;

/**
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = TmtuTblloginController.class, secure = false)
public class TmtuTblloginControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TmtuTblloginService tmtuTblloginService;
	
	/**
	 * Test method for {@link com.tmtu.controllers.TmtuTblloginController#login(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.tmtu.controllers.TmtuTblloginController#saveUser(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long)}.
	 */
	@Test
	public void testSaveUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.tmtu.controllers.TmtuTblloginController#updateprofile(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUpdateprofile() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.tmtu.controllers.TmtuTblloginController#updateRole(long, long, long)}.
	 */
	@Test
	public void testUpdateRole() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.tmtu.controllers.TmtuTblloginController#deActive(long, long)}.
	 */
	@Test
	public void testDeActive() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.tmtu.controllers.TmtuTblloginController#getById(long)}.
	 */
	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.tmtu.controllers.TmtuTblloginController#getAllUsers()}.
	 */
	@Test
	public void testGetAllUsers() {
		fail("Not yet implemented");
	}

}
