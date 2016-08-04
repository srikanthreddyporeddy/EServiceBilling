package com.uhg.esbdb.datadeliverybatch.validation;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import com.uhg.esbdb.common.exception.EDBException;
import com.uhg.esbdb.common.util.DateFormatterUtil;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CSAddressSectionBean;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CSCustomerSectionBean;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CSDiscountSectionBean;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CSHeaderSectionBean;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CSPolicySectionBean;
import com.uhg.esbdb.datadeliverybatch.beans.BE111CaseStructureRecordBean;
import com.uhg.esbdb.common.constants.EDDCommonConstants;

public class BE111PrimeCaseStructureValidation {
	
	static BE111CaseStructureRecordBean be111CaseStructureRecordBean = new BE111CaseStructureRecordBean();
	static ArrayList<BE111CaseStructureRecordBean> be111CaseStructureRecordBeans = new ArrayList<BE111CaseStructureRecordBean>();

	public static boolean checkPrimeMessageRecordType(String primeMessage) {

		String recordType = primeMessage.substring(0, 1);
		if (recordType.equals("1") || recordType.equals("2") || recordType.equals("3") || recordType.equals("4")
				|| recordType.equals("5") || recordType.equals("6") || recordType.equals("7")
				|| recordType.equals("8")) {
			return true;
		} else {
			return false;
		}
	}

	public static BE111CaseStructureRecordBean validatingHeaderSection(String primeMessage,
			BE111CSHeaderSectionBean be111csHeaderSectionBean) throws EDBException {
		ArrayList<Object> al;
		String csHeaderRecordType = primeMessage.substring(0, 1);
		csHeaderRecordType = csHeaderRecordType.trim();
		be111csHeaderSectionBean.setCsHeaderRecordType(csHeaderRecordType);
		String csHeaderCustId = primeMessage.substring(1, 8);
		if (!csHeaderCustId.equals(EDDCommonConstants.SEVEN_BYTES_SPACE)) {
			be111csHeaderSectionBean.setCsHeaderCustId(csHeaderCustId);
		} else {
			throw new EDBException("Invalid input customer ID");
		}

		String csHeaderTimeDate = primeMessage.substring(8, 22);
		al = DateFormatterUtil.convertStringToTimeStamp(csHeaderTimeDate);
		if (al.get(1).equals(EDDCommonConstants.TRUE_STATUS)) {
			be111csHeaderSectionBean.setCsHeaderTimeDate((Timestamp) al.get(0));
		}

		String csHeaderDataTypeCD = primeMessage.substring(22, 23);
		csHeaderDataTypeCD = csHeaderDataTypeCD.trim();
		be111csHeaderSectionBean.setCsHeaderDataTypeCD(csHeaderDataTypeCD);

		String csBusTransTypeCD = primeMessage.substring(23, 25);
		csBusTransTypeCD = csBusTransTypeCD.trim();
		be111csHeaderSectionBean.setCsBusTransTypeCD(csBusTransTypeCD);

		be111CaseStructureRecordBean.setBe111CSHeaderSectionBean(be111csHeaderSectionBean);
		return be111CaseStructureRecordBean;
	}

