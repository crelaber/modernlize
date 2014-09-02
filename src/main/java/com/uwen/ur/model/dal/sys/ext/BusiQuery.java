package com.uwen.ur.model.dal.sys.ext;

import java.util.List;

public interface BusiQuery {
	//List<ViewAreaSuppCount> selectByExample(AreaParam param);

	public static class AreaParam {
		
		public AreaParam(){}
		
		public AreaParam(String skeyword, String typeId, String areaPid) {
			super();
			this.skeyword = skeyword;
			this.typeId = typeId;
			this.areaPid = areaPid;
		}

		public AreaParam(String skeyword, List<String> typeIds, String areaPid) {
			super();
			this.skeyword = skeyword;
			this.typeIds = typeIds;
			this.areaPid = areaPid;
		}

		private String skeyword;
		private String typeId;
		private List<String> typeIds;
		private String areaPid;

		public String getSkeyword() {
			return skeyword;
		}

		public void setSkeyword(String skeyword) {
			this.skeyword = skeyword;
		}

		public String getTypeId() {
			return typeId;
		}

		public void setTypeId(String typeId) {
			this.typeId = typeId;
		}

		public List<String> getTypeIds() {
			return typeIds;
		}

		public void setTypeIds(List<String> typeIds) {
			this.typeIds = typeIds;
		}

		public String getAreaPid() {
			return areaPid;
		}

		public void setAreaPid(String areaPid) {
			this.areaPid = areaPid;
		}
	}
}