package com.techm.project.dee.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CandidateRegistrationNumber {

	public static String generateRegistrationNumber() {
		
		Random random = new Random();
		String currentYear = String.valueOf(LocalDate.now().getYear()).substring(2, 4);
		String currentMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
		String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HHSS"));
		int randomNumber = random.nextInt(6000 - 5001) + 5000;

		return currentYear + currentMonth + randomNumber + currentTime;
	}
}