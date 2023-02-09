package com.yunhai.db.my;

import java.util.Date;

/**
 * DVersion entity. @author MyEclipse Persistence Tools
 */
public class DVersion extends AbstractDVersion implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public DVersion() {
	}

	/** minimal constructor */
	public DVersion(String versionId, String dataType, String versionValue, Short yearValue, Short subVersion,
			String versionStatus, String targetTable, Date generateDate) {
		super(versionId, dataType, versionValue, yearValue, subVersion, versionStatus, targetTable, generateDate);
	}

	/** full constructor */
	public DVersion(String versionId, String dataType, String versionValue, Short yearValue, Short subVersion,
			String versionStatus, String targetTable, String parentVersion, Date generateDate, String discription,
			String parentVersionTemp, String fileName, Long recordQuantity, String procedureName,
			String procedureVersion) {
		super(versionId, dataType, versionValue, yearValue, subVersion, versionStatus, targetTable, parentVersion,
				generateDate, discription, parentVersionTemp, fileName, recordQuantity, procedureName,
				procedureVersion);
	}

}
