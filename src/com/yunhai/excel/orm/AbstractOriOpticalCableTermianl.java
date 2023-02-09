package com.yunhai.excel.orm;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractOriOpticalCableTermianl entity provides the base persistence
 * definition of the OriOpticalCableTermianl entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractOriOpticalCableTermianl implements java.io.Serializable {

	// Fields

	private String oriOpticalCableTermianlId;
	private String globalName;
	private String name;
	private String abbreviation;
	private String subordinateComputerRoom;
	private String erpAssetCoding;
	private String erpEquipmentAccountCoding;
	private String subordinateSite;
	private String subordinateSystem;
	private String manufacturer;
	private String manufacturerEquipmentType;
	private Date commissioningDate;
	private String workingState;
	private String jurisdictionRightOrg;
	private String dataMaintenanceOrg;
	private String propertyRightsOrg;
	private String statisticalOrg;
	private String defender;
	private String warningSurveillanceOrg;
	private String technicalSystem;
	private String equipmentType;
	private String maximumCapacity;
	private String actualConfigurationMaxRate;
	private String transportNetworkElementType;
	private String dataVersion;
	private String dataSourceFile;
	// Constructors

	/** default constructor */
	public AbstractOriOpticalCableTermianl() {
	}

	/** minimal constructor */
	public AbstractOriOpticalCableTermianl(String oriOpticalCableTermianlId) {
		this.oriOpticalCableTermianlId = oriOpticalCableTermianlId;
	}

	/** full constructor */
	public AbstractOriOpticalCableTermianl(String oriOpticalCableTermianlId, String globalName, String name,
			String abbreviation, String subordinateComputerRoom, String erpAssetCoding,
			String erpEquipmentAccountCoding, String subordinateSite, String subordinateSystem, String manufacturer,
			String manufacturerEquipmentType, Date commissioningDate, String workingState, String jurisdictionRightOrg,
			String dataMaintenanceOrg, String propertyRightsOrg, String statisticalOrg, String defender,
			String warningSurveillanceOrg, String technicalSystem, String equipmentType, String maximumCapacity,
			String actualConfigurationMaxRate, String transportNetworkElementType, String dataVersion,
			String dataSourceFile) {
		this.oriOpticalCableTermianlId = oriOpticalCableTermianlId;
		this.globalName = globalName;
		this.name = name;
		this.abbreviation = abbreviation;
		this.subordinateComputerRoom = subordinateComputerRoom;
		this.erpAssetCoding = erpAssetCoding;
		this.erpEquipmentAccountCoding = erpEquipmentAccountCoding;
		this.subordinateSite = subordinateSite;
		this.subordinateSystem = subordinateSystem;
		this.manufacturer = manufacturer;
		this.manufacturerEquipmentType = manufacturerEquipmentType;
		this.commissioningDate = commissioningDate;
		this.workingState = workingState;
		this.jurisdictionRightOrg = jurisdictionRightOrg;
		this.dataMaintenanceOrg = dataMaintenanceOrg;
		this.propertyRightsOrg = propertyRightsOrg;
		this.statisticalOrg = statisticalOrg;
		this.defender = defender;
		this.warningSurveillanceOrg = warningSurveillanceOrg;
		this.technicalSystem = technicalSystem;
		this.equipmentType = equipmentType;
		this.maximumCapacity = maximumCapacity;
		this.actualConfigurationMaxRate = actualConfigurationMaxRate;
		this.transportNetworkElementType = transportNetworkElementType;
		this.dataVersion = dataVersion;
		this.dataSourceFile = dataSourceFile; 
	}

	// Property accessors

	public String getDataVersion() {
		return dataVersion;
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

	public String getOriOpticalCableTermianlId() {
		return this.oriOpticalCableTermianlId;
	}

	public void setOriOpticalCableTermianlId(String oriOpticalCableTermianlId) {
		this.oriOpticalCableTermianlId = oriOpticalCableTermianlId;
	}

	public String getGlobalName() {
		return this.globalName;
	}

	public void setGlobalName(String globalName) {
		this.globalName = globalName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getSubordinateComputerRoom() {
		return this.subordinateComputerRoom;
	}

	public void setSubordinateComputerRoom(String subordinateComputerRoom) {
		this.subordinateComputerRoom = subordinateComputerRoom;
	}

	public String getErpAssetCoding() {
		return this.erpAssetCoding;
	}

	public void setErpAssetCoding(String erpAssetCoding) {
		this.erpAssetCoding = erpAssetCoding;
	}

	public String getErpEquipmentAccountCoding() {
		return this.erpEquipmentAccountCoding;
	}

	public void setErpEquipmentAccountCoding(String erpEquipmentAccountCoding) {
		this.erpEquipmentAccountCoding = erpEquipmentAccountCoding;
	}

	public String getSubordinateSite() {
		return this.subordinateSite;
	}

	public void setSubordinateSite(String subordinateSite) {
		this.subordinateSite = subordinateSite;
	}

	public String getSubordinateSystem() {
		return this.subordinateSystem;
	}

	public void setSubordinateSystem(String subordinateSystem) {
		this.subordinateSystem = subordinateSystem;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturerEquipmentType() {
		return this.manufacturerEquipmentType;
	}

	public void setManufacturerEquipmentType(String manufacturerEquipmentType) {
		this.manufacturerEquipmentType = manufacturerEquipmentType;
	}

	public Date getCommissioningDate() {
		return this.commissioningDate;
	}

	public void setCommissioningDate(Date commissioningDate) {
		this.commissioningDate = commissioningDate;
	}

	public String getWorkingState() {
		return this.workingState;
	}

	public void setWorkingState(String workingState) {
		this.workingState = workingState;
	}

	public String getJurisdictionRightOrg() {
		return this.jurisdictionRightOrg;
	}

	public void setJurisdictionRightOrg(String jurisdictionRightOrg) {
		this.jurisdictionRightOrg = jurisdictionRightOrg;
	}

	public String getDataMaintenanceOrg() {
		return this.dataMaintenanceOrg;
	}

	public void setDataMaintenanceOrg(String dataMaintenanceOrg) {
		this.dataMaintenanceOrg = dataMaintenanceOrg;
	}

	public String getPropertyRightsOrg() {
		return this.propertyRightsOrg;
	}

	public void setPropertyRightsOrg(String propertyRightsOrg) {
		this.propertyRightsOrg = propertyRightsOrg;
	}

	public String getStatisticalOrg() {
		return this.statisticalOrg;
	}

	public void setStatisticalOrg(String statisticalOrg) {
		this.statisticalOrg = statisticalOrg;
	}

	public String getDefender() {
		return this.defender;
	}

	public void setDefender(String defender) {
		this.defender = defender;
	}

	public String getWarningSurveillanceOrg() {
		return this.warningSurveillanceOrg;
	}

	public void setWarningSurveillanceOrg(String warningSurveillanceOrg) {
		this.warningSurveillanceOrg = warningSurveillanceOrg;
	}

	public String getTechnicalSystem() {
		return this.technicalSystem;
	}

	public void setTechnicalSystem(String technicalSystem) {
		this.technicalSystem = technicalSystem;
	}

	public String getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getMaximumCapacity() {
		return this.maximumCapacity;
	}

	public void setMaximumCapacity(String maximumCapacity) {
		this.maximumCapacity = maximumCapacity;
	}

	public String getActualConfigurationMaxRate() {
		return this.actualConfigurationMaxRate;
	}

	public void setActualConfigurationMaxRate(String actualConfigurationMaxRate) {
		this.actualConfigurationMaxRate = actualConfigurationMaxRate;
	}

	public String getTransportNetworkElementType() {
		return this.transportNetworkElementType;
	}

	public void setTransportNetworkElementType(String transportNetworkElementType) {
		this.transportNetworkElementType = transportNetworkElementType;
	}

}