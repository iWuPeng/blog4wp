package com.wupeng.blog.util.lang;

import java.util.*;
import java.io.*;


public class DateUtil {

	public static int SUNDAY = 1;
	public static int MONDAY = 2;
	public static int TUESDAY = 3;
	public static int WEDNESDAY = 4;
	public static int THURSDAY = 5;
	public static int FRIDAY = 6;
	public static int SATURDAY = 7;

	/** @serial 1~366*/
	private int year;
	/** @serial 0~11 */
	private int month;
	/**day:1~31*/
	private int day;
    /**intDayOfWeek:1~7对应于Sun~Sat*/
	private int intDayOfWeek;
    /**intDayOfMonth:1~31*/
	private int intDayOfMonth;
    /**intDayOfYear:1~366*/
	private int intDayOfYear;
	/**intWeekOfMonth:1~6*/
    private int intWeekOfMonth;
    /**intWeekOfYear:1~54*/
	private int intWeekOfYear;

	/** 时间 */
	/** intHourOfDay 0~23 二十四小时制*/
	private int intHourOfDay;
	/** hour 0~12 十二小时制*/
	private int hour;
	/** minute 0~59*/
	private int minute;
	/** second 0~59 */
	private int second;
	/** millisecond 0~999*/
	private int millisecond;
    /**是否为上午:0-上午;1-下午*/
	private int intPmFlag;
    /**mylocal实例*/
    private Locale mylocal;
    /**todaysDate实例*/
	private GregorianCalendar todaysDate = null;

	/**
     * DateUtil构造函数
     */
    public DateUtil() {
		todaysDate = new GregorianCalendar();
		year = todaysDate.get(Calendar.YEAR);
		month = todaysDate.get(Calendar.MONTH) + 1;
		day = todaysDate.get(Calendar.DAY_OF_MONTH);
		hour = todaysDate.get(Calendar.HOUR_OF_DAY);
		minute = todaysDate.get(Calendar.MINUTE);
		second = todaysDate.get(Calendar.SECOND);
	}

	/**
	 * 设置当前日期 zb add at 2002-04-16
	 */
	public void setNow() {
		todaysDate = new GregorianCalendar();
	}

	/**
	 * 得到系统时间的年份
	 * @param degree 几进制,取值为2,8,10,16
	 * @return 系统时间的年份
	 */
	public String getSystemYear(int degree) {

		String systemdate = "";
		year = todaysDate.get(Calendar.YEAR);
		if (year < 100)
			year += 1900;

		if (degree == 2)
			systemdate += "" + Integer.toBinaryString(year);
		else if (degree == 8)
			systemdate += "" + Integer.toOctalString(year);
		else if (degree == 16) {
			systemdate += "0" + Integer.toHexString(year);
		}
		else
			systemdate += "" + year;

		return systemdate;
	}

	/**
	 * 得到系统时间的月份
	 * @param degree 几进制,取值为2,8,10,16
	 * @return String Month 01~12
	 * @throws SQLException
	 */
	public String getSystemMonth(int degree) {
		//if(degree!=2&&degree!=8&&degree!=10&&degree!=16)
		//	return "Your degree"+degree+"请选择合适的进制: 2; 8; 10; 16";
		String systemdate = "";
		month = todaysDate.get(Calendar.MONTH) + 1; //old:0~11
		if (month < degree) { //Now:1~12
			if (degree == 2)
				systemdate += "" + Integer.toBinaryString(month);
			else if (degree == 8)
				systemdate += "" + Integer.toOctalString(month);
			else if (degree == 16)
				systemdate += "0" + Integer.toHexString(month);
			else
				systemdate += "0" + month;
		}
		else
			systemdate += "" + month;

		return systemdate;
	}

