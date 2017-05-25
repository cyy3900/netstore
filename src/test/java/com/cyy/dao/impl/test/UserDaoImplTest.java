/**
 * 
 */
package com.cyy.dao.impl.test;


import java.util.Date;

import org.junit.Test;

import com.cyy.dao.UserDao;
import com.cyy.dao.impl.UserDaoImpl;
import com.cyy.domain.User;

import junit.framework.Assert;

/**   
*    
* 项目名称：netstore   
* 类名称：UserDaoImplTest   
* 类描述：   
* 创建人：cyy   
* 创建时间：2017年5月22日 下午11:11:41   
* 修改人：cyy   
* 修改时间：2017年5月22日 下午11:11:41   
* 修改备注：   
* @version    
*    
*/
public class UserDaoImplTest {

	UserDao dao = new UserDaoImpl();
	/**
	 * Test method for {@link com.cyy.dao.impl.UserDaoImpl#insertUser(com.cyy.domain.User)}.
	 */
	@Test
	public void testInsertUser() {
		User user = new User();
		user.setUsername("cyy");
		user.setPassword("123");
		user.setEmail("cyy@126.com");
		user.setActive(0);
		user.setRegisterDate(new Date());
		Assert.assertEquals(true, dao.insertUser(user));
	}

	/**
	 * Test method for {@link com.cyy.dao.impl.UserDaoImpl#findUser(int)}.
	 */
	@Test
	public void testFindUser() {
		User user = dao.findUser(2);
		System.out.println(user.toString());
		Assert.assertNotNull(user);
		Assert.assertEquals(2, user.getId());
	}

	/**
	 * Test method for {@link com.cyy.dao.impl.UserDaoImpl#updateUser(com.cyy.domain.User)}.
	 */
	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setUsername("yuli");
		user.setPassword("333");
		user.setEmail("cyy@126.com");
		user.setRegisterDate(new Date());
		user.setActive(1);
		user.setId(2);
		dao.updateUser(user);
	}

	/**
	 * Test method for {@link com.cyy.dao.impl.UserDaoImpl#deleteUser(com.cyy.domain.User)}.
	 */
	@Test
	public void testDeleteUser() {
		User user = new User();
		user.setId(1);
		dao.deleteUser(user);
	}

}
