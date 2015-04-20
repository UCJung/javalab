package co.kr.godo.exam.SortNSuffle;

class NumberCharacterShuffleStrategy implements SuffleStrategy {
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

	public int getMaxLength(char[]... chars) {
		int maxSize = 0;
		for (char[] member : chars) {
			maxSize = ( maxSize < member.length ) ? member.length : maxSize;  
		}
		return maxSize;
	}
}