	public static BE111CaseStructureRecordBean validatingCustomerSection(String primeMessage,
			BE111CSCustomerSectionBean be111csCustomerSectionBean) throws EDBException {

		String csCustAbbrName = primeMessage.substring(25, 64);
		csCustAbbrName = csCustAbbrName.trim();
		be111csCustomerSectionBean.setCsCustAbbrName(csCustAbbrName);

		String csCustTin = primeMessage.substring(64, 73);
		csCustTin = csCustTin.trim();
		be111csCustomerSectionBean.setCsCustTin(csCustTin);

		String csCustSmallGrpInd = primeMessage.substring(73, 75);
		csCustSmallGrpInd = csCustSmallGrpInd.trim();
		be111csCustomerSectionBean.setCsCustSmallGrpInd(csCustSmallGrpInd);

		String csCustSic = primeMessage.substring(75, 79);
		csCustSic = csCustSic.trim();
		be111csCustomerSectionBean.setCsCustSic(csCustSic);

		String csCustCosmosDiv = primeMessage.substring(79, 82);
		csCustCosmosDiv = csCustCosmosDiv.trim();
		be111csCustomerSectionBean.setCsCustCosmosDiv(csCustCosmosDiv);

		String csCustCosmosMstGrp = primeMessage.substring(82, 88);
		csCustCosmosMstGrp = csCustCosmosMstGrp.trim();
		be111csCustomerSectionBean.setCsCustCosmosMstGrp(csCustCosmosMstGrp);

		String csCustSchRuleNbr = primeMessage.substring(88, 91);
		csCustSchRuleNbr = csCustSchRuleNbr.trim();
		be111csCustomerSectionBean.setCsCustSchRuleNbr(csCustSchRuleNbr);

		String csCustInvHold = primeMessage.substring(91, 92);
		csCustInvHold = csCustInvHold.trim();
		be111csCustomerSectionBean.setCsCustInvHold(csCustInvHold);

		String csCustNewBiz = primeMessage.substring(92, 93);
		csCustNewBiz = csCustNewBiz.trim();
		be111csCustomerSectionBean.setCsCustNewBiz(csCustNewBiz);

		String csCustFranCode = primeMessage.substring(93, 100);
		csCustFranCode = csCustFranCode.trim();
		be111csCustomerSectionBean.setCsCustFranCode(csCustFranCode);

		String csOffFirstValue = primeMessage.substring(100, 102);
		csOffFirstValue = csOffFirstValue.trim();
		be111csCustomerSectionBean.setCsOffFirstValue(csOffFirstValue);

		String csCustHlthPrevCarrCd = primeMessage.substring(102, 105);
		csCustHlthPrevCarrCd = csCustHlthPrevCarrCd.trim();
		be111csCustomerSectionBean.setCsCustHlthPrevCarrCD(csCustHlthPrevCarrCd);

		String csCustPrevHlthCarrNm = primeMessage.substring(105, 144);
		csCustPrevHlthCarrNm = csCustPrevHlthCarrNm.trim();
		be111csCustomerSectionBean.setCsCustPrevHlthCarrNM(csCustPrevHlthCarrNm);

		be111CaseStructureRecordBean.setBe111CSCustomerSectionBean(be111csCustomerSectionBean);
		return be111CaseStructureRecordBean;

	}

