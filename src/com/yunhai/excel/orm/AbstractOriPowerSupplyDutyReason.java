package com.yunhai.excel.orm;

import java.util.Date;

public class AbstractOriPowerSupplyDutyReason implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7697903478588768367L;
	private String oriPowerSupplyDutyReaId;
	private Date calYear;
	private String dataVersion;
	private Date startTime;
	private Date endTime;
	private String statisticClassification;
	private String statisticExplain;
	private String orgCode;
	private String statisticOrgName;
	private String planningFeature;
	private String orgPropertyCode;
	private String orgProperty;
	private String voltageLevel;
	private String powerCutNature;
	private String circuitProperty;
	private String specialAnalysisCode;
	private String specialAnalysis;
	private String reasonType;
	private String dutyReasonName;
	private String dutyReasonCode;
	private Double powerCutTimes;
	private Double blackoutCustomerQuantity;
	private Double powerCutLastTime;
	private Double powerCutTimeMultipUserNum;
	private Double powerCutCapacity;
	private Double lackPowerSupply;
	private Double powerCutTimePerUser;
	private Double influenceOnRs1;
	private String statisticTaskId;
	private String classifiedCode;
	private String dataSourceFile;

	/** default constructor */
	public AbstractOriPowerSupplyDutyReason() {

	}

	/** full constructor */
	public AbstractOriPowerSupplyDutyReason(String oriPowerSupplyDutyReaId, Date calYear, String dataVersion,
			Date startTime, Date endTime, String statisticClassification, String statisticExplain, String orgCode,
			String statisticOrgName, String planningFeature, String orgPropertyCode, String orgProperty,
			String voltageLevel, String powerCutNature, String circuitProperty, String specialAnalysisCode,
			String specialAnalysis, String reasonType, String dutyReasonName, String dutyReasonCode,
			Double powerCutTimes, Double blackoutCustomerQuantity, Double powerCutLastTime,
			Double powerCutTimeMultipUserNum, Double powerCutCapacity, Double lackPowerSupply,
			Double powerCutTimePerUser, Double influenceOnRs1, String statisticTaskId, String classifiedCode,String dataSourceFile) {
		super();
		this.oriPowerSupplyDutyReaId = oriPowerSupplyDutyReaId;
		this.calYear = calYear;
		this.dataVersion = dataVersion;
		this.startTime = startTime;
		this.endTime = endTime;
		this.statisticClassification = statisticClassification;
		this.statisticExplain = statisticExplain;
		this.orgCode = orgCode;
		this.statisticOrgName = statisticOrgName;
		this.planningFeature = planningFeature;
		this.orgPropertyCode = orgPropertyCode;
		this.orgProperty = orgProperty;
		this.voltageLevel = voltageLevel;
		this.powerCutNature = powerCutNature;
		this.circuitProperty = circuitProperty;
		this.specialAnalysisCode = specialAnalysisCode;
		this.specialAnalysis = specialAnalysis;
		this.reasonType = reasonType;
		this.dutyReasonName = dutyReasonName;
		this.dutyReasonCode = dutyReasonCode;
		this.powerCutTimes = powerCutTimes;
		this.blackoutCustomerQuantity = blackoutCustomerQuantity;
		this.powerCutLastTime = powerCutLastTime;
		this.powerCutTimeMultipUserNum = powerCutTimeMultipUserNum;
		this.powerCutCapacity = powerCutCapacity;
		this.lackPowerSupply = lackPowerSupply;
		this.powerCutTimePerUser = powerCutTimePerUser;
		this.influenceOnRs1 = influenceOnRs1;
		this.statisticTaskId = statisticTaskId;
		this.classifiedCode = classifiedCode;
		this.dataSourceFile=dataSourceFile;
	}
 
	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public String getOriPowerSupplyDutyReaId() {
		return oriPowerSupplyDutyReaId;
	}

	public void setOriPowerSupplyDutyReaId(String oriPowerSupplyDutyReaId) {
		this.oriPowerSupplyDutyReaId = oriPowerSupplyDutyReaId;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStatisticClassification() {
		return statisticClassification;
	}

	public void setStatisticClassification(String statisticClassification) {
		this.statisticClassification = statisticClassification;
	}

	public String getStatisticExplain() {
		return statisticExplain;
	}

	public void setStatisticExplain(String statisticExplain) {
		this.statisticExplain = statisticExplain;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getStatisticOrgName() {
		return statisticOrgName;
	}

	public void setStatisticOrgName(String statisticOrgName) {
		this.statisticOrgName = statisticOrgName;
	}

	public String getPlanningFeature() {
		return planningFeature;
	}

	public void setPlanningFeature(String planningFeature) {
		this.planningFeature = planningFeature;
	}

	public String getOrgPropertyCode() {
		return orgPropertyCode;
	}

	public void setOrgPropertyCode(String orgPropertyCode) {
		this.orgPropertyCode = orgPropertyCode;
	}

	public String getOrgProperty() {
		return orgProperty;
	}

	public void setOrgProperty(String orgProperty) {
		this.orgProperty = orgProperty;
	}

	public String getVoltageLevel() {
		return voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public String getPowerCutNature() {
		return powerCutNature;
	}

	public void setPowerCutNature(String powerCutNature) {
		this.powerCutNature = powerCutNature;
	}

	public String getCircuitProperty() {
		return circuitProperty;
	}

	public void setCircuitProperty(String circuitProperty) {
		this.circuitProperty = circuitProperty;
	}

	public String getSpecialAnalysisCode() {
		return specialAnalysisCode;
	}

	public void setSpecialAnalysisCode(String specialAnalysisCode) {
		this.specialAnalysisCode = specialAnalysisCode;
	}

	public String getSpecialAnalysis() {
		return specialAnalysis;
	}

	public void setSpecialAnalysis(String specialAnalysis) {
		this.specialAnalysis = specialAnalysis;
	}

	public String getReasonType() {
		return reasonType;
	}

	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

	public String getDutyReasonName() {
		return dutyReasonName;
	}

	public void setDutyReasonName(String dutyReasonName) {
		this.dutyReasonName = dutyReasonName;
	}

	public String getDutyReasonCode() {
		return dutyReasonCode;
	}

	public void setDutyReasonCode(String dutyReasonCode) {
		this.dutyReasonCode = dutyReasonCode;
	}

	public Double getPowerCutTimes() {
		return powerCutTimes;
	}

	public void setPowerCutTimes(Double powerCutTimes) {
		this.powerCutTimes = powerCutTimes;
	}

	public Double getBlackoutCustomerQuantity() {
		return blackoutCustomerQuantity;
	}

	public void setBlackoutCustomerQuantity(Double blackoutCustomerQuantity) {
		this.blackoutCustomerQuantity = blackoutCustomerQuantity;
	}

	public Double getPowerCutLastTime() {
		return powerCutLastTime;
	}

	public void setPowerCutLastTime(Double powerCutLastTime) {
		this.powerCutLastTime = powerCutLastTime;
	}

	public Double getPowerCutTimeMultipUserNum() {
		return powerCutTimeMultipUserNum;
	}

	public void setPowerCutTimeMultipUserNum(Double powerCutTimeMultipUserNum) {
		this.powerCutTimeMultipUserNum = powerCutTimeMultipUserNum;
	}

	public Double getPowerCutCapacity() {
		return powerCutCapacity;
	}

	public void setPowerCutCapacity(Double powerCutCapacity) {
		this.powerCutCapacity = powerCutCapacity;
	}

	public Double getLackPowerSupply() {
		return lackPowerSupply;
	}

	public void setLackPowerSupply(Double lackPowerSupply) {
		this.lackPowerSupply = lackPowerSupply;
	}

	public Double getPowerCutTimePerUser() {
		return powerCutTimePerUser;
	}

	public void setPowerCutTimePerUser(Double powerCutTimePerUser) {
		this.powerCutTimePerUser = powerCutTimePerUser;
	}

	public Double getInfluenceOnRs1() {
		return influenceOnRs1;
	}

	public void setInfluenceOnRs1(Double influenceOnRs1) {
		this.influenceOnRs1 = influenceOnRs1;
	}

	public String getStatisticTaskId() {
		return statisticTaskId;
	}

	public void setStatisticTaskId(String statisticTaskId) {
		this.statisticTaskId = statisticTaskId;
	}

	public String getClassifiedCode() {
		return classifiedCode;
	}

	public void setClassifiedCode(String classifiedCode) {
		this.classifiedCode = classifiedCode;
	}

}
