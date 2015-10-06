package com.tgb.interfaceSystem.Base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.aspectj.org.eclipse.jdt.core.dom.ThisExpression;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tgb.interfaceSystem.action.bean.QueryResult;
import com.tgb.interfaceSystem.util.TUtils;

/**
 * @ClassName: BaseDaoImpl
 * @Description: 公共底层方法的实现类
 * @author: LUCKY
 * @date:2015年9月26日 下午1:25:29
 * @param <T>
 */

public abstract class BaseHibernateDaoImpl<T> extends HibernateDaoSupport
		implements BaseDao<T> {

	protected  QueryRunner runner;
	public DataSource dataSource;
	public Connection connection;

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) throws Exception {

		dataSource=getDataSource(sessionFacotry);
		connection = dataSource.getConnection();
		runner=new QueryRunner(dataSource); 
		super.setSessionFactory(sessionFacotry);
	}

	// 获得JDBC的数据库连接操作
//	public Connection connection;
 
	private Class<T> clazz;

	// 用来获得Connection的连接操作
	public abstract  DataSource getDataSource(SessionFactory sessionFactory) throws Exception;

	// 构造函数，用来实例化泛型T
	public BaseHibernateDaoImpl(){
	
		this.clazz = TUtils.getGenericSuperclass(this.getClass());
		// 通过构造函数调用子类的方法，来为connection进行赋值的操作
//		try {
//			
//		
////			getHibernateTemplate().getSessionFactory().openSession().doWork(new Work() {
////				
////			    
////				public void execute(Connection connection) throws SQLException {
////				
////				 this.connection=connection;
////				}
////			});
//					  
//		
//			
////			dataSource=getDataSource();
////			connection=	dataSource.getConnection("root", "123456");
//			
//		} catch (Exception e1) {
//		
//			System.out.println(e1.getMessage());
//			e1.printStackTrace();
//		}finally{
//		
//		}
		
		
		
	}

	// -------------------------------------------添加方法--------------------------------------------------------------------------------

	/*
	 * 根据集合来添加或者更新方法，如果实体处于persient状态的话，则是更新操作 如果是transient状态的话，测试添加操作
	 * 
	 * @param list 要添加的实体集合
	 */
	public void saveOrUpdateAll(List list) {
		getHibernateTemplate().saveOrUpdateAll(list);
	}

	/*
	 * 保存实体方法
	 * 
	 * @param t 要保存的实体
	 * 
	 * @return 保存后的实体
	 */
	public T saveEntity(T t) {
		getHibernateTemplate().save(t);
		return t;

	}

	/*
	 * 批量添加对象实体，如果实体库中没有的话，调用的是添加方法 库中有的话，会自动调用更新方法
	 * 
	 * @param t 要添加的实体对象
	 */
	public void saveOrUpdateObject(T t) {

		getHibernateTemplate().saveOrUpdate(t);

	}

	// -------------------------------------------更新方法--------------------------------------------------------------------------------

	/*
	 * 更新实体方法
	 * 
	 * @param t 要更新的实体
	 */
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	public void merge(T t) {
		getHibernateTemplate().merge(t);

	}

	// -------------------------------------------删除方法--------------------------------------------------------------------------------

	/*
	 * 删除实体方法
	 * 
	 * @param t 要删除的实体
	 */
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	/*
	 * 根据实体id进行删除实体
	 * 
	 * @param id 实体id
	 */
	public void deleteById(Serializable id) {
		T objecT = this.get(getEntityClass(), id);
		if (objecT != null) {
			delete(objecT);
		}
	}

	// -------------------------------------------查询方法--------------------------------------------------------------------------------

	/*
	 * 根据实体类型和实体ID来查询实体操作
	 * 
	 * @param entityClass 实体的class类型
	 * 
	 * @param id 实体的id
	 * 
	 * @return 要查询的实体
	 */
	public T get(Class<T> entityClass, Serializable id) {

		return getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * @Title: getEntityClass
	 * @Description: 得到泛型中的实体类型
	 * @param @return
	 * @return Class<T>
	 * @throws
	 */
	public Class<T> getEntityClass() {
		Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return entityClass;
	}

	/*
	 * @param clazz 实体的class类型
	 * 
	 * @return 查询某个实体类的库中的所有信息
	 */
	public List<T> getObjects(Class clazz) {

		return getHibernateTemplate().loadAll(clazz);

	}

	/**
	 * @Author: Charles
	 * @Description: 获取表主键类型
	 * @param clazz
	 * @return Type:
	 */
	public Type getPkType() {
		ClassMetadata meta = getHibernateTemplate().getSessionFactory()
				.getClassMetadata(getEntityClass());
		return meta.getIdentifierType();
	}

	/**
	 * 获取主键名
	 */
	public String getPkColunmName() {
		ClassMetadata meta = getHibernateTemplate().getSessionFactory()
				.getClassMetadata(getEntityClass());
		return meta.getIdentifierPropertyName();
	}

	/**
	 * 获取实体类型名
	 * 
	 */
	public String getEntityClassName() {
		ClassMetadata meta = getHibernateTemplate().getSessionFactory()
				.getClassMetadata(getEntityClass());
		return meta.getEntityName();
	}

	/*
	 * @param obj 对象实体
	 * 
	 * @return 根据对象获取某个类的所有对象
	 */
	public List getObjectsByExample(T obj) {

		return getHibernateTemplate().findByExample(obj);

	}

	// 分页查询开始

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
		return getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public QueryResult doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery(hql)
						.setFirstResult(
								(queryResult.getCurrentPage().intValue() - 1)
										* queryResult.getPageSize().intValue())
						.setMaxResults(queryResult.getPageSize().intValue());

				Set keys = values.keySet();
				for (Object o : keys) {
					query.setParameter((String) o, values.get(o));
				}
				queryResult.setResultList(query.list());
				String countHql = "select count(*) " + hql; // 封装查询总记录条数
				Long allCount = getAllCount(countHql, values); // 总记录条数
				queryResult.setAllCount(allCount);
				queryResult.calcuatePage(); // 计算总页数
				return queryResult;
			}
		});
	}

	/**
	 * hql查询得到总查询数目
	 * 
	 * @param hql
	 *            查询字符串
	 * @param values
	 *            查询值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Long getAllCount(final String hql, final Map values) {
		return getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				Set keys = values.keySet();
				for (Object o : keys) {
					query.setParameter((String) o, values.get(o));
				}
				return query.uniqueResult();
			}
		});
	}

	/*
	 * 根据Hql语句，进行查询相应的实体
	 * 
	 * @param hql hql语句
	 * 
	 * @param param hql语句中的参数
	 * 
	 * @return
	 */
	public List findHql(final String hql, final Map<String, Object> param) {
		return getHibernateTemplate().execute(new HibernateCallback<List>() {
			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				if (param != null && param.size() > 0) {
					for (String property : param.keySet()) {
						query.setParameter(property, param.get(property));
					}
				}
				return query.list();
			}
		});
	}

}
