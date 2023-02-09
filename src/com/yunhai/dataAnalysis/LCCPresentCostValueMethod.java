package com.yunhai.dataAnalysis;

public class LCCPresentCostValueMethod {
	
	public Double nPeriodPresentCostValue(Double cost,Double inflationRate,Double interestRate,int period) {
		 
		return cost*Math.pow((1+inflationRate), period)/Math.pow((1+interestRate), period);
	}
	public Double presentCostValue(Double cost,Double inflationRate,Double interestRate,int period) {
		Double resultValue=0.0;
		for(int i=1;i<=period;i++) {
			resultValue=resultValue+nPeriodPresentCostValue(cost, inflationRate, interestRate,i);
		}
		return resultValue;
	}
	
	
}
