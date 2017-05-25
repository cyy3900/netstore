/**
 * 
 */
package com.cyy.domain;

import java.util.Date;

/**   
*    
* ��Ŀ���ƣ�netstore   
* �����ƣ�User   
* ��������   
* �����ˣ�cyy   
* ����ʱ�䣺2017��5��22�� ����9:04:31   
* �޸��ˣ�cyy   
* �޸�ʱ�䣺2017��5��22�� ����9:04:31   
* �޸ı�ע��   
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
public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private int active;
	private Date registerDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", active="
				+ active + ", registerDate=" + registerDate + "]";
	}
	
}
