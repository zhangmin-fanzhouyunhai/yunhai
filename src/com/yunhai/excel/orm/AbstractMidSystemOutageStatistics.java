package com.yunhai.excel.orm;

import java.util.Date;

public class AbstractMidSystemOutageStatistics implements java.io.Serializable {


    // Fields    

     private String midSystemOutageStatisId;
     private String version;
     private Date calYear;
     private String orgName;
     private String largeDutyReason;
     private String mediumDutyReason;
     private String smallDutyReason;
     private Double powerOutageCustomerTimes1;
     private Double powerOutageTimeCustomerQt1;
     private Double powerOutageCustomerTimes2;
     private Double powerOutageTimeCustomerQt2;
     private Double powerOutageCustomerTimes3;
     private Double powerOutageTimeCustomerQt3;
     private Double powerOutageCustomerTimes4;
     private Double powerOutageTimeCustomerQt4;
     private Double powerOutageCustomerTimes5;
     private Double powerOutageTimeCustomerQt5;
     private Date dvDateValue;
     private String dutyReasonCategory;
     private String areaName;


    // Constructors

    /** default constructor */
    public AbstractMidSystemOutageStatistics() {
    }

	/** minimal constructor */
    public AbstractMidSystemOutageStatistics(String midSystemOutageStatisId) {
        this.midSystemOutageStatisId = midSystemOutageStatisId;
    }
    
    /** full constructor */
    public AbstractMidSystemOutageStatistics(String midSystemOutageStatisId, String version, Date calYear, String orgName, String largeDutyReason, String mediumDutyReason, String smallDutyReason, Double powerOutageCustomerTimes1, Double powerOutageTimeCustomerQt1, Double powerOutageCustomerTimes2, Double powerOutageTimeCustomerQt2, Double powerOutageCustomerTimes3, Double powerOutageTimeCustomerQt3, Double powerOutageCustomerTimes4, Double powerOutageTimeCustomerQt4, Double powerOutageCustomerTimes5, Double powerOutageTimeCustomerQt5, Date dvDateValue, String dutyReasonCategory, String areaName) {
        this.midSystemOutageStatisId = midSystemOutageStatisId;
        this.version = version;
        this.calYear = calYear;
        this.orgName = orgName;
        this.largeDutyReason = largeDutyReason;
        this.mediumDutyReason = mediumDutyReason;
        this.smallDutyReason = smallDutyReason;
        this.powerOutageCustomerTimes1 = powerOutageCustomerTimes1;
        this.powerOutageTimeCustomerQt1 = powerOutageTimeCustomerQt1;
        this.powerOutageCustomerTimes2 = powerOutageCustomerTimes2;
        this.powerOutageTimeCustomerQt2 = powerOutageTimeCustomerQt2;
        this.powerOutageCustomerTimes3 = powerOutageCustomerTimes3;
        this.powerOutageTimeCustomerQt3 = powerOutageTimeCustomerQt3;
        this.powerOutageCustomerTimes4 = powerOutageCustomerTimes4;
        this.powerOutageTimeCustomerQt4 = powerOutageTimeCustomerQt4;
        this.powerOutageCustomerTimes5 = powerOutageCustomerTimes5;
        this.powerOutageTimeCustomerQt5 = powerOutageTimeCustomerQt5;
        this.dvDateValue = dvDateValue;
        this.dutyReasonCategory = dutyReasonCategory;
        this.areaName = areaName;
    }

   
    // Property accessors

    public String getMidSystemOutageStatisId() {
        return this.midSystemOutageStatisId;
    }
    
