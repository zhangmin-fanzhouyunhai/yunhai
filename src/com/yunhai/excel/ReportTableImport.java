package com.yunhai.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yunhai.excel.orm.MidAssetHealthStateQuant;
import com.yunhai.excel.orm.MidAssetMaxAvgAge;
import com.yunhai.excel.orm.MidAssetOriginalNetScale;
import com.yunhai.excel.orm.MidAssetOriginalValueWall;
import com.yunhai.excel.orm.MidAssetQuantAgeStructure;
import com.yunhai.excel.orm.MidAssetTechQuantityScale;
import com.yunhai.excel.orm.MidAssetTescaAgeStructure;
import com.yunhai.excel.orm.MidAssetUseStateOrigVal;
import com.yunhai.excel.orm.MidAssetUseStateQuant;
import com.yunhai.excel.orm.MidBackupAssetScale;
import com.yunhai.excel.orm.MidDepreciationCost;
import com.yunhai.excel.orm.MidDiscardAssetUseingYear;
import com.yunhai.excel.orm.MidDiscardAssetYearScale;
import com.yunhai.excel.orm.MidDiscardProjectDistribute;
import com.yunhai.excel.orm.MidDiscardReasDistEqu20;
import com.yunhai.excel.orm.MidDiscardReasDistEqu5;
import com.yunhai.excel.orm.MidDiscardReasonDistribute;
import com.yunhai.excel.orm.MidEquipBreakdownSatistics;
import com.yunhai.excel.orm.MidEquipForceOutageStatist;
import com.yunhai.excel.orm.MidIncreaseAssetQuantScale;
import com.yunhai.excel.orm.MidIncreaseAssetValueScale;
import com.yunhai.excel.orm.MidMaintenOverhaulCost;
import com.yunhai.excel.orm.MidOtherProvinceLeaseAsset;
import com.yunhai.excel.orm.MidOverAgeAssetScale;
import com.yunhai.excel.orm.MidResuingAssetScale;
import com.yunhai.excel.orm.MidSystemOutageStatistics;
import com.yunhai.excel.orm.MidUnitIncreCapacityCost;
import com.yunhai.excel.orm.MidUnitTransmiDistriCost;
import com.yunhai.excel.orm.MidUserAssetTechQuanScale;

public class ReportTableImport {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	public static void main(String[] args) throws IOException {
		/*
		 * System.out.println("开始readCsv()"); readeCsv();
		 * System.out.println("结束readCsv()");
		 */
		String version = "RS_2018_9";
		System.out.println("开始!");
		String pathStr = "D:/temp/各省校核过的数据-V2.1-20191223/省公司资产";
		// pathStr = "D:/temp/各省校核过的数据-V2.1-20191223/test";
		String errorFilePath = "src/main/resources/demoFile/报表错误记录模板-V1.0-20200616.xls";
		String templateFile = "src/main/resources/demoFile/结构模板-V1.0-20191119.xls";
		//reportBatchImport(pathStr, templateFile, errorFilePath, version);

		errorFilePath = "D:/temp/已恢复公式未校核已累加-V1.3-20191121/总部司资产errorValue-20191225-1.xls";
		pathStr = "D:/temp/各省校核过的数据-V2.1-20191223/总部资产";
		// reportBatchImport(pathStr,templateFile,errorFilePath,version);

		errorFilePath = "D:/temp/已恢复公式未校核已累加-V1.3-20191121/分部公司资产errorValue-20191225-1.xls";
		pathStr = "D:/temp/各省校核过的数据-V2.1-20191223/分部资产";
		// reportBatchImport(pathStr,templateFile,errorFilePath,version);

		errorFilePath = "D:/temp/已恢复公式未校核已累加-V1.3-20191121/球办汇总资产errorValue-20191225-1.xls";
		pathStr = "D:/temp/各省校核过的数据-V2.1-20191223/球办汇总";
		// reportBatchImport(pathStr,templateFile,errorFilePath,version);

		errorFilePath = "D:/temp/已恢复公式未校核已累加-V1.3-20191121/全网累加errorValue-20191224.xls";
		pathStr = "D:/temp/各省校核过的数据-V2.1-20191223/全网累加";
		// reportBatchImport(pathStr,templateFile,errorFilePath,version);

		pathStr = "D:/temp/已恢复公式未校核已累加-V1.3-20191121/省公司资产";
		errorFilePath = "D:/temp/已恢复公式未校核已累加-V1.3-20191121/省公司资产errorValue-20191123.xls";
		// reportBatchImport(pathStr,templateFile, errorFilePath, version);
		pathStr = "D:/temp/已恢复公式未校核已累加-V1.3-20191121/总部资产";
		errorFilePath = "D:/temp/已恢复公式未校核已累加-V1.3-20191121/总部司资产errorValue-20191123.xls";
		// reportBatchImport(pathStr,templateFile, errorFilePath, version);
		pathStr = "D:/temp/已恢复公式未校核已累加-V1.3-20191121/分部资产";
		errorFilePath = "D:/temp/已恢复公式未校核已累加-V1.3-20191121/分部公司资产errorValue-20191123.xls";
		// reportBatchImport(pathStr,templateFile, errorFilePath, version);

		pathStr = "D:/temp/已恢复公式未校核已累加-V1.3-20191121/实物资产全网汇总累加表";
		errorFilePath = "D:/temp/已恢复公式未校核已累加-V1.3-20191121/分部公司资产errorValue-20191123.xls";
		// reportBatchImport(pathStr,templateFile, errorFilePath, version);

		templateFile = "D:/temp/各省校核过的数据-V1.3-20191126-甘肃总部和蒙东总部存在问题/结构模板-V1.1-20191126.xls";
		pathStr = "D:/temp/各省校核过的数据-V1.3-20191126-甘肃总部和蒙东总部存在问题/省公司资产";
		errorFilePath = "D:/temp/各省校核过的数据-V1.3-20191126-甘肃总部和蒙东总部存在问题/省公司资产errorValue-20191127.xls";
		// reportBatchImport(pathStr,templateFile, errorFilePath, version);
		pathStr = "D:/temp/各省校核过的数据-V1.3-20191126-甘肃总部和蒙东总部存在问题/总部资产";
		errorFilePath = "D:/temp/各省校核过的数据-V1.3-20191126-甘肃总部和蒙东总部存在问题/总部司资产errorValue-20191127.xls";
		// reportBatchImport(pathStr,templateFile, errorFilePath, version);
		pathStr = "D:/temp/各省校核过的数据-V1.3-20191126-甘肃总部和蒙东总部存在问题/分部资产";
		errorFilePath = "D:/temp/各省校核过的数据-V1.3-20191126-甘肃总部和蒙东总部存在问题/分部公司资产errorValue-20191127.xls";
		// reportBatchImport(pathStr,templateFile, errorFilePath, version);

		pathStr = "D:/temp/各省校核过的数据-V1.3-20191126-甘肃总部和蒙东总部存在问题/球办资产统计";
		errorFilePath = "D:/temp/各省校核过的数据-V1.3-20191126-甘肃总部和蒙东总部存在问题/球办资产errorValue-20191127.xls";
		// reportBatchValueAndQuantityImport(pathStr,templateFile, errorFilePath,
		// version);

		System.out.println("结束!");

	}

