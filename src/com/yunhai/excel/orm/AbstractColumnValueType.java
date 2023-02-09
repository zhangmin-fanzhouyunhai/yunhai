package com.yunhai.excel.orm;



/**
 * AbstractColumnValueType entity provides the base persistence definition of the ColumnValueType entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractColumnValueType  implements java.io.Serializable {


    // Fields    

     private String columnValueTypeId;
     private String columnValueTypeName;
     private String dataTypeCode;
     private Double sortIndex;
     private String description;


    // Constructors

    /** default constructor */
    public AbstractColumnValueType() {
    }

	/** minimal constructor */
    public AbstractColumnValueType(String columnValueTypeId) {
        this.columnValueTypeId = columnValueTypeId;
    }
    
    /** full constructor */
    public AbstractColumnValueType(String columnValueTypeId, String columnValueTypeName,  String dataTypeCode, Double sortIndex, String description) {
        this.columnValueTypeId = columnValueTypeId;
        this.columnValueTypeName = columnValueTypeName;
        this.dataTypeCode = dataTypeCode;
        this.sortIndex = sortIndex;
        this.description = description;
    }

   
    // Property accessors

    public String getColumnValueTypeId() {
        return this.columnValueTypeId;
    }
    
    public void setColumnValueTypeId(String columnValueTypeId) {
        this.columnValueTypeId = columnValueTypeId;
    }

    public String getColumnValueTypeName() {
        return this.columnValueTypeName;
    }
    
    public void setColumnValueTypeName(String columnValueTypeName) {
        this.columnValueTypeName = columnValueTypeName;
    }

    public String getDataTypeCode() {
        return this.dataTypeCode;
    }
    
    public void setDataTypeCode(String dataTypeCode) {
        this.dataTypeCode = dataTypeCode;
    }

    public Double getSortIndex() {
        return this.sortIndex;
    }
    
    public void setSortIndex(Double sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
   








}