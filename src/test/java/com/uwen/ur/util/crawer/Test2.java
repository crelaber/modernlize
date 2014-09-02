package com.uwen.ur.util.crawer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Test2 {


	public static void main(String[] args) throws IOException {
		//System.out.println("ssdsd_01_33你吗啊?????#￥*&*&*@？？。。".replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5]", ""));
		//System.out.println(parsePix(new Double(-2),null));
		//testMergeImg();
		testMerge2();
	}
	
	public static Integer parsePix(Object object,Context context) {
		if(object instanceof Integer){
			return (Integer)object;
		}else if(object instanceof Double){
			return ((Double)object).intValue();
		}else if(object instanceof String){
			String result = (String)object;
			if(result.endsWith("dip")){
				result = result.replace("dip", "");
				try{
					//return Util.dip2px(context, Integer.parseInt(result));
				}catch(Exception e){
					return null;
				}
			}else if(result.endsWith("px")){
				result = result.replace("px", "");
				try{
					return Integer.parseInt(result);
				}catch(Exception e){
					return null;
				}
			}else{
				try{
					return Integer.parseInt(result);
				}catch(Exception e){
					return null;
				}
			}
		}
		return null;
	}
	
	public static void testMergeImg(){
		int length = 16;
		String[] pics = new String[length];
		String path = "E:\\我的文档\\uwen\\design\\其他游戏\\游戏技能光效27\\CLAMP (26)\\";
		for (int i = 1; i < length + 1; i++) {
			if(i < 10){
				pics[i-1] = path + "0" + i + ".png";
			}else{
				pics[i-1] = path + i + ".png";
			}
		}
		merge(pics, "png", path+"test.png");
	}
	
	public static void testMergeImg2(){
		int length = 9;
		String[] pics = new String[length];
		String path = "E:\\我的文档\\uwen\\design\\其他游戏\\DNF游戏技能序列特效\\SM-302-游戏技能序列特效04\\游戏技能序列特效04  (73)\\";
		for (int i = 1; i < length + 1; i++) {
			pics[i-1] = path + i + ".png";
		}
		merge(pics, "png", path+"test.png");
	}
	
	/**
	 * Java拼接多张图片
	 * 
	 * @param pics
	 * @param type
	 * @param dst_pic
	 * @return
	 */
	public static boolean merge(String[] pics, String type, String dst_pic) {

		int len = pics.length;
		if (len < 1) {
			System.out.println("pics len < 1");
			return false;
		}
		File[] src = new File[len];
		BufferedImage[] images = new BufferedImage[len];
		int[][] ImageArrays = new int[len][];
		for (int i = 0; i < len; i++) {
			try {
				src[i] = new File(pics[i]);
				images[i] = ImageIO.read(src[i]);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			int width = images[i].getWidth();
			int height = images[i].getHeight();
			ImageArrays[i] = new int[width * height];// 从图片中读取RGB
			ImageArrays[i] = images[i].getRGB(0, 0, width, height,
					ImageArrays[i], 0, width);
		}

		int dst_height = 0;
		int dst_width = images[0].getWidth();
		for (int i = 0; i < images.length; i++) {
			dst_width = dst_width > images[i].getWidth() ? dst_width
					: images[i].getWidth();

			dst_height += images[i].getHeight();
		}
		System.out.println(dst_width);
		System.out.println(dst_height);
		if (dst_height < 1) {
			System.out.println("dst_height < 1");
			return false;
		}

		// 生成新图片
		try {
			// dst_width = images[0].getWidth();
			BufferedImage ImageNew = new BufferedImage(dst_width, dst_height,
					BufferedImage.TRANSLUCENT);
			int height_i = 0;
			for (int i = 0; i < images.length; i++) {
				ImageNew.setRGB(0, height_i, dst_width, images[i].getHeight(),
						ImageArrays[i], 0, dst_width);
				height_i += images[i].getHeight();
			}

			File outFile = new File(dst_pic);
			ImageIO.write(ImageNew, type, outFile);// 写图片
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void testMerge2(){
		for (int i = 2; i < 3; i++) {
			String path = "E:\\我的文档\\uwen\\design\\其他游戏\\游戏技能光效27\\CLAMP ("+ i +")\\";
			merge2(path,i);
		}
	}
	
	/**
	 * Java拼接多张图片
	 * 
	 * @param pics
	 * @param type
	 * @param dst_pic
	 * @return
	 */
	public static boolean merge2(String path,int midx) {
		
		File root = new File(path);
		if(!root.exists() || !root.isDirectory()){
			return false;
		}
		
		File[] files = root.listFiles();
		
		if(null == files){
			return false;
		}
		
		List<BufferedImage> images = new ArrayList<BufferedImage>();
		List imageArrays = new ArrayList();
		
		int dst_width = 0;
		int dst_height = 0;
		for (File file : files) {
			String fileName =  file.getName();
			if(!file.isFile() || fileName.startsWith("test")  || !fileName.endsWith(".png")){
				continue;
			}
			//System.out.println(file.getName());
			
			try {
				BufferedImage img = ImageIO.read(file);
				int width = img.getWidth();
				int height = img.getHeight();
				int[] imageArray = new int[width * height];// 从图片中读取RGB
				imageArray = img.getRGB(0, 0, width, height, imageArray, 0, width);
				imageArrays.add(imageArray);
				images.add(img);
				
				if(width > dst_width){
					dst_width = width;
				}
				dst_height += height;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		BufferedImage ImageNew = new BufferedImage(dst_width, dst_height, BufferedImage.TRANSLUCENT);
		
		int idx = 0;
		int height_i = 0;
		for (BufferedImage bufferedImage : images) {
			try{
				ImageNew.setRGB(0, height_i, dst_width, bufferedImage.getHeight(),
						(int[])imageArrays.get(idx), 0, dst_width);
				height_i += bufferedImage.getHeight();
			}catch (Exception e) {
				System.out.println(path);
			}
			idx ++;
		}
		File outFile = new File(path + "test" + midx + ".png");
		
		try {
			ImageIO.write(ImageNew, "png", outFile);
		} catch (IOException e) {
			e.printStackTrace();
		}// 写图片
		
		/*int[][] ImageArrays = new int[len][];
		
		for (int i = 0; i < len; i++) {
			try {
				src[i] = new File(pics[i]);
				BufferedImage img = ImageIO.read(src[i]);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			int width = images[i].getWidth();
			int height = images[i].getHeight();
			ImageArrays[i] = new int[width * height];// 从图片中读取RGB
			ImageArrays[i] = images[i].getRGB(0, 0, width, height,
					ImageArrays[i], 0, width);
		}

		int dst_height = 0;
		int dst_width = images[0].getWidth();
		for (int i = 0; i < images.length; i++) {
			dst_width = dst_width > images[i].getWidth() ? dst_width
					: images[i].getWidth();

			dst_height += images[i].getHeight();
		}
		System.out.println(dst_width);
		System.out.println(dst_height);
		if (dst_height < 1) {
			System.out.println("dst_height < 1");
			return false;
		}

		// 生成新图片
		try {
			// dst_width = images[0].getWidth();
			BufferedImage ImageNew = new BufferedImage(dst_width, dst_height,
					BufferedImage.TRANSLUCENT);
			int height_i = 0;
			for (int i = 0; i < images.length; i++) {
				ImageNew.setRGB(0, height_i, dst_width, images[i].getHeight(),
						ImageArrays[i], 0, dst_width);
				height_i += images[i].getHeight();
			}

			File outFile = new File(dst_pic);
			ImageIO.write(ImageNew, "png", outFile);// 写图片
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}*/
		return true;
	}
	
	public static class Context{
		
	}
	public static class Util{
		
	}
	public static class Config{
		
	}
}
