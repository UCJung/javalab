package com.mykumi.exam.SortNSuffle;

import java.util.List;

public abstract class ShuffleStrategy {

	public abstract String getShuffleString(List<StringExtractor> stringExtractors);
	protected int getMaxLength(List<StringExtractor> stringExtractors) {
		int maxSize = 0;
		for (StringExtractor member : stringExtractors) {
			char[] sorted = member.getSortedArray();
			maxSize = ( maxSize < sorted.length ) ? sorted.length : maxSize;  
		}
		return maxSize;
	}
}