package com.uwen.ur.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.uwen.ur.common.CommonConstants;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class ServicesGeneral {

    private Configuration cfg;
    
    public static String PRJ_NAME = "ur_manage";
    public static String ROOT_PATH = "F:/soft_dev/ide/myeclipse10/workspace/"+PRJ_NAME+"/";
    public static String SOURCE_PATH = "src/main/java/com/uwen/ur/";
    public static String ACTION_PATH = SOURCE_PATH + "action/sys/";
    public static String SERVICE_PATH = SOURCE_PATH + "model/service/sys/";
    public static String SERVICE_IMPL_PATH = SERVICE_PATH + "impl/";
    
    public void init() throws Exception {
        // 初始化FreeMarker配置
        // 创建一个Configuration实例
        cfg = new Configuration();
        // 设置FreeMarker的模版文件位置
        cfg.setDirectoryForTemplateLoading(new File(ROOT_PATH + "src/main/resources/mg"));
    }

    public void processAction(ServicesGeneral hf, JSONObject pojoCfg) throws Exception {
        JSONArray pojos = pojoCfg.getJSONArray("pojos");
        for (int i = 0; i< pojos.size(); i++) {
            JSONObject pojo = pojos.getJSONObject(i);
            // 根
            Map<String, Object> root = new HashMap<String, Object>();
            String pojo_name = pojo.getString("name");
            
            root.put("pojo", pojo);
            root.put("pojo_name", pojo_name);
            root.put("pks", pojo.getJSONArray("pks"));
            root.put("fas", pojo.getJSONArray("fas"));
            root.put("resouces", pojo.getJSONArray("resouces"));
            if(pojo.containsKey("blobs")){
            	root.put("blobs", pojo.getBoolean("blobs"));
            }
            // 项目路径
            //String projectPath = "F:\\soft_dev\\ide\\myeclipse10\\workspace\\upic\\";
            
            String fileName = pojo_name + "Action.java";
            
            //String savePath = "src//main//java//com//uwen//upic//action//sys//";
            
            Template template = cfg.getTemplate("general_action.ftl");
            // 生成action
            hf.buildTemplate(root, ROOT_PATH, ACTION_PATH, fileName, template);
        }
        
    }
    
    public void process(ServicesGeneral hf , JSONObject pojoCfg) throws Exception {
    	
    	JSONArray pojos = pojoCfg.getJSONArray("pojos");
        for (int i = 0; i< pojos.size(); i++) {
        	JSONObject pojo = pojos.getJSONObject(i);
        	String model_name = pojo.getString("name");
            // 根
            Map<String, Object> root = new HashMap<String, Object>();
            String model_id_type = "String";
            String model_name_cn = model_name + "表";

            root.put("model_name", model_name);
            root.put("model_id_type", model_id_type);
            root.put("model_name_cn", model_name_cn);
            root.put("pks", pojo.getJSONArray("pks"));
            if(pojo.containsKey("blobs")){
            	root.put("blobs", pojo.getBoolean("blobs"));
            }

            // 项目路径
            //String projectPath = "F:\\soft_dev\\ide\\myeclipse10\\workspace\\upic\\";

            String fileName = model_name + "Service.java";

            //String savePath = "src//main//java//com//uwen//upic//model//service//sys//";

            Template template = cfg.getTemplate("general_service.ftl");
            // 生成接口
            hf.buildTemplate(root, ROOT_PATH, SERVICE_PATH, fileName, template);
            // 生成接口实现
            template = cfg.getTemplate("general_service_impl.ftl");
            fileName = model_name + "ServiceImpl.java";
            //savePath = "src//main//java//com//uwen//upic//model//service//sys//impl//";
            hf.buildTemplate(root, ROOT_PATH, SERVICE_IMPL_PATH, fileName, template);
        }

    }

    /**
     * 构建模版
     * 
     * @param root
     * @param projectPath
     * @param savePath
     * @param fileName
     * @param template
     */
    public void buildTemplate(Map<String, Object> root, String projectPath, String savePath, String fileName, Template template) {
        String realFileName = projectPath + savePath + fileName;

        String realSavePath = projectPath + "/" + savePath;

        File newsDir = new File(realSavePath);
        if (!newsDir.exists()) {
            newsDir.mkdirs();
        }

        try {
            // SYSTEM_ENCODING = "UTF-8";
            Writer out = new OutputStreamWriter(new FileOutputStream(realFileName), CommonConstants.SYSTEM_ENCODING);
            template.process(root, out);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static void gservice(){
    	try {
			ServicesGeneral hf = new ServicesGeneral();
			hf.init();
			//生产Service
			hf.process(hf, getAutoCfg());
		} catch (Exception e) {
			System.out.println("生成模版失败");
            e.printStackTrace();
            return;
        }
        System.out.println("生成模版成功");
    }
    
    public static JSONObject getAutoCfg() throws IOException{
    	InputStream is = ServicesGeneral.class.getClassLoader().getResourceAsStream("mg/auto_cfg.json");
        //包装流
        InputStreamReader isr = new InputStreamReader(is);
        //字符流
        BufferedReader bf = new BufferedReader(isr);
        //
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        //
        while ((line = bf.readLine()) != null) {
            stringBuilder.append(line);
        }
        
        return JSONObject.fromObject(stringBuilder.toString());
    }
    
    public static void gaction(){
    	try {
            ServicesGeneral hf = new ServicesGeneral();
            hf.init();
            //生产Service
            //hf.process(hf, new String[] { "Imgage", "Tag"});
            //生产ACTION
            //字节流
            hf.processAction(hf,getAutoCfg());
        } catch (Exception e) {
            System.out.println("生成模版失败");
            e.printStackTrace();
            return;
        }
        System.out.println("生成模版成功");
    }
    
    public static void main(String[] args) throws Exception {
    	gservice();
    	gaction();
    }

}
