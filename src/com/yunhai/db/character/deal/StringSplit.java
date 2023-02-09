package com.yunhai.db.character.deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yunhai.db.util.DbUtil;

public class StringSplit {

	public static void main(String[] args) {
		//test();
		//techProjectRecommdationBasisSplit();
		//overhaulProjectRecommdationBasisSplit();
	}
	
	public static void test() {
		String s = "4.3.4.2  符合以下现象之一的开关柜（包括高、低压开关柜,下同）应安排技改：\r\n" + 
				"1)通过设备状态评价认定：绝缘性能、载流能力、短路开断能力、SF6气体、机械特性等评价结果为严重状态且无法通过现场大修解决的开关柜。\r\n" + 
				"2)内部故障电流大小和短路持续时间（IAC等级水平）达不到技术标准要求，影响安全运行的落地手车式高压开关柜。\r\n" + 
				"3)累计短路开断次数达到产品设计值，或累计合分操作次数达到产品设计的额定机械寿命，且无修复价值的开关柜。\r\n" + 
				"4)手车抽出或隔离（负荷）开关分闸后，不能满足避雷器、电压互感器和熔断器均不带电的开关柜。\r\n" + 
				"5)存在五防装置故障、严重放电、严重破损、过热等严重状态的开关柜。\r\n" + 
				"6)未设置泄压通道的开关柜。";
		// 把要匹配的字符串写成正则表达式，然后要提取的字符使用括号括起来
		// 在这里，我们要提取最后一个数字，正则规则就是“一个数字加上大于等于0个非数字再加上结束符”
		Pattern pattern = Pattern.compile("([0-9]*.([0-9]*.)*[0-9]*)");
		Matcher matcher = pattern.matcher(s);
		while(matcher.find()) { 
			System.out.println(matcher.group());  
		}
	}

