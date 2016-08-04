package com.uhg.esbdb.datadeliverybatch.beans;

public class BE111CSDiscountSectionBean {
private BE111CSDiscountBean be111CSDiscountBean;
	
	private String csDiscPolNbr;	
	private String csDiscBilgrpId;	
	private String csDiscPlanNumber;
	public BE111CSDiscountBean getBe111CSDiscountBean() {
		return be111CSDiscountBean;
	}
	public void setBe111CSDiscountBean(BE111CSDiscountBean be111csDiscountBean) {
		be111CSDiscountBean = be111csDiscountBean;
	}
	public String getCsDiscPolNbr() {
		return csDiscPolNbr;
	}
	public void setCsDiscPolNbr(String csDiscPolNbr) {
		this.csDiscPolNbr = csDiscPolNbr;
	}
	public String getCsDiscBilgrpId() {
		return csDiscBilgrpId;
	}
	public void setCsDiscBilgrpId(String csDiscBilgrpId) {
		this.csDiscBilgrpId = csDiscBilgrpId;
	}
	public String getCsDiscPlanNumber() {
		return csDiscPlanNumber;
	}
	public void setCsDiscPlanNumber(String csDiscPlanNumber) {
		this.csDiscPlanNumber = csDiscPlanNumber;
	}


}
