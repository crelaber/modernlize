package com.uwen.ur.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.uwen.ur.util.JUtil;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;


/**
 * 文件名称: CommonConstants.java 内容摘要:
 * 
 * @author: wuzhiyun
 * @version: 1.0
 * @Date: 2012-5-11 下午03:35:22
 * 
 * 修改历史: 修改日期 修改人员 版本 修改内容 ----------------------------------------------
 * 2012-5-11 wuzhiyun 1.0 1.0 XXXX
 * 
 * 版权: 版权所有(C)2012 公司: 华诚信息科技股份有限公司
 */
public class CommonConstants {
    
	
	/**
	 * 返回状态码 200 - 499 都可以认为是成功   |  >=500 都可以认为是异常/失败
	 */
	public static final int STATE_SUCCESS = 200; // 执行成功

	public static final int STATE_FAIL = 500; // 常规失败
	public static final int STATE_EXCEPTION = 505; // 系统异常
	
	public static final int STATE_NOT_LOGIN = 501; // 用户未登陆
	public static final int STATE_USER_EXIST = 503; // 用户已存在
    /**
     * 系统编码
     */
    public static final String SYSTEM_ENCODING = "UTF-8";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_SIMPLE = "yyyy-MM-dd";
    
    public static final String SEX_MALE = "0";
    public static final String SEX_FEMALE = "1";
    public static final String BUSI_STATE_BUSI= "1";  //商家忙碌状态之忙碌
    public static final String BUSI_STATE_FREE= "2";  //商家忙碌状态之空闲
    public static final String BUSI_STATE_COLSE_BUSINESS= "3";  //商家忙碌状态之关闭
    public static final String DEFAULT_EMPTY_STRING = "";
    public static final int ADMIN_MESSAGE_TYPE_ADMIN_SEND = 0;
    public static final int ADMIN_MESSAGE_TYPE_BUSINESS_SEND = 1;
    
    public static final String SERVER_IP = "http://115.28.91.240/mycar/";
    
    public static final String BASE_BUSINESS_IMG_PATH = "save/business/poster";
    public static final String BASE_AD_IMG_PATH = "save/ad/poster";
    @Deprecated
    public static final Date getDate(String datestr) throws ParseException{
        return JUtil.parseDate(datestr);
    }
    
    /**
     * 获取服务器地址
     * 
     * @param serviceName
     * @return String
     */
    public static String getServicePath(String serviceName) {
        String servicePath = "";
        String configfile = "c:/twra.properties";
        if (System.getProperty("file.separator").equals("/")) {
            configfile = "/twra.properties";
        }
        FileInputStream input;
        try {
            input = new FileInputStream(configfile);
            Properties p = new Properties();
            try {
                p.load(input);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            servicePath = p.getProperty(serviceName);// "HELP";
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return servicePath;
    }
	
    public static JsonConfig JSON_CFG;
    
    static{
        JSON_CFG = new JsonConfig();
        //防止自包含
        JSON_CFG.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        //设置日期格式
        JSON_CFG.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            
            public Object processObjectValue(String name, Object value, JsonConfig cfg) {
                if(!(value instanceof Date)) return null;
                DateFormat dateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMAT);
                String dateStr = dateFormat.format(value);
                return dateStr;
            }
            
            
            public Object processArrayValue(Object arg0, JsonConfig arg1) {
                // TODO Auto-generated method stub
                return null;
            }
        });
        
        //属性过滤空值
        JSON_CFG.setJsonPropertyFilter(new PropertyFilter() {
            
            public boolean apply(Object obj, String name, Object value) {
                return value == null;
            }
        });
    }
    
    /**
     * 系统实体包名
     */
    public static final String SYSTEM_POJO_PACKAGE = "com.talkweb.cplx.model.pojo.sys.";
	public static final String SESSION_SECURITY_CODE = "SESSION_SECURITY_CODE";
	public static final String COUPON = "coupon";
	public static final String VIP = "vip";
	public static final String HISTORY_URL = "historyURL";
	public static final String PROTOCOL_PRD = "prd_protocol";
	public static final String PROTOCOL_USER = "user_protocol";
	public static final String BUSINESS_INFO = "business_info";
	
	public static final int USER_MANGER = 1;
	public static final int USER_ADMIN = 2;
	
	public static final String ADMIN_USER = "admin_user";
	public static final String ADV_INDEX_1 = "index_1";
	public static final String ADV_INDEX_2 = "index_2";
	public static final String ADV_INDEX_3 = "index_3";
	public static final String ADV_INDEX_4 = "index_4";
	public static final String USER_NORMAL = "user";
	public static final String EXIST_GGN = "existGGN";
	public static final String CHECK_MIBAO_SUCCESS = "checkMibaoSuccess";
	public static final int BUFF_SIZE_OUT = 2048;
    /**
     * 系统文件上传根目录
     */
    //public static String SYSTEM_UPLOAD_ROOT = "/www/apache-tomcat-6.0.36/webapps/tpm/attach/";
    public static String SYSTEM_UPLOAD_ROOT = "E:/tpm_upload/attach/";
    public static String getSystemUploadRoot(){
        return SYSTEM_UPLOAD_ROOT;
    }


    /**
     * 获取web路径
     * @return
     */
    private static String getWebRoot()
    {
        String webRoot ="./tmp_upload/";
        try {
            URI webRootUrl;
            webRootUrl = Thread.currentThread().getContextClassLoader().getResource("").toURI();
            int webRootPos =0;

            if(webRootUrl!=null)
            {
                webRoot =   webRootUrl.toString();
                if((webRootPos=webRoot.indexOf("file:/"))>=0)
                {
                    webRoot = webRoot.substring(webRootPos+6);
                }
            }
            if(webRoot!=null &&  (webRootPos =webRoot.indexOf("WEB-INF"))>0)
            {
                webRoot=webRoot.substring(0,webRootPos);
            }
            webRoot = webRoot +"/attach";
            File webRootFile = new File(webRoot);
            if(webRootFile.exists()==false)
            {
                webRootFile.mkdirs();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return webRoot;
    }
    /*public final static Map<String,List<NormalFieldFkConfig>> FIELD_FK_CONFIG = new HashMap<String, List<NormalFieldFkConfig>>();
    static{
        List<NormalFieldFkConfig> tpmAuditFks = new ArrayList<NormalFieldFkConfig>();
        FIELD_FK_CONFIG.put("TpmAudit", tpmAuditFks);
    }*/
}
