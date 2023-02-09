package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriValidatTechRenovaProj entity. @author MyEclipse Persistence Tools
 */
public class OriValidatTechRenovaProj extends AbstractOriValidatTechRenovaProj implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriValidatTechRenovaProj() {
	}

	/** minimal constructor */
	public OriValidatTechRenovaProj(String validatTechRenovaProjId) {
		super(validatTechRenovaProjId);
	}

	/** full constructor */
	public OriValidatTechRenovaProj(String validatTechRenovaProjId, String dataVersion, Date calYear,
			String projectNo, String company, String projectName, String projectContent, String projectType,
			String professionalCategory, String professionalSegmentation, String voltageLevel,
			Date projectStartTime, Date projectEndTime, String responsibleDepartment, Double currentYearFunds,
			Double totalInvestment, String assetProperty, String transformationPurpose, String dataSourceFile) {
		super(validatTechRenovaProjId, dataVersion, calYear, projectNo, company, projectName, projectContent,
				projectType, professionalCategory, professionalSegmentation, voltageLevel, projectStartTime,
				projectEndTime, responsibleDepartment, currentYearFunds, totalInvestment, assetProperty,
				transformationPurpose, dataSourceFile);
	}

}
