package com.yunhai.excel.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yunhai.excel.orm.OriOpticalCableSection;
import com.yunhai.excel.orm.PmsSpareEquipment;
import com.yunhai.excel.orm.ZfiSwzcDisc;
import com.yunhai.util.DateFormatUtil;

public class CsvImportDao {
	public void csvZfiSwzcDiscAdd(String pathStr, String versionValue, String calYear)
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

		DecimalFormat decimalFormat = new DecimalFormat();
		int i = 0;
		/**
		 * 下一行代码与数据导入不可同时进行，要不然在此名中查出了CSV文件中的数据量的同时，iterator就已经跳到最后了，iterator.hasNext()将返回false
		 */
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			ZfiSwzcDisc zfiSwzcDisc = new ZfiSwzcDisc();

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");

			try {
				zfiSwzcDisc.setCalYear(simpleDateFormat.parse(calYear));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			zfiSwzcDisc.setVersion(versionValue);

			zfiSwzcDisc.setCalyear(Long.parseLong(calYear.substring(0, 4)));
			zfiSwzcDisc.setCompCode(csvRecord.get("COMP_CODE"));
			zfiSwzcDisc.setAssetMain(csvRecord.get("ASSET_MAIN"));
			zfiSwzcDisc.setAsset(csvRecord.get("ASSET"));
			zfiSwzcDisc.setEqunr(csvRecord.get("EQUNR"));
			zfiSwzcDisc.setCurrency(csvRecord.get("CURRENCY"));
			if (csvRecord.get("ZPMZCYZ").trim().isEmpty()) {
				zfiSwzcDisc.setZpmzcyz(new Double(0.0));
			} else {
				zfiSwzcDisc.setZpmzcyz(decimalFormat.parse(csvRecord.get("ZPMZCYZ")).doubleValue());
			}
			if (csvRecord.get("ZPMZCJZ").trim().isEmpty()) {
				zfiSwzcDisc.setZpmzcjz(new Double(0.0));
			} else {
				zfiSwzcDisc.setZpmzcjz(decimalFormat.parse(csvRecord.get("ZPMZCJZ")).doubleValue());
			}
			zfiSwzcDisc.setZtypbz1(csvRecord.get("ZTYPBZ1"));
			zfiSwzcDisc.setZtypbz2(csvRecord.get("ZTYPBZ2"));
			zfiSwzcDisc.setZtypbz3(csvRecord.get("ZTYPBZ3"));
			zfiSwzcDisc.setZvolLev(csvRecord.get("ZVOL_LEV"));
			if (csvRecord.get("ZQUANTITY").trim().isEmpty()) {
				zfiSwzcDisc.setZquantity(new Double(0.0));
			} else {
				zfiSwzcDisc.setZquantity(decimalFormat.parse(csvRecord.get("ZQUANTITY")).doubleValue());

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
			/*zfiSwzcDisc.setCdate(csvRecord.get("CDATE"));
			zfiSwzcDisc.setCtime(csvRecord.get("CTIME"));
			zfiSwzcDisc.setCname(csvRecord.get("CNAME"));
			*/
			zfiSwzcDisc.setAssetProperty(csvRecord.get("ASSET_PROPERTY"));
			zfiSwzcDisc.setPropertyCode(csvRecord.get("PROPERTY_CODE"));
			zfiSwzcDisc.setDataSourceFile(pathStr);
			zfiSwzcDisc.setDataVersion(versionValue);
			zfiSwzcDisc.setAssetId(csvRecord.get("ASSET_ID"));
			zfiSwzcDisc.setFixedAssetClass(csvRecord.get("FIXED_ASSET_CLASS"));
			zfiSwzcDisc.setOrgGroupCode(csvRecord.get("ORG_GROUP_CODE"));
			zfiSwzcDisc.setZtypbz1T(csvRecord.get("ZTYPBZ1_T"));
			zfiSwzcDisc.setZtypbz2T(csvRecord.get("ZTYPBZ2_T"));
			zfiSwzcDisc.setZtypbz3T(csvRecord.get("ZTYPBZ3_T"));
			zfiSwzcDisc.setAssetDescription(csvRecord.get("ASSET_DESCRIPTION"));
			zfiSwzcDisc.setFixAssetClassDescript(csvRecord.get("FIX_ASSET_CLASS_DESCRIPT"));
			zfiSwzcDisc.setUnkownCode(csvRecord.get("UNKOWN_CODE"));
			zfiSwzcDisc.setAssetPropertyCvsName(csvRecord.get("ASSET_PROPERTY_CVS_NAME"));
			zfiSwzcDisc.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));
			zfiSwzcDisc.setRealAssetIdEquip(csvRecord.get("REAL_ASSET_ID_EQUIP"));
			zfiSwzcDisc.setDiscardCapacityScale(csvRecord.get("DISCARD_CAPACITY_SCALE"));
			if (csvRecord.get("DISCARD_PAPER_NUMBER").trim().isEmpty()) {
				zfiSwzcDisc.setDiscardPaperNumber(new Double(0.0));
			} else {
				zfiSwzcDisc.setDiscardPaperNumber(
						decimalFormat.parse(csvRecord.get("DISCARD_PAPER_NUMBER")).doubleValue());

			}
			zfiSwzcDisc.setMetreUnit(csvRecord.get("METRE_UNIT"));
			zfiSwzcDisc.setDiscardSourceProject(csvRecord.get("DISCARD_SOURCE_PROJECT"));
			// zfiSwzcDisc.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));
			// zfiSwzcDisc.setDiscardReason(csvRecord.get("DISCARD_REASON"));
			//zfiSwzcDisc.setDiscardSourceProjectId(csvRecord.get("DISCARD_SOURCE_PROJECT_ID"));
			//zfiSwzcDisc.setDiscardSourceProjectDescr(csvRecord.get("DISCARD_SOURCE_PROJECT_DESCR"));
			//zfiSwzcDisc.setDiscardSourceProjectType(csvRecord.get("DISCARD_SOURCE_PROJECT_TYPE"));
			//zfiSwzcDisc.setWbs(csvRecord.get("WBS"));
			zfiSwzcDisc.setCostCenterDescription(csvRecord.get("COST_CENTER_DESCRIPTION"));
			//zfiSwzcDisc.setGroupCode(csvRecord.get("GROUP_CODE"));
			//System.out.println("I="+i+"OPERATION_MAINTENANCE_TEAM not exists="+csvRecord.get("OPERATION_MAINTENANCE_TEAM"));
			zfiSwzcDisc.setOperationMaintenanceTeam(csvRecord.get("OPERATION_MAINTENANCE_TEAM"));
			//zfiSwzcDisc.setOperationMaintenanceTeam("");
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

