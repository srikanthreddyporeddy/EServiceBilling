package com.uhg.esbdb.datadeliverybatch.business;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.uhg.esbdb.common.exception.EDBException;
import com.uhg.esbdb.common.util.FileIOOperationsUtil;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CSAddressSectionBean;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CSCustomerSectionBean;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CSDiscountSectionBean;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CSHeaderSectionBean;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CSPolicySectionBean;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CaseStructureRecordBean;
import com.uhg.esbdb.datadeliverybatch.validation.BE111PrimeCaseStructureValidation;

import com.uhg.esbdb.common.constants.EDDCommonConstants;

public class BE111PrimeCaseStructureProcessor {
	private static List<BE111CaseStructureRecordBean> be111CaseStructureRecordBeans= new ArrayList<>();
	
	public static BE111CaseStructureRecordBean be111CaseStructureRecordBean=null;
	public static BE111CSHeaderSectionBean be111CSHeaderSectionBean =null;
	public static BE111CSCustomerSectionBean be111CSCustomerSectionBean =null;
	public static BE111CSAddressSectionBean be111csAddressSectionBean =null;
	public static BE111CSPolicySectionBean be111csPolicySectionBean =null;
	public static BE111CSDiscountSectionBean be111csDiscountSectionBean =null;
	
	static{
		 be111CaseStructureRecordBean=new BE111CaseStructureRecordBean();
		 be111CSHeaderSectionBean =new BE111CSHeaderSectionBean();
		 be111CSCustomerSectionBean =new BE111CSCustomerSectionBean();
		 be111csAddressSectionBean =new BE111CSAddressSectionBean();
		 be111csPolicySectionBean =new BE111CSPolicySectionBean();
		 be111csDiscountSectionBean =new BE111CSDiscountSectionBean();
		}
	
	public static List<BE111CaseStructureRecordBean> processPrimeMessageData() throws EDBException, IOException, ParseException{
		be111CaseStructureRecordBean=new BE111CaseStructureRecordBean();
		
		String primeMessageData=FileIOOperationsUtil.readFileFromInboundDir();
		
		System.out.println(EDDCommonConstants.CHECK_RECORD_TYPE);
		if(BE111PrimeCaseStructureValidation.checkPrimeMessageRecordType(primeMessageData)){
			System.out.println(EDDCommonConstants.VALID_RECORD);
			
			System.out.println(EDDCommonConstants.MOVE_VALID_FILE_TO_PROCESSED_DIR);
			
			FileIOOperationsUtil.moveFileToProcessedDirectory();
			
		}else{
			throw new EDBException(EDDCommonConstants.INVALID_REDORD);
		}
		
		BE111PrimeCaseStructureValidation.validatingHeaderSection(primeMessageData, be111CSHeaderSectionBean);
		
		System.out.println(EDDCommonConstants.VALIDATION_MSG);
		
		String csHeaderRecordType=primeMessageData.substring(0, 1);
	
		if(csHeaderRecordType.equals("1")){
			be111CaseStructureRecordBeans.add(BE111PrimeCaseStructureValidation.validatingCustomerSection(primeMessageData,be111CSCustomerSectionBean));
			be111CaseStructureRecordBeans.add(BE111PrimeCaseStructureValidation.validatingAddressSection(primeMessageData, be111csAddressSectionBean));
			be111CaseStructureRecordBeans.add(BE111PrimeCaseStructureValidation.validatingPolicySection(primeMessageData, be111csPolicySectionBean));
			
		}
		if(csHeaderRecordType.equals("2")){
			be111CaseStructureRecordBeans.add(BE111PrimeCaseStructureValidation.validatingCustomerSection(primeMessageData,be111CSCustomerSectionBean));
			be111CaseStructureRecordBeans.add(BE111PrimeCaseStructureValidation.validatingAddressSection(primeMessageData, be111csAddressSectionBean));
			
		}
		if(csHeaderRecordType.equals("3")){
			be111CaseStructureRecordBeans.add(BE111PrimeCaseStructureValidation.validatingCustomerSection(primeMessageData,be111CSCustomerSectionBean));
			be111CaseStructureRecordBeans.add(BE111PrimeCaseStructureValidation.validatingPolicySection(primeMessageData, be111csPolicySectionBean));
			
		}
		if(csHeaderRecordType.equals("4")){
			be111CaseStructureRecordBeans.add(BE111PrimeCaseStructureValidation.validatingCustomerSection(primeMessageData,be111CSCustomerSectionBean));
			
		}
		if(csHeaderRecordType.equals("5")){
			be111CaseStructureRecordBeans.add(BE111PrimeCaseStructureValidation.validatingAddressSection(primeMessageData, be111csAddressSectionBean));
			be111CaseStructureRecordBeans.add(BE111PrimeCaseStructureValidation.validatingPolicySection(primeMessageData, be111csPolicySectionBean));
			
		}
		if(csHeaderRecordType.equals("6")){
			be111CaseStructureRecordBeans.add(BE111PrimeCaseStructureValidation.validatingAddressSection(primeMessageData, be111csAddressSectionBean));
			
		}
		if(csHeaderRecordType.equals("7")){
			be111CaseStructureRecordBeans.add(BE111PrimeCaseStructureValidation.validatingPolicySection(primeMessageData, be111csPolicySectionBean));
			
		}
		
		return be111CaseStructureRecordBeans;
		
	}

}