	public static void reportBatchValueAndQuantityImport(String pathName, String templateFile, String errorFilePath,
			String version) throws IOException {
		// String pathName = "D:/temp/实物资产评价数据表2019_1107_恢复公式/省公司资产/";
		String fileName = "";

		String sheetName = "";
		int sheetNumber = 0;

		// 创建需要复制公式的目标EXCEL文件所在路径文件对象
		File importPathFile = new File(pathName);
		// 得到路径下所有文件的列表
		File[] importFileList = importPathFile.listFiles();
		int importFileNumber = importFileList.length;
		for (int k = 0; k < importFileNumber; k++) {
			// fileName = pathName + "/" + importFileList[k].getName();
			fileName = importFileList[k].getName();
			int startRowNumber = 4;
			int endRowNumber = 201;
			sheetNumber = 0;
			sheetName = "A.1 资产结构-价值规模";
			// 省公司已经导入 MID_ASSET_ORIGINAL_NET_SCALE
			//
			reportMidAssetOriginalNetScaleImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, version);
			startRowNumber = 4;
			endRowNumber = startRowNumber + 197;
			sheetNumber = 1;
			sheetName = "A.2 资产结构-数量规模";
			// 省公司已经导入 MID_ASSET_TECH_QUANTITY_SCALE
			//
			reportMidAssetTechQuantityScaleImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

		}

	}

	public static String getOrgName(String importFileVersion,String fileName) {
		String orgName="";
		
		return orgName;
	}
	
	public static void reportBatchImport(String pathName, String templateFile, String errorFilePath, String version)
			throws IOException {
		// String pathName = "D:/temp/实物资产评价数据表2019_1107_恢复公式/省公司资产/";
		String fileName = "";
		// System.out.println("pathName=" + pathName);
		String sheetName = "";
		int sheetNumber = 0;

		// 创建需要复制公式的目标EXCEL文件所在路径文件对象
		File importPathFile = new File(pathName);
		// 得到路径下所有文件的列表
		File[] importFileList = importPathFile.listFiles();
		int importFileNumber = importFileList.length;
		for (int k = 0; k < importFileNumber; k++) {
			// fileName = pathName + "/" + importFileList[k].getName();
			fileName = importFileList[k].getName();
			String orgName=getOrgName("",fileName);
			int startRowNumber = 4;
			int endRowNumber = 201;
			sheetNumber = 0;

			sheetName = "A.1 资产结构-价值规模";
			// 省公司已经导入 MID_ASSET_ORIGINAL_NET_SCALE
			reportMidAssetOriginalNetScaleImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, version);

			startRowNumber = 4;
			endRowNumber = startRowNumber + 197;
			sheetNumber = 1;
			sheetName = "A.2 资产结构-数量规模";
			// 省公司已经导入 MID_ASSET_TECH_QUANTITY_SCALE

			reportMidAssetTechQuantityScaleImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 197;
			sheetNumber = 2;
			sheetName = "A.3.1 资产结构-年龄结构（价值）";
			// 省公司已经导入 MID_ASSET_ORIGINAL_VALUE_WALL
			reportMidAssetOriginalValueWallImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 197;
			sheetNumber = 3;
			sheetName = "A.3.2.1 资产结构-年龄结构（数量）";
			// 省公司已经导入 MID_ASSET_QUANT_AGE_STRUCTURE
			reportMidAssetQuantAgeStructureImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 197;
			sheetNumber = 5;
			sheetName = "A.3.3 资产结构-资产平均年龄";
			// 省公司已经导入 MID_ASSET_MAX_AVG_AGE
			reportMidAssetMaxAvgAgeImport(templateFile, pathName, fileName, startRowNumber, endRowNumber, sheetName,
					errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 197;
			sheetNumber = 6;
			sheetName = "A.3.4 逾龄资产";
			// 省公司已经导入 MID_OVER_AGE_ASSET_SCALE
			//
			reportMidOverAgeAssetScaleImport(templateFile, pathName, fileName, startRowNumber, endRowNumber, sheetName,
					errorFilePath, version);

			startRowNumber = 6;
			endRowNumber = startRowNumber + 197;
			sheetNumber = 7;
			sheetName = "A.3.5 省外代维资产及租赁资产表";
			// 省公司已经导入 MID_OTHER_PROVINCE_LEASE_ASSET
			//
			reportMidOtherProvinceLeaseAssetImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			// String sheetName
			startRowNumber = 4;
			endRowNumber = startRowNumber + 197;
			sheetNumber = 8;
			sheetName = "A.3.6 用户资产";
			// 省公司已经导入 MID_USER_ASSET_TECH_QUAN_SCALE
			reportMidUserAssetTechQuanScaleImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 197;
			sheetNumber = 9;
			sheetName = "A.4.1 新增资产（价值）";
			// 省公司已经导入 MID_INCREASE_ASSET_VALUE_SCALE
			//
			reportMidIncreaseAssetValueScaleImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 6;
			endRowNumber = startRowNumber + 197;
			sheetNumber = 10;
			sheetName = "A.4.2 新增资产（数量）";
			// 省公司已经导入 MID_INCREASE_ASSET_QUANT_SCALE
			//
			reportMidIncreaseAssetQuantScaleImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 4;
			endRowNumber = startRowNumber + 197;
			sheetName = "C.2.1 利用效率-资产利用状态(数量)";
			// 省公司已经导入 MID_ASSET_USE_STATE_QUANT

			reportMidAssetUseStateQuantImport(templateFile, pathName, fileName, startRowNumber, endRowNumber, sheetName,
					errorFilePath, version);

			startRowNumber = 4;
			endRowNumber = startRowNumber + 197;
			sheetName = "C.2.2 利用效率-资产利用状态(原值)";
			// 省公司已经导入 MID_ASSET_USE_STATE_ORIG_VAL
			reportMidAssetUseStateOrigValImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 197;
			sheetName = "C.2.8 资产退役-使用年限";
			// 省公司已经导入 MID_DISCARD_ASSET_USEING_YEAR
			//
			reportMidDiscardAssetUseingYearImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 62;
			sheetName = "A.3.2.2 资产结构-年龄结构（规模）";
			// 省公司已经导入 MID_ASSET_TESCA_AGE_STRUCTURE
			reportMidAssetTescaAgeStructureImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 4;
			endRowNumber = startRowNumber + 181;
			sheetName = "B.5.2 各年度健康状态统计表";
			// 省公司已经导入 MID_ASSET_HEALTH_STATE_QUANT
			//
			reportMidAssetHealthStateQuantImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 256;
			sheetName = "C.2.5 利用效率-再利用设备数量规模";
			// 省公司已经导入 MID_RESUING_ASSET_SCALE
			reportMidResuingAssetScaleImport(templateFile, pathName, fileName, startRowNumber, endRowNumber, sheetName,
					errorFilePath, version);

			startRowNumber = 4;
			endRowNumber = startRowNumber + 215;
			sheetName = "C.2.6 利用效率-备品备件数量规模";
			// 省公司已经导入 MID_BACKUP_ASSET_SCALE
			reportMidBackupAssetScaleImport(templateFile, pathName, fileName, startRowNumber, endRowNumber, sheetName,
					errorFilePath, version);

			startRowNumber = 4;
			endRowNumber = startRowNumber + 25;
			sheetName = "D.1 单位新增容量成本";
			// 省公司已经导入 MID_UNIT_INCRE_CAPACITY_COST
			reportMidUnitIncreCapacityCostImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 4;
			endRowNumber = startRowNumber + 50;
			sheetName = "D.4 折旧成本";
			// 省公司已经导入 MID_DEPRECIATION_COST
			reportMidDepreciationCostImport(templateFile, pathName, fileName, startRowNumber, endRowNumber, sheetName,
					errorFilePath, version);

			startRowNumber = 4;
			endRowNumber = startRowNumber + 394;
			sheetName = "C.2.7 资产退役-资产报废按年份";
			// 省公司已经导入 MID_DISCARD_ASSET_YEAR_SCALE
			reportMidDiscardAssetYearScaleImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 591;
			sheetName = "C.2.7.4 资产退役-资产报废按项目类型";
			// 省公司已经导入 MID_DISCARD_PROJECT_DISTRIBUTE
			reportMidDiscardProjectDistributeImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 591;
			sheetName = "C.2.7.1 资产退役-资产报废按成因";
			// 省公司已经导入 MID_DISCARD_REASON_DISTRIBUTE
			reportMidDiscardReasonDistributeImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 591;
			sheetName = "C.2.7.2 资产退役-报废按成因 (成新率5%以上资产)";
			// 省公司已经导入 MID_DISCARD_REAS_DIST_EQU_5
			reportMidDiscardReasDistEqu5Import(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 591;
			sheetName = "C.2.7.3 资产退役-报废按成因 (成新率20%以上资产)";
			// 省公司已经导入 MID_DISCARD_REAS_DIST_EQU_20
			reportMidDiscardReasDistEqu20Import(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 6;
			endRowNumber = startRowNumber + 23;
			sheetName = "B.1 设备故障统计表";
			// 省公司已经导入 MID_EQUIP_BREAKDOWN_SATISTICS
			reportMidEquipBreakdownSatisticsImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 14;
			sheetName = "B.2 设备强迫停运统计表";
			// 省公司已经导入 MID_EQUIP_FORCE_OUTAGE_STATIST
			reportMidEquipForceOutageStatistImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 5;
			endRowNumber = startRowNumber + 75;
			sheetName = "B.3.1 系统停电统计表";
			// MID_SYSTEM_OUTAGE_STATISTICS
			reportMidSystemOutageStatisticsImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 4;
			endRowNumber = startRowNumber + 9;
			sheetName = "D.2 大修运维费用";
			// MID_SYSTEM_OUTAGE_STATISTICS
			reportMidMaintenOverhaulCostImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);

			startRowNumber = 3;
			endRowNumber = startRowNumber + 5;
			sheetName = "D.3 单位输配电成本";
			// MID_UNIT_TRANSMI_DISTRI_COST
			reportMidUnitTransmiDistriCostImport(templateFile, pathName, fileName, startRowNumber, endRowNumber,
					sheetName, errorFilePath, version);
		}

	}

	/**
	 * "A.1 资产结构-价值规模"数据导入 MidAssetOriginalNetScale MID_ASSET_ORIGINAL_NET_SCALE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidAssetOriginalNetScaleImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String version) throws IOException {

		Double maxUsedMemoryPercent = 0.60;
		Double maxFreeMemoryPercent = 0.30;
		/*
		 * Runtime run = Runtime.getRuntime(); run = Runtime.getRuntime(); Double maxMem
		 * = new Double(run.maxMemory() / 1024 / 1024); Double freeMem = new
		 * Double(run.freeMemory() / 1024 / 1024); Double totalMem = new
		 * Double(run.totalMemory() / 1024 / 1024); if ((new Double(run.totalMemory()) /
		 * new Double(run.maxMemory()) > maxUsedMemoryPercent) && (new
		 * Double(run.freeMemory()) / new Double(run.maxMemory()) <
		 * maxFreeMemoryPercent)) { System.out.println("output " + (outj++) + "times!");
		 */
		String filePathAndName = pathName + "/" + fileName;
		// System.out.println("filePathAndName=" + filePathAndName);
		// 创建需要复制公式的目标EXCEL文件工作簿的引用

		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet fileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				fileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (fileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 201;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = fileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = fileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();

		if (endRowNumber < fileSheet.getPhysicalNumberOfRows() - 1) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {

			if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
			}
			if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow templateStructureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow = fileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即templateStructureNodeRow中获取。
			 */
			if (templateStructureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(templateStructureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(
					new Double(templateStructureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			if (structureNodeRow.getCell(1).getCellType() == structureNodeRow.getCell(1).CELL_TYPE_STRING) {
				structureNodeValueMap.put(1, new BigDecimal(0.0000));
			} else {
				structureNodeValueMap.put(1, new BigDecimal(structureNodeRow.getCell(1).getNumericCellValue()));
			}
			if (structureNodeRow.getCell(2).getCellType() == structureNodeRow.getCell(2).CELL_TYPE_STRING) {
				structureNodeValueMap.put(2, new BigDecimal(0.0000));
			} else {
				structureNodeValueMap.put(2, new BigDecimal(structureNodeRow.getCell(2).getNumericCellValue()));
			}
			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidAssetOriginalNetScale midAssetOriginalNetScale = new MidAssetOriginalNetScale();
			midAssetOriginalNetScale.setVersion(version);

			try {
				midAssetOriginalNetScale.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midAssetOriginalNetScale.setOrgName(orgName);
			try {
				midAssetOriginalNetScale.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midAssetOriginalNetScale.setLargeClass(structureNodeI.getNodeName());
				midAssetOriginalNetScale.setMediumClass("");
				midAssetOriginalNetScale.setSmallClass("");
				midAssetOriginalNetScale.setVoltageLevel("");
				midAssetOriginalNetScale.setOriginalValue(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetOriginalNetScale.setNetValue(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetOriginalNetScale.setCategory(structureNodeI.getNodeName());
				session.save(midAssetOriginalNetScale);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midAssetOriginalNetScale
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetOriginalNetScale.setMediumClass(structureNodeI.getNodeName());
				midAssetOriginalNetScale.setSmallClass("");
				midAssetOriginalNetScale.setVoltageLevel("");
				midAssetOriginalNetScale.setOriginalValue(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetOriginalNetScale.setNetValue(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetOriginalNetScale.setCategory(structureNodeI.getNodeName());
				session.save(midAssetOriginalNetScale);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midAssetOriginalNetScale.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetOriginalNetScale
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetOriginalNetScale.setSmallClass("");
				midAssetOriginalNetScale.setVoltageLevel(structureNodeI.getNodeName());
				midAssetOriginalNetScale.setOriginalValue(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetOriginalNetScale.setNetValue(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetOriginalNetScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetOriginalNetScale);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midAssetOriginalNetScale.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midAssetOriginalNetScale.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetOriginalNetScale
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetOriginalNetScale.setVoltageLevel(structureNodeI.getNodeName());
				midAssetOriginalNetScale.setOriginalValue(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetOriginalNetScale.setNetValue(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetOriginalNetScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetOriginalNetScale);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "A.2 资产结构-数量规模"数据导入 MidAssetTechQuantityScale
	 * 
	 * MID_ASSET_TECH_QUANTITY_SCALE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidAssetTechQuantityScaleImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 201;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 * endStructureNode.setValueMap(endStructureNodeValueMap);
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {

			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}

			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			try {
				structureNodeValueMap.put(1, new BigDecimal(structureNodeRow1.getCell(1).getNumericCellValue()));
			} catch (Exception e) {
				// TODO: handle exception
				OutputStream out = null;
				structureNodeValueMap.put(1, new BigDecimal(0.0));
				Row errorRow = errorSheet.createRow(errorI + 1);
				Cell first = errorRow.createCell(0);
				Cell second = errorRow.createCell(1);
				Cell third = errorRow.createCell(2);
				Cell four = errorRow.createCell(3);
				Cell five = errorRow.createCell(4);
				Cell six = errorRow.createCell(5);
				Cell seven = errorRow.createCell(6);
				// first.setCellValue(errorString);
				first.setCellValue(new Date());
				second.setCellValue(fileName);
				third.setCellValue(sheetName);
				four.setCellValue(rowI + standardStartRowNumber + 1);
				five.setCellValue(1);
				six.setCellValue(e.getMessage());
				errorI = errorI + 1;

				out = new FileOutputStream(errorFilePath);
				errorWorkBook.write(out);
				try {
					if (out != null) {
						out.flush();
						out.close();
					}
				} catch (IOException outE) {
					outE.printStackTrace();
				}
			}

			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());
			if (structureNodeRow1.getCell(2).getCellType() == structureNodeRow1.getCell(2).CELL_TYPE_STRING) {
				structureNodeValueMap.put(2, new BigDecimal(0.0000));
			} else {
				structureNodeValueMap.put(2, new BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			}
			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("filePathAndName=" + filePathAndName + "Node name is " + structureNode.getNodeName()
					+ " node number is " + structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidAssetTechQuantityScale midAssetTechQuantityScale = new MidAssetTechQuantityScale();
			midAssetTechQuantityScale.setVersion(version);

			try {
				midAssetTechQuantityScale.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midAssetTechQuantityScale.setOrgName(orgName);
			try {
				midAssetTechQuantityScale.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midAssetTechQuantityScale.setLargeClass(structureNodeI.getNodeName());
				midAssetTechQuantityScale.setMediumClass("");
				midAssetTechQuantityScale.setSmallClass("");
				midAssetTechQuantityScale.setVoltageLevel("");
				midAssetTechQuantityScale.setQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetTechQuantityScale.setTechnologyScale(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetTechQuantityScale.setCategory(structureNodeI.getNodeName());
				session.save(midAssetTechQuantityScale);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midAssetTechQuantityScale
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetTechQuantityScale.setMediumClass(structureNodeI.getNodeName());
				midAssetTechQuantityScale.setSmallClass("");
				midAssetTechQuantityScale.setVoltageLevel("");
				midAssetTechQuantityScale.setQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetTechQuantityScale.setTechnologyScale(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetTechQuantityScale.setCategory(structureNodeI.getNodeName());
				session.save(midAssetTechQuantityScale);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midAssetTechQuantityScale.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetTechQuantityScale
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetTechQuantityScale.setSmallClass("");
				midAssetTechQuantityScale.setVoltageLevel(structureNodeI.getNodeName());
				midAssetTechQuantityScale.setQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetTechQuantityScale.setTechnologyScale(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetTechQuantityScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetTechQuantityScale);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midAssetTechQuantityScale.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midAssetTechQuantityScale.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetTechQuantityScale
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetTechQuantityScale.setVoltageLevel(structureNodeI.getNodeName());
				midAssetTechQuantityScale.setQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetTechQuantityScale.setTechnologyScale(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetTechQuantityScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetTechQuantityScale);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "A.3.1 资产结构-年龄结构（价值）"表的数据的导入 MID_ASSET_ORIGINAL_VALUE_WALL
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidAssetOriginalValueWallImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();
		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 201;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {

			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}

			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 31; colI++) {

				try {
					structureNodeValueMap.put(colI,
							new BigDecimal(structureNodeRow1.getCell(colI + 1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());
			/*
			 * if (structureNodeRow1.getCell(2).getCellType() ==
			 * structureNodeRow1.getCell(2).CELL_TYPE_STRING) { structureNodeValueMap.put(2,
			 * new BigDecimal(0.0000)); } else { structureNodeValueMap.put(2, new
			 * BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue())); }
			 */
			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("filePathAndName=" + filePathAndName + "Node name is " + structureNode.getNodeName()
					+ " node number is " + structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidAssetOriginalValueWall midAssetOriginalValueWall = new MidAssetOriginalValueWall();
			midAssetOriginalValueWall.setVersion(version);

			try {
				midAssetOriginalValueWall.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midAssetOriginalValueWall.setOrgName(orgName);
			try {
				midAssetOriginalValueWall.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midAssetOriginalValueWall.setLargeClass(structureNodeI.getNodeName());
				midAssetOriginalValueWall.setMediumClass("");
				midAssetOriginalValueWall.setSmallClass("");
				midAssetOriginalValueWall.setVoltageLevel("");
				midAssetOriginalValueWall.setOriginalValueAge1(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge2(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge3(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge4(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge5(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge6(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge7(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge8(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge9(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge10(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge11(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge12(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge13(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge14(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge15(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge16(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge17(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge18(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge19(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge20(structureNodeI.getValueMap().get(20).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge21(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge22(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge23(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge24(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge25(structureNodeI.getValueMap().get(25).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge26(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge27(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge28(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge29(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge30(structureNodeI.getValueMap().get(30).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge31(structureNodeI.getValueMap().get(31).doubleValue());
				midAssetOriginalValueWall.setCategory(structureNodeI.getNodeName());
				session.save(midAssetOriginalValueWall);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midAssetOriginalValueWall
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetOriginalValueWall.setMediumClass(structureNodeI.getNodeName());
				midAssetOriginalValueWall.setSmallClass("");
				midAssetOriginalValueWall.setVoltageLevel("");
				midAssetOriginalValueWall.setOriginalValueAge1(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge2(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge3(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge4(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge5(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge6(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge7(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge8(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge9(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge10(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge11(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge12(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge13(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge14(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge15(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge16(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge17(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge18(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge19(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge20(structureNodeI.getValueMap().get(20).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge21(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge22(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge23(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge24(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge25(structureNodeI.getValueMap().get(25).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge26(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge27(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge28(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge29(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge30(structureNodeI.getValueMap().get(30).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge31(structureNodeI.getValueMap().get(31).doubleValue());
				midAssetOriginalValueWall.setCategory(structureNodeI.getNodeName());
				session.save(midAssetOriginalValueWall);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midAssetOriginalValueWall.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetOriginalValueWall
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetOriginalValueWall.setSmallClass("");
				midAssetOriginalValueWall.setVoltageLevel(structureNodeI.getNodeName());
				midAssetOriginalValueWall.setOriginalValueAge1(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge2(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge3(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge4(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge5(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge6(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge7(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge8(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge9(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge10(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge11(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge12(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge13(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge14(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge15(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge16(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge17(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge18(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge19(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge20(structureNodeI.getValueMap().get(20).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge21(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge22(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge23(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge24(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge25(structureNodeI.getValueMap().get(25).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge26(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge27(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge28(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge29(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge30(structureNodeI.getValueMap().get(30).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge31(structureNodeI.getValueMap().get(31).doubleValue());
				midAssetOriginalValueWall
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetOriginalValueWall);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midAssetOriginalValueWall.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midAssetOriginalValueWall.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetOriginalValueWall
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetOriginalValueWall.setVoltageLevel(structureNodeI.getNodeName());
				midAssetOriginalValueWall.setOriginalValueAge1(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge2(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge3(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge4(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge5(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge6(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge7(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge8(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge9(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge10(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge11(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge12(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge13(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge14(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge15(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge16(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge17(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge18(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge19(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge20(structureNodeI.getValueMap().get(20).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge21(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge22(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge23(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge24(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge25(structureNodeI.getValueMap().get(25).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge26(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge27(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge28(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge29(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge30(structureNodeI.getValueMap().get(30).doubleValue());
				midAssetOriginalValueWall.setOriginalValueAge31(structureNodeI.getValueMap().get(31).doubleValue());
				midAssetOriginalValueWall
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetOriginalValueWall);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "A.3.2.1 资产结构-年龄结构（数量）"表的数据的导入 MidAssetQuantAgeStructure
	 * MID_ASSET_QUANT_AGE_STRUCTURE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidAssetQuantAgeStructureImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {
		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		 
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();
		String filePathAndName = pathName + "/" + fileName;
		
		File importFile=new File(filePathAndName);
		Workbook fileWorkbook=getWorkbok(importFile);
		Workbook templateFileWorkbook=getWorkbok(new File(templateFile));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		//HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		//		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		Sheet templateFileSheet;
		Sheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 201;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		Row sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		Row sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		Row sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		Row sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {

			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}

			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode(); 
			Row structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			Row structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 31; colI++) {

				try {
					structureNodeValueMap.put(colI,
							new BigDecimal(structureNodeRow1.getCell(colI + 1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());
			/*
			 * if (structureNodeRow1.getCell(2).getCellType() ==
			 * structureNodeRow1.getCell(2).CELL_TYPE_STRING) { structureNodeValueMap.put(2,
			 * new BigDecimal(0.0000)); } else { structureNodeValueMap.put(2, new
			 * BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue())); }
			 */
			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("filePathAndName=" + filePathAndName + "Node name is " + structureNode.getNodeName()
					+ " node number is " + structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidAssetQuantAgeStructure midAssetQuantAgeStructure = new MidAssetQuantAgeStructure();
			midAssetQuantAgeStructure.setVersion(version);

			try {
				midAssetQuantAgeStructure.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midAssetQuantAgeStructure.setOrgName(orgName);
			try {
				midAssetQuantAgeStructure.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midAssetQuantAgeStructure.setLargeClass(structureNodeI.getNodeName());
				midAssetQuantAgeStructure.setMediumClass("");
				midAssetQuantAgeStructure.setSmallClass("");
				midAssetQuantAgeStructure.setVoltageLevel("");
				midAssetQuantAgeStructure.setQuantityAge1(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge2(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge3(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge4(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge5(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge6(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge7(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge8(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge9(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge10(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge11(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge12(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge13(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge14(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge15(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge16(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge17(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge18(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge19(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge20(structureNodeI.getValueMap().get(20).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge21(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge22(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge23(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge24(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge25(structureNodeI.getValueMap().get(25).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge26(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge27(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge28(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge29(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge30(structureNodeI.getValueMap().get(30).doubleValue());
				midAssetQuantAgeStructure.setQuantityAgeMoreThan30(structureNodeI.getValueMap().get(31).doubleValue());

				midAssetQuantAgeStructure.setCategory(structureNodeI.getNodeName());
				session.save(midAssetQuantAgeStructure);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midAssetQuantAgeStructure
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetQuantAgeStructure.setMediumClass(structureNodeI.getNodeName());
				midAssetQuantAgeStructure.setSmallClass("");
				midAssetQuantAgeStructure.setVoltageLevel("");
				midAssetQuantAgeStructure.setQuantityAge1(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge2(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge3(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge4(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge5(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge6(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge7(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge8(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge9(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge10(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge11(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge12(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge13(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge14(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge15(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge16(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge17(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge18(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge19(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge20(structureNodeI.getValueMap().get(20).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge21(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge22(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge23(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge24(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge25(structureNodeI.getValueMap().get(25).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge26(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge27(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge28(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge29(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge30(structureNodeI.getValueMap().get(30).doubleValue());
				midAssetQuantAgeStructure.setQuantityAgeMoreThan30(structureNodeI.getValueMap().get(31).doubleValue());
				midAssetQuantAgeStructure.setCategory(structureNodeI.getNodeName());
				session.save(midAssetQuantAgeStructure);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midAssetQuantAgeStructure.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetQuantAgeStructure
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetQuantAgeStructure.setSmallClass("");
				midAssetQuantAgeStructure.setVoltageLevel(structureNodeI.getNodeName());
				midAssetQuantAgeStructure.setQuantityAge1(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge2(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge3(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge4(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge5(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge6(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge7(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge8(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge9(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge10(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge11(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge12(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge13(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge14(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge15(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge16(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge17(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge18(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge19(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge20(structureNodeI.getValueMap().get(20).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge21(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge22(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge23(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge24(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge25(structureNodeI.getValueMap().get(25).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge26(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge27(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge28(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge29(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge30(structureNodeI.getValueMap().get(30).doubleValue());
				midAssetQuantAgeStructure.setQuantityAgeMoreThan30(structureNodeI.getValueMap().get(31).doubleValue());

				midAssetQuantAgeStructure
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetQuantAgeStructure);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midAssetQuantAgeStructure.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midAssetQuantAgeStructure.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetQuantAgeStructure
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetQuantAgeStructure.setVoltageLevel(structureNodeI.getNodeName());
				midAssetQuantAgeStructure.setQuantityAge1(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge2(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge3(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge4(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge5(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge6(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge7(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge8(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge9(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge10(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge11(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge12(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge13(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge14(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge15(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge16(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge17(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge18(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge19(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge20(structureNodeI.getValueMap().get(20).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge21(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge22(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge23(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge24(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge25(structureNodeI.getValueMap().get(25).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge26(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge27(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge28(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge29(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetQuantAgeStructure.setQuantityAge30(structureNodeI.getValueMap().get(30).doubleValue());
				midAssetQuantAgeStructure.setQuantityAgeMoreThan30(structureNodeI.getValueMap().get(31).doubleValue());

				midAssetQuantAgeStructure
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetQuantAgeStructure);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "A.3.3 资产结构-资产平均年龄"表的数据的导入 MidAssetMaxAvgAge MID_ASSET_MAX_AVG_AGE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidAssetMaxAvgAgeImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 201;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {

			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}

			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			// System.out.println(
			// "rowI=" + (rowI + standardStartRowNumber) + "structureNodeRow1.getCell(colI +
			// 1).getCellType() "
			// + structureNodeRow1.getCell(1).getCellType());

			for (int colI = 1; colI <= 5; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {

					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}

			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());
			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("filePathAndName=" + filePathAndName + "Node name is " + structureNode.getNodeName()
					+ " node number is " + structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidAssetMaxAvgAge midAssetMaxAvgAge = new MidAssetMaxAvgAge();
			midAssetMaxAvgAge.setVersion(version);

			try {
				midAssetMaxAvgAge.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midAssetMaxAvgAge.setOrgName(orgName);
			try {
				midAssetMaxAvgAge.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midAssetMaxAvgAge.setLargeClass(structureNodeI.getNodeName());
				midAssetMaxAvgAge.setMediumClass("");
				midAssetMaxAvgAge.setSmallClass("");
				midAssetMaxAvgAge.setVoltageLevel("");
				midAssetMaxAvgAge.setYear1AvgAge(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetMaxAvgAge.setYear2AvgAge(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetMaxAvgAge.setYear3AvgAge(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetMaxAvgAge.setYear4AvgAge(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetMaxAvgAge.setYear5AvgAge(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetMaxAvgAge.setYear1MaxAge(0.0);
				midAssetMaxAvgAge.setYear2MaxAge(0.0);
				midAssetMaxAvgAge.setYear3MaxAge(0.0);
				midAssetMaxAvgAge.setYear4MaxAge(0.0);
				midAssetMaxAvgAge.setYear5MaxAge(0.0);

				midAssetMaxAvgAge.setCategory(structureNodeI.getNodeName());
				session.save(midAssetMaxAvgAge);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midAssetMaxAvgAge
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetMaxAvgAge.setMediumClass(structureNodeI.getNodeName());
				midAssetMaxAvgAge.setSmallClass("");
				midAssetMaxAvgAge.setVoltageLevel("");
				midAssetMaxAvgAge.setYear1AvgAge(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetMaxAvgAge.setYear2AvgAge(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetMaxAvgAge.setYear3AvgAge(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetMaxAvgAge.setYear4AvgAge(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetMaxAvgAge.setYear5AvgAge(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetMaxAvgAge.setYear1MaxAge(0.0);
				midAssetMaxAvgAge.setYear2MaxAge(0.0);
				midAssetMaxAvgAge.setYear3MaxAge(0.0);
				midAssetMaxAvgAge.setYear4MaxAge(0.0);
				midAssetMaxAvgAge.setYear5MaxAge(0.0);
				midAssetMaxAvgAge.setCategory(structureNodeI.getNodeName());
				session.save(midAssetMaxAvgAge);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midAssetMaxAvgAge.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetMaxAvgAge
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetMaxAvgAge.setSmallClass("");
				midAssetMaxAvgAge.setVoltageLevel(structureNodeI.getNodeName());
				midAssetMaxAvgAge.setYear1AvgAge(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetMaxAvgAge.setYear2AvgAge(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetMaxAvgAge.setYear3AvgAge(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetMaxAvgAge.setYear4AvgAge(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetMaxAvgAge.setYear5AvgAge(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetMaxAvgAge.setYear1MaxAge(0.0);
				midAssetMaxAvgAge.setYear2MaxAge(0.0);
				midAssetMaxAvgAge.setYear3MaxAge(0.0);
				midAssetMaxAvgAge.setYear4MaxAge(0.0);
				midAssetMaxAvgAge.setYear5MaxAge(0.0);
				midAssetMaxAvgAge
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetMaxAvgAge);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midAssetMaxAvgAge.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midAssetMaxAvgAge.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetMaxAvgAge
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetMaxAvgAge.setVoltageLevel(structureNodeI.getNodeName());
				midAssetMaxAvgAge.setYear1AvgAge(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetMaxAvgAge.setYear2AvgAge(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetMaxAvgAge.setYear3AvgAge(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetMaxAvgAge.setYear4AvgAge(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetMaxAvgAge.setYear5AvgAge(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetMaxAvgAge.setYear1MaxAge(0.0);
				midAssetMaxAvgAge.setYear2MaxAge(0.0);
				midAssetMaxAvgAge.setYear3MaxAge(0.0);
				midAssetMaxAvgAge.setYear4MaxAge(0.0);
				midAssetMaxAvgAge.setYear5MaxAge(0.0);
				midAssetMaxAvgAge
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetMaxAvgAge);
			}

			if (sNodeI % 5000 == 0) {
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
 * 需要形成一种行控制与列控制。
*报表的树状结构读取出来，存在列表中，然后根据行列控制分类进行数据组装，然后存储进相应的表中。
*TABLE_NAME为数据库物理表；
*COLUMN_LIST数据库物理表的列名称；
*某些列，需要通过表头的信息来进行转换；
 */
	/**
	 * "A.3.4 逾龄资产"表的数据的导入 MidOverAgeAssetScale MID_OVER_AGE_ASSET_SCALE
	 * 
	 * @param templateFile   导入数据时参考的模板报表的名称
	 * @param pathName       需要导入报表所在的路径
	 * @param fileName       需要导入报表的EXCEL的文件名称
	 * @param startRowNumber 报表起始行
	 * @param endRowNumber   报表结束行
	 * @param sheetName      需要导入的报表的名称
	 * @param errorFilePath  报错信息记录表文件与路径名
	 * @param version        数据版本
	 * @throws IOException
	 */
	public static void reportMidOverAgeAssetScaleImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();
		String importedFilePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(importedFilePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取本报表导入需要参考的报表模型Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		/*
		 * 对被考入报表excel文件中的sheet表的名称进行遍历，如出现sheetName中存放的需要导入的sheet报表名称，
		 * 即sheet对象放入importFileSheet对象中， 并结束，否则继续循环至结束。
		 */
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {

			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}

		/*
		 * 对如不存在sheetName中存放的需要导入的报表名称，则报错并结束程序。
		 * 否则继续进行数据导入
		 */
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		} else {

			int standardStartRowNumber = 4;
			int standardEndRowNumber = 201;
			// 输出遍历到的sheet表的名称
			// 获取至Sheet表中的行数
			// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
			HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
			HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

			HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
			HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

			Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
			StructureNode endStructureNode = new StructureNode();

			/*
			 * 构建报表中数据的树状结果，endStructureNode存放最后的汇总行为根结点，方便以后进行汇总计算。
			 */
			endStructureNode.setLeaf(false);
			endStructureNode.setNodeName("总计");
			endStructureNode.setStructureNodeNumber(standardEndRowNumber);
			endStructureNode.setParentNodeNumber(0);

			Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
			/*
			 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
			 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
			 * else {
			 * 
			 * if (sheetEndRow1.getCell(1).getCellType() ==
			 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
			 * sheetEndRow1.getCell(1).getCellType() ==
			 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
			 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
			 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
			 * (sheetEndRow1.getCell(2).getCellType() ==
			 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
			 * sheetEndRow1.getCell(2).getCellType() ==
			 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
			 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
			 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
			 */
			/**
			 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
			 */
			if (sheetEndRow1 == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else { 
				/*
				 * 如果第1个为null,构建虚拟值
				 */
				if (sheetEndRow1.getCell(1) == null) {
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
				} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
						|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
				} else {
					// endStructureNodeValueMap.put(1, new
					// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
					try {
						endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						endStructureNodeValueMap.put(1, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(endRowNumber + 1);
						five.setCellValue(2);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}
				}

				if (sheetEndRow1.getCell(2) == null) {
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
				} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
						|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
				} else {
					// endStructureNodeValueMap.put(2, new
					// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

					try {
						endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						endStructureNodeValueMap.put(2, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(endRowNumber + 1);
						five.setCellValue(3);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			endStructureNode.setValueMap(endStructureNodeValueMap);
			// endStructureNode.setValueMap(endStructureNodeValueMap);

			for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
				StructureNode structureNode = new StructureNode();
				HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
				HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
				/**
				 * 表结构从sheet(0)，即structureNodeRow中获取。
				 */
				if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
					structureNode.setLeaf(true);
				} else {
					structureNode.setLeaf(false);
				}
				structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
				structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
				structureNode
						.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
				/**
				 * 数据从sheet(1)，即structureNodeRow1中获取。
				 */

				// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
				// BigDecimal>();
				Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
				DecimalFormat df1 = new DecimalFormat("#.0000");
				// structureNodeValueMap.put(1, new
				// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
				for (int colI = 1; colI <= 8; colI++) {
					if (structureNodeRow1.getCell(colI) == null) {
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue("单元格取值为null");
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					} else if (structureNodeRow1.getCell(colI)
							.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
							|| structureNodeRow1.getCell(colI)
									.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
					} else {

						try {
							structureNodeValueMap.put(colI,
									new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
						} catch (Exception e) {
							// TODO: handle exception
							OutputStream out = null;
							structureNodeValueMap.put(colI, new BigDecimal(0.0));
							Row errorRow = errorSheet.createRow(errorI + 1);
							Cell first = errorRow.createCell(0);
							Cell second = errorRow.createCell(1);
							Cell third = errorRow.createCell(2);
							Cell four = errorRow.createCell(3);
							Cell five = errorRow.createCell(4);
							Cell six = errorRow.createCell(5);
							Cell seven = errorRow.createCell(6);
							// first.setCellValue(errorString);
							first.setCellValue(new Date());
							second.setCellValue(fileName);
							third.setCellValue(sheetName);
							four.setCellValue(rowI + standardStartRowNumber + 1);
							five.setCellValue(colI + 1);
							six.setCellValue(e.getMessage());
							errorI = errorI + 1;

							out = new FileOutputStream(errorFilePath);
							errorWorkBook.write(out);
							try {
								if (out != null) {
									out.flush();
									out.close();
								}
							} catch (IOException outE) {
								outE.printStackTrace();
							}
						}
					}
				}
				// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

				structureNode.setValueMap(structureNodeValueMap);

				System.out.println("importedFilePathAndName=" + importedFilePathAndName + "Node name is "
						+ structureNode.getNodeName() + " node number is " + structureNode.getStructureNodeNumber()
						+ " parentNodeNumber is " + structureNode.getParentNodeNumber() + " head one value is "
						+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
						+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf "
						+ structureNode.isLeaf());
				// 从标准结构结点中获取
				structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
			}
			structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
			// System.out.println("structureNodeList.size()=" + structureNodeList.size());

			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			// 打开一个Session
			Session session = sf.openSession();
			// 开始一个事务
			Transaction tx = session.beginTransaction();
			DecimalFormat df = new DecimalFormat();
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			// String version = "RS_2018_3";
			// int i = 0;
			String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
			// System.out.println("orgName=" + orgName);

			for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
				// System.out.println("sNodeI=" + sNodeI);
				StructureNode structureNodeI = structureNodeList.get(sNodeI);
				// CSVRecord csvRecord = iterator.next();
				MidOverAgeAssetScale midOverAgeAssetScale = new MidOverAgeAssetScale();
				midOverAgeAssetScale.setVersion(version);

				try {
					midOverAgeAssetScale.setCalYear(simpleDateFormat.parse("2019/11/18"));
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				midOverAgeAssetScale.setOrgName(orgName);
				try {
					midOverAgeAssetScale.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// System.out.println("structureNodeI.getParentNodeNumber()=" +
				// structureNodeI.getParentNodeNumber());
				if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
					/**
					 * 该分枝处理只有大类，没有电压等级、小类与中类的行
					 */
					midOverAgeAssetScale.setLargeClass(structureNodeI.getNodeName());
					midOverAgeAssetScale.setMediumClass("");
					midOverAgeAssetScale.setSmallClass("");
					midOverAgeAssetScale.setVoltageLevel("");
					midOverAgeAssetScale.setTotalOriginalValue(structureNodeI.getValueMap().get(1).doubleValue());
					midOverAgeAssetScale.setTotalQuantity(structureNodeI.getValueMap().get(2).doubleValue());
					midOverAgeAssetScale.setTotalTechnologyScale(structureNodeI.getValueMap().get(3).doubleValue());
					midOverAgeAssetScale.setTotalNetValue(0.0);
					midOverAgeAssetScale.setOverAgeNetValue(0.0);
					midOverAgeAssetScale.setOverAgeOriginalValue(structureNodeI.getValueMap().get(4).doubleValue());
					midOverAgeAssetScale.setOverAgeQuantity(structureNodeI.getValueMap().get(6).doubleValue());
					midOverAgeAssetScale.setOverAgeTechnologyScale(structureNodeI.getValueMap().get(7).doubleValue());

					midOverAgeAssetScale.setCategory(structureNodeI.getNodeName());
					session.save(midOverAgeAssetScale);
				} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
						.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
						&& structureNodeI.isLeaf() == true) {
					/**
					 * 该分枝处理有中类，没有电压等级与小类的行
					 */
					midOverAgeAssetScale
							.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
					midOverAgeAssetScale.setMediumClass(structureNodeI.getNodeName());
					midOverAgeAssetScale.setSmallClass("");
					midOverAgeAssetScale.setVoltageLevel("");
					midOverAgeAssetScale.setTotalOriginalValue(structureNodeI.getValueMap().get(1).doubleValue());
					midOverAgeAssetScale.setTotalQuantity(structureNodeI.getValueMap().get(2).doubleValue());
					midOverAgeAssetScale.setTotalTechnologyScale(structureNodeI.getValueMap().get(3).doubleValue());
					midOverAgeAssetScale.setTotalNetValue(0.0);
					midOverAgeAssetScale.setOverAgeNetValue(0.0);
					midOverAgeAssetScale.setOverAgeOriginalValue(structureNodeI.getValueMap().get(4).doubleValue());
					midOverAgeAssetScale.setOverAgeQuantity(structureNodeI.getValueMap().get(6).doubleValue());
					midOverAgeAssetScale.setOverAgeTechnologyScale(structureNodeI.getValueMap().get(7).doubleValue());

					midOverAgeAssetScale.setCategory(structureNodeI.getNodeName());
					session.save(midOverAgeAssetScale);
				} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
						&& structureNodeList
								.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
								.getParentNodeNumber() == standardEndRowNumber) {
					/**
					 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
					 */
					midOverAgeAssetScale.setLargeClass(structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getNodeName());
					midOverAgeAssetScale
							.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
					midOverAgeAssetScale.setSmallClass("");
					midOverAgeAssetScale.setVoltageLevel(structureNodeI.getNodeName());
					midOverAgeAssetScale.setTotalOriginalValue(structureNodeI.getValueMap().get(1).doubleValue());
					midOverAgeAssetScale.setTotalQuantity(structureNodeI.getValueMap().get(2).doubleValue());
					midOverAgeAssetScale.setTotalTechnologyScale(structureNodeI.getValueMap().get(3).doubleValue());
					midOverAgeAssetScale.setTotalNetValue(0.0);
					midOverAgeAssetScale.setOverAgeNetValue(0.0);
					midOverAgeAssetScale.setOverAgeOriginalValue(structureNodeI.getValueMap().get(4).doubleValue());
					midOverAgeAssetScale.setOverAgeQuantity(structureNodeI.getValueMap().get(6).doubleValue());
					midOverAgeAssetScale.setOverAgeTechnologyScale(structureNodeI.getValueMap().get(7).doubleValue());

					midOverAgeAssetScale
							.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
					session.save(midOverAgeAssetScale);
				} else if ((structureNodeI.getNodeName().contains("kV")
						|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）"))
						&& structureNodeI.isLeaf() == true) {
					/**
					 * 处理含有电压等级，且大类、中类与小类均有值的行。
					 */
					midOverAgeAssetScale.setLargeClass(structureNodeList.get(structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber()).getNodeName());
					midOverAgeAssetScale.setMediumClass(structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getNodeName());
					midOverAgeAssetScale
							.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
					midOverAgeAssetScale.setVoltageLevel(structureNodeI.getNodeName());
					midOverAgeAssetScale.setTotalOriginalValue(structureNodeI.getValueMap().get(1).doubleValue());
					midOverAgeAssetScale.setTotalQuantity(structureNodeI.getValueMap().get(2).doubleValue());
					midOverAgeAssetScale.setTotalTechnologyScale(structureNodeI.getValueMap().get(3).doubleValue());
					midOverAgeAssetScale.setTotalNetValue(0.0);
					midOverAgeAssetScale.setOverAgeNetValue(0.0);
					midOverAgeAssetScale.setOverAgeOriginalValue(structureNodeI.getValueMap().get(4).doubleValue());
					midOverAgeAssetScale.setOverAgeQuantity(structureNodeI.getValueMap().get(6).doubleValue());
					midOverAgeAssetScale.setOverAgeTechnologyScale(structureNodeI.getValueMap().get(7).doubleValue());

					midOverAgeAssetScale
							.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
					session.save(midOverAgeAssetScale);
				}

				if (sNodeI % 5000 == 0) {
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

	}

	/**
	 * "A.3.5 省外代维资产及租赁资产表"表的数据的导入 MidOtherProvinceLeaseAsset
	 * MidOtherProvinceLeaseAsset MID_OTHER_PROVINCE_LEASE_ASSET
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidOtherProvinceLeaseAssetImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String importedFilePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(importedFilePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 201;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {

			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}

			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 8; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {

					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("importedFilePathAndName=" + importedFilePathAndName + "Node name is "
					+ structureNode.getNodeName() + " node number is " + structureNode.getStructureNodeNumber()
					+ " parentNodeNumber is " + structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidOtherProvinceLeaseAsset midOtherProvinceLeaseAsset = new MidOtherProvinceLeaseAsset();
			midOtherProvinceLeaseAsset.setVersion(version);

			try {
				midOtherProvinceLeaseAsset.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midOtherProvinceLeaseAsset.setOrgName(orgName);
			try {
				midOtherProvinceLeaseAsset.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midOtherProvinceLeaseAsset.setLargeClass(structureNodeI.getNodeName());
				midOtherProvinceLeaseAsset.setMediumClass("");
				midOtherProvinceLeaseAsset.setSmallClass("");
				midOtherProvinceLeaseAsset.setVoltageLevel("");
				midOtherProvinceLeaseAsset
						.setOtherProviOriginalValue(structureNodeI.getValueMap().get(1).doubleValue());
				midOtherProvinceLeaseAsset.setOtherProviNetValue(structureNodeI.getValueMap().get(2).doubleValue());
				midOtherProvinceLeaseAsset.setOtherProviQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midOtherProvinceLeaseAsset
						.setOtherProviTechnologyScale(structureNodeI.getValueMap().get(4).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseOriginalValue(structureNodeI.getValueMap().get(5).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseNetValue(structureNodeI.getValueMap().get(6).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseQuantity(structureNodeI.getValueMap().get(7).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseTechnologyScale(structureNodeI.getValueMap().get(8).doubleValue());

				midOtherProvinceLeaseAsset.setCategory(structureNodeI.getNodeName());
				session.save(midOtherProvinceLeaseAsset);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midOtherProvinceLeaseAsset
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midOtherProvinceLeaseAsset.setMediumClass(structureNodeI.getNodeName());
				midOtherProvinceLeaseAsset.setSmallClass("");
				midOtherProvinceLeaseAsset.setVoltageLevel("");
				midOtherProvinceLeaseAsset
						.setOtherProviOriginalValue(structureNodeI.getValueMap().get(1).doubleValue());
				midOtherProvinceLeaseAsset.setOtherProviNetValue(structureNodeI.getValueMap().get(2).doubleValue());
				midOtherProvinceLeaseAsset.setOtherProviQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midOtherProvinceLeaseAsset
						.setOtherProviTechnologyScale(structureNodeI.getValueMap().get(4).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseOriginalValue(structureNodeI.getValueMap().get(5).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseNetValue(structureNodeI.getValueMap().get(6).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseQuantity(structureNodeI.getValueMap().get(7).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseTechnologyScale(structureNodeI.getValueMap().get(8).doubleValue());

				midOtherProvinceLeaseAsset.setCategory(structureNodeI.getNodeName());
				session.save(midOtherProvinceLeaseAsset);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midOtherProvinceLeaseAsset.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midOtherProvinceLeaseAsset
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midOtherProvinceLeaseAsset.setSmallClass("");
				midOtherProvinceLeaseAsset.setVoltageLevel(structureNodeI.getNodeName());
				midOtherProvinceLeaseAsset
						.setOtherProviOriginalValue(structureNodeI.getValueMap().get(1).doubleValue());
				midOtherProvinceLeaseAsset.setOtherProviNetValue(structureNodeI.getValueMap().get(2).doubleValue());
				midOtherProvinceLeaseAsset.setOtherProviQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midOtherProvinceLeaseAsset
						.setOtherProviTechnologyScale(structureNodeI.getValueMap().get(4).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseOriginalValue(structureNodeI.getValueMap().get(5).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseNetValue(structureNodeI.getValueMap().get(6).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseQuantity(structureNodeI.getValueMap().get(7).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseTechnologyScale(structureNodeI.getValueMap().get(8).doubleValue());

				midOtherProvinceLeaseAsset
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midOtherProvinceLeaseAsset);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midOtherProvinceLeaseAsset.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midOtherProvinceLeaseAsset.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midOtherProvinceLeaseAsset
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midOtherProvinceLeaseAsset.setVoltageLevel(structureNodeI.getNodeName());
				midOtherProvinceLeaseAsset
						.setOtherProviOriginalValue(structureNodeI.getValueMap().get(1).doubleValue());
				midOtherProvinceLeaseAsset.setOtherProviNetValue(structureNodeI.getValueMap().get(2).doubleValue());
				midOtherProvinceLeaseAsset.setOtherProviQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midOtherProvinceLeaseAsset
						.setOtherProviTechnologyScale(structureNodeI.getValueMap().get(4).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseOriginalValue(structureNodeI.getValueMap().get(5).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseNetValue(structureNodeI.getValueMap().get(6).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseQuantity(structureNodeI.getValueMap().get(7).doubleValue());
				midOtherProvinceLeaseAsset.setLeaseTechnologyScale(structureNodeI.getValueMap().get(8).doubleValue());

				midOtherProvinceLeaseAsset
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midOtherProvinceLeaseAsset);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "A.3.6 用户资产"表的数据的导入 MidUserAssetTechQuanScale MID_USER_ASSET_TECH_QUAN_SCALE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidUserAssetTechQuanScaleImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 201;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {

			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}

			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 2; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {

					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("filePathAndName=" + filePathAndName + "Node name is " + structureNode.getNodeName()
					+ " node number is " + structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidUserAssetTechQuanScale midUserAssetTechQuanScale = new MidUserAssetTechQuanScale();
			midUserAssetTechQuanScale.setVersion(version);

			try {
				midUserAssetTechQuanScale.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midUserAssetTechQuanScale.setOrgName(orgName);
			try {
				midUserAssetTechQuanScale.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midUserAssetTechQuanScale.setLargeClass(structureNodeI.getNodeName());
				midUserAssetTechQuanScale.setMediumClass("");
				midUserAssetTechQuanScale.setSmallClass("");
				midUserAssetTechQuanScale.setVoltageLevel("");
				midUserAssetTechQuanScale.setQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midUserAssetTechQuanScale.setTechnologyScale(structureNodeI.getValueMap().get(2).doubleValue());
				midUserAssetTechQuanScale.setOriginalValue(0.0);
				midUserAssetTechQuanScale.setNetValue(0.0);

				midUserAssetTechQuanScale.setCategory(structureNodeI.getNodeName());
				session.save(midUserAssetTechQuanScale);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midUserAssetTechQuanScale
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midUserAssetTechQuanScale.setMediumClass(structureNodeI.getNodeName());
				midUserAssetTechQuanScale.setSmallClass("");
				midUserAssetTechQuanScale.setVoltageLevel("");
				midUserAssetTechQuanScale.setQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midUserAssetTechQuanScale.setTechnologyScale(structureNodeI.getValueMap().get(2).doubleValue());
				midUserAssetTechQuanScale.setOriginalValue(0.0);
				midUserAssetTechQuanScale.setNetValue(0.0);

				midUserAssetTechQuanScale.setCategory(structureNodeI.getNodeName());
				session.save(midUserAssetTechQuanScale);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midUserAssetTechQuanScale.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midUserAssetTechQuanScale
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midUserAssetTechQuanScale.setSmallClass("");
				midUserAssetTechQuanScale.setVoltageLevel(structureNodeI.getNodeName());
				midUserAssetTechQuanScale.setQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midUserAssetTechQuanScale.setTechnologyScale(structureNodeI.getValueMap().get(2).doubleValue());
				midUserAssetTechQuanScale.setOriginalValue(0.0);
				midUserAssetTechQuanScale.setNetValue(0.0);

				midUserAssetTechQuanScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midUserAssetTechQuanScale);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midUserAssetTechQuanScale.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midUserAssetTechQuanScale.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midUserAssetTechQuanScale
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midUserAssetTechQuanScale.setVoltageLevel(structureNodeI.getNodeName());
				midUserAssetTechQuanScale.setQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midUserAssetTechQuanScale.setTechnologyScale(structureNodeI.getValueMap().get(2).doubleValue());
				midUserAssetTechQuanScale.setOriginalValue(0.0);
				midUserAssetTechQuanScale.setNetValue(0.0);

				midUserAssetTechQuanScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midUserAssetTechQuanScale);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "A.4.1 新增资产（价值）"表的数据的导入 MidIncreaseAssetValueScale
	 * MID_INCREASE_ASSET_VALUE_SCALE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidIncreaseAssetValueScaleImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 201;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else {
		 * 
		 * try { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } catch
		 * (Exception e) { // TODO: handle exception OutputStream out = null;
		 * endStructureNodeValueMap.put(2, new BigDecimal(0.0)); Row errorRow =
		 * errorSheet.createRow(errorI + 1); Cell first = errorRow.createCell(0); Cell
		 * second = errorRow.createCell(1); Cell third = errorRow.createCell(2); Cell
		 * four = errorRow.createCell(3); Cell five = errorRow.createCell(4); Cell six =
		 * errorRow.createCell(5); Cell seven = errorRow.createCell(6); //
		 * first.setCellValue(errorString); first.setCellValue(new Date());
		 * second.setCellValue(fileName); third.setCellValue(sheetName);
		 * four.setCellValue(standardEndRowNumber + 1); five.setCellValue(2 + 1);
		 * six.setCellValue(e.getMessage()); errorI = errorI + 1;
		 * 
		 * out = new FileOutputStream(errorFilePath); errorWorkBook.write(out); try { if
		 * (out != null) { out.flush(); out.close(); } } catch (IOException outE) {
		 * outE.printStackTrace(); } }
		 * 
		 * } }
		 *//**
			 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
			 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {

			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}

			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 5; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidIncreaseAssetValueScale midIncreaseAssetValueScale = new MidIncreaseAssetValueScale();
			midIncreaseAssetValueScale.setVersion(version);

			try {
				midIncreaseAssetValueScale.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midIncreaseAssetValueScale.setOrgName(orgName);
			try {
				midIncreaseAssetValueScale.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midIncreaseAssetValueScale.setLargeClass(structureNodeI.getNodeName());
				midIncreaseAssetValueScale.setMediumClass("");
				midIncreaseAssetValueScale.setSmallClass("");
				midIncreaseAssetValueScale.setVoltageLevel("");
				midIncreaseAssetValueScale
						.setInverstThisYearOriginValue(structureNodeI.getValueMap().get(1).doubleValue());
				midIncreaseAssetValueScale
						.setUserHandoverOriginValue(structureNodeI.getValueMap().get(2).doubleValue());
				midIncreaseAssetValueScale
						.setSmallPurchaseOriginValue(structureNodeI.getValueMap().get(3).doubleValue());
				midIncreaseAssetValueScale.setAllocationOriginValue(structureNodeI.getValueMap().get(4).doubleValue());
				midIncreaseAssetValueScale.setOtherOriginValue(structureNodeI.getValueMap().get(5).doubleValue());

				midIncreaseAssetValueScale.setCategory(structureNodeI.getNodeName());
				session.save(midIncreaseAssetValueScale);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midIncreaseAssetValueScale
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midIncreaseAssetValueScale.setMediumClass(structureNodeI.getNodeName());
				midIncreaseAssetValueScale.setSmallClass("");
				midIncreaseAssetValueScale.setVoltageLevel("");
				midIncreaseAssetValueScale
						.setInverstThisYearOriginValue(structureNodeI.getValueMap().get(1).doubleValue());
				midIncreaseAssetValueScale
						.setUserHandoverOriginValue(structureNodeI.getValueMap().get(2).doubleValue());
				midIncreaseAssetValueScale
						.setSmallPurchaseOriginValue(structureNodeI.getValueMap().get(3).doubleValue());
				midIncreaseAssetValueScale.setAllocationOriginValue(structureNodeI.getValueMap().get(4).doubleValue());
				midIncreaseAssetValueScale.setOtherOriginValue(structureNodeI.getValueMap().get(5).doubleValue());

				midIncreaseAssetValueScale.setCategory(structureNodeI.getNodeName());
				session.save(midIncreaseAssetValueScale);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midIncreaseAssetValueScale.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midIncreaseAssetValueScale
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midIncreaseAssetValueScale.setSmallClass("");
				midIncreaseAssetValueScale.setVoltageLevel(structureNodeI.getNodeName());
				midIncreaseAssetValueScale
						.setInverstThisYearOriginValue(structureNodeI.getValueMap().get(1).doubleValue());
				midIncreaseAssetValueScale
						.setUserHandoverOriginValue(structureNodeI.getValueMap().get(2).doubleValue());
				midIncreaseAssetValueScale
						.setSmallPurchaseOriginValue(structureNodeI.getValueMap().get(3).doubleValue());
				midIncreaseAssetValueScale.setAllocationOriginValue(structureNodeI.getValueMap().get(4).doubleValue());
				midIncreaseAssetValueScale.setOtherOriginValue(structureNodeI.getValueMap().get(5).doubleValue());

				midIncreaseAssetValueScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midIncreaseAssetValueScale);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midIncreaseAssetValueScale.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midIncreaseAssetValueScale.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midIncreaseAssetValueScale
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midIncreaseAssetValueScale.setVoltageLevel(structureNodeI.getNodeName());
				midIncreaseAssetValueScale
						.setInverstThisYearOriginValue(structureNodeI.getValueMap().get(1).doubleValue());
				midIncreaseAssetValueScale
						.setUserHandoverOriginValue(structureNodeI.getValueMap().get(2).doubleValue());
				midIncreaseAssetValueScale
						.setSmallPurchaseOriginValue(structureNodeI.getValueMap().get(3).doubleValue());
				midIncreaseAssetValueScale.setAllocationOriginValue(structureNodeI.getValueMap().get(4).doubleValue());
				midIncreaseAssetValueScale.setOtherOriginValue(structureNodeI.getValueMap().get(5).doubleValue());

				midIncreaseAssetValueScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midIncreaseAssetValueScale);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "A.3.5 省外代维资产及租赁资产表"表的数据的导入 MidIncreaseAssetQuantScale
	 * MID_INCREASE_ASSET_QUANT_SCALE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidIncreaseAssetQuantScaleImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 201;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {

			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}

			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 10; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidIncreaseAssetQuantScale midIncreaseAssetQuantScale = new MidIncreaseAssetQuantScale();
			midIncreaseAssetQuantScale.setVersion(version);

			try {
				midIncreaseAssetQuantScale.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midIncreaseAssetQuantScale.setOrgName(orgName);
			try {
				midIncreaseAssetQuantScale.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midIncreaseAssetQuantScale.setLargeClass(structureNodeI.getNodeName());
				midIncreaseAssetQuantScale.setMediumClass("");
				midIncreaseAssetQuantScale.setSmallClass("");
				midIncreaseAssetQuantScale.setVoltageLevel("");
				midIncreaseAssetQuantScale
						.setInverstThisYearQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midIncreaseAssetQuantScale
						.setInverstThisYearTechScale(structureNodeI.getValueMap().get(2).doubleValue());
				midIncreaseAssetQuantScale.setUserHandoverQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midIncreaseAssetQuantScale.setUserHandoverTechScale(structureNodeI.getValueMap().get(4).doubleValue());
				midIncreaseAssetQuantScale.setSmallPurchaseQuantity(structureNodeI.getValueMap().get(5).doubleValue());
				midIncreaseAssetQuantScale.setSmallPurchaseTechScale(structureNodeI.getValueMap().get(6).doubleValue());
				midIncreaseAssetQuantScale.setAllocationQuantity(structureNodeI.getValueMap().get(7).doubleValue());
				midIncreaseAssetQuantScale.setAllocationTechScale(structureNodeI.getValueMap().get(8).doubleValue());
				midIncreaseAssetQuantScale.setOtherQuantity(structureNodeI.getValueMap().get(9).doubleValue());
				midIncreaseAssetQuantScale.setOtherTechScale(structureNodeI.getValueMap().get(10).doubleValue());

				midIncreaseAssetQuantScale.setCategory(structureNodeI.getNodeName());
				session.save(midIncreaseAssetQuantScale);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midIncreaseAssetQuantScale
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midIncreaseAssetQuantScale.setMediumClass(structureNodeI.getNodeName());
				midIncreaseAssetQuantScale.setSmallClass("");
				midIncreaseAssetQuantScale.setVoltageLevel("");
				midIncreaseAssetQuantScale
						.setInverstThisYearQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midIncreaseAssetQuantScale
						.setInverstThisYearTechScale(structureNodeI.getValueMap().get(2).doubleValue());
				midIncreaseAssetQuantScale.setUserHandoverQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midIncreaseAssetQuantScale.setUserHandoverTechScale(structureNodeI.getValueMap().get(4).doubleValue());
				midIncreaseAssetQuantScale.setSmallPurchaseQuantity(structureNodeI.getValueMap().get(5).doubleValue());
				midIncreaseAssetQuantScale.setSmallPurchaseTechScale(structureNodeI.getValueMap().get(6).doubleValue());
				midIncreaseAssetQuantScale.setAllocationQuantity(structureNodeI.getValueMap().get(7).doubleValue());
				midIncreaseAssetQuantScale.setAllocationTechScale(structureNodeI.getValueMap().get(8).doubleValue());
				midIncreaseAssetQuantScale.setOtherQuantity(structureNodeI.getValueMap().get(9).doubleValue());
				midIncreaseAssetQuantScale.setOtherTechScale(structureNodeI.getValueMap().get(10).doubleValue());

				midIncreaseAssetQuantScale.setCategory(structureNodeI.getNodeName());
				session.save(midIncreaseAssetQuantScale);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midIncreaseAssetQuantScale.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midIncreaseAssetQuantScale
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midIncreaseAssetQuantScale.setSmallClass("");
				midIncreaseAssetQuantScale.setVoltageLevel(structureNodeI.getNodeName());
				midIncreaseAssetQuantScale
						.setInverstThisYearQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midIncreaseAssetQuantScale
						.setInverstThisYearTechScale(structureNodeI.getValueMap().get(2).doubleValue());
				midIncreaseAssetQuantScale.setUserHandoverQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midIncreaseAssetQuantScale.setUserHandoverTechScale(structureNodeI.getValueMap().get(4).doubleValue());
				midIncreaseAssetQuantScale.setSmallPurchaseQuantity(structureNodeI.getValueMap().get(5).doubleValue());
				midIncreaseAssetQuantScale.setSmallPurchaseTechScale(structureNodeI.getValueMap().get(6).doubleValue());
				midIncreaseAssetQuantScale.setAllocationQuantity(structureNodeI.getValueMap().get(7).doubleValue());
				midIncreaseAssetQuantScale.setAllocationTechScale(structureNodeI.getValueMap().get(8).doubleValue());
				midIncreaseAssetQuantScale.setOtherQuantity(structureNodeI.getValueMap().get(9).doubleValue());
				midIncreaseAssetQuantScale.setOtherTechScale(structureNodeI.getValueMap().get(10).doubleValue());

				midIncreaseAssetQuantScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midIncreaseAssetQuantScale);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midIncreaseAssetQuantScale.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midIncreaseAssetQuantScale.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midIncreaseAssetQuantScale
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midIncreaseAssetQuantScale.setVoltageLevel(structureNodeI.getNodeName());
				midIncreaseAssetQuantScale
						.setInverstThisYearQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midIncreaseAssetQuantScale
						.setInverstThisYearTechScale(structureNodeI.getValueMap().get(2).doubleValue());
				midIncreaseAssetQuantScale.setUserHandoverQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midIncreaseAssetQuantScale.setUserHandoverTechScale(structureNodeI.getValueMap().get(4).doubleValue());
				midIncreaseAssetQuantScale.setSmallPurchaseQuantity(structureNodeI.getValueMap().get(5).doubleValue());
				midIncreaseAssetQuantScale.setSmallPurchaseTechScale(structureNodeI.getValueMap().get(6).doubleValue());
				midIncreaseAssetQuantScale.setAllocationQuantity(structureNodeI.getValueMap().get(7).doubleValue());
				midIncreaseAssetQuantScale.setAllocationTechScale(structureNodeI.getValueMap().get(8).doubleValue());
				midIncreaseAssetQuantScale.setOtherQuantity(structureNodeI.getValueMap().get(9).doubleValue());
				midIncreaseAssetQuantScale.setOtherTechScale(structureNodeI.getValueMap().get(10).doubleValue());

				midIncreaseAssetQuantScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midIncreaseAssetQuantScale);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "C.2.1 利用效率-资产利用状态(数量)"表的数据的导入 MidAssetUseStateQuant
	 * MID_ASSET_USE_STATE_QUANT
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidAssetUseStateQuantImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();
		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}
		int standardStartRowNumber = 4;
		int standardEndRowNumber = 201;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

//System.out.println("filePathAndName="+filePathAndName+"sheetEndRow1="+sheetEndRow1);
		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * int rowNumber=importFileSheet.getPhysicalNumberOfRows();
		 * //System.out.println("rowNumber="+rowNumber+",endRowNumber="+endRowNumber);
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else { if(sheetEndRow1.getCell(1)==null) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); }
		 * 
		 * if(sheetEndRow1.getCell(2)==null) { endStructureNodeValueMap.put(2, new
		 * BigDecimal(0.0)); } else if (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {

			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}

			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 18; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("filePathAndName=" + filePathAndName + ",Node name is " + structureNode.getNodeName()
					+ " node number is " + structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidAssetUseStateQuant midAssetUseStateQuant = new MidAssetUseStateQuant();
			midAssetUseStateQuant.setVersion(version);

			try {
				midAssetUseStateQuant.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midAssetUseStateQuant.setOrgName(orgName);
			try {
				midAssetUseStateQuant.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midAssetUseStateQuant.setLargeClass(structureNodeI.getNodeName());
				midAssetUseStateQuant.setMediumClass("");
				midAssetUseStateQuant.setSmallClass("");
				midAssetUseStateQuant.setVoltageLevel("");
				midAssetUseStateQuant.setYear1WorkingState(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetUseStateQuant.setYear1BackupState(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetUseStateQuant.setYear1DiscardState(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetUseStateQuant.setYear2WorkingState(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetUseStateQuant.setYear2BackupState(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetUseStateQuant.setYear2DiscardState(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetUseStateQuant.setYear3WorkingState(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetUseStateQuant.setYear3BackupState(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetUseStateQuant.setYear3DiscardState(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetUseStateQuant.setYear4WorkingState(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetUseStateQuant.setYear4BackupState(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetUseStateQuant.setYear4DiscardState(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetUseStateQuant.setYear5WorkingState(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetUseStateQuant.setYear5BackupState(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetUseStateQuant.setYear5DiscardState(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetUseStateQuant.setYear6WorkingState(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetUseStateQuant.setYear6BackupState(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetUseStateQuant.setYear6DiscardState(structureNodeI.getValueMap().get(3).doubleValue());

				midAssetUseStateQuant.setCategory(structureNodeI.getNodeName());
				session.save(midAssetUseStateQuant);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midAssetUseStateQuant
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetUseStateQuant.setMediumClass(structureNodeI.getNodeName());
				midAssetUseStateQuant.setSmallClass("");
				midAssetUseStateQuant.setVoltageLevel("");
				midAssetUseStateQuant.setYear1WorkingState(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetUseStateQuant.setYear1BackupState(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetUseStateQuant.setYear1DiscardState(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetUseStateQuant.setYear2WorkingState(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetUseStateQuant.setYear2BackupState(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetUseStateQuant.setYear2DiscardState(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetUseStateQuant.setYear3WorkingState(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetUseStateQuant.setYear3BackupState(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetUseStateQuant.setYear3DiscardState(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetUseStateQuant.setYear4WorkingState(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetUseStateQuant.setYear4BackupState(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetUseStateQuant.setYear4DiscardState(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetUseStateQuant.setYear5WorkingState(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetUseStateQuant.setYear5BackupState(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetUseStateQuant.setYear5DiscardState(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetUseStateQuant.setYear6WorkingState(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetUseStateQuant.setYear6BackupState(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetUseStateQuant.setYear6DiscardState(structureNodeI.getValueMap().get(3).doubleValue());

				midAssetUseStateQuant.setCategory(structureNodeI.getNodeName());
				session.save(midAssetUseStateQuant);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midAssetUseStateQuant.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetUseStateQuant
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetUseStateQuant.setSmallClass("");
				midAssetUseStateQuant.setVoltageLevel(structureNodeI.getNodeName());
				midAssetUseStateQuant.setYear1WorkingState(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetUseStateQuant.setYear1BackupState(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetUseStateQuant.setYear1DiscardState(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetUseStateQuant.setYear2WorkingState(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetUseStateQuant.setYear2BackupState(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetUseStateQuant.setYear2DiscardState(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetUseStateQuant.setYear3WorkingState(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetUseStateQuant.setYear3BackupState(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetUseStateQuant.setYear3DiscardState(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetUseStateQuant.setYear4WorkingState(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetUseStateQuant.setYear4BackupState(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetUseStateQuant.setYear4DiscardState(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetUseStateQuant.setYear5WorkingState(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetUseStateQuant.setYear5BackupState(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetUseStateQuant.setYear5DiscardState(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetUseStateQuant.setYear6WorkingState(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetUseStateQuant.setYear6BackupState(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetUseStateQuant.setYear6DiscardState(structureNodeI.getValueMap().get(3).doubleValue());

				midAssetUseStateQuant
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetUseStateQuant);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midAssetUseStateQuant.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midAssetUseStateQuant.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetUseStateQuant
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetUseStateQuant.setVoltageLevel(structureNodeI.getNodeName());
				midAssetUseStateQuant.setYear1WorkingState(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetUseStateQuant.setYear1BackupState(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetUseStateQuant.setYear1DiscardState(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetUseStateQuant.setYear2WorkingState(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetUseStateQuant.setYear2BackupState(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetUseStateQuant.setYear2DiscardState(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetUseStateQuant.setYear3WorkingState(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetUseStateQuant.setYear3BackupState(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetUseStateQuant.setYear3DiscardState(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetUseStateQuant.setYear4WorkingState(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetUseStateQuant.setYear4BackupState(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetUseStateQuant.setYear4DiscardState(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetUseStateQuant.setYear5WorkingState(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetUseStateQuant.setYear5BackupState(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetUseStateQuant.setYear5DiscardState(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetUseStateQuant.setYear6WorkingState(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetUseStateQuant.setYear6BackupState(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetUseStateQuant.setYear6DiscardState(structureNodeI.getValueMap().get(3).doubleValue());

				midAssetUseStateQuant
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetUseStateQuant);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "C.2.2 利用效率-资产利用状态(原值)"表的数据的导入 MidAssetUseStateOrigVal
	 * MID_ASSET_USE_STATE_ORIG_VAL
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidAssetUseStateOrigValImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();
		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 201;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 18; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidAssetUseStateOrigVal midAssetUseStateOrigVal = new MidAssetUseStateOrigVal();
			midAssetUseStateOrigVal.setVersion(version);

			try {
				midAssetUseStateOrigVal.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midAssetUseStateOrigVal.setOrgName(orgName);
			try {
				midAssetUseStateOrigVal.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midAssetUseStateOrigVal.setLargeClass(structureNodeI.getNodeName());
				midAssetUseStateOrigVal.setMediumClass("");
				midAssetUseStateOrigVal.setSmallClass("");
				midAssetUseStateOrigVal.setVoltageLevel("");
				midAssetUseStateOrigVal.setYear1WorkingOrigVal(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetUseStateOrigVal.setYear1BackupOrigVal(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetUseStateOrigVal.setYear1DiscardOrigVal(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetUseStateOrigVal.setYear2WorkingOrigVal(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetUseStateOrigVal.setYear2BackupOrigVal(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetUseStateOrigVal.setYear2DiscardOrigVal(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetUseStateOrigVal.setYear3WorkingOrigVal(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetUseStateOrigVal.setYear3BackupOrigVal(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetUseStateOrigVal.setYear3DiscardOrigVal(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetUseStateOrigVal.setYear4WorkingOrigVal(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetUseStateOrigVal.setYear4BackupOrigVal(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetUseStateOrigVal.setYear4DiscardOrigVal(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetUseStateOrigVal.setYear5WorkingOrigVal(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetUseStateOrigVal.setYear5BackupOrigVal(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetUseStateOrigVal.setYear5DiscardOrigVal(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetUseStateOrigVal.setYear6WorkingOrigVal(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetUseStateOrigVal.setYear6BackupOrigVal(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetUseStateOrigVal.setYear6DiscardOrigVal(structureNodeI.getValueMap().get(3).doubleValue());

				midAssetUseStateOrigVal.setCategory(structureNodeI.getNodeName());
				session.save(midAssetUseStateOrigVal);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midAssetUseStateOrigVal
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetUseStateOrigVal.setMediumClass(structureNodeI.getNodeName());
				midAssetUseStateOrigVal.setSmallClass("");
				midAssetUseStateOrigVal.setVoltageLevel("");
				midAssetUseStateOrigVal.setYear1WorkingOrigVal(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetUseStateOrigVal.setYear1BackupOrigVal(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetUseStateOrigVal.setYear1DiscardOrigVal(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetUseStateOrigVal.setYear2WorkingOrigVal(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetUseStateOrigVal.setYear2BackupOrigVal(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetUseStateOrigVal.setYear2DiscardOrigVal(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetUseStateOrigVal.setYear3WorkingOrigVal(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetUseStateOrigVal.setYear3BackupOrigVal(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetUseStateOrigVal.setYear3DiscardOrigVal(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetUseStateOrigVal.setYear4WorkingOrigVal(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetUseStateOrigVal.setYear4BackupOrigVal(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetUseStateOrigVal.setYear4DiscardOrigVal(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetUseStateOrigVal.setYear5WorkingOrigVal(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetUseStateOrigVal.setYear5BackupOrigVal(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetUseStateOrigVal.setYear5DiscardOrigVal(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetUseStateOrigVal.setYear6WorkingOrigVal(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetUseStateOrigVal.setYear6BackupOrigVal(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetUseStateOrigVal.setYear6DiscardOrigVal(structureNodeI.getValueMap().get(3).doubleValue());

				midAssetUseStateOrigVal.setCategory(structureNodeI.getNodeName());
				session.save(midAssetUseStateOrigVal);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midAssetUseStateOrigVal.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetUseStateOrigVal
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetUseStateOrigVal.setSmallClass("");
				midAssetUseStateOrigVal.setVoltageLevel(structureNodeI.getNodeName());
				midAssetUseStateOrigVal.setYear1WorkingOrigVal(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetUseStateOrigVal.setYear1BackupOrigVal(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetUseStateOrigVal.setYear1DiscardOrigVal(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetUseStateOrigVal.setYear2WorkingOrigVal(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetUseStateOrigVal.setYear2BackupOrigVal(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetUseStateOrigVal.setYear2DiscardOrigVal(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetUseStateOrigVal.setYear3WorkingOrigVal(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetUseStateOrigVal.setYear3BackupOrigVal(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetUseStateOrigVal.setYear3DiscardOrigVal(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetUseStateOrigVal.setYear4WorkingOrigVal(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetUseStateOrigVal.setYear4BackupOrigVal(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetUseStateOrigVal.setYear4DiscardOrigVal(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetUseStateOrigVal.setYear5WorkingOrigVal(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetUseStateOrigVal.setYear5BackupOrigVal(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetUseStateOrigVal.setYear5DiscardOrigVal(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetUseStateOrigVal.setYear6WorkingOrigVal(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetUseStateOrigVal.setYear6BackupOrigVal(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetUseStateOrigVal.setYear6DiscardOrigVal(structureNodeI.getValueMap().get(3).doubleValue());

				midAssetUseStateOrigVal
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetUseStateOrigVal);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midAssetUseStateOrigVal.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midAssetUseStateOrigVal.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetUseStateOrigVal
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetUseStateOrigVal.setVoltageLevel(structureNodeI.getNodeName());
				midAssetUseStateOrigVal.setYear1WorkingOrigVal(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetUseStateOrigVal.setYear1BackupOrigVal(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetUseStateOrigVal.setYear1DiscardOrigVal(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetUseStateOrigVal.setYear2WorkingOrigVal(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetUseStateOrigVal.setYear2BackupOrigVal(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetUseStateOrigVal.setYear2DiscardOrigVal(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetUseStateOrigVal.setYear3WorkingOrigVal(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetUseStateOrigVal.setYear3BackupOrigVal(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetUseStateOrigVal.setYear3DiscardOrigVal(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetUseStateOrigVal.setYear4WorkingOrigVal(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetUseStateOrigVal.setYear4BackupOrigVal(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetUseStateOrigVal.setYear4DiscardOrigVal(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetUseStateOrigVal.setYear5WorkingOrigVal(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetUseStateOrigVal.setYear5BackupOrigVal(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetUseStateOrigVal.setYear5DiscardOrigVal(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetUseStateOrigVal.setYear6WorkingOrigVal(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetUseStateOrigVal.setYear6BackupOrigVal(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetUseStateOrigVal.setYear6DiscardOrigVal(structureNodeI.getValueMap().get(3).doubleValue());

				midAssetUseStateOrigVal
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetUseStateOrigVal);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "C.2.8 资产退役-使用年限"表的数据的导入 MidDiscardAssetUseingYear
	 * MID_DISCARD_ASSET_USEING_YEAR
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidDiscardAssetUseingYearImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.1 资产结构-价值规模结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 201;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();

		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 *//**
			 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
			 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 12; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidDiscardAssetUseingYear midDiscardAssetUseingYear = new MidDiscardAssetUseingYear();
			midDiscardAssetUseingYear.setVersion(version);

			try {
				midDiscardAssetUseingYear.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midDiscardAssetUseingYear.setOrgName(orgName);
			try {
				midDiscardAssetUseingYear.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midDiscardAssetUseingYear.setLargeClass(structureNodeI.getNodeName());
				midDiscardAssetUseingYear.setMediumClass("");
				midDiscardAssetUseingYear.setSmallClass("");
				midDiscardAssetUseingYear.setVoltageLevel("");
				midDiscardAssetUseingYear.setRealUsingYear6(structureNodeI.getValueMap().get(1).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear5(structureNodeI.getValueMap().get(3).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear4(structureNodeI.getValueMap().get(5).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear3(structureNodeI.getValueMap().get(7).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear2(structureNodeI.getValueMap().get(9).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear1(structureNodeI.getValueMap().get(11).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear6(structureNodeI.getValueMap().get(2).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear5(structureNodeI.getValueMap().get(4).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear4(structureNodeI.getValueMap().get(6).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear3(structureNodeI.getValueMap().get(8).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear2(structureNodeI.getValueMap().get(10).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear1(structureNodeI.getValueMap().get(12).doubleValue());

				midDiscardAssetUseingYear.setCategory(structureNodeI.getNodeName());
				session.save(midDiscardAssetUseingYear);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midDiscardAssetUseingYear
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardAssetUseingYear.setMediumClass(structureNodeI.getNodeName());
				midDiscardAssetUseingYear.setSmallClass("");
				midDiscardAssetUseingYear.setVoltageLevel("");
				midDiscardAssetUseingYear.setRealUsingYear6(structureNodeI.getValueMap().get(1).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear5(structureNodeI.getValueMap().get(3).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear4(structureNodeI.getValueMap().get(5).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear3(structureNodeI.getValueMap().get(7).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear2(structureNodeI.getValueMap().get(9).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear1(structureNodeI.getValueMap().get(11).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear6(structureNodeI.getValueMap().get(2).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear5(structureNodeI.getValueMap().get(4).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear4(structureNodeI.getValueMap().get(6).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear3(structureNodeI.getValueMap().get(8).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear2(structureNodeI.getValueMap().get(10).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear1(structureNodeI.getValueMap().get(12).doubleValue());

				midDiscardAssetUseingYear.setCategory(structureNodeI.getNodeName());
				session.save(midDiscardAssetUseingYear);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midDiscardAssetUseingYear.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midDiscardAssetUseingYear
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardAssetUseingYear.setSmallClass("");
				midDiscardAssetUseingYear.setVoltageLevel(structureNodeI.getNodeName());
				midDiscardAssetUseingYear.setRealUsingYear6(structureNodeI.getValueMap().get(1).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear5(structureNodeI.getValueMap().get(3).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear4(structureNodeI.getValueMap().get(5).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear3(structureNodeI.getValueMap().get(7).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear2(structureNodeI.getValueMap().get(9).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear1(structureNodeI.getValueMap().get(11).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear6(structureNodeI.getValueMap().get(2).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear5(structureNodeI.getValueMap().get(4).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear4(structureNodeI.getValueMap().get(6).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear3(structureNodeI.getValueMap().get(8).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear2(structureNodeI.getValueMap().get(10).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear1(structureNodeI.getValueMap().get(12).doubleValue());

				midDiscardAssetUseingYear
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midDiscardAssetUseingYear);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midDiscardAssetUseingYear.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midDiscardAssetUseingYear.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midDiscardAssetUseingYear
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardAssetUseingYear.setVoltageLevel(structureNodeI.getNodeName());
				midDiscardAssetUseingYear.setRealUsingYear6(structureNodeI.getValueMap().get(1).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear5(structureNodeI.getValueMap().get(3).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear4(structureNodeI.getValueMap().get(5).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear3(structureNodeI.getValueMap().get(7).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear2(structureNodeI.getValueMap().get(9).doubleValue());
				midDiscardAssetUseingYear.setRealUsingYear1(structureNodeI.getValueMap().get(11).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear6(structureNodeI.getValueMap().get(2).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear5(structureNodeI.getValueMap().get(4).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear4(structureNodeI.getValueMap().get(6).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear3(structureNodeI.getValueMap().get(8).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear2(structureNodeI.getValueMap().get(10).doubleValue());
				midDiscardAssetUseingYear
						.setDiscardAssetQuantityYear1(structureNodeI.getValueMap().get(12).doubleValue());

				midDiscardAssetUseingYear
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midDiscardAssetUseingYear);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "A.3.2.2 资产结构-年龄结构（规模）"表的数据的导入 MidAssetTescaAgeStructure
	 * MID_ASSET_TESCA_AGE_STRUCTURE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidAssetTescaAgeStructureImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("A.3.2.2 资产结构（规模)结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 5;
		int standardEndRowNumber = 68;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();

		/*
		 * System.out.println("importFileSheet.getPhysicalNumberOfRows()=" +
		 * importFileSheet.getPhysicalNumberOfRows() + ",endRowNumber=" + endRowNumber);
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else { if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 31; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI + 1)
						.getCellType() == structureNodeRow1.getCell(colI + 1).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI + 1)
								.getCellType() == structureNodeRow1.getCell(colI + 1).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI + 1).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidAssetTescaAgeStructure midAssetTescaAgeStructure = new MidAssetTescaAgeStructure();
			midAssetTescaAgeStructure.setVersion(version);

			try {
				midAssetTescaAgeStructure.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midAssetTescaAgeStructure.setOrgName(orgName);
			try {
				midAssetTescaAgeStructure.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midAssetTescaAgeStructure.setLargeClass(structureNodeI.getNodeName());
				midAssetTescaAgeStructure.setMediumClass("");
				midAssetTescaAgeStructure.setSmallClass("");
				midAssetTescaAgeStructure.setVoltageLevel("");
				midAssetTescaAgeStructure.setTechScaleAge1(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge2(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge3(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge4(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge5(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge6(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge7(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge8(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge9(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge10(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge11(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge12(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge13(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge14(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge15(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge16(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge17(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge18(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge19(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge20(structureNodeI.getValueMap().get(20).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge21(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge22(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge23(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge24(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge25(structureNodeI.getValueMap().get(25).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge26(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge27(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge28(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge29(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge30(structureNodeI.getValueMap().get(30).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAgeMoreThan30(structureNodeI.getValueMap().get(31).doubleValue());

				midAssetTescaAgeStructure.setCategory(structureNodeI.getNodeName());
				session.save(midAssetTescaAgeStructure);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midAssetTescaAgeStructure
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetTescaAgeStructure.setMediumClass(structureNodeI.getNodeName());
				midAssetTescaAgeStructure.setSmallClass("");
				midAssetTescaAgeStructure.setVoltageLevel("");
				midAssetTescaAgeStructure.setTechScaleAge1(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge2(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge3(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge4(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge5(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge6(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge7(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge8(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge9(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge10(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge11(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge12(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge13(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge14(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge15(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge16(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge17(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge18(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge19(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge20(structureNodeI.getValueMap().get(20).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge21(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge22(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge23(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge24(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge25(structureNodeI.getValueMap().get(25).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge26(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge27(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge28(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge29(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge30(structureNodeI.getValueMap().get(30).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAgeMoreThan30(structureNodeI.getValueMap().get(31).doubleValue());

				midAssetTescaAgeStructure.setCategory(structureNodeI.getNodeName());
				session.save(midAssetTescaAgeStructure);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midAssetTescaAgeStructure.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetTescaAgeStructure
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetTescaAgeStructure.setSmallClass("");
				midAssetTescaAgeStructure.setVoltageLevel(structureNodeI.getNodeName());
				midAssetTescaAgeStructure.setTechScaleAge1(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge2(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge3(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge4(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge5(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge6(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge7(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge8(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge9(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge10(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge11(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge12(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge13(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge14(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge15(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge16(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge17(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge18(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge19(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge20(structureNodeI.getValueMap().get(20).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge21(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge22(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge23(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge24(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge25(structureNodeI.getValueMap().get(25).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge26(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge27(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge28(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge29(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge30(structureNodeI.getValueMap().get(30).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAgeMoreThan30(structureNodeI.getValueMap().get(31).doubleValue());

				midAssetTescaAgeStructure
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetTescaAgeStructure);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midAssetTescaAgeStructure.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midAssetTescaAgeStructure.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetTescaAgeStructure
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetTescaAgeStructure.setVoltageLevel(structureNodeI.getNodeName());
				midAssetTescaAgeStructure.setTechScaleAge1(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge2(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge3(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge4(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge5(structureNodeI.getValueMap().get(5).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge6(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge7(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge8(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge9(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge10(structureNodeI.getValueMap().get(10).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge11(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge12(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge13(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge14(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge15(structureNodeI.getValueMap().get(15).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge16(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge17(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge18(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge19(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge20(structureNodeI.getValueMap().get(20).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge21(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge22(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge23(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge24(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge25(structureNodeI.getValueMap().get(25).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge26(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge27(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge28(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge29(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAge30(structureNodeI.getValueMap().get(30).doubleValue());
				midAssetTescaAgeStructure.setTechScaleAgeMoreThan30(structureNodeI.getValueMap().get(31).doubleValue());

				midAssetTescaAgeStructure
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetTescaAgeStructure);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "B.5.2 各年度健康状态统计表"表的数据的导入 MidAssetHealthStateQuant
	 * MID_ASSET_HEALTH_STATE_QUANT
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidAssetHealthStateQuantImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("B.5.2 各年度健康状态统计表-结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 185;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();

		// System.out.println("importFileSheet.getPhysicalNumberOfRows()-1="+(importFileSheet.getPhysicalNumberOfRows()-1)+",endRowNumber"+endRowNumber);
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else { if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 30; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidAssetHealthStateQuant midAssetHealthStateQuant = new MidAssetHealthStateQuant();
			midAssetHealthStateQuant.setVersion(version);

			try {
				midAssetHealthStateQuant.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midAssetHealthStateQuant.setOrgName(orgName);
			try {
				midAssetHealthStateQuant.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midAssetHealthStateQuant.setLargeClass(structureNodeI.getNodeName());
				midAssetHealthStateQuant.setMediumClass("");
				midAssetHealthStateQuant.setSmallClass("");
				midAssetHealthStateQuant.setVoltageLevel("");
				midAssetHealthStateQuant.setYear1TotalAssetQuantity(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetHealthStateQuant.setYear1NormalStateQuant(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetHealthStateQuant
						.setYear1AttentionStateQuant(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetHealthStateQuant.setYear1UnnormalStateQuant(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetHealthStateQuant.setYear1SeriousStateQuant(structureNodeI.getValueMap().get(30).doubleValue());

				midAssetHealthStateQuant.setYear2TotalAssetQuantity(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetHealthStateQuant.setYear2NormalStateQuant(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetHealthStateQuant
						.setYear2AttentionStateQuant(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetHealthStateQuant.setYear2UnnormalStateQuant(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetHealthStateQuant.setYear2SeriousStateQuant(structureNodeI.getValueMap().get(25).doubleValue());

				midAssetHealthStateQuant.setYear3TotalAssetQuantity(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetHealthStateQuant.setYear3NormalStateQuant(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetHealthStateQuant
						.setYear3AttentionStateQuant(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetHealthStateQuant.setYear3UnnormalStateQuant(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetHealthStateQuant.setYear3SeriousStateQuant(structureNodeI.getValueMap().get(20).doubleValue());

				midAssetHealthStateQuant.setYear4TotalAssetQuantity(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetHealthStateQuant.setYear4NormalStateQuant(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetHealthStateQuant
						.setYear4AttentionStateQuant(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetHealthStateQuant.setYear4UnnormalStateQuant(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetHealthStateQuant.setYear4SeriousStateQuant(structureNodeI.getValueMap().get(15).doubleValue());

				midAssetHealthStateQuant.setYear5TotalAssetQuantity(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetHealthStateQuant.setYear5NormalStateQuant(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetHealthStateQuant.setYear5AttentionStateQuant(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetHealthStateQuant.setYear5UnnormalStateQuant(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetHealthStateQuant.setYear5SeriousStateQuant(structureNodeI.getValueMap().get(10).doubleValue());

				midAssetHealthStateQuant.setYear6TotalAssetQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetHealthStateQuant.setYear6NormalStateQuant(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetHealthStateQuant.setYear6AttentionStateQuant(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetHealthStateQuant.setYear6UnnormalStateQuant(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetHealthStateQuant.setYear6SeriousStateQuant(structureNodeI.getValueMap().get(5).doubleValue());

				midAssetHealthStateQuant.setCategory(structureNodeI.getNodeName());
				session.save(midAssetHealthStateQuant);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midAssetHealthStateQuant
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetHealthStateQuant.setMediumClass(structureNodeI.getNodeName());
				midAssetHealthStateQuant.setSmallClass("");
				midAssetHealthStateQuant.setVoltageLevel("");
				midAssetHealthStateQuant.setYear1TotalAssetQuantity(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetHealthStateQuant.setYear1NormalStateQuant(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetHealthStateQuant
						.setYear1AttentionStateQuant(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetHealthStateQuant.setYear1UnnormalStateQuant(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetHealthStateQuant.setYear1SeriousStateQuant(structureNodeI.getValueMap().get(30).doubleValue());

				midAssetHealthStateQuant.setYear2TotalAssetQuantity(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetHealthStateQuant.setYear2NormalStateQuant(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetHealthStateQuant
						.setYear2AttentionStateQuant(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetHealthStateQuant.setYear2UnnormalStateQuant(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetHealthStateQuant.setYear2SeriousStateQuant(structureNodeI.getValueMap().get(25).doubleValue());

				midAssetHealthStateQuant.setYear3TotalAssetQuantity(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetHealthStateQuant.setYear3NormalStateQuant(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetHealthStateQuant
						.setYear3AttentionStateQuant(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetHealthStateQuant.setYear3UnnormalStateQuant(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetHealthStateQuant.setYear3SeriousStateQuant(structureNodeI.getValueMap().get(20).doubleValue());

				midAssetHealthStateQuant.setYear4TotalAssetQuantity(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetHealthStateQuant.setYear4NormalStateQuant(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetHealthStateQuant
						.setYear4AttentionStateQuant(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetHealthStateQuant.setYear4UnnormalStateQuant(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetHealthStateQuant.setYear4SeriousStateQuant(structureNodeI.getValueMap().get(15).doubleValue());

				midAssetHealthStateQuant.setYear5TotalAssetQuantity(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetHealthStateQuant.setYear5NormalStateQuant(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetHealthStateQuant.setYear5AttentionStateQuant(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetHealthStateQuant.setYear5UnnormalStateQuant(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetHealthStateQuant.setYear5SeriousStateQuant(structureNodeI.getValueMap().get(10).doubleValue());

				midAssetHealthStateQuant.setYear6TotalAssetQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetHealthStateQuant.setYear6NormalStateQuant(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetHealthStateQuant.setYear6AttentionStateQuant(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetHealthStateQuant.setYear6UnnormalStateQuant(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetHealthStateQuant.setYear6SeriousStateQuant(structureNodeI.getValueMap().get(5).doubleValue());

				midAssetHealthStateQuant.setCategory(structureNodeI.getNodeName());
				session.save(midAssetHealthStateQuant);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midAssetHealthStateQuant.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetHealthStateQuant
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetHealthStateQuant.setSmallClass("");
				midAssetHealthStateQuant.setVoltageLevel(structureNodeI.getNodeName());
				midAssetHealthStateQuant.setYear1TotalAssetQuantity(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetHealthStateQuant.setYear1NormalStateQuant(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetHealthStateQuant
						.setYear1AttentionStateQuant(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetHealthStateQuant.setYear1UnnormalStateQuant(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetHealthStateQuant.setYear1SeriousStateQuant(structureNodeI.getValueMap().get(30).doubleValue());

				midAssetHealthStateQuant.setYear2TotalAssetQuantity(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetHealthStateQuant.setYear2NormalStateQuant(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetHealthStateQuant
						.setYear2AttentionStateQuant(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetHealthStateQuant.setYear2UnnormalStateQuant(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetHealthStateQuant.setYear2SeriousStateQuant(structureNodeI.getValueMap().get(25).doubleValue());

				midAssetHealthStateQuant.setYear3TotalAssetQuantity(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetHealthStateQuant.setYear3NormalStateQuant(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetHealthStateQuant
						.setYear3AttentionStateQuant(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetHealthStateQuant.setYear3UnnormalStateQuant(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetHealthStateQuant.setYear3SeriousStateQuant(structureNodeI.getValueMap().get(20).doubleValue());

				midAssetHealthStateQuant.setYear4TotalAssetQuantity(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetHealthStateQuant.setYear4NormalStateQuant(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetHealthStateQuant
						.setYear4AttentionStateQuant(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetHealthStateQuant.setYear4UnnormalStateQuant(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetHealthStateQuant.setYear4SeriousStateQuant(structureNodeI.getValueMap().get(15).doubleValue());

				midAssetHealthStateQuant.setYear5TotalAssetQuantity(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetHealthStateQuant.setYear5NormalStateQuant(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetHealthStateQuant.setYear5AttentionStateQuant(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetHealthStateQuant.setYear5UnnormalStateQuant(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetHealthStateQuant.setYear5SeriousStateQuant(structureNodeI.getValueMap().get(10).doubleValue());

				midAssetHealthStateQuant.setYear6TotalAssetQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetHealthStateQuant.setYear6NormalStateQuant(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetHealthStateQuant.setYear6AttentionStateQuant(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetHealthStateQuant.setYear6UnnormalStateQuant(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetHealthStateQuant.setYear6SeriousStateQuant(structureNodeI.getValueMap().get(5).doubleValue());

				midAssetHealthStateQuant
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetHealthStateQuant);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midAssetHealthStateQuant.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midAssetHealthStateQuant.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midAssetHealthStateQuant
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midAssetHealthStateQuant.setVoltageLevel(structureNodeI.getNodeName());
				midAssetHealthStateQuant.setYear1TotalAssetQuantity(structureNodeI.getValueMap().get(26).doubleValue());
				midAssetHealthStateQuant.setYear1NormalStateQuant(structureNodeI.getValueMap().get(27).doubleValue());
				midAssetHealthStateQuant
						.setYear1AttentionStateQuant(structureNodeI.getValueMap().get(28).doubleValue());
				midAssetHealthStateQuant.setYear1UnnormalStateQuant(structureNodeI.getValueMap().get(29).doubleValue());
				midAssetHealthStateQuant.setYear1SeriousStateQuant(structureNodeI.getValueMap().get(30).doubleValue());

				midAssetHealthStateQuant.setYear2TotalAssetQuantity(structureNodeI.getValueMap().get(21).doubleValue());
				midAssetHealthStateQuant.setYear2NormalStateQuant(structureNodeI.getValueMap().get(22).doubleValue());
				midAssetHealthStateQuant
						.setYear2AttentionStateQuant(structureNodeI.getValueMap().get(23).doubleValue());
				midAssetHealthStateQuant.setYear2UnnormalStateQuant(structureNodeI.getValueMap().get(24).doubleValue());
				midAssetHealthStateQuant.setYear2SeriousStateQuant(structureNodeI.getValueMap().get(25).doubleValue());

				midAssetHealthStateQuant.setYear3TotalAssetQuantity(structureNodeI.getValueMap().get(16).doubleValue());
				midAssetHealthStateQuant.setYear3NormalStateQuant(structureNodeI.getValueMap().get(17).doubleValue());
				midAssetHealthStateQuant
						.setYear3AttentionStateQuant(structureNodeI.getValueMap().get(18).doubleValue());
				midAssetHealthStateQuant.setYear3UnnormalStateQuant(structureNodeI.getValueMap().get(19).doubleValue());
				midAssetHealthStateQuant.setYear3SeriousStateQuant(structureNodeI.getValueMap().get(20).doubleValue());

				midAssetHealthStateQuant.setYear4TotalAssetQuantity(structureNodeI.getValueMap().get(11).doubleValue());
				midAssetHealthStateQuant.setYear4NormalStateQuant(structureNodeI.getValueMap().get(12).doubleValue());
				midAssetHealthStateQuant
						.setYear4AttentionStateQuant(structureNodeI.getValueMap().get(13).doubleValue());
				midAssetHealthStateQuant.setYear4UnnormalStateQuant(structureNodeI.getValueMap().get(14).doubleValue());
				midAssetHealthStateQuant.setYear4SeriousStateQuant(structureNodeI.getValueMap().get(15).doubleValue());

				midAssetHealthStateQuant.setYear5TotalAssetQuantity(structureNodeI.getValueMap().get(6).doubleValue());
				midAssetHealthStateQuant.setYear5NormalStateQuant(structureNodeI.getValueMap().get(7).doubleValue());
				midAssetHealthStateQuant.setYear5AttentionStateQuant(structureNodeI.getValueMap().get(8).doubleValue());
				midAssetHealthStateQuant.setYear5UnnormalStateQuant(structureNodeI.getValueMap().get(9).doubleValue());
				midAssetHealthStateQuant.setYear5SeriousStateQuant(structureNodeI.getValueMap().get(10).doubleValue());

				midAssetHealthStateQuant.setYear6TotalAssetQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midAssetHealthStateQuant.setYear6NormalStateQuant(structureNodeI.getValueMap().get(2).doubleValue());
				midAssetHealthStateQuant.setYear6AttentionStateQuant(structureNodeI.getValueMap().get(3).doubleValue());
				midAssetHealthStateQuant.setYear6UnnormalStateQuant(structureNodeI.getValueMap().get(4).doubleValue());
				midAssetHealthStateQuant.setYear6SeriousStateQuant(structureNodeI.getValueMap().get(5).doubleValue());

				midAssetHealthStateQuant
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midAssetHealthStateQuant);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "C.2.5 利用效率-再利用设备数量规模"表的数据的导入 MidResuingAssetScale MID_RESUING_ASSET_SCALE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidResuingAssetScaleImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("C.2.5 利用效率-再利用设备数量规模-结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 5;
		int standardEndRowNumber = 261;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();

		// System.out.println("importFileSheet.getPhysicalNumberOfRows()-1="+(importFileSheet.getPhysicalNumberOfRows()-1)+",endRowNumber"+endRowNumber);
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else { if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 8; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidResuingAssetScale midResuingAssetScale = new MidResuingAssetScale();
			midResuingAssetScale.setVersion(version);

			try {
				midResuingAssetScale.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midResuingAssetScale.setOrgName(orgName);
			try {
				midResuingAssetScale.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midResuingAssetScale.setLargeClass(structureNodeI.getNodeName());
				midResuingAssetScale.setMediumClass("");
				midResuingAssetScale.setSmallClass("");
				midResuingAssetScale.setVoltageLevel("");
				midResuingAssetScale.setInYearProvQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midResuingAssetScale.setInYearProvTechnScale(structureNodeI.getValueMap().get(2).doubleValue());
				midResuingAssetScale.setAccumInProvQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midResuingAssetScale.setAccumInProvTechnScale(structureNodeI.getValueMap().get(4).doubleValue());
				midResuingAssetScale.setInYearBetProvQuantity(structureNodeI.getValueMap().get(5).doubleValue());
				midResuingAssetScale.setInYearBetProvTechnScale(structureNodeI.getValueMap().get(6).doubleValue());
				midResuingAssetScale.setAccumBetProvQuantity(structureNodeI.getValueMap().get(7).doubleValue());
				midResuingAssetScale.setAccumBetProvTechnScale(structureNodeI.getValueMap().get(8).doubleValue());

				midResuingAssetScale.setCategory(structureNodeI.getNodeName());
				session.save(midResuingAssetScale);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midResuingAssetScale
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midResuingAssetScale.setMediumClass(structureNodeI.getNodeName());
				midResuingAssetScale.setSmallClass("");
				midResuingAssetScale.setVoltageLevel("");
				midResuingAssetScale.setInYearProvQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midResuingAssetScale.setInYearProvTechnScale(structureNodeI.getValueMap().get(2).doubleValue());
				midResuingAssetScale.setAccumInProvQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midResuingAssetScale.setAccumInProvTechnScale(structureNodeI.getValueMap().get(4).doubleValue());
				midResuingAssetScale.setInYearBetProvQuantity(structureNodeI.getValueMap().get(5).doubleValue());
				midResuingAssetScale.setInYearBetProvTechnScale(structureNodeI.getValueMap().get(6).doubleValue());
				midResuingAssetScale.setAccumBetProvQuantity(structureNodeI.getValueMap().get(7).doubleValue());
				midResuingAssetScale.setAccumBetProvTechnScale(structureNodeI.getValueMap().get(8).doubleValue());

				midResuingAssetScale.setCategory(structureNodeI.getNodeName());
				session.save(midResuingAssetScale);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midResuingAssetScale.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midResuingAssetScale
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midResuingAssetScale.setSmallClass("");
				midResuingAssetScale.setVoltageLevel(structureNodeI.getNodeName());
				midResuingAssetScale.setInYearProvQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midResuingAssetScale.setInYearProvTechnScale(structureNodeI.getValueMap().get(2).doubleValue());
				midResuingAssetScale.setAccumInProvQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midResuingAssetScale.setAccumInProvTechnScale(structureNodeI.getValueMap().get(4).doubleValue());
				midResuingAssetScale.setInYearBetProvQuantity(structureNodeI.getValueMap().get(5).doubleValue());
				midResuingAssetScale.setInYearBetProvTechnScale(structureNodeI.getValueMap().get(6).doubleValue());
				midResuingAssetScale.setAccumBetProvQuantity(structureNodeI.getValueMap().get(7).doubleValue());
				midResuingAssetScale.setAccumBetProvTechnScale(structureNodeI.getValueMap().get(8).doubleValue());

				midResuingAssetScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midResuingAssetScale);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midResuingAssetScale.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midResuingAssetScale.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midResuingAssetScale
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midResuingAssetScale.setVoltageLevel(structureNodeI.getNodeName());
				midResuingAssetScale.setInYearProvQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midResuingAssetScale.setInYearProvTechnScale(structureNodeI.getValueMap().get(2).doubleValue());
				midResuingAssetScale.setAccumInProvQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midResuingAssetScale.setAccumInProvTechnScale(structureNodeI.getValueMap().get(4).doubleValue());
				midResuingAssetScale.setInYearBetProvQuantity(structureNodeI.getValueMap().get(5).doubleValue());
				midResuingAssetScale.setInYearBetProvTechnScale(structureNodeI.getValueMap().get(6).doubleValue());
				midResuingAssetScale.setAccumBetProvQuantity(structureNodeI.getValueMap().get(7).doubleValue());
				midResuingAssetScale.setAccumBetProvTechnScale(structureNodeI.getValueMap().get(8).doubleValue());

				midResuingAssetScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midResuingAssetScale);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "C.2.6 利用效率-备品备件数量规模"表的数据的导入 MidBackupAssetScale MID_BACKUP_ASSET_SCALE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidBackupAssetScaleImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("C.2.6 利用效率-备品备件数量规模-结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 219;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();

		// System.out.println("importFileSheet.getPhysicalNumberOfRows()-1="+(importFileSheet.getPhysicalNumberOfRows()-1)+",endRowNumber"+endRowNumber);
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else { if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);
		// endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 4; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidBackupAssetScale midBackupAssetScale = new MidBackupAssetScale();
			midBackupAssetScale.setVersion(version);

			try {
				midBackupAssetScale.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midBackupAssetScale.setOrgName(orgName);
			try {
				midBackupAssetScale.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midBackupAssetScale.setLargeClass(structureNodeI.getNodeName());
				midBackupAssetScale.setMediumClass("");
				midBackupAssetScale.setSmallClass("");
				midBackupAssetScale.setVoltageLevel("");
				midBackupAssetScale.setWithin3YearQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midBackupAssetScale.setWithin3YearTechnScale(structureNodeI.getValueMap().get(2).doubleValue());
				midBackupAssetScale.setMoreThan3YearQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midBackupAssetScale.setMoreThan3YearTechnScale(structureNodeI.getValueMap().get(4).doubleValue());

				midBackupAssetScale.setCategory(structureNodeI.getNodeName());
				session.save(midBackupAssetScale);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midBackupAssetScale
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midBackupAssetScale.setMediumClass(structureNodeI.getNodeName());
				midBackupAssetScale.setSmallClass("");
				midBackupAssetScale.setVoltageLevel("");
				midBackupAssetScale.setWithin3YearQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midBackupAssetScale.setWithin3YearTechnScale(structureNodeI.getValueMap().get(2).doubleValue());
				midBackupAssetScale.setMoreThan3YearQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midBackupAssetScale.setMoreThan3YearTechnScale(structureNodeI.getValueMap().get(4).doubleValue());

				midBackupAssetScale.setCategory(structureNodeI.getNodeName());
				session.save(midBackupAssetScale);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midBackupAssetScale.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midBackupAssetScale
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midBackupAssetScale.setSmallClass("");
				midBackupAssetScale.setVoltageLevel(structureNodeI.getNodeName());
				midBackupAssetScale.setWithin3YearQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midBackupAssetScale.setWithin3YearTechnScale(structureNodeI.getValueMap().get(2).doubleValue());
				midBackupAssetScale.setMoreThan3YearQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midBackupAssetScale.setMoreThan3YearTechnScale(structureNodeI.getValueMap().get(4).doubleValue());

				midBackupAssetScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midBackupAssetScale);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midBackupAssetScale.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midBackupAssetScale.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midBackupAssetScale
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midBackupAssetScale.setVoltageLevel(structureNodeI.getNodeName());
				midBackupAssetScale.setWithin3YearQuantity(structureNodeI.getValueMap().get(1).doubleValue());
				midBackupAssetScale.setWithin3YearTechnScale(structureNodeI.getValueMap().get(2).doubleValue());
				midBackupAssetScale.setMoreThan3YearQuantity(structureNodeI.getValueMap().get(3).doubleValue());
				midBackupAssetScale.setMoreThan3YearTechnScale(structureNodeI.getValueMap().get(4).doubleValue());

				midBackupAssetScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midBackupAssetScale);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "D.1 单位新增容量成本"表的数据的导入 MidUnitIncreCapacityCost MID_UNIT_INCRE_CAPACITY_COST
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidUnitIncreCapacityCostImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// System.out.println("fileName"+fileName);
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("D.1 单位新增容量成本-结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 29;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();

		// System.out.println("importFileSheet.getPhysicalNumberOfRows()-1="+(importFileSheet.getPhysicalNumberOfRows()-1)+",endRowNumber"+endRowNumber);
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {

			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}

			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 5; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_ERROR
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {

					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidUnitIncreCapacityCost midUnitIncreCapacityCost = new MidUnitIncreCapacityCost();
			midUnitIncreCapacityCost.setVersion(version);

			try {
				midUnitIncreCapacityCost.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midUnitIncreCapacityCost.setOrgName(orgName);
			try {
				midUnitIncreCapacityCost.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midUnitIncreCapacityCost.setLargeClass(structureNodeI.getNodeName());
				midUnitIncreCapacityCost.setMediumClass("");
				midUnitIncreCapacityCost.setSmallClass("");
				midUnitIncreCapacityCost.setVoltageLevel("");
				midUnitIncreCapacityCost.setYear1Cost(structureNodeI.getValueMap().get(5).doubleValue());
				midUnitIncreCapacityCost.setYear2Cost(structureNodeI.getValueMap().get(4).doubleValue());
				midUnitIncreCapacityCost.setYear3Cost(structureNodeI.getValueMap().get(3).doubleValue());
				midUnitIncreCapacityCost.setYear4Cost(structureNodeI.getValueMap().get(2).doubleValue());
				midUnitIncreCapacityCost.setYear5Cost(structureNodeI.getValueMap().get(1).doubleValue());

				midUnitIncreCapacityCost.setCategory(structureNodeI.getNodeName());
				session.save(midUnitIncreCapacityCost);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midUnitIncreCapacityCost
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midUnitIncreCapacityCost.setMediumClass(structureNodeI.getNodeName());
				midUnitIncreCapacityCost.setSmallClass("");
				midUnitIncreCapacityCost.setVoltageLevel("");
				midUnitIncreCapacityCost.setYear1Cost(structureNodeI.getValueMap().get(5).doubleValue());
				midUnitIncreCapacityCost.setYear2Cost(structureNodeI.getValueMap().get(4).doubleValue());
				midUnitIncreCapacityCost.setYear3Cost(structureNodeI.getValueMap().get(3).doubleValue());
				midUnitIncreCapacityCost.setYear4Cost(structureNodeI.getValueMap().get(2).doubleValue());
				midUnitIncreCapacityCost.setYear5Cost(structureNodeI.getValueMap().get(1).doubleValue());

				midUnitIncreCapacityCost.setCategory(structureNodeI.getNodeName());
				session.save(midUnitIncreCapacityCost);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midUnitIncreCapacityCost.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midUnitIncreCapacityCost
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midUnitIncreCapacityCost.setSmallClass("");
				midUnitIncreCapacityCost.setVoltageLevel(structureNodeI.getNodeName());
				midUnitIncreCapacityCost.setYear1Cost(structureNodeI.getValueMap().get(5).doubleValue());
				midUnitIncreCapacityCost.setYear2Cost(structureNodeI.getValueMap().get(4).doubleValue());
				midUnitIncreCapacityCost.setYear3Cost(structureNodeI.getValueMap().get(3).doubleValue());
				midUnitIncreCapacityCost.setYear4Cost(structureNodeI.getValueMap().get(2).doubleValue());
				midUnitIncreCapacityCost.setYear5Cost(structureNodeI.getValueMap().get(1).doubleValue());

				midUnitIncreCapacityCost
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midUnitIncreCapacityCost);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midUnitIncreCapacityCost.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midUnitIncreCapacityCost.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midUnitIncreCapacityCost
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midUnitIncreCapacityCost.setVoltageLevel(structureNodeI.getNodeName());
				midUnitIncreCapacityCost.setYear1Cost(structureNodeI.getValueMap().get(5).doubleValue());
				midUnitIncreCapacityCost.setYear2Cost(structureNodeI.getValueMap().get(4).doubleValue());
				midUnitIncreCapacityCost.setYear3Cost(structureNodeI.getValueMap().get(3).doubleValue());
				midUnitIncreCapacityCost.setYear4Cost(structureNodeI.getValueMap().get(2).doubleValue());
				midUnitIncreCapacityCost.setYear5Cost(structureNodeI.getValueMap().get(1).doubleValue());

				midUnitIncreCapacityCost
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midUnitIncreCapacityCost);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "C.2.6 利用效率-备品备件数量规模"表的数据的导入 MidDepreciationCost MID_DEPRECIATION_COST
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidDepreciationCostImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("D.4 折旧成本结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 54;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();

		// System.out.println("importFileSheet.getPhysicalNumberOfRows()-1="+(importFileSheet.getPhysicalNumberOfRows()-1)+",endRowNumber"+endRowNumber);
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {

			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}

			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));
			for (int colI = 1; colI <= 5; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidDepreciationCost midDepreciationCost = new MidDepreciationCost();
			midDepreciationCost.setVersion(version);

			try {
				midDepreciationCost.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midDepreciationCost.setOrgName(orgName);
			try {
				midDepreciationCost.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midDepreciationCost.setLargeClass(structureNodeI.getNodeName().trim());
				midDepreciationCost.setMediumClass("");
				midDepreciationCost.setSmallClass("");
				midDepreciationCost.setVoltageLevel("");
				midDepreciationCost.setYear1DeprecCost(structureNodeI.getValueMap().get(5).doubleValue());
				midDepreciationCost.setYear2DeprecCost(structureNodeI.getValueMap().get(4).doubleValue());
				midDepreciationCost.setYear3DeprecCost(structureNodeI.getValueMap().get(3).doubleValue());
				midDepreciationCost.setYear4DeprecCost(structureNodeI.getValueMap().get(2).doubleValue());
				midDepreciationCost.setYear5DeprecCost(structureNodeI.getValueMap().get(1).doubleValue());

				midDepreciationCost.setCategory(structureNodeI.getNodeName().trim());
				session.save(midDepreciationCost);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midDepreciationCost.setLargeClass(
						structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName().trim());
				midDepreciationCost.setMediumClass(structureNodeI.getNodeName().trim());
				midDepreciationCost.setSmallClass("");
				midDepreciationCost.setVoltageLevel("");
				midDepreciationCost.setYear1DeprecCost(structureNodeI.getValueMap().get(5).doubleValue());
				midDepreciationCost.setYear2DeprecCost(structureNodeI.getValueMap().get(4).doubleValue());
				midDepreciationCost.setYear3DeprecCost(structureNodeI.getValueMap().get(3).doubleValue());
				midDepreciationCost.setYear4DeprecCost(structureNodeI.getValueMap().get(2).doubleValue());
				midDepreciationCost.setYear5DeprecCost(structureNodeI.getValueMap().get(1).doubleValue());

				midDepreciationCost.setCategory(structureNodeI.getNodeName().trim());
				session.save(midDepreciationCost);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList.get(structureNodeI.getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类有值，而中类、小类无取值的行。
				 */
				midDepreciationCost.setLargeClass(
						structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName().trim());
				midDepreciationCost.setMediumClass("");
				midDepreciationCost.setSmallClass("");
				midDepreciationCost.setVoltageLevel(structureNodeI.getNodeName().trim());
				midDepreciationCost.setYear1DeprecCost(structureNodeI.getValueMap().get(5).doubleValue());
				midDepreciationCost.setYear2DeprecCost(structureNodeI.getValueMap().get(4).doubleValue());
				midDepreciationCost.setYear3DeprecCost(structureNodeI.getValueMap().get(3).doubleValue());
				midDepreciationCost.setYear4DeprecCost(structureNodeI.getValueMap().get(2).doubleValue());
				midDepreciationCost.setYear5DeprecCost(structureNodeI.getValueMap().get(1).doubleValue());
				midDepreciationCost
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName().trim());
				session.save(midDepreciationCost);
			} else if (structureNodeI.isLeaf() == true
					&& (structureNodeI.getNodeName().contains("kV")
							|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）"))
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midDepreciationCost.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName().trim());
				midDepreciationCost.setMediumClass(
						structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName().trim());
				midDepreciationCost.setSmallClass("");
				midDepreciationCost.setVoltageLevel(structureNodeI.getNodeName().trim());
				midDepreciationCost.setYear1DeprecCost(structureNodeI.getValueMap().get(5).doubleValue());
				midDepreciationCost.setYear2DeprecCost(structureNodeI.getValueMap().get(4).doubleValue());
				midDepreciationCost.setYear3DeprecCost(structureNodeI.getValueMap().get(3).doubleValue());
				midDepreciationCost.setYear4DeprecCost(structureNodeI.getValueMap().get(2).doubleValue());
				midDepreciationCost.setYear5DeprecCost(structureNodeI.getValueMap().get(1).doubleValue());
				midDepreciationCost
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName().trim());
				session.save(midDepreciationCost);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midDepreciationCost.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName().trim());
				midDepreciationCost.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName().trim());
				midDepreciationCost.setSmallClass(
						structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName().trim());
				midDepreciationCost.setVoltageLevel(structureNodeI.getNodeName().trim());
				midDepreciationCost.setYear1DeprecCost(structureNodeI.getValueMap().get(5).doubleValue());
				midDepreciationCost.setYear2DeprecCost(structureNodeI.getValueMap().get(4).doubleValue());
				midDepreciationCost.setYear3DeprecCost(structureNodeI.getValueMap().get(3).doubleValue());
				midDepreciationCost.setYear4DeprecCost(structureNodeI.getValueMap().get(2).doubleValue());
				midDepreciationCost.setYear5DeprecCost(structureNodeI.getValueMap().get(1).doubleValue());

				midDepreciationCost
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName().trim());
				session.save(midDepreciationCost);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "C.2.7 资产退役-资产报废按年份"表的数据的导入 MidDiscardAssetYearScale
	 * MID_DISCARD_ASSET_YEAR_SCALE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidDiscardAssetYearScaleImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();
		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("C.2.7 资产退役-资产报废按年份-结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 4;
		int standardEndRowNumber = 398;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();

		String valueType = sheetEndRow1.getCell(1).getStringCellValue();
		// System.out.println("valueType="+valueType);
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			endStructureNodeValueMap.put(3, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(3) == null) {
				endStructureNodeValueMap.put(3, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(3, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(3, new
				// BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(3, new BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(3, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(4);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		// endStructureNode.setValueMap(endStructureNodeValueMap);
		if (valueType.contentEquals("资产原值")) {
			endStructureNodeValueMap.put(1, new BigDecimal(1.0));
		} else if (valueType.contentEquals("设备数量")) {
			endStructureNodeValueMap.put(1, new BigDecimal(2.0));
		}

		endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));

			valueType = structureNodeRow1.getCell(1).getStringCellValue();
			// System.out.println("valueType=" + valueType);
			if (valueType.contentEquals("资产原值")) {
				structureNodeValueMap.put(1, new BigDecimal(1.0));
			} else if (valueType.contentEquals("设备数量")) {
				structureNodeValueMap.put(1, new BigDecimal(2.0));
			}
			// System.out.println("structureNodeValueMap.get(1)=" +
			// structureNodeValueMap.get(1));
			for (int colI = 2; colI <= 7; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(3)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidDiscardAssetYearScale midDiscardAssetYearScale = new MidDiscardAssetYearScale();
			midDiscardAssetYearScale.setVersion(version);

			try {
				midDiscardAssetYearScale.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midDiscardAssetYearScale.setOrgName(orgName);
			try {
				midDiscardAssetYearScale.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midDiscardAssetYearScale.setLargeClass(structureNodeI.getNodeName());
				midDiscardAssetYearScale.setMediumClass("");
				midDiscardAssetYearScale.setSmallClass("");
				midDiscardAssetYearScale.setVoltageLevel("");
				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardAssetYearScale.setOrigValue6Years(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardAssetYearScale.setOrigValue5Years(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardAssetYearScale.setOrigValue4Years(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardAssetYearScale.setOrigValue3Years(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardAssetYearScale.setOrigValue2Years(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardAssetYearScale.setOrigValue1Years(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardAssetYearScale.setQuantity6Years(0.0);
					midDiscardAssetYearScale.setQuantity5Years(0.0);
					midDiscardAssetYearScale.setQuantity4Years(0.0);
					midDiscardAssetYearScale.setQuantity3Years(0.0);
					midDiscardAssetYearScale.setQuantity2Years(0.0);
					midDiscardAssetYearScale.setQuantity1Years(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardAssetYearScale.setOrigValue6Years(0.0);
					midDiscardAssetYearScale.setOrigValue5Years(0.0);
					midDiscardAssetYearScale.setOrigValue4Years(0.0);
					midDiscardAssetYearScale.setOrigValue3Years(0.0);
					midDiscardAssetYearScale.setOrigValue2Years(0.0);
					midDiscardAssetYearScale.setOrigValue1Years(0.0);
					midDiscardAssetYearScale.setQuantity6Years(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardAssetYearScale.setQuantity5Years(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardAssetYearScale.setQuantity4Years(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardAssetYearScale.setQuantity3Years(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardAssetYearScale.setQuantity2Years(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardAssetYearScale.setQuantity1Years(structureNodeI.getValueMap().get(7).doubleValue());
				}

				midDiscardAssetYearScale.setCategory(structureNodeI.getNodeName());
				session.save(midDiscardAssetYearScale);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midDiscardAssetYearScale
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardAssetYearScale.setMediumClass(structureNodeI.getNodeName());
				midDiscardAssetYearScale.setSmallClass("");
				midDiscardAssetYearScale.setVoltageLevel("");
				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardAssetYearScale.setOrigValue6Years(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardAssetYearScale.setOrigValue5Years(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardAssetYearScale.setOrigValue4Years(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardAssetYearScale.setOrigValue3Years(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardAssetYearScale.setOrigValue2Years(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardAssetYearScale.setOrigValue1Years(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardAssetYearScale.setQuantity6Years(0.0);
					midDiscardAssetYearScale.setQuantity5Years(0.0);
					midDiscardAssetYearScale.setQuantity4Years(0.0);
					midDiscardAssetYearScale.setQuantity3Years(0.0);
					midDiscardAssetYearScale.setQuantity2Years(0.0);
					midDiscardAssetYearScale.setQuantity1Years(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardAssetYearScale.setOrigValue6Years(0.0);
					midDiscardAssetYearScale.setOrigValue5Years(0.0);
					midDiscardAssetYearScale.setOrigValue4Years(0.0);
					midDiscardAssetYearScale.setOrigValue3Years(0.0);
					midDiscardAssetYearScale.setOrigValue2Years(0.0);
					midDiscardAssetYearScale.setOrigValue1Years(0.0);
					midDiscardAssetYearScale.setQuantity6Years(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardAssetYearScale.setQuantity5Years(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardAssetYearScale.setQuantity4Years(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardAssetYearScale.setQuantity3Years(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardAssetYearScale.setQuantity2Years(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardAssetYearScale.setQuantity1Years(structureNodeI.getValueMap().get(7).doubleValue());
				}

				midDiscardAssetYearScale.setCategory(structureNodeI.getNodeName());
				session.save(midDiscardAssetYearScale);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midDiscardAssetYearScale.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midDiscardAssetYearScale
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardAssetYearScale.setSmallClass("");
				midDiscardAssetYearScale.setVoltageLevel(structureNodeI.getNodeName());
				// System.out.println("structureNodeI.getValueMap().get(1).doubleValue()="
				// + structureNodeI.getValueMap().get(1).doubleValue());
				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardAssetYearScale.setOrigValue6Years(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardAssetYearScale.setOrigValue5Years(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardAssetYearScale.setOrigValue4Years(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardAssetYearScale.setOrigValue3Years(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardAssetYearScale.setOrigValue2Years(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardAssetYearScale.setOrigValue1Years(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardAssetYearScale.setQuantity6Years(0.0);
					midDiscardAssetYearScale.setQuantity5Years(0.0);
					midDiscardAssetYearScale.setQuantity4Years(0.0);
					midDiscardAssetYearScale.setQuantity3Years(0.0);
					midDiscardAssetYearScale.setQuantity2Years(0.0);
					midDiscardAssetYearScale.setQuantity1Years(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardAssetYearScale.setOrigValue6Years(0.0);
					midDiscardAssetYearScale.setOrigValue5Years(0.0);
					midDiscardAssetYearScale.setOrigValue4Years(0.0);
					midDiscardAssetYearScale.setOrigValue3Years(0.0);
					midDiscardAssetYearScale.setOrigValue2Years(0.0);
					midDiscardAssetYearScale.setOrigValue1Years(0.0);
					midDiscardAssetYearScale.setQuantity6Years(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardAssetYearScale.setQuantity5Years(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardAssetYearScale.setQuantity4Years(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardAssetYearScale.setQuantity3Years(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardAssetYearScale.setQuantity2Years(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardAssetYearScale.setQuantity1Years(structureNodeI.getValueMap().get(7).doubleValue());
				}

				midDiscardAssetYearScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midDiscardAssetYearScale);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midDiscardAssetYearScale.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midDiscardAssetYearScale.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midDiscardAssetYearScale
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardAssetYearScale.setVoltageLevel(structureNodeI.getNodeName());
				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardAssetYearScale.setOrigValue6Years(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardAssetYearScale.setOrigValue5Years(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardAssetYearScale.setOrigValue4Years(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardAssetYearScale.setOrigValue3Years(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardAssetYearScale.setOrigValue2Years(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardAssetYearScale.setOrigValue1Years(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardAssetYearScale.setQuantity6Years(0.0);
					midDiscardAssetYearScale.setQuantity5Years(0.0);
					midDiscardAssetYearScale.setQuantity4Years(0.0);
					midDiscardAssetYearScale.setQuantity3Years(0.0);
					midDiscardAssetYearScale.setQuantity2Years(0.0);
					midDiscardAssetYearScale.setQuantity1Years(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardAssetYearScale.setOrigValue6Years(0.0);
					midDiscardAssetYearScale.setOrigValue5Years(0.0);
					midDiscardAssetYearScale.setOrigValue4Years(0.0);
					midDiscardAssetYearScale.setOrigValue3Years(0.0);
					midDiscardAssetYearScale.setOrigValue2Years(0.0);
					midDiscardAssetYearScale.setOrigValue1Years(0.0);
					midDiscardAssetYearScale.setQuantity6Years(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardAssetYearScale.setQuantity5Years(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardAssetYearScale.setQuantity4Years(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardAssetYearScale.setQuantity3Years(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardAssetYearScale.setQuantity2Years(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardAssetYearScale.setQuantity1Years(structureNodeI.getValueMap().get(7).doubleValue());
				}

				midDiscardAssetYearScale
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midDiscardAssetYearScale);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "C.2.7.1 资产退役-资产报废按成因"表的数据的导入 MidDiscardProjectDistribute
	 * MID_DISCARD_PROJECT_DISTRIBUTE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidDiscardProjectDistributeImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("C.2.7.1 资产退役-资产报废按成因-结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 5;
		int standardEndRowNumber = 596;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(2, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(3, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(3).getCellType() ==
		 * sheetEndRow1.getCell(3).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(3).getCellType() ==
		 * sheetEndRow1.getCell(3).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(3,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(3, new
		 * BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			endStructureNodeValueMap.put(3, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(3) == null) {
				endStructureNodeValueMap.put(3, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(3, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(3, new
				// BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(3, new BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(3, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(4);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		// endStructureNode.setValueMap(endStructureNodeValueMap);
		String valueType = sheetEndRow1.getCell(1).getStringCellValue();
		// System.out.println("valueType="+valueType);
		if (valueType.contentEquals("资产原值")) {
			endStructureNodeValueMap.put(1, new BigDecimal(1.0));
		} else if (valueType.contentEquals("设备数量")) {
			endStructureNodeValueMap.put(1, new BigDecimal(2.0));
		} else if (valueType.contentEquals("资产净值")) {
			endStructureNodeValueMap.put(1, new BigDecimal(3.0));
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));

			valueType = structureNodeRow1.getCell(1).getStringCellValue();
			// System.out.println("valueType=" + valueType);
			if (valueType.contentEquals("资产原值")) {
				structureNodeValueMap.put(1, new BigDecimal(1.0));
			} else if (valueType.contentEquals("设备数量")) {
				structureNodeValueMap.put(1, new BigDecimal(2.0));
			} else if (valueType.contentEquals("资产净值")) {
				structureNodeValueMap.put(1, new BigDecimal(3.0));
			}
			// System.out.println("structureNodeValueMap.get(1)=" +
			// structureNodeValueMap.get(1));
			for (int colI = 2; colI <= 5; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}
				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(3)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidDiscardProjectDistribute midDiscardProjectDistribute = new MidDiscardProjectDistribute();
			midDiscardProjectDistribute.setVersion(version);

			try {
				midDiscardProjectDistribute.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midDiscardProjectDistribute.setOrgName(orgName);
			try {
				midDiscardProjectDistribute.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midDiscardProjectDistribute.setLargeClass(structureNodeI.getNodeName());
				midDiscardProjectDistribute.setMediumClass("");
				midDiscardProjectDistribute.setSmallClass("");
				midDiscardProjectDistribute.setVoltageLevel("");
				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardProjectDistribute.setOrigValueProject1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardProjectDistribute.setOrigValueProject2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardProjectDistribute.setOrigValueProject3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardProjectDistribute.setOrigValueProject4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardProjectDistribute.setNetValueProject1(0.0);
					midDiscardProjectDistribute.setNetValueProject2(0.0);
					midDiscardProjectDistribute.setNetValueProject3(0.0);
					midDiscardProjectDistribute.setNetValueProject4(0.0);
					midDiscardProjectDistribute.setQuantityProject1(0.0);
					midDiscardProjectDistribute.setQuantityProject2(0.0);
					midDiscardProjectDistribute.setQuantityProject3(0.0);
					midDiscardProjectDistribute.setQuantityProject4(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardProjectDistribute.setOrigValueProject1(0.0);
					midDiscardProjectDistribute.setOrigValueProject2(0.0);
					midDiscardProjectDistribute.setOrigValueProject3(0.0);
					midDiscardProjectDistribute.setOrigValueProject4(0.0);
					midDiscardProjectDistribute.setNetValueProject1(0.0);
					midDiscardProjectDistribute.setNetValueProject2(0.0);
					midDiscardProjectDistribute.setNetValueProject3(0.0);
					midDiscardProjectDistribute.setNetValueProject4(0.0);
					midDiscardProjectDistribute.setQuantityProject1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardProjectDistribute.setQuantityProject2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardProjectDistribute.setQuantityProject3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardProjectDistribute.setQuantityProject4(structureNodeI.getValueMap().get(5).doubleValue());
				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardProjectDistribute.setOrigValueProject1(0.0);
					midDiscardProjectDistribute.setOrigValueProject2(0.0);
					midDiscardProjectDistribute.setOrigValueProject3(0.0);
					midDiscardProjectDistribute.setOrigValueProject4(0.0);
					midDiscardProjectDistribute.setNetValueProject1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardProjectDistribute.setNetValueProject2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardProjectDistribute.setNetValueProject3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardProjectDistribute.setNetValueProject4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardProjectDistribute.setQuantityProject1(0.0);
					midDiscardProjectDistribute.setQuantityProject2(0.0);
					midDiscardProjectDistribute.setQuantityProject3(0.0);
					midDiscardProjectDistribute.setQuantityProject4(0.0);
				}

				midDiscardProjectDistribute.setCategory(structureNodeI.getNodeName());
				session.save(midDiscardProjectDistribute);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midDiscardProjectDistribute
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardProjectDistribute.setMediumClass(structureNodeI.getNodeName());
				midDiscardProjectDistribute.setSmallClass("");
				midDiscardProjectDistribute.setVoltageLevel("");
				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardProjectDistribute.setOrigValueProject1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardProjectDistribute.setOrigValueProject2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardProjectDistribute.setOrigValueProject3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardProjectDistribute.setOrigValueProject4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardProjectDistribute.setNetValueProject1(0.0);
					midDiscardProjectDistribute.setNetValueProject2(0.0);
					midDiscardProjectDistribute.setNetValueProject3(0.0);
					midDiscardProjectDistribute.setNetValueProject4(0.0);
					midDiscardProjectDistribute.setQuantityProject1(0.0);
					midDiscardProjectDistribute.setQuantityProject2(0.0);
					midDiscardProjectDistribute.setQuantityProject3(0.0);
					midDiscardProjectDistribute.setQuantityProject4(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardProjectDistribute.setOrigValueProject1(0.0);
					midDiscardProjectDistribute.setOrigValueProject2(0.0);
					midDiscardProjectDistribute.setOrigValueProject3(0.0);
					midDiscardProjectDistribute.setOrigValueProject4(0.0);
					midDiscardProjectDistribute.setNetValueProject1(0.0);
					midDiscardProjectDistribute.setNetValueProject2(0.0);
					midDiscardProjectDistribute.setNetValueProject3(0.0);
					midDiscardProjectDistribute.setNetValueProject4(0.0);
					midDiscardProjectDistribute.setQuantityProject1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardProjectDistribute.setQuantityProject2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardProjectDistribute.setQuantityProject3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardProjectDistribute.setQuantityProject4(structureNodeI.getValueMap().get(5).doubleValue());
				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardProjectDistribute.setOrigValueProject1(0.0);
					midDiscardProjectDistribute.setOrigValueProject2(0.0);
					midDiscardProjectDistribute.setOrigValueProject3(0.0);
					midDiscardProjectDistribute.setOrigValueProject4(0.0);
					midDiscardProjectDistribute.setNetValueProject1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardProjectDistribute.setNetValueProject2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardProjectDistribute.setNetValueProject3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardProjectDistribute.setNetValueProject4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardProjectDistribute.setQuantityProject1(0.0);
					midDiscardProjectDistribute.setQuantityProject2(0.0);
					midDiscardProjectDistribute.setQuantityProject3(0.0);
					midDiscardProjectDistribute.setQuantityProject4(0.0);
				}

				midDiscardProjectDistribute.setCategory(structureNodeI.getNodeName());
				session.save(midDiscardProjectDistribute);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midDiscardProjectDistribute.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midDiscardProjectDistribute
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardProjectDistribute.setSmallClass("");
				midDiscardProjectDistribute.setVoltageLevel(structureNodeI.getNodeName());

				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardProjectDistribute.setOrigValueProject1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardProjectDistribute.setOrigValueProject2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardProjectDistribute.setOrigValueProject3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardProjectDistribute.setOrigValueProject4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardProjectDistribute.setNetValueProject1(0.0);
					midDiscardProjectDistribute.setNetValueProject2(0.0);
					midDiscardProjectDistribute.setNetValueProject3(0.0);
					midDiscardProjectDistribute.setNetValueProject4(0.0);
					midDiscardProjectDistribute.setQuantityProject1(0.0);
					midDiscardProjectDistribute.setQuantityProject2(0.0);
					midDiscardProjectDistribute.setQuantityProject3(0.0);
					midDiscardProjectDistribute.setQuantityProject4(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardProjectDistribute.setOrigValueProject1(0.0);
					midDiscardProjectDistribute.setOrigValueProject2(0.0);
					midDiscardProjectDistribute.setOrigValueProject3(0.0);
					midDiscardProjectDistribute.setOrigValueProject4(0.0);
					midDiscardProjectDistribute.setNetValueProject1(0.0);
					midDiscardProjectDistribute.setNetValueProject2(0.0);
					midDiscardProjectDistribute.setNetValueProject3(0.0);
					midDiscardProjectDistribute.setNetValueProject4(0.0);
					midDiscardProjectDistribute.setQuantityProject1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardProjectDistribute.setQuantityProject2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardProjectDistribute.setQuantityProject3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardProjectDistribute.setQuantityProject4(structureNodeI.getValueMap().get(5).doubleValue());
				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardProjectDistribute.setOrigValueProject1(0.0);
					midDiscardProjectDistribute.setOrigValueProject2(0.0);
					midDiscardProjectDistribute.setOrigValueProject3(0.0);
					midDiscardProjectDistribute.setOrigValueProject4(0.0);
					midDiscardProjectDistribute.setNetValueProject1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardProjectDistribute.setNetValueProject2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardProjectDistribute.setNetValueProject3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardProjectDistribute.setNetValueProject4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardProjectDistribute.setQuantityProject1(0.0);
					midDiscardProjectDistribute.setQuantityProject2(0.0);
					midDiscardProjectDistribute.setQuantityProject3(0.0);
					midDiscardProjectDistribute.setQuantityProject4(0.0);
				}

				midDiscardProjectDistribute
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midDiscardProjectDistribute);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midDiscardProjectDistribute.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midDiscardProjectDistribute.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midDiscardProjectDistribute
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardProjectDistribute.setVoltageLevel(structureNodeI.getNodeName());
				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardProjectDistribute.setOrigValueProject1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardProjectDistribute.setOrigValueProject2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardProjectDistribute.setOrigValueProject3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardProjectDistribute.setOrigValueProject4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardProjectDistribute.setNetValueProject1(0.0);
					midDiscardProjectDistribute.setNetValueProject2(0.0);
					midDiscardProjectDistribute.setNetValueProject3(0.0);
					midDiscardProjectDistribute.setNetValueProject4(0.0);
					midDiscardProjectDistribute.setQuantityProject1(0.0);
					midDiscardProjectDistribute.setQuantityProject2(0.0);
					midDiscardProjectDistribute.setQuantityProject3(0.0);
					midDiscardProjectDistribute.setQuantityProject4(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardProjectDistribute.setOrigValueProject1(0.0);
					midDiscardProjectDistribute.setOrigValueProject2(0.0);
					midDiscardProjectDistribute.setOrigValueProject3(0.0);
					midDiscardProjectDistribute.setOrigValueProject4(0.0);
					midDiscardProjectDistribute.setNetValueProject1(0.0);
					midDiscardProjectDistribute.setNetValueProject2(0.0);
					midDiscardProjectDistribute.setNetValueProject3(0.0);
					midDiscardProjectDistribute.setNetValueProject4(0.0);
					midDiscardProjectDistribute.setQuantityProject1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardProjectDistribute.setQuantityProject2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardProjectDistribute.setQuantityProject3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardProjectDistribute.setQuantityProject4(structureNodeI.getValueMap().get(5).doubleValue());
				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardProjectDistribute.setOrigValueProject1(0.0);
					midDiscardProjectDistribute.setOrigValueProject2(0.0);
					midDiscardProjectDistribute.setOrigValueProject3(0.0);
					midDiscardProjectDistribute.setOrigValueProject4(0.0);
					midDiscardProjectDistribute.setNetValueProject1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardProjectDistribute.setNetValueProject2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardProjectDistribute.setNetValueProject3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardProjectDistribute.setNetValueProject4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardProjectDistribute.setQuantityProject1(0.0);
					midDiscardProjectDistribute.setQuantityProject2(0.0);
					midDiscardProjectDistribute.setQuantityProject3(0.0);
					midDiscardProjectDistribute.setQuantityProject4(0.0);
				}

				midDiscardProjectDistribute
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midDiscardProjectDistribute);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "C.2.7.1 资产退役-资产报废按成因"表的数据的导入 MidDiscardReasonDistribute
	 * MID_DISCARD_REASON_DISTRIBUTE
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidDiscardReasonDistributeImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("C.2.7.1 资产退役-资产报废按成因-结构模板");
		// importFileSheet = fileWorkbook.getSheet(sheetName);
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}
		int standardStartRowNumber = 5;
		int standardEndRowNumber = 596;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(2, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(3, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(3).getCellType() ==
		 * sheetEndRow1.getCell(3).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(3).getCellType() ==
		 * sheetEndRow1.getCell(3).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(3,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(3, new
		 * BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			endStructureNodeValueMap.put(3, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(3) == null) {
				endStructureNodeValueMap.put(3, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(3, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(3, new
				// BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(3, new BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(3, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(4);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		// endStructureNode.setValueMap(endStructureNodeValueMap);
		String valueType = sheetEndRow1.getCell(1).getStringCellValue();
		// System.out.println("valueType="+valueType);
		if (valueType.contentEquals("资产原值")) {
			endStructureNodeValueMap.put(1, new BigDecimal(1.0));
		} else if (valueType.contentEquals("设备数量")) {
			endStructureNodeValueMap.put(1, new BigDecimal(2.0));
		} else if (valueType.contentEquals("资产净值")) {
			endStructureNodeValueMap.put(1, new BigDecimal(3.0));
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));

			valueType = structureNodeRow1.getCell(1).getStringCellValue();
			// System.out.println("valueType="+valueType);
			if (valueType.contentEquals("资产原值")) {
				structureNodeValueMap.put(1, new BigDecimal(1.0));
			} else if (valueType.contentEquals("设备数量")) {
				structureNodeValueMap.put(1, new BigDecimal(2.0));
			} else if (valueType.contentEquals("资产净值")) {
				structureNodeValueMap.put(1, new BigDecimal(3.0));
			}
			// System.out.println("structureNodeValueMap.get(1)=" +
			// structureNodeValueMap.get(1));
			for (int colI = 2; colI <= 9; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}
				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(3)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidDiscardReasonDistribute midDiscardReasonDistribute = new MidDiscardReasonDistribute();
			midDiscardReasonDistribute.setVersion(version);

			try {
				midDiscardReasonDistribute.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midDiscardReasonDistribute.setOrgName(orgName);
			try {
				midDiscardReasonDistribute.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midDiscardReasonDistribute.setLargeClass(structureNodeI.getNodeName());
				midDiscardReasonDistribute.setMediumClass("");
				midDiscardReasonDistribute.setSmallClass("");
				midDiscardReasonDistribute.setVoltageLevel("");
				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardReasonDistribute
							.setOrigValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());
					midDiscardReasonDistribute.setQuantityDiscardReason1(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason2(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason3(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason4(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason5(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason6(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason7(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason8(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardReasonDistribute.setOrigValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason8(0.0);
					midDiscardReasonDistribute
							.setQuantityDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());
					midDiscardReasonDistribute.setNetValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardReasonDistribute.setOrigValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason8(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason1(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason2(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason3(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason4(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason5(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason6(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason7(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason8(0.0);
					midDiscardReasonDistribute
							.setNetValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

				}

				midDiscardReasonDistribute.setCategory(structureNodeI.getNodeName());
				session.save(midDiscardReasonDistribute);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midDiscardReasonDistribute
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardReasonDistribute.setMediumClass(structureNodeI.getNodeName());
				midDiscardReasonDistribute.setSmallClass("");
				midDiscardReasonDistribute.setVoltageLevel("");

				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardReasonDistribute
							.setOrigValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());
					midDiscardReasonDistribute.setQuantityDiscardReason1(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason2(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason3(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason4(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason5(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason6(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason7(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason8(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardReasonDistribute.setOrigValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason8(0.0);
					midDiscardReasonDistribute
							.setQuantityDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());
					midDiscardReasonDistribute.setNetValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardReasonDistribute.setOrigValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason8(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason1(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason2(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason3(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason4(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason5(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason6(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason7(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason8(0.0);
					midDiscardReasonDistribute
							.setNetValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

				}

				midDiscardReasonDistribute.setCategory(structureNodeI.getNodeName());
				session.save(midDiscardReasonDistribute);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midDiscardReasonDistribute.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midDiscardReasonDistribute
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardReasonDistribute.setSmallClass("");
				midDiscardReasonDistribute.setVoltageLevel(structureNodeI.getNodeName());

				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardReasonDistribute
							.setOrigValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());
					midDiscardReasonDistribute.setQuantityDiscardReason1(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason2(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason3(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason4(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason5(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason6(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason7(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason8(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardReasonDistribute.setOrigValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason8(0.0);
					midDiscardReasonDistribute
							.setQuantityDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());
					midDiscardReasonDistribute.setNetValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardReasonDistribute.setOrigValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason8(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason1(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason2(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason3(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason4(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason5(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason6(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason7(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason8(0.0);
					midDiscardReasonDistribute
							.setNetValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

				}

				midDiscardReasonDistribute
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midDiscardReasonDistribute);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midDiscardReasonDistribute.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midDiscardReasonDistribute.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midDiscardReasonDistribute
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardReasonDistribute.setVoltageLevel(structureNodeI.getNodeName());

				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardReasonDistribute
							.setOrigValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasonDistribute
							.setOrigValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());
					midDiscardReasonDistribute.setQuantityDiscardReason1(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason2(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason3(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason4(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason5(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason6(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason7(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason8(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardReasonDistribute.setOrigValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason8(0.0);
					midDiscardReasonDistribute
							.setQuantityDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasonDistribute
							.setQuantityDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());
					midDiscardReasonDistribute.setNetValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setNetValueDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardReasonDistribute.setOrigValueDiscardReason1(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason2(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason3(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason4(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason5(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason6(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason7(0.0);
					midDiscardReasonDistribute.setOrigValueDiscardReason8(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason1(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason2(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason3(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason4(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason5(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason6(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason7(0.0);
					midDiscardReasonDistribute.setQuantityDiscardReason8(0.0);
					midDiscardReasonDistribute
							.setNetValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasonDistribute
							.setNetValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

				}

				midDiscardReasonDistribute
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midDiscardReasonDistribute);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "C.2.7.2 资产退役-报废按成因 (成新率5%以上资产)"表的数据的导入 MidDiscardReasDistEqu5
	 * MID_DISCARD_REAS_DIST_EQU_5
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidDiscardReasDistEqu5Import(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("C.2.7.1 资产退役-资产报废按成因-结构模板");

		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}

		int standardStartRowNumber = 5;
		int standardEndRowNumber = 596;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(2, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(3, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(3).getCellType() ==
		 * sheetEndRow1.getCell(3).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(3).getCellType() ==
		 * sheetEndRow1.getCell(3).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(3,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(3, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			endStructureNodeValueMap.put(3, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(3) == null) {
				endStructureNodeValueMap.put(3, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(3, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(3, new
				// BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(3, new BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(3, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(4);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		// endStructureNode.setValueMap(endStructureNodeValueMap);
		String valueType = sheetEndRow1.getCell(1).getStringCellValue();
		// System.out.println("valueType="+valueType);
		if (valueType.contentEquals("资产原值")) {
			endStructureNodeValueMap.put(1, new BigDecimal(1.0));
		} else if (valueType.contentEquals("设备数量")) {
			endStructureNodeValueMap.put(1, new BigDecimal(2.0));
		} else if (valueType.contentEquals("资产净值")) {
			endStructureNodeValueMap.put(1, new BigDecimal(3.0));
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));

			valueType = structureNodeRow1.getCell(1).getStringCellValue();
			// System.out.println("valueType="+valueType);
			if (valueType.contentEquals("资产原值")) {
				structureNodeValueMap.put(1, new BigDecimal(1.0));
			} else if (valueType.contentEquals("设备数量")) {
				structureNodeValueMap.put(1, new BigDecimal(2.0));
			} else if (valueType.contentEquals("资产净值")) {
				structureNodeValueMap.put(1, new BigDecimal(3.0));
			}
			// System.out.println("structureNodeValueMap.get(1)=" +
			// structureNodeValueMap.get(1));
			for (int colI = 2; colI <= 9; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;

					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception

						OutputStream out = null;

						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}

					}
				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(3)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidDiscardReasDistEqu5 midDiscardReasDistEqu5 = new MidDiscardReasDistEqu5();
			midDiscardReasDistEqu5.setVersion(version);

			try {
				midDiscardReasDistEqu5.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midDiscardReasDistEqu5.setOrgName(orgName);
			try {
				midDiscardReasDistEqu5.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midDiscardReasDistEqu5.setLargeClass(structureNodeI.getNodeName());
				midDiscardReasDistEqu5.setMediumClass("");
				midDiscardReasDistEqu5.setSmallClass("");
				midDiscardReasDistEqu5.setVoltageLevel("");
				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu5.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardReasDistEqu5.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setQuantityDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardReasDistEqu5.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setNetValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu5.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason8(0.0);

				}

				midDiscardReasDistEqu5.setCategory(structureNodeI.getNodeName());
				session.save(midDiscardReasDistEqu5);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midDiscardReasDistEqu5
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardReasDistEqu5.setMediumClass(structureNodeI.getNodeName());
				midDiscardReasDistEqu5.setSmallClass("");
				midDiscardReasDistEqu5.setVoltageLevel("");

				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu5.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardReasDistEqu5.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setQuantityDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardReasDistEqu5.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setNetValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu5.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason8(0.0);

				}

				midDiscardReasDistEqu5.setCategory(structureNodeI.getNodeName());
				session.save(midDiscardReasDistEqu5);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midDiscardReasDistEqu5.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midDiscardReasDistEqu5
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardReasDistEqu5.setSmallClass("");
				midDiscardReasDistEqu5.setVoltageLevel(structureNodeI.getNodeName());

				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu5.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardReasDistEqu5.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setQuantityDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardReasDistEqu5.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setNetValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu5.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason8(0.0);

				}

				midDiscardReasDistEqu5
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midDiscardReasDistEqu5);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midDiscardReasDistEqu5.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midDiscardReasDistEqu5.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midDiscardReasDistEqu5
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardReasDistEqu5.setVoltageLevel(structureNodeI.getNodeName());

				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu5
							.setOrigValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu5.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardReasDistEqu5.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setQuantityDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu5.setQuantityDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardReasDistEqu5.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu5.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu5.setNetValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu5.setNetValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu5.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu5.setQuantityDiscardReason8(0.0);

				}

				midDiscardReasDistEqu5
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midDiscardReasDistEqu5);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "C.2.7.3 资产退役-报废按成因 (成新率20%以上资产)"表的数据的导入 MidDiscardReasDistEqu20
	 * MID_DISCARD_REAS_DIST_EQU_20
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidDiscardReasDistEqu20Import(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("C.2.7.1 资产退役-资产报废按成因-结构模板");
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}
		int standardStartRowNumber = 5;
		int standardEndRowNumber = 596;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(2, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(3, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(1).getCellType() ==
		 * sheetEndRow1.getCell(1).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(3,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(3, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			endStructureNodeValueMap.put(3, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(1).getCellType() == sheetEndRow1.getCell(1).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(3, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(3, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(3, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(3, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(3, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		// endStructureNode.setValueMap(endStructureNodeValueMap);
		String valueType = sheetEndRow1.getCell(1).getStringCellValue();
		// System.out.println("valueType="+valueType);
		if (valueType.contentEquals("资产原值")) {
			endStructureNodeValueMap.put(1, new BigDecimal(1.0));
		} else if (valueType.contentEquals("设备数量")) {
			endStructureNodeValueMap.put(1, new BigDecimal(2.0));
		} else if (valueType.contentEquals("资产净值")) {
			endStructureNodeValueMap.put(1, new BigDecimal(3.0));
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			// Map<String, BigDecimal> structureNodeValueMap = new HashMap<String,
			// BigDecimal>();
			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");
			// structureNodeValueMap.put(1, new
			// BigDecimal(structureNodeRow1.getCell(2).getNumericCellValue()));

			valueType = structureNodeRow1.getCell(1).getStringCellValue();
			// System.out.println("valueType="+valueType);
			if (valueType.contentEquals("资产原值")) {
				structureNodeValueMap.put(1, new BigDecimal(1.0));
			} else if (valueType.contentEquals("设备数量")) {
				structureNodeValueMap.put(1, new BigDecimal(2.0));
			} else if (valueType.contentEquals("资产净值")) {
				structureNodeValueMap.put(1, new BigDecimal(3.0));
			}
			// System.out.println("structureNodeValueMap.get(1)=" +
			// structureNodeValueMap.get(1));
			for (int colI = 2; colI <= 9; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}
				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(3)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidDiscardReasDistEqu20 midDiscardReasDistEqu20 = new MidDiscardReasDistEqu20();
			midDiscardReasDistEqu20.setVersion(version);

			try {
				midDiscardReasDistEqu20.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midDiscardReasDistEqu20.setOrgName(orgName);
			try {
				midDiscardReasDistEqu20.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类，没有电压等级、小类与中类的行
				 */
				midDiscardReasDistEqu20.setLargeClass(structureNodeI.getNodeName());
				midDiscardReasDistEqu20.setMediumClass("");
				midDiscardReasDistEqu20.setSmallClass("");
				midDiscardReasDistEqu20.setVoltageLevel("");
				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu20.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu20.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardReasDistEqu20.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu20.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu20
							.setQuantityDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardReasDistEqu20.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu20
							.setNetValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu20.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason8(0.0);

				}

				midDiscardReasDistEqu20.setCategory(structureNodeI.getNodeName());
				session.save(midDiscardReasDistEqu20);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && !structureNodeI.getNodeName().contains("kV")
					&& structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有中类，没有电压等级与小类的行
				 */
				midDiscardReasDistEqu20
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardReasDistEqu20.setMediumClass(structureNodeI.getNodeName());
				midDiscardReasDistEqu20.setSmallClass("");
				midDiscardReasDistEqu20.setVoltageLevel("");
				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu20.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu20.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardReasDistEqu20.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu20.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu20
							.setQuantityDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardReasDistEqu20.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu20
							.setNetValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu20.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason8(0.0);

				}

				midDiscardReasDistEqu20.setCategory(structureNodeI.getNodeName());
				session.save(midDiscardReasDistEqu20);
			} else if (structureNodeI.isLeaf() == true && structureNodeI.getNodeName().contains("kV")
					&& structureNodeList
							.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
							.getParentNodeNumber() == standardEndRowNumber) {
				/**
				 * 处理含有电压等级，且大类与中类有值，而小类无取值的行。
				 */
				midDiscardReasDistEqu20.setLargeClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midDiscardReasDistEqu20
						.setMediumClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardReasDistEqu20.setSmallClass("");
				midDiscardReasDistEqu20.setVoltageLevel(structureNodeI.getNodeName());

				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu20.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu20.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardReasDistEqu20.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu20.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu20
							.setQuantityDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardReasDistEqu20.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu20
							.setNetValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu20.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason8(0.0);

				}

				midDiscardReasDistEqu20
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midDiscardReasDistEqu20);
			} else if ((structureNodeI.getNodeName().contains("kV")
					|| structureNodeI.getNodeName().contains("其他（包含无电压等级、直流）")) && structureNodeI.isLeaf() == true) {
				/**
				 * 处理含有电压等级，且大类、中类与小类均有值的行。
				 */
				midDiscardReasDistEqu20.setLargeClass(structureNodeList.get(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getParentNodeNumber()).getNodeName());
				midDiscardReasDistEqu20.setMediumClass(structureNodeList
						.get(structureNodeList.get(structureNodeI.getParentNodeNumber()).getParentNodeNumber())
						.getNodeName());
				midDiscardReasDistEqu20
						.setSmallClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midDiscardReasDistEqu20.setVoltageLevel(structureNodeI.getNodeName());

				if (structureNodeI.getValueMap().get(1).doubleValue() == 1.0) {
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu20
							.setOrigValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu20.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu20.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason8(0.0);

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 2.0) {
					midDiscardReasDistEqu20.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu20.setNetValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setNetValueDiscardReason8(0.0);

					midDiscardReasDistEqu20
							.setQuantityDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu20
							.setQuantityDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

				} else if (structureNodeI.getValueMap().get(1).doubleValue() == 3.0) {
					midDiscardReasDistEqu20.setOrigValueDiscardReason1(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason2(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason3(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason4(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason5(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason6(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason7(0.0);
					midDiscardReasDistEqu20.setOrigValueDiscardReason8(0.0);

					midDiscardReasDistEqu20
							.setNetValueDiscardReason1(structureNodeI.getValueMap().get(2).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason2(structureNodeI.getValueMap().get(3).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason3(structureNodeI.getValueMap().get(4).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason4(structureNodeI.getValueMap().get(5).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason5(structureNodeI.getValueMap().get(6).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason6(structureNodeI.getValueMap().get(7).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason7(structureNodeI.getValueMap().get(8).doubleValue());
					midDiscardReasDistEqu20
							.setNetValueDiscardReason8(structureNodeI.getValueMap().get(9).doubleValue());

					midDiscardReasDistEqu20.setQuantityDiscardReason1(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason2(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason3(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason4(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason5(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason6(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason7(0.0);
					midDiscardReasDistEqu20.setQuantityDiscardReason8(0.0);

				}

				midDiscardReasDistEqu20
						.setCategory(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				session.save(midDiscardReasDistEqu20);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "B.1 设备故障统计表"表的数据的导入 MidEquipBreakdownSatistics MID_EQUIP_BREAKDOWN_SATISTICS
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidEquipBreakdownSatisticsImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// System.out.println("filePathAndName" + filePathAndName);
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;

		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("B.1 设备故障统计表-结构模板");
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
		}

		int standardStartRowNumber = 6;
		int standardEndRowNumber = 29;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(3).getCellType() ==
		 * sheetEndRow1.getCell(3).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(3).getCellType() ==
		 * sheetEndRow1.getCell(3).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(3) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		// endStructureNode.setValueMap(endStructureNodeValueMap);
		endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");

			for (int colI = 2; colI <= 16; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}
				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("filePathAndName=" + filePathAndName + "Node name is " + structureNode.getNodeName()
					+ " node number is " + structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(3)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			// CSVRecord csvRecord = iterator.next();
			MidEquipBreakdownSatistics midEquipBreakdownSatistics = new MidEquipBreakdownSatistics();
			midEquipBreakdownSatistics.setVersion(version);

			try {
				midEquipBreakdownSatistics.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midEquipBreakdownSatistics.setOrgName(orgName);
			try {
				midEquipBreakdownSatistics.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类责任原因，没有小类责任原因与中类责任原因的行
				 */
				midEquipBreakdownSatistics.setLargeDutyReason(structureNodeI.getNodeName());
				midEquipBreakdownSatistics.setMediumDutyReason("");
				midEquipBreakdownSatistics.setSmallDutyReason("");
				midEquipBreakdownSatistics
						.setTransmissionBreakdownTimes5(structureNodeI.getValueMap().get(2).doubleValue());
				midEquipBreakdownSatistics
						.setTransformerBreakdownTimes5(structureNodeI.getValueMap().get(3).doubleValue());
				midEquipBreakdownSatistics
						.setDistributionBreakdownTimes5(structureNodeI.getValueMap().get(4).doubleValue());
				midEquipBreakdownSatistics
						.setTransmissionBreakdownTimes4(structureNodeI.getValueMap().get(5).doubleValue());
				midEquipBreakdownSatistics
						.setTransformerBreakdownTimes4(structureNodeI.getValueMap().get(6).doubleValue());
				midEquipBreakdownSatistics
						.setDistributionBreakdownTimes4(structureNodeI.getValueMap().get(7).doubleValue());
				midEquipBreakdownSatistics
						.setTransmissionBreakdownTimes3(structureNodeI.getValueMap().get(8).doubleValue());
				midEquipBreakdownSatistics
						.setTransformerBreakdownTimes3(structureNodeI.getValueMap().get(9).doubleValue());
				midEquipBreakdownSatistics
						.setDistributionBreakdownTimes3(structureNodeI.getValueMap().get(10).doubleValue());
				midEquipBreakdownSatistics
						.setTransmissionBreakdownTimes2(structureNodeI.getValueMap().get(11).doubleValue());
				midEquipBreakdownSatistics
						.setTransformerBreakdownTimes2(structureNodeI.getValueMap().get(12).doubleValue());
				midEquipBreakdownSatistics
						.setDistributionBreakdownTimes2(structureNodeI.getValueMap().get(13).doubleValue());
				midEquipBreakdownSatistics
						.setTransmissionBreakdownTimes1(structureNodeI.getValueMap().get(14).doubleValue());
				midEquipBreakdownSatistics
						.setTransformerBreakdownTimes1(structureNodeI.getValueMap().get(15).doubleValue());
				midEquipBreakdownSatistics
						.setDistributionBreakdownTimes1(structureNodeI.getValueMap().get(16).doubleValue());

				midEquipBreakdownSatistics.setDutyReasonCategory(structureNodeI.getNodeName());

				session.save(midEquipBreakdownSatistics);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有责任原因大类和责任原因中类，没有责任原因小类的行
				 */
				midEquipBreakdownSatistics
						.setLargeDutyReason(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midEquipBreakdownSatistics.setMediumDutyReason(structureNodeI.getNodeName());
				midEquipBreakdownSatistics.setSmallDutyReason("");

				midEquipBreakdownSatistics
						.setTransmissionBreakdownTimes5(structureNodeI.getValueMap().get(2).doubleValue());
				midEquipBreakdownSatistics
						.setTransformerBreakdownTimes5(structureNodeI.getValueMap().get(3).doubleValue());
				midEquipBreakdownSatistics
						.setDistributionBreakdownTimes5(structureNodeI.getValueMap().get(4).doubleValue());

				midEquipBreakdownSatistics
						.setTransmissionBreakdownTimes4(structureNodeI.getValueMap().get(5).doubleValue());
				midEquipBreakdownSatistics
						.setTransformerBreakdownTimes4(structureNodeI.getValueMap().get(6).doubleValue());
				midEquipBreakdownSatistics
						.setDistributionBreakdownTimes4(structureNodeI.getValueMap().get(7).doubleValue());

				midEquipBreakdownSatistics
						.setTransmissionBreakdownTimes3(structureNodeI.getValueMap().get(8).doubleValue());
				midEquipBreakdownSatistics
						.setTransformerBreakdownTimes3(structureNodeI.getValueMap().get(9).doubleValue());
				midEquipBreakdownSatistics
						.setDistributionBreakdownTimes3(structureNodeI.getValueMap().get(10).doubleValue());

				midEquipBreakdownSatistics
						.setTransmissionBreakdownTimes2(structureNodeI.getValueMap().get(11).doubleValue());
				midEquipBreakdownSatistics
						.setTransformerBreakdownTimes2(structureNodeI.getValueMap().get(12).doubleValue());
				midEquipBreakdownSatistics
						.setDistributionBreakdownTimes2(structureNodeI.getValueMap().get(13).doubleValue());

				midEquipBreakdownSatistics
						.setTransmissionBreakdownTimes1(structureNodeI.getValueMap().get(14).doubleValue());
				midEquipBreakdownSatistics
						.setTransformerBreakdownTimes1(structureNodeI.getValueMap().get(15).doubleValue());
				midEquipBreakdownSatistics
						.setDistributionBreakdownTimes1(structureNodeI.getValueMap().get(16).doubleValue());

				midEquipBreakdownSatistics.setDutyReasonCategory(structureNodeI.getNodeName());
				session.save(midEquipBreakdownSatistics);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "B.2 设备强迫停运统计表-结构模板"表的数据的导入 MidEquipForceOutageStatist
	 * MID_EQUIP_FORCE_OUTAGE_STATIST
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidEquipForceOutageStatistImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("B.2 设备强迫停运统计表-结构模板");

		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
		}

		int standardStartRowNumber = 5;
		int standardEndRowNumber = 19;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(3).getCellType() ==
		 * sheetEndRow1.getCell(3).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(3).getCellType() ==
		 * sheetEndRow1.getCell(3).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(1) == null) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(3) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		// endStructureNode.setValueMap(endStructureNodeValueMap);
		endStructureNode.setValueMap(endStructureNodeValueMap);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		for (int classI = 0; classI < 11; classI++) {
			HSSFRow classStructureNodeRow = importFileSheet.getRow(standardStartRowNumber - 2);

			String className = classStructureNodeRow.getCell(1 + classI * 5).getStringCellValue();

			// System.out.println(
			// "orgName" + orgName +
			// "structureNodeRow.getCell(1+classI*5).getStringCellValue()=" + className);
			for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
				StructureNode structureNode = new StructureNode();
				HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
				HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);

				// 表结构从sheet(0)，即structureNodeRow中获取。

				if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
					structureNode.setLeaf(true);
				} else {
					structureNode.setLeaf(false);
				}
				structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
				structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
				structureNode
						.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());

				// 数据从sheet(1)，即structureNodeRow1中获取。

				Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
				DecimalFormat df1 = new DecimalFormat("#.0000");

				for (int colI = 1; colI <= 5; colI++) {
					if (structureNodeRow1.getCell(colI + classI * 5) == null) {
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + classI * 5 + 1);
						six.setCellValue("单元格取值获取不到");
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					} else if (structureNodeRow1.getCell(colI + classI * 5)
							.getCellType() == structureNodeRow1.getCell(colI + classI * 5).CELL_TYPE_BLANK
							|| structureNodeRow1.getCell(colI + classI * 5)
									.getCellType() == structureNodeRow1.getCell(colI + classI * 5).CELL_TYPE_STRING) {
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
					} else {
						try {
							structureNodeValueMap.put(colI,
									new BigDecimal(structureNodeRow1.getCell(colI + classI * 5).getNumericCellValue()));
						} catch (Exception e) {
							// TODO: handle exception
							OutputStream out = null;
							structureNodeValueMap.put(colI, new BigDecimal(0.0));
							Row errorRow = errorSheet.createRow(errorI + 1);
							Cell first = errorRow.createCell(0);
							Cell second = errorRow.createCell(1);
							Cell third = errorRow.createCell(2);
							Cell four = errorRow.createCell(3);
							Cell five = errorRow.createCell(4);
							Cell six = errorRow.createCell(5);
							Cell seven = errorRow.createCell(6);
							// first.setCellValue(errorString);
							first.setCellValue(new Date());
							second.setCellValue(fileName);
							third.setCellValue(sheetName);
							four.setCellValue(rowI + standardStartRowNumber + 1);
							five.setCellValue(colI + classI * 5 + 1);
							six.setCellValue(e.getMessage());
							errorI = errorI + 1;

							out = new FileOutputStream(errorFilePath);
							errorWorkBook.write(out);
							try {
								if (out != null) {
									out.flush();
									out.close();
								}
							} catch (IOException outE) {
								outE.printStackTrace();
							}
						}
					}
				}
				// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

				structureNode.setValueMap(structureNodeValueMap);

				System.out.println("filePathAndName=" + filePathAndName + "Node name is " + structureNode.getNodeName()
						+ " node number is " + structureNode.getStructureNodeNumber() + " parentNodeNumber is "
						+ structureNode.getParentNodeNumber() + " head one value is "
						+ df1.format(structureNode.getValueMap().get(1)) + " head one value is "
						+ df1.format(structureNode.getValueMap().get(2)) + " whether is leaf "
						+ structureNode.isLeaf());
				// 从标准结构结点中获取
				structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
			}
			structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
			// System.out.println("structureNodeList.size()=" + structureNodeList.size());

			// 打开一个Session
			Session session = sf.openSession();
			// 开始一个事务
			Transaction tx = session.beginTransaction();
			DecimalFormat df = new DecimalFormat();
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			// String version = "RS_2018_3";
			// int i = 0;
			// System.out.println("orgName=" + orgName);

			for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
				// System.out.println("sNodeI=" + sNodeI);
				StructureNode structureNodeI = structureNodeList.get(sNodeI);
				// CSVRecord csvRecord = iterator.next();
				MidEquipForceOutageStatist midEquipForceOutageStatist = new MidEquipForceOutageStatist();
				midEquipForceOutageStatist.setVersion(version);

				try {
					midEquipForceOutageStatist.setCalYear(simpleDateFormat.parse("2019/11/18"));
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				midEquipForceOutageStatist.setOrgName(orgName);

				midEquipForceOutageStatist.setAssetClass(className);

				try {
					midEquipForceOutageStatist.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// System.out.println("structureNodeI.getParentNodeNumber()=" +
				// structureNodeI.getParentNodeNumber());
				if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {

					// 该分枝处理只有大类责任原因，没有小类责任原因与中类责任原因的行

					midEquipForceOutageStatist.setDutyReason(structureNodeI.getNodeName());
					midEquipForceOutageStatist.setSmallDutyReason("");
					midEquipForceOutageStatist
							.setEquipForceOutageTimesYear1(structureNodeI.getValueMap().get(5).doubleValue());
					midEquipForceOutageStatist
							.setEquipForceOutageTimesYear2(structureNodeI.getValueMap().get(4).doubleValue());
					midEquipForceOutageStatist
							.setEquipForceOutageTimesYear3(structureNodeI.getValueMap().get(3).doubleValue());
					midEquipForceOutageStatist
							.setEquipForceOutageTimesYear4(structureNodeI.getValueMap().get(2).doubleValue());
					midEquipForceOutageStatist
							.setEquipForceOutageTimesYear5(structureNodeI.getValueMap().get(1).doubleValue());

					midEquipForceOutageStatist.setDutyReasonCategory(structureNodeI.getNodeName());

					session.save(midEquipForceOutageStatist);
				}

				if (sNodeI % 5000 == 0) {
					session.flush();
					session.clear();
					tx.commit();
					tx = session.beginTransaction();
				}
			}
			tx.commit();
			session.clear();
		}
		sf.close();

	}

	/**
	 * "B.3.1 系统停电统计表"表的数据的导入 MidSystemOutageStatistics MID_SYSTEM_OUTAGE_STATISTICS
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidSystemOutageStatisticsImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("B.3.1 系统停电统计表-结构模板");
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
		}
		int standardStartRowNumber = 5;
		int standardEndRowNumber = 80;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();
		/*
		 * if (sheetEndRow1==null) { endStructureNodeValueMap.put(1, new
		 * BigDecimal(0.0)); endStructureNodeValueMap.put(2, new BigDecimal(0.0)); }
		 * else {
		 * 
		 * if (sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(2).getCellType() ==
		 * sheetEndRow1.getCell(2).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(1,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(1, new
		 * BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue())); } if
		 * (sheetEndRow1.getCell(3).getCellType() ==
		 * sheetEndRow1.getCell(3).CELL_TYPE_STRING ||
		 * sheetEndRow1.getCell(3).getCellType() ==
		 * sheetEndRow1.getCell(3).CELL_TYPE_BLANK) { endStructureNodeValueMap.put(2,
		 * new BigDecimal(0.0)); } else { endStructureNodeValueMap.put(2, new
		 * BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue())); } }
		 */
		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(2) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(3) == null) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else if (sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		// endStructureNode.setValueMap(endStructureNodeValueMap);
		endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");

			for (int colI = 2; colI <= 11; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格获取不到");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(3)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			MidSystemOutageStatistics midSystemOutageStatistics = new MidSystemOutageStatistics();
			midSystemOutageStatistics.setVersion(version);

			try {
				midSystemOutageStatistics.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midSystemOutageStatistics.setOrgName(orgName);
			try {
				midSystemOutageStatistics.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类责任原因，没有小类责任原因与中类责任原因的行
				 */
				midSystemOutageStatistics.setLargeDutyReason(structureNodeI.getNodeName());
				midSystemOutageStatistics.setMediumDutyReason("");
				midSystemOutageStatistics.setSmallDutyReason("");
				midSystemOutageStatistics
						.setPowerOutageCustomerTimes5(structureNodeI.getValueMap().get(2).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageTimeCustomerQt5(structureNodeI.getValueMap().get(3).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageCustomerTimes4(structureNodeI.getValueMap().get(4).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageTimeCustomerQt4(structureNodeI.getValueMap().get(5).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageCustomerTimes3(structureNodeI.getValueMap().get(6).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageTimeCustomerQt3(structureNodeI.getValueMap().get(7).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageCustomerTimes2(structureNodeI.getValueMap().get(8).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageTimeCustomerQt2(structureNodeI.getValueMap().get(9).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageCustomerTimes1(structureNodeI.getValueMap().get(10).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageTimeCustomerQt1(structureNodeI.getValueMap().get(11).doubleValue());

				midSystemOutageStatistics.setDutyReasonCategory(structureNodeI.getNodeName());

				session.save(midSystemOutageStatistics);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有责任原因大类和责任原因中类，没有责任原因小类的行
				 */
				midSystemOutageStatistics
						.setLargeDutyReason(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midSystemOutageStatistics.setMediumDutyReason(structureNodeI.getNodeName());
				midSystemOutageStatistics.setSmallDutyReason("");

				midSystemOutageStatistics
						.setPowerOutageCustomerTimes5(structureNodeI.getValueMap().get(2).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageTimeCustomerQt5(structureNodeI.getValueMap().get(3).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageCustomerTimes4(structureNodeI.getValueMap().get(4).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageTimeCustomerQt4(structureNodeI.getValueMap().get(5).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageCustomerTimes3(structureNodeI.getValueMap().get(6).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageTimeCustomerQt3(structureNodeI.getValueMap().get(7).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageCustomerTimes2(structureNodeI.getValueMap().get(8).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageTimeCustomerQt2(structureNodeI.getValueMap().get(9).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageCustomerTimes1(structureNodeI.getValueMap().get(10).doubleValue());
				midSystemOutageStatistics
						.setPowerOutageTimeCustomerQt1(structureNodeI.getValueMap().get(11).doubleValue());

				midSystemOutageStatistics.setDutyReasonCategory(structureNodeI.getNodeName());
				session.save(midSystemOutageStatistics);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "D.2 大修运维费用"表的数据的导入 MidMaintenOverhaulCost MID_MAINTEN_OVERHAUL_COST
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidMaintenOverhaulCostImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("D.2 大修运维费用-结构模板");
		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}
		int standardStartRowNumber = 4;
		int standardEndRowNumber = 13;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();
		HSSFRow sheetEndRow = templateFileSheet.getRow(standardEndRowNumber);
		HSSFRow sheetHeadRow = templateFileSheet.getRow(standardStartRowNumber - 1);

		HSSFRow sheetEndRow1 = importFileSheet.getRow(endRowNumber);
		HSSFRow sheetHeadRow1 = importFileSheet.getRow(startRowNumber - 1);

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();
		StructureNode endStructureNode = new StructureNode();

		endStructureNode.setLeaf(false);
		endStructureNode.setNodeName("总计");
		endStructureNode.setStructureNodeNumber(standardEndRowNumber);
		endStructureNode.setParentNodeNumber(0);

		Map<Integer, BigDecimal> endStructureNodeValueMap = new HashMap<Integer, BigDecimal>();

		/**
		 * 下面的程序块用于构建报表的最后一行汇总的根节点。 如果表中有汇总行，则直接读取； 没有，则表明没有汇总行，用构建一个虚拟的汇总根节点
		 */
		if (sheetEndRow1 == null) {
			endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			endStructureNodeValueMap.put(2, new BigDecimal(0.0));
		} else {
			if (sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(2).getCellType() == sheetEndRow1.getCell(2).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(1, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(1, new
				// BigDecimal(sheetEndRow1.getCell(1).getNumericCellValue()));
				try {
					endStructureNodeValueMap.put(1, new BigDecimal(sheetEndRow1.getCell(2).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(1, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(2);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}
			}
			if (sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_STRING
					|| sheetEndRow1.getCell(3).getCellType() == sheetEndRow1.getCell(3).CELL_TYPE_BLANK) {
				endStructureNodeValueMap.put(2, new BigDecimal(0.0));
			} else {
				// endStructureNodeValueMap.put(2, new
				// BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));

				try {
					endStructureNodeValueMap.put(2, new BigDecimal(sheetEndRow1.getCell(3).getNumericCellValue()));
				} catch (Exception e) {
					// TODO: handle exception
					OutputStream out = null;
					endStructureNodeValueMap.put(2, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(endRowNumber + 1);
					five.setCellValue(3);
					six.setCellValue(e.getMessage());
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				}

			}
		}
		endStructureNode.setValueMap(endStructureNodeValueMap);

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			if (structureNodeRow.getCell(3).getNumericCellValue() == 1) {
				structureNode.setLeaf(true);
			} else {
				structureNode.setLeaf(false);
			}
			structureNode.setNodeName(structureNodeRow.getCell(0).getStringCellValue());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(new Double(structureNodeRow.getCell(4).getNumericCellValue()).intValue());
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");

			for (int colI = 2; colI <= 6; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格取值为null");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {
					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(3)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		structureNodeList.put(endStructureNode.getStructureNodeNumber(), endStructureNode);
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			MidMaintenOverhaulCost midMaintenOverhaulCost = new MidMaintenOverhaulCost();
			midMaintenOverhaulCost.setVersion(version);

			try {
				midMaintenOverhaulCost.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midMaintenOverhaulCost.setOrgName(orgName);
			try {
				midMaintenOverhaulCost.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类责任原因，没有小类责任原因与中类责任原因的行
				 */
				midMaintenOverhaulCost.setLargeClass(structureNodeI.getNodeName());
				midMaintenOverhaulCost.setMediumClass("");
				midMaintenOverhaulCost.setSmallClass("");
				midMaintenOverhaulCost.setVoltageLevel("");
				if (structureNodeI.getNodeName().contentEquals("整体运维费用")) {

					midMaintenOverhaulCost.setMaintenance5YearCost(structureNodeI.getValueMap().get(2).doubleValue());
					midMaintenOverhaulCost.setMaintenance4YearCost(structureNodeI.getValueMap().get(3).doubleValue());
					midMaintenOverhaulCost.setMaintenance3YearCost(structureNodeI.getValueMap().get(4).doubleValue());
					midMaintenOverhaulCost.setMaintenance2YearCost(structureNodeI.getValueMap().get(5).doubleValue());
					midMaintenOverhaulCost.setMaintenance1YearCost(structureNodeI.getValueMap().get(6).doubleValue());

					midMaintenOverhaulCost.setOverhaul5YearCost(0.0);
					midMaintenOverhaulCost.setOverhaul4YearCost(0.0);
					midMaintenOverhaulCost.setOverhaul3YearCost(0.0);
					midMaintenOverhaulCost.setOverhaul2YearCost(0.0);
					midMaintenOverhaulCost.setOverhaul1YearCost(0.0);
				} else if (structureNodeI.getNodeName().contentEquals("整体大修费用")) {
					midMaintenOverhaulCost.setMaintenance5YearCost(0.0);
					midMaintenOverhaulCost.setMaintenance4YearCost(0.0);
					midMaintenOverhaulCost.setMaintenance3YearCost(0.0);
					midMaintenOverhaulCost.setMaintenance2YearCost(0.0);
					midMaintenOverhaulCost.setMaintenance1YearCost(0.0);

					midMaintenOverhaulCost.setOverhaul5YearCost(structureNodeI.getValueMap().get(2).doubleValue());
					midMaintenOverhaulCost.setOverhaul4YearCost(structureNodeI.getValueMap().get(2).doubleValue());
					midMaintenOverhaulCost.setOverhaul3YearCost(structureNodeI.getValueMap().get(2).doubleValue());
					midMaintenOverhaulCost.setOverhaul2YearCost(structureNodeI.getValueMap().get(2).doubleValue());
					midMaintenOverhaulCost.setOverhaul1YearCost(structureNodeI.getValueMap().get(2).doubleValue());
				}

				midMaintenOverhaulCost.setCategory(structureNodeI.getNodeName());

				session.save(midMaintenOverhaulCost);
			} else if (structureNodeList.get(structureNodeI.getParentNodeNumber())
					.getParentNodeNumber() == standardEndRowNumber && structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理有资产分类和费用分类，没有责任原因小类的行
				 */
				midMaintenOverhaulCost
						.setLargeClass(structureNodeList.get(structureNodeI.getParentNodeNumber()).getNodeName());
				midMaintenOverhaulCost.setMediumClass("");
				midMaintenOverhaulCost.setSmallClass("");
				midMaintenOverhaulCost.setVoltageLevel("");
				if (structureNodeI.getNodeName().contentEquals("整体运维费用")) {

					midMaintenOverhaulCost.setMaintenance5YearCost(structureNodeI.getValueMap().get(2).doubleValue());
					midMaintenOverhaulCost.setMaintenance4YearCost(structureNodeI.getValueMap().get(3).doubleValue());
					midMaintenOverhaulCost.setMaintenance3YearCost(structureNodeI.getValueMap().get(4).doubleValue());
					midMaintenOverhaulCost.setMaintenance2YearCost(structureNodeI.getValueMap().get(5).doubleValue());
					midMaintenOverhaulCost.setMaintenance1YearCost(structureNodeI.getValueMap().get(6).doubleValue());

					midMaintenOverhaulCost.setOverhaul5YearCost(0.0);
					midMaintenOverhaulCost.setOverhaul4YearCost(0.0);
					midMaintenOverhaulCost.setOverhaul3YearCost(0.0);
					midMaintenOverhaulCost.setOverhaul2YearCost(0.0);
					midMaintenOverhaulCost.setOverhaul1YearCost(0.0);
				} else if (structureNodeI.getNodeName().contentEquals("整体大修费用")) {
					midMaintenOverhaulCost.setMaintenance5YearCost(0.0);
					midMaintenOverhaulCost.setMaintenance4YearCost(0.0);
					midMaintenOverhaulCost.setMaintenance3YearCost(0.0);
					midMaintenOverhaulCost.setMaintenance2YearCost(0.0);
					midMaintenOverhaulCost.setMaintenance1YearCost(0.0);

					midMaintenOverhaulCost.setOverhaul5YearCost(structureNodeI.getValueMap().get(2).doubleValue());
					midMaintenOverhaulCost.setOverhaul4YearCost(structureNodeI.getValueMap().get(2).doubleValue());
					midMaintenOverhaulCost.setOverhaul3YearCost(structureNodeI.getValueMap().get(2).doubleValue());
					midMaintenOverhaulCost.setOverhaul2YearCost(structureNodeI.getValueMap().get(2).doubleValue());
					midMaintenOverhaulCost.setOverhaul1YearCost(structureNodeI.getValueMap().get(2).doubleValue());
				}

				midMaintenOverhaulCost.setCategory(structureNodeI.getNodeName());
				session.save(midMaintenOverhaulCost);
			}

			if (sNodeI % 5000 == 0) {
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
	 * "D.3 单位输配电成本"表的数据的导入 MidUnitTransmiDistriCost MID_UNIT_TRANSMI_DISTRI_COST
	 * 
	 * @param pathName
	 * @param fileName
	 * @param startRowNumber
	 * @param endRowNumber
	 * @param sheetNumber
	 * @throws IOException
	 */
	public static void reportMidUnitTransmiDistriCostImport(String templateFile, String pathName, String fileName,
			int startRowNumber, int endRowNumber, String sheetName, String errorFilePath, String version)
			throws IOException {

		File errorFile = new File(errorFilePath);
		Workbook errorWorkBook = getWorkbok(errorFile);
		// sheet 对应一个工作页
		Sheet errorSheet = errorWorkBook.getSheetAt(0);
		int errorI = errorSheet.getPhysicalNumberOfRows();

		String filePathAndName = pathName + "/" + fileName;
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook fileWorkbook = new HSSFWorkbook(new FileInputStream(filePathAndName));
		// 创建需要复制公式的目标EXCEL文件工作簿的引用
		HSSFWorkbook templateFileWorkbook = new HSSFWorkbook(new FileInputStream(templateFile));
		HSSFSheet templateFileSheet;
		HSSFSheet importFileSheet = null;
		// 获取Sheet对象
		templateFileSheet = templateFileWorkbook.getSheet("D.3 单位输配电成本-结构模板");

		String sheetListElementName = null;
		for (int sheetI = 0; sheetI < fileWorkbook.getNumberOfSheets(); sheetI++) {
			sheetListElementName = fileWorkbook.getSheetAt(sheetI).getSheetName().trim();
			if (sheetListElementName.contentEquals(sheetName)) {
				importFileSheet = fileWorkbook.getSheetAt(sheetI);
				break;
			}
		}
		if (importFileSheet == null) {
			System.out.println("Not find sheet '" + sheetName + "'，Please use standard template table submit!");
			// return "Not find sheet '"+sheetName+"'，Please use standard template table
			// submit!";
		}
		int standardStartRowNumber = 3;
		int standardEndRowNumber = 8;
		// 输出遍历到的sheet表的名称
		// 获取至Sheet表中的行数
		// int fileSheetRowNumber = fileSheet.getPhysicalNumberOfRows();

		Map<Integer, StructureNode> structureNodeList = new HashMap<Integer, StructureNode>();

		for (int rowI = 0; rowI + standardStartRowNumber < standardEndRowNumber; rowI++) {
			StructureNode structureNode = new StructureNode();
			HSSFRow structureNodeRow = templateFileSheet.getRow(rowI + standardStartRowNumber);
			HSSFRow structureNodeRow1 = importFileSheet.getRow(rowI + startRowNumber);
			/**
			 * 表结构从sheet(0)，即structureNodeRow中获取。
			 */
			structureNode.setLeaf(true);

			structureNode.setNodeName(new Double(structureNodeRow.getCell(0).getNumericCellValue()).toString());
			structureNode.setStructureNodeNumber(rowI + standardStartRowNumber);
			structureNode.setParentNodeNumber(rowI + standardStartRowNumber - 1);
			/**
			 * 数据从sheet(1)，即structureNodeRow1中获取。
			 */

			Map<Integer, BigDecimal> structureNodeValueMap = new HashMap<Integer, BigDecimal>();
			DecimalFormat df1 = new DecimalFormat("#.0000");

			for (int colI = 1; colI <= 3; colI++) {
				if (structureNodeRow1.getCell(colI) == null) {
					OutputStream out = null;
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
					Row errorRow = errorSheet.createRow(errorI + 1);
					Cell first = errorRow.createCell(0);
					Cell second = errorRow.createCell(1);
					Cell third = errorRow.createCell(2);
					Cell four = errorRow.createCell(3);
					Cell five = errorRow.createCell(4);
					Cell six = errorRow.createCell(5);
					Cell seven = errorRow.createCell(6);
					// first.setCellValue(errorString);
					first.setCellValue(new Date());
					second.setCellValue(fileName);
					third.setCellValue(sheetName);
					four.setCellValue(rowI + standardStartRowNumber + 1);
					five.setCellValue(colI + 1);
					six.setCellValue("单元格取值为null");
					errorI = errorI + 1;

					out = new FileOutputStream(errorFilePath);
					errorWorkBook.write(out);
					try {
						if (out != null) {
							out.flush();
							out.close();
						}
					} catch (IOException outE) {
						outE.printStackTrace();
					}
				} else if (structureNodeRow1.getCell(colI)
						.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_BLANK
						|| structureNodeRow1.getCell(colI)
								.getCellType() == structureNodeRow1.getCell(colI).CELL_TYPE_STRING) {
					structureNodeValueMap.put(colI, new BigDecimal(0.0));
				} else {

					try {
						structureNodeValueMap.put(colI,
								new BigDecimal(structureNodeRow1.getCell(colI).getNumericCellValue()));
					} catch (Exception e) {
						// TODO: handle exception
						OutputStream out = null;
						structureNodeValueMap.put(colI, new BigDecimal(0.0));
						Row errorRow = errorSheet.createRow(errorI + 1);
						Cell first = errorRow.createCell(0);
						Cell second = errorRow.createCell(1);
						Cell third = errorRow.createCell(2);
						Cell four = errorRow.createCell(3);
						Cell five = errorRow.createCell(4);
						Cell six = errorRow.createCell(5);
						Cell seven = errorRow.createCell(6);
						// first.setCellValue(errorString);
						first.setCellValue(new Date());
						second.setCellValue(fileName);
						third.setCellValue(sheetName);
						four.setCellValue(rowI + standardStartRowNumber + 1);
						five.setCellValue(colI + 1);
						six.setCellValue(e.getMessage());
						errorI = errorI + 1;

						out = new FileOutputStream(errorFilePath);
						errorWorkBook.write(out);
						try {
							if (out != null) {
								out.flush();
								out.close();
							}
						} catch (IOException outE) {
							outE.printStackTrace();
						}
					}

				}
			}
			// System.out.println("structureNodeRow1.getCell(2).getCellType()"+structureNodeRow1.getCell(2).getCellType());

			structureNode.setValueMap(structureNodeValueMap);

			System.out.println("Node name is " + structureNode.getNodeName() + " node number is "
					+ structureNode.getStructureNodeNumber() + " parentNodeNumber is "
					+ structureNode.getParentNodeNumber() + " head one value is "
					+ df1.format(structureNode.getValueMap().get(2)) + " head one value is "
					+ df1.format(structureNode.getValueMap().get(3)) + " whether is leaf " + structureNode.isLeaf());
			// 从标准结构结点中获取
			structureNodeList.put(structureNode.getStructureNodeNumber(), structureNode);
		}
		// System.out.println("structureNodeList.size()=" + structureNodeList.size());

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// 打开一个Session
		Session session = sf.openSession();
		// 开始一个事务
		Transaction tx = session.beginTransaction();
		DecimalFormat df = new DecimalFormat();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// String version = "RS_2018_3";
		// int i = 0;
		String orgName = fileName.substring(fileName.indexOf("-") + 1, fileName.length() - 4);
		// System.out.println("orgName=" + orgName);

		for (int sNodeI = standardStartRowNumber; sNodeI < standardEndRowNumber; sNodeI++) {
			// System.out.println("sNodeI=" + sNodeI);
			StructureNode structureNodeI = structureNodeList.get(sNodeI);
			MidUnitTransmiDistriCost midUnitTransmiDistriCost = new MidUnitTransmiDistriCost();
			midUnitTransmiDistriCost.setVersion(version);

			try {
				midUnitTransmiDistriCost.setCalYear(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midUnitTransmiDistriCost.setOrgName(orgName);
			try {
				midUnitTransmiDistriCost.setDvDateValue(simpleDateFormat.parse("2019/11/18"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("structureNodeI.getParentNodeNumber()=" +
			// structureNodeI.getParentNodeNumber());
			if (structureNodeI.isLeaf() == true) {
				/**
				 * 该分枝处理只有大类责任原因，没有小类责任原因与中类责任原因的行
				 */
				midUnitTransmiDistriCost.setYearValue(new Double(structureNodeI.getNodeName()).intValue());

				midUnitTransmiDistriCost.setTransmiDistriCost(structureNodeI.getValueMap().get(1).doubleValue());

				midUnitTransmiDistriCost.setElectricitySales(structureNodeI.getValueMap().get(2).doubleValue());

				midUnitTransmiDistriCost
						.setUnitElectrTransmDistriCost(structureNodeI.getValueMap().get(3).doubleValue());

				session.save(midUnitTransmiDistriCost);

			}

			if (sNodeI % 5000 == 0) {
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

	public static String getCellValue(Cell cell) {
		String cellValue = "";
		// 以下是判断数据的类型
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // 数字
			if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				cellValue = sdf.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue()))
						.toString();
			} else {
				DataFormatter dataFormatter = new DataFormatter();
				cellValue = dataFormatter.formatCellValue(cell);
			}
			break;
		case Cell.CELL_TYPE_STRING: // 字符串
			cellValue = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_BOOLEAN: // Boolean
			cellValue = cell.getBooleanCellValue() + "";
			break;
		case Cell.CELL_TYPE_FORMULA: // 公式
			cellValue = cell.getCellFormula() + "";
			break;
		case Cell.CELL_TYPE_BLANK: // 空值
			cellValue = "";
			break;
		case Cell.CELL_TYPE_ERROR: // 故障
			cellValue = "非法字符";
			break;
		default:
			cellValue = "未知类型";
			break;
		}
		return cellValue;
	}

	/**
	 * 判断Excel的版本,获取Workbook
	 * 
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkbok(File file) throws IOException {
		Workbook wb = null;
		FileInputStream in = new FileInputStream(file);
		if (file.getName().endsWith(EXCEL_XLS)) { // Excel&nbsp;2003
			wb = new HSSFWorkbook(in);
		} else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel 2007/2010
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}
}