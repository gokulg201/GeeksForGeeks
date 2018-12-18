

//$Id$

/**
 * Test Class
 * @author gokul-4406
 *
 */
public class GFG {
	static int wildCard(String pattern, String str)
    {
    char[] text = str.toCharArray();
	char[] pat = pattern.toCharArray();
	//Simplifying the pattern, by grouping all consecutive *'s to one
	int writeIndex = 0;
	boolean isFirst = true;
	for(int i = 0 ;i < pat.length;i++){
		if(pat[i] == '*'){
			if(isFirst){
				pat[writeIndex++] = pat[i];
				isFirst = false;
			}
		}else{
			pat[writeIndex++] = pat[i];
			isFirst = true;
		}
	}
	int n = text.length;
	int m = writeIndex;
	boolean[][] match = new boolean[n+1][m+1];
	for(int i = 0 ; i <= n;i++){
		for(int j = 0 ;j <= m;j++){
			//No wildcard and no text
			if(i == 0 && j == 0){
				match[i][j] = true;
				continue;
			}
			//No Text
			if(i == 0){
				if(j == 1 && pat[0] == '*'){
					match[i][j] = true;//As empty text can match a pattern with just '*'
					continue;
				}
				match[i][j] = false;//As a pattern cannot match empty text
				continue;
			}
			//No Pattern
			if(j == 0){
				match[i][j] = false;
				continue;
			}
			if(pat[j - 1] == text[i - 1] || pat[j - 1] == '?'){
				match[i][j] = match[i - 1][j - 1];
			}else{
				if(pat[j - 1] == '*'){
					match[i][j] = match[i][j - 1] //Treating '*' as contributing empty space
								|| match[i - 1][j]; //Treating '*' as a wildcard for any sequence	
				}
			}
		}
	}
	return match[n][m] ? 1 : 0;
    }
    public static void main(String[] args){
    	int x = 14;  
        System.out.print(swapBitsInPair(x)); 
    }
    static int swapBitsInPair( int x) 
    { 
    	toBinary(x);
        // Extracting the high bit shift it to lowbit 
        // Extracting the low bit shift it to highbit
    	System.out.println();
    	toBinary((x & 0b10101010) >> 1);
    	System.out.println();
    	toBinary((x & 0b01010101) << 1);
    	System.out.println();
        return ((x & 0b10101010) >> 1) |  
                ((x & 0b01010101) << 1);  
    } 
    static void toBinary(int x){
    	if(x > 1){
    		toBinary(x/2);
    	}
    	System.out.print(x % 2);
    }
}
