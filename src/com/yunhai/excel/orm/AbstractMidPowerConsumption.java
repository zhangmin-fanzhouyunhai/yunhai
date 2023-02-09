package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractMidPowerConsumption entity provides the base persistence definition
 * of the MidPowerConsumption entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidPowerConsumption implements java.io.Serializable {

	// Fields

	private String midPowerConsumptionId;
	private Date dvDate;
	private String timestampName;
	private String dispatchOrgName;
	private Date calYear;
	private String dataVersion;
	private String dataSource;
	private Double powerConsumptionQuantity;
	private Double qConsumptionQuantity; 
	// Constructors

	/** default constructor 
	 * @param qConsumptionQuantity2 
	 * @param dataSource2 
	 * @param dataVersion2 
	 * @param calYear2 
	 * @param powerConsumptionQuantity2 
	 * @param dispatchOrgName2 
	 * @param timestampName2 
	 * @param dvDate2 */
	public AbstractMidPowerConsumption(Date dvDate2, String timestampName2, String dispatchOrgName2, Double powerConsumptionQuantity2, Date calYear2, String dataVersion2, String dataSource2, Double qConsumptionQuantity2) {

		this.dvDate = dvDate;
		this.timestampName = timestampName;
		this.dispatchOrgName = dispatchOrgName;
		this.calYear = calYear;
		this.dataVersion = dataVersion;
		this.dataSource = dataSource;
		this.powerConsumptionQuantity = powerConsumptionQuantity;
		this.qConsumptionQuantity = qConsumptionQuantity;}

	/** minimal constructor */
	public AbstractMidPowerConsumption(Date dvDate, String timestampName, String dispatchOrgName) {
		this.dvDate = dvDate;
		this.timestampName = timestampName;
		this.dispatchOrgName = dispatchOrgName;
	}

	/** full constructor */
	public AbstractMidPowerConsumption(Date dvDate, String timestampName, String dispatchOrgName,
			Double powerConsumptionQuantity) {
		this.dvDate = dvDate;
		this.timestampName = timestampName;
		this.dispatchOrgName = dispatchOrgName;
		this.powerConsumptionQuantity = powerConsumptionQuantity;
	}
 
	/** full constructor */
	public AbstractMidPowerConsumption(Date dvDate, String timestampName, String dispatchOrgName,
			Double powerConsumptionQuantity,Double qConsumptionQuantity) { 
		this.dvDate = dvDate;
		this.timestampName = timestampName;
		this.dispatchOrgName = dispatchOrgName;
		this.powerConsumptionQuantity = powerConsumptionQuantity;
		this.qConsumptionQuantity = qConsumptionQuantity;
	}
	// Property accessors

	public AbstractMidPowerConsumption() {
		// TODO Auto-generated constructor stub
	}

	public String getMidPowerConsumptionId() {
		return this.midPowerConsumptionId;
	}

	public void setMidPowerConsumptionId(String midPowerConsumptionId) {
		this.midPowerConsumptionId = midPowerConsumptionId;
	}

	public Double getqConsumptionQuantity() {
		return qConsumptionQuantity;
	}

	public void setqConsumptionQuantity(Double qConsumptionQuantity) {
		this.qConsumptionQuantity = qConsumptionQuantity;
	}

	public Date getDvDate() {
		return this.dvDate;
	}

	public void setDvDate(Date dvDate) {
		this.dvDate = dvDate;
	}

	public String getTimestampName() {
		return this.timestampName;
	}

	public void setTimestampName(String timestampName) {
		this.timestampName = timestampName;
	}

	public String getDispatchOrgName() {
		return this.dispatchOrgName;
	}

	public void setDispatchOrgName(String dispatchOrgName) {
		this.dispatchOrgName = dispatchOrgName;
	}

	public Double getPowerConsumptionQuantity() {
		return this.powerConsumptionQuantity;
	}

	public void setPowerConsumptionQuantity(Double powerConsumptionQuantity) {
		this.powerConsumptionQuantity = powerConsumptionQuantity;
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

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

}