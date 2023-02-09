package com.yunhai.otherWebSite.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.yunhai.otherWebSite.orm.WebContent;
import com.yunhai.util.CommenHibernateUtil;

public class EncylopediaThinkTankWebSiteDao {

	public List<WebContent> queryWebSiteAndLocalWebFile(String serverCode) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String sql = "select * from web_content order by create_date desc";

				Session session = CommenHibernateUtil.getSession(serverCode);
				SQLQuery query = session.createSQLQuery(sql).addEntity(WebContent.class); 
				List<WebContent> webContentList = query.list();  
				session.close();
				return webContentList;
	}

	public void webDownload(String webSiteName, String webSite,String pythonFile, String relativePath, String storagePath) {
		// TODO Auto-generated method stub
		String[] pythonCmds=new String[] {"python",pythonFile, String.valueOf(webSiteName),String.valueOf(webSite),String.valueOf(relativePath),String.valueOf(storagePath)};
		//System.out.println("webSiteName:"+webSiteName);
		//System.out.println("webSite:"+webSite);
		//System.out.println("storagePath:"+storagePath);
		try {
			Process proc=Runtime.getRuntime().exec(pythonCmds);
			//System.out.println("pythonCmds:"+pythonCmds);
			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		    String line = null;
		    while ((line = in.readLine()) != null) {
		        System.out.println(line);
		    }
		    in.close();
		    try {
				proc.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
