/*
LeetCode #763 Parition Labels: O(n) time O(n) space

A string S of lowercase English letters is given. We want to partition this
string into as many parts as possible so that each letter appears in at most one
part, and return a list of integers representing the size of these parts.
*/

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> lastPosition = new HashMap<>();
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < S.length(); i++)
            lastPosition.put(S.charAt(i), i);
        int start = 0, end = -1;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastPosition.get(S.charAt(i)));
            if (end == i) {
                output.add(end + 1 - start);
                start = end + 1;
            }
        }
        return output;
    }
}

class PartitionLabels {
    public static void main(String[] args)
    {
        String S = "ababcbacadefegdehijhklij";
        List<Integer> output = new Solution().partitionLabels(S);
        System.out.print("{");
        for (int n : output)
            System.out.print(n + ", ");
        System.out.println("}");
    }
}