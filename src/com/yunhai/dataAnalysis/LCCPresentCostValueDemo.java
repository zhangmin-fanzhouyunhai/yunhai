package com.yunhai.dataAnalysis;

public class LCCPresentCostValueDemo {
	public static void main(String[] args) {
		LCCPresentCostValueMethod lccP=new LCCPresentCostValueMethod();
		Double inflationRate=0.0223;
		Double interestRate=0.0221;
		int period=32;
		Double initalCost=8.0;//初始成本C1
		Double cost2=0.0;//运维检修成本C2
		Double cost21=0.8;//运维成本C21
		Double cost22=0.7;//检修成本C22
		Double cost23=0.4;//故障成本C23
		Double cost3=0.0;//损耗成本C3
		Double cost5=-0.4;//退役处置成本C5
		cost2=cost21+cost22+cost23;
		
		Double initalPresentCost=initalCost;//初始成本C1
		Double presentcost2=lccP.presentCostValue(cost2,inflationRate,interestRate,period);//运维检修成本C2
		Double presentcost21=lccP.presentCostValue(cost21,inflationRate,interestRate,period);//运维成本C21
		Double presentcost22=lccP.presentCostValue(cost22,inflationRate,interestRate,period);//检修成本C22
		Double presentcost23=lccP.presentCostValue(cost23,inflationRate,interestRate,period);//故障成本C23
		Double presentcost3=lccP.presentCostValue(cost3,inflationRate,interestRate,period);//损耗成本C3
		Double presentcost5=lccP.nPeriodPresentCostValue(cost5,inflationRate,interestRate,period);//退役处置成本C5 
		System.out.println("initalPresentCost="+initalPresentCost);
		System.out.println("Presentcost2="+presentcost2); 
		System.out.println("Presentcost21="+presentcost21);
		System.out.println("Presentcost22="+presentcost22);
		System.out.println("Presentcost23="+presentcost23);
		System.out.println("Presentcost3="+presentcost3);
		System.out.println("Presentcost5="+presentcost5);
		
	}
}
