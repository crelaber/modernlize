package com.uwen.ur.model.dal.sys.ext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.sun.org.apache.commons.collections.CollectionUtils;
import com.uwen.ur.util.Page;

public interface SuppBusiQuery {
	
	//List<ViewSuppSearchExt> selectViewSuppSearchByExample(Params param);
	int countByExample(Params param);
	
	public static class Params {
		
		public Params(){
			
		}
		
		public Params(String lon, String lat, Double kmScope) {
			super();
			this.lon = lon;
			this.lat = lat;
			this.kmScope = kmScope;
		}

		private String lon;
		private String lat;
		private Double kmScope;
		private String typeId;
		private List typeIds;
		private String orderByClause;
		private String parAreaId;
		
		private Page page;
		
		public String getLon() {
			return lon;
		}

		public void setLon(String lon) {
			this.lon = lon;
		}

		public String getLat() {
			return lat;
		}

		public void setLat(String lat) {
			this.lat = lat;
		}

		public Double getKmScope() {
			return kmScope;
		}

		public void setKmScope(Double kmScope) {
			this.kmScope = kmScope;
		}

		public String getTypeId() {
			return typeId;
		}

		public void setTypeId(String typeId) {
			this.typeId = typeId;
			if(StringUtils.isNotEmpty(this.typeId)){
				String[] ids = this.typeId.split(",");
				if(ArrayUtils.isNotEmpty(ids)){
					this.typeIds = new ArrayList<String>();
					CollectionUtils.addAll(typeIds, ids);
				}
			}
		}

		public String getOrderByClause() {
			return orderByClause;
		}

		public void setOrderByClause(String orderByClause) {
			this.orderByClause = orderByClause;
		}

		public Page getPage() {
			return page;
		}

		public void setPage(Page page) {
			this.page = page;
		}

		public String getParAreaId() {
			return parAreaId;
		}

		public void setParAreaId(String parAreaId) {
			this.parAreaId = parAreaId;
		}

		public List getTypeIds() {
			return typeIds;
		}

		public void setTypeIds(List typeIds) {
			this.typeIds = typeIds;
		}

	}
}