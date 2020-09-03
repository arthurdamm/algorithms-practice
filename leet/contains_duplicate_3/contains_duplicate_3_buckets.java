import java.util.Map;
import java.util.HashMap;
import java.io.FileReader;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;


class Solution {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, long[]> seen = new HashMap<Long, long[]>();
        long[] bucket = new long[2];
        if (t < 0 || nums.length < 2)
            return false;
        for (int i = 0; i < nums.length; i++)
        {
            long j = nums[i] / (t + 1);

            if ((bucket = seen.getOrDefault(j, null)) != null &&
                i - bucket[0] <= k && Math.abs(bucket[1] - nums[i]) <= t)
                    return true;
            if ((bucket = seen.getOrDefault(j - 1, null)) != null &&
                i - bucket[0] <= k && Math.abs(bucket[1] - nums[i]) <= t)
                    return true;
            if ((bucket = seen.getOrDefault(j + 1, null)) != null &&
                i - bucket[0] <= k && Math.abs(bucket[1] - nums[i]) <= t)
                    return true;
            bucket = new long[2];
            bucket[0] = i;
            bucket[1] = nums[i];
            seen.put(j, bucket);
        }
        return false;
    }
}

public class Test
{
    public static void main(String args[])
    {
        Object obj = null;
        try {
             obj = new JSONParser().parse(new FileReader("foo.json"));
        } catch (Exception e) { System.out.println(e); }

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray solutions = (JSONArray) jsonObject.get("arr");

            int[] a = new int[solutions.size()];
            for (int i = 0; i < solutions.size(); ++i) {
                a[i] = ((Long)solutions.get(i)).intValue();
            }
            System.out.println("TEST: " + Solution.containsNearbyAlmostDuplicate(a, 10000, 0));

    }
}
