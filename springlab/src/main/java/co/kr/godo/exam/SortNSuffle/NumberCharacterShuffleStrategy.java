package co.kr.godo.exam.SortNSuffle;

class NumberCharacterShuffleStrategy implements SuffleStrategy {
	@Override
	public String getShuffleString(char[] chars, char[] nums) {
		int charsLength = chars.length;
	    int numsLength = nums.length;
	    int limit = (charsLength > numsLength) ? charsLength : numsLength;
	    StringBuilder sbResult = new StringBuilder();
	    for ( int i = 0 ; i < limit ; i ++ ){
	        if (numsLength > i ) sbResult.append(nums[i]);
	        if (charsLength > i ) sbResult.append(chars[i]);
	    }
		return sbResult.toString();
	}
}