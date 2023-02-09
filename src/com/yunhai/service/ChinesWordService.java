package com.yunhai.service;

import java.util.List;

import com.yunhai.dao.ChinesWordDao;
import com.yunhai.orm.WordChinese;

public class ChinesWordService {
	public void saveWords(List<String> wordList,String serveCode){
		new ChinesWordDao().saveWords(wordList,serveCode);
	}

	public List<WordChinese> queryWordListWithLimitNum(int wordNum,String serveCode) {
		// TODO Auto-generated method stub
		List<WordChinese> wordList=new ChinesWordDao().queryWordListWithLimitNum(wordNum,serveCode);
		return wordList;
	}
}
