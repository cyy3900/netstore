/**
 * 
 */
package com.cyy.dao;

import com.cyy.domain.User;

/**   
*    
* ��Ŀ���ƣ�netstore   
* �����ƣ�UserDao   
* ��������   
* �����ˣ�cyy   
* ����ʱ�䣺2017��5��22�� ����10:03:29   
* �޸��ˣ�cyy   
* �޸�ʱ�䣺2017��5��22�� ����10:03:29   
* �޸ı�ע��   
* @version    
*    
*/
public interface UserDao {
	boolean insertUser(User user);
	User findUser(int id);
	boolean updateUser(User user);
	boolean deleteUser(User user);
}