	/**
	 * 得到系统时间的日子
	 * @param degree 几进制,取值为2,8,10,16
	 * @return String Day 01~31
	 */
	public String getSystemDay(int degree) {
		String systemdate = "";
		day = todaysDate.get(Calendar.DAY_OF_MONTH);
		if (day < degree) {
			if (degree == 2)
				systemdate += "" + Integer.toBinaryString(day);
			else if (degree == 8)
				systemdate += "" + Integer.toOctalString(day);
			else if (degree == 16) {
				systemdate += "0" + Integer.toHexString(day);
			}
			else
				systemdate += "0" + day;
			}
			else {
			if (degree == 2)
				systemdate += "" + Integer.toBinaryString(day);
			else if (degree == 8)
				systemdate += "" + Integer.toOctalString(day);
			else if (degree == 16) {
				systemdate += "" + Integer.toHexString(day);
			}
			else
				systemdate += "" + day;
		}

		return systemdate;
	}

	/**
	 * 得到系统时间的小时
	 * @param degree 几进制,取值为2,8,10,16
	 * @return tring Hour 00~23 二十四小时制
	 */
	public String getSystemHour(int degree) {
		String systemdate = "";

		intHourOfDay = todaysDate.get(Calendar.HOUR_OF_DAY); //0~23 二十四小时制
		//intPmFlag=todaysDate.get(Calendar.AM_PM);
		//if (intPmFlag==1) hour+=12; //十二小时制
		if (intHourOfDay < degree) {
			if (degree == 2)
				systemdate += "" + Integer.toBinaryString(intHourOfDay);
			else if (degree == 8)
				systemdate += "" + Integer.toOctalString(intHourOfDay);
			else if (degree == 16) {
				systemdate += "0" + Integer.toHexString(intHourOfDay);
			}
			else
				systemdate += "0" + intHourOfDay;
			}
			else {
				if (degree == 2)
					systemdate += "" + Integer.toBinaryString(intHourOfDay);
				else if (degree == 8)
					systemdate += "" + Integer.toOctalString(intHourOfDay);
				else if (degree == 16) {
					systemdate += "" + Integer.toHexString(intHourOfDay);
			}
			else
				systemdate += "" + intHourOfDay;
		}

		return systemdate;
	}

	/**
	 * 得到系统时间的分钟
	 * @param degree 几进制,取值为2,8,10,16
	 * @return String Minute 00~59
	 */
	public String getSystemMinute(int degree) {
		String systemdate = "";
		minute = todaysDate.get(Calendar.MINUTE); //0~59
		if (minute < degree) {
			if (degree == 2)
				systemdate += "" + Integer.toBinaryString(minute);
			else if (degree == 8)
				systemdate += "" + Integer.toOctalString(minute);
			else if (degree == 16) {
				systemdate += "0" + Integer.toHexString(minute);
			}
			else
				systemdate += "0" + minute;
			}
			else {
				if (degree == 2)
					systemdate += "" + Integer.toBinaryString(minute);
				else if (degree == 8)
					systemdate += "" + Integer.toOctalString(minute);
				else if (degree == 16) {
					systemdate += "" + Integer.toHexString(minute);
			}
			else
				systemdate += "" + minute;
		}
		return systemdate;
	}

	/**
	 * 得到系统时间的秒
	 * @param degree 几进制,取值为2,8,10,16
	 * @return String Second 00~59
	 */
	public String getSystemSecond(int degree) {
		String systemdate = "";
		second = todaysDate.get(Calendar.SECOND); //0~59
		if (second < degree) {
			if (degree == 2)
				systemdate += "" + Integer.toBinaryString(second);
			else if (degree == 8)
				systemdate += "" + Integer.toOctalString(second);
			else if (degree == 16) {
				systemdate += "0" + Integer.toHexString(second);
			}
			else
				systemdate += "0" + second;
			}
			else {
				if (degree == 2)
					systemdate += "" + Integer.toBinaryString(second);
				else if (degree == 8)
					systemdate += "" + Integer.toOctalString(second);
				else if (degree == 16) {
					systemdate += "" + Integer.toHexString(second);
			}
			else
				systemdate += "" + second;
		}

		return systemdate;
	}

