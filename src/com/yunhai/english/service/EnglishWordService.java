package com.yunhai.english.service;

import java.util.List;

import com.yunhai.dao.ChinesWordDao;
import com.yunhai.english.dao.EnglishWordDao;
import com.yunhai.english.orm.EnglishWord;
import com.yunhai.orm.WordChinese;

public class EnglishWordService {
public void addEnglishWord(String serverCode,EnglishWord englisWord) {
	new EnglishWordDao().addEnglishWord(serverCode,englisWord);
}

public List<EnglishWord> queryWordListWithLimitNum(int wordNum, String serveCode) {
	// TODO Auto-generated method stub
	List<EnglishWord> wordList=new EnglishWordDao().queryWordListWithLimitNum(wordNum,serveCode);
	return wordList;
}
}