	public static void overhaulProjectRecommdationBasisSplit() {

		// TODO Auto-generated method stub

		Connection conn = null;
		conn = DbUtil.getConnection();
		
		String sqlStr="SELECT  " + 
				"A.PROFESSIONAL_CATEGORY, " + 
				"A.PROFESSIONAL_SEGMENTATION, " + 
				"A.TRANSFORMATION_PURPOSE, " + 
				"A.PROFESSIONAL_INVEST_DIRECTION, " + 
				" A.RECOMMENDATION_BASIS,  " + 
				"COUNT(*) QUANTITY  " + 
				"FROM  " + 
				"( " + 
				"SELECT  " + 
				"A.PROFESSIONAL_CATEGORY, " + 
				"A.PROFESSIONAL_SEGMENTATION, " + 
				"''TRANSFORMATION_PURPOSE, " + 
				"CAST(A.PROJECT_BASIS AS NVARCHAR2(1000))RECOMMENDATION_BASIS, " + 
				"A.PROFESSIONAL_INVEST_DIRECTION " + 
				"FROM  " + 
				"ORI_OVERHAUL_ROUGH_TABLE A  " + 
				"WHERE  " + 
				"DATA_VERSION='O_2021_2' " + 
				") A " + 
				"GROUP BY " + 
				"A.PROFESSIONAL_CATEGORY, " + 
				"A.PROFESSIONAL_SEGMENTATION, " + 
				"A.TRANSFORMATION_PURPOSE, " + 
				"A.PROFESSIONAL_INVEST_DIRECTION, " + 
				" A.RECOMMENDATION_BASIS   " + 
				"ORDER BY " + 
				"A.PROFESSIONAL_CATEGORY, " + 
				"A.PROFESSIONAL_SEGMENTATION, " + 
				"A.TRANSFORMATION_PURPOSE, " + 
				"A.PROFESSIONAL_INVEST_DIRECTION, " + 
				"A.RECOMMENDATION_BASIS ";

		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		List<Map> resultList=new ArrayList<Map>();
		try {
			pre = conn.prepareStatement(sqlStr);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			/**
			 * 通过正则(([0-9]+\\.)([0-9]+\\.)+([0-9]+)),将技改依据拆分，得到所引用的所有技改依据的内容部分
			 * 注意：在正则表达式中“.”表示“匹配除换行符\n之外的任何字单字符。要匹配.，需要使用\”，而写成“\.”是会报错的，只有写成“\\.”才是正确的。
			 */
			Pattern pattern=Pattern.compile("(([0-9]+\\.)([0-9]+\\.)+([0-9]+))");
			Matcher matcher = null;
			while (result.next()) {  
				String professionalCategory= result.getString("PROFESSIONAL_CATEGORY");
				String professionalSegmentation= result.getString("PROFESSIONAL_SEGMENTATION");
				String transformationPurpose= result.getString("TRANSFORMATION_PURPOSE");
				String professionalInvestDirection= result.getString("PROFESSIONAL_INVEST_DIRECTION");
				//System.out.println("professionalInvestDirection:"+professionalInvestDirection);
				String recommendationBasis= result.getString("RECOMMENDATION_BASIS");
				String quantity=  result.getString("QUANTITY"); 
				List<String> recommendationBasisIndexList=new ArrayList<String>();
				List<String> recommendationBasisContentList=new ArrayList<String>();
				//System.out.println("recommendationBasis:"+recommendationBasis);
				if(recommendationBasis!=null) { 
					/**
					 * 通过正则(([0-9]+\\.)([0-9]+\\.)+([0-9]+)),将技改依据拆分，得到所引用的所有技改依据的内容部分
					 * 进行匹配时会出现一个为空的字符串，为普遍现象。
					 * 注意：在正则表达式中“.”表示“匹配除换行符\n之外的任何字单字符。要匹配.，需要使用\”，而写成“\.”是会报错的，只有写成“\\.”才是正确的。
					 */
					String [] recommendationBasisSub =recommendationBasis.split("(([0-9]+\\.)([0-9]+\\.)+([0-9]+))");
					/**
					 * 通过循环将技改依据存入recommendationBasisContentList
					 */
					int contentI=0;
					for(int i=0;i<recommendationBasisSub.length;i++) { 
						if(recommendationBasisSub[i].trim()!=null && !recommendationBasisSub[i].trim().isEmpty()) {
						//System.out.println("recommendationBasisSub["+i+"]:"+recommendationBasisSub[i].trim());
						recommendationBasisContentList.add(contentI,recommendationBasisSub[i].trim());
						}
					}
					/**
					 * 通过正则(([0-9]+\\.)([0-9]+\\.)+([0-9]+)),将技改依据拆获取不同技改依据的编号，
					 * 并将通过循环技改依据的编号存入recommendationBasisIndexList中。
					 * 注意：在正则表达式中“.”表示“匹配除换行符\n之外的任何字单字符。要匹配.，需要使用\”，而写成“\.”是会报错的，只有写成“\\.”才是正确的。
					 */
					matcher=pattern.matcher(recommendationBasis); 
					int recI=0;
					while(matcher.find()) {
						//System.out.println(matcher.group()); 
						recommendationBasisIndexList.add(recI, matcher.group());
						recI++;
					}
					//System.out.println("recommendationBasisIndexList.size="+recommendationBasisIndexList.size());
					//System.out.println("recommendationBasisContentList.size="+recommendationBasisContentList.size());
					for(int basisI=0;basisI<recommendationBasisIndexList.size();basisI++) { 
						Map recordMap =new HashMap();
						recordMap.put("PROFESSIONAL_CATEGORY", professionalCategory);
						recordMap.put("PROFESSIONAL_SEGMENTATION", professionalSegmentation);
						recordMap.put("TRANSFORMATION_PURPOSE", transformationPurpose);
						recordMap.put("PROFESSIONAL_INVEST_DIRECTION", professionalInvestDirection);
						recordMap.put("RECOMMENDATION_BASIS", recommendationBasis);
						recordMap.put("QUANTITY", quantity);
						recordMap.put("RECOMMENDATION_BASIS_INDEX", recommendationBasisIndexList.get(basisI));
						recordMap.put("RECOMMENDATION_BASIS_CONTENT", recommendationBasisContentList.get(basisI));
						resultList.add(recordMap); 
					}
				}else { 
					Map recordMap =new HashMap();
					recordMap.put("PROFESSIONAL_CATEGORY", professionalCategory);
					recordMap.put("PROFESSIONAL_SEGMENTATION", professionalSegmentation);
					recordMap.put("TRANSFORMATION_PURPOSE", transformationPurpose);
					recordMap.put("PROFESSIONAL_INVEST_DIRECTION", professionalInvestDirection);
					recordMap.put("RECOMMENDATION_BASIS", recommendationBasis);
					recordMap.put("QUANTITY", quantity); 
					recordMap.put("RECOMMENDATION_BASIS_INDEX", "");
					recordMap.put("RECOMMENDATION_BASIS_CONTENT", "");
					resultList.add(recordMap); 
				}
			}
		String insertSql="INSERT INTO DV_OVER_INVE_DIRECT_RECO_BASIS(PROFESSIONAL_CATEGORY,	"
				+ "PROFESSIONAL_SEGMENTATION,	TRANSFORMATION_PURPOSE,	PROFESSIONAL_INVEST_DIRECTION,	"
				+ "RECOMMENDATION_BASIS,	QUANTITY,	"
				+ "RECOMMENDATION_BASIS_INDEX,	RECOMMENDATION_BASIS_CONTENT"
				+ ")VALUES(?,?,?,?,?,?,?,?)";
		pre = conn.prepareStatement(insertSql);
		int reslutListSize=resultList.size();
		int insertCount=0;
		System.out.println("reslutListSize="+reslutListSize);
		for(int recordI=0;recordI<reslutListSize;recordI++) {
			//System.out.println("PROFESSIONAL_CATEGORY="+(String) resultList.get(recordI).get("PROFESSIONAL_CATEGORY"));
			pre.setString(1, (String) resultList.get(recordI).get("PROFESSIONAL_CATEGORY"));
			pre.setString(2, (String) resultList.get(recordI).get("PROFESSIONAL_SEGMENTATION"));
			pre.setString(3, (String) resultList.get(recordI).get("TRANSFORMATION_PURPOSE"));
			pre.setString(4, (String) resultList.get(recordI).get("PROFESSIONAL_INVEST_DIRECTION"));
			pre.setString(5, (String) resultList.get(recordI).get("RECOMMENDATION_BASIS"));
			pre.setInt(6,Integer.parseInt( resultList.get(recordI).get("QUANTITY").toString()));
			pre.setString(7, (String) resultList.get(recordI).get("RECOMMENDATION_BASIS_INDEX"));
			pre.setString(8, (String) resultList.get(recordI).get("RECOMMENDATION_BASIS_CONTENT"));
			pre.addBatch();
			insertCount++;
			if(insertCount%20==0) {
				pre.executeBatch();
				pre.clearBatch();
				//conn.commit();
			}
		}
		pre.executeBatch();
		pre.clearBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void techProjectRecommdationBasisSplit() {

		// TODO Auto-generated method stub

		Connection conn = null;
		conn = DbUtil.getConnection();
		
		String sqlStr="SELECT  " + 
				"A.PROFESSIONAL_CATEGORY, " + 
				"A.PROFESSIONAL_SEGMENTATION, " + 
				"A.TRANSFORMATION_PURPOSE, " + 
				"A.PROFESSIONAL_INVEST_DIRECTION, " + 
				" A.RECOMMENDATION_BASIS,  " + 
				"COUNT(*) QUANTITY  " + 
				"FROM  " + 
				"( " + 
				"SELECT  " + 
				"A.PROFESSIONAL_CATEGORY, " + 
				"A.PROFESSIONAL_SEGMENTATION, " + 
				"A.TRANSFORMATION_PURPOSE, " + 
				"CAST(A.RECOMMENDATION_BASIS AS NVARCHAR2(1000))RECOMMENDATION_BASIS, " + 
				"A.PROFESSIONAL_INVEST_DIRECTION " + 
				"FROM  " + 
				"ORI_TECH_TRANSFORM_ROUGH_TABLE A  " + 
				"WHERE  " + 
				"DATA_VERSION='O_2021_2' " + 
				") A " + 
				"GROUP BY " + 
				"A.PROFESSIONAL_CATEGORY, " + 
				"A.PROFESSIONAL_SEGMENTATION, " + 
				"A.TRANSFORMATION_PURPOSE, " + 
				"A.PROFESSIONAL_INVEST_DIRECTION, " + 
				" A.RECOMMENDATION_BASIS   " + 
				"ORDER BY " + 
				"A.PROFESSIONAL_CATEGORY, " + 
				"A.PROFESSIONAL_SEGMENTATION, " + 
				"A.TRANSFORMATION_PURPOSE, " + 
				"A.PROFESSIONAL_INVEST_DIRECTION, " + 
				"A.RECOMMENDATION_BASIS ";

		PreparedStatement pre = null;
		// 创建一个结果集对象
		ResultSet result = null;
		List<Map> resultList=new ArrayList<Map>();
		try {
			pre = conn.prepareStatement(sqlStr);
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			/**
			 * 通过正则(([0-9]+\\.)([0-9]+\\.)+([0-9]+)),将技改依据拆分，得到所引用的所有技改依据的内容部分
			 * 注意：在正则表达式中“.”表示“匹配除换行符\n之外的任何字单字符。要匹配.，需要使用\”，而写成“\.”是会报错的，只有写成“\\.”才是正确的。
			 */
			Pattern pattern=Pattern.compile("(([0-9]+\\.)([0-9]+\\.)+([0-9]+))");
			Matcher matcher = null;
			while (result.next()) {  
				String professionalCategory= result.getString("PROFESSIONAL_CATEGORY");
				String professionalSegmentation= result.getString("PROFESSIONAL_SEGMENTATION");
				String transformationPurpose= result.getString("TRANSFORMATION_PURPOSE");
				String professionalInvestDirection= result.getString("PROFESSIONAL_INVEST_DIRECTION");
				//System.out.println("professionalInvestDirection:"+professionalInvestDirection);
				String recommendationBasis= result.getString("RECOMMENDATION_BASIS");
				String quantity=  result.getString("QUANTITY"); 
				List<String> recommendationBasisIndexList=new ArrayList<String>();
				List<String> recommendationBasisContentList=new ArrayList<String>();
				//System.out.println("recommendationBasis:"+recommendationBasis);
				if(recommendationBasis!=null) { 
					/**
					 * 通过正则(([0-9]+\\.)([0-9]+\\.)+([0-9]+)),将技改依据拆分，得到所引用的所有技改依据的内容部分
					 * 进行匹配时会出现一个为空的字符串，为普遍现象。
					 * 注意：在正则表达式中“.”表示“匹配除换行符\n之外的任何字单字符。要匹配.，需要使用\”，而写成“\.”是会报错的，只有写成“\\.”才是正确的。
					 */
					String [] recommendationBasisSub =recommendationBasis.split("(([0-9]+\\.)([0-9]+\\.)+([0-9]+))");
					/**
					 * 通过循环将技改依据存入recommendationBasisContentList
					 */
					int contentI=0;
					for(int i=0;i<recommendationBasisSub.length;i++) { 
						if(recommendationBasisSub[i].trim()!=null && !recommendationBasisSub[i].trim().isEmpty()) {
						//System.out.println("recommendationBasisSub["+i+"]:"+recommendationBasisSub[i].trim());
						recommendationBasisContentList.add(contentI,recommendationBasisSub[i].trim());
						}
					}
					/**
					 * 通过正则(([0-9]+\\.)([0-9]+\\.)+([0-9]+)),将技改依据拆获取不同技改依据的编号，
					 * 并将通过循环技改依据的编号存入recommendationBasisIndexList中。
					 * 注意：在正则表达式中“.”表示“匹配除换行符\n之外的任何字单字符。要匹配.，需要使用\”，而写成“\.”是会报错的，只有写成“\\.”才是正确的。
					 */
					matcher=pattern.matcher(recommendationBasis); 
					int recI=0;
					while(matcher.find()) {
						//System.out.println(matcher.group()); 
						recommendationBasisIndexList.add(recI, matcher.group());
						recI++;
					}
					//System.out.println("recommendationBasisIndexList.size="+recommendationBasisIndexList.size());
					//System.out.println("recommendationBasisContentList.size="+recommendationBasisContentList.size());
					for(int basisI=0;basisI<recommendationBasisIndexList.size();basisI++) { 
						Map recordMap =new HashMap();
						recordMap.put("PROFESSIONAL_CATEGORY", professionalCategory);
						recordMap.put("PROFESSIONAL_SEGMENTATION", professionalSegmentation);
						recordMap.put("TRANSFORMATION_PURPOSE", transformationPurpose);
						recordMap.put("PROFESSIONAL_INVEST_DIRECTION", professionalInvestDirection);
						recordMap.put("RECOMMENDATION_BASIS", recommendationBasis);
						recordMap.put("QUANTITY", quantity);
						recordMap.put("RECOMMENDATION_BASIS_INDEX", recommendationBasisIndexList.get(basisI));
						recordMap.put("RECOMMENDATION_BASIS_CONTENT", recommendationBasisContentList.get(basisI));
						resultList.add(recordMap); 
					}
				}else { 
					Map recordMap =new HashMap();
					recordMap.put("PROFESSIONAL_CATEGORY", professionalCategory);
					recordMap.put("PROFESSIONAL_SEGMENTATION", professionalSegmentation);
					recordMap.put("TRANSFORMATION_PURPOSE", transformationPurpose);
					recordMap.put("PROFESSIONAL_INVEST_DIRECTION", professionalInvestDirection);
					recordMap.put("RECOMMENDATION_BASIS", recommendationBasis);
					recordMap.put("QUANTITY", quantity); 
					recordMap.put("RECOMMENDATION_BASIS_INDEX", "");
					recordMap.put("RECOMMENDATION_BASIS_CONTENT", "");
					resultList.add(recordMap); 
				}
			}
		String insertSql="INSERT INTO DV_TECH_INVE_DIRECT_RECO_BASIS(PROFESSIONAL_CATEGORY,	"
				+ "PROFESSIONAL_SEGMENTATION,	TRANSFORMATION_PURPOSE,	PROFESSIONAL_INVEST_DIRECTION,	"
				+ "RECOMMENDATION_BASIS,	QUANTITY,	"
				+ "RECOMMENDATION_BASIS_INDEX,	RECOMMENDATION_BASIS_CONTENT"
				+ ")VALUES(?,?,?,?,?,?,?,?)";
		pre = conn.prepareStatement(insertSql);
		int reslutListSize=resultList.size();
		int insertCount=0;
		System.out.println("reslutListSize="+reslutListSize);
		for(int recordI=0;recordI<reslutListSize;recordI++) {
			//System.out.println("PROFESSIONAL_CATEGORY="+(String) resultList.get(recordI).get("PROFESSIONAL_CATEGORY"));
			pre.setString(1, (String) resultList.get(recordI).get("PROFESSIONAL_CATEGORY"));
			pre.setString(2, (String) resultList.get(recordI).get("PROFESSIONAL_SEGMENTATION"));
			pre.setString(3, (String) resultList.get(recordI).get("TRANSFORMATION_PURPOSE"));
			pre.setString(4, (String) resultList.get(recordI).get("PROFESSIONAL_INVEST_DIRECTION"));
			pre.setString(5, (String) resultList.get(recordI).get("RECOMMENDATION_BASIS"));
			pre.setInt(6,Integer.parseInt( resultList.get(recordI).get("QUANTITY").toString()));
			pre.setString(7, (String) resultList.get(recordI).get("RECOMMENDATION_BASIS_INDEX"));
			pre.setString(8, (String) resultList.get(recordI).get("RECOMMENDATION_BASIS_CONTENT"));
			pre.addBatch();
			insertCount++;
			if(insertCount%20==0) {
				pre.executeBatch();
				pre.clearBatch();
				//conn.commit();
			}
		}
		pre.executeBatch();
		pre.clearBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
