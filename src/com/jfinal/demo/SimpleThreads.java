package com.jfinal.demo;

public class SimpleThreads {
	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.err.format("%s: %s%n", threadName, message);
	}

	private static class MessageLoop implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			String importantInfo[] = { //
					"Mares eat oats", //
					"Does eat oats", //
					"Little lambs eat ivy", //
					"A kid will eat ivy too" };
			try {
				for (int i = 0; i < importantInfo.length; i++) {
					Thread.sleep(4000);
					threadMessage(importantInfo[i]);
				}
			} catch (InterruptedException e) {
				threadMessage("I wasn't done!");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		long patience = 3000;// 1000 * 60 * 60;
		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread thread = new Thread(new MessageLoop());
		thread.start();

		threadMessage("Waiting for MessageLoop thread to finish");

		while (thread.isAlive()) {
			threadMessage("Still waiting....");
			thread.join(1000);

			if (((System.currentTimeMillis() - startTime)) > patience && thread.isAlive()) {
				threadMessage("Tired of waiting!");
				thread.interrupt();

				// thread.join();
			}
		}


		Thread t = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++)
					threadMessage("第" + i + "次执行！");

				Thread.yield();
			}
		});
		t.start();
		t.join();
		
		threadMessage("Finally!");
	}
}
