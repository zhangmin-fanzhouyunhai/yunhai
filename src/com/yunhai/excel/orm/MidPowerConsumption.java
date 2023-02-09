package com.yunhai.excel.orm;

import java.util.Date;

/**
 * MidPowerConsumption entity. @author MyEclipse Persistence Tools
 */
public class MidPowerConsumption extends AbstractMidPowerConsumption implements java.io.Serializable {

	// Constructors
	public MidPowerConsumption() {
		super();
	}

	/** minimal constructor */
	public MidPowerConsumption(Date dvDate, String timestampName, String dispatchOrgName) {
		super(dvDate, timestampName, dispatchOrgName);
	}

	/** full constructor */
	public MidPowerConsumption(Date dvDate, String timestampName, String dispatchOrgName,
			Double powerConsumptionQuantity) {
		super(dvDate, timestampName, dispatchOrgName, powerConsumptionQuantity);
	}


	/** full constructor */
	public MidPowerConsumption(Date dvDate, String timestampName, String dispatchOrgName,
			Double powerConsumptionQuantity,Double qConsumptionQuantity) {
		super(dvDate, timestampName, dispatchOrgName, powerConsumptionQuantity, qConsumptionQuantity);
	}
	/** full constructor */
	public MidPowerConsumption(Date dvDate, String timestampName, String dispatchOrgName,
			Date calYear, String dataVersion, String dataSource,
			Double powerConsumptionQuantity,Double qConsumptionQuantity) {
		super(dvDate, timestampName, dispatchOrgName, powerConsumptionQuantity, calYear, dataVersion, dataSource,qConsumptionQuantity);
	}
}
