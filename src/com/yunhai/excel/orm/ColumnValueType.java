package com.yunhai.excel.orm;



/**
 * ColumnValueType entity. @author MyEclipse Persistence Tools
 */
public class ColumnValueType extends AbstractColumnValueType implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public ColumnValueType() {
    }

	/** minimal constructor */
    public ColumnValueType(String columnValueTypeId) {
        super(columnValueTypeId);        
    }
    
    /** full constructor */
    public ColumnValueType(String columnValueTypeId, String columnValueTypeName,  String dataTypeCode, Double sortIndex, String description) {
        super(columnValueTypeId, columnValueTypeName,  dataTypeCode, sortIndex, description);        
    }
   
}
