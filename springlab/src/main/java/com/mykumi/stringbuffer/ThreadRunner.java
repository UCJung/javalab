package com.mykumi.stringbuffer;

public class ThreadRunner implements Runnable {
	private Thread t;
	private String threadName; 
	private StringBuilder sb;
	private StringBuffer sbf;
	
	
	public ThreadRunner(String threadName, StringBuilder sb, StringBuffer sbf) {
		this.threadName = threadName;
		this.sb = sb;
		this.sbf = sbf;
		System.out.println("Create : " + this.threadName);
	}
	
	@Override
	public void run() {
		System.out.println("Running : " + threadName);
		for (int i = 4; i > 0 ; i--) {
			for (int j = 0 ; j < 10000 ; j ++ ) {
				synchronized (sb) {
					sb.append("a");
				}
				sbf.append("a");
			}
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Exited " +  threadName);
	}
	
	public void start() {
		System.out.println("Strat " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
	
	public boolean isThreadAlive() {
		return this.t.isAlive();
	}
}
