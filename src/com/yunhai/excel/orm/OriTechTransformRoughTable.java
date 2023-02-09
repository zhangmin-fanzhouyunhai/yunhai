package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriTechTransformRoughTable entity. @author MyEclipse Persistence Tools
 */
public class OriTechTransformRoughTable extends AbstractOriTechTransformRoughTable implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriTechTransformRoughTable() {
	}

	/** minimal constructor */
	public OriTechTransformRoughTable(String oriTechTransfRoughTableId, String dataVersion, Date calYear) {
		super(oriTechTransfRoughTableId, dataVersion, calYear);
	}

	public OriTechTransformRoughTable(String oriTechTransfRoughTableId, String dataVersion, Date calYear,
			String projectId, Double plannedYear, String professionalCategory, String professionalSegmentation,
			String transformationPurpose, Double totalInvestment, String recommendationBasis, String dataSourceFile,
			String professionalInvestDirection) {
		super(oriTechTransfRoughTableId, dataVersion, calYear, projectId, plannedYear, professionalCategory,
				professionalSegmentation, transformationPurpose, totalInvestment, recommendationBasis, dataSourceFile,
				professionalInvestDirection);
		// TODO Auto-generated constructor stub
	}

	/** full constructor */
	public OriTechTransformRoughTable(String oriTechTransfRoughTableId, String dataVersion, Date calYear,
			String projectId, Double plannedYear, String professionalCategory, String professionalSegmentation,
			String transformationPurpose, Double totalInvestment, String recommendationBasis) {
		super(oriTechTransfRoughTableId, dataVersion, calYear, projectId, plannedYear, professionalCategory,
				professionalSegmentation, transformationPurpose, totalInvestment, recommendationBasis);
	}

	public OriTechTransformRoughTable(String oriTechTransfRoughTableId, String dataVersion, Date calYear,
			String projectId, Double plannedYear, String professionalCategory, String professionalSegmentation,
			String transformationPurpose, Double totalInvestment, String recommendationBasis, String dataSourceFile) {
		super(oriTechTransfRoughTableId, dataVersion, calYear, projectId, plannedYear, professionalCategory,
				professionalSegmentation, transformationPurpose, totalInvestment, recommendationBasis, dataSourceFile);
		// TODO Auto-generated constructor stub
	}

}
