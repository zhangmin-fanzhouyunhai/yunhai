package com.yunhai.excel.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import com.yunhai.db.orm.TableColumnProperty;
import com.yunhai.db.util.DbUtil;
import com.yunhai.excel.orm.BicAzfiSwzc;
import com.yunhai.excel.orm.MidErpItem;
import com.yunhai.excel.orm.MidErpItemOld20199;
import com.yunhai.excel.orm.MidPmsItem;
import com.yunhai.excel.orm.MidPmsItemOldAge1992;
import com.yunhai.excel.orm.PmsQuexian;
import com.yunhai.excel.orm.ZfiSwzcHeBei;

import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class PmsQuexianService {

	/**
	 * @return
	 */
	public static List<BicAzfiSwzc> getAllBicAzfiSwzc(Connection conn, String tableName) {
		List<BicAzfiSwzc> list = new ArrayList<BicAzfiSwzc>();
		try {
			// Connection conn = null;
			// conn = Dbutil.getConnection();
			// 创建预编译语句对象，�?般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建�?个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参�?
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String bicAzfiSwzcId = null;
			String calyear = null;
			String compCode = null;
			String assetMain = null;
			String asset = null;
			String zioEqunr = null;
			String currency = null;
			Double zpmzcyz = null;
			Double zpmzcjz = null;
			String ztypbz1 = null;
			String ztypbz2 = null;
			String ztypbz3 = null;
			String zvolLev = null;
			Double zquantity = null;
			String unit = null;
			String zioZczt = null;
			String profitCtr = null;
			String zlrzx = null;
			String coArea = null;
			String zzcms = null;
			String zioZxmlx = null;
			String capitDate = null;
			String zdeakt = null;
			String assetClas = null;
			String zxlh = null;
			String zinvnr = null;
			String zi0Zzc1 = null;
			String zi0Zzc2 = null;
			String zioKostl = null;
			String zkostlv = null;
			String zioRaumn = null;
			String zzzph = null;
			String zzkostl = null;
			String zioZzc06 = null;
			String zioZzc07 = null;
			String zioOrd41 = null;
			String zord44 = null;
			String zgdlgrp = null;
			String zzcly = null;
			String zioUmwkz = null;
			String zsfdg = null;
			String zioHerst = null;
			String ztypbz = null;
			String zPosid = null;
			String zpost11 = null;
			String zfiamt = null;
			String zioStadt = null;
			String zfwcqzh = null;
			String zioEqktx = null;
			String zioTxt04 = null;
			String zioEqart = null;
			String zpmsqz = null;
			String zioInbdt = null;
			String zioZccrq = null;
			String zzzs = null;
			String zioHerld = null;
			String zioMapar = null;
			String ztxz012 = null;
			String zioSerge = null;
			String zioSwerk = null;
			String zioStort = null;
			String zioBeber = null;
			String zioAbckz = null;
			String zioEqfnr = null;
			String zioZzc02 = null;
			String zProjk = null;
			String zwbsnm = null;
			String zioIwerk = null;
			String zioIngrp = null;
			String zioVaplz = null;
			String zioTplnr = null;
			String zioHequi = null;
			String zioTidnr = null;
			String zioSb010 = null;
			String zioSb001 = null;
			String zioSb002 = null;
			String zioSb004 = null;
			String zioSb005 = null;
			String zioSb006 = null;
			String zioSb003 = null;
			String zioSb007 = null;
			Double zioSb008 = null;
			String zlenunt = null;
			Double zioSb009 = null;
			String zcapunt = null;
			String zioSb011 = null;
			String zioUmlgo = null;
			String zioGplab = null;
			String zioPosid = null;
			String zlyrkrq = null;
			String zlyckrq = null;
			String zpost1 = null;
			String zioCusre = null;
			String zbfyy = null;
			String zioZsb13 = null;
			String zioZsb12 = null;
			String recordmode = null;
			String dataVersion = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			long maxMem = run.maxMemory() / 1024 / 1024;
			long freeMem = run.freeMemory() / 1024 / 1024;
			long totalMem = run.totalMemory();
			long usedMem = maxMem - freeMem;
			while (result.next()) {

				maxMem = run.maxMemory() / 1024 / 1024;
				freeMem = run.freeMemory() / 1024 / 1024;
				totalMem = run.totalMemory();
				usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(usedMem / maxMem) + ",maxMem="
						+ (maxMem) + ",freeMem=" + (freeMem) + ",usedMem=" + (usedMem) + ",totalMem=" + (totalMem));

				// System.out.println("Add!");

				// try {
				// midPmsItemId = result.getString("MID_PMS_ITEM_ID");
				// } catch (SQLException e) {
				// try {
				// midPmsItemId = result.getString("MID_PMS_UNMATCHED_ITEM_ID");
				// } catch (SQLException e1) {
				// midPmsItemId = result.getString("MID_PMS_MATCHED_ITEM_ID");
				// }
				// }
				bicAzfiSwzcId = result.getString("BIC_AZFI_SWZC_ID");
				calyear = result.getString("CALYEAR");
				compCode = result.getString("COMP_CODE");
				assetMain = result.getString("ASSET_MAIN");
				asset = result.getString("ASSET");
				zioEqunr = result.getString("ZIO_EQUNR");
				currency = result.getString("CURRENCY");
				if (null == result.getString("ZPMZCYZ")) {
					zpmzcyz = Double.parseDouble("0");
				} else {
					zpmzcyz = Double.parseDouble(result.getString("ZPMZCYZ"));
				}
				// zpmzcyz= result.getString("ZPMZCYZ");
				if (null == result.getString("ZPMZCJZ")) {
					zpmzcjz = Double.parseDouble("0");
				} else {
					zpmzcjz = Double.parseDouble(result.getString("ZPMZCJZ"));
				}
				// zpmzcjz= result.getString("ZPMZCJZ");
				ztypbz1 = result.getString("ZTYPBZ1");
				ztypbz2 = result.getString("ZTYPBZ2");
				ztypbz3 = result.getString("ZTYPBZ3");
				zvolLev = result.getString("ZVOL_LEV");
				if (null == result.getString("ZQUANTITY")) {
					zquantity = Double.parseDouble("0");
				} else {
					zquantity = Double.parseDouble(result.getString("ZQUANTITY"));
				}
				// zquantity= result.getString("ZQUANTITY");
				unit = result.getString("UNIT");
				zioZczt = result.getString("ZIO_ZCZT");
				profitCtr = result.getString("PROFIT_CTR");
				zlrzx = result.getString("ZLRZX");
				coArea = result.getString("CO_AREA");
				zzcms = result.getString("ZZCMS");
				zioZxmlx = result.getString("ZIO_ZXMLX");
				capitDate = result.getString("CAPIT_DATE");
				zdeakt = result.getString("ZDEAKT");
				assetClas = result.getString("ASSET_CLAS");
				zxlh = result.getString("ZXLH");
				zinvnr = result.getString("ZINVNR");
				zi0Zzc1 = result.getString("ZI0_ZZC1");
				zi0Zzc2 = result.getString("ZI0_ZZC2");
				zioKostl = result.getString("ZIO_KOSTL");
				zkostlv = result.getString("ZKOSTLV");
				zioRaumn = result.getString("ZIO_RAUMN");
				zzzph = result.getString("ZZZPH");
				zzkostl = result.getString("ZZKOSTL");
				zioZzc06 = result.getString("ZIO_ZZC06");
				zioZzc07 = result.getString("ZIO_ZZC07");
				zioOrd41 = result.getString("ZIO_ORD41");
				zord44 = result.getString("ZORD44");
				zgdlgrp = result.getString("ZGDLGRP");
				zzcly = result.getString("ZZCLY");
				zioUmwkz = result.getString("ZIO_UMWKZ");
				zsfdg = result.getString("ZSFDG");
				zioHerst = result.getString("ZIO_HERST");
				ztypbz = result.getString("ZTYPBZ");
				zPosid = result.getString("Z_POSID");
				zpost11 = result.getString("ZPOST11");
				zfiamt = result.getString("ZFIAMT");
				zioStadt = result.getString("ZIO_STADT");
				zfwcqzh = result.getString("ZFWCQZH");
				zioEqktx = result.getString("ZIO_EQKTX");
				zioTxt04 = result.getString("ZIO_TXT04");
				zioEqart = result.getString("ZIO_EQART");
				zpmsqz = result.getString("ZPMSQZ");
				zioInbdt = result.getString("ZIO_INBDT");
				zioZccrq = result.getString("ZIO_ZCCRQ");
				zzzs = result.getString("ZZZS");
				zioHerld = result.getString("ZIO_HERLD");
				zioMapar = result.getString("ZIO_MAPAR");
				ztxz012 = result.getString("ZTXZ012");
				zioSerge = result.getString("ZIO_SERGE");
				zioSwerk = result.getString("ZIO_SWERK");
				zioStort = result.getString("ZIO_STORT");
				zioBeber = result.getString("ZIO_BEBER");
				zioAbckz = result.getString("ZIO_ABCKZ");
				zioEqfnr = result.getString("ZIO_EQFNR");
				zioZzc02 = result.getString("ZIO_ZZC02");
				zProjk = result.getString("Z_PROJK");
				zwbsnm = result.getString("ZWBSNM");
				zioIwerk = result.getString("ZIO_IWERK");
				zioIngrp = result.getString("ZIO_INGRP");
				zioVaplz = result.getString("ZIO_VAPLZ");
				zioTplnr = result.getString("ZIO_TPLNR");
				zioHequi = result.getString("ZIO_HEQUI");
				zioTidnr = result.getString("ZIO_TIDNR");
				zioSb010 = result.getString("ZIO_SB010");
				zioSb001 = result.getString("ZIO_SB001");
				zioSb002 = result.getString("ZIO_SB002");
				zioSb004 = result.getString("ZIO_SB004");
				zioSb005 = result.getString("ZIO_SB005");
				zioSb006 = result.getString("ZIO_SB006");
				zioSb003 = result.getString("ZIO_SB003");
				zioSb007 = result.getString("ZIO_SB007");
				if (null == result.getString("ZIO_SB008")) {
					zioSb008 = Double.parseDouble("0");
				} else {
					zioSb008 = Double.parseDouble(result.getString("ZIO_SB008"));
				}
				// zioSb008= result.getString("ZIO_SB008");
				zlenunt = result.getString("ZLENUNT");
				if (null == result.getString("ZIO_SB009")) {
					zioSb009 = Double.parseDouble("0");
				} else {
					zioSb009 = Double.parseDouble(result.getString("ZIO_SB009"));
				}
				// zioSb009= result.getString("ZIO_SB009");
				zcapunt = result.getString("ZCAPUNT");
				zioSb011 = result.getString("ZIO_SB011");
				zioUmlgo = result.getString("ZIO_UMLGO");
				zioGplab = result.getString("ZIO_GPLAB");
				zioPosid = result.getString("ZIO_POSID");
				zlyrkrq = result.getString("ZLYRKRQ");
				zlyckrq = result.getString("ZLYCKRQ");
				zpost1 = result.getString("ZPOST1");
				zioCusre = result.getString("ZIO_CUSRE");
				zbfyy = result.getString("ZBFYY");
				zioZsb13 = result.getString("ZIO_ZSB13");
				zioZsb12 = result.getString("ZIO_ZSB12");
				recordmode = result.getString("RECORDMODE");
				dataVersion = result.getString("DATA_VERSION");

				list.add(new BicAzfiSwzc(bicAzfiSwzcId, calyear, compCode, assetMain, asset, zioEqunr, currency,
						zpmzcyz, zpmzcjz, ztypbz1, ztypbz2, ztypbz3, zvolLev, zquantity, unit, zioZczt, profitCtr,
						zlrzx, coArea, zzcms, zioZxmlx, capitDate, zdeakt, assetClas, zxlh, zinvnr, zi0Zzc1, zi0Zzc2,
						zioKostl, zkostlv, zioRaumn, zzzph, zzkostl, zioZzc06, zioZzc07, zioOrd41, zord44, zgdlgrp,
						zzcly, zioUmwkz, zsfdg, zioHerst, ztypbz, zPosid, zpost11, zfiamt, zioStadt, zfwcqzh, zioEqktx,
						zioTxt04, zioEqart, zpmsqz, zioInbdt, zioZccrq, zzzs, zioHerld, zioMapar, ztxz012, zioSerge,
						zioSwerk, zioStort, zioBeber, zioAbckz, zioEqfnr, zioZzc02, zProjk, zwbsnm, zioIwerk, zioIngrp,
						zioVaplz, zioTplnr, zioHequi, zioTidnr, zioSb010, zioSb001, zioSb002, zioSb004, zioSb005,
						zioSb006, zioSb003, zioSb007, zioSb008, zlenunt, zioSb009, zcapunt, zioSb011, zioUmlgo,
						zioGplab, zioPosid, zlyrkrq, zlyckrq, zpost1, zioCusre, zbfyy, zioZsb13, zioZsb12, recordmode,
						dataVersion));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @return
	 */
	public static List<ZfiSwzcHeBei> getAllZfiSwzcHeBei(String tableName) {
		List<ZfiSwzcHeBei> list = new ArrayList<ZfiSwzcHeBei>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			// 创建预编译语句对象，�?般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建�?个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参�?
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String mandt = null;
			Integer calyear = null;
			String compCode = null;
			String assetMain = null;
			String asset = null;
			String equnr = null;
			String currency = null;
			Double zpmzcyz = null;
			Double zpmzcjz = null;
			String ztypbz1 = null;
			String ztypbz1t = null;
			String ztypbz2 = null;
			String ztypbz2t = null;
			String ztypbz3 = null;
			String ztypbz3t = null;
			String zvolLev = null;
			Double zquantity = null;
			String unit = null;
			String zioZczt = null;
			String profitCtr = null;
			String zlrzx = null;
			String coArea = null;
			String zzcms = null;
			String zioZxmlx = null;
			String aktiv = null;
			String deakt = null;
			String anlkl = null;
			String txk20 = null;
			String sernr = null;
			String invnr = null;
			String zzc001 = null;
			String zzc002 = null;
			String kostl = null;
			String ltext = null;
			String kostlv = null;
			String raumn = null;
			String kfzkz = null;
			String zzas1 = null;
			String zzc006 = null;
			String zzc007 = null;
			String ord41 = null;
			String ord44 = null;
			String gdlgrp = null;
			String izwek = null;
			String umwkz = null;
			String anlue = null;
			String herst = null;
			String typbz = null;
			String stext4 = null;
			String zkpwbs = null;
			String zkpwbsms = null;
			String fiamt = null;
			String stadt = null;
			String zfwcqzh = null;
			String eqktx = null;
			String txt04 = null;
			String eqart = null;
			String begru = null;
			String inbdt = null;
			String zccrq = null;
			String zherst = null;
			String herld = null;
			String mapar = null;
			String ztypbz = null;
			String serge = null;
			String swerk = null;
			String stort = null;
			String beber = null;
			String abckz = null;
			String eqfnr = null;
			String zkostl = null;
			String zsbwbs = null;
			String zsbwbsms = null;
			String iwerk = null;
			String ingrp = null;
			String gewrk = null;
			String tplnr = null;
			String hequi = null;
			String tidnr = null;
			String zsb010 = null;
			String zsb001 = null;
			String zsb002 = null;
			String zsb004 = null;
			String zsb005 = null;
			String zsb006 = null;
			String zsb003 = null;
			String zsb007 = null;
			String zsb008 = null;
			String zlenunt = null;
			String zsb009 = null;
			String zcapunt = null;
			String zsb011 = null;
			String zeq003 = null;
			String zeq001 = null;
			String zeq002 = null;
			String zlyrkrq = null;
			String zlyckrq = null;
			String zbfjzrq = null;
			String zbfxmbm = null;
			String zbfxmms = null;
			String zbfyydm = null;
			String zbfyywb = null;
			String pmunr = null;
			String cdate = null;
			String ctime = null;
			String cname = null;
			String version = null;
			Date calYear = null;
			String assetProperty = null;
			String propertyCode = null;
			String fing = null;
			String assetId = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			long maxMem = run.maxMemory() / 1024 / 1024;
			long freeMem = run.freeMemory() / 1024 / 1024;
			long totalMem = run.totalMemory();
			long usedMem = maxMem - freeMem;
			while (result.next()) {

				maxMem = run.maxMemory() / 1024 / 1024;
				freeMem = run.freeMemory() / 1024 / 1024;
				totalMem = run.totalMemory();
				usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(usedMem / maxMem) + ",maxMem="
						+ (maxMem) + ",freeMem=" + (freeMem) + ",usedMem=" + (usedMem) + ",totalMem=" + (totalMem));

				mandt = result.getString("MANDT");
				try {
					calyear = new DecimalFormat().parse(result.getString("CALYEAR")).intValue();
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				compCode = result.getString("COMP_CODE");
				assetMain = result.getString("ASSET_MAIN");
				asset = result.getString("ASSET");
				equnr = result.getString("EQUNR");
				currency = result.getString("CURRENCY");
				try {
					zpmzcyz = new DecimalFormat().parse(result.getString("ZPMZCYZ")).doubleValue();
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					zpmzcjz = new DecimalFormat().parse(result.getString("ZPMZCJZ")).doubleValue();
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				ztypbz1 = result.getString("ZTYPBZ1");
				ztypbz1t = result.getString("ZTYPBZ1T");
				ztypbz2 = result.getString("ZTYPBZ2");
				ztypbz2t = result.getString("ZTYPBZ2T");
				ztypbz3 = result.getString("ZTYPBZ3");
				ztypbz3t = result.getString("ZTYPBZ3T");
				zvolLev = result.getString("ZVOL_LEV");
				try {
					zquantity = new DecimalFormat().parse(result.getString("ZQUANTITY")).doubleValue();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				unit = result.getString("UNIT");
				zioZczt = result.getString("ZIO_ZCZT");
				profitCtr = result.getString("PROFIT_CTR");
				zlrzx = result.getString("ZLRZX");
				coArea = result.getString("CO_AREA");
				zzcms = result.getString("ZZCMS");
				zioZxmlx = result.getString("ZIO_ZXMLX");
				aktiv = result.getString("AKTIV");
				deakt = result.getString("DEAKT");
				anlkl = result.getString("ANLKL");
				txk20 = result.getString("TXK20");
				sernr = result.getString("SERNR");
				invnr = result.getString("INVNR");
				zzc001 = result.getString("ZZC001");
				zzc002 = result.getString("ZZC002");
				kostl = result.getString("KOSTL");
				ltext = result.getString("LTEXT");
				kostlv = result.getString("KOSTLV");
				raumn = result.getString("RAUMN");
				kfzkz = result.getString("KFZKZ");
				zzas1 = result.getString("ZZAS1");
				zzc006 = result.getString("ZZC006");
				zzc007 = result.getString("ZZC007");
				ord41 = result.getString("ORD41");
				ord44 = result.getString("ORD44");
				gdlgrp = result.getString("GDLGRP");
				izwek = result.getString("IZWEK");
				umwkz = result.getString("UMWKZ");
				anlue = result.getString("ANLUE");
				herst = result.getString("HERST");
				typbz = result.getString("TYPBZ");
				stext4 = result.getString("STEXT4");
				zkpwbs = result.getString("ZKPWBS");
				zkpwbsms = result.getString("ZKPWBSMS");
				fiamt = result.getString("FIAMT");
				stadt = result.getString("STADT");
				zfwcqzh = result.getString("ZFWCQZH");
				eqktx = result.getString("EQKTX");
				txt04 = result.getString("TXT04");
				eqart = result.getString("EQART");
				begru = result.getString("BEGRU");
				inbdt = result.getString("INBDT");
				zccrq = result.getString("ZCCRQ");
				zherst = result.getString("ZHERST");
				herld = result.getString("HERLD");
				mapar = result.getString("MAPAR");
				ztypbz = result.getString("ZTYPBZ");
				serge = result.getString("SERGE");
				swerk = result.getString("SWERK");
				stort = result.getString("STORT");
				beber = result.getString("BEBER");
				abckz = result.getString("ABCKZ");
				eqfnr = result.getString("EQFNR");
				zkostl = result.getString("ZKOSTL");
				zsbwbs = result.getString("ZSBWBS");
				zsbwbsms = result.getString("ZSBWBSMS");
				iwerk = result.getString("IWERK");
				ingrp = result.getString("INGRP");
				gewrk = result.getString("GEWRK");
				tplnr = result.getString("TPLNR");
				hequi = result.getString("HEQUI");
				tidnr = result.getString("TIDNR");
				zsb010 = result.getString("ZSB010");
				zsb001 = result.getString("ZSB001");
				zsb002 = result.getString("ZSB002");
				zsb004 = result.getString("ZSB004");
				zsb005 = result.getString("ZSB005");
				zsb006 = result.getString("ZSB006");
				zsb003 = result.getString("ZSB003");
				zsb007 = result.getString("ZSB007");
				zsb008 = result.getString("ZSB008");
				zlenunt = result.getString("ZLENUNT");
				zsb009 = result.getString("ZSB009");
				zcapunt = result.getString("ZCAPUNT");
				zsb011 = result.getString("ZSB011");
				zeq003 = result.getString("ZEQ003");
				zeq001 = result.getString("ZEQ001");
				zeq002 = result.getString("ZEQ002");
				zlyrkrq = result.getString("ZLYRKRQ");
				zlyckrq = result.getString("ZLYCKRQ");
				zbfjzrq = result.getString("ZBFJZRQ");
				zbfxmbm = result.getString("ZBFXMBM");
				zbfxmms = result.getString("ZBFXMMS");
				zbfyydm = result.getString("ZBFYYDM");
				zbfyywb = result.getString("ZBFYYWB");
				pmunr = result.getString("PMUNR");
				cdate = result.getString("CDATE");
				ctime = result.getString("CTIME");
				cname = result.getString("CNAME");
				version = result.getString("VERSION");
				try {
					calYear = simpleDateFormat.parse(result.getString("CAL_YEAR"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				assetProperty = result.getString("ASSET_PROPERTY");
				propertyCode = result.getString("PROPERTY_CODE");
				fing = result.getString("FING");
				assetId = result.getString("ASSET_ID");

				list.add(new ZfiSwzcHeBei(mandt, calyear, compCode, assetMain, asset, equnr, currency, zpmzcyz, zpmzcjz,
						ztypbz1, ztypbz1t, ztypbz2, ztypbz2t, ztypbz3, ztypbz3t, zvolLev, zquantity, unit, zioZczt,
						profitCtr, zlrzx, coArea, zzcms, zioZxmlx, aktiv, deakt, anlkl, txk20, sernr, invnr, zzc001,
						zzc002, kostl, ltext, kostlv, raumn, kfzkz, zzas1, zzc006, zzc007, ord41, ord44, gdlgrp, izwek,
						umwkz, anlue, herst, typbz, stext4, zkpwbs, zkpwbsms, fiamt, stadt, zfwcqzh, eqktx, txt04,
						eqart, begru, inbdt, zccrq, zherst, herld, mapar, ztypbz, serge, swerk, stort, beber, abckz,
						eqfnr, zkostl, zsbwbs, zsbwbsms, iwerk, ingrp, gewrk, tplnr, hequi, tidnr, zsb010, zsb001,
						zsb002, zsb004, zsb005, zsb006, zsb003, zsb007, zsb008, zlenunt, zsb009, zcapunt, zsb011,
						zeq003, zeq001, zeq002, zlyrkrq, zlyckrq, zbfjzrq, zbfxmbm, zbfxmms, zbfyydm, zbfyywb, pmunr,
						cdate, ctime, cname, fing));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @return
	 */
	public static List<MidPmsItem> getAllMidPmsItem(String tableName) {
		List<MidPmsItem> list = new ArrayList<MidPmsItem>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			// 创建预编译语句对象，�?般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建�?个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参�?
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String midPmsItemId = null;
			String version = null;
			String sbbm = null;
			String orgName = null;
			String dvPmsAssetClassId = null;
			String zcDl = null;
			String zcZl = null;
			String zcXl = null;
			String voltageLevel = null;
			Date calYear = null;
			String qfzd = null;
			String jkzt = null;
			String yxzt = null;
			String ywdw = null;
			String zckbm = null;
			Double zcyz = null;
			Date zjtyrq = null;
			String zcxz = null;
			Double sl = null;
			Double sl1 = null;
			Double sl2 = null;
			Double sl3 = null;
			String jldw = null;
			String zzsmc = null;
			String ssxlbdz = null;
			String sbxh = null;
			Integer tynf = null;
			String nnd = null;
			Date tyrq = null;
			Integer nn = null;
			Date ccrq = null;
			String isMatched = null;
			String equipmentName = null;
			String assetId = null;
			String equipmentIncreaseMode = null;
			String lineProperty = null;
			String zcdl = null;
			String sblx = null;
			Date dvDateValue = null;
			Double slOld = null;
			String oldVoltageLevel2 = null;
			String oldZcxz = null;
			String discription = null;
			String oldYxzt = null;
			Date oldTyrq = null;
			Date oldCcrq = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			long maxMem = run.maxMemory() / 1024 / 1024;
			long freeMem = run.freeMemory() / 1024 / 1024;
			long totalMem = run.totalMemory();
			long usedMem = maxMem - freeMem;
			while (result.next()) {

				maxMem = run.maxMemory() / 1024 / 1024;
				freeMem = run.freeMemory() / 1024 / 1024;
				totalMem = run.totalMemory();
				usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(usedMem / maxMem) + ",maxMem="
						+ (maxMem) + ",freeMem=" + (freeMem) + ",usedMem=" + (usedMem) + ",totalMem=" + (totalMem));

				try {
					midPmsItemId = result.getString("MID_PMS_ITEM_ID");
				} catch (SQLException e) {
					try {
						midPmsItemId = result.getString("MID_PMS_UNMATCHED_ITEM_ID");
					} catch (SQLException e1) {
						midPmsItemId = result.getString("MID_PMS_MATCHED_ITEM_ID");
					}
				}
				version = result.getString("VERSION");
				sbbm = result.getString("SBBM");
				orgName = result.getString("ORG_NAME");
				dvPmsAssetClassId = result.getString("DV_PMS_ASSET_CLASS_ID");
				zcDl = result.getString("ZC_DL");
				zcZl = result.getString("ZC_ZL");
				zcXl = result.getString("ZC_XL");
				voltageLevel = result.getString("VOLTAGE_LEVEL");
				if (null != result.getString("CAL_YEAR")) {
					try {
						calYear = simpleDateFormat.parse(result.getString("CAL_YEAR"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				qfzd = result.getString("QFZD");
				jkzt = result.getString("JKZT");
				yxzt = result.getString("YXZT");
				ywdw = result.getString("YWDW");
				zckbm = result.getString("ZCKBM");
				if (null == result.getString("ZCYZ")) {
					zcyz = Double.parseDouble("0");
				} else {
					zcyz = Double.parseDouble(result.getString("ZCYZ"));
				}
				if (null != result.getString("ZJTYRQ")) {
					try {
						zjtyrq = simpleDateFormat.parse(result.getString("ZJTYRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				zcxz = result.getString("ZCXZ");
				if (null == result.getString("SL")) {
					sl = Double.parseDouble("0");
				} else {
					sl = Double.parseDouble(result.getString("SL"));
				}
				// System.out.println("result.getString('SL1')="+result.getString("SL1"));
				if (null == result.getString("SL1")) {
					sl1 = Double.parseDouble("0");
				} else {
					sl1 = Double.parseDouble(result.getString("SL1"));
				}
				if (null == result.getString("SL2")) {
					sl2 = Double.parseDouble("0");
				} else {
					sl2 = Double.parseDouble(result.getString("SL2"));
				}
				if (null == result.getString("SL3")) {
					sl3 = Double.parseDouble("0");
				} else {
					sl3 = Double.parseDouble(result.getString("SL3"));
				}
				// sl= result.getString("SL");
				// sl1= result.getString("SL1");
				// sl2= result.getString("SL2");
				// sl3= result.getString("SL3");
				jldw = result.getString("JLDW");
				zzsmc = result.getString("ZZSMC");
				ssxlbdz = result.getString("SSXLBDZ");
				sbxh = result.getString("SBXH");
				// System.out.println("result.getString('TYNF')="+result.getString("TYNF"));
				if (null == result.getString("TYNF")) {
					tynf = new Integer("0");
				} else {
					tynf = new Integer(result.getString("TYNF"));
				}
				// tynf= result.getString("TYNF");
				nnd = result.getString("NND");
				if (null != result.getString("TYRQ")) {
					try {
						tyrq = simpleDateFormat.parse(result.getString("TYRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// tyrq= result.getString("TYRQ");
				if (null == result.getString("NN")) {
					nn = new Integer("0");
				} else {
					nn = new Integer(result.getString("NN"));
				}
				// nn= result.getString("NN");
				if (null != result.getString("CCRQ")) {
					try {
						ccrq = simpleDateFormat.parse(result.getString("CCRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// ccrq= result.getString("CCRQ");
				isMatched = result.getString("IS_MATCHED");
				equipmentName = result.getString("EQUIPMENT_NAME");
				assetId = result.getString("ASSET_ID");
				equipmentIncreaseMode = result.getString("EQUIPMENT_INCREASE_MODE");
				lineProperty = result.getString("LINE_PROPERTY");
				zcdl = result.getString("ZCDL");
				sblx = result.getString("SBLX");
				if (null != result.getString("DV_DATE_VALUE")) {
					try {
						dvDateValue = DateUtils.parseDate(result.getString("DV_DATE_VALUE"), "dd-MM�?-yy",
								"dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd",
								"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null == result.getString("SL_OLD")) {
					slOld = new Double(0.0);
				} else {
					slOld = new Double(result.getString("SL_OLD"));
				}
				oldVoltageLevel2 = result.getString("OLD_VOLTAGE_LEVEL2");
				oldZcxz = result.getString("OLD_ZCXZ");
				discription = result.getString("DISCRIPTION");
				oldYxzt = result.getString("OLD_YXZT");
				if (null != result.getString("OLD_TYRQ")) {
					try {
						oldTyrq = DateUtils.parseDate(result.getString("OLD_TYRQ"), "dd-MM�?-yy", "dd-MM�?-yy HH:mm:ss",
								"dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s", "yyyy/MM/dd",
								"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
								"yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null != result.getString("OLD_CCRQ")) {
					try {
						oldCcrq = DateUtils.parseDate(result.getString("OLD_CCRQ"), "dd-MM�?-yy", "dd-MM�?-yy HH:mm:ss",
								"dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s", "yyyy/MM/dd",
								"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
								"yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				list.add(new MidPmsItem(midPmsItemId, version, sbbm, orgName, dvPmsAssetClassId, zcDl, zcZl, zcXl, voltageLevel, calYear, qfzd,
						jkzt, yxzt, ywdw, zckbm, zcyz, zjtyrq, zcxz, sl, sl1, sl2, sl3, jldw, zzsmc, ssxlbdz, sbxh, tynf, nnd,
						tyrq, nn, ccrq, isMatched, equipmentName, assetId, equipmentIncreaseMode, lineProperty, zcdl, sblx,
						dvDateValue, slOld, oldVoltageLevel2, oldZcxz, discription, oldYxzt, oldTyrq, oldCcrq));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 2020-07-20
	 * 
	 * @return
	 */
	public static List<MidErpItemOld20199> getAllMidErpItemOld20199(String tableName) {
		List<MidErpItemOld20199> list = new ArrayList<MidErpItemOld20199>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			// 创建预编译语句对象，�?般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建�?个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参�?
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String midErpItemId = null;
			String version = null;
			Date calYear = null;
			Long dwdm = null;
			String orgName = null;
			String zcDl = null;
			String zcZl = null;
			String zcXl = null;
			Short calyear = null;
			String compCode = null;
			String assetMainNumber = null;
			String assetSubnumber = null;
			String equipementNumber = null;
			String currency = null;
			String largeClass = null;
			String mediumClass = null;
			String smallClass = null;
			String voltageLevel = null;
			Double quantity = null;
			String unit = null;
			Double originalValue = null;
			Double netValue = null;
			String assetStatus = null;
			String profitEnterSecLevelUnit = null;
			String costControlArea = null;
			String assetDescription = null;
			String projectType = null;
			Date capitalizationDate = null;
			Date deliveryDate = null;
			Date manufactureDate = null;
			Double lineLength = null;
			String lengthUnit = null;
			Double transformerCapacity = null;
			String capacityUnit = null;
			String warehouseAddress = null;
			String sparePartMark = null;
			String reusingDeviceMark = null;
			Date reusingEntryDate = null;
			Date reusingOutDate = null;
			String discardProjectResourceCode = null;
			String discardReasonCode = null;
			Date discardAccountingDate = null;
			String equipmentStatus = null;
			String equipmentVoltageLevel = null;
			String isCustody = null;
			String manufacturerCard = null;
			String manufacturerEquipement = null;
			String manufactureState = null;
			String manufacturePartNumber = null;
			String inactivityDate = null;
			String assetCategory = null;
			String cardSerialNumber = null;
			String cardInventoryNumber = null;
			String cardAssetUnit = null;
			String cardStorageUnit = null;
			String cardCostCenter = null;
			String cardAssetManageDepart = null;
			String cardUsingCustodian = null;
			String cardCarLicense = null;
			String costCenterAuxilAccounting = null;
			String donationType = null;
			String superviseSign = null;
			String assetUsingInformation = null;
			String assetIncreaseMethod = null;
			String assetChangeMode = null;
			String assetOrigin = null;
			String engineeringProperty = null;
			String fixedAssetClass = null;
			String cardWbsElement = null;
			String cardWbsElementDesc = null;
			String assetStorageAddress = null;
			String lineStationName = null;
			String housePropCertifiNum = null;
			String equipementName = null;
			String technicalObjectType = null;
			String authorizationGroup = null;
			String equipSpecificationModel = null;
			String equipNameplateNumber = null;
			String maintenanceFactory = null;
			String equipAssetChangeMode = null;
			String factoryArea = null;
			String abcIdentification = null;
			String classifiedField = null;
			String equipmentCostCenter = null;
			String equipmentWbsElement = null;
			String equipWbsElementDesc = null;
			String planFactory = null;
			String planGroup = null;
			String mainWorkCenter = null;
			String functionalPosition = null;
			String advancedEquipment = null;
			String techIdentificationNumber = null;
			String equipUseCustodian = null;
			String equipStorageDepartment = null;
			String equipObjectManageDeparment = null;
			String equipmentIncreaseMethod = null;
			String equipmentSotrageAddress = null;
			String equipCarLicense = null;
			String equipHousePropCertifiNum = null;
			String lineStationLogo = null;
			String discardOriginProjectDesc = null;
			String discardReasonContent = null;
			Date dataExtractDate = null;
			Date dataExtractTime = null;
			String dataExtractPerson = null;
			String assetProperty = null;
			String propertyCode = null;
			String pmunr = null;
			String assetId = null;
			String assetVoltageLevel = null;
			String oldVoltageLevel = null;
			String oldAssetProperty = null;
			String oldPropertyCode = null;
			Long calYear1 = null;
			Date dvDateValue = null;
			String category = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			long maxMem = run.maxMemory() / 1024 / 1024;
			long freeMem = run.freeMemory() / 1024 / 1024;
			long totalMem = run.totalMemory();
			long usedMem = maxMem - freeMem;
			while (result.next()) {

				maxMem = run.maxMemory() / 1024 / 1024;
				freeMem = run.freeMemory() / 1024 / 1024;
				totalMem = run.totalMemory();
				usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(usedMem / maxMem) + ",maxMem="
						+ (maxMem) + ",freeMem=" + (freeMem) + ",usedMem=" + (usedMem) + ",totalMem=" + (totalMem));

				midErpItemId = result.getString("MID_ERP_ITEM_ID");
				version = result.getString("VERSION");
				if (null != result.getString("CAL_YEAR")) {
					try {
						calYear = DateUtils.parseDate(result.getString("CAL_YEAR"), "dd-MM�?-yy", "dd-MM�?-yy HH:mm:ss",
								"dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s", "yyyy/MM/dd",
								"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
								"yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null == result.getString("DWDM")) {
					dwdm = new Long(0);
				} else {
					dwdm = new Long(result.getString("DWDM"));
				}
				orgName = result.getString("ORG_NAME");
				zcDl = result.getString("ZC_DL");
				zcZl = result.getString("ZC_ZL");
				zcXl = result.getString("ZC_XL");
				if (null == result.getString("CALYEAR")) {
					calyear = new Short((short) 0);
				} else {
					calyear = new Short(result.getString("CALYEAR"));
				}
				compCode = result.getString("COMP_CODE");
				assetMainNumber = result.getString("ASSET_MAIN_NUMBER");
				assetSubnumber = result.getString("ASSET_SUBNUMBER");
				equipementNumber = result.getString("EQUIPEMENT_NUMBER");
				currency = result.getString("CURRENCY");
				largeClass = result.getString("LARGE_CLASS");
				mediumClass = result.getString("MEDIUM_CLASS");
				smallClass = result.getString("SMALL_CLASS");
				voltageLevel = result.getString("VOLTAGE_LEVEL");
				if (null == result.getString("QUANTITY")) {
					quantity = new Double(0.0);
				} else {
					quantity = new Double(result.getString("QUANTITY"));
				}
				unit = result.getString("UNIT");
				if (null == result.getString("ORIGINAL_VALUE")) {
					originalValue = new Double(0.0);
				} else {
					originalValue = new Double(result.getString("ORIGINAL_VALUE"));
				}
				if (null == result.getString("NET_VALUE")) {
					netValue = new Double(0.0);
				} else {
					netValue = new Double(result.getString("NET_VALUE"));
				}
				assetStatus = result.getString("ASSET_STATUS");
				profitEnterSecLevelUnit = result.getString("PROFIT_ENTER_SEC_LEVEL_UNIT");
				costControlArea = result.getString("COST_CONTROL_AREA");
				assetDescription = result.getString("ASSET_DESCRIPTION");
				projectType = result.getString("PROJECT_TYPE");
				if (null != result.getString("CAPITALIZATION_DATE")) {
					try {
						capitalizationDate = DateUtils.parseDate(result.getString("CAPITALIZATION_DATE"), "dd-MM�?-yy",
								"dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd",
								"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null != result.getString("DELIVERY_DATE")) {
					try {
						deliveryDate = DateUtils.parseDate(result.getString("DELIVERY_DATE"), "dd-MM�?-yy",
								"dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd",
								"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null != result.getString("MANUFACTURE_DATE")) {
					try {
						manufactureDate = DateUtils.parseDate(result.getString("MANUFACTURE_DATE"), "dd-MM�?-yy",
								"dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd",
								"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null == result.getString("LINE_LENGTH")) {
					lineLength = new Double(0.0);
				} else {
					lineLength = new Double(result.getString("LINE_LENGTH"));
				}
				lengthUnit = result.getString("LENGTH_UNIT");
				if (null == result.getString("TRANSFORMER_CAPACITY")) {
					transformerCapacity = new Double(0.0);
				} else {
					transformerCapacity = new Double(result.getString("TRANSFORMER_CAPACITY"));
				}
				capacityUnit = result.getString("CAPACITY_UNIT");
				warehouseAddress = result.getString("WAREHOUSE_ADDRESS");
				sparePartMark = result.getString("SPARE_PART_MARK");
				reusingDeviceMark = result.getString("REUSING_DEVICE_MARK");
				if (null != result.getString("REUSING_ENTRY_DATE")) {
					try {
						reusingEntryDate = DateUtils.parseDate(result.getString("REUSING_ENTRY_DATE"), "dd-MM�?-yy",
								"dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd",
								"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null != result.getString("REUSING_OUT_DATE")) {
					try {
						reusingOutDate = DateUtils.parseDate(result.getString("REUSING_OUT_DATE"), "dd-MM�?-yy",
								"dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd",
								"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				discardProjectResourceCode = result.getString("DISCARD_PROJECT_RESOURCE_CODE");
				discardReasonCode = result.getString("DISCARD_REASON_CODE");
				if (null != result.getString("DISCARD_ACCOUNTING_DATE")) {
					try {
						discardAccountingDate = DateUtils.parseDate(result.getString("DISCARD_ACCOUNTING_DATE"),
								"dd-MM�?-yy", "dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy",
								"dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s",
								"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				equipmentStatus = result.getString("EQUIPMENT_STATUS");
				equipmentVoltageLevel = result.getString("EQUIPMENT_VOLTAGE_LEVEL");
				isCustody = result.getString("IS_CUSTODY");
				manufacturerCard = result.getString("MANUFACTURER_CARD");
				manufacturerEquipement = result.getString("MANUFACTURER_EQUIPEMENT");
				manufactureState = result.getString("MANUFACTURE_STATE");
				manufacturePartNumber = result.getString("MANUFACTURE_PART_NUMBER");
				inactivityDate = result.getString("INACTIVITY_DATE");
				assetCategory = result.getString("ASSET_CATEGORY");
				cardSerialNumber = result.getString("CARD_SERIAL_NUMBER");
				cardInventoryNumber = result.getString("CARD_INVENTORY_NUMBER");
				cardAssetUnit = result.getString("CARD_ASSET_UNIT");
				cardStorageUnit = result.getString("CARD_STORAGE_UNIT");
				cardCostCenter = result.getString("CARD_COST_CENTER");
				cardAssetManageDepart = result.getString("CARD_ASSET_MANAGE_DEPART");
				cardUsingCustodian = result.getString("CARD_USING_CUSTODIAN");
				cardCarLicense = result.getString("CARD_CAR_LICENSE");
				costCenterAuxilAccounting = result.getString("COST_CENTER_AUXIL_ACCOUNTING");
				donationType = result.getString("DONATION_TYPE");
				superviseSign = result.getString("SUPERVISE_SIGN");
				assetUsingInformation = result.getString("ASSET_USING_INFORMATION");
				assetIncreaseMethod = result.getString("ASSET_INCREASE_METHOD");
				assetChangeMode = result.getString("ASSET_CHANGE_MODE");
				assetOrigin = result.getString("ASSET_ORIGIN");
				engineeringProperty = result.getString("ENGINEERING_PROPERTY");
				fixedAssetClass = result.getString("FIXED_ASSET_CLASS");
				cardWbsElement = result.getString("CARD_WBS_ELEMENT");
				cardWbsElementDesc = result.getString("CARD_WBS_ELEMENT_DESC");
				assetStorageAddress = result.getString("ASSET_STORAGE_ADDRESS");
				lineStationName = result.getString("LINE_STATION_NAME");
				housePropCertifiNum = result.getString("HOUSE_PROP_CERTIFI_NUM");
				equipementName = result.getString("EQUIPEMENT_NAME");
				technicalObjectType = result.getString("TECHNICAL_OBJECT_TYPE");
				authorizationGroup = result.getString("AUTHORIZATION_GROUP");
				equipSpecificationModel = result.getString("EQUIP_SPECIFICATION_MODEL");
				equipNameplateNumber = result.getString("EQUIP_NAMEPLATE_NUMBER");
				maintenanceFactory = result.getString("MAINTENANCE_FACTORY");
				equipAssetChangeMode = result.getString("EQUIP_ASSET_CHANGE_MODE");
				factoryArea = result.getString("FACTORY_AREA");
				abcIdentification = result.getString("ABC_IDENTIFICATION");
				classifiedField = result.getString("CLASSIFIED_FIELD");
				equipmentCostCenter = result.getString("EQUIPMENT_COST_CENTER");
				equipmentWbsElement = result.getString("EQUIPMENT_WBS_ELEMENT");
				equipWbsElementDesc = result.getString("EQUIP_WBS_ELEMENT_DESC");
				planFactory = result.getString("PLAN_FACTORY");
				planGroup = result.getString("PLAN_GROUP");
				mainWorkCenter = result.getString("MAIN_WORK_CENTER");
				functionalPosition = result.getString("FUNCTIONAL_POSITION");
				advancedEquipment = result.getString("ADVANCED_EQUIPMENT");
				techIdentificationNumber = result.getString("TECH_IDENTIFICATION_NUMBER");
				equipUseCustodian = result.getString("EQUIP_USE_CUSTODIAN");
				equipStorageDepartment = result.getString("EQUIP_STORAGE_DEPARTMENT");
				equipObjectManageDeparment = result.getString("EQUIP_OBJECT_MANAGE_DEPARMENT");
				equipmentIncreaseMethod = result.getString("EQUIPMENT_INCREASE_METHOD");
				equipmentSotrageAddress = result.getString("EQUIPMENT_SOTRAGE_ADDRESS");
				equipCarLicense = result.getString("EQUIP_CAR_LICENSE");
				equipHousePropCertifiNum = result.getString("EQUIP_HOUSE_PROP_CERTIFI_NUM");
				lineStationLogo = result.getString("LINE_STATION_LOGO");
				discardOriginProjectDesc = result.getString("DISCARD_ORIGIN_PROJECT_DESC");
				discardReasonContent = result.getString("DISCARD_REASON_CONTENT");
				if (null != result.getString("DATA_EXTRACT_DATE")) {
					try {
						dataExtractDate = DateUtils.parseDate(result.getString("DATA_EXTRACT_DATE"), "dd-MM�?-yy",
								"dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd",
								"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null != result.getString("DATA_EXTRACT_TIME")) {
					try {
						dataExtractTime = DateUtils.parseDate(result.getString("DATA_EXTRACT_TIME"), "dd-MM�?-yy",
								"dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd",
								"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				dataExtractPerson = result.getString("DATA_EXTRACT_PERSON");
				assetProperty = result.getString("ASSET_PROPERTY");
				propertyCode = result.getString("PROPERTY_CODE");
				pmunr = result.getString("PMUNR");
				assetId = result.getString("ASSET_ID");
				assetVoltageLevel = result.getString("ASSET_VOLTAGE_LEVEL");
				oldVoltageLevel = result.getString("OLD_VOLTAGE_LEVEL");
				oldAssetProperty = result.getString("OLD_ASSET_PROPERTY");
				oldPropertyCode = result.getString("OLD_PROPERTY_CODE");
				if (null == result.getString("CAL_YEAR1")) {
					calYear1 = new Long(0);
				} else {
					calYear1 = new Long(result.getString("CAL_YEAR1"));
				}
				if (null != result.getString("DV_DATE_VALUE")) {
					try {
						dvDateValue = DateUtils.parseDate(result.getString("DV_DATE_VALUE"), "dd-MM�?-yy",
								"dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd",
								"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				category = result.getString("CATEGORY");
				list.add(new MidErpItemOld20199(midErpItemId, version, calYear, dwdm, orgName, zcDl, zcZl, zcXl,
						calyear, compCode, assetMainNumber, assetSubnumber, equipementNumber, currency, largeClass,
						mediumClass, smallClass, voltageLevel, quantity, unit, originalValue, netValue, assetStatus,
						profitEnterSecLevelUnit, costControlArea, assetDescription, projectType, capitalizationDate,
						deliveryDate, manufactureDate, lineLength, lengthUnit, transformerCapacity, capacityUnit,
						warehouseAddress, sparePartMark, reusingDeviceMark, reusingEntryDate, reusingOutDate,
						discardProjectResourceCode, discardReasonCode, discardAccountingDate, equipmentStatus,
						equipmentVoltageLevel, isCustody, manufacturerCard, manufacturerEquipement, manufactureState,
						manufacturePartNumber, inactivityDate, assetCategory, cardSerialNumber, cardInventoryNumber,
						cardAssetUnit, cardStorageUnit, cardCostCenter, cardAssetManageDepart, cardUsingCustodian,
						cardCarLicense, costCenterAuxilAccounting, donationType, superviseSign, assetUsingInformation,
						assetIncreaseMethod, assetChangeMode, assetOrigin, engineeringProperty, fixedAssetClass,
						cardWbsElement, cardWbsElementDesc, assetStorageAddress, lineStationName, housePropCertifiNum,
						equipementName, technicalObjectType, authorizationGroup, equipSpecificationModel,
						equipNameplateNumber, maintenanceFactory, equipAssetChangeMode, factoryArea, abcIdentification,
						classifiedField, equipmentCostCenter, equipmentWbsElement, equipWbsElementDesc, planFactory,
						planGroup, mainWorkCenter, functionalPosition, advancedEquipment, techIdentificationNumber,
						equipUseCustodian, equipStorageDepartment, equipObjectManageDeparment, equipmentIncreaseMethod,
						equipmentSotrageAddress, equipCarLicense, equipHousePropCertifiNum, lineStationLogo,
						discardOriginProjectDesc, discardReasonContent, dataExtractDate, dataExtractTime,
						dataExtractPerson, assetProperty, propertyCode, pmunr, assetId, assetVoltageLevel,
						oldVoltageLevel, oldAssetProperty, oldPropertyCode, calYear1, dvDateValue, category));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @return
	 */
	public static List<MidPmsItemOldAge1992> getAllMidPmsItemOldAge1992(String tableName) {
		List<MidPmsItemOldAge1992> list = new ArrayList<MidPmsItemOldAge1992>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			// 创建预编译语句对象，�?般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建�?个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参�?
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String midPmsItemId = null;
			String version = null;
			String sbbm = null;
			String orgName = null;
			String orgCode = null;
			String largeClass = null;
			String mediumClass = null;
			String smallClass = null;
			String voltageLevel = null;
			Date calYear = null;
			Double assetCapacity = null;
			Double assetAmount = null;
			String yxzt = null;
			String qfzd = null;
			String jkzt = null;
			String ywdw = null;
			String zckbm = null;
			Double zcyz = null;
			Date zjtyrq = null;
			String zcxz = null;
			Double sl = null;
			Double sl1 = null;
			Double sl2 = null;
			Double sl3 = null;
			String jldw = null;
			String zzsmc = null;
			String ssxlbdz = null;
			String sbxh = null;
			Integer tynf = null;
			String nnd = null;
			Date tyrq = null;
			Integer nn = null;
			Date ccrq = null;
			String equipmentName = null;
			String assetId = null;
			String equipmentIncreaseMode = null;
			String lineProperty = null;
			String zcdl = null;
			String sblx = null;
			Date dvDateValue = null;
			Double slOld = null;
			String oldVoltageLevel2 = null;
			String oldZcxz = null;
			String discription = null;
			String oldYxzt = null;
			Date oldTyrq = null;
			Date oldCcrq = null;
			String usingStatusCode = null;
			Integer groupStatus = null;
			Date dvDataValue = null;
			String category = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			long maxMem = run.maxMemory() / 1024 / 1024;
			long freeMem = run.freeMemory() / 1024 / 1024;
			long totalMem = run.totalMemory();
			long usedMem = maxMem - freeMem;
			while (result.next()) {

				maxMem = run.maxMemory() / 1024 / 1024;
				freeMem = run.freeMemory() / 1024 / 1024;
				totalMem = run.totalMemory();
				usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(usedMem / maxMem) + ",maxMem="
						+ (maxMem) + ",freeMem=" + (freeMem) + ",usedMem=" + (usedMem) + ",totalMem=" + (totalMem));

				try {
					midPmsItemId = result.getString("MID_PMS_ITEM_ID");
				} catch (SQLException e) {
					try {
						midPmsItemId = result.getString("MID_PMS_UNMATCHED_ITEM_ID");
					} catch (SQLException e1) {
						midPmsItemId = result.getString("MID_PMS_MATCHED_ITEM_ID");
					}
				}
				// midPmsItemId= result.getString("MID_PMS_ITEM_ID");
				version = result.getString("VERSION");
				sbbm = result.getString("SBBM");
				orgName = result.getString("ORG_NAME");
				orgCode = result.getString("ORG_CODE");
				largeClass = result.getString("LARGE_CLASS");
				mediumClass = result.getString("MEDIUM_CLASS");
				smallClass = result.getString("SMALL_CLASS");
				voltageLevel = result.getString("VOLTAGE_LEVEL");
				if (null != result.getString("CAL_YEAR")) {
					try {
						calYear = DateUtils.parseDate(result.getString("CAL_YEAR"), "dd-MM�?-yy", "dd-MM�?-yy HH:mm:ss",
								"dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s", "yyyy/MM/dd",
								"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
								"yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null == result.getString("ASSET_CAPACITY")) {
					assetCapacity = new Double(0.0);
				} else {
					assetCapacity = new Double(result.getString("ASSET_CAPACITY"));
				}
				if (null == result.getString("ASSET_AMOUNT")) {
					assetAmount = new Double(0.0);
				} else {
					assetAmount = new Double(result.getString("ASSET_AMOUNT"));
				}
				yxzt = result.getString("YXZT");
				qfzd = result.getString("QFZD");
				jkzt = result.getString("JKZT");
				ywdw = result.getString("YWDW");
				zckbm = result.getString("ZCKBM");
				if (null == result.getString("ZCYZ")) {
					zcyz = new Double(0.0);
				} else {
					zcyz = new Double(result.getString("ZCYZ"));
				}
				if (null != result.getString("ZJTYRQ")) {
					try {
						zjtyrq = DateUtils.parseDate(result.getString("ZJTYRQ"), "dd-MM�?-yy", "dd-MM�?-yy HH:mm:ss",
								"dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s", "yyyy/MM/dd",
								"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
								"yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				zcxz = result.getString("ZCXZ");
				if (null == result.getString("SL")) {
					sl = new Double(0.0);
				} else {
					sl = new Double(result.getString("SL"));
				}
				if (null == result.getString("SL1")) {
					sl1 = new Double(0.0);
				} else {
					sl1 = new Double(result.getString("SL1"));
				}
				if (null == result.getString("SL2")) {
					sl2 = new Double(0.0);
				} else {
					sl2 = new Double(result.getString("SL2"));
				}
				if (null == result.getString("SL3")) {
					sl3 = new Double(0.0);
				} else {
					sl3 = new Double(result.getString("SL3"));
				}
				jldw = result.getString("JLDW");
				zzsmc = result.getString("ZZSMC");
				ssxlbdz = result.getString("SSXLBDZ");
				sbxh = result.getString("SBXH");
				if (null == result.getString("TYNF")) {
					tynf = new Integer(0);
				} else {
					tynf = new Integer(result.getString("TYNF"));
				}
				nnd = result.getString("NND");
				if (null != result.getString("TYRQ")) {
					try {
						tyrq = DateUtils.parseDate(result.getString("TYRQ"), "dd-MM�?-yy", "dd-MM�?-yy HH:mm:ss",
								"dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s", "yyyy/MM/dd",
								"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
								"yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null == result.getString("NN")) {
					nn = new Integer(0);
				} else {
					nn = new Integer(result.getString("NN"));
				}
				if (null != result.getString("CCRQ")) {
					try {
						ccrq = DateUtils.parseDate(result.getString("CCRQ"), "dd-MM�?-yy", "dd-MM�?-yy HH:mm:ss",
								"dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s", "yyyy/MM/dd",
								"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
								"yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				equipmentName = result.getString("EQUIPMENT_NAME");
				assetId = result.getString("ASSET_ID");
				equipmentIncreaseMode = result.getString("EQUIPMENT_INCREASE_MODE");
				lineProperty = result.getString("LINE_PROPERTY");
				zcdl = result.getString("ZCDL");
				sblx = result.getString("SBLX");
				if (null != result.getString("DV_DATE_VALUE")) {
					try {
						dvDateValue = DateUtils.parseDate(result.getString("DV_DATE_VALUE"), "dd-MM�?-yy",
								"dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd",
								"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null == result.getString("SL_OLD")) {
					slOld = new Double(0.0);
				} else {
					slOld = new Double(result.getString("SL_OLD"));
				}
				oldVoltageLevel2 = result.getString("OLD_VOLTAGE_LEVEL2");
				oldZcxz = result.getString("OLD_ZCXZ");
				discription = result.getString("DISCRIPTION");
				oldYxzt = result.getString("OLD_YXZT");
				if (null != result.getString("OLD_TYRQ")) {
					try {
						oldTyrq = DateUtils.parseDate(result.getString("OLD_TYRQ"), "dd-MM�?-yy", "dd-MM�?-yy HH:mm:ss",
								"dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s", "yyyy/MM/dd",
								"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
								"yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null != result.getString("OLD_CCRQ")) {
					try {
						oldCcrq = DateUtils.parseDate(result.getString("OLD_CCRQ"), "dd-MM�?-yy", "dd-MM�?-yy HH:mm:ss",
								"dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s", "yyyy/MM/dd",
								"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
								"yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				usingStatusCode = result.getString("USING_STATUS_CODE");
				if (null == result.getString("GROUP_STATUS")) {
					groupStatus = new Integer(0);
				} else {
					groupStatus = new Integer(result.getString("GROUP_STATUS"));
				}
				if (null != result.getString("DV_DATA_VALUE")) {
					try {
						dvDataValue = DateUtils.parseDate(result.getString("DV_DATA_VALUE"), "dd-MM�?-yy",
								"dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s",
								"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd",
								"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				category = result.getString("CATEGORY");
				list.add(new MidPmsItemOldAge1992(midPmsItemId, version, sbbm, orgName, orgCode, largeClass,
						mediumClass, smallClass, voltageLevel, calYear, assetCapacity, assetAmount, yxzt, qfzd, jkzt,
						ywdw, zckbm, zcyz, zjtyrq, zcxz, sl, sl1, sl2, sl3, jldw, zzsmc, ssxlbdz, sbxh, tynf, nnd, tyrq,
						nn, ccrq, equipmentName, assetId, equipmentIncreaseMode, lineProperty, zcdl, sblx, dvDateValue,
						slOld, oldVoltageLevel2, oldZcxz, discription, oldYxzt, oldTyrq, oldCcrq, usingStatusCode,
						groupStatus, dvDataValue, category));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 用于写入xls的表�?
	 * 
	 * @param conn                数据库连�?
	 * @param book                导出目标文件
	 * @param tableName           �?要导出的表的名称
	 * @param columnNameOrComment 取�?�为1时写入字段名，不�?1时写入字段的备注�?
	 * @return
	 */
	public static boolean writeHead(Connection conn, WritableWorkbook book, String tableName, int columnNameOrComment) {
		// Date now = new Date();
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		// String nowdate = df.format(now);
		// 打开文件
		// WritableWorkbook book = null;

		// try {
		// book = Workbook.createWorkbook(new File("D:/temp/" + tableName + "_"
		// + nowdate + "_" + 0 + ".xls"));
		// } catch (IOException e1) {
		// TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		System.out.println(book);
		// System.out.println("D:/temp/" + tableName + nowdate + ".xls");
		// 生成名为"第一�?"的工作表，参�?0表示这是第一
		WritableSheet sheet = book.createSheet("第一�?", 0);

		// 设置字体为宋�?,16号字,加粗,颜色为黑�?
		WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
		try {
			font1.setColour(Colour.BLACK);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WritableCellFormat format1 = new WritableCellFormat(font1);
		try {
			format1.setAlignment(jxl.format.Alignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Connection conn = null;
		// conn = Dbutil.getConnection();
		// 创建预编译语句对象，�?般都是用这个而不用Statement
		PreparedStatement pre = null;
		// 创建�?个结果集对象
		ResultSet result = null;

		String sql = "SELECT B.COLUMN_ID COLUMN_ID,B.COLUMN_NAME COLUMN_NAME,B.DATA_TYPE DATA_TYPE,"
				+ "B.DATA_LENGTH DATA_LENGTH,B.DATA_PRECISION DATA_PRECISION,B.DATA_SCALE DATA_SCALE,"
				+ "A.COMMENTS COLUMN_COMMENT  FROM USER_COL_COMMENTS A  INNER JOIN USER_TAB_COLUMNS B"
				+ " ON A.COLUMN_NAME=B.COLUMN_NAME WHERE B.TABLE_NAME= '" + tableName + "' ORDER BY B.COLUMN_ID";
		System.out.println("sqlStr=" + sql);
		try {
			pre = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 实例化预编译语句
		try {
			result = pre.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 执行查询，注意括号中不需要再加参�?

		Integer columnId = null;
		String columnName = null;
		String dataType = null;
		Integer dataLength = null;
		Integer dataPrecision = null;
		Integer dataScale = null;
		String columnComment = null;
		List<TableColumnProperty> list = new ArrayList<TableColumnProperty>();
		try {
			while (result.next()) {
				if (null != result.getString("COLUMN_ID")) {
					columnId = new Integer(result.getString("COLUMN_ID"));
				}
				columnName = result.getString("COLUMN_NAME");
				dataType = result.getString("DATA_TYPE");
				if (null != result.getString("DATA_LENGTH")) {
					dataLength = new Integer(result.getString("DATA_LENGTH"));
				}
				if (null != result.getString("DATA_PRECISION")) {
					dataPrecision = new Integer(result.getString("DATA_PRECISION"));
				}
				if (null != result.getString("DATA_SCALE")) {
					dataScale = new Integer(result.getString("DATA_SCALE"));
				}
				columnComment = result.getString("COLUMN_COMMENT");

				list.add(new TableColumnProperty(columnId, columnName, dataType, dataLength, dataPrecision, dataScale,
						columnComment));
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			Label label = null;
			if (columnNameOrComment == 1) {
				label = new Label(list.get(i).getColumnId() - 1, 0, list.get(i).getColumnName(), format1);
			} else {
				label = new Label(list.get(i).getColumnId() - 1, 0, list.get(i).getColumnComment(), format1);
			}
			try {
				sheet.addCell(label);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			book.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * try { book.close(); } catch (WriteException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		return true;
	}

	/**
	 * @return
	 */
	public static List<MidErpItem> getAllMidErpItem(String tableName) {
		List<MidErpItem> list = new ArrayList<MidErpItem>();
		Connection conn = null;
		// 创建预编译语句对象，�?般都是用这个而不用Statement
		PreparedStatement pre = null;
		try {
			conn = DbUtil.getConnection();
			// 创建�?个结果集对象
			ResultSet result = null;

			String sql = "select * from " + tableName;
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参�?
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String midErpItemId = null;
			String version = null;
			Date calYear = null;
			Short calyear = null;
			String orgName = null;
			String compCode = null;
			String assetMainNumber = null;
			String assetSubnumber = null;
			String equipementNumber = null;
			String currency = null;
			String largeClass = null;
			String mediumClass = null;
			String smallClass = null;
			String voltageLevel = null;
			Double quantity = null;
			String unit = null;
			Double originalValue = null;
			Double netValue = null;
			String assetStatus = null;
			String profitEnterSecLevelUnit = null;
			String costControlArea = null;
			String assetDescription = null;
			String projectType = null;
			Date capitalizationDate = null;
			Date deliveryDate = null;
			Date manufactureDate = null;
			Double lineLength = null;
			String lengthUnit = null;
			Double transformerCapacity = null;
			String capacityUnit = null;
			String warehouseAddress = null;
			String sparePartMark = null;
			String reusingDeviceMark = null;
			Date reusingEntryDate = null;
			Date reusingOutDate = null;
			String discardProjectResourceCode = null;
			String discardReasonCode = null;
			Date discardAccountingDate = null;
			String equipmentStatus = null;
			String equipmentVoltageLevel = null;
			String isCustody = null;
			String manufacturerCard = null;
			String manufacturerEquipement = null;
			String manufactureState = null;
			String manufacturePartNumber = null;
			String inactivityDate = null;
			String assetCategory = null;
			String cardSerialNumber = null;
			String cardInventoryNumber = null;
			String cardAssetUnit = null;
			String cardStorageUnit = null;
			String cardCostCenter = null;
			String cardAssetManageDepart = null;
			String cardUsingCustodian = null;
			String cardCarLicense = null;
			String costCenterAuxilAccounting = null;
			String donationType = null;
			String superviseSign = null;
			String assetUsingInformation = null;
			String assetIncreaseMethod = null;
			String assetChangeMode = null;
			String assetOrigin = null;
			String engineeringProperty = null;
			String fixedAssetClass = null;
			String cardWbsElement = null;
			String cardWbsElementDesc = null;
			String assetStorageAddress = null;
			String lineStationName = null;
			String housePropCertifiNum = null;
			String equipementName = null;
			String technicalObjectType = null;
			String authorizationGroup = null;
			String equipSpecificationModel = null;
			String equipNameplateNumber = null;
			String maintenanceFactory = null;
			String equipAssetChangeMode = null;
			String factoryArea = null;
			String abcIdentification = null;
			String classifiedField = null;
			String equipmentCostCenter = null;
			String equipmentWbsElement = null;
			String equipWbsElementDesc = null;
			String planFactory = null;
			String planGroup = null;
			String mainWorkCenter = null;
			String functionalPosition = null;
			String advancedEquipment = null;
			String techIdentificationNumber = null;
			String equipUseCustodian = null;
			String equipStorageDepartment = null;
			String equipObjectManageDeparment = null;
			String epqipmentIncreaseMethod = null;
			String equipmentSotrageAddress = null;
			String equipCarLicense = null;
			String equipHousePropCertifiNum = null;
			String lineStationLogo = null;
			String discardOriginProjectDesc = null;
			String discardReasonContent = null;
			Date dataExtractDate = null;
			Date dataExtractTime = null;
			String dataExtractPerson = null;
			String assetProperty = null;
			String propertyCode = null;

			String pmunr;
			String assetId;
			String assetVoltageLevel;
			/* 2020-07-21 添加如下字段变量 */
			String oldVoltageLevel = null;
			String oldAssetProperty = null;
			String oldPropertyCode = null;
			Date oldCapitalizationDate = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			Double maxMem = new Double(run.maxMemory() / 1024 / 1024);
			Double freeMem = new Double(run.freeMemory() / 1024 / 1024);
			Double totalMem = new Double(run.totalMemory() / 1024 / 1024); // totalMemory实际上才是当前使用了的内存量
			// Double usedMem = maxMem - freeMem; //公式是错误的

			while (result.next()) {

				maxMem = new Double(run.maxMemory() / 1024 / 1024);
				freeMem = new Double(run.freeMemory() / 1024 / 1024);
				totalMem = new Double(run.totalMemory() / 1024 / 1024);
				// usedMem = maxMem - freeMem;

				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(totalMem / maxMem) + ",maxMem="
						+ (maxMem) + ",freeMem=" + (freeMem) + ",usedMem=" + (totalMem) + ",totalMem=" + (totalMem));
				try {
					midErpItemId = result.getString("MID_ERP_ITEM_ID");
				} catch (SQLException e) {
					try {
						midErpItemId = result.getString("MID_ERP_UNMATCHED_ITEM_ID");
					} catch (SQLException e1) {
						midErpItemId = result.getString("MID_ERP_MATCHED_ITEM_ID");
					}
				}
				midErpItemId = result.getString("MID_ERP_ITEM_ID");
				version = result.getString("DATA_VERSION");
				// calYear= result.getString("CAL_YEAR");
				if (null != result.getString("CAL_YEAR")) {
					try {
						calYear = simpleDateFormat.parse(result.getString("CAL_YEAR"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// calyear= result.getString("CALYEAR");
				if (null == result.getString("CALYEAR")) {
					calyear = new Short((short) (0));
				} else {
					calyear = new Short(result.getString("CALYEAR"));
				}
				orgName = result.getString("ORG_NAME");
				compCode = result.getString("COMP_CODE");
				assetMainNumber = result.getString("ASSET_MAIN_NUMBER");
				assetSubnumber = result.getString("ASSET_SUBNUMBER");
				equipementNumber = result.getString("EQUIPEMENT_NUMBER");
				currency = result.getString("CURRENCY");
				largeClass = result.getString("LARGE_CLASS");
				mediumClass = result.getString("MEDIUM_CLASS");
				smallClass = result.getString("SMALL_CLASS");
				voltageLevel = result.getString("VOLTAGE_LEVEL");
				// quantity= result.getString("QUANTITY");
				if (null == result.getString("QUANTITY")) {
					quantity = Double.parseDouble("0");
				} else {
					quantity = Double.parseDouble(result.getString("QUANTITY"));
				}
				unit = result.getString("UNIT");
				// originalValue= result.getString("ORIGINAL_VALUE");
				if (null == result.getString("ORIGINAL_VALUE")) {
					originalValue = Double.parseDouble("0");
				} else {
					originalValue = Double.parseDouble(result.getString("ORIGINAL_VALUE"));
				}
				// netValue= result.getString("NET_VALUE");
				if (null == result.getString("NET_VALUE")) {
					netValue = Double.parseDouble("0");
				} else {
					netValue = Double.parseDouble(result.getString("NET_VALUE"));
				}
				assetStatus = result.getString("ASSET_STATUS");
				profitEnterSecLevelUnit = result.getString("PROFIT_ENTER_SEC_LEVEL_UNIT");
				costControlArea = result.getString("COST_CONTROL_AREA");
				assetDescription = result.getString("ASSET_DESCRIPTION");
				projectType = result.getString("PROJECT_TYPE");
				// capitalizationDate= result.getString("CAPITALIZATION_DATE");
				if (null != result.getString("CAPITALIZATION_DATE")) {
					try {
						capitalizationDate = simpleDateFormat.parse(result.getString("CAPITALIZATION_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// deliveryDate= result.getString("DELIVERY_DATE");
				if (null != result.getString("DELIVERY_DATE")) {
					try {
						deliveryDate = simpleDateFormat.parse(result.getString("DELIVERY_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// manufactureDate= result.getString("MANUFACTURE_DATE");
				if (null != result.getString("MANUFACTURE_DATE")) {
					try {
						manufactureDate = simpleDateFormat.parse(result.getString("MANUFACTURE_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// lineLength= result.getString("LINE_LENGTH");
				if (null == result.getString("LINE_LENGTH")) {
					lineLength = Double.parseDouble("0");
				} else {
					lineLength = Double.parseDouble(result.getString("LINE_LENGTH"));
				}
				lengthUnit = result.getString("LENGTH_UNIT");
				// transformerCapacity=
				// result.getString("TRANSFORMER_CAPACITY");
				if (null == result.getString("TRANSFORMER_CAPACITY")) {
					transformerCapacity = Double.parseDouble("0");
				} else {
					transformerCapacity = Double.parseDouble(result.getString("TRANSFORMER_CAPACITY"));
				}
				capacityUnit = result.getString("CAPACITY_UNIT");
				warehouseAddress = result.getString("WAREHOUSE_ADDRESS");
				sparePartMark = result.getString("SPARE_PART_MARK");
				reusingDeviceMark = result.getString("REUSING_DEVICE_MARK");
				// reusingEntryDate= result.getString("REUSING_ENTRY_DATE");
				if (null != result.getString("REUSING_ENTRY_DATE")) {
					try {
						reusingEntryDate = simpleDateFormat.parse(result.getString("REUSING_ENTRY_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// reusingOutDate= result.getString("REUSING_OUT_DATE");
				if (null != result.getString("REUSING_OUT_DATE")) {
					try {
						reusingOutDate = simpleDateFormat.parse(result.getString("REUSING_OUT_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				discardProjectResourceCode = result.getString("DISCARD_PROJECT_RESOURCE_CODE");
				discardReasonCode = result.getString("DISCARD_REASON_CODE");
				// discardAccountingDate=
				// result.getString("DISCARD_ACCOUNTING_DATE");

				if (null != result.getString("DISCARD_ACCOUNTING_DATE")) {
					try {
						discardAccountingDate = simpleDateFormat.parse(result.getString("DISCARD_ACCOUNTING_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				equipmentStatus = result.getString("EQUIPMENT_STATUS");
				equipmentVoltageLevel = result.getString("EQUIPMENT_VOLTAGE_LEVEL");
				isCustody = result.getString("IS_CUSTODY");
				manufacturerCard = result.getString("MANUFACTURER_CARD");
				manufacturerEquipement = result.getString("MANUFACTURER_EQUIPEMENT");
				manufactureState = result.getString("MANUFACTURE_STATE");
				manufacturePartNumber = result.getString("MANUFACTURE_PART_NUMBER");
				inactivityDate = result.getString("INACTIVITY_DATE");
				assetCategory = result.getString("ASSET_CATEGORY");
				cardSerialNumber = result.getString("CARD_SERIAL_NUMBER");
				cardInventoryNumber = result.getString("CARD_INVENTORY_NUMBER");
				cardAssetUnit = result.getString("CARD_ASSET_UNIT");
				cardStorageUnit = result.getString("CARD_STORAGE_UNIT");
				cardCostCenter = result.getString("CARD_COST_CENTER");
				cardAssetManageDepart = result.getString("CARD_ASSET_MANAGE_DEPART");
				cardUsingCustodian = result.getString("CARD_USING_CUSTODIAN");
				cardCarLicense = result.getString("CARD_CAR_LICENSE");
				costCenterAuxilAccounting = result.getString("COST_CENTER_AUXIL_ACCOUNTING");
				donationType = result.getString("DONATION_TYPE");
				superviseSign = result.getString("SUPERVISE_SIGN");
				assetUsingInformation = result.getString("ASSET_USING_INFORMATION");
				assetIncreaseMethod = result.getString("ASSET_INCREASE_METHOD");
				assetChangeMode = result.getString("ASSET_CHANGE_MODE");
				assetOrigin = result.getString("ASSET_ORIGIN");
				engineeringProperty = result.getString("ENGINEERING_PROPERTY");
				fixedAssetClass = result.getString("FIXED_ASSET_CLASS");
				cardWbsElement = result.getString("CARD_WBS_ELEMENT");
				cardWbsElementDesc = result.getString("CARD_WBS_ELEMENT_DESC");
				assetStorageAddress = result.getString("ASSET_STORAGE_ADDRESS");
				lineStationName = result.getString("LINE_STATION_NAME");
				housePropCertifiNum = result.getString("HOUSE_PROP_CERTIFI_NUM");
				equipementName = result.getString("EQUIPEMENT_NAME");
				technicalObjectType = result.getString("TECHNICAL_OBJECT_TYPE");
				authorizationGroup = result.getString("AUTHORIZATION_GROUP");
				equipSpecificationModel = result.getString("EQUIP_SPECIFICATION_MODEL");
				equipNameplateNumber = result.getString("EQUIP_NAMEPLATE_NUMBER");
				maintenanceFactory = result.getString("MAINTENANCE_FACTORY");
				equipAssetChangeMode = result.getString("EQUIP_ASSET_CHANGE_MODE");
				factoryArea = result.getString("FACTORY_AREA");
				abcIdentification = result.getString("ABC_IDENTIFICATION");
				classifiedField = result.getString("CLASSIFIED_FIELD");
				equipmentCostCenter = result.getString("EQUIPMENT_COST_CENTER");
				equipmentWbsElement = result.getString("EQUIPMENT_WBS_ELEMENT");
				equipWbsElementDesc = result.getString("EQUIP_WBS_ELEMENT_DESC");
				planFactory = result.getString("PLAN_FACTORY");
				planGroup = result.getString("PLAN_GROUP");
				mainWorkCenter = result.getString("MAIN_WORK_CENTER");
				functionalPosition = result.getString("FUNCTIONAL_POSITION");
				advancedEquipment = result.getString("ADVANCED_EQUIPMENT");
				techIdentificationNumber = result.getString("TECH_IDENTIFICATION_NUMBER");
				equipUseCustodian = result.getString("EQUIP_USE_CUSTODIAN");
				equipStorageDepartment = result.getString("EQUIP_STORAGE_DEPARTMENT");
				equipObjectManageDeparment = result.getString("EQUIP_OBJECT_MANAGE_DEPARMENT");
				epqipmentIncreaseMethod = result.getString("EQUIPMENT_INCREASE_METHOD");
				equipmentSotrageAddress = result.getString("EQUIPMENT_SOTRAGE_ADDRESS");
				equipCarLicense = result.getString("EQUIP_CAR_LICENSE");
				equipHousePropCertifiNum = result.getString("EQUIP_HOUSE_PROP_CERTIFI_NUM");
				lineStationLogo = result.getString("LINE_STATION_LOGO");
				discardOriginProjectDesc = result.getString("DISCARD_ORIGIN_PROJECT_DESC");
				discardReasonContent = result.getString("DISCARD_REASON_CONTENT");
				if (null != result.getString("DATA_EXTRACT_DATE")) {
					try {
						dataExtractDate = simpleDateFormat.parse(result.getString("DATA_EXTRACT_DATE"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (null != result.getString("DATA_EXTRACT_TIME")) {
					try {
						dataExtractTime = simpleDateFormat.parse(result.getString("DATA_EXTRACT_TIME"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				dataExtractPerson = result.getString("DATA_EXTRACT_PERSON");
				pmunr = result.getString("PMUNR");
				assetId = result.getString("ASSET_ID");
				assetVoltageLevel = result.getString("ASSET_VOLTAGE_LEVEL");
				assetProperty = result.getString("ASSET_PROPERTY");
				propertyCode = result.getString("PROPERTY_CODE");
				oldVoltageLevel = result.getString("OLD_VOLTAGE_LEVEL");
				oldAssetProperty = result.getString("OLD_ASSET_PROPERTY");
				oldPropertyCode = result.getString("OLD_PROPERTY_CODE");
				if (null != result.getString("OLD_CAPITALIZATION_DATE")) {
					try {
						oldCapitalizationDate = DateUtils.parseDate(result.getString("OLD_CAPITALIZATION_DATE"),
								"dd-MM�?-yy", "dd-MM�?-yy HH:mm:ss", "dd-MM�?-yy HH:mm:ss.s", "dd-MM�? -yy",
								"dd-MM�? -yy HH:mm:ss", "dd-MM�? -yy HH:mm:ss.s", "dd-MM�? -yy", "dd-MM�? -yy HH:mm:ss",
								"dd-MM�? -yy HH:mm:ss.s", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s",
								"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				list.add(new MidErpItem(midErpItemId, version, calYear, calyear, orgName, compCode, assetMainNumber,
						assetSubnumber, equipementNumber, currency, largeClass, mediumClass, smallClass, voltageLevel,
						quantity, unit, originalValue, netValue, assetStatus, profitEnterSecLevelUnit, costControlArea,
						assetDescription, projectType, capitalizationDate, deliveryDate, manufactureDate, lineLength,
						lengthUnit, transformerCapacity, capacityUnit, warehouseAddress, sparePartMark,
						reusingDeviceMark, reusingEntryDate, reusingOutDate, discardProjectResourceCode,
						discardReasonCode, discardAccountingDate, equipmentStatus, equipmentVoltageLevel, isCustody,
						manufacturerCard, manufacturerEquipement, manufactureState, manufacturePartNumber,
						inactivityDate, assetCategory, cardSerialNumber, cardInventoryNumber, cardAssetUnit,
						cardStorageUnit, cardCostCenter, cardAssetManageDepart, cardUsingCustodian, cardCarLicense,
						costCenterAuxilAccounting, donationType, superviseSign, assetUsingInformation,
						assetIncreaseMethod, assetChangeMode, assetOrigin, engineeringProperty, fixedAssetClass,
						cardWbsElement, cardWbsElementDesc, assetStorageAddress, lineStationName, housePropCertifiNum,
						equipementName, technicalObjectType, authorizationGroup, equipSpecificationModel,
						equipNameplateNumber, maintenanceFactory, equipAssetChangeMode, factoryArea, abcIdentification,
						classifiedField, equipmentCostCenter, equipmentWbsElement, equipWbsElementDesc, planFactory,
						planGroup, mainWorkCenter, functionalPosition, advancedEquipment, techIdentificationNumber,
						equipUseCustodian, equipStorageDepartment, equipObjectManageDeparment, epqipmentIncreaseMethod,
						equipmentSotrageAddress, equipCarLicense, equipHousePropCertifiNum, lineStationLogo,
						discardOriginProjectDesc, discardReasonContent, dataExtractDate, dataExtractTime,
						dataExtractPerson, assetProperty, propertyCode, pmunr, assetId, assetVoltageLevel,
						oldVoltageLevel, oldAssetProperty, oldPropertyCode, oldCapitalizationDate));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @return
	 */
	public static List<PmsQuexian> getAllByDb() {
		List<PmsQuexian> list = new ArrayList<PmsQuexian>();
		try {
			Connection conn = null;
			conn = DbUtil.getConnection();
			// 创建预编译语句对象，�?般都是用这个而不用Statement
			PreparedStatement pre = null;
			// 创建�?个结果集对象
			ResultSet result = null;

			String sql = "select * from PMS_QUEXIAN";
			pre = conn.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参�?
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String pmsQuexianId = null;
			Short calYear = null;
			String version = null;
			String sbbm = null;
			String dwmx = null;
			String qxbh = null;
			String zclxbm = null;
			String sblx = null;
			Short tynf = null;
			String dydj = null;
			String zzsmc = null;
			String sbxlmc = null;
			String qxms = null;
			String qxbw = null;
			String qxzryy = null;
			String sfxq = null;
			String sfjs = null;
			String zryybm = null;
			String qxjsyy = null;
			String jsyybm = null;
			String qxdj = null;
			Date fsrq = null;
			Date xqrq = null;
			String bz = null;
			Double xqsj = null;
			String jsyy = null;
			String zryy = null;
			String cwbm = null;
			String qfzd = null;
			Date ccrq = null;
			String zcxlms = null;
			String qxnr = null;
			String zclxbm2 = null;
			String equipementName = null;
			String lineStationName = null;
			String originalFile = null;

			System.out.println("Ready in loop!");
			int i = 1;
			Runtime run = Runtime.getRuntime();
			long maxMem = run.maxMemory() / 1024 / 1024;
			long freeMem = run.freeMemory() / 1024 / 1024;
			long totalMem = run.totalMemory();
			long usedMem = maxMem - freeMem;
			while (result.next()) {

				maxMem = run.maxMemory() / 1024 / 1024;
				freeMem = run.freeMemory() / 1024 / 1024;
				totalMem = run.totalMemory();
				usedMem = maxMem - freeMem;
				// System.out.println("Add!");
				System.out.println("i=" + (i++) + ",usedMemPercent=" + new Double(usedMem / maxMem) + ",maxMem="
						+ (maxMem) + ",freeMem=" + (freeMem) + ",usedMem=" + (usedMem) + ",totalMem=" + (totalMem));

				pmsQuexianId = result.getString("PMS_QUEXIAN_ID");
				if (null == result.getString("CAL_YEAR")) {
					calYear = new Short((short) (0));
				} else {
					calYear = new Short(result.getString("CAL_YEAR"));
				}
				version = result.getString("VERSION");
				// System.out.println("SBBM!");
				sbbm = result.getString("SBBM");
				dwmx = result.getString("DWMX");
				qxbh = result.getString("QXBH");
				// System.out.println("qxbh="+qxbh);
				zclxbm = result.getString("ZCLXBM");
				sblx = result.getString("SBLX");
				// System.out.println("TYNF!"+result.getString("TYNF")+",judge="+(null==result.getString("TYNF")));
				if (null == result.getString("TYNF")) {
					tynf = new Short((short) (0));
				} else {
					tynf = new Short(result.getString("TYNF"));
				}
				dydj = result.getString("DYDJ");
				// System.out.println("DYDJ!");
				zzsmc = result.getString("ZZSMC");
				sbxlmc = result.getString("SBXLMC");
				qxms = result.getString("QXMS");
				qxbw = result.getString("QXBW");
				qxzryy = result.getString("QXZRYY");
				sfxq = result.getString("SFXQ");
				sfjs = result.getString("SFJS");
				// System.out.println("ZRYYBM!");
				zryybm = result.getString("ZRYYBM");
				qxjsyy = result.getString("QXJSYY");
				jsyybm = result.getString("JSYYBM");
				qxdj = result.getString("QXDJ");

				// System.out.println("FSRQ!");
				if (null != result.getString("FSRQ")) {
					try {
						fsrq = simpleDateFormat.parse(result.getString("FSRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				// System.out.println("XQRQ!");
				if (null != result.getString("XQRQ")) {
					try {
						xqrq = simpleDateFormat.parse(result.getString("XQRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}

				bz = result.getString("BZ");
				// System.out.println("XQSJ!");
				if (null == result.getString("XQSJ")) {
					xqsj = Double.parseDouble("0.0");
				} else {
					xqsj = new Double(result.getString("XQSJ"));
				}
				jsyy = result.getString("JSYY");
				zryy = result.getString("ZRYY");
				cwbm = result.getString("CWBM");
				qfzd = result.getString("QFZD");

				// System.out.println("CCRQ!");
				if (null != result.getString("CCRQ")) {
					try {
						ccrq = simpleDateFormat.parse(result.getString("CCRQ"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}

				zcxlms = result.getString("ZCXLMS");
				qxnr = result.getString("QXNR");
				zclxbm2 = result.getString("ZCLXBM2");

				equipementName = result.getString("EQUIPEMENT_NAME");
				lineStationName = result.getString("LINE_STATION_NAME");
				// originalFile = result.getString("ORIGINAL_FILE");
				list.add(new PmsQuexian(pmsQuexianId, calYear, version, sbbm, dwmx, qxbh, zclxbm, sblx, tynf, dydj,
						zzsmc, sbxlmc, qxms, qxbw, qxzryy, sfxq, sfjs, zryybm, qxjsyy, jsyybm, qxdj, fsrq, xqrq, bz,
						xqsj, jsyy, zryy, cwbm, qfzd, ccrq, zcxlms, qxnr, zclxbm2, equipementName, lineStationName,
						originalFile));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
