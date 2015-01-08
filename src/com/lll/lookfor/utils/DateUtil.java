package com.lll.lookfor.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.text.format.Time;
import android.util.Log;

public class DateUtil {
	// protected static Log logger = LogFactory.getLog(DateUtil.class);

	// 格式：年－月－日 小时：分钟：秒
	public static final String FORMAT_ONE = "yyyy-MM-dd HH:mm:ss";
	
	// 格式：年－月－日 小时：分钟
	public static final String FORMAT_TWO = "yyyy-MM-dd HH:mm";

	// 格式：年月日 小时分钟秒
	public static final String FORMAT_THREE = "yyyyMMdd-HHmmss";

	// 格式：年－月－日
	public static final String LONG_DATE_FORMAT = "yyyy-MM-dd";

	// 格式：月－日
	public static final String SHORT_DATE_FORMAT = "MM-dd";

	// 格式：小时：分钟：秒
	public static final String LONG_TIME_FORMAT = "HH:mm:ss";
	
	// 格式：小时：分钟
	public static final String LONG_TIME_FORMAT_SECOND = "HH:mm";

	// 格式：年-月
	public static final String MONTG_DATE_FORMAT = "yyyy-MM";
	
    // 格式: 年月日时分秒
    public static final String FORMAT_YYYYMMDDhhmmss = "yyyyMMddHHmmss";

	// 年的加减
	public static final int SUB_YEAR = Calendar.YEAR;

	// 月加减
	public static final int SUB_MONTH = Calendar.MONTH;

	// 天的加减
	public static final int SUB_DAY = Calendar.DATE;

	// 小时的加减
	public static final int SUB_HOUR = Calendar.HOUR;

	// 分钟的加减
	public static final int SUB_MINUTE = Calendar.MINUTE;

	// 秒的加减
	public static final int SUB_SECOND = Calendar.SECOND;

