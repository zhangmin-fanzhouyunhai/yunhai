package com.yunhai.excel.orm;

import java.util.Date;


/**
 * AbstractErpDiscardDepreciationValue entity provides the base persistence definition of the ErpDiscardDepreciationValue entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractErpDiscardDepreciationValue  implements java.io.Serializable {


    // Fields    

     private String erpDiscDepreciationValueId;
     private String version;
     private Date calYear;
     private String assetId;
     private Double originalValue;
     private Double discardDepreciation;


    // Constructors

    /** default constructor */
    public AbstractErpDiscardDepreciationValue() {
    }

    
    /** full constructor */
    public AbstractErpDiscardDepreciationValue(String version,Date calYear, String assetId, Double originalValue, Double discardDepreciation) {
        this.version = version;
        this.calYear = calYear;
        this.assetId = assetId;
        this.originalValue = originalValue;
        this.discardDepreciation = discardDepreciation;
    }

   
    // Property accessors

    public String getErpDiscDepreciationValueId() {
        return this.erpDiscDepreciationValueId;
    }
    
    public void setErpDiscDepreciationValueId(String erpDiscDepreciationValueId) {
        this.erpDiscDepreciationValueId = erpDiscDepreciationValueId;
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

    public String getAssetId() {
        return this.assetId;
    }
    
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Double getOriginalValue() {
        return this.originalValue;
    }
    
    public void setOriginalValue(Double originalValue) {
        this.originalValue = originalValue;
    }

    public Double getDiscardDepreciation() {
        return this.discardDepreciation;
    }
    
    public void setDiscardDepreciation(Double discardDepreciation) {
        this.discardDepreciation = discardDepreciation;
    }
   








}