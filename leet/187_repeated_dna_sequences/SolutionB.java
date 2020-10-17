// LeetCode 187. Repeated DNA Sequences
// O(n) time, O(0xFFFF+1) space

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Arrays;

class SolutionB {

	static void p(Object o) { System.out.println(o); }

	public static void main(String args[]) {
		for (String a : args)
			p("ARG: " + a);
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		p("ANS: " + Arrays.toString(new SolutionB().findRepeatedDnaSequences(s).toArray()));
	}

	int getCode(char c) {
		switch(c) {
			case 'A' : return 0;
			case 'C' : return 1;
			case 'T' : return 2;
		}
		return 3;
	}

    public List<String> findRepeatedDnaSequences(String s) {
    	boolean seen[] = new boolean[0xFFFFF + 1];
    	Set<String> ret = new HashSet<>();

        if (s.length() < 10)
        	return new ArrayList<>();
        int hash = 0;
        for (int i = 0; i < 10; i++)
        	hash = (hash << 2) + getCode(s.charAt(i));
        seen[hash] = true;
        for (int i = 1; i <= s.length() - 10; i++) {
        	hash = (hash << 2) & 0xFFFFF | getCode(s.charAt(i + 9));
        	if (seen[hash])
        		ret.add(s.substring(i, i + 10));
        	else
        		seen[hash] = true;
        }
        return new ArrayList<>(ret);
    }
}
