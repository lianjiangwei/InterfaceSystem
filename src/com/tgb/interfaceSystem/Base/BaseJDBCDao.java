package com.tgb.interfaceSystem.Base;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;



abstract public class BaseJDBCDao<T> extends BaseHibernateDaoImpl<T> {

	// 位父类中的connectionection进行赋值的操作
	public  DataSource getDataSource(SessionFactory sessionFactory) throws Exception{
//		try {
//
//			Session curSeesion = null;
//
//			curSeesion = super.getHibernateTemplate().getSessionFactory()
//					.getCurrentSession();
//			connection = curSeesion.connection();
//			return connection;
//		} catch (Exception es) {
//			System.out.println(es.getMessage());
//			return null;
//		}

		
	
//		Properties props = new Properties();
//		props.setProperty("driver", "com.mysql.jdbc.Driver");
//		props.setProperty("url", "jdbc:mysql://192.168.24.82:3306/test");
//		props.setProperty("username", "root");
//		props.setProperty("password", "123456");  
//	
//		return BasicDataSourceFactory.createDataSource(props);
	 return SessionFactoryUtils.getDataSource(sessionFactory);
	}

	/* 关闭数据库连接 */
	public void closeconnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 查询（返回Array结果） */
	public Object[] queryArray(String sql, Object... params) {
		Object[] result = null;
		try {
			result = runner.query(connection, sql, new ArrayHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 查询（返回ArrayList结果） */
	public List<Object[]> queryArrayList(String sql,
			Object... params) {
		List<Object[]> result = null;
		try {

			result = runner.query(connection, sql, new ArrayListHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 查询（返回Map结果） */
	public Map<String, Object> queryMap(String sql,
			Object... params) {
		Map<String, Object> result = null;
		try {
			result = runner.query(connection, sql, new MapHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 查询（返回MapList结果） */
	public List<Map<String, Object>> queryMapList(String sql,
			Object... params) {

		List<Map<String, Object>> result = null;
		try {
			result = runner.query(connection, sql, new MapListHandler(), params);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 查询（返回Bean结果） */
	public <T> T queryBean(Class<T> cls, Map<String, String> map, String sql, Object... params) {
		T result = null;
		try {
			if (map != null) {
				result = runner.query(connection, sql, new BeanHandler<T>(cls,
						new BasicRowProcessor(new BeanProcessor(map))), params);
			} else {
				result = runner.query(connection, sql, new BeanHandler<T>(cls),
						params);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 查询（返回BeanList结果） */
	public <T> List<T> queryBeanList(Class<T> cls, Map<String, String> map, String sql, Object... params) {
		List<T> result = null;
		try {
			if (map != null) {
				result = runner.query(connection, sql, new BeanListHandler<T>(cls,
						new BasicRowProcessor(new BeanProcessor(map))), params);
			} else {
				result = runner.query(connection, sql, new BeanListHandler<T>(cls),
						params);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 查询指定列名的值（单条数据） */
	public <T> T queryColumn(String column, String sql,
			Object... params) {
		T result = null;
		try {
		
			result = runner.query(connection, sql, new ScalarHandler<T>(column),
					params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 查询指定列名的值（多条数据） */
	public <T> List<T> queryColumnList(String column, 
			String sql, Object... params) {
		List<T> result = null;
		try {
			result = runner.query(connection, sql, new ColumnListHandler<T>(column),
					params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 查询指定列名对应的记录映射 */
	public <T> Map<T, Map<String, Object>> queryKeyMap(String column,
			 String sql, Object... params) {
		Map<T, Map<String, Object>> result = null;
		try {
			result = runner.query(connection, sql, new KeyedHandler<T>(column),
					params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 更新（包括UPDATE、INSERT、DELETE，返回受影响的行数） */
	public int update( String sql, Object... params) {
		int result = 0;
		try {

			result = runner.update(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// -------------------------------------添加方法----------------------------------
	public <T> T insert(String sql, ResultSetHandler<T> rsh)
			throws SQLException {
		T object = null;
		try {

			object = runner.insert(sql, rsh);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return object;

	}

	public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params)
			throws SQLException {
		T object = null;
		try {

			object = runner.insert(sql, rsh, params);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return object;

	}

	
	

	public <T> T insertBatch(String sql, ResultSetHandler<T> rsh,
			Object[][] params) throws SQLException {

		T object = null;
		try {

		
	
			object = runner.insertBatch(sql, rsh, params);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return object;
	}

	
	
	
	   public int[] batch(String sql, Object[][] params) throws SQLException {
	       return runner.batch(sql, params);
	    }
	
}
