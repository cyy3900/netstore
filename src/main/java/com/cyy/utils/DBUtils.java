/**
 * 
 */
package com.cyy.utils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**   
*    
* 项目名称：netstore   
* 类名称：DBUtils   
* 类描述：   
* 创建人：cyy   
* 创建时间：2017年5月22日 下午9:06:57   
* 修改人：cyy   
* 修改时间：2017年5月22日 下午9:06:57   
* 修改备注：   
* @version    
*    
*/
public class DBUtils {

	private static String username;
	private static String password;
	private static String driver;
	private static String url;
	static{
		InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		try {
			prop.load(input);
			username = prop.getProperty("jdbc.username");
			password = prop.getProperty("jdbc.password");
			driver = prop.getProperty("jdbc.driver");
			url = prop.getProperty("jdbc.url");
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return conn;
	}
	
	public static void close(ResultSet rs,Statement st,Connection conn){
		try {
			if(rs != null){
				rs.close();
			}
			if(st != null){
				st.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs = null;
		st = null;
		conn = null;
	}
	
	public static int update(Connection conn,String sql,Object[] params){
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for(int i=0;i<params.length; i++){
				ps.setObject(i+1, params[i]);
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ps != null){
				try {
					ps.close();
					ps = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	public static <T> T query(Connection conn,String sql,Object[] params,Class<T> beanClass){
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement(sql);
				for(int i=0;i<params.length; i++){
					ps.setObject(i+1, params[i]);
				}
				ResultSet rs = ps.executeQuery();
				Field[] fields = beanClass.getDeclaredFields();
				for (Field field : fields) {
					field.setAccessible(true);
				}
				T t = beanClass.newInstance();
				while(rs != null && rs.next()){
					for(Field f: fields){
						String name = f.getName();
						Object value = rs.getObject(name);
						f.set(t, value);
					}
				}
				return t;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(ps != null){
					try {
						ps.close();
						ps = null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		return null;
	}
}
