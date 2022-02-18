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
            
            HashMap<String,ArrayList<String>> map = new HashMap<>();
        
            for(String s: strs){
                
                char[] arr = s.toCharArray();
                Arrays.sort(arr);
                String key = new String(arr);
    
                if(!map.containsKey(key)){
                    ArrayList<String> newlist = new ArrayList<String>();
                    newlist.add(s);
                    map.put(key, newlist);
                } else {
                    map.get(key).add(s);
                }
            }
            
            List<List<String>> list = new  ArrayList<List<String>>();
            
            for(ArrayList<String> l: map.values()){
                list.add(l);
            }
            
            return list;
            
        }
    }
}