package com.yunhai.excel.orm;

import java.io.Serializable;
import java.util.Date;

public class AbstractOriOverhaulMaintainanceCost implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5475858220798096734L;
	private String oriOverhaulMaintainCostId;
	private Date calYear;
	private String dataVersion;
	private Date accountingYear;
	private Double period;
	private String account;
	private String companyCode;
	private String profitCenter;
	private String balanceCenterFLc;
	private String costLargeClass;
	private String subjectDescription;
	private String subjectCode;
	private Double totalStandCurrBusinInter1;
	private Double totalStandCurrBusinInter2;
	private Double totalStandCurrBusinInter3;
	private Double totalStandCurrBusinInter4;
	private Double totalStandCurrBusinInter5;
	private Double totalStandCurrBusinInter6;
	private Double totalStandCurrBusinInter7;
	private Double totalStandCurrBusinInter8;
	private Double totalStandCurrBusinInter9;
	private Double totalStandCurrBusinInter10;
	private Double totalStandCurrBusinInter11;
	private Double totalStandCurrBusinInter12;
	private Double totalStandCurrBusinInter13;
	private Double totalStandCurrBusinInter14;
	private Double totalStandCurrBusinInter15;
	private Double totalStandCurrBusinInter16;
	private Double annualSummary;
	private String dataSourceFile;

	public AbstractOriOverhaulMaintainanceCost() {

	}

	public AbstractOriOverhaulMaintainanceCost(String oriOverhaulMaintainCostId, Date calYear, String dataVersion,
			Date accountingYear, Double period, String account, String companyCode, String profitCenter,
			String balanceCenterFLc, String costLargeClass, String subjectDescription, String subjectCode,
			Double totalStandCurrBusinInter1, Double totalStandCurrBusinInter2, Double totalStandCurrBusinInter3,
			Double totalStandCurrBusinInter4, Double totalStandCurrBusinInter5, Double totalStandCurrBusinInter6,
			Double totalStandCurrBusinInter7, Double totalStandCurrBusinInter8, Double totalStandCurrBusinInter9,
			Double totalStandCurrBusinInter10, Double totalStandCurrBusinInter11, Double totalStandCurrBusinInter12,
			Double totalStandCurrBusinInter13, Double totalStandCurrBusinInter14, Double totalStandCurrBusinInter15,
			Double totalStandCurrBusinInter16, Double annualSummary, String dataSourceFile) {
		super();
		this.oriOverhaulMaintainCostId = oriOverhaulMaintainCostId;
		this.calYear = calYear;
		this.dataVersion = dataVersion;
		this.accountingYear = accountingYear;
		this.period = period;
		this.account = account;
		this.companyCode = companyCode;
		this.profitCenter = profitCenter;
		this.balanceCenterFLc = balanceCenterFLc;
		this.costLargeClass = costLargeClass;
		this.subjectDescription = subjectDescription;
		this.subjectCode = subjectCode;
		this.totalStandCurrBusinInter1 = totalStandCurrBusinInter1;
		this.totalStandCurrBusinInter2 = totalStandCurrBusinInter2;
		this.totalStandCurrBusinInter3 = totalStandCurrBusinInter3;
		this.totalStandCurrBusinInter4 = totalStandCurrBusinInter4;
		this.totalStandCurrBusinInter5 = totalStandCurrBusinInter5;
		this.totalStandCurrBusinInter6 = totalStandCurrBusinInter6;
		this.totalStandCurrBusinInter7 = totalStandCurrBusinInter7;
		this.totalStandCurrBusinInter8 = totalStandCurrBusinInter8;
		this.totalStandCurrBusinInter9 = totalStandCurrBusinInter9;
		this.totalStandCurrBusinInter10 = totalStandCurrBusinInter10;
		this.totalStandCurrBusinInter11 = totalStandCurrBusinInter11;
		this.totalStandCurrBusinInter12 = totalStandCurrBusinInter12;
		this.totalStandCurrBusinInter13 = totalStandCurrBusinInter13;
		this.totalStandCurrBusinInter14 = totalStandCurrBusinInter14;
		this.totalStandCurrBusinInter15 = totalStandCurrBusinInter15;
		this.totalStandCurrBusinInter16 = totalStandCurrBusinInter16;
		this.annualSummary = annualSummary;
		this.dataSourceFile = dataSourceFile;
	}

	public String getOriOverhaulMaintainCostId() {
		return oriOverhaulMaintainCostId;
	}

	public void setOriOverhaulMaintainCostId(String oriOverhaulMaintainCostId) {
		this.oriOverhaulMaintainCostId = oriOverhaulMaintainCostId;
	}

	public Date getCalYear() {
		return calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getDataVersion() {
		return dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getAccountingYear() {
		return accountingYear;
	}

	public void setAccountingYear(Date accountingYear) {
		this.accountingYear = accountingYear;
	}

	public Double getPeriod() {
		return period;
	}

	public void setPeriod(Double period) {
		this.period = period;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getProfitCenter() {
		return profitCenter;
	}

	public void setProfitCenter(String profitCenter) {
		this.profitCenter = profitCenter;
	}

	public String getBalanceCenterFLc() {
		return balanceCenterFLc;
	}

	public void setBalanceCenterFLc(String balanceCenterFLc) {
		this.balanceCenterFLc = balanceCenterFLc;
	}

	public String getCostLargeClass() {
		return costLargeClass;
	}

	public void setCostLargeClass(String costLargeClass) {
		this.costLargeClass = costLargeClass;
	}

	public String getSubjectDescription() {
		return subjectDescription;
	}

	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Double getTotalStandCurrBusinInter1() {
		return totalStandCurrBusinInter1;
	}

	public void setTotalStandCurrBusinInter1(Double totalStandCurrBusinInter1) {
		this.totalStandCurrBusinInter1 = totalStandCurrBusinInter1;
	}

	public Double getTotalStandCurrBusinInter2() {
		return totalStandCurrBusinInter2;
	}

	public void setTotalStandCurrBusinInter2(Double totalStandCurrBusinInter2) {
		this.totalStandCurrBusinInter2 = totalStandCurrBusinInter2;
	}

	public Double getTotalStandCurrBusinInter3() {
		return totalStandCurrBusinInter3;
	}

	public void setTotalStandCurrBusinInter3(Double totalStandCurrBusinInter3) {
		this.totalStandCurrBusinInter3 = totalStandCurrBusinInter3;
	}

	public Double getTotalStandCurrBusinInter4() {
		return totalStandCurrBusinInter4;
	}

	public void setTotalStandCurrBusinInter4(Double totalStandCurrBusinInter4) {
		this.totalStandCurrBusinInter4 = totalStandCurrBusinInter4;
	}

	public Double getTotalStandCurrBusinInter5() {
		return totalStandCurrBusinInter5;
	}

	public void setTotalStandCurrBusinInter5(Double totalStandCurrBusinInter5) {
		this.totalStandCurrBusinInter5 = totalStandCurrBusinInter5;
	}

	public Double getTotalStandCurrBusinInter6() {
		return totalStandCurrBusinInter6;
	}

	public void setTotalStandCurrBusinInter6(Double totalStandCurrBusinInter6) {
		this.totalStandCurrBusinInter6 = totalStandCurrBusinInter6;
	}

	public Double getTotalStandCurrBusinInter7() {
		return totalStandCurrBusinInter7;
	}

	public void setTotalStandCurrBusinInter7(Double totalStandCurrBusinInter7) {
		this.totalStandCurrBusinInter7 = totalStandCurrBusinInter7;
	}

	public Double getTotalStandCurrBusinInter8() {
		return totalStandCurrBusinInter8;
	}

	public void setTotalStandCurrBusinInter8(Double totalStandCurrBusinInter8) {
		this.totalStandCurrBusinInter8 = totalStandCurrBusinInter8;
	}

	public Double getTotalStandCurrBusinInter9() {
		return totalStandCurrBusinInter9;
	}

	public void setTotalStandCurrBusinInter9(Double totalStandCurrBusinInter9) {
		this.totalStandCurrBusinInter9 = totalStandCurrBusinInter9;
	}

	public Double getTotalStandCurrBusinInter10() {
		return totalStandCurrBusinInter10;
	}

	public void setTotalStandCurrBusinInter10(Double totalStandCurrBusinInter10) {
		this.totalStandCurrBusinInter10 = totalStandCurrBusinInter10;
	}

	public Double getTotalStandCurrBusinInter11() {
		return totalStandCurrBusinInter11;
	}

	public void setTotalStandCurrBusinInter11(Double totalStandCurrBusinInter11) {
		this.totalStandCurrBusinInter11 = totalStandCurrBusinInter11;
	}

	public Double getTotalStandCurrBusinInter12() {
		return totalStandCurrBusinInter12;
	}

	public void setTotalStandCurrBusinInter12(Double totalStandCurrBusinInter12) {
		this.totalStandCurrBusinInter12 = totalStandCurrBusinInter12;
	}

	public Double getTotalStandCurrBusinInter13() {
		return totalStandCurrBusinInter13;
	}

	public void setTotalStandCurrBusinInter13(Double totalStandCurrBusinInter13) {
		this.totalStandCurrBusinInter13 = totalStandCurrBusinInter13;
	}

	public Double getTotalStandCurrBusinInter14() {
		return totalStandCurrBusinInter14;
	}

	public void setTotalStandCurrBusinInter14(Double totalStandCurrBusinInter14) {
		this.totalStandCurrBusinInter14 = totalStandCurrBusinInter14;
	}

	public Double getTotalStandCurrBusinInter15() {
		return totalStandCurrBusinInter15;
	}

	public void setTotalStandCurrBusinInter15(Double totalStandCurrBusinInter15) {
		this.totalStandCurrBusinInter15 = totalStandCurrBusinInter15;
	}

	public Double getTotalStandCurrBusinInter16() {
		return totalStandCurrBusinInter16;
	}

	public void setTotalStandCurrBusinInter16(Double totalStandCurrBusinInter16) {
		this.totalStandCurrBusinInter16 = totalStandCurrBusinInter16;
	}

	public Double getAnnualSummary() {
		return annualSummary;
	}

	public void setAnnualSummary(Double annualSummary) {
		this.annualSummary = annualSummary;
	}

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}
 
}
