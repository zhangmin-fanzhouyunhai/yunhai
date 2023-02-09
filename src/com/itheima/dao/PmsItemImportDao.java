package com.itheima.dao;

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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itheima.user.orm.PmsItemShuLine;

public class PmsItemImportDao {
	
	
	

	public PmsItemImportDao() { 
		// TODO Auto-generated constructor stub
	}

	public void csvPmsItemShuLineAdd(String pathStr, String dataVersion, String calYear) throws IOException {
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
			// pmsItemShuLine.setPmsItemShuLineId(csvRecord.get("PMS_ITEM_SHU_LINE_ID"));
			pmsItemShuLine.setCalYear(new Short(calYear));
			// pmsItemShuLine.setVersion(csvRecord.get("VERSION"));
			pmsItemShuLine.setVersion(dataVersion);
			pmsItemShuLine.setSbbm(csvRecord.get("SBBM"));
			pmsItemShuLine.setDwmx(csvRecord.get("DWMX"));
			pmsItemShuLine.setYwdw(csvRecord.get("YWDW"));
			pmsItemShuLine.setZckbm(csvRecord.get("ZCKBM"));
			pmsItemShuLine.setSblx(csvRecord.get("SBLX"));
			if (csvRecord.get("ZCYZ").trim().isEmpty()) {
				pmsItemShuLine.setZcyz(new Double(0.0));
			} else {
				try {
					pmsItemShuLine.setZcyz(df.parse(csvRecord.get("ZCYZ")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			pmsItemShuLine.setZcdl(csvRecord.get("ZCDL"));
			pmsItemShuLine.setZclxbm(csvRecord.get("ZCLXBM"));
			pmsItemShuLine.setCwbm(csvRecord.get("CWBM"));
			pmsItemShuLine.setDydj(csvRecord.get("DYDJ"));
			pmsItemShuLine.setYxzt(csvRecord.get("YXZT"));
			pmsItemShuLine.setJkzt(csvRecord.get("JKZT"));

			// System.out.println(!csvRecord.get("ZJTYRQ").trim().isEmpty());
			// System.out.println(csvRecord.get("ZJTYRQ").trim());
			if (!csvRecord.get("ZJTYRQ").trim().isEmpty()) {
				try {
					// System.out.println(csvRecord.get("ZJTYRQ"));
					pmsItemShuLine.setZjtyrq(simpleDateFormat.parse(csvRecord.get("ZJTYRQ").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			pmsItemShuLine.setZcxz(csvRecord.get("ZCXZ"));

			if (csvRecord.get("SL").trim().isEmpty()) {
				pmsItemShuLine.setSl(new Double(0.0));
			} else {
				try {
					pmsItemShuLine.setSl(df.parse(csvRecord.get("SL")).doubleValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				if (!(null == csvRecord.get("SL1"))) {
					if (csvRecord.get("SL1").trim().isEmpty()) {
						pmsItemShuLine.setSl1(new Double(0.0));
					} else {
						try {
							pmsItemShuLine.setSl1(df.parse(csvRecord.get("SL1")).doubleValue());
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
				if (!(null == csvRecord.get("SL2"))) {
					if (csvRecord.get("SL2").trim().isEmpty()) {
						pmsItemShuLine.setSl2(new Double(0.0));
					} else {
						try {
							pmsItemShuLine.setSl2(df.parse(csvRecord.get("SL2")).doubleValue());
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

			/*
			 * if(!(null ==csvRecord.get("SL3"))){ if
			 * (csvRecord.get("SL3").trim().isEmpty()) { pmsItemShuLine.setSl3(new
			 * Double(0.0)); } else { try { pmsItemShuLine.setSl3(new
			 * DecimalFormat().parse(csvRecord.get("SL3")).doubleValue()); } catch
			 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } }
			 */
			pmsItemShuLine.setZzsmc(csvRecord.get("ZZSMC"));
			pmsItemShuLine.setSsxlbdz(csvRecord.get("SSXLBDZ"));
			pmsItemShuLine.setSbxh(csvRecord.get("SBXH"));
			if (csvRecord.get("TYNF").trim().isEmpty()) {
				pmsItemShuLine.setTynf(new Short("0"));
			} else {
				try {
					pmsItemShuLine.setTynf(df.parse(csvRecord.get("TYNF")).shortValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			pmsItemShuLine.setNnd(csvRecord.get("NND"));
			if (!csvRecord.get("TYRQ").trim().isEmpty()) {
				try {
					pmsItemShuLine.setTyrq(simpleDateFormat.parse(csvRecord.get("TYRQ").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (csvRecord.get("NN").trim().isEmpty()) {
				pmsItemShuLine.setNn(new Short("0"));
			} else {
				try {
					pmsItemShuLine.setNn(df.parse(csvRecord.get("NN")).shortValue());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			pmsItemShuLine.setQfzd(csvRecord.get("QFZD"));
			if (!csvRecord.get("CCRQ").trim().isEmpty()) {
				try {
					pmsItemShuLine.setCcrq(simpleDateFormat.parse(csvRecord.get("CCRQ").replace(" ", "")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			// pmsItemShuLine.setZclxbm1(csvRecord.get("ZCLXBM1"));

			pmsItemShuLine.setEquipmentName(csvRecord.get("EQUIPMENT_NAME"));

			pmsItemShuLine.setAssetId(csvRecord.get("ASSET_ID"));
			pmsItemShuLine.setEquipmentIncreaseMode(csvRecord.get("EQUIPMENT_INCREASE_MODE"));
			pmsItemShuLine.setDataSourceFile(pathStr);

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
}