	/**
	 * 得到系统时间的微秒
	 * @param degree 几进制,取值为2,8,10,16
	 * @return String MilliSecond 000~999
	 */
	public String getSystemMilliSecond(int degree) {
		String systemdate = "";
		millisecond = todaysDate.get(Calendar.MILLISECOND); //0~999
		if (millisecond < degree) {
			if (degree == 2)
				systemdate += "" + Integer.toBinaryString(millisecond);
			else if (degree == 8)
				systemdate += "" + Integer.toOctalString(millisecond);
			else if (degree == 16) {
				systemdate += "00" + Integer.toHexString(millisecond);
			}
			else
				systemdate += "00" + millisecond;
		}
		else if ( (millisecond >= degree) && (millisecond < (degree * degree))) {
			if (degree == 2)
				systemdate += "" + Integer.toBinaryString(millisecond);
			else if (degree == 8)
				systemdate += "" + Integer.toOctalString(millisecond);
			else if (degree == 16) {
				systemdate += "0" + Integer.toHexString(millisecond);
			}
			else
				systemdate += "0" + millisecond;
			}
			else {
				if (degree == 2)
					systemdate += "" + Integer.toBinaryString(millisecond);
				else if (degree == 8)
					systemdate += "" + Integer.toOctalString(millisecond);
				else if (degree == 16) {
					systemdate += "" + Integer.toHexString(millisecond);
			}
			else
				systemdate += "" + millisecond;
		}

		return systemdate;
	}

	/**
	 * 得到系统时间是一年中的第几天
	 * @param degree 几进制,取值为2,8,10,16
	 * @return String Day_of_Year 001~366
	 */
	public String getSystemDayOfYear(int degree) {
		String systemdate = "";
		intDayOfYear = todaysDate.get(Calendar.DAY_OF_YEAR); //001~366
		if (intDayOfYear < degree) { //001~366
			if (degree == 2)
				systemdate += "" + Integer.toBinaryString(intDayOfYear);
			else if (degree == 8)
				systemdate += "" + Integer.toOctalString(intDayOfYear);
			else if (degree == 16) {
				systemdate += "00" + Integer.toHexString(intDayOfYear);
			}
			else
				systemdate += "00" + intDayOfYear;
		}
		else if (intDayOfYear >= degree && intDayOfYear < (degree * degree)) {
			if (degree == 2)
				systemdate += "" + Integer.toBinaryString(intDayOfYear);
			else if (degree == 8)
				systemdate += "" + Integer.toOctalString(intDayOfYear);
			else if (degree == 16) {
				systemdate += "0" + Integer.toHexString(intDayOfYear);
			}else
				systemdate += "0" + intDayOfYear;
			}else {
				if (degree == 2)
					systemdate += "" + Integer.toBinaryString(intDayOfYear);
				else if (degree == 8)
					systemdate += "" + Integer.toOctalString(intDayOfYear);
				else if (degree == 16) {
					systemdate += "" + Integer.toHexString(intDayOfYear);
			}
			else
				systemdate += intDayOfYear;
		}

		return systemdate;
	}

	/**
	 * 得到系统时间在一年中周次
	 * @param degree 几进制，通常取值2，8，10， 16
	 * @return String Week_of_Year 01~54，得到系统时间在年中所处的周
	 */
	public String getSystemWeekOfYear(int degree) {
		String systemdate = "";
		intWeekOfYear = todaysDate.get(Calendar.WEEK_OF_YEAR); //1~54
		if (intWeekOfYear < degree) { //1~54
			if (degree == 2)
				systemdate += "" + Integer.toBinaryString(intWeekOfYear);
			else if (degree == 8)
				systemdate += "" + Integer.toOctalString(intWeekOfYear);
			else if (degree == 16) {
				systemdate += "0" + Integer.toHexString(intWeekOfYear);
			}
			else
				systemdate += "0" + intWeekOfYear;
		}else {
			if (degree == 2)
				systemdate += "" + Integer.toBinaryString(intWeekOfYear);
			else if (degree == 8)
				systemdate += "" + Integer.toOctalString(intWeekOfYear);
			else if (degree == 16) {
				systemdate += "" + Integer.toHexString(intWeekOfYear);
			}
			else
				systemdate += "" + intWeekOfYear;
		}
		return systemdate;
	}

