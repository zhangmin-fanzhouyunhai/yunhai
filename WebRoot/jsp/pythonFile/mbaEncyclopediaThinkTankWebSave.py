#!/usr/bin/env python
# coding: utf-8

# In[2]:


import os
import time
import warnings
import sys
#from gensim.models import Word2Vec

def insertIntoMysqlTable(tableName,columnList,valueList):
    import pymysql
    connect=pymysql.connect(host='localhost',
                            user='DAY13',
                            password='DAY13',
                            db='DAY13',
                            charset='utf8'
                           )
    cur=connect.cursor()
    insert_sql='insert into '+tableName+'(';
    for columnName in columnList :
        insert_sql=insert_sql+columnName+','
    insert_sql=insert_sql[0:len(insert_sql)-1]+') value('
    for columnValue in valueList :
        if isinstance(columnValue,str):
            insert_sql=insert_sql+'\''+columnValue+'\','
        else:
            insert_sql=insert_sql+str(columnValue)+','
    insert_sql=insert_sql[0:len(insert_sql)-1]+');'
    
    #print("insert_sql={}".format(insert_sql)) 
    #-----插入------
    try: 
        cur.execute(insert_sql)
    except Exception as e:
        print('插入数据失败：{}'.format(e))
    else:
        connect.commit()
        print('插入数据成功')
    #print(cur)

def mbaEncyclopediaThinkTank(web_site_name,web_site,relative_path,storage_path):
    import requests
    import datetime
    #构建日期时间
    now=datetime.datetime.now()
    nowValue=now.strftime('%Y-%m-%d_%H(Hour)_%M(Minute)_%S(Second)')
    #print("timeValue={}".format(nowValue))
    res=requests.get(web_site)
    res.encoding='utf-8'
    webText=res.text
    valueCount=webText.count('<script')
    #print("valueCount={}".format(valueCount)) 
    for i in range(valueCount):
        strStartPos=webText.index('<script')
        #print("strStartPos={}".format(strStartPos))
        strEndPos=webText.index('</script>')
        #print("strEndPos={}".format(strEndPos))
        substr=webText[strStartPos:strEndPos+9]
        #print("substr={}".format(substr))
        webText=webText.replace(substr,'')
    #timeValue=time.localtime(time.time())
    #构建文件名  
    fileName=web_site_name+'-'+nowValue+'.html'
    createDate=datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
    tableName='web_content'
    #print("tableName={}".format(tableName))
    columnList=['WEB_SITE_NAME','WEB_SITE','WEB_CONTENT_HTML','CREATE_DATE','STORAGE_PATH','SORT_INDEX','DESCRIPTION']
    #print("columnList={}".format(columnList))
    valueList=[web_site_name,web_site,fileName,createDate,relative_path,2,fileName]
    #print("storage_path={}".format(storage_path))
    insertIntoMysqlTable(tableName,columnList,valueList)
    #fileName='年金终值系数-'+nowValue+'.html'
    #创建并打开文件写入通道
    note=open(storage_path+fileName,mode='w',encoding='utf-8')
    #向文件中存入数据
    note.write(webText)
    #关闭文件写通道
    note.close()
    
if __name__ == '__main__':
    web_site_name=sys.argv[1]
    web_site=sys.argv[2]
    relative_path=sys.argv[3]
    storage_path=sys.argv[4]
    #print("relative_path={}".format(relative_path))
    mbaEncyclopediaThinkTank(web_site_name,web_site,relative_path,storage_path)


# In[ ]:




