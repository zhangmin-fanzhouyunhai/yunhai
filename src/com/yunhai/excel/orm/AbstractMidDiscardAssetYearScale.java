package com.yunhai.excel.orm;

import java.util.Date;


/**
 * AbstractMidDiscardAssetYearScale entity provides the base persistence definition of the MidDiscardAssetYearScale entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidDiscardAssetYearScale  implements java.io.Serializable {


    // Fields    

     private String midDiscAssetYearScaleId;
     private String version;
     private Date calYear;
     private String orgName;
     private String largeClass;
     private String mediumClass;
     private String smallClass;
     private String voltageLevel;
     private Double origValue6Years;
     private Double origValue5Years;
     private Double origValue4Years;
     private Double origValue3Years;
     private Double origValue2Years;
     private Double origValue1Years;
     private Double quantity6Years;
     private Double quantity5Years;
     private Double quantity4Years;
     private Double quantity3Years;
     private Double quantity2Years;
     private Double quantity1Years;
     private Date dvDateValue;
     private String category;


    // Constructors

    /** default constructor */
    public AbstractMidDiscardAssetYearScale() {
    }

	/** minimal constructor */
    public AbstractMidDiscardAssetYearScale(String midDiscAssetYearScaleId) {
        this.midDiscAssetYearScaleId = midDiscAssetYearScaleId;
    }
    
    /** full constructor */
    public AbstractMidDiscardAssetYearScale(String midDiscAssetYearScaleId, String version, Date calYear, String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel, Double origValue6Years, Double origValue5Years, Double origValue4Years, Double origValue3Years, Double origValue2Years, Double origValue1Years, Double quantity6Years, Double quantity5Years, Double quantity4Years, Double quantity3Years, Double quantity2Years, Double quantity1Years, Date dvDateValue, String category) {
        this.midDiscAssetYearScaleId = midDiscAssetYearScaleId;
        this.version = version;
        this.calYear = calYear;
        this.orgName = orgName;
        this.largeClass = largeClass;
        this.mediumClass = mediumClass;
        this.smallClass = smallClass;
        this.voltageLevel = voltageLevel;
        this.origValue6Years = origValue6Years;
        this.origValue5Years = origValue5Years;
        this.origValue4Years = origValue4Years;
        this.origValue3Years = origValue3Years;
        this.origValue2Years = origValue2Years;
        this.origValue1Years = origValue1Years;
        this.quantity6Years = quantity6Years;
        this.quantity5Years = quantity5Years;
        this.quantity4Years = quantity4Years;
        this.quantity3Years = quantity3Years;
        this.quantity2Years = quantity2Years;
        this.quantity1Years = quantity1Years;
        this.dvDateValue = dvDateValue;
        this.category = category;
    }

   
    // Property accessors

    public String getMidDiscAssetYearScaleId() {
        return this.midDiscAssetYearScaleId;
    }
    
    public void setMidDiscAssetYearScaleId(String midDiscAssetYearScaleId) {
        this.midDiscAssetYearScaleId = midDiscAssetYearScaleId;
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

    public String getLargeClass() {
        return this.largeClass;
    }
    
    public void setLargeClass(String largeClass) {
        this.largeClass = largeClass;
    }

    public String getMediumClass() {
        return this.mediumClass;
    }
    
    public void setMediumClass(String mediumClass) {
        this.mediumClass = mediumClass;
    }

    public String getSmallClass() {
        return this.smallClass;
    }
    
    public void setSmallClass(String smallClass) {
        this.smallClass = smallClass;
    }

    public String getVoltageLevel() {
        return this.voltageLevel;
    }
    
    public void setVoltageLevel(String voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    public Double getOrigValue6Years() {
        return this.origValue6Years;
    }
    
    public void setOrigValue6Years(Double origValue6Years) {
        this.origValue6Years = origValue6Years;
    }

    public Double getOrigValue5Years() {
        return this.origValue5Years;
    }
    
    public void setOrigValue5Years(Double origValue5Years) {
        this.origValue5Years = origValue5Years;
    }

    public Double getOrigValue4Years() {
        return this.origValue4Years;
    }
    
    public void setOrigValue4Years(Double origValue4Years) {
        this.origValue4Years = origValue4Years;
    }

    public Double getOrigValue3Years() {
        return this.origValue3Years;
    }
    
    public void setOrigValue3Years(Double origValue3Years) {
        this.origValue3Years = origValue3Years;
    }

    public Double getOrigValue2Years() {
        return this.origValue2Years;
    }
    
    public void setOrigValue2Years(Double origValue2Years) {
        this.origValue2Years = origValue2Years;
    }

    public Double getOrigValue1Years() {
        return this.origValue1Years;
    }
    
    public void setOrigValue1Years(Double origValue1Years) {
        this.origValue1Years = origValue1Years;
    }

    public Double getQuantity6Years() {
        return this.quantity6Years;
    }
    
    public void setQuantity6Years(Double quantity6Years) {
        this.quantity6Years = quantity6Years;
    }

    public Double getQuantity5Years() {
        return this.quantity5Years;
    }
    
    public void setQuantity5Years(Double quantity5Years) {
        this.quantity5Years = quantity5Years;
    }

    public Double getQuantity4Years() {
        return this.quantity4Years;
    }
    
    public void setQuantity4Years(Double quantity4Years) {
        this.quantity4Years = quantity4Years;
    }

    public Double getQuantity3Years() {
        return this.quantity3Years;
    }
    
    public void setQuantity3Years(Double quantity3Years) {
        this.quantity3Years = quantity3Years;
    }

    public Double getQuantity2Years() {
        return this.quantity2Years;
    }
    
    public void setQuantity2Years(Double quantity2Years) {
        this.quantity2Years = quantity2Years;
    }

    public Double getQuantity1Years() {
        return this.quantity1Years;
    }
    
    public void setQuantity1Years(Double quantity1Years) {
        this.quantity1Years = quantity1Years;
    }

    public Date getDvDateValue() {
        return this.dvDateValue;
    }
    
	public void setDvDateValue(Date dvDateValue) {
        this.dvDateValue = dvDateValue;
    }

    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
   








}