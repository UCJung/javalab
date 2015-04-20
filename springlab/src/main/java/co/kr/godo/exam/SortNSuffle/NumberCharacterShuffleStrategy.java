package co.kr.godo.exam.SortNSuffle;

class NumberCharacterShuffleStrategy extends ShuffleStrategy {
	@Override
	public String getShuffleString(char[]... chars) {
		StringBuilder sbResult = new StringBuilder();
		int limit = getMaxLength(chars);
	    for ( int i = 0 ; i < limit ; i ++ ){
	    	for (char[] member : chars) {
		        if (member.length > i ) sbResult.append(member[i]);	    		
	    	}
	    }
		return sbResult.toString();
	}
}