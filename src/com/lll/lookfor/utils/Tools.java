package com.lll.lookfor.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.lll.lookfor.model.HooProgram;

public class Tools {
	/**
	 * MD5参数签名后缀
	 */
	private static final String AppSecret = "123456";

	/**
	 * MD5加密
	 * 
	 * @param s
	 *            加密字符串
	 * @return
	 */
	public final static String MD5(String s) {
		String sign = s + AppSecret;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = sign.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 判断当前时间和指定时间区间的关系
	 * 
	 * @param firstTime
	 *            yyyy-MM-dd HH:mm:ss 格式的时间
	 * @param secondTime
	 * @return 0 在指定时间区间之前 1 在指定时间区间之内 2 在指定时间区间之后
	 */
	public static int relativeCurrentSysTime(String firstTime, String secondTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			long firstDate = format.parse(firstTime).getTime();
			long secondDate = format.parse(secondTime).getTime();
			long currentTime = System.currentTimeMillis();
			if (currentTime >= firstDate && currentTime <= secondDate) {
				return 1;
			} else if (currentTime < firstDate) {
				return 0;
			} else {
				return 2;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e("Tools", e.toString());
		}
		return 0;
	}

	public static String dateToTime(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");
		String time = null;
		try {
			Date date2 = format.parse(date);
			time = format2.format(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;

	}

	/**
	 * 从对象获取一个字节数组
	 * 
	 * @EditTime
	 */
	public static byte[] getBytesFromObject(Serializable obj) throws Exception {
		if (obj == null) {
			return null;
		}
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(obj);
		return bo.toByteArray();
	}

	/**
	 * 从字节数组获取对象
	 * 
	 * @EditTime
	 */
	public static Object getObjectFromBytes(byte[] objBytes) throws Exception {
		if (objBytes == null || objBytes.length == 0) {
			return null;
		}
		ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
		ObjectInputStream oi = new ObjectInputStream(bi);
		return oi.readObject();
	}

	/**
	 * 将时间格式字符串转换成时间戳
	 * 
	 * @param Sdate
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	public static long timeToMillis(String Sdate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = null;
		long timeStemp = 0;
		try {
			date = simpleDateFormat.parse(Sdate);
			timeStemp = date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return timeStemp;
	}

	public static long getTVODTime(String date) {
		long l = timeToMillis(date);
		return l / 1000;

	}

	/**
	 * 拼接回看地址
	 * 
	 * @param hooProgram
	 * @return
	 */
	public static String jointPlayUrl(HooProgram hooProgram) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(hooProgram.getBackPlayURL()).append("&shifttime=");
		stringBuffer.append(getTVODTime(hooProgram.getStartTime())).append("&shiftend=");
		stringBuffer.append(getTVODTime(hooProgram.getEndTime()));
				
		return stringBuffer.toString();
	}

	public static String jointPlayUrl(String playUrl, String startTime,
			String endTime) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(playUrl).append("&shifttime=").append(getTVODTime(startTime)).append("&shiftend=");
		stringBuffer.append(getTVODTime(endTime));
		
		return stringBuffer.toString();
	}

	private static Animation mEnlarger;

	private static Animation mLessen;

	public static void executeTo(View view, boolean enlarger) {
		mEnlarger = getScaleAnim(view, true);
		mLessen = getScaleAnim(view, false);
		if (enlarger) {
			view.bringToFront();
			view.startAnimation(mEnlarger);
		} else {
			view.startAnimation(mLessen);
		}

	}

	private static Animation getScaleAnim(View view, boolean enlarger) {
		int width = view.getMeasuredWidth();
		int height = view.getMeasuredHeight();

		int interval = Math.round(10);
		int duration;
		float fromX, toX, fromY, toY;
		if (enlarger) {
			fromX = 1.0f;
			fromY = 1.0f;
			toX = (float) (width + interval * 2) / width;
			toY = (float) (height + interval * 2) / height;
			duration = 120;
		} else {
			fromX = (float) (width + interval * 2) / width;
			fromY = (float) (height + interval * 2) / height;
			toX = 1.0f;
			toY = 1.0f;
			duration = 120;
		}
		Animation anim = new ScaleAnimation(fromX, toX, fromY, toY,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		anim.setFillAfter(true);
		anim.setDuration(duration);
		return anim;
	}
	
	/**
	 * 计算 指定时间与当前系统时间的时间差
	 * @param dateTime
	 * @return
	 */
	public static String getTimeDifference(String dateTime,String endTime) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer timeDifference = new StringBuffer();
		try {
			Date d1 = df.parse(dateTime);
			Date d2 = df.parse(endTime);
			long diff = d1.getTime() - System.currentTimeMillis();// 这样得到的差值是微秒级别
			long diff_end = d2.getTime() - System.currentTimeMillis();// 这样得到的差值是微秒级别
			long days = diff / (1000 * 60 * 60 * 24);
			long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
			long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
			
			long days_end = diff_end / (1000 * 60 * 60 * 24);
			long hours_end = (diff_end-days_end*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
			long minutes_end = (diff_end-days_end*(1000 * 60 * 60 * 24)-hours_end*(1000* 60 * 60))/(1000* 60);
			
			//格式化数据
			String pattern ="00";
			DecimalFormat format = new DecimalFormat(pattern); 
            if(days == 0){
            	if(hours>=0 && minutes>=0){
            		timeDifference.append(format.format(hours)).append(":").append(format.format(minutes)).append("后播出");
            	}else{
            		if(hours_end >= 0 && minutes_end >= 0){
            			timeDifference.append("正在直播");
            		}else{
            			timeDifference.append("已过期");
            		}
            		
            	}
            	
            }else if(days > 0){
            	Time t=new Time(); // or Time t=new Time("GMT+8"); 加上Time Zone资料。
            	t.set(d1.getTime());
            	timeDifference.append(t.month+1).append("月").append(t.monthDay).append("日播出");
            }else{
            	timeDifference.append("已过期");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeDifference.toString();
	}
	
	public static String getTimeDifferenceToTime(String startTime,String endTime){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date startDate = df.parse(startTime);
			Date endDate = df.parse(endTime);
			long l = endDate.getTime()-startDate.getTime();
			return getTime(l);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "00:00:00";
		
	}
	
	public static String getTime(long time){
		StringBuffer buffer = new StringBuffer();
		long hours = (time / (1000 * 60 * 60));  
		long minutes = (time - hours * (1000 * 60 * 60)) / (1000 * 60);  
		long seconds = (time - hours * (1000 * 60 * 60) - minutes * (1000 * 60)) / 1000;
		//格式化数据
		String pattern ="00";
		DecimalFormat format = new DecimalFormat(pattern); 
		buffer.append(format.format(hours)).append(":").append(format.format(minutes)).append(":").append(format.format(seconds));
        return  buffer.toString();  
	}
	
	/**字符串转化为数字*/
	public static int String2Integer(String str, int defaultInt) {
		int i;
		try {
			i = Integer.parseInt(str);
		} catch (Exception e) {
			i = defaultInt;
		}
		return i;
	}
}
