/**
 * 
 */
package com.cyy.dao;

import com.cyy.domain.User;

/**   
*    
* 项目名称：netstore   
* 类名称：UserDao   
* 类描述：   
* 创建人：cyy   
* 创建时间：2017年5月22日 下午10:03:29   
* 修改人：cyy   
* 修改时间：2017年5月22日 下午10:03:29   
* 修改备注：   
* @version    
*    
*/
public interface UserDao {
	boolean insertUser(User user);
	User findUser(int id);
	boolean updateUser(User user);
	boolean deleteUser(User user);
}
