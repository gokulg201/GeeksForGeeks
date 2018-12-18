//$Id$
package string;

public class Duplicates {
	public static void removeDuplicates(char[] str){
		if(str == null) return;
		int len = str.length;
		if(len < 2) return;
		boolean[] hit = new boolean[256];
		for(int i = 0;i < 256;++i){
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for(int i = 1; i < len;i++){
			if(!hit[str[i]]){
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = '\n';
		System.out.println(str);
	}
	public static void removeDuplicates1(char[] str){
		if(str == null) return;
		int len = str.length;
		if(len < 2) return;
		int index = 0;
		for(int i = 0 ; i < len;i++){
			int j ;
			for(j = 0; j < i;j++){
				if(str[i] == str[j])
					break;
			}
			if(j == i){
				str[index++] = str[i];
				System.out.print(str[i]);
			}
		}
//		for(;index < len; index++){
//			str[index] = '0';
//		}
//		System.out.println(str);
	}
	public static void main(String[] args){
		String str = "aaaababc";
		removeDuplicates(str.toCharArray());
	}
}
