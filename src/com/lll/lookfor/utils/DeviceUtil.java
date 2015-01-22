/**
 * 文件名称 : DeviceUtil.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年5月6日, 下午8:36:04
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 * 设备相关工具集
 * 1.获取imei
 * 2.获取imsi
 * 3.获取mac
 **/
package com.lll.lookfor.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;

/**
 * @author LIJUNJIE
 *
 */
public class DeviceUtil {
    //mac地址
    static String mac;
    //内存总数
    static long memory;
    /**
     * 获取设备上的Mac地址
     * 缓存数据,增强响应速度
     * 当缓存过MAC地址时，直接返回上次取到的mac地址，否则取mac地址。
     * mac地址取失败时，返回null。
     * 传入context为空时，返回空串.
     * @param context
     * @return mac地址
     */
    public static String getMACAddress(Context context) {
        if(mac != null && mac.length() > 0){
            return mac;
        }
        //context为空直接返回空串
        if(context == null){
            return "";
        }
        //获取mac并缓存
        else{
    		ConnectivityManager conMan = (ConnectivityManager) context
    				.getSystemService(Context.CONNECTIVITY_SERVICE);
    		State wifi_state = conMan.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
    				.getState();
    		//手机没有ehternet得到的networkinfo为NULL
    		NetworkInfo networkInfo = conMan.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET);
    		//默认网卡不可用
    		State net_state =State.DISCONNECTED;
    		if(networkInfo != null ){
    			net_state = networkInfo.getState(); 
    		}
    				
    		if(wifi_state == State.CONNECTED){
    		      WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);  
    	          WifiInfo info = wifi.getConnectionInfo();  
    	          mac = info.getMacAddress();
    		}else if(net_state == State.CONNECTED){
    			mac = getEthernetNetworkMACAddress();
    		}
        }
        return mac;
    }
    
    public static String getAndroidID(Context context){        
       return Secure.getString(context.getContentResolver(),Secure.ANDROID_ID); 
    }
    
    public static String getLANMacAddress(){
        String filePath = "/sys/class/net/eth0/address";
        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            char[] buf = new char[1024];
            int numRead=0;
            while((numRead=reader.read(buf)) != -1){
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
            }
            reader.close();
        }
        catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fileData.toString();
    }
    public static long getTotalMemory(){
        return memory;
    }
    
    /**
     * 清理后台程序
     * @param context
     */
    public static void clearMemory(Context context){
        ActivityManager activityManger=(ActivityManager) context.getSystemService(context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> list=activityManger.getRunningAppProcesses();
        if(list!=null){
            for(int i=0;i<list.size();i++){
                ActivityManager.RunningAppProcessInfo apinfo=list.get(i);
                System.out.println("pid            "+apinfo.pid);
                System.out.println("processName              "+apinfo.processName);
                System.out.println("importance            "+apinfo.importance);
                String[] pkgList=apinfo.pkgList;
                if(apinfo.importance>ActivityManager.RunningAppProcessInfo.IMPORTANCE_SERVICE)
                {
                    for(int j=0;j<pkgList.length;j++){
                    	try{
                    		//结束非Hooray的程序
                    		if(!apinfo.processName.contains("hooray")){
                    			activityManger.killBackgroundProcesses(pkgList[j]);	
                    		}
                    	}
                        catch(Exception e){
                        	e.printStackTrace();
                        }
                    } 
                }
            }
        }
    }
    //dp转px
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  
    
    //px转dp
    public static int px2dip(Context context, float pxValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }  
    //获取IP地址
    public static String getLocalIpAddress() { 
        try { 
          for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) { 
            NetworkInterface intf = en.nextElement(); 
            for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) { 
              InetAddress inetAddress = enumIpAddr.nextElement(); 
              if (!inetAddress.isLoopbackAddress()) { 
              return inetAddress.getHostAddress().toString(); 
            } 
          } 
        } 
        } catch (SocketException ex) { 
             
        } 
        return null; 
      } 
    /**
     * 获取以太网卡MAC地址
     * @return
     */
	public static String getEthernetNetworkMACAddress(){
		NetworkInterface NIC;
		StringBuffer mac = new StringBuffer();
		try {
			NIC = NetworkInterface.getByName("eth0");
			byte[] buf = NIC.getHardwareAddress();
			for (int i = 0; i < buf.length; i++) {
				String hex = Integer.toHexString(buf[i] & 0xFF);
				if(hex.length() == 1){
					mac.append("0"+hex);
				}else{
					mac.append(hex);
				}
			}
			Log.e("DeviceUtil", "mac = "+mac.toString());
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mac.toString();
	}
}
