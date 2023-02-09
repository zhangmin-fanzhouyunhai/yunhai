package com.yunhai.camera;
import org.bytedeco.ffmpeg.avcodec.AVCodecParameters;
import org.bytedeco.ffmpeg.avformat.AVFormatContext;
import org.bytedeco.ffmpeg.avformat.AVStream;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.FFmpegLogCallback;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;

public class VideoUtil {
	/**
	 * ��Ƶת�뺯��(��ת��)
	 * 
	 * @param inputfile  ԭʼ��Ƶ�ļ�����·��
	 * @param outputfile Ŀ����Ƶ�ļ���������·�������������ļ�������������ʽ��׺���Ƽ���ʽ��׺Ϊ.mp4��
	 * @throws Exception �쳣
	 */
	public static void videoConvert(String inputfile, String outputfile) throws Exception
	{
		if (outputfile.lastIndexOf('.') < 0)
		{
			throw new Exception("Error! Output file format undetected!");
		}
		String format = outputfile.substring(outputfile.lastIndexOf('.'));

		FFmpegLogCallback.set();
		Frame frame;
		FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(inputfile);
		FFmpegFrameRecorder recorder = null;

		try
		{
			System.out.println("��ʼ��ʼ��֡ץȡ��");

			// ��ʼ��֡ץȡ�����������ݽṹ��ʱ����������������ġ�֡����ȣ���
			// �����ε���true���������avformat_find_stream_info������ȡ������Ϣ������AVFormatContext���͵ĳ�Ա����oc��
			grabber.start(true);

			System.out.println("֡ץȡ����ʼ�����");

			// grabber.start�����У���ʼ���Ľ�������Ϣ���ڷ���grabber�ĳ�Ա����oc��
			AVFormatContext avformatcontext = grabber.getFormatContext();

			// �ļ����м���ý������һ������Ƶ��+��Ƶ����
			int streamNum = avformatcontext.nb_streams();

			// û��ý�����Ͳ��ü�����
			if (streamNum < 1)
			{
				System.out.println("�ļ��ڲ�����ý����");
				throw new Exception("Error! There is no media stream in the file!");
			}

			// ȡ����Ƶ��֡��
			int framerate = (int) grabber.getVideoFrameRate();

			System.out.printf("��Ƶ֡��[%d]����Ƶʱ��[%d]�룬ý��������[%d]\r\n", framerate, avformatcontext.duration() / 1000000,
					avformatcontext.nb_streams());

			// ����ÿһ���������������
			for (int i = 0; i < streamNum; i++)
			{
				AVStream avstream = avformatcontext.streams(i);
				AVCodecParameters avcodecparameters = avstream.codecpar();
				System.out.printf("��������[%d]������������[%d]��������ID[%d]\r\n", i, avcodecparameters.codec_type(),
						avcodecparameters.codec_id());
			}

			// ��Ƶ���
			int frameWidth = grabber.getImageWidth();
			// ��Ƶ�߶�
			int frameHeight = grabber.getImageHeight();
			// ��Ƶͨ������
			int audiochannels = grabber.getAudioChannels();

			System.out.printf("��Ƶ���[%d]����Ƶ�߶�[%d]����Ƶͨ����[%d]\r\n", frameWidth, frameHeight, audiochannels);

			recorder = new FFmpegFrameRecorder(outputfile, frameWidth, frameHeight, audiochannels);
			recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);

			recorder.setFormat(format);
			// ʹ��ԭʼ��Ƶ�����ʣ�����Ҫ�������޸�����
			recorder.setVideoBitrate(grabber.getVideoBitrate());
			
			// һ���ڵ�֡����֡��
			recorder.setFrameRate(framerate);

			// �����ؼ�֮֡���֡��
			recorder.setGopSize(framerate);

			// ������Ƶͨ����������ƵԴ��ͨ�������
			recorder.setAudioChannels(grabber.getAudioChannels());

			recorder.start();

			int videoframenum = 0;
			int audioframenum = 0;
			int dataframenum = 0;

			// ��������ƵԴȡ֡
			while (null != (frame = grabber.grab()))
			{
				// ��ͼ�񣬾Ͱ���Ƶ֡��һ
				if (null != frame.image)
				{
					videoframenum++;
					// ȡ����ÿһ֡�������浽��Ƶ
					recorder.record(frame);
				}

				// ���������Ͱ���Ƶ֡��һ
				if (null != frame.samples)
				{
					audioframenum++;
					// ȡ����ÿһ֡�������浽��Ƶ
					recorder.record(frame);
				}

				// �����ݣ��Ͱ�����֡��һ
				if (null != frame.data)
				{
					dataframenum++;
				}
			}

			System.out.printf("ת����ɣ���Ƶ֡[%d]����Ƶ֡[%d]������֡[%d]\r\n", videoframenum, audioframenum, dataframenum);

		} catch (Exception e)
		{
			// e.printStackTrace();
			throw e;
		} finally
		{
			if (recorder != null)
			{
				try
				{
					recorder.close();
				} catch (Exception e)
				{
					// System.out.println("recorder.close�쳣" + e);
					throw e;
				}
			}

			try
			{
				grabber.close();
			} catch (FrameGrabber.Exception e)
			{
				// System.out.println("frameGrabber.close�쳣" + e);
				throw e;
			}
		}
	} 
}
