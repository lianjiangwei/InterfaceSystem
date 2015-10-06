/**     
 * @FileName: QueryResult.java   
 * @Package:com.tgb.interfaceSystem.util   
 * @Description: TODO  
 * @author: LUCKY    
 * @date:2015年9月28日 上午10:42:33   
 * @version V1.0     
 */
package com.tgb.interfaceSystem.action.bean;

import java.util.List;

/**  
 * @ClassName: QueryResult   
 * @Description: TODO  
 * @author: LUCKY  
 * @date:2015年9月28日 上午10:42:33     
 */
public class QueryResult implements java.io.Serializable {
	 
    private static final long serialVersionUID = 1L;
    private Long allCount;      //总记录条数
    public Long getAllCount() {
		return allCount;
	}

	public void setAllCount(Long allCount) {
		this.allCount = allCount;
	}

	public Long getAllPage() {
		return allPage;
	}

	public void setAllPage(Long allPage) {
		this.allPage = allPage;
	}

	public Long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private Long allPage;       //总页数
    private Long currentPage;   //当前页数
    private Long pageSize;      //一页包含的记录条数
    private List<?> resultList;   //查询结果集
 
    public QueryResult() {
        this.currentPage = 1l;
        this.pageSize = 10l; // 默认每页显示10条记录
    }
     
    //计算总页数
    public void calcuatePage() {
        if (allCount > 0) {
            allPage = allCount % pageSize == 0 ? allCount / pageSize
                    : (allCount / pageSize + 1);
        }
    }
}