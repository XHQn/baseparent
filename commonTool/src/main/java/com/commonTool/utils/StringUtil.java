package com.commonTool.utils;

import com.alibaba.fastjson.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringUtil {

	//判断字符串为空
	public static String getStr(String str){
		if(str != null && !"".equals(str) && !"null".equals(str)){
			return str;
		}else{
			return "";
		}
	}
	
	//判断字符串为空
	public static String rep_(String str){
		if(str != null && !"".equals(str) && !"null".equals(str)){
			return str.replaceAll("_$", "");
		}else{
			return "";
		}
	}

	
	 public static String delHTMLTag(String htmlStr){ 
	        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
	        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
	        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
	        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
	        Matcher m_script=p_script.matcher(htmlStr); 
	        htmlStr=m_script.replaceAll(""); //过滤script标签 
	        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
	        Matcher m_style=p_style.matcher(htmlStr); 
	        htmlStr=m_style.replaceAll(""); //过滤style标签 
	        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
	        Matcher m_html=p_html.matcher(htmlStr); 
	        htmlStr=m_html.replaceAll(""); //过滤html标签 
	        htmlStr=htmlStr.replace("&nbsp;", "");
	        return htmlStr.trim(); //返回文本字符串 
	    } 
	
	 public static String getHtml(String htmlStr){
		 if(StringUtil.IsNull(htmlStr)){
			 return htmlStr = htmlStr.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		 }
		 return "";
	 }

	//判断字符串为空
	public static double getDouble(Double dou){
		if(dou == null){
			return 0;
		}
		return dou;
	}
	
	//判断字符串为空
	public static boolean isTp(String str){
		if(StringUtil.IsNull(str) && (str.contains("jpg") || str.contains("JPG") || str.contains("JPEG") || str.contains("jpeg")  || str.contains("BMP") || str.contains("bmp")
				|| str.contains("PNG") || str.contains("png") || str.contains("gif") || str.contains("GIF")	
		)){
			return true;
		}else{
			return false;
		}
	}
	
	//判断字符串为空
	public static boolean isDoc(String str){
		if(StringUtil.IsNull(str) && (str.contains("doc") || str.contains("DOC") || str.contains("docx") || str.contains("DOCX"))){
			return true;
		}else{
			return false;
		}
	}
	
	//判断字符串为空
	public static boolean isPdf(String str){
		if(StringUtil.IsNull(str) && (str.contains("pdf") || str.contains("PDF") )){
			return true;
		}else{
			return false;
		}
	}
	
	//判断字符串为空
	public static boolean isExcel(String str){
		if(StringUtil.IsNull(str) && (str.contains("xlsx") || str.contains("XLSX")|| str.contains("xls")|| str.contains("XLS"))){
			return true;
		}else{
			return false;
		}
	}
	
	//判断字符串为空
	public static String subBylenght(String str,int length){
		if(str != null && !"".equals(str) && !"null".equals(str) && str.length() > length){
			return str.substring(0,length)+"...";
		}else{
			return str;
		}
	}
	//判断字符串为空
	public static String getDateSub(String str){
		if(StringUtil.IsNull(str) && str.length() > 6){
			return str.substring(0,10);
		}else{
			return str;
		}
	}
	
	//判断字符串为空
	public static String getFileName(String str){
		if(StringUtil.IsNull(str)){
			str = str.substring(str.lastIndexOf("/")+1);
			return str;
		}else{
			return str;
		}
	}
	
	public static int parInt(String str){
		int retrun_int = 0;
		if(StringUtil.IsNull(str) && !"—".equals(str)){
			retrun_int = Integer.parseInt(str);
		}
		return retrun_int;
	}
	
	//判断字符串为空
	public static String subTimeYR(String str){
		if(str != null && str.length() > 10){
			return str.substring(6,10);
		}else{
			return "";
		}
	}
	
	//根据@截取返回list
	public static List<String> getList(String str,String tj){
		List<String> return_list = new ArrayList<String>();
		if(str != null && !"".equals(str) && !"null".equals(str)){
			String [] str_array = str.split(tj);
			for(int i = 0; i < str_array.length; i++){
				return_list.add(str_array[i]);
			}
		}
		return return_list;
	}
	
	
	//判断字符串为空
	public static Long getLong(Long log){
		if(log != null){
			return log;
		}else{
			return 0l;
		}
	}
	
	//判断字符串为空
	public static int getInt(Integer int_){
		if(int_ != null){
			return int_;
		}else{
			return 0;
		}
	}
	
	//判断字符串为空
	public static short getShort(Short sh){
		if(sh != null){
			return sh;
		}else{
			return 0;
		}
	}
	
	//判断字符串为空
	public static boolean IsNull(String str){
		if(str != null && !"".equals(str) && !"null".equals(str) && !"undefined".equals(str)){
			return true;
		}else{
			return false;
		}
	}

	public static boolean isNotNull(String str){
		if(str != null && !"".equals(str) && !"null".equals(str) && !"undefined".equals(str)){
			return true;
		}else{
			return false;
		}
	}

	public static String getFomat(Double dou){
		String str = "";
		if(dou != null && dou != 0L){
			DecimalFormat    df   = new DecimalFormat("######0.00");   
			str = df.format(dou);  
		}
		return str;
	}
	
	//判断字符串为空
	public static boolean IsNull(Integer integer){
		if(integer != null && integer != 0){
			return true;
		}else{
			return false;
		}
	}
	
	//判断字符串为空
	public static boolean IsNull(Double dou){
		if(dou != null && dou != 0){
			return true;
		}else{
			return false;
		}
	}
	
	//判断字符串为空
	public static boolean IsNull(Long long_){
		if(long_ != null && long_ != 0){
			return true;
		}else{
			return false;
		}
	}
	
	//判断字符串为空
	public static String getStrSub(String str){
		if(str != null && str.length() > 2){
			return str.substring(0,3)+"...";
		}else{
			return "";
		}
	}
	
	//判断字符串为空
	public static String getStrName(String str){
		if(str != null && str.length() > 4){
			return str.substring(0,4)+"...";
		}else{
			return str;
		}
	}
	
	//根据当前字符串长度进行换行
	public static StringBuffer getStrn(String str){
		StringBuffer newstr = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if(i == str.length()/2){
				newstr.append("\n");
			}
			newstr.append(str.charAt(i));
		}
		System.out.print(newstr);
		return newstr;
	}

	//重新获取img
	public static String getImg(String str){
		if(!StringUtil.IsNull(str)){
			return "";
		}
		str = str.replaceAll("/>"," />");
		str = str.replaceAll("(<img[^>]*?)\\s+width\\s*=\\s*\\S+","$1");
		str = str.replaceAll("(<img[^>]*?)\\s+height\\s*=\\s*\\S+","$1");
		str = str.replaceAll("(<img[^>]*?)\\s+style\\s*=\\s*\\S+","$1");
		str = str.replaceAll("(<img[^>]*?)","$1 style=\"width:100%; margin: 5px 0;\"");
		
		str = str.replaceAll("(<embed[^>]*?)\\s+width\\s*=\\s*\\S+","$1");
		str = str.replaceAll("(<embed[^>]*?)\\s+height\\s*=\\s*\\S+","$1");
		str = str.replaceAll("(<embed[^>]*?)\\s+style\\s*=\\s*\\S+","$1");
		str = str.replaceAll("(<embed[^>]*?)","$1 style=\"width:100%; margin: 5px 0;\"");
		
		return str;
	}
	
	public static String getString(String str){
		str = str.replaceAll(".*\\d@","");
		return str;
	}
	
	//判断字符串为空
	public static String getSex(String xb){
		if("男".equals(xb)){
			return "0";
		}else if("女".equals(xb)){
			return "1";
		}
		return "";
	}

	/**
	 * 获取文件扩展名
	 * 详细步骤
	 */
	public static String getExt(String filename) {
		if(!StringUtil.IsNull(filename)){
			return "";
		}
		//获取最后一个.的位置
		int lastIndexOf = filename.lastIndexOf(".");
		//获取文件的后缀名 .jpg
		String suffix = filename.substring(lastIndexOf + 1);
		return suffix;
	}


	/**
	 * 获取文件扩展名
	 * 详细步骤
	 */
	public static String getNoKg(String filename) {
		if (!IsNull(filename)){
			return "";
		}
		filename = filename.replaceAll(" +", "");
		filename = filename.replaceAll("\\s*", "");
		return filename;
	}

	/**
	 * object转list
	 */
	public static <T> List<T> castList(Object obj, Class<T> clazz)
	{
		List<T> result = new ArrayList<T>();
		if(obj instanceof List<?>)
		{
			for (Object o : (List<?>) obj)
			{
				String string = JSONObject.toJSONString(o);
				T t = JSONObject.parseObject(string, clazz);
				result.add(clazz.cast(o));
			}
			return result;
		}
		return null;
	}



	public static void main(String[] args) {
		System.out.println(getNoKg("67ff626098a84af68fad2268b56273f6新建 Microsoft Office PowerPoint 演示文稿.pptx"));
	}
}
