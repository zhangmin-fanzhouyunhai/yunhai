package com.yunhai.excel;

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

import com.yunhai.excel.orm.OElectricReactor;
import com.yunhai.util.DateFormatUtil;

public class TestClass {
	public static void csvOElectricReactorAdd(String pathStr, String versionValue, String calYear)
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
			OElectricReactor oElectricReactor = new OElectricReactor();
			oElectricReactor.setOElectricReactorId(csvRecord.get("O_ELECTRIC_REACTOR_ID"));
			oElectricReactor.setDataVersion(versionValue);
			oElectricReactor.setCalYear(DateFormatUtil.parseDate(calYear));
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
			//oElectricReactor.setCodingEquipment(csvRecord.get("CODING_EQUIPMENT"));
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
}
