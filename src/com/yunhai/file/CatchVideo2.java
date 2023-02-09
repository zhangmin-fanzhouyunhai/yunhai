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
 * ��ȡ��Ƶ(MP4����)
 * 
 * @author Zzh
 *
 */
public class CatchVideo2 {

	/** ��Ƶ���� */
	private static String videoName;

	/** ��Ƶǰ׺ */
	private static String videoPathPrefix;

	/** �������ڸ�ʽ */
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * ������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(df.format(new Date()) + ":��ʼ׼�����ء�");
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
		CloseableHttpClient httpClient = HttpClients.createDefault();// ����httpClient
		//HttpGet httpGet = new HttpGet("http://www.cnblogs.com/");// ����httpgetʵ��
		HttpGet httpGet = new HttpGet(url);// ����httpgetʵ��
		CloseableHttpResponse response;
		response = httpClient.execute(httpGet);
		org.apache.http.HttpEntity entity = (HttpEntity) response.getEntity();// ��ȡ����ʵ��
		String content = EntityUtils.toString(entity, "utf-8");// ��ҳ����

		response.close();// �ر������ͷ�ϵͳ��Դ

		Jsoup.parse(content);

		Document doc = Jsoup.parse(content);// ������ҳ�õ��ĵ�����

		Elements elements = doc.getElementsByTag("title");// ��ȡtag��title������dom�ĵ�

		Element element = elements.get(0);// ��ȡ��һ��Ԫ��

		String title = element.text(); // .html�Ƿ���html

		System.out.println("��ҳ���⣺" + title);

		Element element1 = doc.getElementById("header-top");// ��ȡid=site_nav_top��ǩ header-top

		String str = element1.text();

