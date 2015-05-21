package com.mykumi.stringbuffer;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ThreadRunnerTest {

	private ArrayList<ThreadRunner> threadRunners;
	private StringBuilder sb;
	private StringBuffer sbf;	

	@Before
	public void setup() {
		sb = new StringBuilder();
		sbf = new StringBuffer();
		createRunners();
		activatedRunners();		
	}
	
	@Test
	public void testStringBuffer() throws InterruptedException {
		isAliveRunners();
		// StringBuffer의 경우 항상 160000이 나오는 것을 보장한다.
		assertThat(160000, is(sbf.toString().length()));
	}		
	
	@Test
	public void testStringBuilder() throws InterruptedException {
		isAliveRunners();
		// StringBuilder의 경우 항상 160000이 나오는 것을 보장하지 못한다.
		assertThat(160000, not(sb.toString().length()));
	}
	
	private void activatedRunners() {
		for (ThreadRunner tr : threadRunners) {
			tr.start();
		}
	}	
	
	private void createRunners() {
		threadRunners = new ArrayList<ThreadRunner>();
		
		threadRunners.add(new ThreadRunner("Thread-1", sb, sbf));
		threadRunners.add(new ThreadRunner("Thread-2", sb, sbf));
		threadRunners.add(new ThreadRunner("Thread-3", sb, sbf));
		threadRunners.add(new ThreadRunner("Thread-4", sb, sbf));
	}	
	
	private void isAliveRunners() throws InterruptedException {
		while(true) {
			boolean isAnyOneAlive = false;
			for (ThreadRunner tr : threadRunners) {
				if (tr.isThreadAlive() == true) {
					isAnyOneAlive = true;
					break;
				}
			}
			if (isAnyOneAlive == false) break;
			Thread.sleep(1);
		}
		System.out.println(" String Builder Length " +  sb.toString().length());
		System.out.println(" String Buffer Length " +  sbf.toString().length());		
		System.out.println("All Runner Exited");
	}
}
