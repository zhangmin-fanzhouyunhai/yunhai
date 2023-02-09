package com.yunhai.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author Zhang Min(����)
 * excel read utility class
 * excel��д������
 */
public class ExcelUtil {  
    private static Logger logger  = Logger.getLogger(ExcelUtil.class);  
    private final static String xls = "xls";  
    private final static String xlsx = "xlsx";  
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

      
    /** 
     * ����excel�ļ��������󷵻� 
     * @param file 
     * @throws IOException  
     */  
    public static List<String[]> readExcel(MultipartFile file) throws IOException{  
        //����ļ�  
    	fileExistsCheck(file);  
        //���Workbook����������  
        Workbook workbook = getWorkBook(file);  
        //�������ض��󣬰�ÿ���е�ֵ��Ϊһ�����飬��������Ϊһ�����Ϸ���  
        List<String[]> list = new ArrayList<String[]>();  
        if(workbook != null){  
            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){  
                //��õ�ǰsheet������  
                Sheet sheet = workbook.getSheetAt(sheetNum);  
                if(sheet == null){  
                    continue;  
                }  
                //��õ�ǰsheet�Ŀ�ʼ��  
                int firstRowNum  = sheet.getFirstRowNum();  
                //��õ�ǰsheet�Ľ�����  
                int lastRowNum = sheet.getLastRowNum();  
                //ѭ�����˵�һ�е�������  
                for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){  
                    //��õ�ǰ��  
                    Row row = sheet.getRow(rowNum);  
                    if(row == null){  
                        continue;  
                    }  
                    //��õ�ǰ�еĿ�ʼ��  
                    int firstCellNum = row.getFirstCellNum();  
                    //��õ�ǰ�е�����  
                    int lastCellNum = row.getPhysicalNumberOfCells();  
                    String[] cells = new String[row.getPhysicalNumberOfCells()];  
                    //ѭ����ǰ��  
                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){  
                        Cell cell = row.getCell(cellNum);  
                        cells[cellNum] = getCellValue(cell);  
                    }  
                    list.add(cells);  
                }  
            }  
            workbook.close();  
        }  
        return list;  
    }  
    /**
     * 
     * @param file
     * @throws IOException
             * ����ļ��Ƿ�������Ƿ�Ϊexcel�ļ���
     * Check: 
     * Does the file exist;
     * Whether the file is excel. 
     */
    public static void fileExistsCheck(MultipartFile file) throws IOException{  
        //�ж��ļ��Ƿ����  
        if(null == file){
            logger.error("file not exists!");  
            throw new FileNotFoundException("file not exists!");  
        }  
        //����ļ���  
        String fileName = file.getOriginalFilename();  
        //�ж��ļ��Ƿ���excel�ļ�  
        if(!fileName.endsWith(xls) && !fileName.endsWith(xlsx)){  
            logger.error(fileName + " is not an excel file!");  
            throw new IOException(fileName + " is not an excel file!");  
        }  
    }  
    
    
    public static Workbook getWorkBook(MultipartFile file) {  
        //����ļ���  Obtain file name.
        String fileName = file.getOriginalFilename();  
        //����Workbook���������󣬱�ʾ����excel  ,Create workbook for the excel file.
        Workbook workbook = null;  
        try {  
            //��ȡexcel�ļ���io��  
            InputStream is = file.getInputStream();  
            //�����ļ���׺����ͬ(xls��xlsx)��ò�ͬ��Workbookʵ�������  
            if(fileName.endsWith(xls)){  
                //for 2003 version
                workbook = new HSSFWorkbook(is);  
            }else if(fileName.endsWith(xlsx)){  
                //for 2007 version  
                workbook = new XSSFWorkbook(is);  
            }  
        } catch (IOException e) {  
            logger.info(e.getMessage());  
        }  
        return workbook;  
    }  
    

	/**
	 * �ж�Excel�İ汾,��ȡWorkbook
	 * 
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkBook(File file) throws IOException {
		Workbook wb = null;
		FileInputStream in = new FileInputStream(file);
		if (file.getName().endsWith(EXCEL_XLS)) { // Excel&nbsp;2003
			wb = new HSSFWorkbook(in);
		} else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel 2007/2010
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}
    
    public static Workbook getWorkBook(String fileName,String path) { 
        //����ļ���  Obtain file name��including path.  
		String filePathAndName = path + "/" + fileName;
        //����Workbook���������󣬱�ʾ����excel  ,Create workbook for the excel file.
        Workbook workbook = null;  
        try {  
            //��ȡexcel�ļ���io��  
            InputStream is = new FileInputStream(filePathAndName);  
            //�����ļ���׺����ͬ(xls��xlsx)��ò�ͬ��Workbookʵ�������  
            if(filePathAndName.endsWith(xls)){  
                //for 2003 version
                workbook = new HSSFWorkbook(is);  
            }else if(filePathAndName.endsWith(xlsx)){  
                //for 2007 version  
                workbook = new XSSFWorkbook(is);  
            }  
        } catch (IOException e) {  
            logger.info(e.getMessage());  
        }  
        return workbook;  
    }
    
    public static String getCellValue(Cell cell){  
        String cellValue = "";  
        if(cell == null){  
            return cellValue;  
        }  
        //�����ֵ���String�������������1����1.0�����  
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){  
            cell.setCellType(Cell.CELL_TYPE_STRING);  
        }  
        //�ж����ݵ�����  
        switch (cell.getCellType()){  
            case Cell.CELL_TYPE_NUMERIC: //����  
                cellValue = String.valueOf(cell.getNumericCellValue());  
                break;  
            case Cell.CELL_TYPE_STRING: //�ַ���  
                cellValue = String.valueOf(cell.getStringCellValue());  
                break;  
            case Cell.CELL_TYPE_BOOLEAN: //Boolean  
                cellValue = String.valueOf(cell.getBooleanCellValue());  
                break;  
            case Cell.CELL_TYPE_FORMULA: //��ʽ  
                cellValue = String.valueOf(cell.getCellFormula());  
                break;  
            case Cell.CELL_TYPE_BLANK: //��ֵ   
                cellValue = "";  
                break;  
            case Cell.CELL_TYPE_ERROR: //����  
                cellValue = "�Ƿ��ַ�";  
                break;  
            default:  
                cellValue = "δ֪����";  
                break;  
        }  
        return cellValue;  
    }  
} 