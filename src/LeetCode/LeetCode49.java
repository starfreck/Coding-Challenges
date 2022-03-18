package LeetCode;
import java.util.*;

/**
 * 49. Group Anagrams
 * URL: https://leetcode.com/problems/group-anagrams/
 * Asked: Morgan Stanley 
 */
public class LeetCode49 {
    
    class Solution {
    
        public List<List<String>> groupAnagrams(String[] strs) {
        
            HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
            
            for(String s: strs){
                
                System.out.println(s);
                
                char[] charArr = s.toCharArray();
                
                Arrays.sort(charArr);
                
                String key = new String(charArr);
                
                if(map.get(key) == null){
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(s);
                    map.put(key,list);
                } else {
                    map.get(key).add(s);
                }
                
            }
            
            return new ArrayList(map.values());
    }
}