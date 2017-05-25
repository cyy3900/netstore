/**
 * 
 */
package com.cyy.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cyy.dao.UserDao;
import com.cyy.domain.User;
import com.cyy.utils.DBUtils;

/**   
*    
* 项目名称：netstore   
* 类名称：UserDaoImpl   
* 类描述：   
* 创建人：cyy   
* 创建时间：2017年5月22日 下午10:06:57   
* 修改人：cyy   
* 修改时间：2017年5月22日 下午10:06:57   
* 修改备注：   
* @version    
*    
*/
/*
 * create table user(
id int auto_increment,
username varchar(30) not null,
password varchar(30) not null,
email varchar(30),
active int,
registerDate date,
primary key (id)
);
 */
public class UserDaoImpl implements UserDao {

	Statement st = null;
	/* (non-Javadoc)
	 * @see com.cyy.dao.UserDao#insertUser(com.cyy.domain.User)
	 */
	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		String sql = "insert into user(username,password,email,active,registerDate) values(?,?,?,?,?)";
		try {
			int i = DBUtils.update(conn, sql, new Object[]{user.getUsername(),user.getPassword(),user.getEmail(),user.getActive(),user.getRegisterDate()});
			return i>0 ? true:false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.cyy.dao.UserDao#findUser(int)
	 */
	@Override
	public User findUser(int id) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		String sql = "select id,username,password,email,active,registerDate from user where id=?";
		return DBUtils.query(conn, sql, new Object[]{2}, User.class);
	}

	/* (non-Javadoc)
	 * @see com.cyy.dao.UserDao#updateUser(com.cyy.domain.User)
	 */
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		String sql = "update user set username=?,password=?,email=?,active=?,registerDate=? where id=?";
		try {
			int i = DBUtils.update(conn, sql, new Object[]{user.getUsername(),user.getPassword(),user.getEmail(),user.getActive(),user.getRegisterDate(),user.getId()});
			return i>0 ? true:false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.cyy.dao.UserDao#deleteUser(com.cyy.domain.User)
	 */
	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		String sql = "delete from user where id=?";
		try {
			int i = DBUtils.update(conn, sql, new Object[]{user.getId()});
			return i>0 ? true:false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
