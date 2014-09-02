package com.uwen.ur.util.crawer;


import java.text.MessageFormat;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {

	public static String url = "http://huaban.com/favorite/beauty/?q={0}&page={1}&per_page=20&wfl=1";
	public static String keyword = "美女";
	public static String site = "花瓣网";
	public static int page = 1;

	public static void main(String[] args) {
		//crawlByType();
		crawlByShopId();
//		String newUrl = formateUrl(url, keyword, page);
//		//CrawerThrad runnable = new CrawerThrad(url);
//		try {
//			Thread thread = new Thread(runnable);
//			thread.start();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
		
	}
	
	/*public static Element first(Element parent,String expression){
		Elements eles = parent.select(expression);
	}*/
	
	public static void crawlByShopId() {
		try {
			//String shopUrl = "http://www.dianping.com" + urlSuffix;
			String shopUrl = "http://www.dianping.com/shop/4052899";
			
			String shopContent = getContent(shopUrl);
			
			Document shopDoc = Jsoup.parse(shopContent);
			Element shopInfoEle = shopDoc.select(".shop-info-con").first();
			
			Element shopLocationEle = shopInfoEle.select(".shop-location").first();
			Element streetAddress = shopLocationEle.select("[itemprop=street-address").first();
			//地址
			String address = "";
			if(streetAddress != null){
				address = streetAddress.text();
			}
			
			//电话
			Element tel = shopLocationEle.select("[itemprop=tel").first();
			String telPhone = "";
			if(tel != null){
				telPhone = tel.text();
			}
			
			//详细信息
			Element descList = shopInfoEle.select(".desc-list").first();
			Elements descLis = descList.select("li");
			String alisName = "";
			String shopDes = "";
			String shopTime = "";
			for (int i = 0; i < descLis.size(); i++) {
				Element descLi = descLis.get(i);
				Element title = descLi.select(".tit").first();
				if(null == title) continue;
				String titleText = title.text();
/*餐厅别名： 餐厅简介： 营业时间： 官方信息： 餐厅氛围： 餐厅特色： 会员贡献：*/
				if("餐厅别名：".equals(titleText)){
					Element descLiClone = descLi.clone();
					descLiClone.select(".tit").remove();
					alisName = descLiClone.text();
				}else if("餐厅简介：".equals(titleText)){
					Element descLiClone = descLi.clone();
					descLiClone.select(".tit").remove();
					shopDes = descLiClone.text();
				}else if("营业时间：".equals(titleText)){
					//.J_full-cont
					shopTime = descLi.clone().select(".J_full-cont").text();
				}
			}
			System.out.println(alisName + "," + shopDes + "," + shopTime);
			
			/*//相册列表.pic-list
			Elements picList = shopDoc.select(".rec-offic-album");
			for (int i = 0; i < picList.size(); i++) {
				Element picLi = picList.get(i);
				System.out.println(picLi.html());
			}*/
			//
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void crawlByType() {
		// TODO Auto-generated method stub
		//String url = "http://www.dianping.com/search/keyword/1/0_%E4%BC%91%E9%97%B2%E5%A8%B1%E4%B9%90";
		//1 上海//10美食
		String url = "http://www.dianping.com/search/category/1/10";
		try {
			String content = getContent(url);
			Document doc = Jsoup.parse(content);
			Elements eles = doc.select(".detail");
			for (int i = 0; i < eles.size(); i++) {
				try {
					Element ele = eles.get(i);
					//detail li
					//名称 URL地址
					Element shopnameEle = ele.select(".shopname").first();
					//
					Element shopnameA = shopnameEle.select("a").first();
					//店铺名称
					String name = shopnameA.text();
					//链接地址
					String urlSuffix = shopnameA.attr("href");
					
					//地址
					Element address = ele.select(".address").first();
					//所在区
					Element area = address.select("a").first();
					//详细地址
					Element daddrEle = address.clone();
					daddrEle.select("a").remove();
					daddrEle.select("strong").remove();
					String detailAddrs = daddrEle.text();
					String[] daddrs = detailAddrs.split("  ");
					detailAddrs = daddrs[0];
					String telPhone = "";
					if(daddrs.length > 1){
						telPhone = daddrs[1];
					}
					
					//标签
					Element tagsEle = ele.select(".tags").first();
					Element tag = tagsEle.select("a").first();
					//类别名称
					String typeName = tag.text();
					//System.out.println(typeName);
					
				} catch (Exception e) {
					System.out.println("警告!" + e.getMessage());
					//e.printStackTrace();
				}
			}
			//10秒请求一次
			//System.out.println(eles.html());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String formateUrl(String urlStr, String keyword, int page) {
		Object[] param = new Object[] { keyword, page };
		return MessageFormat.format(urlStr, keyword, param);
	}
	
	public static String getContent(String crawUrl) throws Throwable {

		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(crawUrl);
		httpGet.setHeader("Host", "www.dianping.com");
		client.getParams()
				.setParameter(
						CoreProtocolPNames.USER_AGENT,
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_3) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1312.57 Safari/537.17");
		client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION,
				HttpVersion.HTTP_1_1);
		String str = client.execute(httpGet, new BasicResponseHandler());
		httpGet.abort();
		client.getConnectionManager().shutdown();
		client = null;
		return str;
	}
}
