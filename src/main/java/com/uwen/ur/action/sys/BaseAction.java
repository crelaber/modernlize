package com.uwen.ur.action.sys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

import com.uwen.ur.common.BasicJSON;
import com.uwen.ur.common.CommonConstants;
import com.uwen.ur.common.NormalDatagrid;

public class BaseAction {
	 /** @Fields serialVersionUID : 序列号 */
    private static final long serialVersionUID = 5399529876110147241L;
    //是否开启jsonConfig
    protected boolean enableJsonConfig = true;
    //jsonConfig
    protected JsonConfig jsonConfig = builderDefaultJsonConfig();
    
    protected Object $data;

    public Object get$data() {
        return $data;
    }
    
    /**
	* 设置失败的返回
	* @param msg
	* @return 
	* @return 返回类型 String   
	* @throws
	*/
	protected String setFail(String msg) {
		HashMap<String ,Object> map =  new HashMap<String, Object>();
		set$data(new BasicJSON(CommonConstants.STATE_FAIL,msg,map));
		return fail();
	}
	
	/**
	* 设置成功的返回
	* @param msg
	* @return 
	* @return 返回类型 String   
	* @throws
	*/
	protected String setSuccess(String msg,Object data){
		set$data(new BasicJSON(CommonConstants.STATE_SUCCESS,msg,data));
		return success();
	}
    /**
     * 根据传入的对象,设置当前对象值
     * @param $data 对象
     * @return this
     */
    public BaseAction set$data(Object $data) {
        this.$data = JSONObject.fromObject($data,jsonConfig);
        return this;
    }
    
    /**
     * 根据传入的对象,设置当前对象值
     * @param $data 对象
     * @return this
     */
    public BaseAction set$data(@SuppressWarnings("rawtypes") Collection $data) {
        this.$data = JSONArray.fromObject($data, jsonConfig);
        return this;
    }
    
    /**
     * 根据传入的对象,设置当前对象值并添加前缀
     * @param $data 对象
     * @param prefix 前缀
     * @return this
     */
    public BaseAction set$data(Object $data,String prefix) {
        this.$data = normalObj2MapAddPrefix($data,prefix);
        return this;
    }
    
    /**
     * 根据传入对象,追加到当前对象
     * @param $data
     * @return this
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public BaseAction append$data(Object $data) {
        validateData($data);
        validateDataIsMap();
        ((Map) this.$data).putAll(JSONObject.fromObject($data,jsonConfig));
        return this;
    }
    
    /**
     * 根据传入对象,追加到当前对象,并且添加前缀
     * @param $data
     * @param prefix
     * @return
     */
    public BaseAction append$data(Object $data,String prefix) {
        JSONObject obj2map = normalObj2MapAddPrefix($data,prefix);
        this.append$data(obj2map);
        return this;
    }
    
   
    /**
     * 网格数据
     * @param total 总条数
     * @param rows 条目
     * @return
     */
    public BaseAction set$datagrid(int total, Object rows) {
        this.$data = new NormalDatagrid(total, JSONArray.fromObject(rows, jsonConfig));
        return this;
    }
    
    /**
     * 根据传入对象,追加到当前对象
     * @param $data
     * @return this
     */
    /*
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public BaseAction append$data(Map $data) {
        if(null == this.$data){
            throw new RuntimeException("this.$data 不能为空");
        }
        if(null == $data){
            throw new RuntimeException("$data 不能为空");
        }
        if(!(this.$data instanceof Map)){//如果当前对象为MAP
            throw new RuntimeException("this.$data为"+this.$data.getClass()+",期待类型为Map");
        }
        ((Map) this.$data).putAll($data);
        return this;
    }
    */
    
    /**
     * 
     * @param $data
     * @param prefix
     * @return
     */
    /*
    @SuppressWarnings({"rawtypes" })
    public BaseAction append$data(Map $data,String prefix) {
        JSONObject obj2map = normalObj2MapAddPrefix($data,prefix);
        this.append$data(obj2map);
        return this;
    }
    */
    
