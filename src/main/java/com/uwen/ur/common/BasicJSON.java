package com.uwen.ur.common;

import java.io.Serializable;

/**
 * 
 * 文件名称: BasicJSON.java 内容摘要:基本JSON数据传输对象
 * 
 * @author: 姜玮
 * @version: 1.0
 * @Date: 2012-6-3 下午02:02:50
 * 
 *        修改历史: 修改日期 修改人员 版本 修改内容 ----------------------------------------------
 *        2012-6-3 姜玮 1.0 1.0 无
 * 
 *        版权: 版权所有(C)2012 公司: 华诚信息科技股份有限公司
 */
public class BasicJSON implements Serializable {
    /** @Fields serialVersionUID : 序列号 */
    private static final long serialVersionUID = -1219966031755770586L;
    
    /**
     * 状态
     * 0-199 失败 200-499 成功 500 - 无穷大 异常
     * [1:未登陆]
     */
    private Integer state;
    private String message;
    private Object data;

    public BasicJSON() {
    }

    public BasicJSON(Object data) {
        this.data = data;
    }

    public BasicJSON(Integer state, String message, Object data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}

	public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
