package com.uhg.esbdb.datadeliverybatch.beans;

import java.sql.Timestamp;

public class BE111CSDiscountBean {
	private Timestamp csDiscPkgsvStartDt; 
	private Timestamp csDiscPkgsvEndDt;
	private String csDiscPkgSvngCD;
	public Timestamp getCsDiscPkgsvStartDt() {
		return csDiscPkgsvStartDt;
	}
	public void setCsDiscPkgsvStartDt(Timestamp csDiscPkgsvStartDt) {
		this.csDiscPkgsvStartDt = csDiscPkgsvStartDt;
	}
	public Timestamp getCsDiscPkgsvEndDt() {
		return csDiscPkgsvEndDt;
	}
	public void setCsDiscPkgsvEndDt(Timestamp csDiscPkgsvEndDt) {
		this.csDiscPkgsvEndDt = csDiscPkgsvEndDt;
	}
	public String getCsDiscPkgSvngCD() {
		return csDiscPkgSvngCD;
	}
	public void setCsDiscPkgSvngCD(String csDiscPkgSvngCD) {
		this.csDiscPkgSvngCD = csDiscPkgSvngCD;
	}


}
