import java.util.Stack;

public class DecodeString {
	
	public static void p(Object o) { System.out.println(o); }
	
	public static void main(String[] args) {
		String s = "abc3[3[2[c]3[d]]]xyz2[z]";
		String s1 = "ab3[c2[x]y]3[a]";
		String s2 = "ab3[x]o3[y]";
		p("Input: " + s + ": " + new Solution().decodeString(s));
	}
}

class Solution {

    public String decodeString(String s) {
    	Stack<StringBuilder> sbStack = new Stack<>();
    	Stack<Integer> kStack = new Stack<>();
    	int k = 0;
    	StringBuilder sb = new StringBuilder();
    	
    	for (char c : s.toCharArray()) {
    		if (c >= '0' && c <= '9') {
    			k = k * 10 + (c - '0');
    		} else if (c == '[') {
    			kStack.push(k);
    			sbStack.push(sb);
    			k = 0;
    			sb = new StringBuilder();
    		} else if (c == ']') {
    			StringBuilder prevSb = sbStack.pop();
    			k = kStack.pop();
    			while (k-- > 0)
    				prevSb.append(sb);
    			sb = prevSb;
    			k = 0;
    		} else
    			sb.append(c);    			
    	}
    	return sb.toString();
    }   
}
