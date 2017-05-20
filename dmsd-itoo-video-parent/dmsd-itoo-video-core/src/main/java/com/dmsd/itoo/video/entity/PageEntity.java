package com.dmsd.itoo.video.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

public class PageEntity<T>  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//**************************鍒嗛〉鍏叡************************************
	//椤电爜
	private int pageNum;
	//椤靛ぇ灏�
	private int pageSize;
	//璁板綍鏁�
	private Long total;
	//**************************鍗曞疄浣撳垎椤典繚瀛樺埌rows涓紝鍘熺敓sql璇彞鍒嗛〉鏌ヨ淇濆瓨鍦╨ist涓�************************************
	//椤甸泦鍚�
	private List<T> rows;
	//鏈�缁堟煡璇㈡潯浠�
	private String hql;
	//**************************澶氬疄浣撳垎椤典繚瀛樺埌Map涓紝閫氳繃灞炴�у彇鍊�************************************
	//鏌ヨ鍐呭
	private String selectContent;
	//鏌ヨ瀹炰綋
	private String selectFrom;
	//鏌ヨ鏉′欢
	private String selectWhere;
	//鏌ヨ鍒扮殑鍐呭
	private Map<Object, Object> map = new HashMap<Object, Object>();
	
	//鎺掑簭瀛楁
	private String selectOrderContent;
	//鍗囧簭闄嶅簭
	private String selectOrderType;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public String getHql() {
		return hql;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	public String getSelectContent() {
		return selectContent;
	}
	public void setSelectContent(String selectContent) {
		this.selectContent = selectContent;
	}
	public String getSelectFrom() {
		return selectFrom;
	}
	public void setSelectFrom(String selectFrom) {
		this.selectFrom = selectFrom;
	}
	public String getSelectWhere() {
		return selectWhere;
	}
	public void setSelectWhere(String selectWhere) {
		this.selectWhere = selectWhere;
	}
	public Map<Object, Object> getMap() {
		return map;
	}
	public void setMap(Map<Object, Object> map) {
		this.map = map;
	}
	public String getSelectOrderContent() {
		return selectOrderContent;
	}
	public void setSelectOrderContent(String selectOrderContent) {
		this.selectOrderContent = selectOrderContent;
	}
	public String getSelectOrderType() {
		return selectOrderType;
	}
	public void setSelectOrderType(String selectOrderType) {
		this.selectOrderType = selectOrderType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Transient
	private String dataBaseName;
	public String getDataBaseName() {
		return dataBaseName;
	}
	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}
	
}