	public static BE111CaseStructureRecordBean validatingAddressSection(String primeMessage,
			BE111CSAddressSectionBean be111csAddressSectionBean) throws EDBException {

		ArrayList<Object> al;

		String csAddrEffDate = primeMessage.substring(144, 152);
		if(csAddrEffDate.equals(EDDCommonConstants.EIGHT_BYTES_SPACE)){
			csAddrEffDate=null;
		}else{
			csAddrEffDate = csAddrEffDate.length() == 8 ? csAddrEffDate + "000000" : csAddrEffDate;
			al = DateFormatterUtil.convertStringToTimeStamp(csAddrEffDate);
			if (al.get(1).equals(EDDCommonConstants.TRUE_STATUS)) {
				be111csAddressSectionBean.setCsAddrEffDate((Timestamp) al.get(0));
			} else {
				throw new EDBException("Invalid Address Effective Date field.");
			}
		}
		
		String csAddrCntrctHldr = primeMessage.substring(152, 191);
		csAddrCntrctHldr = csAddrCntrctHldr.trim();
		be111csAddressSectionBean.setCsAddrCntrctHldr(csAddrCntrctHldr);

		String csAddrAddress1Txt = primeMessage.substring(191, 237);
		csAddrAddress1Txt = csAddrAddress1Txt.trim();
		be111csAddressSectionBean.setCsAddrAddress1Txt(csAddrAddress1Txt);

		String csAddrAddress2Txt = primeMessage.substring(237, 283);
		csAddrAddress2Txt = csAddrAddress2Txt.trim();
		be111csAddressSectionBean.setCsAddrAddress2Txt(csAddrAddress2Txt);

		String csAddrCity = primeMessage.substring(283, 309);
		csAddrCity = csAddrCity.trim();
		be111csAddressSectionBean.setCsAddrCity(csAddrCity);

		String csAddrState = primeMessage.substring(309, 311);
		csAddrState = csAddrState.trim();
		be111csAddressSectionBean.setCsAddrState(csAddrState);

		String csAddrZip = primeMessage.substring(311, 320);
		csAddrZip = csAddrZip.trim();
		be111csAddressSectionBean.setCsAddrZip(csAddrZip);

		String csAddrCountry = primeMessage.substring(320, 323);
		csAddrCountry = csAddrCountry.trim();
		be111csAddressSectionBean.setCsAddrCountry(csAddrCountry);

		String csAddrPhone = primeMessage.substring(323, 333);
		csAddrPhone = csAddrPhone.trim();
		be111csAddressSectionBean.setCsAddrPhone(csAddrPhone);

		String csAddrAttnName = primeMessage.substring(333, 373);
		csAddrAttnName = csAddrAttnName.trim();
		be111csAddressSectionBean.setCsAddrAttnName(csAddrAttnName);

		String csAddrPresMethod = primeMessage.substring(373, 374);
		csAddrPresMethod = csAddrPresMethod.trim();
		if (!csAddrPresMethod.equals("P") || csAddrPresMethod.equals("E")) {
			be111csAddressSectionBean.setCsAddrPresMethod(csAddrPresMethod);
		} else {
			throw new EDBException("Invalid Presentment Method field.");
		}

		String csAddrBankNbr = primeMessage.substring(374, 391);
		csAddrBankNbr = csAddrBankNbr.trim();
		be111csAddressSectionBean.setCsAddrBankNbr(csAddrBankNbr);

		String csAddrDfiId = primeMessage.substring(391, 403);
		csAddrDfiId = csAddrDfiId.trim();
		be111csAddressSectionBean.setCsAddrDfiId(csAddrDfiId);

		String csAddrAcctType = primeMessage.substring(403, 404);
		csAddrAcctType = csAddrAcctType.trim();
		be111csAddressSectionBean.setCsAddrAcctType(csAddrAcctType);

		String csAddrBilltoName = primeMessage.substring(404, 443);
		csAddrBilltoName = csAddrBilltoName.trim();
		be111csAddressSectionBean.setCsAddrBilltoName(csAddrBilltoName);

		String csAddrBilltoAddTxt1 = primeMessage.substring(443, 489);
		csAddrBilltoAddTxt1 = csAddrBilltoAddTxt1.trim();
		be111csAddressSectionBean.setCsAddrBilltoAddTxt1(csAddrBilltoAddTxt1);

		String csAddrBilltoAddTxt2 = primeMessage.substring(489, 535);
		csAddrBilltoAddTxt2 = csAddrBilltoAddTxt2.trim();
		be111csAddressSectionBean.setCsAddrBilltoAddTxt2(csAddrBilltoAddTxt2);

		String csAddrBilltoCity = primeMessage.substring(535, 561);
		csAddrBilltoCity = csAddrBilltoCity.trim();
		be111csAddressSectionBean.setCsAddrBilltoCity(csAddrBilltoCity);

		String csAddrBilltoState = primeMessage.substring(561, 563);
		csAddrBilltoState = csAddrBilltoState.trim();
		be111csAddressSectionBean.setCsAddrBilltoState(csAddrBilltoState);

		String csAddrBilltoZip = primeMessage.substring(563, 572);
		csAddrBilltoZip = csAddrBilltoZip.trim();
		be111csAddressSectionBean.setCsAddrBilltoZip(csAddrBilltoZip);

		String csAddrBilltoCountry = primeMessage.substring(572, 575);
		csAddrBilltoCountry = csAddrBilltoCountry.trim();
		be111csAddressSectionBean.setCsAddrBilltoCountry(csAddrBilltoCountry);

		String csAddrBilltoPhone = primeMessage.substring(575, 585);
		csAddrBilltoPhone = csAddrBilltoPhone.trim();
		be111csAddressSectionBean.setCsAddrBilltoPhone(csAddrBilltoPhone);

		String csAddrBilltoAttnName = primeMessage.substring(585, 625);
		csAddrBilltoAttnName = csAddrBilltoAttnName.trim();
		be111csAddressSectionBean.setCsAddrBilltoAttnName(csAddrBilltoAttnName);

		String csAddrChBilAddrSameInd = primeMessage.substring(625, 626);
		csAddrChBilAddrSameInd = csAddrChBilAddrSameInd.trim();
		be111csAddressSectionBean.setCsAddrChBilAddrSameInd(csAddrChBilAddrSameInd);

		be111CaseStructureRecordBean.setBe111CSAddressSectionBean(be111csAddressSectionBean);
		return be111CaseStructureRecordBean;
	}

