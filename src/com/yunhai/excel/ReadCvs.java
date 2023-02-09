package com.yunhai.excel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

//import com.virtualdell.zcxz.dataImport.pojo.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yunhai.excel.dao.CtBreakdownDAO;
import com.yunhai.excel.orm.BicAzfiSwzc;
import com.yunhai.excel.orm.CtBreakdown;
import com.yunhai.excel.orm.DVersion;
import com.yunhai.excel.orm.Erp2anlaRecordSheet1;
import com.yunhai.excel.orm.Erp2anlaRecordSheet10;
import com.yunhai.excel.orm.Erp2anlaRecordSheet11;
import com.yunhai.excel.orm.Erp2anlaRecordSheet12;
import com.yunhai.excel.orm.Erp2anlaRecordSheet13;
import com.yunhai.excel.orm.Erp2anlaRecordSheet2;
import com.yunhai.excel.orm.Erp2anlaRecordSheet3;
import com.yunhai.excel.orm.Erp2anlaRecordSheet5;
import com.yunhai.excel.orm.Erp2anlaRecordSheet6;
import com.yunhai.excel.orm.Erp2anlaRecordSheet7;
import com.yunhai.excel.orm.Erp2anlaRecordSheet8;
import com.yunhai.excel.orm.Erp2anlaRecordSheet9;
import com.yunhai.excel.orm.ErpAnlcRecord;
import com.yunhai.excel.orm.ErpAnluRecord;
import com.yunhai.excel.orm.ErpAnlzRecord;
import com.yunhai.excel.orm.ErpCsksRecord;
import com.yunhai.excel.orm.ErpDiscardDepreciationValue;
import com.yunhai.excel.orm.ErpItemDiscard;
import com.yunhai.excel.orm.ErpItemDiscardHebei;
import com.yunhai.excel.orm.ErpItemIncreasedImp;
import com.yunhai.excel.orm.ErpItemOldDiscard;
import com.yunhai.excel.orm.ErpItemReuse;
import com.yunhai.excel.orm.ErpPropertyRecord;
import com.yunhai.excel.orm.OElectricReactor;
import com.yunhai.excel.orm.OElectricReactorCollect;
import com.yunhai.excel.orm.OPowerCapacitor;
import com.yunhai.excel.orm.OPowerCapacitorCollect;
import com.yunhai.excel.orm.OSwitchCabinet;
import com.yunhai.excel.orm.OSwitchCabinetCollect;
import com.yunhai.excel.orm.OriAssetInformationItem;
import com.yunhai.excel.orm.OriDiscardApplicationRecord;
import com.yunhai.excel.orm.OriDistributionNetworkFault;
import com.yunhai.excel.orm.OriEquipAssetRelationItem;
import com.yunhai.excel.orm.OriEquipmentBreakdown;
import com.yunhai.excel.orm.OriEquipmentInformationItem;
import com.yunhai.excel.orm.OriEquipmentRealAssetCode;
import com.yunhai.excel.orm.OriFinancePostRecordAnep;
import com.yunhai.excel.orm.OriFinanceScrapPostAsset;
import com.yunhai.excel.orm.OriFinanceScrapPostEquip;
import com.yunhai.excel.orm.OriFinanceScrapPostRecord;
import com.yunhai.excel.orm.OriFullAssetAccountPosting;
import com.yunhai.excel.orm.OriFullAssetCapitalization;
import com.yunhai.excel.orm.OriLowVolStationLineEquip;
import com.yunhai.excel.orm.OriOperationTicketRecord;
import com.yunhai.excel.orm.OriOpticalCableSection;
import com.yunhai.excel.orm.OriOpticalCableTermianl;
import com.yunhai.excel.orm.OriOrderRecord;
import com.yunhai.excel.orm.OriOverAgeAsset;
import com.yunhai.excel.orm.OriOverAgeItem;
import com.yunhai.excel.orm.OriOverhaulProject;
import com.yunhai.excel.orm.OriOverhaulRoughTable;
import com.yunhai.excel.orm.OriPmsTransformer;
import com.yunhai.excel.orm.OriPmsTransformerSubstation;
import com.yunhai.excel.orm.OriPowerSupplyDutyReason;
import com.yunhai.excel.orm.OriTechRenovaProjEquip;
import com.yunhai.excel.orm.OriTechRenovationProject;
import com.yunhai.excel.orm.OriTechTransformProject;
import com.yunhai.excel.orm.OriTechTransformRoughTable;
import com.yunhai.excel.orm.OriValidatTechRenovaProj;
import com.yunhai.excel.orm.OriWorkTaskDocumentRecord;
import com.yunhai.excel.orm.OriWorkTaskInvoice;
import com.yunhai.excel.orm.OriWorkTicket;
import com.yunhai.excel.orm.OriWorkTicketRecord;
import com.yunhai.excel.orm.PmsItemAutomatic;
import com.yunhai.excel.orm.PmsItemBackup;
import com.yunhai.excel.orm.PmsItemDefectHebei;
import com.yunhai.excel.orm.PmsItemLowVoltPlat;
import com.yunhai.excel.orm.PmsItemPeiLine;
import com.yunhai.excel.orm.PmsItemPeiSet;
import com.yunhai.excel.orm.PmsItemReuse;
import com.yunhai.excel.orm.PmsItemRingMainUnit;
import com.yunhai.excel.orm.PmsItemShuLine;
import com.yunhai.excel.orm.PmsItemTools;
import com.yunhai.excel.orm.PmsItemTransSet;
import com.yunhai.excel.orm.PmsItemTransformers;
import com.yunhai.excel.orm.PmsQuexian;
import com.yunhai.excel.orm.TechRefProSinEngDecompose;
import com.yunhai.excel.orm.UpZfiaaBf;
import com.yunhai.excel.orm.UpdateVoltageLevel;
import com.yunhai.excel.orm.ZfiSwzc16classValue;
import com.yunhai.excel.orm.ZfiSwzc2019;
import com.yunhai.excel.orm.ZfiSwzcDisc;
import com.yunhai.excel.orm.ZfiSwzcHeBei;
import com.yunhai.excel.orm.ZfiSwzcNew;
import com.yunhai.excel.orm.ZfiSwzcNo16classValue;
import com.yunhai.util.DateFormatUtil;

public class ReadCvs {
	private static final Logger log = LoggerFactory.getLogger(CtBreakdownDAO.class);
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
		/*
		 * System.out.println("开始readCsv()"); readeCsv();
		 * System.out.println("结束readCsv()");
		 */

		System.out.println("开始!");
		String pathStr = null;
		String versionValue = null;
		String calYear = null;
		String dataVersion = null;
		String calYera = null;
		//
		dataVersion = "O_2019_1";
		calYear = "2021-01-14";
		//
		pathStr = "D:/temp/工作票/工作票-替换表头-V1.0-20210114.csv";

		// csvOriWorkTicketAdd(pathStr, dataVersion, calYear);
		//
		dataVersion = "O_2019_2";
		String targetTable = "ORI_WORK_TICKET";
		String dataType = "O";
		Short yearValue = 2019;
		Short subVersion = 1;
		String versionStatus = "1";
		String parentVersion = "";

		dataVersion = "O_2020_1";
		calYear = "2021";
		pathStr = "F:/Workspace/0实物资产分析评价系统－新目录/2021/2021年数据收集反馈样本/河北/实物资产评价-20210208_ERP/2020年报废数据-替换表头-V1.0-20210303.csv";

		// getCSVHeader(pathStr);
		// ORI_DISCARD_APPLICATION_RECORD
		// csvOriDiscardApplicationRecordAdd(pathStr, dataVersion, calYear);
		// insertInToDVersion( dataVersion, targetTable, dataType,
		// yearValue, subVersion, versionStatus, parentVersion) ;

		/*
		 * 日期：2021-01-19 导入第一版PMS样本 提供人：罗健波
		 * 
		 */
		dataVersion = "O_2020_1";
		calYear = "2021";
		pathStr = "D:/temp/hubei/2021/pms20210119/输电线路.csv";
		// csvPmsItemShuLineAdd(pathStr, dataVersion, calYear);
		// getCSVHeader(pathStr);
		pathStr = "D:/temp/hubei/2021/pms20210119/变压器.csv";
		// csvPmsItemTransformersAdd(pathStr, dataVersion, calYear);
		// getCSVHeader(pathStr);
		pathStr = "D:/temp/hubei/2021/pms20210119/变电设备.csv";
		// csvPmsItemTransSetAdd(pathStr, dataVersion, calYear);
		// getCSVHeader(pathStr);

		pathStr = "D:/temp/hubei/2021/pms20210119/配电线路.csv";
		// getCSVHeader(pathStr);
		// 
		csvPmsItemPeiLineAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hubei/2021/pms20210119/配电设备1.csv";
		// getCSVHeader(pathStr);
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);
		pathStr = "D:/temp/hubei/2021/pms20210119/配电设备2.csv";
		// getCSVHeader(pathStr);
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);
		pathStr = "D:/temp/hebei/2021/2020年第一批计划关联设备信息-分析-V1.0-20210706.csv";
		// 20210802 ORI_TECH_RENOVA_PROJ_EQUIP OriTechRenovaProjEquip
		calYear = "2021-08-02";
		// getCSVHeader(pathStr);
		// csvOriTechRenovaProjEquipAdd(pathStr, dataVersion, calYear);

		dataVersion = "O_2020_2";
		calYear = "2021";
		pathStr = "D:/temp/hebei/2021/计划关联信息-替换表头-V1.0-20210829.csv";
		// 20210829 ORI_TECH_RENOVA_PROJ_EQUIP OriTechRenovaProjEquip
		calYear = "2021-08-29";
		// getCSVHeader(pathStr);
		// csvOriTechRenovaProjEquipAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hebei/2021/2020验证清单-2020年综合计划第一批（生产技改）-汇总导入-V1.3-20210802.csv";// 20210802
																							// ORI_VALIDAT_TECH_RENOVA_PROJ
		calYear = "2021-08-02";
		dataVersion = "O_2020_1";
		// getCSVHeader(pathStr);
		// csvOriValidatTechRenovaProjAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hebei/2021/2020验证清单-2020年综合计划第一批（生产技改）-汇总导入-V1.3-20210802.csv";// 20210802
																							// ORI_VALIDAT_TECH_RENOVA_PROJ
		calYear = "2021-08-31";
		dataVersion = "O_2020_2";
		// getCSVHeader(pathStr);
		// csvOriValidatTechRenovaProjAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hebei/2021/2020年第一批计划信息-验收认证项目-V1.3-导入-20210803.csv";// 20210803 ORI_TECH_RENOVATION_PROJECT
		calYear = "2021-09-01";
		dataVersion = "O_2020_2";
		parentVersion = "";

		// getCSVHeader(pathStr);
		// csvOriTechRenovaProjectAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/实物资产分析评价-冀北/资产全寿命周期管理-冀北/选好设备/选好设备数据/设备/电抗器（干式与油浸式）-替换表头-V1.1-20220519.csv";
		// 20210803 O_ELECTRIC_REACTOR
		// getCSVHeader(pathStr);
		calYear = "2022-05-22";
		dataVersion = "O_2022_1";
		//
		targetTable = "O_ELECTRIC_REACTOR";
		parentVersion = "";
		//dataVersion = ExportDao.getMaxDataVersion(targetTable, dataVersion);
		//
		//csvOElectricReactorAdd(pathStr, dataVersion, calYear);
		String discription = "选好设备数据－电抗器（干式与油浸式）";
		String method = "csvOElectricReactorAdd";

		
		DVersion dVersion = new DVersion();
		dVersion.setVersionValue(dataVersion);
		dVersion.setTargetTable(targetTable);
		dVersion.setDataType(dataVersion.substring(0, dataVersion.indexOf("_")));
		dVersion.setYearValue(
				new Short(dataVersion.substring(dataVersion.indexOf("_") + 1, dataVersion.indexOf("_") + 5)));
		dVersion.setSubVersion(new Short(dataVersion.substring(dataVersion.lastIndexOf("_") + 1)));
		dVersion.setVersionStatus("1");
		dVersion.setParentVersion(parentVersion);
		dVersion.setGenerateDate(new Date());
		dVersion.setFileName(pathStr);
		dVersion.setDiscription(discription);
		dVersion.setProcedureName(method);
		//insertInToDVersion(dVersion);


		pathStr = "D:/实物资产分析评价-冀北/资产全寿命周期管理-冀北/选好设备/选好设备数据/设备/电力电容器（框架式与集合式）-替换表头-V1.0-20220505.csv";
		// 20210803 O_ELECTRIC_REACTOR
		// getCSVHeader(pathStr);
		calYear = "2022-05-22";
		dataVersion = "O_2022_1";
		//
		targetTable = "O_POWER_CAPACITOR";
		parentVersion = "";
		//dataVersion = ExportDao.getMaxDataVersion(targetTable, dataVersion);
		//csvOPowerCapacitorAdd(pathStr, dataVersion, calYear);
		discription = "选好设备数据－电力电容器（框架式与集合式）";
		method = "csvOPowerCapacitorAdd";

		
		dVersion = new DVersion();
		dVersion.setVersionValue(dataVersion);
		dVersion.setTargetTable(targetTable);
		dVersion.setDataType(dataVersion.substring(0, dataVersion.indexOf("_")));
		dVersion.setYearValue(
				new Short(dataVersion.substring(dataVersion.indexOf("_") + 1, dataVersion.indexOf("_") + 5)));
		dVersion.setSubVersion(new Short(dataVersion.substring(dataVersion.lastIndexOf("_") + 1)));
		dVersion.setVersionStatus("1");
		dVersion.setParentVersion(parentVersion);
		dVersion.setGenerateDate(new Date());
		dVersion.setFileName(pathStr);
		dVersion.setDiscription(discription);
		dVersion.setProcedureName(method);
		//insertInToDVersion(dVersion);

		pathStr = "D:/实物资产分析评价-冀北/资产全寿命周期管理-冀北/选好设备/选好设备数据/设备/开关柜（充气柜与空气柜汇总）-替换表头-V1.1-20220426.csv";
		pathStr = "D:/实物资产分析评价-冀北/资产全寿命周期管理-冀北/选好设备/选好设备数据/设备/开关柜-替换表头-V1.0-20220426.csv";
		// 20210803 O_ELECTRIC_REACTOR
		// getCSVHeader(pathStr);
		calYear = "2022-05-26";
		dataVersion = "O_2022_2";
		//
		targetTable = "O_SWITCH_CABINET";
		parentVersion = "";
		//dataVersion = ExportDao.getMaxDataVersion(targetTable, dataVersion);
		//csvOSwitchCabinetAdd(pathStr, dataVersion, calYear);
		discription = "选好设备数据－开关柜（充气柜与空气柜汇总）";
		method = "csvOSwitchCabinetAdd";

		
		dVersion = new DVersion();
		dVersion.setVersionValue(dataVersion);
		dVersion.setTargetTable(targetTable);
		dVersion.setDataType(dataVersion.substring(0, dataVersion.indexOf("_")));
		dVersion.setYearValue(
				new Short(dataVersion.substring(dataVersion.indexOf("_") + 1, dataVersion.indexOf("_") + 5)));
		dVersion.setSubVersion(new Short(dataVersion.substring(dataVersion.lastIndexOf("_") + 1)));
		dVersion.setVersionStatus("1");
		dVersion.setParentVersion(parentVersion);
		dVersion.setGenerateDate(new Date());
		dVersion.setFileName(pathStr);
		dVersion.setDiscription(discription);
		dVersion.setProcedureName(method);
		//insertInToDVersion(dVersion);
		


		pathStr = "D:/实物资产分析评价-冀北/资产全寿命周期管理-冀北/选好设备/选好设备数据/设备/V1.0-20220425.csv";
		// 20210803 O_ELECTRIC_REACTOR
		// getCSVHeader(pathStr);
		calYear = "2022-05-22";
		dataVersion = "O_2022_1";
		//
		targetTable = "O_ELECTRIC_REACTOR_COLLECT";
		parentVersion = "";
		//dataVersion = ExportDao.getMaxDataVersion(targetTable, dataVersion);
		//csvOElectricReactorCollectAdd(pathStr, dataVersion, calYear);
		discription = "选好设备数据－电抗器-收集数据表";
		method = "csvOElectricReactorCollectAdd";

		
		
		dVersion = new DVersion();
		dVersion.setVersionValue(dataVersion);
		dVersion.setTargetTable(targetTable);
		dVersion.setDataType(dataVersion.substring(0, dataVersion.indexOf("_")));
		dVersion.setYearValue(
				new Short(dataVersion.substring(dataVersion.indexOf("_") + 1, dataVersion.indexOf("_") + 5)));
		dVersion.setSubVersion(new Short(dataVersion.substring(dataVersion.lastIndexOf("_") + 1)));
		dVersion.setVersionStatus("1");
		dVersion.setParentVersion(parentVersion);
		dVersion.setGenerateDate(new Date());
		dVersion.setFileName(pathStr);
		dVersion.setDiscription(discription);
		dVersion.setProcedureName(method);
		//insertInToDVersion(dVersion);
		

		pathStr = "D:/实物资产分析评价-冀北/资产全寿命周期管理-冀北/选好设备/选好设备数据/设备/V1.0-20220425.csv";
		// 20210803 O_ELECTRIC_REACTOR
		// getCSVHeader(pathStr);
		calYear = "2022-05-22";
		dataVersion = "O_2022_1";
		//
		targetTable = "O_POWER_CAPACITOR_COLLECT";
		parentVersion = "";
		//dataVersion = ExportDao.getMaxDataVersion(targetTable, dataVersion);
		//csvOPowerCapacitorCollectAdd(pathStr, dataVersion, calYear);
		discription = "选好设备数据－电抗器-收集数据表";
		method = "csvOPowerCapacitorCollectAdd";

		
		
		dVersion = new DVersion();
		dVersion.setVersionValue(dataVersion);
		dVersion.setTargetTable(targetTable);
		dVersion.setDataType(dataVersion.substring(0, dataVersion.indexOf("_")));
		dVersion.setYearValue(
				new Short(dataVersion.substring(dataVersion.indexOf("_") + 1, dataVersion.indexOf("_") + 5)));
		dVersion.setSubVersion(new Short(dataVersion.substring(dataVersion.lastIndexOf("_") + 1)));
		dVersion.setVersionStatus("1");
		dVersion.setParentVersion(parentVersion);
		dVersion.setGenerateDate(new Date());
		dVersion.setFileName(pathStr);
		dVersion.setDiscription(discription);
		dVersion.setProcedureName(method);
		//insertInToDVersion(dVersion);
		

		pathStr = "D:/实物资产分析评价-冀北/资产全寿命周期管理-冀北/选好设备/选好设备数据/设备/附件1-国网冀北“选好设备”项目数据收集表-开关柜-20220526-V1.0-承德.csv";
		pathStr = "D:/实物资产分析评价-冀北/资产全寿命周期管理-冀北/选好设备/选好设备数据/设备/附件1-国网冀北“选好设备”项目数据收集表-开关柜-20220526-V1.0-唐山.csv";
		pathStr = "D:/实物资产分析评价-冀北/资产全寿命周期管理-冀北/选好设备/选好设备数据/设备/附件1-国网冀北“选好设备”项目数据收集表-V1.1-唐山-20220527.csv";
		// 20210803 O_ELECTRIC_REACTOR
		// getCSVHeader(pathStr);
		calYear = "2022-05-22";
		dataVersion = "O_2022_1";
		//
		targetTable = "O_SWITCH_CABINET_COLLECT";
		parentVersion = "";
		//dataVersion = ExportDao.getMaxDataVersion(targetTable, dataVersion);
		//csvOSwitchCabinetCollectAdd(pathStr, dataVersion, calYear);
		discription = "选好设备数据－开关柜-收集数据表";
		method = "csvOSwitchCabinetCollectAdd";

		dVersion = new DVersion();
		dVersion.setVersionValue(dataVersion);
		dVersion.setTargetTable(targetTable);
		dVersion.setDataType(dataVersion.substring(0, dataVersion.indexOf("_")));
		dVersion.setYearValue(
				new Short(dataVersion.substring(dataVersion.indexOf("_") + 1, dataVersion.indexOf("_") + 5)));
		dVersion.setSubVersion(new Short(dataVersion.substring(dataVersion.lastIndexOf("_") + 1)));
		dVersion.setVersionStatus("1");
		dVersion.setParentVersion(parentVersion);
		dVersion.setGenerateDate(new Date());
		dVersion.setFileName(pathStr);
		dVersion.setDiscription(discription);
		dVersion.setProcedureName(method);
		//insertInToDVersion(dVersion);
		

		//
		targetTable = "ORI_TECH_RENOVATION_PROJECT";

		discription = "2020年技改大修项目清单";
		method = "csvOriTechRenovaProjectAdd";

		// insertInToDVersion(targetTable, dataVersion, pathStr,parentVersion,
		// discription, method);

		pathStr = "D:/temp/hubei/2021/pms20210119/环网柜.csv";
		// getCSVHeader(pathStr);
		// csvPmsItemRingMainUnitAdd(pathStr, dataVersion, calYear);
		//
		String result = "";
		// result=new AssetValueProcedureDao().assetValueProcedureByProcedureCall();

		System.out.println("result=" + result);
		pathStr = "D:/temp/hubei/2021/pms20210119/仪器仪表及测试设备.csv";
		// getCSVHeader(pathStr);
		// csvPmsItemToolsAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hubei/2021/pms20210119/自动化系统及设备和继电保护及安全自动装置.csv";
		// getCSVHeader(pathStr);
		// csvPmsItemAutomaticAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hubei/2021/pms20210119/缺陷.csv";
		// getCSVHeader(pathStr);
		// csvPmsQuexianAdd(pathStr, dataVersion, calYear); //OK 20190905 201200条

		//
		pathStr = "D:/temp/hubei/2021/pms20210119/低压.csv";
		// getCSVHeader(pathStr);
		// csvOriLowVolStationLineEquipAdd(pathStr, dataVersion, calYear);
		/*
		 * 日期：2021-02-18 导入第一版PMS样本 提供人：耿倩
		 * 
		 */

		dataVersion = "O_2021_1";
		String calYearDate = "2021-08-24";
		// getCSVHeader(pathStr);
		// ORI_OVERHAUL_ROUGH_TABLE OriOverhaulRoughTable
		pathStr = "D:/temp/hebei/2021/大修基础表-V1.0-20210824.csv";
		// csvOriOverhaulRoughTableAdd(pathStr, dataVersion, calYearDate);

		dataVersion = "O_2021_1";
		calYearDate = "2021-08-24";
		// getCSVHeader(pathStr);
		// ORI_TECH_TRANSFORM_ROUGH_TABLE OriTechTransformRoughTable
		pathStr = "D:/temp/hebei/2021/技改基础表-V1.0-20210824.csv";
		// csvOriTechTransformRoughTableAdd(pathStr, dataVersion, calYearDate);

		dataVersion = "O_2021_2";
		calYearDate = "2021-08-26";
		// getCSVHeader(pathStr);
		// ORI_OVERHAUL_ROUGH_TABLE OriOverhaulRoughTable
		pathStr = "D:/temp/hebei/2021/大修基础表－处理汇总-20210826.csv";
		// csvOriOverhaulRoughTableAdd(pathStr, dataVersion, calYearDate);

		dataVersion = "O_2021_2";
		calYearDate = "2021-08-26";
		// getCSVHeader(pathStr);
		// ORI_TECH_TRANSFORM_ROUGH_TABLE OriTechTransformRoughTable
		pathStr = "D:/temp/hebei/2021/技改基础表-汇总-20210826.csv";
		// csvOriTechTransformRoughTableAdd(pathStr, dataVersion, calYearDate);

		dataVersion = "O_2020_1";
		calYear = "2021";
		pathStr = "D:/temp/hebei/2021/PMS_20210208/2.1-2020年PMS-输电线路样表-V1.1-1-转换表头-20210218.csv";
		// csvPmsItemShuLineAdd(pathStr, dataVersion, calYear);
		pathStr = "D:/temp/hebei/2021/PMS_20210208/2.1-2020年PMS-输电线路样表-V1.1-2-转换表头-20210218.csv";
		// csvPmsItemShuLineAdd(pathStr, dataVersion, calYear);
		pathStr = "D:/temp/hebei/2021/PMS_20210208/2.1-2020年PMS-输电线路样表-V1.1-3-转换表头-20210218.csv";
		// csvPmsItemShuLineAdd(pathStr, dataVersion, calYear);
		// getCSVHeader(pathStr);
		pathStr = "D:/temp/hebei/2021/PMS_20210208/2.3-2020年PMS-变压器样表-V1.1-20210218.csv";
		// csvPmsItemTransformersAdd(pathStr, dataVersion, calYear);
		// getCSVHeader(pathStr);
		// PMS_ITEM_TRANS_SET_IN PmsItemTransSet
		pathStr = "D:/temp/hebei/2021/PMS_20210208/2.2-2020年PMS-变电设备样表-V1.1-20210218.csv";
		// csvPmsItemTransSetAdd(pathStr, dataVersion, calYear);
		// getCSVHeader(pathStr);

		pathStr = "D:/temp/hebei/2021/PMS_20210208/2.6-2020年PMS-环网柜样表-V1.1-20210218.csv";
		// getCSVHeader(pathStr);
		// csvPmsItemRingMainUnitAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hebei/2021/PMS_20210208/2.4-2020年PMS-配电线路样表-V1.0-20210208.csv";
		// getCSVHeader(pathStr);
		// csvPmsItemPeiLineAdd(pathStr, dataVersion, calYear);
		pathStr = "D:/temp/hebei/2021/PMS_20210208/2.5-2020年PMS-配电设备样表-V1.1-20210208.csv";
		// getCSVHeader(pathStr);
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hebei/2021/PMS_20210208/2.7-2020年PMS-自动化系统及设备样表-V1.1-20210218.csv";
		// getCSVHeader(pathStr);
		// csvPmsItemAutomaticAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hebei/2021/PMS_20210208/2.8-2020年PMS-仪器仪表及测试设备样表-V1.0-20210204.csv";
		// getCSVHeader(pathStr);
		// csvPmsItemToolsAdd(pathStr, dataVersion, calYear);
		pathStr = "D:/temp/hebei/2021/PMS_20210208/2.9-2020年PMS-缺陷样表-表头替换-V1.0-20210219.csv";
		// getCSVHeader(pathStr);
		// csvPmsQuexianAdd(pathStr, dataVersion, calYear); //OK 20210219 272264条

		// 2021 PMS 湖北

		pathStr = "D:/temp/hubei/2021年二季度PMS-20210812/变电设备.csv";
		dataVersion = "O_2021_1";
		calYear = "2021";
		// getCSVHeader(pathStr);
		// PMS_ITEM_TRANS_SET_IN PmsItemTransSet
		// csvPmsItemTransSetAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hubei/2021年二季度PMS-20210812/输电线路.csv";
		// PMS_ITEM_SHU_LINE_IN PmsItemShuLine
		// csvPmsItemShuLineAdd(pathStr, dataVersion, calYear);
		// getCSVHeader(pathStr);
		pathStr = "D:/temp/hubei/2021年二季度PMS-20210812/变压器.csv";
		// PMS_ITEM_TRANSFORMERS_IN PmsItemTransformers
		// csvPmsItemTransformersAdd(pathStr, dataVersion, calYear);
		// getCSVHeader(pathStr);

		pathStr = "D:/temp/hubei/2021年二季度PMS-20210812/环网柜.csv";
		// getCSVHeader(pathStr);
		// PMS_ITEM_RING_MAIN_UNIT_IN PmsItemRingMainUnit
		// csvPmsItemRingMainUnitAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hubei/2021年二季度PMS-20210812/配电线路.csv";
		// getCSVHeader(pathStr);
		// PMS_ITEM_PEI_LINE_IN PmsItemPeiLine
		// csvPmsItemPeiLineAdd(pathStr, dataVersion, calYear);
		pathStr = "D:/temp/hubei/2021年二季度PMS-20210812/配电设备.csv";
		// getCSVHeader(pathStr);
		// PMS_ITEM_PEI_SET_IN PmsItemPeiSet
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hubei/2021年二季度PMS-20210812/自动化系统及设备和继电保护及安全自动装置.csv";
		// getCSVHeader(pathStr);
		// PMS_ITEM_AUTOMATIC_IN PmsItemAutomatic
		// csvPmsItemAutomaticAdd(pathStr, dataVersion, calYear);

		pathStr = "D:/temp/hubei/2021年二季度PMS-20210812/仪器仪表及测试设备.csv";
		// getCSVHeader(pathStr);
		// PMS_ITEM_TOOLS_IN PmsItemTools
		// csvPmsItemToolsAdd(pathStr, dataVersion, calYear);
		pathStr = "D:/temp/hubei/2021年二季度PMS-20210812/缺陷.csv";
		// PMS_QUEXIAN_IN PmsQuexian
		// getCSVHeader(pathStr);
		// csvPmsQuexianAdd(pathStr, dataVersion, calYear); //OK 20210219 272264条

		//
		pathStr = "D:/temp/hubei/2021年二季度PMS-20210812/低压设备指标.csv";
		// getCSVHeader(pathStr);
		// ORI_LOW_VOL_STATION_LINE_EQUIP OriLowVolStationLineEquip
		// csvOriLowVolStationLineEquipAdd(pathStr, dataVersion, calYear);

		// 2021 ERP 湖北

		//
		pathStr = "D:/temp/hebei/2021/ERP-20210220/ANEP所有资产-替换表头-V1.1-20210220.csv";
		// getCSVHeader(pathStr);
		// ORI_FINANCE_POST_RECORD_ANEP
		// csvOriFinancePostRecordAnepAdd(pathStr, dataVersion, calYear);

		//
		pathStr = "D:/temp/hebei/2021/ERP-20210220/逾龄资产-替换表头-V1.1-20210220.csv";
		// getCSVHeader(pathStr);
		// csvOriOverAgeAssetAdd(pathStr, dataVersion, calYear);
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-27";
		//
		pathStr = "D:/temp/hubei/2021/ERP20210127/1、实物资产评价16-表头替换-V1.1-20210127.csv";
		// ZFI_SWZC_HUBEI_IN
		// csvZfiSwzcAdd( pathStr, versionValue, calYear);

		//
		pathStr = "D:/temp/hubei/2021/ERP20210127/2、实物资产评价非16-表头替换-V1.2-20210127 .csv";

		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-27";

		// ZFI_SWZC_HUBEI_IN，计划备份至表：ZFI_SWZC_HUBEI_IN_2020_1
		// csvZfiSwzcAdd( pathStr, versionValue, calYear);

		//
		pathStr = "D:/temp/hubei/2021/ERP20210127/3-2020全年资产过账记录-反馈表-替换表头-V1.0-20210127.csv";
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-27";

		// ORI_FULL_ASSET_ACCOUNT_POSTING，计划备份至ORI_FULL_ASSET_ACCOUNT_POS20_1;
		// oriFullAssetAccountPostingAdd( pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hubei/2021/ERP20210127/报废/1-报废明细记录-过账记录-主表-模板-替换表头-V1.0-20210128.csv";
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-28";
		// ORI_FINANCE_SCRAP_POST_RECORD
		// csvOriFinanceScrapPostRecordAdd(pathStr, versionValue, calYear);
		//
		pathStr =
				//
				"D:/temp/hubei/2021/ERP20210127/报废//3-报废明细记录2020年-过账记录-资产子表-模板-替换表头-V1.0-20210128.csv";
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-28";
		// ORI_FINANCE_SCRAP_POST_ASSET
		// csvOriFinanceScrapPostAssetAdd(pathStr, versionValue, calYear);
		//
		pathStr =
				//
				"D:/temp/hubei/2021/ERP20210127/报废/2-报废明细记录-过账记录-设备子表-模板-替换表头-V1.0-20210128.csv";
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-28";
		// ORI_FINANCE_SCRAP_POST_EQUIP
		// csvOriFinanceScrapPostEquipAdd(pathStr, versionValue, calYear);

		/*
		 * 2020年逾龄资产导入-开始行
		 * 
		 */
		//
		pathStr =
				//
				"D:/temp/hubei/2021/ERP20210127/逾龄/表1-2020-资产信息表-模板-替换表头-V1.0-20210128.csv";
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-28";
		// ORI_ASSET_INFORMATION_ITEM
		// csvOriAssetInformationItemAdd(pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hubei/2021/ERP20210127/逾龄/表2-2020-设备信息表-模板-表头替换-part1-V1.0-20210108.csv";
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-28";
		// ORI_EQUIPMENT_INFORMATION_ITEM
		// csvOriEquipmentInformationItemAdd(pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hubei/2021/ERP20210127/逾龄/表2-2020-设备信息表-模板-表头替换-part2-V1.0-20210108.csv";
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-28";
		// ORI_EQUIPMENT_INFORMATION_ITEM
		// csvOriEquipmentInformationItemAdd(pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hubei/2021/ERP20210127/逾龄/表3-2020-逾龄的清单-资产-模板-表头替换-V1.0-20210108.csv";
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-28";
		// ORI_OVER_AGE_ITEM
		// csvOriOverAgeItemAdd(pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hubei/2021/ERP20210127/逾龄/表4-2020-资产设备对应-模板-替换表头-part1-V1.0-20210108.csv";
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-28";
		// ORI_EQUIP_ASSET_RELATION_ITEM
		// csvOriEquipAssetRelationItemAdd(pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hubei/2021/ERP20210127/逾龄/表4-2020-资产设备对应-模板-替换表头-part2-V1.0-20210108.csv";
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-28";
		// ORI_EQUIP_ASSET_RELATION_ITEM
		// csvOriEquipAssetRelationItemAdd(pathStr, versionValue, calYear);

		/*
		 * 2020年逾龄资产导入-结束行
		 * 
		 */

		/*
		 * 2020年刘汶淇提供报废资产导入-开始
		 * 
		 */

		// pathStr
		// ="D:/temp/hubei/2021/ERP20210127/报废/3-2020年ERP报废台账清-湖北-替换表头-V1.0-20210118.csv";
		pathStr = "D:/temp/hubei/2021/ERP20210127/报废/3-2020年ERP报废台账清-湖北-替换表头-V1.1-20210301.csv";
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-03-02";
		// ZFI_SWZC_DISC_INCR
		// csvZfiSwzcDiscAdd(pathStr, versionValue, calYear);

		/*
		 * 2020年刘汶淇提供报废资产导入-结束行
		 * 
		 */

		//
		pathStr = "D:/temp/hubei/2021/ERP20210127/.csv";
		//
		versionValue = "O_2020_1";
		//
		calYear = "2021-01-27";
		// ORI_FULL_ASSET_CAPITALIZATION
		// 不在需要导入，直接与ZFI_SWZC_HUBEI_IN表中的全量数据进行匹配即可
		// oriFullAssetCapitalizationAdd(pathStr, versionValue, calYear);

		// pathStr ="D:/temp/hebei/ACCOUNT_POSTED/2019全年资产过账记录-替换表头-V1.0-20200610.csv";
		// versionValue = "O_2019_2";
		// calYear = "2020-06-10";

		// oriFullAssetAccountPostingAdd( pathStr, versionValue, calYear);

		//
		pathStr = "D:/temp/hebei/ACCOUNT_POSTED/资本化日期2019年资产原值-替换表头-V1.0-20200610.csv";
		//
		versionValue = "O_2019_2";
		// calYear = "2020-06-10";

		// oriFullAssetCapitalizationAdd(pathStr, versionValue, calYear);
		// ORI_FULL_ASSET_CAPITALIZATION
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/未完全分类的记录/BIC_AZFI_SWZC_2_CLASS_WRO_2019-08-06155728_0.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);

		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/未完全分类的记录/BIC_AZFI_SWZC_5_CLASS_WRO_2019-08-06155959_0.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/未完全分类的记录/BIC_AZFI_SWZC_5_CLASS_WRO_2019-08-06160005_1.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/未完全分类的记录/BIC_AZFI_SWZC_5_CLASS_WRO_2019-08-06160010_2.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/未完全分类的记录/BIC_AZFI_SWZC_7_CLASS_WRO_2019-08-06160020_0.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/未完全分类的记录/BIC_AZFI_SWZC_3_CLASS_WRO_2019-08-06155738_0.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/hebei/ERP/2-ERP报废资产台账清单-河北收集表-V1.1-20190807-20190902.csv";
		// versionValue = "O_2018_3";
		// calYear = "2018";
		// csvUpZfiaaBfAdd(pathStr, versionValue, calYear);

		// pathStr =
		// "D:/temp/hubei/20200409/表3-2019年ERP报废台账清单_0409-表头替换.csv";
		// versionValue = "O_2019_3";
		// calYear = "2019";
		// csvZfiSwzcDiscAdd(pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hebei/ERP/表3-2019年ERP报废台账清单-模板_0409_调整表头.csv";
		//
		versionValue = "O_2019_7";
		//
		calYear = "2019";
		// csvZfiSwzcDiscAdd(pathStr, versionValue, calYear);

		//
		dataVersion = "O_2019_1";
		calYear = "2021-01-14";
		//
		pathStr = "D:/temp/工作票/工作任务单-替换表头V1.0-20210114.csv";

		// oriWorkTaskInvoiceAdd(pathStr, dataVersion, calYear);

		// csvZfiSwzcHeBeiAdd();
		/*
		 * try { csvErpItemDiscardAdd(); } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		// csvErpItemReuseAdd();
		// csvErpItemDiscardHebeiAdd();
		// dateTest();
		/*
		 * String pathStr; pathStr="F:/temp/2017INCREASED_FEEDBACK_BAODING-OK.csv"; //
		 * CSV文件路径 csvErpItemIncreasedImpAdd(pathStr); pathStr=
		 * "F:/temp/2017INCREASED_FEEDBACK_CHANGZHOU-2018.10.12-OK20181031.csv"; //
		 * CSV文件路径 csvErpItemIncreasedImpAdd(pathStr); pathStr=
		 * "F:/temp/2017INCREASED_FEEDBACK_HANDAN-2018.10.12-OK20181031.csv";
		 * csvErpItemIncreasedImpAdd(pathStr); pathStr=
		 * "F:/temp/2017INCREASED_FEEDBACK_HENGSHUI-2018.10.12-OK20181031.csv";
		 * csvErpItemIncreasedImpAdd(pathStr);
		 * pathStr="F:/temp/2017INCREASED_FEEDBACK_JIANXIU-OK-201810310921.csv";
		 * csvErpItemIncreasedImpAdd(pathStr); pathStr=
		 * "F:/temp/2017INCREASED_FEEDBACK_SHIJIAZHUANG-2018.10.12-OK20181031.csv";
		 * csvErpItemIncreasedImpAdd(pathStr); pathStr=
		 * "F:/temp/2017INCREASED_FEEDBACK_XINGTAI-2018.10.12-OK20181031.csv";
		 * csvErpItemIncreasedImpAdd(pathStr);
		 */
		// String pathStr =
		// "F:/temp/ASSET_PROPERTY_RECORD_PART1_205000_20181105.csv";
		// String pathStr = "F:/temp/ASSET_PROPERTY_RECORD_PART2_20181105.csv";

		// csvErpPropertyRecordAdd(pathStr);
		// csvErpItemOldDiscardAdd();
		// csvPmsItemDefectHebeiAdd();
		// csvErpAnlcRecordAdd();
		// csvErpAnluRecordAdd();
		// csvErpAnlzRecordAdd();
		// csvZfiSwzcNewAdd();
		/*
		 * String pathStr; pathStr="F:/temp/SHEET-1-IMPORT-20181111-去除-#NA.csv";
		 * csvZfiSwzcNewAdd( pathStr);
		 * pathStr="F:/temp/SHEET-2-IMPORT-20181111-去除-#NA-2.csv"; csvZfiSwzcNewAdd(
		 * pathStr); pathStr="F:/temp/SHEET-3-IMPORT-20181111-去除-#NA.csv";
		 * csvZfiSwzcNewAdd( pathStr); pathStr="F:/temp/SHEET-W1-IMPORT-20181111-3.csv";
		 * csvZfiSwzcNewAdd( pathStr); pathStr="F:/temp/SHEET-W2-IMPORT-20181111.csv";
		 * csvZfiSwzcNewAdd( pathStr); pathStr="F:/temp/SHEET-W3-IMPORT-20181111.csv";
		 * csvZfiSwzcNewAdd( pathStr); //pathStr="F:/temp/SHEET-W4-IMPORT-20181111.csv";
		 * //csvZfiSwzcNewAdd( pathStr); pathStr="F:/temp/SHEET-W5-IMPORT-20181111.csv";
		 * csvZfiSwzcNewAdd( pathStr); pathStr="F:/temp/SHEET-W6-IMPORT-20181111.csv";
		 * csvZfiSwzcNewAdd( pathStr); pathStr="F:/temp/SHEET-W7-IMPORT-20181111.csv";
		 * csvZfiSwzcNewAdd( pathStr); pathStr="F:/temp/SHEET-W8-IMPORT-20181111.csv";
		 * csvZfiSwzcNewAdd( pathStr); pathStr="F:/temp/SHEET-W9-IMPORT-20181111.csv";
		 * csvZfiSwzcNewAdd( pathStr);
		 * pathStr="F:/temp/SHEET-W10-IMPORT-20181111-去除#NA.csv"; csvZfiSwzcNewAdd(
		 * pathStr);
		 */
		/*
		 * String pathStr;
		 * pathStr="F:/temp/2ANLA2018 (v222)-SHEET1-IMPORT-20181111.csv";
		 * csvErp2anlaRecordSheet1Add( pathStr);
		 * pathStr="F:/temp/2ANLA2018 (v222)-SHEET2-IMPORT-20181111.csv";
		 * csvErp2anlaRecordSheet2Add( pathStr);
		 * pathStr="F:/temp/2ANLA2018 (v222)-SHEET3-IMPORT-20181111.csv";
		 * csvErp2anlaRecordSheet3Add( pathStr);
		 * pathStr="F:/temp/2ANLA2018 (v222)-SHEET5-IMPORT-20181111.csv";
		 * csvErp2anlaRecordSheet5Add(pathStr);
		 * pathStr="F:/temp/2ANLA2018 (v222)-SHEET6-IMPORT-20181111-2.csv";
		 * csvErp2anlaRecordSheet6Add(pathStr);
		 * pathStr="F:/temp/2ANLA2018 (v222)-SHEET7-IMPORT-20181111-2.csv";
		 * csvErp2anlaRecordSheet7Add(pathStr);
		 * pathStr="F:/temp/2ANLA2018 (v222)-SHEET8-IMPORT-20181111.csv";
		 * csvErp2anlaRecordSheet8Add(pathStr);
		 * pathStr="F:/temp/2ANLA2018 (v222)-SHEET9-IMPORT-20181111.csv";
		 * csvErp2anlaRecordSheet9Add(pathStr);
		 * pathStr="F:/temp/2ANLA2018 (v222)-SHEET10-IMPORT-20181111.csv";
		 * csvErp2anlaRecordSheet10Add(pathStr);
		 * pathStr="F:/temp/2ANLA2018 (v222)-SHEET11-IMPORT-20181111.csv";
		 * csvErp2anlaRecordSheet11Add(pathStr);
		 * pathStr="F:/temp/2ANLA2018 (v222)-SHEET12-IMPORT-20181111.csv";
		 * csvErp2anlaRecordSheet12Add(pathStr);
		 * pathStr="F:/temp/2ANLA2018 (v222)-SHEET13-IMPORT-20181111.csv";
		 * csvErp2anlaRecordSheet13Add(pathStr);
		 */
		/*
		 * String pathStr; pathStr="F:/temp/CSKS-IMPORT-20181111.csv";
		 * csvErpCsksRecordAdd( pathStr);
		 */

		/*
		 * String pathStr; pathStr="F:/temp/2017DEFECT-BAODING-IMPORT-20181111.csv";
		 * csvPmsItemDefectHebeiAdd( pathStr);
		 * pathStr="F:/temp/2017DEFECT-CHANGZHOU-IMPORT-20181111.csv";
		 * csvPmsItemDefectHebeiAdd( pathStr);
		 * pathStr="F:/temp/2017DEFECT-HANDANG-IMPORT-20181111.csv";
		 * csvPmsItemDefectHebeiAdd( pathStr);
		 * pathStr="F:/temp/2017DEFECT-HENGSHUI-IMPORT-20181111.csv";
		 * csvPmsItemDefectHebeiAdd( pathStr);
		 * pathStr="F:/temp/2017DEFECT-JIANXIU-IMPORT-20181111-2.csv";
		 * csvPmsItemDefectHebeiAdd( pathStr);
		 * pathStr="F:/temp/2017DEFECT-SHIJIAZHUANG-IMPORT-20181111-2.csv";
		 * csvPmsItemDefectHebeiAdd( pathStr);
		 * pathStr="F:/temp/2017DEFECT-XINGTAI-IMPORT-20181111-2.csv";
		 * csvPmsItemDefectHebeiAdd( pathStr);
		 */
		/*
		 * String pathStr;
		 * pathStr="F:/temp/2017ErpDiscardDepreciationValue-20181116.csv";
		 * csvErpDiscardDepreciationValueAdd( pathStr);
		 */
		/*
		 * String pathStr; pathStr="F:/temp/CLASS_3_VOLTAGE_LEVEL-20181117.csv";
		 * csvUpdateVoltageLevelAdd( pathStr);
		 */
		// String pathStr;
		// pathStr = "F:/temp/TECH_REF_PRO_SIN_ENG_DECOMPOSE-20181203-6.csv";
		// csvTechRefProSinEngDecomposeAdd(pathStr);

		// String pathStr;
		// pathStr = "F:/temp/oriPmsTransformerSubstation-20190113-1.csv";
		// csvOriPmsTransformerSubstationAdd(pathStr);

		// String pathStr;
		// pathStr = "F:/temp/oriPmsTransformer-20190113-1.csv";
		// csvOriPmsTransformerAdd(pathStr);
		// System.out.println("1987-01-03 00:00:00.0".substring(0,19));

		//
		dataVersion = "O_2019_1";
		calYear = "2019-12-31";
		// pathStr = "D:/temp/hubei/实物ID与设备ID的对应关系20200525/EXPORT-表头替换.csv" ;
		// csvOriEquipmentRealAssetCodeAdd(pathStr, dataVersion, calYear);

		//
		dataVersion = "O_2019_1";
		calYear = "2019-12-31";
		// 2020-10-09
		//
		pathStr = "D:/temp/hebei/20201009/国网调整后河北技改项目820项（资产性质省公司）-替换表头-V1.2-20201009.csv";
		// csvOriTechTransformProjectAdd(pathStr, dataVersion, calYear);
		//
		// 1
		//
		dataVersion = "O_2015_1";
		calYear = "2020-12-21";
		// 2020-10-09
		//
		pathStr = "D:/temp/故障查询数据导出-河北/故障查询数据导出-2015-替换表头.csv";

		// csvOriEquipmentBreakdownAdd(pathStr, dataVersion, calYear);
		//
		dataVersion = "O_2016_1";
		calYear = "2020-12-21";
		// 2020-10-09
		//
		pathStr = "D:/temp/故障查询数据导出-河北/故障查询数据导出-2016-替换表头.csv";

		// csvOriEquipmentBreakdownAdd(pathStr, dataVersion, calYear);
		//
		dataVersion = "O_2017_1";
		calYear = "2020-12-21";
		// 2020-10-09
		//
		pathStr = "D:/temp/故障查询数据导出-河北/故障查询数据导出-2017-替换表头.csv";

		// csvOriEquipmentBreakdownAdd(pathStr, dataVersion, calYear);
		//
		dataVersion = "O_2018_2";
		calYear = "2020-12-21";
		// 2020-10-09
		//
		pathStr = "D:/temp/故障查询数据导出-河北/故障查询数据导出-2018-替换表头.csv";

		// csvOriEquipmentBreakdownAdd(pathStr, dataVersion, calYear);

		//
		dataVersion = "O_2019_1";
		calYear = "2020-12-21";
		// 2020-10-09
		//
		pathStr = "D:/temp/故障查询数据导出-河北/2019故障查询数据导出-替换表头-6.4.csv";

		// csvOriEquipmentBreakdownAdd(pathStr, dataVersion, calYear);
		//
		dataVersion = "O_2019_1";
		calYear = "2019-12-31";
		// 2020-10-09
		//
		pathStr = "D:/temp/hebei/20201009/国网调整后大修项目1271项（资产性质省公司）-替换表头-V1.0-20201009.csv";
		// csvOriOverhaulProjectAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200407/1输电线路.csv" ;
		// csvPmsItemShuLineAdd(pathStr, dataVersion, calYear); //

		// pathStr = "D:/temp/hubei/20200407/2变压器.csv";
		// csvPmsItemTransformersAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200407/2变电设备.csv";
		// csvPmsItemTransSetAdd(pathStr, dataVersion, calYear);

		//
		pathStr = "D:/temp/hubei/20200407/3配电线路.csv";
		//
		// csvPmsItemPeiLineAdd(pathStr, dataVersion, calYear);

		String columnName = "";
		List<String> columnValueList = new ArrayList();
		// 从CSV文件中检索需要查找的数据
		// csvQueryByEquipmentIDList(pathStr, columnName, columnValueList);

		// pathStr = "D:/temp/hubei/20200407/3配电设备.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200407/4环网柜.csv";
		// csvPmsItemRingMainUnitAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200407/5仪器仪表.csv";
		// csvPmsItemToolsAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200407/6自动化设备.csv";
		// csvPmsItemAutomaticAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200407/7缺陷.csv";
		// csvPmsQuexianAdd(pathStr, dataVersion, calYear); //OK 20190905 201200条

		//
		dataVersion = "O_2019_3";
		calYear = "2019";
		// pathStr =
		// "D:/temp/hebei/20200709/2019年当年的缺陷记录-去除发生日期为2018年的数据-V1.0-20200708-替换表头.csv";
		// csvPmsQuexianAdd(pathStr, dataVersion, calYear);

		// pathStr =
		// "D:/temp/hubei/20200407/8低压指标.csv";
		// csvOriLowVolStationLineEquipAdd(pathStr, dataVersion, calYear);

		//
		dataVersion = "O_2019_3";
		calYear = "2019";

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版配电线路与设备补充/07-配电线路.csv";
		// csvPmsItemPeiLineAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版配电线路与设备补充/08-配电线路.csv";
		// csvPmsItemPeiLineAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版配电线路与设备补充/00.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200416/PMS河北_柱上变压器2020040801.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200416/PMS河北_柱上变压器2020040802.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200416/PMS河北_柱上变压器2020040803.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版配电线路与设备补充/01-更正.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版配电线路与设备补充/02.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版配电线路与设备补充/03.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版配电线路与设备补充/04-更正.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版配电线路与设备补充/05.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版配电线路与设备补充/06.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版原始数据20200407/1、输电线路.csv" ;
		// csvPmsItemShuLineAdd(pathStr, dataVersion, calYear); //

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版原始数据20200407/2、主变压器.csv";
		// csvPmsItemTransformersAdd(pathStr, dataVersion, calYear);
		//
		pathStr = "D:/temp/hebei/20200407/PMS河北第2版原始数据20200407/3、变电设备.csv";
		// csvPmsItemTransSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版原始数据20200407/4、配电线路.csv";
		// csvPmsItemPeiLineAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版原始数据20200407/5、配电设备.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版原始数据20200407/11、环网柜.csv";
		// csvPmsItemRingMainUnitAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版原始数据20200407/7、仪器仪表.csv";
		// csvPmsItemToolsAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版原始数据20200407/8、自动化系统.csv";
		// csvPmsItemAutomaticAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/PMS河北第2版原始数据20200407/9、缺陷.csv";
		// csvPmsQuexianAdd(pathStr, dataVersion, calYear); //OK 20190905 201200条

		// pathStr =
		// "D:/temp/hebei/20200407/PMS河北第2版原始数据20200407/10、PMS低压设备计算指标.csv";
		// csvOriLowVolStationLineEquipAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/ERP河北0408-资产报废清单V2_20200408.csv";
		// dataVersion = "O_2019_2";
		// calYear = "2019";
		// csvUpZfiaaBfAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hebei/20200407/ERP河北第1版数据20200407/ERP河北-资产报废清单.csv";
		// dataVersion = "O_2019_1";
		// calYear = "2019";
		// csvUpZfiaaBfAdd(pathStr, dataVersion, calYear);

		//
		dataVersion = "O_2019_2";
		calYear = "2019";
		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/输电线路.csv" ;
		// csvPmsItemShuLineAdd(pathStr, dataVersion, calYear); //

		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/变压器.csv";
		// csvPmsItemTransformersAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/变电设备.csv";
		// csvPmsItemTransSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/配电线路.csv";
		// csvPmsItemPeiLineAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/配电设备.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/环网柜.csv";
		// csvPmsItemRingMainUnitAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/仪器仪表及测试设备.csv";
		// csvPmsItemToolsAdd(pathStr, dataVersion, calYear);

		// pathStr =
		// "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/自动化系统及设备和继电保护及安全自动装置.csv";
		// csvPmsItemAutomaticAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/缺陷.csv";
		// dataVersion = "O_2019_1";
		// csvPmsQuexianAdd(pathStr, dataVersion, calYear); //OK 20190905 201200条

		// pathStr =
		// "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/低压设备指标统计.csv";
		// csvOriLowVolStationLineEquipAdd(pathStr, dataVersion, calYear); //

		//
		dataVersion = "O_2019_2";
		calYear = "2019";
		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/输电线路.csv" ;
		// csvPmsItemShuLineAdd(pathStr, dataVersion, calYear); //

		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/变压器.csv";
		// csvPmsItemTransformersAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/变电设备.csv";
		// csvPmsItemTransSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/配电线路.csv";
		// csvPmsItemPeiLineAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/配电设备.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/环网柜.csv";
		// csvPmsItemRingMainUnitAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/仪器仪表及测试设备.csv";
		// csvPmsItemToolsAdd(pathStr, dataVersion, calYear);

		// pathStr =
		// "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/自动化系统及设备和继电保护及安全自动装置.csv";
		// csvPmsItemAutomaticAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/缺陷.csv";

		// csvPmsQuexianAdd(pathStr, dataVersion, calYear); //OK 20190905 201200条

		// pathStr =
		// "D:/temp/hubei/20200405/2-湖北PMS原始单体数据-V1.0-20200403/低压设备指标统计.csv";
		// csvOriLowVolStationLineEquipAdd(pathStr, dataVersion, calYear);

		dataVersion = "O_2018_2";
		calYear = "2018";
		// pathStr = "D:/temp/hebei/20200405/河北PMS-实物资产数据-V1.0-20200403/1、输电线路.csv" ;
		// csvPmsItemShuLineAdd(pathStr, dataVersion, calYear); //
		// pathStr = "D:/temp/PMS9类设备-20190724/2.二、1变压器.csv";
		// csvPmsItemTransformersAdd(pathStr);
		// pathStr = "D:/temp/PMS9类设备-20190724/2.二、变电设备.csv";
		// csvPmsItemTransSetAdd(pathStr);
		// pathStr = "D:/temp/PMS9类设备-20190724/仪器仪表及测试设备.csv";
		// csvPmsItemToolsAdd(pathStr);
		// pathStr = "D:/temp/PMS9类设备-20190724/环网柜.csv";
		// csvPmsItemRingMainUnitAdd(pathStr);
		// pathStr = "D:/temp/PMS9类设备-20190724/3.三、1配电线路.csv";
		// csvPmsItemPeiLineAdd(pathStr);
		// pathStr = "D:/temp/PMS9类设备-20190724/自动化系统及设备和继电保护及安全自动装置.csv";
		// csvPmsItemAutomaticAdd(pathStr);
		// pathStr = "D:/temp/hebei/PMS/配电设备-低压台区.csv";
		// csvPmsItemLowVoltPlatAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hebei/PMS/一、输电线路.csv";
		// csvPmsItemShuLineAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hebei/PMS/二、变压器.csv";
		// csvPmsItemTransformersAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hebei/PMS/三、变电设备.csv";
		// csvPmsItemTransSetAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hebei/PMS/3.1、配电线路.csv";
		// csvPmsItemPeiLineAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hebei/PMS/3.2配电设备.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hebei/PMS/4.环网柜.csv";
		// csvPmsItemRingMainUnitAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hebei/PMS/5.仪器仪表及测试设备20190829.csv";
		// csvPmsItemToolsAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hebei/PMS/6.自动化系统及设备和继电保护及安全自动装置20190829.csv";
		// csvPmsItemAutomaticAdd(pathStr, dataVersion, calYear);

		// String versionValue;
		// pathStr = "D:/temp/hebei/PMS/7.缺陷20190829.csv";
		// versionValue = "O_2018_2";
		// csvPmsQuexianAdd(pathStr, versionValue); //OK 20190905 201200条
		// String versionValue;

		// pathStr = "D:/temp/hebei/PMS/光缆段20190716.csv";
		// versionValue = "O_2018_1";
		// csvOriOpticalCableSectionAdd(pathStr, versionValue); // OK 20190905 条

		// pathStr = "D:/temp/hebei/PMS/SDH_PTN_OTN设备20190716.csv";
		// versionValue = "O_2018_1";
		// csvOriOpticalCableTerminal(pathStr, versionValue); // OK 20190905 条

		// pathStr = "D:/temp/hubei-20190727/TMS系统光缆表-201909061.csv";
		// versionValue = "O_2018_1";
		// csvOriOpticalCableSectionAdd(pathStr, versionValue); // 条

		// pathStr = "D:/temp/hubei/20200409/湖北TMS光缆数据【2019-12-31前】 20200409表头替换.csv";
		// versionValue = "O_2019_2";
		// csvOriOpticalCableSectionAdd(pathStr, versionValue); // 条

		//
		pathStr = "D:/temp/hebei/20200612/光缆段200407151542-替换表头.csv";
		//
		versionValue = "O_2019_3";
		// csvOriOpticalCableSectionAdd(pathStr, versionValue); // 条
		// ORI_OPTICAL_CABLE_SECTION
		// pathStr = "D:/temp/hubei-20190727/PMS-20190815/缺陷.csv";
		// versionValue = "O_2018_3";
		// csvPmsQuexianAdd(pathStr, versionValue);

		// dataVersion = "O_2018_3";
		// calYear = "2018";
		// pathStr = "D:/temp/hebei/PMS/二、变压器.csv";
		// csvPmsItemLowVoltPlatAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei-20190727/PMS-20190815/输电线路.csv";
		// csvPmsItemShuLineAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei-20190727/PMS-20190815/变压器.csv";
		// csvPmsItemTransformersAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hubei-20190727/PMS-20190815/变电设备.csv";
		// csvPmsItemTransSetAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hubei-20190727/PMS-20190815/仪器仪表及测试设备.csv";
		// csvPmsItemToolsAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hubei-20190727/PMS-20190815/环网柜.csv";
		// csvPmsItemRingMainUnitAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hubei-20190727/PMS-20190815/配电设备.csv";
		// csvPmsItemPeiSetAdd(pathStr, dataVersion, calYear);
		// pathStr = "D:/temp/hubei-20190727/PMS-20190815/配电线路.csv";
		// csvPmsItemPeiLineAdd(pathStr, dataVersion, calYear);

		// pathStr = "D:/temp/hubei-20190727/PMS-20190815/自动化系统及设备和继电保护及安全自动装置.csv";
		// csvPmsItemAutomaticAdd(pathStr, dataVersion, calYear);

		// String versionValue;
		// pathStr = "D:/temp/PMS9类设备-20190724/缺陷.csv";
		// versionValue = "O_2018_2";
		// csvPmsQuexianAdd(pathStr, versionValue);
		// pathStr = "D:/temp/供电责任原因/2014.csv";
		// dataVersion = "O_2014_1";
		// calYera = "2018-07-22";
		// csvOriPowerSupplyDutyReasonAdd(pathStr,dataVersion,calYera);

		// pathStr = "D:/temp/供电责任原因/2015.csv";
		// dataVersion="O_2015_1";
		// calYera="2018-07-22";
		// csvOriPowerSupplyDutyReasonAdd(pathStr,dataVersion,calYera);

		// pathStr = "D:/temp/供电责任原因/2016.csv";
		// dataVersion="O_2016_1";
		// calYera="2018-07-22";
		// csvOriPowerSupplyDutyReasonAdd(pathStr,dataVersion,calYera);
		// pathStr = "D:/temp/供电责任原因/2017.csv";
		// dataVersion="O_2017_1";
		// calYera="2018-07-22";
		// csvOriPowerSupplyDutyReasonAdd(pathStr,dataVersion,calYera);

		// pathStr = "D:/temp/供电责任原因/2018.csv";
		// dataVersion="O_2018_1";
		//// calYera="2018-07-22";
		// csvOriPowerSupplyDutyReasonAdd(pathStr,dataVersion,calYera);

		// pathStr = "D:/temp/hubei-20190727/供电责任原因/2014年供电停电事件责任原因分类-IMPORT.csv";
		// dataVersion = "O_2014_1";
		// calYera = "2018-09-17";
		// csvOriPowerSupplyDutyReasonAdd(pathStr, dataVersion, calYera);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// pathStr = "D:/temp/20200108/110kV、220kV操作票记录-IMPORT-V1.0-20200108.csv";
		// dataVersion = "O_2019_1";
		// calYera = simpleDateFormat.format(new Date());// "2020-01-08 10:28:33";
		// System.out.println(new Date().toLocaleString());
		// System.out.println(simpleDateFormat.format(new Date()));
		// csvOriOperationTicketRecordAdd(pathStr, dataVersion, calYera);

		// pathStr = "D:/temp/20200108/110kV、220kV工作任务单记录-IMPORT-V1.0-20200107.csv";
		// dataVersion = "O_2019_1";
		// calYera = simpleDateFormat.format(new Date());

		// csvOriWorkTaskDocumentRecordAdd(pathStr, dataVersion, calYera);
		// pathStr = "D:/temp/20200108/110kV、220kV工作票记录-IMPORT-V1.0-20200107.csv";
		// dataVersion = "O_2019_1";
		// calYera = simpleDateFormat.format(new Date());
		// csvOriWorkTicketRecordAdd(pathStr, dataVersion, calYera);

		// pathStr = "D:/temp/20200112/工单20191216-2012.csv";
		// dataVersion = "O_2019_1";
		// calYera = simpleDateFormat.format(new Date());
		// csvOriOrderRecordAdd(pathStr, dataVersion, calYera);
		// pathStr = "D:/temp/20200112/工单20191216-2010-2011.csv";
		// dataVersion = "O_2019_1";
		// calYera = simpleDateFormat.format(new Date());
		// csvOriOrderRecordAdd(pathStr, dataVersion, calYera);
		// pathStr = "D:/temp/20200112/工单20191216-2013-2019.csv";
		// dataVersion = "O_2019_1";
		// calYera = simpleDateFormat.format(new Date());
		// csvOriOrderRecordAdd(pathStr, dataVersion, calYera);

		// pathStr = "D:/temp/hubei-20190727/供电责任原因/2015年供电停电事件责任原因分类-IMPORT.csv";
		// dataVersion="O_2015_1";
		// calYera="2018-09-17";
		// csvOriPowerSupplyDutyReasonAdd(pathStr,dataVersion,calYera);

		// pathStr = "D:/temp/hubei-20190727/供电责任原因/2016年供电停电事件责任原因分类-IMPORT.csv";
		// dataVersion="O_2016_1";
		// calYera="2018-09-17";
		// csvOriPowerSupplyDutyReasonAdd(pathStr,dataVersion,calYera);
		// pathStr = "D:/temp/hubei-20190727/供电责任原因/2017年供电停电事件责任原因分类-IMPORT.csv";
		// dataVersion="O_2017_1";
		// calYera="2018-09-17";
		// csvOriPowerSupplyDutyReasonAdd(pathStr,dataVersion,calYera);

		// pathStr = "D:/temp/hubei-20190727/供电责任原因/2018年供电停电事件责任原因分类-IMPORT.csv";
		// dataVersion="O_2018_1";
		// calYera="2018-09-17";
		// csvOriPowerSupplyDutyReasonAdd(pathStr,dataVersion,calYera);

		// pathStr = "D:/temp/配网故障/2014/2014-1.csv";
		/*
		 * pathStr = "D:/temp/配网故障/2014/2014-2.csv";
		 * csvOriDistributionNetworkFaultAdd(pathStr); pathStr =
		 * "D:/temp/配网故障/2014/2014-3.csv"; csvOriDistributionNetworkFaultAdd(pathStr);
		 * pathStr = "D:/temp/配网故障/2014/2014-4.csv";
		 * csvOriDistributionNetworkFaultAdd(pathStr); pathStr =
		 * "D:/temp/配网故障/2014/2014-5.csv"; csvOriDistributionNetworkFaultAdd(pathStr);
		 * pathStr = "D:/temp/配网故障/2014/2014-6.csv";
		 * csvOriDistributionNetworkFaultAdd(pathStr); pathStr =
		 * "D:/temp/配网故障/2014/2014-7.csv"; csvOriDistributionNetworkFaultAdd(pathStr);
		 * pathStr = "D:/temp/配网故障/2014/2014-8.csv";
		 * csvOriDistributionNetworkFaultAdd(pathStr); pathStr =
		 * "D:/temp/配网故障/2014/2014-9.csv"; csvOriDistributionNetworkFaultAdd(pathStr);
		 */
		/*
		 * pathStr = "D:/temp/配网故障/2018/2018-1.csv";
		 * csvOriDistributionNetworkFaultAdd(pathStr);
		 */
		/*
		 * pathStr = "D:/temp/配网故障/2018/2018-2.csv";
		 * csvOriDistributionNetworkFaultAdd(pathStr);
		 */
		/*
		 * pathStr = "D:/temp/配网故障/2018/2018-3.csv";
		 * csvOriDistributionNetworkFaultAdd(pathStr);
		 */
		/*
		 * pathStr = "D:/temp/配网故障/2018/2018-4.csv";
		 * csvOriDistributionNetworkFaultAdd(pathStr);
		 */
		/*
		 * pathStr = "D:/temp/配网故障/2018/2018-5.csv";
		 * csvOriDistributionNetworkFaultAdd(pathStr);
		 */
		/*
		 * pathStr = "D:/temp/配网故障/2018/2018-6.csv";
		 * csvOriDistributionNetworkFaultAdd(pathStr);
		 */
		// pathStr = "D:/temp/配网故障/2017/2017-1.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2017/2017-2.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2017/2017-3.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2017/2017-4.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2017/2017-5.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);

		// pathStr = "D:/temp/配网故障/2016/2016-1.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2016/2016-2.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2016/2016-3.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2016/2016-4.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2016/2016-5.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2016/2016-6.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2016/2016-7.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2016/2016-8.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);

		// pathStr = "D:/temp/配网故障/2015/2015.1.01-05.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/2015.2.6-7.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/2015.3.8-11.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/2015.4.12-15.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/2015.5.11-13.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/2015.6.13-16.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/2015.7.17.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/2015.7.18.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/2015.8.20-23.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/2015.9.13-30.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/2015.10.1-10.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/2015.11.10-15.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/2015.12.20-23.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);

		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.1.15.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.1.20.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.1.31.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.2.15.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.2.28.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.3.10.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.3.15.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.3.20.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.3.23.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.3.25.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.3.29.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.3.30.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.3.31.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015/新建文件夹/2015.4.05.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);

		// pathStr = "D:/temp/配网故障/2014.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2015.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2016.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2017.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);
		// pathStr = "D:/temp/配网故障/2018.csv";
		// csvOriDistributionNetworkFaultAdd(pathStr);

		// pathStr = "D:/temp/hubei-20190727/备品备件信息-2.csv";
		// versionValue = "O_2018_1";
		// csvPmsItemBackupAdd(pathStr, versionValue);
		// String versionValue;
		// pathStr = "D:/temp/hubei-20190727/再利用设备查询统计2.csv";
		// versionValue = "O_2018_1";
		// csvPmsItemReuseAdd(pathStr, versionValue);
		// pathStr = "D:/temp/hebei/备品备件与再利用/再利用查询-DOING.csv";
		// versionValue = "O_2018_1";
		// csvPmsItemReuseAdd(pathStr, versionValue);
		// pathStr = "D:/temp/hebei/备品备件与再利用/备品备件-DOING.csv";
		// versionValue = "O_2018_1";
		// calYear="2019-08-01";
		// csvPmsItemBackupAdd(pathStr, versionValue,calYear);

		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150127_0.csv";
		// versionValue = "O_2018_4";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);

		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150127_0.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/ERP未有效分类的记录-20190801反馈CSV/BIC_AZFI_SWZC00_182_UNCLASSED_2019-07-31173748_0.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/ERP未有效分类的记录-20190801反馈CSV/BIC_AZFI_SWZC00_182_UNCLASSED_2019-07-31173807_1.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/ERP未有效分类的记录-20190801反馈CSV/BIC_AZFI_SWZC00_182_UNCLASSED_2019-07-31173821_2.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/ERP未有效分类的记录-20190801反馈CSV/BIC_AZFI_SWZC00_182_UNCLASSED_2019-07-31173828_3.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/ERP未有效分类的记录-20190801反馈CSV/BIC_AZFI_SWZC00_182_UNCLASSED_2019-07-31173853_4.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/ERP未有效分类的记录-20190801反馈CSV/BIC_AZFI_SWZC00_182_UNCLASSED_2019-07-31173903_5.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:\\temp\\hubei-20190727\\ERP-王志强\\表1-2018年ERP资产台账清单-V1.1-20190718-DOING-16大类.csv";
		// versionValue = "O_2018_3";
		// calYear = "2019-08-01";
		// csvZfiSwzcAdd(pathStr, versionValue, calYear);
		// pathStr =
		// "D:\\temp\\hubei-20190727\\ERP-王志强\\表1-2018年ERP资产台账清单-V1.1-20190718-DOING-非16大类.csv";
		// versionValue = "O_2018_3";
		// calYear = "2019-08-01";
		// csvZfiSwzcAdd(pathStr, versionValue, calYear);

		// pathStr =
		// "D:\\temp\\hubei-20190727\\ERP-20190821\\资产价值更新20190821-16.csv";
		// versionValue = "O_2018_4";
		// calYear = "2019-08-21";
		// csvZfiSwzc16classValueAdd( pathStr, versionValue, calYear);

		// pathStr =
		// "D:\\temp\\hubei-20190727\\ERP-20190821\\资产价值更新20190821-非16.csv";
		// versionValue = "O_2018_4";
		// calYear = "2019-08-21";

		// csvZfiSwzcNo16classValueAdd( pathStr, versionValue, calYear);

		// pathStr ="D:/temp/hubei/ERP湖北VERSION20200426/表1-2019年16第一批.csv";
		//
		versionValue = "O_2019_3";
		//
		calYear = "2020-04-24";
		// csvZfiSwzcAdd( pathStr, versionValue, calYear);

		// pathStr ="D:/temp/hubei/ERP湖北VERSION20200426/表1-2019年16第二批.csv";
		//
		versionValue = "O_2019_3";
		//
		calYear = "2020-04-24";
		// csvZfiSwzcAdd( pathStr, versionValue, calYear);

		// pathStr ="D:/temp/hubei/ERP湖北VERSION20200426/表1-2019年非16第一批.csv";
		//
		versionValue = "O_2019_3";
		//
		calYear = "2020-04-24";
		// csvZfiSwzcAdd( pathStr, versionValue, calYear);

		// pathStr ="D:/temp/hubei/ERP湖北VERSION20200426/表1-2019年非16第二批.csv";
		//
		versionValue = "O_2019_3";
		//
		calYear = "2020-04-24";

		// csvZfiSwzcAdd( pathStr, versionValue, calYear);

		// pathStr ="D:/temp/hubei/财务提供20200508/16资产-财务提供20200508-替换表头.csv";
		// versionValue = "O_2019_4";
		// calYear = "2020-05-08";
		// csvZfiSwzcAdd( pathStr, versionValue, calYear);

		// pathStr ="D:/temp/hubei/财务提供20200508/非16资产财务提供20200508-替换表头.csv";
		// versionValue = "O_2019_4";
		// calYear = "2020-05-08";

		// csvZfiSwzcAdd( pathStr, versionValue, calYear);

		// pathStr ="D:/temp/hubei/财务提供事务记录20200514/全量资产2019过账记录-2019全年资产过账记录-替换表头.csv";
		// versionValue = "O_2019_1";
		// calYear = "2020-05-14";

		// oriFullAssetAccountPostingAdd( pathStr, versionValue, calYear);

		// pathStr =
		// "D:/temp/hubei/财务提供事务记录20200514/全量资产2019过账记录-资本化日期2019年资产原值-表头替换.csv";
		// versionValue = "O_2019_1";
		// calYear = "2020-05-14";

		// oriFullAssetCapitalizationAdd(pathStr, versionValue, calYear);

		// pathStr ="D:/temp/hebei/ACCOUNT_POSTED/2019全年资产过账记录-替换表头-V1.0-20200610.csv";
		// versionValue = "O_2019_2";
		// calYear = "2020-06-10";

		// oriFullAssetAccountPostingAdd( pathStr, versionValue, calYear);

		//
		pathStr = "D:/temp/hebei/ACCOUNT_POSTED/资本化日期2019年资产原值-替换表头-V1.0-20200610.csv";
		//
		versionValue = "O_2019_2";
		// calYear = "2020-06-10";

		// oriFullAssetCapitalizationAdd(pathStr, versionValue, calYear);
		// ORI_FULL_ASSET_CAPITALIZATION
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/未完全分类的记录/BIC_AZFI_SWZC_2_CLASS_WRO_2019-08-06155728_0.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);

		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/未完全分类的记录/BIC_AZFI_SWZC_5_CLASS_WRO_2019-08-06155959_0.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/未完全分类的记录/BIC_AZFI_SWZC_5_CLASS_WRO_2019-08-06160005_1.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/未完全分类的记录/BIC_AZFI_SWZC_5_CLASS_WRO_2019-08-06160010_2.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/未完全分类的记录/BIC_AZFI_SWZC_7_CLASS_WRO_2019-08-06160020_0.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/未完全分类的记录/BIC_AZFI_SWZC_3_CLASS_WRO_2019-08-06155738_0.csv";
		// versionValue = "O_2018_2";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/hebei/ERP/2-ERP报废资产台账清单-河北收集表-V1.1-20190807-20190902.csv";
		// versionValue = "O_2018_3";
		// calYear = "2018";
		// csvUpZfiaaBfAdd(pathStr, versionValue, calYear);

		// pathStr =
		// "D:/temp/hubei/20200409/表3-2019年ERP报废台账清单_0409-表头替换.csv";
		// versionValue = "O_2019_3";
		// calYear = "2019";
		// csvZfiSwzcDiscAdd(pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hebei/ERP/表3-2019年ERP报废台账清单-模板_0409_调整表头.csv";
		//
		versionValue = "O_2019_7";
		//
		calYear = "2019";
		// csvZfiSwzcDiscAdd(pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hebei/ERP/表3-2019年ERP报废台账清单_0409-河北-erp反馈-调整2.csv";
		//
		versionValue = "O_2019_6";
		//
		calYear = "2019";
		// csvZfiSwzcDiscAdd(pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hubei/报废20200715/报废明细记录2019年-过账记录-主表-侯安提供-替换表头-20200702.csv";
		//
		versionValue = "O_2019_2";
		//
		calYear = "2019-12-31";
		// csvOriFinanceScrapPostRecordAdd(pathStr, versionValue, calYear);
		//
		pathStr =
				//
				"D:/temp/hubei/报废20200715/报废明细记录2019年-过账记录-资产子表-侯安提供-替换表头-20200702.csv";
		//
		versionValue = "O_2019_2";
		//
		calYear = "2019-12-31";
		// csvOriFinanceScrapPostAssetAdd(pathStr, versionValue, calYear);
		//
		pathStr =
				//
				"D:/temp/hubei/报废20200715/报废明细记录2019年-过账记录-设备子表-侯安提供-替换表头-20200702.csv";
		//
		versionValue = "O_2019_2";
		//
		calYear = "2019-12-31";
		// csvOriFinanceScrapPostEquipAdd(pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hubei/20200623/表1-资产信息表-替换表头.csv";
		//
		versionValue = "O_2019_1";
		//
		calYear = "2019-12-31";
		// csvOriAssetInformationItemAdd(pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hubei/20200623/表2-设备信息表-替换表头.csv";
		//
		versionValue = "O_2019_1";
		//
		calYear = "2019-12-31";
		// csvOriEquipmentInformationItemAdd(pathStr, versionValue, calYear);
		//
		pathStr =
				//
				"D:/temp/hubei/20200623/表3-逾龄的清单-资产-替换表头.csv";
		//
		versionValue = "O_2019_1";
		//
		calYear = "2019-12-31";
		// csvOriOverAgeItemAdd(pathStr, versionValue, calYear);

		//
		pathStr =
				//
				"D:/temp/hubei/20200623/表4-资产设备对应-替换表头.csv";
		//
		versionValue = "O_2019_1";
		//
		calYear = "2019-12-31";
		// csvOriEquipAssetRelationItemAdd(pathStr, versionValue, calYear);

		// pathStr =
		// "D:/temp/hubei/20200409/表2-2019年ERP新增资产台账清单_0409-表头替换.csv";
		// versionValue = "O_2019_4";
		// calYear = "2019";
		// csvZfiSwzcIncreaAdd(pathStr, versionValue, calYear);
		// pathStr =
		// "D:/temp/hubei-20190727/ERP-20190821/2018年报废资产明细-V1-IMPORT_READYING.csv";
		// versionValue = "O_2018_2";
		// calYear = "2018";
		// csvUpZfiaaBfAdd(pathStr, versionValue, calYear);
		// 111
		// 111
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150140_1.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150150_2.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150156_3.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150204_4.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150212_5.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150221_6.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150229_7.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150236_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150359_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150407_1.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150416_2.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150423_3.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150429_4.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150436_5.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150443_6.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150450_7.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150454_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150609_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150616_1.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150622_2.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150629_3.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150635_4.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150642_5.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150648_6.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150655_7.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150659_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150808_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150815_1.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150821_2.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150827_3.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150834_4.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150840_5.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150845_6.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150852_7.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30150856_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151006_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151012_1.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151018_2.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151028_3.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151034_4.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151039_5.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151045_6.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151052_7.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151056_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151144_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151150_1.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151156_2.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151202_3.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151207_4.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/CSV/BIC_AZFI_SWZC00_182_2019-07-30151213_5.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);

		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184618_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);

		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184625_1.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184631_2.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184637_3.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184643_4.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184649_5.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184655_6.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184701_7.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);

		// versionValue = "O_2018_2";
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184705_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184757_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184805_1.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184811_2.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184816_3.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184822_4.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184829_5.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184834_6.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184840_7.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr
		// ="D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184843_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);

		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184927_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184932_1.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184938_2.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184944_3.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184948_4.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01184955_5.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185001_6.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185006_7.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185013_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185143_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185148_1.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185152_2.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185157_3.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185202_4.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185207_5.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185212_6.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185217_7.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185220_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185312_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185318_1.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185324_2.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185330_3.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185335_4.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185341_5.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185345_6.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185350_7.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185353_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185423_0.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185427_1.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185432_2.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185437_3.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185441_4.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// pathStr =
		// "D:/temp/BIC_AZFI_SWZC00_182/BIC_AZFI_SWZC00_182_2019-08-01185446_5.csv";
		// csvBicAzfiSwzcAdd(pathStr, versionValue);
		// System.out.println(getClass("com.yunhai.excel.orm.PmsItemShuLine").getSimpleName());
		// getObjectByStringTest();
		System.out.println("结束!");

	}

	public static void getCSVHeader(String filePathStr) throws IOException {
		File csv = new File(filePathStr);

		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		System.out.println("filePathStr=" + filePathStr);
		Iterable<CSVRecord> records;
		/*
		 * CSVFormat.RFC4180.parse(in)方法读取csv文件中包括表头的所有数据。
		 * CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);方法则是将第一行视为表头不读取。
		 */
		records = CSVFormat.RFC4180.parse(in);
		int recordI = 1;
		/**
		 * 下面的部分读取csv文件的表头部分。
		 */
		Iterator<CSVRecord> iterator = records.iterator();
		CSVRecord record = iterator.next();

		for (int vI = 0; vI < record.size(); vI++) {
			System.out.println(vI + ":" + record.get(vI));
		}
		/**
		 * 正面的部分读取csv文件的表头部分。下面是旧方法。
		 */
		/*
		 * for (CSVRecord record : records) { if (recordI == 1) {
		 * 
		 * System.out.println("1:" + record.toString());// 打印整行内容 for (int vI = 0; vI <
		 * record.size(); vI++) { System.out.println(vI + ":" + record.get(vI)); }
		 * System.out.println("2:" + record.size());// 打印本行有多少个值 System.out.println("3:"
		 * + record.getRecordNumber());// 打印本行行数 System.out.println("4:" +
		 * record.get(0));// 按索引返回对应值 System.out.println("recordI:" + recordI);//
		 * 按索引返回对应值 // System.out.println(record.get("id"));//按名称返回对应值 recordI++; break;
		 * } }
		 */
		/*
		 * 正面的部分读取csv文件中的非表头部分的数据
		 */
		/*
		 * Iterator<CSVRecord> iterator = records.iterator(); while (iterator.hasNext())
		 * { CSVRecord csvRecord = iterator.next();
		 * 
		 * System.out.println(csvRecord.get(0)); }
		 */

		// 关闭输入流
		in.close();
	}

	public static void insertInToDVersion(String versionValue, String targetTable, String dataType, Short yearValue,
			Short subVersion, String versionStatus, String parentVersion) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DVersion dVersion = new DVersion();
		dVersion.setVersionValue(versionValue);
		dVersion.setTargetTable(targetTable);
		dVersion.setDataType(dataType);
		dVersion.setYearValue(yearValue);
		dVersion.setSubVersion(subVersion);
		dVersion.setVersionStatus(versionStatus);
		dVersion.setParentVersion(parentVersion);
		dVersion.setGenerateDate(new Date());
		session.save(dVersion);
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void getObjectByStringTest() throws ClassNotFoundException {
		PmsItemShuLine pmsItemShuLine = null;
		try {
			Class obj = Class.forName("com.yunhai.excel.orm.PmsItemShuLine");
			switch ("PmsItemShuLine") {
			case "PmsItemShuLine":
				pmsItemShuLine = (PmsItemShuLine) obj.newInstance();
				// pmsItemShuLine=(PmsItemShuLine)getClass("com.yunhai.excel.orm.PmsItemShuLine").newInstance();
				break;

			default:
				break;
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// pmsItemShuLine.setAssetId("12345");
		// pmsItemShuLine.setCalYear(new Short("2020"));
		pmsItemShuLine.PropertySet("calYear", "2020");
		pmsItemShuLine.PropertySet("assetId", "assetId");
		System.out.println("pmsItemShuLine.AssetId=" + pmsItemShuLine.getAssetId() + "，pmsItemShuLine.CalYear="
				+ pmsItemShuLine.getCalYear());

	}

	public static Object getObjectTest(Object obj) {
		return obj.getClass();
	}

	public static Class getClass(String className) throws ClassNotFoundException {
		Class obj = Class.forName(className);
		return obj;
	}

	public static void csvZfiSwzc16classValueAdd(String pathStr, String versionValue, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ZfiSwzc16classValue zfiSwzc16classValue = new ZfiSwzc16classValue();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			// pmsItemReuse.setPmsItemReuseId(csvRecord.get("PMS_ITEM_REUSE_ID"));
			// zfiSwzc16classValue.setZfiSwzc16classValueId(csvRecord.get("ZFI_SWZC_16CLASS_VALUE_ID"));
			zfiSwzc16classValue.setDataVersion(versionValue);
			zfiSwzc16classValue.setCalYear(DateFormatUtil.parseDate(calYear));
			zfiSwzc16classValue.setAssetMain(csvRecord.get("ASSET_MAIN"));
			zfiSwzc16classValue.setEqunr(csvRecord.get("EQUNR"));
			if (csvRecord.get("ZPMZCYZ").trim().isEmpty()) {
				zfiSwzc16classValue.setZpmzcyz(new Double(0.0));
			} else {
				zfiSwzc16classValue.setZpmzcyz(Double.parseDouble(csvRecord.get("ZPMZCYZ")));
			}
			if (csvRecord.get("ZPMZCJZ").trim().isEmpty()) {
				zfiSwzc16classValue.setZpmzcjz(new Double(0.0));
			} else {
				zfiSwzc16classValue.setZpmzcjz(Double.parseDouble(csvRecord.get("ZPMZCJZ")));
			}
			zfiSwzc16classValue.setDataSourceFile(pathStr);

			session.save(zfiSwzc16classValue);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvZfiSwzcNo16classValueAdd(String pathStr, String versionValue, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ZfiSwzcNo16classValue zfiSwzcNo16classValue = new ZfiSwzcNo16classValue();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			// pmsItemReuse.setPmsItemReuseId(csvRecord.get("PMS_ITEM_REUSE_ID"));
			// zfiSwzcNo16classValue.setZfiSwzc16classValueId(csvRecord.get("ZFI_SWZC_16CLASS_VALUE_ID"));
			zfiSwzcNo16classValue.setDataVersion(versionValue);
			zfiSwzcNo16classValue.setCalYear(DateFormatUtil.parseDate(calYear));
			zfiSwzcNo16classValue.setAssetMain(csvRecord.get("ASSET_MAIN"));
			zfiSwzcNo16classValue.setEqunr(csvRecord.get("EQUNR"));
			if (csvRecord.get("ZPMZCYZ").trim().isEmpty()) {
				zfiSwzcNo16classValue.setZpmzcyz(new Double(0.0));
			} else {
				zfiSwzcNo16classValue.setZpmzcyz(Double.parseDouble(csvRecord.get("ZPMZCYZ")));
			}
			if (csvRecord.get("ZPMZCJZ").trim().isEmpty()) {
				zfiSwzcNo16classValue.setZpmzcjz(new Double(0.0));
			} else {
				zfiSwzcNo16classValue.setZpmzcjz(Double.parseDouble(csvRecord.get("ZPMZCJZ")));
			}
			zfiSwzcNo16classValue.setDataSourceFile(pathStr);

			session.save(zfiSwzcNo16classValue);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvZfiSwzcDiscAdd(String pathStr, String versionValue) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			BicAzfiSwzc bicAzfiSwzc = new BicAzfiSwzc();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			try {

				bicAzfiSwzc.setDataVersion(csvRecord.get("DATA_VERSION"));
			} catch (Exception e) {
				// TODO: handle exception

				bicAzfiSwzc.setDataVersion(versionValue);
			}

			bicAzfiSwzc.setBicAzfiSwzcId(csvRecord.get("BIC_AZFI_SWZC_ID"));
			bicAzfiSwzc.setCalyear(csvRecord.get("CALYEAR"));
			bicAzfiSwzc.setCompCode(csvRecord.get("COMP_CODE"));
			bicAzfiSwzc.setAssetMain(csvRecord.get("ASSET_MAIN"));
			bicAzfiSwzc.setAsset(csvRecord.get("ASSET"));
			bicAzfiSwzc.setZioEqunr(csvRecord.get("ZIO_EQUNR"));
			bicAzfiSwzc.setCurrency(csvRecord.get("CURRENCY"));
			if (csvRecord.get("ZPMZCYZ").trim().isEmpty()) {
				bicAzfiSwzc.setZpmzcyz(new Double(0.0));
			} else {
				bicAzfiSwzc.setZpmzcyz(Double.parseDouble(csvRecord.get("ZPMZCYZ")));
			}
			if (csvRecord.get("ZPMZCJZ").trim().isEmpty()) {
				bicAzfiSwzc.setZpmzcjz(new Double(0.0));
			} else {
				bicAzfiSwzc.setZpmzcjz(Double.parseDouble(csvRecord.get("ZPMZCJZ")));
			}
			bicAzfiSwzc.setZtypbz1(csvRecord.get("ZTYPBZ1"));
			bicAzfiSwzc.setZtypbz2(csvRecord.get("ZTYPBZ2"));
			bicAzfiSwzc.setZtypbz3(csvRecord.get("ZTYPBZ3"));
			bicAzfiSwzc.setZvolLev(csvRecord.get("ZVOL_LEV"));
			if (csvRecord.get("ZQUANTITY").trim().isEmpty()) {
				bicAzfiSwzc.setZquantity(new Double(0.0));
			} else {
				bicAzfiSwzc.setZquantity(Double.parseDouble(csvRecord.get("ZQUANTITY")));
			}
			bicAzfiSwzc.setUnit(csvRecord.get("UNIT"));
			bicAzfiSwzc.setZioZczt(csvRecord.get("ZIO_ZCZT"));
			bicAzfiSwzc.setProfitCtr(csvRecord.get("PROFIT_CTR"));
			bicAzfiSwzc.setZlrzx(csvRecord.get("ZLRZX"));
			bicAzfiSwzc.setCoArea(csvRecord.get("CO_AREA"));
			bicAzfiSwzc.setZzcms(csvRecord.get("ZZCMS"));
			bicAzfiSwzc.setZioZxmlx(csvRecord.get("ZIO_ZXMLX"));
			bicAzfiSwzc.setCapitDate(csvRecord.get("CAPIT_DATE"));
			bicAzfiSwzc.setZdeakt(csvRecord.get("ZDEAKT"));
			bicAzfiSwzc.setAssetClas(csvRecord.get("ASSET_CLAS"));
			bicAzfiSwzc.setZxlh(csvRecord.get("ZXLH"));
			bicAzfiSwzc.setZinvnr(csvRecord.get("ZINVNR"));
			bicAzfiSwzc.setZi0Zzc1(csvRecord.get("ZI0_ZZC1"));
			bicAzfiSwzc.setZi0Zzc2(csvRecord.get("ZI0_ZZC2"));
			bicAzfiSwzc.setZioKostl(csvRecord.get("ZIO_KOSTL"));
			bicAzfiSwzc.setZkostlv(csvRecord.get("ZKOSTLV"));
			bicAzfiSwzc.setZioRaumn(csvRecord.get("ZIO_RAUMN"));
			bicAzfiSwzc.setZzzph(csvRecord.get("ZZZPH"));
			bicAzfiSwzc.setZzkostl(csvRecord.get("ZZKOSTL"));
			bicAzfiSwzc.setZioZzc06(csvRecord.get("ZIO_ZZC06"));
			bicAzfiSwzc.setZioZzc07(csvRecord.get("ZIO_ZZC07"));
			bicAzfiSwzc.setZioOrd41(csvRecord.get("ZIO_ORD41"));
			bicAzfiSwzc.setZord44(csvRecord.get("ZORD44"));
			bicAzfiSwzc.setZgdlgrp(csvRecord.get("ZGDLGRP"));
			bicAzfiSwzc.setZzcly(csvRecord.get("ZZCLY"));
			bicAzfiSwzc.setZioUmwkz(csvRecord.get("ZIO_UMWKZ"));
			bicAzfiSwzc.setZsfdg(csvRecord.get("ZSFDG"));
			bicAzfiSwzc.setZioHerst(csvRecord.get("ZIO_HERST"));
			bicAzfiSwzc.setZtypbz(csvRecord.get("ZTYPBZ"));
			bicAzfiSwzc.setzPosid(csvRecord.get("Z_POSID"));
			bicAzfiSwzc.setZpost11(csvRecord.get("ZPOST11"));
			bicAzfiSwzc.setZfiamt(csvRecord.get("ZFIAMT"));
			bicAzfiSwzc.setZioStadt(csvRecord.get("ZIO_STADT"));
			bicAzfiSwzc.setZfwcqzh(csvRecord.get("ZFWCQZH"));
			bicAzfiSwzc.setZioEqktx(csvRecord.get("ZIO_EQKTX"));
			bicAzfiSwzc.setZioTxt04(csvRecord.get("ZIO_TXT04"));
			bicAzfiSwzc.setZioEqart(csvRecord.get("ZIO_EQART"));
			bicAzfiSwzc.setZpmsqz(csvRecord.get("ZPMSQZ"));
			bicAzfiSwzc.setZioInbdt(csvRecord.get("ZIO_INBDT"));
			bicAzfiSwzc.setZioZccrq(csvRecord.get("ZIO_ZCCRQ"));
			bicAzfiSwzc.setZzzs(csvRecord.get("ZZZS"));
			bicAzfiSwzc.setZioHerld(csvRecord.get("ZIO_HERLD"));
			bicAzfiSwzc.setZioMapar(csvRecord.get("ZIO_MAPAR"));
			bicAzfiSwzc.setZtxz012(csvRecord.get("ZTXZ012"));
			bicAzfiSwzc.setZioSerge(csvRecord.get("ZIO_SERGE"));
			bicAzfiSwzc.setZioSwerk(csvRecord.get("ZIO_SWERK"));
			bicAzfiSwzc.setZioStort(csvRecord.get("ZIO_STORT"));
			bicAzfiSwzc.setZioBeber(csvRecord.get("ZIO_BEBER"));
			bicAzfiSwzc.setZioAbckz(csvRecord.get("ZIO_ABCKZ"));
			bicAzfiSwzc.setZioEqfnr(csvRecord.get("ZIO_EQFNR"));
			bicAzfiSwzc.setZioZzc02(csvRecord.get("ZIO_ZZC02"));
			bicAzfiSwzc.setzProjk(csvRecord.get("Z_PROJK"));
			bicAzfiSwzc.setZwbsnm(csvRecord.get("ZWBSNM"));
			bicAzfiSwzc.setZioIwerk(csvRecord.get("ZIO_IWERK"));
			bicAzfiSwzc.setZioIngrp(csvRecord.get("ZIO_INGRP"));
			bicAzfiSwzc.setZioVaplz(csvRecord.get("ZIO_VAPLZ"));
			bicAzfiSwzc.setZioTplnr(csvRecord.get("ZIO_TPLNR"));
			bicAzfiSwzc.setZioHequi(csvRecord.get("ZIO_HEQUI"));
			bicAzfiSwzc.setZioTidnr(csvRecord.get("ZIO_TIDNR"));
			bicAzfiSwzc.setZioSb010(csvRecord.get("ZIO_SB010"));
			bicAzfiSwzc.setZioSb001(csvRecord.get("ZIO_SB001"));
			bicAzfiSwzc.setZioSb002(csvRecord.get("ZIO_SB002"));
			bicAzfiSwzc.setZioSb004(csvRecord.get("ZIO_SB004"));
			bicAzfiSwzc.setZioSb005(csvRecord.get("ZIO_SB005"));
			bicAzfiSwzc.setZioSb006(csvRecord.get("ZIO_SB006"));
			bicAzfiSwzc.setZioSb003(csvRecord.get("ZIO_SB003"));
			bicAzfiSwzc.setZioSb007(csvRecord.get("ZIO_SB007"));
			if (csvRecord.get("ZIO_SB008").trim().isEmpty()) {
				bicAzfiSwzc.setZioSb008(new Double(0.0));
			} else {
				bicAzfiSwzc.setZioSb008(Double.parseDouble(csvRecord.get("ZIO_SB008")));
			}
			bicAzfiSwzc.setZlenunt(csvRecord.get("ZLENUNT"));
			if (csvRecord.get("ZIO_SB009").trim().isEmpty()) {
				bicAzfiSwzc.setZioSb009(new Double(0.0));
			} else {
				bicAzfiSwzc.setZioSb009(Double.parseDouble(csvRecord.get("ZIO_SB009")));
			}
			bicAzfiSwzc.setZcapunt(csvRecord.get("ZCAPUNT"));
			bicAzfiSwzc.setZioSb011(csvRecord.get("ZIO_SB011"));
			bicAzfiSwzc.setZioUmlgo(csvRecord.get("ZIO_UMLGO"));
			bicAzfiSwzc.setZioGplab(csvRecord.get("ZIO_GPLAB"));
			bicAzfiSwzc.setZioPosid(csvRecord.get("ZIO_POSID"));
			bicAzfiSwzc.setZlyrkrq(csvRecord.get("ZLYRKRQ"));
			bicAzfiSwzc.setZlyckrq(csvRecord.get("ZLYCKRQ"));
			bicAzfiSwzc.setZpost1(csvRecord.get("ZPOST1"));
			bicAzfiSwzc.setZioCusre(csvRecord.get("ZIO_CUSRE"));
			bicAzfiSwzc.setZbfyy(csvRecord.get("ZBFYY"));
			bicAzfiSwzc.setZioZsb13(csvRecord.get("ZIO_ZSB13"));
			bicAzfiSwzc.setZioZsb12(csvRecord.get("ZIO_ZSB12"));
			bicAzfiSwzc.setRecordmode(csvRecord.get("RECORDMODE"));
			bicAzfiSwzc.setDataSourceFile(pathStr);

			session.save(bicAzfiSwzc);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvBicAzfiSwzcAdd(String pathStr, String versionValue) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			BicAzfiSwzc bicAzfiSwzc = new BicAzfiSwzc();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			try {

				bicAzfiSwzc.setDataVersion(csvRecord.get("DATA_VERSION"));
			} catch (Exception e) {
				// TODO: handle exception

				bicAzfiSwzc.setDataVersion(versionValue);
			}

			bicAzfiSwzc.setBicAzfiSwzcId(csvRecord.get("BIC_AZFI_SWZC_ID"));
			bicAzfiSwzc.setCalyear(csvRecord.get("CALYEAR"));
			bicAzfiSwzc.setCompCode(csvRecord.get("COMP_CODE"));
			bicAzfiSwzc.setAssetMain(csvRecord.get("ASSET_MAIN"));
			bicAzfiSwzc.setAsset(csvRecord.get("ASSET"));
			bicAzfiSwzc.setZioEqunr(csvRecord.get("ZIO_EQUNR"));
			bicAzfiSwzc.setCurrency(csvRecord.get("CURRENCY"));
			if (csvRecord.get("ZPMZCYZ").trim().isEmpty()) {
				bicAzfiSwzc.setZpmzcyz(new Double(0.0));
			} else {
				bicAzfiSwzc.setZpmzcyz(Double.parseDouble(csvRecord.get("ZPMZCYZ")));
			}
			if (csvRecord.get("ZPMZCJZ").trim().isEmpty()) {
				bicAzfiSwzc.setZpmzcjz(new Double(0.0));
			} else {
				bicAzfiSwzc.setZpmzcjz(Double.parseDouble(csvRecord.get("ZPMZCJZ")));
			}
			bicAzfiSwzc.setZtypbz1(csvRecord.get("ZTYPBZ1"));
			bicAzfiSwzc.setZtypbz2(csvRecord.get("ZTYPBZ2"));
			bicAzfiSwzc.setZtypbz3(csvRecord.get("ZTYPBZ3"));
			bicAzfiSwzc.setZvolLev(csvRecord.get("ZVOL_LEV"));
			if (csvRecord.get("ZQUANTITY").trim().isEmpty()) {
				bicAzfiSwzc.setZquantity(new Double(0.0));
			} else {
				bicAzfiSwzc.setZquantity(Double.parseDouble(csvRecord.get("ZQUANTITY")));
			}
			bicAzfiSwzc.setUnit(csvRecord.get("UNIT"));
			bicAzfiSwzc.setZioZczt(csvRecord.get("ZIO_ZCZT"));
			bicAzfiSwzc.setProfitCtr(csvRecord.get("PROFIT_CTR"));
			bicAzfiSwzc.setZlrzx(csvRecord.get("ZLRZX"));
			bicAzfiSwzc.setCoArea(csvRecord.get("CO_AREA"));
			bicAzfiSwzc.setZzcms(csvRecord.get("ZZCMS"));
			bicAzfiSwzc.setZioZxmlx(csvRecord.get("ZIO_ZXMLX"));
			bicAzfiSwzc.setCapitDate(csvRecord.get("CAPIT_DATE"));
			bicAzfiSwzc.setZdeakt(csvRecord.get("ZDEAKT"));
			bicAzfiSwzc.setAssetClas(csvRecord.get("ASSET_CLAS"));
			bicAzfiSwzc.setZxlh(csvRecord.get("ZXLH"));
			bicAzfiSwzc.setZinvnr(csvRecord.get("ZINVNR"));
			bicAzfiSwzc.setZi0Zzc1(csvRecord.get("ZI0_ZZC1"));
			bicAzfiSwzc.setZi0Zzc2(csvRecord.get("ZI0_ZZC2"));
			bicAzfiSwzc.setZioKostl(csvRecord.get("ZIO_KOSTL"));
			bicAzfiSwzc.setZkostlv(csvRecord.get("ZKOSTLV"));
			bicAzfiSwzc.setZioRaumn(csvRecord.get("ZIO_RAUMN"));
			bicAzfiSwzc.setZzzph(csvRecord.get("ZZZPH"));
			bicAzfiSwzc.setZzkostl(csvRecord.get("ZZKOSTL"));
			bicAzfiSwzc.setZioZzc06(csvRecord.get("ZIO_ZZC06"));
			bicAzfiSwzc.setZioZzc07(csvRecord.get("ZIO_ZZC07"));
			bicAzfiSwzc.setZioOrd41(csvRecord.get("ZIO_ORD41"));
			bicAzfiSwzc.setZord44(csvRecord.get("ZORD44"));
			bicAzfiSwzc.setZgdlgrp(csvRecord.get("ZGDLGRP"));
			bicAzfiSwzc.setZzcly(csvRecord.get("ZZCLY"));
			bicAzfiSwzc.setZioUmwkz(csvRecord.get("ZIO_UMWKZ"));
			bicAzfiSwzc.setZsfdg(csvRecord.get("ZSFDG"));
			bicAzfiSwzc.setZioHerst(csvRecord.get("ZIO_HERST"));
			bicAzfiSwzc.setZtypbz(csvRecord.get("ZTYPBZ"));
			bicAzfiSwzc.setzPosid(csvRecord.get("Z_POSID"));
			bicAzfiSwzc.setZpost11(csvRecord.get("ZPOST11"));
			bicAzfiSwzc.setZfiamt(csvRecord.get("ZFIAMT"));
			bicAzfiSwzc.setZioStadt(csvRecord.get("ZIO_STADT"));
			bicAzfiSwzc.setZfwcqzh(csvRecord.get("ZFWCQZH"));
			bicAzfiSwzc.setZioEqktx(csvRecord.get("ZIO_EQKTX"));
			bicAzfiSwzc.setZioTxt04(csvRecord.get("ZIO_TXT04"));
			bicAzfiSwzc.setZioEqart(csvRecord.get("ZIO_EQART"));
			bicAzfiSwzc.setZpmsqz(csvRecord.get("ZPMSQZ"));
			bicAzfiSwzc.setZioInbdt(csvRecord.get("ZIO_INBDT"));
			bicAzfiSwzc.setZioZccrq(csvRecord.get("ZIO_ZCCRQ"));
			bicAzfiSwzc.setZzzs(csvRecord.get("ZZZS"));
			bicAzfiSwzc.setZioHerld(csvRecord.get("ZIO_HERLD"));
			bicAzfiSwzc.setZioMapar(csvRecord.get("ZIO_MAPAR"));
			bicAzfiSwzc.setZtxz012(csvRecord.get("ZTXZ012"));
			bicAzfiSwzc.setZioSerge(csvRecord.get("ZIO_SERGE"));
			bicAzfiSwzc.setZioSwerk(csvRecord.get("ZIO_SWERK"));
			bicAzfiSwzc.setZioStort(csvRecord.get("ZIO_STORT"));
			bicAzfiSwzc.setZioBeber(csvRecord.get("ZIO_BEBER"));
			bicAzfiSwzc.setZioAbckz(csvRecord.get("ZIO_ABCKZ"));
			bicAzfiSwzc.setZioEqfnr(csvRecord.get("ZIO_EQFNR"));
			bicAzfiSwzc.setZioZzc02(csvRecord.get("ZIO_ZZC02"));
			bicAzfiSwzc.setzProjk(csvRecord.get("Z_PROJK"));
			bicAzfiSwzc.setZwbsnm(csvRecord.get("ZWBSNM"));
			bicAzfiSwzc.setZioIwerk(csvRecord.get("ZIO_IWERK"));
			bicAzfiSwzc.setZioIngrp(csvRecord.get("ZIO_INGRP"));
			bicAzfiSwzc.setZioVaplz(csvRecord.get("ZIO_VAPLZ"));
			bicAzfiSwzc.setZioTplnr(csvRecord.get("ZIO_TPLNR"));
			bicAzfiSwzc.setZioHequi(csvRecord.get("ZIO_HEQUI"));
			bicAzfiSwzc.setZioTidnr(csvRecord.get("ZIO_TIDNR"));
			bicAzfiSwzc.setZioSb010(csvRecord.get("ZIO_SB010"));
			bicAzfiSwzc.setZioSb001(csvRecord.get("ZIO_SB001"));
			bicAzfiSwzc.setZioSb002(csvRecord.get("ZIO_SB002"));
			bicAzfiSwzc.setZioSb004(csvRecord.get("ZIO_SB004"));
			bicAzfiSwzc.setZioSb005(csvRecord.get("ZIO_SB005"));
			bicAzfiSwzc.setZioSb006(csvRecord.get("ZIO_SB006"));
			bicAzfiSwzc.setZioSb003(csvRecord.get("ZIO_SB003"));
			bicAzfiSwzc.setZioSb007(csvRecord.get("ZIO_SB007"));
			if (csvRecord.get("ZIO_SB008").trim().isEmpty()) {
				bicAzfiSwzc.setZioSb008(new Double(0.0));
			} else {
				bicAzfiSwzc.setZioSb008(Double.parseDouble(csvRecord.get("ZIO_SB008")));
			}
			bicAzfiSwzc.setZlenunt(csvRecord.get("ZLENUNT"));
			if (csvRecord.get("ZIO_SB009").trim().isEmpty()) {
				bicAzfiSwzc.setZioSb009(new Double(0.0));
			} else {
				bicAzfiSwzc.setZioSb009(Double.parseDouble(csvRecord.get("ZIO_SB009")));
			}
			bicAzfiSwzc.setZcapunt(csvRecord.get("ZCAPUNT"));
			bicAzfiSwzc.setZioSb011(csvRecord.get("ZIO_SB011"));
			bicAzfiSwzc.setZioUmlgo(csvRecord.get("ZIO_UMLGO"));
			bicAzfiSwzc.setZioGplab(csvRecord.get("ZIO_GPLAB"));
			bicAzfiSwzc.setZioPosid(csvRecord.get("ZIO_POSID"));
			bicAzfiSwzc.setZlyrkrq(csvRecord.get("ZLYRKRQ"));
			bicAzfiSwzc.setZlyckrq(csvRecord.get("ZLYCKRQ"));
			bicAzfiSwzc.setZpost1(csvRecord.get("ZPOST1"));
			bicAzfiSwzc.setZioCusre(csvRecord.get("ZIO_CUSRE"));
			bicAzfiSwzc.setZbfyy(csvRecord.get("ZBFYY"));
			bicAzfiSwzc.setZioZsb13(csvRecord.get("ZIO_ZSB13"));
			bicAzfiSwzc.setZioZsb12(csvRecord.get("ZIO_ZSB12"));
			bicAzfiSwzc.setRecordmode(csvRecord.get("RECORDMODE"));
			bicAzfiSwzc.setDataSourceFile(pathStr);

			session.save(bicAzfiSwzc);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvZfiSwzcIncreaAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ZfiSwzcDisc zfiSwzcDisc = new ZfiSwzcDisc();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			// pmsItemReuse.setPmsItemReuseId(csvRecord.get("PMS_ITEM_REUSE_ID"));
			// zfiSwzcDisc.setZfiSwzcId(csvRecord.get("ZFI_SWZC_ID"));
			/*
			 * zfiSwzcDisc.setVersion(versionValue); if
			 * (!(csvRecord.get("CAL_YEAR").trim().isEmpty())) { try {
			 * zfiSwzcDisc.setCalYear(simpleDateFormat.parse("2020/04/09"));
			 * //zfiSwzcDisc.setCalYear(simpleDateFormat.parse(csvRecord.get("CAL_YEAR")));
			 * } catch (ParseException e) { e.printStackTrace(); } }
			 */

			try {
				// zfiSwzcDisc.setCalYear(simpleDateFormat.parse("2020-04-09"));
				zfiSwzcDisc.setCalYear(simpleDateFormat.parse(calYear));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			zfiSwzcDisc.setCalyear(Long.parseLong(calYear));
			zfiSwzcDisc.setCompCode(csvRecord.get("COMP_CODE"));
			zfiSwzcDisc.setAssetMain(csvRecord.get("ASSET_MAIN"));
			zfiSwzcDisc.setAsset(csvRecord.get("ASSET"));
			zfiSwzcDisc.setEqunr(csvRecord.get("EQUNR"));
			zfiSwzcDisc.setCurrency(csvRecord.get("CURRENCY"));
			if (csvRecord.get("ZPMZCYZ").trim().isEmpty()) {
				zfiSwzcDisc.setZpmzcyz(new Double(0.0));
			} else {
				zfiSwzcDisc.setZpmzcyz(new DecimalFormat().parse(csvRecord.get("ZPMZCYZ")).doubleValue());
			}
			if (csvRecord.get("ZPMZCJZ").trim().isEmpty()) {
				zfiSwzcDisc.setZpmzcjz(new Double(0.0));
			} else {
				zfiSwzcDisc.setZpmzcjz(new DecimalFormat().parse(csvRecord.get("ZPMZCJZ")).doubleValue());
			}
			zfiSwzcDisc.setZtypbz1(csvRecord.get("ZTYPBZ1"));
			zfiSwzcDisc.setZtypbz2(csvRecord.get("ZTYPBZ2"));
			zfiSwzcDisc.setZtypbz3(csvRecord.get("ZTYPBZ3"));
			zfiSwzcDisc.setZvolLev(csvRecord.get("ZVOL_LEV"));
			if (csvRecord.get("ZQUANTITY").trim().isEmpty()) {
				zfiSwzcDisc.setZquantity(new Double(0));
			} else {
				zfiSwzcDisc.setZquantity(new DecimalFormat().parse(csvRecord.get("ZQUANTITY")).doubleValue());
			}
			zfiSwzcDisc.setUnit(csvRecord.get("UNIT"));
			zfiSwzcDisc.setZioZczt(csvRecord.get("ZIO_ZCZT"));
			zfiSwzcDisc.setProfitCtr(csvRecord.get("PROFIT_CTR"));
			zfiSwzcDisc.setZlrzx(csvRecord.get("ZLRZX"));
			zfiSwzcDisc.setCoArea(csvRecord.get("CO_AREA"));
			zfiSwzcDisc.setZzcms(csvRecord.get("ZZCMS"));
			zfiSwzcDisc.setZioZxmlx(csvRecord.get("ZIO_ZXMLX"));
			zfiSwzcDisc.setAktiv(csvRecord.get("AKTIV"));
			zfiSwzcDisc.setDeakt(csvRecord.get("DEAKT"));
			zfiSwzcDisc.setAnlkl(csvRecord.get("ANLKL"));
			zfiSwzcDisc.setSernr(csvRecord.get("SERNR"));
			zfiSwzcDisc.setInvnr(csvRecord.get("INVNR"));
			zfiSwzcDisc.setZzc001(csvRecord.get("ZZC001"));
			zfiSwzcDisc.setZzc002(csvRecord.get("ZZC002"));
			zfiSwzcDisc.setKostl(csvRecord.get("KOSTL"));
			zfiSwzcDisc.setKostlv(csvRecord.get("KOSTLV"));
			zfiSwzcDisc.setRaumn(csvRecord.get("RAUMN"));
			zfiSwzcDisc.setKfzkz(csvRecord.get("KFZKZ"));
			zfiSwzcDisc.setZzas1(csvRecord.get("ZZAS1"));
			zfiSwzcDisc.setZzc006(csvRecord.get("ZZC006"));
			zfiSwzcDisc.setZzc007(csvRecord.get("ZZC007"));
			zfiSwzcDisc.setOrd41(csvRecord.get("ORD41"));
			zfiSwzcDisc.setOrd44(csvRecord.get("ORD44"));
			zfiSwzcDisc.setGdlgrp(csvRecord.get("GDLGRP"));
			zfiSwzcDisc.setIzwek(csvRecord.get("IZWEK"));
			zfiSwzcDisc.setUmwkz(csvRecord.get("UMWKZ"));
			zfiSwzcDisc.setAnlue(csvRecord.get("ANLUE"));
			zfiSwzcDisc.setHerst(csvRecord.get("HERST"));
			zfiSwzcDisc.setTypbz(csvRecord.get("TYPBZ"));
			zfiSwzcDisc.setZkpwbs(csvRecord.get("ZKPWBS"));
			zfiSwzcDisc.setZkpwbsms(csvRecord.get("ZKPWBSMS"));
			zfiSwzcDisc.setFiamt(csvRecord.get("FIAMT"));
			zfiSwzcDisc.setStadt(csvRecord.get("STADT"));
			zfiSwzcDisc.setZfwcqzh(csvRecord.get("ZFWCQZH"));
			zfiSwzcDisc.setEqktx(csvRecord.get("EQKTX"));
			zfiSwzcDisc.setTxt04(csvRecord.get("TXT04"));
			zfiSwzcDisc.setEqart(csvRecord.get("EQART"));
			zfiSwzcDisc.setBegru(csvRecord.get("BEGRU"));
			zfiSwzcDisc.setInbdt(csvRecord.get("INBDT"));
			zfiSwzcDisc.setZccrq(csvRecord.get("ZCCRQ"));
			zfiSwzcDisc.setZherst(csvRecord.get("ZHERST"));
			zfiSwzcDisc.setHerld(csvRecord.get("HERLD"));
			zfiSwzcDisc.setMapar(csvRecord.get("MAPAR"));
			zfiSwzcDisc.setZtypbz(csvRecord.get("ZTYPBZ"));
			zfiSwzcDisc.setSerge(csvRecord.get("SERGE"));
			zfiSwzcDisc.setSwerk(csvRecord.get("SWERK"));
			zfiSwzcDisc.setStort(csvRecord.get("STORT"));
			// zfiSwzcDisc.setBeber(csvRecord.get("BEBER"));
			/*
			 * zfiSwzcDisc.setAbckz(csvRecord.get("ABCKZ"));
			 * zfiSwzcDisc.setEqfnr(csvRecord.get("EQFNR"));
			 * zfiSwzcDisc.setZkostl(csvRecord.get("ZKOSTL"));
			 * zfiSwzcDisc.setZsbwbs(csvRecord.get("ZSBWBS"));
			 * zfiSwzcDisc.setZsbwbsms(csvRecord.get("ZSBWBSMS"));
			 * zfiSwzcDisc.setIwerk(csvRecord.get("IWERK"));
			 * zfiSwzcDisc.setIngrp(csvRecord.get("INGRP"));
			 * zfiSwzcDisc.setGewrk(csvRecord.get("GEWRK"));
			 * zfiSwzcDisc.setTplnr(csvRecord.get("TPLNR"));
			 * zfiSwzcDisc.setHequi(csvRecord.get("HEQUI"));
			 * zfiSwzcDisc.setTidnr(csvRecord.get("TIDNR"));
			 * zfiSwzcDisc.setZsb010(csvRecord.get("ZSB010"));
			 * zfiSwzcDisc.setZsb001(csvRecord.get("ZSB001"));
			 * zfiSwzcDisc.setZsb002(csvRecord.get("ZSB002"));
			 */
			zfiSwzcDisc.setZsb004(csvRecord.get("ZSB004"));
			zfiSwzcDisc.setZsb005(csvRecord.get("ZSB005"));
			zfiSwzcDisc.setZsb006(csvRecord.get("ZSB006"));
			zfiSwzcDisc.setZsb003(csvRecord.get("ZSB003"));
			zfiSwzcDisc.setZsb007(csvRecord.get("ZSB007"));
			zfiSwzcDisc.setZsb008(csvRecord.get("ZSB008"));
			zfiSwzcDisc.setZlenunt(csvRecord.get("ZLENUNT"));
			zfiSwzcDisc.setZsb009(csvRecord.get("ZSB009"));
			zfiSwzcDisc.setZcapunt(csvRecord.get("ZCAPUNT"));
			zfiSwzcDisc.setZsb011(csvRecord.get("ZSB011"));
			zfiSwzcDisc.setZeq003(csvRecord.get("ZEQ003"));
			/*
			 * zfiSwzcDisc.setZeq001(csvRecord.get("ZEQ001"));
			 * zfiSwzcDisc.setZeq002(csvRecord.get("ZEQ002"));
			 * zfiSwzcDisc.setZlyrkrq(csvRecord.get("ZLYRKRQ"));
			 * zfiSwzcDisc.setZlyckrq(csvRecord.get("ZLYCKRQ"));
			 * zfiSwzcDisc.setZbfjzrq(csvRecord.get("ZBFJZRQ"));
			 * zfiSwzcDisc.setZbfxmbm(csvRecord.get("ZBFXMBM"));
			 * zfiSwzcDisc.setZbfxmms(csvRecord.get("ZBFXMMS"));
			 * zfiSwzcDisc.setZbfyydm(csvRecord.get("ZBFYYDM"));
			 * zfiSwzcDisc.setZbfyywb(csvRecord.get("ZBFYYWB"));
			 * zfiSwzcDisc.setPmunr(csvRecord.get("PMUNR"));
			 */
			/*
			 * zfiSwzcDisc.setCdate(csvRecord.get("CDATE"));
			 * zfiSwzcDisc.setCtime(csvRecord.get("CTIME"));
			 * zfiSwzcDisc.setCname(csvRecord.get("CNAME"));
			 */
			zfiSwzcDisc.setAssetProperty(csvRecord.get("ASSET_PROPERTY"));
			zfiSwzcDisc.setPropertyCode(csvRecord.get("PROPERTY_CODE"));
			zfiSwzcDisc.setDataSourceFile(pathStr);
			zfiSwzcDisc.setDataVersion(versionValue);
			zfiSwzcDisc.setAssetId(csvRecord.get("ASSET_ID"));
			// zfiSwzcDisc.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			zfiSwzcDisc.setOrgGroupCode(csvRecord.get("ORG_GROUP_CODE"));
			zfiSwzcDisc.setZtypbz1T(csvRecord.get("ZTYPBZ1_T"));
			zfiSwzcDisc.setZtypbz2T(csvRecord.get("ZTYPBZ2_T"));
			zfiSwzcDisc.setZtypbz3T(csvRecord.get("ZTYPBZ3_T"));
			zfiSwzcDisc.setAssetDescription(csvRecord.get("ASSET_DESCRIPTION"));
			zfiSwzcDisc.setFixAssetClassDescript(csvRecord.get("FIX_ASSET_CLASS_DESCRIPT"));
			// zfiSwzcDisc.setUnkownCode(csvRecord.get("UNKOWN_CODE"));
			zfiSwzcDisc.setAssetPropertyCvsName(csvRecord.get("ASSET_PROPERTY_CVS_NAME"));
			zfiSwzcDisc.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			zfiSwzcDisc.setRealAssetIdEquip(csvRecord.get("REAL_ASSET_ID_EQUIP"));
			// zfiSwzcDisc.setDiscardCapacityScale(csvRecord.get("DISCARD_CAPACITY_SCALE"));
			/*
			 * if (csvRecord.get("DISCARD_PAPER_NUMBER").trim().isEmpty()) {
			 * zfiSwzcDisc.setDiscardPaperNumber(new Double(0.0)); } else {
			 * zfiSwzcDisc.setDiscardPaperNumber( new
			 * DecimalFormat().parse(csvRecord.get("DISCARD_PAPER_NUMBER")).doubleValue());
			 * } zfiSwzcDisc.setMetreUnit(csvRecord.get("METRE_UNIT"));
			 * zfiSwzcDisc.setDiscardSourceProject(csvRecord.get("DISCARD_SOURCE_PROJECT"));
			 */

			session.save(zfiSwzcDisc);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriAssetInformationItemAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriAssetInformationItem oriAssetInformationItem = new OriAssetInformationItem();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");

			oriAssetInformationItem.setDataVersion(versionValue);
			oriAssetInformationItem.setCalYear(DateFormatUtil.parseDate(calYear));
			// oriAssetInformationItem.setOriAssetInformationItemId(csvRecord.get("ORI_ASSET_INFORMATION_ITEM_ID"));
			// oriAssetInformationItem.setDataVersion(csvRecord.get("DATA_VERSION"));
			// if(!(csvRecord.get("CAL_YEAR").trim().isEmpty())){try
			// {oriAssetInformationItem.setCalYear(simpleDateFormat.parse(csvRecord.get("CAL_YEAR")));
			// } catch (ParseException e) { e.printStackTrace(); }}
			oriAssetInformationItem.setOrgCode(csvRecord.get("ORG_CODE"));
			oriAssetInformationItem.setAssetNumber(csvRecord.get("ASSET_NUMBER"));
			oriAssetInformationItem.setSno(csvRecord.get("SNO"));
			if (!(csvRecord.get("VALID_DATE").trim().isEmpty())) {
				oriAssetInformationItem.setValidDate(DateFormatUtil.parseDate(csvRecord.get("VALID_DATE")));
			}
			oriAssetInformationItem.setCategoryCode(csvRecord.get("CATEGORY_CODE"));
			if (!(csvRecord.get("CAPITALIZATION_DATE").trim().isEmpty())) {
				oriAssetInformationItem
						.setCapitalizationDate(DateFormatUtil.parseDate(csvRecord.get("CAPITALIZATION_DATE")));
			}
			oriAssetInformationItem.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			oriAssetInformationItem.setVoltageLevelDescription(csvRecord.get("VOLTAGE_LEVEL_DESCRIPTION"));
			if (csvRecord.get("QUANTITY").trim().isEmpty()) {
				oriAssetInformationItem.setQuantity(new Double(0.0));
			} else {
				oriAssetInformationItem.setQuantity(new DecimalFormat().parse(csvRecord.get("QUANTITY")).doubleValue());
			}
			oriAssetInformationItem.setTypeNameCode(csvRecord.get("TYPE_NAME_CODE"));
			oriAssetInformationItem.setAssetStatusCode(csvRecord.get("ASSET_STATUS_CODE"));
			oriAssetInformationItem.setAssetStatusDescription(csvRecord.get("ASSET_STATUS_DESCRIPTION"));
			oriAssetInformationItem.setAssetDescription(csvRecord.get("ASSET_DESCRIPTION"));
			oriAssetInformationItem.setBelongLineStationName(csvRecord.get("BELONG_LINE_STATION_NAME"));
			oriAssetInformationItem.setCostCenter(csvRecord.get("COST_CENTER"));
			oriAssetInformationItem.setProfitCenter(csvRecord.get("PROFIT_CENTER"));
			oriAssetInformationItem.setProfitCenterDescription(csvRecord.get("PROFIT_CENTER_DESCRIPTION"));
			oriAssetInformationItem.setDataSourceFile(pathStr);

			session.save(oriAssetInformationItem);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriEquipAssetRelationItemAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriEquipAssetRelationItem oriEquipAssetRelationItem = new OriEquipAssetRelationItem();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");

			oriEquipAssetRelationItem.setDataVersion(versionValue);
			oriEquipAssetRelationItem.setCalYear(DateFormatUtil.parseDate(calYear));

			// oriEquipAssetRelationItem.setOriEquipAssetRelatItemId(csvRecord.get("ORI_EQUIP_ASSET_RELAT_ITEM_ID"));

			oriEquipAssetRelationItem.setEquipmentNumber(csvRecord.get("EQUIPMENT_NUMBER"));
			oriEquipAssetRelationItem.setTechObjectDescription(csvRecord.get("TECH_OBJECT_DESCRIPTION"));
			oriEquipAssetRelationItem.setTechObjectType(csvRecord.get("TECH_OBJECT_TYPE"));
			oriEquipAssetRelationItem.setAssetNumber(csvRecord.get("ASSET_NUMBER"));
			oriEquipAssetRelationItem.setAssetProperty(csvRecord.get("ASSET_PROPERTY"));
			if (!(csvRecord.get("COMMISSIONING_DATE").trim().isEmpty())) {
				oriEquipAssetRelationItem
						.setCommissioningDate(DateFormatUtil.parseDate(csvRecord.get("COMMISSIONING_DATE")));
			}
			oriEquipAssetRelationItem.setAssetPropertyDescription(csvRecord.get("ASSET_PROPERTY_DESCRIPTION"));

			oriEquipAssetRelationItem.setDataSourceFile(pathStr);

			session.save(oriEquipAssetRelationItem);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriEquipmentInformationItemAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriEquipmentInformationItem oriEquipmentInformationItem = new OriEquipmentInformationItem();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");

			oriEquipmentInformationItem.setDataVersion(versionValue);
			oriEquipmentInformationItem.setCalYear(DateFormatUtil.parseDate(calYear));
			// oriEquipmentInformationItem.setOriEquipmentInformatItemId(csvRecord.get("ORI_EQUIPMENT_INFORMAT_ITEM_ID"));
			// oriEquipmentInformationItem.setDataVersion(csvRecord.get("DATA_VERSION"));
			// if(!(csvRecord.get("CAL_YEAR").trim().isEmpty())){try
			// {oriEquipmentInformationItem.setCalYear(simpleDateFormat.parse(csvRecord.get("CAL_YEAR")));
			// } catch (ParseException e) { e.printStackTrace(); }}
			oriEquipmentInformationItem.setEquipmentNumber(csvRecord.get("EQUIPMENT_NUMBER"));
			oriEquipmentInformationItem.setLengthUnit(csvRecord.get("LENGTH_UNIT"));
			oriEquipmentInformationItem.setCapacityUnit(csvRecord.get("CAPACITY_UNIT"));
			if (csvRecord.get("LINE_LENGTH").trim().isEmpty()) {
				oriEquipmentInformationItem.setLineLength(new Double(0.0));
			} else {
				oriEquipmentInformationItem
						.setLineLength(new DecimalFormat().parse(csvRecord.get("LINE_LENGTH")).doubleValue());
			}
			if (csvRecord.get("TRANSFORMER_CAPACITY").trim().isEmpty()) {
				oriEquipmentInformationItem.setTransformerCapacity(new Double(0.0));
			} else {
				oriEquipmentInformationItem.setTransformerCapacity(
						new DecimalFormat().parse(csvRecord.get("TRANSFORMER_CAPACITY")).doubleValue());
			}
			oriEquipmentInformationItem.setRealAssetId(csvRecord.get("REAL_ASSET_ID"));
			// oriEquipmentInformationItem.setDataSourceFile(csvRecord.get("DATA_SOURCE_FILE"));
			// oriAssetInformationItem.setDataSourceFile(csvRecord.get("DATA_SOURCE_FILE"));
			oriEquipmentInformationItem.setDataSourceFile(pathStr);

			session.save(oriEquipmentInformationItem);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriOverAgeItemAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriOverAgeItem oriOverAgeItem = new OriOverAgeItem();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");

			oriOverAgeItem.setDataVersion(versionValue);
			oriOverAgeItem.setCalYear(DateFormatUtil.parseDate(calYear));
			oriOverAgeItem.setAssetNumber(csvRecord.get("ASSET_NUMBER"));
			oriOverAgeItem.setSno(csvRecord.get("SNO"));
			oriOverAgeItem.setExtractYear(csvRecord.get("EXTRACT_YEAR"));
			oriOverAgeItem.setLargeClassCode(csvRecord.get("LARGE_CLASS_CODE"));
			if (csvRecord.get("ORIGINAL_VALUE").trim().isEmpty()) {
				oriOverAgeItem.setOriginalValue(new Double(0.0));
			} else {
				oriOverAgeItem.setOriginalValue(

						new DecimalFormat().parse(csvRecord.get("ORIGINAL_VALUE")).doubleValue());
			}
			if (csvRecord.get("ACCUMULATED_DEPRECIATION").trim().isEmpty()) {
				oriOverAgeItem.setAccumulatedDepreciation(new Double(0.0));
			} else {
				oriOverAgeItem.setAccumulatedDepreciation(
						new DecimalFormat().parse(csvRecord.get("ACCUMULATED_DEPRECIATION")).doubleValue());
			}
			if (csvRecord.get("NET_VALUE").trim().isEmpty()) {
				oriOverAgeItem.setNetValue(new Double(0.0));
			} else {
				oriOverAgeItem.setNetValue(new DecimalFormat().parse(csvRecord.get("NET_VALUE")).doubleValue());
			}
			if (csvRecord.get("DEPRECIATION_RATIO").trim().isEmpty()) {
				oriOverAgeItem.setDepreciationRatio(new Double(0.0));
			} else {
				oriOverAgeItem.setDepreciationRatio(
						new DecimalFormat().parse(csvRecord.get("DEPRECIATION_RATIO")).doubleValue());
			}
			oriOverAgeItem.setDataSourceFile(pathStr);

			session.save(oriOverAgeItem);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvZfiSwzcDiscAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ZfiSwzcDisc zfiSwzcDisc = new ZfiSwzcDisc();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			// pmsItemReuse.setPmsItemReuseId(csvRecord.get("PMS_ITEM_REUSE_ID"));
			// zfiSwzcDisc.setZfiSwzcId(csvRecord.get("ZFI_SWZC_ID"));
			/*
			 * zfiSwzcDisc.setVersion(versionValue); if
			 * (!(csvRecord.get("CAL_YEAR").trim().isEmpty())) { try {
			 * zfiSwzcDisc.setCalYear(simpleDateFormat.parse("2020/04/09"));
			 * //zfiSwzcDisc.setCalYear(simpleDateFormat.parse(csvRecord.get("CAL_YEAR")));
			 * } catch (ParseException e) { e.printStackTrace(); } }
			 */

			try {
				// zfiSwzcDisc.setCalYear(simpleDateFormat.parse("2020-04-09"));
				zfiSwzcDisc.setCalYear(simpleDateFormat.parse(calYear));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			zfiSwzcDisc.setCalyear(Long.parseLong(calYear.substring(0, 4)));
			zfiSwzcDisc.setCompCode(csvRecord.get("COMP_CODE"));
			zfiSwzcDisc.setAssetMain(csvRecord.get("ASSET_MAIN"));
			zfiSwzcDisc.setAsset(csvRecord.get("ASSET"));
			zfiSwzcDisc.setEqunr(csvRecord.get("EQUNR"));
			zfiSwzcDisc.setCurrency(csvRecord.get("CURRENCY"));
			if (csvRecord.get("ZPMZCYZ").trim().isEmpty()) {
				zfiSwzcDisc.setZpmzcyz(new Double(0.0));
			} else {
				zfiSwzcDisc.setZpmzcyz(new DecimalFormat().parse(csvRecord.get("ZPMZCYZ")).doubleValue());
			}
			if (csvRecord.get("ZPMZCJZ").trim().isEmpty()) {
				zfiSwzcDisc.setZpmzcjz(new Double(0.0));
			} else {
				zfiSwzcDisc.setZpmzcjz(new DecimalFormat().parse(csvRecord.get("ZPMZCJZ")).doubleValue());
			}
			zfiSwzcDisc.setZtypbz1(csvRecord.get("ZTYPBZ1"));
			zfiSwzcDisc.setZtypbz2(csvRecord.get("ZTYPBZ2"));
			zfiSwzcDisc.setZtypbz3(csvRecord.get("ZTYPBZ3"));
			zfiSwzcDisc.setZvolLev(csvRecord.get("ZVOL_LEV"));
			if (csvRecord.get("ZQUANTITY").trim().isEmpty()) {
				zfiSwzcDisc.setZquantity(new Double(0));
			} else {
				zfiSwzcDisc.setZquantity(new DecimalFormat().parse(csvRecord.get("ZQUANTITY")).doubleValue());
			}
			zfiSwzcDisc.setUnit(csvRecord.get("UNIT"));
			zfiSwzcDisc.setZioZczt(csvRecord.get("ZIO_ZCZT"));
			zfiSwzcDisc.setProfitCtr(csvRecord.get("PROFIT_CTR"));
			zfiSwzcDisc.setZlrzx(csvRecord.get("ZLRZX"));
			zfiSwzcDisc.setCoArea(csvRecord.get("CO_AREA"));
			zfiSwzcDisc.setZzcms(csvRecord.get("ZZCMS"));
			zfiSwzcDisc.setZioZxmlx(csvRecord.get("ZIO_ZXMLX"));
			zfiSwzcDisc.setAktiv(csvRecord.get("AKTIV"));
			zfiSwzcDisc.setDeakt(csvRecord.get("DEAKT"));
			zfiSwzcDisc.setAnlkl(csvRecord.get("ANLKL"));
			zfiSwzcDisc.setSernr(csvRecord.get("SERNR"));
			zfiSwzcDisc.setInvnr(csvRecord.get("INVNR"));
			zfiSwzcDisc.setZzc001(csvRecord.get("ZZC001"));
			zfiSwzcDisc.setZzc002(csvRecord.get("ZZC002"));
			zfiSwzcDisc.setKostl(csvRecord.get("KOSTL"));
			zfiSwzcDisc.setKostlv(csvRecord.get("KOSTLV"));
			zfiSwzcDisc.setRaumn(csvRecord.get("RAUMN"));
			zfiSwzcDisc.setKfzkz(csvRecord.get("KFZKZ"));
			zfiSwzcDisc.setZzas1(csvRecord.get("ZZAS1"));
			zfiSwzcDisc.setZzc006(csvRecord.get("ZZC006"));
			zfiSwzcDisc.setZzc007(csvRecord.get("ZZC007"));
			zfiSwzcDisc.setOrd41(csvRecord.get("ORD41"));
			zfiSwzcDisc.setOrd44(csvRecord.get("ORD44"));
			zfiSwzcDisc.setGdlgrp(csvRecord.get("GDLGRP"));
			zfiSwzcDisc.setIzwek(csvRecord.get("IZWEK"));
			zfiSwzcDisc.setUmwkz(csvRecord.get("UMWKZ"));
			zfiSwzcDisc.setAnlue(csvRecord.get("ANLUE"));
			zfiSwzcDisc.setHerst(csvRecord.get("HERST"));
			zfiSwzcDisc.setTypbz(csvRecord.get("TYPBZ"));
			zfiSwzcDisc.setZkpwbs(csvRecord.get("ZKPWBS"));
			zfiSwzcDisc.setZkpwbsms(csvRecord.get("ZKPWBSMS"));
			zfiSwzcDisc.setFiamt(csvRecord.get("FIAMT"));
			zfiSwzcDisc.setStadt(csvRecord.get("STADT"));
			zfiSwzcDisc.setZfwcqzh(csvRecord.get("ZFWCQZH"));
			// zfiSwzcDisc.setEqktx(csvRecord.get("EQKTX"));
			zfiSwzcDisc.setTxt04(csvRecord.get("TXT04"));
			zfiSwzcDisc.setEqart(csvRecord.get("EQART"));
			zfiSwzcDisc.setBegru(csvRecord.get("BEGRU"));
			zfiSwzcDisc.setInbdt(csvRecord.get("INBDT"));
			zfiSwzcDisc.setZccrq(csvRecord.get("ZCCRQ"));
			zfiSwzcDisc.setZherst(csvRecord.get("ZHERST"));
			zfiSwzcDisc.setHerld(csvRecord.get("HERLD"));
			zfiSwzcDisc.setMapar(csvRecord.get("MAPAR"));
			zfiSwzcDisc.setZtypbz(csvRecord.get("ZTYPBZ"));
			zfiSwzcDisc.setSerge(csvRecord.get("SERGE"));
			zfiSwzcDisc.setSwerk(csvRecord.get("SWERK"));
			zfiSwzcDisc.setStort(csvRecord.get("STORT"));
			zfiSwzcDisc.setBeber(csvRecord.get("BEBER"));
			zfiSwzcDisc.setAbckz(csvRecord.get("ABCKZ"));
			zfiSwzcDisc.setEqfnr(csvRecord.get("EQFNR"));
			zfiSwzcDisc.setZkostl(csvRecord.get("ZKOSTL"));
			zfiSwzcDisc.setZsbwbs(csvRecord.get("ZSBWBS"));
			zfiSwzcDisc.setZsbwbsms(csvRecord.get("ZSBWBSMS"));
			zfiSwzcDisc.setIwerk(csvRecord.get("IWERK"));
			zfiSwzcDisc.setIngrp(csvRecord.get("INGRP"));
			zfiSwzcDisc.setGewrk(csvRecord.get("GEWRK"));
			zfiSwzcDisc.setTplnr(csvRecord.get("TPLNR"));
			zfiSwzcDisc.setHequi(csvRecord.get("HEQUI"));
			zfiSwzcDisc.setTidnr(csvRecord.get("TIDNR"));
			zfiSwzcDisc.setZsb010(csvRecord.get("ZSB010"));
			zfiSwzcDisc.setZsb001(csvRecord.get("ZSB001"));
			zfiSwzcDisc.setZsb002(csvRecord.get("ZSB002"));
			zfiSwzcDisc.setZsb004(csvRecord.get("ZSB004"));
			zfiSwzcDisc.setZsb005(csvRecord.get("ZSB005"));
			zfiSwzcDisc.setZsb006(csvRecord.get("ZSB006"));
			zfiSwzcDisc.setZsb003(csvRecord.get("ZSB003"));
			zfiSwzcDisc.setZsb007(csvRecord.get("ZSB007"));
			zfiSwzcDisc.setZsb008(csvRecord.get("ZSB008"));
			zfiSwzcDisc.setZlenunt(csvRecord.get("ZLENUNT"));
			zfiSwzcDisc.setZsb009(csvRecord.get("ZSB009"));
			zfiSwzcDisc.setZcapunt(csvRecord.get("ZCAPUNT"));
			zfiSwzcDisc.setZsb011(csvRecord.get("ZSB011"));
			zfiSwzcDisc.setZeq003(csvRecord.get("ZEQ003"));
			zfiSwzcDisc.setZeq001(csvRecord.get("ZEQ001"));
			zfiSwzcDisc.setZeq002(csvRecord.get("ZEQ002"));
			zfiSwzcDisc.setZlyrkrq(csvRecord.get("ZLYRKRQ"));
			zfiSwzcDisc.setZlyckrq(csvRecord.get("ZLYCKRQ"));
			zfiSwzcDisc.setZbfjzrq(csvRecord.get("ZBFJZRQ"));
			zfiSwzcDisc.setZbfxmbm(csvRecord.get("ZBFXMBM"));
			zfiSwzcDisc.setZbfxmms(csvRecord.get("ZBFXMMS"));
			zfiSwzcDisc.setZbfyydm(csvRecord.get("ZBFYYDM"));
			zfiSwzcDisc.setZbfyywb(csvRecord.get("ZBFYYWB"));
			zfiSwzcDisc.setPmunr(csvRecord.get("PMUNR"));
			/*
			 * zfiSwzcDisc.setCdate(csvRecord.get("CDATE"));
			 * zfiSwzcDisc.setCtime(csvRecord.get("CTIME"));
			 * zfiSwzcDisc.setCname(csvRecord.get("CNAME"));
			 */
			zfiSwzcDisc.setAssetProperty(csvRecord.get("ASSET_PROPERTY"));
			zfiSwzcDisc.setPropertyCode(csvRecord.get("PROPERTY_CODE"));
			zfiSwzcDisc.setDataSourceFile(pathStr);
			zfiSwzcDisc.setDataVersion(versionValue);
			zfiSwzcDisc.setAssetId(csvRecord.get("ASSET_ID"));
			// zfiSwzcDisc.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			// zfiSwzcDisc.setOrgGroupCode(csvRecord.get("ORG_GROUP_CODE"));
			zfiSwzcDisc.setZtypbz1T(csvRecord.get("ZTYPBZ1_T"));
			zfiSwzcDisc.setZtypbz2T(csvRecord.get("ZTYPBZ2_T"));
			zfiSwzcDisc.setZtypbz3T(csvRecord.get("ZTYPBZ3_T"));
			zfiSwzcDisc.setAssetDescription(csvRecord.get("ASSET_DESCRIPTION"));
			zfiSwzcDisc.setFixAssetClassDescript(csvRecord.get("FIX_ASSET_CLASS_DESCRIPT"));
			// zfiSwzcDisc.setUnkownCode(csvRecord.get("UNKOWN_CODE"));
			zfiSwzcDisc.setAssetPropertyCvsName(csvRecord.get("ASSET_PROPERTY_CVS_NAME"));
			zfiSwzcDisc.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			zfiSwzcDisc.setRealAssetIdEquip(csvRecord.get("REAL_ASSET_ID_EQUIP"));
			zfiSwzcDisc.setDiscardCapacityScale(csvRecord.get("DISCARD_CAPACITY_SCALE"));
			if (csvRecord.get("DISCARD_PAPER_NUMBER").trim().isEmpty()) {
				zfiSwzcDisc.setDiscardPaperNumber(new Double(0.0));
			} else {
				zfiSwzcDisc.setDiscardPaperNumber(
						new DecimalFormat().parse(csvRecord.get("DISCARD_PAPER_NUMBER")).doubleValue());
			}
			zfiSwzcDisc.setMetreUnit(csvRecord.get("METRE_UNIT"));
			zfiSwzcDisc.setDiscardSourceProject(csvRecord.get("DISCARD_SOURCE_PROJECT"));
			/*
			 * zfiSwzcDisc.setDiscardSourceProjectId(csvRecord.get(
			 * "DISCARD_SOURCE_PROJECT_ID"));
			 * zfiSwzcDisc.setDiscardSourceProjectDescr(csvRecord.get(
			 * "DISCARD_SOURCE_PROJECT_DESCR"));
			 * zfiSwzcDisc.setDiscardSourceProjectType(csvRecord.get(
			 * "DISCARD_SOURCE_PROJECT_TYPE")); zfiSwzcDisc.setWbs(csvRecord.get("WBS"));
			 * zfiSwzcDisc.setCostCenterDescription(csvRecord.get("COST_CENTER_DESCRIPTION")
			 * ); zfiSwzcDisc.setGroupCode(csvRecord.get("GROUP_CODE"));
			 */

			session.save(zfiSwzcDisc);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriFinanceScrapPostEquipAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriFinanceScrapPostEquip oriFinanceScrapPostEquip = new OriFinanceScrapPostEquip();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			/*
			 * oriFinanceScrapPostEquip.setOriFinancScrapPostEquipId(csvRecord.get(
			 * "ORI_FINANC_SCRAP_POST_EQUIP_ID"));
			 */

			oriFinanceScrapPostEquip.setDataVersion(versionValue);
			oriFinanceScrapPostEquip.setCalYear(DateFormatUtil.parseDate(calYear));
			oriFinanceScrapPostEquip.setEquipmentNo(csvRecord.get("EQUIPMENT_NO"));
			oriFinanceScrapPostEquip.setTechnicalObjectType(csvRecord.get("TECHNICAL_OBJECT_TYPE"));
			oriFinanceScrapPostEquip.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			oriFinanceScrapPostEquip.setEquipmentIncreaseMode(csvRecord.get("EQUIPMENT_INCREASE_MODE"));
			oriFinanceScrapPostEquip.setAssetManufacturer(csvRecord.get("ASSET_MANUFACTURER"));
			oriFinanceScrapPostEquip.setModel(csvRecord.get("MODEL"));
			oriFinanceScrapPostEquip.setUserStatus(csvRecord.get("USER_STATUS"));
			oriFinanceScrapPostEquip.setAssetPropertyCode(csvRecord.get("ASSET_PROPERTY_CODE"));
			oriFinanceScrapPostEquip.setAssetPropertyTxt(csvRecord.get("ASSET_PROPERTY_TXT"));
			oriFinanceScrapPostEquip.setEquipmentDescription(csvRecord.get("EQUIPMENT_DESCRIPTION"));
			if (!(csvRecord.get("COMMISSIONING_DATE").trim().isEmpty())) {
				oriFinanceScrapPostEquip
						.setCommissioningDate(DateFormatUtil.parseDate(csvRecord.get("COMMISSIONING_DATE")));
			}
			oriFinanceScrapPostEquip.setLengthUnit(csvRecord.get("LENGTH_UNIT"));
			oriFinanceScrapPostEquip.setCapacitanceUnit(csvRecord.get("CAPACITANCE_UNIT"));
			if (csvRecord.get("LINE_LENGTH").trim().isEmpty()) {
				oriFinanceScrapPostEquip.setLineLength(new Double(0.0));
			} else {
				oriFinanceScrapPostEquip
						.setLineLength(new DecimalFormat().parse(csvRecord.get("LINE_LENGTH")).doubleValue());
			}
			if (csvRecord.get("SUBSTATION_CAPACITY").trim().isEmpty()) {
				oriFinanceScrapPostEquip.setSubstationCapacity(new Double(0.0));
			} else {
				oriFinanceScrapPostEquip.setSubstationCapacity(
						new DecimalFormat().parse(csvRecord.get("SUBSTATION_CAPACITY")).doubleValue());
			}
			oriFinanceScrapPostEquip.setEquipmentPhysicalId(csvRecord.get("EQUIPMENT_PHYSICAL_ID"));
			oriFinanceScrapPostEquip.setDataSourceFileName(pathStr);

			session.save(oriFinanceScrapPostEquip);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriFinanceScrapPostAssetAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriFinanceScrapPostAsset oriFinanceScrapPostAsset = new OriFinanceScrapPostAsset();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			/*
			 * oriFinanceScrapPostAsset.setOriFinancScrapPostAssetId(csvRecord.get(
			 * "ORI_FINANC_SCRAP_POST_ASSET_ID"));
			 */

			oriFinanceScrapPostAsset.setDataVersion(versionValue);
			oriFinanceScrapPostAsset.setCalYear(DateFormatUtil.parseDate(calYear));
			oriFinanceScrapPostAsset.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			oriFinanceScrapPostAsset.setAssetsNo(csvRecord.get("ASSETS_NO"));
			oriFinanceScrapPostAsset.setSno(csvRecord.get("SNO"));
			oriFinanceScrapPostAsset.setClassification(csvRecord.get("CLASSIFICATION"));
			oriFinanceScrapPostAsset.setTypeName(csvRecord.get("TYPE_NAME"));
			oriFinanceScrapPostAsset.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			if (csvRecord.get("QUANTITY").trim().isEmpty()) {
				oriFinanceScrapPostAsset.setQuantity(new Double(0.0));
			} else {
				oriFinanceScrapPostAsset
						.setQuantity(new DecimalFormat().parse(csvRecord.get("QUANTITY")).doubleValue());
			}
			oriFinanceScrapPostAsset.setMeterUnit(csvRecord.get("METER_UNIT"));
			oriFinanceScrapPostAsset.setAssetStatus(csvRecord.get("ASSET_STATUS"));
			oriFinanceScrapPostAsset.setCostCenter(csvRecord.get("COST_CENTER"));
			oriFinanceScrapPostAsset.setAssetDescription(csvRecord.get("ASSET_DESCRIPTION"));
			if (!(csvRecord.get("CAPITALIZATION_DATE").trim().isEmpty())) {
				oriFinanceScrapPostAsset
						.setCapitalizationDate(DateFormatUtil.parseDate(csvRecord.get("CAPITALIZATION_DATE")));
			}
			if (!(csvRecord.get("INACTIVE_DATE").trim().isEmpty())) {
				oriFinanceScrapPostAsset.setInactiveDate(DateFormatUtil.parseDate(csvRecord.get("INACTIVE_DATE")));
			}
			oriFinanceScrapPostAsset.setLocationAddress(csvRecord.get("LOCATION_ADDRESS"));
			oriFinanceScrapPostAsset.setAssetPhysicalId(csvRecord.get("ASSET_PHYSICAL_ID"));
			oriFinanceScrapPostAsset.setDataSourceFileName(pathStr);

			session.save(oriFinanceScrapPostAsset);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriFinanceScrapPostRecordAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriFinanceScrapPostRecord oriFinanceScrapPostRecord = new OriFinanceScrapPostRecord();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			/*
			 * oriFinanceScrapPostRecord.setOriFinanScrapPostRecordId(csvRecord.get(
			 * "ORI_FINAN_SCRAP_POST_RECORD_ID"));
			 */

			oriFinanceScrapPostRecord.setCalYear(DateFormatUtil.parseDate(calYear));
			oriFinanceScrapPostRecord.setDataVersion(versionValue);

			oriFinanceScrapPostRecord.setApplicationNo(csvRecord.get("APPLICATION_NO"));
			oriFinanceScrapPostRecord.setMainEquipmentNumber(csvRecord.get("MAIN_EQUIPMENT_NUMBER"));
			oriFinanceScrapPostRecord.setMainEquipmentStatus(csvRecord.get("MAIN_EQUIPMENT_STATUS"));
			oriFinanceScrapPostRecord.setClassification(csvRecord.get("CLASSIFICATION"));
			oriFinanceScrapPostRecord.setAssetClassAlias(csvRecord.get("ASSET_CLASS_ALIAS"));
			oriFinanceScrapPostRecord.setAssetsNumber(csvRecord.get("ASSETS_NUMBER"));
			oriFinanceScrapPostRecord.setAssetDescription(csvRecord.get("ASSET_DESCRIPTION"));
			oriFinanceScrapPostRecord.setAssetRetirement(csvRecord.get("ASSET_RETIREMENT"));
			oriFinanceScrapPostRecord.setChangingState(csvRecord.get("CHANGING_STATE"));
			if (!(csvRecord.get("ASSET_VALUE_DATE").trim().isEmpty())) {
				oriFinanceScrapPostRecord
						.setAssetValueDate(DateFormatUtil.parseDate(csvRecord.get("ASSET_VALUE_DATE")));

			}
			if (!(csvRecord.get("BOOKKEEPING_DATE").trim().isEmpty())) {
				oriFinanceScrapPostRecord
						.setBookkeepingDate(DateFormatUtil.parseDate(csvRecord.get("BOOKKEEPING_DATE")));

			}
			if (csvRecord.get("ORIGINAL_BOOK_VALUE").trim().isEmpty()) {
				oriFinanceScrapPostRecord.setOriginalBookValue(new Double(0.0));
			} else {
				oriFinanceScrapPostRecord.setOriginalBookValue(
						new DecimalFormat().parse(csvRecord.get("ORIGINAL_BOOK_VALUE")).doubleValue());
			}
			if (csvRecord.get("ACCUMULATED_DEPRECIATION").trim().isEmpty()) {
				oriFinanceScrapPostRecord.setAccumulatedDepreciation(new Double(0.0));
			} else {
				oriFinanceScrapPostRecord.setAccumulatedDepreciation(
						new DecimalFormat().parse(csvRecord.get("ACCUMULATED_DEPRECIATION")).doubleValue());
			}
			if (csvRecord.get("PROVISION_FOR_IMPAIRMENT").trim().isEmpty()) {
				oriFinanceScrapPostRecord.setProvisionForImpairment(new Double(0.0));
			} else {
				oriFinanceScrapPostRecord.setProvisionForImpairment(
						new DecimalFormat().parse(csvRecord.get("PROVISION_FOR_IMPAIRMENT")).doubleValue());
			}
			if (csvRecord.get("NET_BOOK_VALUE").trim().isEmpty()) {
				oriFinanceScrapPostRecord.setNetBookValue(new Double(0.0));
			} else {
				oriFinanceScrapPostRecord
						.setNetBookValue(new DecimalFormat().parse(csvRecord.get("NET_BOOK_VALUE")).doubleValue());
			}
			if (csvRecord.get("SCRAP_RATIO").trim().isEmpty()) {
				oriFinanceScrapPostRecord.setScrapRatio(new Double(0.0));
			} else {
				oriFinanceScrapPostRecord
						.setScrapRatio(new DecimalFormat().parse(csvRecord.get("SCRAP_RATIO")).doubleValue());
			}
			if (csvRecord.get("SCRAP_ORIGINAL_VALUE").trim().isEmpty()) {
				oriFinanceScrapPostRecord.setScrapOriginalValue(new Double(0.0));
			} else {
				oriFinanceScrapPostRecord.setScrapOriginalValue(
						new DecimalFormat().parse(csvRecord.get("SCRAP_ORIGINAL_VALUE")).doubleValue());
			}
			if (csvRecord.get("SCRAP_DEPRECIATION").trim().isEmpty()) {
				oriFinanceScrapPostRecord.setScrapDepreciation(new Double(0.0));
			} else {
				oriFinanceScrapPostRecord.setScrapDepreciation(
						new DecimalFormat().parse(csvRecord.get("SCRAP_DEPRECIATION")).doubleValue());
			}
			oriFinanceScrapPostRecord.setCostCenter(csvRecord.get("COST_CENTER"));
			if (csvRecord.get("QUANTITY").trim().isEmpty()) {
				oriFinanceScrapPostRecord.setQuantity(new Double(0.0));
			} else {
				oriFinanceScrapPostRecord
						.setQuantity(new DecimalFormat().parse(csvRecord.get("QUANTITY")).doubleValue());
			}
			oriFinanceScrapPostRecord.setMeterUnit(csvRecord.get("METER_UNIT"));
			oriFinanceScrapPostRecord.setUnitOfMeasureText(csvRecord.get("UNIT_OF_MEASURE_TEXT"));
			oriFinanceScrapPostRecord.setAssetManufacturer(csvRecord.get("ASSET_MANUFACTURER"));
			if (!(csvRecord.get("CAPITALIZATION_DATE").trim().isEmpty())) {
				oriFinanceScrapPostRecord
						.setCapitalizationDate(DateFormatUtil.parseDate(csvRecord.get("CAPITALIZATION_DATE")));

			}

			oriFinanceScrapPostRecord.setProfitCenter(csvRecord.get("PROFIT_CENTER"));
			oriFinanceScrapPostRecord.setScrapReasonCode(csvRecord.get("SCRAP_REASON_CODE"));
			oriFinanceScrapPostRecord.setScrapReasonDescription(csvRecord.get("SCRAP_REASON_DESCRIPTION"));
			oriFinanceScrapPostRecord.setObjectType(csvRecord.get("OBJECT_TYPE"));
			oriFinanceScrapPostRecord.setDataSourceFileName(pathStr);

			session.save(oriFinanceScrapPostRecord);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvUpZfiaaBfAdd(String pathStr, String versionValue, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			UpZfiaaBf upZfiaaBf = new UpZfiaaBf();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			// pmsItemReuse.setPmsItemReuseId(csvRecord.get("PMS_ITEM_REUSE_ID"));
			upZfiaaBf.setUpZfiaaBfId(csvRecord.get("UP_ZFIAA_BF_ID"));
			try {

				if (csvRecord.get("CAL_YEAR").trim().isEmpty()) {
					upZfiaaBf.setCalYear(new Integer(0));
				} else {
					upZfiaaBf.setCalYear(new Integer(csvRecord.get("CAL_YEAR")));
				}
			} catch (Exception e) {
				// TODO: handle exception
				upZfiaaBf.setCalYear(new Integer(calYear));
			}
			upZfiaaBf.setVersion(versionValue);
			upZfiaaBf.setCompCode(csvRecord.get("COMP_CODE"));
			upZfiaaBf.setAssetMain(csvRecord.get("ASSET_MAIN"));
			upZfiaaBf.setAsset(csvRecord.get("ASSET"));
			upZfiaaBf.setZzcms(csvRecord.get("ZZCMS"));
			upZfiaaBf.setCalyear(csvRecord.get("CALYEAR"));
			upZfiaaBf.setProfitCtr(csvRecord.get("PROFIT_CTR"));
			upZfiaaBf.setZlrzx(csvRecord.get("ZLRZX"));
			upZfiaaBf.setZtypbz1(csvRecord.get("ZTYPBZ1"));
			// upZfiaaBf.setZtypbz2(csvRecord.get("ZTYPBZ2"));
			upZfiaaBf.setZtypbz3(csvRecord.get("ZTYPBZ3"));
			upZfiaaBf.setZioZxmlx(csvRecord.get("ZIO_ZXMLX"));
			upZfiaaBf.setZioZusye(csvRecord.get("ZIO_ZUSYE"));
			upZfiaaBf.setZvolLev(csvRecord.get("ZVOL_LEV"));
			upZfiaaBf.setCoArea(csvRecord.get("CO_AREA"));
			upZfiaaBf.setUnit(csvRecord.get("UNIT"));
			upZfiaaBf.setZbfyy(csvRecord.get("ZBFYY"));
			upZfiaaBf.setCurrency(csvRecord.get("CURRENCY"));
			upZfiaaBf.setRecordmode(csvRecord.get("RECORDMODE"));
			if (csvRecord.get("ZPMZCJZ").trim().isEmpty()) {
				upZfiaaBf.setZpmzcjz(new Double(0.0));
			} else {
				try {
					upZfiaaBf.setZpmzcjz(new DecimalFormat().parse(csvRecord.get("ZPMZCJZ")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (csvRecord.get("ZPMZCYZ").trim().isEmpty()) {
				upZfiaaBf.setZpmzcyz(new Double(0.0));
			} else {
				try {
					upZfiaaBf.setZpmzcyz(new DecimalFormat().parse(csvRecord.get("ZPMZCYZ")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (csvRecord.get("ZQUANTITY").trim().isEmpty()) {
				upZfiaaBf.setZquantity(new Double(0.0));
			} else {
				try {
					upZfiaaBf.setZquantity(new DecimalFormat().parse(csvRecord.get("ZQUANTITY")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				upZfiaaBf.setFixedAssetClassificateCode(csvRecord.get("FIXED_ASSET_CLASSIFICATE_CODE"));
			} catch (Exception e) {
				// TODO: handle exception
				upZfiaaBf.setFixedAssetClassificateCode("");
			}
			try {
				upZfiaaBf.setFixedAssetClassifDescript(csvRecord.get("FIXED_ASSET_CLASSIF_DESCRIPT"));
			} catch (Exception e) {
				// TODO: handle exception
				upZfiaaBf.setFixedAssetClassifDescript("");
			}

			try {
				upZfiaaBf.setIncreasedProjectType(csvRecord.get("INCREASED_PROJECT_TYPE"));
			} catch (Exception e) {
				// TODO: handle exception
				upZfiaaBf.setIncreasedProjectType("");
			}

			if (!(csvRecord.get("DISCARD_BOOK_DATE").trim().isEmpty())) {
				/*
				 * try { upZfiaaBf.setDiscardBookDate(simpleDateFormat.parse(csvRecord.get(
				 * "DISCARD_BOOK_DATE"))); } catch (ParseException e) { try {
				 * upZfiaaBf.setDiscardBookDate(simpleDateFormat2.parse(csvRecord.get(
				 * "DISCARD_BOOK_DATE"))); } catch (ParseException e1) { // TODO Auto-generated
				 * catch block // e1.printStackTrace(); } }
				 */
				DateFormatUtil.parseDate(csvRecord.get("DISCARD_BOOK_DATE"));

			}
			try {
				if (!(csvRecord.get("CAPITALIZATION_DATE").trim().isEmpty())) {
					upZfiaaBf.setCapitalizationDate(DateFormatUtil.parseDate(csvRecord.get("CAPITALIZATION_DATE")));
				}
			} catch (Exception e) { // TODO: handle exception

			}
			try {
				if (!(csvRecord.get("INACTIVE_DATE").trim().isEmpty())) {
					try {
						upZfiaaBf.setInactiveDate(simpleDateFormat2.parse(csvRecord.get("INACTIVE_DATE")));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) { // TODO: handle exception

			}

			try {
				upZfiaaBf.setDiscardType(csvRecord.get("DISCARD_TYPE"));
			} catch (Exception e) {
				// TODO: handle exception
				upZfiaaBf.setDiscardType("");
			}
			try {
				upZfiaaBf.setAreaName(csvRecord.get("areaName"));
			} catch (Exception e) {
				// TODO: handle exception
				upZfiaaBf.setAreaName("");
			}
			try {
				upZfiaaBf.setTextDescription(csvRecord.get("TEXT_DESCRIPTION"));
			} catch (Exception e) { // TODO: handle exception
				upZfiaaBf.setTextDescription("");
			}
			try {
				upZfiaaBf.setResume(csvRecord.get("RESUME"));
			} catch (Exception e) {
				// TODO: handle exception
				upZfiaaBf.setResume("");
			}

			try {
				upZfiaaBf.setDataSourceFile(csvRecord.get("DATA_SOURCE_FILE"));
			} catch (Exception e) {
				// TODO: handle exception
				upZfiaaBf.setDataSourceFile(pathStr);
			}

			session.save(upZfiaaBf);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvPmsItemReuseAdd(String pathStr, String versionValue, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemReuse pmsItemReuse = new PmsItemReuse();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			// pmsItemReuse.setPmsItemReuseId(csvRecord.get("PMS_ITEM_REUSE_ID"));
			pmsItemReuse.setCalYear(DateFormatUtil.parseDate(calYear));

			// pmsItemReuse.setVersion(csvRecord.get("VERSION"));
			pmsItemReuse.setVersion(versionValue);
			try {
				pmsItemReuse.setOldEquipmentName(csvRecord.get("OLD_EQUIPMENT_NAME"));
			} catch (Exception e) {
				// TODO: handle exception
				pmsItemReuse.setOldEquipmentName("");
			}
			try {
				pmsItemReuse.setEquipmentType(csvRecord.get("EQUIPMENT_TYPE"));
			} catch (Exception e) {
				// TODO: handle exception
				pmsItemReuse.setEquipmentType("");
			}
			pmsItemReuse.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			pmsItemReuse.setOldTransformSubstationLine(csvRecord.get("OLD_TRANSFORM_SUBSTATION_LINE"));
			pmsItemReuse.setRepositoryAddress(csvRecord.get("REPOSITORY_ADDRESS"));
			try {
				pmsItemReuse.setEquipmentCustodian(csvRecord.get("EQUIPMENT_CUSTODIAN"));
			} catch (Exception e) {
				// TODO: handle exception
				pmsItemReuse.setEquipmentCustodian("");
			}
			pmsItemReuse.setEquipmentEvaluationResult(csvRecord.get("EQUIPMENT_EVALUATION_RESULT"));
			pmsItemReuse.setAssetProperty(csvRecord.get("ASSET_PROPERTY"));
			pmsItemReuse.setOldMaintenanceOrgName(csvRecord.get("OLD_MAINTENANCE_ORG_NAME"));
			pmsItemReuse.setAssetNumber(csvRecord.get("ASSET_NUMBER"));
			pmsItemReuse.setEquipmentNumber(csvRecord.get("EQUIPMENT_NUMBER"));
			// pmsItemReuse.setPmEquipmentNumber(csvRecord.get("PM_EQUIPMENT_NUMBER"));
			try {
				if (csvRecord.get("ORIGINAL_VALUE").trim().isEmpty()) {
					pmsItemReuse.setOriginalValue(new Double(0.0));
				} else {
					pmsItemReuse.setOriginalValue(Double.parseDouble(csvRecord.get("ORIGINAL_VALUE")));
				}
			} catch (Exception e) {
				// TODO: handle exception
				pmsItemReuse.setOriginalValue(new Double(0.0));
			}

			try {
				if (csvRecord.get("NET_VALUE").trim().isEmpty()) {
					pmsItemReuse.setNetValue(new Double(0.0));
				} else {
					pmsItemReuse.setNetValue(Double.parseDouble(csvRecord.get("NET_VALUE")));
				}
			} catch (Exception e) {
				// TODO: handle exception
				pmsItemReuse.setNetValue(new Double(0.0));
			}
			if (!(csvRecord.get("DELIVERY_DATE").trim().isEmpty())) {

				/*
				 * try { pmsItemReuse.setDeliveryDate(simpleDateFormat.parse(csvRecord.get(
				 * "DELIVERY_DATE"))); } catch (ParseException e) { try {
				 * pmsItemReuse.setDeliveryDate(simpleDateFormat2.parse(csvRecord.get(
				 * "DELIVERY_DATE"))); } catch (ParseException e1) { // TODO Auto-generated
				 * catch block e1.printStackTrace(); } }
				 */
				DateFormatUtil.parseDate(csvRecord.get("DELIVERY_DATE"));
			}
			if (!(csvRecord.get("STORAGE_DATE").trim().isEmpty())) {
				/*
				 * try { pmsItemReuse.setStorageDate(simpleDateFormat.parse(csvRecord.get(
				 * "STORAGE_DATE"))); } catch (ParseException e) { try {
				 * pmsItemReuse.setStorageDate(simpleDateFormat2.parse(csvRecord.get(
				 * "STORAGE_DATE"))); } catch (ParseException e1) { // TODO Auto-generated catch
				 * block e1.printStackTrace(); } }
				 */
				DateFormatUtil.parseDate(csvRecord.get("STORAGE_DATE"));

			}
			// pmsItemReuse.setIsOccupied(csvRecord.get("IS_OCCUPIED"));
			// pmsItemReuse.setOccupiedOrgName(csvRecord.get("OCCUPIED_ORG_NAME"));
			// pmsItemReuse.setOccupiedProjectName(csvRecord.get("OCCUPIED_PROJECT_NAME"));
			// pmsItemReuse.setUnit(csvRecord.get("UNIT"));
			pmsItemReuse.setDisposialStatus(csvRecord.get("DISPOSIAL_STATUS"));

			pmsItemReuse.setMaintenanceOrgId(csvRecord.get("MAINTENANCE_ORG_ID"));
			pmsItemReuse.setSubordinateMunicipality(csvRecord.get("SUBORDINATE_MUNICIPALITY"));
			pmsItemReuse.setSubordinateMaintenanceOrg(csvRecord.get("SUBORDINATE_MAINTENANCE_ORG"));
			pmsItemReuse.setModifierName(csvRecord.get("MODIFIER_NAME"));
			if (csvRecord.get("WHETHER_BEEN_USED").trim().isEmpty()) {
				pmsItemReuse.setWhetherBeenUsed(new Double(0.0));
			} else {
				pmsItemReuse.setWhetherBeenUsed(Double.parseDouble(csvRecord.get("WHETHER_BEEN_USED")));
			}
			try {
				pmsItemReuse.setDataSourceFile(csvRecord.get("DATA_SOURCE_FILE"));
			} catch (Exception e) {
				// TODO: handle exception
				pmsItemReuse.setDataSourceFile(pathStr);
			}

			session.save(pmsItemReuse);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriEquipmentRealAssetCodeAdd(String pathStr, String versionValue, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriEquipmentRealAssetCode oriEquipmentRealAssetCode = new OriEquipmentRealAssetCode();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy-MM-dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			if (calYear.length() <= 10) {
				oriEquipmentRealAssetCode.setCalYear(DateFormatUtil.parseDate(calYear));
			} else {
				oriEquipmentRealAssetCode.setCalYear(DateFormatUtil.parseDate(calYear));
			}
			// pmsItemBackup.setVersion(csvRecord.get("VERSION"));
			oriEquipmentRealAssetCode.setDataVersion(versionValue);

			oriEquipmentRealAssetCode.setClass_(csvRecord.get("CLASS"));
			oriEquipmentRealAssetCode.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			oriEquipmentRealAssetCode.setRealAssetId(csvRecord.get("REAL_ASSET_ID"));
			try {
				oriEquipmentRealAssetCode.setDataSourceFile(csvRecord.get("DATA_SOURCE_FILE"));
			} catch (Exception e) {
				// TODO: handle exception
				oriEquipmentRealAssetCode.setDataSourceFile(pathStr);
			}
			session.save(oriEquipmentRealAssetCode);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();

	}

	public static void csvOriWorkTicketAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriWorkTicket oriWorkTicket = new OriWorkTicket();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");
			oriWorkTicket.setDataVersion(versionValue);

			oriWorkTicket.setCalYear(DateFormatUtil.parseDate(calYear));
			oriWorkTicket.setObjId(csvRecord.get("OBJ__ID"));
			oriWorkTicket.setTicketName(csvRecord.get("TICKET_NAME"));
			oriWorkTicket.setTicketType(csvRecord.get("TICKET_TYPE"));
			oriWorkTicket.setTicketNumber(csvRecord.get("TICKET_NUMBER"));
			oriWorkTicket.setTicketStatus(csvRecord.get("TICKET_STATUS"));
			oriWorkTicket.setOutsourcingOrNot(csvRecord.get("OUTSOURCING_OR_NOT"));
			oriWorkTicket.setStationLineType(csvRecord.get("STATION_LINE_TYPE"));
			oriWorkTicket.setWorkPlaceName(csvRecord.get("WORK_PLACE_NAME"));
			oriWorkTicket.setWorkplaceDescription(csvRecord.get("WORKPLACE_DESCRIPTION"));
			oriWorkTicket.setJobContent(csvRecord.get("JOB_CONTENT"));
			if (!(csvRecord.get("TICKET_MAKING_TIME").trim().isEmpty())) {
				oriWorkTicket.setTicketMakingTime(DateFormatUtil.parseDate(csvRecord.get("TICKET_MAKING_TIME")));
			}
			oriWorkTicket.setTicketingDepartmentName(csvRecord.get("TICKETING_DEPARTMENT_NAME"));
			oriWorkTicket.setTicketMakerName(csvRecord.get("TICKET_MAKER_NAME"));
			oriWorkTicket.setOperationOrgName(csvRecord.get("OPERATION_ORG_NAME"));
			oriWorkTicket.setFilingDepartmentName(csvRecord.get("FILING_DEPARTMENT_NAME"));
			oriWorkTicket.setArchivistName(csvRecord.get("ARCHIVIST_NAME"));
			oriWorkTicket.setChargePersonName(csvRecord.get("CHARGE_PERSON_NAME"));
			oriWorkTicket.setApproverName(csvRecord.get("APPROVER_NAME"));
			oriWorkTicket.setDeqfrmc(csvRecord.get("DEQFRMC"));
			oriWorkTicket.setTeamMembers(csvRecord.get("TEAM_MEMBERS"));
			if (!(csvRecord.get("PLANNED_START_TIME").trim().isEmpty())) {
				oriWorkTicket.setPlannedStartTime(DateFormatUtil.parseDate(csvRecord.get("PLANNED_START_TIME")));
			}
			if (!(csvRecord.get("PLANNED_END_TIME").trim().isEmpty())) {
				oriWorkTicket.setPlannedEndTime(DateFormatUtil.parseDate(csvRecord.get("PLANNED_END_TIME")));
			}
			oriWorkTicket.setPermitWorkChargePersonName(csvRecord.get("PERMIT_WORK_CHARGE_PERSON_NAME"));
			oriWorkTicket.setLicenserName(csvRecord.get("LICENSER_NAME"));
			if (!(csvRecord.get("PERMITTED_WORKING_HOURS").trim().isEmpty())) {
				oriWorkTicket
						.setPermittedWorkingHours(DateFormatUtil.parseDate(csvRecord.get("PERMITTED_WORKING_HOURS")));
			}
			if (!(csvRecord.get("DELAY_TIME").trim().isEmpty())) {
				oriWorkTicket.setDelayTime(DateFormatUtil.parseDate(csvRecord.get("DELAY_TIME")));
			}
			if (!(csvRecord.get("END_TIME").trim().isEmpty())) {
				oriWorkTicket.setEndTime(DateFormatUtil.parseDate(csvRecord.get("END_TIME")));
			}
			oriWorkTicket.setTerminationPermitterName(csvRecord.get("TERMINATION_PERMITTER_NAME"));
			oriWorkTicket.setTerminationChargePersonName(csvRecord.get("TERMINATION_CHARGE_PERSON_NAME"));
			oriWorkTicket.setTerminationNonExecutReason(csvRecord.get("TERMINATION_NON_EXECUT_REASON"));
			oriWorkTicket.setInvalidNonExecutPersonName(csvRecord.get("INVALID_NON_EXECUT_PERSON_NAME"));
			if (!(csvRecord.get("INVALID_OR_UNEXECUTED_TIME").trim().isEmpty())) {
				oriWorkTicket.setInvalidOrUnexecutedTime(
						DateFormatUtil.parseDate(csvRecord.get("INVALID_OR_UNEXECUTED_TIME")));
			}
			oriWorkTicket.setTeamName(csvRecord.get("TEAM_NAME"));
			oriWorkTicket.setWorkOrgName(csvRecord.get("WORK_ORG_NAME"));
			if (csvRecord.get("TEAM_MEMBER_QUANTITY").trim().isEmpty()) {
				oriWorkTicket.setTeamMemberQuantity(new Double(0.0));
			} else {
				oriWorkTicket.setTeamMemberQuantity(
						new DecimalFormat().parse(csvRecord.get("TEAM_MEMBER_QUANTITY")).doubleValue());
			}
			if (!(csvRecord.get("ISSUANCE_TIME").trim().isEmpty())) {
				oriWorkTicket.setIssuanceTime(DateFormatUtil.parseDate(csvRecord.get("ISSUANCE_TIME")));
			}
			if (!(csvRecord.get("LICENSE_END_TIME").trim().isEmpty())) {
				oriWorkTicket.setLicenseEndTime(DateFormatUtil.parseDate(csvRecord.get("LICENSE_END_TIME")));
			}
			oriWorkTicket.setNameOfReceiver(csvRecord.get("NAME_OF_RECEIVER"));
			if (!(csvRecord.get("PICK_UP_TIME").trim().isEmpty())) {
				oriWorkTicket.setPickUpTime(DateFormatUtil.parseDate(csvRecord.get("PICK_UP_TIME")));
			}
			oriWorkTicket.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			oriWorkTicket.setDrawerName(csvRecord.get("DRAWER_NAME"));
			if (!(csvRecord.get("BILLING_TIME").trim().isEmpty())) {
				oriWorkTicket.setBillingTime(DateFormatUtil.parseDate(csvRecord.get("BILLING_TIME")));
			}
			oriWorkTicket.setReturnedPersonName(csvRecord.get("RETURNED_PERSON_NAME"));
			oriWorkTicket.setReturnReason(csvRecord.get("RETURN_REASON"));
			if (!(csvRecord.get("RETURN_TIME").trim().isEmpty())) {
				oriWorkTicket.setReturnTime(DateFormatUtil.parseDate(csvRecord.get("RETURN_TIME")));
			}
			if (csvRecord.get("PRINTING_TIMES").trim().isEmpty()) {
				oriWorkTicket.setPrintingTimes(new Double(0.0));
			} else {
				oriWorkTicket
						.setPrintingTimes(new DecimalFormat().parse(csvRecord.get("PRINTING_TIMES")).doubleValue());
			}
			oriWorkTicket.setPrinterName(csvRecord.get("PRINTER_NAME"));
			oriWorkTicket.setPrintReason(csvRecord.get("PRINT_REASON"));

			if (!(csvRecord.get("PRINTING_TIME").trim().isEmpty())) {

				oriWorkTicket.setPrintingTime(DateFormatUtil.parseDate(csvRecord.get("PRINTING_TIME")));

			}
			oriWorkTicket.setBelongedCityName(csvRecord.get("BELONGED_CITY_NAME"));
			if (!(csvRecord.get("SECOND_ISSUE_TIME").trim().isEmpty())) {
				oriWorkTicket.setSecondIssueTime(DateFormatUtil.parseDate(csvRecord.get("SECOND_ISSUE_TIME")));

			}
			oriWorkTicket.setMajorClassification(csvRecord.get("MAJOR_CLASSIFICATION"));
			if (!(csvRecord.get("ARCHIVE_TIME").trim().isEmpty())) {
				oriWorkTicket.setArchiveTime(DateFormatUtil.parseDate(csvRecord.get("ARCHIVE_TIME")));

			}
			oriWorkTicket.setMajorType(csvRecord.get("MAJOR_TYPE"));
			oriWorkTicket.setNameOfMaintenanceTeam(csvRecord.get("NAME_OF_MAINTENANCE_TEAM"));
			if (!(csvRecord.get("CHANGE_TIME").trim().isEmpty())) {
				oriWorkTicket.setChangeTime(DateFormatUtil.parseDate(csvRecord.get("CHANGE_TIME")));
			}
			try {
				oriWorkTicket.setDataFile(csvRecord.get("FILE_NAME"));
			} catch (Exception e) {
				// TODO: handle exception
				oriWorkTicket.setDataFile(pathStr);
			}
			session.save(oriWorkTicket);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();

	}

	public static void oriWorkTaskInvoiceAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriWorkTaskInvoice oriWorkTaskInvoice = new OriWorkTaskInvoice();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");
			oriWorkTaskInvoice.setDataVersion(versionValue);

			oriWorkTaskInvoice.setCalYear(DateFormatUtil.parseDate(calYear));
			oriWorkTaskInvoice.setDataVersion(versionValue);
			oriWorkTaskInvoice.setObjId(csvRecord.get("OBJ_ID"));
			oriWorkTaskInvoice.setTaskInvoiceName(csvRecord.get("TASK_INVOICE_NAME"));
			if (!(csvRecord.get("PREPARATION_DATE").trim().isEmpty())) {
				oriWorkTaskInvoice.setPreparationDate(DateFormatUtil.parseDate(csvRecord.get("PREPARATION_DATE")));
			}

			oriWorkTaskInvoice.setPowerStationLine(csvRecord.get("POWER_STATION_LINE"));
			if (!(csvRecord.get("PLANNED_START_TIME").trim().isEmpty())) {
				oriWorkTaskInvoice.setPlannedStartTime(DateFormatUtil.parseDate(csvRecord.get("PLANNED_START_TIME")));
			}
			if (!(csvRecord.get("PLANNED_END_TIME").trim().isEmpty())) {
				oriWorkTaskInvoice.setPlannedEndTime(DateFormatUtil.parseDate(csvRecord.get("PLANNED_END_TIME")));
			}
			oriWorkTaskInvoice.setIsPowerFailure(csvRecord.get("IS_POWER_FAILURE"));
			oriWorkTaskInvoice.setApprovedOutageStartTime(csvRecord.get("APPROVED_OUTAGE_START_TIME"));
			oriWorkTaskInvoice.setApprovedOutageEndTime(csvRecord.get("APPROVED_OUTAGE_END_TIME"));
			oriWorkTaskInvoice.setPowerCutScope(csvRecord.get("POWER_CUT_SCOPE"));
			oriWorkTaskInvoice.setTaskArrangerName(csvRecord.get("TASK_ARRANGER_NAME"));
			oriWorkTaskInvoice.setCompletionPhase(csvRecord.get("COMPLETION_PHASE"));
			oriWorkTaskInvoice.setMajor(csvRecord.get("MAJOR"));
			oriWorkTaskInvoice.setBelongedCityName(csvRecord.get("BELONGED_CITY_NAME"));
			oriWorkTaskInvoice.setPreparationDepartmentName(csvRecord.get("PREPARATION_DEPARTMENT_NAME"));
			oriWorkTaskInvoice.setStationLineType(csvRecord.get("STATION_LINE_TYPE"));
			oriWorkTaskInvoice.setWhetherAllocateOtherOrg(csvRecord.get("WHETHER_ALLOCATE_OTHER_ORG"));
			oriWorkTaskInvoice.setResponsibleOrg(csvRecord.get("RESPONSIBLE_ORG"));
			try {
				oriWorkTaskInvoice.setDataFile(csvRecord.get("FILE_NAME"));
			} catch (Exception e) {
				// TODO: handle exception
				oriWorkTaskInvoice.setDataFile(pathStr);
			}
			session.save(oriWorkTaskInvoice);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();

	}

	public static void csvOriEquipmentBreakdownAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriEquipmentBreakdown oriEquipmentBreakdown = new OriEquipmentBreakdown();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");
			oriEquipmentBreakdown.setDataVersion(versionValue);

			if (calYear.length() <= 10) {
				oriEquipmentBreakdown.setCalYear(DateFormatUtil.parseDate(calYear));
			} else {
				oriEquipmentBreakdown.setCalYear(DateFormatUtil.parseDate(calYear));
			}
			oriEquipmentBreakdown.setCalYear(DateFormatUtil.parseDate(calYear));
			oriEquipmentBreakdown.setOrgName(csvRecord.get("ORG_NAME"));
			oriEquipmentBreakdown.setMaintainanceOrgName(csvRecord.get("MAINTAINANCE_ORG_NAME"));
			oriEquipmentBreakdown.setTransformerSubstation(csvRecord.get("TRANSFORMER_SUBSTATION"));
			oriEquipmentBreakdown.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			oriEquipmentBreakdown.setFaultyLine(csvRecord.get("FAULTY_LINE"));
			oriEquipmentBreakdown.setFaultEquipment(csvRecord.get("FAULT_EQUIPMENT"));
			if (!(csvRecord.get("TIME_OF_FAILURE").trim().isEmpty())) {
				oriEquipmentBreakdown.setTimeOfFailure(DateFormatUtil.parseDate(csvRecord.get("TIME_OF_FAILURE")));
			}
			oriEquipmentBreakdown.setTreatmentProcess(csvRecord.get("TREATMENT_PROCESS"));
			oriEquipmentBreakdown.setTechnicalReasons(csvRecord.get("TECHNICAL_REASONS"));
			oriEquipmentBreakdown.setDutyReason(csvRecord.get("DUTY_REASON"));
			if (csvRecord.get("RECORDING_RANGE_FINDING").trim().isEmpty()) {
				oriEquipmentBreakdown.setRecordingRangeFinding(new Double(0.0));
			} else {
				oriEquipmentBreakdown.setRecordingRangeFinding(
						new DecimalFormat().parse(csvRecord.get("RECORDING_RANGE_FINDING")).doubleValue());
			}
			if (csvRecord.get("FAULT_CURRENT_KA").trim().isEmpty()) {
				oriEquipmentBreakdown.setFaultCurrentKa(new Double(0.0));
			} else {
				oriEquipmentBreakdown
						.setFaultCurrentKa(new DecimalFormat().parse(csvRecord.get("FAULT_CURRENT_KA")).doubleValue());
			}
			oriEquipmentBreakdown.setIsFaultOverstepped(csvRecord.get("IS_FAULT_OVERSTEPPED"));
			oriEquipmentBreakdown.setFailureOutageScope(csvRecord.get("FAILURE_OUTAGE_SCOPE"));
			oriEquipmentBreakdown.setFailureSatuiation(csvRecord.get("FAILURE_SATUIATION"));
			oriEquipmentBreakdown.setIsInStationFault(csvRecord.get("IS_IN_STATION_FAULT"));
			oriEquipmentBreakdown.setFaultType(csvRecord.get("FAULT_TYPE"));
			oriEquipmentBreakdown.setWeatherInFailurePeriod(csvRecord.get("WEATHER_IN_FAILURE_PERIOD"));
			oriEquipmentBreakdown.setFaultClassification(csvRecord.get("FAULT_CLASSIFICATION"));
			oriEquipmentBreakdown.setIsLocked(csvRecord.get("IS_LOCKED"));
			oriEquipmentBreakdown.setExtremelyBlockedAction(csvRecord.get("EXTREMELY_BLOCKED_ACTION"));
			oriEquipmentBreakdown.setReclosureOperation(csvRecord.get("RECLOSURE_OPERATION"));
			oriEquipmentBreakdown.setFaultPhase(csvRecord.get("FAULT_PHASE"));
			oriEquipmentBreakdown.setIsOutage(csvRecord.get("IS_OUTAGE"));
			oriEquipmentBreakdown.setIsTripping(csvRecord.get("IS_TRIPPING"));
			oriEquipmentBreakdown.setSimpleFault(csvRecord.get("SIMPLE_FAULT"));
			/*
			 * if (csvRecord.get("PARTICULAR_YEAR").trim().isEmpty()) {
			 * oriEquipmentBreakdown.setParticularYear(new Long(0)); } else {
			 * oriEquipmentBreakdown .setParticularYear(new
			 * DecimalFormat().parse(csvRecord.get("PARTICULAR_YEAR")).longValue()); }
			 * oriEquipmentBreakdown.setDutyReasonLargeClass(csvRecord.get(
			 * "DUTY_REASON_LARGE_CLASS"));
			 * oriEquipmentBreakdown.setDutyReasonMediumClass(csvRecord.get(
			 * "DUTY_REASON_MEDIUM_CLASS"));
			 * oriEquipmentBreakdown.setMajor(csvRecord.get("MAJOR"));
			 */
			try {
				oriEquipmentBreakdown.setDataSourceFile(csvRecord.get("FILE_NAME"));
			} catch (Exception e) {
				// TODO: handle exception
				oriEquipmentBreakdown.setDataSourceFile(pathStr);
			}
			session.save(oriEquipmentBreakdown);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();

	}

	public static void csvOriTechTransformProjectAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriTechTransformProject oriTechTransformProject = new OriTechTransformProject();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy-MM-dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			if (calYear.length() <= 10) {
				oriTechTransformProject.setCalYear(DateFormatUtil.parseDate(calYear));
			} else {
				oriTechTransformProject.setCalYear(DateFormatUtil.parseDate(calYear));

			}
			// pmsItemBackup.setVersion(csvRecord.get("VERSION"));
			oriTechTransformProject.setDataVersion(versionValue);

			if (csvRecord.get("RECORD_NUM").trim().isEmpty()) {
				oriTechTransformProject.setRecordNum(new Integer(0));
			} else {
				oriTechTransformProject.setRecordNum(new DecimalFormat().parse(csvRecord.get("RECORD_NUM")).intValue());
			}
			oriTechTransformProject.setObjId(csvRecord.get("OBJ_ID"));
			oriTechTransformProject.setProjectId(csvRecord.get("PROJECT_ID"));
			oriTechTransformProject.setOrgName(csvRecord.get("ORG_NAME"));
			oriTechTransformProject.setProjectName(csvRecord.get("PROJECT_NAME"));
			if (csvRecord.get("PLANNING_YEAR").trim().isEmpty()) {
				oriTechTransformProject.setPlanningYear(new Integer(0));
			} else {
				oriTechTransformProject
						.setPlanningYear(new DecimalFormat().parse(csvRecord.get("PLANNING_YEAR")).intValue());
			}
			oriTechTransformProject.setProjectType(csvRecord.get("PROJECT_TYPE"));
			oriTechTransformProject.setMajorCategory(csvRecord.get("MAJOR_CATEGORY"));
			oriTechTransformProject.setMajorDetailCategory(csvRecord.get("MAJOR_DETAIL_CATEGORY"));
			oriTechTransformProject.setProjectContent(csvRecord.get("PROJECT_CONTENT"));
			oriTechTransformProject.setPurposeOfTransformation(csvRecord.get("PURPOSE_OF_TRANSFORMATION"));
			oriTechTransformProject.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			oriTechTransformProject.setImageProgress(csvRecord.get("IMAGE_PROGRESS"));
			if (csvRecord.get("CURRENT_YEAR_ACCOUNTING_MONEY").trim().isEmpty()) {
				oriTechTransformProject.setCurrentYearAccountingMoney(new Double(0.0));
			} else {
				oriTechTransformProject.setCurrentYearAccountingMoney(
						new DecimalFormat().parse(csvRecord.get("CURRENT_YEAR_ACCOUNTING_MONEY")).doubleValue());
			}
			if (csvRecord.get("CURRENT_YEAR_FUNDS").trim().isEmpty()) {
				oriTechTransformProject.setCurrentYearFunds(new Double(0.0));
			} else {
				oriTechTransformProject.setCurrentYearFunds(
						new DecimalFormat().parse(csvRecord.get("CURRENT_YEAR_FUNDS")).doubleValue());
			}
			if (csvRecord.get("TOTAL_INVESTMENT").trim().isEmpty()) {
				oriTechTransformProject.setTotalInvestment(new Double(0.0));
			} else {
				oriTechTransformProject
						.setTotalInvestment(new DecimalFormat().parse(csvRecord.get("TOTAL_INVESTMENT")).doubleValue());
			}
			if (!(csvRecord.get("XMKSSJ").trim().isEmpty())) {
				oriTechTransformProject.setXmkssj(DateFormatUtil.parseDate(csvRecord.get("XMKSSJ")));
			}
			if (!(csvRecord.get("XMWCSJ").trim().isEmpty())) {
				oriTechTransformProject.setXmwcsj(DateFormatUtil.parseDate(csvRecord.get("XMWCSJ")));
			}
			oriTechTransformProject.setIsItRuralNetwork(csvRecord.get("IS_IT_RURAL_NETWORK"));
			oriTechTransformProject.setProjectApprovalBasis(csvRecord.get("PROJECT_APPROVAL_BASIS"));
			oriTechTransformProject.setTransformationReason(csvRecord.get("TRANSFORMATION_REASON"));
			oriTechTransformProject.setFeasibilityStudyRevieDocNo(csvRecord.get("FEASIBILITY_STUDY_REVIE_DOC_NO"));
			oriTechTransformProject.setFeasibilityStudyApproDocNo(csvRecord.get("FEASIBILITY_STUDY_APPRO_DOC_NO"));
			oriTechTransformProject.setNatureOfTheProject(csvRecord.get("NATURE_OF_THE_PROJECT"));
			oriTechTransformProject.setEquipmentCategory(csvRecord.get("EQUIPMENT_CATEGORY"));
			oriTechTransformProject.setUnit(csvRecord.get("UNIT"));
			if (csvRecord.get("ASSET_QUANTITY").trim().isEmpty()) {
				oriTechTransformProject.setAssetQuantity(new Double(0.0));
			} else {
				oriTechTransformProject
						.setAssetQuantity(new DecimalFormat().parse(csvRecord.get("ASSET_QUANTITY")).doubleValue());
			}
			oriTechTransformProject.setGovernanceDirection(csvRecord.get("GOVERNANCE_DIRECTION"));
			oriTechTransformProject.setGovernanceSubCategory(csvRecord.get("GOVERNANCE_SUB_CATEGORY"));
			oriTechTransformProject.setReviewer(csvRecord.get("REVIEWER"));
			oriTechTransformProject.setFireFightingOrNot(csvRecord.get("FIRE_FIGHTING_OR_NOT"));
			oriTechTransformProject.setAdjustBatch(csvRecord.get("ADJUST_BATCH"));
			oriTechTransformProject.setAdjustCategory(csvRecord.get("ADJUST_CATEGORY"));

			try {
				oriTechTransformProject.setFileName(csvRecord.get("FILE_NAME"));
			} catch (Exception e) {
				// TODO: handle exception
				oriTechTransformProject.setFileName(pathStr);
			}
			session.save(oriTechTransformProject);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();

	}

	public static void csvOriOverhaulProjectAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriOverhaulProject oriOverhaulProject = new OriOverhaulProject();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy-MM-dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			if (calYear.length() <= 10) {
				oriOverhaulProject.setCalYear(DateFormatUtil.parseDate(calYear));
			} else {
				oriOverhaulProject.setCalYear(DateFormatUtil.parseDate(calYear));
			}
			oriOverhaulProject.setDataVersion(versionValue);

			if (csvRecord.get("RECORD_NUM").trim().isEmpty()) {
				oriOverhaulProject.setRecordNum(new Integer(0));
			} else {
				oriOverhaulProject.setRecordNum(new DecimalFormat().parse(csvRecord.get("RECORD_NUM")).intValue());
			}
			oriOverhaulProject.setObjId(csvRecord.get("OBJ_ID"));
			oriOverhaulProject.setProjectId(csvRecord.get("PROJECT_ID"));
			oriOverhaulProject.setOrgName(csvRecord.get("ORG_NAME"));
			oriOverhaulProject.setProjectName(csvRecord.get("PROJECT_NAME"));
			if (csvRecord.get("PLANNING_YEAR").trim().isEmpty()) {
				oriOverhaulProject.setPlanningYear(new Integer(0));
			} else {
				oriOverhaulProject
						.setPlanningYear(new DecimalFormat().parse(csvRecord.get("PLANNING_YEAR")).intValue());
			}
			oriOverhaulProject.setProjectType(csvRecord.get("PROJECT_TYPE"));
			oriOverhaulProject.setMajorCategory(csvRecord.get("MAJOR_CATEGORY"));
			oriOverhaulProject.setMajorDetailCategory(csvRecord.get("MAJOR_DETAIL_CATEGORY"));
			oriOverhaulProject.setProjectContent(csvRecord.get("PROJECT_CONTENT"));
			oriOverhaulProject.setPurposeOfTransformation(csvRecord.get("PURPOSE_OF_TRANSFORMATION"));
			oriOverhaulProject.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			/*
			 * oriOverhaulProject.setImageProgress(csvRecord.get("IMAGE_PROGRESS")); if
			 * (csvRecord.get("CURRENT_YEAR_ACCOUNTING_MONEY").trim().isEmpty()) {
			 * oriOverhaulProject.setCurrentYearAccountingMoney(new Double(0.0)); } else {
			 * oriOverhaulProject.setCurrentYearAccountingMoney( new
			 * DecimalFormat().parse(csvRecord.get("CURRENT_YEAR_ACCOUNTING_MONEY")).
			 * doubleValue()); } if (csvRecord.get("CURRENT_YEAR_FUNDS").trim().isEmpty()) {
			 * oriOverhaulProject.setCurrentYearFunds(new Double(0.0)); } else {
			 * oriOverhaulProject.setCurrentYearFunds( new
			 * DecimalFormat().parse(csvRecord.get("CURRENT_YEAR_FUNDS")).doubleValue()); }
			 * if (csvRecord.get("TOTAL_INVESTMENT").trim().isEmpty()) {
			 * oriOverhaulProject.setTotalInvestment(new Double(0.0)); } else {
			 * oriOverhaulProject .setTotalInvestment(new
			 * DecimalFormat().parse(csvRecord.get("TOTAL_INVESTMENT")).doubleValue()); }
			 */
			if (!(csvRecord.get("XMKSSJ").trim().isEmpty())) {
				oriOverhaulProject.setXmkssj(DateFormatUtil.parseDate(csvRecord.get("XMKSSJ")));
			}
			if (!(csvRecord.get("XMWCSJ").trim().isEmpty())) {
				oriOverhaulProject.setXmwcsj(DateFormatUtil.parseDate(csvRecord.get("XMWCSJ")));
			}
			oriOverhaulProject.setIsItRuralNetwork(csvRecord.get("IS_IT_RURAL_NETWORK"));
			oriOverhaulProject.setProjectApprovalBasis(csvRecord.get("PROJECT_APPROVAL_BASIS"));
			oriOverhaulProject.setTransformationReason(csvRecord.get("TRANSFORMATION_REASON"));
			oriOverhaulProject.setFeasibilityStudyRevieDocNo(csvRecord.get("FEASIBILITY_STUDY_REVIE_DOC_NO"));
			oriOverhaulProject.setFeasibilityStudyApproDocNo(csvRecord.get("FEASIBILITY_STUDY_APPRO_DOC_NO"));
			oriOverhaulProject.setNatureOfTheProject(csvRecord.get("NATURE_OF_THE_PROJECT"));
			oriOverhaulProject.setEquipmentCategory(csvRecord.get("EQUIPMENT_CATEGORY"));
			oriOverhaulProject.setUnit(csvRecord.get("UNIT"));
			if (csvRecord.get("ASSET_QUANTITY").trim().isEmpty()) {
				oriOverhaulProject.setAssetQuantity(new Double(0.0));
			} else {
				oriOverhaulProject
						.setAssetQuantity(new DecimalFormat().parse(csvRecord.get("ASSET_QUANTITY")).doubleValue());
			}
			oriOverhaulProject.setGovernanceDirection(csvRecord.get("GOVERNANCE_DIRECTION"));
			oriOverhaulProject.setGovernanceSubCategory(csvRecord.get("GOVERNANCE_SUB_CATEGORY"));
			oriOverhaulProject.setReviewer(csvRecord.get("REVIEWER"));
			// oriOverhaulProject.setFireFightingOrNot(csvRecord.get("FIRE_FIGHTING_OR_NOT"));
			oriOverhaulProject.setAdjustBatch(csvRecord.get("ADJUST_BATCH"));
			oriOverhaulProject.setAdjustCategory(csvRecord.get("ADJUST_CATEGORY"));
			oriOverhaulProject.setCalYear(DateFormatUtil.parseDate(calYear));
			try {
				oriOverhaulProject.setFileName(csvRecord.get("FILE_NAME"));
			} catch (Exception e) {
				// TODO: handle exception
				oriOverhaulProject.setFileName(pathStr);
			}
			session.save(oriOverhaulProject);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();

	}

	public static void csvPmsItemBackupAdd(String pathStr, String versionValue, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemBackup pmsItemBackup = new PmsItemBackup();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy-MM-dd");
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy/MM/dd");

			// pmsItemBackup.setPmsItemBackupId(csvRecord.get("PMS_ITEM_BACKUP_ID"));
			if (!(calYear.isEmpty())) {
				pmsItemBackup.setCalYear(DateFormatUtil.parseDate(calYear));
			}
			// pmsItemBackup.setVersion(csvRecord.get("VERSION"));
			pmsItemBackup.setVersion(versionValue);
			pmsItemBackup.setBackupItemSource(csvRecord.get("BACKUP_ITEM_SOURCE"));
			pmsItemBackup.setEquipmentType(csvRecord.get("EQUIPMENT_TYPE"));
			pmsItemBackup.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			pmsItemBackup.setManufacturer(csvRecord.get("MANUFACTURER"));
			pmsItemBackup.setEquipmentModel(csvRecord.get("EQUIPMENT_MODEL"));
			pmsItemBackup.setReporsitoryAddress(csvRecord.get("REPORSITORY_ADDRESS"));
			try {
				pmsItemBackup.setEquipmentCustodian(csvRecord.get("EQUIPMENT_CUSTODIAN"));
			} catch (Exception e) {
				// TODO: handle exception
				pmsItemBackup.setEquipmentCustodian("");
			}
			pmsItemBackup.setEquipmentEvaluationResult(csvRecord.get("EQUIPMENT_EVALUATION_RESULT"));
			pmsItemBackup.setAssetProperty(csvRecord.get("ASSET_PROPERTY"));
			pmsItemBackup.setOrgName(csvRecord.get("ORG_NAME"));
			pmsItemBackup.setAssetNumber(csvRecord.get("ASSET_NUMBER"));
			pmsItemBackup.setEquipmentNumber(csvRecord.get("EQUIPMENT_NUMBER"));
			/*
			 * if (!(csvRecord.get("STORAGE_DATE").trim().isEmpty())) { if
			 * (csvRecord.get("STORAGE_DATE").length() <= 10) { try {
			 * pmsItemBackup.setStorageDate(simpleDateFormat3.parse(csvRecord.get(
			 * "STORAGE_DATE"))); } catch (ParseException e) { try {
			 * pmsItemBackup.setStorageDate(simpleDateFormat4.parse(csvRecord.get(
			 * "STORAGE_DATE"))); } catch (ParseException e1) { // TODO Auto-generated catch
			 * block e1.printStackTrace(); } } } else { try {
			 * pmsItemBackup.setStorageDate(simpleDateFormat.parse(csvRecord.get(
			 * "STORAGE_DATE"))); } catch (ParseException e) { try {
			 * pmsItemBackup.setStorageDate(simpleDateFormat2.parse(csvRecord.get(
			 * "STORAGE_DATE"))); } catch (ParseException e1) { // TODO Auto-generated catch
			 * block e1.printStackTrace(); } } } }
			 */
			if (!(csvRecord.get("STORAGE_DATE").trim().isEmpty())) {
				pmsItemBackup.setStorageDate(DateFormatUtil.parseDate(csvRecord.get("STORAGE_DATE")));
			}
			pmsItemBackup.setBackupEquipmentStatus(csvRecord.get("BACKUP_EQUIPMENT_STATUS"));
			pmsItemBackup.setProjectName(csvRecord.get("PROJECT_NAME"));
			try {
				if (csvRecord.get("ORIGINAL_VALUE").trim().isEmpty()) {
					pmsItemBackup.setOriginalValue(new Double(0.0));
				} else {
					pmsItemBackup.setOriginalValue(Double.parseDouble(csvRecord.get("ORIGINAL_VALUE")));
				}
			} catch (Exception e) {
				// TODO: handle exception
				pmsItemBackup.setOriginalValue(new Double(0.0));
			}
			try {
				if (csvRecord.get("NET_VALUE").trim().isEmpty()) {
					pmsItemBackup.setNetValue(new Double(0.0));
				} else {
					pmsItemBackup.setNetValue(Double.parseDouble(csvRecord.get("NET_VALUE")));
				}
			} catch (Exception e) {
				// TODO: handle exception
				pmsItemBackup.setNetValue(new Double(0.0));
			}
			// pmsItemBackup.setUnit(csvRecord.get("UNIT"));
			pmsItemBackup.setMaintenanceOrgId(csvRecord.get("MAINTENANCE_ORG_ID"));
			pmsItemBackup.setSubordinateMunicipality(csvRecord.get("SUBORDINATE_MUNICIPALITY"));
			pmsItemBackup.setSubordinateMaintenanceOrg(csvRecord.get("SUBORDINATE_MAINTENANCE_ORG"));
			pmsItemBackup.setModifierName(csvRecord.get("MODIFIER_NAME"));
			pmsItemBackup.setProjectId(csvRecord.get("PROJECT_ID"));
			try {
				pmsItemBackup.setDataSourceFile(csvRecord.get("DATA_SOURCE_FILE"));
			} catch (Exception e) {
				// TODO: handle exception
				pmsItemBackup.setDataSourceFile(pathStr);
			}
			session.save(pmsItemBackup);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();

	}

	public static void csvOriOpticalCableTerminal(String pathStr, String versionValue) throws IOException {

		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriOpticalCableTermianl oriOpticalCableTermianl = new OriOpticalCableTermianl();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			// pmsItemAutomatic.setpmsItemAutomaticId(csvRecord.get("PMS_ITEM_SHU_LINE_ID"));
			oriOpticalCableTermianl.setDataVersion(versionValue);

			oriOpticalCableTermianl.setGlobalName(csvRecord.get("GLOBAL_NAME"));
			oriOpticalCableTermianl.setName(csvRecord.get("NAME"));
			oriOpticalCableTermianl.setAbbreviation(csvRecord.get("ABBREVIATION"));
			oriOpticalCableTermianl.setSubordinateComputerRoom(csvRecord.get("SUBORDINATE_COMPUTER_ROOM"));
			oriOpticalCableTermianl.setErpAssetCoding(csvRecord.get("ERP_ASSET_CODING"));
			oriOpticalCableTermianl.setErpEquipmentAccountCoding(csvRecord.get("ERP_EQUIPMENT_ACCOUNT_CODING"));
			oriOpticalCableTermianl.setSubordinateSite(csvRecord.get("SUBORDINATE_SITE"));
			oriOpticalCableTermianl.setSubordinateSystem(csvRecord.get("SUBORDINATE_SYSTEM"));
			oriOpticalCableTermianl.setManufacturer(csvRecord.get("MANUFACTURER"));
			oriOpticalCableTermianl.setManufacturerEquipmentType(csvRecord.get("MANUFACTURER_EQUIPMENT_TYPE"));

			oriOpticalCableTermianl.setCommissioningDate(DateFormatUtil.parseDate(csvRecord.get("COMMISSIONING_DATE")));

			oriOpticalCableTermianl.setWorkingState(csvRecord.get("WORKING_STATE"));
			oriOpticalCableTermianl.setJurisdictionRightOrg(csvRecord.get("JURISDICTION_RIGHT_ORG"));
			oriOpticalCableTermianl.setDataMaintenanceOrg(csvRecord.get("DATA_MAINTENANCE_ORG"));
			oriOpticalCableTermianl.setPropertyRightsOrg(csvRecord.get("PROPERTY_RIGHTS_ORG"));
			oriOpticalCableTermianl.setStatisticalOrg(csvRecord.get("STATISTICAL_ORG"));
			oriOpticalCableTermianl.setDefender(csvRecord.get("DEFENDER"));
			oriOpticalCableTermianl.setWarningSurveillanceOrg(csvRecord.get("WARNING_SURVEILLANCE_ORG"));
			oriOpticalCableTermianl.setTechnicalSystem(csvRecord.get("TECHNICAL_SYSTEM"));
			oriOpticalCableTermianl.setEquipmentType(csvRecord.get("EQUIPMENT_TYPE"));
			oriOpticalCableTermianl.setMaximumCapacity(csvRecord.get("MAXIMUM_CAPACITY"));
			oriOpticalCableTermianl.setActualConfigurationMaxRate(csvRecord.get("ACTUAL_CONFIGURATION_MAX_RATE"));
			oriOpticalCableTermianl.setTransportNetworkElementType(csvRecord.get("TRANSPORT_NETWORK_ELEMENT_TYPE"));
			oriOpticalCableTermianl.setDataSourceFile(pathStr);

			session.save(oriOpticalCableTermianl);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriOpticalCableSectionAdd(String pathStr, String versionValue)
			throws IOException, ParseException {

		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));

		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM月-yy");
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriOpticalCableSection oriOpticalCableSection = new OriOpticalCableSection();
			oriOpticalCableSection.setDataVersion(versionValue);
			oriOpticalCableSection.setObjId(csvRecord.get("OBJ_ID"));
			oriOpticalCableSection.setOpticalCableSectionName(csvRecord.get("OPTICAL_CABLE_SECTION_NAME"));
			try {
				oriOpticalCableSection.setSubordinateOpticalCable(csvRecord.get("SUBORDINATE_OPTICAL_CABLE"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			/*
			 * try { oriOpticalCableSection.setOpticalCableStatus(csvRecord.get(
			 * "OPTICAL_CABLE_STATUS")); } catch (Exception e) { // TODO: handle exception }
			 */
			if (csvRecord.get("TOTAL_CORES_NUMBER").trim().isEmpty()) {
				oriOpticalCableSection.setTotalCoresNumber(new Double(0.0));
			} else {
				//
				// oriOpticalCableSection.setTotalCoresNumber(Double.parseDouble(csvRecord.get("TOTAL_CORES_NUMBER")));
				oriOpticalCableSection.setTotalCoresNumber(
						new DecimalFormat().parse(csvRecord.get("TOTAL_CORES_NUMBER")).doubleValue());
			}
			if (csvRecord.get("USED_CORES_NUMBER").trim().isEmpty()) {
				oriOpticalCableSection.setUsedCoresNumber(new Double(0.0));
			} else {
				oriOpticalCableSection.setUsedCoresNumber(
						new DecimalFormat().parse(csvRecord.get("USED_CORES_NUMBER")).doubleValue());
			}
			if (csvRecord.get("AVAILABLE_CORE_NUMBER").trim().isEmpty()) {
				oriOpticalCableSection.setAvailableCoreNumber(new Double(0.0));
			} else {
				oriOpticalCableSection.setAvailableCoreNumber(
						new DecimalFormat().parse(csvRecord.get("AVAILABLE_CORE_NUMBER")).doubleValue());
			}
			if (csvRecord.get("OPTICAL_CABLE_LENGTH_KM").trim().isEmpty()) {
				oriOpticalCableSection.setOpticalCableLengthKm(new Double(0.0));
			} else {
				oriOpticalCableSection.setOpticalCableLengthKm(
						new DecimalFormat().parse(csvRecord.get("OPTICAL_CABLE_LENGTH_KM")).doubleValue());
			}

			oriOpticalCableSection.setCommissioningDate(DateFormatUtil.parseDate(csvRecord.get("COMMISSIONING_DATE")));

			/*
			 * if (!(csvRecord.get("COMMISSIONING_DATE").trim().isEmpty())) { try {
			 * oriOpticalCableSection
			 * .setCommissioningDate(simpleDateFormat.parse(csvRecord.get(
			 * "COMMISSIONING_DATE"))); } catch (ParseException e) { try {
			 * oriOpticalCableSection
			 * .setCommissioningDate(simpleDateFormat2.parse(csvRecord.get(
			 * "COMMISSIONING_DATE"))); } catch (ParseException e2) {
			 * 
			 * try { oriOpticalCableSection
			 * .setCommissioningDate(simpleDateFormat3.parse(csvRecord.get(
			 * "COMMISSIONING_DATE"))); } catch (ParseException e3) { e3.printStackTrace();
			 * } } } }
			 */
			//
			oriOpticalCableSection.setBelongAreas(csvRecord.get("BELONG_AREAS"));
			oriOpticalCableSection.setOpticalCableType(csvRecord.get("OPTICAL_CABLE_TYPE"));
			oriOpticalCableSection.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));

			// oriOpticalCableSection.setPmsVoltageLevel(csvRecord.get("PMS_VOLTAGE_LEVEL"));

			oriOpticalCableSection.setPrimaryLineName(csvRecord.get("PRIMARY_LINE_NAME"));

			//
			oriOpticalCableSection.setPmsPrimaryLineName(csvRecord.get("PMS_PRIMARY_LINE_NAME"));

			// oriOpticalCableSection.setLayingType(csvRecord.get("LAYING_TYPE"));
			// oriOpticalCableSection.setLayingMethod(csvRecord.get("LAYING_METHOD"));

			// oriOpticalCableSection.setThreeSpanSituation(
			// csvRecord.get("THREE_SPAN_SITUATION"));

			// oriOpticalCableSection.setOpticalCableStartPointType(
			// csvRecord.get("OPTICAL_CABLE_START_POINT_TYPE"));
			oriOpticalCableSection.setOptCabSectStartPointType(csvRecord.get("OPT_CAB_SECT_START_POINT_TYPE"));
			oriOpticalCableSection.setOptCabSectStartPointResou(csvRecord.get("OPT_CAB_SECT_START_POINT_RESOU"));
			// oriOpticalCableSection.setOpticalCableEndpointType(csvRecord.get("OPTICAL_CABLE_ENDPOINT_TYPE"));
			oriOpticalCableSection.setOptCableSectEndpointType(csvRecord.get("OPT_CABLE_SECT_ENDPOINT_TYPE"));
			oriOpticalCableSection.setOptCableEndpointResources(csvRecord.get("OPT_CABLE_ENDPOINT_RESOURCES"));
			// oriOpticalCableSection.setOptCableSectEndpointResou(csvRecord.get("OPT_CABLE_SECT_ENDPOINT_RESOU"));
			oriOpticalCableSection.setRightJurisdictionUnderOrg(csvRecord.get("RIGHT_JURISDICTION_UNDER_ORG"));
//			oriOpticalCableSection.setMaintenanceOrg(csvRecord.get("MAINTENANCE_ORG"));
			oriOpticalCableSection.setStatisticalOrg(csvRecord.get("STATISTICAL_ORG"));

			oriOpticalCableSection.setPropertyRightsOrg(csvRecord.get("PROPERTY_RIGHTS_ORG"));
			oriOpticalCableSection.setGlobalName(csvRecord.get("GLOBAL_NAME"));
			//
			oriOpticalCableSection.setAbbreviation(csvRecord.get("ABBREVIATION"));
			// oriOpticalCableSection.setModel(csvRecord.get("MODEL"));
			oriOpticalCableSection.setDefender(csvRecord.get("DEFENDER"));
			// oriOpticalCableSection.setContactNumber(csvRecord.get("CONTACT_NUMBER"));
			oriOpticalCableSection.setWhetIntraStationOptiCable(csvRecord.get("WHET_INTRA_STATION_OPTI_CABLE"));
			oriOpticalCableSection.setManufacturer(csvRecord.get("MANUFACTURER"));
			oriOpticalCableSection.setDataMaintenanceOrg(csvRecord.get("DATA_MAINTENANCE_ORG"));
			oriOpticalCableSection.setDataSourceFile(pathStr);

			session.save(oriOpticalCableSection);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}

		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriOverAgeAssetAdd(String pathStr, String dataVersion, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriOverAgeAsset oriOverAgeAsset = new OriOverAgeAsset();
			String dateStr = calYear + "/01/01";
			oriOverAgeAsset.setDataVersion(dataVersion);
			oriOverAgeAsset.setCalYear(DateFormatUtil.parseDate(dateStr));

			oriOverAgeAsset.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			oriOverAgeAsset.setAssetNumber(csvRecord.get("ASSET_NUMBER"));
			oriOverAgeAsset.setProfitCenter(csvRecord.get("PROFIT_CENTER"));
			oriOverAgeAsset.setAssetClassificationCode(csvRecord.get("ASSET_CLASSIFICATION_CODE"));
			oriOverAgeAsset.setFixeAssetClassificationCode(csvRecord.get("FIXE_ASSET_CLASSIFICATION_CODE"));
			oriOverAgeAsset.setProfitCenterDescription(csvRecord.get("PROFIT_CENTER_DESCRIPTION"));
			oriOverAgeAsset.setAssetName(csvRecord.get("ASSET_NAME"));
			oriOverAgeAsset.setAssetClassAlias(csvRecord.get("ASSET_CLASS_ALIAS"));
			oriOverAgeAsset.setCostCenter(csvRecord.get("COST_CENTER"));
			oriOverAgeAsset.setCostCenterName(csvRecord.get("COST_CENTER_NAME"));
			oriOverAgeAsset.setLargeAssetClassCode(csvRecord.get("LARGE_ASSET_CLASS_CODE"));
			oriOverAgeAsset.setMediumAssetClassCode(csvRecord.get("MEDIUM_ASSET_CLASS_CODE"));
			oriOverAgeAsset.setSmallAssetClassCode(csvRecord.get("SMALL_ASSET_CLASS_CODE"));
			if (csvRecord.get("ACCUMULATED_PURCHASE_VALUE").trim().isEmpty()) {
				oriOverAgeAsset.setAccumulatedPurchaseValue(new Double(0.0));
			} else {
				try {
					oriOverAgeAsset.setAccumulatedPurchaseValue(
							new DecimalFormat().parse(csvRecord.get("ACCUMULATED_PURCHASE_VALUE")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (csvRecord.get("ACCUMUL_UNPLANNED_DEPRECIATION").trim().isEmpty()) {
				oriOverAgeAsset.setAccumulUnplannedDepreciation(new Double(0.0));
			} else {
				try {
					oriOverAgeAsset.setAccumulUnplannedDepreciation(
							new DecimalFormat().parse(csvRecord.get("ACCUMUL_UNPLANNED_DEPRECIATION")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (csvRecord.get("ACCUMUL_ORDINARY_DEPRECIATION").trim().isEmpty()) {
				oriOverAgeAsset.setAccumulOrdinaryDepreciation(new Double(0.0));
			} else {
				oriOverAgeAsset.setAccumulOrdinaryDepreciation(
						new DecimalFormat().parse(csvRecord.get("ACCUMUL_ORDINARY_DEPRECIATION")).doubleValue());
			}
			if (csvRecord.get("ASSET_NET_VALUE").trim().isEmpty()) {
				oriOverAgeAsset.setAssetNetValue(new Double(0.0));
			} else {
				oriOverAgeAsset
						.setAssetNetValue(new DecimalFormat().parse(csvRecord.get("ASSET_NET_VALUE")).doubleValue());
			}
			if (csvRecord.get("ASSET_RESIDUAL_VALUE").trim().isEmpty()) {
				oriOverAgeAsset.setAssetResidualValue(new Double(0.0));
			} else {
				oriOverAgeAsset.setAssetResidualValue(
						new DecimalFormat().parse(csvRecord.get("ASSET_RESIDUAL_VALUE")).doubleValue());
			}
			if (!(csvRecord.get("CAPITALIZATION_DATE").trim().isEmpty())) {
				oriOverAgeAsset.setCapitalizationDate(DateFormatUtil.parseDate(csvRecord.get("CAPITALIZATION_DATE")));
			}
			oriOverAgeAsset.setExpectedServiceLife(csvRecord.get("EXPECTED_SERVICE_LIFE"));
			if (!(csvRecord.get("OVER_AGE_DATE").trim().isEmpty())) {
				oriOverAgeAsset.setOverAgeDate(DateFormatUtil.parseDate(csvRecord.get("OVER_AGE_DATE")));
			}
			oriOverAgeAsset.setDepreciationCode(csvRecord.get("DEPRECIATION_CODE"));
			oriOverAgeAsset.setDataSourceFile(pathStr);

			oriOverAgeAsset.setDataSourceFile(pathStr);
			session.save(oriOverAgeAsset);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriDiscardApplicationRecordAdd(String pathStr, String dataVersion, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriDiscardApplicationRecord oriDiscardApplicationRecord = new OriDiscardApplicationRecord();

			oriDiscardApplicationRecord.setDataVersion(dataVersion);
			oriDiscardApplicationRecord.setCalYear(DateFormatUtil.parseDate(calYear));
			oriDiscardApplicationRecord.setDataSourceFile(pathStr);
			oriDiscardApplicationRecord.setApplicationNumber(csvRecord.get("APPLICATION_NUMBER"));
			oriDiscardApplicationRecord.setCreator(csvRecord.get("CREATOR"));

			oriDiscardApplicationRecord.setSerialNumber(csvRecord.get("SERIAL_NUMBER"));
			oriDiscardApplicationRecord.setApprovedPerson(csvRecord.get("APPROVED_PERSON"));
			oriDiscardApplicationRecord.setApprovalLevel(csvRecord.get("APPROVAL_LEVEL"));
			oriDiscardApplicationRecord.setApprovalStatus(csvRecord.get("APPROVAL_STATUS"));
			oriDiscardApplicationRecord.setCreationDate(csvRecord.get("CREATION_DATE"));

			oriDiscardApplicationRecord.setDateOfSubmission(csvRecord.get("DATE_OF_SUBMISSION"));
			oriDiscardApplicationRecord.setEndDate(csvRecord.get("END_DATE"));
			oriDiscardApplicationRecord.setDocumentNumber(csvRecord.get("DOCUMENT_NUMBER"));
			oriDiscardApplicationRecord.setEquipmentNumber1(csvRecord.get("EQUIPMENT_NUMBER1"));
			oriDiscardApplicationRecord.setTechnicalObjectDescription1(csvRecord.get("TECHNICAL_OBJECT_DESCRIPTION1"));
			oriDiscardApplicationRecord.setEquipment(csvRecord.get("EQUIPMENT"));
			oriDiscardApplicationRecord.setTechnicalObjectDescription2(csvRecord.get("TECHNICAL_OBJECT_DESCRIPTION2"));
			oriDiscardApplicationRecord.setImportComponentEquipStatus(csvRecord.get("IMPORT_COMPONENT_EQUIP_STATUS"));

			oriDiscardApplicationRecord.setImportantEquipReferenceVal(csvRecord.get("IMPORTANT_EQUIP_REFERENCE_VAL"));
			oriDiscardApplicationRecord.setEquipmentNumber(csvRecord.get("EQUIPMENT_NUMBER"));
			oriDiscardApplicationRecord.setTechnicalObjectDescription(csvRecord.get("TECHNICAL_OBJECT_DESCRIPTION"));
			oriDiscardApplicationRecord.setMasterDeviceStatus(csvRecord.get("MASTER_DEVICE_STATUS"));
			oriDiscardApplicationRecord.setMainEquipmentReferenceValue(csvRecord.get("MAIN_EQUIPMENT_REFERENCE_VALUE"));
			oriDiscardApplicationRecord.setAssetClassification(csvRecord.get("ASSET_CLASSIFICATION"));
			oriDiscardApplicationRecord.setAssetClassAlias(csvRecord.get("ASSET_CLASS_ALIAS"));
			oriDiscardApplicationRecord.setAssetNumber(csvRecord.get("ASSET_NUMBER"));
			oriDiscardApplicationRecord.setAssetDescription(csvRecord.get("ASSET_DESCRIPTION"));
			oriDiscardApplicationRecord.setScrappingReason(csvRecord.get("SCRAPPING_REASON"));
			oriDiscardApplicationRecord.setResiduValAssetRenewaScheme(csvRecord.get("RESIDU_VAL_ASSET_RENEWA_SCHEME"));
			oriDiscardApplicationRecord.setAssetRetirementScale(csvRecord.get("ASSET_RETIREMENT_SCALE"));
			oriDiscardApplicationRecord.setChangeStatus(csvRecord.get("CHANGE_STATUS"));
			oriDiscardApplicationRecord.setAssetValueDate(csvRecord.get("ASSET_VALUE_DATE"));
			oriDiscardApplicationRecord.setBookkeepingDate(csvRecord.get("BOOKKEEPING_DATE"));
			oriDiscardApplicationRecord.setInvolvingPurchaseYear(csvRecord.get("INVOLVING_PURCHASE_YEAR"));
			oriDiscardApplicationRecord.setOriginalBookValue(csvRecord.get("ORIGINAL_BOOK_VALUE"));
			oriDiscardApplicationRecord.setAccumulatedDepreciation(csvRecord.get("ACCUMULATED_DEPRECIATION"));

			oriDiscardApplicationRecord.setProvisionForImpairment(csvRecord.get("PROVISION_FOR_IMPAIRMENT"));
			oriDiscardApplicationRecord.setNetBookValue(csvRecord.get("NET_BOOK_VALUE"));

			oriDiscardApplicationRecord.setScrapRatio(csvRecord.get("SCRAP_RATIO"));
			oriDiscardApplicationRecord.setScrapOriginalValueAmount(csvRecord.get("SCRAP_ORIGINAL_VALUE_AMOUNT"));

			oriDiscardApplicationRecord.setScrapDepreciation(csvRecord.get("SCRAP_DEPRECIATION"));

			oriDiscardApplicationRecord.setPreparationForRetention(csvRecord.get("PREPARATION_FOR_RETENTION"));
			oriDiscardApplicationRecord.setEstimatedResidualValue(csvRecord.get("ESTIMATED_RESIDUAL_VALUE"));
			oriDiscardApplicationRecord.setSaleRevenue(csvRecord.get("SALE_REVENUE"));
			oriDiscardApplicationRecord.setInsuranceLiabilityIndemnity(csvRecord.get("INSURANCE_LIABILITY_INDEMNITY"));

			oriDiscardApplicationRecord.setText(csvRecord.get("TEXT"));
			oriDiscardApplicationRecord.setAssignment1(csvRecord.get("ASSIGNMENT1"));
			oriDiscardApplicationRecord.setAssignment(csvRecord.get("ASSIGNMENT"));
			oriDiscardApplicationRecord.setCostCenter(csvRecord.get("COST_CENTER"));
			oriDiscardApplicationRecord.setCostCenterShortText(csvRecord.get("COST_CENTER_SHORT_TEXT"));

			oriDiscardApplicationRecord.setQuantity(csvRecord.get("QUANTITY"));

			oriDiscardApplicationRecord.setMeasurementBasicUnit(csvRecord.get("MEASUREMENT_BASIC_UNIT"));
			oriDiscardApplicationRecord.setMeasureUnitText(csvRecord.get("MEASURE_UNIT_TEXT"));
			oriDiscardApplicationRecord.setAssetManufacturer(csvRecord.get("ASSET_MANUFACTURER"));

			oriDiscardApplicationRecord.setCapitalizationDate(csvRecord.get("CAPITALIZATION_DATE"));

			oriDiscardApplicationRecord.setExpectedServiceLife(csvRecord.get("EXPECTED_SERVICE_LIFE"));

			oriDiscardApplicationRecord.setScheduledMonth(csvRecord.get("SCHEDULED_MONTH"));

			oriDiscardApplicationRecord.setCheckmark(csvRecord.get("CHECKMARK"));
			oriDiscardApplicationRecord.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			oriDiscardApplicationRecord.setCorporateName(csvRecord.get("CORPORATE_NAME"));
			oriDiscardApplicationRecord.setProfitCenter(csvRecord.get("PROFIT_CENTER"));
			oriDiscardApplicationRecord.setLongText(csvRecord.get("LONG_TEXT"));
			oriDiscardApplicationRecord.setAbstract_(csvRecord.get("ABSTRACT"));
			oriDiscardApplicationRecord.setUserChineseName(csvRecord.get("USER_CHINESE_NAME"));
			oriDiscardApplicationRecord.setTechnicalDataNameNumber(csvRecord.get("TECHNICAL_DATA_NAME_NUMBER"));
			oriDiscardApplicationRecord.setResiValTreOpiAsseReneSch(csvRecord.get("RESI_VAL_TRE_OPI_ASSE_RENE_SCH"));
			oriDiscardApplicationRecord.setProvinCompApprovRequired(csvRecord.get("PROVIN_COMP_APPROV_REQUIRED"));
			oriDiscardApplicationRecord.setSuccessMark(csvRecord.get("SUCCESS_MARK"));
			oriDiscardApplicationRecord.setApprovNodeSelected91Step(csvRecord.get("APPROV_NODE_SELECTED_91_STEP"));
			oriDiscardApplicationRecord.setIsItVehicleProcess(csvRecord.get("IS_IT_VEHICLE_PROCESS"));
			oriDiscardApplicationRecord.setBusinessTypeVehicle(csvRecord.get("BUSINESS_TYPE_VEHICLE"));
			oriDiscardApplicationRecord.setVehicleType(csvRecord.get("VEHICLE_TYPE"));
			oriDiscardApplicationRecord.setVehicleApplicationLevel(csvRecord.get("VEHICLE_APPLICATION_LEVEL"));
			oriDiscardApplicationRecord.setPhysicalId(csvRecord.get("PHYSICAL_ID"));
			oriDiscardApplicationRecord.setBusinessType(csvRecord.get("BUSINESS_TYPE"));
			oriDiscardApplicationRecord.setProvincCompanyApprovalType(csvRecord.get("PROVINC_COMPANY_APPROVAL_TYPE"));
			oriDiscardApplicationRecord.setDemolitionListNo(csvRecord.get("DEMOLITION_LIST_NO"));
			oriDiscardApplicationRecord.setDemolitionListLineNumber(csvRecord.get("DEMOLITION_LIST_LINE_NUMBER"));

			session.save(oriDiscardApplicationRecord);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriFinancePostRecordAnepAdd(String pathStr, String dataVersion, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriFinancePostRecordAnep oriFinancePostRecordAnep = new OriFinancePostRecordAnep();
			String dateStr = calYear + "/01/01";
			oriFinancePostRecordAnep.setDataVersion(dataVersion);
			oriFinancePostRecordAnep.setCalYear(DateFormatUtil.parseDate(dateStr));
			oriFinancePostRecordAnep.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			oriFinancePostRecordAnep.setAssetNumber(csvRecord.get("ASSET_NUMBER"));
			oriFinancePostRecordAnep.setSubnumber(csvRecord.get("SUBNUMBER"));
			oriFinancePostRecordAnep.setFiscalYear(csvRecord.get("FISCAL_YEAR"));
			oriFinancePostRecordAnep.setTransactionType(csvRecord.get("TRANSACTION_TYPE"));
			if (csvRecord.get("ACCOUNT_AMOUNT").trim().isEmpty()) {
				oriFinancePostRecordAnep.setAccountAmount(new Double(0.0));
			} else {
				try {
					oriFinancePostRecordAnep
							.setAccountAmount(new DecimalFormat().parse(csvRecord.get("ACCOUNT_AMOUNT")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (!(csvRecord.get("ASSET_VALUE_DATE").trim().isEmpty())) {
				oriFinancePostRecordAnep.setAssetValueDate(DateFormatUtil.parseDate(csvRecord.get("ASSET_VALUE_DATE")));
			}
			oriFinancePostRecordAnep.setDataSourceFile(pathStr);
			session.save(oriFinancePostRecordAnep);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriLowVolStationLineEquipAdd(String pathStr, String dataVersion, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriLowVolStationLineEquip oriLowVolStationLineEquip = new OriLowVolStationLineEquip();
			String dateStr = calYear + "/01/01";
			oriLowVolStationLineEquip.setDataVersion(dataVersion);
			try {
				oriLowVolStationLineEquip.setCalYear(simpleDateFormat.parse(dateStr));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			oriLowVolStationLineEquip.setSubordinateOrgCode(csvRecord.get("SSDS"));
			oriLowVolStationLineEquip.setOrgName(csvRecord.get("SSDSMC"));
			oriLowVolStationLineEquip.setAssetClassName(csvRecord.get("ASSET_CLASS"));
			oriLowVolStationLineEquip.setAssetIncreasedMode(csvRecord.get("ASSET_SOURCE"));
			/*
			 * oriLowVolStationLineEquip.setSubordinateOrgCode(csvRecord.get(
			 * "SUBORDINATE_ORG_CODE"));
			 * oriLowVolStationLineEquip.setOrgName(csvRecord.get("ORG_NAME"));
			 * oriLowVolStationLineEquip.setAssetClassName(csvRecord.get("ASSET_CLASS_NAME")
			 * ); oriLowVolStationLineEquip.setAssetIncreasedMode(csvRecord.get(
			 * "ASSET_INCREASED_MODE"));
			 */

			if (csvRecord.get("WORKING_AGE").trim().isEmpty()) {
				oriLowVolStationLineEquip.setWorkingAge(new Double(0.0));
			} else {
				oriLowVolStationLineEquip.setWorkingAge(new Double(csvRecord.get("WORKING_AGE")));
			}
			if (csvRecord.get("QUANTITY").trim().isEmpty()) {
				oriLowVolStationLineEquip.setQuantity(new Double(0.0));
			} else {
				oriLowVolStationLineEquip.setQuantity(new Double(csvRecord.get("QUANTITY")));
			}
			if (csvRecord.get("LENGTH_CAPACITY").trim().isEmpty()) {
				oriLowVolStationLineEquip.setLengthCapacity(new Double(0.0));
			} else {
				oriLowVolStationLineEquip.setLengthCapacity(new Double(csvRecord.get("LENGTH_CAPACITY")));
			}
			oriLowVolStationLineEquip.setDataSourceFile(pathStr);
			session.save(oriLowVolStationLineEquip);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvPmsQuexianAdd(String pathStr, String versionValue, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		// System.out.println("PmsQuexian Record quantity of csv file is :" +
		// csvRecordCount(iterator));
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsQuexian pmsQuexian = new PmsQuexian();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			// pmsItemAutomatic.setpmsItemAutomaticId(csvRecord.get("PMS_ITEM_SHU_LINE_ID"));
			/*
			 * if (csvRecord.get("CAL_YEAR").trim().isEmpty()) {
			 * pmsItemAutomatic.setCalYear(new Short("0")); } else {
			 * pmsItemAutomatic.setCalYear(new Short(csvRecord.get("CAL_YEAR"))); }
			 */

			pmsQuexian.setCalYear(new Short(calYear));
			pmsQuexian.setVersion(versionValue);
			pmsQuexian.setDataSourceFile(pathStr);

			pmsQuexian.setSbbm(csvRecord.get("设备编码"));
			pmsQuexian.setDwmx(csvRecord.get("公司"));
			pmsQuexian.setQxbh(csvRecord.get("缺陷编号"));
			pmsQuexian.setZclxbm(csvRecord.get("设备类型编码"));
			pmsQuexian.setSblx(csvRecord.get("设备类型"));
			if (csvRecord.get("投运年份").trim().isEmpty()) {
				pmsQuexian.setTynf(new Short((short) 0));
			} else {
				pmsQuexian.setTynf(new Short(csvRecord.get("投运年份")));
			}
			pmsQuexian.setDydj(csvRecord.get("电压等级"));
			pmsQuexian.setZzsmc(csvRecord.get("生产厂家"));
			pmsQuexian.setSbxlmc(csvRecord.get("设备/线路名称"));
			pmsQuexian.setQxms(csvRecord.get("缺陷描述"));
			pmsQuexian.setQxbw(csvRecord.get("缺陷部位"));
			pmsQuexian.setQxzryy(csvRecord.get("缺陷责任原因"));
			pmsQuexian.setSfxq(csvRecord.get("是否消缺"));
			pmsQuexian.setSfjs(csvRecord.get("是否及时"));
			pmsQuexian.setZryybm(csvRecord.get("责任原因编码"));
			pmsQuexian.setQxjsyy(csvRecord.get("缺陷技术原因"));
			pmsQuexian.setJsyybm(csvRecord.get("技术原因编码"));
			pmsQuexian.setQxdj(csvRecord.get("缺陷等级"));
			if (!csvRecord.get("发生日期").trim().isEmpty()) {
				/*
				 * try { pmsQuexian.setFsrq(simpleDateFormat.parse(csvRecord.get("发生日期"))); }
				 * catch (ParseException e) { e.printStackTrace(); }
				 */
				pmsQuexian.setFsrq(DateFormatUtil.parseDate(csvRecord.get("发生日期")));
			}
			if (!csvRecord.get("消缺日期").trim().isEmpty()) {
				/*
				 * try { pmsQuexian.setXqrq(simpleDateFormat.parse(csvRecord.get("消缺日期"))); }
				 * catch (ParseException e) { e.printStackTrace(); }
				 */

				pmsQuexian.setXqrq(DateFormatUtil.parseDate(csvRecord.get("消缺日期")));
			}
			pmsQuexian.setBz(csvRecord.get("备注"));
			if (csvRecord.get("消缺时间（天）").trim().isEmpty()) {
				pmsQuexian.setXqsj(new Double(0.0));
			} else {
				pmsQuexian.setXqsj(Double.parseDouble(csvRecord.get("消缺时间（天）")));
			}
			pmsQuexian.setJsyy(csvRecord.get("技术原因"));
			pmsQuexian.setZryy(csvRecord.get("责任原因"));
			pmsQuexian.setCwbm(csvRecord.get("资产细类编码"));
			// pmsQuexian.setQfzd(csvRecord.get("区分字段"));
			/*
			 * if (!csvRecord.get("出厂日期").trim().isEmpty()) {
			 * pmsQuexian.setCcrq(DateFormatUtil.parseDate(csvRecord.get("出厂日期"))); }
			 */
			// pmsQuexian.setQfzd(csvRecord.get("QFZD"));
			// if (!csvRecord.get("CCRQ").trim().isEmpty()) {
			// try {
			// pmsQuexian.setCcrq(simpleDateFormat.parse(csvRecord.get("CCRQ")));
			// } catch (ParseException e) {
			// e.printStackTrace();
			// }
			// }
			pmsQuexian.setZcxlms(csvRecord.get("资产细类描述"));
			// pmsQuexian.setQxnr(csvRecord.get("缺陷内容"));
			// pmsQuexian.setQxnr(csvRecord.get("QXNR"));
			// pmsQuexian.setZclxbm2(csvRecord.get("ZCLXBM2"));
			// pmsQuexian.setEquipementName(csvRecord.get("EQUIPEMENT_NAME"));
			// pmsQuexian.setLineStationName(csvRecord.get("LINE_STATION_NAME"));
			session.save(pmsQuexian);

			/*
			 * pmsQuexian.setSbbm(csvRecord.get("SBBM"));
			 * pmsQuexian.setDwmx(csvRecord.get("DWMX"));
			 * pmsQuexian.setQxbh(csvRecord.get("QXBH"));
			 * pmsQuexian.setZclxbm(csvRecord.get("ZCLXBM"));
			 * pmsQuexian.setSblx(csvRecord.get("SBLX")); if
			 * (csvRecord.get("TYNF").trim().isEmpty()) { pmsQuexian.setTynf(new
			 * Short((short) 0)); } else { pmsQuexian.setTynf(new
			 * Short(csvRecord.get("TYNF"))); } pmsQuexian.setDydj(csvRecord.get("DYDJ"));
			 * pmsQuexian.setZzsmc(csvRecord.get("ZZSMC"));
			 * pmsQuexian.setSbxlmc(csvRecord.get("SBXLMC"));
			 * pmsQuexian.setQxms(csvRecord.get("QXMS"));
			 * pmsQuexian.setQxbw(csvRecord.get("QXBW"));
			 * pmsQuexian.setQxzryy(csvRecord.get("QXZRYY"));
			 * pmsQuexian.setSfxq(csvRecord.get("SFXQ"));
			 * pmsQuexian.setSfjs(csvRecord.get("SFJS"));
			 * pmsQuexian.setZryybm(csvRecord.get("ZRYYBM"));
			 * pmsQuexian.setQxjsyy(csvRecord.get("QXJSYY"));
			 * pmsQuexian.setJsyybm(csvRecord.get("JSYYBM"));
			 * pmsQuexian.setQxdj(csvRecord.get("QXDJ")); if
			 * (!csvRecord.get("FSRQ").trim().isEmpty()) { try {
			 * pmsQuexian.setFsrq(simpleDateFormat.parse(csvRecord.get("FSRQ"))); } catch
			 * (ParseException e) { e.printStackTrace(); } } if
			 * (!csvRecord.get("XQRQ").trim().isEmpty()) { try {
			 * pmsQuexian.setXqrq(simpleDateFormat.parse(csvRecord.get("XQRQ"))); } catch
			 * (ParseException e) { e.printStackTrace(); } }
			 * pmsQuexian.setBz(csvRecord.get("BZ")); if
			 * (csvRecord.get("XQSJ").trim().isEmpty()) { pmsQuexian.setXqsj(new
			 * Double(0.0)); } else {
			 * pmsQuexian.setXqsj(Double.parseDouble(csvRecord.get("XQSJ"))); }
			 * pmsQuexian.setJsyy(csvRecord.get("JSYY"));
			 * pmsQuexian.setZryy(csvRecord.get("ZRYY"));
			 * pmsQuexian.setCwbm(csvRecord.get("CWBM")); //
			 * pmsQuexian.setQfzd(csvRecord.get("QFZD")); // if
			 * (!csvRecord.get("CCRQ").trim().isEmpty()) { // try { //
			 * pmsQuexian.setCcrq(simpleDateFormat.parse(csvRecord.get("CCRQ"))); // } catch
			 * (ParseException e) { // e.printStackTrace(); // } // }
			 * pmsQuexian.setZcxlms(csvRecord.get("ZCXLMS")); //
			 * pmsQuexian.setQxnr(csvRecord.get("QXNR")); //
			 * pmsQuexian.setZclxbm2(csvRecord.get("ZCLXBM2")); //
			 * pmsQuexian.setEquipementName(csvRecord.get("EQUIPEMENT_NAME")); //
			 * pmsQuexian.setLineStationName(csvRecord.get("LINE_STATION_NAME"));
			 * pmsQuexian.setDataSourceFile(pathStr); session.save(pmsQuexian);
			 */

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriDistributionNetworkFaultAdd(String pathStr, String dataVersion, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriDistributionNetworkFault oriDistributionNetworkFault = new OriDistributionNetworkFault();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			// oriDistributionNetworkFault.setCalYear(simpleDateFormat.parse("2019-07-22"));
			oriDistributionNetworkFault.setCalYear(DateFormatUtil.parseDate(calYear));
			// oriDistributionNetworkFault.setDataVersion("O_2018_1");
			oriDistributionNetworkFault.setDataVersion(dataVersion);
			oriDistributionNetworkFault.setDataSourceFile(pathStr);
			oriDistributionNetworkFault.setAuditType(csvRecord.get("AUDIT_TYPE"));
			oriDistributionNetworkFault.setOrgCode(csvRecord.get("ORG_CODE"));
			oriDistributionNetworkFault.setOrgName(csvRecord.get("ORG_NAME"));
			oriDistributionNetworkFault.setIncidentId(csvRecord.get("INCIDENT_ID"));
			oriDistributionNetworkFault.setResponsibleDepartCode(csvRecord.get("RESPONSIBLE_DEPART_CODE"));
			oriDistributionNetworkFault.setResponsibleDepartment(csvRecord.get("RESPONSIBLE_DEPARTMENT"));
			oriDistributionNetworkFault.setProvinceName(csvRecord.get("PROVINCE_NAME"));

			if (!(csvRecord.get("START_TIME").trim().isEmpty())) {
				try {
					oriDistributionNetworkFault.setStartTime(simpleDateFormat.parse(csvRecord.get("START_TIME")));
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}
			if (!(csvRecord.get("END_TIME").trim().isEmpty())) {
				try {
					oriDistributionNetworkFault.setEndTime(simpleDateFormat.parse(csvRecord.get("END_TIME")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (csvRecord.get("LAST_TIME").trim().isEmpty()) {
				oriDistributionNetworkFault.setLastTime(new Double(0.0));
			} else {
				oriDistributionNetworkFault.setLastTime(Double.parseDouble(csvRecord.get("LAST_TIME")));
			}
			if (csvRecord.get("CIRCUIT_LINE_TIMES").trim().isEmpty()) {
				oriDistributionNetworkFault.setCircuitLineTimes(new Double(0.0));
			} else {
				oriDistributionNetworkFault
						.setCircuitLineTimes(Double.parseDouble(csvRecord.get("CIRCUIT_LINE_TIMES")));
			}
			if (csvRecord.get("USER_TIMES").trim().isEmpty()) {
				oriDistributionNetworkFault.setUserTimes(new Double(0.0));
			} else {
				oriDistributionNetworkFault.setUserTimes(Double.parseDouble(csvRecord.get("USER_TIMES")));
			}
			if (csvRecord.get("TIME_MULTIP_USER_QUANTITY").trim().isEmpty()) {
				oriDistributionNetworkFault.setTimeMultipUserQuantity(new Double(0.0));
			} else {
				oriDistributionNetworkFault
						.setTimeMultipUserQuantity(Double.parseDouble(csvRecord.get("TIME_MULTIP_USER_QUANTITY")));
			}
			if (csvRecord.get("LACK_POWER_SUPPLY_QUANTITY").trim().isEmpty()) {
				oriDistributionNetworkFault.setLackPowerSupplyQuantity(new Double(0.0));
			} else {
				oriDistributionNetworkFault
						.setLackPowerSupplyQuantity(Double.parseDouble(csvRecord.get("LACK_POWER_SUPPLY_QUANTITY")));
			}
			oriDistributionNetworkFault.setPowerCutProperty(csvRecord.get("POWER_CUT_PROPERTY"));
			oriDistributionNetworkFault.setIgnoreReason(csvRecord.get("IGNORE_REASON"));
			oriDistributionNetworkFault.setPowerCutEquipmentId(csvRecord.get("POWER_CUT_EQUIPMENT_ID"));
			oriDistributionNetworkFault.setPowerCutEquipmentName(csvRecord.get("POWER_CUT_EQUIPMENT_NAME"));
			oriDistributionNetworkFault.setTechniqueReasonCode(csvRecord.get("TECHNIQUE_REASON_CODE"));
			oriDistributionNetworkFault.setTechniqueReasonName(csvRecord.get("TECHNIQUE_REASON_NAME"));
			oriDistributionNetworkFault.setDutyReasonCode(csvRecord.get("DUTY_REASON_CODE"));
			oriDistributionNetworkFault.setDutyReasonName(csvRecord.get("DUTY_REASON_NAME"));
			oriDistributionNetworkFault.setSpecialAnalysis(csvRecord.get("SPECIAL_ANALYSIS"));
			oriDistributionNetworkFault.setPowerCutPropertyCode(csvRecord.get("POWER_CUT_PROPERTY_CODE"));
			oriDistributionNetworkFault.setResume(csvRecord.get("RESUME"));
			if (!(csvRecord.get("INCREASE_REGISTE_DATE").trim().isEmpty())) {
				try {
					oriDistributionNetworkFault
							.setIncreaseRegisteDate(simpleDateFormat.parse(csvRecord.get("INCREASE_REGISTE_DATE")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (!(csvRecord.get("USER_MODIFIED_DATE").trim().isEmpty())) {
				try {
					oriDistributionNetworkFault
							.setUserModifiedDate(simpleDateFormat.parse(csvRecord.get("USER_MODIFIED_DATE")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (!(csvRecord.get("SYSTEM_MANIPULATE_DATE").trim().isEmpty())) {
				try {
					oriDistributionNetworkFault
							.setSystemManipulateDate(simpleDateFormat.parse(csvRecord.get("SYSTEM_MANIPULATE_DATE")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (!(csvRecord.get("CONFORM_IGNORE_APPLY_DATE").trim().isEmpty())) {
				try {
					oriDistributionNetworkFault.setConformIgnoreApplyDate(
							simpleDateFormat.parse(csvRecord.get("CONFORM_IGNORE_APPLY_DATE")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (!(csvRecord.get("POWER_OUTAGE_REVISION_TIME").trim().isEmpty())) {
				try {
					oriDistributionNetworkFault.setPowerOutageRevisionTime(
							simpleDateFormat.parse(csvRecord.get("POWER_OUTAGE_REVISION_TIME")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (!(csvRecord.get("NATIONAL_GRID_AUDIT_TIME").trim().isEmpty())) {
				try {
					oriDistributionNetworkFault.setNationalGridAuditTime(
							simpleDateFormat.parse(csvRecord.get("NATIONAL_GRID_AUDIT_TIME")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			oriDistributionNetworkFault.setNationalGridAuditor(csvRecord.get("NATIONAL_GRID_AUDITOR"));
			if (!(csvRecord.get("NATI_GRID_PROVINCE_AUDIT_TIME").trim().isEmpty())) {
				try {
					oriDistributionNetworkFault.setNatiGridProvinceAuditTime(
							simpleDateFormat.parse(csvRecord.get("NATI_GRID_PROVINCE_AUDIT_TIME")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			oriDistributionNetworkFault.setNatiGridProvinceAuditor(csvRecord.get("NATI_GRID_PROVINCE_AUDITOR"));
			if (!(csvRecord.get("NATI_GRID_MUNICIPAL_AUDIT_TIME").trim().isEmpty())) {
				try {
					oriDistributionNetworkFault.setNatiGridMunicipalAuditTime(
							simpleDateFormat.parse(csvRecord.get("NATI_GRID_MUNICIPAL_AUDIT_TIME")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			oriDistributionNetworkFault.setNatiGridMunicipalAuditor(csvRecord.get("NATI_GRID_MUNICIPAL_AUDITOR"));
			oriDistributionNetworkFault.setOperator(csvRecord.get("OPERATOR"));
			oriDistributionNetworkFault.setRecordObjId(csvRecord.get("RECORD_OBJ_ID"));
			oriDistributionNetworkFault.setManagementProperty(csvRecord.get("MANAGEMENT_PROPERTY"));
			oriDistributionNetworkFault.setAbnormalState(csvRecord.get("ABNORMAL_STATE"));
			if (!(csvRecord.get("ABNORMAL_UPDATE_TIME").trim().isEmpty())) {
				try {
					oriDistributionNetworkFault
							.setAbnormalUpdateTime(simpleDateFormat.parse(csvRecord.get("ABNORMAL_UPDATE_TIME")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			oriDistributionNetworkFault.setAbnormalDataReasonCode(csvRecord.get("ABNORMAL_DATA_REASON_CODE"));
			oriDistributionNetworkFault.setAbnormalDataMarkerOrgCode(csvRecord.get("ABNORMAL_DATA_MARKER_ORG_CODE"));
			oriDistributionNetworkFault.setMarkAuditOrgCode(csvRecord.get("MARK_AUDIT_ORG_CODE"));
			if (!(csvRecord.get("MARK_AUDIT_TIME").trim().isEmpty())) {
				try {
					oriDistributionNetworkFault
							.setMarkAuditTime(simpleDateFormat.parse(csvRecord.get("MARK_AUDIT_TIME")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			oriDistributionNetworkFault.setIsMajorEventDay(csvRecord.get("IS_MAJOR_EVENT_DAY"));
			oriDistributionNetworkFault.setObjId(csvRecord.get("OBJ_ID"));
			oriDistributionNetworkFault.setObjDispidx(csvRecord.get("OBJ_DISPIDX"));
			oriDistributionNetworkFault.setDataSourceFile(pathStr);

			session.save(oriDistributionNetworkFault);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriPowerSupplyDutyReasonAdd(String pathStr, String dataVersion, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriPowerSupplyDutyReason oriPowerSupplyDutyReason = new OriPowerSupplyDutyReason();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// oriPowerSupplyDutyReason.setCalYear(simpleDateFormat.parse("2019-07-22"));
			oriPowerSupplyDutyReason.setCalYear(DateFormatUtil.parseDate(calYear));
			oriPowerSupplyDutyReason.setDataVersion(dataVersion);
			// oriPowerSupplyDutyReason.setDataVersion("O_2018_1");

			if (!(csvRecord.get("START_TIME").trim().isEmpty())) {
				try {
					oriPowerSupplyDutyReason.setStartTime(simpleDateFormat.parse(csvRecord.get("START_TIME")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (!(csvRecord.get("END_TIME").trim().isEmpty())) {
				try {
					oriPowerSupplyDutyReason.setEndTime(simpleDateFormat.parse(csvRecord.get("END_TIME")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			oriPowerSupplyDutyReason.setStatisticClassification(csvRecord.get("STATISTIC_CLASSIFICATION"));
			oriPowerSupplyDutyReason.setStatisticExplain(csvRecord.get("STATISTIC_EXPLAIN"));
			oriPowerSupplyDutyReason.setOrgCode(csvRecord.get("ORG_CODE"));
			oriPowerSupplyDutyReason.setStatisticOrgName(csvRecord.get("STATISTIC_ORG_NAME"));
			oriPowerSupplyDutyReason.setPlanningFeature(csvRecord.get("PLANNING_FEATURE"));
			oriPowerSupplyDutyReason.setOrgPropertyCode(csvRecord.get("ORG_PROPERTY_CODE"));
			oriPowerSupplyDutyReason.setOrgProperty(csvRecord.get("ORG_PROPERTY"));
			oriPowerSupplyDutyReason.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			oriPowerSupplyDutyReason.setPowerCutNature(csvRecord.get("POWER_CUT_NATURE"));
			oriPowerSupplyDutyReason.setCircuitProperty(csvRecord.get("CIRCUIT_PROPERTY"));
			oriPowerSupplyDutyReason.setSpecialAnalysisCode(csvRecord.get("SPECIAL_ANALYSIS_CODE"));
			oriPowerSupplyDutyReason.setSpecialAnalysis(csvRecord.get("SPECIAL_ANALYSIS"));
			oriPowerSupplyDutyReason.setReasonType(csvRecord.get("REASON_TYPE"));
			oriPowerSupplyDutyReason.setDutyReasonName(csvRecord.get("DUTY_REASON_NAME"));
			oriPowerSupplyDutyReason.setDutyReasonCode(csvRecord.get("DUTY_REASON_CODE"));
			if (csvRecord.get("POWER_CUT_TIMES").trim().isEmpty()) {
				oriPowerSupplyDutyReason.setPowerCutTimes(new Double(0.0));
			} else {
				oriPowerSupplyDutyReason.setPowerCutTimes(Double.parseDouble(csvRecord.get("POWER_CUT_TIMES")));
			}
			if (csvRecord.get("BLACKOUT_CUSTOMER_QUANTITY").trim().isEmpty()) {
				oriPowerSupplyDutyReason.setBlackoutCustomerQuantity(new Double(0.0));
			} else {
				oriPowerSupplyDutyReason
						.setBlackoutCustomerQuantity(Double.parseDouble(csvRecord.get("BLACKOUT_CUSTOMER_QUANTITY")));
			}
			if (csvRecord.get("POWER_CUT_LAST_TIME").trim().isEmpty()) {
				oriPowerSupplyDutyReason.setPowerCutLastTime(new Double(0.0));
			} else {
				oriPowerSupplyDutyReason.setPowerCutLastTime(Double.parseDouble(csvRecord.get("POWER_CUT_LAST_TIME")));
			}
			if (csvRecord.get("POWER_CUT_TIME_MULTIP_USER_NUM").trim().isEmpty()) {
				oriPowerSupplyDutyReason.setPowerCutTimeMultipUserNum((new Double(0.0)));
			} else {
				oriPowerSupplyDutyReason.setPowerCutTimeMultipUserNum(
						Double.parseDouble(csvRecord.get("POWER_CUT_TIME_MULTIP_USER_NUM")));
			}
			if (csvRecord.get("POWER_CUT_CAPACITY").trim().isEmpty()) {
				oriPowerSupplyDutyReason.setPowerCutCapacity(new Double(0.0));
			} else {
				oriPowerSupplyDutyReason.setPowerCutCapacity(Double.parseDouble(csvRecord.get("POWER_CUT_CAPACITY")));
			}
			if (csvRecord.get("LACK_POWER_SUPPLY").trim().isEmpty()) {
				oriPowerSupplyDutyReason.setLackPowerSupply(new Double(0.0));
			} else {
				oriPowerSupplyDutyReason.setLackPowerSupply(Double.parseDouble(csvRecord.get("LACK_POWER_SUPPLY")));
			}
			if (csvRecord.get("POWER_CUT_TIME_PER_USER").trim().isEmpty()) {
				oriPowerSupplyDutyReason.setPowerCutTimePerUser(new Double(0.0));
			} else {
				oriPowerSupplyDutyReason
						.setPowerCutTimePerUser(Double.parseDouble(csvRecord.get("POWER_CUT_TIME_PER_USER")));
			}
			if (csvRecord.get("INFLUENCE_ON_RS_1").trim().isEmpty()) {
				oriPowerSupplyDutyReason.setInfluenceOnRs1(new Double(0.0));
			} else {
				oriPowerSupplyDutyReason.setInfluenceOnRs1(Double.parseDouble(csvRecord.get("INFLUENCE_ON_RS_1")));
			}
			oriPowerSupplyDutyReason.setStatisticTaskId(csvRecord.get("STATISTIC_TASK_ID"));
			// oriPowerSupplyDutyReason.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			oriPowerSupplyDutyReason.setDataSourceFile(pathStr);

			session.save(oriPowerSupplyDutyReason);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriOperationTicketRecordAdd(String pathStr, String dataVersion, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "utf-8");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriOperationTicketRecord oriOperationTicketRecord = new OriOperationTicketRecord();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// oriPowerSupplyDutyReason.setCalYear(simpleDateFormat.parse("2019-07-22"));
			oriOperationTicketRecord.setCalYear(DateFormatUtil.parseDate(calYear));
			oriOperationTicketRecord.setDataVersion(dataVersion);

			oriOperationTicketRecord.setCalYear(DateFormatUtil.parseDate(calYear));
			oriOperationTicketRecord.setDataVersion(dataVersion);

			oriOperationTicketRecord.setTicketNumber(csvRecord.get("TICKET_NUMBER"));
			oriOperationTicketRecord.setTicketType(csvRecord.get("TICKET_TYPE"));
			oriOperationTicketRecord.setOperationTicketType(csvRecord.get("OPERATION_TICKET_TYPE"));
			oriOperationTicketRecord.setOperationTicketStatus(csvRecord.get("OPERATION_TICKET_STATUS"));
			oriOperationTicketRecord.setWorkPlaceName(csvRecord.get("WORK_PLACE_NAME"));
			oriOperationTicketRecord.setOperationTask(csvRecord.get("OPERATION_TASK"));
			oriOperationTicketRecord.setTicketMakingTime(csvRecord.get("TICKET_MAKING_TIME"));
			/*
			 * try { if (csvRecord.get("TICKET_MAKING_TIME").contains("-")) {
			 * oriOperationTicketRecord
			 * .setTicketMakingTime(simpleDateFormat.parse(csvRecord.get(
			 * "TICKET_MAKING_TIME"))); } else if
			 * (csvRecord.get("TICKET_MAKING_TIME").contains("/")) {
			 * oriOperationTicketRecord.setTicketMakingTime(
			 * simpleDateFormat2.parse((csvRecord.get("TICKET_MAKING_TIME").length() <= 10)
			 * ? csvRecord.get("TICKET_MAKING_TIME") + "00:00" :
			 * csvRecord.get("TICKET_MAKING_TIME"))); } } catch (ParseException e) {
			 * e.printStackTrace(); }
			 */
			oriOperationTicketRecord.setTicketMakingOrgName(csvRecord.get("TICKET_MAKING_ORG_NAME"));
			oriOperationTicketRecord.setTicketPreparerName(csvRecord.get("TICKET_PREPARER_NAME"));
			oriOperationTicketRecord.setOrderIssuePersonName(csvRecord.get("ORDER_ISSUE_PERSON_NAME"));
			oriOperationTicketRecord.setOrderRecipientName(csvRecord.get("ORDER_RECIPIENT_NAME"));
			oriOperationTicketRecord.setGuardianName(csvRecord.get("GUARDIAN_NAME"));
			oriOperationTicketRecord.setOperationStartTime(csvRecord.get("OPERATION_START_TIME"));
			oriOperationTicketRecord.setOperationEndTime(csvRecord.get("OPERATION_END_TIME"));
			/*
			 * try { if (csvRecord.get("OPERATION_START_TIME").contains("-")) {
			 * oriOperationTicketRecord
			 * .setOperationStartTime(simpleDateFormat.parse(csvRecord.get(
			 * "OPERATION_START_TIME"))); } else if
			 * (csvRecord.get("OPERATION_START_TIME").contains("/")) {
			 * oriOperationTicketRecord.setOperationStartTime(
			 * simpleDateFormat2.parse((csvRecord.get("OPERATION_START_TIME").length() <=
			 * 10) ? csvRecord.get("OPERATION_START_TIME") + "00:00" :
			 * csvRecord.get("OPERATION_START_TIME"))); }
			 * 
			 * } catch (ParseException e) { e.printStackTrace(); } try { if
			 * (csvRecord.get("OPERATION_END_TIME").contains("-")) {
			 * oriOperationTicketRecord
			 * .setOperationEndTime(simpleDateFormat.parse(csvRecord.get(
			 * "OPERATION_END_TIME"))); } else if
			 * (csvRecord.get("OPERATION_END_TIME").contains("/")) {
			 * oriOperationTicketRecord.setOperationEndTime(
			 * simpleDateFormat2.parse((csvRecord.get("OPERATION_END_TIME").length() <= 10)
			 * ? csvRecord.get("OPERATION_END_TIME") + "00:00" :
			 * csvRecord.get("OPERATION_END_TIME"))); } } catch (ParseException e) {
			 * e.printStackTrace(); }
			 */
			oriOperationTicketRecord.setDataSource(pathStr);

			session.save(oriOperationTicketRecord);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriWorkTaskDocumentRecordAdd(String pathStr, String dataVersion, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "UTF-8");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		// int maxLength=0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriWorkTaskDocumentRecord oriWorkTaskDocumentRecord = new OriWorkTaskDocumentRecord();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");

			// oriPowerSupplyDutyReason.setCalYear(simpleDateFormat.parse("2019-07-22"));
			oriWorkTaskDocumentRecord.setCalYear(DateFormatUtil.parseDate(calYear));
			oriWorkTaskDocumentRecord.setDataVersion(dataVersion);

			oriWorkTaskDocumentRecord.setCalYear(DateFormatUtil.parseDate(calYear));
			oriWorkTaskDocumentRecord.setTaskDocumentNumber(csvRecord.get("TASK_DOCUMENT_NUMBER"));
			oriWorkTaskDocumentRecord.setTaskDocumentName(csvRecord.get("TASK_DOCUMENT_NAME"));
			oriWorkTaskDocumentRecord.setCompileTime(csvRecord.get("COMPILE_TIME"));
			oriWorkTaskDocumentRecord.setTaskContent(csvRecord.get("TASK_CONTENT"));
			oriWorkTaskDocumentRecord.setWorkingPlace(csvRecord.get("WORKING_PLACE"));

			oriWorkTaskDocumentRecord.setPlannedStartTime(csvRecord.get("PLANNED_START_TIME"));
			oriWorkTaskDocumentRecord.setPlannedEndTime(csvRecord.get("PLANNED_END_TIME"));

			oriWorkTaskDocumentRecord.setWhetherPowerCut(csvRecord.get("WHETHER_POWER_CUT"));
			oriWorkTaskDocumentRecord.setApprovedPowerCutStartTime(csvRecord.get("APPROVED_POWER_CUT_START_TIME"));
			oriWorkTaskDocumentRecord.setApprovedPowerCutEndTime(csvRecord.get("APPROVED_POWER_CUT_END_TIME"));
			/*
			 * if(csvRecord.get("TASK_CONTENT").length()>maxLength) {
			 * maxLength=csvRecord.get("TASK_CONTENT").length(); }
			 */
			oriWorkTaskDocumentRecord.setBlackoutRange(csvRecord.get("BLACKOUT_RANGE"));
			oriWorkTaskDocumentRecord.setTaskArrangerName(csvRecord.get("TASK_ARRANGER_NAME"));
			oriWorkTaskDocumentRecord.setCompletionPhase(csvRecord.get("COMPLETION_PHASE"));
			oriWorkTaskDocumentRecord.setCityName(csvRecord.get("CITY_NAME"));
			oriWorkTaskDocumentRecord.setDataSource(pathStr);

			session.save(oriWorkTaskDocumentRecord);

			// System.out.println("maxLength="+maxLength);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriWorkTicketRecordAdd(String pathStr, String dataVersion, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "UTF-8");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			// OriWorkTicketRecord
			OriWorkTicketRecord oriWorkTicketRecord = new OriWorkTicketRecord();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");

			// oriPowerSupplyDutyReason.setCalYear(simpleDateFormat.parse("2019-07-22"));
			oriWorkTicketRecord.setCalYear(DateFormatUtil.parseDate(calYear));
			oriWorkTicketRecord.setDataVersion(dataVersion);

			oriWorkTicketRecord.setCalYear(DateFormatUtil.parseDate(calYear));
			oriWorkTicketRecord.setTicketNumber(csvRecord.get("TICKET_NUMBER"));
			oriWorkTicketRecord.setTicketType(csvRecord.get("TICKET_TYPE"));
			oriWorkTicketRecord.setWorkTicketType(csvRecord.get("WORK_TICKET_TYPE"));
			oriWorkTicketRecord.setWorkTicketStatus(csvRecord.get("WORK_TICKET_STATUS"));
			oriWorkTicketRecord.setWorkPlaceName(csvRecord.get("WORK_PLACE_NAME"));
			oriWorkTicketRecord.setJobDescription(csvRecord.get("JOB_DESCRIPTION"));
			oriWorkTicketRecord.setTicketMakingDepartment(csvRecord.get("TICKET_MAKING_DEPARTMENT"));
			oriWorkTicketRecord.setOperationMaintenanceOrgName(csvRecord.get("OPERATION_MAINTENANCE_ORG_NAME"));
			oriWorkTicketRecord.setTicketMakingTime(csvRecord.get("TICKET_MAKING_TIME"));
			oriWorkTicketRecord.setPlannedStartTime(csvRecord.get("PLANNED_START_TIME"));
			oriWorkTicketRecord.setPlannedEndTime(csvRecord.get("PLANNED_END_TIME"));
			oriWorkTicketRecord.setPermittedWorkingHours(csvRecord.get("PERMITTED_WORKING_HOURS"));
			oriWorkTicketRecord.setLicensorName(csvRecord.get("LICENSOR_NAME"));
			oriWorkTicketRecord.setEndTime(csvRecord.get("END_TIME"));
			if (csvRecord.get("TEAM_MEMBERS_QUANTITY").trim().isEmpty()) {
				oriWorkTicketRecord.setTeamMembersQuantity(new Double(0.0));
			} else {
				oriWorkTicketRecord.setTeamMembersQuantity(Double.parseDouble(csvRecord.get("TEAM_MEMBERS_QUANTITY")));
			}
			oriWorkTicketRecord.setTicketPreparerName(csvRecord.get("TICKET_PREPARER_NAME"));

			oriWorkTicketRecord.setDataSource(pathStr);

			session.save(oriWorkTicketRecord);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriOrderRecordAdd(String pathStr, String dataVersion, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "UTF-8");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			// OriWorkTicketRecord
			OriOrderRecord oriOrderRecord = new OriOrderRecord();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");

			/*
			 * try { //
			 * oriPowerSupplyDutyReason.setCalYear(simpleDateFormat.parse("2019-07-22"));
			 * oriOrderRecord.setCalYear(simpleDateFormat.parse(calYear)); } catch
			 * (ParseException e) { e.printStackTrace(); }
			 */
			oriOrderRecord.setDataVersion(dataVersion);

			/*
			 * try { oriOrderRecord.setCalYear(simpleDateFormat.parse(calYear)); } catch
			 * (ParseException e) { e.printStackTrace(); }
			 */
			oriOrderRecord.setOrderType(csvRecord.get("ORDER_TYPE"));
			oriOrderRecord.setOrderNumber(csvRecord.get("ORDER_NUMBER"));
			oriOrderRecord.setBusinessScope(csvRecord.get("BUSINESS_SCOPE"));
			if (csvRecord.get("PLANNED_TOTAL").trim().isEmpty()) {
				oriOrderRecord.setPlannedTotal(new Double(0.0));
			} else {
				try {
					oriOrderRecord
							.setPlannedTotal(new DecimalFormat().parse(csvRecord.get("PLANNED_TOTAL")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (csvRecord.get("ACTUAL_TOTAL").trim().isEmpty()) {
				oriOrderRecord.setActualTotal(new Double(0.0));
			} else {
				try {
					oriOrderRecord
							.setActualTotal(new DecimalFormat().parse(csvRecord.get("ACTUAL_TOTAL")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			oriOrderRecord.setFunctionalLocation(csvRecord.get("FUNCTIONAL_LOCATION"));
			oriOrderRecord.setMaintenanceJobType(csvRecord.get("MAINTENANCE_JOB_TYPE"));
			oriOrderRecord.setPlannerGroup(csvRecord.get("PLANNER_GROUP"));
			oriOrderRecord.setOrderContentDescribe(csvRecord.get("ORDER_CONTENT_DESCRIBE"));
			oriOrderRecord.setPlanningFactory(csvRecord.get("PLANNING_FACTORY"));
			oriOrderRecord.setBasicStartDate(csvRecord.get("BASIC_START_DATE"));
			oriOrderRecord.setBasicCompletionDate(csvRecord.get("BASIC_COMPLETION_DATE"));
			oriOrderRecord.setUserStatus(csvRecord.get("USER_STATUS"));
			oriOrderRecord.setImporter(csvRecord.get("IMPORTER"));
			oriOrderRecord.setCreationDate(csvRecord.get("CREATION_DATE"));
			oriOrderRecord.setBasicCompletionTime(csvRecord.get("BASIC_COMPLETION_TIME"));
			oriOrderRecord.setCompletionTime(csvRecord.get("COMPLETION_TIME"));
			oriOrderRecord.setWbsOrderTitle(csvRecord.get("WBS_ORDER_TITLE"));
			oriOrderRecord.setWorkingPlaceDescribe(csvRecord.get("WORKING_PLACE_DESCRIBE"));
			oriOrderRecord.setAbcLogo(csvRecord.get("ABC_LOGO"));
			oriOrderRecord.setPurchaseOrderDate(csvRecord.get("PURCHASE_ORDER_DATE"));
			oriOrderRecord.setPurchaseOrderNumber(csvRecord.get("PURCHASE_ORDER_NUMBER"));
			oriOrderRecord.setReservePurchaseApplication(csvRecord.get("RESERVE_PURCHASE_APPLICATION"));
			oriOrderRecord.setChangeDate(csvRecord.get("CHANGE_DATE"));

			oriOrderRecord.setDataFile(pathStr);

			session.save(oriOrderRecord);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void oriFullAssetAccountPostingAdd(String pathStr, String versionValue, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriFullAssetAccountPosting oriFullAssetAccountPosting = new OriFullAssetAccountPosting();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// oriFullAssetAccountPosting.setOriFullAssetAccountPosId(csvRecord.get("ORI_FULL_ASSET_ACCOUNT_POS_ID"));
			oriFullAssetAccountPosting.setDataVersion(versionValue);
			oriFullAssetAccountPosting.setCalYaer(DateFormatUtil.parseDate(calYear));
			oriFullAssetAccountPosting.setSystemIdentification(csvRecord.get("SYSTEM_IDENTIFICATION"));
			oriFullAssetAccountPosting.setOrgNameCode(csvRecord.get("ORG_NAME_CODE"));
			// oriFullAssetAccountPosting.setOrgName(csvRecord.get("ORG_NAME"));
			oriFullAssetAccountPosting.setAssetNumber(csvRecord.get("ASSET_NUMBER"));
			oriFullAssetAccountPosting.setSecondaryNumber(csvRecord.get("SECONDARY_NUMBER"));
			if (csvRecord.get("CALYEAR").trim().isEmpty()) {
				oriFullAssetAccountPosting.setCalyear(new Long(0));
			} else {
				try {
					oriFullAssetAccountPosting
							.setCalyear(new DecimalFormat().parse(csvRecord.get("CALYEAR")).longValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			oriFullAssetAccountPosting.setLargeClassCode(csvRecord.get("LARGE_CLASS_CODE"));
			oriFullAssetAccountPosting.setTransactionCategory(csvRecord.get("TRANSACTION_CATEGORY"));
			oriFullAssetAccountPosting.setWhethCapitalizationLastYear(csvRecord.get("WHETH_CAPITALIZATION_LAST_YEAR"));
			if (csvRecord.get("BOOK_KEEPING_AMOUNT").trim().isEmpty()) {
				oriFullAssetAccountPosting.setBookKeepingAmount(new Double(0.0));
			} else {
				try {
					oriFullAssetAccountPosting.setBookKeepingAmount(
							new DecimalFormat().parse(csvRecord.get("BOOK_KEEPING_AMOUNT")).doubleValue()

					);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (!(csvRecord.get("ASSET_VALUE_DATE").trim().isEmpty())) {
				oriFullAssetAccountPosting
						.setAssetValueDate(DateFormatUtil.parseDate(csvRecord.get("ASSET_VALUE_DATE")));
			}
			oriFullAssetAccountPosting.setBusinessAttribute(csvRecord.get("BUSINESS_ATTRIBUTE"));

			oriFullAssetAccountPosting.setDataSourceFile(pathStr);

			session.save(oriFullAssetAccountPosting);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void oriFullAssetCapitalizationAdd(String pathStr, String versionValue, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriFullAssetCapitalization oriFullAssetCapitalization = new OriFullAssetCapitalization();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
			// oriFullAssetAccountPosting.setOriFullAssetAccountPosId(csvRecord.get("ORI_FULL_ASSET_ACCOUNT_POS_ID"));
			oriFullAssetCapitalization.setDataVersion(versionValue);
			oriFullAssetCapitalization.setCalYaer(DateFormatUtil.parseDate(calYear));
			// oriFullAssetCapitalization.setOriFullAssetCapitalizId(csvRecord.get("ORI_FULL_ASSET_CAPITALIZ_ID"));
			oriFullAssetCapitalization.setDataVersion(versionValue);
			oriFullAssetCapitalization.setCalYaer(DateFormatUtil.parseDate(calYear));
			oriFullAssetCapitalization.setOrgNameCode(csvRecord.get("ORG_NAME_CODE"));
			oriFullAssetCapitalization.setAssetNumber(csvRecord.get("ASSET_NUMBER"));
			oriFullAssetCapitalization.setSecondaryNumber(csvRecord.get("SECONDARY_NUMBER"));
			if (csvRecord.get("CALYEAR").trim().isEmpty()) {
				oriFullAssetCapitalization.setCalyear(new Long(0));
			} else {
				try {
					oriFullAssetCapitalization
							.setCalyear(new DecimalFormat().parse(csvRecord.get("CALYEAR")).longValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			oriFullAssetCapitalization.setArDot(csvRecord.get("AR_DOT"));
			oriFullAssetCapitalization.setLargeClassCode(csvRecord.get("LARGE_CLASS_CODE"));
			if (csvRecord.get("ORIGINAL_VALUE").trim().isEmpty()) {
				oriFullAssetCapitalization.setOriginalValue(new Double(0.0));
			} else {
				try {
					oriFullAssetCapitalization
							.setOriginalValue(new DecimalFormat().parse(csvRecord.get("ORIGINAL_VALUE")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (csvRecord.get("ACCUMULATED_PURCHASE_VALUE").trim().isEmpty()) {
				oriFullAssetCapitalization.setAccumulatedPurchaseValue((new Double(0.0)));
			} else {
				try {
					oriFullAssetCapitalization.setAccumulatedPurchaseValue(
							new DecimalFormat().parse(csvRecord.get("ACCUMULATED_PURCHASE_VALUE")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (csvRecord.get("ASSET_VALUE_BUSINESS").trim().isEmpty()) {
				oriFullAssetCapitalization.setAssetValueBusiness(new Double(0.0));
			} else {
				try {
					oriFullAssetCapitalization.setAssetValueBusiness(
							new DecimalFormat().parse(csvRecord.get("ASSET_VALUE_BUSINESS")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			oriFullAssetCapitalization.setDataSourceFile(pathStr);

			session.save(oriFullAssetCapitalization);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvZfiSwzcAdd(String pathStr, String versionValue, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ZfiSwzc2019 zfiSwzc2019 = new ZfiSwzc2019();

			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
			// zfiSwzc2019.setZfiSwzc2019Id(csvRecord.get("ZFI_SWZC_2019_ID"));
			zfiSwzc2019.setVersion(versionValue);
			zfiSwzc2019.setCalYear(DateFormatUtil.parseDate(calYear));

			zfiSwzc2019.setAssetMain(csvRecord.get("ASSET_MAIN"));

			zfiSwzc2019.setEqunr(csvRecord.get("EQUNR"));
			/*
			 * try {
			 * 
			 * zfiSwzc2019.setCurrency(csvRecord.get("CURRENCY")); } catch (Exception e) {
			 * // TODO: handle exception zfiSwzc2019.setCurrency(""); }
			 */
			if (csvRecord.get("ZPMZCYZ").trim().isEmpty()) {
				zfiSwzc2019.setZpmzcyz(new Double(0.0));
			} else {
				// zfiSwzc2019.setZpmzcyz(Double.parseDouble(csvRecord.get("ZPMZCYZ")));
				try {
					zfiSwzc2019.setZpmzcyz(new DecimalFormat().parse(csvRecord.get("ZPMZCYZ")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (csvRecord.get("ZPMZCJZ").trim().isEmpty()) {
				zfiSwzc2019.setZpmzcjz(new Double(0.0));
			} else {
				// zfiSwzc2019.setZpmzcjz(Double.parseDouble(csvRecord.get("ZPMZCJZ")));
				try {
					zfiSwzc2019.setZpmzcjz(new DecimalFormat().parse(csvRecord.get("ZPMZCJZ")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			/*
			 * zfiSwzc2019.setZtypbz1(csvRecord.get("ZTYPBZ1"));
			 * zfiSwzc2019.setZtypbz2(csvRecord.get("ZTYPBZ2"));
			 * zfiSwzc2019.setZtypbz3(csvRecord.get("ZTYPBZ3"));
			 */
			zfiSwzc2019.setZvolLev(csvRecord.get("ZVOL_LEV"));
			/*
			 * if (csvRecord.get("ZQUANTITY").trim().isEmpty()) {
			 * zfiSwzc2019.setZquantity(new Double(0.0)); } else { //
			 * zfiSwzc2019.setZquantity(Double.parseDouble(csvRecord.get("ZQUANTITY"))); try
			 * { zfiSwzc2019.setZquantity(new
			 * DecimalFormat().parse(csvRecord.get("ZQUANTITY")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } zfiSwzc2019.setUnit(csvRecord.get("UNIT"));
			 */
			zfiSwzc2019.setZioZczt(csvRecord.get("ZIO_ZCZT"));
			/* zfiSwzc2019.setProfitCtr(csvRecord.get("PROFIT_CTR")); */
			zfiSwzc2019.setZlrzx(csvRecord.get("ZLRZX"));
			/*
			 * try {
			 * 
			 * zfiSwzc2019.setCoArea(csvRecord.get("CO_AREA")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setCoArea(""); }
			 * zfiSwzc2019.setZzcms(csvRecord.get("ZZCMS"));
			 */
			zfiSwzc2019.setZioZxmlx(csvRecord.get("ZIO_ZXMLX"));
			zfiSwzc2019.setAktiv(csvRecord.get("AKTIV"));
			/*
			 * zfiSwzc2019.setDeakt(csvRecord.get("DEAKT"));
			 * zfiSwzc2019.setAnlkl(csvRecord.get("ANLKL")); try {
			 * 
			 * zfiSwzc2019.setSernr(csvRecord.get("SERNR")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setSernr(""); } try {
			 * 
			 * zfiSwzc2019.setInvnr(csvRecord.get("INVNR")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setInvnr(""); }
			 * zfiSwzc2019.setZzc001(csvRecord.get("ZZC001"));
			 * zfiSwzc2019.setZzc002(csvRecord.get("ZZC002"));
			 * zfiSwzc2019.setKostl(csvRecord.get("KOSTL")); try {
			 * 
			 * zfiSwzc2019.setKostlv(csvRecord.get("KOSTLV")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setKostlv(""); } try {
			 * 
			 * zfiSwzc2019.setRaumn(csvRecord.get("RAUMN")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setRaumn("RAUMN"); } try {
			 * 
			 * zfiSwzc2019.setKfzkz(csvRecord.get("KFZKZ")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setKfzkz(""); } try {
			 * 
			 * zfiSwzc2019.setZzas1(csvRecord.get("ZZAS1")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setZzas1(""); }
			 * zfiSwzc2019.setZzc006(csvRecord.get("ZZC006")); try {
			 * 
			 * zfiSwzc2019.setZzc007(csvRecord.get("ZZC007")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setZzc007(""); }
			 * zfiSwzc2019.setOrd41(csvRecord.get("ORD41"));
			 */
			zfiSwzc2019.setOrd44(csvRecord.get("ORD44"));
			zfiSwzc2019.setGdlgrp(csvRecord.get("GDLGRP"));
			zfiSwzc2019.setIzwek(csvRecord.get("IZWEK"));
			/*
			 * zfiSwzc2019.setUmwkz(csvRecord.get("UMWKZ"));
			 * zfiSwzc2019.setAnlue(csvRecord.get("ANLUE"));
			 * zfiSwzc2019.setHerst(csvRecord.get("HERST"));
			 */
			zfiSwzc2019.setTypbz(csvRecord.get("TYPBZ"));
			/*
			 * try {
			 * 
			 * zfiSwzc2019.setZkpwbs(csvRecord.get("ZKPWBS")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setZkpwbs(""); } try {
			 * 
			 * zfiSwzc2019.setZkpwbsms(csvRecord.get("ZKPWBSMS")); } catch (Exception e) {
			 * // TODO: handle exception zfiSwzc2019.setZkpwbsms(""); } try {
			 * 
			 * zfiSwzc2019.setFiamt(csvRecord.get("FIAMT")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setFiamt(""); }
			 */
			zfiSwzc2019.setStadt(csvRecord.get("STADT"));
			/*
			 * try {
			 * 
			 * zfiSwzc2019.setZfwcqzh(csvRecord.get("ZFWCQZH")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setZfwcqzh(""); }
			 */
			zfiSwzc2019.setEqktx(csvRecord.get("EQKTX"));
			zfiSwzc2019.setTxt04(csvRecord.get("TXT04"));
			/*
			 * try { zfiSwzc2019.setEqart(csvRecord.get("EQART")); } catch (Exception e) {
			 * // TODO: handle exception zfiSwzc2019.setEqart(""); } try {
			 * 
			 * zfiSwzc2019.setBegru(csvRecord.get("BEGRU")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setBegru(""); }
			 */
			zfiSwzc2019.setInbdt(csvRecord.get("INBDT"));
			/*
			 * zfiSwzc2019.setZccrq(csvRecord.get("ZCCRQ"));
			 * zfiSwzc2019.setZherst(csvRecord.get("ZHERST"));
			 * zfiSwzc2019.setHerld(csvRecord.get("HERLD"));
			 * zfiSwzc2019.setMapar(csvRecord.get("MAPAR"));
			 * zfiSwzc2019.setZtypbz(csvRecord.get("ZTYPBZ"));
			 * 
			 * try {
			 * 
			 * zfiSwzc2019.setSerge(csvRecord.get("SERGE")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setSerge(""); } try {
			 * 
			 * zfiSwzc2019.setSwerk(csvRecord.get("SWERK")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setSwerk(""); } try {
			 * 
			 * zfiSwzc2019.setStort(csvRecord.get("STORT")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setStort(""); } try {
			 * 
			 * zfiSwzc2019.setBeber(csvRecord.get("BEBER")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setBeber(""); } try {
			 * zfiSwzc2019.setAbckz(csvRecord.get("ABCKZ")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setAbckz(""); }
			 * zfiSwzc2019.setEqfnr(csvRecord.get("EQFNR")); try {
			 * zfiSwzc2019.setZkostl(csvRecord.get("ZKOSTL")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setZkostl(""); } try {
			 * zfiSwzc2019.setZsbwbs(csvRecord.get("ZSBWBS")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setZsbwbs(""); } try {
			 * zfiSwzc2019.setZsbwbsms(csvRecord.get("ZSBWBSMS")); } catch (Exception e) {
			 * // TODO: handle exception zfiSwzc2019.setZsbwbsms(""); } try {
			 * zfiSwzc2019.setIwerk(csvRecord.get("IWERK")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setIwerk(""); } try {
			 * zfiSwzc2019.setIngrp(csvRecord.get("INGRP")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setIngrp(""); } try {
			 * zfiSwzc2019.setGewrk(csvRecord.get("GEWRK")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setGewrk(""); }
			 * zfiSwzc2019.setTplnr(csvRecord.get("TPLNR"));
			 * zfiSwzc2019.setHequi(csvRecord.get("HEQUI")); try {
			 * zfiSwzc2019.setTidnr(csvRecord.get("TIDNR")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setTidnr(""); } try {
			 * zfiSwzc2019.setZsb010(csvRecord.get("ZSB010")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setZsb010(""); } try {
			 * zfiSwzc2019.setZsb001(csvRecord.get("ZSB001")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setZsb001(""); } try {
			 * zfiSwzc2019.setZsb002(csvRecord.get("ZSB002")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setZsb002(""); }
			 * zfiSwzc2019.setZsb004(csvRecord.get("ZSB004"));
			 */
			zfiSwzc2019.setZsb005(csvRecord.get("ZSB005"));
			/*
			 * try { zfiSwzc2019.setZsb006(csvRecord.get("ZSB006")); } catch (Exception e) {
			 * // TODO: handle exception zfiSwzc2019.setZsb006(""); } try {
			 * zfiSwzc2019.setZsb003(csvRecord.get("ZSB003")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setZsb003(""); } try {
			 * zfiSwzc2019.setZsb007(csvRecord.get("ZSB007")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setZsb007(""); }
			 */
			try {
				zfiSwzc2019.setZsb008(csvRecord.get("ZSB008"));
			} catch (Exception e) {
				// TODO: handle exception
				zfiSwzc2019.setZsb008("");
			}
			zfiSwzc2019.setZlenunt(csvRecord.get("ZLENUNT"));
			zfiSwzc2019.setZsb009(csvRecord.get("ZSB009"));
			zfiSwzc2019.setZcapunt(csvRecord.get("ZCAPUNT"));

			/*
			 * try { zfiSwzc2019.setZsb011(csvRecord.get("ZSB011")); } catch (Exception e) {
			 * // TODO: handle exception zfiSwzc2019.setZsb011(""); }
			 * zfiSwzc2019.setZeq003(csvRecord.get("ZEQ003"));
			 * zfiSwzc2019.setZeq001(csvRecord.get("ZEQ001"));
			 * 
			 * zfiSwzc2019.setZeq002(csvRecord.get("ZEQ002"));
			 * zfiSwzc2019.setZlyrkrq(csvRecord.get("ZLYRKRQ"));
			 * zfiSwzc2019.setZlyckrq(csvRecord.get("ZLYCKRQ"));
			 * zfiSwzc2019.setZbfjzrq(csvRecord.get("ZBFJZRQ"));
			 * zfiSwzc2019.setZbfxmbm(csvRecord.get("ZBFXMBM"));
			 * zfiSwzc2019.setZbfxmms(csvRecord.get("ZBFXMMS"));
			 * zfiSwzc2019.setZbfyydm(csvRecord.get("ZBFYYDM"));
			 * zfiSwzc2019.setZbfyywb(csvRecord.get("ZBFYYWB")); try {
			 * zfiSwzc2019.setCdate(csvRecord.get("CDATE")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setCdate(""); } try {
			 * zfiSwzc2019.setCtime(csvRecord.get("CTIME")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setCtime(""); } try {
			 * zfiSwzc2019.setCname(csvRecord.get("CNAME")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setCname(""); } try {
			 * zfiSwzc2019.setStext4(csvRecord.get("STEXT4"));
			 * zfiSwzc2019.setCname(csvRecord.get("CNAME")); } catch (Exception e) { //
			 * TODO: handle exception zfiSwzc2019.setStext4(""); }
			 */
			zfiSwzc2019.setZtypbz1t(csvRecord.get("ZTYPBZ1T"));
			zfiSwzc2019.setZtypbz2t(csvRecord.get("ZTYPBZ2T"));
			zfiSwzc2019.setZtypbz3t(csvRecord.get("ZTYPBZ3T"));
			zfiSwzc2019.setAssetProperty(csvRecord.get("ASSET_PROPERTY"));
			zfiSwzc2019.setPropertyCode(csvRecord.get("PROPERTY_CODE"));
			/* zfiSwzc2019.setAssetId(csvRecord.get("ASSET_ID")); */

			zfiSwzc2019.setVersion(versionValue);

			// zfiSwzc2019.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			// zfiSwzc2019.setOrgGroupCode(csvRecord.get("ORG_GROUP_CODE"));
			// zfiSwzc2019.setAssetDescription(csvRecord.get("ASSET_DESCRIPTION"));
			// zfiSwzc2019.setFixAssetClassDescript(csvRecord.get("FIX_ASSET_CLASS_DESCRIPT"));
			// zfiSwzc2019.setUnkownCode(csvRecord.get("UNKOWN_CODE"));
			// zfiSwzc2019.setAssetPropertyCVSName(csvRecord.get("ASSET_PROPERTY_CVS_NAME"));
			// zfiSwzc2019.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			// zfiSwzc2019.setRealAssetIdEquip(csvRecord.get("REAL_ASSET_ID_EQUIP"));
			// zfiSwzc2019.setDiscardCapacityScale(csvRecord.get("DISCARD_CAPACITY_SCALE"));
			// zfiSwzc2019.setDiscardPaperNumber(csvRecord.get("DISCARD_PAPER_NUMBER"));
			// zfiSwzc2019.setMetreUnit(csvRecord.get("METRE_UNIT"));
			// zfiSwzc2019.setDiscardSourceProject(csvRecord.get("DISCARD_SOURCE_PROJECT"));
			/* zfiSwzc2019.setFing(csvRecord.get("FING")); */
			// zfiSwzc2019.setEquipmentAssetIdProperty(csvRecord.get("EQUIPMENT_ASSET_ID_PROPERTY"));
			zfiSwzc2019.setAssetIdProperty(csvRecord.get("ASSET_ID_PROPERTY"));
			zfiSwzc2019.setOperationMaintenanceTeam(csvRecord.get("OPERATION_MAINTENANCE_TEAM"));
			/*
			 * zfiSwzc2019.setStext4(csvRecord.get("STEXT4"));
			 * zfiSwzc2019.setTxk20(csvRecord.get("TXK20"));
			 * zfiSwzc2019.setLtext(csvRecord.get("LTEXT"));
			 */

			zfiSwzc2019.setDataSourceFile(pathStr);

			session.save(zfiSwzc2019);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvPmsItemAutomaticAdd(String pathStr, String dataVersion, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemAutomatic pmsItemAutomatic = new PmsItemAutomatic();
			pmsItemAutomatic.setCalYear(new Short(calYear));
			pmsItemAutomatic.setVersion(dataVersion);
			pmsItemAutomatic.setDataSourceFile(pathStr);

			pmsItemAutomatic.setSbbm(csvRecord.get("设备编码"));
			pmsItemAutomatic.setDwmx(csvRecord.get("单位明细"));
			pmsItemAutomatic.setYwdw(csvRecord.get("运维单位"));
			pmsItemAutomatic.setZckbm(csvRecord.get("自动匹配的资产卡片编码"));
			pmsItemAutomatic.setSblx(csvRecord.get("设备类型"));
			if (csvRecord.get("资产原值").trim().isEmpty()) {
				pmsItemAutomatic.setZcyz(new Double(0.0));
			} else {
				pmsItemAutomatic.setZcyz(new Double(csvRecord.get("资产原值")));
			}
			pmsItemAutomatic.setZcdl(csvRecord.get("资产大类"));
			pmsItemAutomatic.setZclxbm(csvRecord.get("PMS设备类型编码"));
			pmsItemAutomatic.setCwbm(csvRecord.get("资产细类编码"));
			pmsItemAutomatic.setDydj(csvRecord.get("电压等级"));
			pmsItemAutomatic.setYxzt(csvRecord.get("运行状态"));
			pmsItemAutomatic.setJkzt(csvRecord.get("健康状态"));
			if (!csvRecord.get("最近投运日期").trim().isEmpty()) {
				pmsItemAutomatic.setZjtyrq(DateFormatUtil.parseDate(csvRecord.get("最近投运日期")));
			}
			pmsItemAutomatic.setZcxz(csvRecord.get("资产性质"));

			if (csvRecord.get("额定容量").trim().isEmpty()) {
				pmsItemAutomatic.setSl(new Double(0.0));
			} else {
				try {
					pmsItemAutomatic.setSl(df.parse(csvRecord.get("额定容量")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (!(null == csvRecord.get("电缆线路长度"))) {
				if (csvRecord.get("电缆线路长度").trim().isEmpty()) {
					pmsItemAutomatic.setSl1(new Double(0.0));
				} else {
					try {
						pmsItemAutomatic.setSl1(df.parse(csvRecord.get("电缆线路长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (!(null == csvRecord.get("架空线路长度"))) {
				if (csvRecord.get("架空线路长度").trim().isEmpty()) {
					pmsItemAutomatic.setSl2(new Double(0.0));
				} else {
					try {
						pmsItemAutomatic.setSl2(df.parse(csvRecord.get("架空线路长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			/*
			 * if(!(null ==csvRecord.get("SL3"))){ if
			 * (csvRecord.get("SL3").trim().isEmpty()) { pmsItemAutomatic.setSl3(new
			 * Double(0.0)); } else { try { pmsItemAutomatic.setSl3(
			 * df.parse(csvRecord.get("SL3")).doubleValue()); } catch (ParseException e) {
			 * // TODO Auto-generated catch block e.printStackTrace(); } } }
			 *
			 * pmsItemAutomatic.setJldw(csvRecord.get("JLDW"));
			 */
			pmsItemAutomatic.setZzsmc(csvRecord.get("制造商名称"));
			pmsItemAutomatic.setSsxlbdz(csvRecord.get("所属变电站名称"));
			pmsItemAutomatic.setSbxh(csvRecord.get("设备型号"));
			if (csvRecord.get("投运年份").trim().isEmpty()) {
				pmsItemAutomatic.setTynf(new Short("0"));
			} else {
				pmsItemAutomatic.setTynf(new Short(csvRecord.get("投运年份")));
			}
			pmsItemAutomatic.setNnd(csvRecord.get("年龄段"));
			if (!csvRecord.get("投运日期").trim().isEmpty()) {
				pmsItemAutomatic.setTyrq(DateFormatUtil.parseDate(csvRecord.get("投运日期")));
			}
			if (csvRecord.get("年龄").trim().isEmpty()) {
				pmsItemAutomatic.setNn(new Short("0"));
			} else {
				pmsItemAutomatic.setNn(new Short(csvRecord.get("年龄")));
			}

			pmsItemAutomatic.setQfzd(csvRecord.get("区分字段"));
			if (!csvRecord.get("出厂日期").trim().isEmpty()) {
				pmsItemAutomatic.setCcrq(DateFormatUtil.parseDate(csvRecord.get("出厂日期")));
			}
			// pmsItemAutomatic.setZclxbm1(csvRecord.get("ZCLXBM1"));

			pmsItemAutomatic.setEquipmentName(csvRecord.get("设备名称"));

			pmsItemAutomatic.setAssetId(csvRecord.get("实物ID"));
			pmsItemAutomatic.setEquipmentIncreaseMode(csvRecord.get("设备增加方式"));

			pmsItemAutomatic.setLineProperty(csvRecord.get("线路性质"));
			// pmsItemAutomatic.setJldw(csvRecord.get("计量单位"));
			session.save(pmsItemAutomatic);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvQueryByEquipmentIDList(String pathStr, String columnName, List columnValueList)
			throws IOException {
		File csv = new File(pathStr);
		System.out.println("csv.getName()=" + csv.getName());
		String targetFileName = csv.getName();
		String targetFilePathAndName = "src/main/webapp/userFile/Excel/errorRecord" + targetFileName;

		/*
		 * SessionFactory sf = new Configuration().configure().buildSessionFactory(); //
		 * 打开一个Session Session session = sf.openSession(); // 开始一个事务 Transaction tx =
		 * session.beginTransaction(); CSVFormat format =
		 * CSVFormat.DEFAULT.withHeader(); InputStreamReader in = new
		 * InputStreamReader(new FileInputStream(csv), "GB2312"); // CSVParser parser =
		 * CSVFormat.RFC4180.parse(in); CSVParser parser = new CSVParser(in, format);
		 * Iterator<CSVRecord> iterator = parser.iterator(); DecimalFormat df = new
		 * DecimalFormat(); // SimpleDateFormat simpleDateFormat = new //
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); SimpleDateFormat simpleDateFormat =
		 * new SimpleDateFormat("yyyy/MM/dd"); // parser.getHeaderMap().keySet(); int i
		 * = 0; while (iterator.hasNext()) { CSVRecord csvRecord = iterator.next();
		 * PmsItemRingMainUnit pmsItemRingMainUnit = new PmsItemRingMainUnit();
		 * pmsItemRingMainUnit.setDataSourceFile(pathStr);
		 * 
		 * pmsItemRingMainUnit.setSbbm(csvRecord.get("设备编码"));
		 * pmsItemRingMainUnit.setDwmx(csvRecord.get("单位明细"));
		 * pmsItemRingMainUnit.setYwdw(csvRecord.get("运维单位"));
		 * pmsItemRingMainUnit.setZckbm(csvRecord.get("自动匹配的资产卡片编码"));
		 * pmsItemRingMainUnit.setSblx(csvRecord.get("设备类型")); if
		 * (csvRecord.get("资产原值").trim().isEmpty()) { pmsItemRingMainUnit.setZcyz(new
		 * Double(0.0)); } else { pmsItemRingMainUnit.setZcyz(new
		 * Double(csvRecord.get("资产原值"))); }
		 * pmsItemRingMainUnit.setZcdl(csvRecord.get("资产大类"));
		 * pmsItemRingMainUnit.setZclxbm(csvRecord.get("PMS设备类型编码"));
		 * pmsItemRingMainUnit.setCwbm(csvRecord.get("资产细类编码"));
		 * pmsItemRingMainUnit.setDydj(csvRecord.get("电压等级"));
		 * pmsItemRingMainUnit.setYxzt(csvRecord.get("运行状态"));
		 * pmsItemRingMainUnit.setJkzt(csvRecord.get("健康状态")); if
		 * (!csvRecord.get("最近投运日期").trim().isEmpty()) { try {
		 * pmsItemRingMainUnit.setZjtyrq(simpleDateFormat.parse(csvRecord.get("最近投运日期"))
		 * ); } catch (ParseException e) { e.printStackTrace(); } }
		 * pmsItemRingMainUnit.setZcxz(csvRecord.get("资产性质"));
		 * 
		 * if (!(null == csvRecord.get("额定容量"))) { if
		 * (csvRecord.get("额定容量").trim().isEmpty()) { pmsItemRingMainUnit.setSl(new
		 * Double(0.0)); } else { try {
		 * pmsItemRingMainUnit.setSl(df.parse(csvRecord.get("额定容量")).doubleValue()); }
		 * catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } } if (!(null == csvRecord.get("电缆线路长度"))) { if
		 * (csvRecord.get("电缆线路长度").trim().isEmpty()) { pmsItemRingMainUnit.setSl1(new
		 * Double(0.0)); } else { try {
		 * pmsItemRingMainUnit.setSl1(df.parse(csvRecord.get("电缆线路长度")).doubleValue());
		 * } catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } } if (!(null == csvRecord.get("架空线路长度"))) { if
		 * (csvRecord.get("架空线路长度").trim().isEmpty()) { pmsItemRingMainUnit.setSl2(new
		 * Double(0.0)); } else { try {
		 * pmsItemRingMainUnit.setSl2(df.parse(csvRecord.get("架空线路长度")).doubleValue());
		 * } catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } }
		 * 
		 * 
		 * pmsItemRingMainUnit.setZzsmc(csvRecord.get("制造商名称"));
		 * pmsItemRingMainUnit.setSsxlbdz(csvRecord.get("站房名称"));
		 * pmsItemRingMainUnit.setSbxh(csvRecord.get("设备型号")); if
		 * (csvRecord.get("投运年份").trim().isEmpty()) { pmsItemRingMainUnit.setTynf(new
		 * Short("0")); } else { pmsItemRingMainUnit.setTynf(new
		 * Short(csvRecord.get("投运年份"))); }
		 * pmsItemRingMainUnit.setNnd(csvRecord.get("年龄段")); if
		 * (!csvRecord.get("投运日期").trim().isEmpty()) { try {
		 * pmsItemRingMainUnit.setTyrq(simpleDateFormat.parse(csvRecord.get("投运日期"))); }
		 * catch (ParseException e) { e.printStackTrace(); } } if
		 * (csvRecord.get("年龄").trim().isEmpty()) { pmsItemRingMainUnit.setNn(new
		 * Short("0")); } else { pmsItemRingMainUnit.setNn(new
		 * Short(csvRecord.get("年龄"))); }
		 * 
		 * pmsItemRingMainUnit.setQfzd(csvRecord.get("区分字段")); if
		 * (!csvRecord.get("出厂日期").trim().isEmpty()) { try {
		 * pmsItemRingMainUnit.setCcrq(simpleDateFormat.parse(csvRecord.get("出厂日期"))); }
		 * catch (ParseException e) { e.printStackTrace(); } }
		 * 
		 * pmsItemRingMainUnit.setEquipmentName(csvRecord.get("设备名称"));
		 * 
		 * pmsItemRingMainUnit.setAssetId(csvRecord.get("实物ID"));
		 * pmsItemRingMainUnit.setEquipmentIncreaseMode(csvRecord.get("设备增加方式"));
		 * pmsItemRingMainUnit.setLineProperty(csvRecord.get("线路性质"));
		 * session.save(pmsItemRingMainUnit);
		 * 
		 * 
		 * if (++i % 5000 == 0) { session.flush(); session.clear(); tx.commit(); tx =
		 * session.beginTransaction(); } } tx.commit(); session.clear(); sf.close();
		 */
	}

	public static void csvPmsItemPeiLineAdd(String pathStr, String dataVersion, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemPeiLine pmsItemPeiLine = new PmsItemPeiLine();

			pmsItemPeiLine.setCalYear(new Short(calYear));
			pmsItemPeiLine.setVersion(dataVersion);
			pmsItemPeiLine.setDataSourceFile(pathStr);

			pmsItemPeiLine.setSbbm(csvRecord.get("设备编码"));
			pmsItemPeiLine.setDwmx(csvRecord.get("单位明细"));
			pmsItemPeiLine.setYwdw(csvRecord.get("运维单位"));
			pmsItemPeiLine.setZckbm(csvRecord.get("自动匹配的资产卡片编码"));
			pmsItemPeiLine.setSblx(csvRecord.get("设备类型"));
			if (csvRecord.get("资产原值").trim().isEmpty()) {
				pmsItemPeiLine.setZcyz(new Double(0.0));
			} else {
				pmsItemPeiLine.setZcyz(new Double(csvRecord.get("资产原值")));
			}
			pmsItemPeiLine.setZcdl(csvRecord.get("资产大类"));
			pmsItemPeiLine.setZclxbm(csvRecord.get("PMS设备类型编码"));
			pmsItemPeiLine.setCwbm(csvRecord.get("资产细类编码"));
			pmsItemPeiLine.setDydj(csvRecord.get("电压等级"));
			pmsItemPeiLine.setYxzt(csvRecord.get("运行状态"));
			pmsItemPeiLine.setJkzt(csvRecord.get("健康状态"));
			if (!csvRecord.get("最近投运日期").trim().isEmpty()) {
				pmsItemPeiLine.setZjtyrq(DateFormatUtil.parseDate(csvRecord.get("最近投运日期")));
			}
			pmsItemPeiLine.setZcxz(csvRecord.get("资产性质"));

			if (!(null == csvRecord.get("线路总长度"))) {
				if (csvRecord.get("线路总长度").trim().isEmpty()) {
					pmsItemPeiLine.setSl(new Double(0.0));
				} else {
					try {
						pmsItemPeiLine.setSl(df.parse(csvRecord.get("线路总长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			try {
				if (!(null == csvRecord.get("电缆线路长度"))) {
					if (csvRecord.get("电缆线路长度").trim().isEmpty()) {
						pmsItemPeiLine.setSl1(new Double(0.0));
					} else {
						try {
							pmsItemPeiLine.setSl1(df.parse(csvRecord.get("电缆线路长度")).doubleValue());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				if (!(null == csvRecord.get("CABLE_LINE_LENGTH"))) {
					if (csvRecord.get("CABLE_LINE_LENGTH").trim().isEmpty()) {
						pmsItemPeiLine.setSl1(new Double(0.0));
					} else {
						try {
							pmsItemPeiLine.setSl1(df.parse(csvRecord.get("CABLE_LINE_LENGTH")).doubleValue());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			try {
				if (!(null == csvRecord.get("架空线路长度"))) {
					if (csvRecord.get("架空线路长度").trim().isEmpty()) {
						pmsItemPeiLine.setSl2(new Double(0.0));
					} else {
						try {
							pmsItemPeiLine.setSl2(df.parse(csvRecord.get("架空线路长度")).doubleValue());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				if (!(null == csvRecord.get("OVERHEAD_LINE_LENGTH"))) {
					if (csvRecord.get("OVERHEAD_LINE_LENGTH").trim().isEmpty()) {
						pmsItemPeiLine.setSl2(new Double(0.0));
					} else {
						try {
							pmsItemPeiLine.setSl2(df.parse(csvRecord.get("OVERHEAD_LINE_LENGTH")).doubleValue());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}

			/*
			 * if(!(null ==csvRecord.get("SL3"))){ if
			 * (csvRecord.get("SL3").trim().isEmpty()) { pmsItemPeiLine.setSl3(new
			 * Double(0.0)); } else { try { pmsItemPeiLine.setSl3(new
			 * DecimalFormat().parse(csvRecord.get("SL3")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } } pmsItemPeiLine.setJldw(csvRecord.get("JLDW"));
			 */

			pmsItemPeiLine.setZzsmc(csvRecord.get("制造商名称"));
			pmsItemPeiLine.setSsxlbdz(csvRecord.get("所属线路名称"));
			pmsItemPeiLine.setSbxh(csvRecord.get("设备型号"));
			if (csvRecord.get("投运年份").trim().isEmpty()) {
				pmsItemPeiLine.setTynf(new Short("0"));
			} else {
				pmsItemPeiLine.setTynf(new Short(csvRecord.get("投运年份")));
			}
			pmsItemPeiLine.setNnd(csvRecord.get("年龄段"));
			if (!csvRecord.get("投运日期").trim().isEmpty()) {
				pmsItemPeiLine.setTyrq(DateFormatUtil.parseDate(csvRecord.get("投运日期")));
			}
			if (csvRecord.get("年龄").trim().isEmpty()) {
				pmsItemPeiLine.setNn(new Short("0"));
			} else {
				pmsItemPeiLine.setNn(new Short(csvRecord.get("年龄")));
			}

			pmsItemPeiLine.setQfzd(csvRecord.get("区分字段"));
			if (!csvRecord.get("出厂日期").trim().isEmpty()) {
				pmsItemPeiLine.setCcrq(DateFormatUtil.parseDate(csvRecord.get("出厂日期")));
			}

			pmsItemPeiLine.setEquipmentName(csvRecord.get("设备名称"));

			pmsItemPeiLine.setAssetId(csvRecord.get("实物ID"));
			pmsItemPeiLine.setEquipmentIncreaseMode(csvRecord.get("设备增加方式"));
			pmsItemPeiLine.setLineProperty(csvRecord.get("线路性质"));
			// pmsItemPeiLine.setJldw(csvRecord.get("计量单位"));

			session.save(pmsItemPeiLine);

			/*
			 * pmsItemPeiLine.setSbbm(csvRecord.get("SBBM"));
			 * pmsItemPeiLine.setDwmx(csvRecord.get("DWMX"));
			 * pmsItemPeiLine.setYwdw(csvRecord.get("YWDW"));
			 * pmsItemPeiLine.setZckbm(csvRecord.get("ZCKBM"));
			 * pmsItemPeiLine.setSblx(csvRecord.get("SBLX")); if
			 * (csvRecord.get("ZCYZ").trim().isEmpty()) { pmsItemPeiLine.setZcyz(new
			 * Double(0.0)); } else { pmsItemPeiLine.setZcyz(new
			 * Double(csvRecord.get("ZCYZ"))); }
			 * pmsItemPeiLine.setZcdl(csvRecord.get("ZCDL"));
			 * pmsItemPeiLine.setZclxbm(csvRecord.get("ZCLXBM"));
			 * pmsItemPeiLine.setCwbm(csvRecord.get("CWBM"));
			 * pmsItemPeiLine.setDydj(csvRecord.get("DYDJ"));
			 * pmsItemPeiLine.setYxzt(csvRecord.get("YXZT"));
			 * pmsItemPeiLine.setJkzt(csvRecord.get("JKZT")); if
			 * (!csvRecord.get("ZJTYRQ").trim().isEmpty()) { try {
			 * pmsItemPeiLine.setZjtyrq(simpleDateFormat.parse(csvRecord.get("ZJTYRQ"))); }
			 * catch (ParseException e) { e.printStackTrace(); } }
			 * pmsItemPeiLine.setZcxz(csvRecord.get("ZCXZ"));
			 * 
			 * if (!(null == csvRecord.get("SL"))) { if
			 * (csvRecord.get("SL").trim().isEmpty()) { pmsItemPeiLine.setSl(new
			 * Double(0.0)); } else { try {
			 * pmsItemPeiLine.setSl(df.parse(csvRecord.get("SL")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } }
			 * 
			 * try { if (!(null == csvRecord.get("SL1"))) { if
			 * (csvRecord.get("SL1").trim().isEmpty()) { pmsItemPeiLine.setSl1(new
			 * Double(0.0)); } else { try {
			 * pmsItemPeiLine.setSl1(df.parse(csvRecord.get("SL1")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } } } catch (Exception e) { // TODO: handle exception if (!(null ==
			 * csvRecord.get("CABLE_LINE_LENGTH"))) { if
			 * (csvRecord.get("CABLE_LINE_LENGTH").trim().isEmpty()) {
			 * pmsItemPeiLine.setSl1(new Double(0.0)); } else { try {
			 * pmsItemPeiLine.setSl1(df.parse(csvRecord.get("CABLE_LINE_LENGTH")).
			 * doubleValue()); } catch (ParseException e1) { // TODO Auto-generated catch
			 * block e1.printStackTrace(); } } } } try { if (!(null ==
			 * csvRecord.get("SL2"))) { if (csvRecord.get("SL2").trim().isEmpty()) {
			 * pmsItemPeiLine.setSl2(new Double(0.0)); } else { try {
			 * pmsItemPeiLine.setSl2(df.parse(csvRecord.get("SL2")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } } } catch (Exception e) { // TODO: handle exception if (!(null ==
			 * csvRecord.get("OVERHEAD_LINE_LENGTH"))) { if
			 * (csvRecord.get("OVERHEAD_LINE_LENGTH").trim().isEmpty()) {
			 * pmsItemPeiLine.setSl2(new Double(0.0)); } else { try {
			 * pmsItemPeiLine.setSl2(df.parse(csvRecord.get("OVERHEAD_LINE_LENGTH")).
			 * doubleValue()); } catch (ParseException e1) { // TODO Auto-generated catch
			 * block e1.printStackTrace(); } } } }
			 * 
			 * pmsItemPeiLine.setZzsmc(csvRecord.get("ZZSMC"));
			 * pmsItemPeiLine.setSsxlbdz(csvRecord.get("SSXLBDZ"));
			 * pmsItemPeiLine.setSbxh(csvRecord.get("SBXH")); if
			 * (csvRecord.get("TYNF").trim().isEmpty()) { pmsItemPeiLine.setTynf(new
			 * Short("0")); } else { pmsItemPeiLine.setTynf(new
			 * Short(csvRecord.get("TYNF"))); } pmsItemPeiLine.setNnd(csvRecord.get("NND"));
			 * if (!csvRecord.get("TYRQ").trim().isEmpty()) { try {
			 * pmsItemPeiLine.setTyrq(simpleDateFormat.parse(csvRecord.get("TYRQ"))); }
			 * catch (ParseException e) { e.printStackTrace(); } } if
			 * (csvRecord.get("NN").trim().isEmpty()) { pmsItemPeiLine.setNn(new
			 * Short("0")); } else { pmsItemPeiLine.setNn(new Short(csvRecord.get("NN"))); }
			 * 
			 * pmsItemPeiLine.setQfzd(csvRecord.get("QFZD")); if
			 * (!csvRecord.get("CCRQ").trim().isEmpty()) { try {
			 * pmsItemPeiLine.setCcrq(simpleDateFormat.parse(csvRecord.get("CCRQ"))); }
			 * catch (ParseException e) { e.printStackTrace(); } }
			 * 
			 * pmsItemPeiLine.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			 * 
			 * pmsItemPeiLine.setAssetId(csvRecord.get("ASSET_ID"));
			 * pmsItemPeiLine.setEquipmentIncreaseMode(csvRecord.get(
			 * "EQUIPMENT_INCREASE_MODE")); pmsItemPeiLine.setDataSourceFile(pathStr);
			 * 
			 * session.save(pmsItemPeiLine);
			 * 
			 */
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriTechRenovaProjEquipAdd(String pathStr, String dataVersion, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriTechRenovaProjEquip oriTechRenovaProjEquip = new OriTechRenovaProjEquip();

			oriTechRenovaProjEquip.setDataVersion(dataVersion);
			oriTechRenovaProjEquip.setCalYear(DateFormatUtil.parseDate(calYear));
			oriTechRenovaProjEquip.setObjId(csvRecord.get("OBJ_ID"));
			oriTechRenovaProjEquip.setLocalCity(csvRecord.get("LOCAL_CITY"));
			oriTechRenovaProjEquip.setEntryName(csvRecord.get("ENTRY_NAME"));
			oriTechRenovaProjEquip.setPlannedYear(csvRecord.get("PLANNED_YEAR"));
			oriTechRenovaProjEquip.setProjectType(csvRecord.get("PROJECT_TYPE"));
			if (csvRecord.get("ITEM_SCORE").trim().isEmpty()) {
				oriTechRenovaProjEquip.setItemScore(new Double(0.0));
			} else {
				oriTechRenovaProjEquip
						.setItemScore(new DecimalFormat().parse(csvRecord.get("ITEM_SCORE")).doubleValue());
			}
			oriTechRenovaProjEquip.setProfessionalCategory(csvRecord.get("PROFESSIONAL_CATEGORY"));
			oriTechRenovaProjEquip.setProfessionalSegmentation(csvRecord.get("PROFESSIONAL_SEGMENTATION"));
			oriTechRenovaProjEquip.setProjectContent(csvRecord.get("PROJECT_CONTENT"));
			oriTechRenovaProjEquip.setTransformationPurpose(csvRecord.get("TRANSFORMATION_PURPOSE"));
			oriTechRenovaProjEquip.setProjectVoltageLevel(csvRecord.get("PROJECT_VOLTAGE_LEVEL"));
			oriTechRenovaProjEquip.setProjectDocumentNo(csvRecord.get("PROJECT_DOCUMENT_NO"));
			if (csvRecord.get("CURRENT_YEAR_FUNDS").trim().isEmpty()) {
				oriTechRenovaProjEquip.setCurrentYearFunds(new Double(0.0));
			} else {
				oriTechRenovaProjEquip.setCurrentYearFunds(
						new DecimalFormat().parse(csvRecord.get("CURRENT_YEAR_FUNDS")).doubleValue());
			}
			if (csvRecord.get("TOTAL_INVESTMENT").trim().isEmpty()) {
				oriTechRenovaProjEquip.setTotalInvestment(new Double(0.0));
			} else {
				oriTechRenovaProjEquip
						.setTotalInvestment(new DecimalFormat().parse(csvRecord.get("TOTAL_INVESTMENT")).doubleValue());
			}
			oriTechRenovaProjEquip.setAssetProperty(csvRecord.get("ASSET_PROPERTY"));
			if (!(csvRecord.get("PROJECT_START_TIME").trim().isEmpty())) {
				oriTechRenovaProjEquip
						.setProjectStartTime(DateFormatUtil.parseDate(csvRecord.get("PROJECT_START_TIME")));

			}
			if (!(csvRecord.get("PROJECT_END_TIME").trim().isEmpty())) {
				oriTechRenovaProjEquip.setProjectEndTime(DateFormatUtil.parseDate(csvRecord.get("PROJECT_END_TIME")));

			}
			oriTechRenovaProjEquip.setRuralPowerNetwork(csvRecord.get("RURAL_POWER_NETWORK"));
			oriTechRenovaProjEquip.setTransformationReasons(csvRecord.get("TRANSFORMATION_REASONS"));
			oriTechRenovaProjEquip.setEquipmentType(csvRecord.get("EQUIPMENT_TYPE"));
			oriTechRenovaProjEquip.setEquipmentCode(csvRecord.get("EQUIPMENT_CODE"));
			oriTechRenovaProjEquip.setEquipmentVoltageLevel(csvRecord.get("EQUIPMENT_VOLTAGE_LEVEL"));
			oriTechRenovaProjEquip.setEquipmentModel(csvRecord.get("EQUIPMENT_MODEL"));
			if (!(csvRecord.get("OPERATION_DATE").trim().isEmpty())) {
				oriTechRenovaProjEquip.setOperationDate(DateFormatUtil.parseDate(csvRecord.get("OPERATION_DATE")));
			}
			if (csvRecord.get("EQUIPMENT_CAPACITY").trim().isEmpty()) {
				oriTechRenovaProjEquip.setEquipmentCapacity(new Double(0.0));
			} else {
				oriTechRenovaProjEquip.setEquipmentCapacity(
						new DecimalFormat().parse(csvRecord.get("EQUIPMENT_CAPACITY")).doubleValue());
			}
			oriTechRenovaProjEquip.setSubstationLineName(csvRecord.get("SUBSTATION_LINE_NAME"));
			oriTechRenovaProjEquip.setDataSourceFile(pathStr);

			session.save(oriTechRenovaProjEquip);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriValidatTechRenovaProjAdd(String pathStr, String dataVersion, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriValidatTechRenovaProj oriValidatTechRenovaProj = new OriValidatTechRenovaProj();
			oriValidatTechRenovaProj.setDataVersion(dataVersion);
			oriValidatTechRenovaProj.setCalYear(DateFormatUtil.parseDate(calYear));
			oriValidatTechRenovaProj.setProjectNo(csvRecord.get("PROJECT_NO"));
			oriValidatTechRenovaProj.setCompany(csvRecord.get("COMPANY"));
			oriValidatTechRenovaProj.setProjectName(csvRecord.get("PROJECT_NAME"));
			oriValidatTechRenovaProj.setProjectContent(csvRecord.get("PROJECT_CONTENT"));
			oriValidatTechRenovaProj.setProjectType(csvRecord.get("PROJECT_TYPE"));
			oriValidatTechRenovaProj.setProfessionalCategory(csvRecord.get("PROFESSIONAL_CATEGORY"));
			oriValidatTechRenovaProj.setProfessionalSegmentation(csvRecord.get("PROFESSIONAL_SEGMENTATION"));
			oriValidatTechRenovaProj.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			if (!(csvRecord.get("PROJECT_START_TIME").trim().isEmpty())) {
				oriValidatTechRenovaProj
						.setProjectStartTime(DateFormatUtil.parseDate(csvRecord.get("PROJECT_START_TIME")));
			}
			if (!(csvRecord.get("PROJECT_END_TIME").trim().isEmpty())) {
				oriValidatTechRenovaProj.setProjectEndTime(DateFormatUtil.parseDate(csvRecord.get("PROJECT_END_TIME")));
			}
			oriValidatTechRenovaProj.setResponsibleDepartment(csvRecord.get("RESPONSIBLE_DEPARTMENT"));
			if (csvRecord.get("CURRENT_YEAR_FUNDS").trim().isEmpty()) {
				oriValidatTechRenovaProj.setCurrentYearFunds(new Double(0.0));
			} else {
				oriValidatTechRenovaProj.setCurrentYearFunds(
						new DecimalFormat().parse(csvRecord.get("CURRENT_YEAR_FUNDS")).doubleValue());
			}
			if (csvRecord.get("TOTAL_INVESTMENT").trim().isEmpty()) {
				oriValidatTechRenovaProj.setTotalInvestment(new Double(0.0));
			} else {
				oriValidatTechRenovaProj
						.setTotalInvestment(new DecimalFormat().parse(csvRecord.get("TOTAL_INVESTMENT")).doubleValue());
			}
			oriValidatTechRenovaProj.setAssetProperty(csvRecord.get("ASSET_PROPERTY"));
			oriValidatTechRenovaProj.setTransformationPurpose(csvRecord.get("TRANSFORMATION_PURPOSE"));
			oriValidatTechRenovaProj.setDataSourceFile(pathStr);

			session.save(oriValidatTechRenovaProj);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void insertInToDVersion(DVersion dV) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		// 需要检查一下，将要插入的数据版本在表中是否存在，如果存在则将版本编号增长一位，并重新检查是否仍然存在，直至不存在则执行插入动作。
		// session.createSQLQuery(arg0);
		boolean existsOrNot = ExportDao.dataVersionCheck(dV.getTargetTable(), dV.getVersionValue());
		//System.out.println("dV.getTargetTable()="+dV.getTargetTable()+",dV.getVersionValue()="+dV.getVersionValue());
		if (!existsOrNot) {
			dV.setVersionStatus("1");
			dV.setGenerateDate(new Date());
			session.save(dV);
			tx.commit();
			session.clear();
			sf.close();
		} else {
			//System.out.println("dV.getTargetTable()="+dV.getTargetTable()+",dV.getVersionValue()="+dV.getVersionValue());
			String versionValue = ExportDao.getMaxDataVersion(dV.getTargetTable(), dV.getVersionValue());
			dV.setVersionStatus("1");
			dV.setGenerateDate(new Date());
			dV.setSubVersion(new Short(versionValue.substring(versionValue.lastIndexOf("_") + 1)));
			dV.setVersionValue(versionValue);
			//System.out.println("dV.getTargetTable()="+dV.getTargetTable()+",dV.getVersionValue()="+dV.getVersionValue());
			insertInToDVersion(dV);
		}
	}

	public static void insertInToDVersion(String targetTable, String dataVersion, String pathStr, String parentVersion,
			String discription, String method) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		// 需要检查一下，将要插入的数据版本在表中是否存在，如果存在则将版本编号增长一位，并重新检查是否仍然存在，直至不存在则执行插入动作。
		// session.createSQLQuery(arg0);
		boolean existsOrNot = ExportDao.dataVersionCheck(targetTable, dataVersion);
		if (!existsOrNot) {
			DVersion dVersion = new DVersion();
			dVersion.setVersionValue(dataVersion);
			dVersion.setTargetTable(targetTable);
			dVersion.setDataType(dataVersion.substring(0, dataVersion.indexOf("_")));
			dVersion.setYearValue(
					new Short(dataVersion.substring(dataVersion.indexOf("_") + 1, dataVersion.indexOf("_") + 5)));
			dVersion.setSubVersion(new Short(dataVersion.substring(dataVersion.lastIndexOf("_") + 1)));
			dVersion.setVersionStatus("1");
			dVersion.setParentVersion(parentVersion);
			dVersion.setGenerateDate(new Date());
			dVersion.setFileName(pathStr);
			dVersion.setDiscription(discription);
			dVersion.setProcedureName(method);
			session.save(dVersion);
			tx.commit();
			session.clear();
			sf.close();
		} else {
			String versionValue = ExportDao.getMaxDataVersion(targetTable, dataVersion);
			insertInToDVersion(targetTable, versionValue, pathStr, parentVersion, discription, method);
		}
	}

	public static void csvOriTechRenovaProjectAdd(String pathStr, String dataVersion, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriTechRenovationProject oriTechRenovationProject = new OriTechRenovationProject();
			oriTechRenovationProject.setDataVersion(dataVersion);
			oriTechRenovationProject.setCalYear(DateFormatUtil.parseDate(calYear));
			oriTechRenovationProject.setObjId(csvRecord.get("OBJ_ID"));
			oriTechRenovationProject.setLocalCity(csvRecord.get("LOCAL_CITY"));
			oriTechRenovationProject.setProjectName(csvRecord.get("PROJECT_NAME"));
			oriTechRenovationProject.setPlannedYear(csvRecord.get("PLANNED_YEAR"));
			oriTechRenovationProject.setProjectType(csvRecord.get("PROJECT_TYPE"));
			if (csvRecord.get("PROJECT_SCORE").trim().isEmpty()) {
				oriTechRenovationProject.setProjectScore(new Double(0.0));
			} else {
				oriTechRenovationProject
						.setProjectScore(new DecimalFormat().parse(csvRecord.get("PROJECT_SCORE")).doubleValue());
			}
			oriTechRenovationProject.setProfessionalCategory(csvRecord.get("PROFESSIONAL_CATEGORY"));
			oriTechRenovationProject.setProfessionalSubspecialty(csvRecord.get("PROFESSIONAL_SUBSPECIALTY"));
			oriTechRenovationProject.setProjectContent(csvRecord.get("PROJECT_CONTENT"));

			oriTechRenovationProject.setRenovationPurpose(csvRecord.get("RENOVATION_PURPOSE"));
			oriTechRenovationProject.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			oriTechRenovationProject.setProjectDocumentNo(csvRecord.get("PROJECT_DOCUMENT_NO"));
			if (csvRecord.get("CURRENT_YEAR_FUNDS").trim().isEmpty()) {
				oriTechRenovationProject.setCurrentYearFunds(new Double(0.0));
			} else {
				oriTechRenovationProject.setCurrentYearFunds(
						new DecimalFormat().parse(csvRecord.get("CURRENT_YEAR_FUNDS")).doubleValue());
			}
			if (csvRecord.get("TOTAL_INVESTMENT").trim().isEmpty()) {
				oriTechRenovationProject.setTotalInvestment(new Double(0.0));
			} else {
				oriTechRenovationProject
						.setTotalInvestment(new DecimalFormat().parse(csvRecord.get("TOTAL_INVESTMENT")).doubleValue());
			}
			oriTechRenovationProject.setAssetNature(csvRecord.get("ASSET_NATURE"));
			if (!(csvRecord.get("PROJECT_START_TIME").trim().isEmpty())) {
				oriTechRenovationProject
						.setProjectStartTime(DateFormatUtil.parseDate(csvRecord.get("PROJECT_START_TIME")));
			}
			if (!(csvRecord.get("PROJECT_END_TIME").trim().isEmpty())) {
				oriTechRenovationProject.setProjectEndTime(DateFormatUtil.parseDate(csvRecord.get("PROJECT_END_TIME")));
			}
			oriTechRenovationProject.setRuralPowerNetwork(csvRecord.get("RURAL_POWER_NETWORK"));
			oriTechRenovationProject.setPreparedPerson(csvRecord.get("PREPARED_PERSON"));
			oriTechRenovationProject.setProjectBasis(csvRecord.get("PROJECT_BASIS"));
			oriTechRenovationProject.setRenovationReasons(csvRecord.get("RENOVATION_REASONS"));
			oriTechRenovationProject.setFeasibStudyReviewDocNo(csvRecord.get("FEASIB_STUDY_REVIEW_DOC_NO"));
			oriTechRenovationProject.setFeasibStudyApproReplyNo(csvRecord.get("FEASIB_STUDY_APPRO_REPLY_NO"));
			oriTechRenovationProject.setFeasibStudyReviewComments(csvRecord.get("FEASIB_STUDY_REVIEW_COMMENTS"));
			oriTechRenovationProject.setFeasibStudyApprovalDocument(csvRecord.get("FEASIB_STUDY_APPROVAL_DOCUMENT"));
			oriTechRenovationProject.setProjectNature(csvRecord.get("PROJECT_NATURE"));
			oriTechRenovationProject.setDataSourceFile(pathStr);

			session.save(oriTechRenovationProject);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOSwitchCabinetCollectAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OSwitchCabinetCollect oSwitchCabinetCollect = new OSwitchCabinetCollect();
			oSwitchCabinetCollect.setDataVersion(versionValue);
			oSwitchCabinetCollect.setCalYear(DateFormatUtil.parseDate(calYear));
			oSwitchCabinetCollect.setDataSourceFile(pathStr);
			oSwitchCabinetCollect.setProjectType(csvRecord.get("PROJECT_TYPE"));
			oSwitchCabinetCollect.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			oSwitchCabinetCollect.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			oSwitchCabinetCollect.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			if (!(csvRecord.get("OPERATION_DATE").trim().isEmpty())) {
				oSwitchCabinetCollect.setOperationDate(DateFormatUtil.parseDate(csvRecord.get("OPERATION_DATE")));
			}
			oSwitchCabinetCollect.setInsulatingMedium(csvRecord.get("INSULATING_MEDIUM"));
			oSwitchCabinetCollect.setStructureType(csvRecord.get("STRUCTURE_TYPE"));
			oSwitchCabinetCollect.setWhetherRuralPowerNetwork(csvRecord.get("WHETHER_RURAL_POWER_NETWORK"));
			oSwitchCabinetCollect.setRatedVoltage(csvRecord.get("RATED_VOLTAGE"));
			if (csvRecord.get("RATED_CURRENT").trim().isEmpty()) {
				oSwitchCabinetCollect.setRatedCurrent(new Double(0.0));
			} else {
				oSwitchCabinetCollect
						.setRatedCurrent(new DecimalFormat().parse(csvRecord.get("RATED_CURRENT")).doubleValue());
			}
			if (csvRecord.get("RATED_FREQUENCY").trim().isEmpty()) {
				oSwitchCabinetCollect.setRatedFrequency(new Double(0.0));
			} else {
				oSwitchCabinetCollect
						.setRatedFrequency(new DecimalFormat().parse(csvRecord.get("RATED_FREQUENCY")).doubleValue());
			}
			oSwitchCabinetCollect.setAssetId(csvRecord.get("ASSET_ID"));
			oSwitchCabinetCollect.setPhysicalId(csvRecord.get("PHYSICAL_ID"));
			oSwitchCabinetCollect.setPmId(csvRecord.get("PM_ID"));
			oSwitchCabinetCollect.setBelongLocalCityCompany(csvRecord.get("BELONG_LOCAL_CITY_COMPANY"));
			oSwitchCabinetCollect.setBelongSubstation(csvRecord.get("BELONG_SUBSTATION"));
			oSwitchCabinetCollect.setUseEnvironment(csvRecord.get("USE_ENVIRONMENT"));
			if (csvRecord.get("WORKING_AGE").trim().isEmpty()) {
				oSwitchCabinetCollect.setWorkingAge(new Double(0.0));
			} else {
				oSwitchCabinetCollect
						.setWorkingAge(new DecimalFormat().parse(csvRecord.get("WORKING_AGE")).doubleValue());
			}
			if (csvRecord.get("LIFE_CYCLE").trim().isEmpty()) {
				oSwitchCabinetCollect.setLifeCycle(new Double(0.0));
			} else {
				oSwitchCabinetCollect
						.setLifeCycle(new DecimalFormat().parse(csvRecord.get("LIFE_CYCLE")).doubleValue());
			}
			if (csvRecord.get("AVERAGE_ANNUAL_INTEREST_RATE").trim().isEmpty()) {
				oSwitchCabinetCollect.setAverageAnnualInterestRate(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setAverageAnnualInterestRate(
						new DecimalFormat().parse(csvRecord.get("AVERAGE_ANNUAL_INTEREST_RATE")).doubleValue());
			}
			if (csvRecord.get("LIFE_CYCLE_COST").trim().isEmpty()) {
				oSwitchCabinetCollect.setLifeCycleCost(new Double(0.0));
			} else {
				oSwitchCabinetCollect
						.setLifeCycleCost(new DecimalFormat().parse(csvRecord.get("LIFE_CYCLE_COST")).doubleValue());
			}
			if (csvRecord.get("LCC_INI_INVES_COST_EQUIP_VALUE").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccIniInvesCostEquipValue(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccIniInvesCostEquipValue(
						new DecimalFormat().parse(csvRecord.get("LCC_INI_INVES_COST_EQUIP_VALUE")).doubleValue());
			}
			if (csvRecord.get("LCC_INI_INVES_COST_INSTAL_COST").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccIniInvesCostInstalCost(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccIniInvesCostInstalCost(
						new DecimalFormat().parse(csvRecord.get("LCC_INI_INVES_COST_INSTAL_COST")).doubleValue());
			}
			if (csvRecord.get("LCC_INI_INVEMENT_COST_OTHERS").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccIniInvementCostOthers(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccIniInvementCostOthers(
						new DecimalFormat().parse(csvRecord.get("LCC_INI_INVEMENT_COST_OTHERS")).doubleValue());
			}
			if (csvRecord.get("LCC_TOTAL_INI_INVESTMENT_COST").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccTotalIniInvestmentCost(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccTotalIniInvestmentCost(
						new DecimalFormat().parse(csvRecord.get("LCC_TOTAL_INI_INVESTMENT_COST")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_17").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpPatro17(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpPatro17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_18").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpPatro18(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpPatro18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_19").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpPatro19(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpPatro19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_20").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpPatro20(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpPatro20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_21").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpPatro21(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpPatro21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_17").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpEchec17(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpEchec17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_18").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpEchec18(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpEchec18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_19").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpEchec19(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpEchec19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_20").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpEchec20(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpEchec20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_21").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpEchec21(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpEchec21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_17").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpeTota17(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpeTota17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_18").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpeTota18(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpeTota18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_19").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpeTota19(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpeTota19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_20").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpeTota20(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpeTota20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_21").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnOpeTota21(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnOpeTota21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_17").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepOver17(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepOver17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_18").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepOver18(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepOver18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_19").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepOver19(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepOver19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_20").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepOver20(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepOver20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_21").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepOver21(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepOver21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_17").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepDefe17(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepDefe17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_18").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepDefe18(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepDefe18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_19").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepDefe19(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepDefe19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_20").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepDefe20(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepDefe20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_21").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepDefe21(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepDefe21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_17").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepTota17(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepTota17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_18").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepTota18(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepTota18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_19").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepTota19(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepTota19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_20").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepTota20(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepTota20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_21").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnRepTota21(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnRepTota21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_17").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnFaiCost17(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnFaiCost17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_18").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnFaiCost18(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnFaiCost18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_19").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnFaiCost19(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnFaiCost19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_20").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnFaiCost20(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnFaiCost20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_21").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintAnnFaiCost21(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintAnnFaiCost21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2017").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintTotalCost2017(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintTotalCost2017(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2017")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2018").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintTotalCost2018(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintTotalCost2018(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2018")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2019").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintTotalCost2019(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintTotalCost2019(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2019")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2020").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintTotalCost2020(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintTotalCost2020(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2020")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2021").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintTotalCost2021(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintTotalCost2021(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2021")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_COST_LATEST_5Y").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccOperMaintCostLatest5y(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccOperMaintCostLatest5y(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_COST_LATEST_5Y")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2017").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccTechTransformaInves2017(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccTechTransformaInves2017(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2017")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2018").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccTechTransformaInves2018(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccTechTransformaInves2018(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2018")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2019").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccTechTransformaInves2019(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccTechTransformaInves2019(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2019")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2020").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccTechTransformaInves2020(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccTechTransformaInves2020(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2020")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2021").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccTechTransformaInves2021(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccTechTransformaInves2021(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2021")).doubleValue());
			}
			if (csvRecord.get("LCC_ABANDON_COST_DISPOS_INCOME").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccAbandonCostDisposIncome(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccAbandonCostDisposIncome(
						new DecimalFormat().parse(csvRecord.get("LCC_ABANDON_COST_DISPOS_INCOME")).doubleValue());
			}
			if (csvRecord.get("LCC_ABANDON_COST_DISPOS_COST").trim().isEmpty()) {
				oSwitchCabinetCollect.setLccAbandonCostDisposCost(new Double(0.0));
			} else {
				oSwitchCabinetCollect.setLccAbandonCostDisposCost(
						new DecimalFormat().parse(csvRecord.get("LCC_ABANDON_COST_DISPOS_COST")).doubleValue());
			}
			session.save(oSwitchCabinetCollect);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOPowerCapacitorCollectAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OPowerCapacitorCollect oPowerCapacitorCollect = new OPowerCapacitorCollect();
			oPowerCapacitorCollect.setDataVersion(versionValue);
			oPowerCapacitorCollect.setDataSourceFile(pathStr);
			oPowerCapacitorCollect.setCalYear(DateFormatUtil.parseDate(calYear));
			oPowerCapacitorCollect.setProjectType(csvRecord.get("PROJECT_TYPE"));
			oPowerCapacitorCollect.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			oPowerCapacitorCollect.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			oPowerCapacitorCollect.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			if (!(csvRecord.get("OPERATION_DATE").trim().isEmpty())) {
				oPowerCapacitorCollect.setOperationDate(DateFormatUtil.parseDate(csvRecord.get("OPERATION_DATE")));
			}
			oPowerCapacitorCollect.setInsulatingMedium(csvRecord.get("INSULATING_MEDIUM"));
			oPowerCapacitorCollect.setInstallationMode(csvRecord.get("INSTALLATION_MODE"));
			oPowerCapacitorCollect.setAccessMode(csvRecord.get("ACCESS_MODE"));
			oPowerCapacitorCollect.setWiringMode(csvRecord.get("WIRING_MODE"));
			oPowerCapacitorCollect.setWhetherRuralPowerNetwork(csvRecord.get("WHETHER_RURAL_POWER_NETWORK"));
			oPowerCapacitorCollect.setRatedVoltage(csvRecord.get("RATED_VOLTAGE"));
			if (csvRecord.get("RATED_CURRENT").trim().isEmpty()) {
				oPowerCapacitorCollect.setRatedCurrent(new Double(0.0));
			} else {
				oPowerCapacitorCollect
						.setRatedCurrent(new DecimalFormat().parse(csvRecord.get("RATED_CURRENT")).doubleValue());
			}
			if (csvRecord.get("RATED_FREQUENCY").trim().isEmpty()) {
				oPowerCapacitorCollect.setRatedFrequency(new Double(0.0));
			} else {
				oPowerCapacitorCollect
						.setRatedFrequency(new DecimalFormat().parse(csvRecord.get("RATED_FREQUENCY")).doubleValue());
			}
			if (csvRecord.get("SINGLE_CAPACITY").trim().isEmpty()) {
				oPowerCapacitorCollect.setSingleCapacity(new Double(0.0));
			} else {
				oPowerCapacitorCollect
						.setSingleCapacity(new DecimalFormat().parse(csvRecord.get("SINGLE_CAPACITY")).doubleValue());
			}
			if (csvRecord.get("CAPACITANCE_VALUE").trim().isEmpty()) {
				oPowerCapacitorCollect.setCapacitanceValue(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setCapacitanceValue(
						new DecimalFormat().parse(csvRecord.get("CAPACITANCE_VALUE")).doubleValue());
			}
			oPowerCapacitorCollect.setAssetId(csvRecord.get("ASSET_ID"));
			oPowerCapacitorCollect.setPhysicalId(csvRecord.get("PHYSICAL_ID"));
			oPowerCapacitorCollect.setPmId(csvRecord.get("PM_ID"));
			oPowerCapacitorCollect.setBelongLocalCityCompany(csvRecord.get("BELONG_LOCAL_CITY_COMPANY"));
			oPowerCapacitorCollect.setBelongSubstation(csvRecord.get("BELONG_SUBSTATION"));
			oPowerCapacitorCollect.setUseEnvironment(csvRecord.get("USE_ENVIRONMENT"));
			if (csvRecord.get("WORKING_AGE").trim().isEmpty()) {
				oPowerCapacitorCollect.setWorkingAge(new Double(0.0));
			} else {
				oPowerCapacitorCollect
						.setWorkingAge(new DecimalFormat().parse(csvRecord.get("WORKING_AGE")).doubleValue());
			}
			if (csvRecord.get("LIFE_CYCLE").trim().isEmpty()) {
				oPowerCapacitorCollect.setLifeCycle(new Double(0.0));
			} else {
				oPowerCapacitorCollect
						.setLifeCycle(new DecimalFormat().parse(csvRecord.get("LIFE_CYCLE")).doubleValue());
			}
			if (csvRecord.get("AVERAGE_ANNUAL_INTEREST_RATE").trim().isEmpty()) {
				oPowerCapacitorCollect.setAverageAnnualInterestRate(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setAverageAnnualInterestRate(
						new DecimalFormat().parse(csvRecord.get("AVERAGE_ANNUAL_INTEREST_RATE")).doubleValue());
			}
			if (csvRecord.get("LIFE_CYCLE_COST").trim().isEmpty()) {
				oPowerCapacitorCollect.setLifeCycleCost(new Double(0.0));
			} else {
				oPowerCapacitorCollect
						.setLifeCycleCost(new DecimalFormat().parse(csvRecord.get("LIFE_CYCLE_COST")).doubleValue());
			}
			if (csvRecord.get("LCC_INI_INVES_COST_EQUIP_VALUE").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccIniInvesCostEquipValue(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccIniInvesCostEquipValue(
						new DecimalFormat().parse(csvRecord.get("LCC_INI_INVES_COST_EQUIP_VALUE")).doubleValue());
			}
			if (csvRecord.get("LCC_INI_INVES_COST_INSTAL_COST").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccIniInvesCostInstalCost(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccIniInvesCostInstalCost(
						new DecimalFormat().parse(csvRecord.get("LCC_INI_INVES_COST_INSTAL_COST")).doubleValue());
			}
			if (csvRecord.get("LCC_INI_INVEMENT_COST_OTHERS").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccIniInvementCostOthers(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccIniInvementCostOthers(
						new DecimalFormat().parse(csvRecord.get("LCC_INI_INVEMENT_COST_OTHERS")).doubleValue());
			}
			if (csvRecord.get("LCC_TOTAL_INI_INVESTMENT_COST").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccTotalIniInvestmentCost(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccTotalIniInvestmentCost(
						new DecimalFormat().parse(csvRecord.get("LCC_TOTAL_INI_INVESTMENT_COST")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_17").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpPatro17(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpPatro17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_18").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpPatro18(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpPatro18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_19").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpPatro19(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpPatro19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_20").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpPatro20(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpPatro20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_21").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpPatro21(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpPatro21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_17").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpEchec17(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpEchec17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_18").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpEchec18(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpEchec18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_19").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpEchec19(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpEchec19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_20").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpEchec20(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpEchec20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_21").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpEchec21(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpEchec21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_17").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpeTota17(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpeTota17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_18").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpeTota18(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpeTota18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_19").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpeTota19(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpeTota19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_20").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpeTota20(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpeTota20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_21").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnOpeTota21(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnOpeTota21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_17").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepOver17(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepOver17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_18").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepOver18(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepOver18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_19").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepOver19(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepOver19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_20").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepOver20(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepOver20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_21").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepOver21(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepOver21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_17").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepDefe17(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepDefe17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_18").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepDefe18(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepDefe18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_19").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepDefe19(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepDefe19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_20").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepDefe20(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepDefe20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_21").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepDefe21(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepDefe21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_17").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepTota17(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepTota17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_18").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepTota18(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepTota18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_19").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepTota19(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepTota19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_20").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepTota20(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepTota20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_21").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnRepTota21(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnRepTota21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_17").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnFaiCost17(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnFaiCost17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_18").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnFaiCost18(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnFaiCost18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_19").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnFaiCost19(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnFaiCost19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_20").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnFaiCost20(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnFaiCost20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_21").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintAnnFaiCost21(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintAnnFaiCost21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2017").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintTotalCost2017(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintTotalCost2017(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2017")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2018").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintTotalCost2018(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintTotalCost2018(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2018")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2019").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintTotalCost2019(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintTotalCost2019(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2019")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2020").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintTotalCost2020(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintTotalCost2020(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2020")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2021").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintTotalCost2021(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintTotalCost2021(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2021")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_COST_LATEST_5Y").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccOperMaintCostLatest5y(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccOperMaintCostLatest5y(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_COST_LATEST_5Y")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2017").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccTechTransformaInves2017(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccTechTransformaInves2017(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2017")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2018").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccTechTransformaInves2018(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccTechTransformaInves2018(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2018")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2019").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccTechTransformaInves2019(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccTechTransformaInves2019(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2019")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2020").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccTechTransformaInves2020(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccTechTransformaInves2020(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2020")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2021").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccTechTransformaInves2021(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccTechTransformaInves2021(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2021")).doubleValue());
			}
			if (csvRecord.get("LCC_ABANDON_COST_DISPOS_INCOME").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccAbandonCostDisposIncome(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccAbandonCostDisposIncome(
						new DecimalFormat().parse(csvRecord.get("LCC_ABANDON_COST_DISPOS_INCOME")).doubleValue());
			}
			if (csvRecord.get("LCC_ABANDON_COST_DISPOS_COST").trim().isEmpty()) {
				oPowerCapacitorCollect.setLccAbandonCostDisposCost(new Double(0.0));
			} else {
				oPowerCapacitorCollect.setLccAbandonCostDisposCost(
						new DecimalFormat().parse(csvRecord.get("LCC_ABANDON_COST_DISPOS_COST")).doubleValue());
			}
			session.save(oPowerCapacitorCollect);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOElectricReactorCollectAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OElectricReactorCollect oElectricReactorCollect = new OElectricReactorCollect();
			oElectricReactorCollect.setDataVersion(versionValue);
			oElectricReactorCollect.setDataSourceFile(pathStr);
			oElectricReactorCollect.setCalYear(DateFormatUtil.parseDate(calYear));
			oElectricReactorCollect.setProjectType(csvRecord.get("PROJECT_TYPE"));
			oElectricReactorCollect.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			oElectricReactorCollect.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			oElectricReactorCollect.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			if (!(csvRecord.get("OPERATION_DATE").trim().isEmpty())) {
				oElectricReactorCollect.setOperationDate(DateFormatUtil.parseDate(csvRecord.get("OPERATION_DATE")));
			}
			oElectricReactorCollect.setInsulatingMedium(csvRecord.get("INSULATING_MEDIUM"));
			oElectricReactorCollect.setInstallationMode(csvRecord.get("INSTALLATION_MODE"));
			oElectricReactorCollect.setAccessMode(csvRecord.get("ACCESS_MODE"));
			oElectricReactorCollect.setCoolingMode(csvRecord.get("COOLING_MODE"));
			oElectricReactorCollect.setVoltageRegulationMode(csvRecord.get("VOLTAGE_REGULATION_MODE"));
			oElectricReactorCollect.setWhetherRuralPowerNetwork(csvRecord.get("WHETHER_RURAL_POWER_NETWORK"));
			oElectricReactorCollect.setRatedVoltage(csvRecord.get("RATED_VOLTAGE"));
			if (csvRecord.get("RATED_CURRENT").trim().isEmpty()) {
				oElectricReactorCollect.setRatedCurrent(new Double(0.0));
			} else {
				oElectricReactorCollect
						.setRatedCurrent(new DecimalFormat().parse(csvRecord.get("RATED_CURRENT")).doubleValue());
			}
			if (csvRecord.get("RATED_FREQUENCY").trim().isEmpty()) {
				oElectricReactorCollect.setRatedFrequency(new Double(0.0));
			} else {
				oElectricReactorCollect
						.setRatedFrequency(new DecimalFormat().parse(csvRecord.get("RATED_FREQUENCY")).doubleValue());
			}
			if (csvRecord.get("RATED_CAPACITY").trim().isEmpty()) {
				oElectricReactorCollect.setRatedCapacity(new Double(0.0));
			} else {
				oElectricReactorCollect
						.setRatedCapacity(new DecimalFormat().parse(csvRecord.get("RATED_CAPACITY")).doubleValue());
			}
			if (csvRecord.get("RATED_REACTANCE").trim().isEmpty()) {
				oElectricReactorCollect.setRatedReactance(new Double(0.0));
			} else {
				oElectricReactorCollect
						.setRatedReactance(new DecimalFormat().parse(csvRecord.get("RATED_REACTANCE")).doubleValue());
			}
			if (csvRecord.get("RATED_REACTANCE_RATE").trim().isEmpty()) {
				oElectricReactorCollect.setRatedReactanceRate(new Double(0.0));
			} else {
				oElectricReactorCollect.setRatedReactanceRate(
						new DecimalFormat().parse(csvRecord.get("RATED_REACTANCE_RATE")).doubleValue());
			}
			if (csvRecord.get("RATED_INDUCTANCE").trim().isEmpty()) {
				oElectricReactorCollect.setRatedInductance(new Double(0.0));
			} else {
				oElectricReactorCollect
						.setRatedInductance(new DecimalFormat().parse(csvRecord.get("RATED_INDUCTANCE")).doubleValue());
			}
			oElectricReactorCollect.setAssetId(csvRecord.get("ASSET_ID"));
			oElectricReactorCollect.setPhysicalId(csvRecord.get("PHYSICAL_ID"));
			oElectricReactorCollect.setPmId(csvRecord.get("PM_ID"));
			oElectricReactorCollect.setBelongLocalCityCompany(csvRecord.get("BELONG_LOCAL_CITY_COMPANY"));
			oElectricReactorCollect.setBelongSubstation(csvRecord.get("BELONG_SUBSTATION"));
			oElectricReactorCollect.setUseEnvironment(csvRecord.get("USE_ENVIRONMENT"));
			if (csvRecord.get("WORKING_AGE").trim().isEmpty()) {
				oElectricReactorCollect.setWorkingAge(new Double(0.0));
			} else {
				oElectricReactorCollect
						.setWorkingAge(new DecimalFormat().parse(csvRecord.get("WORKING_AGE")).doubleValue());
			}
			if (csvRecord.get("LIFE_CYCLE").trim().isEmpty()) {
				oElectricReactorCollect.setLifeCycle(new Double(0.0));
			} else {
				oElectricReactorCollect
						.setLifeCycle(new DecimalFormat().parse(csvRecord.get("LIFE_CYCLE")).doubleValue());
			}
			if (csvRecord.get("AVERAGE_ANNUAL_INTEREST_RATE").trim().isEmpty()) {
				oElectricReactorCollect.setAverageAnnualInterestRate(new Double(0.0));
			} else {
				oElectricReactorCollect.setAverageAnnualInterestRate(
						new DecimalFormat().parse(csvRecord.get("AVERAGE_ANNUAL_INTEREST_RATE")).doubleValue());
			}
			if (csvRecord.get("LIFE_CYCLE_COST").trim().isEmpty()) {
				oElectricReactorCollect.setLifeCycleCost(new Double(0.0));
			} else {
				oElectricReactorCollect
						.setLifeCycleCost(new DecimalFormat().parse(csvRecord.get("LIFE_CYCLE_COST")).doubleValue());
			}
			if (csvRecord.get("LCC_INI_INVES_COST_EQUIP_VALUE").trim().isEmpty()) {
				oElectricReactorCollect.setLccIniInvesCostEquipValue(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccIniInvesCostEquipValue(
						new DecimalFormat().parse(csvRecord.get("LCC_INI_INVES_COST_EQUIP_VALUE")).doubleValue());
			}
			if (csvRecord.get("LCC_INI_INVES_COST_INSTAL_COST").trim().isEmpty()) {
				oElectricReactorCollect.setLccIniInvesCostInstalCost(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccIniInvesCostInstalCost(
						new DecimalFormat().parse(csvRecord.get("LCC_INI_INVES_COST_INSTAL_COST")).doubleValue());
			}
			if (csvRecord.get("LCC_INI_INVEMENT_COST_OTHERS").trim().isEmpty()) {
				oElectricReactorCollect.setLccIniInvementCostOthers(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccIniInvementCostOthers(
						new DecimalFormat().parse(csvRecord.get("LCC_INI_INVEMENT_COST_OTHERS")).doubleValue());
			}
			if (csvRecord.get("LCC_TOTAL_INI_INVESTMENT_COST").trim().isEmpty()) {
				oElectricReactorCollect.setLccTotalIniInvestmentCost(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccTotalIniInvestmentCost(
						new DecimalFormat().parse(csvRecord.get("LCC_TOTAL_INI_INVESTMENT_COST")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_17").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpPatro17(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpPatro17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_18").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpPatro18(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpPatro18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_19").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpPatro19(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpPatro19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_20").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpPatro20(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpPatro20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_21").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpPatro21(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpPatro21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_PATRO_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_17").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpEchec17(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpEchec17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_18").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpEchec18(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpEchec18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_19").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpEchec19(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpEchec19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_20").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpEchec20(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpEchec20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_21").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpEchec21(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpEchec21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OP_ECHEC_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_17").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpeTota17(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpeTota17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_18").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpeTota18(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpeTota18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_19").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpeTota19(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpeTota19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_20").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpeTota20(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpeTota20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_21").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnOpeTota21(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnOpeTota21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_OPE_TOTA_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_17").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepOver17(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepOver17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_18").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepOver18(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepOver18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_19").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepOver19(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepOver19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_20").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepOver20(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepOver20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_21").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepOver21(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepOver21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_OVER_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_17").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepDefe17(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepDefe17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_18").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepDefe18(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepDefe18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_19").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepDefe19(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepDefe19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_20").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepDefe20(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepDefe20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_21").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepDefe21(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepDefe21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_DEFE_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_17").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepTota17(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepTota17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_18").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepTota18(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepTota18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_19").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepTota19(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepTota19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_20").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepTota20(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepTota20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_21").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnRepTota21(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnRepTota21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_REP_TOTA_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_17").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnFaiCost17(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnFaiCost17(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_17")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_18").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnFaiCost18(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnFaiCost18(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_18")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_19").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnFaiCost19(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnFaiCost19(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_19")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_20").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnFaiCost20(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnFaiCost20(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_20")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_21").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintAnnFaiCost21(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintAnnFaiCost21(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_ANN_FAI_COST_21")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2017").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintTotalCost2017(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintTotalCost2017(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2017")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2018").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintTotalCost2018(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintTotalCost2018(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2018")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2019").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintTotalCost2019(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintTotalCost2019(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2019")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2020").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintTotalCost2020(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintTotalCost2020(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2020")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2021").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintTotalCost2021(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintTotalCost2021(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_TOTAL_COST_2021")).doubleValue());
			}
			if (csvRecord.get("LCC_OPER_MAINT_COST_LATEST_5Y").trim().isEmpty()) {
				oElectricReactorCollect.setLccOperMaintCostLatest5y(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccOperMaintCostLatest5y(
						new DecimalFormat().parse(csvRecord.get("LCC_OPER_MAINT_COST_LATEST_5Y")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2017").trim().isEmpty()) {
				oElectricReactorCollect.setLccTechTransformaInves2017(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccTechTransformaInves2017(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2017")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2018").trim().isEmpty()) {
				oElectricReactorCollect.setLccTechTransformaInves2018(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccTechTransformaInves2018(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2018")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2019").trim().isEmpty()) {
				oElectricReactorCollect.setLccTechTransformaInves2019(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccTechTransformaInves2019(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2019")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2020").trim().isEmpty()) {
				oElectricReactorCollect.setLccTechTransformaInves2020(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccTechTransformaInves2020(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2020")).doubleValue());
			}
			if (csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2021").trim().isEmpty()) {
				oElectricReactorCollect.setLccTechTransformaInves2021(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccTechTransformaInves2021(
						new DecimalFormat().parse(csvRecord.get("LCC_TECH_TRANSFORMA_INVES_2021")).doubleValue());
			}
			if (csvRecord.get("LCC_ABANDON_COST_DISPOS_INCOME").trim().isEmpty()) {
				oElectricReactorCollect.setLccAbandonCostDisposIncome(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccAbandonCostDisposIncome(
						new DecimalFormat().parse(csvRecord.get("LCC_ABANDON_COST_DISPOS_INCOME")).doubleValue());
			}
			if (csvRecord.get("LCC_ABANDON_COST_DISPOS_COST").trim().isEmpty()) {
				oElectricReactorCollect.setLccAbandonCostDisposCost(new Double(0.0));
			} else {
				oElectricReactorCollect.setLccAbandonCostDisposCost(
						new DecimalFormat().parse(csvRecord.get("LCC_ABANDON_COST_DISPOS_COST")).doubleValue());
			}
			session.save(oElectricReactorCollect);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOSwitchCabinetAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OSwitchCabinet oSwitchCabinet = new OSwitchCabinet();
			oSwitchCabinet.setDataVersion(versionValue);
			oSwitchCabinet.setCalYear(DateFormatUtil.parseDate(calYear));
			oSwitchCabinet.setDataSourceFile(pathStr);
			oSwitchCabinet.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			oSwitchCabinet.setOperationNumber(csvRecord.get("OPERATION_NUMBER"));
			oSwitchCabinet.setPowerStation(csvRecord.get("POWER_STATION"));
			oSwitchCabinet.setSpacerUnit(csvRecord.get("SPACER_UNIT"));
			oSwitchCabinet.setLocalCity(csvRecord.get("LOCAL_CITY"));
			oSwitchCabinet.setOperationMaintenanceOrg(csvRecord.get("OPERATION_MAINTENANCE_ORG"));
			oSwitchCabinet.setMaintenanceTeam(csvRecord.get("MAINTENANCE_TEAM"));
			oSwitchCabinet.setEquipmentOwner(csvRecord.get("EQUIPMENT_OWNER"));
			oSwitchCabinet.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			oSwitchCabinet.setEquipmentStatus(csvRecord.get("EQUIPMENT_STATUS"));
			if (!(csvRecord.get("OPERATION_DATE").trim().isEmpty())) {
				oSwitchCabinet.setOperationDate(DateFormatUtil.parseDate(csvRecord.get("OPERATION_DATE")));
			}
			if (!(csvRecord.get("LATEST_OPERATION_DATE").trim().isEmpty())) {
				oSwitchCabinet.setLatestOperationDate(DateFormatUtil.parseDate(csvRecord.get("LATEST_OPERATION_DATE")));
			}
			oSwitchCabinet.setGenerationMaintenance(csvRecord.get("GENERATION_MAINTENANCE"));
			oSwitchCabinet.setRegionalCharacteristics(csvRecord.get("REGIONAL_CHARACTERISTICS"));
			oSwitchCabinet.setEquipmentClass(csvRecord.get("EQUIPMENT_CLASS"));
			oSwitchCabinet.setRuralPowerNetwork(csvRecord.get("RURAL_POWER_NETWORK"));
			oSwitchCabinet.setUseEnvironment(csvRecord.get("USE_ENVIRONMENT"));
			oSwitchCabinet.setAssetNature(csvRecord.get("ASSET_NATURE"));
			oSwitchCabinet.setAssetUnit(csvRecord.get("ASSET_UNIT"));
			oSwitchCabinet.setAssetId(csvRecord.get("ASSET_ID"));
			oSwitchCabinet.setItemCode(csvRecord.get("ITEM_CODE"));
			oSwitchCabinet.setEquipmentAdditionMethod(csvRecord.get("EQUIPMENT_ADDITION_METHOD"));
			oSwitchCabinet.setSingleItemCoding(csvRecord.get("SINGLE_ITEM_CODING"));
			oSwitchCabinet.setEntryName(csvRecord.get("ENTRY_NAME"));
			oSwitchCabinet.setItemName(csvRecord.get("ITEM_NAME"));
			oSwitchCabinet.setEquipmentModel(csvRecord.get("EQUIPMENT_MODEL"));
			oSwitchCabinet.setManufacturer(csvRecord.get("MANUFACTURER"));
			oSwitchCabinet.setWbsCode(csvRecord.get("WBS_CODE"));
			oSwitchCabinet.setFactoryNumber(csvRecord.get("FACTORY_NUMBER"));
			oSwitchCabinet.setProductCode(csvRecord.get("PRODUCT_CODE"));
			oSwitchCabinet.setManufacturingCountry(csvRecord.get("MANUFACTURING_COUNTRY"));
			if (!(csvRecord.get("PRODUCTION_DATE").trim().isEmpty())) {
				oSwitchCabinet.setProductionDate(DateFormatUtil.parseDate(csvRecord.get("PRODUCTION_DATE")));
			}
			if (csvRecord.get("RATED_VOLTAGE_KV").trim().isEmpty()) {
				oSwitchCabinet.setRatedVoltageKv(new Double(0.0));
			} else {
				oSwitchCabinet
						.setRatedVoltageKv(new DecimalFormat().parse(csvRecord.get("RATED_VOLTAGE_KV")).doubleValue());
			}
			if (csvRecord.get("HEIGHT_MM").trim().isEmpty()) {
				oSwitchCabinet.setHeightMm(new Double(0.0));
			} else {
				oSwitchCabinet.setHeightMm(new DecimalFormat().parse(csvRecord.get("HEIGHT_MM")).doubleValue());
			}
			if (csvRecord.get("WIDTH_MM").trim().isEmpty()) {
				oSwitchCabinet.setWidthMm(new Double(0.0));
			} else {
				oSwitchCabinet.setWidthMm(new DecimalFormat().parse(csvRecord.get("WIDTH_MM")).doubleValue());
			}
			if (csvRecord.get("RATED_CURRENT_A").trim().isEmpty()) {
				oSwitchCabinet.setRatedCurrentA(new Double(0.0));
			} else {
				oSwitchCabinet
						.setRatedCurrentA(new DecimalFormat().parse(csvRecord.get("RATED_CURRENT_A")).doubleValue());
			}
			if (csvRecord.get("DEPTH_MM").trim().isEmpty()) {
				oSwitchCabinet.setDepthMm(new Double(0.0));
			} else {
				oSwitchCabinet.setDepthMm(new DecimalFormat().parse(csvRecord.get("DEPTH_MM")).doubleValue());
			}
			if (csvRecord.get("RATED_FREQUENCY_HZ").trim().isEmpty()) {
				oSwitchCabinet.setRatedFrequencyHz(new Double(0.0));
			} else {
				oSwitchCabinet.setRatedFrequencyHz(
						new DecimalFormat().parse(csvRecord.get("RATED_FREQUENCY_HZ")).doubleValue());
			}
			oSwitchCabinet.setInsulatingMedium(csvRecord.get("INSULATING_MEDIUM"));
			oSwitchCabinet.setWhetherIacLevel(csvRecord.get("WHETHER_IAC_LEVEL"));
			oSwitchCabinet.setWhetherLsc2Class(csvRecord.get("WHETHER_LSC2_CLASS"));
			oSwitchCabinet.setBackCoverOrNot(csvRecord.get("BACK_COVER_OR_NOT"));
			oSwitchCabinet.setStructureType(csvRecord.get("STRUCTURE_TYPE"));
			if (csvRecord.get("CABINET_WIDTH_MM").trim().isEmpty()) {
				oSwitchCabinet.setCabinetWidthMm(new Double(0.0));
			} else {
				oSwitchCabinet
						.setCabinetWidthMm(new DecimalFormat().parse(csvRecord.get("CABINET_WIDTH_MM")).doubleValue());
			}
			oSwitchCabinet.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			if (!(csvRecord.get("REGISTRATION_TIME").trim().isEmpty())) {
				oSwitchCabinet.setRegistrationTime(DateFormatUtil.parseDate(csvRecord.get("REGISTRATION_TIME")));
			}
			oSwitchCabinet.setRemarks(csvRecord.get("REMARKS"));
			oSwitchCabinet.setAccountCreationMethod(csvRecord.get("ACCOUNT_CREATION_METHOD"));
			oSwitchCabinet.setPhysicalId(csvRecord.get("PHYSICAL_ID"));
			oSwitchCabinet.setPowerStationVoltageLevel(csvRecord.get("POWER_STATION_VOLTAGE_LEVEL"));
			oSwitchCabinet.setFunctionalLocation(csvRecord.get("FUNCTIONAL_LOCATION"));
			oSwitchCabinet.setPmId(csvRecord.get("PM_ID"));
			oSwitchCabinet.setProfessionalClassification(csvRecord.get("PROFESSIONAL_CLASSIFICATION"));
			oSwitchCabinet.setEquipmentTypeCode(csvRecord.get("EQUIPMENT_TYPE_CODE"));
			oSwitchCabinet.setWhetherStandardized(csvRecord.get("WHETHER_STANDARDIZED"));
			oSwitchCabinet.setVoltageClassCode(csvRecord.get("VOLTAGE_CLASS_CODE"));
			oSwitchCabinet.setVoltageClassName(csvRecord.get("VOLTAGE_CLASS_NAME"));
			session.save(oSwitchCabinet);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOPowerCapacitorAdd(String pathStr, String versionValue, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OPowerCapacitor oPowerCapacitor = new OPowerCapacitor();
			oPowerCapacitor.setDataVersion(versionValue);
			oPowerCapacitor.setCalYear(DateFormatUtil.parseDate(calYear));
			oPowerCapacitor.setDataSourceFile(pathStr);
			oPowerCapacitor.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			oPowerCapacitor.setOperationNumber(csvRecord.get("OPERATION_NUMBER"));
			oPowerCapacitor.setPowerStation(csvRecord.get("POWER_STATION"));
			oPowerCapacitor.setSpacerUnit(csvRecord.get("SPACER_UNIT"));
			oPowerCapacitor.setLocalCity(csvRecord.get("LOCAL_CITY"));
			oPowerCapacitor.setOperationMaintenanDepartment(csvRecord.get("OPERATION_MAINTENAN_DEPARTMENT"));
			oPowerCapacitor.setMaintenanceTeam(csvRecord.get("MAINTENANCE_TEAM"));
			oPowerCapacitor.setEquipmentOwner(csvRecord.get("EQUIPMENT_OWNER"));
			oPowerCapacitor.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			oPowerCapacitor.setBelongLargeFeederLine(csvRecord.get("BELONG_LARGE_FEEDER_LINE"));
			oPowerCapacitor.setEquipmentStatus(csvRecord.get("EQUIPMENT_STATUS"));
			if (!(csvRecord.get("OPERATION_DATE").trim().isEmpty())) {
				oPowerCapacitor.setOperationDate(DateFormatUtil.parseDate(csvRecord.get("OPERATION_DATE")));
			}
			oPowerCapacitor.setWhetherAgentMaintenance(csvRecord.get("WHETHER_AGENT_MAINTENANCE"));
			oPowerCapacitor.setLargeFeederBrnachLine(csvRecord.get("LARGE_FEEDER_BRNACH_LINE"));
			if (!(csvRecord.get("LATEST_OPERATION_DATE").trim().isEmpty())) {
				oPowerCapacitor
						.setLatestOperationDate(DateFormatUtil.parseDate(csvRecord.get("LATEST_OPERATION_DATE")));
			}
			oPowerCapacitor.setCombinedEquipmentType(csvRecord.get("COMBINED_EQUIPMENT_TYPE"));
			oPowerCapacitor.setWhetherRuralPowerNetwork(csvRecord.get("WHETHER_RURAL_POWER_NETWORK"));
			oPowerCapacitor.setUseEnvironment(csvRecord.get("USE_ENVIRONMENT"));
			oPowerCapacitor.setImportanceDegree(csvRecord.get("IMPORTANCE_DEGREE"));
			oPowerCapacitor.setInstallationMode(csvRecord.get("INSTALLATION_MODE"));
			oPowerCapacitor.setAccessMode(csvRecord.get("ACCESS_MODE"));
			oPowerCapacitor.setWiringMode(csvRecord.get("WIRING_MODE"));
			oPowerCapacitor.setAssetNature(csvRecord.get("ASSET_NATURE"));
			oPowerCapacitor.setAssetDepartment(csvRecord.get("ASSET_DEPARTMENT"));
			oPowerCapacitor.setWbsId(csvRecord.get("WBS_ID"));
			oPowerCapacitor.setAssetId(csvRecord.get("ASSET_ID"));
			oPowerCapacitor.setProjectNo(csvRecord.get("PROJECT_NO"));
			oPowerCapacitor.setProjectName(csvRecord.get("PROJECT_NAME"));
			oPowerCapacitor.setEquipmentAdditionMethod(csvRecord.get("EQUIPMENT_ADDITION_METHOD"));
			oPowerCapacitor.setEquipmentModel(csvRecord.get("EQUIPMENT_MODEL"));
			oPowerCapacitor.setManufacturer(csvRecord.get("MANUFACTURER"));
			oPowerCapacitor.setFactoryNumber(csvRecord.get("FACTORY_NUMBER"));
			oPowerCapacitor.setProductCode(csvRecord.get("PRODUCT_CODE"));
			oPowerCapacitor.setManufacturingCountry(csvRecord.get("MANUFACTURING_COUNTRY"));
			if (!(csvRecord.get("PRODUCTION_DATE").trim().isEmpty())) {
				oPowerCapacitor.setProductionDate(DateFormatUtil.parseDate(csvRecord.get("PRODUCTION_DATE")));
			}
			oPowerCapacitor.setInsulatingMedium(csvRecord.get("INSULATING_MEDIUM"));
			oPowerCapacitor.setCapacitorBankInteProteMode(csvRecord.get("CAPACITOR_BANK_INTE_PROTE_MODE"));
			oPowerCapacitor.setSingleProtectionMode(csvRecord.get("SINGLE_PROTECTION_MODE"));
			oPowerCapacitor.setRatedVoltageKv(csvRecord.get("RATED_VOLTAGE_KV"));
			if (csvRecord.get("RATED_CURRENT_A").trim().isEmpty()) {
				oPowerCapacitor.setRatedCurrentA(new Double(0.0));
			} else {
				oPowerCapacitor
						.setRatedCurrentA(new DecimalFormat().parse(csvRecord.get("RATED_CURRENT_A")).doubleValue());
			}
			if (csvRecord.get("RATED_FREQUENCY_HZ").trim().isEmpty()) {
				oPowerCapacitor.setRatedFrequencyHz(new Double(0.0));
			} else {
				oPowerCapacitor.setRatedFrequencyHz(
						new DecimalFormat().parse(csvRecord.get("RATED_FREQUENCY_HZ")).doubleValue());
			}
			if (csvRecord.get("SINGLE_CAPACITY_KVAR").trim().isEmpty()) {
				oPowerCapacitor.setSingleCapacityKvar(new Double(0.0));
			} else {
				oPowerCapacitor.setSingleCapacityKvar(
						new DecimalFormat().parse(csvRecord.get("SINGLE_CAPACITY_KVAR")).doubleValue());
			}
			if (csvRecord.get("WHOLE_GROUP_CAPACITY_KVAR").trim().isEmpty()) {
				oPowerCapacitor.setWholeGroupCapacityKvar(new Double(0.0));
			} else {
				oPowerCapacitor.setWholeGroupCapacityKvar(
						new DecimalFormat().parse(csvRecord.get("WHOLE_GROUP_CAPACITY_KVAR")).doubleValue());
			}
			if (csvRecord.get("CAPACITANCE_UF").trim().isEmpty()) {
				oPowerCapacitor.setCapacitanceUf(new Double(0.0));
			} else {
				oPowerCapacitor
						.setCapacitanceUf(new DecimalFormat().parse(csvRecord.get("CAPACITANCE_UF")).doubleValue());
			}
			oPowerCapacitor.setDispatchingJurisdiction(csvRecord.get("DISPATCHING_JURISDICTION"));
			if (csvRecord.get("EQUIPMENT_NUMBER").trim().isEmpty()) {
				oPowerCapacitor.setEquipmentNumber(new Double(0.0));
			} else {
				oPowerCapacitor
						.setEquipmentNumber(new DecimalFormat().parse(csvRecord.get("EQUIPMENT_NUMBER")).doubleValue());
			}
			oPowerCapacitor.setDispatchingOperationRight(csvRecord.get("DISPATCHING_OPERATION_RIGHT"));
			oPowerCapacitor.setDispatchingPermission(csvRecord.get("DISPATCHING_PERMISSION"));
			oPowerCapacitor.setDispatchingMonitoringRight(csvRecord.get("DISPATCHING_MONITORING_RIGHT"));
			if (!(csvRecord.get("REGISTRATION_TIME").trim().isEmpty())) {
				oPowerCapacitor.setRegistrationTime(DateFormatUtil.parseDate(csvRecord.get("REGISTRATION_TIME")));
			}
			oPowerCapacitor.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			oPowerCapacitor.setRemark(csvRecord.get("REMARK"));
			oPowerCapacitor.setEquipmentClassCode(csvRecord.get("EQUIPMENT_CLASS_CODE"));
			oPowerCapacitor.setCombinedElectricalAppliance(csvRecord.get("COMBINED_ELECTRICAL_APPLIANCE"));
			oPowerCapacitor.setCombinedEquipmentName(csvRecord.get("COMBINED_EQUIPMENT_NAME"));
			oPowerCapacitor.setCombinedApparSwitchgearName(csvRecord.get("COMBINED_APPAR_SWITCHGEAR_NAME"));
			oPowerCapacitor.setProfessionalClassification(csvRecord.get("PROFESSIONAL_CLASSIFICATION"));
			oPowerCapacitor.setPmId(csvRecord.get("PM_ID"));
			oPowerCapacitor.setFunctionalLocation(csvRecord.get("FUNCTIONAL_LOCATION"));
			oPowerCapacitor.setPhysicalId(csvRecord.get("PHYSICAL_ID"));
			oPowerCapacitor.setAccountCreationMethod(csvRecord.get("ACCOUNT_CREATION_METHOD"));
			session.save(oPowerCapacitor);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOElectricReactorAdd(String pathStr, String dataVersion, String calYear)
			throws IOException, ParseException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OElectricReactor oElectricReactor = new OElectricReactor();
			oElectricReactor.setDataVersion(dataVersion);
			oElectricReactor.setCalYear(DateFormatUtil.parseDate(calYear));
			oElectricReactor.setDataSourceFile(pathStr);
			oElectricReactor.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			oElectricReactor.setAssociatFixedFireExtingSys(csvRecord.get("ASSOCIAT_FIXED_FIRE_EXTING_SYS"));
			oElectricReactor.setOperationNumber(csvRecord.get("OPERATION_NUMBER"));
			oElectricReactor.setPowerStation(csvRecord.get("POWER_STATION"));
			oElectricReactor.setSpacerUnit(csvRecord.get("SPACER_UNIT"));
			oElectricReactor.setLocalCity(csvRecord.get("LOCAL_CITY"));
			oElectricReactor.setOperationMaintenanDepartment(csvRecord.get("OPERATION_MAINTENAN_DEPARTMENT"));
			oElectricReactor.setMaintenanceTeam(csvRecord.get("MAINTENANCE_TEAM"));
			oElectricReactor.setEquipmentOwner(csvRecord.get("EQUIPMENT_OWNER"));
			oElectricReactor.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			oElectricReactor.setEquipmentStatus(csvRecord.get("EQUIPMENT_STATUS"));
			oElectricReactor.setLargeFeederLine(csvRecord.get("LARGE_FEEDER_LINE"));
			oElectricReactor.setPhaseNumber(csvRecord.get("PHASE_NUMBER"));
			oElectricReactor.setPhaseName(csvRecord.get("PHASE_NAME"));
			oElectricReactor.setLargeFeederBrnachLine(csvRecord.get("LARGE_FEEDER_BRNACH_LINE"));
			if (!(csvRecord.get("OPERATION_DATE").trim().isEmpty())) {
				oElectricReactor.setOperationDate(DateFormatUtil.parseDate(csvRecord.get("OPERATION_DATE")));
			}
			if (!(csvRecord.get("LATEST_OPERATION_DATE").trim().isEmpty())) {
				oElectricReactor
						.setLatestOperationDate(DateFormatUtil.parseDate(csvRecord.get("LATEST_OPERATION_DATE")));
			}
			oElectricReactor.setWhetherRuralPowerNetwork(csvRecord.get("WHETHER_RURAL_POWER_NETWORK"));
			oElectricReactor.setCombinedEquipmentClass(csvRecord.get("COMBINED_EQUIPMENT_CLASS"));
			oElectricReactor.setAccessMode(csvRecord.get("ACCESS_MODE"));
			oElectricReactor.setUseEnvironment(csvRecord.get("USE_ENVIRONMENT"));
			oElectricReactor.setWhetherAgentMaintenance(csvRecord.get("WHETHER_AGENT_MAINTENANCE"));
			oElectricReactor.setInstallationMode(csvRecord.get("INSTALLATION_MODE"));
			oElectricReactor.setRegionalCharacteristic(csvRecord.get("REGIONAL_CHARACTERISTIC"));
			oElectricReactor.setAssetNature(csvRecord.get("ASSET_NATURE"));
			oElectricReactor.setAssetOrganization(csvRecord.get("ASSET_ORGANIZATION"));
			oElectricReactor.setWbsId(csvRecord.get("WBS_ID"));
			oElectricReactor.setAssetId(csvRecord.get("ASSET_ID"));
			oElectricReactor.setEquipmentClassCode(csvRecord.get("EQUIPMENT_CLASS_CODE"));
			oElectricReactor.setProjectNo(csvRecord.get("PROJECT_NO"));
			oElectricReactor.setProjectName(csvRecord.get("PROJECT_NAME"));
			oElectricReactor.setEquipmentAdditionMethod(csvRecord.get("EQUIPMENT_ADDITION_METHOD"));
			oElectricReactor.setModel(csvRecord.get("MODEL"));
			oElectricReactor.setManufacturer(csvRecord.get("MANUFACTURER"));
			oElectricReactor.setFactoryNumber(csvRecord.get("FACTORY_NUMBER"));
			oElectricReactor.setProductCode(csvRecord.get("PRODUCT_CODE"));
			oElectricReactor.setManufacturingCountry(csvRecord.get("MANUFACTURING_COUNTRY"));
			if (!(csvRecord.get("DATE_OF_PRODUCTION").trim().isEmpty())) {
				oElectricReactor.setDateOfProduction(DateFormatUtil.parseDate(csvRecord.get("DATE_OF_PRODUCTION")));
			}
			oElectricReactor.setInsulationClass(csvRecord.get("INSULATION_CLASS"));
			oElectricReactor.setAntifoulingGrade(csvRecord.get("ANTIFOULING_GRADE"));
			oElectricReactor.setRatedVoltageKv(csvRecord.get("RATED_VOLTAGE_KV"));
			if (csvRecord.get("RATED_CURRENT_A").trim().isEmpty()) {
				oElectricReactor.setRatedCurrentA(new Double(0.0));
			} else {
				oElectricReactor
						.setRatedCurrentA(new DecimalFormat().parse(csvRecord.get("RATED_CURRENT_A")).doubleValue());
			}
			if (csvRecord.get("RATED_FREQUENCY_HZ").trim().isEmpty()) {
				oElectricReactor.setRatedFrequencyHz(new Double(0.0));
			} else {
				oElectricReactor.setRatedFrequencyHz(
						new DecimalFormat().parse(csvRecord.get("RATED_FREQUENCY_HZ")).doubleValue());
			}
			oElectricReactor.setCoolingMode(csvRecord.get("COOLING_MODE"));
			oElectricReactor.setVoltageRegulationMode(csvRecord.get("VOLTAGE_REGULATION_MODE"));
			oElectricReactor.setInsulatingMedium(csvRecord.get("INSULATING_MEDIUM"));
			oElectricReactor.setMagneticConductionStructure(csvRecord.get("MAGNETIC_CONDUCTION_STRUCTURE"));
			if (csvRecord.get("RATED_CAPACITY_KVAR").trim().isEmpty()) {
				oElectricReactor.setRatedCapacityKvar(new Double(0.0));
			} else {
				oElectricReactor.setRatedCapacityKvar(
						new DecimalFormat().parse(csvRecord.get("RATED_CAPACITY_KVAR")).doubleValue());
			}
			if (csvRecord.get("RATED_REACTANCE_OMEGA").trim().isEmpty()) {
				oElectricReactor.setRatedReactanceOmega(new Double(0.0));
			} else {
				oElectricReactor.setRatedReactanceOmega(
						new DecimalFormat().parse(csvRecord.get("RATED_REACTANCE_OMEGA")).doubleValue());
			}
			if (csvRecord.get("RATED_REACTANCE_RATE").trim().isEmpty()) {
				oElectricReactor.setRatedReactanceRate(new Double(0.0));
			} else {
				oElectricReactor.setRatedReactanceRate(
						new DecimalFormat().parse(csvRecord.get("RATED_REACTANCE_RATE")).doubleValue());
			}
			if (csvRecord.get("RATED_INDUCTANCE_MH").trim().isEmpty()) {
				oElectricReactor.setRatedInductanceMh(new Double(0.0));
			} else {
				oElectricReactor.setRatedInductanceMh(
						new DecimalFormat().parse(csvRecord.get("RATED_INDUCTANCE_MH")).doubleValue());
			}
			if (csvRecord.get("TOTAL_WEIGHT_T").trim().isEmpty()) {
				oElectricReactor.setTotalWeightT(new Double(0.0));
			} else {
				oElectricReactor
						.setTotalWeightT(new DecimalFormat().parse(csvRecord.get("TOTAL_WEIGHT_T")).doubleValue());
			}
			oElectricReactor.setOilNumber(csvRecord.get("OIL_NUMBER"));
			oElectricReactor.setOilProducingArea(csvRecord.get("OIL_PRODUCING_AREA"));
			if (csvRecord.get("RATED_LOSS_KW").trim().isEmpty()) {
				oElectricReactor.setRatedLossKw(new Double(0.0));
			} else {
				oElectricReactor
						.setRatedLossKw(new DecimalFormat().parse(csvRecord.get("RATED_LOSS_KW")).doubleValue());
			}
			if (csvRecord.get("PERCENT_IMPEDANCE_PERCENT").trim().isEmpty()) {
				oElectricReactor.setPercentImpedancePercent(new Double(0.0));
			} else {
				oElectricReactor.setPercentImpedancePercent(
						new DecimalFormat().parse(csvRecord.get("PERCENT_IMPEDANCE_PERCENT")).doubleValue());
			}
			if (csvRecord.get("RATED_S_TIME_WITHSTAND_CURR_KA").trim().isEmpty()) {
				oElectricReactor.setRatedSTimeWithstandCurrKa(new Double(0.0));
			} else {
				oElectricReactor.setRatedSTimeWithstandCurrKa(
						new DecimalFormat().parse(csvRecord.get("RATED_S_TIME_WITHSTAND_CURR_KA")).doubleValue());
			}
			if (csvRecord.get("RATED_PEAK_WITHSTAND_CURR_KA").trim().isEmpty()) {
				oElectricReactor.setRatedPeakWithstandCurrKa(new Double(0.0));
			} else {
				oElectricReactor.setRatedPeakWithstandCurrKa(
						new DecimalFormat().parse(csvRecord.get("RATED_PEAK_WITHSTAND_CURR_KA")).doubleValue());
			}
			if (csvRecord.get("RATED_SHORT_CIRCUIT_DURAT_MS").trim().isEmpty()) {
				oElectricReactor.setRatedShortCircuitDuratMs(new Double(0.0));
			} else {
				oElectricReactor.setRatedShortCircuitDuratMs(
						new DecimalFormat().parse(csvRecord.get("RATED_SHORT_CIRCUIT_DURAT_MS")).doubleValue());
			}
			oElectricReactor.setInsulationLevel(csvRecord.get("INSULATION_LEVEL"));
			if (csvRecord.get("BODY_WEIGHT_T").trim().isEmpty()) {
				oElectricReactor.setBodyWeightT(new Double(0.0));
			} else {
				oElectricReactor
						.setBodyWeightT(new DecimalFormat().parse(csvRecord.get("BODY_WEIGHT_T")).doubleValue());
			}
			oElectricReactor.setInsulationLevelNeutralPoint(csvRecord.get("INSULATION_LEVEL_NEUTRAL_POINT"));
			if (csvRecord.get("ZERO_SEQUENCE_REACTANCE_OMEGA").trim().isEmpty()) {
				oElectricReactor.setZeroSequenceReactanceOmega(new Double(0.0));
			} else {
				oElectricReactor.setZeroSequenceReactanceOmega(
						new DecimalFormat().parse(csvRecord.get("ZERO_SEQUENCE_REACTANCE_OMEGA")).doubleValue());
			}
			if (csvRecord.get("CONTINU_WORK_OVERVOLTAGE_MULTI").trim().isEmpty()) {
				oElectricReactor.setContinuWorkOvervoltageMulti(new Double(0.0));
			} else {
				oElectricReactor.setContinuWorkOvervoltageMulti(
						new DecimalFormat().parse(csvRecord.get("CONTINU_WORK_OVERVOLTAGE_MULTI")).doubleValue());
			}
			if (csvRecord.get("OIL_WEIGHT_T").trim().isEmpty()) {
				oElectricReactor.setOilWeightT(new Double(0.0));
			} else {
				oElectricReactor.setOilWeightT(new DecimalFormat().parse(csvRecord.get("OIL_WEIGHT_T")).doubleValue());
			}
			oElectricReactor.setOilTankStructure(csvRecord.get("OIL_TANK_STRUCTURE"));
			oElectricReactor.setConservatorSealingMode(csvRecord.get("CONSERVATOR_SEALING_MODE"));
			oElectricReactor.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			if (csvRecord.get("CONTINU_WORK_OVERCURRENT_MULTI").trim().isEmpty()) {
				oElectricReactor.setContinuWorkOvercurrentMulti(new Double(0.0));
			} else {
				oElectricReactor.setContinuWorkOvercurrentMulti(
						new DecimalFormat().parse(csvRecord.get("CONTINU_WORK_OVERCURRENT_MULTI")).doubleValue());
			}
			if (!(csvRecord.get("REGISTRATION_TIME").trim().isEmpty())) {
				oElectricReactor.setRegistrationTime(DateFormatUtil.parseDate(csvRecord.get("REGISTRATION_TIME")));
			}
			oElectricReactor.setRemark(csvRecord.get("REMARK"));
			oElectricReactor.setStationLineName(csvRecord.get("STATION_LINE_NAME"));
			oElectricReactor.setAccountCreationMethod(csvRecord.get("ACCOUNT_CREATION_METHOD"));
			oElectricReactor.setVoltageClassName(csvRecord.get("VOLTAGE_CLASS_NAME"));
			oElectricReactor.setCombinedApparSwitchgearName(csvRecord.get("COMBINED_APPAR_SWITCHGEAR_NAME"));
			oElectricReactor.setBelongCombinApparSwitchgear(csvRecord.get("BELONG_COMBIN_APPAR_SWITCHGEAR"));
			oElectricReactor.setEquipmentManufacturer(csvRecord.get("EQUIPMENT_MANUFACTURER"));
			oElectricReactor.setProfessionalClassification(csvRecord.get("PROFESSIONAL_CLASSIFICATION"));
			oElectricReactor.setPmId(csvRecord.get("PM_ID"));
			oElectricReactor.setFunctionalLocation(csvRecord.get("FUNCTIONAL_LOCATION"));
			oElectricReactor.setBelongStationVoltageLevel(csvRecord.get("BELONG_STATION_VOLTAGE_LEVEL"));
			oElectricReactor.setPhysicalId(csvRecord.get("PHYSICAL_ID"));
			oElectricReactor.setVoltageClassCode(csvRecord.get("VOLTAGE_CLASS_CODE"));

			session.save(oElectricReactor);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvPmsItemPeiSetAdd(String pathStr, String dataVersion, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemPeiSet pmsItemPeiSet = new PmsItemPeiSet();

			pmsItemPeiSet.setCalYear(new Short(calYear));
			pmsItemPeiSet.setVersion(dataVersion);
			pmsItemPeiSet.setDataSourceFile(pathStr);

			pmsItemPeiSet.setSbbm(csvRecord.get("设备编码"));
			pmsItemPeiSet.setDwmx(csvRecord.get("单位明细"));
			pmsItemPeiSet.setYwdw(csvRecord.get("运维单位"));
			pmsItemPeiSet.setZckbm(csvRecord.get("自动匹配的资产卡片编码"));
			pmsItemPeiSet.setSblx(csvRecord.get("设备类型"));
			if (csvRecord.get("资产原值").trim().isEmpty()) {
				pmsItemPeiSet.setZcyz(new Double(0.0));
			} else {
				pmsItemPeiSet.setZcyz(new Double(csvRecord.get("资产原值")));
			}
			pmsItemPeiSet.setZcdl(csvRecord.get("资产大类"));
			pmsItemPeiSet.setZclxbm(csvRecord.get("PMS设备类型编码"));
			pmsItemPeiSet.setCwbm(csvRecord.get("资产细类编码"));
			pmsItemPeiSet.setDydj(csvRecord.get("电压等级"));
			pmsItemPeiSet.setYxzt(csvRecord.get("运行状态"));
			pmsItemPeiSet.setJkzt(csvRecord.get("健康状态"));
			if (!csvRecord.get("最近投运日期").trim().isEmpty()) {
				pmsItemPeiSet.setZjtyrq(DateFormatUtil.parseDate(csvRecord.get("最近投运日期")));
			}
			pmsItemPeiSet.setZcxz(csvRecord.get("资产性质"));

			if (!(null == csvRecord.get("额定容量"))) {
				if (csvRecord.get("额定容量").trim().isEmpty()) {
					pmsItemPeiSet.setSl(new Double(0.0));
				} else {
					try {
						pmsItemPeiSet.setSl(df.parse(csvRecord.get("额定容量")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (!(null == csvRecord.get("电缆线路长度"))) {
				if (csvRecord.get("电缆线路长度").trim().isEmpty()) {
					pmsItemPeiSet.setSl1(new Double(0.0));
				} else {
					try {
						pmsItemPeiSet.setSl1(df.parse(csvRecord.get("电缆线路长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (!(null == csvRecord.get("架空线路长度"))) {
				if (csvRecord.get("架空线路长度").trim().isEmpty()) {
					pmsItemPeiSet.setSl2(new Double(0.0));
				} else {
					try {
						pmsItemPeiSet.setSl2(df.parse(csvRecord.get("架空线路长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			/*
			 * if(!(null ==csvRecord.get("SL3"))){ if
			 * (csvRecord.get("SL3").trim().isEmpty()) { pmsItemPeiSet.setSl3(new
			 * Double(0.0)); } else { try { pmsItemPeiSet.setSl3(new
			 * DecimalFormat().parse(csvRecord.get("SL3")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } }
			 */

			pmsItemPeiSet.setZzsmc(csvRecord.get("制造商名称"));
			pmsItemPeiSet.setSsxlbdz(csvRecord.get("所属线路名称"));
			pmsItemPeiSet.setSbxh(csvRecord.get("设备型号"));
			if (csvRecord.get("投运年份").trim().isEmpty()) {
				pmsItemPeiSet.setTynf(new Short("0"));
			} else {
				pmsItemPeiSet.setTynf(new Short(csvRecord.get("投运年份")));
			}
			pmsItemPeiSet.setNnd(csvRecord.get("年龄段"));
			if (!csvRecord.get("投运日期").trim().isEmpty()) {
				pmsItemPeiSet.setTyrq(DateFormatUtil.parseDate(csvRecord.get("投运日期")));
			}
			if (csvRecord.get("年龄").trim().isEmpty()) {
				pmsItemPeiSet.setNn(new Short("0"));
			} else {
				pmsItemPeiSet.setNn(new Short(csvRecord.get("年龄")));
			}

			pmsItemPeiSet.setQfzd(csvRecord.get("区分字段"));
			if (!csvRecord.get("出厂日期").trim().isEmpty()) {
				pmsItemPeiSet.setCcrq(DateFormatUtil.parseDate(csvRecord.get("出厂日期")));
			}

			pmsItemPeiSet.setEquipmentName(csvRecord.get("设备名称"));

			pmsItemPeiSet.setAssetId(csvRecord.get("实物ID"));
			pmsItemPeiSet.setEquipmentIncreaseMode(csvRecord.get("设备增加方式"));

			pmsItemPeiSet.setLineProperty(csvRecord.get("线路性质"));
			// pmsItemPeiSet.setJldw(csvRecord.get("计量单位"));
			session.save(pmsItemPeiSet);

			/*
			 * pmsItemPeiSet.setSbbm(csvRecord.get("SBBM"));
			 * pmsItemPeiSet.setDwmx(csvRecord.get("DWMX"));
			 * pmsItemPeiSet.setYwdw(csvRecord.get("YWDW"));
			 * pmsItemPeiSet.setZckbm(csvRecord.get("ZCKBM"));
			 * pmsItemPeiSet.setSblx(csvRecord.get("SBLX")); if
			 * (csvRecord.get("ZCYZ").trim().isEmpty()) { pmsItemPeiSet.setZcyz(new
			 * Double(0.0)); } else { pmsItemPeiSet.setZcyz(new
			 * Double(csvRecord.get("ZCYZ"))); }
			 * pmsItemPeiSet.setZcdl(csvRecord.get("ZCDL"));
			 * pmsItemPeiSet.setZclxbm(csvRecord.get("ZCLXBM"));
			 * pmsItemPeiSet.setCwbm(csvRecord.get("CWBM"));
			 * pmsItemPeiSet.setDydj(csvRecord.get("DYDJ"));
			 * pmsItemPeiSet.setYxzt(csvRecord.get("YXZT"));
			 * pmsItemPeiSet.setJkzt(csvRecord.get("JKZT")); if
			 * (!csvRecord.get("ZJTYRQ").trim().isEmpty()) { try {
			 * pmsItemPeiSet.setZjtyrq(simpleDateFormat.parse(csvRecord.get("ZJTYRQ"))); }
			 * catch (ParseException e) { e.printStackTrace(); } }
			 * pmsItemPeiSet.setZcxz(csvRecord.get("ZCXZ"));
			 * 
			 * if (!(null == csvRecord.get("SL"))) { if
			 * (csvRecord.get("SL").trim().isEmpty()) { pmsItemPeiSet.setSl(new
			 * Double(0.0)); } else { try {
			 * pmsItemPeiSet.setSl(df.parse(csvRecord.get("SL")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } } if (!(null == csvRecord.get("SL1"))) { if
			 * (csvRecord.get("SL1").trim().isEmpty()) { pmsItemPeiSet.setSl1(new
			 * Double(0.0)); } else { try {
			 * pmsItemPeiSet.setSl1(df.parse(csvRecord.get("SL1")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } } if (!(null == csvRecord.get("SL2"))) { if
			 * (csvRecord.get("SL2").trim().isEmpty()) { pmsItemPeiSet.setSl2(new
			 * Double(0.0)); } else { try {
			 * pmsItemPeiSet.setSl2(df.parse(csvRecord.get("SL2")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } }
			 * 
			 * pmsItemPeiSet.setZzsmc(csvRecord.get("ZZSMC"));
			 * pmsItemPeiSet.setSsxlbdz(csvRecord.get("SSXLBDZ"));
			 * pmsItemPeiSet.setSbxh(csvRecord.get("SBXH")); if
			 * (csvRecord.get("TYNF").trim().isEmpty()) { pmsItemPeiSet.setTynf(new
			 * Short("0")); } else { pmsItemPeiSet.setTynf(new
			 * Short(csvRecord.get("TYNF"))); } pmsItemPeiSet.setNnd(csvRecord.get("NND"));
			 * if (!csvRecord.get("TYRQ").trim().isEmpty()) { try {
			 * pmsItemPeiSet.setTyrq(simpleDateFormat.parse(csvRecord.get("TYRQ"))); } catch
			 * (ParseException e) { e.printStackTrace(); } } if
			 * (csvRecord.get("NN").trim().isEmpty()) { pmsItemPeiSet.setNn(new Short("0"));
			 * } else { pmsItemPeiSet.setNn(new Short(csvRecord.get("NN"))); }
			 * 
			 * pmsItemPeiSet.setQfzd(csvRecord.get("QFZD")); if
			 * (!csvRecord.get("CCRQ").trim().isEmpty()) { try {
			 * pmsItemPeiSet.setCcrq(simpleDateFormat.parse(csvRecord.get("CCRQ"))); } catch
			 * (ParseException e) { e.printStackTrace(); } }
			 * 
			 * pmsItemPeiSet.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			 * 
			 * pmsItemPeiSet.setAssetId(csvRecord.get("ASSET_ID"));
			 * pmsItemPeiSet.setEquipmentIncreaseMode(csvRecord.get(
			 * "EQUIPMENT_INCREASE_MODE")); pmsItemPeiSet.setDataSourceFile(pathStr);
			 * 
			 * session.save(pmsItemPeiSet);
			 * 
			 */

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvPmsItemRingMainUnitAdd(String pathStr, String dataVersion, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemRingMainUnit pmsItemRingMainUnit = new PmsItemRingMainUnit();
			pmsItemRingMainUnit.setCalYear(new Short(calYear));
			pmsItemRingMainUnit.setVersion(dataVersion);
			pmsItemRingMainUnit.setDataSourceFile(pathStr);

			pmsItemRingMainUnit.setSbbm(csvRecord.get("设备编码"));
			pmsItemRingMainUnit.setDwmx(csvRecord.get("单位明细"));
			pmsItemRingMainUnit.setYwdw(csvRecord.get("运维单位"));
			pmsItemRingMainUnit.setZckbm(csvRecord.get("自动匹配的资产卡片编码"));
			pmsItemRingMainUnit.setSblx(csvRecord.get("设备类型"));
			if (csvRecord.get("资产原值").trim().isEmpty()) {
				pmsItemRingMainUnit.setZcyz(new Double(0.0));
			} else {
				pmsItemRingMainUnit.setZcyz(new Double(csvRecord.get("资产原值")));
			}
			pmsItemRingMainUnit.setZcdl(csvRecord.get("资产大类"));
			pmsItemRingMainUnit.setZclxbm(csvRecord.get("PMS设备类型编码"));
			pmsItemRingMainUnit.setCwbm(csvRecord.get("资产细类编码"));
			pmsItemRingMainUnit.setDydj(csvRecord.get("电压等级"));
			pmsItemRingMainUnit.setYxzt(csvRecord.get("运行状态"));
			pmsItemRingMainUnit.setJkzt(csvRecord.get("健康状态"));
			if (!csvRecord.get("最近投运日期").trim().isEmpty()) {
				pmsItemRingMainUnit.setZjtyrq(DateFormatUtil.parseDate(csvRecord.get("最近投运日期")));
			}
			pmsItemRingMainUnit.setZcxz(csvRecord.get("资产性质"));

			if (!(null == csvRecord.get("额定容量"))) {
				if (csvRecord.get("额定容量").trim().isEmpty()) {
					pmsItemRingMainUnit.setSl(new Double(0.0));
				} else {
					try {
						pmsItemRingMainUnit.setSl(df.parse(csvRecord.get("额定容量")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (!(null == csvRecord.get("电缆线路长度"))) {
				if (csvRecord.get("电缆线路长度").trim().isEmpty()) {
					pmsItemRingMainUnit.setSl1(new Double(0.0));
				} else {
					try {
						pmsItemRingMainUnit.setSl1(df.parse(csvRecord.get("电缆线路长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (!(null == csvRecord.get("架空线路长度"))) {
				if (csvRecord.get("架空线路长度").trim().isEmpty()) {
					pmsItemRingMainUnit.setSl2(new Double(0.0));
				} else {
					try {
						pmsItemRingMainUnit.setSl2(df.parse(csvRecord.get("架空线路长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			/*
			 * if(!(null ==csvRecord.get("SL3"))){ if
			 * (csvRecord.get("SL3").trim().isEmpty()) { pmsItemRingMainUnit.setSl3(new
			 * Double(0.0)); } else { try { pmsItemRingMainUnit.setSl3(new
			 * DecimalFormat().parse(csvRecord.get("SL3")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } }
			 */

			pmsItemRingMainUnit.setZzsmc(csvRecord.get("制造商名称"));
			pmsItemRingMainUnit.setSsxlbdz(csvRecord.get("站房名称"));
			pmsItemRingMainUnit.setSbxh(csvRecord.get("设备型号"));
			if (csvRecord.get("投运年份").trim().isEmpty()) {
				pmsItemRingMainUnit.setTynf(new Short("0"));
			} else {
				pmsItemRingMainUnit.setTynf(new Short(csvRecord.get("投运年份")));
			}
			pmsItemRingMainUnit.setNnd(csvRecord.get("年龄段"));
			if (!csvRecord.get("投运日期").trim().isEmpty()) {
				try {
					pmsItemRingMainUnit.setTyrq(simpleDateFormat.parse(csvRecord.get("投运日期")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (csvRecord.get("年龄").trim().isEmpty()) {
				pmsItemRingMainUnit.setNn(new Short("0"));
			} else {
				pmsItemRingMainUnit.setNn(new Short(csvRecord.get("年龄")));
			}

			pmsItemRingMainUnit.setQfzd(csvRecord.get("区分字段"));
			if (!csvRecord.get("出厂日期").trim().isEmpty()) {
				try {
					pmsItemRingMainUnit.setCcrq(simpleDateFormat.parse(csvRecord.get("出厂日期")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			pmsItemRingMainUnit.setEquipmentName(csvRecord.get("设备名称"));

			// pmsItemRingMainUnit.setJldw(csvRecord.get("计量单位"));
			pmsItemRingMainUnit.setAssetId(csvRecord.get("实物ID"));
			pmsItemRingMainUnit.setEquipmentIncreaseMode(csvRecord.get("设备增加方式"));
			pmsItemRingMainUnit.setLineProperty(csvRecord.get("线路性质"));
			session.save(pmsItemRingMainUnit);

			/*
			 * pmsItemRingMainUnit.setSbbm(csvRecord.get("SBBM"));
			 * pmsItemRingMainUnit.setDwmx(csvRecord.get("DWMX"));
			 * pmsItemRingMainUnit.setYwdw(csvRecord.get("YWDW"));
			 * pmsItemRingMainUnit.setZckbm(csvRecord.get("ZCKBM"));
			 * pmsItemRingMainUnit.setSblx(csvRecord.get("SBLX")); if
			 * (csvRecord.get("ZCYZ").trim().isEmpty()) { pmsItemRingMainUnit.setZcyz(new
			 * Double(0.0)); } else { pmsItemRingMainUnit.setZcyz(new
			 * Double(csvRecord.get("ZCYZ"))); }
			 * pmsItemRingMainUnit.setZcdl(csvRecord.get("ZCDL"));
			 * pmsItemRingMainUnit.setZclxbm(csvRecord.get("ZCLXBM"));
			 * pmsItemRingMainUnit.setCwbm(csvRecord.get("CWBM"));
			 * pmsItemRingMainUnit.setDydj(csvRecord.get("DYDJ"));
			 * pmsItemRingMainUnit.setYxzt(csvRecord.get("YXZT"));
			 * pmsItemRingMainUnit.setJkzt(csvRecord.get("JKZT")); if
			 * (!csvRecord.get("ZJTYRQ").trim().isEmpty()) { try {
			 * pmsItemRingMainUnit.setZjtyrq(simpleDateFormat.parse(csvRecord.get("ZJTYRQ"))
			 * ); } catch (ParseException e) { e.printStackTrace(); } }
			 * pmsItemRingMainUnit.setZcxz(csvRecord.get("ZCXZ"));
			 * 
			 * if (!(null == csvRecord.get("SL"))) { if
			 * (csvRecord.get("SL").trim().isEmpty()) { pmsItemRingMainUnit.setSl(new
			 * Double(0.0)); } else { try {
			 * pmsItemRingMainUnit.setSl(df.parse(csvRecord.get("SL")).doubleValue()); }
			 * catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } } if (!(null == csvRecord.get("SL1"))) { if
			 * (csvRecord.get("SL1").trim().isEmpty()) { pmsItemRingMainUnit.setSl1(new
			 * Double(0.0)); } else { try {
			 * pmsItemRingMainUnit.setSl1(df.parse(csvRecord.get("SL1")).doubleValue()); }
			 * catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } } if (!(null == csvRecord.get("SL2"))) { if
			 * (csvRecord.get("SL2").trim().isEmpty()) { pmsItemRingMainUnit.setSl2(new
			 * Double(0.0)); } else { try {
			 * pmsItemRingMainUnit.setSl2(df.parse(csvRecord.get("SL2")).doubleValue()); }
			 * catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } }
			 * 
			 * pmsItemRingMainUnit.setZzsmc(csvRecord.get("ZZSMC"));
			 * pmsItemRingMainUnit.setSsxlbdz(csvRecord.get("SSXLBDZ"));
			 * pmsItemRingMainUnit.setSbxh(csvRecord.get("SBXH")); if
			 * (csvRecord.get("TYNF").trim().isEmpty()) { pmsItemRingMainUnit.setTynf(new
			 * Short("0")); } else { pmsItemRingMainUnit.setTynf(new
			 * Short(csvRecord.get("TYNF"))); }
			 * pmsItemRingMainUnit.setNnd(csvRecord.get("NND")); if
			 * (!csvRecord.get("TYRQ").trim().isEmpty()) { try {
			 * pmsItemRingMainUnit.setTyrq(simpleDateFormat.parse(csvRecord.get("TYRQ"))); }
			 * catch (ParseException e) { e.printStackTrace(); } } if
			 * (csvRecord.get("NN").trim().isEmpty()) { pmsItemRingMainUnit.setNn(new
			 * Short("0")); } else { pmsItemRingMainUnit.setNn(new
			 * Short(csvRecord.get("NN"))); }
			 * 
			 * pmsItemRingMainUnit.setQfzd(csvRecord.get("QFZD")); if
			 * (!csvRecord.get("CCRQ").trim().isEmpty()) { try {
			 * pmsItemRingMainUnit.setCcrq(simpleDateFormat.parse(csvRecord.get("CCRQ"))); }
			 * catch (ParseException e) { e.printStackTrace(); } } //
			 * pmsItemRingMainUnit.setZclxbm1(csvRecord.get("ZCLXBM1"));
			 * 
			 * pmsItemRingMainUnit.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			 * 
			 * pmsItemRingMainUnit.setAssetId(csvRecord.get("ASSET_ID"));
			 * pmsItemRingMainUnit.setEquipmentIncreaseMode(csvRecord.get(
			 * "EQUIPMENT_INCREASE_MODE")); pmsItemRingMainUnit.setDataSourceFile(pathStr);
			 * pmsItemRingMainUnit.setLineProperty(csvRecord.get("线路性质"));
			 * session.save(pmsItemRingMainUnit);
			 */

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvPmsItemToolsAdd(String pathStr, String dataVersion, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();

		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemTools pmsItemTools = new PmsItemTools();

			pmsItemTools.setCalYear(new Short(calYear));
			pmsItemTools.setVersion(dataVersion);

			pmsItemTools.setSbbm(csvRecord.get("设备编码"));
			pmsItemTools.setDwmx(csvRecord.get("单位明细"));
			pmsItemTools.setYwdw(csvRecord.get("运维单位"));
			pmsItemTools.setZckbm(csvRecord.get("自动匹配的资产卡片编码"));
			pmsItemTools.setSblx(csvRecord.get("设备类型"));
			if (csvRecord.get("资产原值").trim().isEmpty()) {
				pmsItemTools.setZcyz(new Double(0.0));
			} else {
				pmsItemTools.setZcyz(new Double(csvRecord.get("资产原值")));
			}
			pmsItemTools.setZcdl(csvRecord.get("资产大类"));
			pmsItemTools.setZclxbm(csvRecord.get("PMS设备类型编码"));
			pmsItemTools.setCwbm(csvRecord.get("资产细类编码"));
			pmsItemTools.setDydj(csvRecord.get("电压等级"));
			pmsItemTools.setYxzt(csvRecord.get("运行状态"));
			pmsItemTools.setJkzt(csvRecord.get("健康状态"));
			if (!csvRecord.get("最近投运日期").trim().isEmpty()) {
				try {
					pmsItemTools.setZjtyrq(simpleDateFormat.parse(csvRecord.get("最近投运日期")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			pmsItemTools.setZcxz(csvRecord.get("资产性质"));

			if (csvRecord.get("额定容量").trim().isEmpty()) {
				pmsItemTools.setSl(new Double(0.0));
			} else {
				try {
					pmsItemTools.setSl(df.parse(csvRecord.get("额定容量")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (!(null == csvRecord.get("电缆线路长度"))) {
				if (csvRecord.get("电缆线路长度").trim().isEmpty()) {
					pmsItemTools.setSl1(new Double(0.0));
				} else {
					try {
						pmsItemTools.setSl1(df.parse(csvRecord.get("电缆线路长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (!(null == csvRecord.get("架空线路长度"))) {
				if (csvRecord.get("架空线路长度").trim().isEmpty()) {
					pmsItemTools.setSl2(new Double(0.0));
				} else {
					try {
						pmsItemTools.setSl2(df.parse(csvRecord.get("架空线路长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			/*
			 * if(!(null ==csvRecord.get("SL3"))){ if
			 * (csvRecord.get("SL3").trim().isEmpty()) { pmsItemTools.setSl3(new
			 * Double(0.0)); } else { try {
			 * pmsItemTools.setSl3(df.parse(csvRecord.get("SL3")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } }
			 */
			pmsItemTools.setZzsmc(csvRecord.get("制造商名称"));
			pmsItemTools.setSsxlbdz(csvRecord.get("所属变电站名称"));
			pmsItemTools.setSbxh(csvRecord.get("设备型号"));
			if (csvRecord.get("投运年份").trim().isEmpty()) {
				pmsItemTools.setTynf(new Short("0"));
			} else {
				pmsItemTools.setTynf(new Short(csvRecord.get("投运年份")));
			}
			pmsItemTools.setNnd(csvRecord.get("年龄段"));
			if (!csvRecord.get("投运日期").trim().isEmpty()) {
				try {
					pmsItemTools.setTyrq(simpleDateFormat.parse(csvRecord.get("投运日期")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (csvRecord.get("年龄").trim().isEmpty()) {
				pmsItemTools.setNn(new Short("0"));
			} else {
				pmsItemTools.setNn(new Short(csvRecord.get("年龄")));
			}

			pmsItemTools.setQfzd(csvRecord.get("区分字段"));
			if (!csvRecord.get("出厂日期").trim().isEmpty()) {
				try {
					pmsItemTools.setCcrq(simpleDateFormat.parse(csvRecord.get("出厂日期")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			// pmsItemTools.setZclxbm1(csvRecord.get("ZCLXBM1"));

			pmsItemTools.setEquipmentName(csvRecord.get("设备名称"));

			pmsItemTools.setAssetId(csvRecord.get("实物ID"));
			pmsItemTools.setEquipmentIncreaseMode(csvRecord.get("设备增加方式"));
			pmsItemTools.setLineProperty(csvRecord.get("线路性质"));
			// pmsItemTools.setJldw(csvRecord.get("计量单位"));
			pmsItemTools.setDataSourceFile(pathStr);

			session.save(pmsItemTools);
			/*
			 * pmsItemTools.setSbbm(csvRecord.get("SBBM"));
			 * pmsItemTools.setDwmx(csvRecord.get("DWMX"));
			 * pmsItemTools.setYwdw(csvRecord.get("YWDW"));
			 * pmsItemTools.setZckbm(csvRecord.get("ZCKBM"));
			 * pmsItemTools.setSblx(csvRecord.get("SBLX")); if
			 * (csvRecord.get("ZCYZ").trim().isEmpty()) { pmsItemTools.setZcyz(new
			 * Double(0.0)); } else { pmsItemTools.setZcyz(new
			 * Double(csvRecord.get("ZCYZ"))); }
			 * pmsItemTools.setZcdl(csvRecord.get("ZCDL"));
			 * pmsItemTools.setZclxbm(csvRecord.get("ZCLXBM"));
			 * pmsItemTools.setCwbm(csvRecord.get("CWBM"));
			 * pmsItemTools.setDydj(csvRecord.get("DYDJ"));
			 * pmsItemTools.setYxzt(csvRecord.get("YXZT"));
			 * pmsItemTools.setJkzt(csvRecord.get("JKZT")); if
			 * (!csvRecord.get("ZJTYRQ").trim().isEmpty()) { try {
			 * pmsItemTools.setZjtyrq(simpleDateFormat.parse(csvRecord.get("ZJTYRQ"))); }
			 * catch (ParseException e) { e.printStackTrace(); } }
			 * pmsItemTools.setZcxz(csvRecord.get("ZCXZ"));
			 * 
			 * if (csvRecord.get("SL").trim().isEmpty()) { pmsItemTools.setSl(new
			 * Double(0.0)); } else { try {
			 * pmsItemTools.setSl(df.parse(csvRecord.get("SL")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } if (!(null == csvRecord.get("SL1"))) { if
			 * (csvRecord.get("SL1").trim().isEmpty()) { pmsItemTools.setSl1(new
			 * Double(0.0)); } else { try {
			 * pmsItemTools.setSl1(df.parse(csvRecord.get("SL1")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } } if (!(null == csvRecord.get("SL2"))) { if
			 * (csvRecord.get("SL2").trim().isEmpty()) { pmsItemTools.setSl2(new
			 * Double(0.0)); } else { try {
			 * pmsItemTools.setSl2(df.parse(csvRecord.get("SL2")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } }
			 * 
			 * pmsItemTools.setZzsmc(csvRecord.get("ZZSMC"));
			 * pmsItemTools.setSsxlbdz(csvRecord.get("SSXLBDZ"));
			 * pmsItemTools.setSbxh(csvRecord.get("SBXH")); if
			 * (csvRecord.get("TYNF").trim().isEmpty()) { pmsItemTools.setTynf(new
			 * Short("0")); } else { pmsItemTools.setTynf(new Short(csvRecord.get("TYNF")));
			 * } pmsItemTools.setNnd(csvRecord.get("NND")); if
			 * (!csvRecord.get("TYRQ").trim().isEmpty()) { try {
			 * pmsItemTools.setTyrq(simpleDateFormat.parse(csvRecord.get("TYRQ"))); } catch
			 * (ParseException e) { e.printStackTrace(); } } if
			 * (csvRecord.get("NN").trim().isEmpty()) { pmsItemTools.setNn(new Short("0"));
			 * } else { pmsItemTools.setNn(new Short(csvRecord.get("NN"))); }
			 * 
			 * pmsItemTools.setQfzd(csvRecord.get("QFZD")); if
			 * (!csvRecord.get("CCRQ").trim().isEmpty()) { try {
			 * pmsItemTools.setCcrq(simpleDateFormat.parse(csvRecord.get("CCRQ"))); } catch
			 * (ParseException e) { e.printStackTrace(); } } //
			 * pmsItemTools.setZclxbm1(csvRecord.get("ZCLXBM1"));
			 * 
			 * pmsItemTools.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			 * 
			 * pmsItemTools.setAssetId(csvRecord.get("ASSET_ID"));
			 * pmsItemTools.setEquipmentIncreaseMode(csvRecord.get("EQUIPMENT_INCREASE_MODE"
			 * )); pmsItemTools.setLineProperty(csvRecord.get("线路性质"));
			 * pmsItemTools.setDataSourceFile(pathStr);
			 * 
			 * session.save(pmsItemTools);
			 */

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriTechTransformRoughTableAdd(String pathStr, String dataVersion, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriTechTransformRoughTable oriTechTransformRoughTable = new OriTechTransformRoughTable();
			oriTechTransformRoughTable.setDataVersion(dataVersion);
			oriTechTransformRoughTable.setDataSourceFile(pathStr);

			oriTechTransformRoughTable.setCalYear(DateFormatUtil.parseDate(calYear));
			oriTechTransformRoughTable.setProjectId(csvRecord.get("PROJECT_ID"));
			if (csvRecord.get("PLANNED_YEAR").trim().isEmpty()) {
				oriTechTransformRoughTable.setPlannedYear(new Double(0.0));
			} else {
				oriTechTransformRoughTable.setPlannedYear(Double.parseDouble(csvRecord.get("PLANNED_YEAR")));
			}
			oriTechTransformRoughTable.setProfessionalCategory(csvRecord.get("PROFESSIONAL_CATEGORY"));
			oriTechTransformRoughTable.setProfessionalSegmentation(csvRecord.get("PROFESSIONAL_SEGMENTATION"));
			oriTechTransformRoughTable.setTransformationPurpose(csvRecord.get("TRANSFORMATION_PURPOSE"));
			if (csvRecord.get("TOTAL_INVESTMENT").trim().isEmpty()) {
				oriTechTransformRoughTable.setTotalInvestment(new Double(0.0));
			} else {
				oriTechTransformRoughTable.setTotalInvestment(Double.parseDouble(csvRecord.get("TOTAL_INVESTMENT")));
			}

			oriTechTransformRoughTable.setRecommendationBasis(csvRecord.get("RECOMMENDATION_BASIS"));
			;

			oriTechTransformRoughTable.setProfessionalInvestDirection(csvRecord.get("PROFESSIONAL_INVEST_DIRECTION"));
			session.save(oriTechTransformRoughTable);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriOverhaulRoughTableAdd(String pathStr, String dataVersion, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriOverhaulRoughTable oriOverhaulRoughTable = new OriOverhaulRoughTable();
			oriOverhaulRoughTable.setCalYear(DateFormatUtil.parseDate(calYear));
			oriOverhaulRoughTable.setDataVersion(dataVersion);
			oriOverhaulRoughTable.setDataSourceFile(pathStr);
			oriOverhaulRoughTable.setProjectId(csvRecord.get("PROJECT_ID"));
			if (csvRecord.get("PLANNED_YEAR").trim().isEmpty()) {
				oriOverhaulRoughTable.setPlannedYear(new Double(0.0));
			} else {
				oriOverhaulRoughTable.setPlannedYear(Double.parseDouble(csvRecord.get("PLANNED_YEAR")));
			}
			oriOverhaulRoughTable.setProfessionalCategory(csvRecord.get("PROFESSIONAL_CATEGORY"));
			oriOverhaulRoughTable.setProfessionalSegmentation(csvRecord.get("PROFESSIONAL_SEGMENTATION"));
			if (csvRecord.get("TOTAL_INVESTMENT").trim().isEmpty()) {
				oriOverhaulRoughTable.setTotalInvestment(new Double(0.0));
			} else {
				oriOverhaulRoughTable.setTotalInvestment(Double.parseDouble(csvRecord.get("TOTAL_INVESTMENT")));
			}
			oriOverhaulRoughTable.setProjectBasis(csvRecord.get("PROJECT_BASIS"));
			;
			oriOverhaulRoughTable.setProfessionalInvestDirection(csvRecord.get("PROFESSIONAL_INVEST_DIRECTION"));

			session.save(oriOverhaulRoughTable);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvPmsItemTransSetAdd(String pathStr, String dataVersion, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemTransSet pmsItemTransSet = new PmsItemTransSet();
			pmsItemTransSet.setCalYear(new Short(calYear));
			pmsItemTransSet.setVersion(dataVersion);
			pmsItemTransSet.setDataSourceFile(pathStr);

			pmsItemTransSet.setSbbm(csvRecord.get("设备编码"));
			pmsItemTransSet.setDwmx(csvRecord.get("单位明细"));
			pmsItemTransSet.setYwdw(csvRecord.get("运维单位"));
			pmsItemTransSet.setZckbm(csvRecord.get("自动匹配的资产卡片编码"));
			pmsItemTransSet.setSblx(csvRecord.get("设备类型"));
			if (csvRecord.get("资产原值").trim().isEmpty()) {
				pmsItemTransSet.setZcyz(new Double(0.0));
			} else {
				pmsItemTransSet.setZcyz(new Double(csvRecord.get("资产原值")));
			}
			pmsItemTransSet.setZcdl(csvRecord.get("资产大类"));
			pmsItemTransSet.setZclxbm(csvRecord.get("PMS设备类型编码"));
			pmsItemTransSet.setCwbm(csvRecord.get("资产细类编码"));
			pmsItemTransSet.setDydj(csvRecord.get("电压等级"));
			pmsItemTransSet.setYxzt(csvRecord.get("运行状态"));
			pmsItemTransSet.setJkzt(csvRecord.get("健康状态"));
			if (!csvRecord.get("最近投运日期").trim().isEmpty()) {
				try {
					pmsItemTransSet.setZjtyrq(simpleDateFormat.parse(csvRecord.get("最近投运日期")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			pmsItemTransSet.setZcxz(csvRecord.get("资产性质"));
			if (csvRecord.get("额定容量").trim().isEmpty()) {
				pmsItemTransSet.setSl(new Double(0.0));
			} else {
				try {
					pmsItemTransSet.setSl(df.parse(csvRecord.get("额定容量")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (!(null == csvRecord.get("电缆线路长度"))) {
				if (csvRecord.get("电缆线路长度").trim().isEmpty()) {
					pmsItemTransSet.setSl1(new Double(0.0));
				} else {
					try {
						pmsItemTransSet.setSl1(df.parse(csvRecord.get("电缆线路长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (!(null == csvRecord.get("架空线路长度"))) {
				if (csvRecord.get("架空线路长度").trim().isEmpty()) {
					pmsItemTransSet.setSl2(new Double(0.0));
				} else {
					try {
						pmsItemTransSet.setSl2(df.parse(csvRecord.get("架空线路长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} /*
				 * if(!(null ==csvRecord.get("SL3"))){ if
				 * (csvRecord.get("SL3").trim().isEmpty()) { pmsItemTransSet.setSl3(new
				 * Double(0.0)); } else { try { pmsItemTransSet.setSl3(new
				 * DecimalFormat().parse(csvRecord.get("SL3")).doubleValue()); } catch
				 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
				 * } } }
				 */
			// pmsItemTransSet.setJldw(csvRecord.get("JLDW"));
			pmsItemTransSet.setZzsmc(csvRecord.get("制造商名称"));
			pmsItemTransSet.setSsxlbdz(csvRecord.get("所属变电站名称"));
			pmsItemTransSet.setSbxh(csvRecord.get("设备型号"));
			if (csvRecord.get("投运年份").trim().isEmpty()) {
				pmsItemTransSet.setTynf(new Short("0"));
			} else {
				pmsItemTransSet.setTynf(new Short(csvRecord.get("投运年份")));
			}
			pmsItemTransSet.setNnd(csvRecord.get("年龄段"));
			if (!csvRecord.get("投运日期").trim().isEmpty()) {
				try {
					pmsItemTransSet.setTyrq(simpleDateFormat.parse(csvRecord.get("投运日期")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (csvRecord.get("年龄").trim().isEmpty()) {
				pmsItemTransSet.setNn(new Short("0"));
			} else {
				pmsItemTransSet.setNn(new Short(csvRecord.get("年龄")));
			}
			pmsItemTransSet.setQfzd(csvRecord.get("区分字段"));

			if (!csvRecord.get("出厂日期").trim().isEmpty()) {
				try {
					pmsItemTransSet.setCcrq(simpleDateFormat.parse(csvRecord.get("出厂日期")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			pmsItemTransSet.setEquipmentName(csvRecord.get("设备名称"));
			// pmsItemTransSet.setJldw(csvRecord.get("计量单位"));

			pmsItemTransSet.setAssetId(csvRecord.get("实物ID"));
			pmsItemTransSet.setEquipmentIncreaseMode(csvRecord.get("设备增加方式"));
			pmsItemTransSet.setLineProperty(csvRecord.get("线路性质"));
			session.save(pmsItemTransSet);

			/*
			 * pmsItemTransSet.setSbbm(csvRecord.get("SBBM"));
			 * pmsItemTransSet.setDwmx(csvRecord.get("DWMX"));
			 * pmsItemTransSet.setYwdw(csvRecord.get("YWDW"));
			 * pmsItemTransSet.setZckbm(csvRecord.get("ZCKBM"));
			 * pmsItemTransSet.setSblx(csvRecord.get("SBLX")); if
			 * (csvRecord.get("ZCYZ").trim().isEmpty()) { pmsItemTransSet.setZcyz(new
			 * Double(0.0)); } else { pmsItemTransSet.setZcyz(new
			 * Double(csvRecord.get("ZCYZ"))); }
			 * pmsItemTransSet.setZcdl(csvRecord.get("ZCDL"));
			 * pmsItemTransSet.setZclxbm(csvRecord.get("ZCLXBM"));
			 * pmsItemTransSet.setCwbm(csvRecord.get("CWBM"));
			 * pmsItemTransSet.setDydj(csvRecord.get("DYDJ"));
			 * pmsItemTransSet.setYxzt(csvRecord.get("YXZT"));
			 * pmsItemTransSet.setJkzt(csvRecord.get("JKZT")); if
			 * (!csvRecord.get("ZJTYRQ").trim().isEmpty()) { try {
			 * pmsItemTransSet.setZjtyrq(simpleDateFormat.parse(csvRecord.get("ZJTYRQ"))); }
			 * catch (ParseException e) { e.printStackTrace(); } }
			 * pmsItemTransSet.setZcxz(csvRecord.get("ZCXZ")); if
			 * (csvRecord.get("SL").trim().isEmpty()) { pmsItemTransSet.setSl(new
			 * Double(0.0)); } else { try {
			 * pmsItemTransSet.setSl(df.parse(csvRecord.get("SL")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } }
			 * 
			 * if (!(null == csvRecord.get("SL1"))) { if
			 * (csvRecord.get("SL1").trim().isEmpty()) { pmsItemTransSet.setSl1(new
			 * Double(0.0)); } else { try {
			 * pmsItemTransSet.setSl1(df.parse(csvRecord.get("SL1")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } } if (!(null == csvRecord.get("SL2"))) { if
			 * (csvRecord.get("SL2").trim().isEmpty()) { pmsItemTransSet.setSl2(new
			 * Double(0.0)); } else { try {
			 * pmsItemTransSet.setSl2(df.parse(csvRecord.get("SL2")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } }
			 * 
			 * // pmsItemTransSet.setJldw(csvRecord.get("JLDW"));
			 * pmsItemTransSet.setZzsmc(csvRecord.get("ZZSMC"));
			 * pmsItemTransSet.setSsxlbdz(csvRecord.get("SSXLBDZ"));
			 * pmsItemTransSet.setSbxh(csvRecord.get("SBXH")); if
			 * (csvRecord.get("TYNF").trim().isEmpty()) { pmsItemTransSet.setTynf(new
			 * Short("0")); } else { pmsItemTransSet.setTynf(new
			 * Short(csvRecord.get("TYNF"))); }
			 * pmsItemTransSet.setNnd(csvRecord.get("NND")); if
			 * (!csvRecord.get("TYRQ").trim().isEmpty()) { try {
			 * pmsItemTransSet.setTyrq(simpleDateFormat.parse(csvRecord.get("TYRQ"))); }
			 * catch (ParseException e) { e.printStackTrace(); } } if
			 * (csvRecord.get("NN").trim().isEmpty()) { pmsItemTransSet.setNn(new
			 * Short("0")); } else { pmsItemTransSet.setNn(new Short(csvRecord.get("NN")));
			 * } pmsItemTransSet.setQfzd(csvRecord.get("QFZD"));
			 * 
			 * if (!csvRecord.get("CCRQ").trim().isEmpty()) { try {
			 * pmsItemTransSet.setCcrq(simpleDateFormat.parse(csvRecord.get("CCRQ"))); }
			 * catch (ParseException e) { e.printStackTrace(); } }
			 * 
			 * pmsItemTransSet.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			 * 
			 * pmsItemTransSet.setAssetId(csvRecord.get("ASSET_ID"));
			 * pmsItemTransSet.setEquipmentIncreaseMode(csvRecord.get(
			 * "EQUIPMENT_INCREASE_MODE")); pmsItemTransSet.setDataSourceFile(pathStr);
			 * 
			 * session.save(pmsItemTransSet);
			 */
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvPmsItemLowVoltPlatAdd(String pathStr, String dataVersion, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM月-yy");

		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemLowVoltPlat pmsItemLowVoltPlat = new PmsItemLowVoltPlat();
			pmsItemLowVoltPlat.setCalYear(new Short(calYear));
			pmsItemLowVoltPlat.setDataSourceFile(pathStr);
			pmsItemLowVoltPlat.setVersion(dataVersion);

			pmsItemLowVoltPlat.setSbbm(csvRecord.get("SBBM"));
			pmsItemLowVoltPlat.setDwmx(csvRecord.get("DWMX"));
			pmsItemLowVoltPlat.setYwdw(csvRecord.get("YWDW"));
			pmsItemLowVoltPlat.setZckbm(csvRecord.get("ZCKBM"));
			pmsItemLowVoltPlat.setSblx(csvRecord.get("SBLX"));
			if (csvRecord.get("ZCYZ").trim().isEmpty()) {
				pmsItemLowVoltPlat.setZcyz(new Double(0.0));
			} else {
				try {
					pmsItemLowVoltPlat.setZcyz(df.parse(csvRecord.get("ZCYZ")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			pmsItemLowVoltPlat.setZcdl(csvRecord.get("ZCDL"));
			pmsItemLowVoltPlat.setZclxbm(csvRecord.get("ZCLXBM"));
			pmsItemLowVoltPlat.setCwbm(csvRecord.get("CWBM"));
			pmsItemLowVoltPlat.setDydj(csvRecord.get("DYDJ"));
			pmsItemLowVoltPlat.setYxzt(csvRecord.get("YXZT"));
			pmsItemLowVoltPlat.setJkzt(csvRecord.get("JKZT"));

			// System.out.println(!csvRecord.get("ZJTYRQ").trim().isEmpty());
			// System.out.println(csvRecord.get("ZJTYRQ").trim());
			if (!csvRecord.get("ZJTYRQ").trim().isEmpty()) {
				try {
					System.out.println(csvRecord.get("ZJTYRQ"));
					pmsItemLowVoltPlat.setZjtyrq(simpleDateFormat.parse(csvRecord.get("ZJTYRQ").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			pmsItemLowVoltPlat.setZcxz(csvRecord.get("ZCXZ"));

			if (csvRecord.get("SL").trim().isEmpty()) {
				pmsItemLowVoltPlat.setSl(new Double(0.0));
			} else {
				try {
					pmsItemLowVoltPlat.setSl(df.parse(csvRecord.get("SL")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (!(null == csvRecord.get("SL1"))) {
				if (csvRecord.get("SL1").trim().isEmpty()) {
					pmsItemLowVoltPlat.setSl1(new Double(0.0));
				} else {
					try {
						pmsItemLowVoltPlat.setSl1(df.parse(csvRecord.get("SL1")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (!(null == csvRecord.get("SL2"))) {
				if (csvRecord.get("SL2").trim().isEmpty()) {
					pmsItemLowVoltPlat.setSl2(new Double(0.0));
				} else {
					try {
						pmsItemLowVoltPlat.setSl2(df.parse(csvRecord.get("SL2")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			/*
			 * if(!(null ==csvRecord.get("SL3"))){ if
			 * (csvRecord.get("SL3").trim().isEmpty()) { pmsItemLowVoltPlat.setSl3(new
			 * Double(0.0)); } else { try { pmsItemLowVoltPlat.setSl3(new
			 * DecimalFormat().parse(csvRecord.get("SL3")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } }
			 */
			pmsItemLowVoltPlat.setZzsmc(csvRecord.get("ZZSMC"));
			pmsItemLowVoltPlat.setSsxlbdz(csvRecord.get("SSXLBDZ"));
			pmsItemLowVoltPlat.setSbxh(csvRecord.get("SBXH"));
			if (csvRecord.get("TYNF").trim().isEmpty()) {
				pmsItemLowVoltPlat.setTynf(new Short("0"));
			} else {
				try {
					pmsItemLowVoltPlat.setTynf(df.parse(csvRecord.get("TYNF")).shortValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			pmsItemLowVoltPlat.setNnd(csvRecord.get("NND"));
			if (!csvRecord.get("TYRQ").trim().isEmpty()) {
				try {
					pmsItemLowVoltPlat.setTyrq(simpleDateFormat2.parse(csvRecord.get("TYRQ").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (csvRecord.get("NN").trim().isEmpty()) {
				pmsItemLowVoltPlat.setNn(new Short("0"));
			} else {
				try {
					pmsItemLowVoltPlat.setNn(df.parse(csvRecord.get("NN")).shortValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			pmsItemLowVoltPlat.setQfzd(csvRecord.get("QFZD"));
			if (!csvRecord.get("CCRQ").trim().isEmpty()) {
				try {
					pmsItemLowVoltPlat.setCcrq(simpleDateFormat2.parse(csvRecord.get("CCRQ").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			// pmsItemLowVoltPlat.setZclxbm1(csvRecord.get("ZCLXBM1"));

			pmsItemLowVoltPlat.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));

			pmsItemLowVoltPlat.setAssetId(csvRecord.get("ASSET_ID"));
			pmsItemLowVoltPlat.setEquipmentIncreaseMode(csvRecord.get("EQUIPMENT_INCREASE_MODE"));

			session.save(pmsItemLowVoltPlat);
			/*
			 * pmsItemLowVoltPlat.setSbbm(csvRecord.get("SBBM"));
			 * pmsItemLowVoltPlat.setDwmx(csvRecord.get("DWMX"));
			 * pmsItemLowVoltPlat.setYwdw(csvRecord.get("YWDW"));
			 * pmsItemLowVoltPlat.setZckbm(csvRecord.get("ZCKBM"));
			 * pmsItemLowVoltPlat.setSblx(csvRecord.get("SBLX")); if
			 * (csvRecord.get("ZCYZ").trim().isEmpty()) { pmsItemLowVoltPlat.setZcyz(new
			 * Double(0.0)); } else { try {
			 * pmsItemLowVoltPlat.setZcyz(df.parse(csvRecord.get("ZCYZ")).doubleValue()); }
			 * catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } pmsItemLowVoltPlat.setZcdl(csvRecord.get("ZCDL"));
			 * pmsItemLowVoltPlat.setZclxbm(csvRecord.get("ZCLXBM"));
			 * pmsItemLowVoltPlat.setCwbm(csvRecord.get("CWBM"));
			 * pmsItemLowVoltPlat.setDydj(csvRecord.get("DYDJ"));
			 * pmsItemLowVoltPlat.setYxzt(csvRecord.get("YXZT"));
			 * pmsItemLowVoltPlat.setJkzt(csvRecord.get("JKZT"));
			 * 
			 * // System.out.println(!csvRecord.get("ZJTYRQ").trim().isEmpty()); //
			 * System.out.println(csvRecord.get("ZJTYRQ").trim()); if
			 * (!csvRecord.get("ZJTYRQ").trim().isEmpty()) { try {
			 * System.out.println(csvRecord.get("ZJTYRQ"));
			 * pmsItemLowVoltPlat.setZjtyrq(simpleDateFormat.parse(csvRecord.get("ZJTYRQ").
			 * replace(" ", ""))); } catch (ParseException e) { e.printStackTrace(); } }
			 * pmsItemLowVoltPlat.setZcxz(csvRecord.get("ZCXZ"));
			 * 
			 * if (csvRecord.get("SL").trim().isEmpty()) { pmsItemLowVoltPlat.setSl(new
			 * Double(0.0)); } else { try {
			 * pmsItemLowVoltPlat.setSl(df.parse(csvRecord.get("SL")).doubleValue()); }
			 * catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } if (!(null == csvRecord.get("SL1"))) { if
			 * (csvRecord.get("SL1").trim().isEmpty()) { pmsItemLowVoltPlat.setSl1(new
			 * Double(0.0)); } else { try {
			 * pmsItemLowVoltPlat.setSl1(df.parse(csvRecord.get("SL1")).doubleValue()); }
			 * catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } } if (!(null == csvRecord.get("SL2"))) { if
			 * (csvRecord.get("SL2").trim().isEmpty()) { pmsItemLowVoltPlat.setSl2(new
			 * Double(0.0)); } else { try {
			 * pmsItemLowVoltPlat.setSl2(df.parse(csvRecord.get("SL2")).doubleValue()); }
			 * catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } }
			 * 
			 * pmsItemLowVoltPlat.setZzsmc(csvRecord.get("ZZSMC"));
			 * pmsItemLowVoltPlat.setSsxlbdz(csvRecord.get("SSXLBDZ"));
			 * pmsItemLowVoltPlat.setSbxh(csvRecord.get("SBXH")); if
			 * (csvRecord.get("TYNF").trim().isEmpty()) { pmsItemLowVoltPlat.setTynf(new
			 * Short("0")); } else { try {
			 * pmsItemLowVoltPlat.setTynf(df.parse(csvRecord.get("TYNF")).shortValue()); }
			 * catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } }
			 * 
			 * pmsItemLowVoltPlat.setNnd(csvRecord.get("NND")); if
			 * (!csvRecord.get("TYRQ").trim().isEmpty()) { try {
			 * pmsItemLowVoltPlat.setTyrq(simpleDateFormat2.parse(csvRecord.get("TYRQ").
			 * replace(" ", ""))); } catch (ParseException e) { e.printStackTrace(); } } if
			 * (csvRecord.get("NN").trim().isEmpty()) { pmsItemLowVoltPlat.setNn(new
			 * Short("0")); } else { try {
			 * pmsItemLowVoltPlat.setNn(df.parse(csvRecord.get("NN")).shortValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } }
			 * 
			 * pmsItemLowVoltPlat.setQfzd(csvRecord.get("QFZD")); if
			 * (!csvRecord.get("CCRQ").trim().isEmpty()) { try {
			 * pmsItemLowVoltPlat.setCcrq(simpleDateFormat2.parse(csvRecord.get("CCRQ").
			 * replace(" ", ""))); } catch (ParseException e) { e.printStackTrace(); } } //
			 * pmsItemLowVoltPlat.setZclxbm1(csvRecord.get("ZCLXBM1"));
			 * 
			 * pmsItemLowVoltPlat.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			 * 
			 * pmsItemLowVoltPlat.setAssetId(csvRecord.get("ASSET_ID"));
			 * pmsItemLowVoltPlat.setEquipmentIncreaseMode(csvRecord.get(
			 * "EQUIPMENT_INCREASE_MODE")); pmsItemLowVoltPlat.setDataSourceFile(pathStr);
			 * 
			 * session.save(pmsItemLowVoltPlat);
			 */

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvTableDataImport(String pathStr, String dataVersion, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery(
				"SELECT PROERTY_NAME,FIELD_NAME FROM PROPERTY_FIELD_MATCH_TABLE WHERE " + " TABLE_NAME=? ;");

		query.list();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemShuLine pmsItemShuLine = new PmsItemShuLine();
			// pmsItemShuLine.setCalYear(new
			// Short(dataVersion.substring(dataVersion.indexOf("_")+1,dataVersion.indexOf("_")+5)));
			pmsItemShuLine.setCalYear(new Short(calYear));
			pmsItemShuLine.setVersion(dataVersion);
			pmsItemShuLine.setDataSourceFile(pathStr);

			pmsItemShuLine.setSbbm(csvRecord.get("设备编码"));
			pmsItemShuLine.setDwmx(csvRecord.get("单位明细"));
			pmsItemShuLine.setYwdw(csvRecord.get("运维单位"));
			pmsItemShuLine.setZckbm(csvRecord.get("自动匹配的资产卡片编码"));
			pmsItemShuLine.setSblx(csvRecord.get("设备类型"));
			if (csvRecord.get("资产原值").trim().isEmpty()) {
				pmsItemShuLine.setZcyz(new Double(0.0));
			} else {
				try {
					pmsItemShuLine.setZcyz(df.parse(csvRecord.get("资产原值")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			pmsItemShuLine.setZcdl(csvRecord.get("资产大类"));
			pmsItemShuLine.setZclxbm(csvRecord.get("PMS设备类型编码"));
			pmsItemShuLine.setCwbm(csvRecord.get("资产细类编码"));
			pmsItemShuLine.setDydj(csvRecord.get("电压等级"));
			pmsItemShuLine.setYxzt(csvRecord.get("运行状态"));
			pmsItemShuLine.setJkzt(csvRecord.get("健康状态"));

			if (!csvRecord.get("最近投运日期").trim().isEmpty()) {
				try {
					pmsItemShuLine.setZjtyrq(simpleDateFormat.parse(csvRecord.get("最近投运日期").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			pmsItemShuLine.setZcxz(csvRecord.get("资产性质"));

			if (csvRecord.get("线路总长度").trim().isEmpty()) {
				pmsItemShuLine.setSl(new Double(0.0));
			} else {
				try {
					pmsItemShuLine.setSl(df.parse(csvRecord.get("线路总长度")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				if (!(null == csvRecord.get("电缆线路长度"))) {
					if (csvRecord.get("电缆线路长度").trim().isEmpty()) {
						pmsItemShuLine.setSl1(new Double(0.0));
					} else {
						try {
							pmsItemShuLine.setSl1(df.parse(csvRecord.get("电缆线路长度")).doubleValue());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				if (!(null == csvRecord.get("CABLE_LINE_LENGTH"))) {
					if (csvRecord.get("CABLE_LINE_LENGTH").trim().isEmpty()) {
						pmsItemShuLine.setSl1(new Double(0.0));
					} else {
						try {
							pmsItemShuLine.setSl1(df.parse(csvRecord.get("CABLE_LINE_LENGTH")).doubleValue());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			try {
				if (!(null == csvRecord.get("架空线路长度"))) {
					if (csvRecord.get("架空线路长度").trim().isEmpty()) {
						pmsItemShuLine.setSl2(new Double(0.0));
					} else {
						try {
							pmsItemShuLine.setSl2(df.parse(csvRecord.get("架空线路长度")).doubleValue());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				if (!(null == csvRecord.get("OVERHEAD_LINE_LENGTH"))) {
					if (csvRecord.get("OVERHEAD_LINE_LENGTH").trim().isEmpty()) {
						pmsItemShuLine.setSl2(new Double(0.0));
					} else {
						try {
							pmsItemShuLine.setSl2(df.parse(csvRecord.get("OVERHEAD_LINE_LENGTH")).doubleValue());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			pmsItemShuLine.setSl3(new Double(0.0));
			pmsItemShuLine.setZzsmc(csvRecord.get("制造商名称"));
			pmsItemShuLine.setSsxlbdz(csvRecord.get("所属线路名称"));
			pmsItemShuLine.setSbxh(csvRecord.get("设备型号"));
			if (csvRecord.get("投运年份").trim().isEmpty()) {
				pmsItemShuLine.setTynf(new Short("0"));
			} else {
				try {
					pmsItemShuLine.setTynf(df.parse(csvRecord.get("投运年份")).shortValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			pmsItemShuLine.setNnd(csvRecord.get("年龄段"));
			if (!csvRecord.get("投运日期").trim().isEmpty()) {
				try {
					pmsItemShuLine.setTyrq(simpleDateFormat.parse(csvRecord.get("投运日期").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (csvRecord.get("年龄").trim().isEmpty()) {
				pmsItemShuLine.setNn(new Short("0"));
			} else {
				try {
					pmsItemShuLine.setNn(df.parse(csvRecord.get("年龄")).shortValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			pmsItemShuLine.setQfzd(csvRecord.get("区分字段"));
			if (!csvRecord.get("出厂日期").trim().isEmpty()) {
				try {
					pmsItemShuLine.setCcrq(simpleDateFormat.parse(csvRecord.get("出厂日期").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			pmsItemShuLine.setEquipmentName(csvRecord.get("线路名称"));

			pmsItemShuLine.setAssetId(csvRecord.get("实物ID"));
			pmsItemShuLine.setEquipmentIncreaseMode(csvRecord.get("设备增加方式"));
			pmsItemShuLine.setLineProperty(csvRecord.get("线路性质"));

			session.save(pmsItemShuLine);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvPmsItemShuLineAdd(String pathStr, String dataVersion, String calYear) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemShuLine pmsItemShuLine = new PmsItemShuLine();
			// pmsItemShuLine.setCalYear(new
			// Short(dataVersion.substring(dataVersion.indexOf("_")+1,dataVersion.indexOf("_")+5)));
			pmsItemShuLine.setCalYear(new Short(calYear));
			pmsItemShuLine.setVersion(dataVersion);
			pmsItemShuLine.setDataSourceFile(pathStr);

			pmsItemShuLine.setSbbm(csvRecord.get("设备编码"));
			pmsItemShuLine.setDwmx(csvRecord.get("单位明细"));
			pmsItemShuLine.setYwdw(csvRecord.get("运维单位"));
			pmsItemShuLine.setZckbm(csvRecord.get("自动匹配的资产卡片编码"));
			pmsItemShuLine.setSblx(csvRecord.get("设备类型"));
			if (csvRecord.get("资产原值").trim().isEmpty()) {
				pmsItemShuLine.setZcyz(new Double(0.0));
			} else {
				try {
					pmsItemShuLine.setZcyz(df.parse(csvRecord.get("资产原值")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			pmsItemShuLine.setZcdl(csvRecord.get("资产大类"));
			pmsItemShuLine.setZclxbm(csvRecord.get("PMS设备类型编码"));
			pmsItemShuLine.setCwbm(csvRecord.get("资产细类编码"));
			pmsItemShuLine.setDydj(csvRecord.get("电压等级"));
			pmsItemShuLine.setYxzt(csvRecord.get("运行状态"));
			pmsItemShuLine.setJkzt(csvRecord.get("健康状态"));

			if (!csvRecord.get("最近投运日期").trim().isEmpty()) {
				try {
					pmsItemShuLine.setZjtyrq(simpleDateFormat.parse(csvRecord.get("最近投运日期").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			pmsItemShuLine.setZcxz(csvRecord.get("资产性质"));

			if (csvRecord.get("线路总长度").trim().isEmpty()) {
				pmsItemShuLine.setSl(new Double(0.0));
			} else {
				try {
					pmsItemShuLine.setSl(df.parse(csvRecord.get("线路总长度")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				if (!(null == csvRecord.get("电缆线路长度"))) {
					if (csvRecord.get("电缆线路长度").trim().isEmpty()) {
						pmsItemShuLine.setSl1(new Double(0.0));
					} else {
						try {
							pmsItemShuLine.setSl1(df.parse(csvRecord.get("电缆线路长度")).doubleValue());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				if (!(null == csvRecord.get("CABLE_LINE_LENGTH"))) {
					if (csvRecord.get("CABLE_LINE_LENGTH").trim().isEmpty()) {
						pmsItemShuLine.setSl1(new Double(0.0));
					} else {
						try {
							pmsItemShuLine.setSl1(df.parse(csvRecord.get("CABLE_LINE_LENGTH")).doubleValue());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			try {
				if (!(null == csvRecord.get("架空线路长度"))) {
					if (csvRecord.get("架空线路长度").trim().isEmpty()) {
						pmsItemShuLine.setSl2(new Double(0.0));
					} else {
						try {
							pmsItemShuLine.setSl2(df.parse(csvRecord.get("架空线路长度")).doubleValue());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				if (!(null == csvRecord.get("OVERHEAD_LINE_LENGTH"))) {
					if (csvRecord.get("OVERHEAD_LINE_LENGTH").trim().isEmpty()) {
						pmsItemShuLine.setSl2(new Double(0.0));
					} else {
						try {
							pmsItemShuLine.setSl2(df.parse(csvRecord.get("OVERHEAD_LINE_LENGTH")).doubleValue());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			pmsItemShuLine.setSl3(new Double(0.0));
			pmsItemShuLine.setZzsmc(csvRecord.get("制造商名称"));
			pmsItemShuLine.setSsxlbdz(csvRecord.get("所属线路名称"));
			pmsItemShuLine.setSbxh(csvRecord.get("设备型号"));
			if (csvRecord.get("投运年份").trim().isEmpty()) {
				pmsItemShuLine.setTynf(new Short("0"));
			} else {
				try {
					pmsItemShuLine.setTynf(df.parse(csvRecord.get("投运年份")).shortValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			pmsItemShuLine.setNnd(csvRecord.get("年龄段"));
			if (!csvRecord.get("投运日期").trim().isEmpty()) {
				try {
					pmsItemShuLine.setTyrq(simpleDateFormat.parse(csvRecord.get("投运日期").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (csvRecord.get("年龄").trim().isEmpty()) {
				pmsItemShuLine.setNn(new Short("0"));
			} else {
				try {
					pmsItemShuLine.setNn(df.parse(csvRecord.get("年龄")).shortValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			pmsItemShuLine.setQfzd(csvRecord.get("区分字段"));
			if (!csvRecord.get("出厂日期").trim().isEmpty()) {
				try {
					pmsItemShuLine.setCcrq(simpleDateFormat.parse(csvRecord.get("出厂日期").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			pmsItemShuLine.setEquipmentName(csvRecord.get("线路名称"));

			pmsItemShuLine.setAssetId(csvRecord.get("实物ID"));
			pmsItemShuLine.setEquipmentIncreaseMode(csvRecord.get("设备增加方式"));
			pmsItemShuLine.setLineProperty(csvRecord.get("线路性质"));

			session.save(pmsItemShuLine);

			/*
			 * pmsItemShuLine.setSbbm(csvRecord.get("SBBM"));
			 * pmsItemShuLine.setDwmx(csvRecord.get("DWMX"));
			 * pmsItemShuLine.setYwdw(csvRecord.get("YWDW"));
			 * pmsItemShuLine.setZckbm(csvRecord.get("ZCKBM"));
			 * pmsItemShuLine.setSblx(csvRecord.get("SBLX")); if
			 * (csvRecord.get("ZCYZ").trim().isEmpty()) { pmsItemShuLine.setZcyz(new
			 * Double(0.0)); } else { try {
			 * pmsItemShuLine.setZcyz(df.parse(csvRecord.get("ZCYZ")).doubleValue()); }
			 * catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } pmsItemShuLine.setZcdl(csvRecord.get("ZCDL"));
			 * pmsItemShuLine.setZclxbm(csvRecord.get("ZCLXBM"));
			 * pmsItemShuLine.setCwbm(csvRecord.get("CWBM"));
			 * pmsItemShuLine.setDydj(csvRecord.get("DYDJ"));
			 * pmsItemShuLine.setYxzt(csvRecord.get("YXZT"));
			 * pmsItemShuLine.setJkzt(csvRecord.get("JKZT"));
			 * 
			 * // System.out.println(!csvRecord.get("ZJTYRQ").trim().isEmpty()); //
			 * System.out.println(csvRecord.get("ZJTYRQ").trim()); if
			 * (!csvRecord.get("ZJTYRQ").trim().isEmpty()) { try { //
			 * System.out.println(csvRecord.get("ZJTYRQ"));
			 * pmsItemShuLine.setZjtyrq(simpleDateFormat.parse(csvRecord.get("ZJTYRQ").
			 * replace(" ", ""))); } catch (ParseException e) { e.printStackTrace(); } }
			 * pmsItemShuLine.setZcxz(csvRecord.get("ZCXZ"));
			 * 
			 * if (csvRecord.get("SL").trim().isEmpty()) { pmsItemShuLine.setSl(new
			 * Double(0.0)); } else { try {
			 * pmsItemShuLine.setSl(df.parse(csvRecord.get("SL")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } try { if (!(null == csvRecord.get("SL1"))) { if
			 * (csvRecord.get("SL1").trim().isEmpty()) { pmsItemShuLine.setSl1(new
			 * Double(0.0)); } else { try {
			 * pmsItemShuLine.setSl1(df.parse(csvRecord.get("SL1")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } } } catch (Exception e) { // TODO: handle exception if (!(null ==
			 * csvRecord.get("CABLE_LINE_LENGTH"))) { if
			 * (csvRecord.get("CABLE_LINE_LENGTH").trim().isEmpty()) {
			 * pmsItemShuLine.setSl1(new Double(0.0)); } else { try {
			 * pmsItemShuLine.setSl1(df.parse(csvRecord.get("CABLE_LINE_LENGTH")).
			 * doubleValue()); } catch (ParseException e1) { // TODO Auto-generated catch
			 * block e1.printStackTrace(); } } } } try { if (!(null ==
			 * csvRecord.get("SL2"))) { if (csvRecord.get("SL2").trim().isEmpty()) {
			 * pmsItemShuLine.setSl2(new Double(0.0)); } else { try {
			 * pmsItemShuLine.setSl2(df.parse(csvRecord.get("SL2")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } } } catch (Exception e) { // TODO: handle exception if (!(null ==
			 * csvRecord.get("OVERHEAD_LINE_LENGTH"))) { if
			 * (csvRecord.get("OVERHEAD_LINE_LENGTH").trim().isEmpty()) {
			 * pmsItemShuLine.setSl2(new Double(0.0)); } else { try {
			 * pmsItemShuLine.setSl2(df.parse(csvRecord.get("OVERHEAD_LINE_LENGTH")).
			 * doubleValue()); } catch (ParseException e1) { // TODO Auto-generated catch
			 * block e1.printStackTrace(); } } } }
			 * 
			 * pmsItemShuLine.setZzsmc(csvRecord.get("ZZSMC"));
			 * pmsItemShuLine.setSsxlbdz(csvRecord.get("SSXLBDZ"));
			 * pmsItemShuLine.setSbxh(csvRecord.get("SBXH")); if
			 * (csvRecord.get("TYNF").trim().isEmpty()) { pmsItemShuLine.setTynf(new
			 * Short("0")); } else { try {
			 * pmsItemShuLine.setTynf(df.parse(csvRecord.get("TYNF")).shortValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } }
			 * 
			 * pmsItemShuLine.setNnd(csvRecord.get("NND")); if
			 * (!csvRecord.get("TYRQ").trim().isEmpty()) { try {
			 * pmsItemShuLine.setTyrq(simpleDateFormat.parse(csvRecord.get("TYRQ").
			 * replace(" ", ""))); } catch (ParseException e) { e.printStackTrace(); } } if
			 * (csvRecord.get("NN").trim().isEmpty()) { pmsItemShuLine.setNn(new
			 * Short("0")); } else { try {
			 * pmsItemShuLine.setNn(df.parse(csvRecord.get("NN")).shortValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } }
			 * 
			 * pmsItemShuLine.setQfzd(csvRecord.get("QFZD")); if
			 * (!csvRecord.get("CCRQ").trim().isEmpty()) { try {
			 * pmsItemShuLine.setCcrq(simpleDateFormat.parse(csvRecord.get("CCRQ").
			 * replace(" ", ""))); } catch (ParseException e) { e.printStackTrace(); } } //
			 * pmsItemShuLine.setZclxbm1(csvRecord.get("ZCLXBM1"));
			 * 
			 * pmsItemShuLine.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			 * 
			 * pmsItemShuLine.setAssetId(csvRecord.get("ASSET_ID"));
			 * pmsItemShuLine.setEquipmentIncreaseMode(csvRecord.get(
			 * "EQUIPMENT_INCREASE_MODE"));
			 * 
			 * session.save(pmsItemShuLine);
			 * 
			 */

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvPmsItemTransformersAdd(String pathStr, String dataVersion, String calYear)
			throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		format.getHeader();
		Iterator<CSVRecord> iterator = parser.iterator();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemTransformers pmsItemTransformers = new PmsItemTransformers();

			pmsItemTransformers.setCalYear(new Short(calYear));
			pmsItemTransformers.setVersion(dataVersion);
			pmsItemTransformers.setDataSourceFile(pathStr);

			pmsItemTransformers.setSbbm(csvRecord.get("设备编码"));
			pmsItemTransformers.setDwmx(csvRecord.get("单位明细"));
			pmsItemTransformers.setYwdw(csvRecord.get("运维单位"));
			pmsItemTransformers.setZckbm(csvRecord.get("自动匹配的资产卡片编码"));
			pmsItemTransformers.setSblx(csvRecord.get("设备类型"));
			if (csvRecord.get("资产原值").trim().isEmpty()) {
				pmsItemTransformers.setZcyz(new Double("0"));
			} else {
				pmsItemTransformers.setZcyz(new Double(csvRecord.get("资产原值")));
			}
			pmsItemTransformers.setZcdl(csvRecord.get("资产大类"));
			pmsItemTransformers.setZclxbm(csvRecord.get("PMS设备类型编码"));
			pmsItemTransformers.setCwbm(csvRecord.get("资产细类编码"));
			pmsItemTransformers.setDydj(csvRecord.get("电压等级"));
			pmsItemTransformers.setYxzt(csvRecord.get("运行状态"));
			pmsItemTransformers.setJkzt(csvRecord.get("健康状态"));
			if (!csvRecord.get("最近投运日期").trim().isEmpty()) {
				try {
					pmsItemTransformers.setZjtyrq(simpleDateFormat.parse(csvRecord.get("最近投运日期").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			pmsItemTransformers.setZcxz(csvRecord.get("资产性质"));
			if (csvRecord.get("额定容量").trim().isEmpty()) {
				pmsItemTransformers.setSl(new Double(0.0));
			} else {
				try {
					pmsItemTransformers.setSl(df.parse(csvRecord.get("额定容量")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (!(null == csvRecord.get("电缆线路长度"))) {
				if (csvRecord.get("电缆线路长度").trim().isEmpty()) {
					pmsItemTransformers.setSl1(new Double(0.0));
				} else {
					try {
						pmsItemTransformers.setSl1(df.parse(csvRecord.get("电缆线路长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (!(null == csvRecord.get("架空线路长度"))) {
				if (csvRecord.get("架空线路长度").trim().isEmpty()) {
					pmsItemTransformers.setSl2(new Double(0.0));
				} else {
					try {
						pmsItemTransformers.setSl2(df.parse(csvRecord.get("架空线路长度")).doubleValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			/*
			 * if(!(null ==csvRecord.get("SL3"))){ if
			 * (csvRecord.get("SL3").trim().isEmpty()) { pmsItemTransformers.setSl3(new
			 * Double(0.0)); } else { try { pmsItemTransformers.setSl3(new
			 * DecimalFormat().parse(csvRecord.get("SL3")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } }
			 */

			pmsItemTransformers.setZzsmc(csvRecord.get("制造商名称"));
			pmsItemTransformers.setSsxlbdz(csvRecord.get("所属变电站名称"));
			pmsItemTransformers.setSbxh(csvRecord.get("设备型号"));
			if (csvRecord.get("投运年份").trim().isEmpty()) {
				pmsItemTransformers.setTynf(new Short("0"));
			} else {
				pmsItemTransformers.setTynf(new Short(csvRecord.get("投运年份")));
			}
			pmsItemTransformers.setNnd(csvRecord.get("年龄段"));
			if (!csvRecord.get("投运日期").trim().isEmpty()) {
				try {
					pmsItemTransformers.setTyrq(simpleDateFormat.parse(csvRecord.get("投运日期").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (csvRecord.get("年龄").trim().isEmpty()) {
				pmsItemTransformers.setNn(new Short("0"));
			} else {
				pmsItemTransformers.setNn(new Short(csvRecord.get("年龄")));
			}
			pmsItemTransformers.setQfzd(csvRecord.get("区分字段"));

			if (!csvRecord.get("出厂日期").trim().isEmpty()) {
				try {
					pmsItemTransformers.setCcrq(simpleDateFormat.parse(csvRecord.get("出厂日期").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			pmsItemTransformers.setEquipmentName(csvRecord.get("设备名称"));

			pmsItemTransformers.setAssetId(csvRecord.get("实物ID"));
			pmsItemTransformers.setEquipmentIncreaseMode(csvRecord.get("设备增加方式"));

			pmsItemTransformers.setLineProperty(csvRecord.get("线路性质"));
			// pmsItemTransformers.setJldw(csvRecord.get("计量单位"));

			session.save(pmsItemTransformers);
			/*
			 * pmsItemTransformers.setSbbm(csvRecord.get("SBBM"));
			 * pmsItemTransformers.setDwmx(csvRecord.get("DWMX"));
			 * pmsItemTransformers.setYwdw(csvRecord.get("YWDW"));
			 * pmsItemTransformers.setZckbm(csvRecord.get("ZCKBM"));
			 * pmsItemTransformers.setSblx(csvRecord.get("SBLX")); if
			 * (csvRecord.get("ZCYZ").trim().isEmpty()) { pmsItemTransformers.setZcyz(new
			 * Double("0")); } else { pmsItemTransformers.setZcyz(new
			 * Double(csvRecord.get("ZCYZ"))); }
			 * pmsItemTransformers.setZcdl(csvRecord.get("ZCDL"));
			 * pmsItemTransformers.setZclxbm(csvRecord.get("ZCLXBM"));
			 * pmsItemTransformers.setCwbm(csvRecord.get("CWBM"));
			 * pmsItemTransformers.setDydj(csvRecord.get("DYDJ"));
			 * pmsItemTransformers.setYxzt(csvRecord.get("YXZT"));
			 * pmsItemTransformers.setJkzt(csvRecord.get("JKZT")); if
			 * (!csvRecord.get("ZJTYRQ").trim().isEmpty()) { try {
			 * pmsItemTransformers.setZjtyrq(simpleDateFormat.parse(csvRecord.get("ZJTYRQ").
			 * replace(" ", ""))); } catch (ParseException e) { e.printStackTrace(); } }
			 * pmsItemTransformers.setZcxz(csvRecord.get("ZCXZ")); if
			 * (csvRecord.get("SL").trim().isEmpty()) { pmsItemTransformers.setSl(new
			 * Double(0.0)); } else { try {
			 * pmsItemTransformers.setSl(df.parse(csvRecord.get("SL")).doubleValue()); }
			 * catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } if (!(null == csvRecord.get("SL1"))) { if
			 * (csvRecord.get("SL1").trim().isEmpty()) { pmsItemTransformers.setSl1(new
			 * Double(0.0)); } else { try {
			 * pmsItemTransformers.setSl1(df.parse(csvRecord.get("SL1")).doubleValue()); }
			 * catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } } if (!(null == csvRecord.get("SL2"))) { if
			 * (csvRecord.get("SL2").trim().isEmpty()) { pmsItemTransformers.setSl2(new
			 * Double(0.0)); } else { try {
			 * pmsItemTransformers.setSl2(df.parse(csvRecord.get("SL2")).doubleValue()); }
			 * catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } }
			 * 
			 * 
			 * pmsItemTransformers.setZzsmc(csvRecord.get("ZZSMC"));
			 * pmsItemTransformers.setSsxlbdz(csvRecord.get("SSXLBDZ"));
			 * pmsItemTransformers.setSbxh(csvRecord.get("SBXH")); if
			 * (csvRecord.get("TYNF").trim().isEmpty()) { pmsItemTransformers.setTynf(new
			 * Short("0")); } else { pmsItemTransformers.setTynf(new
			 * Short(csvRecord.get("TYNF"))); }
			 * pmsItemTransformers.setNnd(csvRecord.get("NND")); if
			 * (!csvRecord.get("TYRQ").trim().isEmpty()) { try {
			 * pmsItemTransformers.setTyrq(simpleDateFormat.parse(csvRecord.get("TYRQ").
			 * replace(" ", ""))); } catch (ParseException e) { e.printStackTrace(); } } if
			 * (csvRecord.get("NN").trim().isEmpty()) { pmsItemTransformers.setNn(new
			 * Short("0")); } else { pmsItemTransformers.setNn(new
			 * Short(csvRecord.get("NN"))); }
			 * pmsItemTransformers.setQfzd(csvRecord.get("QFZD"));
			 * 
			 * if (!csvRecord.get("CCRQ").trim().isEmpty()) { try {
			 * pmsItemTransformers.setCcrq(simpleDateFormat.parse(csvRecord.get("CCRQ").
			 * replace(" ", ""))); } catch (ParseException e) { e.printStackTrace(); } }
			 * 
			 * // pmsItemTransformers.setZclxbm1(csvRecord.get("ZCLXBM1"));
			 * pmsItemTransformers.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			 * 
			 * pmsItemTransformers.setAssetId(csvRecord.get("ASSET_ID"));
			 * pmsItemTransformers.setEquipmentIncreaseMode(csvRecord.get(
			 * "EQUIPMENT_INCREASE_MODE")); pmsItemTransformers.setDataSourceFile(pathStr);
			 * 
			 * session.save(pmsItemTransformers);
			 */

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	/*
	 * public static void alterTableColumn(){ //临时字段名称 String tempFieldName =
	 * fieldName + "_TEMP_COL"; //第一步新增一个临时字段
	 * jdbcTemplate.execute(String.format(ADD_FIELD_TEMPLATE,
	 * tableName,tempFieldName,fieldType,length));
	 * 
	 * //第二步将要修改的字段数据更新到临时字段
	 * jdbcTemplate.update(String.format(UPDATE_FIELD_TEMPLATE,
	 * tableName,tempFieldName,fieldName));
	 * 
	 * //第三步将要修改的字段置空
	 * jdbcTemplate.update(String.format("UPDATE \"%s\" SET \"%s\" = null",
	 * tableName,fieldName));
	 * 
	 * //第四步修改字段类型 jdbcTemplate.execute(String.format(MODIFY_FIELD_TEMPLATE,
	 * tableName,fieldName,fieldType,length));
	 * 
	 * //第五步 将临时字段的值再赋回给修改字段
	 * jdbcTemplate.update(String.format(UPDATE_FIELD_TEMPLATE,
	 * tableName,fieldName,tempFieldName));
	 * 
	 * //第六步 删掉临时字段
	 * jdbcTemplate.execute(String.format(DROP_FIELD_TEMPLATE,tableName,
	 * tempFieldName));
	 * 
	 * 
	 * }
	 */
	public static void csvOriPmsTransformerSubstationAdd(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriPmsTransformerSubstation oriPmsTransformerSubstation = new OriPmsTransformerSubstation();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// oriPmsTransformerSubstation.setOriPmsTransformerSubstatId(csvRecord.get("ORI_PMS_TRANSFORMER_SUBSTAT_ID"));
			oriPmsTransformerSubstation.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			oriPmsTransformerSubstation.setSubstationName(csvRecord.get("SUBSTATION_NAME"));
			oriPmsTransformerSubstation.setOrgName(csvRecord.get("ORG_NAME"));
			oriPmsTransformerSubstation.setMaintainanceOrgName(csvRecord.get("MAINTAINANCE_ORG_NAME"));
			oriPmsTransformerSubstation.setMaintainanceTeam(csvRecord.get("MAINTAINANCE_TEAM"));
			oriPmsTransformerSubstation.setAssetProperty(csvRecord.get("ASSET_PROPERTY"));
			oriPmsTransformerSubstation.setAssetOrgName(csvRecord.get("ASSET_ORG_NAME"));
			oriPmsTransformerSubstation.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			oriPmsTransformerSubstation.setAssetStatus(csvRecord.get("ASSET_STATUS"));
			if (!csvRecord.get("COMMISSIONING_DATE").isEmpty()) {
				try {
					oriPmsTransformerSubstation.setCommissioningDate(simpleDateFormat
							.parse(csvRecord.get("COMMISSIONING_DATE").replace(" ", "").trim().substring(0, 19)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			oriPmsTransformerSubstation.setSubstationType(csvRecord.get("SUBSTATION_TYPE"));
			oriPmsTransformerSubstation.setPowerSupplyArea(csvRecord.get("POWER_SUPPLY_AREA"));
			oriPmsTransformerSubstation.setWhetherSmartSubstation(csvRecord.get("WHETHER_SMART_SUBSTATION"));
			oriPmsTransformerSubstation.setIsHubSubstation(csvRecord.get("IS_HUB_SUBSTATION"));
			oriPmsTransformerSubstation.setSubstationImportantLevel(csvRecord.get("SUBSTATION_IMPORTANT_LEVEL"));
			oriPmsTransformerSubstation.setWhetherAgentMaintainance(csvRecord.get("WHETHER_AGENT_MAINTAINANCE"));
			oriPmsTransformerSubstation.setWhetherRuralPowerNetwork(csvRecord.get("WHETHER_RURAL_POWER_NETWORK"));
			oriPmsTransformerSubstation.setDutyMode(csvRecord.get("DUTY_MODE"));
			oriPmsTransformerSubstation.setArrangementMode(csvRecord.get("ARRANGEMENT_MODE"));
			oriPmsTransformerSubstation.setContaminationLevel(csvRecord.get("CONTAMINATION_LEVEL"));
			oriPmsTransformerSubstation.setSubstationAddress(csvRecord.get("SUBSTATION_ADDRESS"));
			if (csvRecord.get("COVERAGE_AREA").trim().isEmpty()) {
				oriPmsTransformerSubstation.setCoverageArea(new Double(0.0));
			} else {
				oriPmsTransformerSubstation.setCoverageArea(new Double(csvRecord.get("COVERAGE_AREA")));
			}
			oriPmsTransformerSubstation.setCoverageAreaUnit(csvRecord.get("COVERAGE_AREA_UNIT"));
			if (csvRecord.get("BUILDING_AREA").trim().isEmpty()) {
				oriPmsTransformerSubstation.setBuildingArea(new Double(0.0));
			} else {
				oriPmsTransformerSubstation.setBuildingArea(new Double(csvRecord.get("BUILDING_AREA")));
			}
			oriPmsTransformerSubstation.setBuildingAreaUnit(csvRecord.get("BUILDING_AREA_UNIT"));
			if (csvRecord.get("ALTITUDE").trim().isEmpty()) {
				oriPmsTransformerSubstation.setAltitude(new BigDecimal(new Double(0.0)));
			} else {
				oriPmsTransformerSubstation.setAltitude(new BigDecimal(Double.parseDouble(csvRecord.get("ALTITUDE"))));
			}
			oriPmsTransformerSubstation.setAltitudeUnit(csvRecord.get("ALTITUDE_UNIT"));
			oriPmsTransformerSubstation.setRegionalCharacteristics(csvRecord.get("REGIONAL_CHARACTERISTICS"));
			if (!csvRecord.get("CANCELLATION_DATE").isEmpty()) {
				try {
					oriPmsTransformerSubstation.setCancellationDate(simpleDateFormat
							.parse(csvRecord.get("CANCELLATION_DATE").replace(" ", "").substring(0, 19)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			oriPmsTransformerSubstation.setContactPhoneNumber(csvRecord.get("CONTACT_PHONE_NUMBER"));
			oriPmsTransformerSubstation.setSubstationShortName(csvRecord.get("SUBSTATION_SHORT_NAME"));
			oriPmsTransformerSubstation.setSupremeDispatchJurisdiction(csvRecord.get("SUPREME_DISPATCH_JURISDICTION"));
			oriPmsTransformerSubstation.setWhetherSatisfiedNMinus1(csvRecord.get("WHETHER_SATISFIED_N_MINUS_1"));
			oriPmsTransformerSubstation.setWhetherConnectedAvc(csvRecord.get("WHETHER_CONNECTED_AVC"));
			oriPmsTransformerSubstation.setIfLinkDefInfoTeletransSys(csvRecord.get("IF_LINK_DEF_INFO_TELETRANS_SYS"));
			oriPmsTransformerSubstation.setEngineeringName(csvRecord.get("ENGINEERING_NAME"));
			oriPmsTransformerSubstation.setWhetherCentralizeMonitoring(csvRecord.get("WHETHER_CENTRALIZE_MONITORING"));
			oriPmsTransformerSubstation.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			if (!csvRecord.get("REGISTRATION_DATE").isEmpty()) {
				try {
					oriPmsTransformerSubstation.setRegistrationDate(simpleDateFormat
							.parse(csvRecord.get("REGISTRATION_DATE").replace(" ", "").substring(0, 19)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			oriPmsTransformerSubstation.setDeviceOwner(csvRecord.get("DEVICE_OWNER"));
			oriPmsTransformerSubstation.setRemark(csvRecord.get("REMARK"));
			oriPmsTransformerSubstation.setWhetherExistRingNetwork(csvRecord.get("WHETHER_EXIST_RING_NETWORK"));
			oriPmsTransformerSubstation.setEngineeringId(csvRecord.get("ENGINEERING_ID"));
			oriPmsTransformerSubstation.setIsIndependentBuilding(csvRecord.get("IS_INDEPENDENT_BUILDING"));
			oriPmsTransformerSubstation.setAntiMisoperationMode(csvRecord.get("ANTI_MISOPERATION_MODE"));
			oriPmsTransformerSubstation.setSubordinateDcSystem(csvRecord.get("SUBORDINATE_DC_SYSTEM"));
			oriPmsTransformerSubstation.setConverterStationType(csvRecord.get("CONVERTER_STATION_TYPE"));
			oriPmsTransformerSubstation.setAssetId(csvRecord.get("ASSET_ID"));
			oriPmsTransformerSubstation.setProfessionalClassification(csvRecord.get("PROFESSIONAL_CLASSIFICATION"));
			oriPmsTransformerSubstation.setFuncionalLocationCode(csvRecord.get("FUNCIONAL_LOCATION_CODE"));
			if (csvRecord.get("GROUNDING_RESISTANCE").trim().isEmpty()) {
				oriPmsTransformerSubstation.setGroundingResistance(new Double(0.0));
			} else {
				oriPmsTransformerSubstation.setGroundingResistance(new Double(csvRecord.get("GROUNDING_RESISTANCE")));
			}
			oriPmsTransformerSubstation.setGroundingResistanceUnit(csvRecord.get("GROUNDING_RESISTANCE_UNIT"));
			oriPmsTransformerSubstation.setPmId(csvRecord.get("PM_ID"));
			if (csvRecord.get("DC_TRANSMISSION_CAPACITY").trim().isEmpty()) {
				oriPmsTransformerSubstation.setDcTransmissionCapacity(new Double(0.0));
			} else {
				oriPmsTransformerSubstation
						.setDcTransmissionCapacity(new Double(csvRecord.get("DC_TRANSMISSION_CAPACITY")));
			}
			oriPmsTransformerSubstation.setDcTransmissionCapacityUnit(csvRecord.get("DC_TRANSMISSION_CAPACITY_UNIT"));
			oriPmsTransformerSubstation.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			oriPmsTransformerSubstation.setVoltageLevelName(csvRecord.get("VOLTAGE_LEVEL_NAME"));
			oriPmsTransformerSubstation.setStationId(csvRecord.get("STATION_ID"));
			oriPmsTransformerSubstation.setBoxTransformerType(csvRecord.get("BOX_TRANSFORMER_TYPE"));
			if (csvRecord.get("REACTIVE_POWER_COMPEN_CAPACITY").trim().isEmpty()) {
				oriPmsTransformerSubstation.setReactivePowerCompenCapacity(new Double(0.0));
			} else {
				oriPmsTransformerSubstation
						.setReactivePowerCompenCapacity(new Double(csvRecord.get("REACTIVE_POWER_COMPEN_CAPACITY")));
			}
			oriPmsTransformerSubstation.setReactPowerCompenCapaciUnit(csvRecord.get("REACT_POWER_COMPEN_CAPACI_UNIT"));
			oriPmsTransformerSubstation.setIsUndergroundStation(csvRecord.get("IS_UNDERGROUND_STATION"));
			oriPmsTransformerSubstation.setWorkingNumber(csvRecord.get("WORKING_NUMBER"));
			oriPmsTransformerSubstation.setImportanceDegree(csvRecord.get("IMPORTANCE_DEGREE"));
			if (csvRecord.get("DISTRIB_TRANSFORMER_CAPACITY").trim().isEmpty()) {
				oriPmsTransformerSubstation.setDistribTransformerCapacity(new Double(0.0));
			} else {
				oriPmsTransformerSubstation
						.setDistribTransformerCapacity(new Double(csvRecord.get("DISTRIB_TRANSFORMER_CAPACITY")));
			}
			oriPmsTransformerSubstation.setDistribTransformerCapacUnit(csvRecord.get("DISTRIB_TRANSFORMER_CAPAC_UNIT"));
			if (csvRecord.get("DISTRIB_TRANSFORMER_QUANTITY").trim().isEmpty()) {
				oriPmsTransformerSubstation.setDistribTransformerQuantity(new Double(0.0));
			} else {
				oriPmsTransformerSubstation
						.setDistribTransformerQuantity(new Double(csvRecord.get("DISTRIB_TRANSFORMER_QUANTITY")));
			}

			session.save(oriPmsTransformerSubstation);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvOriPmsTransformerAdd(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriPmsTransformer oriPmsTransformer = new OriPmsTransformer();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			/*
			 * oriPmsTransformer.setVersion("O_2017_1"); try {
			 * oriPmsTransformer.setCalYear(simpleDateFormat. parse("2018/12/03 00:00:00"));
			 * } catch (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } SimpleDateFormat simpleDateFormat2 = new
			 * SimpleDateFormat("yyyy-MM-dd");
			 */
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			// techRefProSinEngDecompose.setTechRefProSinEngDecompId(csvRecord.get("TECH_REF_PRO_SIN_ENG_DECOMP_ID"));
			// techRefProSinEngDecompose.setVersion(csvRecord.get("VERSION"));
			// try {
			// techRefProSinEngDecompose.setCalYear(simpleDateFormat.parse(csvRecord.get("CAL_YEAR")));
			// } catch (ParseException e) {
			// e.printStackTrace();
			// }
			// oriPmsTransformer.setOriPmsTransformerId(csvRecord.get("ORI_PMS_TRANSFORMER_ID"));
			oriPmsTransformer.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			oriPmsTransformer.setWorkingCode(csvRecord.get("WORKING_CODE"));
			oriPmsTransformer.setSubordinateSubstationName(csvRecord.get("SUBORDINATE_SUBSTATION_NAME"));
			if (!csvRecord.get("COMMISSIONING_DATE").isEmpty()) {
				try {
					oriPmsTransformer.setCommissioningDate(
							simpleDateFormat.parse(csvRecord.get("COMMISSIONING_DATE").trim().substring(0, 19)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			oriPmsTransformer.setAssetOrgName(csvRecord.get("ASSET_ORG_NAME"));
			oriPmsTransformer.setWbsId(csvRecord.get("WBS_ID"));
			oriPmsTransformer.setModelNumber(csvRecord.get("MODEL_NUMBER"));
			oriPmsTransformer.setManufacturer(csvRecord.get("MANUFACTURER"));
			oriPmsTransformer.setFactoryNumber(csvRecord.get("FACTORY_NUMBER"));
			if (!csvRecord.get("PRODUCTION_DATE").isEmpty()) {
				try {
					oriPmsTransformer.setProductionDate(
							simpleDateFormat.parse(csvRecord.get("PRODUCTION_DATE").trim().substring(0, 19)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			oriPmsTransformer.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			oriPmsTransformer.setEquipmentTypeCode(csvRecord.get("EQUIPMENT_TYPE_CODE"));
			oriPmsTransformer.setSpaceingUnit(csvRecord.get("SPACEING_UNIT"));
			oriPmsTransformer.setOrgName(csvRecord.get("ORG_NAME"));
			oriPmsTransformer.setMaintainanceOrgName(csvRecord.get("MAINTAINANCE_ORG_NAME"));
			oriPmsTransformer.setMaintainanceTeam(csvRecord.get("MAINTAINANCE_TEAM"));
			oriPmsTransformer.setEquipmentOwner(csvRecord.get("EQUIPMENT_OWNER"));
			oriPmsTransformer.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			oriPmsTransformer.setEquipmentStatus(csvRecord.get("EQUIPMENT_STATUS"));
			oriPmsTransformer.setPhaseNumber(csvRecord.get("PHASE_NUMBER"));
			oriPmsTransformer.setPhaseType(csvRecord.get("PHASE_TYPE"));
			if (!csvRecord.get("RECENT_COMMISSIONING_DATE").isEmpty()) {

				try {
					oriPmsTransformer.setRecentCommissioningDate(
							simpleDateFormat.parse(csvRecord.get("RECENT_COMMISSIONING_DATE").trim().substring(0, 19)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			oriPmsTransformer.setWhetherRuralPowerNetwork(csvRecord.get("WHETHER_RURAL_POWER_NETWORK"));
			oriPmsTransformer.setPurpose(csvRecord.get("PURPOSE"));
			oriPmsTransformer.setWorkingEnvironment(csvRecord.get("WORKING_ENVIRONMENT"));
			oriPmsTransformer.setInstallationLocation(csvRecord.get("INSTALLATION_LOCATION"));
			oriPmsTransformer.setAssetProperty(csvRecord.get("ASSET_PROPERTY"));
			oriPmsTransformer.setAssetId(csvRecord.get("ASSET_ID"));
			oriPmsTransformer.setEngineeringId(csvRecord.get("ENGINEERING_ID"));
			oriPmsTransformer.setEngineeringName(csvRecord.get("ENGINEERING_NAME"));
			oriPmsTransformer.setEquipmentIncreaseMode(csvRecord.get("EQUIPMENT_INCREASE_MODE"));
			oriPmsTransformer.setProductCode(csvRecord.get("PRODUCT_CODE"));
			oriPmsTransformer.setManufacturingCountry(csvRecord.get("MANUFACTURING_COUNTRY"));
			oriPmsTransformer.setRatedVoltage(csvRecord.get("RATED_VOLTAGE"));
			// oriPmsTransformer.setRatedVoltageUnit(csvRecord.get("RATED_VOLTAGE_UNIT"));
			oriPmsTransformer.setRatedVoltageUnit("kV");

			if (csvRecord.get("RATED_CURRENT").trim().isEmpty()) {
				oriPmsTransformer.setRatedCurrent(new Double(0.0));
			} else {
				oriPmsTransformer.setRatedCurrent(new Double(csvRecord.get("RATED_CURRENT")));
			}
			// oriPmsTransformer.setRatedCurrentUnit(csvRecord.get("RATED_CURRENT_UNIT"));
			oriPmsTransformer.setRatedCurrentUnit("A");
			if (csvRecord.get("RATED_FREQUENCY").trim().isEmpty()) {
				oriPmsTransformer.setRatedFrequency(new Double(0.0));
			} else {
				oriPmsTransformer.setRatedFrequency(new Double(csvRecord.get("RATED_FREQUENCY")));
			}
			// oriPmsTransformer.setRatedFrequencyUnit(csvRecord.get("RATED_FREQUENCY_UNIT"));
			oriPmsTransformer.setRatedFrequencyUnit("Hz");
			oriPmsTransformer.setInsulateHeatResistanceGrade(csvRecord.get("INSULATE_HEAT_RESISTANCE_GRADE"));
			oriPmsTransformer.setAntifoulingGrade(csvRecord.get("ANTIFOULING_GRADE"));
			oriPmsTransformer.setInsulatingMedium(csvRecord.get("INSULATING_MEDIUM"));
			oriPmsTransformer.setWindingType(csvRecord.get("WINDING_TYPE"));
			oriPmsTransformer.setStructuralStyle(csvRecord.get("STRUCTURAL_STYLE"));
			oriPmsTransformer.setCoolingMode(csvRecord.get("COOLING_MODE"));
			oriPmsTransformer.setVoltageRegulationMode(csvRecord.get("VOLTAGE_REGULATION_MODE"));
			oriPmsTransformer.setConnectionGroupLabel(csvRecord.get("CONNECTION_GROUP_LABEL"));
			if (csvRecord.get("RATED_CAPACITY").trim().isEmpty()) {
				oriPmsTransformer.setRatedCapacity(new Double(0.0));
			} else {
				oriPmsTransformer.setRatedCapacity(new Double(csvRecord.get("RATED_CAPACITY")));
			}
			// oriPmsTransformer.setRatedCapacityUnit(csvRecord.get("RATED_CAPACITY_UNIT"));
			oriPmsTransformer.setRatedCapacityUnit("MVA");
			if (csvRecord.get("SELF_COOLING_CAPACITY_PERCENT").trim().isEmpty()) {
				oriPmsTransformer.setSelfCoolingCapacityPercent(new Double(0.0));
			} else {
				oriPmsTransformer
						.setSelfCoolingCapacityPercent(new Double(csvRecord.get("SELF_COOLING_CAPACITY_PERCENT")));
			}
			oriPmsTransformer.setVoltageRatio(csvRecord.get("VOLTAGE_RATIO"));
			oriPmsTransformer.setRatedMediumVoltage(csvRecord.get("RATED_MEDIUM_VOLTAGE"));
			// oriPmsTransformer.setRatedMediumVoltageUnit(csvRecord.get("RATED_MEDIUM_VOLTAGE_UNIT"));
			oriPmsTransformer.setRatedMediumVoltageUnit("kV");
			oriPmsTransformer.setRatedLowVoltage(csvRecord.get("RATED_LOW_VOLTAGE"));
			// oriPmsTransformer.setRatedLowVoltageUnit(csvRecord.get("RATED_LOW_VOLTAGE_UNIT"));
			oriPmsTransformer.setRatedLowVoltageUnit("kV");
			if (csvRecord.get("MV_RATED_CURRENT").trim().isEmpty()) {
				oriPmsTransformer.setMvRatedCurrent(new Double(0.0));
			} else {
				oriPmsTransformer.setMvRatedCurrent(new Double(csvRecord.get("MV_RATED_CURRENT")));
			}
			oriPmsTransformer.setMvRatedCurrentUnit(csvRecord.get("MV_RATED_CURRENT_UNIT"));
			oriPmsTransformer.setMvRatedCurrentUnit("A");
			if (csvRecord.get("LV_RATED_CURRENT").trim().isEmpty()) {
				oriPmsTransformer.setLvRatedCurrent(new Double(0.0));
			} else {
				oriPmsTransformer.setLvRatedCurrent(new Double(csvRecord.get("LV_RATED_CURRENT")));
			}
			oriPmsTransformer.setLvRatedCurrentUnit(csvRecord.get("LV_RATED_CURRENT_UNIT"));
			oriPmsTransformer.setLvRatedCurrentUnit("A");
			if (csvRecord.get("HIGH_LOW_VOLTAGE_LOAD_LOSS").trim().isEmpty()) {
				oriPmsTransformer.setHighLowVoltageLoadLoss(new Double(0.0));
			} else {
				oriPmsTransformer.setHighLowVoltageLoadLoss(new Double(csvRecord.get("HIGH_LOW_VOLTAGE_LOAD_LOSS")));
			}
			// oriPmsTransformer.setHighLowVoltLoadLossUnit(csvRecord.get("HIGH_LOW_VOLT_LOAD_LOSS_UNIT"));
			oriPmsTransformer.setHighLowVoltLoadLossUnit("kW");
			if (csvRecord.get("HIGH_MEDIUM_VOLTAGE_LOAD_LOSS").trim().isEmpty()) {
				oriPmsTransformer.setHighMediumVoltageLoadLoss(new Double(0.0));
			} else {
				oriPmsTransformer
						.setHighMediumVoltageLoadLoss(new Double(csvRecord.get("HIGH_MEDIUM_VOLTAGE_LOAD_LOSS")));
			}
			// oriPmsTransformer.setHighMedVoltLoadLossUnit(csvRecord.get("HIGH_MED_VOLT_LOAD_LOSS_UNIT"));
			oriPmsTransformer.setHighMedVoltLoadLossUnit("kW");
			if (csvRecord.get("MEDIUM_LOW_VOLT_LOAD_LOSS").trim().isEmpty()) {
				oriPmsTransformer.setMediumLowVoltLoadLoss(new Double(0.0));
			} else {
				oriPmsTransformer.setMediumLowVoltLoadLoss(new Double(csvRecord.get("MEDIUM_LOW_VOLT_LOAD_LOSS")));
			}
			// oriPmsTransformer.setMedLowVoltLoadLossUnit(csvRecord.get("MED_LOW_VOLT_LOAD_LOSS_UNIT"));
			oriPmsTransformer.setMedLowVoltLoadLossUnit("kW");
			if (csvRecord.get("HV_MV_SHORT_CIRCUIT_IMPEDANC").trim().isEmpty()) {
				oriPmsTransformer.setHvMvShortCircuitImpedanc(new Double(0.0));
			} else {
				oriPmsTransformer
						.setHvMvShortCircuitImpedanc(new Double(csvRecord.get("HV_MV_SHORT_CIRCUIT_IMPEDANC")));
			}
			if (csvRecord.get("HV_LV_SHORT_CIRCUIT_IMPEDANCE").trim().isEmpty()) {
				oriPmsTransformer.setHvLvShortCircuitImpedance(new Double(0.0));
			} else {
				oriPmsTransformer
						.setHvLvShortCircuitImpedance(new Double(csvRecord.get("HV_LV_SHORT_CIRCUIT_IMPEDANCE")));
			}
			if (csvRecord.get("MV_LV_SHORT_CIRCUIT_IMPEDANCE").trim().isEmpty()) {
				oriPmsTransformer.setMvLvShortCircuitImpedance(new Double(0.0));
			} else {
				oriPmsTransformer
						.setMvLvShortCircuitImpedance(new Double(csvRecord.get("MV_LV_SHORT_CIRCUIT_IMPEDANCE")));
			}
			if (csvRecord.get("NO_LOAD_CURRENT_RATIO").trim().isEmpty()) {
				oriPmsTransformer.setNoLoadCurrentRatio(new Double(0.0));
			} else {
				oriPmsTransformer.setNoLoadCurrentRatio(new Double(csvRecord.get("NO_LOAD_CURRENT_RATIO")));
			}
			if (csvRecord.get("NO_LOAD_LOSS").trim().isEmpty()) {
				oriPmsTransformer.setNoLoadLoss(new Double(0.0));
			} else {
				oriPmsTransformer.setNoLoadLoss(new Double(csvRecord.get("NO_LOAD_LOSS")));
			}
			// oriPmsTransformer.setNoLoadLossUnit(csvRecord.get("NO_LOAD_LOSS_UNIT"));
			oriPmsTransformer.setNoLoadLossUnit("kW");
			if (csvRecord.get("FULL_LOAD_LOSS").trim().isEmpty()) {
				oriPmsTransformer.setFullLoadLoss(new Double(0.0));
			} else {
				oriPmsTransformer.setFullLoadLoss(new Double(csvRecord.get("FULL_LOAD_LOSS")));
			}
			// oriPmsTransformer.setFullLoadLossUnit(csvRecord.get("FULL_LOAD_LOSS_UNIT"));
			oriPmsTransformer.setFullLoadLossUnit("kW");
			if (csvRecord.get("TOTAL_WEIGHT").trim().isEmpty()) {
				oriPmsTransformer.setTotalWeight(new Double(0.0));
			} else {
				oriPmsTransformer.setTotalWeight(new Double(csvRecord.get("TOTAL_WEIGHT")));
			}
			// oriPmsTransformer.setTotalWeightUnit(csvRecord.get("TOTAL_WEIGHT_UNIT"));
			oriPmsTransformer.setTotalWeightUnit("t");
			oriPmsTransformer.setOilNumber(csvRecord.get("OIL_NUMBER"));
			if (csvRecord.get("OIL_WEIGHT").trim().isEmpty()) {
				oriPmsTransformer.setOilWeight(new Double(0.0));
			} else {
				oriPmsTransformer.setOilWeight(new Double(csvRecord.get("OIL_WEIGHT")));
			}
			// oriPmsTransformer.setOilWeightUnit(csvRecord.get("OIL_WEIGHT_UNIT"));
			oriPmsTransformer.setOilWeightUnit("t");
			oriPmsTransformer.setOilProductionArea(csvRecord.get("OIL_PRODUCTION_AREA"));
			if (csvRecord.get("RATED_SF6_GAS_PRESSURE").trim().isEmpty()) {
				oriPmsTransformer.setRatedSf6GasPressure(new Double(0.0));
			} else {
				oriPmsTransformer.setRatedSf6GasPressure(new Double(csvRecord.get("RATED_SF6_GAS_PRESSURE")));
			}
			// oriPmsTransformer.setRatedSf6GasPressureUnit(csvRecord.get("RATED_SF6_GAS_PRESSURE_UNIT"));
			oriPmsTransformer.setRatedSf6GasPressureUnit("Mpa");
			if (csvRecord.get("SF6_GAS_ALARM_PRESSURE").trim().isEmpty()) {
				oriPmsTransformer.setSf6GasAlarmPressure(new Double(0.0));
			} else {
				oriPmsTransformer.setSf6GasAlarmPressure(new Double(csvRecord.get("SF6_GAS_ALARM_PRESSURE")));
			}
			// oriPmsTransformer.setSf6GasAlarmPressureUnit(csvRecord.get("SF6_GAS_ALARM_PRESSURE_UNIT"));
			oriPmsTransformer.setSf6GasAlarmPressureUnit("Mpa");
			if (csvRecord.get("BODY_WEIGHT").trim().isEmpty()) {
				oriPmsTransformer.setBodyWeight(new Double(0.0));
			} else {
				oriPmsTransformer.setBodyWeight(new Double(csvRecord.get("BODY_WEIGHT")));
			}
			// oriPmsTransformer.setBodyWeightUnit(csvRecord.get("BODY_WEIGHT_UNIT"));
			oriPmsTransformer.setBodyWeightUnit("t");
			if (csvRecord.get("TRANSPORTATION_WEIGHT").trim().isEmpty()) {
				oriPmsTransformer.setTransportationWeight(new Double(0.0));
			} else {
				oriPmsTransformer.setTransportationWeight(new Double(csvRecord.get("TRANSPORTATION_WEIGHT")));
			}
			// oriPmsTransformer.setTransportationWeightUnit(csvRecord.get("TRANSPORTATION_WEIGHT_UNIT"));
			oriPmsTransformer.setTransportationWeightUnit("t");
			oriPmsTransformer.setIsulationLevel(csvRecord.get("ISULATION_LEVEL"));
			oriPmsTransformer.setIsulationLevelNeutralPoint(csvRecord.get("ISULATION_LEVEL_NEUTRAL_POINT"));
			if (csvRecord.get("FORCED_AIR_COOLING_NOISE_HP").trim().isEmpty()) {
				oriPmsTransformer.setForcedAirCoolingNoiseHp(new Double(0.0));
			} else {
				oriPmsTransformer.setForcedAirCoolingNoiseHp(new Double(csvRecord.get("FORCED_AIR_COOLING_NOISE_HP")));
			}
			// oriPmsTransformer.setForcedAirCoolNoiseHpUnit(csvRecord.get("FORCED_AIR_COOL_NOISE_HP_UNIT"));
			oriPmsTransformer.setForcedAirCoolNoiseHpUnit("dB");
			if (csvRecord.get("OIL_PILLOW_CAPACITY").trim().isEmpty()) {
				oriPmsTransformer.setOilPillowCapacity(new Double(0.0));
			} else {
				oriPmsTransformer.setOilPillowCapacity(new Double(csvRecord.get("OIL_PILLOW_CAPACITY")));
			}
			// oriPmsTransformer.setOilPillowCapacityUnit(csvRecord.get("OIL_PILLOW_CAPACITY_UNIT"));
			oriPmsTransformer.setOilPillowCapacityUnit("m3");
			oriPmsTransformer.setOilPillowSealingMethod(csvRecord.get("OIL_PILLOW_SEALING_METHOD"));
			oriPmsTransformer.setWhetherExistThermalSiphon(csvRecord.get("WHETHER_EXIST_THERMAL_SIPHON"));
			if (csvRecord.get("UPPER_FUEL_TANK_WEIGHT").trim().isEmpty()) {
				oriPmsTransformer.setUpperFuelTankWeight(new Double(0.0));
			} else {
				oriPmsTransformer.setUpperFuelTankWeight(new Double(csvRecord.get("UPPER_FUEL_TANK_WEIGHT")));
			}
			// oriPmsTransformer.setUpperFuelTankWeightUnit(csvRecord.get("UPPER_FUEL_TANK_WEIGHT_UNIT"));
			oriPmsTransformer.setUpperFuelTankWeightUnit("t");
			oriPmsTransformer.setOilGasTankStructure(csvRecord.get("OIL_GAS_TANK_STRUCTURE"));
			oriPmsTransformer.setSf6Manufacturer(csvRecord.get("SF6_MANUFACTURER"));
			if (csvRecord.get("SF6_GAS_WEIGHT").trim().isEmpty()) {
				oriPmsTransformer.setSf6GasWeight(new Double(0.0));
			} else {
				oriPmsTransformer.setSf6GasWeight(new Double(csvRecord.get("SF6_GAS_WEIGHT")));
			}
			// oriPmsTransformer.setSf6GasWeightUnit(csvRecord.get("SF6_GAS_WEIGHT_UNIT"));
			oriPmsTransformer.setSf6GasWeightUnit("kg");
			if (csvRecord.get("SF6_AIR_ONTOLOGY_WEIGHT").trim().isEmpty()) {
				oriPmsTransformer.setSf6AirOntologyWeight(new Double(0.0));
			} else {
				oriPmsTransformer.setSf6AirOntologyWeight(new Double(csvRecord.get("SF6_AIR_ONTOLOGY_WEIGHT")));
			}
			// oriPmsTransformer.setSf6AirOntologyWeightUnit(csvRecord.get("SF6_AIR_ONTOLOGY_WEIGHT_UNIT"));
			oriPmsTransformer.setSf6AirOntologyWeightUnit("kg");
			if (csvRecord.get("SF6_AIR_CABLE_STORAGE_WEIGHT").trim().isEmpty()) {
				oriPmsTransformer.setSf6AirCableStorageWeight(new Double(0.0));
			} else {
				oriPmsTransformer
						.setSf6AirCableStorageWeight(new Double(csvRecord.get("SF6_AIR_CABLE_STORAGE_WEIGHT")));
			}
			// oriPmsTransformer.setSf6AirCableStorWeightUnit(csvRecord.get("SF6_AIR_CABLE_STOR_WEIGHT_UNIT"));
			oriPmsTransformer.setSf6AirCableStorWeightUnit("kg");
			if (csvRecord.get("SF6_AIR_ON_LOAD_SWITCH_WEIGHT").trim().isEmpty()) {
				oriPmsTransformer.setSf6AirOnLoadSwitchWeight(new Double(0.0));
			} else {
				oriPmsTransformer
						.setSf6AirOnLoadSwitchWeight(new Double(csvRecord.get("SF6_AIR_ON_LOAD_SWITCH_WEIGHT")));
			}
			// oriPmsTransformer.setSf6OnLoadSwitchWeightUnit(csvRecord.get("SF6_ON_LOAD_SWITCH_WEIGHT_UNIT"));
			oriPmsTransformer.setSf6OnLoadSwitchWeightUnit("kg");
			if (csvRecord.get("SF6_AIR_ONTOLOGY_PRESSURE").trim().isEmpty()) {
				oriPmsTransformer.setSf6AirOntologyPressure(new Double(0.0));
			} else {
				oriPmsTransformer.setSf6AirOntologyPressure(new Double(csvRecord.get("SF6_AIR_ONTOLOGY_PRESSURE")));
			}
			// oriPmsTransformer.setSf6AirOntologyPressureUnit(csvRecord.get("SF6_AIR_ONTOLOGY_PRESSURE_UNIT"));
			oriPmsTransformer.setSf6AirOntologyPressureUnit("MPa");
			if (csvRecord.get("SF6_AIR_CABLE_STORAGE_PRESSURE").trim().isEmpty()) {
				oriPmsTransformer.setSf6AirCableStoragePressure(new Double(0.0));
			} else {
				oriPmsTransformer
						.setSf6AirCableStoragePressure(new Double(csvRecord.get("SF6_AIR_CABLE_STORAGE_PRESSURE")));
			}
			// oriPmsTransformer.setSf6CableStorPressureUnit(csvRecord.get("SF6_CABLE_STOR_PRESSURE_UNIT"));
			oriPmsTransformer.setSf6CableStorPressureUnit("MPa");
			if (csvRecord.get("SF6_ON_LOAD_SWITCH_PRESSURE").trim().isEmpty()) {
				oriPmsTransformer.setSf6OnLoadSwitchPressure(new Double(0.0));
			} else {
				oriPmsTransformer.setSf6OnLoadSwitchPressure(new Double(csvRecord.get("SF6_ON_LOAD_SWITCH_PRESSURE")));
			}
			// oriPmsTransformer.setSf6OnLoadSwitchPressuUnit(csvRecord.get("SF6_ON_LOAD_SWITCH_PRESSU_UNIT"));
			oriPmsTransformer.setSf6OnLoadSwitchPressuUnit("MPa");
			if (csvRecord.get("COOLING_WATER_WEIGHT").trim().isEmpty()) {
				oriPmsTransformer.setCoolingWaterWeight(new Double(0.0));
			} else {
				oriPmsTransformer.setCoolingWaterWeight(new Double(csvRecord.get("COOLING_WATER_WEIGHT")));
			}
			// oriPmsTransformer.setCoolingWaterWeightUnit(csvRecord.get("COOLING_WATER_WEIGHT_UNIT"));
			oriPmsTransformer.setCoolingWaterWeightUnit("t");
			if (csvRecord.get("CUMULATIVE_FILING_NUMBER").trim().isEmpty()) {
				oriPmsTransformer.setCumulativeFilingNumber(new Double(0.0));
			} else {
				oriPmsTransformer.setCumulativeFilingNumber(new Double(csvRecord.get("CUMULATIVE_FILING_NUMBER")));
			}
			if (csvRecord.get("UP_LAYER_OIL_TEMPERATURE_LIMIT").trim().isEmpty()) {
				oriPmsTransformer.setUpLayerOilTemperatureLimit(new Double(0.0));
			} else {
				oriPmsTransformer
						.setUpLayerOilTemperatureLimit(new Double(csvRecord.get("UP_LAYER_OIL_TEMPERATURE_LIMIT")));
			}
			// oriPmsTransformer.setUpLayerOilTemperLimitUnit(csvRecord.get("UP_LAYER_OIL_TEMPER_LIMIT_UNIT"));
			oriPmsTransformer.setUpLayerOilTemperLimitUnit("℃");
			if (csvRecord.get("WINDING_TEMPERATURE_LIMIT").trim().isEmpty()) {
				oriPmsTransformer.setWindingTemperatureLimit(new Double(0.0));
			} else {
				oriPmsTransformer.setWindingTemperatureLimit(new Double(csvRecord.get("WINDING_TEMPERATURE_LIMIT")));
			}
			// oriPmsTransformer.setWindingTemperatureLimitUnit(csvRecord.get("WINDING_TEMPERATURE_LIMIT_UNIT"));
			oriPmsTransformer.setWindingTemperatureLimitUnit("℃");
			oriPmsTransformer.setNeutralPoingGroundingMode(csvRecord.get("NEUTRAL_POING_GROUNDING_MODE"));
			if (csvRecord.get("HIGH_VOLTAGE_SIDE_TAP_GEAR").trim().isEmpty()) {
				oriPmsTransformer.setHighVoltageSideTapGear(new Double(0.0));
			} else {
				oriPmsTransformer.setHighVoltageSideTapGear(new Double(csvRecord.get("HIGH_VOLTAGE_SIDE_TAP_GEAR")));
			}
			if (csvRecord.get("MEDIUM_VOLTAGE_SIDE_TAP_GEAR").trim().isEmpty()) {
				oriPmsTransformer.setMediumVoltageSideTapGear(new Double(0.0));
			} else {
				oriPmsTransformer
						.setMediumVoltageSideTapGear(new Double(csvRecord.get("MEDIUM_VOLTAGE_SIDE_TAP_GEAR")));
			}
			if (csvRecord.get("LOW_VOLTAGE_SIDE_TAP_GEAR").trim().isEmpty()) {
				oriPmsTransformer.setLowVoltageSideTapGear(new Double(0.0));
			} else {
				oriPmsTransformer.setLowVoltageSideTapGear(new Double(csvRecord.get("LOW_VOLTAGE_SIDE_TAP_GEAR")));
			}
			if (csvRecord.get("MV_SIDE_CAPACITY").trim().isEmpty()) {
				oriPmsTransformer.setMvSideCapacity(new Double(0.0));
			} else {
				oriPmsTransformer.setMvSideCapacity(new Double(csvRecord.get("MV_SIDE_CAPACITY")));
			}
			// oriPmsTransformer.setMvSideCapacityUnit(csvRecord.get("MV_SIDE_CAPACITY_UNIT"));
			oriPmsTransformer.setMvSideCapacityUnit("MW");
			if (csvRecord.get("LV_SIDE_CAPACITY").trim().isEmpty()) {
				oriPmsTransformer.setLvSideCapacity(new Double(0.0));
			} else {
				oriPmsTransformer.setLvSideCapacity(new Double(csvRecord.get("LV_SIDE_CAPACITY")));
			}
			// oriPmsTransformer.setLvSideCapacityUnit(csvRecord.get("LV_SIDE_CAPACITY_UNIT"));
			oriPmsTransformer.setLvSideCapacityUnit("MW");
			if (csvRecord.get("HV_SIDE_ZERO_SEQUENCE_RESISTER").trim().isEmpty()) {
				oriPmsTransformer.setHvSideZeroSequenceResister(new Double(0.0));
			} else {
				oriPmsTransformer
						.setHvSideZeroSequenceResister(new Double(csvRecord.get("HV_SIDE_ZERO_SEQUENCE_RESISTER")));
			}
			// oriPmsTransformer.setHvSideZeroSeqResisterUnit(csvRecord.get("HV_SIDE_ZERO_SEQ_RESISTER_UNIT"));
			oriPmsTransformer.setHvSideZeroSeqResisterUnit("Ω");
			if (csvRecord.get("HV_SIDE_ZERO_SEQ_REACTANCE").trim().isEmpty()) {
				oriPmsTransformer.setHvSideZeroSeqReactance(new Double(0.0));
			} else {
				oriPmsTransformer.setHvSideZeroSeqReactance(new Double(csvRecord.get("HV_SIDE_ZERO_SEQ_REACTANCE")));
			}
			// oriPmsTransformer.setHvSideZerSeqReactanceUnit(csvRecord.get("HV_SIDE_ZER_SEQ_REACTANCE_UNIT"));
			oriPmsTransformer.setHvSideZerSeqReactanceUnit("s");
			if (csvRecord.get("MV_SIDE_ZERO_SEQUENCE_RESISTER").trim().isEmpty()) {
				oriPmsTransformer.setMvSideZeroSequenceResister(new Double(0.0));
			} else {
				oriPmsTransformer
						.setMvSideZeroSequenceResister(new Double(csvRecord.get("MV_SIDE_ZERO_SEQUENCE_RESISTER")));
			}
			// oriPmsTransformer.setMvSideZeroSeqResisterUnit(csvRecord.get("MV_SIDE_ZERO_SEQ_RESISTER_UNIT"));
			oriPmsTransformer.setMvSideZeroSeqResisterUnit("Ω");
			if (csvRecord.get("MV_SIDE_ZERO_SEQ_REACTANCE").trim().isEmpty()) {
				oriPmsTransformer.setMvSideZeroSeqReactance(new Double(0.0));
			} else {
				oriPmsTransformer.setMvSideZeroSeqReactance(new Double(csvRecord.get("MV_SIDE_ZERO_SEQ_REACTANCE")));
			}
			// oriPmsTransformer.setMvSideZerSeqReactanceUnit(csvRecord.get("MV_SIDE_ZER_SEQ_REACTANCE_UNIT"));
			oriPmsTransformer.setMvSideZerSeqReactanceUnit("s");
			if (csvRecord.get("LV_SIDE_ZERO_SEQUENCE_RESISTER").trim().isEmpty()) {
				oriPmsTransformer.setLvSideZeroSequenceResister(new Double(0.0));
			} else {
				oriPmsTransformer
						.setLvSideZeroSequenceResister(new Double(csvRecord.get("LV_SIDE_ZERO_SEQUENCE_RESISTER")));
			}
			// oriPmsTransformer.setLvSideZeroSeqResisterUnit(csvRecord.get("LV_SIDE_ZERO_SEQ_RESISTER_UNIT"));
			oriPmsTransformer.setLvSideZeroSeqResisterUnit("Ω");
			if (csvRecord.get("LV_SIDE_ZERO_SEQ_REACTANCE").trim().isEmpty()) {
				oriPmsTransformer.setLvSideZeroSeqReactance(new Double(0.0));
			} else {
				oriPmsTransformer.setLvSideZeroSeqReactance(new Double(csvRecord.get("LV_SIDE_ZERO_SEQ_REACTANCE")));
			}
			// oriPmsTransformer.setLvSideZerSeqReactanceUnit(csvRecord.get("LV_SIDE_ZER_SEQ_REACTANCE_UNIT"));
			oriPmsTransformer.setLvSideZerSeqReactanceUnit("s");
			oriPmsTransformer.setDispatchingJurisdiction(csvRecord.get("DISPATCHING_JURISDICTION"));
			oriPmsTransformer.setDispatchingOperationRight(csvRecord.get("DISPATCHING_OPERATION_RIGHT"));
			oriPmsTransformer.setDispatchingPermission(csvRecord.get("DISPATCHING_PERMISSION"));
			oriPmsTransformer.setDispatchingMonitRight(csvRecord.get("DISPATCHING_MONIT_RIGHT"));

			if (!csvRecord.get("REGISTRATION_DATE").isEmpty()) {
				try {
					oriPmsTransformer.setRegistrationDate(
							simpleDateFormat.parse(csvRecord.get("REGISTRATION_DATE").trim().substring(0, 19)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			oriPmsTransformer.setRemark(csvRecord.get("REMARK"));
			oriPmsTransformer.setPowerSysNameplateRunlibId(csvRecord.get("POWER_SYS_NAMEPLATE_RUNLIB_ID"));
			oriPmsTransformer.setObjectId(csvRecord.get("OBJECT_ID"));
			oriPmsTransformer.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			oriPmsTransformer.setCapacityRatio(csvRecord.get("CAPACITY_RATIO"));
			oriPmsTransformer.setSubstationVoltageLevel(csvRecord.get("SUBSTATION_VOLTAGE_LEVEL"));
			oriPmsTransformer.setVoltageLevelName(csvRecord.get("VOLTAGE_LEVEL_NAME"));
			oriPmsTransformer.setProfessionalClassification(csvRecord.get("PROFESSIONAL_CLASSIFICATION"));
			oriPmsTransformer.setStationId(csvRecord.get("STATION_ID"));
			oriPmsTransformer.setFunctionLocation(csvRecord.get("FUNCTION_LOCATION"));
			oriPmsTransformer.setPmId(csvRecord.get("PM_ID"));

			session.save(oriPmsTransformer);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvTechRefProSinEngDecomposeAdd(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			TechRefProSinEngDecompose techRefProSinEngDecompose = new TechRefProSinEngDecompose();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			techRefProSinEngDecompose.setVersion("O_2017_1");
			try {
				techRefProSinEngDecompose.setCalYear(simpleDateFormat.parse("2018/12/03 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			// techRefProSinEngDecompose.setTechRefProSinEngDecompId(csvRecord.get("TECH_REF_PRO_SIN_ENG_DECOMP_ID"));
			// techRefProSinEngDecompose.setVersion(csvRecord.get("VERSION"));
			// try {
			// techRefProSinEngDecompose.setCalYear(simpleDateFormat.parse(csvRecord.get("CAL_YEAR")));
			// } catch (ParseException e) {
			// e.printStackTrace();
			// }
			if (csvRecord.get("INDEXOF").trim().isEmpty()) {
				techRefProSinEngDecompose.setIndexof(new Integer(0));
			} else {
				techRefProSinEngDecompose.setIndexof(new Integer(csvRecord.get("INDEXOF")));
			}
			techRefProSinEngDecompose.setProjectManageOrgName(csvRecord.get("PROJECT_MANAGE_ORG_NAME"));
			techRefProSinEngDecompose.setProjectImplementOrgName(csvRecord.get("PROJECT_IMPLEMENT_ORG_NAME"));
			techRefProSinEngDecompose.setAssetRpoperty(csvRecord.get("ASSET_RPOPERTY"));
			techRefProSinEngDecompose.setSubstationLineVoltageLevel(csvRecord.get("SUBSTATION_LINE_VOLTAGE_LEVEL"));
			techRefProSinEngDecompose.setProjectId(csvRecord.get("PROJECT_ID"));
			techRefProSinEngDecompose.setProjectName(csvRecord.get("PROJECT_NAME"));
			techRefProSinEngDecompose.setSingleProjectType(csvRecord.get("SINGLE_PROJECT_TYPE"));
			techRefProSinEngDecompose.setReformEquipVoltageLevel(csvRecord.get("REFORM_EQUIP_VOLTAGE_LEVEL"));
			techRefProSinEngDecompose.setSingleProjectContent(csvRecord.get("SINGLE_PROJECT_CONTENT"));
			try {
				techRefProSinEngDecompose.setTechnicalReformStartTime(
						simpleDateFormat2.parse(csvRecord.get("TECHNICAL_REFORM_START_TIME")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			try {
				techRefProSinEngDecompose
						.setTechnicalReformEndTime(simpleDateFormat2.parse(csvRecord.get("TECHNICAL_REFORM_END_TIME")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			techRefProSinEngDecompose.setPreRegulationVersion(csvRecord.get("PRE_REGULATION_VERSION"));
			techRefProSinEngDecompose.setTransformerEquipmentModel(csvRecord.get("TRANSFORMER_EQUIPMENT_MODEL"));
			if (csvRecord.get("TRANSFORMER_REFORM_QUANTITY").trim().isEmpty()) {
				techRefProSinEngDecompose.setTransformerReformQuantity(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setTransformerReformQuantity(new Double(csvRecord.get("TRANSFORMER_REFORM_QUANTITY")));
			}
			if (csvRecord.get("TRANSFORMER_SINGLE_CAPACITY").trim().isEmpty()) {
				techRefProSinEngDecompose.setTransformerSingleCapacity(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setTransformerSingleCapacity(new Double(csvRecord.get("TRANSFORMER_SINGLE_CAPACITY")));
			}
			if (csvRecord.get("TRANSFORMER_AFT_TAX_UNIT_PRICE").trim().isEmpty()) {
				techRefProSinEngDecompose.setTransformerAftTaxUnitPrice(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setTransformerAftTaxUnitPrice(new Double(csvRecord.get("TRANSFORMER_AFT_TAX_UNIT_PRICE")));
			}
			techRefProSinEngDecompose.setCircuitBreakerModel(csvRecord.get("CIRCUIT_BREAKER_MODEL"));
			if (csvRecord.get("RATED_CURRENT").trim().isEmpty()) {
				techRefProSinEngDecompose.setRatedCurrent(new Double(0.0));
			} else {
				techRefProSinEngDecompose.setRatedCurrent(new Double(csvRecord.get("RATED_CURRENT")));
			}
			if (csvRecord.get("CIRCUIT_BREAK_REFORM_QUANTITY").trim().isEmpty()) {
				techRefProSinEngDecompose.setCircuitBreakReformQuantity(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setCircuitBreakReformQuantity(new Double(csvRecord.get("CIRCUIT_BREAK_REFORM_QUANTITY")));
			}
			if (csvRecord.get("CIRCU_BREAK_AFT_TAX_UNIT_PRICE").trim().isEmpty()) {
				techRefProSinEngDecompose.setCircuBreakAftTaxUnitPrice(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setCircuBreakAftTaxUnitPrice(new Double(csvRecord.get("CIRCU_BREAK_AFT_TAX_UNIT_PRICE")));
			}
			techRefProSinEngDecompose.setIsolatingSwitStuctureModel(csvRecord.get("ISOLATING_SWIT_STUCTURE_MODEL"));
			if (csvRecord.get("ISOLATING_SWIT_REFORM_QUANTITY").trim().isEmpty()) {
				techRefProSinEngDecompose.setIsolatingSwitReformQuantity(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setIsolatingSwitReformQuantity(new Double(csvRecord.get("ISOLATING_SWIT_REFORM_QUANTITY")));
			}
			if (csvRecord.get("ISOLAT_SWIT_AFT_TAX_UNIT_PRICE").trim().isEmpty()) {
				techRefProSinEngDecompose.setIsolatSwitAftTaxUnitPrice(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setIsolatSwitAftTaxUnitPrice(new Double(csvRecord.get("ISOLAT_SWIT_AFT_TAX_UNIT_PRICE")));
			}
			if (csvRecord.get("CONSTRUCTION_COST").trim().isEmpty()) {
				techRefProSinEngDecompose.setConstructionCost(new Double(0.0));
			} else {
				techRefProSinEngDecompose.setConstructionCost(new Double(csvRecord.get("CONSTRUCTION_COST")));
			}
			if (csvRecord.get("EQUIPMENT_PURCHASE_COST").trim().isEmpty()) {
				techRefProSinEngDecompose.setEquipmentPurchaseCost(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setEquipmentPurchaseCost(new Double(csvRecord.get("EQUIPMENT_PURCHASE_COST")));
			}
			if (csvRecord.get("TOTAL_INSTALL_ENGINEERING_COST").trim().isEmpty()) {
				techRefProSinEngDecompose.setTotalInstallEngineeringCost(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setTotalInstallEngineeringCost(new Double(csvRecord.get("TOTAL_INSTALL_ENGINEERING_COST")));
			}
			if (csvRecord.get("AFT_TAX_INSTALL_DEV_MATER_COST").trim().isEmpty()) {
				techRefProSinEngDecompose.setAftTaxInstallDevMaterCost(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setAftTaxInstallDevMaterCost(new Double(csvRecord.get("AFT_TAX_INSTALL_DEV_MATER_COST")));
			}
			if (csvRecord.get("DEMOLITION_COST").trim().isEmpty()) {
				techRefProSinEngDecompose.setDemolitionCost(new Double(0.0));
			} else {
				techRefProSinEngDecompose.setDemolitionCost(new Double(csvRecord.get("DEMOLITION_COST")));
			}
			if (csvRecord.get("TOTAL_OTHER_COST").trim().isEmpty()) {
				techRefProSinEngDecompose.setTotalOtherCost(new Double(0.0));
			} else {
				techRefProSinEngDecompose.setTotalOtherCost(new Double(csvRecord.get("TOTAL_OTHER_COST")));
			}
			if (csvRecord.get("STATIC_INVESTMENT").trim().isEmpty()) {
				techRefProSinEngDecompose.setStaticInvestment(new Double(0.0));
			} else {
				techRefProSinEngDecompose.setStaticInvestment(new Double(csvRecord.get("STATIC_INVESTMENT")));
			}
			techRefProSinEngDecompose.setBefTechniReformEquipErpId(csvRecord.get("BEF_TECHNI_REFORM_EQUIP_ERP_ID"));
			techRefProSinEngDecompose.setBefTechniReformEquipPmsId(csvRecord.get("BEF_TECHNI_REFORM_EQUIP_PMS_ID"));
			techRefProSinEngDecompose.setBefTechRefoEquipWorkStat(csvRecord.get("BEF_TECH_REFO_EQUIP_WORK_STAT"));
			techRefProSinEngDecompose.setEquipTechnicalReformReason(csvRecord.get("EQUIP_TECHNICAL_REFORM_REASON"));
			techRefProSinEngDecompose.setTechRefoFeasibOrigDesiDoc(csvRecord.get("TECH_REFO_FEASIB_ORIG_DESI_DOC"));
			if (csvRecord.get("RESIDUE_RATIO").trim().isEmpty()) {
				techRefProSinEngDecompose.setResidueRatio(new Double(0.0));
			} else {
				techRefProSinEngDecompose.setResidueRatio(new Double(csvRecord.get("RESIDUE_RATIO")));
			}
			techRefProSinEngDecompose.setEquipmentDealStation(csvRecord.get("EQUIPMENT_DEAL_STATION"));
			if (csvRecord.get("ASSET_ACTUAL_USED_AGE").trim().isEmpty()) {
				techRefProSinEngDecompose.setAssetActualUsedAge(new Double(0.0));
			} else {
				techRefProSinEngDecompose.setAssetActualUsedAge(new Double(csvRecord.get("ASSET_ACTUAL_USED_AGE")));
			}
			if (csvRecord.get("DISCARD_ASSET_AGE").trim().isEmpty()) {
				techRefProSinEngDecompose.setDiscardAssetAge(new Double(0.0));
			} else {
				techRefProSinEngDecompose.setDiscardAssetAge(new Double(csvRecord.get("DISCARD_ASSET_AGE")));
			}
			techRefProSinEngDecompose.setAfterTechnicalReformErpId(csvRecord.get("AFTER_TECHNICAL_REFORM_ERP_ID"));
			techRefProSinEngDecompose.setAfterTechnicalReformPmsId(csvRecord.get("AFTER_TECHNICAL_REFORM_PMS_ID"));
			if (csvRecord.get("AFT_TECH_REF_SER_ABN_STA_TIMES").trim().isEmpty()) {
				techRefProSinEngDecompose.setAftTechRefSerAbnStaTimes(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setAftTechRefSerAbnStaTimes(new Double(csvRecord.get("AFT_TECH_REF_SER_ABN_STA_TIMES")));
			}
			if (csvRecord.get("AFT_TECH_REF_DEFECT_TIMES").trim().isEmpty()) {
				techRefProSinEngDecompose.setAftTechRefDefectTimes(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setAftTechRefDefectTimes(new Double(csvRecord.get("AFT_TECH_REF_DEFECT_TIMES")));
			}
			techRefProSinEngDecompose.setAftTechRefAchieSolProBen(csvRecord.get("AFT_TECH_REF_ACHIE_SOL_PRO_BEN"));
			techRefProSinEngDecompose.setPostEvaluationReport(csvRecord.get("POST_EVALUATION_REPORT"));
			if (csvRecord.get("HISTORICAL_DEFECT_TIMES").trim().isEmpty()) {
				techRefProSinEngDecompose.setHistoricalDefectTimes(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setHistoricalDefectTimes(new Double(csvRecord.get("HISTORICAL_DEFECT_TIMES")));
			}
			if (csvRecord.get("DISCARC_AGE").trim().isEmpty()) {
				techRefProSinEngDecompose.setDiscarcAge(new Double(0.0));
			} else {
				techRefProSinEngDecompose.setDiscarcAge(new Double(csvRecord.get("DISCARC_AGE")));
			}
			if (csvRecord.get("AFT_TECH_REFORM_DEFECT_TIMES").trim().isEmpty()) {
				techRefProSinEngDecompose.setAftTechReformDefectTimes(new Double(0.0));
			} else {
				techRefProSinEngDecompose
						.setAftTechReformDefectTimes(new Double(csvRecord.get("AFT_TECH_REFORM_DEFECT_TIMES")));
			}
			if (csvRecord.get("WORKING_AGE").trim().isEmpty()) {
				techRefProSinEngDecompose.setWorkingAge(new Double(0.0));
			} else {
				techRefProSinEngDecompose.setWorkingAge(new Double(csvRecord.get("WORKING_AGE")));
			}
			session.save(techRefProSinEngDecompose);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvUpdateVoltageLevelAdd(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			UpdateVoltageLevel updateVoltageLevel = new UpdateVoltageLevel();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			updateVoltageLevel.setAssetMainNumber(csvRecord.get("ASSET_MAIN_NUMBER"));
			updateVoltageLevel.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));

			session.save(updateVoltageLevel);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErpDiscardDepreciationValueAdd(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ErpDiscardDepreciationValue erpDiscardDepreciationValue = new ErpDiscardDepreciationValue();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erpDiscardDepreciationValue.setVersion("O_2017_1");
			try {
				erpDiscardDepreciationValue.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erpCsksRecord.setErpCsksRecordId(csvRecord.get("ERP_CSKS_RECORD_ID"));
			// erpCsksRecord.setVersion(csvRecord.get("VERSION"));
			// erpCsksRecord.setCalYear(new Date(csvRecord.get("CAL_YEAR")));
			// erpDiscardDepreciationValue.setErpDiscDepreciationValueId(csvRecord.get("ERP_DISC_DEPRECIATION_VALUE_ID"));
			// erpDiscardDepreciationValue.setVersion(csvRecord.get("VERSION"));
			// erpDiscardDepreciationValue.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erpDiscardDepreciationValue.setAssetId(csvRecord.get("ASSET_ID"));
			erpDiscardDepreciationValue.setOriginalValue(Double.parseDouble(csvRecord.get("ORIGINAL_VALUE")));
			erpDiscardDepreciationValue
					.setDiscardDepreciation(Double.parseDouble(csvRecord.get("DISCARD_DEPRECIATION")));

			session.save(erpDiscardDepreciationValue);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErpCsksRecordAdd(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ErpCsksRecord erpCsksRecord = new ErpCsksRecord();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erpCsksRecord.setVersion("O_2017_1");
			try {
				erpCsksRecord.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erpCsksRecord.setErpCsksRecordId(csvRecord.get("ERP_CSKS_RECORD_ID"));
			// erpCsksRecord.setVersion(csvRecord.get("VERSION"));
			// erpCsksRecord.setCalYear(new Date(csvRecord.get("CAL_YEAR")));
			erpCsksRecord.setProfitConentCode(csvRecord.get("PROFIT_CONENT_CODE"));
			erpCsksRecord.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erpCsksRecord.setSecondProfitCode(csvRecord.get("SECOND_PROFIT_CODE"));
			try {
				if (!csvRecord.get("VALID_END_DATE").isEmpty())
					erpCsksRecord
							.setValidEndDate(simpleDateFormat.parse(csvRecord.get("VALID_END_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			try {
				if (!csvRecord.get("VALID_START_DATE").isEmpty())
					erpCsksRecord
							.setValidStartDate(simpleDateFormat.parse(csvRecord.get("VALID_START_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}

			session.save(erpCsksRecord);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErp2anlaRecordSheet10Add(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			Erp2anlaRecordSheet10 erp2anlaRecordSheet10 = new Erp2anlaRecordSheet10();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erp2anlaRecordSheet10.setVersion("O_2017_1");
			try {
				erp2anlaRecordSheet10.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erp2anlaRecordSheet10.seterp2anlaRecordSheet10Id(csvRecord.get("ERP_2ANLA_RECORD_SHEET1_ID"));
			// erp2anlaRecordSheet10.setVersion(csvRecord.get("VERSION"));
			// erp2anlaRecordSheet10.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erp2anlaRecordSheet10.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erp2anlaRecordSheet10.setAssetId(csvRecord.get("ASSET_ID"));
			erp2anlaRecordSheet10.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erp2anlaRecordSheet10.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erp2anlaRecordSheet10.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			// erp2anlaRecordSheet10.setCapitalizationDate(new
			// Date(csvRecord.get("CAPITALIZATION_DATE")));
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erp2anlaRecordSheet10.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// erp2anlaRecordSheet10.setUnactivedDate(new
			// Date(csvRecord.get("UNACTIVED_DATE")));
			try {
				if (!csvRecord.get("UNACTIVED_DATE").isEmpty())
					erp2anlaRecordSheet10
							.setUnactivedDate(simpleDateFormat.parse(csvRecord.get("UNACTIVED_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erp2anlaRecordSheet10.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			erp2anlaRecordSheet10.setAssetState(csvRecord.get("ASSET_STATE"));
			erp2anlaRecordSheet10.setIsEscrow(csvRecord.get("IS_ESCROW"));
			erp2anlaRecordSheet10.setManufacturer(csvRecord.get("MANUFACTURER"));
			// erp2anlaRecordSheet10.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			if (csvRecord.get("QUANTITY").isEmpty()) {
				erp2anlaRecordSheet10.setQuantity(new Double(0.0));
			} else {
				erp2anlaRecordSheet10.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			}
			erp2anlaRecordSheet10.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			erp2anlaRecordSheet10.setDataSource(csvRecord.get("DATA_SOURCE"));
			erp2anlaRecordSheet10.setAssetName(csvRecord.get("ASSET_NAME"));
			erp2anlaRecordSheet10.setDescription2(csvRecord.get("DESCRIPTION2"));
			erp2anlaRecordSheet10.setWbsElement(csvRecord.get("WBS_ELEMENT"));

			session.save(erp2anlaRecordSheet10);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErp2anlaRecordSheet11Add(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			Erp2anlaRecordSheet11 erp2anlaRecordSheet11 = new Erp2anlaRecordSheet11();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erp2anlaRecordSheet11.setVersion("O_2017_1");
			try {
				erp2anlaRecordSheet11.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erp2anlaRecordSheet11.seterp2anlaRecordSheet11Id(csvRecord.get("ERP_2ANLA_RECORD_SHEET1_ID"));
			// erp2anlaRecordSheet11.setVersion(csvRecord.get("VERSION"));
			// erp2anlaRecordSheet11.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erp2anlaRecordSheet11.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erp2anlaRecordSheet11.setAssetId(csvRecord.get("ASSET_ID"));
			erp2anlaRecordSheet11.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erp2anlaRecordSheet11.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erp2anlaRecordSheet11.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			// erp2anlaRecordSheet11.setCapitalizationDate(new
			// Date(csvRecord.get("CAPITALIZATION_DATE")));
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erp2anlaRecordSheet11.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// erp2anlaRecordSheet11.setUnactivedDate(new
			// Date(csvRecord.get("UNACTIVED_DATE")));
			try {
				if (!csvRecord.get("UNACTIVED_DATE").isEmpty())
					erp2anlaRecordSheet11
							.setUnactivedDate(simpleDateFormat.parse(csvRecord.get("UNACTIVED_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erp2anlaRecordSheet11.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			erp2anlaRecordSheet11.setAssetState(csvRecord.get("ASSET_STATE"));
			erp2anlaRecordSheet11.setIsEscrow(csvRecord.get("IS_ESCROW"));
			erp2anlaRecordSheet11.setManufacturer(csvRecord.get("MANUFACTURER"));
			// erp2anlaRecordSheet11.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			if (csvRecord.get("QUANTITY").isEmpty()) {
				erp2anlaRecordSheet11.setQuantity(new Double(0.0));
			} else {
				erp2anlaRecordSheet11.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			}
			erp2anlaRecordSheet11.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			erp2anlaRecordSheet11.setDataSource(csvRecord.get("DATA_SOURCE"));
			erp2anlaRecordSheet11.setAssetName(csvRecord.get("ASSET_NAME"));
			erp2anlaRecordSheet11.setDescription2(csvRecord.get("DESCRIPTION2"));
			erp2anlaRecordSheet11.setWbsElement(csvRecord.get("WBS_ELEMENT"));

			session.save(erp2anlaRecordSheet11);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErp2anlaRecordSheet12Add(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			Erp2anlaRecordSheet12 erp2anlaRecordSheet12 = new Erp2anlaRecordSheet12();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erp2anlaRecordSheet12.setVersion("O_2017_1");
			try {
				erp2anlaRecordSheet12.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erp2anlaRecordSheet12.seterp2anlaRecordSheet12Id(csvRecord.get("ERP_2ANLA_RECORD_SHEET1_ID"));
			// erp2anlaRecordSheet12.setVersion(csvRecord.get("VERSION"));
			// erp2anlaRecordSheet12.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erp2anlaRecordSheet12.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erp2anlaRecordSheet12.setAssetId(csvRecord.get("ASSET_ID"));
			erp2anlaRecordSheet12.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erp2anlaRecordSheet12.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erp2anlaRecordSheet12.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			// erp2anlaRecordSheet12.setCapitalizationDate(new
			// Date(csvRecord.get("CAPITALIZATION_DATE")));
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erp2anlaRecordSheet12.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// erp2anlaRecordSheet12.setUnactivedDate(new
			// Date(csvRecord.get("UNACTIVED_DATE")));
			try {
				if (!csvRecord.get("UNACTIVED_DATE").isEmpty())
					erp2anlaRecordSheet12
							.setUnactivedDate(simpleDateFormat.parse(csvRecord.get("UNACTIVED_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erp2anlaRecordSheet12.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			erp2anlaRecordSheet12.setAssetState(csvRecord.get("ASSET_STATE"));
			erp2anlaRecordSheet12.setIsEscrow(csvRecord.get("IS_ESCROW"));
			erp2anlaRecordSheet12.setManufacturer(csvRecord.get("MANUFACTURER"));
			// erp2anlaRecordSheet12.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			if (csvRecord.get("QUANTITY").isEmpty()) {
				erp2anlaRecordSheet12.setQuantity(new Double(0.0));
			} else {
				erp2anlaRecordSheet12.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			}
			erp2anlaRecordSheet12.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			erp2anlaRecordSheet12.setDataSource(csvRecord.get("DATA_SOURCE"));
			erp2anlaRecordSheet12.setAssetName(csvRecord.get("ASSET_NAME"));
			erp2anlaRecordSheet12.setDescription2(csvRecord.get("DESCRIPTION2"));
			erp2anlaRecordSheet12.setWbsElement(csvRecord.get("WBS_ELEMENT"));

			session.save(erp2anlaRecordSheet12);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErp2anlaRecordSheet13Add(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			Erp2anlaRecordSheet13 erp2anlaRecordSheet13 = new Erp2anlaRecordSheet13();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erp2anlaRecordSheet13.setVersion("O_2017_1");
			try {
				erp2anlaRecordSheet13.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erp2anlaRecordSheet13.seterp2anlaRecordSheet13Id(csvRecord.get("ERP_2ANLA_RECORD_SHEET1_ID"));
			// erp2anlaRecordSheet13.setVersion(csvRecord.get("VERSION"));
			// erp2anlaRecordSheet13.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erp2anlaRecordSheet13.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erp2anlaRecordSheet13.setAssetId(csvRecord.get("ASSET_ID"));
			erp2anlaRecordSheet13.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erp2anlaRecordSheet13.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erp2anlaRecordSheet13.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			// erp2anlaRecordSheet13.setCapitalizationDate(new
			// Date(csvRecord.get("CAPITALIZATION_DATE")));
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erp2anlaRecordSheet13.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// erp2anlaRecordSheet13.setUnactivedDate(new
			// Date(csvRecord.get("UNACTIVED_DATE")));
			try {
				if (!csvRecord.get("UNACTIVED_DATE").isEmpty())
					erp2anlaRecordSheet13
							.setUnactivedDate(simpleDateFormat.parse(csvRecord.get("UNACTIVED_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erp2anlaRecordSheet13.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			erp2anlaRecordSheet13.setAssetState(csvRecord.get("ASSET_STATE"));
			erp2anlaRecordSheet13.setIsEscrow(csvRecord.get("IS_ESCROW"));
			erp2anlaRecordSheet13.setManufacturer(csvRecord.get("MANUFACTURER"));
			// erp2anlaRecordSheet13.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			if (csvRecord.get("QUANTITY").isEmpty()) {
				erp2anlaRecordSheet13.setQuantity(new Double(0.0));
			} else {
				erp2anlaRecordSheet13.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			}
			erp2anlaRecordSheet13.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			erp2anlaRecordSheet13.setDataSource(csvRecord.get("DATA_SOURCE"));
			erp2anlaRecordSheet13.setAssetName(csvRecord.get("ASSET_NAME"));
			erp2anlaRecordSheet13.setDescription2(csvRecord.get("DESCRIPTION2"));
			erp2anlaRecordSheet13.setWbsElement(csvRecord.get("WBS_ELEMENT"));

			session.save(erp2anlaRecordSheet13);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErp2anlaRecordSheet9Add(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			Erp2anlaRecordSheet9 erp2anlaRecordSheet9 = new Erp2anlaRecordSheet9();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erp2anlaRecordSheet9.setVersion("O_2017_1");
			try {
				erp2anlaRecordSheet9.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erp2anlaRecordSheet9.seterp2anlaRecordSheet9Id(csvRecord.get("ERP_2ANLA_RECORD_SHEET1_ID"));
			// erp2anlaRecordSheet9.setVersion(csvRecord.get("VERSION"));
			// erp2anlaRecordSheet9.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erp2anlaRecordSheet9.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erp2anlaRecordSheet9.setAssetId(csvRecord.get("ASSET_ID"));
			erp2anlaRecordSheet9.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erp2anlaRecordSheet9.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erp2anlaRecordSheet9.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			// erp2anlaRecordSheet9.setCapitalizationDate(new
			// Date(csvRecord.get("CAPITALIZATION_DATE")));
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erp2anlaRecordSheet9.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// erp2anlaRecordSheet9.setUnactivedDate(new
			// Date(csvRecord.get("UNACTIVED_DATE")));
			try {
				if (!csvRecord.get("UNACTIVED_DATE").isEmpty())
					erp2anlaRecordSheet9
							.setUnactivedDate(simpleDateFormat.parse(csvRecord.get("UNACTIVED_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erp2anlaRecordSheet9.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			erp2anlaRecordSheet9.setAssetState(csvRecord.get("ASSET_STATE"));
			erp2anlaRecordSheet9.setIsEscrow(csvRecord.get("IS_ESCROW"));
			erp2anlaRecordSheet9.setManufacturer(csvRecord.get("MANUFACTURER"));
			// erp2anlaRecordSheet9.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			if (csvRecord.get("QUANTITY").isEmpty()) {
				erp2anlaRecordSheet9.setQuantity(new Double(0.0));
			} else {
				erp2anlaRecordSheet9.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			}
			erp2anlaRecordSheet9.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			erp2anlaRecordSheet9.setDataSource(csvRecord.get("DATA_SOURCE"));
			erp2anlaRecordSheet9.setAssetName(csvRecord.get("ASSET_NAME"));
			erp2anlaRecordSheet9.setDescription2(csvRecord.get("DESCRIPTION2"));
			erp2anlaRecordSheet9.setWbsElement(csvRecord.get("WBS_ELEMENT"));

			session.save(erp2anlaRecordSheet9);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErp2anlaRecordSheet8Add(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			Erp2anlaRecordSheet8 erp2anlaRecordSheet8 = new Erp2anlaRecordSheet8();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erp2anlaRecordSheet8.setVersion("O_2017_1");
			try {
				erp2anlaRecordSheet8.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erp2anlaRecordSheet8.seterp2anlaRecordSheet8Id(csvRecord.get("ERP_2ANLA_RECORD_SHEET1_ID"));
			// erp2anlaRecordSheet8.setVersion(csvRecord.get("VERSION"));
			// erp2anlaRecordSheet8.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erp2anlaRecordSheet8.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erp2anlaRecordSheet8.setAssetId(csvRecord.get("ASSET_ID"));
			erp2anlaRecordSheet8.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erp2anlaRecordSheet8.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erp2anlaRecordSheet8.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			// erp2anlaRecordSheet8.setCapitalizationDate(new
			// Date(csvRecord.get("CAPITALIZATION_DATE")));
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erp2anlaRecordSheet8.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// erp2anlaRecordSheet8.setUnactivedDate(new
			// Date(csvRecord.get("UNACTIVED_DATE")));
			try {
				if (!csvRecord.get("UNACTIVED_DATE").isEmpty())
					erp2anlaRecordSheet8
							.setUnactivedDate(simpleDateFormat.parse(csvRecord.get("UNACTIVED_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erp2anlaRecordSheet8.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			erp2anlaRecordSheet8.setAssetState(csvRecord.get("ASSET_STATE"));
			erp2anlaRecordSheet8.setIsEscrow(csvRecord.get("IS_ESCROW"));
			erp2anlaRecordSheet8.setManufacturer(csvRecord.get("MANUFACTURER"));
			// erp2anlaRecordSheet8.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			if (csvRecord.get("QUANTITY").isEmpty()) {
				erp2anlaRecordSheet8.setQuantity(new Double(0.0));
			} else {
				erp2anlaRecordSheet8.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			}
			erp2anlaRecordSheet8.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			erp2anlaRecordSheet8.setDataSource(csvRecord.get("DATA_SOURCE"));
			erp2anlaRecordSheet8.setAssetName(csvRecord.get("ASSET_NAME"));
			erp2anlaRecordSheet8.setDescription2(csvRecord.get("DESCRIPTION2"));
			erp2anlaRecordSheet8.setWbsElement(csvRecord.get("WBS_ELEMENT"));

			session.save(erp2anlaRecordSheet8);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErp2anlaRecordSheet7Add(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			Erp2anlaRecordSheet7 erp2anlaRecordSheet7 = new Erp2anlaRecordSheet7();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erp2anlaRecordSheet7.setVersion("O_2017_1");
			try {
				erp2anlaRecordSheet7.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erp2anlaRecordSheet7.seterp2anlaRecordSheet7Id(csvRecord.get("ERP_2ANLA_RECORD_SHEET1_ID"));
			// erp2anlaRecordSheet7.setVersion(csvRecord.get("VERSION"));
			// erp2anlaRecordSheet7.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erp2anlaRecordSheet7.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erp2anlaRecordSheet7.setAssetId(csvRecord.get("ASSET_ID"));
			erp2anlaRecordSheet7.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erp2anlaRecordSheet7.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erp2anlaRecordSheet7.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			// erp2anlaRecordSheet7.setCapitalizationDate(new
			// Date(csvRecord.get("CAPITALIZATION_DATE")));
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erp2anlaRecordSheet7.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// erp2anlaRecordSheet7.setUnactivedDate(new
			// Date(csvRecord.get("UNACTIVED_DATE")));
			try {
				if (!csvRecord.get("UNACTIVED_DATE").isEmpty())
					erp2anlaRecordSheet7
							.setUnactivedDate(simpleDateFormat.parse(csvRecord.get("UNACTIVED_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erp2anlaRecordSheet7.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			erp2anlaRecordSheet7.setAssetState(csvRecord.get("ASSET_STATE"));
			erp2anlaRecordSheet7.setIsEscrow(csvRecord.get("IS_ESCROW"));
			erp2anlaRecordSheet7.setManufacturer(csvRecord.get("MANUFACTURER"));
			// erp2anlaRecordSheet7.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			if (csvRecord.get("QUANTITY").isEmpty()) {
				erp2anlaRecordSheet7.setQuantity(new Double(0.0));
			} else {
				erp2anlaRecordSheet7.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			}
			erp2anlaRecordSheet7.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			erp2anlaRecordSheet7.setDataSource(csvRecord.get("DATA_SOURCE"));
			erp2anlaRecordSheet7.setAssetName(csvRecord.get("ASSET_NAME"));
			erp2anlaRecordSheet7.setDescription2(csvRecord.get("DESCRIPTION2"));
			erp2anlaRecordSheet7.setWbsElement(csvRecord.get("WBS_ELEMENT"));

			session.save(erp2anlaRecordSheet7);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErp2anlaRecordSheet6Add(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			Erp2anlaRecordSheet6 erp2anlaRecordSheet6 = new Erp2anlaRecordSheet6();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erp2anlaRecordSheet6.setVersion("O_2017_1");
			try {
				erp2anlaRecordSheet6.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erp2anlaRecordSheet6.seterp2anlaRecordSheet6Id(csvRecord.get("ERP_2ANLA_RECORD_SHEET1_ID"));
			// erp2anlaRecordSheet6.setVersion(csvRecord.get("VERSION"));
			// erp2anlaRecordSheet6.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erp2anlaRecordSheet6.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erp2anlaRecordSheet6.setAssetId(csvRecord.get("ASSET_ID"));
			erp2anlaRecordSheet6.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erp2anlaRecordSheet6.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erp2anlaRecordSheet6.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			// erp2anlaRecordSheet6.setCapitalizationDate(new
			// Date(csvRecord.get("CAPITALIZATION_DATE")));
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erp2anlaRecordSheet6.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// erp2anlaRecordSheet6.setUnactivedDate(new
			// Date(csvRecord.get("UNACTIVED_DATE")));
			try {
				if (!csvRecord.get("UNACTIVED_DATE").isEmpty())
					erp2anlaRecordSheet6
							.setUnactivedDate(simpleDateFormat.parse(csvRecord.get("UNACTIVED_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erp2anlaRecordSheet6.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			erp2anlaRecordSheet6.setAssetState(csvRecord.get("ASSET_STATE"));
			erp2anlaRecordSheet6.setIsEscrow(csvRecord.get("IS_ESCROW"));
			erp2anlaRecordSheet6.setManufacturer(csvRecord.get("MANUFACTURER"));
			// erp2anlaRecordSheet6.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			if (csvRecord.get("QUANTITY").isEmpty()) {
				erp2anlaRecordSheet6.setQuantity(new Double(0.0));
			} else {
				erp2anlaRecordSheet6.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			}
			erp2anlaRecordSheet6.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			erp2anlaRecordSheet6.setDataSource(csvRecord.get("DATA_SOURCE"));
			erp2anlaRecordSheet6.setAssetName(csvRecord.get("ASSET_NAME"));
			erp2anlaRecordSheet6.setDescription2(csvRecord.get("DESCRIPTION2"));
			erp2anlaRecordSheet6.setWbsElement(csvRecord.get("WBS_ELEMENT"));

			session.save(erp2anlaRecordSheet6);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErp2anlaRecordSheet5Add(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			Erp2anlaRecordSheet5 erp2anlaRecordSheet5 = new Erp2anlaRecordSheet5();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erp2anlaRecordSheet5.setVersion("O_2017_1");
			try {
				erp2anlaRecordSheet5.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erp2anlaRecordSheet5.seterp2anlaRecordSheet5Id(csvRecord.get("ERP_2ANLA_RECORD_SHEET1_ID"));
			// erp2anlaRecordSheet5.setVersion(csvRecord.get("VERSION"));
			// erp2anlaRecordSheet5.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erp2anlaRecordSheet5.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erp2anlaRecordSheet5.setAssetId(csvRecord.get("ASSET_ID"));
			erp2anlaRecordSheet5.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erp2anlaRecordSheet5.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erp2anlaRecordSheet5.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			// erp2anlaRecordSheet5.setCapitalizationDate(new
			// Date(csvRecord.get("CAPITALIZATION_DATE")));
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erp2anlaRecordSheet5.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// erp2anlaRecordSheet5.setUnactivedDate(new
			// Date(csvRecord.get("UNACTIVED_DATE")));
			try {
				if (!csvRecord.get("UNACTIVED_DATE").isEmpty())
					erp2anlaRecordSheet5
							.setUnactivedDate(simpleDateFormat.parse(csvRecord.get("UNACTIVED_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erp2anlaRecordSheet5.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			erp2anlaRecordSheet5.setAssetState(csvRecord.get("ASSET_STATE"));
			erp2anlaRecordSheet5.setIsEscrow(csvRecord.get("IS_ESCROW"));
			erp2anlaRecordSheet5.setManufacturer(csvRecord.get("MANUFACTURER"));
			if (csvRecord.get("QUANTITY").isEmpty()) {
				erp2anlaRecordSheet5.setQuantity(new Double(0.0));
			} else {
				erp2anlaRecordSheet5.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			}
			erp2anlaRecordSheet5.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			erp2anlaRecordSheet5.setDataSource(csvRecord.get("DATA_SOURCE"));
			erp2anlaRecordSheet5.setAssetName(csvRecord.get("ASSET_NAME"));
			erp2anlaRecordSheet5.setDescription2(csvRecord.get("DESCRIPTION2"));
			erp2anlaRecordSheet5.setWbsElement(csvRecord.get("WBS_ELEMENT"));

			session.save(erp2anlaRecordSheet5);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErp2anlaRecordSheet3Add(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			Erp2anlaRecordSheet3 erp2anlaRecordSheet3 = new Erp2anlaRecordSheet3();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erp2anlaRecordSheet3.setVersion("O_2017_1");
			try {
				erp2anlaRecordSheet3.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erp2anlaRecordSheet3.seterp2anlaRecordSheet3Id(csvRecord.get("ERP_2ANLA_RECORD_SHEET1_ID"));
			// erp2anlaRecordSheet3.setVersion(csvRecord.get("VERSION"));
			// erp2anlaRecordSheet3.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erp2anlaRecordSheet3.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erp2anlaRecordSheet3.setAssetId(csvRecord.get("ASSET_ID"));
			erp2anlaRecordSheet3.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erp2anlaRecordSheet3.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erp2anlaRecordSheet3.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			// erp2anlaRecordSheet3.setCapitalizationDate(new
			// Date(csvRecord.get("CAPITALIZATION_DATE")));
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erp2anlaRecordSheet3.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// erp2anlaRecordSheet3.setUnactivedDate(new
			// Date(csvRecord.get("UNACTIVED_DATE")));
			try {
				if (!csvRecord.get("UNACTIVED_DATE").isEmpty())
					erp2anlaRecordSheet3
							.setUnactivedDate(simpleDateFormat.parse(csvRecord.get("UNACTIVED_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erp2anlaRecordSheet3.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			erp2anlaRecordSheet3.setAssetState(csvRecord.get("ASSET_STATE"));
			erp2anlaRecordSheet3.setIsEscrow(csvRecord.get("IS_ESCROW"));
			erp2anlaRecordSheet3.setManufacturer(csvRecord.get("MANUFACTURER"));
			if (csvRecord.get("QUANTITY").isEmpty()) {
				erp2anlaRecordSheet3.setQuantity(new Double(0.0));
			} else {
				erp2anlaRecordSheet3.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			}
			erp2anlaRecordSheet3.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			erp2anlaRecordSheet3.setDataSource(csvRecord.get("DATA_SOURCE"));
			erp2anlaRecordSheet3.setAssetName(csvRecord.get("ASSET_NAME"));
			erp2anlaRecordSheet3.setDescription2(csvRecord.get("DESCRIPTION2"));
			erp2anlaRecordSheet3.setWbsElement(csvRecord.get("WBS_ELEMENT"));

			session.save(erp2anlaRecordSheet3);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErp2anlaRecordSheet2Add(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			Erp2anlaRecordSheet2 erp2anlaRecordSheet2 = new Erp2anlaRecordSheet2();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erp2anlaRecordSheet2.setVersion("O_2017_1");
			try {
				erp2anlaRecordSheet2.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erp2anlaRecordSheet2.seterp2anlaRecordSheet2Id(csvRecord.get("ERP_2ANLA_RECORD_SHEET1_ID"));
			// erp2anlaRecordSheet2.setVersion(csvRecord.get("VERSION"));
			// erp2anlaRecordSheet2.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erp2anlaRecordSheet2.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erp2anlaRecordSheet2.setAssetId(csvRecord.get("ASSET_ID"));
			erp2anlaRecordSheet2.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erp2anlaRecordSheet2.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erp2anlaRecordSheet2.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			// erp2anlaRecordSheet2.setCapitalizationDate(new
			// Date(csvRecord.get("CAPITALIZATION_DATE")));
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erp2anlaRecordSheet2.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// erp2anlaRecordSheet2.setUnactivedDate(new
			// Date(csvRecord.get("UNACTIVED_DATE")));
			try {
				if (!csvRecord.get("UNACTIVED_DATE").isEmpty())
					erp2anlaRecordSheet2
							.setUnactivedDate(simpleDateFormat.parse(csvRecord.get("UNACTIVED_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erp2anlaRecordSheet2.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			erp2anlaRecordSheet2.setAssetState(csvRecord.get("ASSET_STATE"));
			erp2anlaRecordSheet2.setIsEscrow(csvRecord.get("IS_ESCROW"));
			erp2anlaRecordSheet2.setManufacturer(csvRecord.get("MANUFACTURER"));
			// erp2anlaRecordSheet2.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			if (csvRecord.get("QUANTITY").isEmpty()) {
				erp2anlaRecordSheet2.setQuantity(new Double(0.0));
			} else {
				erp2anlaRecordSheet2.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			}
			erp2anlaRecordSheet2.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			erp2anlaRecordSheet2.setDataSource(csvRecord.get("DATA_SOURCE"));
			erp2anlaRecordSheet2.setAssetName(csvRecord.get("ASSET_NAME"));
			erp2anlaRecordSheet2.setDescription2(csvRecord.get("DESCRIPTION2"));
			erp2anlaRecordSheet2.setWbsElement(csvRecord.get("WBS_ELEMENT"));

			session.save(erp2anlaRecordSheet2);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErp2anlaRecordSheet1Add(String pathStr) throws IOException {
		File csv = new File(pathStr);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			Erp2anlaRecordSheet1 erp2anlaRecordSheet1 = new Erp2anlaRecordSheet1();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erp2anlaRecordSheet1.setVersion("O_2017_1");
			try {
				erp2anlaRecordSheet1.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erp2anlaRecordSheet1.setErp2anlaRecordSheet1Id(csvRecord.get("ERP_2ANLA_RECORD_SHEET1_ID"));
			// erp2anlaRecordSheet1.setVersion(csvRecord.get("VERSION"));
			// erp2anlaRecordSheet1.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));
			erp2anlaRecordSheet1.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erp2anlaRecordSheet1.setAssetId(csvRecord.get("ASSET_ID"));
			erp2anlaRecordSheet1.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erp2anlaRecordSheet1.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erp2anlaRecordSheet1.setClassifiedCode(csvRecord.get("CLASSIFIED_CODE"));
			// erp2anlaRecordSheet1.setCapitalizationDate(new
			// Date(csvRecord.get("CAPITALIZATION_DATE")));
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erp2anlaRecordSheet1.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// erp2anlaRecordSheet1.setUnactivedDate(new
			// Date(csvRecord.get("UNACTIVED_DATE")));
			try {
				if (!csvRecord.get("UNACTIVED_DATE").isEmpty())
					erp2anlaRecordSheet1
							.setUnactivedDate(simpleDateFormat.parse(csvRecord.get("UNACTIVED_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erp2anlaRecordSheet1.setVoltageLevelCode(csvRecord.get("VOLTAGE_LEVEL_CODE"));
			erp2anlaRecordSheet1.setAssetState(csvRecord.get("ASSET_STATE"));
			erp2anlaRecordSheet1.setIsEscrow(csvRecord.get("IS_ESCROW"));
			erp2anlaRecordSheet1.setManufacturer(csvRecord.get("MANUFACTURER"));
			// erp2anlaRecordSheet1.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			if (csvRecord.get("QUANTITY").isEmpty()) {
				erp2anlaRecordSheet1.setQuantity(new Double(0.0));
			} else {
				erp2anlaRecordSheet1.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			}
			erp2anlaRecordSheet1.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			erp2anlaRecordSheet1.setDataSource(csvRecord.get("DATA_SOURCE"));
			erp2anlaRecordSheet1.setAssetName(csvRecord.get("ASSET_NAME"));
			erp2anlaRecordSheet1.setDescription2(csvRecord.get("DESCRIPTION2"));
			erp2anlaRecordSheet1.setWbsElement(csvRecord.get("WBS_ELEMENT"));

			session.save(erp2anlaRecordSheet1);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvZfiSwzcNewAdd(String pathStr) throws IOException {
		// File csv = new File("F:/temp/SHEET-1-IMPORT-20181111-去除-#NA.csv");
		//
		File csv = new File(pathStr);
		// File csv = new File("F:/temp/SHEET-3-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/SHEET-W1-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/SHEET-W2-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/SHEET-W3-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/SHEET-W4-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/SHEET-W5-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/SHEET-W6-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/SHEET-W7-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/SHEET-W8-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/SHEET-W9-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/SHEET-W10-IMPORT-20181111.csv");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ZfiSwzcNew zfiSwzcNew = new ZfiSwzcNew();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			zfiSwzcNew.setVersion("O_2017_1");
			try {
				zfiSwzcNew.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// zfiSwzcNew.setZfiSwzcNewId(csvRecord.get("ZFI_SWZC_NEW_ID"));
			// zfiSwzcNew.setVersion(csvRecord.get("VERSION"));
			// zfiSwzcNew.setCalYear(new Date(csvRecord.get("CAL_YEAR")));
			zfiSwzcNew.setCalyear(Short.parseShort(csvRecord.get("CALYEAR")));
			zfiSwzcNew.setCompCode(csvRecord.get("COMP_CODE"));
			zfiSwzcNew.setAssetMain(csvRecord.get("ASSET_MAIN"));
			zfiSwzcNew.setAsset(csvRecord.get("ASSET"));
			zfiSwzcNew.setEqunr(csvRecord.get("EQUNR"));
			if (csvRecord.get("ZPMZCYZ").isEmpty()) {
				zfiSwzcNew.setZpmzcyz(new Double(0.0));
			} else {
				zfiSwzcNew.setZpmzcyz(Double.parseDouble(csvRecord.get("ZPMZCYZ")));
			}
			if (csvRecord.get("ZPMZCJZ").isEmpty()) {
				zfiSwzcNew.setZpmzcjz(new Double(0.0));
			} else {
				zfiSwzcNew.setZpmzcjz(Double.parseDouble(csvRecord.get("ZPMZCJZ")));
			}
			zfiSwzcNew.setFixedAssetClassCode(csvRecord.get("FIXED_ASSET_CLASS_CODE"));
			zfiSwzcNew.setZtypbz1(csvRecord.get("ZTYPBZ1"));
			zfiSwzcNew.setZtypbz2(csvRecord.get("ZTYPBZ2"));
			zfiSwzcNew.setZtypbz3(csvRecord.get("ZTYPBZ3"));
			zfiSwzcNew.setZvolLev(csvRecord.get("ZVOL_LEV"));
			if (csvRecord.get("ZQUANTITY").isEmpty()) {
				zfiSwzcNew.setZquantity(new Double(0.0));
			} else {
				zfiSwzcNew.setZquantity(Double.parseDouble(csvRecord.get("ZQUANTITY")));
			}
			zfiSwzcNew.setZioZczt(csvRecord.get("ZIO_ZCZT"));
			zfiSwzcNew.setProfitCtr(csvRecord.get("PROFIT_CTR"));
			zfiSwzcNew.setZzcms(csvRecord.get("ZZCMS"));
			zfiSwzcNew.setDescription2(csvRecord.get("DESCRIPTION2"));
			zfiSwzcNew.setWbs(csvRecord.get("WBS"));
			zfiSwzcNew.setZioZxmlx(csvRecord.get("ZIO_ZXMLX"));
			zfiSwzcNew.setAktiv(csvRecord.get("AKTIV"));
			zfiSwzcNew.setDeakt(csvRecord.get("DEAKT"));
			zfiSwzcNew.setAnlkl(csvRecord.get("ANLKL"));
			zfiSwzcNew.setZzc001(csvRecord.get("ZZC001"));
			zfiSwzcNew.setZzc002(csvRecord.get("ZZC002"));
			zfiSwzcNew.setKostl(csvRecord.get("KOSTL"));
			zfiSwzcNew.setIzwek(csvRecord.get("IZWEK"));
			zfiSwzcNew.setAnlue(csvRecord.get("ANLUE"));
			zfiSwzcNew.setHerst(csvRecord.get("HERST"));
			zfiSwzcNew.setEqktx(csvRecord.get("EQKTX"));
			zfiSwzcNew.setTxt04(csvRecord.get("TXT04"));
			zfiSwzcNew.setInbdt(csvRecord.get("INBDT"));
			zfiSwzcNew.setZccrq(csvRecord.get("ZCCRQ"));
			zfiSwzcNew.setZherst(csvRecord.get("ZHERST"));
			zfiSwzcNew.setZsb004(csvRecord.get("ZSB004"));

			session.save(zfiSwzcNew);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErpAnlzRecordAdd() throws IOException {
		// File csv = new File("F:/temp/ANLZ-SHEET-1-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/ANLZ-SHEET-2-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/ANLZ-SHEET-3-IMPORT-20181111.csv");
		//
		File csv = new File("F:/temp/ANLZ-SHEET-4-IMPORT-20181111.csv");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ErpAnlzRecord erpAnlzRecord = new ErpAnlzRecord();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erpAnlzRecord.setVersion("O_2017_1");
			try {
				erpAnlzRecord.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// erpAnlzRecord.setErpAnlzRecordId(csvRecord.get("ERP_ANLZ_RECORD_ID"));
			// erpAnlzRecord.setVersion(csvRecord.get("VERSION"));
			// erpAnlzRecord.setCalYear(new Date(csvRecord.get("CAL_YEAR")));
			erpAnlzRecord.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erpAnlzRecord.setMainAssetId(csvRecord.get("MAIN_ASSET_ID"));
			erpAnlzRecord.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			try {
				if (!csvRecord.get("VALID_END_DATE").isEmpty())
					erpAnlzRecord
							.setValidEndDate(simpleDateFormat.parse(csvRecord.get("VALID_END_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erpAnlzRecord.setProfitCenterCode(csvRecord.get("PROFIT_CENTER_CODE"));
			erpAnlzRecord.setPssElement(csvRecord.get("PSS_ELEMENT"));

			session.save(erpAnlzRecord);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErpAnluRecordAdd() throws IOException {
		// File csv = new File("F:/temp/anlu-SHEET-1-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/anlu-SHEET-2-IMPORT-20181111.csv");
		// File csv = new File("F:/temp/anlu-SHEET-3-IMPORT-20181111.csv");
		//
		File csv = new File("F:/temp/anlu-SHEET-4-IMPORT-20181111.csv");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ErpAnluRecord erpAnluRecord = new ErpAnluRecord();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erpAnluRecord.setVersion("O_2017_1");
			try {
				erpAnluRecord.setCalYear(simpleDateFormat.parse("2017/11/11  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erpAnluRecord.setErpAnluRecordId(csvRecord.get("ERP_ANLU_RECORD_ID"));
			// erpAnluRecord.setVersion(csvRecord.get("VERSION"));
			erpAnluRecord.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erpAnluRecord.setMainAssetId(csvRecord.get("MAIN_ASSET_ID"));
			erpAnluRecord.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erpAnluRecord.setAssetOwnOrgId(csvRecord.get("ASSET_OWN_ORG_ID"));
			erpAnluRecord.setUsingCustodianOrgId(csvRecord.get("USING_CUSTODIAN_ORG_ID"));

			session.save(erpAnluRecord);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErpAnlcRecordAdd() throws IOException {
		// File csv = new File("F:/temp/anlc-SHEET-1-IMPORT-20181111-2.csv");
		//
		File csv = new File("F:/temp/anlc-SHEET-2-IMPORT-20181111-2.csv");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ErpAnlcRecord erpAnlcRecord = new ErpAnlcRecord();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			erpAnlcRecord.setVersion("O_2017_1");
			try {
				erpAnlcRecord.setCalYear(simpleDateFormat.parse("2017/11/07  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// erpAnlcRecord.setErpAnlcRecordId(csvRecord.get("ERP_ANLC_RECORD_ID"));
			// erpAnlcRecord.setCalYear(new Date(csvRecord.get("CAL_YEAR")));
			erpAnlcRecord.setCompanyCode(csvRecord.get("COMPANY_CODE"));
			erpAnlcRecord.setMainAssetId(csvRecord.get("MAIN_ASSET_ID"));
			erpAnlcRecord.setSecondaryCode(csvRecord.get("SECONDARY_CODE"));
			erpAnlcRecord.setCalyear(Long.parseLong(csvRecord.get("CALYEAR")));
			erpAnlcRecord.setArCode(csvRecord.get("AR_CODE"));
			erpAnlcRecord.setOriginalValue(Double.parseDouble(csvRecord.get("ORIGINAL_VALUE")));
			erpAnlcRecord.setAccumulatGeneralDepreciation(
					Double.parseDouble(csvRecord.get("ACCUMULAT_GENERAL_DEPRECIATION")));
			erpAnlcRecord.setUnplannedDepreciation(Double.parseDouble(csvRecord.get("UNPLANNED_DEPRECIATION")));
			erpAnlcRecord.setNetValue(Double.parseDouble(csvRecord.get("NET_VALUE")));

			session.save(erpAnlcRecord);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvPmsItemDefectHebeiAdd(String pathStr) throws IOException {
		File csv = new File(pathStr);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			PmsItemDefectHebei pmsItemDefectHebei = new PmsItemDefectHebei();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			// erpItemOldDiscard.setVersion("O_2015_1");
			// erpItemOldDiscard.setVersion("O_2015_2");
			//
			pmsItemDefectHebei.setVersion("O_2017_1");
			try {
				pmsItemDefectHebei.setCalYear(simpleDateFormat.parse("2017/11/07  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// pmsItemDefectHebei.setPmsItemDefectId(csvRecord.get("PMS_ITEM_DEFECT_ID"));
			// pmsItemDefectHebei.setCalYear(new
			// Date(csvRecord.get("CAL_YEAR")));

			pmsItemDefectHebei.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			pmsItemDefectHebei.setOrgName(csvRecord.get("ORG_NAME"));
			pmsItemDefectHebei.setAssetDetailClassCode(csvRecord.get("ASSET_DETAIL_CLASS_CODE"));
			pmsItemDefectHebei.setAssetDetailClassDescription(csvRecord.get("ASSET_DETAIL_CLASS_DESCRIPTION"));
			pmsItemDefectHebei.setDefectId(csvRecord.get("DEFECT_ID"));
			pmsItemDefectHebei.setDefectHappenDepartment(csvRecord.get("DEFECT_HAPPEN_DEPARTMENT"));
			pmsItemDefectHebei.setSubstationLineName(csvRecord.get("SUBSTATION_LINE_NAME"));
			pmsItemDefectHebei.setDefectMainEpuipName(csvRecord.get("DEFECT_MAIN_EPUIP_NAME"));
			pmsItemDefectHebei.setDefectContent(csvRecord.get("DEFECT_CONTENT"));
			pmsItemDefectHebei.setEquipmentTypeCode(csvRecord.get("EQUIPMENT_TYPE_CODE"));
			pmsItemDefectHebei.setEquipmentType(csvRecord.get("EQUIPMENT_TYPE"));
			if (csvRecord.get("DELIVERY_YEAR").isEmpty()) {
				pmsItemDefectHebei.setDeliveryYear(new Long(0));
			} else {
				pmsItemDefectHebei.setDeliveryYear(Long.parseLong(csvRecord.get("DELIVERY_YEAR")));
			}
			pmsItemDefectHebei.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			pmsItemDefectHebei.setManufacturer(csvRecord.get("MANUFACTURER"));
			pmsItemDefectHebei.setEquipmentLineName(csvRecord.get("EQUIPMENT_LINE_NAME"));
			pmsItemDefectHebei.setDefectDescription(csvRecord.get("DEFECT_DESCRIPTION"));
			pmsItemDefectHebei.setDefectPosition(csvRecord.get("DEFECT_POSITION"));
			pmsItemDefectHebei.setDefectDutyReason(csvRecord.get("DEFECT_DUTY_REASON"));
			pmsItemDefectHebei.setWhetherEliminateDefect(csvRecord.get("WHETHER_ELIMINATE_DEFECT"));
			pmsItemDefectHebei.setIsOnTime(csvRecord.get("IS_ON_TIME"));
			pmsItemDefectHebei.setDutyReasonCode(csvRecord.get("DUTY_REASON_CODE"));
			pmsItemDefectHebei.setDefectTechnicalReason(csvRecord.get("DEFECT_TECHNICAL_REASON"));
			pmsItemDefectHebei.setTechnicalReasonCode(csvRecord.get("TECHNICAL_REASON_CODE"));
			pmsItemDefectHebei.setDefectDegree(csvRecord.get("DEFECT_DEGREE"));
			try {
				if (!csvRecord.get("DEFECT_OCCURRENCE_DATE").isEmpty())
					pmsItemDefectHebei.setDefectOccurrenceDate(
							simpleDateFormat.parse(csvRecord.get("DEFECT_OCCURRENCE_DATE") + ":00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			try {
				if (!csvRecord.get("DEFECT_ELIMINATE_DATE").isEmpty())
					pmsItemDefectHebei.setDefectEliminateDate(
							simpleDateFormat.parse(csvRecord.get("DEFECT_ELIMINATE_DATE") + ":00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			pmsItemDefectHebei.setRemark(csvRecord.get("REMARK"));
			if (csvRecord.get("DEFECT_ELIMINATE_DAYS").isEmpty()) {
				pmsItemDefectHebei.setDefectEliminateDays(new Double(0.0));
			} else {
				pmsItemDefectHebei.setDefectEliminateDays(Double.parseDouble(csvRecord.get("DEFECT_ELIMINATE_DAYS")));
			}
			pmsItemDefectHebei.setTechnicalReason(csvRecord.get("TECHNICAL_REASON"));
			pmsItemDefectHebei.setDutyReason(csvRecord.get("DUTY_REASON"));
			pmsItemDefectHebei.setStandardDefectPosition(csvRecord.get("STANDARD_DEFECT_POSITION"));
			pmsItemDefectHebei.setStandardDefectTechReason(csvRecord.get("STANDARD_DEFECT_TECH_REASON"));
			pmsItemDefectHebei.setStandardDefectDutyReason(csvRecord.get("STANDARD_DEFECT_DUTY_REASON"));

			session.save(pmsItemDefectHebei);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public List<Object> findByClassofSourceTable(String id) {

		List<Object> result = new ArrayList<Object>();
		String shql = "from ReportTableMin rt,STableMin s"
				+ " where s.STableId = rt.tableId and rt.reportClassMin.reportClassId = ?";
		String chql = "from ReportTableMin rt,CTableMin C"
				+ " where c.CTableId = rt.tableId and rt.reportClassMin.reportClassId = ?";
		// Query squeryObject = getCurrentSession().createQuery(shql);
		// Query cqueryObject = getCurrentSession().createQuery(chql);
		// squeryObject.setParameter(0, id);
		// cqueryObject.setParameter(0, id);
		// List<Object> sList=squeryObject.list();
		// List<Object> cList=squeryObject.list();
		// result.addAll(sList);
		// result.addAll(cList);
		return result;

	}

	public static void csvErpItemOldDiscardAdd() throws IOException {
		// File csv = new
		// File("F:/temp/2011-2015-DISCARD-VERSION=O_2015_1-20181107-6.csv");
		// File csv = new
		// File("F:/temp/2015HEBEI-DISCARDVERSION=O_2015_2-20181107-2.csv");
		//
		File csv = new File("F:/temp/2016HEBEI-DISCARD-VERSION=O_2016_1-20181107-5.csv");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ErpItemOldDiscard erpItemOldDiscard = new ErpItemOldDiscard();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 */
			// erpItemOldDiscard.setVersion("O_2015_1");
			// erpItemOldDiscard.setVersion("O_2015_2");
			//
			erpItemOldDiscard.setVersion("O_2016_1");
			try {
				// erpItemOldDiscard.setCalYear(simpleDateFormat.parse("2015/11/07
				// 00:00:00"));
				// erpItemOldDiscard.setCalYear(simpleDateFormat.parse("2015/11/10
				// 00:00:00"));
				erpItemOldDiscard.setCalYear(simpleDateFormat.parse("2016/11/07  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * System.out.println("INDEX_ID:" + csvRecord.get("INDEX_ID"));
			 */
			erpItemOldDiscard.setProfitCenterId(csvRecord.get("PROFIT_CENTER_ID"));
			erpItemOldDiscard.setNeng(csvRecord.get("NENG"));
			erpItemOldDiscard.setOrgName(csvRecord.get("ORG_NAME"));
			erpItemOldDiscard.setAreaName(csvRecord.get("AREA_NAME"));
			erpItemOldDiscard.setSubstation(csvRecord.get("SUBSTATION"));
			erpItemOldDiscard.setEquipmentType(csvRecord.get("EQUIPMENT_TYPE"));
			erpItemOldDiscard.setEquipmentClass(csvRecord.get("EQUIPMENT_CLASS"));
			erpItemOldDiscard.setPmsEquipmentId(csvRecord.get("PMS_EQUIPMENT_ID"));
			erpItemOldDiscard.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erpItemOldDiscard.setAssetId(csvRecord.get("ASSET_ID"));
			erpItemOldDiscard.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			erpItemOldDiscard.setEquipmentMode(csvRecord.get("EQUIPMENT_MODE"));
			try {
				if (!csvRecord.get("DELIVERY_DATE").isEmpty())
					erpItemOldDiscard
							.setDeliveryDate(simpleDateFormat.parse(csvRecord.get("DELIVERY_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			try {
				if (!csvRecord.get("MANUFACTURE_DATE").isEmpty())
					erpItemOldDiscard.setManufactureDate(
							simpleDateFormat.parse(csvRecord.get("MANUFACTURE_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			try {
				if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
					erpItemOldDiscard.setCapitalizationDate(
							simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			try {
				if (!csvRecord.get("DISCARD_DATE").isEmpty())
					erpItemOldDiscard
							.setDiscardDate(simpleDateFormat.parse(csvRecord.get("DISCARD_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			// System.out.println("DISCARD_YEAR:" +
			// csvRecord.get("DISCARD_YEAR")+csvRecord.get("DISCARD_YEAR").isEmpty()+i);
			if (csvRecord.get("DISCARD_YEAR").isEmpty())
				erpItemOldDiscard.setDiscardYear(new Long(0));
			else {
				// System.out.println("DISCARD_YEAR:" +
				// csvRecord.get("DISCARD_YEAR"));
				erpItemOldDiscard.setDiscardYear(Long.parseLong(csvRecord.get("DISCARD_YEAR")));
			}
			erpItemOldDiscard.setDiscardReason(csvRecord.get("DISCARD_REASON"));
			erpItemOldDiscard.setDiscardProject(csvRecord.get("DISCARD_PROJECT"));
			if (csvRecord.get("DISCARD_ORIGINAL_VALUE").isEmpty()) {
				erpItemOldDiscard.setDiscardOriginalValue(new Double(0.0));
			} else {
				erpItemOldDiscard.setDiscardOriginalValue(Double.parseDouble(csvRecord.get("DISCARD_ORIGINAL_VALUE")));
			}
			if (csvRecord.get("DISCARD_NET_VALUE").isEmpty()) {
				erpItemOldDiscard.setDiscardNetValue(new Double(0.0));
			} else {
				erpItemOldDiscard.setDiscardNetValue(Double.parseDouble(csvRecord.get("DISCARD_NET_VALUE")));
			}
			erpItemOldDiscard.setManufacturer(csvRecord.get("MANUFACTURER"));
			if (csvRecord.get("USE_AGE").isEmpty()) {
				erpItemOldDiscard.setUseAge(new Double(0.0));
			} else {
				erpItemOldDiscard.setUseAge(Double.parseDouble(csvRecord.get("USE_AGE")));
			}
			erpItemOldDiscard.setMinimumDate(csvRecord.get("MINIMUM_DATE"));
			erpItemOldDiscard.setRemark(csvRecord.get("REMARK"));
			erpItemOldDiscard.setProjectId(csvRecord.get("PROJECT_ID"));
			if (!csvRecord.get("ENTITY_RATIO").isEmpty()) {
				erpItemOldDiscard.setEntityRatio(new Double(0.0));
			} else {
				erpItemOldDiscard.setEntityRatio(Double.parseDouble(csvRecord.get("ENTITY_RATIO")));
			}
			erpItemOldDiscard.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			erpItemOldDiscard.setEquipmentModeCode(csvRecord.get("EQUIPMENT_MODE_CODE"));
			erpItemOldDiscard.setEquipmentVoltageLevel(csvRecord.get("EQUIPMENT_VOLTAGE_LEVEL"));
			session.save(erpItemOldDiscard);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErpPropertyRecordAdd(String pathStr) throws IOException {
		// File csv = new File("F:/temp/2017INCREASED_FEEDBACK_BAODING-OK.csv");
		// // CSV文件路径
		// File csv = new
		// File("F:/temp/2017INCREASED_FEEDBACK_CHANGZHOU-2018.10.12-OK20181031.csv");
		// // CSV文件路径
		File csv = new File(pathStr); // CSV文件路径

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			// System.out.println("MANDT:" + csvRecord.get("MANDT"));
			ErpPropertyRecord erpPropertyRecord = new ErpPropertyRecord();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			/*
			 * System.out.println("INDEX_ID:" + csvRecord.get("INDEX_ID"));
			 * System.out.println("EQUIPMENT_ID:" + csvRecord.get("EQUIPMENT_ID"));
			 * System.out.println("PROPERTY_CODE:" + csvRecord.get("PROPERTY_CODE"));
			 * System.out.println("PROPERTY_NAME:" + csvRecord.get("PROPERTY_NAME"));
			 */
			erpPropertyRecord.setIndexId(csvRecord.get("INDEX_ID"));
			erpPropertyRecord.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erpPropertyRecord.setPropertyCode(csvRecord.get("PROPERTY_CODE"));
			erpPropertyRecord.setPropertyName(csvRecord.get("PROPERTY_NAME"));
			session.save(erpPropertyRecord);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvErpItemIncreasedImpAdd(String pathStr) throws IOException {
		// File csv = new File("F:/temp/2017INCREASED_FEEDBACK_BAODING-OK.csv");
		// // CSV文件路径
		// File csv = new
		// File("F:/temp/2017INCREASED_FEEDBACK_CHANGZHOU-2018.10.12-OK20181031.csv");
		// // CSV文件路径
		File csv = new File(pathStr); // CSV文件路径

		// File csv = new
		// File("F:/temp/2017INCREASED_FEEDBACK_HANDAN-2018.10.12-OK20181031.csv");
		// // CSV文件路径
		// File csv = new
		// File("F:/temp/2017INCREASED_FEEDBACK_HENGSHUI-2018.10.12-OK20181031.csv");
		// // CSV文件路径
		// File csv = new
		// File("F:/temp/2017INCREASED_FEEDBACK_JIANXIU-OK-201810310921.csv");
		// // CSV文件路径
		// File csv = new
		// File("F:/temp/2017INCREASED_FEEDBACK_SHIJIAZHUANG-2018.10.12-OK20181031.csv");
		// // CSV文件路径
		// File csv = new
		// File("F:/temp/2017INCREASED_FEEDBACK_XINGTAI-2018.10.12-OK20181031.csv");
		// // CSV文件路径

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			// System.out.println("MANDT:" + csvRecord.get("MANDT"));
			ErpItemIncreasedImp erpItemIncreasedImp = new ErpItemIncreasedImp();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {
				if (!csvRecord.get("CAL_YEAR").isEmpty())
					erpItemIncreasedImp.setCalYear(simpleDateFormat.parse(csvRecord.get("CAL_YEAR") + " 00:00:00"));
				else
					erpItemIncreasedImp.setCalYear(simpleDateFormat.parse("2017/10/31  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			 * System.out.println("ZPMZCYZ:" + csvRecord.get("ZPMZCYZ"));
			 * System.out.println("ZPMZCJZ:" + csvRecord.get("ZPMZCJZ"));
			 * System.out.println("ZQUANTITY:" + csvRecord.get("ZQUANTITY"));
			 */
			erpItemIncreasedImp.setVersion("O_2017_1");
			// erpItemIncreasedImp.setErpItemIncreasedImpId(csvRecord.get("ERP_ITEM_INCREASED_IMP_ID"));
			erpItemIncreasedImp.setMandt(csvRecord.get("MANDT"));
			erpItemIncreasedImp.setCompCode(csvRecord.get("COMP_CODE"));
			erpItemIncreasedImp.setAssetMain(csvRecord.get("ASSET_MAIN"));
			erpItemIncreasedImp.setAsset(csvRecord.get("ASSET"));
			erpItemIncreasedImp.setEqunr(csvRecord.get("EQUNR"));
			erpItemIncreasedImp.setCurrency(csvRecord.get("CURRENCY"));
			erpItemIncreasedImp.setZpmzcyz(new BigDecimal(Double.parseDouble(csvRecord.get("ZPMZCYZ"))));
			erpItemIncreasedImp.setZpmzcjz(new BigDecimal(Double.parseDouble(csvRecord.get("ZPMZCJZ"))));
			erpItemIncreasedImp.setZtypbz1(csvRecord.get("ZTYPBZ1"));
			erpItemIncreasedImp.setZtypbz1t(csvRecord.get("ZTYPBZ1T"));
			erpItemIncreasedImp.setZtypbz2(csvRecord.get("ZTYPBZ2"));
			erpItemIncreasedImp.setZtypbz2t(csvRecord.get("ZTYPBZ2T"));
			erpItemIncreasedImp.setZtypbz3(csvRecord.get("ZTYPBZ3"));
			erpItemIncreasedImp.setZtypbz3t(csvRecord.get("ZTYPBZ3T"));
			erpItemIncreasedImp.setZvolLev(csvRecord.get("ZVOL_LEV"));
			erpItemIncreasedImp.setZquantity(new BigDecimal(Double.parseDouble(csvRecord.get("ZQUANTITY"))));
			erpItemIncreasedImp.setUnit(csvRecord.get("UNIT"));
			erpItemIncreasedImp.setZioZczt(csvRecord.get("ZIO_ZCZT"));
			erpItemIncreasedImp.setProfitCtr(csvRecord.get("PROFIT_CTR"));
			erpItemIncreasedImp.setZlrzx(csvRecord.get("ZLRZX"));
			erpItemIncreasedImp.setCoArea(csvRecord.get("CO_AREA"));
			erpItemIncreasedImp.setZzcms(csvRecord.get("ZZCMS"));
			erpItemIncreasedImp.setZioZxmlx(csvRecord.get("ZIO_ZXMLX"));
			erpItemIncreasedImp.setAktiv(csvRecord.get("AKTIV"));
			erpItemIncreasedImp.setDeakt(csvRecord.get("DEAKT"));
			erpItemIncreasedImp.setAnlkl(csvRecord.get("ANLKL"));
			erpItemIncreasedImp.setTxk20(csvRecord.get("TXK20"));
			erpItemIncreasedImp.setSernr(csvRecord.get("SERNR"));
			erpItemIncreasedImp.setInvnr(csvRecord.get("INVNR"));
			erpItemIncreasedImp.setZzc001(csvRecord.get("ZZC001"));
			erpItemIncreasedImp.setZzc002(csvRecord.get("ZZC002"));
			erpItemIncreasedImp.setKostl(csvRecord.get("KOSTL"));
			erpItemIncreasedImp.setLtext(csvRecord.get("LTEXT"));
			erpItemIncreasedImp.setKostlv(csvRecord.get("KOSTLV"));
			erpItemIncreasedImp.setRaumn(csvRecord.get("RAUMN"));
			erpItemIncreasedImp.setKfzkz(csvRecord.get("KFZKZ"));
			erpItemIncreasedImp.setZzas1(csvRecord.get("ZZAS1"));
			erpItemIncreasedImp.setZzc006(csvRecord.get("ZZC006"));
			erpItemIncreasedImp.setZzc007(csvRecord.get("ZZC007"));
			erpItemIncreasedImp.setOrd41(csvRecord.get("ORD41"));
			erpItemIncreasedImp.setOrd44(csvRecord.get("ORD44"));
			erpItemIncreasedImp.setGdlgrp(csvRecord.get("GDLGRP"));
			erpItemIncreasedImp.setIzwek(csvRecord.get("IZWEK"));
			erpItemIncreasedImp.setUmwkz(csvRecord.get("UMWKZ"));
			erpItemIncreasedImp.setAnlue(csvRecord.get("ANLUE"));
			erpItemIncreasedImp.setHerst(csvRecord.get("HERST"));
			erpItemIncreasedImp.setTypbz(csvRecord.get("TYPBZ"));
			erpItemIncreasedImp.setStext4(csvRecord.get("STEXT4"));
			erpItemIncreasedImp.setZkpwbs(csvRecord.get("ZKPWBS"));
			erpItemIncreasedImp.setZkpwbsms(csvRecord.get("ZKPWBSMS"));
			erpItemIncreasedImp.setFiamt(csvRecord.get("FIAMT"));
			erpItemIncreasedImp.setStadt(csvRecord.get("STADT"));
			erpItemIncreasedImp.setZfwcqzh(csvRecord.get("ZFWCQZH"));
			erpItemIncreasedImp.setEqktx(csvRecord.get("EQKTX"));
			erpItemIncreasedImp.setTxt04(csvRecord.get("TXT04"));
			erpItemIncreasedImp.setEqart(csvRecord.get("EQART"));
			erpItemIncreasedImp.setBegru(csvRecord.get("BEGRU"));
			erpItemIncreasedImp.setInbdt(csvRecord.get("INBDT"));
			erpItemIncreasedImp.setZccrq(csvRecord.get("ZCCRQ"));
			erpItemIncreasedImp.setZherst(csvRecord.get("ZHERST"));
			erpItemIncreasedImp.setHerld(csvRecord.get("HERLD"));
			erpItemIncreasedImp.setMapar(csvRecord.get("MAPAR"));
			erpItemIncreasedImp.setZtypbz(csvRecord.get("ZTYPBZ"));
			erpItemIncreasedImp.setSerge(csvRecord.get("SERGE"));
			erpItemIncreasedImp.setSwerk(csvRecord.get("SWERK"));
			erpItemIncreasedImp.setStort(csvRecord.get("STORT"));
			erpItemIncreasedImp.setBeber(csvRecord.get("BEBER"));
			erpItemIncreasedImp.setAbckz(csvRecord.get("ABCKZ"));
			erpItemIncreasedImp.setEqfnr(csvRecord.get("EQFNR"));
			erpItemIncreasedImp.setZkostl(csvRecord.get("ZKOSTL"));
			erpItemIncreasedImp.setZsbwbs(csvRecord.get("ZSBWBS"));
			erpItemIncreasedImp.setZsbwbsms(csvRecord.get("ZSBWBSMS"));
			erpItemIncreasedImp.setIwerk(csvRecord.get("IWERK"));
			erpItemIncreasedImp.setIngrp(csvRecord.get("INGRP"));
			erpItemIncreasedImp.setGewrk(csvRecord.get("GEWRK"));
			erpItemIncreasedImp.setTplnr(csvRecord.get("TPLNR"));
			erpItemIncreasedImp.setHequi(csvRecord.get("HEQUI"));
			erpItemIncreasedImp.setTidnr(csvRecord.get("TIDNR"));
			erpItemIncreasedImp.setZsb010(csvRecord.get("ZSB010"));
			erpItemIncreasedImp.setZsb001(csvRecord.get("ZSB001"));
			erpItemIncreasedImp.setZsb002(csvRecord.get("ZSB002"));
			erpItemIncreasedImp.setZsb004(csvRecord.get("ZSB004"));
			erpItemIncreasedImp.setZsb005(csvRecord.get("ZSB005"));
			erpItemIncreasedImp.setZsb006(csvRecord.get("ZSB006"));
			erpItemIncreasedImp.setZsb003(csvRecord.get("ZSB003"));
			erpItemIncreasedImp.setZsb007(csvRecord.get("ZSB007"));
			erpItemIncreasedImp.setZsb008(csvRecord.get("ZSB008"));
			erpItemIncreasedImp.setZlenunt(csvRecord.get("ZLENUNT"));
			erpItemIncreasedImp.setZsb009(csvRecord.get("ZSB009"));
			erpItemIncreasedImp.setZcapunt(csvRecord.get("ZCAPUNT"));
			erpItemIncreasedImp.setZsb011(csvRecord.get("ZSB011"));
			erpItemIncreasedImp.setZeq003(csvRecord.get("ZEQ003"));
			erpItemIncreasedImp.setZeq001(csvRecord.get("ZEQ001"));
			erpItemIncreasedImp.setZeq002(csvRecord.get("ZEQ002"));
			erpItemIncreasedImp.setZlyrkrq(csvRecord.get("ZLYRKRQ"));
			erpItemIncreasedImp.setZlyckrq(csvRecord.get("ZLYCKRQ"));
			erpItemIncreasedImp.setZbfjzrq(csvRecord.get("ZBFJZRQ"));
			erpItemIncreasedImp.setZbfxmbm(csvRecord.get("ZBFXMBM"));
			erpItemIncreasedImp.setZbfxmms(csvRecord.get("ZBFXMMS"));
			erpItemIncreasedImp.setZbfyydm(csvRecord.get("ZBFYYDM"));
			erpItemIncreasedImp.setZbfyywb(csvRecord.get("ZBFYYWB"));
			erpItemIncreasedImp.setPmunr(csvRecord.get("PMUNR"));
			erpItemIncreasedImp.setCdate(csvRecord.get("CDATE"));
			erpItemIncreasedImp.setCtime(csvRecord.get("CTIME"));
			erpItemIncreasedImp.setCname(csvRecord.get("CNAME"));
			session.save(erpItemIncreasedImp);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void dateTest() {

		String strDate = "2005/04/22 00:00:00";
		// 注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 加上时间
		// 必须捕获异常
		try {
			Date date = simpleDateFormat.parse(strDate);
			System.out.println(date);
		} catch (ParseException px) {
			px.printStackTrace();
		}

		System.out.println(new Date().getDate());
		System.out.println(new Date().getMonth() + "-" + new Date().getDay());
		try {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-25"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public static void readeCsv() { try {
	 * 
	 * ArrayList<String[]> csvList = new ArrayList<String[]>(); // 用来保存数据 String
	 * csvFilePath = "F:/temp/ERP_20180827.csv"; // CsvReader reader = new //
	 * CsvReader(csvFilePath,',',Charset.forName("SJIS")); //一般用这编码读就可以了 CsvReader
	 * reader = new CsvReader(csvFilePath, ',', Charset.forName("GB2312")); //
	 * 一般用这编码读就可以了
	 * 
	 * reader.readHeaders(); // 跳过表头 如果需要表头的话，不要写这句。
	 * 
	 * while (reader.readRecord()) { // 逐行读入除表头的数据 csvList.add(reader.getValues());
	 * } reader.close();
	 * 
	 * for (int row = 0; row < csvList.size(); row++) {
	 * 
	 * String cell = csvList.get(row)[0]; // 取得第row行第0列的数据 System.out.println(cell);
	 * 
	 * }
	 * 
	 * } catch (Exception ex) { System.out.println(ex); } }
	 */
	public static void queryCtBreakdown() {
		List<CtBreakdown> ctBreakdownList;
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			// 打开一个Session
			Session session = sf.openSession();
			// 开始一个事务
			Transaction tx = session.beginTransaction();
			// 创建一个
			// CtBreakdown ctBreakdown = new CtBreakdown();
			// CtBreakdownDAO ctBreakdownDao = new CtBreakdownDAO();
			// ctBreakdownDao.setSessionFactory(sf);
			try {

				String queryString = "from CtBreakdown";// "from CtBreakdown ord
														// by areaName desc";
				System.out.println(queryString);
				Query queryObject = session.createQuery(queryString);// sf.getCurrentSession().createQuery(queryString);
				ctBreakdownList = queryObject.list();
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
			System.out.println("The size of the ctBreakdownList=" + ctBreakdownList.size());

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void csvErpItemDiscardHebeiAdd() throws IOException {
		// File csv = new
		// File("F:/temp/2017HEBEI_DISCARD_ITEM_2.1_201810300945.csv"); //
		// CSV文件路径
		File csv = new File("F:/temp/HEBEI20190305/20190304.csv"); // CSV文件路径

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		System.out.println("Record quantity of csv file is :" + csvRecordCount(iterator));
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			// System.out.println("MANDT:" + csvRecord.get("MANDT"));
			ErpItemDiscardHebei erpItemDiscardHebei = new ErpItemDiscardHebei();
			// erpItemDiscardHebei.setErpItemDiscardHebeiId(csvRecord.get("ERP_ITEM_DISCARD_HEBEI_ID"));

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {
				if (!csvRecord.get("CAL_YEAR").isEmpty())
					erpItemDiscardHebei.setCalYear(simpleDateFormat.parse(csvRecord.get("CAL_YEAR") + " 00:00:00"));
				else
					erpItemDiscardHebei.setCalYear(simpleDateFormat.parse("2018/03/05  00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("CALYEAR:" + csvRecord.get("CALYEAR"));
			// System.out.println("ZPMZCYZ:" + csvRecord.get("ZPMZCYZ"));
			// System.out.println("ZPMZCJZ:" + csvRecord.get("ZPMZCJZ"));
			// System.out.println("ZQUANTITY:" + csvRecord.get("ZQUANTITY"));

			erpItemDiscardHebei.setVersion("O_2018_1");
			erpItemDiscardHebei.setMandt(csvRecord.get("MANDT"));
			erpItemDiscardHebei.setCalyear(Integer.parseInt(csvRecord.get("CALYEAR")));
			erpItemDiscardHebei.setCompCode(csvRecord.get("COMP_CODE"));
			erpItemDiscardHebei.setAssetMain(csvRecord.get("ASSET_MAIN"));
			erpItemDiscardHebei.setAsset(csvRecord.get("ASSET"));
			erpItemDiscardHebei.setEqunr(csvRecord.get("EQUNR"));
			erpItemDiscardHebei.setCurrency(csvRecord.get("CURRENCY"));
			erpItemDiscardHebei.setZpmzcyz(new BigDecimal(Double.parseDouble(csvRecord.get("ZPMZCYZ"))));
			erpItemDiscardHebei.setZpmzcjz(new BigDecimal(Double.parseDouble(csvRecord.get("ZPMZCJZ"))));
			erpItemDiscardHebei.setZtypbz1(csvRecord.get("ZTYPBZ1"));
			erpItemDiscardHebei.setZtypbz1t(csvRecord.get("ZTYPBZ1T"));
			erpItemDiscardHebei.setZtypbz2(csvRecord.get("ZTYPBZ2"));
			erpItemDiscardHebei.setZtypbz2t(csvRecord.get("ZTYPBZ2T"));
			erpItemDiscardHebei.setZtypbz3(csvRecord.get("ZTYPBZ3"));
			erpItemDiscardHebei.setZtypbz3t(csvRecord.get("ZTYPBZ3T"));
			erpItemDiscardHebei.setZvolLev(csvRecord.get("ZVOL_LEV"));
			erpItemDiscardHebei.setZquantity(new BigDecimal(Double.parseDouble(csvRecord.get("ZQUANTITY"))));
			erpItemDiscardHebei.setUnit(csvRecord.get("UNIT"));
			erpItemDiscardHebei.setZioZczt(csvRecord.get("ZIO_ZCZT"));
			erpItemDiscardHebei.setProfitCtr(csvRecord.get("PROFIT_CTR"));
			erpItemDiscardHebei.setZlrzx(csvRecord.get("ZLRZX"));
			erpItemDiscardHebei.setCoArea(csvRecord.get("CO_AREA"));
			erpItemDiscardHebei.setZzcms(csvRecord.get("ZZCMS"));
			erpItemDiscardHebei.setZioZxmlx(csvRecord.get("ZIO_ZXMLX"));
			erpItemDiscardHebei.setAktiv(csvRecord.get("AKTIV"));
			erpItemDiscardHebei.setDeakt(csvRecord.get("DEAKT"));
			erpItemDiscardHebei.setAnlkl(csvRecord.get("ANLKL"));
			erpItemDiscardHebei.setTxk20(csvRecord.get("TXK20"));
			erpItemDiscardHebei.setSernr(csvRecord.get("SERNR"));
			erpItemDiscardHebei.setInvnr(csvRecord.get("INVNR"));
			erpItemDiscardHebei.setZzc001(csvRecord.get("ZZC001"));
			erpItemDiscardHebei.setZzc002(csvRecord.get("ZZC002"));
			erpItemDiscardHebei.setKostl(csvRecord.get("KOSTL"));
			erpItemDiscardHebei.setLtext(csvRecord.get("LTEXT"));
			erpItemDiscardHebei.setKostlv(csvRecord.get("KOSTLV"));
			erpItemDiscardHebei.setRaumn(csvRecord.get("RAUMN"));
			erpItemDiscardHebei.setKfzkz(csvRecord.get("KFZKZ"));
			erpItemDiscardHebei.setZzas1(csvRecord.get("ZZAS1"));
			erpItemDiscardHebei.setZzc006(csvRecord.get("ZZC006"));
			erpItemDiscardHebei.setZzc007(csvRecord.get("ZZC007"));
			erpItemDiscardHebei.setOrd41(csvRecord.get("ORD41"));
			erpItemDiscardHebei.setOrd44(csvRecord.get("ORD44"));
			erpItemDiscardHebei.setGdlgrp(csvRecord.get("GDLGRP"));
			erpItemDiscardHebei.setIzwek(csvRecord.get("IZWEK"));
			erpItemDiscardHebei.setUmwkz(csvRecord.get("UMWKZ"));
			erpItemDiscardHebei.setAnlue(csvRecord.get("ANLUE"));
			erpItemDiscardHebei.setHerst(csvRecord.get("HERST"));
			erpItemDiscardHebei.setTypbz(csvRecord.get("TYPBZ"));
			erpItemDiscardHebei.setStext4(csvRecord.get("STEXT4"));
			erpItemDiscardHebei.setZkpwbs(csvRecord.get("ZKPWBS"));
			erpItemDiscardHebei.setZkpwbsms(csvRecord.get("ZKPWBSMS"));
			erpItemDiscardHebei.setFiamt(csvRecord.get("FIAMT"));
			erpItemDiscardHebei.setStadt(csvRecord.get("STADT"));
			erpItemDiscardHebei.setZfwcqzh(csvRecord.get("ZFWCQZH"));
			erpItemDiscardHebei.setEqktx(csvRecord.get("EQKTX"));
			erpItemDiscardHebei.setTxt04(csvRecord.get("TXT04"));
			erpItemDiscardHebei.setEqart(csvRecord.get("EQART"));
			erpItemDiscardHebei.setBegru(csvRecord.get("BEGRU"));
			erpItemDiscardHebei.setInbdt(csvRecord.get("INBDT"));
			erpItemDiscardHebei.setZccrq(csvRecord.get("ZCCRQ"));
			erpItemDiscardHebei.setZherst(csvRecord.get("ZHERST"));
			erpItemDiscardHebei.setHerld(csvRecord.get("HERLD"));
			erpItemDiscardHebei.setMapar(csvRecord.get("MAPAR"));
			erpItemDiscardHebei.setZtypbz(csvRecord.get("ZTYPBZ"));
			erpItemDiscardHebei.setSerge(csvRecord.get("SERGE"));
			erpItemDiscardHebei.setSwerk(csvRecord.get("SWERK"));
			erpItemDiscardHebei.setStort(csvRecord.get("STORT"));
			erpItemDiscardHebei.setBeber(csvRecord.get("BEBER"));
			erpItemDiscardHebei.setAbckz(csvRecord.get("ABCKZ"));
			erpItemDiscardHebei.setEqfnr(csvRecord.get("EQFNR"));
			erpItemDiscardHebei.setZkostl(csvRecord.get("ZKOSTL"));
			erpItemDiscardHebei.setZsbwbs(csvRecord.get("ZSBWBS"));
			erpItemDiscardHebei.setZsbwbsms(csvRecord.get("ZSBWBSMS"));
			erpItemDiscardHebei.setIwerk(csvRecord.get("IWERK"));
			erpItemDiscardHebei.setIngrp(csvRecord.get("INGRP"));
			erpItemDiscardHebei.setGewrk(csvRecord.get("GEWRK"));
			erpItemDiscardHebei.setTplnr(csvRecord.get("TPLNR"));
			erpItemDiscardHebei.setHequi(csvRecord.get("HEQUI"));
			erpItemDiscardHebei.setTidnr(csvRecord.get("TIDNR"));
			erpItemDiscardHebei.setZsb010(csvRecord.get("ZSB010"));
			erpItemDiscardHebei.setZsb001(csvRecord.get("ZSB001"));
			erpItemDiscardHebei.setZsb002(csvRecord.get("ZSB002"));
			erpItemDiscardHebei.setZsb004(csvRecord.get("ZSB004"));
			erpItemDiscardHebei.setZsb005(csvRecord.get("ZSB005"));
			erpItemDiscardHebei.setZsb006(csvRecord.get("ZSB006"));
			erpItemDiscardHebei.setZsb003(csvRecord.get("ZSB003"));
			erpItemDiscardHebei.setZsb007(csvRecord.get("ZSB007"));
			erpItemDiscardHebei.setZsb008(csvRecord.get("ZSB008"));
			erpItemDiscardHebei.setZlenunt(csvRecord.get("ZLENUNT"));
			erpItemDiscardHebei.setZsb009(csvRecord.get("ZSB009"));
			erpItemDiscardHebei.setZcapunt(csvRecord.get("ZCAPUNT"));
			erpItemDiscardHebei.setZsb011(csvRecord.get("ZSB011"));
			erpItemDiscardHebei.setZeq003(csvRecord.get("ZEQ003"));
			erpItemDiscardHebei.setZeq001(csvRecord.get("ZEQ001"));
			erpItemDiscardHebei.setZeq002(csvRecord.get("ZEQ002"));
			erpItemDiscardHebei.setZlyrkrq(csvRecord.get("ZLYRKRQ"));
			erpItemDiscardHebei.setZlyckrq(csvRecord.get("ZLYCKRQ"));
			erpItemDiscardHebei.setZbfjzrq(csvRecord.get("ZBFJZRQ"));
			erpItemDiscardHebei.setZbfxmbm(csvRecord.get("ZBFXMBM"));
			erpItemDiscardHebei.setZbfxmms(csvRecord.get("ZBFXMMS"));
			erpItemDiscardHebei.setZbfyydm(csvRecord.get("ZBFYYDM"));
			erpItemDiscardHebei.setZbfyywb(csvRecord.get("ZBFYYWB"));
			erpItemDiscardHebei.setPmunr(csvRecord.get("PMUNR"));
			erpItemDiscardHebei.setCdate(csvRecord.get("CDATE"));
			erpItemDiscardHebei.setCtime(csvRecord.get("CTIME"));
			erpItemDiscardHebei.setCname(csvRecord.get("CNAME"));
			erpItemDiscardHebei.setDiscardProjectType(csvRecord.get("DISCARD_PROJECT_TYPE"));
			erpItemDiscardHebei.setDiscardReasonStandardValue(csvRecord.get("DISCARD_REASON_STANDARD_VALUE"));
			session.save(erpItemDiscardHebei);

			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}

		tx.commit();
		session.clear();
		sf.close();
	}

	/**
	 * 
	 * @param iterator
	 * @return 统计csv表中的记录数量
	 */

	public static int csvRecordCount(Iterator iterator) {
		int quantity = 0;
		while (iterator.hasNext() && null != iterator.next()) {
			// CSVRecord csvRecord = (CSVRecord)iterator.next();
			// System.out.println("ASSET_MAIN="+csvRecord.get("ASSET_MAIN"));
			quantity++;
			// System.out.println(quantity);
		}

		return quantity;
	}

	public static void csvErpItemDiscardAdd() throws IOException, ParseException {
		File csv = new File("F:/temp/ErpItemDiscard-V1.1-20181026.csv"); // CSV文件路径

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			ErpItemDiscard erpItemDiscard = new ErpItemDiscard();
			// erpItemDiscard.setErpItemDiscardId(csvRecord.get("ERP_ITEM_DISCARD_ID"));
			erpItemDiscard.setCategoryCode(csvRecord.get("CATEGORY_CODE"));
			erpItemDiscard.setApplicationFormId(csvRecord.get("APPLICATION_FORM_ID"));
			erpItemDiscard.setApplicaFormCreatorAccount(csvRecord.get("APPLICA_FORM_CREATOR_ACCOUNT"));
			erpItemDiscard.setXh(csvRecord.get("XH"));
			erpItemDiscard.setWarrantId(csvRecord.get("WARRANT_ID"));
			erpItemDiscard.setApproverAcclunt(csvRecord.get("APPROVER_ACCLUNT"));
			erpItemDiscard.setCurrentApprovalLevel(csvRecord.get("CURRENT_APPROVAL_LEVEL"));
			erpItemDiscard.setFixAssetDiscAppFormState(csvRecord.get("FIX_ASSET_DISC_APP_FORM_STATE"));
			if (!csvRecord.get("APP_FORM_CREATE_DATE").isEmpty())
				erpItemDiscard.setAppFormCreateDate(
						simpleDateFormat.parse(csvRecord.get("APP_FORM_CREATE_DATE") + " 00:00:00"));
			if (!csvRecord.get("APP_FORM_SUBMIT_DATE").isEmpty())
				erpItemDiscard.setAppFormSubmitDate(
						simpleDateFormat.parse(csvRecord.get("APP_FORM_SUBMIT_DATE") + " 00:00:00"));
			erpItemDiscard.setEquipmentId(csvRecord.get("EQUIPMENT_ID"));
			erpItemDiscard.setTechnObjectSpecification(csvRecord.get("TECHN_OBJECT_SPECIFICATION"));
			erpItemDiscard.setEquipmentStatus(csvRecord.get("EQUIPMENT_STATUS"));
			erpItemDiscard.setEquipmentClassCode(csvRecord.get("EQUIPMENT_CLASS_CODE"));
			erpItemDiscard.setAssetCategoryName(csvRecord.get("ASSET_CATEGORY_NAME"));
			erpItemDiscard.setAssetNumber(csvRecord.get("ASSET_NUMBER"));
			erpItemDiscard.setAssetSpecification(csvRecord.get("ASSET_SPECIFICATION"));
			erpItemDiscard.setDiscardDetailDescription(csvRecord.get("DISCARD_DETAIL_DESCRIPTION"));
			erpItemDiscard.setResiduValueDealAssetRenew(csvRecord.get("RESIDU_VALUE_DEAL_ASSET_RENEW"));
			erpItemDiscard.setAssetDiscardCompleteness(csvRecord.get("ASSET_DISCARD_COMPLETENESS"));
			erpItemDiscard.setStateChange(csvRecord.get("STATE_CHANGE"));
			if (!csvRecord.get("ASSET_VALUE_DATE").isEmpty())
				erpItemDiscard
						.setAssetValueDate(simpleDateFormat.parse(csvRecord.get("ASSET_VALUE_DATE") + " 00:00:00"));
			if (!csvRecord.get("ACCOUNT_DATE").isEmpty())
				erpItemDiscard.setAccountDate(simpleDateFormat.parse(csvRecord.get("ACCOUNT_DATE") + " 00:00:00"));
			erpItemDiscard.setComeFrom(csvRecord.get("COME_FROM"));
			erpItemDiscard.setOriginalValue(Double.parseDouble(csvRecord.get("ORIGINAL_VALUE")));
			erpItemDiscard.setAccumulatedDepreciation(Double.parseDouble(csvRecord.get("ACCUMULATED_DEPRECIATION")));
			erpItemDiscard.setBeenImpairmentProvision(Double.parseDouble(csvRecord.get("BEEN_IMPAIRMENT_PROVISION")));
			erpItemDiscard.setNetValue(Double.parseDouble(csvRecord.get("NET_VALUE")));
			erpItemDiscard.setDiscardRate(Double.parseDouble(csvRecord.get("DISCARD_RATE")));
			erpItemDiscard.setDiscardOriginalAmount(Double.parseDouble(csvRecord.get("DISCARD_ORIGINAL_AMOUNT")));
			erpItemDiscard.setDiscardDepreciation(Double.parseDouble(csvRecord.get("DISCARD_DEPRECIATION")));
			erpItemDiscard.setTlzb(Double.parseDouble(csvRecord.get("TLZB")));
			erpItemDiscard.setExpectedSalvageValue(Double.parseDouble(csvRecord.get("EXPECTED_SALVAGE_VALUE")));
			erpItemDiscard
					.setInsuranceLiabilityCompensat(Double.parseDouble(csvRecord.get("INSURANCE_LIABILITY_COMPENSAT")));
			erpItemDiscard.setDocumentDescription(csvRecord.get("DOCUMENT_DESCRIPTION"));
			erpItemDiscard.setReference(csvRecord.get("REFERENCE"));
			erpItemDiscard.setAllocation(csvRecord.get("ALLOCATION"));
			erpItemDiscard.setCostCenter(csvRecord.get("COST_CENTER"));
			erpItemDiscard.setAbstractSpecification(csvRecord.get("ABSTRACT_SPECIFICATION"));
			erpItemDiscard.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			erpItemDiscard.setBunUnit(csvRecord.get("BUN_UNIT"));
			erpItemDiscard.setUnitName(csvRecord.get("UNIT_NAME"));
			erpItemDiscard.setManufacturerName(csvRecord.get("MANUFACTURER_NAME"));
			if (!csvRecord.get("CAPITALIZATION_DATE").isEmpty())
				erpItemDiscard.setCapitalizationDate(
						simpleDateFormat.parse(csvRecord.get("CAPITALIZATION_DATE") + " 00:00:00"));
			erpItemDiscard.setReserverUsingYears(Integer.parseInt(csvRecord.get("RESERVER_USING_YEARS")));
			erpItemDiscard.setReserverUsingMonth(csvRecord.get("RESERVER_USING_MONTH"));
			erpItemDiscard.setMark(csvRecord.get("MARK"));
			erpItemDiscard.setOrgCode(csvRecord.get("ORG_CODE"));
			erpItemDiscard.setOrgName(csvRecord.get("ORG_NAME"));
			erpItemDiscard.setProfitCenterCode(csvRecord.get("PROFIT_CENTER_CODE"));
			erpItemDiscard.setDetailSpecification(csvRecord.get("DETAIL_SPECIFICATION"));
			erpItemDiscard.setAbstract_(csvRecord.get("ABSTRACT"));
			erpItemDiscard.setUserName(csvRecord.get("USER_NAME"));
			erpItemDiscard.setSublevel(csvRecord.get("SUBLEVEL"));
			erpItemDiscard.setZflagProcess(csvRecord.get("ZFLAG_PROCESS"));
			erpItemDiscard.setCurrentSymbol(csvRecord.get("CURRENT_SYMBOL"));
			erpItemDiscard.setCurrentId(csvRecord.get("CURRENT_ID"));
			erpItemDiscard.setCurrentCode(csvRecord.get("CURRENT_CODE"));
			erpItemDiscard.setProcedureCompleIndicate(csvRecord.get("PROCEDURE_COMPLE_INDICATE"));
			erpItemDiscard.setProcedureCreatorAccount(csvRecord.get("PROCEDURE_CREATOR_ACCOUNT"));
			erpItemDiscard.setFinancialStaffAccount(csvRecord.get("FINANCIAL_STAFF_ACCOUNT"));
			if (!csvRecord.get("UDATE").isEmpty())
				erpItemDiscard.setUdate(simpleDateFormat.parse(csvRecord.get("UDATE") + " 00:00:00"));
			if (!csvRecord.get("UTIME").isEmpty())
				erpItemDiscard.setUtime(simpleDateFormat.parse("0001/01/01 " + csvRecord.get("UTIME")));
			erpItemDiscard.setWhethNeedLocalOrgApproval(csvRecord.get("WHETH_NEED_LOCAL_ORG_APPROVAL"));
			erpItemDiscard.setWhethNeedProviOrgApproval(csvRecord.get("WHETH_NEED_PROVI_ORG_APPROVAL"));
			erpItemDiscard.setFjid(csvRecord.get("FJID"));
			erpItemDiscard.setDiscardReasonCode(csvRecord.get("DISCARD_REASON_CODE"));
			erpItemDiscard.setDiscardReasonDiscription(csvRecord.get("DISCARD_REASON_DISCRIPTION"));
			erpItemDiscard.setResiduValueDealAssetRenew2(csvRecord.get("RESIDU_VALUE_DEAL_ASSET_RENEW2"));
			if (!csvRecord.get("DISCARD_WC_DATE").isEmpty())
				erpItemDiscard.setDiscardWcDate(simpleDateFormat.parse(csvRecord.get("DISCARD_WC_DATE") + " 00:00:00"));
			erpItemDiscard.setAssetOutgoingFormId(csvRecord.get("ASSET_OUTGOING_FORM_ID"));
			erpItemDiscard.setZccqhh(csvRecord.get("ZCCQHH"));
			erpItemDiscard.setWriteOffMark(csvRecord.get("WRITE_OFF_MARK"));
			erpItemDiscard
					.setWasteMaterialOutputTaxRate(Double.parseDouble(csvRecord.get("WASTE_MATERIAL_OUTPUT_TAX_RATE")));

			session.save(erpItemDiscard);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		sf.close();
	}

	public static void csvErpItemReuseAdd() throws IOException {
		File csv = new File("F:/temp/ErpItemReuse-V1.0-20181025.csv"); // CSV文件路径

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			ErpItemReuse erpItemReuse = new ErpItemReuse();
			// erpItemReuse.setErpItemReuseId(csvRecord.get("ERP_ITEM_REUSE_ID"));
			erpItemReuse.setCategoryCode(csvRecord.get("CATEGORY_CODE"));
			erpItemReuse.setAssetQuitPlanId(csvRecord.get("ASSET_QUIT_PLAN_ID"));
			erpItemReuse.setRowProjectId(csvRecord.get("ROW_PROJECT_ID"));
			erpItemReuse.setReutilitizationStatus(csvRecord.get("REUTILITIZATION_STATUS"));
			erpItemReuse.setAssetManageStorageStatus(csvRecord.get("ASSET_MANAGE_STORAGE_STATUS"));
			erpItemReuse.setQuitPlanIdDescription(csvRecord.get("QUIT_PLAN_ID_DESCRIPTION"));
			erpItemReuse.setCompanCode(csvRecord.get("COMPAN_CODE"));
			erpItemReuse.setAssetManageOrgId(csvRecord.get("ASSET_MANAGE_ORG_ID"));
			erpItemReuse.setAssetManageOrgName(csvRecord.get("ASSET_MANAGE_ORG_NAME"));
			try {
				if (!csvRecord.get("PLAN_CREATE_DATE").isEmpty())
					erpItemReuse
							.setPlanCreateDate(simpleDateFormat.parse(csvRecord.get("PLAN_CREATE_DATE") + " 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			erpItemReuse.setPlanCreator(csvRecord.get("PLAN_CREATOR"));
			erpItemReuse.setPlanStatus(csvRecord.get("PLAN_STATUS"));
			erpItemReuse.setDoPlanAdjustment(csvRecord.get("DO_PLAN_ADJUSTMENT"));
			try {
				if (!csvRecord.get("AUDIT_FINISHED_DATE").isEmpty())
					erpItemReuse.setAuditFinishedDate(
							simpleDateFormat.parse(csvRecord.get("AUDIT_FINISHED_DATE" + " 00:00:00")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			erpItemReuse.setReutilitizationAssetId(csvRecord.get("REUTILITIZATION_ASSET_ID"));
			erpItemReuse.setReutilitizationAssetName(csvRecord.get("REUTILITIZATION_ASSET_NAME"));
			erpItemReuse.setManufacturerCode(csvRecord.get("MANUFACTURER_CODE"));
			erpItemReuse.setMvt(csvRecord.get("MVT"));
			erpItemReuse.setStoragePlace(csvRecord.get("STORAGE_PLACE"));
			erpItemReuse.setRepositoryAddressDescription(csvRecord.get("REPOSITORY_ADDRESS_DESCRIPTION"));
			erpItemReuse.setQuantity(Double.parseDouble(csvRecord.get("QUANTITY")));
			erpItemReuse.setBunUnit(csvRecord.get("BUN_UNIT"));
			erpItemReuse.setCostCenterId(csvRecord.get("COST_CENTER_ID"));
			erpItemReuse.setMateriaWarehouseWarrantId(csvRecord.get("MATERIA_WAREHOUSE_WARRANT_ID"));
			erpItemReuse.setWriteoffStorageWarrantId(csvRecord.get("WRITEOFF_STORAGE_WARRANT_ID"));
			erpItemReuse.setMateriaOutgoingWarrantId(csvRecord.get("MATERIA_OUTGOING_WARRANT_ID"));
			erpItemReuse.setWriteoffOutgoingWarrantId(csvRecord.get("WRITEOFF_OUTGOING_WARRANT_ID"));
			erpItemReuse.setProjectCategory(csvRecord.get("PROJECT_CATEGORY"));
			erpItemReuse.setProjectDescription(csvRecord.get("PROJECT_DESCRIPTION"));
			erpItemReuse.setProjectDefinitionId(csvRecord.get("PROJECT_DEFINITION_ID"));
			erpItemReuse.setImportantComponentEquipId(csvRecord.get("IMPORTANT_COMPONENT_EQUIP_ID"));
			erpItemReuse.setImportComponentEquipProfile(csvRecord.get("IMPORT_COMPONENT_EQUIP_PROFILE"));
			erpItemReuse.setMainEquipmentId(csvRecord.get("MAIN_EQUIPMENT_ID"));
			erpItemReuse.setMainEquipmentName(csvRecord.get("MAIN_EQUIPMENT_NAME"));
			erpItemReuse.setMainEquipmentVoltageLevel(csvRecord.get("MAIN_EQUIPMENT_VOLTAGE_LEVEL"));
			erpItemReuse.setBelongedToLineSubstation(csvRecord.get("BELONGED_TO_LINE_SUBSTATION"));
			erpItemReuse.setEquipmentType(csvRecord.get("EQUIPMENT_TYPE"));
			erpItemReuse.setManufacturerName(csvRecord.get("MANUFACTURER_NAME"));
			erpItemReuse.setSpecificationModel(csvRecord.get("SPECIFICATION_MODEL"));
			erpItemReuse.setEquipmentCapacity(Double.parseDouble(csvRecord.get("EQUIPMENT_CAPACITY")));
			erpItemReuse.setLineLength(Double.parseDouble(csvRecord.get("LINE_LENGTH")));
			try {
				if (!csvRecord.get("EX_FACTORY_DATE").isEmpty())
					erpItemReuse
							.setExFactoryDate(simpleDateFormat.parse(csvRecord.get("EX_FACTORY_DATE") + " 00:00:00"));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (!csvRecord.get("WORKING_ONLINE_DATE").isEmpty())
					erpItemReuse.setWorkingOnlineDate(
							simpleDateFormat.parse(csvRecord.get("WORKING_ONLINE_DATE") + " 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			erpItemReuse.setAssetCategoryId(csvRecord.get("ASSET_CATEGORY_ID"));
			erpItemReuse.setAssetCategoryName(csvRecord.get("ASSET_CATEGORY_NAME"));
			erpItemReuse.setAssetId(csvRecord.get("ASSET_ID"));
			erpItemReuse.setAssetName(csvRecord.get("ASSET_NAME"));
			erpItemReuse.setAssetOriginalValue(Double.parseDouble(csvRecord.get("ASSET_ORIGINAL_VALUE")));
			erpItemReuse.setAssetNetValue(Double.parseDouble(csvRecord.get("ASSET_NET_VALUE")));
			try {
				if (!csvRecord.get("WARRANT_DATE").isEmpty())
					erpItemReuse.setWarrantDate(simpleDateFormat.parse(csvRecord.get("WARRANT_DATE") + " 00:00:00"));
			} catch (ParseException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			try {
				if (!csvRecord.get("POSTING_DATE").isEmpty())
					erpItemReuse.setPostingDate(simpleDateFormat.parse(csvRecord.get("POSTING_DATE") + " 00:00:00"));
			} catch (ParseException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			erpItemReuse.setReference(csvRecord.get("REFERENCE"));
			erpItemReuse
					.setPlannedDismantlingQuantity(Double.parseDouble(csvRecord.get("PLANNED_DISMANTLING_QUANTITY")));
			erpItemReuse.setAssetQuantityUnit(csvRecord.get("ASSET_QUANTITY_UNIT"));
			try {
				if (!csvRecord.get("PLANNED_QUIT_DATE").isEmpty())
					erpItemReuse.setPlannedQuitDate(
							simpleDateFormat.parse(csvRecord.get("PLANNED_QUIT_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			try {
				if (!csvRecord.get("ACTUAL_DISMANTLING_DATE").isEmpty())
					erpItemReuse.setActualDismantlingDate(
							simpleDateFormat.parse(csvRecord.get("ACTUAL_DISMANTLING_DATE") + " 00:00:00"));
			} catch (ParseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			erpItemReuse.setReusedRate(Double.parseDouble(csvRecord.get("REUSED_RATE")));
			erpItemReuse.setReusedAmount(Double.parseDouble(csvRecord.get("REUSED_AMOUNT")));
			erpItemReuse.setDemandOrgId(csvRecord.get("DEMAND_ORG_ID"));
			erpItemReuse.setDemandOrgName(csvRecord.get("DEMAND_ORG_NAME"));
			erpItemReuse.setDemanderId(csvRecord.get("DEMANDER_ID"));
			erpItemReuse.setDemanderName(csvRecord.get("DEMANDER_NAME"));
			erpItemReuse.setDemanderTeleNumber(csvRecord.get("DEMANDER_TELE_NUMBER"));
			erpItemReuse.setReservedOrg(csvRecord.get("RESERVED_ORG"));
			erpItemReuse.setReservedPerson(csvRecord.get("RESERVED_PERSON"));
			erpItemReuse.setReservedPersonTeleNumber(csvRecord.get("RESERVED_PERSON_TELE_NUMBER"));
			erpItemReuse.setReutiRepositoryFuncPosition(csvRecord.get("REUTI_REPOSITORY_FUNC_POSITION"));
			erpItemReuse.setWorkingOnlineAge(Integer.parseInt(csvRecord.get("WORKING_ONLINE_AGE")));
			erpItemReuse.setRemark(csvRecord.get("REMARK"));
			erpItemReuse.setStatusIndicateSymbol(csvRecord.get("STATUS_INDICATE_SYMBOL"));
			erpItemReuse.setCreator(csvRecord.get("CREATOR"));
			try {
				if (!csvRecord.get("CREATE_DATE").isEmpty())
					erpItemReuse.setCreateDate(simpleDateFormat.parse(csvRecord.get("CREATE_DATE") + " 00:00:00"));
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				if (!csvRecord.get("CREATE_TIME").isEmpty())
					erpItemReuse.setCreateTime(simpleDateFormat.parse("0001/01/01 " + csvRecord.get("CREATE_TIME")));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			erpItemReuse.setWorkflowDocumentReserveId(csvRecord.get("WORKFLOW_DOCUMENT_RESERVE_ID"));
			erpItemReuse.setWorkflowRowProjReserveId(csvRecord.get("WORKFLOW_ROW_PROJ_RESERVE_ID"));
			erpItemReuse.setWorkflowDoc2discardId(csvRecord.get("WORKFLOW_DOC_2DISCARD_ID"));
			erpItemReuse.setWorkflowRowProj2discardId(csvRecord.get("WORKFLOW_ROW_PROJ_2DISCARD_ID"));
			erpItemReuse.setWorkflowDocAppraisalId(csvRecord.get("WORKFLOW_DOC_APPRAISAL_ID"));
			erpItemReuse.setWorkflowRowProjAppraisalId(csvRecord.get("WORKFLOW_ROW_PROJ_APPRAISAL_ID"));
			erpItemReuse.setBfsqdh(csvRecord.get("BFSQDH"));
			erpItemReuse.setZzksj(csvRecord.get("ZZKSJ"));
			try {
				if (!csvRecord.get("JDSJ").isEmpty())
					erpItemReuse.setJdsj(simpleDateFormat.parse(csvRecord.get("JDSJ") + " 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			erpItemReuse.setCzsj(csvRecord.get("CZSJ"));
			erpItemReuse.setAssetCostCenter(csvRecord.get("ASSET_COST_CENTER"));
			erpItemReuse.setReusedStatus(csvRecord.get("REUSED_STATUS"));
			erpItemReuse.setBatchId(csvRecord.get("BATCH_ID"));
			erpItemReuse.setZqxxm(csvRecord.get("ZQXXM"));
			erpItemReuse.setZqxxmms(csvRecord.get("ZQXXMMS"));
			session.save(erpItemReuse);
			if (++i % 100 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		sf.close();
	}

	public static void csvZfiSwzcHeBeiAdd() throws IOException {
		File csv = new File("F:/temp/ERP_20180827.csv"); // CSV文件路径

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		CSVFormat format = CSVFormat.DEFAULT.withHeader();
		InputStreamReader in = new InputStreamReader(new FileInputStream(csv), "GB2312");
		// CSVParser parser = CSVFormat.RFC4180.parse(in);
		CSVParser parser = new CSVParser(in, format);
		Iterator<CSVRecord> iterator = parser.iterator();
		// parser.getHeaderMap().keySet();
		int i = 0;
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			System.out.println("MANDT:" + csvRecord.get("MANDT"));
			ZfiSwzcHeBei zfiSwzcHeBei = new ZfiSwzcHeBei();
			zfiSwzcHeBei.setMandt(csvRecord.get("MANDT"));
			// zfiSwzcHeBei.setCalyear(new
			// BigDecimal(Integer.parseInt(csvRecord.get("CALYEAR"))));
			try {
				zfiSwzcHeBei.setCalyear(new DecimalFormat().parse(csvRecord.get("CALYEAR")).intValue());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			zfiSwzcHeBei.setCompCode((csvRecord.get("COMP_CODE")));
			zfiSwzcHeBei.setAssetMain((csvRecord.get("ASSET_MAIN")));
			zfiSwzcHeBei.setAsset((csvRecord.get("ASSET")));
			zfiSwzcHeBei.setEqunr((csvRecord.get("EQUNR")));
			zfiSwzcHeBei.setCurrency((csvRecord.get("CURRENCY")));
			// zfiSwzcHeBei.setZpmzcyz(new
			// BigDecimal(Double.parseDouble(csvRecord.get("ZPMZCYZ"))));
			// zfiSwzcHeBei.setZpmzcjz(new
			// BigDecimal(Double.parseDouble(csvRecord.get("ZPMZCJZ"))));
			try {
				zfiSwzcHeBei.setZpmzcyz(new DecimalFormat().parse(csvRecord.get("ZPMZCYZ")).doubleValue());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				zfiSwzcHeBei.setZpmzcjz(new DecimalFormat().parse(csvRecord.get("ZPMZCJZ")).doubleValue());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			zfiSwzcHeBei.setZtypbz1((csvRecord.get("ZTYPBZ1")));
			zfiSwzcHeBei.setZtypbz1t((csvRecord.get("ZTYPBZ1T")));
			zfiSwzcHeBei.setZtypbz2((csvRecord.get("ZTYPBZ2")));
			zfiSwzcHeBei.setZtypbz2t((csvRecord.get("ZTYPBZ2T")));
			zfiSwzcHeBei.setZtypbz3((csvRecord.get("ZTYPBZ3")));
			zfiSwzcHeBei.setZtypbz3t((csvRecord.get("ZTYPBZ3T")));
			zfiSwzcHeBei.setZvolLev((csvRecord.get("ZVOL_LEV")));
			// zfiSwzcHeBei.setZquantity(new
			// BigDecimal(Double.parseDouble(csvRecord.get("ZQUANTITY"))));
			try {
				zfiSwzcHeBei.setZquantity(new DecimalFormat().parse(csvRecord.get("ZQUANTITY")).doubleValue());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			zfiSwzcHeBei.setUnit((csvRecord.get("UNIT")));
			zfiSwzcHeBei.setZioZczt((csvRecord.get("ZIO_ZCZT")));
			zfiSwzcHeBei.setProfitCtr((csvRecord.get("PROFIT_CTR")));
			zfiSwzcHeBei.setZlrzx((csvRecord.get("ZLRZX")));
			zfiSwzcHeBei.setCoArea((csvRecord.get("CO_AREA")));
			zfiSwzcHeBei.setZzcms((csvRecord.get("ZZCMS")));
			zfiSwzcHeBei.setZioZxmlx((csvRecord.get("ZIO_ZXMLX")));
			zfiSwzcHeBei.setAktiv((csvRecord.get("AKTIV")));
			zfiSwzcHeBei.setDeakt((csvRecord.get("DEAKT")));
			zfiSwzcHeBei.setAnlkl((csvRecord.get("ANLKL")));
			zfiSwzcHeBei.setTxk20((csvRecord.get("TXK20")));
			zfiSwzcHeBei.setSernr((csvRecord.get("SERNR")));
			zfiSwzcHeBei.setInvnr((csvRecord.get("INVNR")));
			zfiSwzcHeBei.setZzc001((csvRecord.get("ZZC001")));
			zfiSwzcHeBei.setZzc002((csvRecord.get("ZZC002")));
			zfiSwzcHeBei.setKostl((csvRecord.get("KOSTL")));
			zfiSwzcHeBei.setLtext((csvRecord.get("LTEXT")));
			zfiSwzcHeBei.setKostlv((csvRecord.get("KOSTLV")));
			zfiSwzcHeBei.setRaumn((csvRecord.get("RAUMN")));
			zfiSwzcHeBei.setKfzkz((csvRecord.get("KFZKZ")));
			zfiSwzcHeBei.setZzas1((csvRecord.get("ZZAS1")));
			zfiSwzcHeBei.setZzc006((csvRecord.get("ZZC006")));
			zfiSwzcHeBei.setZzc007((csvRecord.get("ZZC007")));
			zfiSwzcHeBei.setOrd41((csvRecord.get("ORD41")));
			zfiSwzcHeBei.setOrd44((csvRecord.get("ORD44")));
			zfiSwzcHeBei.setGdlgrp((csvRecord.get("GDLGRP")));
			zfiSwzcHeBei.setIzwek((csvRecord.get("IZWEK")));
			zfiSwzcHeBei.setUmwkz((csvRecord.get("UMWKZ")));
			zfiSwzcHeBei.setAnlue((csvRecord.get("ANLUE")));
			zfiSwzcHeBei.setHerst((csvRecord.get("HERST")));
			zfiSwzcHeBei.setTypbz((csvRecord.get("TYPBZ")));
			zfiSwzcHeBei.setStext4((csvRecord.get("STEXT4")));
			zfiSwzcHeBei.setZkpwbs((csvRecord.get("ZKPWBS")));
			zfiSwzcHeBei.setZkpwbsms((csvRecord.get("ZKPWBSMS")));
			zfiSwzcHeBei.setFiamt((csvRecord.get("FIAMT")));
			zfiSwzcHeBei.setStadt((csvRecord.get("STADT")));
			zfiSwzcHeBei.setZfwcqzh((csvRecord.get("ZFWCQZH")));
			zfiSwzcHeBei.setEqktx((csvRecord.get("EQKTX")));
			zfiSwzcHeBei.setTxt04((csvRecord.get("TXT04")));
			zfiSwzcHeBei.setEqart((csvRecord.get("EQART")));
			zfiSwzcHeBei.setBegru((csvRecord.get("BEGRU")));
			zfiSwzcHeBei.setInbdt((csvRecord.get("INBDT")));
			zfiSwzcHeBei.setZccrq((csvRecord.get("ZCCRQ")));
			zfiSwzcHeBei.setZherst((csvRecord.get("ZHERST")));
			zfiSwzcHeBei.setHerld((csvRecord.get("HERLD")));
			zfiSwzcHeBei.setMapar((csvRecord.get("MAPAR")));
			zfiSwzcHeBei.setZtypbz((csvRecord.get("ZTYPBZ")));
			zfiSwzcHeBei.setSerge((csvRecord.get("SERGE")));
			zfiSwzcHeBei.setSwerk((csvRecord.get("SWERK")));
			zfiSwzcHeBei.setStort((csvRecord.get("STORT")));
			zfiSwzcHeBei.setBeber((csvRecord.get("BEBER")));
			zfiSwzcHeBei.setAbckz((csvRecord.get("ABCKZ")));
			zfiSwzcHeBei.setEqfnr((csvRecord.get("EQFNR")));
			zfiSwzcHeBei.setZkostl((csvRecord.get("ZKOSTL")));
			zfiSwzcHeBei.setZsbwbs((csvRecord.get("ZSBWBS")));
			zfiSwzcHeBei.setZsbwbsms((csvRecord.get("ZSBWBSMS")));
			zfiSwzcHeBei.setIwerk((csvRecord.get("IWERK")));
			zfiSwzcHeBei.setIngrp((csvRecord.get("INGRP")));
			zfiSwzcHeBei.setGewrk((csvRecord.get("GEWRK")));
			zfiSwzcHeBei.setTplnr((csvRecord.get("TPLNR")));
			zfiSwzcHeBei.setHequi((csvRecord.get("HEQUI")));
			zfiSwzcHeBei.setTidnr((csvRecord.get("TIDNR")));
			zfiSwzcHeBei.setZsb010((csvRecord.get("ZSB010")));
			zfiSwzcHeBei.setZsb001((csvRecord.get("ZSB001")));
			zfiSwzcHeBei.setZsb002((csvRecord.get("ZSB002")));
			zfiSwzcHeBei.setZsb004((csvRecord.get("ZSB004")));
			zfiSwzcHeBei.setZsb005((csvRecord.get("ZSB005")));
			zfiSwzcHeBei.setZsb006((csvRecord.get("ZSB006")));
			zfiSwzcHeBei.setZsb003((csvRecord.get("ZSB003")));
			zfiSwzcHeBei.setZsb007((csvRecord.get("ZSB007")));
			zfiSwzcHeBei.setZsb008((csvRecord.get("ZSB008")));
			zfiSwzcHeBei.setZlenunt((csvRecord.get("ZLENUNT")));
			zfiSwzcHeBei.setZsb009((csvRecord.get("ZSB009")));
			zfiSwzcHeBei.setZcapunt((csvRecord.get("ZCAPUNT")));
			zfiSwzcHeBei.setZsb011((csvRecord.get("ZSB011")));
			zfiSwzcHeBei.setZeq003((csvRecord.get("ZEQ003")));
			zfiSwzcHeBei.setZeq001((csvRecord.get("ZEQ001")));
			zfiSwzcHeBei.setZeq002((csvRecord.get("ZEQ002")));
			zfiSwzcHeBei.setZlyrkrq((csvRecord.get("ZLYRKRQ")));
			zfiSwzcHeBei.setZlyckrq((csvRecord.get("ZLYCKRQ")));
			zfiSwzcHeBei.setZbfjzrq((csvRecord.get("ZBFJZRQ")));
			zfiSwzcHeBei.setZbfxmbm((csvRecord.get("ZBFXMBM")));
			zfiSwzcHeBei.setZbfxmms((csvRecord.get("ZBFXMMS")));
			zfiSwzcHeBei.setZbfyydm((csvRecord.get("ZBFYYDM")));
			zfiSwzcHeBei.setZbfyywb((csvRecord.get("ZBFYYWB")));
			zfiSwzcHeBei.setPmunr((csvRecord.get("PMUNR")));
			zfiSwzcHeBei.setPmunr((csvRecord.get("FING")));

			System.out.println(zfiSwzcHeBei.getZbfjzrq());

			System.out.println(zfiSwzcHeBei.getMandt());

			session.save(zfiSwzcHeBei);
			if (++i % 5000 == 0) {
				session.flush();
				session.clear();
				tx.commit();
				tx = session.beginTransaction();
			}
		}
		tx.commit();
		session.clear();
		sf.close();
	}

	public static void csvRecordeLineNumber() throws UnsupportedEncodingException {
		// File csv = new File("F:/temp/ERP_20180827.csv"); // CSV文件路径
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("F:/temp/ERP_20180827.csv"), "GB2312"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int record = 0;
		String line = "";
		String everyLine = "";
		try {
			List<String> allString = new ArrayList<>();
			while ((line = br.readLine()) != null) // 读取到的内容给line变量
			{
				record = record + 1;
				if (record == 1000)
					break;
				everyLine = line;
				System.out.println(everyLine);
				allString.add(everyLine);
			}
			System.out.println("csv表格中所有行数：" + allString.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将文件 originalFile 的内容复制到 targetFile 文件中 复制的可以是 Excel 等多种格式
	 * 
	 * @param originalFile
	 * @param targetFile
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void copyFileContent(File originalFile, File targetFile) throws IOException, FileNotFoundException {
		FileInputStream ins = new FileInputStream(originalFile);
		FileOutputStream out = new FileOutputStream(targetFile);
		byte[] b = new byte[1024];
		int n = 0;
		while ((n = ins.read(b)) != -1) {
			out.write(b, 0, n);
		}
		ins.close();
		out.close();
	}

}
