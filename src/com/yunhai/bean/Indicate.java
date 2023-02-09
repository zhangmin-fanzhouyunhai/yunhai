package com.yunhai.bean;

import java.util.List;
import java.util.Map;

public class Indicate extends AbstractIndicate{

	public Indicate() {
		// TODO Auto-generated constructor stub
	}

	public Indicate(Map indicateMap, String indicateName, List<AbstractDimension> dimensionList) {
		super(indicateMap, indicateName, dimensionList);
		// TODO Auto-generated constructor stub
	}

	public Indicate(Map indicateMap, String indicateName, List<AbstractDimension> dimensionList, int columnNumber,
			int rowNumber, int direction) {
		super(indicateMap, indicateName, dimensionList, columnNumber, rowNumber, direction);
		// TODO Auto-generated constructor stub
	}

	public Indicate(Map indicateMap, String indicateName, List<AbstractDimension> dimensionList, int columnNumber,
			int rowNumber) {
		super(indicateMap, indicateName, dimensionList, columnNumber, rowNumber);
		// TODO Auto-generated constructor stub
	}

}
