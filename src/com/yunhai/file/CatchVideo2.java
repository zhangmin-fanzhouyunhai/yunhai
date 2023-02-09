package com.yunhai.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import org.springframework.http.HttpEntity;

//import com.sun.jersey.server.wadl.generators.resourcedoc.xhtml.Elements;

//import com.sun.jersey.server.wadl.generators.resourcedoc.xhtml.Elements;

/**
 * 
 * 获取视频(MP4类型)
 * 
 * @author Zzh
 *
 */
public class CatchVideo2 {

	/** 视频名称 */
	private static String videoName;

	/** 视频前缀 */
	private static String videoPathPrefix;

	/** 设置日期格式 */
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 主程序
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(df.format(new Date()) + ":开始准备下载。");
		String htmlUrl = "https://www.blwdy.com/vod-play-id-63077-src-10-num-1.html";

		try {
			praseHtml(htmlUrl);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void praseHtml(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();// 创建httpClient
		//HttpGet httpGet = new HttpGet("http://www.cnblogs.com/");// 创建httpget实例
		HttpGet httpGet = new HttpGet(url);// 创建httpget实例
		CloseableHttpResponse response;
		response = httpClient.execute(httpGet);
		org.apache.http.HttpEntity entity = (HttpEntity) response.getEntity();// 获取返回实体
		String content = EntityUtils.toString(entity, "utf-8");// 网页内容

		response.close();// 关闭流和释放系统资源

		Jsoup.parse(content);

		Document doc = Jsoup.parse(content);// 解析网页得到文档对象

		Elements elements = doc.getElementsByTag("title");// 获取tag是title的所有dom文档

		Element element = elements.get(0);// 获取第一个元素

		String title = element.text(); // .html是返回html

		System.out.println("网页标题：" + title);

		Element element1 = doc.getElementById("header-top");// 获取id=site_nav_top标签 header-top

		String str = element1.text();

		System.out.println("str:" + str);
	}

	private static void test() {
		// 地址集
		List<String> downLoadUrls = new ArrayList<String>();
		String htmlUrl = "http://www.yhdm.tv/show/1014.html";
		htmlUrl = "https://www.blwdy.com/vod-play-id-63077-src-10-num-1.html";
		// 视频的主页面
		String htmlmain = getHtml(htmlUrl);
		// 获取每集页面的地址
		List<String> urls = parseHtmlMain(htmlmain);
		// List<String> urls = parseHtmlMain(htmlUrl);

		String mainurl = "http://www.yhdm.tv";
		mainurl = "https://www.blwdy.com/vod-play-id-63077-src-10-num-1.html";
		for (String url : urls) {
			// 每集真正播放地址
			String html = getHtml(mainurl + url);
			String downLoadUrl = parseHtml(html);
			downLoadUrls.add(downLoadUrl);
		}

		httpDownload(downLoadUrls);
	}

	/**
	 * 获取网页html代码
	 * 
	 * @param 网址
	 */
	private static String getHtml(String path) {

		System.out.println(df.format(new Date()) + " 获取：" + path + "，页面代码。");
		// 保存整个html文档的数据
		StringBuffer html = new StringBuffer();

		try {
			// 发起一个url网址的请求
			URL url = new URL(path);
			URLConnection connection = url.openConnection();

			// 获取网页的数据流
			InputStream input = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(input, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(reader);
			// 解析并且获取InputStream中具体的数据，并且输出到控制台
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				// 将所有读到的每行信息line追加到（拼接到）html对象上
				html.append(line);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return html.toString();
	}

	/**
	 * 获取集数
	 * 
	 * @param HTML内容
	 * @return 视频地址
	 */
	private static List<String> parseHtmlMain(String html) {

		System.out.println(df.format(new Date()) + ":获取集数。");
		Document document = Jsoup.parse(html);
		// 获取id为main0的元素
		// Element mainEle = document.getElementById("header-top");
		Elements mainEle = document.getElementsByTag("ul");
		Elements urlLinks = mainEle.get(0).getElementsByTag("a");
		List<String> urls = new ArrayList<String>();
		// 每集地址添加
		for (Element urlLink : urlLinks) {
			String name = urlLink.html();
			System.out.println("Url name" + name);
			if (name.contains("CM") || name.contains("PV")) {
				continue;
			}
			urlLink.attr("href");
			urls.add(urlLink.attr("href"));
		}
		Elements videoNameH1 = document.getElementsByTag("h1");
		// 视频名
		videoName = videoNameH1.get(0).text().replace(":", "").replace("/", "").replace("\\", "").replace("*", "")
				.replace("?", "").replace("|", "").replace("<", "").replace(">", "");

		return urls;
	}

	/**
	 * 解析HTML
	 * 
	 * @param HTML内容
	 * @return 视频地址
	 */
	private static String parseHtml(String html) {
		Document document = Jsoup.parse(html);
		Element dplayer = document.getElementById("play_1");
		String videoUrl = dplayer.attr("onclick");
		videoUrl = videoUrl.replace("changeplay('", "");
		videoUrl = videoUrl.replace("$mp4');", "");

		return videoUrl;
	}

	/**
	 * 下载视频
	 * 
	 * @param 视频地址集
	 */
	public static boolean httpDownload(List<String> httpUrls) {

		// 设置路径
		String saveFile = "D:\\视频\\" + videoName;
		String saveFileVideo = "D:\\视频\\" + videoName + "\\" + videoName;
		System.out.println(df.format(new Date()) + ":地址集获取完毕准备开始下载。");
		int i = 0;

		for (String httpUrl : httpUrls) {
			// 合成用MAP
			HashMap<Integer, String> keyFileMap = new HashMap<Integer, String>();
			// 下载索引文件
			String indexStr = getIndexFile(httpUrl);
			// 解析索引文件
			List<String> videoUrlsList = analysisIndex(indexStr);
			i++;
			int j = 0;
			for (String videoUrl : videoUrlsList) {
				try {
					j++;
					int byteRead;
					URL url;
					// 创建文件
					File file = new File(saveFile);
					if (!file.exists()) {
						file.getParentFile().mkdir();
						file.mkdirs();
					}

					File fileVideo = new File(saveFileVideo);
					if (!fileVideo.exists()) {
						fileVideo.getParentFile().mkdir();
						fileVideo.mkdirs();
					}

					try {
						url = new URL(videoPathPrefix + videoUrl);
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
						continue;
					}

					try {

						// 写入文件
						String st_saveFilename = "";
						st_saveFilename = saveFile + "\\" + videoName + i + "_" + j + ".mp4";
						File file_saveFilename = new File(st_saveFilename);
						if (!file_saveFilename.exists()) {
							// 获取链接
							URLConnection conn = url.openConnection();
							HttpURLConnection httpURLConnection = (HttpURLConnection) conn;
							httpURLConnection.setInstanceFollowRedirects(false);
							// 输入流
							InputStream inStream = httpURLConnection.getInputStream();
							FileOutputStream fs = new FileOutputStream(st_saveFilename);

							byte[] buffer = new byte[1024];
							while ((byteRead = inStream.read(buffer)) != -1) {
								fs.write(buffer, 0, byteRead);
							}
							inStream.close();
							fs.close();
							System.out.println(videoName + "第" + i + "集" + j + "片段下载好了");
						} else {
							System.out.println(videoName + "第" + i + "集" + j + "片段已存在");
						}
						keyFileMap.put(j - 1, st_saveFilename);
					} catch (FileNotFoundException e) {
						System.out.println(videoName + "第" + i + "集" + j + "片段不存在");
					}
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println(videoName + "第" + i + "集" + j + "片段超时");
				}
			}
			// 合成视频片段
			composeFile(saveFileVideo + "\\" + videoName + i + ".mp4", keyFileMap);
			System.out.println(df.format(new Date()) + ":" + videoName + i + "集完成");
		}
		return true;
	}

	/**
	 * 下载索引
	 * 
	 * @param content
	 */
	public static String getIndexFile(String urlpath) {
		try {
			URL url = new URL(urlpath);

			// 下在资源
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String content = "";
			String line;
			String indexUrl = "";
			int i = 0;
			while ((line = in.readLine()) != null) {
				i++;
				content += line + "\n";
				if (i == 2) {
					indexUrl = content;
				}
			}
			// 转换为获取到的索引文件地址
			urlpath = urlpath.replace("index.m3u8", "") + content.replace(indexUrl, "");
			// 获取视频链接目录
			videoPathPrefix = urlpath.replace("index.m3u8", "").replace("\n", "");
			// 获取索引
			URL url2 = new URL(urlpath);
			URLConnection conn2 = url2.openConnection();
			HttpURLConnection httpURLConnection2 = (HttpURLConnection) conn2;
			httpURLConnection2.setInstanceFollowRedirects(false);

			try {
				// 输入流
				BufferedReader in2 = new BufferedReader(
						new InputStreamReader(httpURLConnection2.getInputStream(), "UTF-8"));
				String content2 = "";
				String line2;
				while ((line2 = in2.readLine()) != null) {
					content2 += line2 + "\n";
				}
				in2.close();

				return content2;
			} catch (FileNotFoundException e) {
				System.out.println(videoName + "链接错误");
			}

			return content;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析索引
	 * 
	 * @param content
	 */
	public static List<String> analysisIndex(String content) {
		Pattern pattern = Pattern.compile(".*ts");
		Matcher ma = pattern.matcher(content);

		List<String> list = new ArrayList<String>();

		while (ma.find()) {
			String s = ma.group();
			list.add(s);
		}
		return list;
	}

	/**
	 * 视频片段合成
	 * 
	 * @param fileOutPath
	 * @param keyFileMap
	 */
	public static void composeFile(String fileOutPath, HashMap<Integer, String> keyFileMap) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(fileOutPath));
			byte[] bytes = new byte[1024];
			int length = 0;
			for (int i = 0; i < keyFileMap.size(); i++) {
				String nodePath = keyFileMap.get(i);
				File file = new File(nodePath);
				if (!file.exists())
					continue;
				FileInputStream fis = new FileInputStream(file);
				while ((length = fis.read(bytes)) != -1) {
					fileOutputStream.write(bytes, 0, length);
				}
			}
		} catch (Exception e) {
			System.out.println("视频合成失败");
		}
	}
}
