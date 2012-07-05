
package com.wupeng.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil
{

	public TimeUtil()
	{
	}

	public static Date getBeginOfDay(Date date)
	{
		if (date == null)
		{
			return null;
		} else
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(11, 0);
			cal.set(12, 0);
			cal.set(13, 0);
			cal.set(14, 0);
			return cal.getTime();
		}
	}

	public static Date getEndOfDay(Date date)
	{
		if (date == null)
		{
			return null;
		} else
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(11, 23);
			cal.set(12, 59);
			cal.set(13, 59);
			cal.set(14, 999);
			return cal.getTime();
		}
	}

	public static Date parseDayDate(String day)
	{
		if (day == null)
			return null;
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			date = df.parse(day);
		}
		catch (ParseException e) { }
		return date;
	}
	
	public static Date parseDayDate(String day, String srcFormat)
	{
		if (day == null)
			return null;
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat(srcFormat);
		try
		{
			date = df.parse(day);
		}
		catch (ParseException e) { }
		return date;
	}


	/**
	 * parseDayDate("2011-06-08 14:02:43", "yyyy-MM-dd HH:mm:ss", "yyyyMMdd")-->20110608
	 * @param date
	 * @param srcFormat
	 * @param targetFormat
	 * @return
	 */
	public static String parseDayDate(String date, String srcFormat, String targetFormat){
		String target;
		Date srcDate = parseDayDate(date, srcFormat);
		
		target = format(srcDate, targetFormat);
		
		return target;
	}
	

	public static String formatDate(Date date)
	{
		if (date == null)
		{
			return "";
		} else
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.format(date);
		}
	}
	public static String formatTime(Date date)
	{
		if (date == null)
		{
			return "";
		} else
		{
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
			return df.format(date);
		}
	}
	/**
	 * [- - [29/
	 * 
	 * */
	public static String formatLogDate(Date date)
	{
		if (date == null)
		{
			return "";
		} else
		{
			SimpleDateFormat df = new SimpleDateFormat("dd");
			return "["+df.format(date)+"/";
		}
	}
	/**
	 * HH:mm:ss
	 * */
	public static int formatDateToSec(String times)
	{	int r=0;
		String[] tArr=times.split(":");
		if (tArr.length<=0)
		{
			return 0;
		} else {
			r=Integer.parseInt(tArr[0])*60*60;
			r+=Integer.parseInt(tArr[1])*60;
			r+=Integer.parseInt(tArr[2]);
			return r;
		}
	}
	
	
	
	
	public static String format3Date(Date date)
	{
		if (date == null)
		{
			return "";
		} else
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			return df.format(date);
		}
	}

	public static String format2Date(Date date)
	{
		if (date == null)
		{
			return "";
		} else
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format(date);
		}
	}
	
	public static String format(Date date, String format)
	{
		if (date == null)
		{
			return "";
		} else
		{
			SimpleDateFormat df = new SimpleDateFormat(format);
			return df.format(date);
		}
	}

	public static boolean isFinish(Date date)
	{
		boolean isFinish = false;
		Calendar cal = Calendar.getInstance();
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(14, 0);
		long currentDay = cal.getTimeInMillis();
		if (date != null && date.getTime() < currentDay)
			isFinish = true;
		return isFinish;
	}

	public static Date parseString2Date(String dateStr)
	{
		if (dateStr == null)
			return null;
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			date = df.parse(dateStr);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}

	public static Date getBeginOfMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(5, 1);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(14, 0);
		return cal.getTime();
	}

	public static Date getEndOfMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(2, cal.get(2) + 1);
		cal.set(5, 1);
		cal.set(5, cal.get(5) - 1);
		cal.set(10, 23);
		cal.set(12, 59);
		cal.set(13, 59);
		cal.set(14, 999);
		return cal.getTime();
	}
}
