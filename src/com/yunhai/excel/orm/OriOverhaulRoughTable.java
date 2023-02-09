package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OriOverhaulRoughTable entity. @author MyEclipse Persistence Tools
 */
public class OriOverhaulRoughTable extends AbstractOriOverhaulRoughTable implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OriOverhaulRoughTable() {
	}

	public OriOverhaulRoughTable(String oriOverhaulRoughTableId, String dataVersion, Date calYear, String projectId,
			Double plannedYear, String professionalCategory, String professionalSegmentation, Double totalInvestment,
			String projectBasis, String dataSourceFile, String professionalInvestDirection) {
		super(oriOverhaulRoughTableId, dataVersion, calYear, projectId, plannedYear, professionalCategory,
				professionalSegmentation, totalInvestment, projectBasis, dataSourceFile, professionalInvestDirection);
		// TODO Auto-generated constructor stub
	}

	/** minimal constructor */
	public OriOverhaulRoughTable(String oriOverhaulRoughTableId, String dataVersion, Date calYear) {
		super(oriOverhaulRoughTableId, dataVersion, calYear);
	}

	/** full constructor */
	public OriOverhaulRoughTable(String oriOverhaulRoughTableId, String dataVersion, Date calYear,
			String projectId, Double plannedYear, String professionalCategory, String professionalSegmentation,
			Double totalInvestment, String projectBasis) {
		super(oriOverhaulRoughTableId, dataVersion, calYear, projectId, plannedYear, professionalCategory,
				professionalSegmentation, totalInvestment, projectBasis);
	}

	public OriOverhaulRoughTable(String oriOverhaulRoughTableId, String dataVersion, Date calYear, String projectId,
			Double plannedYear, String professionalCategory, String professionalSegmentation, Double totalInvestment,
			String projectBasis, String dataSourceFile) {
		super(oriOverhaulRoughTableId, dataVersion, calYear, projectId, plannedYear, professionalCategory,
				professionalSegmentation, totalInvestment, projectBasis, dataSourceFile);
		// TODO Auto-generated constructor stub
	}

}
