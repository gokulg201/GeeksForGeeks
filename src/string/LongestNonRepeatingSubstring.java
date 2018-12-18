//$Id$
package string;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6. 
 * For “BBBB” the longest substring is “B”, with length 1. For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7.
 * https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * @author gokul-4406
 *
 */
public class LongestNonRepeatingSubstring {
	public static int longestNonRepeatingSubString(String str){
		int[] visited = new int[256];
		int max_len = 1;
		int cur_len = 1;
		int prev = -1;
		for(int i = 0; i < 256;i++){
			visited[i] = -1;
		}
		visited[str.charAt(0)] = 0;
		for(int i = 1; i < str.length();i++){
			prev = visited[str.charAt(i)];
			//If the character has not been visited at all or is not a part of the current sequence
			if(prev == -1 || i - cur_len > prev){
				cur_len ++;
			}else{
				if(max_len < cur_len){
					max_len = cur_len;
				}
				//updating cur_len
				cur_len = i - prev;// Excluding the last occurence of ith character
			}
			//Updating the last visited index
			visited[str.charAt(i)] = i;
		}
		if(max_len < cur_len){
			max_len = cur_len;
		}
		return max_len;
	}
	public static void main(String[] args){
		System.out.println(longestNonRepeatingSubString("ABDEFGABEF"));
	}
}
