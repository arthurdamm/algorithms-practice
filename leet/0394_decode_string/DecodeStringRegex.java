import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecodeStringRegex {
	
	public static void p(Object o) { System.out.println(o); }
	
	public static void main(String[] args) {
		String s = "abc3[3[2[c]3[d]]]xyz2[z]";
		p("Input: " + s + ": " + new Solution().decodeString(s));
	}
}

class Solution2 {

	Pattern pattern = Pattern.compile("(?:(\\d+)\\[)|]");
	Matcher matcher;
	
    public String decodeString(String s) {
    	StringBuilder sb = new StringBuilder();
    	this.matcher = this.pattern.matcher(s);
    	recursive(s, 0, sb);
        return sb.toString();
    }
    
    int recursive(String s, int i, StringBuilder sb) {
    	while (this.matcher.find(i)) {
    		if (this.matcher.group(1) == null) {
    			sb.append(s, i, this.matcher.start());
    			return this.matcher.end();
    		} else {
    			sb.append(s, i, this.matcher.start());
    			StringBuilder subSb = new StringBuilder();
    			int sz = Integer.parseInt(this.matcher.group(1));
    			i = recursive(s, this.matcher.end(), subSb);
    			while (sz-- > 0)
    				sb.append(subSb);
    		}
    	}
    	sb.append(s, i, s.length());
		return s.length();			    	
    }
}