    /**
     * 根据传入对象,追加到当前对象
     * @param $data
     * @return this
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public BaseAction append$data(Collection $data) {
        validateData($data);
        validateDataIsCollection($data);
        ((Collection) this.$data).addAll($data);
        return this;
    }
    
    private void validateDataIsMap() {
        if(!(this.$data instanceof Map)){//如果当前对象为MAP
            throw new RuntimeException("this.$data为"+this.$data+",期待类型为Map");
        }
    }

    private void validateData(Object $data) {
        if(null == this.$data){
            throw new RuntimeException("this.$data 不能为空");
        }
        if(null == $data){
            throw new RuntimeException("$data 不能为空");
        }
    }
    
    private void validateDataIsCollection(@SuppressWarnings("rawtypes") Collection $data2) {
        if(!(this.$data instanceof Collection)){//如果当前对象不为Collection
            throw new RuntimeException("this.$data为"+this.$data.getClass()+",期待类型为Collection");
        }
    }
    
    protected JsonConfig builderDefaultJsonConfig() {
        JsonConfig jsonConfig = new JsonConfig();
        //防止自包含
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        //设置日期格式
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            
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
        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            
            public boolean apply(Object obj, String name, Object value) {
                return value == null;
            }
        });
        return jsonConfig;
    }
    
    @Deprecated
    public static JsonConfig excludeNullJsonConfig(){
        JsonConfig jsonConfig = new JsonConfig();
        //防止自包含
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        //设置日期格式
        /*jsonConfig.registerJsonBeanProcessor(Date.class, new JsonBeanProcessor() {
            
            
            public JSONObject processBean(Object date, JsonConfig cfg) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss");
                String dateStr = dateFormat.format(date);
                return JSONObject.fromObject(dateStr);
            }
        });*/
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            
            
            public Object processObjectValue(String name, Object value, JsonConfig cfg) {
                if(!(value instanceof Date)) return null;
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateStr = dateFormat.format(value);
                return dateStr;
            }
            
            
            public Object processArrayValue(Object arg0, JsonConfig arg1) {
                // TODO Auto-generated method stub
                return null;
            }
        });
        //属性过滤
        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            
            public boolean apply(Object obj, String name, Object value) {
                return value == null;
            }
        });
        return jsonConfig;
    }
    
    /**
     * 
     * @param $data
     * @param prefix
     * @return
     */
    public JSONObject normalObj2MapAddPrefix(Object $data, String prefix) {
        //转换为JSONObject
        JSONObject obj2map = JSONObject.fromObject($data,jsonConfig);
        //缓存
        JSONObject temp2map = new JSONObject();
        //键列表
        @SuppressWarnings("unchecked")
        Set<Object> keys = obj2map.keySet();
        //遍历
        for (Object key : keys) {
            temp2map.put(prefix + key, obj2map.get(key));
        }
        //清空本身数据
        obj2map.clear();
        //放入缓存数据
        obj2map.putAll(temp2map);
        //返回对象
        return temp2map;
    }
    
    /**
     * 
     * @param $data
     * @return
     */
    public JSONObject normalObj2Map(Object $data){
        return JSONObject.fromObject($data,jsonConfig);
    }
    
    public static void main(String[] args) {
    }
    
    protected BaseAction clear(){
        this.$data = null;
        return this;
    }
    
    protected String fail(int state,String message){
        return "fail";
    }
    
    protected String fail(String message){
        return fail(0,message);
    }
    
    protected String fail(){
        return fail("操作失败!");
    }
    
    
    protected String success(int state,String message){
        return "success";
    }
    
    protected String success(String message){
        return success(200,message);
    }
    
    protected String success(){
        return success("操作成功!");
    }
    
    protected String exception(int state,String message){
        return "exception";
    }
    
    protected String exception(int state,Throwable t){
        return exception(state,t.toString());
    }
    
    protected String exception(Throwable t){
        return exception(t.toString());
    }
    
    protected String exception(int state,String message,Throwable t){
        return exception(state,message+":"+t.toString());
    }
    
    protected String exception(String message,Throwable t){
        return exception(message+":"+t.toString());
    }
    
    protected String exception(String message){
        return exception(500,message);
    }
    
    protected String exception(){
        return exception("操作异常!");
    }

}
