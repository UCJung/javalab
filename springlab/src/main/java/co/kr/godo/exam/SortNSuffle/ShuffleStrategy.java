package co.kr.godo.exam.SortNSuffle;

public abstract class ShuffleStrategy {

	public abstract String getShuffleString(char[]... chars);

	protected int getMaxLength(char[]... chars) {
		int maxSize = 0;
		for (char[] member : chars) {
			maxSize = ( maxSize < member.length ) ? member.length : maxSize;  
		}
		return maxSize;
	}
}