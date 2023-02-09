package com.yunhai.excel.orm;

import java.util.Date;

/**
 * OPowerCapacitorCollect entity. @author MyEclipse Persistence Tools
 */
public class OPowerCapacitorCollect extends AbstractOPowerCapacitorCollect implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OPowerCapacitorCollect() {
	}

	/** minimal constructor */
	public OPowerCapacitorCollect(String OPowerCapacitorCollectId, String dataVersion, Date calYear) {
		super(OPowerCapacitorCollectId, dataVersion, calYear);
	}

	/** full constructor */
	public OPowerCapacitorCollect(String OPowerCapacitorCollectId, String dataVersion, Date calYear,
			String projectType, String equipmentId, String equipmentName, String voltageLevel,
			Date operationDate, String insulatingMedium, String installationMode, String accessMode,
			String wiringMode, String whetherRuralPowerNetwork, String ratedVoltage, Double ratedCurrent,
			Double ratedFrequency, Double singleCapacity, Double capacitanceValue, String assetId, String physicalId,
			String pmCode, String belongLocalCityCompany, String belongSubstation, String useEnvironment,
			Double workingAge, Double lifeCycle, Double averageAnnualInterestRate, Double lifeCycleCost,
			Double lccIniInvesCostEquipValue, Double lccIniInvesCostInstalCost, Double lccIniInvementCostOthers,
			Double lccTotalIniInvestmentCost, Double lccOperMaintAnnOpPatro17, Double lccOperMaintAnnOpPatro18,
			Double lccOperMaintAnnOpPatro19, Double lccOperMaintAnnOpPatro20, Double lccOperMaintAnnOpPatro21,
			Double lccOperMaintAnnOpEchec17, Double lccOperMaintAnnOpEchec18, Double lccOperMaintAnnOpEchec19,
			Double lccOperMaintAnnOpEchec20, Double lccOperMaintAnnOpEchec21, Double lccOperMaintAnnOpeTota17,
			Double lccOperMaintAnnOpeTota18, Double lccOperMaintAnnOpeTota19, Double lccOperMaintAnnOpeTota20,
			Double lccOperMaintAnnOpeTota21, Double lccOperMaintAnnRepOver17, Double lccOperMaintAnnRepOver18,
			Double lccOperMaintAnnRepOver19, Double lccOperMaintAnnRepOver20, Double lccOperMaintAnnRepOver21,
			Double lccOperMaintAnnRepDefe17, Double lccOperMaintAnnRepDefe18, Double lccOperMaintAnnRepDefe19,
			Double lccOperMaintAnnRepDefe20, Double lccOperMaintAnnRepDefe21, Double lccOperMaintAnnRepTota17,
			Double lccOperMaintAnnRepTota18, Double lccOperMaintAnnRepTota19, Double lccOperMaintAnnRepTota20,
			Double lccOperMaintAnnRepTota21, Double lccOperMaintAnnFaiCost17, Double lccOperMaintAnnFaiCost18,
			Double lccOperMaintAnnFaiCost19, Double lccOperMaintAnnFaiCost20, Double lccOperMaintAnnFaiCost21,
			Double lccOperMaintTotalCost2017, Double lccOperMaintTotalCost2018, Double lccOperMaintTotalCost2019,
			Double lccOperMaintTotalCost2020, Double lccOperMaintTotalCost2021, Double lccOperMaintCostLatest5y,
			Double lccTechTransformaInves2017, Double lccTechTransformaInves2018, Double lccTechTransformaInves2019,
			Double lccTechTransformaInves2020, Double lccTechTransformaInves2021, Double lccAbandonCostDisposIncome,
			Double lccAbandonCostDisposCost) {
		super(OPowerCapacitorCollectId, dataVersion, calYear, projectType, equipmentId, equipmentName, voltageLevel,
				operationDate, insulatingMedium, installationMode, accessMode, wiringMode, whetherRuralPowerNetwork,
				ratedVoltage, ratedCurrent, ratedFrequency, singleCapacity, capacitanceValue, assetId, physicalId,
				pmCode, belongLocalCityCompany, belongSubstation, useEnvironment, workingAge, lifeCycle,
				averageAnnualInterestRate, lifeCycleCost, lccIniInvesCostEquipValue, lccIniInvesCostInstalCost,
				lccIniInvementCostOthers, lccTotalIniInvestmentCost, lccOperMaintAnnOpPatro17, lccOperMaintAnnOpPatro18,
				lccOperMaintAnnOpPatro19, lccOperMaintAnnOpPatro20, lccOperMaintAnnOpPatro21, lccOperMaintAnnOpEchec17,
				lccOperMaintAnnOpEchec18, lccOperMaintAnnOpEchec19, lccOperMaintAnnOpEchec20, lccOperMaintAnnOpEchec21,
				lccOperMaintAnnOpeTota17, lccOperMaintAnnOpeTota18, lccOperMaintAnnOpeTota19, lccOperMaintAnnOpeTota20,
				lccOperMaintAnnOpeTota21, lccOperMaintAnnRepOver17, lccOperMaintAnnRepOver18, lccOperMaintAnnRepOver19,
				lccOperMaintAnnRepOver20, lccOperMaintAnnRepOver21, lccOperMaintAnnRepDefe17, lccOperMaintAnnRepDefe18,
				lccOperMaintAnnRepDefe19, lccOperMaintAnnRepDefe20, lccOperMaintAnnRepDefe21, lccOperMaintAnnRepTota17,
				lccOperMaintAnnRepTota18, lccOperMaintAnnRepTota19, lccOperMaintAnnRepTota20, lccOperMaintAnnRepTota21,
				lccOperMaintAnnFaiCost17, lccOperMaintAnnFaiCost18, lccOperMaintAnnFaiCost19, lccOperMaintAnnFaiCost20,
				lccOperMaintAnnFaiCost21, lccOperMaintTotalCost2017, lccOperMaintTotalCost2018,
				lccOperMaintTotalCost2019, lccOperMaintTotalCost2020, lccOperMaintTotalCost2021,
				lccOperMaintCostLatest5y, lccTechTransformaInves2017, lccTechTransformaInves2018,
				lccTechTransformaInves2019, lccTechTransformaInves2020, lccTechTransformaInves2021,
				lccAbandonCostDisposIncome, lccAbandonCostDisposCost);
	}

}
