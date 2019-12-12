import java.io.*;

public class DataFrameTest{  	
	public static void main(String[] args) throws IOException {
		DataFrame a = new DataFrame("Divvy_Trips_July2013.csv");
		DataFrame b = new DataFrame("PEdata-multiYear.csv");
		System.out.println(a);
		System.out.println(b);			
	
		//for PE file
		
		//test average
		System.out.println("Avg Invalid Column: "+b.average("invalid Column Name"));
		System.out.println("Avg ID: "+b.average("ID"));
		System.out.println("Avg Gender: "+b.average("gender"));
		System.out.println("Avg Test Number: "+b.average("Test_Number"));
		System.out.println("Avg Age: "+b.average("Age"));
		System.out.println("Avg Curl ups 1 min: "+b.average("Curl_Ups_1Min"));
		System.out.println("Avg Shuttle run: "+b.average("Shuttle_Run"));
		System.out.println("Avg Sit reach: "+b.average("Sit_Reach"));
		System.out.println("Avg Mile Run SS: "+b.average("Mile_RunSS"));
		System.out.println("Avg Push ups: "+b.average("Push_Ups"));
		System.out.println("Avg EmptyColumn: "+b.average("Nextse"));



		//test max
		System.out.println("Max Invalid Column: "+b.maximum("invalid Column Name"));
		System.out.println("Max ID: "+b.maximum("ID"));
		System.out.println("Max gender: "+b.maximum("gender"));
		System.out.println("Max Test Number: "+b.maximum("Test_Number"));
		System.out.println("Max age: "+b.maximum("Age"));
		System.out.println("Max Curl ups 1 min: "+b.maximum("Curl_Ups_1Min"));
		System.out.println("Max Shuttle run: "+b.maximum("Shuttle_Run"));
		System.out.println("Max Sit reach: "+b.maximum("Sit_Reach"));
		System.out.println("Max Mile Run SS: "+b.maximum("Mile_RunSS"));
		System.out.println("Max Push ups: "+b.maximum("Push_Ups"));
		

		
		//test min
		System.out.println("Min Invalid Column: "+b.minimum("invalid Column Name"));
		System.out.println("Min ID: "+b.minimum("ID"));
		System.out.println("Min gender: "+b.minimum("gender"));
		System.out.println("Min Test Number: "+b.minimum("Test_Number"));
		System.out.println("Min age: "+b.minimum("Age"));
		System.out.println("Min Curl ups 1 min: "+b.minimum("Curl_Ups_1Min"));
		System.out.println("Min Shuttle run: "+b.minimum("Shuttle_Run"));
		System.out.println("Min Sit reach: "+b.minimum("Sit_Reach"));
		System.out.println("Min Mile Run SS: "+b.minimum("Mile_RunSS"));
		System.out.println("Min Push ups: "+b.minimum("Push_Ups"));
		
		
		
		//test frequency
		System.out.println("Freq Invalid Column: "+b.frequency("invalid Column Name"));
		System.out.println("Freq ID: "+b.frequency("ID"));
		System.out.println("Freq gender: "+b.frequency("gender"));
		System.out.println("Freq Test Number: "+b.frequency("Test_Number"));
		System.out.println("Freq age: "+b.frequency("Age"));
		System.out.println("Freq Curl ups 1 min: "+b.frequency("Curl_Ups_1Min"));
		System.out.println("Freq Shuttle run: "+b.frequency("Shuttle_Run"));
		System.out.println("Freq Sit reach: "+b.frequency("Sit_Reach"));
		System.out.println("Freq Mile Run SS: "+b.frequency("Mile_RunSS"));
		System.out.println("Freq Push ups: "+b.frequency("Push_Ups"));

		
		
		//test checkOperatorValue
		System.out.println("OprVal1 : "+b.checkOperatorValue("2", "int", "<", "7" ));
		System.out.println("OprVal2 : "+b.checkOperatorValue("8", "int", "<", "7"));
		System.out.println("OprVal3 : "+b.checkOperatorValue("5", "int", ">", "7"));
		System.out.println("OprVal4 : "+b.checkOperatorValue("10", "int", ">", "7"));
		System.out.println("OprVal5 : "+b.checkOperatorValue("10", "int", "==", "7"));
		System.out.println("OprVal5. : "+b.checkOperatorValue("7", "int", "==", "7"));
		System.out.println("OprVal6 : "+b.checkOperatorValue("10", "int", "!=", "7"));
		System.out.println("OprVal6. : "+b.checkOperatorValue("7", "int", "!=", "7"));
		
		System.out.println("OprVal7 : "+b.checkOperatorValue("2", "double", "<", "7"));
		System.out.println("OprVal8 : "+b.checkOperatorValue("8", "double", "<", "7"));
		System.out.println("OprVal9 : "+b.checkOperatorValue("5", "double", ">", "7"));
		System.out.println("OprVal10 : "+b.checkOperatorValue("10", "double", ">", "7"));
		System.out.println("OprVal11 : "+b.checkOperatorValue("2", "double", "==", "7"));
		System.out.println("OprVal11. : "+b.checkOperatorValue("7", "double", "==", "7"));
		System.out.println("OprVal12 : "+b.checkOperatorValue("2", "double", "!=", "7"));
		System.out.println("OprVal12. : "+b.checkOperatorValue("7", "double", "!=", "7"));
		
		System.out.println("OprVal13 : "+b.checkOperatorValue("d", "char", "==", "e"));
		System.out.println("OprVal14 : "+b.checkOperatorValue("a", "char", "==", "a"));
		System.out.println("OprVal15 : "+b.checkOperatorValue("d", "char", "!=", "e"));
		System.out.println("OprVal16 : "+b.checkOperatorValue("a", "char", "!=", "a"));

		System.out.println("OprVal17 : "+b.checkOperatorValue("hello", "String", "==", "hi"));
		System.out.println("OprVal18 : "+b.checkOperatorValue("hi", "String", "==", "hi"));
		System.out.println("OprVal19 : "+b.checkOperatorValue("hello", "String", "!=", "hi"));
		System.out.println("OprVal20 : "+b.checkOperatorValue("hi", "String", "!=", "hi"));

		
		
		//test subset
		
		System.out.println(b.subset("Push_Ups", "<", "10"));

		System.out.println(b.subset("Push_Ups", "<", "10").minimum("gender"));
		System.out.println(b.subset("Shuttle_Run", ">", "20").maximum("Shuttle_Run"));
		System.out.println(b.subset("gender", "==", "F").frequency("Sit_Reach"));
		System.out.println(b.subset("Age", "!=", "12").average("Mile_RunSS"));
		System.out.println(b.subset("Age", "==", "M"));		//invalid

		
		
		//for Trip file
		
		
		//test average
		System.out.println("Avg Invalid Column: "+a.average("invalid Column Name"));
		System.out.println("Avg trip_id: "+a.average("trip_id"));
		System.out.println("Avg bikeid: "+a.average("bikeid"));
		System.out.println("Avg tripduration: "+a.average("tripduration"));
		System.out.println("Avg from_station_id: "+a.average("from_station_id"));
		System.out.println("Avg from_station_name: "+a.average("from_station_name"));
		System.out.println("Avg to_station_id: "+a.average("to_station_id"));
		System.out.println("Avg to_station_name: "+a.average("to_station_name"));
		System.out.println("Avg usertype: "+a.average("usertype"));
		System.out.println("Avg gender: "+a.average("gender"));
		System.out.println("Avg birthyear: "+a.average("birthyear"));



		//test max
		System.out.println("Max Invaid Column: "+a.maximum("invalid Column Name"));
		System.out.println("Max trip_id: "+a.maximum("trip_id"));
		System.out.println("Max bikeid: "+a.maximum("bikeid"));
		System.out.println("Max tripduration: "+a.maximum("tripduration"));
		System.out.println("Max from_station_id: "+a.maximum("from_station_id"));
		System.out.println("Max from_station_name: "+a.maximum("from_station_name"));
		System.out.println("Max to_station_id: "+a.maximum("to_station_id"));
		System.out.println("Max to_station_name: "+a.maximum("to_station_name"));
		System.out.println("Max usertype: "+a.maximum("usertype"));
		System.out.println("Max gender: "+a.maximum("gender"));
		System.out.println("Max birthyear: "+a.maximum("birthyear"));


		
		//test min
		System.out.println("Min Invalid Column: "+a.minimum("invalid Column Name"));
		System.out.println("Min trip_id: "+a.minimum("trip_id"));
		System.out.println("Min bikeid: "+a.minimum("bikeid"));
		System.out.println("Min tripduration: "+a.minimum("tripduration"));
		System.out.println("Min from_station_id: "+a.minimum("from_station_id"));
		System.out.println("Min from_station_name: "+a.minimum("from_station_name"));
		System.out.println("Min to_station_id: "+a.minimum("to_station_id"));
		System.out.println("Min to_station_name: "+a.minimum("to_station_name"));
		System.out.println("Min usertype: "+a.minimum("usertype"));
		System.out.println("Min gender: "+a.minimum("gender"));
		System.out.println("Min birthyear: "+a.minimum("birthyear"));

		
		
		//test frequency
		System.out.println("Freq Invalid Column: "+a.frequency("invalid Column Name"));
		System.out.println("Freq trip_id: "+a.frequency("trip_id"));
		System.out.println("Freq bikeid: "+a.frequency("bikeid"));
		System.out.println("Freq tripduration: "+a.frequency("tripduration"));
		System.out.println("Freq from_station_id: "+a.frequency("from_station_id"));
		System.out.println("Freq from_station_name: "+a.frequency("from_station_name"));
		System.out.println("Freq to_station_id: "+a.frequency("to_station_id"));
		System.out.println("Freq to_station_name: "+a.frequency("to_station_name"));
		System.out.println("Freq usertype: "+a.frequency("usertype"));
		System.out.println("Freq gender: "+a.frequency("gender"));
		System.out.println("Freq birthyear: "+a.frequency("birthyear"));

		
		
		//test checkOperatorValue
		System.out.println("OprVal1 : "+a.checkOperatorValue("2", "int", "<", "7" ));
		System.out.println("OprVal2 : "+a.checkOperatorValue("8", "int", "<", "7"));
		System.out.println("OprVal3 : "+a.checkOperatorValue("5", "int", ">", "7"));
		System.out.println("OprVal4 : "+a.checkOperatorValue("10", "int", ">", "7"));
		System.out.println("OprVal5 : "+a.checkOperatorValue("10", "int", "==", "7"));
		System.out.println("OprVal5. : "+a.checkOperatorValue("7", "int", "==", "7"));
		System.out.println("OprVal6 : "+a.checkOperatorValue("10", "int", "!=", "7"));
		System.out.println("OprVal6. : "+a.checkOperatorValue("7", "int", "!=", "7"));
		
		System.out.println("OprVal7 : "+a.checkOperatorValue("2", "double", "<", "7"));
		System.out.println("OprVal8 : "+a.checkOperatorValue("8", "double", "<", "7"));
		System.out.println("OprVal9 : "+a.checkOperatorValue("5", "double", ">", "7"));
		System.out.println("OprVal10 : "+a.checkOperatorValue("10", "double", ">", "7"));
		System.out.println("OprVal11 : "+a.checkOperatorValue("2", "double", "==", "7"));
		System.out.println("OprVal11. : "+a.checkOperatorValue("7", "double", "==", "7"));
		System.out.println("OprVal12 : "+a.checkOperatorValue("2", "double", "!=", "7"));
		System.out.println("OprVal12. : "+a.checkOperatorValue("7", "double", "!=", "7"));
		
		System.out.println("OprVal13 : "+a.checkOperatorValue("d", "char", "==", "e"));
		System.out.println("OprVal14 : "+a.checkOperatorValue("a", "char", "==", "a"));
		System.out.println("OprVal15 : "+a.checkOperatorValue("d", "char", "!=", "e"));
		System.out.println("OprVal16 : "+a.checkOperatorValue("a", "char", "!=", "a"));

		System.out.println("OprVal17 : "+a.checkOperatorValue("hello", "String", "==", "hi"));
		System.out.println("OprVal18 : "+a.checkOperatorValue("hi", "String", "==", "hi"));
		System.out.println("OprVal19 : "+a.checkOperatorValue("hello", "String", "!=", "hi"));
		System.out.println("OprVal20 : "+a.checkOperatorValue("hi", "String", "!=", "hi"));

		
		//test subset
		
		System.out.println(a.subset("tripduration", ">", "500"));

		System.out.println(a.subset("from_station_id", "<", "100").minimum("from_station_id"));
		System.out.println(a.subset("from_station_name", "==", "Clinton St & Tilden St").maximum("tripduration"));
		System.out.println(a.subset("gender", "==", "Male").frequency("trip_id"));
		System.out.println(a.subset("birthyear", "!=", "1971").average("to_station_id"));
		System.out.println(a.subset("to_station_name", "<", "300"));	//invalid
		
		
		
		

	}
}
