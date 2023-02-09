package com.yunhai.otherWebSite.Service;

import java.util.List;

import com.yunhai.otherWebSite.dao.EncylopediaThinkTankWebSiteDao;
import com.yunhai.otherWebSite.orm.WebContent;

public class EncylopediaThinkTankWebSiteService {

	public List<WebContent> queryWebSiteAndLocalWebFile(String serverCode) {
		// TODO Auto-generated method stub
		List<WebContent> webContentList=  new EncylopediaThinkTankWebSiteDao().queryWebSiteAndLocalWebFile(serverCode);
		 return webContentList;
	}

	public void webDownload(String webSiteName, String webSite,String pythonFile, String relativePath, String storagePath) {
		// TODO Auto-generated method stub
		new EncylopediaThinkTankWebSiteDao().webDownload( webSiteName, webSite,pythonFile, relativePath, storagePath);
	}

}
