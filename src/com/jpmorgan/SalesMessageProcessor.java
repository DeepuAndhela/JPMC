package com.jpmorgan;

import java.io.BufferedReader;
import java.io.FileReader;

import com.jpmorgan.processor.Sale;

public class SalesMessageProcessor {
	public static void main(String[] args) {
		// Initiate the sale object
		Sale sale = new Sale();

		// Read inputs from test file
		try {
			String line;
			BufferedReader inputFile = new BufferedReader(new FileReader("testInput/input.txt"));
			while ((line = inputFile.readLine()) != null) {
				// process message for each sale notification
				sale.processNotification(line);

				// Call the report
				// @note: report only generates after every 10th iteration and stops on 50th
				// iteration and pauses for
				// 2 seconds.
				sale.log.report();
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}