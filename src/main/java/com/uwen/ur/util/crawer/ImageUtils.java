package com.uwen.ur.util.crawer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class ImageUtils {

	public static BufferedImage zoomImage(BufferedImage originalImage,
			int width, boolean square) {
		int imgWid = originalImage.getWidth();
		int imgHeight = originalImage.getHeight();
		int height = (int) (width / (float) imgWid * originalImage.getHeight());
		if (square) {
			int squareSize = imgWid > imgHeight ? imgHeight : imgWid;
			originalImage = originalImage.getSubimage(0, 0, squareSize,
					squareSize);
			height = width;
		}
		BufferedImage newImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = newImage.getGraphics();
		g.drawImage(originalImage.getScaledInstance(width, height,
				BufferedImage.SCALE_SMOOTH), 0, 0, null);
		// g.setClip(0, 0, width, sqheight);
		g.dispose();
		return newImage;
	}

	public static BufferedImage getImg(InputStream inStream) throws IOException {
		return ImageIO.read(inStream);
	}

	public static void saveImage(BufferedImage bufImg, String dirPath,
			String tempPath, String imageName, int width, boolean square)
			throws Exception {
		BufferedImage bufferedImage = zoomImage(bufImg, width, square);
		saveImage(bufferedImage,dirPath,tempPath,imageName);
	}
	
	public static void saveImage(InputStream is, String dirPath,String fileName) throws Exception {
		BufferedImage bufImg = getImg(is);
		ImageUtils.saveImage(bufImg, dirPath, "", fileName,bufImg.getWidth(),false);
		ImageUtils.saveImage(bufImg, dirPath, "/i32", fileName, 32, true);
		ImageUtils.saveImage(bufImg, dirPath, "/i64", fileName, 64, true);
		ImageUtils.saveImage(bufImg, dirPath, "/i160", fileName, 160, true);
		ImageUtils.saveImage(bufImg, dirPath, "/i256", fileName, 256, true);
		ImageUtils.saveImage(bufImg, dirPath, "/i512", fileName, 512, false);
	}
	
	public static void saveImage(BufferedImage bufImg, String dirPath,
			String tempPath, String imageName) throws Exception {
		FileOutputStream out = null;
		try {
			
			File dirFile = new File(dirPath + tempPath);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			out = new FileOutputStream(new File(dirFile,imageName));
			//JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			//encoder.encode(bufImg);
		} catch (Exception e) {
			throw e;
		}finally{
			//if(null != out)out.close();
			
		}
	}
	
	public static String getPinYin(String src) {
		char[] t1 = null;
		t1 = src.toCharArray();
		// System.out.println(t1.length);
		String[] t2 = new String[t1.length];
		// System.out.println(t2.length);
		// 设置汉字拼音输出的格式
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		String t4 = "";
		int t0 = t1.length;
		try {
			for (int i = 0; i < t0; i++) {
				// 判断是否为汉字字符
				// System.out.println(t1[i]);
				if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);// 将汉字的几种全拼都存到t2数组中
					t4 += t2[0];// 取出该汉字全拼的第一种读音并连接到字符串t4后
				} else {
					// 如果不是汉字字符，直接取出字符并连接到字符串t4后
					t4 += Character.toString(t1[i]);
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t4;
	}

	public static InputStream getInputStreamByUrl(String url) throws Exception {
		Thread.sleep(2000);
		URL urler = new URL(url);
		// 打开链接
		HttpURLConnection conn = (HttpURLConnection) urler.openConnection();
		conn.setRequestMethod("GET");
		// 设置请求方式为"GET"
		String contentType = conn.getHeaderField("Content-Type");
		/*if(!(contentType.equals("image/jpeg"))){
			return null;
		}*/
		// 超时响应时间为5秒
		conn.setConnectTimeout(10 * 1000);
		// 通过输入流获取图片数据
		InputStream inStream = conn.getInputStream();
		// 得到图片的二进制数据，以二进制封装得到数据，具有通用性
		return inStream;
	}

	public static void saveImage(File file, String path, String fileName) throws Exception {
		FileOutputStream out = null;
		FileInputStream is = null;
		try {
			out = new FileOutputStream(new File(path + "/" + fileName));
			is = new FileInputStream(file);
			byte[] buff = new byte[1024];
			while(is.read(buff) > -1){
				out.write(buff);
			}
			
		} catch (Exception e) {
			throw e;
		} finally{
			if(null != out) out.close();
			if(null != is) is.close();
		}
	}

}
