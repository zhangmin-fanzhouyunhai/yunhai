package com.yunhai.excel.orm;



/**
 * AbstractOriOrderRecord entity provides the base persistence definition of the OriOrderRecord entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOriOrderRecord  implements java.io.Serializable {


    // Fields    

     private String oriOrderRecordId;
     private String dataVersion;
     private String orderType;
     private String orderNumber;
     private String businessScope;
     private Double plannedTotal;
     private Double actualTotal;
     private String functionalLocation;
     private String maintenanceJobType;
     private String plannerGroup;
     private String orderContentDescribe;
     private String planningFactory;
     private String basicStartDate;
     private String basicCompletionDate;
     private String userStatus;
     private String importer;
     private String creationDate;
     private String basicCompletionTime;
     private String completionTime;
     private String wbsOrderTitle;
     private String workingPlaceDescribe;
     private String abcLogo;
     private String purchaseOrderDate;
     private String purchaseOrderNumber;
     private String reservePurchaseApplication;
     private String changeDate;
     private String dataFile;


    // Constructors

    /** default constructor */
    public AbstractOriOrderRecord() {
    }

	/** minimal constructor */
    public AbstractOriOrderRecord(String oriOrderRecordId) {
        this.oriOrderRecordId = oriOrderRecordId;
    }
    
    /** full constructor */
    public AbstractOriOrderRecord(String oriOrderRecordId, String dataVersion, String orderType, String orderNumber, String businessScope, Double plannedTotal, Double actualTotal, String functionalLocation, String maintenanceJobType, String plannerGroup, String orderContentDescribe, String planningFactory, String basicStartDate, String basicCompletionDate, String userStatus, String importer, String creationDate, String basicCompletionTime, String completionTime, String wbsOrderTitle, String workingPlaceDescribe, String abcLogo, String purchaseOrderDate, String purchaseOrderNumber, String reservePurchaseApplication, String changeDate, String dataFile) {
        this.oriOrderRecordId = oriOrderRecordId;
        this.dataVersion = dataVersion;
        this.orderType = orderType;
        this.orderNumber = orderNumber;
        this.businessScope = businessScope;
        this.plannedTotal = plannedTotal;
        this.actualTotal = actualTotal;
        this.functionalLocation = functionalLocation;
        this.maintenanceJobType = maintenanceJobType;
        this.plannerGroup = plannerGroup;
        this.orderContentDescribe = orderContentDescribe;
        this.planningFactory = planningFactory;
        this.basicStartDate = basicStartDate;
        this.basicCompletionDate = basicCompletionDate;
        this.userStatus = userStatus;
        this.importer = importer;
        this.creationDate = creationDate;
        this.basicCompletionTime = basicCompletionTime;
        this.completionTime = completionTime;
        this.wbsOrderTitle = wbsOrderTitle;
        this.workingPlaceDescribe = workingPlaceDescribe;
        this.abcLogo = abcLogo;
        this.purchaseOrderDate = purchaseOrderDate;
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.reservePurchaseApplication = reservePurchaseApplication;
        this.changeDate = changeDate;
        this.dataFile = dataFile;
    }

   
    // Property accessors

    public String getOriOrderRecordId() {
        return this.oriOrderRecordId;
    }
    
    public void setOriOrderRecordId(String oriOrderRecordId) {
        this.oriOrderRecordId = oriOrderRecordId;
    }

    public String getDataVersion() {
        return this.dataVersion;
    }
    
    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public String getOrderType() {
        return this.orderType;
    }
    
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }
    
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getBusinessScope() {
        return this.businessScope;
    }
    
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public Double getPlannedTotal() {
        return this.plannedTotal;
    }
    
    public void setPlannedTotal(Double plannedTotal) {
        this.plannedTotal = plannedTotal;
    }

    public Double getActualTotal() {
        return this.actualTotal;
    }
    
    public void setActualTotal(Double actualTotal) {
        this.actualTotal = actualTotal;
    }

    public String getFunctionalLocation() {
        return this.functionalLocation;
    }
    
    public void setFunctionalLocation(String functionalLocation) {
        this.functionalLocation = functionalLocation;
    }

    public String getMaintenanceJobType() {
        return this.maintenanceJobType;
    }
    
    public void setMaintenanceJobType(String maintenanceJobType) {
        this.maintenanceJobType = maintenanceJobType;
    }

    public String getPlannerGroup() {
        return this.plannerGroup;
    }
    
    public void setPlannerGroup(String plannerGroup) {
        this.plannerGroup = plannerGroup;
    }

    public String getOrderContentDescribe() {
        return this.orderContentDescribe;
    }
    
    public void setOrderContentDescribe(String orderContentDescribe) {
        this.orderContentDescribe = orderContentDescribe;
    }

    public String getPlanningFactory() {
        return this.planningFactory;
    }
    
    public void setPlanningFactory(String planningFactory) {
        this.planningFactory = planningFactory;
    }

    public String getBasicStartDate() {
        return this.basicStartDate;
    }
    
    public void setBasicStartDate(String basicStartDate) {
        this.basicStartDate = basicStartDate;
    }

    public String getBasicCompletionDate() {
        return this.basicCompletionDate;
    }
    
    public void setBasicCompletionDate(String basicCompletionDate) {
        this.basicCompletionDate = basicCompletionDate;
    }

    public String getUserStatus() {
        return this.userStatus;
    }
    
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getImporter() {
        return this.importer;
    }
    
    public void setImporter(String importer) {
        this.importer = importer;
    }

    public String getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getBasicCompletionTime() {
        return this.basicCompletionTime;
    }
    
    public void setBasicCompletionTime(String basicCompletionTime) {
        this.basicCompletionTime = basicCompletionTime;
    }

    public String getCompletionTime() {
        return this.completionTime;
    }
    
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    public String getWbsOrderTitle() {
        return this.wbsOrderTitle;
    }
    
    public void setWbsOrderTitle(String wbsOrderTitle) {
        this.wbsOrderTitle = wbsOrderTitle;
    }

    public String getWorkingPlaceDescribe() {
        return this.workingPlaceDescribe;
    }
    
    public void setWorkingPlaceDescribe(String workingPlaceDescribe) {
        this.workingPlaceDescribe = workingPlaceDescribe;
    }

    public String getAbcLogo() {
        return this.abcLogo;
    }
    
    public void setAbcLogo(String abcLogo) {
        this.abcLogo = abcLogo;
    }

    public String getPurchaseOrderDate() {
        return this.purchaseOrderDate;
    }
    
    public void setPurchaseOrderDate(String purchaseOrderDate) {
        this.purchaseOrderDate = purchaseOrderDate;
    }

    public String getPurchaseOrderNumber() {
        return this.purchaseOrderNumber;
    }
    
    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getReservePurchaseApplication() {
        return this.reservePurchaseApplication;
    }
    
    public void setReservePurchaseApplication(String reservePurchaseApplication) {
        this.reservePurchaseApplication = reservePurchaseApplication;
    }

    public String getChangeDate() {
        return this.changeDate;
    }
    
    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    public String getDataFile() {
        return this.dataFile;
    }
    
    public void setDataFile(String dataFile) {
        this.dataFile = dataFile;
    }
   








}