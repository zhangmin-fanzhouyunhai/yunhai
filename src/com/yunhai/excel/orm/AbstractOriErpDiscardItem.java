package com.yunhai.excel.orm;

import java.util.Date;

/**
 * AbstractOriErpDiscardItem entity provides the base persistence definition of
 * the OriErpDiscardItem entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOriErpDiscardItem implements java.io.Serializable {

	// Fields

	private String oriErpDiscardItemId;
	private String version;
	private Date calYear;
	private String equnr;
	private String techObj;
	private String txt04;
	private String ztypbz;
	private String ztypbzTxt;
	private String assetMain;
	private String zzcms;
	private String zbfyywb;
	private String rvaluePro;
	private String assetDiscard;
	private String variableStatus;
	private Date transDate;
	private Date accountDate;
	private String involve;
	private Double discardRatio;
	private Double discardOvalue;
	private Double discardDepr;
	private String text;
	private String allocate;
	private String allocateCode;
	private String costCenter;
	private String costcenterText;
	private Double zquantity;
	private String unit;
	private String unitText;
	private String herst;
	private Date aktiv;
	private String readyuseYear;
	private String readyuseMonth;
	private String checkMark;
	private String zlrzxCode;
	private String zlrzx;
	private String profitCtr;
	private String longText;
	private String abstract_;
	private String username;
	private String techInformation;
	private String rvalueproUpdaplan;
	private String provAppr;
	private String mark;
	private String approvalNode;
	private String carproWhether;
	private String carBustype;
	private String carType;
	private String carLevel;
	private String physicalid;

	// Constructors

	/** default constructor */
	public AbstractOriErpDiscardItem() {
	}

	/** minimal constructor */
	public AbstractOriErpDiscardItem(String version, Date calYear) {
		this.version = version;
		this.calYear = calYear;
	}

	/** full constructor */
	public AbstractOriErpDiscardItem(String version, Date calYear, String equnr, String techObj, String txt04,
			String ztypbz, String ztypbzTxt, String assetMain, String zzcms, String zbfyywb, String rvaluePro,
			String assetDiscard, String variableStatus, Date transDate, Date accountDate, String involve,
			Double discardRatio, Double discardOvalue, Double discardDepr, String text, String allocate,
			String allocateCode, String costCenter, String costcenterText, Double zquantity, String unit,
			String unitText, String herst, Date aktiv, String readyuseYear, String readyuseMonth, String checkMark,
			String zlrzxCode, String zlrzx, String profitCtr, String longText, String abstract_, String username,
			String techInformation, String rvalueproUpdaplan, String provAppr, String mark, String approvalNode,
			String carproWhether, String carBustype, String carType, String carLevel, String physicalid) {
		this.version = version;
		this.calYear = calYear;
		this.equnr = equnr;
		this.techObj = techObj;
		this.txt04 = txt04;
		this.ztypbz = ztypbz;
		this.ztypbzTxt = ztypbzTxt;
		this.assetMain = assetMain;
		this.zzcms = zzcms;
		this.zbfyywb = zbfyywb;
		this.rvaluePro = rvaluePro;
		this.assetDiscard = assetDiscard;
		this.variableStatus = variableStatus;
		this.transDate = transDate;
		this.accountDate = accountDate;
		this.involve = involve;
		this.discardRatio = discardRatio;
		this.discardOvalue = discardOvalue;
		this.discardDepr = discardDepr;
		this.text = text;
		this.allocate = allocate;
		this.allocateCode = allocateCode;
		this.costCenter = costCenter;
		this.costcenterText = costcenterText;
		this.zquantity = zquantity;
		this.unit = unit;
		this.unitText = unitText;
		this.herst = herst;
		this.aktiv = aktiv;
		this.readyuseYear = readyuseYear;
		this.readyuseMonth = readyuseMonth;
		this.checkMark = checkMark;
		this.zlrzxCode = zlrzxCode;
		this.zlrzx = zlrzx;
		this.profitCtr = profitCtr;
		this.longText = longText;
		this.abstract_ = abstract_;
		this.username = username;
		this.techInformation = techInformation;
		this.rvalueproUpdaplan = rvalueproUpdaplan;
		this.provAppr = provAppr;
		this.mark = mark;
		this.approvalNode = approvalNode;
		this.carproWhether = carproWhether;
		this.carBustype = carBustype;
		this.carType = carType;
		this.carLevel = carLevel;
		this.physicalid = physicalid;
	}

	// Property accessors

	public String getOriErpDiscardItemId() {
		return this.oriErpDiscardItemId;
	}

	public void setOriErpDiscardItemId(String oriErpDiscardItemId) {
		this.oriErpDiscardItemId = oriErpDiscardItemId;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Date calYear) {
		this.calYear = calYear;
	}

	public String getEqunr() {
		return this.equnr;
	}

	public void setEqunr(String equnr) {
		this.equnr = equnr;
	}

	public String getTechObj() {
		return this.techObj;
	}

	public void setTechObj(String techObj) {
		this.techObj = techObj;
	}

	public String getTxt04() {
		return this.txt04;
	}

	public void setTxt04(String txt04) {
		this.txt04 = txt04;
	}

	public String getZtypbz() {
		return this.ztypbz;
	}

	public void setZtypbz(String ztypbz) {
		this.ztypbz = ztypbz;
	}

	public String getZtypbzTxt() {
		return this.ztypbzTxt;
	}

	public void setZtypbzTxt(String ztypbzTxt) {
		this.ztypbzTxt = ztypbzTxt;
	}

	public String getAssetMain() {
		return this.assetMain;
	}

	public void setAssetMain(String assetMain) {
		this.assetMain = assetMain;
	}

	public String getZzcms() {
		return this.zzcms;
	}

	public void setZzcms(String zzcms) {
		this.zzcms = zzcms;
	}

	public String getZbfyywb() {
		return this.zbfyywb;
	}

	public void setZbfyywb(String zbfyywb) {
		this.zbfyywb = zbfyywb;
	}

	public String getRvaluePro() {
		return this.rvaluePro;
	}

	public void setRvaluePro(String rvaluePro) {
		this.rvaluePro = rvaluePro;
	}

	public String getAssetDiscard() {
		return this.assetDiscard;
	}

	public void setAssetDiscard(String assetDiscard) {
		this.assetDiscard = assetDiscard;
	}

	public String getVariableStatus() {
		return this.variableStatus;
	}

	public void setVariableStatus(String variableStatus) {
		this.variableStatus = variableStatus;
	}

	public Date getTransDate() {
		return this.transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public Date getAccountDate() {
		return this.accountDate;
	}

	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}

	public String getInvolve() {
		return this.involve;
	}

	public void setInvolve(String involve) {
		this.involve = involve;
	}

	public Double getDiscardRatio() {
		return this.discardRatio;
	}

	public void setDiscardRatio(Double discardRatio) {
		this.discardRatio = discardRatio;
	}

	public Double getDiscardOvalue() {
		return this.discardOvalue;
	}

	public void setDiscardOvalue(Double discardOvalue) {
		this.discardOvalue = discardOvalue;
	}

	public Double getDiscardDepr() {
		return this.discardDepr;
	}

	public void setDiscardDepr(Double discardDepr) {
		this.discardDepr = discardDepr;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAllocate() {
		return this.allocate;
	}

	public void setAllocate(String allocate) {
		this.allocate = allocate;
	}

	public String getAllocateCode() {
		return this.allocateCode;
	}

	public void setAllocateCode(String allocateCode) {
		this.allocateCode = allocateCode;
	}

	public String getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getCostcenterText() {
		return this.costcenterText;
	}

	public void setCostcenterText(String costcenterText) {
		this.costcenterText = costcenterText;
	}

	public Double getZquantity() {
		return this.zquantity;
	}

	public void setZquantity(Double zquantity) {
		this.zquantity = zquantity;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitText() {
		return this.unitText;
	}

	public void setUnitText(String unitText) {
		this.unitText = unitText;
	}

	public String getHerst() {
		return this.herst;
	}

	public void setHerst(String herst) {
		this.herst = herst;
	}

	public Date getAktiv() {
		return this.aktiv;
	}

	public void setAktiv(Date aktiv) {
		this.aktiv = aktiv;
	}

	public String getReadyuseYear() {
		return this.readyuseYear;
	}

	public void setReadyuseYear(String readyuseYear) {
		this.readyuseYear = readyuseYear;
	}

	public String getReadyuseMonth() {
		return this.readyuseMonth;
	}

	public void setReadyuseMonth(String readyuseMonth) {
		this.readyuseMonth = readyuseMonth;
	}

	public String getCheckMark() {
		return this.checkMark;
	}

	public void setCheckMark(String checkMark) {
		this.checkMark = checkMark;
	}

	public String getZlrzxCode() {
		return this.zlrzxCode;
	}

	public void setZlrzxCode(String zlrzxCode) {
		this.zlrzxCode = zlrzxCode;
	}

	public String getZlrzx() {
		return this.zlrzx;
	}

	public void setZlrzx(String zlrzx) {
		this.zlrzx = zlrzx;
	}

	public String getProfitCtr() {
		return this.profitCtr;
	}

	public void setProfitCtr(String profitCtr) {
		this.profitCtr = profitCtr;
	}

	public String getLongText() {
		return this.longText;
	}

	public void setLongText(String longText) {
		this.longText = longText;
	}

	public String getAbstract_() {
		return this.abstract_;
	}

	public void setAbstract_(String abstract_) {
		this.abstract_ = abstract_;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTechInformation() {
		return this.techInformation;
	}

	public void setTechInformation(String techInformation) {
		this.techInformation = techInformation;
	}

	public String getRvalueproUpdaplan() {
		return this.rvalueproUpdaplan;
	}

	public void setRvalueproUpdaplan(String rvalueproUpdaplan) {
		this.rvalueproUpdaplan = rvalueproUpdaplan;
	}

	public String getProvAppr() {
		return this.provAppr;
	}

	public void setProvAppr(String provAppr) {
		this.provAppr = provAppr;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getApprovalNode() {
		return this.approvalNode;
	}

	public void setApprovalNode(String approvalNode) {
		this.approvalNode = approvalNode;
	}

	public String getCarproWhether() {
		return this.carproWhether;
	}

	public void setCarproWhether(String carproWhether) {
		this.carproWhether = carproWhether;
	}

	public String getCarBustype() {
		return this.carBustype;
	}

	public void setCarBustype(String carBustype) {
		this.carBustype = carBustype;
	}

	public String getCarType() {
		return this.carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarLevel() {
		return this.carLevel;
	}

	public void setCarLevel(String carLevel) {
		this.carLevel = carLevel;
	}

	public String getPhysicalid() {
		return this.physicalid;
	}

	public void setPhysicalid(String physicalid) {
		this.physicalid = physicalid;
	}

}