package com.yunhai.dataAnalysis.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunhai.dataAnalysis.LCCPresentCostValueMethod;

import net.sf.json.JSONObject;

public class PresentValueCostServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LCCPresentCostValueMethod lccPCV=new LCCPresentCostValueMethod(); 
		//通货膨胀率
		Double inflationRate=(Double) request.getAttribute("inflationRate");
		//Double inflationRate=0.0223;
		//利率
		Double interestRate=(Double) request.getAttribute("interestRate");
		//Double interestRate=0.0221; 

		//现值期数
		Integer period=(Integer) request.getAttribute("period");
		//初始成本C1
		Double initalCost=(Double) request.getAttribute("initalCost");
		//Double initalCost=8.0;
		//运维检修成本C2
		Double operationMaintenOverhaulCost=(Double) request.getAttribute("operationMaintenOverhaulCost");
		//Double cost2=0.0;
		//运维成本C21
		Double operationMaintenanceCost=(Double) request.getAttribute("operationMaintenanceCost");
		//Double cost21=0.8;
		//检修成本C22
		Double overhaulCost=(Double) request.getAttribute("overhaulCost");
		//Double cost22=0.7;
		//故障成本C23
		Double failureCost=(Double) request.getAttribute("failureCost");
		//Double cost23=0.4;
		//损耗成本C3
		Double wastageCost=(Double) request.getAttribute("wastageCost");
		//Double cost3=0.0;
		//退役处置成本C5
		Double retireHandleCost=(Double) request.getAttribute("retireHandleCost");
		//Double cost5=-0.4;
		
		Double initalPresentCost=initalCost;//初始成本C1
		Double presentOperationMaintenOverhaulCost=lccPCV.presentCostValue(operationMaintenOverhaulCost,inflationRate,interestRate,period);//运维检修成本C2
		Double presentOperationMaintenanceCost=lccPCV.presentCostValue(operationMaintenanceCost,inflationRate,interestRate,period);//运维成本C21
		Double presentOverhaulCost=lccPCV.presentCostValue(overhaulCost,inflationRate,interestRate,period);//检修成本C22
		Double presentFailureCost=lccPCV.presentCostValue(failureCost,inflationRate,interestRate,period);//故障成本C23
		Double presentWastageCost=lccPCV.presentCostValue(wastageCost,inflationRate,interestRate,period);//损耗成本C3
		Double presentRetireHandleCost=lccPCV.nPeriodPresentCostValue(retireHandleCost,inflationRate,interestRate,period);//退役处置成本C5
		Map<Object,Object> resultData=new HashMap<>();
		resultData.put("initalPresentCost", initalPresentCost);
		resultData.put("presentOperationMaintenOverhaulCost", presentOperationMaintenOverhaulCost);
		resultData.put("presentOperationMaintenanceCost", presentOperationMaintenanceCost);
		resultData.put("presentOverhaulCost", presentOverhaulCost);
		resultData.put("presentFailureCost", presentFailureCost);
		resultData.put("presentWastageCost", presentWastageCost);
		resultData.put("presentRetireHandleCost", presentRetireHandleCost);
		JSONObject object=JSONObject.fromObject(resultData);
		//把json数据返回给浏览器；
		response.getWriter().write(object.toString());
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}
}