    public void setMidSystemOutageStatisId(String midSystemOutageStatisId) {
        this.midSystemOutageStatisId = midSystemOutageStatisId;
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

    public String getOrgName() {
        return this.orgName;
    }
    
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLargeDutyReason() {
        return this.largeDutyReason;
    }
    
    public void setLargeDutyReason(String largeDutyReason) {
        this.largeDutyReason = largeDutyReason;
    }

    public String getMediumDutyReason() {
        return this.mediumDutyReason;
    }
    
    public void setMediumDutyReason(String mediumDutyReason) {
        this.mediumDutyReason = mediumDutyReason;
    }

    public String getSmallDutyReason() {
        return this.smallDutyReason;
    }
    
    public void setSmallDutyReason(String smallDutyReason) {
        this.smallDutyReason = smallDutyReason;
    }

    public Double getPowerOutageCustomerTimes1() {
        return this.powerOutageCustomerTimes1;
    }
    
    public void setPowerOutageCustomerTimes1(Double powerOutageCustomerTimes1) {
        this.powerOutageCustomerTimes1 = powerOutageCustomerTimes1;
    }

    public Double getPowerOutageTimeCustomerQt1() {
        return this.powerOutageTimeCustomerQt1;
    }
    
    public void setPowerOutageTimeCustomerQt1(Double powerOutageTimeCustomerQt1) {
        this.powerOutageTimeCustomerQt1 = powerOutageTimeCustomerQt1;
    }

    public Double getPowerOutageCustomerTimes2() {
        return this.powerOutageCustomerTimes2;
    }
    
    public void setPowerOutageCustomerTimes2(Double powerOutageCustomerTimes2) {
        this.powerOutageCustomerTimes2 = powerOutageCustomerTimes2;
    }

    public Double getPowerOutageTimeCustomerQt2() {
        return this.powerOutageTimeCustomerQt2;
    }
    
    public void setPowerOutageTimeCustomerQt2(Double powerOutageTimeCustomerQt2) {
        this.powerOutageTimeCustomerQt2 = powerOutageTimeCustomerQt2;
    }

    public Double getPowerOutageCustomerTimes3() {
        return this.powerOutageCustomerTimes3;
    }
    
    public void setPowerOutageCustomerTimes3(Double powerOutageCustomerTimes3) {
        this.powerOutageCustomerTimes3 = powerOutageCustomerTimes3;
    }

    public Double getPowerOutageTimeCustomerQt3() {
        return this.powerOutageTimeCustomerQt3;
    }
    
    public void setPowerOutageTimeCustomerQt3(Double powerOutageTimeCustomerQt3) {
        this.powerOutageTimeCustomerQt3 = powerOutageTimeCustomerQt3;
    }

    public Double getPowerOutageCustomerTimes4() {
        return this.powerOutageCustomerTimes4;
    }
    
    public void setPowerOutageCustomerTimes4(Double powerOutageCustomerTimes4) {
        this.powerOutageCustomerTimes4 = powerOutageCustomerTimes4;
    }

    public Double getPowerOutageTimeCustomerQt4() {
        return this.powerOutageTimeCustomerQt4;
    }
    
    public void setPowerOutageTimeCustomerQt4(Double powerOutageTimeCustomerQt4) {
        this.powerOutageTimeCustomerQt4 = powerOutageTimeCustomerQt4;
    }

    public Double getPowerOutageCustomerTimes5() {
        return this.powerOutageCustomerTimes5;
    }
    
    public void setPowerOutageCustomerTimes5(Double powerOutageCustomerTimes5) {
        this.powerOutageCustomerTimes5 = powerOutageCustomerTimes5;
    }

    public Double getPowerOutageTimeCustomerQt5() {
        return this.powerOutageTimeCustomerQt5;
    }
    
    public void setPowerOutageTimeCustomerQt5(Double powerOutageTimeCustomerQt5) {
        this.powerOutageTimeCustomerQt5 = powerOutageTimeCustomerQt5;
    }

    public Date getDvDateValue() {
        return this.dvDateValue;
    }
    
    public void setDvDateValue(Date dvDateValue) {
        this.dvDateValue = dvDateValue;
    }

    public String getDutyReasonCategory() {
        return this.dutyReasonCategory;
    }
    
    public void setDutyReasonCategory(String dutyReasonCategory) {
        this.dutyReasonCategory = dutyReasonCategory;
    }

    public String getAreaName() {
        return this.areaName;
    }
    
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
   


}