	/**
	 * 得到系统时间在一个月中的周次
	 * @param degree 几进制，通常取值2，8，10， 16
	 * @return Week_of_Month 1~6，得到系统时间在月中中所处的周次
	 */
	public String getSystemWeekOfMonth(int degree) {
		String systemdate = "";
		intWeekOfMonth = todaysDate.get(Calendar.WEEK_OF_MONTH); //1~6

		if (degree == 2)
			systemdate += "" + Integer.toBinaryString(intWeekOfMonth);
		else if (degree == 8)
			systemdate += "" + Integer.toOctalString(intWeekOfMonth);
		else if (degree == 16) {
			systemdate += "" + Integer.toHexString(intWeekOfMonth);
		}
		else
			systemdate += "" + intWeekOfMonth;

		return systemdate;
	}

	/**
	 * 得到系统时间是一周中的第几天
	 * @param degree 几进制，通常取值2，8，10， 16
	 * @return String Day_of_Week 1~7， 得到系统时间在一周中所处的天
	 */
	public String getSystemDayOfWeek(int degree) {
		String systemdate = "";
		intDayOfWeek = todaysDate.get(Calendar.DAY_OF_WEEK) - 1; //old:1~7;
		if (intDayOfWeek == 0)
			intDayOfWeek = 7; //now 1-mon;6-sta;7-sun

		if (degree == 2)
			systemdate += "" + Integer.toBinaryString(intDayOfWeek);
		else if (degree == 8)
			systemdate += "" + Integer.toOctalString(intDayOfWeek);
		else if (degree == 16) {
			systemdate += "" + Integer.toHexString(intDayOfWeek);
		}
		else
			systemdate += "" + intDayOfWeek;

		return systemdate;
	}

	/**
	 * 得到当前系统时间的数字表达
	 * @param degree 几进制，通常取值2，8，10， 16
	 * @return String SystemDateID, 当前系统时间的数字表达
	 */
	public String getSystemDateID(int degree) {
		String systemdate = "";
		systemdate = getSystemYear(degree) + getSystemMonth(degree) +
			getSystemDay(degree) //if degree=16 8 digit
			+ getSystemHour(degree) + getSystemMinute(degree) +
			getSystemSecond(degree) + getSystemMilliSecond(degree) //if degree=16 9 digit
			//+getSystemWeekOfMonth(degree)+getSystemDayOfYear(degree)//if degree=16 4 digit
			+ getSystemWeekOfYear(degree) + getSystemDayOfWeek(degree); //if degree=16 3 digit
		systemdate = systemdate.trim();
		return systemdate; //20 digit
	}

	/**
	 * 得到系统时间包括毫秒的字符串表示
	 * @return String SystemDateMS 系统日期时间带毫秒---"年月日时分秒毫秒",如:20020423153803123
	 */
	public String getSystemTimeWithMS() {
		String systemdate = "";
		int degree = 10;
		systemdate = getSystemYear(degree) + getSystemMonth(degree) +
			getSystemDay(degree) //if degree=16 8 digit
			+ getSystemHour(degree) + getSystemMinute(degree) +
			getSystemSecond(degree) + getSystemMilliSecond(degree); //if degree=16 9 digit
		return systemdate;
	}

	/**
	 * 得到系统日期
	 * @return String SystemDate 启用占位符号，如2002-1-21————>2002-02-21
	 */
	public String getSystemDate() {
		String systemdate = "";
		int degree = 10;
		systemdate = getSystemYear(degree) + "-" + getSystemMonth(degree) + "-" +
			getSystemDay(degree); //10 digit
		//systemdate=systemdate.trim();
		return systemdate; //10 digit
	}

	/**
	 * 得到系统SQL日期
	 * @return java.sql.Date SystemDate
	 */
	public java.sql.Date getSystemSQLDate() {
		java.util.Date utilDate = new java.util.Date();
		long timevalue = utilDate.getTime();

		java.sql.Date systemdate = new java.sql.Date(timevalue);
		return systemdate;

	}

