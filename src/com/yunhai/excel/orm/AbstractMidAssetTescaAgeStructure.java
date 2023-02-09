package com.yunhai.excel.orm;

import java.util.Date;


/**
 * AbstractMidAssetTescaAgeStructure entity provides the base persistence definition of the MidAssetTescaAgeStructure entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMidAssetTescaAgeStructure  implements java.io.Serializable {


    // Fields    

     private String midAssetTescaAgeStructId;
     private String version;
     private Date calYear;
     private String orgName;
     private String largeClass;
     private String mediumClass;
     private String smallClass;
     private String voltageLevel;
     private Double totalTechScale;
     private Double techScaleAge1;
     private Double techScaleAge2;
     private Double techScaleAge3;
     private Double techScaleAge4;
     private Double techScaleAge5;
     private Double techScaleAge6;
     private Double techScaleAge7;
     private Double techScaleAge8;
     private Double techScaleAge9;
     private Double techScaleAge10;
     private Double techScaleAge11;
     private Double techScaleAge12;
     private Double techScaleAge13;
     private Double techScaleAge14;
     private Double techScaleAge15;
     private Double techScaleAge16;
     private Double techScaleAge17;
     private Double techScaleAge18;
     private Double techScaleAge19;
     private Double techScaleAge20;
     private Double techScaleAge21;
     private Double techScaleAge22;
     private Double techScaleAge23;
     private Double techScaleAge24;
     private Double techScaleAge25;
     private Double techScaleAge26;
     private Double techScaleAge27;
     private Double techScaleAge28;
     private Double techScaleAge29;
     private Double techScaleAge30;
     private Double techScaleAgeMoreThan30;
     private Date dvDateValue;
     private String category;
     private String areaName;
     private Double techScaleAgeBetw05;
     private Double techScaleAgeBetw510;
     private Double techScaleAgeBetw1015;
     private Double techScaleAgeBetw1520;
     private Double techScaleAgeBetw2030;
     private Double techScaleAgeMoreThen30;


    // Constructors

    /** default constructor */
    public AbstractMidAssetTescaAgeStructure() {
    }

	/** minimal constructor */
    public AbstractMidAssetTescaAgeStructure(String midAssetTescaAgeStructId) {
        this.midAssetTescaAgeStructId = midAssetTescaAgeStructId;
    }
    
    /** full constructor */
    public AbstractMidAssetTescaAgeStructure(String midAssetTescaAgeStructId, String version, Date calYear, String orgName, String largeClass, String mediumClass, String smallClass, String voltageLevel, Double totalTechScale, Double techScaleAge1, Double techScaleAge2, Double techScaleAge3, Double techScaleAge4, Double techScaleAge5, Double techScaleAge6, Double techScaleAge7, Double techScaleAge8, Double techScaleAge9, Double techScaleAge10, Double techScaleAge11, Double techScaleAge12, Double techScaleAge13, Double techScaleAge14, Double techScaleAge15, Double techScaleAge16, Double techScaleAge17, Double techScaleAge18, Double techScaleAge19, Double techScaleAge20, Double techScaleAge21, Double techScaleAge22, Double techScaleAge23, Double techScaleAge24, Double techScaleAge25, Double techScaleAge26, Double techScaleAge27, Double techScaleAge28, Double techScaleAge29, Double techScaleAge30, Double techScaleAgeMoreThan30, Date dvDateValue, String category, String areaName, Double techScaleAgeBetw05, Double techScaleAgeBetw510, Double techScaleAgeBetw1015, Double techScaleAgeBetw1520, Double techScaleAgeBetw2030, Double techScaleAgeMoreThen30) {
        this.midAssetTescaAgeStructId = midAssetTescaAgeStructId;
        this.version = version;
        this.calYear = calYear;
        this.orgName = orgName;
        this.largeClass = largeClass;
        this.mediumClass = mediumClass;
        this.smallClass = smallClass;
        this.voltageLevel = voltageLevel;
        this.totalTechScale = totalTechScale;
        this.techScaleAge1 = techScaleAge1;
        this.techScaleAge2 = techScaleAge2;
        this.techScaleAge3 = techScaleAge3;
        this.techScaleAge4 = techScaleAge4;
        this.techScaleAge5 = techScaleAge5;
        this.techScaleAge6 = techScaleAge6;
        this.techScaleAge7 = techScaleAge7;
        this.techScaleAge8 = techScaleAge8;
        this.techScaleAge9 = techScaleAge9;
        this.techScaleAge10 = techScaleAge10;
        this.techScaleAge11 = techScaleAge11;
        this.techScaleAge12 = techScaleAge12;
        this.techScaleAge13 = techScaleAge13;
        this.techScaleAge14 = techScaleAge14;
        this.techScaleAge15 = techScaleAge15;
        this.techScaleAge16 = techScaleAge16;
        this.techScaleAge17 = techScaleAge17;
        this.techScaleAge18 = techScaleAge18;
        this.techScaleAge19 = techScaleAge19;
        this.techScaleAge20 = techScaleAge20;
        this.techScaleAge21 = techScaleAge21;
        this.techScaleAge22 = techScaleAge22;
        this.techScaleAge23 = techScaleAge23;
        this.techScaleAge24 = techScaleAge24;
        this.techScaleAge25 = techScaleAge25;
        this.techScaleAge26 = techScaleAge26;
        this.techScaleAge27 = techScaleAge27;
        this.techScaleAge28 = techScaleAge28;
        this.techScaleAge29 = techScaleAge29;
        this.techScaleAge30 = techScaleAge30;
        this.techScaleAgeMoreThan30 = techScaleAgeMoreThan30;
        this.dvDateValue = dvDateValue;
        this.category = category;
        this.areaName = areaName;
        this.techScaleAgeBetw05 = techScaleAgeBetw05;
        this.techScaleAgeBetw510 = techScaleAgeBetw510;
        this.techScaleAgeBetw1015 = techScaleAgeBetw1015;
        this.techScaleAgeBetw1520 = techScaleAgeBetw1520;
        this.techScaleAgeBetw2030 = techScaleAgeBetw2030;
        this.techScaleAgeMoreThen30 = techScaleAgeMoreThen30;
    }

   
    // Property accessors

    public String getMidAssetTescaAgeStructId() {
        return this.midAssetTescaAgeStructId;
    }
    
    public void setMidAssetTescaAgeStructId(String midAssetTescaAgeStructId) {
        this.midAssetTescaAgeStructId = midAssetTescaAgeStructId;
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

    public Double getTotalTechScale() {
        return this.totalTechScale;
    }
    
    public void setTotalTechScale(Double totalTechScale) {
        this.totalTechScale = totalTechScale;
    }

    public Double getTechScaleAge1() {
        return this.techScaleAge1;
    }
    
    public void setTechScaleAge1(Double techScaleAge1) {
        this.techScaleAge1 = techScaleAge1;
    }

    public Double getTechScaleAge2() {
        return this.techScaleAge2;
    }
    
    public void setTechScaleAge2(Double techScaleAge2) {
        this.techScaleAge2 = techScaleAge2;
    }

    public Double getTechScaleAge3() {
        return this.techScaleAge3;
    }
    
    public void setTechScaleAge3(Double techScaleAge3) {
        this.techScaleAge3 = techScaleAge3;
    }

    public Double getTechScaleAge4() {
        return this.techScaleAge4;
    }
    
    public void setTechScaleAge4(Double techScaleAge4) {
        this.techScaleAge4 = techScaleAge4;
    }

    public Double getTechScaleAge5() {
        return this.techScaleAge5;
    }
    
    public void setTechScaleAge5(Double techScaleAge5) {
        this.techScaleAge5 = techScaleAge5;
    }

    public Double getTechScaleAge6() {
        return this.techScaleAge6;
    }
    
    public void setTechScaleAge6(Double techScaleAge6) {
        this.techScaleAge6 = techScaleAge6;
    }

    public Double getTechScaleAge7() {
        return this.techScaleAge7;
    }
    
    public void setTechScaleAge7(Double techScaleAge7) {
        this.techScaleAge7 = techScaleAge7;
    }

    public Double getTechScaleAge8() {
        return this.techScaleAge8;
    }
    
    public void setTechScaleAge8(Double techScaleAge8) {
        this.techScaleAge8 = techScaleAge8;
    }

    public Double getTechScaleAge9() {
        return this.techScaleAge9;
    }
    
    public void setTechScaleAge9(Double techScaleAge9) {
        this.techScaleAge9 = techScaleAge9;
    }

    public Double getTechScaleAge10() {
        return this.techScaleAge10;
    }
    
    public void setTechScaleAge10(Double techScaleAge10) {
        this.techScaleAge10 = techScaleAge10;
    }

    public Double getTechScaleAge11() {
        return this.techScaleAge11;
    }
    
    public void setTechScaleAge11(Double techScaleAge11) {
        this.techScaleAge11 = techScaleAge11;
    }

    public Double getTechScaleAge12() {
        return this.techScaleAge12;
    }
    
    public void setTechScaleAge12(Double techScaleAge12) {
        this.techScaleAge12 = techScaleAge12;
    }

    public Double getTechScaleAge13() {
        return this.techScaleAge13;
    }
    
    public void setTechScaleAge13(Double techScaleAge13) {
        this.techScaleAge13 = techScaleAge13;
    }

    public Double getTechScaleAge14() {
        return this.techScaleAge14;
    }
    
    public void setTechScaleAge14(Double techScaleAge14) {
        this.techScaleAge14 = techScaleAge14;
    }

    public Double getTechScaleAge15() {
        return this.techScaleAge15;
    }
    
    public void setTechScaleAge15(Double techScaleAge15) {
        this.techScaleAge15 = techScaleAge15;
    }

    public Double getTechScaleAge16() {
        return this.techScaleAge16;
    }
    
    public void setTechScaleAge16(Double techScaleAge16) {
        this.techScaleAge16 = techScaleAge16;
    }

    public Double getTechScaleAge17() {
        return this.techScaleAge17;
    }
    
    public void setTechScaleAge17(Double techScaleAge17) {
        this.techScaleAge17 = techScaleAge17;
    }

    public Double getTechScaleAge18() {
        return this.techScaleAge18;
    }
    
    public void setTechScaleAge18(Double techScaleAge18) {
        this.techScaleAge18 = techScaleAge18;
    }

    public Double getTechScaleAge19() {
        return this.techScaleAge19;
    }
    
    public void setTechScaleAge19(Double techScaleAge19) {
        this.techScaleAge19 = techScaleAge19;
    }

    public Double getTechScaleAge20() {
        return this.techScaleAge20;
    }
    
    public void setTechScaleAge20(Double techScaleAge20) {
        this.techScaleAge20 = techScaleAge20;
    }

    public Double getTechScaleAge21() {
        return this.techScaleAge21;
    }
    
    public void setTechScaleAge21(Double techScaleAge21) {
        this.techScaleAge21 = techScaleAge21;
    }

    public Double getTechScaleAge22() {
        return this.techScaleAge22;
    }
    
    public void setTechScaleAge22(Double techScaleAge22) {
        this.techScaleAge22 = techScaleAge22;
    }

    public Double getTechScaleAge23() {
        return this.techScaleAge23;
    }
    
    public void setTechScaleAge23(Double techScaleAge23) {
        this.techScaleAge23 = techScaleAge23;
    }

    public Double getTechScaleAge24() {
        return this.techScaleAge24;
    }
    
    public void setTechScaleAge24(Double techScaleAge24) {
        this.techScaleAge24 = techScaleAge24;
    }

    public Double getTechScaleAge25() {
        return this.techScaleAge25;
    }
    
    public void setTechScaleAge25(Double techScaleAge25) {
        this.techScaleAge25 = techScaleAge25;
    }

    public Double getTechScaleAge26() {
        return this.techScaleAge26;
    }
    
    public void setTechScaleAge26(Double techScaleAge26) {
        this.techScaleAge26 = techScaleAge26;
    }

    public Double getTechScaleAge27() {
        return this.techScaleAge27;
    }
    
    public void setTechScaleAge27(Double techScaleAge27) {
        this.techScaleAge27 = techScaleAge27;
    }

    public Double getTechScaleAge28() {
        return this.techScaleAge28;
    }
    
    public void setTechScaleAge28(Double techScaleAge28) {
        this.techScaleAge28 = techScaleAge28;
    }

    public Double getTechScaleAge29() {
        return this.techScaleAge29;
    }
    
    public void setTechScaleAge29(Double techScaleAge29) {
        this.techScaleAge29 = techScaleAge29;
    }

    public Double getTechScaleAge30() {
        return this.techScaleAge30;
    }
    
    public void setTechScaleAge30(Double techScaleAge30) {
        this.techScaleAge30 = techScaleAge30;
    }

    public Double getTechScaleAgeMoreThan30() {
        return this.techScaleAgeMoreThan30;
    }
    
    public void setTechScaleAgeMoreThan30(Double techScaleAgeMoreThan30) {
        this.techScaleAgeMoreThan30 = techScaleAgeMoreThan30;
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

    public String getAreaName() {
        return this.areaName;
    }
    
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Double getTechScaleAgeBetw05() {
        return this.techScaleAgeBetw05;
    }
    
    public void setTechScaleAgeBetw05(Double techScaleAgeBetw05) {
        this.techScaleAgeBetw05 = techScaleAgeBetw05;
    }

    public Double getTechScaleAgeBetw510() {
        return this.techScaleAgeBetw510;
    }
    
    public void setTechScaleAgeBetw510(Double techScaleAgeBetw510) {
        this.techScaleAgeBetw510 = techScaleAgeBetw510;
    }

    public Double getTechScaleAgeBetw1015() {
        return this.techScaleAgeBetw1015;
    }
    
    public void setTechScaleAgeBetw1015(Double techScaleAgeBetw1015) {
        this.techScaleAgeBetw1015 = techScaleAgeBetw1015;
    }

    public Double getTechScaleAgeBetw1520() {
        return this.techScaleAgeBetw1520;
    }
    
    public void setTechScaleAgeBetw1520(Double techScaleAgeBetw1520) {
        this.techScaleAgeBetw1520 = techScaleAgeBetw1520;
    }

    public Double getTechScaleAgeBetw2030() {
        return this.techScaleAgeBetw2030;
    }
    
    public void setTechScaleAgeBetw2030(Double techScaleAgeBetw2030) {
        this.techScaleAgeBetw2030 = techScaleAgeBetw2030;
    }

    public Double getTechScaleAgeMoreThen30() {
        return this.techScaleAgeMoreThen30;
    }
    
    public void setTechScaleAgeMoreThen30(Double techScaleAgeMoreThen30) {
        this.techScaleAgeMoreThen30 = techScaleAgeMoreThen30;
    }
   








}