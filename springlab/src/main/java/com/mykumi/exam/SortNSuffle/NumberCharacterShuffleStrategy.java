package com.mykumi.exam.SortNSuffle;

import java.util.List;

class NumberCharacterShuffleStrategy extends ShuffleStrategy {
	@Override
	public String getShuffleString(List<StringExtractor> stringExtractors) {
		StringBuilder sbResult = new StringBuilder();
		int limit = getMaxLength(stringExtractors);
	    for ( int i = 0 ; i < limit ; i ++ ){
	    	for (StringExtractor member : stringExtractors) {
		        if (member.getSortedArray().length > i ) sbResult.append(member.getSortedArray()[i]);	    		
	    	}
	    }
		return sbResult.toString();
	}
}