package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriOpticalCableSection entity provides the base persistence
 * definition of the OriOpticalCableSection entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriOpticalCableSection implements java.io.Serializable {

	// Fields

	private String oriOpticalCableSectionId;
	private Date calYear;
	private String objId;
	private String opticalCableSectionName;
	private String subordinateOpticalCable;
	private String opticalCableStatus;
	private Double totalCoresNumber;
	private Double usedCoresNumber;
	private Double availableCoreNumber;
	private Double opticalCableLengthKm;
	private Date commissioningDate;
	private String belongAreas;
	private String opticalCableType;
	private String voltageLevel;
	private String pmsVoltageLevel;
	private String primaryLineName;
	private String pmsPrimaryLineName;
	private String layingType;
	private String layingMethod;
	private String threeSpanSituation;
	private String opticalCableStartPointType;
	private String optCabSectStartPointType;
	private String optCabSectStartPointResou;
	private String opticalCableEndpointType;
	private String optCableSectEndpointType;
	private String optCableEndpointResources;
	private String optCableSectEndpointResou;
	private String rightJurisdictionUnderOrg;
	private String maintenanceOrg;
	private String statisticalOrg;
	private String propertyRightsOrg;
	

	private String globalName;
	private String abbreviation;
	private String model;
	private String defender;
	private String contactNumber;
	private String whetIntraStationOptiCable;
	private String manufacturer;
	private String dataMaintenanceOrg; 
	
	private String dataVersion;
	private String dataSourceFile;

	// Constructors

	/** default constructor */
	public AbstractOriOpticalCableSection() {
	}

	/** minimal constructor */
	public AbstractOriOpticalCableSection(String oriOpticalCableSectionId) {
		this.oriOpticalCableSectionId = oriOpticalCableSectionId;
	}

	/** full constructor */
	public AbstractOriOpticalCableSection(String oriOpticalCableSectionId, String objId, String opticalCableSectionName,
			String subordinateOpticalCable, String opticalCableStatus, Double totalCoresNumber, Double usedCoresNumber,
			Double availableCoreNumber, Double opticalCableLengthKm, Date commissioningDate, String belongAreas,
			String opticalCableType, String voltageLevel, String pmsVoltageLevel, String primaryLineName,
			String pmsPrimaryLineName, String layingType, String layingMethod, String threeSpanSituation,
			String opticalCableStartPointType, String optCabSectStartPointType, String optCabSectStartPointResou,
			String opticalCableEndpointType, String optCableSectEndpointType, String optCableEndpointResources,
			String optCableSectEndpointResou, String rightJurisdictionUnderOrg, String maintenanceOrg,
			String statisticalOrg, String propertyRightsOrg, String dataVersion, String dataSourceFile) {
		this.oriOpticalCableSectionId = oriOpticalCableSectionId;
		this.objId = objId;
		this.opticalCableSectionName = opticalCableSectionName;
		this.subordinateOpticalCable = subordinateOpticalCable;
		this.opticalCableStatus = opticalCableStatus;
		this.totalCoresNumber = totalCoresNumber;
		this.usedCoresNumber = usedCoresNumber;
		this.availableCoreNumber = availableCoreNumber;
		this.opticalCableLengthKm = opticalCableLengthKm;
		this.commissioningDate = commissioningDate;
		this.belongAreas = belongAreas;
		this.opticalCableType = opticalCableType;
		this.voltageLevel = voltageLevel;
		this.pmsVoltageLevel = pmsVoltageLevel;
		this.primaryLineName = primaryLineName;
		this.pmsPrimaryLineName = pmsPrimaryLineName;
		this.layingType = layingType;
		this.layingMethod = layingMethod;
		this.threeSpanSituation = threeSpanSituation;
		this.opticalCableStartPointType = opticalCableStartPointType;
		this.optCabSectStartPointType = optCabSectStartPointType;
		this.optCabSectStartPointResou = optCabSectStartPointResou;
		this.opticalCableEndpointType = opticalCableEndpointType;
		this.optCableSectEndpointType = optCableSectEndpointType;
		this.optCableEndpointResources = optCableEndpointResources;
		this.optCableSectEndpointResou = optCableSectEndpointResou;
		this.rightJurisdictionUnderOrg = rightJurisdictionUnderOrg;
		this.maintenanceOrg = maintenanceOrg;
		this.statisticalOrg = statisticalOrg;
		this.propertyRightsOrg = propertyRightsOrg;
		this.dataVersion = dataVersion;
		this.dataSourceFile = dataSourceFile;

	}

	
	
	// Property accessors

	public AbstractOriOpticalCableSection(String oriOpticalCableSectionId, Date calYear, String objId,
			String opticalCableSectionName, String subordinateOpticalCable, String opticalCableStatus,
			Double totalCoresNumber, Double usedCoresNumber, Double availableCoreNumber, Double opticalCableLengthKm,
			Date commissioningDate, String belongAreas, String opticalCableType, String voltageLevel,
			String pmsVoltageLevel, String primaryLineName, String pmsPrimaryLineName, String layingType,
			String layingMethod, String threeSpanSituation, String opticalCableStartPointType,
			String optCabSectStartPointType, String optCabSectStartPointResou, String opticalCableEndpointType,
			String optCableSectEndpointType, String optCableEndpointResources, String optCableSectEndpointResou,
			String rightJurisdictionUnderOrg, String maintenanceOrg, String statisticalOrg, String propertyRightsOrg,
			String globalName, String abbreviation, String model, String defender, String contactNumber,
			String whetIntraStationOptiCable, String manufacturer, String dataMaintenanceOrg, String dataVersion,
			String dataSourceFile) {
		super();
		this.oriOpticalCableSectionId = oriOpticalCableSectionId;
		this.calYear = calYear;
		this.objId = objId;
		this.opticalCableSectionName = opticalCableSectionName;
		this.subordinateOpticalCable = subordinateOpticalCable;
		this.opticalCableStatus = opticalCableStatus;
		this.totalCoresNumber = totalCoresNumber;
		this.usedCoresNumber = usedCoresNumber;
		this.availableCoreNumber = availableCoreNumber;
		this.opticalCableLengthKm = opticalCableLengthKm;
		this.commissioningDate = commissioningDate;
		this.belongAreas = belongAreas;
		this.opticalCableType = opticalCableType;
		this.voltageLevel = voltageLevel;
		this.pmsVoltageLevel = pmsVoltageLevel;
		this.primaryLineName = primaryLineName;
		this.pmsPrimaryLineName = pmsPrimaryLineName;
		this.layingType = layingType;
		this.layingMethod = layingMethod;
		this.threeSpanSituation = threeSpanSituation;
		this.opticalCableStartPointType = opticalCableStartPointType;
		this.optCabSectStartPointType = optCabSectStartPointType;
		this.optCabSectStartPointResou = optCabSectStartPointResou;
		this.opticalCableEndpointType = opticalCableEndpointType;
		this.optCableSectEndpointType = optCableSectEndpointType;
		this.optCableEndpointResources = optCableEndpointResources;
		this.optCableSectEndpointResou = optCableSectEndpointResou;
		this.rightJurisdictionUnderOrg = rightJurisdictionUnderOrg;
		this.maintenanceOrg = maintenanceOrg;
		this.statisticalOrg = statisticalOrg;
		this.propertyRightsOrg = propertyRightsOrg;
		this.globalName = globalName;
		this.abbreviation = abbreviation;
		this.model = model;
		this.defender = defender;
		this.contactNumber = contactNumber;
		this.whetIntraStationOptiCable = whetIntraStationOptiCable;
		this.manufacturer = manufacturer;
		this.dataMaintenanceOrg = dataMaintenanceOrg;
		this.dataVersion = dataVersion;
		this.dataSourceFile = dataSourceFile;
	}

	public AbstractOriOpticalCableSection(String oriOpticalCableSectionId, String objId, String opticalCableSectionName,
			String subordinateOpticalCable, String opticalCableStatus, Double totalCoresNumber, Double usedCoresNumber,
			Double availableCoreNumber, Double opticalCableLengthKm, Date commissioningDate, String belongAreas,
			String opticalCableType, String voltageLevel, String pmsVoltageLevel, String primaryLineName,
			String pmsPrimaryLineName, String layingType, String layingMethod, String threeSpanSituation,
			String opticalCableStartPointType, String optCabSectStartPointType, String optCabSectStartPointResou,
			String opticalCableEndpointType, String optCableSectEndpointType, String optCableEndpointResources,
			String optCableSectEndpointResou, String rightJurisdictionUnderOrg, String maintenanceOrg,
			String statisticalOrg, String propertyRightsOrg, String globalName, String abbreviation, String model,
			String defender, String contactNumber, String whetIntraStationOptiCable, String manufacturer,
			String dataMaintenanceOrg, String dataVersion, String dataSourceFile) {
		super();
		this.oriOpticalCableSectionId = oriOpticalCableSectionId;
		this.objId = objId;
		this.opticalCableSectionName = opticalCableSectionName;
		this.subordinateOpticalCable = subordinateOpticalCable;
		this.opticalCableStatus = opticalCableStatus;
		this.totalCoresNumber = totalCoresNumber;
		this.usedCoresNumber = usedCoresNumber;
		this.availableCoreNumber = availableCoreNumber;
		this.opticalCableLengthKm = opticalCableLengthKm;
		this.commissioningDate = commissioningDate;
		this.belongAreas = belongAreas;
		this.opticalCableType = opticalCableType;
		this.voltageLevel = voltageLevel;
		this.pmsVoltageLevel = pmsVoltageLevel;
		this.primaryLineName = primaryLineName;
		this.pmsPrimaryLineName = pmsPrimaryLineName;
		this.layingType = layingType;
		this.layingMethod = layingMethod;
		this.threeSpanSituation = threeSpanSituation;
		this.opticalCableStartPointType = opticalCableStartPointType;
		this.optCabSectStartPointType = optCabSectStartPointType;
		this.optCabSectStartPointResou = optCabSectStartPointResou;
		this.opticalCableEndpointType = opticalCableEndpointType;
		this.optCableSectEndpointType = optCableSectEndpointType;
		this.optCableEndpointResources = optCableEndpointResources;
		this.optCableSectEndpointResou = optCableSectEndpointResou;
		this.rightJurisdictionUnderOrg = rightJurisdictionUnderOrg;
		this.maintenanceOrg = maintenanceOrg;
		this.statisticalOrg = statisticalOrg;
		this.propertyRightsOrg = propertyRightsOrg;
		this.globalName = globalName;
		this.abbreviation = abbreviation;
		this.model = model;
		this.defender = defender;
		this.contactNumber = contactNumber;
		this.whetIntraStationOptiCable = whetIntraStationOptiCable;
		this.manufacturer = manufacturer;
		this.dataMaintenanceOrg = dataMaintenanceOrg;
		this.dataVersion = dataVersion;
		this.dataSourceFile = dataSourceFile;
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

	public String getGlobalName() {
		return globalName;
	}

	public void setGlobalName(String globalName) {
		this.globalName = globalName;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDefender() {
		return defender;
	}

	public void setDefender(String defender) {
		this.defender = defender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getWhetIntraStationOptiCable() {
		return whetIntraStationOptiCable;
	}

	public void setWhetIntraStationOptiCable(String whetIntraStationOptiCable) {
		this.whetIntraStationOptiCable = whetIntraStationOptiCable;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDataMaintenanceOrg() {
		return dataMaintenanceOrg;
	}

	public void setDataMaintenanceOrg(String dataMaintenanceOrg) {
		this.dataMaintenanceOrg = dataMaintenanceOrg;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public String getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(String dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public String getOriOpticalCableSectionId() {
		return this.oriOpticalCableSectionId;
	}

	public void setOriOpticalCableSectionId(String oriOpticalCableSectionId) {
		this.oriOpticalCableSectionId = oriOpticalCableSectionId;
	}

	public String getObjId() {
		return this.objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getOpticalCableSectionName() {
		return this.opticalCableSectionName;
	}

	public void setOpticalCableSectionName(String opticalCableSectionName) {
		this.opticalCableSectionName = opticalCableSectionName;
	}

	public String getSubordinateOpticalCable() {
		return this.subordinateOpticalCable;
	}

	public void setSubordinateOpticalCable(String subordinateOpticalCable) {
		this.subordinateOpticalCable = subordinateOpticalCable;
	}

	public String getOpticalCableStatus() {
		return this.opticalCableStatus;
	}

	public void setOpticalCableStatus(String opticalCableStatus) {
		this.opticalCableStatus = opticalCableStatus;
	}

	public Double getTotalCoresNumber() {
		return this.totalCoresNumber;
	}

	public void setTotalCoresNumber(Double totalCoresNumber) {
		this.totalCoresNumber = totalCoresNumber;
	}

	public Double getUsedCoresNumber() {
		return this.usedCoresNumber;
	}

	public void setUsedCoresNumber(Double usedCoresNumber) {
		this.usedCoresNumber = usedCoresNumber;
	}

	public Double getAvailableCoreNumber() {
		return this.availableCoreNumber;
	}

	public void setAvailableCoreNumber(Double availableCoreNumber) {
		this.availableCoreNumber = availableCoreNumber;
	}

	public Double getOpticalCableLengthKm() {
		return this.opticalCableLengthKm;
	}

	public void setOpticalCableLengthKm(Double opticalCableLengthKm) {
		this.opticalCableLengthKm = opticalCableLengthKm;
	}

	public Date getCommissioningDate() {
		return this.commissioningDate;
	}

	public void setCommissioningDate(Date commissioningDate) {
		this.commissioningDate = commissioningDate;
	}

	public String getBelongAreas() {
		return this.belongAreas;
	}

	public void setBelongAreas(String belongAreas) {
		this.belongAreas = belongAreas;
	}

	public String getOpticalCableType() {
		return this.opticalCableType;
	}

	public void setOpticalCableType(String opticalCableType) {
		this.opticalCableType = opticalCableType;
	}

	public String getVoltageLevel() {
		return this.voltageLevel;
	}

	public void setVoltageLevel(String voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public String getPmsVoltageLevel() {
		return this.pmsVoltageLevel;
	}

	public void setPmsVoltageLevel(String pmsVoltageLevel) {
		this.pmsVoltageLevel = pmsVoltageLevel;
	}

	public String getPrimaryLineName() {
		return this.primaryLineName;
	}

	public void setPrimaryLineName(String primaryLineName) {
		this.primaryLineName = primaryLineName;
	}

	public String getPmsPrimaryLineName() {
		return this.pmsPrimaryLineName;
	}

	public void setPmsPrimaryLineName(String pmsPrimaryLineName) {
		this.pmsPrimaryLineName = pmsPrimaryLineName;
	}

	public String getLayingType() {
		return this.layingType;
	}

	public void setLayingType(String layingType) {
		this.layingType = layingType;
	}

	public String getLayingMethod() {
		return this.layingMethod;
	}

	public void setLayingMethod(String layingMethod) {
		this.layingMethod = layingMethod;
	}

	public String getThreeSpanSituation() {
		return this.threeSpanSituation;
	}

	public void setThreeSpanSituation(String threeSpanSituation) {
		this.threeSpanSituation = threeSpanSituation;
	}

	public String getOpticalCableStartPointType() {
		return this.opticalCableStartPointType;
	}

	public void setOpticalCableStartPointType(String opticalCableStartPointType) {
		this.opticalCableStartPointType = opticalCableStartPointType;
	}

	public String getOptCabSectStartPointType() {
		return this.optCabSectStartPointType;
	}

	public void setOptCabSectStartPointType(String optCabSectStartPointType) {
		this.optCabSectStartPointType = optCabSectStartPointType;
	}

	public String getOptCabSectStartPointResou() {
		return this.optCabSectStartPointResou;
	}

	public void setOptCabSectStartPointResou(String optCabSectStartPointResou) {
		this.optCabSectStartPointResou = optCabSectStartPointResou;
	}

	public String getOpticalCableEndpointType() {
		return this.opticalCableEndpointType;
	}

	public void setOpticalCableEndpointType(String opticalCableEndpointType) {
		this.opticalCableEndpointType = opticalCableEndpointType;
	}

	public String getOptCableSectEndpointType() {
		return this.optCableSectEndpointType;
	}

	public void setOptCableSectEndpointType(String optCableSectEndpointType) {
		this.optCableSectEndpointType = optCableSectEndpointType;
	}

	public String getOptCableEndpointResources() {
		return this.optCableEndpointResources;
	}

	public void setOptCableEndpointResources(String optCableEndpointResources) {
		this.optCableEndpointResources = optCableEndpointResources;
	}

	public String getOptCableSectEndpointResou() {
		return this.optCableSectEndpointResou;
	}

	public void setOptCableSectEndpointResou(String optCableSectEndpointResou) {
		this.optCableSectEndpointResou = optCableSectEndpointResou;
	}

	public String getRightJurisdictionUnderOrg() {
		return this.rightJurisdictionUnderOrg;
	}

	public void setRightJurisdictionUnderOrg(String rightJurisdictionUnderOrg) {
		this.rightJurisdictionUnderOrg = rightJurisdictionUnderOrg;
	}

	public String getMaintenanceOrg() {
		return this.maintenanceOrg;
	}

	public void setMaintenanceOrg(String maintenanceOrg) {
		this.maintenanceOrg = maintenanceOrg;
	}

	public String getStatisticalOrg() {
		return this.statisticalOrg;
	}

	public void setStatisticalOrg(String statisticalOrg) {
		this.statisticalOrg = statisticalOrg;
	}

	public String getPropertyRightsOrg() {
		return this.propertyRightsOrg;
	}

	public void setPropertyRightsOrg(String propertyRightsOrg) {
		this.propertyRightsOrg = propertyRightsOrg;
	}

}