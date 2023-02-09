package com.yunhai.txt.orm;

public class Article {
	private String articleID;
	private String authorID;
	private String articleName;
	private Double sortIndex;
	private String description;

	public Article() {
		
	}
	
	public Article(String articleID, String authorID, String articleName, Double sortIndex, String description) {
		
		this.articleID = articleID;
		this.authorID = authorID;
		this.articleName = articleName;
		this.sortIndex = sortIndex;
		this.description = description;
	}

	public String getAuthorID() {
		return authorID;
	}

	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public Double getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(Double sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArticleID() {
		return articleID;
	}

	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

}
