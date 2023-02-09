package com.yunhai.excel.orm;

import java.util.Date;


/**
 * AbstractPmsItemDefectHebei entity provides the base persistence definition of the PmsItemDefectHebei entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPmsItemDefectHebei  implements java.io.Serializable {


    // Fields    

     private String pmsItemDefectId;
     private String version;
     private Date calYear;
     private String equipmentId;
     private String orgName;
     private String assetDetailClassCode;
     private String assetDetailClassDescription;
     private String defectId;
     private String defectHappenDepartment;
     private String substationLineName;
     private String defectMainEpuipName;
     private String defectContent;
     private String equipmentTypeCode;
     private String equipmentType;
     private Long deliveryYear;
     private String voltageLevel;
     private String manufacturer;
     private String equipmentLineName;
     private String defectDescription;
     private String defectPosition;
     private String defectDutyReason;
     private String whetherEliminateDefect;
     private String isOnTime;
     private String dutyReasonCode;
     private String defectTechnicalReason;
     private String technicalReasonCode;
     private String defectDegree;
     private Date defectOccurrenceDate;
     private Date defectEliminateDate;
     private String remark;
     private Double defectEliminateDays;
     private String technicalReason;
     private String dutyReason;
     private String standardDefectPosition;
     private String standardDefectTechReason;
     private String standardDefectDutyReason;


    // Constructors

    /** default constructor */
    public AbstractPmsItemDefectHebei() {
    }

	/** minimal constructor */
    public AbstractPmsItemDefectHebei(Date calYear) {
        this.calYear = calYear;
    }
    
    /** full constructor */
    public AbstractPmsItemDefectHebei(String version, Date calYear, String equipmentId, String orgName, String assetDetailClassCode, String assetDetailClassDescription, String defectId, String defectHappenDepartment, String substationLineName, String defectMainEpuipName, String defectContent, String equipmentTypeCode, String equipmentType, Long deliveryYear, String voltageLevel, String manufacturer, String equipmentLineName, String defectDescription, String defectPosition, String defectDutyReason, String whetherEliminateDefect, String isOnTime, String dutyReasonCode, String defectTechnicalReason, String technicalReasonCode, String defectDegree, Date defectOccurrenceDate, Date defectEliminateDate, String remark, Double defectEliminateDays, String technicalReason, String dutyReason, String standardDefectPosition, String standardDefectTechReason, String standardDefectDutyReason) {
        this.version = version;
        this.calYear = calYear;
        this.equipmentId = equipmentId;
        this.orgName = orgName;
        this.assetDetailClassCode = assetDetailClassCode;
        this.assetDetailClassDescription = assetDetailClassDescription;
        this.defectId = defectId;
        this.defectHappenDepartment = defectHappenDepartment;
        this.substationLineName = substationLineName;
        this.defectMainEpuipName = defectMainEpuipName;
        this.defectContent = defectContent;
        this.equipmentTypeCode = equipmentTypeCode;
        this.equipmentType = equipmentType;
        this.deliveryYear = deliveryYear;
        this.voltageLevel = voltageLevel;
        this.manufacturer = manufacturer;
        this.equipmentLineName = equipmentLineName;
        this.defectDescription = defectDescription;
        this.defectPosition = defectPosition;
        this.defectDutyReason = defectDutyReason;
        this.whetherEliminateDefect = whetherEliminateDefect;
        this.isOnTime = isOnTime;
        this.dutyReasonCode = dutyReasonCode;
        this.defectTechnicalReason = defectTechnicalReason;
        this.technicalReasonCode = technicalReasonCode;
        this.defectDegree = defectDegree;
        this.defectOccurrenceDate = defectOccurrenceDate;
        this.defectEliminateDate = defectEliminateDate;
        this.remark = remark;
        this.defectEliminateDays = defectEliminateDays;
        this.technicalReason = technicalReason;
        this.dutyReason = dutyReason;
        this.standardDefectPosition = standardDefectPosition;
        this.standardDefectTechReason = standardDefectTechReason;
        this.standardDefectDutyReason = standardDefectDutyReason;
    }

   
    // Property accessors

    public String getPmsItemDefectId() {
        return this.pmsItemDefectId;
    }
    
    public void setPmsItemDefectId(String pmsItemDefectId) {
        this.pmsItemDefectId = pmsItemDefectId;
    }

    public String getVersion() {
        return this.version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }

    public Date getCalYear() {
        return this.calYear;
    }
    
    public void setCalYear(Date calYear) {
        this.calYear = calYear;
    }

    public String getEquipmentId() {
        return this.equipmentId;
    }
    
    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getOrgName() {
        return this.orgName;
    }
    
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAssetDetailClassCode() {
        return this.assetDetailClassCode;
    }
    
    public void setAssetDetailClassCode(String assetDetailClassCode) {
        this.assetDetailClassCode = assetDetailClassCode;
    }

    public String getAssetDetailClassDescription() {
        return this.assetDetailClassDescription;
    }
    
    public void setAssetDetailClassDescription(String assetDetailClassDescription) {
        this.assetDetailClassDescription = assetDetailClassDescription;
    }

    public String getDefectId() {
        return this.defectId;
    }
    
    public void setDefectId(String defectId) {
        this.defectId = defectId;
    }

    public String getDefectHappenDepartment() {
        return this.defectHappenDepartment;
    }
    
    public void setDefectHappenDepartment(String defectHappenDepartment) {
        this.defectHappenDepartment = defectHappenDepartment;
    }

    public String getSubstationLineName() {
        return this.substationLineName;
    }
    
    public void setSubstationLineName(String substationLineName) {
        this.substationLineName = substationLineName;
    }

    public String getDefectMainEpuipName() {
        return this.defectMainEpuipName;
    }
    
    public void setDefectMainEpuipName(String defectMainEpuipName) {
        this.defectMainEpuipName = defectMainEpuipName;
    }

    public String getDefectContent() {
        return this.defectContent;
    }
    
    public void setDefectContent(String defectContent) {
        this.defectContent = defectContent;
    }

    public String getEquipmentTypeCode() {
        return this.equipmentTypeCode;
    }
    
    public void setEquipmentTypeCode(String equipmentTypeCode) {
        this.equipmentTypeCode = equipmentTypeCode;
    }

    public String getEquipmentType() {
        return this.equipmentType;
    }
    
    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Long getDeliveryYear() {
        return this.deliveryYear;
    }
    
    public void setDeliveryYear(Long deliveryYear) {
        this.deliveryYear = deliveryYear;
    }

    public String getVoltageLevel() {
        return this.voltageLevel;
    }
    
    public void setVoltageLevel(String voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getEquipmentLineName() {
        return this.equipmentLineName;
    }
    
    public void setEquipmentLineName(String equipmentLineName) {
        this.equipmentLineName = equipmentLineName;
    }

    public String getDefectDescription() {
        return this.defectDescription;
    }
    
    public void setDefectDescription(String defectDescription) {
        this.defectDescription = defectDescription;
    }

    public String getDefectPosition() {
        return this.defectPosition;
    }
    
    public void setDefectPosition(String defectPosition) {
        this.defectPosition = defectPosition;
    }

    public String getDefectDutyReason() {
        return this.defectDutyReason;
    }
    
    public void setDefectDutyReason(String defectDutyReason) {
        this.defectDutyReason = defectDutyReason;
    }

    public String getWhetherEliminateDefect() {
        return this.whetherEliminateDefect;
    }
    
    public void setWhetherEliminateDefect(String whetherEliminateDefect) {
        this.whetherEliminateDefect = whetherEliminateDefect;
    }

    public String getIsOnTime() {
        return this.isOnTime;
    }
    
    public void setIsOnTime(String isOnTime) {
        this.isOnTime = isOnTime;
    }

    public String getDutyReasonCode() {
        return this.dutyReasonCode;
    }
    
    public void setDutyReasonCode(String dutyReasonCode) {
        this.dutyReasonCode = dutyReasonCode;
    }

    public String getDefectTechnicalReason() {
        return this.defectTechnicalReason;
    }
    
    public void setDefectTechnicalReason(String defectTechnicalReason) {
        this.defectTechnicalReason = defectTechnicalReason;
    }

    public String getTechnicalReasonCode() {
        return this.technicalReasonCode;
    }
    
    public void setTechnicalReasonCode(String technicalReasonCode) {
        this.technicalReasonCode = technicalReasonCode;
    }

    public String getDefectDegree() {
        return this.defectDegree;
    }
    
    public void setDefectDegree(String defectDegree) {
        this.defectDegree = defectDegree;
    }

    public Date getDefectOccurrenceDate() {
        return this.defectOccurrenceDate;
    }
    
    public void setDefectOccurrenceDate(Date defectOccurrenceDate) {
        this.defectOccurrenceDate = defectOccurrenceDate;
    }

    public Date getDefectEliminateDate() {
        return this.defectEliminateDate;
    }
    
    public void setDefectEliminateDate(Date defectEliminateDate) {
        this.defectEliminateDate = defectEliminateDate;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getDefectEliminateDays() {
        return this.defectEliminateDays;
    }
    
    public void setDefectEliminateDays(Double defectEliminateDays) {
        this.defectEliminateDays = defectEliminateDays;
    }

    public String getTechnicalReason() {
        return this.technicalReason;
    }
    
    public void setTechnicalReason(String technicalReason) {
        this.technicalReason = technicalReason;
    }

    public String getDutyReason() {
        return this.dutyReason;
    }
    
    public void setDutyReason(String dutyReason) {
        this.dutyReason = dutyReason;
    }

    public String getStandardDefectPosition() {
        return this.standardDefectPosition;
    }
    
    public void setStandardDefectPosition(String standardDefectPosition) {
        this.standardDefectPosition = standardDefectPosition;
    }

    public String getStandardDefectTechReason() {
        return this.standardDefectTechReason;
    }
    
    public void setStandardDefectTechReason(String standardDefectTechReason) {
        this.standardDefectTechReason = standardDefectTechReason;
    }

    public String getStandardDefectDutyReason() {
        return this.standardDefectDutyReason;
    }
    
    public void setStandardDefectDutyReason(String standardDefectDutyReason) {
        this.standardDefectDutyReason = standardDefectDutyReason;
    }
   








}