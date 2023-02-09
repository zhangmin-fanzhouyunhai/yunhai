package com.yunhai.excel;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.yunhai.db.util.DbUtil;
import com.yunhai.excel.orm.BicAzfiSwzc;
import com.yunhai.excel.orm.MidErpItem;
import com.yunhai.excel.orm.MidPmsItem;
import com.yunhai.excel.orm.PmsQuexian;
import com.yunhai.excel.service.PmsQuexianService;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;



public class ExportToExcelCsv {

	public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		// new ExportToExcelXls().createXLS();
		String tableName;
		//
		int recordQuantity=65534;
		//int recordQuantity = 30000;
		
		//tableName = "MID_PMS_ITEM_AGE_GRE_50_2018";
		//new ExportToExcelXls().exportMidPmsItem(tableName, recordQuantity);

		// 
		Double maxUsedMemoryPercent=0.60;
		// 
		Double maxFreeMemoryPercent=0.30;
		// 				tableName = "MID_PMS_ITEM_WUHAN_19";
		//				new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
		//		 maxFreeMemoryPercent); 
		// 	
		//
		tableName = "MID_PMS_ITEM_HUANGSHI_19";
		// 	
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
		//		 
				maxFreeMemoryPercent); 

		/*
		// 		
		tableName = "MID_PMS_ITEM_SHIYAN_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
		// 		
		tableName = "MID_PMS_ITEM_XIANGYANG_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
		// 		
		tableName = "MID_PMS_ITEM_HUANGGANG_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
		// 		
		tableName = "MID_PMS_ITEM_ERZHOU_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
		// 		
		tableName = "MID_PMS_ITEM_JINMENG_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
		// 		
		tableName = "MID_PMS_ITEM_YICHANG_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
		// 		
		tableName = "MID_PMS_ITEM_JINZHOU_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
		// 		
		tableName = "MID_PMS_ITEM_XIAOGAN_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
		// 		
		tableName = "MID_PMS_ITEM_XIANNING_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
		// 		
		tableName = "MID_PMS_ITEM_SUIZHOU_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
		// 		
		tableName = "MID_PMS_ITEM_SHENNONGJIA_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
		// 		
		tableName = "MID_PMS_ITEM_ENSHI_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
		// 		
		tableName = "MID_PMS_ITEM_OTHERS_19";
		// 		
		new ExportDao().exportMidPmsItem( tableName,  maxUsedMemoryPercent,
				 maxFreeMemoryPercent); 
				 
*/

		//tableName = "MID_ERP_ITEM_OVER_AGE2020_2";
		//
		tableName = "MID_ERP_ITEM"; 
			//
		new ExportDao().exportMidErpItemTest( tableName); 
		//
		tableName = "MID_ERP_ITEM_ASSET_WALL"; 
			//new ExportDao().exportMidErpItemAssetWallTest( tableName); 
		/**
		 * 上面的方法还是无法摆脱对具体类的束缚，通用性的方法，将每一个类的所有属性转换成
		 * excel的row对象，row对象中包含所有的cell对应的值的链表，
		 * 在数据导出时直接从头到尾的写出链表中的数据到excel中去。
		 * 类名，通过表名映射？
		 * 
		 */
		/****20200527 
		//tableName = "MID_ERP_ITEM_WUHAN_19";
		// new ExportDao().exportMidErpItem( tableName);

		//tableName = "MID_ERP_ITEM_HUANGSHI_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_SHIYAN_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_XIANGYANG_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_HUANGGANG_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_ERZHOU_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_JINMENG_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_YICHANG_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_JINZHOU_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_XIAOGAN_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_XIANNING_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_SUIZHOU_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_SHENNONGJIA_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_ENSHI_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//
		tableName = "MID_ERP_ITEM_OTHERS_19";
		//		
		new ExportDao().exportMidErpItem( tableName);
		//		tableName = "MID_ERP_ITEM_WUHAN_19";
		//			new ExportDao().exportMidErpItem( tableName);

		 20200527*/
		// tableName = "MID_ERP_ITEM_MANU_GRA_CAPI";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_DELI_GRA_CAPI";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_NET_EQU_ZERO";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_ORI_EQU_ZERO";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_ORI_NET_EQU_ZERO";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_ORI_NET_EQU_ZERO";
		// new ExportService().getClassPropertyType(tableName);
		// tableName = "MID_ERP_ITEM_NET_ORI_ZERO";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_NET_ORI_LES_ZERO";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_ORI_LES_NET";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_PMS_ITEM_AGE_GRE_50_2018";
		// new ExportToExcelXls().exportMidPmsItem(tableName, recordQuantity);
		// tableName = "MID_PMS_ITEM_BACK_STATUS_2018";
		// new ExportToExcelXls().exportMidPmsItem(tableName, recordQuantity);
		// tableName = "MID_PMS_ITEM_SERI_ABNOR_2018";
		// new ExportToExcelXls().exportMidPmsItem(tableName, recordQuantity);
		// tableName = "MID_ERP_ITEM_WRO_VOLT_SWIT_18";
		// new ExportToExcelXls().exportMidErpItem(tableName, recordQuantity);
		// tableName = "MID_ERP_ITEM_1000KV_17";
		// new ExportToExcelXls().exportMidErpItem(tableName, recordQuantity);
		// tableName = "MID_PMS_UNMAT_ITEM_LINE_TRANS";
		// new ExportToExcelXls().exportMidPmsItem(tableName, recordQuantity);
		// tableName = "MID_ERP_ITEM_2018_ORI_NEG_GROW";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_2017_ORI_NEG_GROW";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_2017_CAB_TRANS";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// 		tableName = "MID_PMS_ITEM";
		// 		new ExportToExcelXls().exportMidPmsItem(tableName, recordQuantity);
		//tableName = "MID_PMS_ITEM_19_ERP_NOT_EXISTS";
		// new ExportToExcelXls().exportMidPmsItem(tableName, recordQuantity);
		//1
		// tableName = "BIC_AZFI_SWZC00_182_18";
		// new ExportToExcelXls().exportBicAzfiSwzc00(tableName, recordQuantity);
		// tableName = "BIC_AZFI_SWZC00_182_17_2";
		// new ExportToExcelXls().exportBicAzfiSwzc00(tableName, recordQuantity);
		// tableName = "MID_ERP_ITEM_NET_EQU_ZERO";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_VOLT_LEVEL_NULL";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_VOLT_LEV_NULL_1";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_VOLT_LEV_NULL_2";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_PMS_ITEM_LENGTH_EQ_0";
		// new ExportToExcelXls().exportMidPmsItem(tableName,recordQuantity);

		// tableName = "MID_ERP_ITEM_2017_V9_PAR1";
		//		new ExportToExcelXls().exportMidErpItem(tableName, recordQuantity);
		// tableName = "MID_ERP_ITEM_2017_V9_PAR2";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_2017_V9_PAR3";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_2018_1";
		// tableName = "MID_ERP_ITEM_2018_1_1";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);

		// 		tableName = "MID_ERP_ITEM_17_EXI_18NO";
		// 		new ExportDao().exportMidErpItem( tableName);
		
		
        //贺兰菲要的2016与2017年的100kV以上断路器清单。
		//		tableName = "MID_ERP_ITEM_2017CIRCUIT_BREAK";
		//		new ExportDao().exportMidErpItem( tableName);
		//		tableName = "MID_ERP_ITEM_2016CIRCUIT_BREAK";
		//		new ExportDao().exportMidErpItem( tableName);
		
		
        //2017年存在，但2018年不存在或被过滤掉的记录明细
		// 				tableName = "MID_ERP_ITEM_17_EXI_18_FILED";
		// 				new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_2017_6_CLASS";
		//		new ExportDao().exportMidErpItem( tableName);
		

		//		tableName = "MID_ERP_ITEM_2017_9_1";
		//		new ExportDao().exportMidErpItem( tableName);
		//		tableName = "MID_ERP_ITEM_2017_9_2_1";
		//		new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_2017_9_2_2";
		//		new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_2017_9_2_3_1";
		//		new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_2017_9_2_3_2";
		//		new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_2017_9_2_3_3";
		//		new ExportDao().exportMidErpItem( tableName);

		//tableName = "MID_ERP_ITEM_2017_9_2_3_4";
		//new ExportDao().exportMidErpItem( tableName);
		

		//		tableName = "MID_ERP_ITEM_2017_9_2_3_5";
		//		new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_2017_9_3_1";
		//		new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_2017_9_3_2";
		//		new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_2017_9_3_3";
		//		new ExportDao().exportMidErpItem( tableName);


		//		tableName = "MID_ERP_ITEM_2017_9_3_4";
		//		new ExportDao().exportMidErpItem( tableName);
		


		//		tableName = "MID_ERP_ITEM_2017_9_4";
		//		new ExportDao().exportMidErpItem( tableName);
		


		//		tableName = "MID_ERP_ITEM_2017_9_5_1";
		//		new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_2017_9_5_2";
		//		new ExportDao().exportMidErpItem( tableName);
		

		//		tableName = "MID_ERP_ITEM_2017_9_5_3";
		//		new ExportDao().exportMidErpItem( tableName);
		

		//		tableName = "MID_ERP_ITEM_2017_9_6";
		//		new ExportDao().exportMidErpItem( tableName);
		
		//		tableName = "MID_ERP_ITEM_2017_9_7";
		//		new ExportDao().exportMidErpItem( tableName);
		

		//		tableName = "MID_ERP_ITEM_2017_9_8";
		//		new ExportDao().exportMidErpItem( tableName);
		

		//		tableName = "MID_ERP_ITEM_2017_9_9";
		//		new ExportDao().exportMidErpItem( tableName);
		//		tableName = "MID_ERP_ITEM_2017_9_10";
		//		new ExportDao().exportMidErpItem( tableName);
		//		tableName = "MID_ERP_ITEM_18_3_A_MAIN_500";
		//		new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_18_4_H_MAIN_500";
		//		new ExportDao().exportMidErpItem( tableName);
		//		tableName = "MID_ERP_ITEM_17_9_H_CIR_BREAK";
		//		new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_18_5_H_CIR_BREAK";
		//		new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_18_3_A_CIR_BREAK";
		//		new ExportDao().exportMidErpItem( tableName);

		//		tableName = "MID_ERP_ITEM_17_9_A_MAIN_500";
		//		new ExportDao().exportMidErpItem( tableName);

		
		
		
		
		
		
		
		
		// tableName = "BIC_AZFI_SWZC00_182";
		// new ExportDao().exportBicAzfiSwzc( tableName);

		// 		tableName = "BIC_AZFI_SWZC_UNION_ALL_FILED";
		// 		new ExportDao().exportBicAzfiSwzc( tableName);

		
		
		
		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_2_1";
		//		new ExportDao().exportBicAzfiSwzc( tableName);
		
		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_2_2";
		//		new ExportDao().exportBicAzfiSwzc( tableName);

		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_2_3_11";
		//		new ExportDao().exportBicAzfiSwzc( tableName);

		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_2_3_12";
		//		new ExportDao().exportBicAzfiSwzc( tableName);

		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_2_3_13";
		//		new ExportDao().exportBicAzfiSwzc( tableName);

		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_2_3_14";
		//		new ExportDao().exportBicAzfiSwzc( tableName);
		
		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_2_3_2";
		//		new ExportDao().exportBicAzfiSwzc( tableName);
		
		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_2_3_3";
		//		new ExportDao().exportBicAzfiSwzc( tableName);


		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_2_3_4";
		//		new ExportDao().exportBicAzfiSwzc( tableName);
		
		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_2_3_5";
		//		new ExportDao().exportBicAzfiSwzc( tableName);

		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_2_3_6";
		//		new ExportDao().exportBicAzfiSwzc( tableName);


		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_3_1_11";
		//		new ExportDao().exportBicAzfiSwzc( tableName);
		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_3_1_12";
		//		new ExportDao().exportBicAzfiSwzc( tableName);
		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_3_2_2";
		//		new ExportDao().exportBicAzfiSwzc( tableName);
		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_3_2_1";
		//		new ExportDao().exportBicAzfiSwzc( tableName);
		
		//tableName = "BIC_AZFI_SWZC_UNION_ALL_3_1_2";
		//		new ExportDao().exportBicAzfiSwzc( tableName);
		//tableName = "BIC_AZFI_SWZC_UNION_ALL_3_1_3";
		//		new ExportDao().exportBicAzfiSwzc( tableName);


		// 		tableName = "BIC_AZFI_SWZC_UNION_ALL_4";
		// 		new ExportDao().exportBicAzfiSwzc( tableName);

		
		// originalValueTooLowerExport();

		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_5_1";
		//		new ExportDao().exportBicAzfiSwzc( tableName);
		

		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_5_3";
		//		new ExportDao().exportBicAzfiSwzc( tableName);

		// 		tableName = "BIC_AZFI_SWZC_UNION_ALL_6";
		//   	new ExportDao().exportBicAzfiSwzc( tableName);
		
		// 		tableName = "BIC_AZFI_SWZC_UNION_ALL_7";
		// 		new ExportDao().exportBicAzfiSwzc( tableName);

		// 		tableName = "BIC_AZFI_SWZC_UNION_ALL_8";
		// 		new ExportDao().exportBicAzfiSwzc( tableName);


		// 		tableName = "BIC_AZFI_SWZC_UNION_ALL_9";
		// 		new ExportDao().exportBicAzfiSwzc( tableName);


		// 		tableName = "BIC_AZFI_SWZC_UNION_ALL_10";
		// 		new ExportDao().exportBicAzfiSwzc( tableName);
		//		tableName = "BIC_AZFI_SWZC_UNION_ALL_H_OUT";
		//		new ExportDao().exportBicAzfiSwzc( tableName);

		
		
		
		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		// 		tableName = "BIC_AZFI_SWZC_1_CLASS_WRO";
		//		new ExportDao().exportBicAzfiSwzc( tableName);
		// tableName = "BIC_AZFI_SWZC_2_CLASS_WRO";
		// new ExportDao().exportBicAzfiSwzc( tableName);
		// tableName = "BIC_AZFI_SWZC_3_CLASS_WRO";
		// new ExportDao().exportBicAzfiSwzc( tableName);
		// tableName = "BIC_AZFI_SWZC_5_CLASS_WRO";
		// new ExportDao().exportBicAzfiSwzc( tableName);
		// tableName = "BIC_AZFI_SWZC_7_CLASS_WRO";
		// new ExportDao().exportBicAzfiSwzc( tableName);
		// tableName = "BIC_AZFI_SWZC_FB_UNCLASSED";
		// new ExportDao().exportBicAzfiSwzc( tableName);
		// tableName = "BIC_AZFI_SWZC_CLASSED_VOL_NULL";
		// new ExportDao().exportBicAzfiSwzc( tableName);
		// tableName = "ZFI_SWZC";
		// new ExportDao().exportZfiSwzc(tableName);

		// tableName = "BIC_AZFI_SWZC_UNIALL_ORI_NET_0";
		// new ExportDao().exportBicAzfiSwzc( tableName);

		// tableName="BIC_AZFI_SWZC_UNIALL_CLA_UNMAT";
		// new ExportDao().exportBicAzfiSwzc( tableName);
		// tableName="BIC_AZFI_SWZC_UNION_ALL";
		// new ExportDao().exportBicAzfiSwzc( tableName);
		// 		tableName="BIC_AZFI_SWZC_UNION_ALL";
		// 		new ExportDao().exportBicAzfiSwzc( tableName);
		
		// tableName = "BIC_AZFI_SWZC00_182_UNCLASSED";
		// new ExportDao().exportBicAzfiSwzc( tableName);
		// tableName = "MID_ERP_ITEM_2016_V6_PAR1";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);
		// tableName = "MID_ERP_ITEM_2016_V6_PAR2";
		// new ExportToExcelXls().exportMidErpItem(tableName, recordQuantity);
		// tableName = "MID_ERP_ITEM_2016_V6_PAR3";
		// new ExportToExcelXls().exportMidErpItem(tableName,recordQuantity);

		
		
		// 
		 Connection conn = null;
		// 
		 conn = DbUtil.getConnection();

		// 
		 tableName = "BIC_AZFI_SWZC00_182_18_1";
		// 		 new ExportToExcelXls().exportBicAzfiSwzc00( conn,tableName, recordQuantity);
		// tableName = "BIC_AZFI_SWZC00_182_17_1_2";
		// new ExportToExcelXls().exportBicAzfiSwzc00( conn,tableName, recordQuantity);
		// tableName = "BIC_AZFI_SWZC00_182_18_2";
		// new ExportToExcelXls().exportBicAzfiSwzc00(tableName, recordQuantity);
		// tableName = "BIC_AZFI_SWZC00_182_18_3";
		// new ExportToExcelXls().exportBicAzfiSwzc00(tableName, recordQuantity);
		// tableName = "BIC_AZFI_SWZC00_182_18_4";
		// new ExportToExcelXls().exportBicAzfiSwzc00(tableName, recordQuantity);
		// tableName = "BIC_AZFI_SWZC00_182_18_5";
		// new ExportToExcelXls().exportBicAzfiSwzc00(tableName, recordQuantity);
		// tableName = "BIC_AZFI_SWZC00_182_18_6";
		// new ExportToExcelXls().exportBicAzfiSwzc00(tableName, recordQuantity);
		//ERP方面日期问题与资产原值净值等于0、小于0、原值比净值小等异常数据的批量导出。
		//errorDateExport();

	}

	public static void errorDateExport() {
		// 出厂日期晚于统计年份
		manufactureDateLaterThanNowDataExport();
		// 投运日期晚于统计年份
		deliveryDateLaterThanNowDataExport();
		// 出厂日期晚于投运日期
		manufactureDateLaterThanDeliveryDateDataExport();
		// 出厂日期晚于转资日期
		manufactureDateLaterThanCapitalizationDateDataExport();
		//  投运日期晚于转资日期
		deliveryDateLaterThanCapitalizationDateDataExport();
		// 转资日期晚于统计年份
		capitalizationDateLaterThanNowDataExport();
		// 净值等于0
		netValueEqualZeroDataExport() ;
		// 净值或原值小于0
		netOrOrigValueLessThanZeroDataExport();
		// 原值等于0
		originalValueEqualZeroDataExport();
		// 原值小于净值
		originalValueLessThanNetValueDataExport();
		// 原值和净值都等于0
		netAndOriginalValueEqualZeroDataExport();

	}

	public static void netAndOriginalValueEqualZeroDataExport() {

		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String tableName = "MID_ERP_ITEM";
		String errorDateTableName = tableName + "_NET_A_ORI_EQ_0_"
				+ (new Integer(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().substring(2, 4)) - 1);
		String createTableSql = "CREATE TABLE " + errorDateTableName + " AS SELECT * FROM " + tableName + " A  "
				+ "WHERE (A.NET_VALUE=0 OR A.NET_VALUE IS NULL ) AND (A.ORIGINAL_VALUE=0 OR A.ORIGINAL_VALUE IS NULL )"
				+ "ORDER BY EQUIPMENT_STATUS";
		System.out.println("createTableSql=" + createTableSql);
		try {
			pre = conn.prepareStatement(createTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句 

		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		new ExportDao().exportMidErpItem(errorDateTableName);
		String dropTableSql = "DROP TABLE " + errorDateTableName + " ";

		System.out.println("dropTableSql=" + dropTableSql);
		try {
			pre = conn.prepareStatement(dropTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句

	}

	public static void originalValueLessThanNetValueDataExport() {

		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String tableName = "MID_ERP_ITEM";
		String errorDateTableName = tableName + "_ORI_LE_THA_NET_"
				+ (new Integer(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().substring(2, 4)) - 1);
		String createTableSql = "CREATE TABLE " + errorDateTableName + " AS SELECT * FROM " + tableName + " A  "
				+ "WHERE (ORIGINAL_VALUE<NET_VALUE) ORDER BY EQUIPMENT_STATUS,ORIGINAL_VALUE ";
		System.out.println("createTableSql=" + createTableSql);
		try {
			pre = conn.prepareStatement(createTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句
		
		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		new ExportDao().exportMidErpItem(errorDateTableName);
		String dropTableSql = "DROP TABLE " + errorDateTableName + " ";

		System.out.println("dropTableSql=" + dropTableSql);
		try {
			pre = conn.prepareStatement(dropTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句

	}

	public static void originalValueEqualZeroDataExport() {

		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String tableName = "MID_ERP_ITEM";
		String errorDateTableName = tableName + "_ORIG_VAL_EQU_0_"
				+ (new Integer(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().substring(2, 4)) - 1);
		String createTableSql = "CREATE TABLE " + errorDateTableName + " AS SELECT * FROM " + tableName + " A  "
				+ "WHERE (A.ORIGINAL_VALUE=0 OR A.ORIGINAL_VALUE IS NULL ) ORDER BY EQUIPMENT_STATUS,ORIGINAL_VALUE ";
		System.out.println("createTableSql=" + createTableSql);
		try {
			pre = conn.prepareStatement(createTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句 
		
		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		new ExportDao().exportMidErpItem(errorDateTableName);
		String dropTableSql = "DROP TABLE " + errorDateTableName + " ";

		System.out.println("dropTableSql=" + dropTableSql);
		try {
			pre = conn.prepareStatement(dropTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句

	}

	public static void netValueEqualZeroDataExport() {

		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String tableName = "MID_ERP_ITEM";
		String errorDateTableName = tableName + "_NET_VAL_EQU_0_"
				+ (new Integer(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().substring(2, 4)) - 1);
		String createTableSql = "CREATE TABLE " + errorDateTableName + " AS SELECT * FROM " + tableName + " A  "
				+ "WHERE (A.NET_VALUE=0 OR A.NET_VALUE IS NULL ) ORDER BY EQUIPMENT_STATUS";
		System.out.println("createTableSql=" + createTableSql);
		try {
			pre = conn.prepareStatement(createTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句
		
		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		new ExportDao().exportMidErpItem(errorDateTableName);
		String dropTableSql = "DROP TABLE " + errorDateTableName + " ";

		System.out.println("dropTableSql=" + dropTableSql);
		try {
			pre = conn.prepareStatement(dropTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句

	}

	public static void netOrOrigValueLessThanZeroDataExport() {

		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String tableName = "MID_ERP_ITEM";
		String errorDateTableName = tableName + "_NET_ORI_LES_0_"
				+ (new Integer(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().substring(2, 4)) - 1);
		String createTableSql = "CREATE TABLE " + errorDateTableName + " AS SELECT * FROM " + tableName + " A  "
				+ "WHERE (ORIGINAL_VALUE<0 OR NET_VALUE<0) ORDER BY EQUIPMENT_STATUS";
		System.out.println("createTableSql=" + createTableSql);
		try {
			pre = conn.prepareStatement(createTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句
		
		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		new ExportDao().exportMidErpItem(errorDateTableName);
		String dropTableSql = "DROP TABLE " + errorDateTableName + " ";

		System.out.println("dropTableSql=" + dropTableSql);
		try {
			pre = conn.prepareStatement(dropTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句

	}

	public static void deliveryDateLaterThanCapitalizationDateDataExport() {

		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String tableName = "MID_ERP_ITEM";
		String errorDateTableName = tableName + "_MANU_LAT_CAPI_"
				+ (new Integer(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().substring(2, 4)) - 1);
		String createTableSql = "CREATE TABLE " + errorDateTableName + " AS SELECT * FROM " + tableName + " A  "
				+ "WHERE (EXTRACT(YEAR FROM DELIVERY_DATE)-EXTRACT(YEAR FROM CAPITALIZATION_DATE))>0";
		System.out.println("createTableSql=" + createTableSql);
		try {
			pre = conn.prepareStatement(createTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句
		
		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		new ExportDao().exportMidErpItem(errorDateTableName);
		String dropTableSql = "DROP TABLE " + errorDateTableName + " ";

		System.out.println("dropTableSql=" + dropTableSql);
		try {
			pre = conn.prepareStatement(dropTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句

	}

	public static void manufactureDateLaterThanCapitalizationDateDataExport() {

		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String tableName = "MID_ERP_ITEM";
		String errorDateTableName = tableName + "_MANU_LATE_CAPI_"
				+ (new Integer(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().substring(2, 4)) - 1);
		String createTableSql = "CREATE TABLE " + errorDateTableName + " AS SELECT * FROM " + tableName + " A  "
				+ "WHERE (EXTRACT(YEAR FROM MANUFACTURE_DATE)-EXTRACT(YEAR FROM CAPITALIZATION_DATE))>0";
		System.out.println("createTableSql=" + createTableSql);
		try {
			pre = conn.prepareStatement(createTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句
		
		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		new ExportDao().exportMidErpItem(errorDateTableName);
		String dropTableSql = "DROP TABLE " + errorDateTableName + " ";

		System.out.println("dropTableSql=" + dropTableSql);
		try {
			pre = conn.prepareStatement(dropTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句

	}

	public static void manufactureDateLaterThanDeliveryDateDataExport() {

		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String tableName = "MID_ERP_ITEM";
		String errorDateTableName = tableName + "_MANU_LAT_DELI"
				+ (new Integer(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().substring(2, 4)) - 1);
		String createTableSql = "CREATE TABLE " + errorDateTableName + " AS SELECT * FROM " + tableName + " A  "
				+ "WHERE (EXTRACT(YEAR FROM MANUFACTURE_DATE)-EXTRACT(YEAR FROM DELIVERY_DATE))>0 ";
		System.out.println("createTableSql=" + createTableSql);
		try {
			pre = conn.prepareStatement(createTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		new ExportDao().exportMidErpItem(errorDateTableName);
		String dropTableSql = "DROP TABLE " + errorDateTableName + " ";

		System.out.println("dropTableSql=" + dropTableSql);
		try {
			pre = conn.prepareStatement(dropTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句

	}

	public static void deliveryDateLaterThanNowDataExport() {

		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String tableName = "MID_ERP_ITEM";
		String errorDateTableName = tableName + "_DELI_LAT_THA"
				+ (new Integer(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().substring(2, 4)) - 1);
		String createTableSql = "CREATE TABLE " + errorDateTableName + " AS SELECT * FROM " + tableName + "  A  "
				+ "WHERE EXTRACT(YEAR FROM DELIVERY_DATE)>EXTRACT(YEAR FROM SYSDATE)-1 ";
		System.out.println("createTableSql=" + createTableSql);
		try {
			pre = conn.prepareStatement(createTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		new ExportDao().exportMidErpItem(errorDateTableName);
		String dropTableSql = "DROP TABLE " + errorDateTableName + " ";

		System.out.println("dropTableSql=" + dropTableSql);
		try {
			pre = conn.prepareStatement(dropTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句

	}

	public static void capitalizationDateLaterThanNowDataExport() {

		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String tableName = "MID_ERP_ITEM";
		String errorDateTableName = tableName + "_CAPIT_LAT_THA_"
				+ (new Integer(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().substring(2, 4)) - 1);
		String createTableSql = "CREATE TABLE " + errorDateTableName + " AS SELECT * FROM " + tableName + "  A  "
				+ "WHERE EXTRACT(YEAR FROM CAPITALIZATION_DATE)>EXTRACT(YEAR FROM SYSDATE)-1 ";
		System.out.println("createTableSql=" + createTableSql);
		try {
			pre = conn.prepareStatement(createTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		new ExportDao().exportMidErpItem(errorDateTableName);
		String dropTableSql = "DROP TABLE " + errorDateTableName + " ";

		System.out.println("dropTableSql=" + dropTableSql);
		try {
			pre = conn.prepareStatement(dropTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句

	}

	public static void originalValueTooLowerExport() {

		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String tableName = "MID_ERP_ITEM";//MID_ERP_ITEM_ORI_VAL_2_LOWER
		String errorDateTableName = "MID_ERP_ITEM_ORI_VAL_2_LOWER"; 
		/*String createTableSql = "CREATE TABLE " + errorDateTableName + " AS SELECT * FROM " + tableName + "  A  "
				+ "WHERE EXTRACT(YEAR FROM CAPITALIZATION_DATE)>EXTRACT(YEAR FROM SYSDATE)-1 ";
		System.out.println("createTableSql=" + createTableSql);
		try {
			pre = conn.prepareStatement(createTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		*/
		
		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		//new ExportDao().exportMidErpItem(errorDateTableName);
		 

	}
	
	
	public static void manufactureDateLaterThanNowDataExport() {

		Connection conn = null;
		conn = DbUtil.getConnection();
		// 创建预编译语句对象，一般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		String tableName = "MID_ERP_ITEM";
		String errorDateTableName = tableName + "_MANUF_LAT_THA_"
				+ (new Integer(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().substring(2, 4)) - 1);
		String createTableSql = "CREATE TABLE " + errorDateTableName + " AS SELECT * FROM " + tableName + "  A  "
				+ "WHERE EXTRACT(YEAR FROM MANUFACTURE_DATE)>EXTRACT(YEAR FROM SYSDATE)-1 ";
		System.out.println("createTableSql=" + createTableSql);
		try {
			pre = conn.prepareStatement(createTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//实现对内存的使用量的监控，防止一次读入的数据量过大，出现内存溢出。
		new ExportDao().exportMidErpItem(errorDateTableName);
		String dropTableSql = "DROP TABLE " + errorDateTableName + " ";

		System.out.println("dropTableSql=" + dropTableSql);
		try {
			pre = conn.prepareStatement(dropTableSql);
			pre.execute();// 执行查询，注意括号中不需要再加参数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 实例化预编译语句

	}

	public void exportBicAzfiSwzc00(Connection conn, String tableName, int recordQuantity) {
		try {
			Date now = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
			String nowdate = df.format(now);
			// 打开文件
			WritableWorkbook book = Workbook.createWorkbook(new File("D:/temp/" + tableName + nowdate + ".xls"));
			System.out.println(book);
			System.out.println("D:/temp/" + tableName + nowdate + ".xls");
			// 生成名为"第一页"的工作表，参数0表示这是第一
			WritableSheet sheet = book.createSheet("第一页", 0);

			// 设置字体为宋体,16号字,加粗,颜色为黑色
			WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
			font1.setColour(Colour.BLACK);
			WritableCellFormat format1 = new WritableCellFormat(font1);
			format1.setAlignment(jxl.format.Alignment.CENTRE);
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Label label0 = new Label(0, 0, "CALYEAR", format1);
			Label label1 = new Label(1, 0, "COMP_CODE", format1);
			Label label2 = new Label(2, 0, "ASSET_MAIN", format1);
			Label label3 = new Label(3, 0, "ASSET", format1);
			Label label4 = new Label(4, 0, "ZIO_EQUNR", format1);
			Label label5 = new Label(5, 0, "CURRENCY", format1);
			Label label6 = new Label(6, 0, "ZPMZCYZ", format1);
			Label label7 = new Label(7, 0, "ZPMZCJZ", format1);
			Label label8 = new Label(8, 0, "ZTYPBZ1", format1);
			Label label9 = new Label(9, 0, "ZTYPBZ2", format1);
			Label label10 = new Label(10, 0, "ZTYPBZ3", format1);
			Label label11 = new Label(11, 0, "ZVOL_LEV", format1);
			Label label12 = new Label(12, 0, "ZQUANTITY", format1);
			Label label13 = new Label(13, 0, "UNIT", format1);
			Label label14 = new Label(14, 0, "ZIO_ZCZT", format1);
			Label label15 = new Label(15, 0, "PROFIT_CTR", format1);
			Label label16 = new Label(16, 0, "ZLRZX", format1);
			Label label17 = new Label(17, 0, "CO_AREA", format1);
			Label label18 = new Label(18, 0, "ZZCMS", format1);
			Label label19 = new Label(19, 0, "ZIO_ZXMLX", format1);
			Label label20 = new Label(20, 0, "CAPIT_DATE", format1);
			Label label21 = new Label(21, 0, "ZDEAKT", format1);
			Label label22 = new Label(22, 0, "ASSET_CLAS", format1);
			Label label23 = new Label(23, 0, "ZXLH", format1);
			Label label24 = new Label(24, 0, "ZINVNR", format1);
			Label label25 = new Label(25, 0, "ZI0_ZZC1", format1);
			Label label26 = new Label(26, 0, "ZI0_ZZC2", format1);
			Label label27 = new Label(27, 0, "ZIO_KOSTL", format1);
			Label label28 = new Label(28, 0, "ZKOSTLV", format1);
			Label label29 = new Label(29, 0, "ZIO_RAUMN", format1);
			Label label30 = new Label(30, 0, "ZZZPH", format1);
			Label label31 = new Label(31, 0, "ZZKOSTL", format1);
			Label label32 = new Label(32, 0, "ZIO_ZZC06", format1);
			Label label33 = new Label(33, 0, "ZIO_ZZC07", format1);
			Label label34 = new Label(34, 0, "ZIO_ORD41", format1);
			Label label35 = new Label(35, 0, "ZORD44", format1);
			Label label36 = new Label(36, 0, "ZGDLGRP", format1);
			Label label37 = new Label(37, 0, "ZZCLY", format1);
			Label label38 = new Label(38, 0, "ZIO_UMWKZ", format1);
			Label label39 = new Label(39, 0, "ZSFDG", format1);
			Label label40 = new Label(40, 0, "ZIO_HERST", format1);
			Label label41 = new Label(41, 0, "ZTYPBZ", format1);
			Label label42 = new Label(42, 0, "Z_POSID", format1);
			Label label43 = new Label(43, 0, "ZPOST11", format1);
			Label label44 = new Label(44, 0, "ZFIAMT", format1);
			Label label45 = new Label(45, 0, "ZIO_STADT", format1);
			Label label46 = new Label(46, 0, "ZFWCQZH", format1);
			Label label47 = new Label(47, 0, "ZIO_EQKTX", format1);
			Label label48 = new Label(48, 0, "ZIO_TXT04", format1);
			Label label49 = new Label(49, 0, "ZIO_EQART", format1);
			Label label50 = new Label(50, 0, "ZPMSQZ", format1);
			Label label51 = new Label(51, 0, "ZIO_INBDT", format1);
			Label label52 = new Label(52, 0, "ZIO_ZCCRQ", format1);
			Label label53 = new Label(53, 0, "ZZZS", format1);
			Label label54 = new Label(54, 0, "ZIO_HERLD", format1);
			Label label55 = new Label(55, 0, "ZIO_MAPAR", format1);
			Label label56 = new Label(56, 0, "ZTXZ012", format1);
			Label label57 = new Label(57, 0, "ZIO_SERGE", format1);
			Label label58 = new Label(58, 0, "ZIO_SWERK", format1);
			Label label59 = new Label(59, 0, "ZIO_STORT", format1);
			Label label60 = new Label(60, 0, "ZIO_BEBER", format1);
			Label label61 = new Label(61, 0, "ZIO_ABCKZ", format1);
			Label label62 = new Label(62, 0, "ZIO_EQFNR", format1);
			Label label63 = new Label(63, 0, "ZIO_ZZC02", format1);
			Label label64 = new Label(64, 0, "Z_PROJK", format1);
			Label label65 = new Label(65, 0, "ZWBSNM", format1);
			Label label66 = new Label(66, 0, "ZIO_IWERK", format1);
			Label label67 = new Label(67, 0, "ZIO_INGRP", format1);
			Label label68 = new Label(68, 0, "ZIO_VAPLZ", format1);
			Label label69 = new Label(69, 0, "ZIO_TPLNR", format1);
			Label label70 = new Label(70, 0, "ZIO_HEQUI", format1);
			Label label71 = new Label(71, 0, "ZIO_TIDNR", format1);
			Label label72 = new Label(72, 0, "ZIO_SB010", format1);
			Label label73 = new Label(73, 0, "ZIO_SB001", format1);
			Label label74 = new Label(74, 0, "ZIO_SB002", format1);
			Label label75 = new Label(75, 0, "ZIO_SB004", format1);
			Label label76 = new Label(76, 0, "ZIO_SB005", format1);
			Label label77 = new Label(77, 0, "ZIO_SB006", format1);
			Label label78 = new Label(78, 0, "ZIO_SB003", format1);
			Label label79 = new Label(79, 0, "ZIO_SB007", format1);
			Label label80 = new Label(80, 0, "ZIO_SB008", format1);
			Label label81 = new Label(81, 0, "ZLENUNT", format1);
			Label label82 = new Label(82, 0, "ZIO_SB009", format1);
			Label label83 = new Label(83, 0, "ZCAPUNT", format1);
			Label label84 = new Label(84, 0, "ZIO_SB011", format1);
			Label label85 = new Label(85, 0, "ZIO_UMLGO", format1);
			Label label86 = new Label(86, 0, "ZIO_GPLAB", format1);
			Label label87 = new Label(87, 0, "ZIO_POSID", format1);
			Label label88 = new Label(88, 0, "ZLYRKRQ", format1);
			Label label89 = new Label(89, 0, "ZLYCKRQ", format1);
			Label label90 = new Label(90, 0, "ZPOST1", format1);
			Label label91 = new Label(91, 0, "ZIO_CUSRE", format1);
			Label label92 = new Label(92, 0, "ZBFYY", format1);
			Label label93 = new Label(93, 0, "ZIO_ZSB13", format1);
			Label label94 = new Label(94, 0, "ZIO_ZSB12", format1);
			Label label95 = new Label(95, 0, "RECORDMODE", format1);
			// 将定义好的单元格添加到工作表中
			sheet.addCell(label0);
			sheet.addCell(label1);
			sheet.addCell(label2);
			sheet.addCell(label3);
			sheet.addCell(label4);
			sheet.addCell(label5);
			sheet.addCell(label6);
			sheet.addCell(label7);
			sheet.addCell(label8);
			sheet.addCell(label9);
			sheet.addCell(label10);
			sheet.addCell(label11);
			sheet.addCell(label12);
			sheet.addCell(label13);
			sheet.addCell(label14);
			sheet.addCell(label15);
			sheet.addCell(label16);
			sheet.addCell(label17);
			sheet.addCell(label18);
			sheet.addCell(label19);
			sheet.addCell(label20);
			sheet.addCell(label21);
			sheet.addCell(label22);
			sheet.addCell(label23);
			sheet.addCell(label24);
			sheet.addCell(label25);
			sheet.addCell(label26);
			sheet.addCell(label27);
			sheet.addCell(label28);
			sheet.addCell(label29);
			sheet.addCell(label30);
			sheet.addCell(label31);
			sheet.addCell(label32);
			sheet.addCell(label33);
			sheet.addCell(label34);
			sheet.addCell(label35);
			sheet.addCell(label36);
			sheet.addCell(label37);
			sheet.addCell(label38);
			sheet.addCell(label39);
			sheet.addCell(label40);
			sheet.addCell(label41);
			sheet.addCell(label42);
			sheet.addCell(label43);
			sheet.addCell(label44);
			sheet.addCell(label45);
			sheet.addCell(label46);
			sheet.addCell(label47);
			sheet.addCell(label48);
			sheet.addCell(label49);
			sheet.addCell(label50);
			sheet.addCell(label51);
			sheet.addCell(label52);
			sheet.addCell(label53);
			sheet.addCell(label54);
			sheet.addCell(label55);
			sheet.addCell(label56);
			sheet.addCell(label57);
			sheet.addCell(label58);
			sheet.addCell(label59);
			sheet.addCell(label60);
			sheet.addCell(label61);
			sheet.addCell(label62);
			sheet.addCell(label63);
			sheet.addCell(label64);
			sheet.addCell(label65);
			sheet.addCell(label66);
			sheet.addCell(label67);
			sheet.addCell(label68);
			sheet.addCell(label69);
			sheet.addCell(label70);
			sheet.addCell(label71);
			sheet.addCell(label72);
			sheet.addCell(label73);
			sheet.addCell(label74);
			sheet.addCell(label75);
			sheet.addCell(label76);
			sheet.addCell(label77);
			sheet.addCell(label78);
			sheet.addCell(label79);
			sheet.addCell(label80);
			sheet.addCell(label81);
			sheet.addCell(label82);
			sheet.addCell(label83);
			sheet.addCell(label84);
			sheet.addCell(label85);
			sheet.addCell(label86);
			sheet.addCell(label87);
			sheet.addCell(label88);
			sheet.addCell(label89);
			sheet.addCell(label90);
			sheet.addCell(label91);
			sheet.addCell(label92);
			sheet.addCell(label93);
			sheet.addCell(label94);
			sheet.addCell(label95);

			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			ResultSet result = null;
			// String sql = "select * from " + tableName;// 预编译语句
			// System.out.println("sql=" + sql);
			// pre = conn.prepareStatement(sql);// 实例化预编译语句
			// result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			// 查询数据库中所有的数据
			List<BicAzfiSwzc> list = PmsQuexianService.getAllBicAzfiSwzc(conn, tableName);
			System.out.println(list.size());
			// System.out.println("------------------------"+list.toString());

			// while (result.next()) {
			for (int i = 0; i < list.size(); i++) {
				int j = i / recordQuantity;

				// System.out.println("i=" + i);
				// System.out.println("(i % 65534) == 0 && i != 0)="+((i %
				// 65534) == 0 && i != 0));
				if ((i % recordQuantity) == 0 && i != 0) {
					// 写入数据并关闭文件
					// System.out.println("I'm Here!");
					book.write();
					book.close();
					df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
					now = new Date();
					nowdate = df.format(now);
					// System.out.println("D:/temp/" + tableName + nowdate +j+
					// ".xls");
					book = Workbook.createWorkbook(new File("D:/temp/" + tableName + nowdate + j + ".xls"));
					// System.out.println("D:/temp/" + tableName + nowdate +j+
					// ".xls");

					sheet = book.createSheet("第一页", 0);
					label0 = new Label(0, 0, "CALYEAR", format1);
					label1 = new Label(1, 0, "COMP_CODE", format1);
					label2 = new Label(2, 0, "ASSET_MAIN", format1);
					label3 = new Label(3, 0, "ASSET", format1);
					label4 = new Label(4, 0, "ZIO_EQUNR", format1);
					label5 = new Label(5, 0, "CURRENCY", format1);
					label6 = new Label(6, 0, "ZPMZCYZ", format1);
					label7 = new Label(7, 0, "ZPMZCJZ", format1);
					label8 = new Label(8, 0, "ZTYPBZ1", format1);
					label9 = new Label(9, 0, "ZTYPBZ2", format1);
					label10 = new Label(10, 0, "ZTYPBZ3", format1);
					label11 = new Label(11, 0, "ZVOL_LEV", format1);
					label12 = new Label(12, 0, "ZQUANTITY", format1);
					label13 = new Label(13, 0, "UNIT", format1);
					label14 = new Label(14, 0, "ZIO_ZCZT", format1);
					label15 = new Label(15, 0, "PROFIT_CTR", format1);
					label16 = new Label(16, 0, "ZLRZX", format1);
					label17 = new Label(17, 0, "CO_AREA", format1);
					label18 = new Label(18, 0, "ZZCMS", format1);
					label19 = new Label(19, 0, "ZIO_ZXMLX", format1);
					label20 = new Label(20, 0, "CAPIT_DATE", format1);
					label21 = new Label(21, 0, "ZDEAKT", format1);
					label22 = new Label(22, 0, "ASSET_CLAS", format1);
					label23 = new Label(23, 0, "ZXLH", format1);
					label24 = new Label(24, 0, "ZINVNR", format1);
					label25 = new Label(25, 0, "ZI0_ZZC1", format1);
					label26 = new Label(26, 0, "ZI0_ZZC2", format1);
					label27 = new Label(27, 0, "ZIO_KOSTL", format1);
					label28 = new Label(28, 0, "ZKOSTLV", format1);
					label29 = new Label(29, 0, "ZIO_RAUMN", format1);
					label30 = new Label(30, 0, "ZZZPH", format1);
					label31 = new Label(31, 0, "ZZKOSTL", format1);
					label32 = new Label(32, 0, "ZIO_ZZC06", format1);
					label33 = new Label(33, 0, "ZIO_ZZC07", format1);
					label34 = new Label(34, 0, "ZIO_ORD41", format1);
					label35 = new Label(35, 0, "ZORD44", format1);
					label36 = new Label(36, 0, "ZGDLGRP", format1);
					label37 = new Label(37, 0, "ZZCLY", format1);
					label38 = new Label(38, 0, "ZIO_UMWKZ", format1);
					label39 = new Label(39, 0, "ZSFDG", format1);
					label40 = new Label(40, 0, "ZIO_HERST", format1);
					label41 = new Label(41, 0, "ZTYPBZ", format1);
					label42 = new Label(42, 0, "Z_POSID", format1);
					label43 = new Label(43, 0, "ZPOST11", format1);
					label44 = new Label(44, 0, "ZFIAMT", format1);
					label45 = new Label(45, 0, "ZIO_STADT", format1);
					label46 = new Label(46, 0, "ZFWCQZH", format1);
					label47 = new Label(47, 0, "ZIO_EQKTX", format1);
					label48 = new Label(48, 0, "ZIO_TXT04", format1);
					label49 = new Label(49, 0, "ZIO_EQART", format1);
					label50 = new Label(50, 0, "ZPMSQZ", format1);
					label51 = new Label(51, 0, "ZIO_INBDT", format1);
					label52 = new Label(52, 0, "ZIO_ZCCRQ", format1);
					label53 = new Label(53, 0, "ZZZS", format1);
					label54 = new Label(54, 0, "ZIO_HERLD", format1);
					label55 = new Label(55, 0, "ZIO_MAPAR", format1);
					label56 = new Label(56, 0, "ZTXZ012", format1);
					label57 = new Label(57, 0, "ZIO_SERGE", format1);
					label58 = new Label(58, 0, "ZIO_SWERK", format1);
					label59 = new Label(59, 0, "ZIO_STORT", format1);
					label60 = new Label(60, 0, "ZIO_BEBER", format1);
					label61 = new Label(61, 0, "ZIO_ABCKZ", format1);
					label62 = new Label(62, 0, "ZIO_EQFNR", format1);
					label63 = new Label(63, 0, "ZIO_ZZC02", format1);
					label64 = new Label(64, 0, "Z_PROJK", format1);
					label65 = new Label(65, 0, "ZWBSNM", format1);
					label66 = new Label(66, 0, "ZIO_IWERK", format1);
					label67 = new Label(67, 0, "ZIO_INGRP", format1);
					label68 = new Label(68, 0, "ZIO_VAPLZ", format1);
					label69 = new Label(69, 0, "ZIO_TPLNR", format1);
					label70 = new Label(70, 0, "ZIO_HEQUI", format1);
					label71 = new Label(71, 0, "ZIO_TIDNR", format1);
					label72 = new Label(72, 0, "ZIO_SB010", format1);
					label73 = new Label(73, 0, "ZIO_SB001", format1);
					label74 = new Label(74, 0, "ZIO_SB002", format1);
					label75 = new Label(75, 0, "ZIO_SB004", format1);
					label76 = new Label(76, 0, "ZIO_SB005", format1);
					label77 = new Label(77, 0, "ZIO_SB006", format1);
					label78 = new Label(78, 0, "ZIO_SB003", format1);
					label79 = new Label(79, 0, "ZIO_SB007", format1);
					label80 = new Label(80, 0, "ZIO_SB008", format1);
					label81 = new Label(81, 0, "ZLENUNT", format1);
					label82 = new Label(82, 0, "ZIO_SB009", format1);
					label83 = new Label(83, 0, "ZCAPUNT", format1);
					label84 = new Label(84, 0, "ZIO_SB011", format1);
					label85 = new Label(85, 0, "ZIO_UMLGO", format1);
					label86 = new Label(86, 0, "ZIO_GPLAB", format1);
					label87 = new Label(87, 0, "ZIO_POSID", format1);
					label88 = new Label(88, 0, "ZLYRKRQ", format1);
					label89 = new Label(89, 0, "ZLYCKRQ", format1);
					label90 = new Label(90, 0, "ZPOST1", format1);
					label91 = new Label(91, 0, "ZIO_CUSRE", format1);
					label92 = new Label(92, 0, "ZBFYY", format1);
					label93 = new Label(93, 0, "ZIO_ZSB13", format1);
					label94 = new Label(94, 0, "ZIO_ZSB12", format1);
					label95 = new Label(95, 0, "RECORDMODE", format1);

					// 将定义好的单元格添加到工作表中
					sheet.addCell(label0);
					sheet.addCell(label1);
					sheet.addCell(label2);
					sheet.addCell(label3);
					sheet.addCell(label4);
					sheet.addCell(label5);
					sheet.addCell(label6);
					sheet.addCell(label7);
					sheet.addCell(label8);
					sheet.addCell(label9);
					sheet.addCell(label10);
					sheet.addCell(label11);
					sheet.addCell(label12);
					sheet.addCell(label13);
					sheet.addCell(label14);
					sheet.addCell(label15);
					sheet.addCell(label16);
					sheet.addCell(label17);
					sheet.addCell(label18);
					sheet.addCell(label19);
					sheet.addCell(label20);
					sheet.addCell(label21);
					sheet.addCell(label22);
					sheet.addCell(label23);
					sheet.addCell(label24);
					sheet.addCell(label25);
					sheet.addCell(label26);
					sheet.addCell(label27);
					sheet.addCell(label28);
					sheet.addCell(label29);
					sheet.addCell(label30);
					sheet.addCell(label31);
					sheet.addCell(label32);
					sheet.addCell(label33);
					sheet.addCell(label34);
					sheet.addCell(label35);
					sheet.addCell(label36);
					sheet.addCell(label37);
					sheet.addCell(label38);
					sheet.addCell(label39);
					sheet.addCell(label40);
					sheet.addCell(label41);
					sheet.addCell(label42);
					sheet.addCell(label43);
					sheet.addCell(label44);
					sheet.addCell(label45);
					sheet.addCell(label46);
					sheet.addCell(label47);
					sheet.addCell(label48);
					sheet.addCell(label49);
					sheet.addCell(label50);
					sheet.addCell(label51);
					sheet.addCell(label52);
					sheet.addCell(label53);
					sheet.addCell(label54);
					sheet.addCell(label55);
					sheet.addCell(label56);
					sheet.addCell(label57);
					sheet.addCell(label58);
					sheet.addCell(label59);
					sheet.addCell(label60);
					sheet.addCell(label61);
					sheet.addCell(label62);
					sheet.addCell(label63);
					sheet.addCell(label64);
					sheet.addCell(label65);
					sheet.addCell(label66);
					sheet.addCell(label67);
					sheet.addCell(label68);
					sheet.addCell(label69);
					sheet.addCell(label70);
					sheet.addCell(label71);
					sheet.addCell(label72);
					sheet.addCell(label73);
					sheet.addCell(label74);
					sheet.addCell(label75);
					sheet.addCell(label76);
					sheet.addCell(label77);
					sheet.addCell(label78);
					sheet.addCell(label79);
					sheet.addCell(label80);
					sheet.addCell(label81);
					sheet.addCell(label82);
					sheet.addCell(label83);
					sheet.addCell(label84);
					sheet.addCell(label85);
					sheet.addCell(label86);
					sheet.addCell(label87);
					sheet.addCell(label88);
					sheet.addCell(label89);
					sheet.addCell(label90);
					sheet.addCell(label91);
					sheet.addCell(label92);
					sheet.addCell(label93);
					sheet.addCell(label94);
					sheet.addCell(label95);
					df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					// break;
				}
				// System.out.println("j=" + j);
				int recordQuantityTimes = j * recordQuantity;

				Label labelV0 = new Label(0, i + 1 - recordQuantityTimes, list.get(i).getCalyear());
				Label labelV1 = new Label(1, i + 1 - recordQuantityTimes, list.get(i).getCompCode());
				Label labelV2 = new Label(2, i + 1 - recordQuantityTimes, list.get(i).getAssetMain());
				Label labelV3 = new Label(3, i + 1 - recordQuantityTimes, list.get(i).getAsset());
				Label labelV4 = new Label(4, i + 1 - recordQuantityTimes, list.get(i).getZioEqunr());
				Label labelV5 = new Label(5, i + 1 - recordQuantityTimes, list.get(i).getCurrency());
				Label labelV6 = new Label(6, i + 1 - recordQuantityTimes, list.get(i).getZpmzcyz().toString());
				Label labelV7 = new Label(7, i + 1 - recordQuantityTimes, list.get(i).getZpmzcjz().toString());
				Label labelV8 = new Label(8, i + 1 - recordQuantityTimes, list.get(i).getZtypbz1());
				Label labelV9 = new Label(9, i + 1 - recordQuantityTimes, list.get(i).getZtypbz2());
				Label labelV10 = new Label(10, i + 1 - recordQuantityTimes, list.get(i).getZtypbz3());
				Label labelV11 = new Label(11, i + 1 - recordQuantityTimes, list.get(i).getZvolLev());
				Label labelV12 = new Label(12, i + 1 - recordQuantityTimes, list.get(i).getZquantity().toString());
				Label labelV13 = new Label(13, i + 1 - recordQuantityTimes, list.get(i).getUnit());
				Label labelV14 = new Label(14, i + 1 - recordQuantityTimes, list.get(i).getZioZczt());
				Label labelV15 = new Label(15, i + 1 - recordQuantityTimes, list.get(i).getProfitCtr());
				Label labelV16 = new Label(16, i + 1 - recordQuantityTimes, list.get(i).getZlrzx());
				Label labelV17 = new Label(17, i + 1 - recordQuantityTimes, list.get(i).getCoArea());
				Label labelV18 = new Label(18, i + 1 - recordQuantityTimes, list.get(i).getZzcms());
				Label labelV19 = new Label(19, i + 1 - recordQuantityTimes, list.get(i).getZioZxmlx());
				Label labelV20 = new Label(20, i + 1 - recordQuantityTimes, list.get(i).getCapitDate());
				Label labelV21 = new Label(21, i + 1 - recordQuantityTimes, list.get(i).getZdeakt());
				Label labelV22 = new Label(22, i + 1 - recordQuantityTimes, list.get(i).getAssetClas());
				Label labelV23 = new Label(23, i + 1 - recordQuantityTimes, list.get(i).getZxlh());
				Label labelV24 = new Label(24, i + 1 - recordQuantityTimes, list.get(i).getZinvnr());
				Label labelV25 = new Label(25, i + 1 - recordQuantityTimes, list.get(i).getZi0Zzc1());
				Label labelV26 = new Label(26, i + 1 - recordQuantityTimes, list.get(i).getZi0Zzc2());
				Label labelV27 = new Label(27, i + 1 - recordQuantityTimes, list.get(i).getZioKostl());
				Label labelV28 = new Label(28, i + 1 - recordQuantityTimes, list.get(i).getZkostlv());
				Label labelV29 = new Label(29, i + 1 - recordQuantityTimes, list.get(i).getZioRaumn());
				Label labelV30 = new Label(30, i + 1 - recordQuantityTimes, list.get(i).getZzzph());
				Label labelV31 = new Label(31, i + 1 - recordQuantityTimes, list.get(i).getZzkostl());
				Label labelV32 = new Label(32, i + 1 - recordQuantityTimes, list.get(i).getZioZzc06());
				Label labelV33 = new Label(33, i + 1 - recordQuantityTimes, list.get(i).getZioZzc07());
				Label labelV34 = new Label(34, i + 1 - recordQuantityTimes, list.get(i).getZioOrd41());
				Label labelV35 = new Label(35, i + 1 - recordQuantityTimes, list.get(i).getZord44());
				Label labelV36 = new Label(36, i + 1 - recordQuantityTimes, list.get(i).getZgdlgrp());
				Label labelV37 = new Label(37, i + 1 - recordQuantityTimes, list.get(i).getZzcly());
				Label labelV38 = new Label(38, i + 1 - recordQuantityTimes, list.get(i).getZioUmwkz());
				Label labelV39 = new Label(39, i + 1 - recordQuantityTimes, list.get(i).getZsfdg());
				Label labelV40 = new Label(40, i + 1 - recordQuantityTimes, list.get(i).getZioHerst());
				Label labelV41 = new Label(41, i + 1 - recordQuantityTimes, list.get(i).getZtypbz());
				Label labelV42 = new Label(42, i + 1 - recordQuantityTimes, list.get(i).getzPosid());
				Label labelV43 = new Label(43, i + 1 - recordQuantityTimes, list.get(i).getZpost11());
				Label labelV44 = new Label(44, i + 1 - recordQuantityTimes, list.get(i).getZfiamt());
				Label labelV45 = new Label(45, i + 1 - recordQuantityTimes, list.get(i).getZioStadt());
				Label labelV46 = new Label(46, i + 1 - recordQuantityTimes, list.get(i).getZfwcqzh());
				Label labelV47 = new Label(47, i + 1 - recordQuantityTimes, list.get(i).getZioEqktx());
				Label labelV48 = new Label(48, i + 1 - recordQuantityTimes, list.get(i).getZioTxt04());
				Label labelV49 = new Label(49, i + 1 - recordQuantityTimes, list.get(i).getZioEqart());
				Label labelV50 = new Label(50, i + 1 - recordQuantityTimes, list.get(i).getZpmsqz());
				Label labelV51 = new Label(51, i + 1 - recordQuantityTimes, list.get(i).getZioInbdt());
				Label labelV52 = new Label(52, i + 1 - recordQuantityTimes, list.get(i).getZioZccrq());
				Label labelV53 = new Label(53, i + 1 - recordQuantityTimes, list.get(i).getZzzs());
				Label labelV54 = new Label(54, i + 1 - recordQuantityTimes, list.get(i).getZioHerld());
				Label labelV55 = new Label(55, i + 1 - recordQuantityTimes, list.get(i).getZioMapar());
				Label labelV56 = new Label(56, i + 1 - recordQuantityTimes, list.get(i).getZtxz012());
				Label labelV57 = new Label(57, i + 1 - recordQuantityTimes, list.get(i).getZioSerge());
				Label labelV58 = new Label(58, i + 1 - recordQuantityTimes, list.get(i).getZioSwerk());
				Label labelV59 = new Label(59, i + 1 - recordQuantityTimes, list.get(i).getZioStort());
				Label labelV60 = new Label(60, i + 1 - recordQuantityTimes, list.get(i).getZioBeber());
				Label labelV61 = new Label(61, i + 1 - recordQuantityTimes, list.get(i).getZioAbckz());
				Label labelV62 = new Label(62, i + 1 - recordQuantityTimes, list.get(i).getZioEqfnr());
				Label labelV63 = new Label(63, i + 1 - recordQuantityTimes, list.get(i).getZioZzc02());
				Label labelV64 = new Label(64, i + 1 - recordQuantityTimes, list.get(i).getzProjk());
				Label labelV65 = new Label(65, i + 1 - recordQuantityTimes, list.get(i).getZwbsnm());
				Label labelV66 = new Label(66, i + 1 - recordQuantityTimes, list.get(i).getZioIwerk());
				Label labelV67 = new Label(67, i + 1 - recordQuantityTimes, list.get(i).getZioIngrp());
				Label labelV68 = new Label(68, i + 1 - recordQuantityTimes, list.get(i).getZioVaplz());
				Label labelV69 = new Label(69, i + 1 - recordQuantityTimes, list.get(i).getZioTplnr());
				Label labelV70 = new Label(70, i + 1 - recordQuantityTimes, list.get(i).getZioHequi());
				Label labelV71 = new Label(71, i + 1 - recordQuantityTimes, list.get(i).getZioTidnr());
				Label labelV72 = new Label(72, i + 1 - recordQuantityTimes, list.get(i).getZioSb010());
				Label labelV73 = new Label(73, i + 1 - recordQuantityTimes, list.get(i).getZioSb001());
				Label labelV74 = new Label(74, i + 1 - recordQuantityTimes, list.get(i).getZioSb002());
				Label labelV75 = new Label(75, i + 1 - recordQuantityTimes, list.get(i).getZioSb004());
				Label labelV76 = new Label(76, i + 1 - recordQuantityTimes, list.get(i).getZioSb005());
				Label labelV77 = new Label(77, i + 1 - recordQuantityTimes, list.get(i).getZioSb006());
				Label labelV78 = new Label(78, i + 1 - recordQuantityTimes, list.get(i).getZioSb003());
				Label labelV79 = new Label(79, i + 1 - recordQuantityTimes, list.get(i).getZioSb007());
				Label labelV80 = new Label(80, i + 1 - recordQuantityTimes, list.get(i).getZioSb008().toString());
				Label labelV81 = new Label(81, i + 1 - recordQuantityTimes, list.get(i).getZlenunt());
				Label labelV82 = new Label(82, i + 1 - recordQuantityTimes, list.get(i).getZioSb009().toString());
				Label labelV83 = new Label(83, i + 1 - recordQuantityTimes, list.get(i).getZcapunt());
				Label labelV84 = new Label(84, i + 1 - recordQuantityTimes, list.get(i).getZioSb011());
				Label labelV85 = new Label(85, i + 1 - recordQuantityTimes, list.get(i).getZioUmlgo());
				Label labelV86 = new Label(86, i + 1 - recordQuantityTimes, list.get(i).getZioGplab());
				Label labelV87 = new Label(87, i + 1 - recordQuantityTimes, list.get(i).getZioPosid());
				Label labelV88 = new Label(88, i + 1 - recordQuantityTimes, list.get(i).getZlyrkrq());
				Label labelV89 = new Label(89, i + 1 - recordQuantityTimes, list.get(i).getZlyckrq());
				Label labelV90 = new Label(90, i + 1 - recordQuantityTimes, list.get(i).getZpost1());
				Label labelV91 = new Label(91, i + 1 - recordQuantityTimes, list.get(i).getZioCusre());
				Label labelV92 = new Label(92, i + 1 - recordQuantityTimes, list.get(i).getZbfyy());
				Label labelV93 = new Label(93, i + 1 - recordQuantityTimes, list.get(i).getZioZsb13());
				Label labelV94 = new Label(94, i + 1 - recordQuantityTimes, list.get(i).getZioZsb12());
				Label labelV95 = new Label(95, i + 1 - recordQuantityTimes, list.get(i).getRecordmode());

				// System.out.println("i=" + i);

				sheet.addCell(labelV0);
				sheet.addCell(labelV1);
				sheet.addCell(labelV2);
				sheet.addCell(labelV3);
				sheet.addCell(labelV4);
				sheet.addCell(labelV5);
				sheet.addCell(labelV6);
				sheet.addCell(labelV7);
				sheet.addCell(labelV8);
				sheet.addCell(labelV9);
				sheet.addCell(labelV10);
				sheet.addCell(labelV11);
				sheet.addCell(labelV12);
				sheet.addCell(labelV13);
				sheet.addCell(labelV14);
				sheet.addCell(labelV15);
				sheet.addCell(labelV16);
				sheet.addCell(labelV17);
				sheet.addCell(labelV18);
				sheet.addCell(labelV19);
				sheet.addCell(labelV20);
				sheet.addCell(labelV21);
				sheet.addCell(labelV22);
				sheet.addCell(labelV23);
				sheet.addCell(labelV24);
				sheet.addCell(labelV25);
				sheet.addCell(labelV26);
				sheet.addCell(labelV27);
				sheet.addCell(labelV28);
				sheet.addCell(labelV29);
				sheet.addCell(labelV30);
				sheet.addCell(labelV31);
				sheet.addCell(labelV32);
				sheet.addCell(labelV33);
				sheet.addCell(labelV34);
				sheet.addCell(labelV35);
				sheet.addCell(labelV36);
				sheet.addCell(labelV37);
				sheet.addCell(labelV38);
				sheet.addCell(labelV39);
				sheet.addCell(labelV40);
				sheet.addCell(labelV41);
				sheet.addCell(labelV42);
				sheet.addCell(labelV43);
				sheet.addCell(labelV44);
				sheet.addCell(labelV45);
				sheet.addCell(labelV46);
				sheet.addCell(labelV47);
				sheet.addCell(labelV48);
				sheet.addCell(labelV49);
				sheet.addCell(labelV50);
				sheet.addCell(labelV51);
				sheet.addCell(labelV52);
				sheet.addCell(labelV53);
				sheet.addCell(labelV54);
				sheet.addCell(labelV55);
				sheet.addCell(labelV56);
				sheet.addCell(labelV57);
				sheet.addCell(labelV58);
				sheet.addCell(labelV59);
				sheet.addCell(labelV60);
				sheet.addCell(labelV61);
				sheet.addCell(labelV62);
				sheet.addCell(labelV63);
				sheet.addCell(labelV64);
				sheet.addCell(labelV65);
				sheet.addCell(labelV66);
				sheet.addCell(labelV67);
				sheet.addCell(labelV68);
				sheet.addCell(labelV69);
				sheet.addCell(labelV70);
				sheet.addCell(labelV71);
				sheet.addCell(labelV72);
				sheet.addCell(labelV73);
				sheet.addCell(labelV74);
				sheet.addCell(labelV75);
				sheet.addCell(labelV76);
				sheet.addCell(labelV77);
				sheet.addCell(labelV78);
				sheet.addCell(labelV79);
				sheet.addCell(labelV80);
				sheet.addCell(labelV81);
				sheet.addCell(labelV82);
				sheet.addCell(labelV83);
				sheet.addCell(labelV84);
				sheet.addCell(labelV85);
				sheet.addCell(labelV86);
				sheet.addCell(labelV87);
				sheet.addCell(labelV88);
				sheet.addCell(labelV89);
				sheet.addCell(labelV90);
				sheet.addCell(labelV91);
				sheet.addCell(labelV92);
				sheet.addCell(labelV93);
				sheet.addCell(labelV94);
				sheet.addCell(labelV95);

				System.out.println("i=" + i);
			}
			System.out.println(sheet.toString());
			// }

			// 写入数据并关闭文件
			book.write();
			book.close();
			System.out.println("创建文件成功!");
			now = new Date();
			nowdate = df.format(now);
			System.out.println("Now time is :" + nowdate);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void exportMidPmsItem(String tableName, int recordQuantity) {
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			Date now = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
			String nowdate = df.format(now);
			// 打开文件
			WritableWorkbook book = Workbook.createWorkbook(new File("D:/temp/" + tableName + nowdate + ".xls"));
			System.out.println(book);
			System.out.println("D:/temp/" + tableName + nowdate + ".xls");
			// 生成名为"第一页"的工作表，参数0表示这是第一
			WritableSheet sheet = book.createSheet("第一页", 0);

			// 设置字体为宋体,16号字,加粗,颜色为黑色
			WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
			font1.setColour(Colour.BLACK);
			WritableCellFormat format1 = new WritableCellFormat(font1);
			format1.setAlignment(jxl.format.Alignment.CENTRE);
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Label label0 = new Label(0, 0, "七大PMS单体表明细记录进行分类转换后的记录ID", format1);
			Label label1 = new Label(1, 0, "版本号", format1);
			Label label2 = new Label(2, 0, "设备编码", format1);
			Label label3 = new Label(3, 0, "单位明细", format1);
			Label label4 = new Label(4, 0, "PMS资产类型分类ID", format1);
			Label label5 = new Label(5, 0, "资产大类", format1);
			Label label6 = new Label(6, 0, "资产中类", format1);
			Label label7 = new Label(7, 0, "资产小类", format1);
			Label label8 = new Label(8, 0, "电压等级", format1);
			Label label9 = new Label(9, 0, "日历年", format1);
			Label label10 = new Label(10, 0, "区分字段", format1);
			Label label11 = new Label(11, 0, "健康状态", format1);
			Label label12 = new Label(12, 0, "运行状态", format1);
			Label label13 = new Label(13, 0, "运维单位", format1);
			Label label14 = new Label(14, 0, "资产卡编码", format1);
			Label label15 = new Label(15, 0, "资产原值", format1);
			Label label16 = new Label(16, 0, "直接投运日期", format1);
			Label label17 = new Label(17, 0, "资产性质", format1);
			Label label18 = new Label(18, 0, "数量", format1);
			Label label19 = new Label(19, 0, "数量1", format1);
			Label label20 = new Label(20, 0, "数量2", format1);
			Label label21 = new Label(21, 0, "数量3", format1);
			Label label22 = new Label(22, 0, "计量单位", format1);
			Label label23 = new Label(23, 0, "制造商名称", format1);
			Label label24 = new Label(24, 0, "所属线路变电站", format1);
			Label label25 = new Label(25, 0, "设备型号", format1);
			Label label26 = new Label(26, 0, "投运日期", format1);
			Label label27 = new Label(27, 0, "年龄段", format1);
			Label label28 = new Label(28, 0, "投运日期", format1);
			Label label29 = new Label(29, 0, "年龄", format1);
			Label label30 = new Label(30, 0, "出厂日期", format1);
			Label label31 = new Label(31, 0, "是否进行过ERP与PMS数据的匹配工作", format1);

			// 将定义好的单元格添加到工作表中
			sheet.addCell(label0);
			sheet.addCell(label1);
			sheet.addCell(label2);
			sheet.addCell(label3);
			sheet.addCell(label4);
			sheet.addCell(label5);
			sheet.addCell(label6);
			sheet.addCell(label7);
			sheet.addCell(label8);
			sheet.addCell(label9);
			sheet.addCell(label10);
			sheet.addCell(label11);
			sheet.addCell(label12);
			sheet.addCell(label13);
			sheet.addCell(label14);
			sheet.addCell(label15);
			sheet.addCell(label16);
			sheet.addCell(label17);
			sheet.addCell(label18);
			sheet.addCell(label19);
			sheet.addCell(label20);
			sheet.addCell(label21);
			sheet.addCell(label22);
			sheet.addCell(label23);
			sheet.addCell(label24);
			sheet.addCell(label25);
			sheet.addCell(label26);
			sheet.addCell(label27);
			sheet.addCell(label28);
			sheet.addCell(label29);
			sheet.addCell(label30);
			sheet.addCell(label31);

			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			// ResultSet result = null;
			// String sql = "select * from " + tableName;// 预编译语句
			// System.out.println("sql=" + sql);
			// pre = conn.prepareStatement(sql);// 实例化预编译语句
			// result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			// 查询数据库中所有的数据
			List<MidPmsItem> list = PmsQuexianService.getAllMidPmsItem(tableName);
			System.out.println(list.size());
			// System.out.println("------------------------"+list.toString());

			// while (result.next()) {
			for (int i = 0; i < list.size(); i++) {
				int j = i / recordQuantity;

				// System.out.println("i=" + i);
				// System.out.println("(i % 65534) == 0 && i != 0)="+((i %
				// 65534) == 0 && i != 0));
				if ((i % recordQuantity) == 0 && i != 0) {
					// 写入数据并关闭文件
					// System.out.println("I'm Here!");
					book.write();
					book.close();
					df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
					now = new Date();
					nowdate = df.format(now);
					// System.out.println("D:/temp/" + tableName + nowdate +j+
					// ".xls");
					book = Workbook.createWorkbook(new File("D:/temp/" + tableName + nowdate + j + ".xls"));
					// System.out.println("D:/temp/" + tableName + nowdate +j+
					// ".xls");

					sheet = book.createSheet("第一页", 0);
					label0 = new Label(0, 0, "七大PMS单体表明细记录进行分类转换后的记录ID", format1);
					label1 = new Label(1, 0, "版本号", format1);
					label2 = new Label(2, 0, "设备编码", format1);
					label3 = new Label(3, 0, "单位明细", format1);
					label4 = new Label(4, 0, "PMS资产类型分类ID", format1);
					label5 = new Label(5, 0, "资产大类", format1);
					label6 = new Label(6, 0, "资产中类", format1);
					label7 = new Label(7, 0, "资产小类", format1);
					label8 = new Label(8, 0, "电压等级", format1);
					label9 = new Label(9, 0, "日历年", format1);
					label10 = new Label(10, 0, "区分字段", format1);
					label11 = new Label(11, 0, "健康状态", format1);
					label12 = new Label(12, 0, "运行状态", format1);
					label13 = new Label(13, 0, "运维单位", format1);
					label14 = new Label(14, 0, "资产卡编码", format1);
					label15 = new Label(15, 0, "资产原值", format1);
					label16 = new Label(16, 0, "直接投运日期", format1);
					label17 = new Label(17, 0, "资产性质", format1);
					label18 = new Label(18, 0, "数量", format1);
					label19 = new Label(19, 0, "数量1", format1);
					label20 = new Label(20, 0, "数量2", format1);
					label21 = new Label(21, 0, "数量3", format1);
					label22 = new Label(22, 0, "计量单位", format1);
					label23 = new Label(23, 0, "制造商名称", format1);
					label24 = new Label(24, 0, "所属线路变电站", format1);
					label25 = new Label(25, 0, "设备型号", format1);
					label26 = new Label(26, 0, "投运日期", format1);
					label27 = new Label(27, 0, "年龄段", format1);
					label28 = new Label(28, 0, "投运日期", format1);
					label29 = new Label(29, 0, "年龄", format1);
					label30 = new Label(30, 0, "出厂日期", format1);
					label31 = new Label(31, 0, "是否进行过ERP与PMS数据的匹配工作", format1);

					// 将定义好的单元格添加到工作表中
					sheet.addCell(label0);
					sheet.addCell(label1);
					sheet.addCell(label2);
					sheet.addCell(label3);
					sheet.addCell(label4);
					sheet.addCell(label5);
					sheet.addCell(label6);
					sheet.addCell(label7);
					sheet.addCell(label8);
					sheet.addCell(label9);
					sheet.addCell(label10);
					sheet.addCell(label11);
					sheet.addCell(label12);
					sheet.addCell(label13);
					sheet.addCell(label14);
					sheet.addCell(label15);
					sheet.addCell(label16);
					sheet.addCell(label17);
					sheet.addCell(label18);
					sheet.addCell(label19);
					sheet.addCell(label20);
					sheet.addCell(label21);
					sheet.addCell(label22);
					sheet.addCell(label23);
					sheet.addCell(label24);
					sheet.addCell(label25);
					sheet.addCell(label26);
					sheet.addCell(label27);
					sheet.addCell(label28);
					sheet.addCell(label29);
					sheet.addCell(label30);
					sheet.addCell(label31);
					df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					// break;
				}
				// System.out.println("j=" + j);
				int recordQuantityTimes = j * recordQuantity;

				Label labelV0 = new Label(0, i + 1 - recordQuantityTimes, list.get(i).getMidPmsItemId());
				Label labelV1 = new Label(1, i + 1 - recordQuantityTimes, list.get(i).getVersion());
				Label labelV2 = new Label(2, i + 1 - recordQuantityTimes, list.get(i).getSbbm());
				Label labelV3 = new Label(3, i + 1 - recordQuantityTimes, list.get(i).getOrgName());
				Label labelV4 = new Label(4, i + 1 - recordQuantityTimes, list.get(i).getDvPmsAssetClassId());
				Label labelV5 = new Label(5, i + 1 - recordQuantityTimes, list.get(i).getZcDl());
				Label labelV6 = new Label(6, i + 1 - recordQuantityTimes, list.get(i).getZcZl());
				Label labelV7 = new Label(7, i + 1 - recordQuantityTimes, list.get(i).getZcXl());
				Label labelV8 = new Label(8, i + 1 - recordQuantityTimes, list.get(i).getVoltageLevel());
				Label labelV9 = null;
				if (null != list.get(i).getCalYear()) {
					labelV9 = new Label(9, i + 1 - recordQuantityTimes, df.format(list.get(i).getCalYear()).toString());
				} else {
					labelV9 = new Label(9, i + 1 - recordQuantityTimes, new String(""));
				}
				// System.out.println("list.get(i).getQfzd()="+list.get(i).getQfzd());
				Label labelV10 = new Label(10, i + 1 - recordQuantityTimes, list.get(i).getQfzd());
				Label labelV11 = new Label(11, i + 1 - recordQuantityTimes, list.get(i).getJkzt());
				Label labelV12 = new Label(12, i + 1 - recordQuantityTimes, list.get(i).getYxzt());
				Label labelV13 = new Label(13, i + 1 - recordQuantityTimes, list.get(i).getYwdw());
				Label labelV14 = new Label(14, i + 1 - recordQuantityTimes, list.get(i).getZckbm());
				Label labelV15 = null;
				if (null != list.get(i).getZcyz()) {
					labelV15 = new Label(15, i + 1 - recordQuantityTimes, list.get(i).getZcyz().toString());
				} else {
					labelV15 = new Label(15, i + 1 - recordQuantityTimes, new String(""));
				}
				// System.out.println("list.get(i).getZjtyrq()="+list.get(i).getZjtyrq());
				Label labelV16 = null;
				if (null != list.get(i).getZjtyrq()) {
					labelV16 = new Label(16, i + 1 - recordQuantityTimes,
							df.format(list.get(i).getZjtyrq()).toString());
				} else {
					labelV16 = new Label(16, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV17 = new Label(17, i + 1 - recordQuantityTimes, list.get(i).getZcxz());
				// System.out.println("list.get(i).getZcxz()="+list.get(i).getZcxz());
				Label labelV18 = null;
				if (null != list.get(i).getSl()) {
					labelV18 = new Label(18, i + 1 - recordQuantityTimes, list.get(i).getSl().toString());
				} else {
					labelV18 = new Label(18, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV19 = null;
				if (null != list.get(i).getSl1()) {
					labelV19 = new Label(19, i + 1 - recordQuantityTimes, list.get(i).getSl1().toString());
				} else {
					labelV19 = new Label(19, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV20 = null;
				if (null != list.get(i).getSl2()) {
					labelV20 = new Label(20, i + 1 - recordQuantityTimes, list.get(i).getSl2().toString());
				} else {
					labelV20 = new Label(20, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV21 = null;
				if (null != list.get(i).getSl3()) {
					labelV21 = new Label(21, i + 1 - recordQuantityTimes, list.get(i).getSl3().toString());
				} else {
					labelV21 = new Label(21, i + 1 - recordQuantityTimes, new String(""));
				}
				// System.out.println("list.get(i).getJldw()="+list.get(i).getJldw());
				Label labelV22 = new Label(22, i + 1 - recordQuantityTimes, list.get(i).getJldw());
				Label labelV23 = new Label(23, i + 1 - recordQuantityTimes, list.get(i).getZzsmc());
				Label labelV24 = new Label(24, i + 1 - recordQuantityTimes, list.get(i).getSsxlbdz());
				Label labelV25 = new Label(25, i + 1 - recordQuantityTimes, list.get(i).getSbxh());
				Label labelV26 = null;
				if (null != list.get(i).getTynf()) {
					labelV26 = new Label(26, i + 1 - recordQuantityTimes, list.get(i).getTynf().toString());
				} else {
					labelV26 = new Label(26, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV27 = new Label(27, i + 1 - recordQuantityTimes, list.get(i).getNnd());
				Label labelV28 = null;
				if (null != list.get(i).getTyrq()) {
					labelV28 = new Label(28, i + 1 - recordQuantityTimes, df.format(list.get(i).getTyrq()).toString());
				} else {
					labelV28 = new Label(28, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV29 = new Label(29, i + 1 - recordQuantityTimes, list.get(i).getNn().toString());
				Label labelV30 = null;
				if (null != list.get(i).getCcrq()) {
					labelV30 = new Label(30, i + 1 - recordQuantityTimes, df.format(list.get(i).getCcrq()).toString());
				} else {
					labelV30 = new Label(30, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV31 = new Label(31, i + 1 - recordQuantityTimes, list.get(i).getIsMatched());

				// System.out.println("i=" + i);

				sheet.addCell(labelV0);
				sheet.addCell(labelV1);
				sheet.addCell(labelV2);
				sheet.addCell(labelV3);
				sheet.addCell(labelV4);
				sheet.addCell(labelV5);
				sheet.addCell(labelV6);
				sheet.addCell(labelV7);
				sheet.addCell(labelV8);
				sheet.addCell(labelV9);
				sheet.addCell(labelV10);
				sheet.addCell(labelV11);
				sheet.addCell(labelV12);
				sheet.addCell(labelV13);
				sheet.addCell(labelV14);
				sheet.addCell(labelV15);
				sheet.addCell(labelV16);
				sheet.addCell(labelV17);
				sheet.addCell(labelV18);
				sheet.addCell(labelV19);
				sheet.addCell(labelV20);
				sheet.addCell(labelV21);
				sheet.addCell(labelV22);
				sheet.addCell(labelV23);
				sheet.addCell(labelV24);
				sheet.addCell(labelV25);
				sheet.addCell(labelV26);
				sheet.addCell(labelV27);
				sheet.addCell(labelV28);
				sheet.addCell(labelV29);
				sheet.addCell(labelV30);
				sheet.addCell(labelV31);

				System.out.println("i=" + i);
			}
			System.out.println(sheet.toString());
			// }

			// 写入数据并关闭文件
			book.write();
			book.close();
			System.out.println("创建文件成功!");
			now = new Date();
			nowdate = df.format(now);
			System.out.println("Now time is :" + nowdate);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void exportMidErpItem(String tableName, int recordQuantity) {
		// Connection conn = null;
		try {
			// conn = Dbutil.getConnection();
			Date now = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
			String nowdate = df.format(now);
			// 打开文件
			WritableWorkbook book = Workbook
					.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + 0 + ".xls"));
			System.out.println(book);
			System.out.println("D:/temp/" + tableName + nowdate + ".xls");
			// 生成名为"第一页"的工作表，参数0表示这是第一
			WritableSheet sheet = book.createSheet("第一页", 0);

			// 设置字体为宋体,16号字,加粗,颜色为黑色
			WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
			font1.setColour(Colour.BLACK);
			WritableCellFormat format1 = new WritableCellFormat(font1);
			format1.setAlignment(jxl.format.Alignment.CENTRE);
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Label label0 = new Label(0, 0, "ERP实物资产单体中间表记录ID", format1);
			Label label1 = new Label(1, 0, "数据版本", format1);
			Label label2 = new Label(2, 0, "统计年", format1);
			Label label3 = new Label(3, 0, "日历年", format1);
			Label label4 = new Label(4, 0, "利润中心名称", format1);
			Label label5 = new Label(5, 0, "单位（公司代码）", format1);
			Label label6 = new Label(6, 0, "主资产编号", format1);
			Label label7 = new Label(7, 0, "资产子编号", format1);
			Label label8 = new Label(8, 0, "设备编号", format1);
			Label label9 = new Label(9, 0, "货币", format1);
			Label label10 = new Label(10, 0, "资产大类", format1);
			Label label11 = new Label(11, 0, "资产中类", format1);
			Label label12 = new Label(12, 0, "资产小类", format1);
			Label label13 = new Label(13, 0, "电压等级（卡片）", format1);
			Label label14 = new Label(14, 0, "数量（卡片）", format1);
			Label label15 = new Label(15, 0, "计量的单位（卡片）", format1);
			Label label16 = new Label(16, 0, "资产原值", format1);
			Label label17 = new Label(17, 0, "资产净值", format1);
			Label label18 = new Label(18, 0, "资产状态", format1);
			Label label19 = new Label(19, 0, "二级单位（利润中心）", format1);
			Label label20 = new Label(20, 0, "成本控制范围", format1);
			Label label21 = new Label(21, 0, "资产描述", format1);
			Label label22 = new Label(22, 0, "项目类型", format1);
			Label label23 = new Label(23, 0, "资本化日期", format1);
			Label label24 = new Label(24, 0, "投运日期", format1);
			Label label25 = new Label(25, 0, "出厂日期", format1);
			Label label26 = new Label(26, 0, "线路长度", format1);
			Label label27 = new Label(27, 0, "长度单位", format1);
			Label label28 = new Label(28, 0, "变电容量", format1);
			Label label29 = new Label(29, 0, "容量单位", format1);
			Label label30 = new Label(30, 0, "库存地点（设备）", format1);
			Label label31 = new Label(31, 0, "备品备件标识", format1);
			Label label32 = new Label(32, 0, "再利用设备标识", format1);
			Label label33 = new Label(33, 0, "入再利用库日期", format1);
			Label label34 = new Label(34, 0, "出再利用库日期", format1);
			Label label35 = new Label(35, 0, "报废来源项目编号", format1);
			Label label36 = new Label(36, 0, "报废原因代码", format1);
			Label label37 = new Label(37, 0, "报废记账日期", format1);
			Label label38 = new Label(38, 0, "设备状态", format1);
			Label label39 = new Label(39, 0, "电压等级（设备）", format1);
			Label label40 = new Label(40, 0, "是否代管", format1);
			Label label41 = new Label(41, 0, "制造厂商（卡片）", format1);
			Label label42 = new Label(42, 0, "制造厂商（设备）", format1);
			Label label43 = new Label(43, 0, "制造商国家", format1);
			Label label44 = new Label(44, 0, "制造商零件号", format1);
			Label label45 = new Label(45, 0, "不活动日期", format1);
			Label label46 = new Label(46, 0, "资产分类", format1);
			Label label47 = new Label(47, 0, "序列号（卡片）", format1);
			Label label48 = new Label(48, 0, "存货号（卡片）", format1);
			Label label49 = new Label(49, 0, "资产所属单位（卡片）", format1);
			Label label50 = new Label(50, 0, "使用保管单位（卡片）", format1);
			Label label51 = new Label(51, 0, "成本中心（卡片）", format1);
			Label label52 = new Label(52, 0, "实物管理部门（卡片）", format1);
			Label label53 = new Label(53, 0, "使用保管人（卡片）", format1);
			Label label54 = new Label(54, 0, "车牌号（卡片）", format1);
			Label label55 = new Label(55, 0, "成本中心辅助核算", format1);
			Label label56 = new Label(56, 0, "捐赠类型", format1);
			Label label57 = new Label(57, 0, "监管标识", format1);
			Label label58 = new Label(58, 0, "资产使用情况", format1);
			Label label59 = new Label(59, 0, "资产增加方式", format1);
			Label label60 = new Label(60, 0, "资产变动方式", format1);
			Label label61 = new Label(61, 0, "资产来源", format1);
			Label label62 = new Label(62, 0, "工程性质", format1);
			Label label63 = new Label(63, 0, "固定资产细类", format1);
			Label label64 = new Label(64, 0, "WBS元素（卡片）", format1);
			Label label65 = new Label(65, 0, "WBS元素描述（卡片）", format1);
			Label label66 = new Label(66, 0, "资产存放地点", format1);
			Label label67 = new Label(67, 0, "所属线站名称", format1);
			Label label68 = new Label(68, 0, "房屋产权证号", format1);
			Label label69 = new Label(69, 0, "设备名称", format1);
			Label label70 = new Label(70, 0, "技术对象类型", format1);
			Label label71 = new Label(71, 0, "授权组", format1);
			Label label72 = new Label(72, 0, "规格型号（设备）", format1);
			Label label73 = new Label(73, 0, "设备铭牌号（设备）", format1);
			Label label74 = new Label(74, 0, "维护工厂", format1);
			Label label75 = new Label(75, 0, "设备资产变动方式（设备）", format1);
			Label label76 = new Label(76, 0, "工厂区域", format1);
			Label label77 = new Label(77, 0, "ABC标识", format1);
			Label label78 = new Label(78, 0, "分类字段", format1);
			Label label79 = new Label(79, 0, "成本中心（设备）", format1);
			Label label80 = new Label(80, 0, "WBS元素（设备）", format1);
			Label label81 = new Label(81, 0, "WBS元素描述（设备）", format1);
			Label label82 = new Label(82, 0, "计划工厂", format1);
			Label label83 = new Label(83, 0, "计划员组", format1);
			Label label84 = new Label(84, 0, "主工作中心", format1);
			Label label85 = new Label(85, 0, "功能位置", format1);
			Label label86 = new Label(86, 0, "高级设备", format1);
			Label label87 = new Label(87, 0, "技术标识号", format1);
			Label label88 = new Label(88, 0, "使用保管人（设备）", format1);
			Label label89 = new Label(89, 0, "使用保管部门（设备）", format1);
			Label label90 = new Label(90, 0, "实物管理部门（设备）", format1);
			Label label91 = new Label(91, 0, "设备增加方式（设备）", format1);
			Label label92 = new Label(92, 0, "设备存放地点（设备）", format1);
			Label label93 = new Label(93, 0, "车牌号（设备）", format1);
			Label label94 = new Label(94, 0, "房屋产权证号（设备）", format1);
			Label label95 = new Label(95, 0, "线站标识", format1);
			Label label96 = new Label(96, 0, "报废来源项目描述", format1);
			Label label97 = new Label(97, 0, "报废原因文本", format1);
			Label label98 = new Label(98, 0, "数据抽取日期", format1);
			Label label99 = new Label(99, 0, "数据抽取时间", format1);
			Label label100 = new Label(100, 0, "数据抽取人", format1);
			Label label101 = new Label(101, 0, "资产性质名称", format1);
			Label label102 = new Label(102, 0, "资产性质编码", format1);

			// 将定义好的单元格添加到工作表中
			sheet.addCell(label0);
			sheet.addCell(label1);
			sheet.addCell(label2);
			sheet.addCell(label3);
			sheet.addCell(label4);
			sheet.addCell(label5);
			sheet.addCell(label6);
			sheet.addCell(label7);
			sheet.addCell(label8);
			sheet.addCell(label9);
			sheet.addCell(label10);
			sheet.addCell(label11);
			sheet.addCell(label12);
			sheet.addCell(label13);
			sheet.addCell(label14);
			sheet.addCell(label15);
			sheet.addCell(label16);
			sheet.addCell(label17);
			sheet.addCell(label18);
			sheet.addCell(label19);
			sheet.addCell(label20);
			sheet.addCell(label21);
			sheet.addCell(label22);
			sheet.addCell(label23);
			sheet.addCell(label24);
			sheet.addCell(label25);
			sheet.addCell(label26);
			sheet.addCell(label27);
			sheet.addCell(label28);
			sheet.addCell(label29);
			sheet.addCell(label30);
			sheet.addCell(label31);
			sheet.addCell(label32);
			sheet.addCell(label33);
			sheet.addCell(label34);
			sheet.addCell(label35);
			sheet.addCell(label36);
			sheet.addCell(label37);
			sheet.addCell(label38);
			sheet.addCell(label39);
			sheet.addCell(label40);
			sheet.addCell(label41);
			sheet.addCell(label42);
			sheet.addCell(label43);
			sheet.addCell(label44);
			sheet.addCell(label45);
			sheet.addCell(label46);
			sheet.addCell(label47);
			sheet.addCell(label48);
			sheet.addCell(label49);
			sheet.addCell(label50);
			sheet.addCell(label51);
			sheet.addCell(label52);
			sheet.addCell(label53);
			sheet.addCell(label54);
			sheet.addCell(label55);
			sheet.addCell(label56);
			sheet.addCell(label57);
			sheet.addCell(label58);
			sheet.addCell(label59);
			sheet.addCell(label60);
			sheet.addCell(label61);
			sheet.addCell(label62);
			sheet.addCell(label63);
			sheet.addCell(label64);
			sheet.addCell(label65);
			sheet.addCell(label66);
			sheet.addCell(label67);
			sheet.addCell(label68);
			sheet.addCell(label69);
			sheet.addCell(label70);
			sheet.addCell(label71);
			sheet.addCell(label72);
			sheet.addCell(label73);
			sheet.addCell(label74);
			sheet.addCell(label75);
			sheet.addCell(label76);
			sheet.addCell(label77);
			sheet.addCell(label78);
			sheet.addCell(label79);
			sheet.addCell(label80);
			sheet.addCell(label81);
			sheet.addCell(label82);
			sheet.addCell(label83);
			sheet.addCell(label84);
			sheet.addCell(label85);
			sheet.addCell(label86);
			sheet.addCell(label87);
			sheet.addCell(label88);
			sheet.addCell(label89);
			sheet.addCell(label90);
			sheet.addCell(label91);
			sheet.addCell(label92);
			sheet.addCell(label93);
			sheet.addCell(label94);
			sheet.addCell(label95);
			sheet.addCell(label96);
			sheet.addCell(label97);
			sheet.addCell(label98);
			sheet.addCell(label99);
			sheet.addCell(label100);
			sheet.addCell(label101);
			sheet.addCell(label102);

			// 创建预编译语句对象，一般都是用这个而不用Statement
			// PreparedStatement pre = null;
			// 创建一个结果集对象
			// ResultSet result = null;
			// String sql = "select * from " + tableName;// 预编译语句
			// System.out.println("sql=" + sql);
			// pre = conn.prepareStatement(sql);// 实例化预编译语句
			// result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			// 查询数据库中所有的数据
			List<MidErpItem> list = PmsQuexianService.getAllMidErpItem(tableName);
			System.out.println(list.size());
			// System.out.println("------------------------"+list.toString());

			// while (result.next()) {
			for (int i = 0; i < list.size(); i++) {
				int j = i / recordQuantity;

				// System.out.println("i=" + i);
				// System.out.println("(i % 65534) == 0 && i != 0)="+((i %
				// 65534) == 0 && i != 0));
				if ((i % recordQuantity) == 0 && i != 0) {
					// 写入数据并关闭文件
					// System.out.println("I'm Here!");
					book.write();
					book.close();
					df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
					now = new Date();
					nowdate = df.format(now);
					// System.out.println("D:/temp/" + tableName + nowdate +j+
					// ".xls");
					book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_" + nowdate + "_" + j + ".xls"));
					// System.out.println("D:/temp/" + tableName + nowdate +j+
					// ".xls");

					sheet = book.createSheet("第一页", 0);
					label0 = new Label(0, 0, "ERP实物资产单体中间表记录ID", format1);
					label1 = new Label(1, 0, "数据版本", format1);
					label2 = new Label(2, 0, "统计年", format1);
					label3 = new Label(3, 0, "日历年", format1);
					label4 = new Label(4, 0, "利润中心名称", format1);
					label5 = new Label(5, 0, "单位（公司代码）", format1);
					label6 = new Label(6, 0, "主资产编号", format1);
					label7 = new Label(7, 0, "资产子编号", format1);
					label8 = new Label(8, 0, "设备编号", format1);
					label9 = new Label(9, 0, "货币", format1);
					label10 = new Label(10, 0, "资产大类", format1);
					label11 = new Label(11, 0, "资产中类", format1);
					label12 = new Label(12, 0, "资产小类", format1);
					label13 = new Label(13, 0, "电压等级（卡片）", format1);
					label14 = new Label(14, 0, "数量（卡片）", format1);
					label15 = new Label(15, 0, "计量的单位（卡片）", format1);
					label16 = new Label(16, 0, "资产原值", format1);
					label17 = new Label(17, 0, "资产净值", format1);
					label18 = new Label(18, 0, "资产状态", format1);
					label19 = new Label(19, 0, "二级单位（利润中心）", format1);
					label20 = new Label(20, 0, "成本控制范围", format1);
					label21 = new Label(21, 0, "资产描述", format1);
					label22 = new Label(22, 0, "项目类型", format1);
					label23 = new Label(23, 0, "资本化日期", format1);
					label24 = new Label(24, 0, "投运日期", format1);
					label25 = new Label(25, 0, "出厂日期", format1);
					label26 = new Label(26, 0, "线路长度", format1);
					label27 = new Label(27, 0, "长度单位", format1);
					label28 = new Label(28, 0, "变电容量", format1);
					label29 = new Label(29, 0, "容量单位", format1);
					label30 = new Label(30, 0, "库存地点（设备）", format1);
					label31 = new Label(31, 0, "备品备件标识", format1);
					label32 = new Label(32, 0, "再利用设备标识", format1);
					label33 = new Label(33, 0, "入再利用库日期", format1);
					label34 = new Label(34, 0, "出再利用库日期", format1);
					label35 = new Label(35, 0, "报废来源项目编号", format1);
					label36 = new Label(36, 0, "报废原因代码", format1);
					label37 = new Label(37, 0, "报废记账日期", format1);
					label38 = new Label(38, 0, "设备状态", format1);
					label39 = new Label(39, 0, "电压等级（设备）", format1);
					label40 = new Label(40, 0, "是否代管", format1);
					label41 = new Label(41, 0, "制造厂商（卡片）", format1);
					label42 = new Label(42, 0, "制造厂商（设备）", format1);
					label43 = new Label(43, 0, "制造商国家", format1);
					label44 = new Label(44, 0, "制造商零件号", format1);
					label45 = new Label(45, 0, "不活动日期", format1);
					label46 = new Label(46, 0, "资产分类", format1);
					label47 = new Label(47, 0, "序列号（卡片）", format1);
					label48 = new Label(48, 0, "存货号（卡片）", format1);
					label49 = new Label(49, 0, "资产所属单位（卡片）", format1);
					label50 = new Label(50, 0, "使用保管单位（卡片）", format1);
					label51 = new Label(51, 0, "成本中心（卡片）", format1);
					label52 = new Label(52, 0, "实物管理部门（卡片）", format1);
					label53 = new Label(53, 0, "使用保管人（卡片）", format1);
					label54 = new Label(54, 0, "车牌号（卡片）", format1);
					label55 = new Label(55, 0, "成本中心辅助核算", format1);
					label56 = new Label(56, 0, "捐赠类型", format1);
					label57 = new Label(57, 0, "监管标识", format1);
					label58 = new Label(58, 0, "资产使用情况", format1);
					label59 = new Label(59, 0, "资产增加方式", format1);
					label60 = new Label(60, 0, "资产变动方式", format1);
					label61 = new Label(61, 0, "资产来源", format1);
					label62 = new Label(62, 0, "工程性质", format1);
					label63 = new Label(63, 0, "固定资产细类", format1);
					label64 = new Label(64, 0, "WBS元素（卡片）", format1);
					label65 = new Label(65, 0, "WBS元素描述（卡片）", format1);
					label66 = new Label(66, 0, "资产存放地点", format1);
					label67 = new Label(67, 0, "所属线站名称", format1);
					label68 = new Label(68, 0, "房屋产权证号", format1);
					label69 = new Label(69, 0, "设备名称", format1);
					label70 = new Label(70, 0, "技术对象类型", format1);
					label71 = new Label(71, 0, "授权组", format1);
					label72 = new Label(72, 0, "规格型号（设备）", format1);
					label73 = new Label(73, 0, "设备铭牌号（设备）", format1);
					label74 = new Label(74, 0, "维护工厂", format1);
					label75 = new Label(75, 0, "设备资产变动方式（设备）", format1);
					label76 = new Label(76, 0, "工厂区域", format1);
					label77 = new Label(77, 0, "ABC标识", format1);
					label78 = new Label(78, 0, "分类字段", format1);
					label79 = new Label(79, 0, "成本中心（设备）", format1);
					label80 = new Label(80, 0, "WBS元素（设备）", format1);
					label81 = new Label(81, 0, "WBS元素描述（设备）", format1);
					label82 = new Label(82, 0, "计划工厂", format1);
					label83 = new Label(83, 0, "计划员组", format1);
					label84 = new Label(84, 0, "主工作中心", format1);
					label85 = new Label(85, 0, "功能位置", format1);
					label86 = new Label(86, 0, "高级设备", format1);
					label87 = new Label(87, 0, "技术标识号", format1);
					label88 = new Label(88, 0, "使用保管人（设备）", format1);
					label89 = new Label(89, 0, "使用保管部门（设备）", format1);
					label90 = new Label(90, 0, "实物管理部门（设备）", format1);
					label91 = new Label(91, 0, "设备增加方式（设备）", format1);
					label92 = new Label(92, 0, "设备存放地点（设备）", format1);
					label93 = new Label(93, 0, "车牌号（设备）", format1);
					label94 = new Label(94, 0, "房屋产权证号（设备）", format1);
					label95 = new Label(95, 0, "线站标识", format1);
					label96 = new Label(96, 0, "报废来源项目描述", format1);
					label97 = new Label(97, 0, "报废原因文本", format1);
					label98 = new Label(98, 0, "数据抽取日期", format1);
					label99 = new Label(99, 0, "数据抽取时间", format1);
					label100 = new Label(100, 0, "数据抽取人", format1);
					label101 = new Label(101, 0, "资产性质名称", format1);
					label102 = new Label(102, 0, "资产性质编码", format1);

					// 将定义好的单元格添加到工作表中
					sheet.addCell(label0);
					sheet.addCell(label1);
					sheet.addCell(label2);
					sheet.addCell(label3);
					sheet.addCell(label4);
					sheet.addCell(label5);
					sheet.addCell(label6);
					sheet.addCell(label7);
					sheet.addCell(label8);
					sheet.addCell(label9);
					sheet.addCell(label10);
					sheet.addCell(label11);
					sheet.addCell(label12);
					sheet.addCell(label13);
					sheet.addCell(label14);
					sheet.addCell(label15);
					sheet.addCell(label16);
					sheet.addCell(label17);
					sheet.addCell(label18);
					sheet.addCell(label19);
					sheet.addCell(label20);
					sheet.addCell(label21);
					sheet.addCell(label22);
					sheet.addCell(label23);
					sheet.addCell(label24);
					sheet.addCell(label25);
					sheet.addCell(label26);
					sheet.addCell(label27);
					sheet.addCell(label28);
					sheet.addCell(label29);
					sheet.addCell(label30);
					sheet.addCell(label31);
					sheet.addCell(label32);
					sheet.addCell(label33);
					sheet.addCell(label34);
					sheet.addCell(label35);
					sheet.addCell(label36);
					sheet.addCell(label37);
					sheet.addCell(label38);
					sheet.addCell(label39);
					sheet.addCell(label40);
					sheet.addCell(label41);
					sheet.addCell(label42);
					sheet.addCell(label43);
					sheet.addCell(label44);
					sheet.addCell(label45);
					sheet.addCell(label46);
					sheet.addCell(label47);
					sheet.addCell(label48);
					sheet.addCell(label49);
					sheet.addCell(label50);
					sheet.addCell(label51);
					sheet.addCell(label52);
					sheet.addCell(label53);
					sheet.addCell(label54);
					sheet.addCell(label55);
					sheet.addCell(label56);
					sheet.addCell(label57);
					sheet.addCell(label58);
					sheet.addCell(label59);
					sheet.addCell(label60);
					sheet.addCell(label61);
					sheet.addCell(label62);
					sheet.addCell(label63);
					sheet.addCell(label64);
					sheet.addCell(label65);
					sheet.addCell(label66);
					sheet.addCell(label67);
					sheet.addCell(label68);
					sheet.addCell(label69);
					sheet.addCell(label70);
					sheet.addCell(label71);
					sheet.addCell(label72);
					sheet.addCell(label73);
					sheet.addCell(label74);
					sheet.addCell(label75);
					sheet.addCell(label76);
					sheet.addCell(label77);
					sheet.addCell(label78);
					sheet.addCell(label79);
					sheet.addCell(label80);
					sheet.addCell(label81);
					sheet.addCell(label82);
					sheet.addCell(label83);
					sheet.addCell(label84);
					sheet.addCell(label85);
					sheet.addCell(label86);
					sheet.addCell(label87);
					sheet.addCell(label88);
					sheet.addCell(label89);
					sheet.addCell(label90);
					sheet.addCell(label91);
					sheet.addCell(label92);
					sheet.addCell(label93);
					sheet.addCell(label94);
					sheet.addCell(label95);
					sheet.addCell(label96);
					sheet.addCell(label97);
					sheet.addCell(label98);
					sheet.addCell(label99);
					sheet.addCell(label100);
					sheet.addCell(label101);
					sheet.addCell(label102);
					df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					// break;
				}
				// System.out.println("j=" + j);
				int recordQuantityTimes = j * recordQuantity;
				Label labelV0 = new Label(0, i + 1 - recordQuantityTimes, list.get(i).getMidErpItemId());
				Label labelV1 = new Label(1, i + 1 - recordQuantityTimes, list.get(i).getVersion());
				// System.out.println("list.get(i).getVersion()" +
				// list.get(i).getVersion());
				Label labelV2 = null;
				if (null != list.get(i).getCalYear()) {
					labelV2 = new Label(2, i + 1 - recordQuantityTimes, df.format(list.get(i).getCalYear()).toString());
				} else {
					labelV2 = new Label(2, i + 1 - recordQuantityTimes, df.format(list.get(i).getCalYear()).toString());
				}
				Label labelV3 = null;
				if (null != list.get(i).getCalyear()) {
					labelV3 = new Label(3, i + 1 - recordQuantityTimes, list.get(i).getCalyear().toString());
				} else {
					labelV3 = new Label(3, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV4 = new Label(4, i + 1 - recordQuantityTimes, list.get(i).getOrgName());
				Label labelV5 = new Label(5, i + 1 - recordQuantityTimes, list.get(i).getCompCode());
				Label labelV6 = new Label(6, i + 1 - recordQuantityTimes, list.get(i).getAssetMainNumber());
				Label labelV7 = new Label(7, i + 1 - recordQuantityTimes, list.get(i).getAssetSubnumber());
				Label labelV8 = new Label(8, i + 1 - recordQuantityTimes, list.get(i).getEquipementNumber());
				Label labelV9 = new Label(9, i + 1 - recordQuantityTimes, list.get(i).getCurrency());
				Label labelV10 = new Label(10, i + 1 - recordQuantityTimes, list.get(i).getLargeClass());
				Label labelV11 = new Label(11, i + 1 - recordQuantityTimes, list.get(i).getMediumClass());
				Label labelV12 = new Label(12, i + 1 - recordQuantityTimes, list.get(i).getSmallClass());
				Label labelV13 = new Label(13, i + 1 - recordQuantityTimes, list.get(i).getVoltageLevel());
				Label labelV14 = null;
				if (null != list.get(i).getQuantity()) {
					labelV14 = new Label(14, i + 1 - recordQuantityTimes, list.get(i).getQuantity().toString());
				} else {
					labelV14 = new Label(14, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV15 = new Label(15, i + 1 - recordQuantityTimes, list.get(i).getUnit());
				Label labelV16 = null;
				if (null != list.get(i).getOriginalValue()) {
					labelV16 = new Label(16, i + 1 - recordQuantityTimes, list.get(i).getOriginalValue().toString());
				} else {
					labelV16 = new Label(16, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV17 = null;
				if (null != list.get(i).getNetValue()) {
					labelV17 = new Label(17, i + 1 - recordQuantityTimes, list.get(i).getNetValue().toString());
				} else {
					labelV17 = new Label(17, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV18 = new Label(18, i + 1 - recordQuantityTimes, list.get(i).getAssetStatus());
				Label labelV19 = new Label(19, i + 1 - recordQuantityTimes, list.get(i).getProfitEnterSecLevelUnit());
				Label labelV20 = new Label(20, i + 1 - recordQuantityTimes, list.get(i).getCostControlArea());
				Label labelV21 = new Label(21, i + 1 - recordQuantityTimes, list.get(i).getAssetDescription());
				Label labelV22 = new Label(22, i + 1 - recordQuantityTimes, list.get(i).getProjectType());
				Label labelV23 = null;
				if (null != list.get(i).getCapitalizationDate()) {
					labelV23 = new Label(23, i + 1 - recordQuantityTimes,
							df.format(list.get(i).getCapitalizationDate()).toString());
				} else {
					labelV23 = new Label(23, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV24 = null;
				if (null != list.get(i).getDeliveryDate()) {
					labelV24 = new Label(24, i + 1 - recordQuantityTimes,
							df.format(list.get(i).getDeliveryDate()).toString());
				} else {
					labelV24 = new Label(24, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV25 = null;
				if (null != list.get(i).getManufactureDate()) {
					labelV25 = new Label(25, i + 1 - recordQuantityTimes,
							df.format(list.get(i).getManufactureDate()).toString());
				} else {
					labelV25 = new Label(25, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV26 = null;
				if (null != list.get(i).getLineLength()) {
					labelV26 = new Label(26, i + 1 - recordQuantityTimes, list.get(i).getLineLength().toString());
				} else {
					labelV26 = new Label(26, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV27 = new Label(27, i + 1 - recordQuantityTimes, list.get(i).getLengthUnit());
				Label labelV28 = null;
				if (null != list.get(i).getTransformerCapacity()) {
					labelV28 = new Label(28, i + 1 - recordQuantityTimes,
							list.get(i).getTransformerCapacity().toString());
				} else {
					labelV28 = new Label(28, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV29 = new Label(29, i + 1 - recordQuantityTimes, list.get(i).getCapacityUnit());
				Label labelV30 = new Label(30, i + 1 - recordQuantityTimes, list.get(i).getWarehouseAddress());
				Label labelV31 = new Label(31, i + 1 - recordQuantityTimes, list.get(i).getSparePartMark());
				Label labelV32 = new Label(32, i + 1 - recordQuantityTimes, list.get(i).getReusingDeviceMark());
				Label labelV33 = null;
				if (null != list.get(i).getReusingEntryDate()) {
					labelV33 = new Label(33, i + 1 - recordQuantityTimes,
							df.format(list.get(i).getReusingEntryDate()).toString());
				} else {
					labelV33 = new Label(33, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV34 = null;
				if (null != list.get(i).getReusingOutDate()) {
					labelV34 = new Label(34, i + 1 - recordQuantityTimes,
							df.format(list.get(i).getReusingOutDate()).toString());
				} else {
					labelV34 = new Label(34, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV35 = new Label(35, i + 1 - recordQuantityTimes,
						list.get(i).getDiscardProjectResourceCode());
				Label labelV36 = new Label(36, i + 1 - recordQuantityTimes, list.get(i).getDiscardReasonCode());
				Label labelV37 = null;
				if (null != list.get(i).getDiscardAccountingDate()) {
					labelV37 = new Label(37, i + 1 - recordQuantityTimes,
							df.format(list.get(i).getDiscardAccountingDate()).toString());
				} else {
					labelV37 = new Label(37, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV38 = new Label(38, i + 1 - recordQuantityTimes, list.get(i).getEquipmentStatus());
				Label labelV39 = new Label(39, i + 1 - recordQuantityTimes, list.get(i).getEquipmentVoltageLevel());
				Label labelV40 = new Label(40, i + 1 - recordQuantityTimes, list.get(i).getIsCustody());
				Label labelV41 = new Label(41, i + 1 - recordQuantityTimes, list.get(i).getManufacturerCard());
				Label labelV42 = new Label(42, i + 1 - recordQuantityTimes, list.get(i).getManufacturerEquipement());
				Label labelV43 = new Label(43, i + 1 - recordQuantityTimes, list.get(i).getManufactureState());
				Label labelV44 = new Label(44, i + 1 - recordQuantityTimes, list.get(i).getManufacturePartNumber());
				Label labelV45 = new Label(45, i + 1 - recordQuantityTimes, list.get(i).getInactivityDate());
				Label labelV46 = new Label(46, i + 1 - recordQuantityTimes, list.get(i).getAssetCategory());
				Label labelV47 = new Label(47, i + 1 - recordQuantityTimes, list.get(i).getCardSerialNumber());
				Label labelV48 = new Label(48, i + 1 - recordQuantityTimes, list.get(i).getCardInventoryNumber());
				Label labelV49 = new Label(49, i + 1 - recordQuantityTimes, list.get(i).getCardAssetUnit());
				Label labelV50 = new Label(50, i + 1 - recordQuantityTimes, list.get(i).getCardStorageUnit());
				Label labelV51 = new Label(51, i + 1 - recordQuantityTimes, list.get(i).getCardCostCenter());
				Label labelV52 = new Label(52, i + 1 - recordQuantityTimes, list.get(i).getCardAssetManageDepart());
				Label labelV53 = new Label(53, i + 1 - recordQuantityTimes, list.get(i).getCardUsingCustodian());
				Label labelV54 = new Label(54, i + 1 - recordQuantityTimes, list.get(i).getCardCarLicense());
				Label labelV55 = new Label(55, i + 1 - recordQuantityTimes, list.get(i).getCostCenterAuxilAccounting());
				Label labelV56 = new Label(56, i + 1 - recordQuantityTimes, list.get(i).getDonationType());
				Label labelV57 = new Label(57, i + 1 - recordQuantityTimes, list.get(i).getSuperviseSign());
				Label labelV58 = new Label(58, i + 1 - recordQuantityTimes, list.get(i).getAssetUsingInformation());
				Label labelV59 = new Label(59, i + 1 - recordQuantityTimes, list.get(i).getAssetIncreaseMethod());
				Label labelV60 = new Label(60, i + 1 - recordQuantityTimes, list.get(i).getAssetChangeMode());
				Label labelV61 = new Label(61, i + 1 - recordQuantityTimes, list.get(i).getAssetOrigin());
				Label labelV62 = new Label(62, i + 1 - recordQuantityTimes, list.get(i).getEngineeringProperty());
				Label labelV63 = new Label(63, i + 1 - recordQuantityTimes, list.get(i).getFixedAssetClass());
				Label labelV64 = new Label(64, i + 1 - recordQuantityTimes, list.get(i).getCardWbsElement());
				Label labelV65 = new Label(65, i + 1 - recordQuantityTimes, list.get(i).getCardWbsElementDesc());
				Label labelV66 = new Label(66, i + 1 - recordQuantityTimes, list.get(i).getAssetStorageAddress());
				Label labelV67 = new Label(67, i + 1 - recordQuantityTimes, list.get(i).getLineStationName());
				Label labelV68 = new Label(68, i + 1 - recordQuantityTimes, list.get(i).getHousePropCertifiNum());
				Label labelV69 = new Label(69, i + 1 - recordQuantityTimes, list.get(i).getEquipementName());
				Label labelV70 = new Label(70, i + 1 - recordQuantityTimes, list.get(i).getTechnicalObjectType());
				Label labelV71 = new Label(71, i + 1 - recordQuantityTimes, list.get(i).getAuthorizationGroup());
				Label labelV72 = new Label(72, i + 1 - recordQuantityTimes, list.get(i).getEquipSpecificationModel());
				Label labelV73 = new Label(73, i + 1 - recordQuantityTimes, list.get(i).getEquipNameplateNumber());
				Label labelV74 = new Label(74, i + 1 - recordQuantityTimes, list.get(i).getMaintenanceFactory());
				Label labelV75 = new Label(75, i + 1 - recordQuantityTimes, list.get(i).getEquipAssetChangeMode());
				Label labelV76 = new Label(76, i + 1 - recordQuantityTimes, list.get(i).getFactoryArea());
				Label labelV77 = new Label(77, i + 1 - recordQuantityTimes, list.get(i).getAbcIdentification());
				Label labelV78 = new Label(78, i + 1 - recordQuantityTimes, list.get(i).getClassifiedField());
				Label labelV79 = new Label(79, i + 1 - recordQuantityTimes, list.get(i).getEquipmentCostCenter());
				Label labelV80 = new Label(80, i + 1 - recordQuantityTimes, list.get(i).getEquipmentWbsElement());
				Label labelV81 = new Label(81, i + 1 - recordQuantityTimes, list.get(i).getEquipWbsElementDesc());
				Label labelV82 = new Label(82, i + 1 - recordQuantityTimes, list.get(i).getPlanFactory());
				Label labelV83 = new Label(83, i + 1 - recordQuantityTimes, list.get(i).getPlanGroup());
				Label labelV84 = new Label(84, i + 1 - recordQuantityTimes, list.get(i).getMainWorkCenter());
				Label labelV85 = new Label(85, i + 1 - recordQuantityTimes, list.get(i).getFunctionalPosition());
				Label labelV86 = new Label(86, i + 1 - recordQuantityTimes, list.get(i).getAdvancedEquipment());
				Label labelV87 = new Label(87, i + 1 - recordQuantityTimes, list.get(i).getTechIdentificationNumber());
				Label labelV88 = new Label(88, i + 1 - recordQuantityTimes, list.get(i).getEquipUseCustodian());
				Label labelV89 = new Label(89, i + 1 - recordQuantityTimes, list.get(i).getEquipStorageDepartment());
				Label labelV90 = new Label(90, i + 1 - recordQuantityTimes,
						list.get(i).getEquipObjectManageDeparment());
				Label labelV91 = new Label(91, i + 1 - recordQuantityTimes, list.get(i).getEpqipmentIncreaseMethod());
				Label labelV92 = new Label(92, i + 1 - recordQuantityTimes, list.get(i).getEquipmentSotrageAddress());
				Label labelV93 = new Label(93, i + 1 - recordQuantityTimes, list.get(i).getEquipCarLicense());
				Label labelV94 = new Label(94, i + 1 - recordQuantityTimes, list.get(i).getEquipHousePropCertifiNum());
				// System.out.println("list.get(i).getLineStationLogo()=" +
				// list.get(i).getLineStationLogo());
				Label labelV95 = new Label(95, i + 1 - recordQuantityTimes, list.get(i).getLineStationLogo());
				Label labelV96 = new Label(96, i + 1 - recordQuantityTimes, list.get(i).getDiscardOriginProjectDesc());
				Label labelV97 = new Label(97, i + 1 - recordQuantityTimes, list.get(i).getDiscardReasonContent());
				// System.out.println("list.get(i).getDiscardReasonContent()=" +
				// list.get(i).getDiscardReasonContent());
				Label labelV98 = null;
				if (null != list.get(i).getDataExtractDate()) {
					labelV98 = new Label(98, i + 1 - recordQuantityTimes,
							df.format(list.get(i).getDataExtractDate()).toString());
				} else {
					labelV98 = new Label(98, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV99 = null;
				if (null != list.get(i).getDataExtractTime()) {
					labelV99 = new Label(99, i + 1 - recordQuantityTimes,
							df.format(list.get(i).getDataExtractTime()).toString());
				} else {
					labelV99 = new Label(99, i + 1 - recordQuantityTimes, new String(""));
				}
				Label labelV100 = new Label(100, i + 1 - recordQuantityTimes, list.get(i).getDataExtractPerson());
				Label labelV101 = new Label(101, i + 1 - recordQuantityTimes, list.get(i).getAssetProperty());
				Label labelV102 = new Label(102, i + 1 - recordQuantityTimes, list.get(i).getPropertyCode());
				// System.out.println("list.get(i).getPropertyCode()=" +
				// list.get(i).getPropertyCode());
				// System.out.println("getLineStationName");
				// System.out.println("i=" + i);

				sheet.addCell(labelV0);
				sheet.addCell(labelV1);
				sheet.addCell(labelV2);
				sheet.addCell(labelV3);
				sheet.addCell(labelV4);
				sheet.addCell(labelV5);
				sheet.addCell(labelV6);
				sheet.addCell(labelV7);
				sheet.addCell(labelV8);
				sheet.addCell(labelV9);
				sheet.addCell(labelV10);
				sheet.addCell(labelV11);
				sheet.addCell(labelV12);
				sheet.addCell(labelV13);
				sheet.addCell(labelV14);
				sheet.addCell(labelV15);
				sheet.addCell(labelV16);
				sheet.addCell(labelV17);
				sheet.addCell(labelV18);
				sheet.addCell(labelV19);
				sheet.addCell(labelV20);
				sheet.addCell(labelV21);
				sheet.addCell(labelV22);
				sheet.addCell(labelV23);
				sheet.addCell(labelV24);
				sheet.addCell(labelV25);
				sheet.addCell(labelV26);
				sheet.addCell(labelV27);
				sheet.addCell(labelV28);
				sheet.addCell(labelV29);
				sheet.addCell(labelV30);
				sheet.addCell(labelV31);
				sheet.addCell(labelV32);
				sheet.addCell(labelV33);
				sheet.addCell(labelV34);
				sheet.addCell(labelV35);
				sheet.addCell(labelV36);
				sheet.addCell(labelV37);
				sheet.addCell(labelV38);
				sheet.addCell(labelV39);
				sheet.addCell(labelV40);
				sheet.addCell(labelV41);
				sheet.addCell(labelV42);
				sheet.addCell(labelV43);
				sheet.addCell(labelV44);
				sheet.addCell(labelV45);
				sheet.addCell(labelV46);
				sheet.addCell(labelV47);
				sheet.addCell(labelV48);
				sheet.addCell(labelV49);
				sheet.addCell(labelV50);
				sheet.addCell(labelV51);
				sheet.addCell(labelV52);
				sheet.addCell(labelV53);
				sheet.addCell(labelV54);
				sheet.addCell(labelV55);
				sheet.addCell(labelV56);
				sheet.addCell(labelV57);
				sheet.addCell(labelV58);
				sheet.addCell(labelV59);
				sheet.addCell(labelV60);
				sheet.addCell(labelV61);
				sheet.addCell(labelV62);
				sheet.addCell(labelV63);
				sheet.addCell(labelV64);
				sheet.addCell(labelV65);
				sheet.addCell(labelV66);
				sheet.addCell(labelV67);
				sheet.addCell(labelV68);
				sheet.addCell(labelV69);
				sheet.addCell(labelV70);
				sheet.addCell(labelV71);
				sheet.addCell(labelV72);
				sheet.addCell(labelV73);
				sheet.addCell(labelV74);
				sheet.addCell(labelV75);
				sheet.addCell(labelV76);
				sheet.addCell(labelV77);
				sheet.addCell(labelV78);
				sheet.addCell(labelV79);
				sheet.addCell(labelV80);
				sheet.addCell(labelV81);
				sheet.addCell(labelV82);
				sheet.addCell(labelV83);
				sheet.addCell(labelV84);
				sheet.addCell(labelV85);
				sheet.addCell(labelV86);
				sheet.addCell(labelV87);
				sheet.addCell(labelV88);
				sheet.addCell(labelV89);
				sheet.addCell(labelV90);
				sheet.addCell(labelV91);
				sheet.addCell(labelV92);
				sheet.addCell(labelV93);
				sheet.addCell(labelV94);
				sheet.addCell(labelV95);
				sheet.addCell(labelV96);
				sheet.addCell(labelV97);
				sheet.addCell(labelV98);
				sheet.addCell(labelV99);
				sheet.addCell(labelV100);
				sheet.addCell(labelV101);
				sheet.addCell(labelV102);

				System.out.println("i=" + i);
			}
			System.out.println(sheet.toString());
			// }

			// 写入数据并关闭文件
			book.write();
			book.close();
			System.out.println("创建文件成功!");
			now = new Date();
			nowdate = df.format(now);
			System.out.println("Now time is :" + nowdate);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void createXLS() {
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			Date now = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
			String nowdate = df.format(now);
			// 打开文件
			WritableWorkbook book = Workbook.createWorkbook(new File("D:/temp/" + nowdate + ".xls"));
			System.out.println(book);
			System.out.println(nowdate + ".xls");
			// 生成名为"第一页"的工作表，参数0表示这是第一
			WritableSheet sheet = book.createSheet("第一页", 0);

			// 设置字体为宋体,16号字,加粗,颜色为黑色
			WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
			font1.setColour(Colour.BLACK);
			WritableCellFormat format1 = new WritableCellFormat(font1);
			format1.setAlignment(jxl.format.Alignment.CENTRE);
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Label labelA = new Label(0, 0, "pmsQuexianId", format1);
			Label labelB = new Label(1, 0, "calYear", format1);
			Label labelC = new Label(2, 0, "version", format1);
			Label labelD = new Label(3, 0, "sbbm", format1);
			Label labelE = new Label(4, 0, "dwmx", format1);
			Label labelF = new Label(5, 0, "qxbh", format1);
			Label labelG = new Label(6, 0, "zclxbm", format1);
			Label labelH = new Label(7, 0, "sblx", format1);
			Label labelI = new Label(8, 0, "tynf", format1);
			Label labelJ = new Label(9, 0, "dydj", format1);
			Label labelK = new Label(10, 0, "zzsmc", format1);
			Label labelL = new Label(11, 0, "sbxlmc", format1);
			Label labelM = new Label(12, 0, "qxms", format1);
			Label labelN = new Label(13, 0, "qxbw", format1);
			Label labelO = new Label(14, 0, "qxzryy", format1);
			Label labelP = new Label(15, 0, "sfxq", format1);
			Label labelQ = new Label(16, 0, "sfjs", format1);
			Label labelR = new Label(17, 0, "zryybm", format1);
			Label labelS = new Label(18, 0, "qxjsyy", format1);
			Label labelT = new Label(19, 0, "jsyybm", format1);
			Label labelU = new Label(20, 0, "qxdj", format1);
			Label labelV = new Label(21, 0, "fsrq", format1);
			Label labelW = new Label(22, 0, "xqrq", format1);
			Label labelX = new Label(23, 0, "bz", format1);
			Label labelY = new Label(24, 0, "xqsj", format1);
			Label labelZ = new Label(25, 0, "jsyy", format1);
			Label labelAA = new Label(26, 0, "zryy", format1);
			Label labelAB = new Label(27, 0, "cwbm", format1);
			Label labelAC = new Label(28, 0, "qfzd", format1);
			Label labelAD = new Label(29, 0, "ccrq", format1);
			Label labelAE = new Label(30, 0, "zcxlms", format1);
			Label labelAF = new Label(31, 0, "qxnr", format1);
			Label labelAG = new Label(32, 0, "zclxbm2", format1);
			Label labelAH = new Label(33, 0, "equipementName", format1);
			Label labelAI = new Label(34, 0, "lineStationName", format1);

			// 将定义好的单元格添加到工作表中
			sheet.addCell(labelA);
			sheet.addCell(labelB);
			sheet.addCell(labelC);
			sheet.addCell(labelD);
			sheet.addCell(labelE);
			sheet.addCell(labelF);
			sheet.addCell(labelG);
			sheet.addCell(labelH);
			sheet.addCell(labelI);
			sheet.addCell(labelJ);
			sheet.addCell(labelK);
			sheet.addCell(labelL);
			sheet.addCell(labelM);
			sheet.addCell(labelN);
			sheet.addCell(labelO);
			sheet.addCell(labelP);
			sheet.addCell(labelQ);
			sheet.addCell(labelR);
			sheet.addCell(labelS);
			sheet.addCell(labelT);
			sheet.addCell(labelU);
			sheet.addCell(labelV);
			sheet.addCell(labelW);
			sheet.addCell(labelX);
			sheet.addCell(labelY);
			sheet.addCell(labelZ);
			sheet.addCell(labelAA);
			sheet.addCell(labelAB);
			sheet.addCell(labelAC);
			sheet.addCell(labelAD);
			sheet.addCell(labelAE);
			sheet.addCell(labelAF);
			sheet.addCell(labelAG);
			sheet.addCell(labelAH);
			sheet.addCell(labelAI);

			// 创建预编译语句对象，一般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建一个结果集对象
			// ResultSet result = null;
			// String sql = "select * from PMS_QUEXIAN_2015_4";// 预编译语句
			// pre = conn.prepareStatement(sql);// 实例化预编译语句
			// result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			// 查询数据库中所有的数据
			List<PmsQuexian> list = PmsQuexianService.getAllByDb();
			System.out.println(list.size());
			// System.out.println("------------------------"+list.toString());

			// while (result.next()) {
			for (int i = 0; i < list.size(); i++) {
				int j = i / 65534;
				if ((i % 65534) == 0) {
					// 写入数据并关闭文件
					book.write();
					book.close();
					df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
					now = new Date();
					nowdate = df.format(now);
					book = Workbook.createWorkbook(new File("D:/temp/" + nowdate + ".xls"));

					sheet = book.createSheet("第一页", 0);
					labelA = new Label(0, 0, "pmsQuexianId", format1);
					labelB = new Label(1, 0, "calYear", format1);
					labelC = new Label(2, 0, "version", format1);
					labelD = new Label(3, 0, "sbbm", format1);
					labelE = new Label(4, 0, "dwmx", format1);
					labelF = new Label(5, 0, "qxbh", format1);
					labelG = new Label(6, 0, "zclxbm", format1);
					labelH = new Label(7, 0, "sblx", format1);
					labelI = new Label(8, 0, "tynf", format1);
					labelJ = new Label(9, 0, "dydj", format1);
					labelK = new Label(10, 0, "zzsmc", format1);
					labelL = new Label(11, 0, "sbxlmc", format1);
					labelM = new Label(12, 0, "qxms", format1);
					labelN = new Label(13, 0, "qxbw", format1);
					labelO = new Label(14, 0, "qxzryy", format1);
					labelP = new Label(15, 0, "sfxq", format1);
					labelQ = new Label(16, 0, "sfjs", format1);
					labelR = new Label(17, 0, "zryybm", format1);
					labelS = new Label(18, 0, "qxjsyy", format1);
					labelT = new Label(19, 0, "jsyybm", format1);
					labelU = new Label(20, 0, "qxdj", format1);
					labelV = new Label(21, 0, "fsrq", format1);
					labelW = new Label(22, 0, "xqrq", format1);
					labelX = new Label(23, 0, "bz", format1);
					labelY = new Label(24, 0, "xqsj", format1);
					labelZ = new Label(25, 0, "jsyy", format1);
					labelAA = new Label(26, 0, "zryy", format1);
					labelAB = new Label(27, 0, "cwbm", format1);
					labelAC = new Label(28, 0, "qfzd", format1);
					labelAD = new Label(29, 0, "ccrq", format1);
					labelAE = new Label(30, 0, "zcxlms", format1);
					labelAF = new Label(31, 0, "qxnr", format1);
					labelAG = new Label(32, 0, "zclxbm2", format1);
					labelAH = new Label(33, 0, "equipementName", format1);
					labelAI = new Label(34, 0, "lineStationName", format1);
					// 将定义好的单元格添加到工作表中
					sheet.addCell(labelA);
					sheet.addCell(labelB);
					sheet.addCell(labelC);
					sheet.addCell(labelD);
					sheet.addCell(labelE);
					sheet.addCell(labelF);
					sheet.addCell(labelG);
					sheet.addCell(labelH);
					sheet.addCell(labelI);
					sheet.addCell(labelJ);
					sheet.addCell(labelK);
					sheet.addCell(labelL);
					sheet.addCell(labelM);
					sheet.addCell(labelN);
					sheet.addCell(labelO);
					sheet.addCell(labelP);
					sheet.addCell(labelQ);
					sheet.addCell(labelR);
					sheet.addCell(labelS);
					sheet.addCell(labelT);
					sheet.addCell(labelU);
					sheet.addCell(labelV);
					sheet.addCell(labelW);
					sheet.addCell(labelX);
					sheet.addCell(labelY);
					sheet.addCell(labelZ);
					sheet.addCell(labelAA);
					sheet.addCell(labelAB);
					sheet.addCell(labelAC);
					sheet.addCell(labelAD);
					sheet.addCell(labelAE);
					sheet.addCell(labelAF);
					sheet.addCell(labelAG);
					sheet.addCell(labelAH);
					sheet.addCell(labelAI);
					df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					// break;
				}
				Label labelAi = new Label(0, i + 1 - j * 65534, list.get(i).getPmsQuexianId());
				// System.out.println("----------------------" +
				// labelAi.toString());
				Label labelBi = new Label(1, i + 1 - j * 65534, list.get(i).getCalYear().toString());
				Label labelCi = new Label(2, i + 1 - j * 65534, list.get(i).getVersion());
				Label labelDi = new Label(3, i + 1 - j * 65534, list.get(i).getSbbm());
				Label labelEi = new Label(4, i + 1 - j * 65534, list.get(i).getDwmx());
				Label labelFi = new Label(5, i + 1 - j * 65534, list.get(i).getQxbh());
				Label labelGi = new Label(6, i + 1 - j * 65534, list.get(i).getZclxbm());
				Label labelHi = new Label(7, i + 1 - j * 65534, list.get(i).getSblx());
				System.out.println("getTynf");
				Label labelIi = null;
				if (null != list.get(i).getTynf()) {
					labelIi = new Label(8, i + 1 - j * 65534, list.get(i).getTynf().toString());
				}
				System.out.println("getDydj");
				Label labelJi = new Label(9, i + 1 - j * 65534, list.get(i).getDydj());
				Label labelKi = new Label(10, i + 1 - j * 65534, list.get(i).getZzsmc());
				Label labelLi = new Label(11, i + 1 - j * 65534, list.get(i).getSbxlmc());
				Label labelMi = new Label(12, i + 1 - j * 65534, list.get(i).getQxms());
				Label labelNi = new Label(13, i + 1 - j * 65534, list.get(i).getQxbw());

				Label labelOi = new Label(14, i + 1 - j * 65534, list.get(i).getQxzryy());
				Label labelPi = new Label(15, i + 1 - j * 65534, list.get(i).getSfxq());
				Label labelQi = new Label(16, i + 1 - j * 65534, list.get(i).getSfjs());
				Label labelRi = new Label(17, i + 1 - j * 65534, list.get(i).getZryybm());
				Label labelSi = new Label(18, i + 1 - j * 65534, list.get(i).getQxjsyy());
				Label labelTi = new Label(19, i + 1 - j * 65534, list.get(i).getJsyybm());
				System.out.println("getQxdj");

				Label labelUi = new Label(20, i + 1 - j * 65534, list.get(i).getQxdj());
				Label labelVi = null;
				// System.out.println("getFsrq=" +
				// df.format(list.get(i).getFsrq()));
				if (null == list.get(i).getFsrq()) {
					labelVi = new Label(21, i + 1 - j * 65534, new String(""));
				} else {
					labelVi = new Label(21, i + 1 - j * 65534, df.format(list.get(i).getFsrq()));
				}
				Label labelWi = null;
				if (null == list.get(i).getXqrq()) {
					labelWi = new Label(22, i + 1 - j * 65534, new String(""));
				} else {
					System.out.println("getXqrq=" + df.format(list.get(i).getXqrq()));
					labelWi = new Label(22, i + 1 - j * 65534, df.format(list.get(i).getXqrq()).toString());
				}
				Label labelXi = new Label(23, i + 1 - j * 65534, list.get(i).getBz());
				Label labelYi = new Label(24, i + 1 - j * 65534, list.get(i).getXqsj().toString());
				Label labelZi = new Label(25, i + 1 - j * 65534, list.get(i).getJsyy());

				System.out.println("getZryy");
				Label labelAAi = new Label(26, i + 1 - j * 65534, list.get(i).getZryy());
				Label labelABi = new Label(27, i + 1 - j * 65534, list.get(i).getCwbm());
				Label labelACi = new Label(28, i + 1 - j * 65534, list.get(i).getQfzd());
				Label labelADi = null;
				if (null == list.get(i).getCcrq()) {
					labelADi = new Label(29, i + 1 - j * 65534, new String(""));
				} else {
					System.out.println("getCcrq=" + df.format(list.get(i).getCcrq()));
					labelADi = new Label(29, i + 1 - j * 65534, df.format(list.get(i).getCcrq()));
				}
				// System.out.println("getZcxlms");
				Label labelAEi = new Label(30, i + 1 - j * 65534, list.get(i).getZcxlms());
				// System.out.println("getQxnr");

				Label labelAFi = new Label(31, i + 1 - j * 65534, list.get(i).getQxnr());
				Label labelAGi = new Label(32, i + 1 - j * 65534, list.get(i).getZclxbm2());
				Label labelAHi = new Label(33, i + 1 - j * 65534, list.get(i).getEquipementName());
				Label labelAIi = new Label(34, i + 1 - j * 65534, list.get(i).getLineStationName());
				// System.out.println("getLineStationName");
				System.out.println("i=" + i);

				sheet.addCell(labelAi);
				sheet.addCell(labelBi);
				sheet.addCell(labelCi);
				sheet.addCell(labelDi);
				sheet.addCell(labelEi);
				sheet.addCell(labelFi);
				sheet.addCell(labelGi);
				sheet.addCell(labelHi);
				sheet.addCell(labelIi);
				sheet.addCell(labelJi);
				sheet.addCell(labelKi);
				sheet.addCell(labelLi);
				sheet.addCell(labelMi);
				sheet.addCell(labelNi);

				sheet.addCell(labelOi);
				sheet.addCell(labelPi);
				sheet.addCell(labelQi);
				sheet.addCell(labelRi);
				sheet.addCell(labelSi);
				sheet.addCell(labelTi);
				sheet.addCell(labelUi);
				sheet.addCell(labelVi);
				sheet.addCell(labelWi);
				sheet.addCell(labelXi);
				sheet.addCell(labelYi);
				sheet.addCell(labelZi);
				sheet.addCell(labelAAi);
				sheet.addCell(labelABi);
				sheet.addCell(labelACi);
				sheet.addCell(labelADi);
				sheet.addCell(labelAEi);
				sheet.addCell(labelAFi);
				sheet.addCell(labelAGi);
				sheet.addCell(labelAHi);
				sheet.addCell(labelAIi);

				System.out.println("i=" + i);
			}
			System.out.println(sheet.toString());
			// }

			// 写入数据并关闭文件
			book.write();
			book.close();
			System.out.println("创建文件成功!");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

