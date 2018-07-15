package Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

	public static void main(String[] args) throws Throwable {
		//test1();
		//test2();
		//test3();
		getMails();
	}
	
	/**
	 * 练习1 治疗口吃
	 * 原始字符串:我我...我我...我我我要..要要要...要..要学学..编编编编编..程程程..程程.程..程
	 */
	public static void test1() {
		String str = "我我...我我...我我我要..要要要...要..要学学..编编编编编..程程程..程程.程..程";
		
		//(.)\\1+ 中的1+表示第一组的词重复一次或多次， $1 表示取出前面一个正则表达式的第一组
		System.out.println(str.replaceAll("\\.", "").replaceAll("(.)\\1+", "$1"));
	}
	
	/**
	 * 练习2：ip地址排序
	 */
	public static void test2() {
		
		String str = "192.168.101.34  127.0.0.1  3.3.3.3  105.70.11.55";
		//都添加两个0
		str = str.replaceAll("(\\d+)", "00$1");
		//截取最后三位
		str = str.replaceAll("0*(\\d{3})", "$1");
		
		//切割ip
		String[] ips = str.split(" +");
		//利用treeSet排序
		TreeSet<String> ts = new TreeSet<>();
		for (String ip : ips) {
			ts.add(ip);
		}
		
		//截取前面的0
		for (String ip : ts) {
			System.out.println(ip.replaceAll("0*(\\d{1,3})", "$1"));
		}
		
		
	}
	
	/**
	 * 3 邮件地址校验
	 */
	public static void test3() {
		
		String str = "821087667@qq.com";
		//String str = "1@11";
		//String reg = "\\w+@\\w+(\\.\\w+)+";
		String reg = "[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{1,3})+";
		System.out.println(str+"是否符合邮件格式:"+str.matches(reg));
	}
	
	/**
	 * 爬虫 查找网页中的邮件地址
	 * @throws FileNotFoundException 
	 */
	public static void getMails() throws Exception{
		
		List<String> resultList = new ArrayList<String>();
		
		//本地文件源
		//BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\liq\\Desktop\\file.html"));
		
		//网络源
		URL url = new URL("https://zhidao.baidu.com/question/1772307510687057620.html");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String reg = "\\w+@\\w+(\\.\\w+)+";
		Pattern pattern = Pattern.compile(reg);
		String  line = "";
		while ((line = reader.readLine()) != null) {
			Matcher matcher = pattern.matcher(line);
			while(matcher.find()) {
				resultList.add(matcher.group());
			}
		}
		
		reader.close();
		
		//打印
		if (resultList.size() != 0) {
			for (String string : resultList) {
				System.out.println(string);
			}
			return ;
		}
		System.out.println("未找到匹配邮箱！");
	}
}
