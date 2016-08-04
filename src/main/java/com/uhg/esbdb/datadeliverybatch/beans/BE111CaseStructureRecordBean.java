package com.uhg.esbdb.datadeliverybatch.beans;

public class BE111CaseStructureRecordBean {
	private BE111CSHeaderSectionBean be111CSHeaderSectionBean;
	private BE111CSCustomerSectionBean be111CSCustomerSectionBean;
	private BE111CSAddressSectionBean be111CSAddressSectionBean;
	private BE111CSPolicySectionBean be111CSPolicySectionBean;
	
	public BE111CSHeaderSectionBean getBe111CSHeaderSectionBean() {
		return be111CSHeaderSectionBean;
	}
	public void setBe111CSHeaderSectionBean(BE111CSHeaderSectionBean be111csHeaderSectionBean) {
		be111CSHeaderSectionBean = be111csHeaderSectionBean;
	}
	public BE111CSCustomerSectionBean getBe111CSCustomerSectionBean() {
		return be111CSCustomerSectionBean;
	}
	public void setBe111CSCustomerSectionBean(BE111CSCustomerSectionBean be111csCustomerSectionBean) {
		be111CSCustomerSectionBean = be111csCustomerSectionBean;
	}
	public BE111CSAddressSectionBean getBe111CSAddressSectionBean() {
		return be111CSAddressSectionBean;
	}
	public void setBe111CSAddressSectionBean(BE111CSAddressSectionBean be111csAddressSectionBean) {
		be111CSAddressSectionBean = be111csAddressSectionBean;
	}
	public BE111CSPolicySectionBean getBe111CSPolicySectionBean() {
		return be111CSPolicySectionBean;
	}
	public void setBe111CSPolicySectionBean(BE111CSPolicySectionBean be111csPolicySectionBean) {
		be111CSPolicySectionBean = be111csPolicySectionBean;
	}
	
	@Override
	public String toString() {
		return "BE111CaseStructureRecordBean [be111CSHeaderSectionBean=" + be111CSHeaderSectionBean
				+ ", be111CSCustomerSectionBean=" + be111CSCustomerSectionBean + ", be111CSAddressSectionBean="
				+ be111CSAddressSectionBean + ", be111CSPolicySectionBean=" + be111CSPolicySectionBean + "]";
	}
	
	
}
