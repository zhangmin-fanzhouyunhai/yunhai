package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOElectricReactorCollect entity provides the base persistence
 * definition of the OElectricReactorCollect entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOElectricReactorCollect implements java.io.Serializable {

	// Fields

	private String OElectricReactorCollectId;
	private String dataVersion;
	private Date calYear;
	private String dataSourceFile;
	private String projectType;
	private String equipmentId;
	private String equipmentName;
	private String voltageLevel;
	private Date operationDate;
	private String insulatingMedium;
	private String installationMode;
	private String accessMode;
	private String coolingMode;
	private String voltageRegulationMode;
	private String whetherRuralPowerNetwork;
	private String ratedVoltage;
	private Double ratedCurrent;
	private Double ratedFrequency;
	private Double ratedCapacity;
	private Double ratedReactance;
	private Double ratedReactanceRate;
	private Double ratedInductance;
	private String assetId;
	private String physicalId;
	private String pmId;
	private String belongLocalCityCompany;
	private String belongSubstation;
	private String useEnvironment;
	private Double workingAge;
	private Double lifeCycle;
	private Double averageAnnualInterestRate;
	private Double lifeCycleCost;
	private Double lccIniInvesCostEquipValue;
	private Double lccIniInvesCostInstalCost;
	private Double lccIniInvementCostOthers;
	private Double lccTotalIniInvestmentCost;
	private Double lccOperMaintAnnOpPatro17;
	private Double lccOperMaintAnnOpPatro18;
	private Double lccOperMaintAnnOpPatro19;
	private Double lccOperMaintAnnOpPatro20;
	private Double lccOperMaintAnnOpPatro21;
	private Double lccOperMaintAnnOpEchec17;
	private Double lccOperMaintAnnOpEchec18;
	private Double lccOperMaintAnnOpEchec19;
	private Double lccOperMaintAnnOpEchec20;
	private Double lccOperMaintAnnOpEchec21;
	private Double lccOperMaintAnnOpeTota17;
	private Double lccOperMaintAnnOpeTota18;
	private Double lccOperMaintAnnOpeTota19;
	private Double lccOperMaintAnnOpeTota20;
	private Double lccOperMaintAnnOpeTota21;
	private Double lccOperMaintAnnRepOver17;
	private Double lccOperMaintAnnRepOver18;
	private Double lccOperMaintAnnRepOver19;
	private Double lccOperMaintAnnRepOver20;
	private Double lccOperMaintAnnRepOver21;
	private Double lccOperMaintAnnRepDefe17;
	private Double lccOperMaintAnnRepDefe18;
	private Double lccOperMaintAnnRepDefe19;
	private Double lccOperMaintAnnRepDefe20;
	private Double lccOperMaintAnnRepDefe21;
	private Double lccOperMaintAnnRepTota17;
	private Double lccOperMaintAnnRepTota18;
	private Double lccOperMaintAnnRepTota19;
	private Double lccOperMaintAnnRepTota20;
	private Double lccOperMaintAnnRepTota21;
	private Double lccOperMaintAnnFaiCost17;
	private Double lccOperMaintAnnFaiCost18;
	private Double lccOperMaintAnnFaiCost19;
	private Double lccOperMaintAnnFaiCost20;
	private Double lccOperMaintAnnFaiCost21;
	private Double lccOperMaintTotalCost2017;
	private Double lccOperMaintTotalCost2018;
	private Double lccOperMaintTotalCost2019;
	private Double lccOperMaintTotalCost2020;
	private Double lccOperMaintTotalCost2021;
	private Double lccOperMaintCostLatest5y;
	private Double lccTechTransformaInves2017;
	private Double lccTechTransformaInves2018;
	private Double lccTechTransformaInves2019;
	private Double lccTechTransformaInves2020;
	private Double lccTechTransformaInves2021;
	private Double lccAbandonCostDisposIncome;
	private Double lccAbandonCostDisposCost;

	// Constructors

	/** default constructor */
	public AbstractOElectricReactorCollect() {
	}

	/** minimal constructor */
	public AbstractOElectricReactorCollect(String OElectricReactorCollectId, String dataVersion, Date calYear) {
		this.OElectricReactorCollectId = OElectricReactorCollectId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractOElectricReactorCollect(String OElectricReactorCollectId, String dataVersion, Date calYear,
			String projectType, String equipmentId, String equipmentName, String voltageLevel,
			Date operationDate, String insulatingMedium, String installationMode, String accessMode,
			String coolingMode, String voltageRegulationMode, String whetherRuralPowerNetwork, String ratedVoltage,
			Double ratedCurrent, Double ratedFrequency, Double ratedCapacity, Double ratedReactance,
			Double ratedReactanceRate, Double ratedInductance, String assetId, String physicalId, String pmId,
			String belongLocalCityCompany, String belongSubstation, String useEnvironment, Double workingAge,
			Double lifeCycle, Double averageAnnualInterestRate, Double lifeCycleCost, Double lccIniInvesCostEquipValue,
			Double lccIniInvesCostInstalCost, Double lccIniInvementCostOthers, Double lccTotalIniInvestmentCost,
			Double lccOperMaintAnnOpPatro17, Double lccOperMaintAnnOpPatro18, Double lccOperMaintAnnOpPatro19,
			Double lccOperMaintAnnOpPatro20, Double lccOperMaintAnnOpPatro21, Double lccOperMaintAnnOpEchec17,
			Double lccOperMaintAnnOpEchec18, Double lccOperMaintAnnOpEchec19, Double lccOperMaintAnnOpEchec20,
			Double lccOperMaintAnnOpEchec21, Double lccOperMaintAnnOpeTota17, Double lccOperMaintAnnOpeTota18,
			Double lccOperMaintAnnOpeTota19, Double lccOperMaintAnnOpeTota20, Double lccOperMaintAnnOpeTota21,
			Double lccOperMaintAnnRepOver17, Double lccOperMaintAnnRepOver18, Double lccOperMaintAnnRepOver19,
			Double lccOperMaintAnnRepOver20, Double lccOperMaintAnnRepOver21, Double lccOperMaintAnnRepDefe17,
			Double lccOperMaintAnnRepDefe18, Double lccOperMaintAnnRepDefe19, Double lccOperMaintAnnRepDefe20,
			Double lccOperMaintAnnRepDefe21, Double lccOperMaintAnnRepTota17, Double lccOperMaintAnnRepTota18,
			Double lccOperMaintAnnRepTota19, Double lccOperMaintAnnRepTota20, Double lccOperMaintAnnRepTota21,
			Double lccOperMaintAnnFaiCost17, Double lccOperMaintAnnFaiCost18, Double lccOperMaintAnnFaiCost19,
			Double lccOperMaintAnnFaiCost20, Double lccOperMaintAnnFaiCost21, Double lccOperMaintTotalCost2017,
			Double lccOperMaintTotalCost2018, Double lccOperMaintTotalCost2019, Double lccOperMaintTotalCost2020,
			Double lccOperMaintTotalCost2021, Double lccOperMaintCostLatest5y, Double lccTechTransformaInves2017,
			Double lccTechTransformaInves2018, Double lccTechTransformaInves2019, Double lccTechTransformaInves2020,
			Double lccTechTransformaInves2021, Double lccAbandonCostDisposIncome, Double lccAbandonCostDisposCost) {
		this.OElectricReactorCollectId = OElectricReactorCollectId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.projectType = projectType;
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.voltageLevel = voltageLevel;
		this.operationDate = operationDate;
		this.insulatingMedium = insulatingMedium;
		this.installationMode = installationMode;
		this.accessMode = accessMode;
		this.coolingMode = coolingMode;
		this.voltageRegulationMode = voltageRegulationMode;
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
		this.ratedVoltage = ratedVoltage;
		this.ratedCurrent = ratedCurrent;
		this.ratedFrequency = ratedFrequency;
		this.ratedCapacity = ratedCapacity;
		this.ratedReactance = ratedReactance;
		this.ratedReactanceRate = ratedReactanceRate;
		this.ratedInductance = ratedInductance;
		this.assetId = assetId;
		this.physicalId = physicalId;
		this.pmId = pmId;
		this.belongLocalCityCompany = belongLocalCityCompany;
		this.belongSubstation = belongSubstation;
		this.useEnvironment = useEnvironment;
		this.workingAge = workingAge;
		this.lifeCycle = lifeCycle;
		this.averageAnnualInterestRate = averageAnnualInterestRate;
		this.lifeCycleCost = lifeCycleCost;
		this.lccIniInvesCostEquipValue = lccIniInvesCostEquipValue;
		this.lccIniInvesCostInstalCost = lccIniInvesCostInstalCost;
		this.lccIniInvementCostOthers = lccIniInvementCostOthers;
		this.lccTotalIniInvestmentCost = lccTotalIniInvestmentCost;
		this.lccOperMaintAnnOpPatro17 = lccOperMaintAnnOpPatro17;
		this.lccOperMaintAnnOpPatro18 = lccOperMaintAnnOpPatro18;
		this.lccOperMaintAnnOpPatro19 = lccOperMaintAnnOpPatro19;
		this.lccOperMaintAnnOpPatro20 = lccOperMaintAnnOpPatro20;
		this.lccOperMaintAnnOpPatro21 = lccOperMaintAnnOpPatro21;
		this.lccOperMaintAnnOpEchec17 = lccOperMaintAnnOpEchec17;
		this.lccOperMaintAnnOpEchec18 = lccOperMaintAnnOpEchec18;
		this.lccOperMaintAnnOpEchec19 = lccOperMaintAnnOpEchec19;
		this.lccOperMaintAnnOpEchec20 = lccOperMaintAnnOpEchec20;
		this.lccOperMaintAnnOpEchec21 = lccOperMaintAnnOpEchec21;
		this.lccOperMaintAnnOpeTota17 = lccOperMaintAnnOpeTota17;
		this.lccOperMaintAnnOpeTota18 = lccOperMaintAnnOpeTota18;
		this.lccOperMaintAnnOpeTota19 = lccOperMaintAnnOpeTota19;
		this.lccOperMaintAnnOpeTota20 = lccOperMaintAnnOpeTota20;
		this.lccOperMaintAnnOpeTota21 = lccOperMaintAnnOpeTota21;
		this.lccOperMaintAnnRepOver17 = lccOperMaintAnnRepOver17;
		this.lccOperMaintAnnRepOver18 = lccOperMaintAnnRepOver18;
		this.lccOperMaintAnnRepOver19 = lccOperMaintAnnRepOver19;
		this.lccOperMaintAnnRepOver20 = lccOperMaintAnnRepOver20;
		this.lccOperMaintAnnRepOver21 = lccOperMaintAnnRepOver21;
		this.lccOperMaintAnnRepDefe17 = lccOperMaintAnnRepDefe17;
		this.lccOperMaintAnnRepDefe18 = lccOperMaintAnnRepDefe18;
		this.lccOperMaintAnnRepDefe19 = lccOperMaintAnnRepDefe19;
		this.lccOperMaintAnnRepDefe20 = lccOperMaintAnnRepDefe20;
		this.lccOperMaintAnnRepDefe21 = lccOperMaintAnnRepDefe21;
		this.lccOperMaintAnnRepTota17 = lccOperMaintAnnRepTota17;
		this.lccOperMaintAnnRepTota18 = lccOperMaintAnnRepTota18;
		this.lccOperMaintAnnRepTota19 = lccOperMaintAnnRepTota19;
		this.lccOperMaintAnnRepTota20 = lccOperMaintAnnRepTota20;
		this.lccOperMaintAnnRepTota21 = lccOperMaintAnnRepTota21;
		this.lccOperMaintAnnFaiCost17 = lccOperMaintAnnFaiCost17;
		this.lccOperMaintAnnFaiCost18 = lccOperMaintAnnFaiCost18;
		this.lccOperMaintAnnFaiCost19 = lccOperMaintAnnFaiCost19;
		this.lccOperMaintAnnFaiCost20 = lccOperMaintAnnFaiCost20;
		this.lccOperMaintAnnFaiCost21 = lccOperMaintAnnFaiCost21;
		this.lccOperMaintTotalCost2017 = lccOperMaintTotalCost2017;
		this.lccOperMaintTotalCost2018 = lccOperMaintTotalCost2018;
		this.lccOperMaintTotalCost2019 = lccOperMaintTotalCost2019;
		this.lccOperMaintTotalCost2020 = lccOperMaintTotalCost2020;
		this.lccOperMaintTotalCost2021 = lccOperMaintTotalCost2021;
		this.lccOperMaintCostLatest5y = lccOperMaintCostLatest5y;
		this.lccTechTransformaInves2017 = lccTechTransformaInves2017;
		this.lccTechTransformaInves2018 = lccTechTransformaInves2018;
		this.lccTechTransformaInves2019 = lccTechTransformaInves2019;
		this.lccTechTransformaInves2020 = lccTechTransformaInves2020;
		this.lccTechTransformaInves2021 = lccTechTransformaInves2021;
		this.lccAbandonCostDisposIncome = lccAbandonCostDisposIncome;
		this.lccAbandonCostDisposCost = lccAbandonCostDisposCost;
	}


	public AbstractOElectricReactorCollect(String oElectricReactorCollectId, String dataVersion, Date calYear,
			String dataSourceFile, String projectType, String equipmentId, String equipmentName, String voltageLevel,
			Date operationDate, String insulatingMedium, String installationMode, String accessMode, String coolingMode,
			String voltageRegulationMode, String whetherRuralPowerNetwork, String ratedVoltage, Double ratedCurrent,
			Double ratedFrequency, Double ratedCapacity, Double ratedReactance, Double ratedReactanceRate,
			Double ratedInductance, String assetId, String physicalId, String pmId, String belongLocalCityCompany,
			String belongSubstation, String useEnvironment, Double workingAge, Double lifeCycle,
			Double averageAnnualInterestRate, Double lifeCycleCost, Double lccIniInvesCostEquipValue,
			Double lccIniInvesCostInstalCost, Double lccIniInvementCostOthers, Double lccTotalIniInvestmentCost,
			Double lccOperMaintAnnOpPatro17, Double lccOperMaintAnnOpPatro18, Double lccOperMaintAnnOpPatro19,
			Double lccOperMaintAnnOpPatro20, Double lccOperMaintAnnOpPatro21, Double lccOperMaintAnnOpEchec17,
			Double lccOperMaintAnnOpEchec18, Double lccOperMaintAnnOpEchec19, Double lccOperMaintAnnOpEchec20,
			Double lccOperMaintAnnOpEchec21, Double lccOperMaintAnnOpeTota17, Double lccOperMaintAnnOpeTota18,
			Double lccOperMaintAnnOpeTota19, Double lccOperMaintAnnOpeTota20, Double lccOperMaintAnnOpeTota21,
			Double lccOperMaintAnnRepOver17, Double lccOperMaintAnnRepOver18, Double lccOperMaintAnnRepOver19,
			Double lccOperMaintAnnRepOver20, Double lccOperMaintAnnRepOver21, Double lccOperMaintAnnRepDefe17,
			Double lccOperMaintAnnRepDefe18, Double lccOperMaintAnnRepDefe19, Double lccOperMaintAnnRepDefe20,
			Double lccOperMaintAnnRepDefe21, Double lccOperMaintAnnRepTota17, Double lccOperMaintAnnRepTota18,
			Double lccOperMaintAnnRepTota19, Double lccOperMaintAnnRepTota20, Double lccOperMaintAnnRepTota21,
			Double lccOperMaintAnnFaiCost17, Double lccOperMaintAnnFaiCost18, Double lccOperMaintAnnFaiCost19,
			Double lccOperMaintAnnFaiCost20, Double lccOperMaintAnnFaiCost21, Double lccOperMaintTotalCost2017,
			Double lccOperMaintTotalCost2018, Double lccOperMaintTotalCost2019, Double lccOperMaintTotalCost2020,
			Double lccOperMaintTotalCost2021, Double lccOperMaintCostLatest5y, Double lccTechTransformaInves2017,
			Double lccTechTransformaInves2018, Double lccTechTransformaInves2019, Double lccTechTransformaInves2020,
			Double lccTechTransformaInves2021, Double lccAbandonCostDisposIncome, Double lccAbandonCostDisposCost) {
		super();
		OElectricReactorCollectId = oElectricReactorCollectId;
		this.dataVersion = dataVersion;
		this.calYear = calYear;
		this.dataSourceFile = dataSourceFile;
		this.projectType = projectType;
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.voltageLevel = voltageLevel;
		this.operationDate = operationDate;
		this.insulatingMedium = insulatingMedium;
		this.installationMode = installationMode;
		this.accessMode = accessMode;
		this.coolingMode = coolingMode;
		this.voltageRegulationMode = voltageRegulationMode;
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
		this.ratedVoltage = ratedVoltage;
		this.ratedCurrent = ratedCurrent;
		this.ratedFrequency = ratedFrequency;
		this.ratedCapacity = ratedCapacity;
		this.ratedReactance = ratedReactance;
		this.ratedReactanceRate = ratedReactanceRate;
		this.ratedInductance = ratedInductance;
		this.assetId = assetId;
		this.physicalId = physicalId;
		this.pmId = pmId;
		this.belongLocalCityCompany = belongLocalCityCompany;
		this.belongSubstation = belongSubstation;
		this.useEnvironment = useEnvironment;
		this.workingAge = workingAge;
		this.lifeCycle = lifeCycle;
		this.averageAnnualInterestRate = averageAnnualInterestRate;
		this.lifeCycleCost = lifeCycleCost;
		this.lccIniInvesCostEquipValue = lccIniInvesCostEquipValue;
		this.lccIniInvesCostInstalCost = lccIniInvesCostInstalCost;
		this.lccIniInvementCostOthers = lccIniInvementCostOthers;
		this.lccTotalIniInvestmentCost = lccTotalIniInvestmentCost;
		this.lccOperMaintAnnOpPatro17 = lccOperMaintAnnOpPatro17;
		this.lccOperMaintAnnOpPatro18 = lccOperMaintAnnOpPatro18;
		this.lccOperMaintAnnOpPatro19 = lccOperMaintAnnOpPatro19;
		this.lccOperMaintAnnOpPatro20 = lccOperMaintAnnOpPatro20;
		this.lccOperMaintAnnOpPatro21 = lccOperMaintAnnOpPatro21;
		this.lccOperMaintAnnOpEchec17 = lccOperMaintAnnOpEchec17;
		this.lccOperMaintAnnOpEchec18 = lccOperMaintAnnOpEchec18;
		this.lccOperMaintAnnOpEchec19 = lccOperMaintAnnOpEchec19;
		this.lccOperMaintAnnOpEchec20 = lccOperMaintAnnOpEchec20;
		this.lccOperMaintAnnOpEchec21 = lccOperMaintAnnOpEchec21;
		this.lccOperMaintAnnOpeTota17 = lccOperMaintAnnOpeTota17;
		this.lccOperMaintAnnOpeTota18 = lccOperMaintAnnOpeTota18;
		this.lccOperMaintAnnOpeTota19 = lccOperMaintAnnOpeTota19;
		this.lccOperMaintAnnOpeTota20 = lccOperMaintAnnOpeTota20;
		this.lccOperMaintAnnOpeTota21 = lccOperMaintAnnOpeTota21;
		this.lccOperMaintAnnRepOver17 = lccOperMaintAnnRepOver17;
		this.lccOperMaintAnnRepOver18 = lccOperMaintAnnRepOver18;
		this.lccOperMaintAnnRepOver19 = lccOperMaintAnnRepOver19;
		this.lccOperMaintAnnRepOver20 = lccOperMaintAnnRepOver20;
		this.lccOperMaintAnnRepOver21 = lccOperMaintAnnRepOver21;
		this.lccOperMaintAnnRepDefe17 = lccOperMaintAnnRepDefe17;
		this.lccOperMaintAnnRepDefe18 = lccOperMaintAnnRepDefe18;
		this.lccOperMaintAnnRepDefe19 = lccOperMaintAnnRepDefe19;
		this.lccOperMaintAnnRepDefe20 = lccOperMaintAnnRepDefe20;
		this.lccOperMaintAnnRepDefe21 = lccOperMaintAnnRepDefe21;
		this.lccOperMaintAnnRepTota17 = lccOperMaintAnnRepTota17;
		this.lccOperMaintAnnRepTota18 = lccOperMaintAnnRepTota18;
		this.lccOperMaintAnnRepTota19 = lccOperMaintAnnRepTota19;
		this.lccOperMaintAnnRepTota20 = lccOperMaintAnnRepTota20;
		this.lccOperMaintAnnRepTota21 = lccOperMaintAnnRepTota21;
		this.lccOperMaintAnnFaiCost17 = lccOperMaintAnnFaiCost17;
		this.lccOperMaintAnnFaiCost18 = lccOperMaintAnnFaiCost18;
		this.lccOperMaintAnnFaiCost19 = lccOperMaintAnnFaiCost19;
		this.lccOperMaintAnnFaiCost20 = lccOperMaintAnnFaiCost20;
		this.lccOperMaintAnnFaiCost21 = lccOperMaintAnnFaiCost21;
		this.lccOperMaintTotalCost2017 = lccOperMaintTotalCost2017;
		this.lccOperMaintTotalCost2018 = lccOperMaintTotalCost2018;
		this.lccOperMaintTotalCost2019 = lccOperMaintTotalCost2019;
		this.lccOperMaintTotalCost2020 = lccOperMaintTotalCost2020;
		this.lccOperMaintTotalCost2021 = lccOperMaintTotalCost2021;
		this.lccOperMaintCostLatest5y = lccOperMaintCostLatest5y;
		this.lccTechTransformaInves2017 = lccTechTransformaInves2017;
		this.lccTechTransformaInves2018 = lccTechTransformaInves2018;
		this.lccTechTransformaInves2019 = lccTechTransformaInves2019;
		this.lccTechTransformaInves2020 = lccTechTransformaInves2020;
		this.lccTechTransformaInves2021 = lccTechTransformaInves2021;
		this.lccAbandonCostDisposIncome = lccAbandonCostDisposIncome;
		this.lccAbandonCostDisposCost = lccAbandonCostDisposCost;
	}

	// Property accessors
	public String getOElectricReactorCollectId() {
		return this.OElectricReactorCollectId;
	}

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public void setOElectricReactorCollectId(String OElectricReactorCollectId) {
		this.OElectricReactorCollectId = OElectricReactorCollectId;
	}

	public String getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getProjectType() {
		return this.projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public Date getOperationDate() {
		return this.operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public String getInsulatingMedium() {
		return this.insulatingMedium;
	}

	public void setInsulatingMedium(String insulatingMedium) {
		this.insulatingMedium = insulatingMedium;
	}

	public String getInstallationMode() {
		return this.installationMode;
	}

	public void setInstallationMode(String installationMode) {
		this.installationMode = installationMode;
	}

	public String getAccessMode() {
		return this.accessMode;
	}

	public void setAccessMode(String accessMode) {
		this.accessMode = accessMode;
	}

	public String getCoolingMode() {
		return this.coolingMode;
	}

	public void setCoolingMode(String coolingMode) {
		this.coolingMode = coolingMode;
	}

	public String getVoltageRegulationMode() {
		return this.voltageRegulationMode;
	}

	public void setVoltageRegulationMode(String voltageRegulationMode) {
		this.voltageRegulationMode = voltageRegulationMode;
	}

	public String getWhetherRuralPowerNetwork() {
		return this.whetherRuralPowerNetwork;
	}

	public void setWhetherRuralPowerNetwork(String whetherRuralPowerNetwork) {
		this.whetherRuralPowerNetwork = whetherRuralPowerNetwork;
	}

	public String getRatedVoltage() {
		return this.ratedVoltage;
	}

	public void setRatedVoltage(String ratedVoltage) {
		this.ratedVoltage = ratedVoltage;
	}

	public Double getRatedCurrent() {
		return this.ratedCurrent;
	}

	public void setRatedCurrent(Double ratedCurrent) {
		this.ratedCurrent = ratedCurrent;
	}

	public Double getRatedFrequency() {
		return this.ratedFrequency;
	}

	public void setRatedFrequency(Double ratedFrequency) {
		this.ratedFrequency = ratedFrequency;
	}

	public Double getRatedCapacity() {
		return this.ratedCapacity;
	}

	public void setRatedCapacity(Double ratedCapacity) {
		this.ratedCapacity = ratedCapacity;
	}

	public Double getRatedReactance() {
		return this.ratedReactance;
	}

	public void setRatedReactance(Double ratedReactance) {
		this.ratedReactance = ratedReactance;
	}

	public Double getRatedReactanceRate() {
		return this.ratedReactanceRate;
	}

	public void setRatedReactanceRate(Double ratedReactanceRate) {
		this.ratedReactanceRate = ratedReactanceRate;
	}

	public Double getRatedInductance() {
		return this.ratedInductance;
	}

	public void setRatedInductance(Double ratedInductance) {
		this.ratedInductance = ratedInductance;
	}

	public String getAssetId() {
		return this.assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getPhysicalId() {
		return this.physicalId;
	}

	public void setPhysicalId(String physicalId) {
		this.physicalId = physicalId;
	}

	public String getPmId() {
		return this.pmId;
	}

	public void setPmId(String pmId) {
		this.pmId = pmId;
	}

	public String getBelongLocalCityCompany() {
		return this.belongLocalCityCompany;
	}

	public void setBelongLocalCityCompany(String belongLocalCityCompany) {
		this.belongLocalCityCompany = belongLocalCityCompany;
	}

	public String getBelongSubstation() {
		return this.belongSubstation;
	}

	public void setBelongSubstation(String belongSubstation) {
		this.belongSubstation = belongSubstation;
	}

	public String getUseEnvironment() {
		return this.useEnvironment;
	}

	public void setUseEnvironment(String useEnvironment) {
		this.useEnvironment = useEnvironment;
	}

	public Double getWorkingAge() {
		return this.workingAge;
	}

	public void setWorkingAge(Double workingAge) {
		this.workingAge = workingAge;
	}

	public Double getLifeCycle() {
		return this.lifeCycle;
	}

	public void setLifeCycle(Double lifeCycle) {
		this.lifeCycle = lifeCycle;
	}

	public Double getAverageAnnualInterestRate() {
		return this.averageAnnualInterestRate;
	}

	public void setAverageAnnualInterestRate(Double averageAnnualInterestRate) {
		this.averageAnnualInterestRate = averageAnnualInterestRate;
	}

	public Double getLifeCycleCost() {
		return this.lifeCycleCost;
	}

	public void setLifeCycleCost(Double lifeCycleCost) {
		this.lifeCycleCost = lifeCycleCost;
	}

	public Double getLccIniInvesCostEquipValue() {
		return this.lccIniInvesCostEquipValue;
	}

	public void setLccIniInvesCostEquipValue(Double lccIniInvesCostEquipValue) {
		this.lccIniInvesCostEquipValue = lccIniInvesCostEquipValue;
	}

	public Double getLccIniInvesCostInstalCost() {
		return this.lccIniInvesCostInstalCost;
	}

	public void setLccIniInvesCostInstalCost(Double lccIniInvesCostInstalCost) {
		this.lccIniInvesCostInstalCost = lccIniInvesCostInstalCost;
	}

	public Double getLccIniInvementCostOthers() {
		return this.lccIniInvementCostOthers;
	}

	public void setLccIniInvementCostOthers(Double lccIniInvementCostOthers) {
		this.lccIniInvementCostOthers = lccIniInvementCostOthers;
	}

	public Double getLccTotalIniInvestmentCost() {
		return this.lccTotalIniInvestmentCost;
	}

	public void setLccTotalIniInvestmentCost(Double lccTotalIniInvestmentCost) {
		this.lccTotalIniInvestmentCost = lccTotalIniInvestmentCost;
	}

	public Double getLccOperMaintAnnOpPatro17() {
		return this.lccOperMaintAnnOpPatro17;
	}

	public void setLccOperMaintAnnOpPatro17(Double lccOperMaintAnnOpPatro17) {
		this.lccOperMaintAnnOpPatro17 = lccOperMaintAnnOpPatro17;
	}

	public Double getLccOperMaintAnnOpPatro18() {
		return this.lccOperMaintAnnOpPatro18;
	}

	public void setLccOperMaintAnnOpPatro18(Double lccOperMaintAnnOpPatro18) {
		this.lccOperMaintAnnOpPatro18 = lccOperMaintAnnOpPatro18;
	}

	public Double getLccOperMaintAnnOpPatro19() {
		return this.lccOperMaintAnnOpPatro19;
	}

	public void setLccOperMaintAnnOpPatro19(Double lccOperMaintAnnOpPatro19) {
		this.lccOperMaintAnnOpPatro19 = lccOperMaintAnnOpPatro19;
	}

	public Double getLccOperMaintAnnOpPatro20() {
		return this.lccOperMaintAnnOpPatro20;
	}

	public void setLccOperMaintAnnOpPatro20(Double lccOperMaintAnnOpPatro20) {
		this.lccOperMaintAnnOpPatro20 = lccOperMaintAnnOpPatro20;
	}

	public Double getLccOperMaintAnnOpPatro21() {
		return this.lccOperMaintAnnOpPatro21;
	}

	public void setLccOperMaintAnnOpPatro21(Double lccOperMaintAnnOpPatro21) {
		this.lccOperMaintAnnOpPatro21 = lccOperMaintAnnOpPatro21;
	}

	public Double getLccOperMaintAnnOpEchec17() {
		return this.lccOperMaintAnnOpEchec17;
	}

	public void setLccOperMaintAnnOpEchec17(Double lccOperMaintAnnOpEchec17) {
		this.lccOperMaintAnnOpEchec17 = lccOperMaintAnnOpEchec17;
	}

	public Double getLccOperMaintAnnOpEchec18() {
		return this.lccOperMaintAnnOpEchec18;
	}

	public void setLccOperMaintAnnOpEchec18(Double lccOperMaintAnnOpEchec18) {
		this.lccOperMaintAnnOpEchec18 = lccOperMaintAnnOpEchec18;
	}

	public Double getLccOperMaintAnnOpEchec19() {
		return this.lccOperMaintAnnOpEchec19;
	}

	public void setLccOperMaintAnnOpEchec19(Double lccOperMaintAnnOpEchec19) {
		this.lccOperMaintAnnOpEchec19 = lccOperMaintAnnOpEchec19;
	}

	public Double getLccOperMaintAnnOpEchec20() {
		return this.lccOperMaintAnnOpEchec20;
	}

	public void setLccOperMaintAnnOpEchec20(Double lccOperMaintAnnOpEchec20) {
		this.lccOperMaintAnnOpEchec20 = lccOperMaintAnnOpEchec20;
	}

	public Double getLccOperMaintAnnOpEchec21() {
		return this.lccOperMaintAnnOpEchec21;
	}

	public void setLccOperMaintAnnOpEchec21(Double lccOperMaintAnnOpEchec21) {
		this.lccOperMaintAnnOpEchec21 = lccOperMaintAnnOpEchec21;
	}

	public Double getLccOperMaintAnnOpeTota17() {
		return this.lccOperMaintAnnOpeTota17;
	}

	public void setLccOperMaintAnnOpeTota17(Double lccOperMaintAnnOpeTota17) {
		this.lccOperMaintAnnOpeTota17 = lccOperMaintAnnOpeTota17;
	}

	public Double getLccOperMaintAnnOpeTota18() {
		return this.lccOperMaintAnnOpeTota18;
	}

	public void setLccOperMaintAnnOpeTota18(Double lccOperMaintAnnOpeTota18) {
		this.lccOperMaintAnnOpeTota18 = lccOperMaintAnnOpeTota18;
	}

	public Double getLccOperMaintAnnOpeTota19() {
		return this.lccOperMaintAnnOpeTota19;
	}

	public void setLccOperMaintAnnOpeTota19(Double lccOperMaintAnnOpeTota19) {
		this.lccOperMaintAnnOpeTota19 = lccOperMaintAnnOpeTota19;
	}

	public Double getLccOperMaintAnnOpeTota20() {
		return this.lccOperMaintAnnOpeTota20;
	}

	public void setLccOperMaintAnnOpeTota20(Double lccOperMaintAnnOpeTota20) {
		this.lccOperMaintAnnOpeTota20 = lccOperMaintAnnOpeTota20;
	}

	public Double getLccOperMaintAnnOpeTota21() {
		return this.lccOperMaintAnnOpeTota21;
	}

	public void setLccOperMaintAnnOpeTota21(Double lccOperMaintAnnOpeTota21) {
		this.lccOperMaintAnnOpeTota21 = lccOperMaintAnnOpeTota21;
	}

	public Double getLccOperMaintAnnRepOver17() {
		return this.lccOperMaintAnnRepOver17;
	}

	public void setLccOperMaintAnnRepOver17(Double lccOperMaintAnnRepOver17) {
		this.lccOperMaintAnnRepOver17 = lccOperMaintAnnRepOver17;
	}

	public Double getLccOperMaintAnnRepOver18() {
		return this.lccOperMaintAnnRepOver18;
	}

	public void setLccOperMaintAnnRepOver18(Double lccOperMaintAnnRepOver18) {
		this.lccOperMaintAnnRepOver18 = lccOperMaintAnnRepOver18;
	}

	public Double getLccOperMaintAnnRepOver19() {
		return this.lccOperMaintAnnRepOver19;
	}

	public void setLccOperMaintAnnRepOver19(Double lccOperMaintAnnRepOver19) {
		this.lccOperMaintAnnRepOver19 = lccOperMaintAnnRepOver19;
	}

	public Double getLccOperMaintAnnRepOver20() {
		return this.lccOperMaintAnnRepOver20;
	}

	public void setLccOperMaintAnnRepOver20(Double lccOperMaintAnnRepOver20) {
		this.lccOperMaintAnnRepOver20 = lccOperMaintAnnRepOver20;
	}

	public Double getLccOperMaintAnnRepOver21() {
		return this.lccOperMaintAnnRepOver21;
	}

	public void setLccOperMaintAnnRepOver21(Double lccOperMaintAnnRepOver21) {
		this.lccOperMaintAnnRepOver21 = lccOperMaintAnnRepOver21;
	}

	public Double getLccOperMaintAnnRepDefe17() {
		return this.lccOperMaintAnnRepDefe17;
	}

	public void setLccOperMaintAnnRepDefe17(Double lccOperMaintAnnRepDefe17) {
		this.lccOperMaintAnnRepDefe17 = lccOperMaintAnnRepDefe17;
	}

	public Double getLccOperMaintAnnRepDefe18() {
		return this.lccOperMaintAnnRepDefe18;
	}

	public void setLccOperMaintAnnRepDefe18(Double lccOperMaintAnnRepDefe18) {
		this.lccOperMaintAnnRepDefe18 = lccOperMaintAnnRepDefe18;
	}

	public Double getLccOperMaintAnnRepDefe19() {
		return this.lccOperMaintAnnRepDefe19;
	}

	public void setLccOperMaintAnnRepDefe19(Double lccOperMaintAnnRepDefe19) {
		this.lccOperMaintAnnRepDefe19 = lccOperMaintAnnRepDefe19;
	}

	public Double getLccOperMaintAnnRepDefe20() {
		return this.lccOperMaintAnnRepDefe20;
	}

	public void setLccOperMaintAnnRepDefe20(Double lccOperMaintAnnRepDefe20) {
		this.lccOperMaintAnnRepDefe20 = lccOperMaintAnnRepDefe20;
	}

	public Double getLccOperMaintAnnRepDefe21() {
		return this.lccOperMaintAnnRepDefe21;
	}

	public void setLccOperMaintAnnRepDefe21(Double lccOperMaintAnnRepDefe21) {
		this.lccOperMaintAnnRepDefe21 = lccOperMaintAnnRepDefe21;
	}

	public Double getLccOperMaintAnnRepTota17() {
		return this.lccOperMaintAnnRepTota17;
	}

	public void setLccOperMaintAnnRepTota17(Double lccOperMaintAnnRepTota17) {
		this.lccOperMaintAnnRepTota17 = lccOperMaintAnnRepTota17;
	}

	public Double getLccOperMaintAnnRepTota18() {
		return this.lccOperMaintAnnRepTota18;
	}

	public void setLccOperMaintAnnRepTota18(Double lccOperMaintAnnRepTota18) {
		this.lccOperMaintAnnRepTota18 = lccOperMaintAnnRepTota18;
	}

	public Double getLccOperMaintAnnRepTota19() {
		return this.lccOperMaintAnnRepTota19;
	}

	public void setLccOperMaintAnnRepTota19(Double lccOperMaintAnnRepTota19) {
		this.lccOperMaintAnnRepTota19 = lccOperMaintAnnRepTota19;
	}

	public Double getLccOperMaintAnnRepTota20() {
		return this.lccOperMaintAnnRepTota20;
	}

	public void setLccOperMaintAnnRepTota20(Double lccOperMaintAnnRepTota20) {
		this.lccOperMaintAnnRepTota20 = lccOperMaintAnnRepTota20;
	}

	public Double getLccOperMaintAnnRepTota21() {
		return this.lccOperMaintAnnRepTota21;
	}

	public void setLccOperMaintAnnRepTota21(Double lccOperMaintAnnRepTota21) {
		this.lccOperMaintAnnRepTota21 = lccOperMaintAnnRepTota21;
	}

	public Double getLccOperMaintAnnFaiCost17() {
		return this.lccOperMaintAnnFaiCost17;
	}

	public void setLccOperMaintAnnFaiCost17(Double lccOperMaintAnnFaiCost17) {
		this.lccOperMaintAnnFaiCost17 = lccOperMaintAnnFaiCost17;
	}

	public Double getLccOperMaintAnnFaiCost18() {
		return this.lccOperMaintAnnFaiCost18;
	}

	public void setLccOperMaintAnnFaiCost18(Double lccOperMaintAnnFaiCost18) {
		this.lccOperMaintAnnFaiCost18 = lccOperMaintAnnFaiCost18;
	}

	public Double getLccOperMaintAnnFaiCost19() {
		return this.lccOperMaintAnnFaiCost19;
	}

	public void setLccOperMaintAnnFaiCost19(Double lccOperMaintAnnFaiCost19) {
		this.lccOperMaintAnnFaiCost19 = lccOperMaintAnnFaiCost19;
	}

	public Double getLccOperMaintAnnFaiCost20() {
		return this.lccOperMaintAnnFaiCost20;
	}

	public void setLccOperMaintAnnFaiCost20(Double lccOperMaintAnnFaiCost20) {
		this.lccOperMaintAnnFaiCost20 = lccOperMaintAnnFaiCost20;
	}

	public Double getLccOperMaintAnnFaiCost21() {
		return this.lccOperMaintAnnFaiCost21;
	}

	public void setLccOperMaintAnnFaiCost21(Double lccOperMaintAnnFaiCost21) {
		this.lccOperMaintAnnFaiCost21 = lccOperMaintAnnFaiCost21;
	}

	public Double getLccOperMaintTotalCost2017() {
		return this.lccOperMaintTotalCost2017;
	}

	public void setLccOperMaintTotalCost2017(Double lccOperMaintTotalCost2017) {
		this.lccOperMaintTotalCost2017 = lccOperMaintTotalCost2017;
	}

	public Double getLccOperMaintTotalCost2018() {
		return this.lccOperMaintTotalCost2018;
	}

	public void setLccOperMaintTotalCost2018(Double lccOperMaintTotalCost2018) {
		this.lccOperMaintTotalCost2018 = lccOperMaintTotalCost2018;
	}

	public Double getLccOperMaintTotalCost2019() {
		return this.lccOperMaintTotalCost2019;
	}

	public void setLccOperMaintTotalCost2019(Double lccOperMaintTotalCost2019) {
		this.lccOperMaintTotalCost2019 = lccOperMaintTotalCost2019;
	}

	public Double getLccOperMaintTotalCost2020() {
		return this.lccOperMaintTotalCost2020;
	}

	public void setLccOperMaintTotalCost2020(Double lccOperMaintTotalCost2020) {
		this.lccOperMaintTotalCost2020 = lccOperMaintTotalCost2020;
	}

	public Double getLccOperMaintTotalCost2021() {
		return this.lccOperMaintTotalCost2021;
	}

	public void setLccOperMaintTotalCost2021(Double lccOperMaintTotalCost2021) {
		this.lccOperMaintTotalCost2021 = lccOperMaintTotalCost2021;
	}

	public Double getLccOperMaintCostLatest5y() {
		return this.lccOperMaintCostLatest5y;
	}

	public void setLccOperMaintCostLatest5y(Double lccOperMaintCostLatest5y) {
		this.lccOperMaintCostLatest5y = lccOperMaintCostLatest5y;
	}

	public Double getLccTechTransformaInves2017() {
		return this.lccTechTransformaInves2017;
	}

	public void setLccTechTransformaInves2017(Double lccTechTransformaInves2017) {
		this.lccTechTransformaInves2017 = lccTechTransformaInves2017;
	}

	public Double getLccTechTransformaInves2018() {
		return this.lccTechTransformaInves2018;
	}

	public void setLccTechTransformaInves2018(Double lccTechTransformaInves2018) {
		this.lccTechTransformaInves2018 = lccTechTransformaInves2018;
	}

	public Double getLccTechTransformaInves2019() {
		return this.lccTechTransformaInves2019;
	}

	public void setLccTechTransformaInves2019(Double lccTechTransformaInves2019) {
		this.lccTechTransformaInves2019 = lccTechTransformaInves2019;
	}

	public Double getLccTechTransformaInves2020() {
		return this.lccTechTransformaInves2020;
	}

	public void setLccTechTransformaInves2020(Double lccTechTransformaInves2020) {
		this.lccTechTransformaInves2020 = lccTechTransformaInves2020;
	}

	public Double getLccTechTransformaInves2021() {
		return this.lccTechTransformaInves2021;
	}

	public void setLccTechTransformaInves2021(Double lccTechTransformaInves2021) {
		this.lccTechTransformaInves2021 = lccTechTransformaInves2021;
	}

	public Double getLccAbandonCostDisposIncome() {
		return this.lccAbandonCostDisposIncome;
	}

	public void setLccAbandonCostDisposIncome(Double lccAbandonCostDisposIncome) {
		this.lccAbandonCostDisposIncome = lccAbandonCostDisposIncome;
	}

	public Double getLccAbandonCostDisposCost() {
		return this.lccAbandonCostDisposCost;
	}

	public void setLccAbandonCostDisposCost(Double lccAbandonCostDisposCost) {
		this.lccAbandonCostDisposCost = lccAbandonCostDisposCost;
	}

}