	public static void csvOriOpticalCableSectionAdd(String pathStr, String versionValue, String calYear)
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
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM月 -yy");
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("dd-MM月-yy");

		// DateUtils.parseDate("", "dd-MM月-yy","dd-MM月 -yy","yyyy/MM/dd","yyyy-MM-dd")

		// SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM月-yy");
		while (iterator.hasNext()) {
			CSVRecord csvRecord = iterator.next();
			OriOpticalCableSection oriOpticalCableSection = new OriOpticalCableSection();
			oriOpticalCableSection.setDataVersion(versionValue);
			oriOpticalCableSection.setObjId(csvRecord.get("OBJ_ID"));
			try {
				oriOpticalCableSection.setCalYear(simpleDateFormat.parse(calYear));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			oriOpticalCableSection.setOpticalCableSectionName(csvRecord.get("OPTICAL_CABLE_SECTION_NAME"));
			try {
				oriOpticalCableSection.setSubordinateOpticalCable(csvRecord.get("SUBORDINATE_OPTICAL_CABLE"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			// oriOpticalCableSection.setOpticalCableStatus(csvRecord.get("OPTICAL_CABLE_STATUS")==null?"":csvRecord.get("OPTICAL_CABLE_STATUS"));

			oriOpticalCableSection.setOpticalCableStatus(csvRecord.get("OPTICAL_CABLE_STATUS"));
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

			try {
				oriOpticalCableSection.setCommissioningDate(DateUtils.parseDate(csvRecord.get("COMMISSIONING_DATE"),
						"dd-MM月-yy", "dd-MM月-yy HH:mm:ss", "dd-MM月-yy HH:mm:ss.s", "dd-MM月 -yy", "dd-MM月 -yy HH:mm:ss",
						"dd-MM月 -yy HH:mm:ss.s", "dd-MM月 -yy", "dd-MM月 -yy HH:mm:ss", "dd-MM月 -yy HH:mm:ss.s",
						"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd",
						"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.s"));
				System.out.println("OBJ_ID=" + csvRecord.get("OBJ_ID") + " "
						+ DateUtils.parseDate(csvRecord.get("COMMISSIONING_DATE"), "dd-MM月-yy", "dd-MM月-yy HH:mm:ss",
								"dd-MM月-yy HH:mm:ss.s", "dd-MM月 -yy", "dd-MM月 -yy HH:mm:ss", "dd-MM月 -yy HH:mm:ss.s",
								"dd-MM月 -yy", "dd-MM月 -yy HH:mm:ss", "dd-MM月 -yy HH:mm:ss.s", "yyyy/MM/dd",
								"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.s", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
								"yyyy-MM-dd HH:mm:ss.s")
						+ "    " + csvRecord.get("COMMISSIONING_DATE") + " " + (++i));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			oriOpticalCableSection.setBelongAreas(csvRecord.get("BELONG_AREAS"));
			oriOpticalCableSection.setOpticalCableType(csvRecord.get("OPTICAL_CABLE_TYPE"));
			oriOpticalCableSection.setVoltageLevel(csvRecord.get("VOLTAGE_LEVEL"));

			oriOpticalCableSection.setPmsVoltageLevel(csvRecord.get("PMS_VOLTAGE_LEVEL"));

			oriOpticalCableSection.setPrimaryLineName(csvRecord.get("PRIMARY_LINE_NAME"));
			oriOpticalCableSection.setPmsPrimaryLineName(csvRecord.get("PMS_PRIMARY_LINE_NAME"));

			oriOpticalCableSection.setLayingType(csvRecord.get("LAYING_TYPE"));
			oriOpticalCableSection.setLayingMethod(csvRecord.get("LAYING_METHOD"));

			oriOpticalCableSection.setThreeSpanSituation(csvRecord.get("THREE_SPAN_SITUATION"));

			oriOpticalCableSection.setOpticalCableStartPointType(csvRecord.get("OPTICAL_CABLE_START_POINT_TYPE"));
			oriOpticalCableSection.setOptCabSectStartPointType(csvRecord.get("OPT_CAB_SECT_START_POINT_TYPE"));
			oriOpticalCableSection.setOptCabSectStartPointResou(csvRecord.get("OPT_CAB_SECT_START_POINT_RESOU"));
			oriOpticalCableSection.setOpticalCableEndpointType(csvRecord.get("OPTICAL_CABLE_ENDPOINT_TYPE"));
			oriOpticalCableSection.setOptCableSectEndpointType(csvRecord.get("OPT_CABLE_SECT_ENDPOINT_TYPE"));
			oriOpticalCableSection.setOptCableEndpointResources(csvRecord.get("OPT_CABLE_ENDPOINT_RESOURCES"));
			oriOpticalCableSection.setOptCableSectEndpointResou(csvRecord.get("OPT_CABLE_SECT_ENDPOINT_RESOU"));
			oriOpticalCableSection.setRightJurisdictionUnderOrg(csvRecord.get("RIGHT_JURISDICTION_UNDER_ORG"));
			oriOpticalCableSection.setMaintenanceOrg(csvRecord.get("MAINTENANCE_ORG"));
			oriOpticalCableSection.setStatisticalOrg(csvRecord.get("STATISTICAL_ORG"));

			oriOpticalCableSection.setPropertyRightsOrg(csvRecord.get("PROPERTY_RIGHTS_ORG"));
			oriOpticalCableSection.setGlobalName(csvRecord.get("GLOBAL_NAME"));

			oriOpticalCableSection.setAbbreviation(csvRecord.get("ABBREVIATION"));
			oriOpticalCableSection.setModel(csvRecord.get("MODEL"));
			oriOpticalCableSection.setDefender(csvRecord.get("DEFENDER"));
			oriOpticalCableSection.setContactNumber(csvRecord.get("CONTACT_NUMBER"));
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

	public void csvspareEquipmentImportAdd(String pathStr, String versionValue, String calYear) throws ParseException, IOException {
		// TODO Auto-generated method stub
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
			PmsSpareEquipment pmsSpareEquipment = new PmsSpareEquipment();
			// pmsItemShuLine.setCalYear(new
			// Short(dataVersion.substring(dataVersion.indexOf("_")+1,dataVersion.indexOf("_")+5)));
			pmsSpareEquipment.setCalYear(DateFormatUtil.parseDate(calYear));
			pmsSpareEquipment.setDataVersion(versionValue); 
            System.out.println("1");
			pmsSpareEquipment.setDataSourceFile(pathStr);
			pmsSpareEquipment.setSpareEquipmentSource(csvRecord.get("SPARE_EQUIPMENT_SOURCE"));
			pmsSpareEquipment.setSblx(csvRecord.get("SBLX"));
			pmsSpareEquipment.setZclxbm(csvRecord.get("ZCLXBM"));
			pmsSpareEquipment.setCwbm(csvRecord.get("CWBM"));
			pmsSpareEquipment.setDydj(csvRecord.get("DYDJ"));
			pmsSpareEquipment.setZzsmc(csvRecord.get("ZZSMC"));
			pmsSpareEquipment.setSbxh(csvRecord.get("SBXH"));
			pmsSpareEquipment.setKcdd(csvRecord.get("KCDD"));
			pmsSpareEquipment.setEquipmentManager(csvRecord.get("EQUIPMENT_MANAGER"));
			pmsSpareEquipment.setEquipmentAccessResult(csvRecord.get("EQUIPMENT_ACCESS_RESULT"));
			pmsSpareEquipment.setAssetQuality(csvRecord.get("ASSET_QUALITY"));
			pmsSpareEquipment.setAssetOrg(csvRecord.get("ASSET_ORG"));
			pmsSpareEquipment.setAssetNo(csvRecord.get("ASSET_NO"));
			pmsSpareEquipment.setSbbm(csvRecord.get("SBBM"));
			if (!(csvRecord.get("WAREHOUSING_DATE").trim().isEmpty())) { 
					pmsSpareEquipment.setWarehousingDate(DateFormatUtil.parseDate(csvRecord.get("WAREHOUSING_DATE")));
				 
			}
			if (csvRecord.get("NN").trim().isEmpty()) {
				pmsSpareEquipment.setNn(new Double(0.0));
			} else {
				pmsSpareEquipment.setNn( 
						new DecimalFormat().parse(csvRecord.get("NN")).doubleValue()
						);
			}
			pmsSpareEquipment.setEquipmentStatus(csvRecord.get("EQUIPMENT_STATUS"));
			pmsSpareEquipment.setProgrameName(csvRecord.get("PROGRAME_NAME"));
			if (csvRecord.get("ASSET_ORIGINAL_VALUE").trim().isEmpty()) {
				pmsSpareEquipment.setAssetOriginalValue(new Double(0.0));
			} else {
				pmsSpareEquipment.setAssetOriginalValue( 
				new DecimalFormat().parse(csvRecord.get("ASSET_ORIGINAL_VALUE")).doubleValue()
				
						);
			}
			if (csvRecord.get("ASSET_NET_VALUE").trim().isEmpty()) {
				pmsSpareEquipment.setAssetNetValue(new Double(0.0));
			} else {
				pmsSpareEquipment
						.setAssetNetValue( 
								new DecimalFormat().parse(csvRecord.get("ASSET_NET_VALUE")).doubleValue()
								);
			}
			pmsSpareEquipment.setValueUnit(csvRecord.get("VALUE_UNIT")); 

			session.save(pmsSpareEquipment);
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

}
