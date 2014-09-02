package com.uwen.ur.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: haobl
 * Date: 13-3-5
 * Time: 下午5:49
 * To change this template use File | Settings | File Templates.
 */
public class CommonUtils {

    public  static  String getServerIP() {
        String ip="";
        InetAddress serverIPAddress;
        try {
            serverIPAddress = InetAddress.getLocalHost();
            ip=  serverIPAddress.getHostAddress();
        } catch (UnknownHostException e) {
            ip="UnknownHostException";
        }
        return ip;
    }

}
