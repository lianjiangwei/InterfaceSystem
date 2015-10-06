/**     
 * @FileName: BaseServiceImpl.java   
 * @Package:com.tgb.interfaceSystem.Base   
 * @Description: TODO  
 * @author: LUCKY    
 * @date:2015年9月28日 下午2:18:34   
 * @version V1.0     
 */
package com.tgb.interfaceSystem.Base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.tgb.interfaceSystem.action.bean.QueryResult;

/**  
 * @ClassName: BaseServiceImpl   
 * @Description: TODO  
 * @author: LUCKY  
 * @date:2015年9月28日 下午2:18:34     
 */


public class BaseServiceImpl<T> implements BaseService<T>{

	
	@Resource
	public BaseDao<T> baseDao;
	
	

	// -------------------------------------------添加方法--------------------------------------------------------------------------------

	/* 根据集合来添加或者更新方法，如果实体处于persient状态的话，则是更新操作
	 * 如果是transient状态的话，测试添加操作
	 * @param list   要添加的实体集合
	 */  
	public void saveOrUpdateAll(List list) {
		baseDao.saveOrUpdateAll(list);
		
	}

	
	/* 保存实体方法
	 * @param t  要保存的实体
	 * @return   保存后的实体
	 */  
	public T saveEntity(T t) {
		baseDao.saveEntity(t);
		return t;

	}

	
	
	
	

	/*  批量添加对象实体，如果实体库中没有的话，调用的是添加方法 库中有的话，会自动调用更新方法
	 * @param t   要添加的实体对象
	 */  
	public void saveOrUpdateObject(T t) {
		baseDao.saveOrUpdateObject(t);

	}

	
	
	
	// -------------------------------------------更新方法--------------------------------------------------------------------------------

	
	/* 更新实体方法
	 * @param t   要更新的实体  
	 */  
	public void update(T t)  {
		baseDao.update(t);
	}

	
	public void merge(T t) {
		baseDao.merge(t);

	}

	// -------------------------------------------删除方法--------------------------------------------------------------------------------
	
	
	/* 删除实体方法  
	 * @param t   要删除的实体
	 */  
	public void delete(T t) {
		baseDao.delete(t);
	}

	
	
	/* 根据实体id进行删除实体 
	 * @param id   实体id
	 */  
	public void deleteById(Serializable id)  {
		baseDao.deleteById(id);
	}

	// -------------------------------------------查询方法--------------------------------------------------------------------------------

	
	
	/*根据实体类型和实体ID来查询实体操作
	 * @param entityClass  实体的class类型
	 * @param id  实体的id
	 * @return   要查询的实体
	 */  
	public T get(Class<T> entityClass, Serializable id) {

		return baseDao.get(entityClass, id);
	}
	
	
	


	

	/*
	 * @param clazz 实体的class类型
	 * @return 查询某个实体类的库中的所有信息
	 */
	public List<T> getObjects(Class clazz) {

		return baseDao.getObjects(clazz);

	}

	
	
	

	
	
	

	

	



	
	
	
	
	
	
	
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
    @SuppressWarnings("unchecked")
    public QueryResult hqlQueryPage(final String hql,
            final QueryResult queryResult, final Map values) {
        return baseDao.hqlQueryPage(hql, queryResult, values);
            
    }
 
    
    
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
    public Long getAllCount(final String hql, final Map values) {
       return baseDao.getAllCount(hql, values);
    }
	
	


	/* 根据Hql语句，进行查询相应的实体
	 * @param hql  hql语句
	 * @param param  hql语句中的参数
	 * @return   
	 */  
	public List findHql(final String hql, final Map<String, Object> param) {
		return baseDao.findHql(hql, param);
	}


	/*
	 * @param obj 对象实体
	 * 
	 * @return 根据对象获取某个类的所有对象
	 */
	public List getObjectsByExample(T obj) {
		return baseDao.getObjectsByExample(obj);
	}

}
