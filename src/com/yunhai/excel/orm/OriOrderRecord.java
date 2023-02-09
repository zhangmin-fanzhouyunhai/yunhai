package com.yunhai.excel.orm;



/**
 * OriOrderRecord entity. @author MyEclipse Persistence Tools
 */
public class OriOrderRecord extends AbstractOriOrderRecord implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public OriOrderRecord() {
    }

	/** minimal constructor */
    public OriOrderRecord(String oriOrderRecordId) {
        super(oriOrderRecordId);        
    }
    
    /** full constructor */
    public OriOrderRecord(String oriOrderRecordId, String dataVersion, String orderType, String orderNumber, String businessScope, Double plannedTotal, Double actualTotal, String functionalLocation, String maintenanceJobType, String plannerGroup, String orderContentDescribe, String planningFactory, String basicStartDate, String basicCompletionDate, String userStatus, String importer, String creationDate, String basicCompletionTime, String completionTime, String wbsOrderTitle, String workingPlaceDescribe, String abcLogo, String purchaseOrderDate, String purchaseOrderNumber, String reservePurchaseApplication, String changeDate, String dataFile) {
        super(oriOrderRecordId, dataVersion, orderType, orderNumber, businessScope, plannedTotal, actualTotal, functionalLocation, maintenanceJobType, plannerGroup, orderContentDescribe, planningFactory, basicStartDate, basicCompletionDate, userStatus, importer, creationDate, basicCompletionTime, completionTime, wbsOrderTitle, workingPlaceDescribe, abcLogo, purchaseOrderDate, purchaseOrderNumber, reservePurchaseApplication, changeDate, dataFile);        
    }
   
}
