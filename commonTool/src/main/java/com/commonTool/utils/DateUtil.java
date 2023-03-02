package com.commonTool.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
	
	/**
     * 获取当前日期是星期几<br>
     *
     * @return 当前日期是星期几
     */
    public static boolean compare(String date1,int year) {
    	try {
        	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date_start = formatter.parse(date1);
			Date date_end = new Date();
			
	        Calendar rightNow = Calendar.getInstance();
	        rightNow.setTime(date_start);
	        rightNow.add(Calendar.YEAR,year);//日期加year年
	        
	        long date1_long = rightNow.getTime().getTime();
			long date2_long = date_end.getTime();
			if(date1_long > date2_long){
				return true;
			}else{
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
    }


	 /**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"7", "1", "2", "3", "4", "5", "6"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    
	 /**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDateDx(Date dt) {
        String[] weekDays = {"七", "一", "二", "三", "四", "五", "六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static String getYYYYMMDD(){
    	Date date=new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	return formatter.format(date);
    }
    
    public static String getYYYYMM(){
    	Date date=new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
    	return formatter.format(date);
    }
    
    public static String getYYYYMMNy(){
    	Date date=new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月");
    	return formatter.format(date);
    }
    
    /**
     * 
     * 描述:获取下一个月.
     * 
     * @return
     */
    public static String getPreMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(cal.MONTH, 1);
        SimpleDateFormat dft = new SimpleDateFormat("yyyy年MM月");
        String preMonth = dft.format(cal.getTime());
        return preMonth;
    }
    
    
    /**
     * 
     * 描述:获取下一个月.
     * 
     * @return
     */
    public static String getThreeMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(cal.MONTH, 3);
        SimpleDateFormat dft = new SimpleDateFormat("yyyy年MM月");
        String preMonth = dft.format(cal.getTime());
        return preMonth;
    }

    /**
     * 获取任意时间的下一个月
     * 描述:<描述函数实现的功能>.
     * @param repeatDate
     * @return
     */
    public static String getPreMonth(String repeatDate) {
        String lastMonth = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat("yyyy年MM月");
        int year = Integer.parseInt(repeatDate.substring(0, 4));
        String monthsString = repeatDate.substring(5, 7);
        int month;
        if ("0".equals(monthsString.substring(0, 1))) {
            month = Integer.parseInt(monthsString.substring(1, 2));
        } else {
            month = Integer.parseInt(monthsString.substring(0, 2));
        }
        cal.set(year,month,Calendar.DATE);
        lastMonth = dft.format(cal.getTime());
        System.out.println(lastMonth);
        return lastMonth;
    }
    

    
    public static String getMM(){
    	Date date=new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("MM");
    	return formatter.format(date);
    }
    /** 
     *  
     * 描述:获取下一个月. 
     *  
     * @return 
     */  
    public static String getXyMonth() {  
        Calendar cal = Calendar.getInstance();  
        cal.add(cal.MONTH, 1);  
        SimpleDateFormat dft = new SimpleDateFormat("MM");  
        String preMonth = dft.format(cal.getTime());  
        return preMonth;  
    }  
    
    /** 
     *  
     * 描述:获取下二个月. 
     *  
     * @return 
     */  
    public static String getXeMonth() {  
        Calendar cal = Calendar.getInstance();  
        cal.add(cal.MONTH, 2);  
        SimpleDateFormat dft = new SimpleDateFormat("MM");  
        String preMonth = dft.format(cal.getTime());  
        return preMonth;  
    }  
    
    public static String getYYYYZ(Date date){
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
    	return formatter.format(date);
    }
    
    public static String getMMZ(Date date){
    	SimpleDateFormat formatter = new SimpleDateFormat("MM");
    	return formatter.format(date);
    }
    
    public static String getCDate(){
    	Date date=new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return formatter.format(date);
    }
    
    public static String getDateBase(){
    	Date date=new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
    	return formatter.format(date);
    }
    
    public static String getDateNumber(){
    	Date date=new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    	return formatter.format(date);
    }
    
    
    public static String getHHMMSS(){
    	Date date=new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    	return formatter.format(date);
    }
    
    public static String getCRq(){
    	Date date=new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	return formatter.format(date);
    }
    
    public static String getYMDHM(){
    	Date date=new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
    	return formatter.format(date);
    }
    
    public static Date getDateByStr(String date_str){
	   Date myDate2 = null;
	   try {
 		   if(date_str != null && !"".equals(date_str) && !"null".equals(date_str) ){
			   DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			   myDate2 = dateFormat2.parse(date_str);
 		   }   
	   } catch (ParseException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }
	   return myDate2;
    }  
    
    public static Date getDateByStr1(String date_str){
 	   Date myDate2 = null;
 	   try {
 		   if(date_str != null && !"".equals(date_str) && !"null".equals(date_str) ){
 	 		   DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
 	 		   myDate2 = dateFormat2.parse(date_str);
 		   }
 	   } catch (ParseException e) {
 		   // TODO Auto-generated catch block
 		   e.printStackTrace();
 	   }
 	   return myDate2;
     }  
    
    public static String getDateChaZhi(String start_date_str,String end_date_str){
 	   String return_long = "";
       Date start_myDate2 = null;
 	   Date end_myDate2 = null;
 	   try {
 		  if(start_date_str != null && !"".equals(end_date_str) && !"null".equals(end_date_str) && end_date_str != null && !"".equals(end_date_str) && !"null".equals(end_date_str)){
 		   	  DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
 		   	  start_myDate2 = dateFormat2.parse(start_date_str);
 		   	  end_myDate2 = dateFormat2.parse(end_date_str);
 			  Long time_cha = end_myDate2.getTime() - start_myDate2.getTime();
 			  long xs = time_cha/1000/60/60;
 			  long fen = time_cha/1000/60%60;
 			  return_long = xs+"小时" + fen + "分";
 		   }
 	   } catch (ParseException e) {
 		   // TODO Auto-generated catch block
 		   e.printStackTrace();
 	   }
 	   return return_long;
     }  
    
    public static String getDateCd(String start_date_str,String end_date_str){
  	   String return_long = "";
        Date start_myDate2 = null;
  	   Date end_myDate2 = null;
  	   try {
  		  if(start_date_str != null && !"".equals(end_date_str) && !"null".equals(end_date_str) && end_date_str != null && !"".equals(end_date_str) && !"null".equals(end_date_str)){
  		   	  DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  		   	  start_myDate2 = dateFormat2.parse(start_date_str);
  		   	  end_myDate2 = dateFormat2.parse(end_date_str);
  		   	  if(end_myDate2.getTime() > start_myDate2.getTime()){
  	  			  Long time_cha = end_myDate2.getTime() - start_myDate2.getTime();
  	  			  long xs = time_cha/1000/60/60;
  	  			  long fen = time_cha/1000/60%60;
  	  			  return_long = xs+"小时" + fen + "分";
  		   	  }
  		   }
  	   } catch (ParseException e) {
  		   // TODO Auto-generated catch block
  		   e.printStackTrace();
  	   }
  	   return return_long;
      }
    
    public static String getTimeStr(String time_str){
    	String return_long = "";
    	if(time_str != null && !"".equals(time_str) && !"null".equals(time_str)){
    		long time_cha = Long.parseLong(time_str);
			long xs = time_cha/1000/60/60;
  			long fen = time_cha/1000/60%60;
  			return_long = xs+"小时" + fen + "分";
    	}
    	return return_long;
    }
    
    public static Long getDateWorkTime(String start_date_str,String end_date_str){
   	   Long return_long = 0l;
       Date start_myDate2 = null;
   	   Date end_myDate2 = null;
   	   try {
   		  if(start_date_str != null && !"".equals(end_date_str) && !"null".equals(end_date_str) && end_date_str != null && !"".equals(end_date_str) && !"null".equals(end_date_str)){
   		   	  DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
   		   	  start_myDate2 = dateFormat2.parse(start_date_str);
   		   	  end_myDate2 = dateFormat2.parse(end_date_str);
   		   	  if(end_myDate2.getTime() > start_myDate2.getTime()){
   		   		  return_long = end_myDate2.getTime() - start_myDate2.getTime();
   		   	  }
   		   }
   	   } catch (ParseException e) {
   		   // TODO Auto-generated catch block
   		   e.printStackTrace();
   	   }
   	   return return_long;
       }
    
    public static Date getDateByYYMMDD(String date_str){
 	   Date myDate2 = null;
 	   try {
 		   DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
 		   myDate2 = dateFormat2.parse(date_str);
 	   } catch (ParseException e) {
 		   // TODO Auto-generated catch block
 		   e.printStackTrace();
 	   }
 	   return myDate2;
     }  
    
    public static String getYYMMDD(String date_str){
  	   Date myDate2 = null;
  	   try {
  		   DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
  		   myDate2 = dateFormat2.parse(date_str);
  		   SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
  		   return formatter.format(myDate2);
  	   } catch (ParseException e) {
  		   // TODO Auto-generated catch block
  		   e.printStackTrace();
  		   return "";
  	   }
    } 
    
    public static String getFomateYYMMDD(String date_str){
   	   Date myDate2 = null;
   	   try {
   		   DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
   		   myDate2 = dateFormat2.parse(date_str);
   		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
   		   return formatter.format(myDate2);
   	   } catch (ParseException e) {
   		   // TODO Auto-generated catch block
   		   e.printStackTrace();
   		   return "";
   	   }
     } 
    
    public static String getYYMMDDj1(String date_str){
    	   Date myDate2 = null;
    	   try {
    		   DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
    		   myDate2 = dateFormat2.parse(date_str);
    		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
    		   String formate_year = formatter.format(myDate2);
    		   if(formate_year != null && !"".equals(formate_year) && !"null".equals(formate_year)){
    			   formate_year = (Integer.parseInt(formate_year)+1) +"";
    		   }
    		   SimpleDateFormat formatter_mounth = new SimpleDateFormat("-MM-dd");
    		   return formate_year + formatter_mounth.format(myDate2);
    	   } catch (ParseException e) {
    		   // TODO Auto-generated catch block
    		   e.printStackTrace();
    		   return "";
    	   }
      } 
    
    public static String getYYMMDDHHmm(String date_str){
   	   Date myDate2 = null;
   	   try {
   		   DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
   		   myDate2 = dateFormat2.parse(date_str);
   		   SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm");
   		   return formatter.format(myDate2);
   	   } catch (ParseException e) {
   		   // TODO Auto-generated catch block
   		   e.printStackTrace();
   		   return "";
   	   }
     }  
    
    public static String getYYMMDDHHmm2(String date_str){
    	   Date myDate2 = null;
    	   try {
    		   DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    		   myDate2 = dateFormat2.parse(date_str);
    		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    		   return formatter.format(myDate2);
    	   } catch (ParseException e) {
    		   // TODO Auto-generated catch block
    		   e.printStackTrace();
    		   return "";
    	   }
      } 
    public static String getMMDD(String date_str){
   	   Date myDate2 = null;
   	   try {
   		   DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
   		   myDate2 = dateFormat2.parse(date_str);
   		   SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
   		   return formatter.format(myDate2);
   	   } catch (ParseException e) {
   		   // TODO Auto-generated catch block
   		   e.printStackTrace();
   		   return "";
   	   }
     }  
    
    public static String getHHmm(String date_str){
    	   Date myDate2 = null;
    	   try {
    		   DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    		   myDate2 = dateFormat2.parse(date_str);
    		   SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    		   return formatter.format(myDate2);
    	   } catch (ParseException e) {
    		   // TODO Auto-generated catch block
    		   e.printStackTrace();
    		   return "";
    	   }
      }  
    
    public static String getYYMMDDStr(Date date){
 	   SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
	   return formatter.format(date);
   } 
    
    public static String getny(Date date){
  	   SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
 	   return formatter.format(date);
    } 
   
    public static String getFormateStr(Date date){
       if(date != null){
      	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
     	   return formatter.format(date);
       }else {
    	   return null;
       }

    } 
    
   public static String getYYYY(Date date){
  	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
 	   return formatter.format(date);
   } 
   public static String getMM(Date date){
  	   SimpleDateFormat formatter = new SimpleDateFormat("MM");
 	   return formatter.format(date);
   } 
   public static String getDD(Date date){
  	   SimpleDateFormat formatter = new SimpleDateFormat("dd");
 	   return formatter.format(date);
   } 
   public static String getYYMMDD(Date date){
  	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
 	  return formatter.format(date);
   }
   
   public static String getYYMM(Date date){
  	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
 	  return formatter.format(date);
   }
   
    public static String getYYYY(){
    	Date date=new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
    	return formatter.format(date);
    }
    
    public static Date getDateByYYMM(String date_str){
  	   Date myDate2 = null;
  	   try {
  		   DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM");
  		   myDate2 = dateFormat2.parse(date_str);
  	   } catch (ParseException e) {
  		   e.printStackTrace();
  	   }
  	   return myDate2;
      }

    public static Date getDateByYY(String date_str){
   	   Date myDate2 = null;
   	   try {
   		   DateFormat dateFormat2 = new SimpleDateFormat("yyyy");
   		   myDate2 = dateFormat2.parse(date_str);
   	   } catch (ParseException e) {
   		   e.printStackTrace();
   	   }
   	   return myDate2;
       }

	public static List<String> getMonth(String beginDate, String endDate) {
		List<String> list_month = new ArrayList<String>();
		if(StringUtil.IsNull(beginDate) && StringUtil.IsNull(endDate)){
	  		String start_month = beginDate.split("-")[1];
	  		String end_month = endDate.split("-")[1];
	  		String start_year = beginDate.split("-")[0];
	  		String end_year = endDate.split("-")[0];
	  		int start = Integer.parseInt(start_month);
	  		int end = Integer.parseInt(end_month);
	  		int start_y = Integer.parseInt(start_year);
	  		int end_y = Integer.parseInt(end_year);
	  		if(!(end_y > start_y)){
	  			for(int i = 0; i < (end - start); i++){
	  				System.out.println(beginDate.split("-")[0]+"-"+(start + i));
	  				list_month.add(beginDate.split("-")[0]+"-"+(start + i));
	  			}
	  		}else{
	  			for(int i = 0; (i + start) < 13; i++){
	  				System.out.println(beginDate.split("-")[0]+"-"+(start + i));
	  				list_month.add(beginDate.split("-")[0]+"-"+(start + i));
	  			}
	  			for(int i = 1; i < end; i++){
	  				System.out.println(endDate.split("-")[0]+"-"+ i);
	  				list_month.add(endDate.split("-")[0]+"-"+ i);
	  			}
	  			
	  		}
		}
		return list_month;
	}  
	
	public static String getMMDD(){
    	Date date=new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
    	return formatter.format(date);
    }

	public String getBefor(String date_str) throws Exception{
		Calendar calendar1 = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		calendar1.add(Calendar.DATE, -1);
		String three_days_ago = sdf1.format(calendar1.getTime());
		System.out.println(three_days_ago);
		return three_days_ago;
	}

	public String getThree(String date_str) throws Exception{
		Calendar calendar1 = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		calendar1.add(Calendar.DATE, -3);
		String three_days_ago = sdf1.format(calendar1.getTime());
		System.out.println(three_days_ago);
		return three_days_ago;
	}

	public static void main(String[] args) throws Exception {
		DateUtil date = new DateUtil();

		String begin_date = date.getThree(DateUtil.getYYYYMMDD());

		String end_date = date.getBefor(DateUtil.getYYYYMMDD());

		System.out.println("begin_date: " + begin_date);
		System.out.println("end_date: " + end_date);
	}



}
