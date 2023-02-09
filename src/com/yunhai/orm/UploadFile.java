package com.yunhai.orm;

import java.io.File;
import java.net.URI;

public class UploadFile extends File {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7841986605443531664L;
	private String fileName = ""; 
	private String path ="";
	public UploadFile(String fileName, String pathname,String path, String child) {
		super(pathname);
		this.path = path;
		this.fileName = fileName;
	}
	public UploadFile(File parent, String child) {
		super(parent, child);
		// TODO Auto-generated constructor stub
	}
	public UploadFile(String parent, String child) {
		super(parent, child);
		// TODO Auto-generated constructor stub
	}
	public UploadFile(String pathname) {
		super(pathname);
		// TODO Auto-generated constructor stub
	}
	public UploadFile(URI uri) {
		super(uri);
		// TODO Auto-generated constructor stub
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
