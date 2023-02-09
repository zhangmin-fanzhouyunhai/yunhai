package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriTechRenovaProjEquip entity. @author MyEclipse Persistence Tools
 */
public class OriTechRenovaProjEquip extends AbstractOriTechRenovaProjEquip implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 472530132002045136L;

	/** default constructor */
	public OriTechRenovaProjEquip() {
	}

	/** minimal constructor */
	public OriTechRenovaProjEquip(String oriTechRenovaProjEquipId) {
		super(oriTechRenovaProjEquipId);
	}

	/** full constructor */
	public OriTechRenovaProjEquip(String oriTechRenovaProjEquipId, String objId, String localCity, String entryName,
			String plannedYear, String projectType, Double itemScore, String professionalCategory,
			String professionalSegmentation, String projectContent, String transformationPurpose,
			String projectVoltageLevel, String projectDocumentNo, Double currentYearFunds, Double totalInvestment,
			String assetProperty, Date projectStartTime, Date projectEndTime, String ruralPowerNetwork,
			String transformationReasons, String equipmentType, String equipmentCode, String equipmentVoltageLevel,
			String equipmentModel, Date operationDate, Double equipmentCapacity) {
		super(oriTechRenovaProjEquipId, objId, localCity, entryName, plannedYear, projectType, itemScore,
				professionalCategory, professionalSegmentation, projectContent, transformationPurpose,
				projectVoltageLevel, projectDocumentNo, currentYearFunds, totalInvestment, assetProperty,
				projectStartTime, projectEndTime, ruralPowerNetwork, transformationReasons, equipmentType,
				equipmentCode, equipmentVoltageLevel, equipmentModel, operationDate, equipmentCapacity);
	}

	public OriTechRenovaProjEquip(String oriTechRenovaProjEquipId, String dataVersion, Date calYear, String objId,
			String localCity, String entryName, String plannedYear, String projectType, Double itemScore,
			String professionalCategory, String professionalSegmentation, String projectContent,
			String transformationPurpose, String projectVoltageLevel, String projectDocumentNo, Double currentYearFunds,
			Double totalInvestment, String assetProperty, Date projectStartTime, Date projectEndTime,
			String ruralPowerNetwork, String transformationReasons, String equipmentType, String equipmentCode,
			String equipmentVoltageLevel, String equipmentModel, Date operationDate, Double equipmentCapacity,
			String dataSourceFile) {
		super(oriTechRenovaProjEquipId, dataVersion, calYear, objId, localCity, entryName, plannedYear, projectType, itemScore,
				professionalCategory, professionalSegmentation, projectContent, transformationPurpose, projectVoltageLevel,
				projectDocumentNo, currentYearFunds, totalInvestment, assetProperty, projectStartTime, projectEndTime,
				ruralPowerNetwork, transformationReasons, equipmentType, equipmentCode, equipmentVoltageLevel, equipmentModel,
				operationDate, equipmentCapacity, dataSourceFile);
		// TODO Auto-generated constructor stub
	}

	public OriTechRenovaProjEquip(String oriTechRenovaProjEquipId, String dataVersion, Date calYear, String objId,
			String localCity, String entryName, String plannedYear, String projectType, Double itemScore,
			String professionalCategory, String professionalSegmentation, String projectContent,
			String transformationPurpose, String projectVoltageLevel, String projectDocumentNo, Double currentYearFunds,
			Double totalInvestment, String assetProperty, Date projectStartTime, Date projectEndTime,
			String ruralPowerNetwork, String transformationReasons, String equipmentType, String equipmentCode,
			String equipmentVoltageLevel, String equipmentModel, Date operationDate, Double equipmentCapacity,
			String dataSourceFile, String substationLineName) {
		super(oriTechRenovaProjEquipId, dataVersion, calYear, objId, localCity, entryName, plannedYear, projectType, itemScore,
				professionalCategory, professionalSegmentation, projectContent, transformationPurpose, projectVoltageLevel,
				projectDocumentNo, currentYearFunds, totalInvestment, assetProperty, projectStartTime, projectEndTime,
				ruralPowerNetwork, transformationReasons, equipmentType, equipmentCode, equipmentVoltageLevel, equipmentModel,
				operationDate, equipmentCapacity, dataSourceFile, substationLineName);
		// TODO Auto-generated constructor stub
	}

}
