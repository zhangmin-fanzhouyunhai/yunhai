package com.yunhai.camera;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameGrabber;

public class CameraTest {
	public static void main(String[] args) throws Exception, InterruptedException {
		//OpenCVFrameGrabber openCVFrameGrabber =new OpenCVFrameGrabber("Second Camera of Zhangmin!!!");
		OpenCVFrameGrabber openCVFrameGrabber =new OpenCVFrameGrabber(0);
		openCVFrameGrabber.setImageWidth(1280);
		openCVFrameGrabber.setImageHeight(720);
		openCVFrameGrabber.start();
		CanvasFrame canvasFrame =new CanvasFrame("Capital");
		canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvasFrame.setAlwaysOnTop(true);
		while(canvasFrame.isDisplayable()) {
			canvasFrame.showImage(openCVFrameGrabber.grab());
			TimeUnit.MILLISECONDS.sleep(40);
		}
		openCVFrameGrabber.stop();
	}
}