	static final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四",
			"星期五", "星期六" };

	@SuppressWarnings("unused")
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	
	public static final int SECONDS_IN_DAY = 60 * 60 * 24;
	
	public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;
	
	public DateUtil() {
	}

	/**
	 * 把符合日期格式的字符串转换为日期类型
	 * 
	 * @param dateStr
	 * @return
	 */
	public static java.util.Date stringtoDate(String dateStr, String format) {
		Date d = null;
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			formater.setLenient(false);
			d = formater.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			d = null;
		}
		return d;
	}

	/**
	 * 把符合日期格式的字符串转换为日期类型
	 */
	public static java.util.Date stringtoDate(String dateStr, String format,
			ParsePosition pos) {
		Date d = null;
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			formater.setLenient(false);
			d = formater.parse(dateStr, pos);
		} catch (Exception e) {
			d = null;
		}
		return d;
	}

	/**
	 * 把日期转换为字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(java.util.Date date, String format) {
		String result = "";
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			result = formater.format(date);
		} catch (Exception e) {
			// log.error(e);
		}
		return result;
	}

	/**
	 * 获取当前时间的指定格式
	 * 
	 * @param format
	 * @return
	 */
	public static String getCurrDate(String format) {
		return dateToString(new Date(), format);
	}

	/**
	 * 
	 * @param dateStr
	 * @param amount
	 * @return
	 */
	public static String dateSub(int dateKind, String dateStr, int amount) {
		Date date = stringtoDate(dateStr, FORMAT_ONE);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(dateKind, amount);
		return dateToString(calendar.getTime(), FORMAT_ONE);
	}

	/**
	 * 两个日期相减
	 * 
	 * @param firstTime
	 * @param secTime
	 * @return 相减得到的秒数
	 */
	public static long timeSub(String firstTime, String secTime) {
		long first = stringtoDate(firstTime, FORMAT_ONE).getTime();
		long second = stringtoDate(secTime, FORMAT_ONE).getTime();
		return (second - first) / 1000;
	}

	/**
	 * 获得某月的天数
	 * 
	 * @param year
	 *            int
	 * @param month
	 *            int
	 * @return int
	 */
	public static int getDaysOfMonth(String year, String month) {
		int days = 0;
		if (month.equals("1") || month.equals("3") || month.equals("5")
				|| month.equals("7") || month.equals("8") || month.equals("10")
				|| month.equals("12")) {
			days = 31;
		} else if (month.equals("4") || month.equals("6") || month.equals("9")
				|| month.equals("11")) {
			days = 30;
		} else {
			if ((Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 != 0)
					|| Integer.parseInt(year) % 400 == 0) {
				days = 29;
			} else {
				days = 28;
			}
		}

		return days;
	}

	/**
	 * 获取某年某月的天数
	 * 
	 * @param year
	 *            int
	 * @param month
	 *            int 月份[1-12]
	 * @return int
	 */
	public static int getDaysOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获得当前日期
	 * 
	 * @return int
	 */
	public static int getToday() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 获得当前月份
	 * 
	 * @return int
	 */
	public static int getToMonth() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获得当前年份
	 * 
	 * @return int
	 */
	public static int getToYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 返回日期的天
	 * 
	 * @param date
	 *            Date
	 * @return int
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 返回日期的年
	 * 
	 * @param date
	 *            Date
	 * @return int
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 返回日期的月份，1-12
	 * 
	 * @param date
	 *            Date
	 * @return int
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 计算两个日期相差的天数，如果date2 > date1 返回正数，否则返回负数
	 * 
	 * @param date1
	 *            Date
	 * @param date2
	 *            Date
	 * @return long
	 */
	public static long dayDiff(Date date1, Date date2) {
		return (date2.getTime() - date1.getTime()) / 86400000;
	}

	/**
	 * 比较两个日期的年差
	 * 
	 * @param befor
	 * @param after
	 * @return
	 */
	public static int yearDiff(String before, String after) {
		Date beforeDay = stringtoDate(before, LONG_DATE_FORMAT);
		Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
		return getYear(afterDay) - getYear(beforeDay);
	}

	/**
	 * 比较指定日期与当前日期的差
	 * 
	 * @param befor
	 * @param after
	 * @return
	 */
	public static int yearDiffCurr(String after) {
		Date beforeDay = new Date();
		Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
		return getYear(beforeDay) - getYear(afterDay);
	}

	/**
	 * 比较指定日期与当前日期的差
	 * 
	 * @param before
	 * @return
	 * @author chenyz
	 */
	public static long dayDiffCurr(String before) {
		Date currDate = DateUtil.stringtoDate(currDay(), LONG_DATE_FORMAT);
		Date beforeDate = stringtoDate(before, LONG_DATE_FORMAT);
		return (currDate.getTime() - beforeDate.getTime()) / 86400000;

	}

	/**
	 * 获取每月的第一周
	 * 
	 * @param year
	 * @param month
	 * @return
	 * @author chenyz
	 */
	public static int getFirstWeekdayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
		c.set(year, month - 1, 1);
		return c.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 获取每月的最后一周
	 * 
	 * @param year
	 * @param month
	 * @return
	 * @author chenyz
	 */
	public static int getLastWeekdayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
		c.set(year, month - 1, getDaysOfMonth(year, month));
		return c.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 获得当前日期字符串，格式"yyyy_MM_dd_HH_mm_ss"
	 * 
	 * @return
	 */
	public static String getCurrent() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		StringBuffer sb = new StringBuffer();
		sb.append(year).append("_").append(addzero(month, 2)).append("_")
				.append(addzero(day, 2)).append("_").append(addzero(hour, 2))
				.append("_").append(addzero(minute, 2)).append("_")
				.append(addzero(second, 2));
		return sb.toString();
	}

	/**
	 * 获得当前日期字符串，格式"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @return
	 */
	public static String getNow() {
		Calendar today = Calendar.getInstance();
		return dateToString(today.getTime(), FORMAT_ONE);
	}

	/**
	 * 根据生日获取星座
	 * 
	 * @param birth
	 *            YYYY-mm-dd
	 * @return
	 */
	public static String getAstro(String birth) {
		if (!isDate(birth)) {
			birth = "2000" + birth;
		}
		if (!isDate(birth)) {
			return "";
		}
		int month = Integer.parseInt(birth.substring(birth.indexOf("-") + 1,
				birth.lastIndexOf("-")));
		int day = Integer.parseInt(birth.substring(birth.lastIndexOf("-") + 1));
		String s = "魔羯水瓶双鱼牡羊金牛双子巨蟹狮子处女天秤天蝎射手魔羯";
		int[] arr = { 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 };
		int start = month * 2 - (day < arr[month - 1] ? 2 : 0);
		return s.substring(start, start + 2) + "座";
	}

	/**
	 * 判断日期是否有效,包括闰年的情况
	 * 
	 * @param date
	 *            YYYY-mm-dd
	 * @return
	 */
	public static boolean isDate(String date) {
		StringBuffer reg = new StringBuffer(
				"^((\\d{2}(([02468][048])|([13579][26]))-?((((0?");
		reg.append("[13578])|(1[02]))-?((0?[1-9])|([1-2][0-9])|(3[01])))");
		reg.append("|(((0?[469])|(11))-?((0?[1-9])|([1-2][0-9])|(30)))|");
		reg.append("(0?2-?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12");
		reg.append("35679])|([13579][01345789]))-?((((0?[13578])|(1[02]))");
		reg.append("-?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))");
		reg.append("-?((0?[1-9])|([1-2][0-9])|(30)))|(0?2-?((0?[");
		reg.append("1-9])|(1[0-9])|(2[0-8]))))))");
		Pattern p = Pattern.compile(reg.toString());
		return p.matcher(date).matches();
	}

	/**
	 * 取得指定日期过 months 月后的日期 (当 months 为负数表示指定月之前);
	 * 
	 * @param date
	 *            日期 为null时表示当天
	 * @param month
	 *            相加(相减)的月数
	 */
	public static Date nextMonth(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}

	/**
	 * 取得指定日期过 day 天后的日期 (当 day 为负数表示指日期之前);
	 * 
	 * @param date
	 *            日期 为null时表示当天
	 * @param month
	 *            相加(相减)的月数
	 */
	public static Date nextDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		cal.add(Calendar.DAY_OF_YEAR, day);
		return cal.getTime();
	}

	/**
	 * 取得距离今天 day 日的日期
	 * 
	 * @param day
	 * @param format
	 * @return
	 * @author chenyz
	 */
	public static String nextDay(int day, String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_YEAR, day);
		return dateToString(cal.getTime(), format);
	}

	/**
	 * 取得指定日期过 day 周后的日期 (当 day 为负数表示指定月之前)
	 * 
	 * @param date
	 *            日期 为null时表示当天
	 */
	public static Date nextWeek(Date date, int week) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		cal.add(Calendar.WEEK_OF_MONTH, week);
		return cal.getTime();
	}

	/**
	 * 获取当前的日期(yyyy-MM-dd)
	 */
	public static String currDay() {
		return DateUtil.dateToString(new Date(), DateUtil.LONG_DATE_FORMAT);
	}

	/**
	 * 获取昨天的日期
	 * 
	 * @return
	 */
	public static String befoDay() {
		return befoDay(DateUtil.LONG_DATE_FORMAT);
	}

	/**
	 * 根据时间类型获取昨天的日期
	 * 
	 * @param format
	 * @return
	 * @author chenyz
	 */
	public static String befoDay(String format) {
		return DateUtil.dateToString(DateUtil.nextDay(new Date(), -1), format);
	}

	/**
	 * 获取明天的日期
	 */
	public static String afterDay() {
		return DateUtil.dateToString(DateUtil.nextDay(new Date(), 1),
				DateUtil.LONG_DATE_FORMAT);
	}

	/**
	 * 取得当前时间距离1900/1/1的天数
	 * 
	 * @return
	 */
	public static int getDayNum() {
		int daynum = 0;
		GregorianCalendar gd = new GregorianCalendar();
		Date dt = gd.getTime();
		GregorianCalendar gd1 = new GregorianCalendar(1900, 1, 1);
		Date dt1 = gd1.getTime();
		daynum = (int) ((dt.getTime() - dt1.getTime()) / (24 * 60 * 60 * 1000));
		return daynum;
	}

	/**
	 * getDayNum的逆方法(用于处理Excel取出的日期格式数据等)
	 * 
	 * @param day
	 * @return
	 */
	public static Date getDateByNum(int day) {
		GregorianCalendar gd = new GregorianCalendar(1900, 1, 1);
		Date date = gd.getTime();
		date = nextDay(date, day);
		return date;
	}

	/** 针对yyyy-MM-dd HH:mm:ss格式,显示yyyymmdd */
	public static String getYmdDateCN(String datestr) {
		if (datestr == null)
			return "";
		if (datestr.length() < 10)
			return "";
		StringBuffer buf = new StringBuffer();
		buf.append(datestr.substring(0, 4)).append(datestr.substring(5, 7))
				.append(datestr.substring(8, 10));
		return buf.toString();
	}
	/** 针对yyyy-MM-dd HH:mm:ss格式,显示yyyyMMddHHmmss */
	public static String getYmdhhmmssDateCN(String datestr) {
		if (datestr == null)
			return "";
		if (datestr.length() < 10)
			return "";
		StringBuffer buf = new StringBuffer();
		buf.append(datestr.substring(0, 4)).append(datestr.substring(5, 7))
				.append(datestr.substring(8, 10)).append(datestr.substring(11, 13)).append(datestr.substring(14, 16)).append(datestr.substring(17, 19));
		return buf.toString();
	}
	/**
	 * 获取本月第一天
	 * 
	 * @param format
	 * @return
	 */
	public static String getFirstDayOfMonth(String format) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		return dateToString(cal.getTime(), format);
	}

	/**
	 * 获取本月最后一天
	 * 
	 * @param format
	 * @return
	 */
	public static String getLastDayOfMonth(String format) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		return dateToString(cal.getTime(), format);
	}

	/**
	 * 将元数据前补零，补后的总长度为指定的长度，以字符串的形式返回
	 * 
	 * @param sourceDate
	 * @param formatLength
	 * @return 重组后的数据
	 */
	public static String addzero(int sourceDate, int formatLength) {
		/*
		 * 0 指前面补充零 formatLength 字符总长度为 formatLength d 代表为正数。
		 */
		String newString = String.format("%0" + formatLength + "d", sourceDate);
		return newString;
	}
	
	/**
	 * 时间转星期
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String dateTimeToWeek(String dateTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String week = null;
		try {
			c.setTime(format.parse(dateTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (c.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			week = "周日";
			break;
		case 2:
			week = "周一";
			break;
		case 3:
			week = "周二";
			break;
		case 4:
			week = "周三";
			break;
		case 5:
			week = "周四";
			break;
		case 6:
			week = "周五";
			break;
		case 7:
			week = "周六";
			break;
		}
		return week;
	}
	
	/**
	 * 将时间格式字符串转换成时间戳
	 * 
	 * @param Sdate
	 * @return
	 */
	public static long dateToMillis(String Sdate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
	
	/**
	 * 根据时间戳判断两个时间是否是同一天
	 * 
	 * @param ms1
	 * @param ms2
	 * @return
	 */
	public static boolean isSameDayOfMillis(long ms1, long ms2) {
		final long interval = ms1 - ms2;
		return interval < MILLIS_IN_DAY && interval > -1L * MILLIS_IN_DAY
				&& toDay(ms1) == toDay(ms2);
	}
	

	private static long toDay(long millis) {
		return (millis + TimeZone.getDefault().getOffset(millis))
				/ MILLIS_IN_DAY;
	}
	
	/**
	 * 获取指定格式的时间的差 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
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
	/**
	 * 格式化时间差
	 * @param time
	 * @return
	 */
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
	
	/**
	 * 计算 指定时间与当前系统时间的时间差
	 * @param dateTime
	 * @return
	 */
	public static String getTimeDifference(String dateTime,String endTime) {
		DateFormat df = new SimpleDateFormat(FORMAT_ONE);
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
            			timeDifference.append("回看");
            		}
            		
            	}
            	
            }else if(days > 0){
            	Time t=new Time(); // or Time t=new Time("GMT+8"); 加上Time Zone资料。
            	t.set(d1.getTime());
            	timeDifference.append(t.month+1).append("月").append(t.monthDay).append("日播出");
            }else{
            	timeDifference.append("回看");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeDifference.toString();
	}
	
	public static long getTimeDifferenceToSecond(String endTime){
		DateFormat df = new SimpleDateFormat(FORMAT_ONE);
		long l = 0;
		try {
			Date d1 = df.parse(endTime);
			long d = System.currentTimeMillis() - d1.getTime();
			l = (d/1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public static long getTimeDifferenceToSecond(String startTime,String endTime){
		DateFormat df = new SimpleDateFormat(FORMAT_ONE);
		long l = 0;
		try {
			Date d1 = df.parse(startTime);
			Date d2 = df.parse(endTime);
			l = (d2.getTime()-d1.getTime())/1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	/**
	 * 计算 指定时间与当前系统时间的时间差
	 * @param dateTime
	 * @return
	 */
	public static String getTimeDifferenceToShifting(String dateTime,String endTime) {
		DateFormat df = new SimpleDateFormat(FORMAT_ONE);
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
			
            if(days == 0){
            	if(hours>=0 && minutes>=0){
            		timeDifference.append("预约");
            	}else{
            		if(hours_end >= 0 && minutes_end >= 0){
            			timeDifference.append("正在直播");
            		}else{
            			timeDifference.append("回看");
            		}
            	}
            }else if(days > 0){
            	Time t=new Time(); // or Time t=new Time("GMT+8"); 加上Time Zone资料。
            	t.set(d1.getTime());
            	timeDifference.append("预约");
            }else{
            	timeDifference.append("回看");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeDifference.toString();
	}
	
	/**
	 * 返回日期的天
	 * 
	 * @param date
	 *            Date
	 * @return int
	 */
	public static int getDay(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date2;
		Calendar calendar = null;
		try {
			date2 = format.parse(date);
			calendar = Calendar.getInstance();
			calendar.setTime(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return calendar == null ? 0 : calendar.get(Calendar.DATE);
	}
	
	public static int getDateDiff(String data) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		int diff = -1;
		try {
			Date date = format.parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int i = calendar.get(Calendar.DATE);
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(new Date(System.currentTimeMillis()));
			int j = calendar2.get(Calendar.DATE);
			diff = i - j;
			// MyLog.e("sudan", "节目日期 = "+i+" 当前日期 = "+j+"  日期差 = "+diff);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return diff;
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
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_ONE);
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
    
	
	
	/**
	 * 获取时移后的时间
	 * @param shiftTime
	 * @return
	 */
	public static String getTimeShifting(long shiftTime){
		long currentTimeMillis  = System.currentTimeMillis();
		long l = currentTimeMillis - shiftTime;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(l);
		return dateToString(calendar.getTime(), FORMAT_ONE);
	}
	
	/**
	 * 从完整的日期时间中截取时、分
	 * @param date
	 * @return
	 */
	public static String getDateToTime(String date){
		Calendar calendar = Calendar.getInstance();
		if(date == null){
			calendar.setTime(new Date());
		}else{
			Date date2 = stringtoDate(date, FORMAT_ONE);
			calendar.setTime(date2);
		}
		
		return dateToString(calendar.getTime(), LONG_TIME_FORMAT_SECOND);
	}
	
	/**
	 * 比较两个时间大小
	 * @param time1
	 * @param time2
	 * @return  true time1相等time2、time1小于time2
	 *          false time1大于time2
	 */
	public static boolean compareTime(String time1,String time2){
		java.text.DateFormat df=new java.text.SimpleDateFormat(FORMAT_ONE);
		Calendar c1=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
		try{
		   c1.setTime(df.parse(time1));
		   c2.setTime(df.parse(time2));
		}catch(java.text.ParseException e){
		   System.err.println("格式不正确");
		}
		int result=c1.compareTo(c2);
		if(result==0){
		   System.out.println("time1相等time2");
		   return true;
	    }else if(result<0){
		   System.out.println("time1小于time2");
		   return true;
		}else{
			 System.out.println("time1大于time2");
			return false;
		}
	}
	/**
	 * 比较两个消息时间大小,从大到小排序
	 * @param time1
	 * @param time2
	 * @return  true time1相等time2、time1小于time2
	 *          false time1大于time2
	 */
	public static int compareMsgTime(String time1,String time2){
		java.text.DateFormat df=new java.text.SimpleDateFormat(FORMAT_ONE);
		Calendar c1=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
		try{
		   c1.setTime(df.parse(time1));
		   c2.setTime(df.parse(time2));
		}catch(java.text.ParseException e){
		   System.err.println("格式不正确");
		}
		int result=c1.compareTo(c2);
		if(result==0){
		   System.out.println("time1相等time2");
		   return 0;
	    }else if(result<0){
		   System.out.println("time1小于time2");
		   return 1;
		}else{
			 System.out.println("time1大于time2");
			return -1;
		}		
	}
	
	public static String getTVODTime(String date) {
		if(date == null || date.length()==0){
			return "";
		}
		int index = date.indexOf(".");
		if(index > 0){
			date = date.substring(0,index);
		}
		String string = "";
		try{
			Date date2 = stringtoDate(date, FORMAT_ONE);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date2);
			string = dateToString(calendar.getTime(), FORMAT_YYYYMMDDhhmmss);
		}catch(Exception e){
			e.printStackTrace();
		}
		return string;
	}
	
	/**
	 * 时间格式转换
	 * @param date  yyyyMMddHHmmss
	 * @return LONG_DATE_FORMAT
	 */
	public static String getProgramDate(String date){
		if(date == null || date.length() == 0){
			return "";
		}
		String string = "";
		try{
			Date date2 = stringtoDate(date, FORMAT_YYYYMMDDhhmmss);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date2);
			string = dateToString(calendar.getTime(), LONG_DATE_FORMAT);
		}catch(Exception e){
			e.printStackTrace();
		}
		return string;
	}
	
	/**
	 * 时间格式转换
	 * @param date  yyyyMMddHHmmss
	 * @return LONG_DATE_FORMAT
	 */
	public static String getProgramStartTime(String date){
		if(date == null || date.length() == 0){
			return "";
		}
		String string = "";
		try{
			Date date2 = stringtoDate(date, FORMAT_YYYYMMDDhhmmss);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date2);
			string = dateToString(calendar.getTime(), FORMAT_ONE);
		}catch(Exception e){
			e.printStackTrace();
		}
		return string;
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
}
