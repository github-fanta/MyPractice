package homework;

public class Vigenere {

	public static void main(String[] args) {
		String originKey = "leg";	//密钥为leg
		String sourceString = "explanation";	//加密单词
		
		//一律转为小写字母
		char[] simpleKeyArray = originKey.toLowerCase().toCharArray();
		char[] sourceCharArray = sourceString.toLowerCase().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		//关键字重复书写，形成密钥流
		for(int i=0; i<sourceCharArray.length; i++) {
			int source = (int)sourceCharArray[i]-97;
			int key = (int)simpleKeyArray[i % 3]-97;
			char target = (char) (97+(source + key) % 26);
			//System.out.println(target);
			sb.append(target);
		}
		System.out.println(sb);
	}
}
