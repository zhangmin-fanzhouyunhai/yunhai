package com.yunhai.beanutils.pdf;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PdfConvertToImage {
	 //��������,dpiΪ96,100,105,120,150,200��,105��ʾЧ����Ϊ����,����ȶ�,dpiԽ��ͼƬ���Խ��,һ�������ʾ�ֱ���Ϊ96
    public static final float DEFAULT_DPI = 105;
    //Ĭ��ת����ͼƬ��ʽΪjpg
    public static final String DEFAULT_FORMAT = "jpg";
    public static void main(String[] args) throws Exception {
		
    	String pdfPath;
        //String pdfPath="D:/temp/pdf/PMS2.0���Ĵ���ģ��һ�廯���ܽ���(��Ŀ������)-20180503-�ո�(PPT71ҳ).pdf";
        pdfPath="D:/temp/pdf/���ҵ�����˾��������������Ŀ�����۹���涨-��������������Ŀ�����۹���涨-��ע.pdf";
        String imgPath="D:/temp/pdf/img/";
        
        AllToImage(pdfPath,imgPath);
        
    }
        
        
        

        /**
         * pdfתͼƬ
         *
         * @param pdfPath PDF·��
         * @imgPath img·��
         * @page_end Ҫת����ҳ�룬Ҳ���Զ��忪ʼҳ��ͽ���ҳ�룬������ֻ��Ҫһҳ�����������������
         */
        public static void AllToImage(String pdfPath, String imgPath) {
            try {
                //ͼ��ϲ�ʹ�ò���
                // �ܿ��
                int width = 0;
                // ����һ��ͼƬ�е�RGB����
                int[] singleImgRGB;
                int shiftHeight = 0;
                //����ÿ��ͼƬ������ֵ
                BufferedImage imageResult = null;
                //����PdfBox����ͼ��
                PDDocument pdDocument = PDDocument.load(new File(pdfPath));
                PDFRenderer renderer = new PDFRenderer(pdDocument); 
                //��ȡpdf�ļ���ҳ�������
                int len = pdDocument.getNumberOfPages() ;
                //ѭ��ÿ��ҳ��
                for (int i = 0; i < len; i++) { 
                		String imgFile=imgPath+(i+1)+".jpg";
                        BufferedImage image = renderer.renderImageWithDPI(i, DEFAULT_DPI, ImageType.RGB);
                        int imageHeight = image.getHeight();
                        int imageWidth = image.getWidth();
                       //����߶Ⱥ�ƫ����
                        //ʹ�õ�һ��ͼƬ���;
                        width = imageWidth;
                        //����ÿҳͼƬ������ֵ
                        imageResult = new BufferedImage(width, imageHeight, BufferedImage.TYPE_INT_RGB);
                        //�����и߶ȣ����Խ�imageHeight*len��������ֵ��ȡһҳ���Բ���Ҫ
                          singleImgRGB = image.getRGB(0, 0, width, imageHeight, null, 0, width);
                          // д������
                          imageResult.setRGB(0, shiftHeight, width, imageHeight, singleImgRGB, 0, width); 

                          // дͼƬ
                          ImageIO.write(imageResult, DEFAULT_FORMAT, new File(imgFile));
                     
                }
     
                pdDocument.close();
                 
            } catch (Exception e) {
               
                e.printStackTrace();
            }
            //OVER
        }
        
}

