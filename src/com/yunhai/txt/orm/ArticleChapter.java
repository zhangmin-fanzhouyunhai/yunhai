package com.yunhai.txt.orm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="articlechapter")//prefix不能使用驼峰,不能使用下划线，需要小写
@Table(name="ARTICLE_CHAPTER")
@GenericGenerator(name="jpa-uuid",strategy="uuid")
public class ArticleChapter {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 100)
    private String articleChapterID;
    private String articleID;
    private String articleChapterContent;
    private Double sortIndex;
    private String description;

    public ArticleChapter() {

    }
    public ArticleChapter(String articleChapterID) {
        this.articleChapterID = articleChapterID;
    }

    public ArticleChapter(String articleChapterID, String articleID, String articleChapterContent, Double sortIndex, String description) {
        this.articleChapterID = articleChapterID;
        this.articleID = articleID;
        this.articleChapterContent = articleChapterContent;
        this.sortIndex = sortIndex;
        this.description = description;
    }

    public String getArticleChapterID() {
        return articleChapterID;
    }

    public void setArticleChapterID(String articleChapterID) {
        this.articleChapterID = articleChapterID;
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getArticleChapterContent() {
        return articleChapterContent;
    }

    public void setArticleChapterContent(String articleChapterContent) {
        this.articleChapterContent = articleChapterContent;
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
}

