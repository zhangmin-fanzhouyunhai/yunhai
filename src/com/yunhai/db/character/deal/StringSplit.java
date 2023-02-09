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
		String s = "4.3.4.2  ������������֮һ�Ŀ��ع񣨰����ߡ���ѹ���ع�,��ͬ��Ӧ���ż��ģ�\r\n" + 
				"1)ͨ���豸״̬�����϶�����Ե���ܡ�������������·����������SF6���塢��е���Ե����۽��Ϊ����״̬���޷�ͨ���ֳ����޽���Ŀ��ع�\r\n" + 
				"2)�ڲ����ϵ�����С�Ͷ�·����ʱ�䣨IAC�ȼ�ˮƽ���ﲻ��������׼Ҫ��Ӱ�찲ȫ���е�����ֳ�ʽ��ѹ���ع�\r\n" + 
				"3)�ۼƶ�·���ϴ����ﵽ��Ʒ���ֵ�����ۼƺϷֲ��������ﵽ��Ʒ��ƵĶ��е�����������޸���ֵ�Ŀ��ع�\r\n" + 
				"4)�ֳ��������루���ɣ����ط�բ�󣬲����������������ѹ���������۶�����������Ŀ��ع�\r\n" + 
				"5)�������װ�ù��ϡ����طŵ硢�������𡢹��ȵ�����״̬�Ŀ��ع�\r\n" + 
				"6)δ����йѹͨ���Ŀ��ع�";
		// ��Ҫƥ����ַ���д��������ʽ��Ȼ��Ҫ��ȡ���ַ�ʹ������������
		// ���������Ҫ��ȡ���һ�����֣����������ǡ�һ�����ּ��ϴ��ڵ���0���������ټ��Ͻ�������
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
		// ����һ�����������
		ResultSet result = null;
		List<Map> resultList=new ArrayList<Map>();
		try {
			pre = conn.prepareStatement(sqlStr);
			result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
			/**
			 * ͨ������(([0-9]+\\.)([0-9]+\\.)+([0-9]+)),���������ݲ�֣��õ������õ����м������ݵ����ݲ���
			 * ע�⣺��������ʽ�С�.����ʾ��ƥ������з�\n֮����κ��ֵ��ַ���Ҫƥ��.����Ҫʹ��\������д�ɡ�\.���ǻᱨ��ģ�ֻ��д�ɡ�\\.��������ȷ�ġ�
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
					 * ͨ������(([0-9]+\\.)([0-9]+\\.)+([0-9]+)),���������ݲ�֣��õ������õ����м������ݵ����ݲ���
					 * ����ƥ��ʱ�����һ��Ϊ�յ��ַ�����Ϊ�ձ�����
					 * ע�⣺��������ʽ�С�.����ʾ��ƥ������з�\n֮����κ��ֵ��ַ���Ҫƥ��.����Ҫʹ��\������д�ɡ�\.���ǻᱨ��ģ�ֻ��д�ɡ�\\.��������ȷ�ġ�
					 */
					String [] recommendationBasisSub =recommendationBasis.split("(([0-9]+\\.)([0-9]+\\.)+([0-9]+))");
					/**
					 * ͨ��ѭ�����������ݴ���recommendationBasisContentList
					 */
					int contentI=0;
					for(int i=0;i<recommendationBasisSub.length;i++) { 
						if(recommendationBasisSub[i].trim()!=null && !recommendationBasisSub[i].trim().isEmpty()) {
						//System.out.println("recommendationBasisSub["+i+"]:"+recommendationBasisSub[i].trim());
						recommendationBasisContentList.add(contentI,recommendationBasisSub[i].trim());
						}
					}
					/**
					 * ͨ������(([0-9]+\\.)([0-9]+\\.)+([0-9]+)),���������ݲ��ȡ��ͬ�������ݵı�ţ�
					 * ����ͨ��ѭ���������ݵı�Ŵ���recommendationBasisIndexList�С�
					 * ע�⣺��������ʽ�С�.����ʾ��ƥ������з�\n֮����κ��ֵ��ַ���Ҫƥ��.����Ҫʹ��\������д�ɡ�\.���ǻᱨ��ģ�ֻ��д�ɡ�\\.��������ȷ�ġ�
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
		// ����һ�����������
		ResultSet result = null;
		List<Map> resultList=new ArrayList<Map>();
		try {
			pre = conn.prepareStatement(sqlStr);
			result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
			/**
			 * ͨ������(([0-9]+\\.)([0-9]+\\.)+([0-9]+)),���������ݲ�֣��õ������õ����м������ݵ����ݲ���
			 * ע�⣺��������ʽ�С�.����ʾ��ƥ������з�\n֮����κ��ֵ��ַ���Ҫƥ��.����Ҫʹ��\������д�ɡ�\.���ǻᱨ��ģ�ֻ��д�ɡ�\\.��������ȷ�ġ�
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
					 * ͨ������(([0-9]+\\.)([0-9]+\\.)+([0-9]+)),���������ݲ�֣��õ������õ����м������ݵ����ݲ���
					 * ����ƥ��ʱ�����һ��Ϊ�յ��ַ�����Ϊ�ձ�����
					 * ע�⣺��������ʽ�С�.����ʾ��ƥ������з�\n֮����κ��ֵ��ַ���Ҫƥ��.����Ҫʹ��\������д�ɡ�\.���ǻᱨ��ģ�ֻ��д�ɡ�\\.��������ȷ�ġ�
					 */
					String [] recommendationBasisSub =recommendationBasis.split("(([0-9]+\\.)([0-9]+\\.)+([0-9]+))");
					/**
					 * ͨ��ѭ�����������ݴ���recommendationBasisContentList
					 */
					int contentI=0;
					for(int i=0;i<recommendationBasisSub.length;i++) { 
						if(recommendationBasisSub[i].trim()!=null && !recommendationBasisSub[i].trim().isEmpty()) {
						//System.out.println("recommendationBasisSub["+i+"]:"+recommendationBasisSub[i].trim());
						recommendationBasisContentList.add(contentI,recommendationBasisSub[i].trim());
						}
					}
					/**
					 * ͨ������(([0-9]+\\.)([0-9]+\\.)+([0-9]+)),���������ݲ��ȡ��ͬ�������ݵı�ţ�
					 * ����ͨ��ѭ���������ݵı�Ŵ���recommendationBasisIndexList�С�
					 * ע�⣺��������ʽ�С�.����ʾ��ƥ������з�\n֮����κ��ֵ��ַ���Ҫƥ��.����Ҫʹ��\������д�ɡ�\.���ǻᱨ��ģ�ֻ��д�ɡ�\\.��������ȷ�ġ�
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