	/**
	 * 得到系统SQL时间
	 * @return java.sql.Date SystemDate
	 */
	public java.sql.Time getSystemSQLTime() {
		java.util.Date utilDate = new java.util.Date();
		long timevalue = utilDate.getTime();

		java.sql.Time systemtime=new java.sql.Time(timevalue);
		return systemtime;

	}


	/**
	 * 格式化日期，采用默认的“-”分隔符
	 * @return 日期的字符串表示
	 */
	public String dateToString() {
		return "" + year + "-" + month + "-" + day + "";
	}

	/**
	 * 根据指定分隔符号格式化日期
	 * @param seperator 年月日的分隔符
	 * @return 日期的字符串表示
	 */
	public String dateToString(String seperator) {
		return "" + year + seperator + month + seperator + day + "";
	}

	/**
	 * 将日期按默认的"-"分隔符格式化成字符串
	 * @param date 待转换的日期
	 * @return 转换后的字符串
	 */
	public String dateToString(Date date) {
		return "" + date.getYear() + "-" + date.getMonth() + "-" + date.getDay() + "";
	}

	/**
	 * 将日期按指定的分隔符格式化成字符串
	 * @param date 待转换的日期
	 * @param seperator 分隔符
	 * @return 转换后的字符串
	 */
	public String dateToString(Date date, String seperator) {
		return "" + date.getYear() + seperator + date.getMonth() + seperator + date.getDay() + "";

	}

	/**
	 * 格式化时间，采用默认的":"分隔
	 * @return 时间的字符串表示
	 */
	public String timeToString() {
		return "" + hour + ":" + minute + ":" + second + "";
	}

	/**
	 * 根据指定的分隔符格式化时间
	 * @param seperator  时分秒的分隔符
	 * @return 时间的字符串表示
	 */
	public String timeToString(String seperator) {
		return "" + hour + seperator + minute + seperator + second + "";
	}


	/**
	 * 得到calendar
	 * @return calendar
	 */
	public GregorianCalendar getSystemCalendar() {
		return todaysDate;
	}

	/**
	 * 得到系统时间
	 * @return String SystemTime 启用占位符号，如7:23:1————>07:23:01
	 */
	public String getSystemTime() {
		String systemtime = "";
		int degree = 10;
		systemtime = getSystemHour(degree) + ":" + getSystemMinute(degree) +
			":" + getSystemSecond(degree); //8 digit
		//systemdate=systemdate.trim();
		return systemtime; //8 digit
	}

	/**
	 * 得到系统日期和时间
	 * @return String SystemDateTime 启用占位符号，如2002-1-21 7:23:1————>2002-02-21 07:23:01
	 */
	public String getSystemDateTime() {
		String systemdatetime = "";
		systemdatetime = getSystemDate() + " " + getSystemTime();
		return systemdatetime; //19 digit
	}

	/**
	 * 调整日期
	 * @param nyear 年
	 * @param nmonth 月
	 * @param nday 天
	 * @return String 调整后的日期
	 */
	public String adjustDate(int nyear, int nmonth, int nday) {
		//GregorianCalendar tmpdate=todaysDate.clone();
		todaysDate.add(Calendar.YEAR, nyear);
		todaysDate.add(Calendar.MONTH, nmonth);
		todaysDate.add(Calendar.DATE, nday);
		return getSystemDate();
	}

	/**
	 * 调整时间
	 * @param nhour 小时(24小时制)
	 * @param nminute 分
	 * @param nsecond 秒
	 * @param nmillisecond 毫秒
	 * @return String 调整后的时间
	 */
	public String adjustTime(int nhour, int nminute, int nsecond,
							 int nmillisecond) {
		todaysDate.add(Calendar.HOUR_OF_DAY, nhour);
		todaysDate.add(Calendar.MINUTE, nminute);
		todaysDate.add(Calendar.SECOND, nsecond);
		todaysDate.add(Calendar.MILLISECOND, nmillisecond);
		return getSystemTime();
	}

	public static void main(String[] args) {

 }

}

