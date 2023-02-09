package com.yunhai.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FileManager {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = "";
		filePath = "C:\\迅雷下载";
		String suffix = "";
		String resultFile = "";
		String spiltChar = "";
		String savePath = "";
		savePath = "C:\\迅雷下载\\1";
		spiltChar = "_";
		suffix = ".ts";
		HashMap<Integer, String> fileNameMap = (HashMap<Integer, String>) renameFile(filePath, suffix, spiltChar,
				savePath);

		for (int i = 0; i < fileNameMap.size(); i++) {
			System.out.println("The new file name of " + i + "'s file is:" + fileNameMap.get(i));
		}
		String composeSavePath = "";
		composeSavePath = "C:\\迅雷下载\\结果";
		resultFile = composeSavePath + "\\result" + new Date().toLocaleString().replace(" ", "-").replace(":", "-")
				+ ".ts";
		System.out.println("resultFile=" + resultFile);
		composeFile(resultFile, fileNameMap);
		for (int i = 0; i < fileNameMap.size(); i++) {
			// System.out.println("Delete "+fileNameMap.get(i)+";");
			deleteFile(fileNameMap.get(i));
		}
	}

	/**
	 * 以分隔符spiltChar为分隔点，将filePath路径下的文件进行重命名。
	 * 
	 * @param filePath  文件存放路径
	 * @param suffix    视频文件后缀
	 * @param spiltChar 文件序列号与后缀文件名称字符串的分隔符号
	 * @return 返回修改后的视频文件的Map列表，包含文件存放路径与文件名称
	 * @throws IOException
	 */
	public static Map<Integer, String> renameFile(String filePath, String suffix, String spiltChar, String savePath)
			throws IOException {
		Map<Integer, String> fileNameMap = new HashMap<Integer, String>();
		// 初始化 找到文件夹
		File file = new File(filePath);
		// 返回文件夹里面的内容
		File[] listFiles = file.listFiles();
		// 遍历出来
		for (File file2 : listFiles) {
			String newFileName = "";
			// 找到文件
			if (file2.getName().endsWith(suffix)) {
				copyFile(file2, savePath);
				// 打印看一下
				System.out.println(file2.getName());
				if (file2.getName().indexOf(spiltChar) > 0) {
					newFileName = file2.getName().substring(0, file2.getName().indexOf(spiltChar)).substring(1);
					newFileName = newFileName + suffix;
					// System.out.println(newFileName);

					// 初始化需要的文件
					File file1 = new File(savePath, file2.getName());
					// 初始化我要修改的文件名字
					File file3 = new File(savePath, newFileName);

					// 修改
					file1.renameTo(file3);
				}
				// System.out.println("index of "+(newFileName.indexOf("ts")-1)+",lastIndexof
				// "+(newFileName.lastIndexOf("ts")-1));
				// System.out.println("index:"+Integer.parseInt(newFileName.substring(0,
				// newFileName.indexOf(suffix))));
				fileNameMap.put(Integer.parseInt(newFileName.substring(0, newFileName.lastIndexOf(suffix))),
						savePath + "\\" + newFileName);
			}
		}
		return fileNameMap;
	}

	/**
	 * 
	 * @param source
	 * @param dest
	 * @throws IOException
	 */
	public static void copyFile(File source, String dest) throws IOException {
		// 创建目的地文件夹
		File destfile = new File(dest);
		if (!destfile.exists()) {
			destfile.mkdir();
		}
		// 如果source是文件夹，则在目的地址中创建新的文件夹
		if (source.isDirectory()) {
			File file = new File(dest + "\\" + source.getName());// 用目的地址加上source的文件夹名称，创建新的文件夹
			file.mkdir();
			// 得到source文件夹的所有文件及目录
			File[] files = source.listFiles();
			if (files.length == 0) {
				return;
			} else {
				for (int i = 0; i < files.length; i++) {
					copyFile(files[i], file.getPath());
				}
			}

		}
		// source是文件，则用字节输入输出流复制文件
		else if (source.isFile()) {
			FileInputStream fis = new FileInputStream(source);
			// 创建新的文件，保存复制内容，文件名称与源文件名称一致
			File dfile = new File(dest + "\\" + source.getName());
			if (!dfile.exists()) {
				dfile.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(dfile);
			// 读写数据
			// 定义数组
			byte[] b = new byte[1024];
			// 定义长度
			int len;
			// 循环读取
			while ((len = fis.read(b)) != -1) {
				// 写出数据
				fos.write(b, 0, len);
			}

			// 关闭资源
			fos.close();
			fis.close();

		}
	}

	/* 实现删除文件的方法 */
	/**
	 * 
	 * @param sPath
	 * @return
	 * @throws IOException
	 */
	public static boolean deleteFile(String sPath) throws IOException {

		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			flag=file.delete();
			System.out.println("file:" + file.getName() + ",path:" + file.getPath()+",flag:"+flag);

			// file.deleteOnExit();
			flag = true;
		}
		return flag;
	}

	/**
	 * 该方法对keyFileMap中存放的视频文件按HashMap中Integer类的顺序进行合并， 保证文件的名称与需要合并文件的顺序保持一致。
	 * 即keyFileMap中存放的文件从0开始，按1步长增长。 合并后的文件存放到fileOutPut路径下。 视频片段合成
	 * 
	 * @param fileOutPath 合并后视频文件存放的位置与生成文件的名称
	 * @param keyFileMap  需要合并的视频文件名称（包含存放路径与文件名称）
	 */
	public static void composeFile(String fileOutPath, HashMap<Integer, String> keyFileMap) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(fileOutPath));
			byte[] bytes = new byte[1024];
			int length = 0;
			FileInputStream fis = null;
			for (int i = 0; i < keyFileMap.size(); i++) {
				String nodePath = keyFileMap.get(i);
				File file = new File(nodePath);
				if (!file.exists())
					continue;
				fis = new FileInputStream(file);
				// System.out.println("file bytes size is :" + fis.available());
				while ((length = fis.read(bytes)) != -1) {
					// fis.read(bytes)从file文件中按字节方式读取数据，并缓存至bytes字节数组中，
					// 并返回读取到的字符数的最后一位
					// 如果到达file文件的最后一个则返回-1，存放到length。
					// 下面代码将缓存至bytes字节数组中的数据写入至fileOutPath文件中
					fileOutputStream.write(bytes, 0, length);
				}
				fis.close();//如果不关闭，则在后面的删除过程中会无法有效删除。
			}

			fileOutputStream.close();
		} catch (Exception e) {
			System.out.println("视频合成失败");
		}
	}
}
