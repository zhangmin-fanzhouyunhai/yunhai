package com.yunhai.excel.orm;

import java.util.Date;


/**
 * PmsItemDefectHebei entity. @author MyEclipse Persistence Tools
 */
public class PmsItemDefectHebei extends AbstractPmsItemDefectHebei implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public PmsItemDefectHebei() {
    }

	/** minimal constructor */
    public PmsItemDefectHebei(Date calYear) {
        super(calYear);        
    }
    
    /** full constructor */
    public PmsItemDefectHebei(String version, Date calYear, String equipmentId, String orgName, String assetDetailClassCode, String assetDetailClassDescription, String defectId, String defectHappenDepartment, String substationLineName, String defectMainEpuipName, String defectContent, String equipmentTypeCode, String equipmentType, Long deliveryYear, String voltageLevel, String manufacturer, String equipmentLineName, String defectDescription, String defectPosition, String defectDutyReason, String whetherEliminateDefect, String isOnTime, String dutyReasonCode, String defectTechnicalReason, String technicalReasonCode, String defectDegree, Date defectOccurrenceDate, Date defectEliminateDate, String remark, Double defectEliminateDays, String technicalReason, String dutyReason, String standardDefectPosition, String standardDefectTechReason, String standardDefectDutyReason) {
        super(version,calYear, equipmentId, orgName, assetDetailClassCode, assetDetailClassDescription, defectId, defectHappenDepartment, substationLineName, defectMainEpuipName, defectContent, equipmentTypeCode, equipmentType, deliveryYear, voltageLevel, manufacturer, equipmentLineName, defectDescription, defectPosition, defectDutyReason, whetherEliminateDefect, isOnTime, dutyReasonCode, defectTechnicalReason, technicalReasonCode, defectDegree, defectOccurrenceDate, defectEliminateDate, remark, defectEliminateDays, technicalReason, dutyReason, standardDefectPosition, standardDefectTechReason, standardDefectDutyReason);        
    }
   
}
