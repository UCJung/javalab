package co.kr.godo.exam.SortNSuffle;

import java.util.ArrayList;
import java.util.List;

public class SortNShuffle {
	private String inputString;
	private List<StringExtractor> stringExtractors = new ArrayList<StringExtractor>(); 
	
	public SortNShuffle(String inputString) {
		this.inputString = inputString;
		this.setExtractor("\\d+", "[a-zA-Z]+");
	}
	
	public SortNShuffle(String inputString, String... regexs) {
		this.inputString = inputString;
		this.setExtractor(regexs);
	}
	
	public void setExtractor(String... regexs) {
		this.clearAllExtractor();
		for (String regex : regexs) {
			this.addExtractor(regex);
		}
	}
	
	public void addExtractor(String regex) {
		stringExtractors.add(new StringExtractor(regex));
	}
	
	public void clearAllExtractor() {
		this.stringExtractors.clear();
	}
	
	public String doing(ShuffleStrategy stgy) {
		collectPatternString();
		getSortedArray();
	    return stgy.getShuffleString(stringExtractors);
	}

	public void getSortedArray() {
		for (StringExtractor se : stringExtractors) {
			se.exTractStringToSortedArray();
		}
	}

	public void collectPatternString() {
		for (StringExtractor se : stringExtractors) {
			se.extractPatternString(inputString);
		}
	}
}
