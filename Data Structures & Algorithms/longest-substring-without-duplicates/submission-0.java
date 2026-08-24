class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;

        HashMap<Character,Integer> seenCharacter = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);
            if(seenCharacter.containsKey(currentChar)){
                left = Math.max(left, seenCharacter.get(currentChar) + 1);
            }
            seenCharacter.put(currentChar, right);
            maxLength = Math.max(maxLength, right-left + 1);
        } 
        return maxLength;
    }
}
