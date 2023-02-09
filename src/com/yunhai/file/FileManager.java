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
		filePath = "C:\\Ѹ������";
		String suffix = "";
		String resultFile = "";
		String spiltChar = "";
		String savePath = "";
		savePath = "C:\\Ѹ������\\1";
		spiltChar = "_";
		suffix = ".ts";
		HashMap<Integer, String> fileNameMap = (HashMap<Integer, String>) renameFile(filePath, suffix, spiltChar,
				savePath);

		for (int i = 0; i < fileNameMap.size(); i++) {
			System.out.println("The new file name of " + i + "'s file is:" + fileNameMap.get(i));
		}
		String composeSavePath = "";
		composeSavePath = "C:\\Ѹ������\\���";
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
	 * �Էָ���spiltCharΪ�ָ��㣬��filePath·���µ��ļ�������������
	 * 
	 * @param filePath  �ļ����·��
	 * @param suffix    ��Ƶ�ļ���׺
	 * @param spiltChar �ļ����к����׺�ļ������ַ����ķָ�����
	 * @return �����޸ĺ����Ƶ�ļ���Map�б������ļ����·�����ļ�����
	 * @throws IOException
	 */
	public static Map<Integer, String> renameFile(String filePath, String suffix, String spiltChar, String savePath)
			throws IOException {
		Map<Integer, String> fileNameMap = new HashMap<Integer, String>();
		// ��ʼ�� �ҵ��ļ���
		File file = new File(filePath);
		// �����ļ������������
		File[] listFiles = file.listFiles();
		// ��������
		for (File file2 : listFiles) {
			String newFileName = "";
			// �ҵ��ļ�
			if (file2.getName().endsWith(suffix)) {
				copyFile(file2, savePath);
				// ��ӡ��һ��
				System.out.println(file2.getName());
				if (file2.getName().indexOf(spiltChar) > 0) {
					newFileName = file2.getName().substring(0, file2.getName().indexOf(spiltChar)).substring(1);
					newFileName = newFileName + suffix;
					// System.out.println(newFileName);

					// ��ʼ����Ҫ���ļ�
					File file1 = new File(savePath, file2.getName());
					// ��ʼ����Ҫ�޸ĵ��ļ�����
					File file3 = new File(savePath, newFileName);

					// �޸�
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
		// ����Ŀ�ĵ��ļ���
		File destfile = new File(dest);
		if (!destfile.exists()) {
			destfile.mkdir();
		}
		// ���source���ļ��У�����Ŀ�ĵ�ַ�д����µ��ļ���
		if (source.isDirectory()) {
			File file = new File(dest + "\\" + source.getName());// ��Ŀ�ĵ�ַ����source���ļ������ƣ������µ��ļ���
			file.mkdir();
			// �õ�source�ļ��е������ļ���Ŀ¼
			File[] files = source.listFiles();
			if (files.length == 0) {
				return;
			} else {
				for (int i = 0; i < files.length; i++) {
					copyFile(files[i], file.getPath());
				}
			}

		}
		// source���ļ��������ֽ���������������ļ�
		else if (source.isFile()) {
			FileInputStream fis = new FileInputStream(source);
			// �����µ��ļ������渴�����ݣ��ļ�������Դ�ļ�����һ��
			File dfile = new File(dest + "\\" + source.getName());
			if (!dfile.exists()) {
				dfile.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(dfile);
			// ��д����
			// ��������
			byte[] b = new byte[1024];
			// ���峤��
			int len;
			// ѭ����ȡ
			while ((len = fis.read(b)) != -1) {
				// д������
				fos.write(b, 0, len);
			}

			// �ر���Դ
			fos.close();
			fis.close();

		}
	}

	/* ʵ��ɾ���ļ��ķ��� */
	/**
	 * 
	 * @param sPath
	 * @return
	 * @throws IOException
	 */
	public static boolean deleteFile(String sPath) throws IOException {

		boolean flag = false;
		File file = new File(sPath);
		// ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��
		if (file.isFile() && file.exists()) {
			flag=file.delete();
			System.out.println("file:" + file.getName() + ",path:" + file.getPath()+",flag:"+flag);

			// file.deleteOnExit();
			flag = true;
		}
		return flag;
	}

	/**
	 * �÷�����keyFileMap�д�ŵ���Ƶ�ļ���HashMap��Integer���˳����кϲ��� ��֤�ļ�����������Ҫ�ϲ��ļ���˳�򱣳�һ�¡�
	 * ��keyFileMap�д�ŵ��ļ���0��ʼ����1���������� �ϲ�����ļ���ŵ�fileOutPut·���¡� ��ƵƬ�κϳ�
	 * 
	 * @param fileOutPath �ϲ�����Ƶ�ļ���ŵ�λ���������ļ�������
	 * @param keyFileMap  ��Ҫ�ϲ�����Ƶ�ļ����ƣ��������·�����ļ����ƣ�
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
					// fis.read(bytes)��file�ļ��а��ֽڷ�ʽ��ȡ���ݣ���������bytes�ֽ������У�
					// �����ض�ȡ�����ַ��������һλ
					// �������file�ļ������һ���򷵻�-1����ŵ�length��
					// ������뽫������bytes�ֽ������е�����д����fileOutPath�ļ���
					fileOutputStream.write(bytes, 0, length);
				}
				fis.close();//������رգ����ں����ɾ�������л��޷���Чɾ����
			}

			fileOutputStream.close();
		} catch (Exception e) {
			System.out.println("��Ƶ�ϳ�ʧ��");
		}
	}
}
