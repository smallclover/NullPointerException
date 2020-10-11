package com.smallclover.nullpointerexception.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

/**
 * 请求端ip地址获取
 * @Author: Amadeus
 * @Date: 2020/5/9 20:51
 */
public class IPAddressUtils {
    // 这是一个 Squid 开发的字段，只有在通过了HTTP代理或者负载均衡服务器时才会添加该项。
    // 格式为X-Forwarded-For:client1,proxy1,proxy2，
    // 一般情况下，第一个ip为客户端真实ip，后面的为经过的代理服务器ip。现在大部分的代理都会加上这个请求头。
    public static final String X_FORWARDED_FOR = "x-forwarded-for";
    // 这个一般是经过apache http服务器的请求才会有，
    // 用apache http做代理时一般会加上Proxy-Client-IP请求头，而WL-Proxy-Client-IP是他的weblogic插件加上的头。
    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    // 有些代理服务器会加上此请求头。
    public static final String HTTP_CLIENT_IP = "Http_Client_IP";
    public static final String UNKNOWN = "unknown";
    public static final String X_REAL_IP = "X-Real-IP";

    /**
     * 获取ip地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader(X_FORWARDED_FOR);
        if (isIP(ip)) {
            ip = request.getHeader(PROXY_CLIENT_IP);
        }
        if (isIP(ip)) {
            ip = request.getHeader(WL_PROXY_CLIENT_IP);
        }
        if (isIP(ip)) {
            ip = request.getHeader(HTTP_CLIENT_IP);
        }
        if (isIP(ip)) {
            ip = request.getHeader(X_REAL_IP);
        }
        if (isIP(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            return ip.split(",")[0];
        } else {
            return ip;
        }
    }

    /**
     * 判断IP是否不存在
     * @param ip
     * @return
     */
    private static boolean isIP(String ip){
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)){
            return true;
        }
        return false;
    }

    /**
     * 获取格式化的uri
     * @param uri
     * @return
     */
    public static ImmutablePair</**host*/String, /**uri*/String> formatUri(String uri) {
        URI u = URI.create(uri);
        String host = u.getHost();
        if (u.getPort() > 0 && u.getPort() != 80) {
            host = host + ":80";
        }

        String baseUri = u.getPath();
        if (u.getFragment() != null) {
            baseUri = baseUri + "#" + u.getFragment();
        }

        if (StringUtils.isNotBlank(baseUri)) {
            baseUri = host + baseUri;
        } else {
            baseUri = host;
        }

        return ImmutablePair.of(host, baseUri);
    }

}