		System.out.println("str:" + str);
	}

	private static void test() {
		// ��ַ��
		List<String> downLoadUrls = new ArrayList<String>();
		String htmlUrl = "http://www.yhdm.tv/show/1014.html";
		htmlUrl = "https://www.blwdy.com/vod-play-id-63077-src-10-num-1.html";
		// ��Ƶ����ҳ��
		String htmlmain = getHtml(htmlUrl);
		// ��ȡÿ��ҳ��ĵ�ַ
		List<String> urls = parseHtmlMain(htmlmain);
		// List<String> urls = parseHtmlMain(htmlUrl);

		String mainurl = "http://www.yhdm.tv";
		mainurl = "https://www.blwdy.com/vod-play-id-63077-src-10-num-1.html";
		for (String url : urls) {
			// ÿ���������ŵ�ַ
			String html = getHtml(mainurl + url);
			String downLoadUrl = parseHtml(html);
			downLoadUrls.add(downLoadUrl);
		}

		httpDownload(downLoadUrls);
	}

	/**
	 * ��ȡ��ҳhtml����
	 * 
	 * @param ��ַ
	 */
	private static String getHtml(String path) {

		System.out.println(df.format(new Date()) + " ��ȡ��" + path + "��ҳ����롣");
		// ��������html�ĵ�������
		StringBuffer html = new StringBuffer();

		try {
			// ����һ��url��ַ������
			URL url = new URL(path);
			URLConnection connection = url.openConnection();

			// ��ȡ��ҳ��������
			InputStream input = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(input, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(reader);
			// �������һ�ȡInputStream�о�������ݣ��������������̨
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				// �����ж�����ÿ����Ϣline׷�ӵ���ƴ�ӵ���html������
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
	 * ��ȡ����
	 * 
	 * @param HTML����
	 * @return ��Ƶ��ַ
	 */
	private static List<String> parseHtmlMain(String html) {

		System.out.println(df.format(new Date()) + ":��ȡ������");
		Document document = Jsoup.parse(html);
		// ��ȡidΪmain0��Ԫ��
		// Element mainEle = document.getElementById("header-top");
		Elements mainEle = document.getElementsByTag("ul");
		Elements urlLinks = mainEle.get(0).getElementsByTag("a");
		List<String> urls = new ArrayList<String>();
		// ÿ����ַ���
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
		// ��Ƶ��
		videoName = videoNameH1.get(0).text().replace(":", "").replace("/", "").replace("\\", "").replace("*", "")
				.replace("?", "").replace("|", "").replace("<", "").replace(">", "");

		return urls;
	}

	/**
	 * ����HTML
	 * 
	 * @param HTML����
	 * @return ��Ƶ��ַ
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
	 * ������Ƶ
	 * 
	 * @param ��Ƶ��ַ��
	 */
	public static boolean httpDownload(List<String> httpUrls) {

		// ����·��
		String saveFile = "D:\\��Ƶ\\" + videoName;
		String saveFileVideo = "D:\\��Ƶ\\" + videoName + "\\" + videoName;
		System.out.println(df.format(new Date()) + ":��ַ����ȡ���׼����ʼ���ء�");
		int i = 0;

		for (String httpUrl : httpUrls) {
			// �ϳ���MAP
			HashMap<Integer, String> keyFileMap = new HashMap<Integer, String>();
			// ���������ļ�
			String indexStr = getIndexFile(httpUrl);
			// ���������ļ�
			List<String> videoUrlsList = analysisIndex(indexStr);
			i++;
			int j = 0;
			for (String videoUrl : videoUrlsList) {
				try {
					j++;
					int byteRead;
					URL url;
					// �����ļ�
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

						// д���ļ�
						String st_saveFilename = "";
						st_saveFilename = saveFile + "\\" + videoName + i + "_" + j + ".mp4";
						File file_saveFilename = new File(st_saveFilename);
						if (!file_saveFilename.exists()) {
							// ��ȡ����
							URLConnection conn = url.openConnection();
							HttpURLConnection httpURLConnection = (HttpURLConnection) conn;
							httpURLConnection.setInstanceFollowRedirects(false);
							// ������
							InputStream inStream = httpURLConnection.getInputStream();
							FileOutputStream fs = new FileOutputStream(st_saveFilename);

							byte[] buffer = new byte[1024];
							while ((byteRead = inStream.read(buffer)) != -1) {
								fs.write(buffer, 0, byteRead);
							}
							inStream.close();
							fs.close();
							System.out.println(videoName + "��" + i + "��" + j + "Ƭ�����غ���");
						} else {
							System.out.println(videoName + "��" + i + "��" + j + "Ƭ���Ѵ���");
						}
						keyFileMap.put(j - 1, st_saveFilename);
					} catch (FileNotFoundException e) {
						System.out.println(videoName + "��" + i + "��" + j + "Ƭ�β�����");
					}
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println(videoName + "��" + i + "��" + j + "Ƭ�γ�ʱ");
				}
			}
			// �ϳ���ƵƬ��
			composeFile(saveFileVideo + "\\" + videoName + i + ".mp4", keyFileMap);
			System.out.println(df.format(new Date()) + ":" + videoName + i + "�����");
		}
		return true;
	}

	/**
	 * ��������
	 * 
	 * @param content
	 */
	public static String getIndexFile(String urlpath) {
		try {
			URL url = new URL(urlpath);

			// ������Դ
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
			// ת��Ϊ��ȡ���������ļ���ַ
			urlpath = urlpath.replace("index.m3u8", "") + content.replace(indexUrl, "");
			// ��ȡ��Ƶ����Ŀ¼
			videoPathPrefix = urlpath.replace("index.m3u8", "").replace("\n", "");
			// ��ȡ����
			URL url2 = new URL(urlpath);
			URLConnection conn2 = url2.openConnection();
			HttpURLConnection httpURLConnection2 = (HttpURLConnection) conn2;
			httpURLConnection2.setInstanceFollowRedirects(false);

			try {
				// ������
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
				System.out.println(videoName + "���Ӵ���");
			}

			return content;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��������
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
	 * ��ƵƬ�κϳ�
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
			System.out.println("��Ƶ�ϳ�ʧ��");
		}
	}
}
