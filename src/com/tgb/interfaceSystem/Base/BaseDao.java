package com.tgb.interfaceSystem.Base;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

import com.tgb.interfaceSystem.action.bean.QueryResult;

/**  
 * @ClassName: BaseDao   
 * @Description: 底层抽象的方法，为所有的的底层服务，把一些公共的方法抽取到最底层
 * @author: LUCKY  
 * @date:2015年9月26日 下午1:24:28  
 * @param <T>   
 */ 
public interface BaseDao<T> {
	
	
	// -------------------------------------------添加方法--------------------------------------------------------------------------------

	/* 根据集合来添加或者更新方法，如果实体处于persient状态的话，则是更新操作
	 * 如果是transient状态的话，测试添加操作
	 * @param list   要添加的实体集合
	 */  
	public void saveOrUpdateAll(List list);

	
	

	
	/* 保存实体方法
	 * @param t  要保存的实体
	 * @return   保存后的实体
	 */  
	public T saveEntity(T t);

	
	
	
	

	/*  批量添加对象实体，如果实体库中没有的话，调用的是添加方法 库中有的话，会自动调用更新方法
	 * @param t   要添加的实体对象
	 */  
	public void saveOrUpdateObject(T t);

	
	
	
	// -------------------------------------------更新方法--------------------------------------------------------------------------------

	
	/* 更新实体方法
	 * @param t   要更新的实体  
	 */  
	public void update(T t);
	
	public void merge(T t) ;

	// -------------------------------------------删除方法--------------------------------------------------------------------------------
	
	
	/* 删除实体方法  
	 * @param t   要删除的实体
	 */  
	public void delete(T t);

	
	
	/* 根据实体id进行删除实体 
	 * @param id   实体id
	 */  
	public void deleteById(Serializable id);

	// -------------------------------------------查询方法--------------------------------------------------------------------------------

	
	
	/*根据实体类型和实体ID来查询实体操作
	 * @param entityClass  实体的class类型
	 * @param id  实体的id
	 * @return   要查询的实体
	 */  
	public T get(Class<T> entityClass, Serializable id);
	
	


	
	

	/*
	 * @param clazz 实体的class类型
	 * @return 查询某个实体类的库中的所有信息
	 */
	public List<T> getObjects(Class clazz) ;

	
	
	

	
	

	
	
	

	/*
	 * @param obj 对象实体
	 * 
	 * @return 根据对象获取某个类的所有对象
	 */
	public List getObjectsByExample(T obj);


	
	
	
	
	
	
	
	//分页查询开始
	
	
	/**
     * hql分页查询
     * 
     * @param hql
     *            查询字符串
     * @param queryResult
     *            查询结果
     * @param values
     *            查询值
     * @return
     */

    public QueryResult hqlQueryPage(final String hql,
            final QueryResult queryResult, final Map values);
 
    
    
    /**
     * hql查询得到总查询数目
     * 
     * @param hql
     *          查询字符串
     * @param values
     *          查询值
     * @return
     */
    @SuppressWarnings("unchecked")
    public Long getAllCount(final String hql, final Map values);
	


	/* 根据Hql语句，进行查询相应的实体
	 * @param hql  hql语句
	 * @param param  hql语句中的参数
	 * @return   
	 */  
	public List findHql(final String hql, final Map<String, Object> param) ;
	
	
	
	
	
	
	
	
	
	
	
	
	//---------------------------纯JDBC中封装的底层的方法，采用的是DBUtil
	/* 查询（返回Array结果） */
	public Object[] queryArray(String sql, Object... params) ;

	/* 查询（返回ArrayList结果） */
	public List<Object[]> queryArrayList(String sql,
			Object... params) ;

	/* 查询（返回Map结果） */
	public Map<String, Object> queryMap(String sql,
			Object... params);

	/* 查询（返回MapList结果） */
	public List<Map<String, Object>> queryMapList(String sql,
			Object... params);

	/* 查询（返回Bean结果） */
	public <T> T queryBean(Class<T> cls, Map<String, String> map, String sql, Object... params);

	/* 查询（返回BeanList结果） */
	public <T> List<T> queryBeanList(Class<T> cls, Map<String, String> map, String sql, Object... params) ;

	/* 查询指定列名的值（单条数据） */
	public <T> T queryColumn(String column, String sql,
			Object... params) ;
	/* 查询指定列名的值（多条数据） */
	public <T> List<T> queryColumnList(String column, 
			String sql, Object... params);

	/* 查询指定列名对应的记录映射 */
	public <T> Map<T, Map<String, Object>> queryKeyMap(String column,
			 String sql, Object... params) ;

	/* 更新（包括UPDATE、INSERT、DELETE，返回受影响的行数） */
	public int update( String sql, Object... params) ;

	// -------------------------------------添加方法----------------------------------
	public <T> T insert(String sql, ResultSetHandler<T> rsh)
			throws SQLException ;

	public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params)
			throws SQLException ;
	
	

	public <T> T insertBatch(String sql, ResultSetHandler<T> rsh,
			Object[][] params) throws SQLException;
	
	
	
	 public int[] batch(String sql, Object[][] params) throws SQLException;
}