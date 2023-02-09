package com.yunhai.dataAnalysis;

public class LCCPresentCostValueDemo {
	public static void main(String[] args) {
		LCCPresentCostValueMethod lccP=new LCCPresentCostValueMethod();
		Double inflationRate=0.0223;
		Double interestRate=0.0221;
		int period=32;
		Double initalCost=8.0;//��ʼ�ɱ�C1
		Double cost2=0.0;//��ά���޳ɱ�C2
		Double cost21=0.8;//��ά�ɱ�C21
		Double cost22=0.7;//���޳ɱ�C22
		Double cost23=0.4;//���ϳɱ�C23
		Double cost3=0.0;//��ĳɱ�C3
		Double cost5=-0.4;//���۴��óɱ�C5
		cost2=cost21+cost22+cost23;
		
		Double initalPresentCost=initalCost;//��ʼ�ɱ�C1
		Double presentcost2=lccP.presentCostValue(cost2,inflationRate,interestRate,period);//��ά���޳ɱ�C2
		Double presentcost21=lccP.presentCostValue(cost21,inflationRate,interestRate,period);//��ά�ɱ�C21
		Double presentcost22=lccP.presentCostValue(cost22,inflationRate,interestRate,period);//���޳ɱ�C22
		Double presentcost23=lccP.presentCostValue(cost23,inflationRate,interestRate,period);//���ϳɱ�C23
		Double presentcost3=lccP.presentCostValue(cost3,inflationRate,interestRate,period);//��ĳɱ�C3
		Double presentcost5=lccP.nPeriodPresentCostValue(cost5,inflationRate,interestRate,period);//���۴��óɱ�C5 
		System.out.println("initalPresentCost="+initalPresentCost);
		System.out.println("Presentcost2="+presentcost2); 
		System.out.println("Presentcost21="+presentcost21);
		System.out.println("Presentcost22="+presentcost22);
		System.out.println("Presentcost23="+presentcost23);
		System.out.println("Presentcost3="+presentcost3);
		System.out.println("Presentcost5="+presentcost5);
		
	}
}
