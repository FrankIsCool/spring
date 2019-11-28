package com.frank.user.api.ip;

import com.frank.user.api.ip.ali.AliIPApi;
import com.frank.user.api.ip.ali.bean.*;
import com.frank.user.api.ip.bj.BJIPApi;
import com.frank.user.api.ip.bj.bean.BJData;
import com.frank.user.api.ip.bj.bean.BJResult;
import com.frank.user.api.ip.cha.ChaIPApi;
import com.frank.user.api.ip.cha.bean.ChaData;
import com.frank.user.api.ip.cha.bean.ChaResult;
import com.frank.user.api.ip.free.FreeIPApi;
import com.frank.user.api.ip.free.bean.FreeAddress;
import com.frank.user.api.ip.ipip.IPIPApi;
import com.frank.user.api.ip.ipip.bean.IPIPData;
import com.frank.user.api.ip.juhe.JHIPApi;
import com.frank.user.api.ip.juhe.bean.JHIPData;
import com.frank.user.api.ip.juhe.bean.JHResult;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPApi {
    /**
     * 根据ip获取地址
     *
     * @param ip
     * @return
     */
    public static IPAddressVo getAddress(String ip) {
        if (StringUtils.isEmpty(ip)) {
            return null;
        }
        IPAddressVo ipAddressVo = new IPAddressVo();
        ipAddressVo.setIp(ip);

        //河南复数
        FSIPResult addressByFS = AliIPApi.getAddressByFS(ip);
        if (null != addressByFS && null != addressByFS.getData()) {
            FSIPData ipData = addressByFS.getData();
            ipAddressVo.setCountry(ipData.getCountry());
            ipAddressVo.setProvince(ipData.getProv());
            ipAddressVo.setCity(ipData.getCity());
            ipAddressVo.setIsp(ipData.getIsp());
            return ipAddressVo;
        }
        //高德
        GDIPResult addressByGD = AliIPApi.getAddressByGD(ip);
        if (null != addressByGD) {
//            ipAddressVo.setCountry(addressByGD.get());
            ipAddressVo.setProvince(addressByGD.getProvince());
            ipAddressVo.setCity(addressByGD.getCity());
            ipAddressVo.setIsp(addressByGD.getInfocode());
            return ipAddressVo;
        }
        //华辰
        HCIPResult addressByHC = AliIPApi.getAddressByHC(ip);
        if (null != addressByHC && null != addressByHC.getData()) {
            HCIPData ipData = addressByHC.getData();
            ipAddressVo.setCountry(ipData.getCountry());
            ipAddressVo.setProvince(ipData.getRegion());
            ipAddressVo.setCity(ipData.getCity());
            ipAddressVo.setIsp(ipData.getIsp());
            return ipAddressVo;
        }
        //易源
        YYIPResult addressByYY = AliIPApi.getAddressByYY(ip);
        if (null != addressByYY && null != addressByYY.getShowapiResBody()) {
            YYIPData ipData = addressByYY.getShowapiResBody();
            ipAddressVo.setCountry(ipData.getCountry());
            ipAddressVo.setProvince(ipData.getRegion());
            ipAddressVo.setCity(ipData.getCity());
            ipAddressVo.setIsp(ipData.getIsp());
            return ipAddressVo;
        }
        BJResult bjResult = BJIPApi.getAdress(ip);
        if (null != bjResult && null != bjResult.getData()) {
            BJData ipData = bjResult.getData();
            ipAddressVo.setCountry(ipData.getCountry());
            ipAddressVo.setProvince(ipData.getProvince());
            ipAddressVo.setCity(ipData.getCity());
            ipAddressVo.setIsp(ipData.getIsp());
            return ipAddressVo;
        }
        //91cha
        ChaResult chaResult = ChaIPApi.getAdress(ip);
        if (null != chaResult && null != chaResult.getData()) {
            ChaData ipData = chaResult.getData();
            ipAddressVo.setCountry(ipData.getCountry());
            ipAddressVo.setProvince(ipData.getProvince());
            ipAddressVo.setCity(ipData.getCity());
            ipAddressVo.setIsp(ipData.getLinetype());
            return ipAddressVo;
        }
        FreeAddress freeAddress = FreeIPApi.getAdress(ip);
        if (null != freeAddress) {
            ipAddressVo.setCountry(freeAddress.getCountry());
            ipAddressVo.setProvince(freeAddress.getProvince());
            ipAddressVo.setCity(freeAddress.getCity());
            ipAddressVo.setIsp(freeAddress.getIsp());
            return ipAddressVo;
        }
        IPIPData ipipData = IPIPApi.getAdress(ip);
        if (null != ipipData) {
            ipAddressVo.setCountry(ipipData.getCountry());
            ipAddressVo.setProvince(ipipData.getProvince());
            ipAddressVo.setCity(ipipData.getCity());
            ipAddressVo.setIsp(ipipData.getIsp());
            return ipAddressVo;
        }
        JHResult<JHIPData> jhResult = JHIPApi.getAddress(ip);
        if (null != jhResult && null != jhResult.getResult()) {
            JHIPData ipData = jhResult.getResult();
            ipAddressVo.setCountry(ipData.getCountry());
            ipAddressVo.setProvince(ipData.getProvince());
            ipAddressVo.setCity(ipData.getCity());
            ipAddressVo.setIsp(ipData.getIsp());
            return ipAddressVo;
        }

        return null;
    }

    /**
     * 获取ip地址
     *
     * @param request
     * @return
     */
    public static IPAddressVo getAddress(HttpServletRequest request) {
        String ipAddr = getIpAddr(request);
        if (StringUtils.isEmpty(ipAddr)) {
            return null;
        }
        return getAddress(ipAddr);
    }

    /**
     * 获取当前网络ip
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
}
