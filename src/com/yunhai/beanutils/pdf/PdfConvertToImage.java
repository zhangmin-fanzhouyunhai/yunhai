package com.yunhai.beanutils.pdf;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PdfConvertToImage {
	 //经过测试,dpi为96,100,105,120,150,200中,105显示效果较为清晰,体积稳定,dpi越高图片体积越大,一般电脑显示分辨率为96
    public static final float DEFAULT_DPI = 105;
    //默认转换的图片格式为jpg
    public static final String DEFAULT_FORMAT = "jpg";
    public static void main(String[] args) throws Exception {
		
    	String pdfPath;
        //String pdfPath="D:/temp/pdf/PMS2.0技改大修模块一体化功能介绍(项目估算书)-20180503-终稿(PPT71页).pdf";
        pdfPath="D:/temp/pdf/国家电网公司生产技术改造项目后评价管理规定-生产技术改造项目后评价管理规定-标注.pdf";
        String imgPath="D:/temp/pdf/img/";
        
        AllToImage(pdfPath,imgPath);
        
    }
        
        
        

        /**
         * pdf转图片
         *
         * @param pdfPath PDF路径
         * @imgPath img路径
         * @page_end 要转换的页码，也可以定义开始页码和结束页码，我这里只需要一页，根据需求自行添加
         */
        public static void AllToImage(String pdfPath, String imgPath) {
            try {
                //图像合并使用参数
                // 总宽度
                int width = 0;
                // 保存一张图片中的RGB数据
                int[] singleImgRGB;
                int shiftHeight = 0;
                //保存每张图片的像素值
                BufferedImage imageResult = null;
                //利用PdfBox生成图像
                PDDocument pdDocument = PDDocument.load(new File(pdfPath));
                PDFRenderer renderer = new PDFRenderer(pdDocument); 
                //获取pdf文件中页面的数量
                int len = pdDocument.getNumberOfPages() ;
                //循环每个页码
                for (int i = 0; i < len; i++) { 
                		String imgFile=imgPath+(i+1)+".jpg";
                        BufferedImage image = renderer.renderImageWithDPI(i, DEFAULT_DPI, ImageType.RGB);
                        int imageHeight = image.getHeight();
                        int imageWidth = image.getWidth();
                       //计算高度和偏移量
                        //使用第一张图片宽度;
                        width = imageWidth;
                        //保存每页图片的像素值
                        imageResult = new BufferedImage(width, imageHeight, BufferedImage.TYPE_INT_RGB);
                        //这里有高度，可以将imageHeight*len，我这里值提取一页所以不需要
                          singleImgRGB = image.getRGB(0, 0, width, imageHeight, null, 0, width);
                          // 写入流中
                          imageResult.setRGB(0, shiftHeight, width, imageHeight, singleImgRGB, 0, width); 

                          // 写图片
                          ImageIO.write(imageResult, DEFAULT_FORMAT, new File(imgFile));
                     
                }
     
                pdDocument.close();
                 
            } catch (Exception e) {
               
                e.printStackTrace();
            }
            //OVER
        }
        
}

