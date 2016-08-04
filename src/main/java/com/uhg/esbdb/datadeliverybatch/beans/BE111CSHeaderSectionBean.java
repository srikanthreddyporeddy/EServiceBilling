package com.uhg.esbdb.datadeliverybatch.beans;

import java.sql.Timestamp;

public class BE111CSHeaderSectionBean {
	private String csHeaderRecordType;
	private String csHeaderCustId;
	private Timestamp csHeaderTimeDate;
	private String csHeaderDataTypeCD;
	private String csBusTransTypeCD;
	public String getCsHeaderRecordType() {
		return csHeaderRecordType;
	}
	public void setCsHeaderRecordType(String csHeaderRecordType) {
		this.csHeaderRecordType = csHeaderRecordType;
	}
	@Override
	public String toString() {
		return "BE111CSHeaderSectionBean [csHeaderRecordType=" + csHeaderRecordType + ", csHeaderCustId="
				+ csHeaderCustId + ", csHeaderTimeDate=" + csHeaderTimeDate + ", csHeaderDataTypeCD="
				+ csHeaderDataTypeCD + ", csBusTransTypeCD=" + csBusTransTypeCD + "]";
	}
	public String getCsHeaderCustId() {
		return csHeaderCustId;
	}
	public void setCsHeaderCustId(String csHeaderCustId) {
		this.csHeaderCustId = csHeaderCustId;
	}
	public Timestamp getCsHeaderTimeDate() {
		return csHeaderTimeDate;
	}
	public void setCsHeaderTimeDate(Timestamp csHeaderTimeDate) {
		this.csHeaderTimeDate = csHeaderTimeDate;
	}
	public String getCsHeaderDataTypeCD() {
		return csHeaderDataTypeCD;
	}
	public void setCsHeaderDataTypeCD(String csHeaderDataTypeCD) {
		this.csHeaderDataTypeCD = csHeaderDataTypeCD;
	}
	public String getCsBusTransTypeCD() {
		return csBusTransTypeCD;
	}
	public void setCsBusTransTypeCD(String csBusTransTypeCD) {
		this.csBusTransTypeCD = csBusTransTypeCD;
	}

}