	public static BE111CaseStructureRecordBean validatingPolicySection(String primeMessage,
			BE111CSPolicySectionBean be111csPolicySectionBean) throws EDBException {

		ArrayList<Object> al;

		String csPolEffDate = primeMessage.substring(626, 634);
		if(csPolEffDate.equals(EDDCommonConstants.EIGHT_BYTES_SPACE)){
			csPolEffDate=null;
		}else{
		csPolEffDate = csPolEffDate.length() == 8 ? csPolEffDate + "000000" : csPolEffDate;
		al = DateFormatterUtil.convertStringToTimeStamp(csPolEffDate);
		if (al.get(1).equals(EDDCommonConstants.TRUE_STATUS)) {
			be111csPolicySectionBean.setCsPolEffDate((Timestamp) al.get(0));
		} else {
			throw new EDBException("Invalid Policy Effective Date");
		}
		}

		String csPolBillTypeCd = primeMessage.substring(634, 635);
		csPolBillTypeCd = csPolBillTypeCd.trim();
		if (!csPolBillTypeCd.equals("Y") || csPolBillTypeCd.equals("N")) {
			be111csPolicySectionBean.setCsPolBillTypeCD(csPolBillTypeCd);
		} else {
			throw new EDBException("Invalid Policy Bill Type code");
		}

		String csPolPolNbr = primeMessage.substring(635, 642);
		csPolPolNbr = csPolPolNbr.trim();
		be111csPolicySectionBean.setCsPolPolNbr(csPolPolNbr);

		String csPolOiCd = primeMessage.substring(642, 644);
		csPolOiCd = csPolOiCd.trim();
		if (!csPolOiCd.equals(EDDCommonConstants.TWO_BYTES_SPACE)) {
			be111csPolicySectionBean.setCsPolOiCD(csPolOiCd);
		} else {
			throw new EDBException("Invalid Obligor ID");
		}

		String csPolSaCd = primeMessage.substring(644, 646);
		csPolSaCd = csPolSaCd.trim();
		if (!csPolSaCd.equals(EDDCommonConstants.TWO_BYTES_SPACE)) {
			be111csPolicySectionBean.setCsPolSaCD(csPolSaCd);
		} else {
			throw new EDBException("Invalid Shared Arrangement Code");
		}

		String csProdId = primeMessage.substring(646, 649);
		csProdId = csProdId.trim();
		be111csPolicySectionBean.setCsProdId(csProdId);

		String csPolShrtTrmDrtn = primeMessage.substring(649, 652);
		csPolShrtTrmDrtn = csPolShrtTrmDrtn.trim();
		if (!csPolShrtTrmDrtn.equals(StringUtils.isNotBlank(csPolShrtTrmDrtn))) {
			be111csPolicySectionBean.setCsPolShrtTrmDrtn(csPolShrtTrmDrtn);
		} else {
			throw new EDBException("Invalid Policy Short Term Duration");
		}

		String csBillFrequencyCd = primeMessage.substring(652, 653);
		csBillFrequencyCd = csBillFrequencyCd.trim();
		if (csBillFrequencyCd.equals("M") || csBillFrequencyCd.equals("Q") || csBillFrequencyCd.equals("S")
				|| csBillFrequencyCd.equals("A") || csBillFrequencyCd.equals("O")) {
			be111csPolicySectionBean.setCsBillFrequencyCD(csBillFrequencyCd);
		} else {
			throw new EDBException("Invalid Bill Frequency Code");
		}

		String csPolBasePolInd = primeMessage.substring(653, 654);
		csPolBasePolInd = csPolBasePolInd.trim();
		be111csPolicySectionBean.setCsPolBasePolInd(csPolBasePolInd);

		String csPolCntrcStIssue = primeMessage.substring(654, 656);
		csPolCntrcStIssue = csPolCntrcStIssue.trim();
		be111csPolicySectionBean.setCsPolCntrcStIssue(csPolCntrcStIssue);

		String csPolAdminInd = primeMessage.substring(656, 657);
		csPolAdminInd = csPolAdminInd.trim();
		if (!csPolAdminInd.equals("Y") && csPolAdminInd.equals("N")) {
			be111csPolicySectionBean.setCsPolAdminInd(csPolAdminInd);
		} else {
			throw new EDBException("Invalid Policy Bill Type code");
		}
		String csPolAnivBeginDate = primeMessage.substring(657, 665);
		if(csPolAnivBeginDate.equals(EDDCommonConstants.EIGHT_BYTES_SPACE)){
			csPolAnivBeginDate=null;
		}else{
			csPolAnivBeginDate = csPolAnivBeginDate.length() == 8 ? csPolAnivBeginDate + "000000" : csPolAnivBeginDate;
			al = DateFormatterUtil.convertStringToTimeStamp(csPolAnivBeginDate);
			if (al.get(1).equals(EDDCommonConstants.TRUE_STATUS)) {
				be111csPolicySectionBean.setCsPolAnivBeginDate((Timestamp) al.get(0));
			} else {
				throw new EDBException("Invalid Policy Aniv Begin Date");
			}
		}
		
		String csPolRenewalDate = primeMessage.substring(665, 673);
		if(csPolRenewalDate.equals(EDDCommonConstants.EIGHT_BYTES_SPACE)){
			csPolRenewalDate=null;
		}else{
			csPolRenewalDate = csPolRenewalDate.length() == 8 ? csPolRenewalDate + "000000" : csPolRenewalDate;
			al = DateFormatterUtil.convertStringToTimeStamp(csPolRenewalDate);
			if (al.get(1).equals(EDDCommonConstants.TRUE_STATUS)) {
				be111csPolicySectionBean.setCsPolRenewalDate((Timestamp) al.get(0));
			} else {
				throw new EDBException("Invalid Policy Renewal Date");
			}
		}

		String csPolAbbrName = primeMessage.substring(673, 712);
		csPolAbbrName = csPolAbbrName.trim();
		be111csPolicySectionBean.setCsPolAbbrName(csPolAbbrName);

		String csPolStatusEffDate = primeMessage.substring(712, 720);
		if (csPolStatusEffDate.equals(EDDCommonConstants.EIGHT_BYTES_SPACE)) {
			csPolStatusEffDate=null;
		} else{
			csPolStatusEffDate = csPolStatusEffDate.length() == 8 ? csPolStatusEffDate + "000000" : csPolStatusEffDate;
			al = DateFormatterUtil.convertStringToTimeStamp(csPolStatusEffDate);
			if (al.get(1).equals(EDDCommonConstants.TRUE_STATUS)) {

				be111csPolicySectionBean.setCsPolStatusEffDate((Timestamp) al.get(0));
			}else {
				throw new EDBException("Invalid Policy Status Effective Date");
			}
		}

		String csPolCancelReason = primeMessage.substring(720, 722);
		csPolCancelReason = csPolCancelReason.trim();
		be111csPolicySectionBean.setCsPolCancelReason(csPolCancelReason);

		String csPolAcctDivCd = primeMessage.substring(722, 725);
		csPolAcctDivCd = csPolAcctDivCd.trim();
		be111csPolicySectionBean.setCsPolAcctDivCD(csPolAcctDivCd);

		String csPolCompanyCd = primeMessage.substring(725, 728);
		csPolCompanyCd = csPolCompanyCd.trim();
		be111csPolicySectionBean.setCsPolCompanyCD(csPolCompanyCd);

		String csPolChrgLnCd = primeMessage.substring(728, 733);
		csPolChrgLnCd = csPolChrgLnCd.trim();
		be111csPolicySectionBean.setCsPolChrgLnCD(csPolChrgLnCd);

		String csPolLegalEntity = primeMessage.substring(733, 738);
		csPolLegalEntity = csPolLegalEntity.trim();
		be111csPolicySectionBean.setCsPolLegalEntity(csPolLegalEntity);

		String csPolLegalEntOnn = primeMessage.substring(738, 743);
		csPolLegalEntOnn = csPolLegalEntOnn.trim();
		be111csPolicySectionBean.setCsPolLegalEntOon(csPolLegalEntOnn);

		String csPolReinsRefCdn = primeMessage.substring(743, 744);
		csPolReinsRefCdn = csPolReinsRefCdn.trim();
		be111csPolicySectionBean.setCsPolReinsRefCDN(csPolReinsRefCdn);

		String csPolRateBegDt = primeMessage.substring(744, 752);
		if (!csPolAdminInd.equals("Y") && !StringUtils.equals(be111csPolicySectionBean.getCsPolRateBegDt(),
				EDDCommonConstants.EIGHT_BYTES_SPACE)) {
			be111csPolicySectionBean.setCsPolRateBegDt(csPolRateBegDt);
		} else {
			throw new EDBException("Invalid Rate Effective Date");
		}

		String csPolRateActDt = primeMessage.substring(752, 760);
		if (!csPolRateActDt.equals("Y") && !StringUtils.equals(be111csPolicySectionBean.getCsPolRateActDt(),
				EDDCommonConstants.EIGHT_BYTES_SPACE)) {
			be111csPolicySectionBean.setCsPolRateActDt(csPolRateActDt);
		} else {
			throw new EDBException("Invalid Rate Activity Date");
		}

		String csPolRateDttm = primeMessage.substring(760, 768);
		csPolRateDttm = csPolRateDttm.trim();
		be111csPolicySectionBean.setCsPolRateDttm(csPolRateDttm);

		String csPolPlanBegDt = primeMessage.substring(768, 776);
		if (!csPolPlanBegDt.equals("Y") && csPolPlanBegDt.equals(EDDCommonConstants.EIGHT_BYTES_SPACE)) {
			be111csPolicySectionBean.setCsPolPlanBegDt(csPolPlanBegDt);
		} else {
			throw new EDBException("Invalid Plan Effective Date");
		}

		String csPolPlanActDt = primeMessage.substring(776, 784);
		if (!csPolPlanActDt.equals("Y") && csPolPlanActDt.equals(EDDCommonConstants.EIGHT_BYTES_SPACE)) {
			be111csPolicySectionBean.setCsPolPlanActDt(csPolPlanActDt);
		} else {
			throw new EDBException("Invalid Plan Activity Date");
		}

		String csPolPlanDttm = primeMessage.substring(784, 792);
		if (!csPolPlanDttm.equals("Y") && csPolPlanDttm.equals(EDDCommonConstants.EIGHT_BYTES_SPACE)) {
			be111csPolicySectionBean.setCsPolPlanDttm(csPolPlanDttm);
		} else {
			throw new EDBException("Invalid Plan Date-Time field");
		}

		String csPolFlatAmt = primeMessage.substring(792, 798);
		csPolFlatAmt = csPolFlatAmt.trim();
		be111csPolicySectionBean.setCsPolFlatAmt(csPolFlatAmt);

		String csPolPerEmpRate = primeMessage.substring(798, 804);
		csPolPerEmpRate = csPolPerEmpRate.trim();
		be111csPolicySectionBean.setCsPolPerEmpRate(csPolPerEmpRate);

		String csPolMaxAmt = primeMessage.substring(804, 810);
		csPolMaxAmt = csPolMaxAmt.trim();
		be111csPolicySectionBean.setCsPolMaxAmt(csPolMaxAmt);

		String csNewPol = primeMessage.substring(810, 811);
		csNewPol = csNewPol.trim();
		be111csPolicySectionBean.setCsNewPol(csNewPol);

		String csOffRegCd = primeMessage.substring(811, 814);
		csOffRegCd = csOffRegCd.trim();
		be111csPolicySectionBean.setCsOffRegCD(csOffRegCd);

		String csCommisnArrgmt = primeMessage.substring(814, 817);
		csCommisnArrgmt = csCommisnArrgmt.trim();
		be111csPolicySectionBean.setCsCommisnArrgmt(csCommisnArrgmt);

		String csRatingZipCd = primeMessage.substring(817, 822);
		csRatingZipCd = csRatingZipCd.trim();
		be111csPolicySectionBean.setCsRatingZipCD(csRatingZipCd);

		String csCountryCd = primeMessage.substring(822, 825);
		csCountryCd = csCountryCd.trim();
		be111csPolicySectionBean.setCsCountryCD(csCountryCd);

		String csMinorMktCd = primeMessage.substring(825, 832);
		csMinorMktCd = csMinorMktCd.trim();
		be111csPolicySectionBean.setCsMinorMktCD(csMinorMktCd);

		String csPolPrdBeginIndDt = primeMessage.substring(832, 840);
		if(csPolPrdBeginIndDt.equals(EDDCommonConstants.EIGHT_BYTES_SPACE)){
			csPolPrdBeginIndDt=null;
		}else{
		csPolPrdBeginIndDt = csPolPrdBeginIndDt.length() == 8 ? csPolPrdBeginIndDt + "000000" : csPolPrdBeginIndDt;
		al = DateFormatterUtil.convertStringToTimeStamp(csPolPrdBeginIndDt);
		if (al.get(1).equals(EDDCommonConstants.TRUE_STATUS)) {
			be111csPolicySectionBean.setCsPolPrdBeginIndDt((Timestamp) al.get(0));
		} else {
			throw new EDBException("Invalid Policy Period Indicator Date");
		}
		}

		String csPolInitEffDt = primeMessage.substring(840, 848);
		if(csPolInitEffDt.equals(EDDCommonConstants.EIGHT_BYTES_SPACE)){
			csPolInitEffDt=null;
		}else{
		csPolInitEffDt = csPolInitEffDt.length() == 8 ? csPolInitEffDt + "000000" : csPolInitEffDt;
		al = DateFormatterUtil.convertStringToTimeStamp(csPolInitEffDt);
		if (al.get(1).equals(EDDCommonConstants.TRUE_STATUS)) {
			be111csPolicySectionBean.setCsPolInitEffDt((Timestamp) al.get(0));
		} else {
			throw new EDBException("Invalid Policy Initial Effective Date");
		}
		}

		String csPolPriorInitEffDate = primeMessage.substring(848, 856);
		if(csPolPriorInitEffDate.equals(EDDCommonConstants.EIGHT_BYTES_SPACE)){
			csPolPriorInitEffDate=null;
		}else{
		csPolPriorInitEffDate = csPolPriorInitEffDate.length() == 8 ? csPolPriorInitEffDate + "000000"
				: csPolPriorInitEffDate;
		al = DateFormatterUtil.convertStringToTimeStamp(csPolPriorInitEffDate);
		if (al.get(1).equals(EDDCommonConstants.TRUE_STATUS)) {
			be111csPolicySectionBean.setCsPolPriorInitEffDt((Timestamp) al.get(0));
		}
		}

		be111CaseStructureRecordBean.setBe111CSPolicySectionBean(be111csPolicySectionBean);
		return be111CaseStructureRecordBean;
	}

	
}
