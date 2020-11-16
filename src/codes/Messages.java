package codes;

import java.time.format.DateTimeFormatter;

public class Messages {
	
	static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
	static String ANNOUNCE_SCORES = "Throw scores: ";
	static String NUMBER_1_SCORE = "Number 1: %d";
	static String NUMBER_2_SCORE = "Number 2: %d";
	static String NUMBER_3_SCORE = "Number 3: %d";
	static String NUMBER_4_SCORE = "Number 4: %d";
	static String NUMBER_5_SCORE = "Number 5: %d";
	static String NUMBER_6_SCORE = "Number 6: %d";
	static String TOTAL_THROWS = "Total throws: %d + %d + %d + %d + %d + %d = %d";
	static String THROWING_DIE = "%s -- %s throws die and gets a %d";
	static String THREAD_EXCEPTION = "%s -- Exception found in thread %s -- Error: %s";

}
