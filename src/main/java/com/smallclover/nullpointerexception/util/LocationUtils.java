package com.smallclover.nullpointerexception.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: Amadeus
 * @Date: 2020/2/15 16:18
 * 获取位置信息
 */
@Slf4j
public class LocationUtils {
    public static final String X_FORWARDED_FOR = "X-Forwarded-For";
    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    public static final String X_REAL_IP = "X-Real-IP";

    public static final String UNKNOWN = "unknown";
    public static final String LOCALHOST = "127.0.01";
    public static final String MAC = "0:0:0:0:0:0:0:1";

    /**
     * 根据request header来获取ip地址
     * @param request 请求
     * @return 字符串类型的ip地址
     */
    public static String getIp(HttpServletRequest request){
        String ip = request.getHeader(X_FORWARDED_FOR);
        if (!isExist(ip)){
            ip = request.getHeader(PROXY_CLIENT_IP);
        }
        if (!isExist(ip)){
            ip = request.getHeader(WL_PROXY_CLIENT_IP);
        }
        if (!isExist(ip)){
            ip = request.getHeader(X_REAL_IP);
        }
        if (!isExist(ip)){
            ip = request.getRemoteAddr();
            if (ip.equals(LOCALHOST) || ip.equals(MAC)){
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    log.error("Class: " + "LocationUtils");
                    log.error("Method: " + "getIp");
                }
                ip = inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        // "***.***.***.***".length()
        if(ip != null && ip.length() > 15){
            if (ip.indexOf(",") > 0){
                ip = ip.substring(0, ip.indexOf(","));
            }
        }

        return ip;
    }

    /**
     * 判断指定的request header是否存在
     * @param ip ip 地址
     * @return 如果不存在返回false，反之返回true
     */
    private static boolean isExist(String ip){
        if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)){
            return false;
        }
        return true;
    }
}
