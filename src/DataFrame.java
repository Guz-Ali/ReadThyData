import java.io.*;
import java.util.*;


import java.lang.Object;

public class DataFrame {
	String[][] data;
	String [] headers, types;
	int numRows, numCols;
	boolean checkColumnName;
	

	public DataFrame(String [] newHeaders, String [] newTypes){
		headers=newHeaders;
		types=newTypes;
		numCols=headers.length;
		data = new String[25000][numCols];
		numRows=0;
	}
	
	public DataFrame(String inputFile) throws IOException{
		if (inputFile!=null) {
			File inFile = new File(inputFile);
			Scanner in = new Scanner(inFile);
			headers = in.nextLine().split(",");			
			types = in.nextLine().split(",");
			numCols=headers.length;
			data = new String[25000][numCols];
			numRows=0;
			while (in.hasNextLine()) {
				append(in.nextLine());				
			}							
		}
	}
	
	public boolean append(String row){
		if (numRows<25000 && row !=null) {
			String [] temp=row.split(",");
			if (temp.length==numCols) {
				data[numRows]=temp;
				numRows++;
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public double average (String columnName) {
		
		double sum=0;
		boolean foundAvg=false;
		double average=0;
		int i=0;
		
		for (int ii=0; ii<headers.length; ii++) {
			if(columnName.equals(headers[ii])) { 
				if (numRows>0) {
				if(types[ii].equals("int")||types[ii].equals("double")) {
					while(i<numRows) {
						sum+=Double.valueOf(data [i] [ii]);
						i++;//i = number of data					
					}
					average = sum/i;				
					foundAvg=true;
				}
			}
			}	
					
		}
		if (foundAvg)	return average;
		else return Double.NaN;
	}	
		
	
	public double maximum (String columnName) {
		 boolean foundMax=false;

		double max=-10;//initial value should be smaller than valid range
		int ii=0;
		for(ii=0; ii<headers.length; ii++) {
			if(columnName.equals(headers[ii])) {
				if (numRows>0) {
				if( types[ii].equals("int")||types[ii].equals("double")) {
					for(int i=0; i<numRows; i++) {						
						if(Double.valueOf(data[i][ii]) > max)	max= Double.valueOf(data[i][ii]);											
					}
					foundMax=true;						
				}
			}
			}				
		}
		if (foundMax)	return max;
		else return Double.NEGATIVE_INFINITY;
	}
	
	public double minimum (String columnName) {
		 boolean foundMin=false;

		double min=9999999;
		//initial value should be smaller than valid range
		int ii=0;
	
		for(ii=0; ii<headers.length; ii++) {
			if(columnName.equals(headers[ii])) {
				if (numRows>0) {
				if( types[ii].equals("int")||types[ii].equals("double")) {
					for(int i=0; i<numRows; i++) {						
						if(Double.valueOf(data[i][ii]) < min)	min= Double.valueOf(data[i][ii]);											
					}
					foundMin=true;						
				}
			}
			}				
		}
		if (foundMin)	return min;
		else return Double.POSITIVE_INFINITY;
	}
	
	
	public String frequency (String columnName) {
		int ii=0;
		String freq="";
		boolean foundFreq=false;
		for(ii=0; ii<headers.length; ii++) {
			if(columnName.equals(headers[ii])) {
				if (numRows>0) {
					if( types[ii].equals("int")||types[ii].equals("double")) {					
						double min = minimum(columnName);
						double max = maximum(columnName);
						double totalrange= max-min;	//total range will be divided by 5, we find the each range by that
					
						double upperRanges[]= new double[4];					
						upperRanges[0]= min+totalrange/5;//range 1 = min ... min+totalrange/5
						upperRanges[1]= upperRanges[0]+totalrange/5;
						upperRanges[2]= upperRanges[1]+totalrange/5;
						upperRanges[3]= upperRanges[2]+totalrange/5;
						int counters[]= new int[5];
					
						for(int i=0; i<numRows; i++) {
							if (Double.valueOf(data[i][ii])<upperRanges[0] && Double.valueOf(data[i][ii])>=min)	counters[0]++;
							else if (Double.valueOf(data[i][ii])<upperRanges[1] && Double.valueOf(data[i][ii])>=upperRanges[0])	counters[1]++;
							if (Double.valueOf(data[i][ii])<upperRanges[2] && Double.valueOf(data[i][ii])>=upperRanges[1])	counters[2]++;
							if (Double.valueOf(data[i][ii])<upperRanges[3] && Double.valueOf(data[i][ii])>=upperRanges[2])	counters[3]++;
							else if(Double.valueOf(data[i][ii])<=max && Double.valueOf(data[i][ii])>=upperRanges[3])	counters[4]++;
						}
				
						freq = "\n["+min+", "+ upperRanges[0]+") " + "count: "+counters[0] +"\n"+
								"["+upperRanges[0]+", "+ upperRanges[1]+") " + "count: "+counters[1] +"\n"+
								"["+upperRanges[1]+", "+ upperRanges[2]+") " + "count: "+counters[2] +"\n"+
								"["+upperRanges[2]+", "+ upperRanges[3]+") " + "count: "+counters[3] +"\n"+
								"["+upperRanges[3]+", "+ max+"] " + "count: "+counters[4];
						foundFreq=true;
						break;
					}
				}
			}
		}
		if (foundFreq)return freq;
		else return "";
	}
	
	public boolean checkOperatorValue(String columnData, String type, String operator, String value) {
		try {		
			
		if (type.equals("double")) {
			if( operator.equals("==") && Double.valueOf(columnData) == Double.valueOf(value))	return true;	
			else if(operator.equals("<") && Double.valueOf(columnData) < Double.valueOf(value))	return true;	
			else if(operator.equals(">") && Double.valueOf(columnData) > Double.valueOf(value))	return true;			
			else if(operator.equals("!=") && Double.valueOf(columnData) != Double.valueOf(value))	return true;			
			else return false;		
			}	
		else if (type.equals("int")) {
			if( operator.equals("==") && Integer.valueOf(columnData) == Integer.valueOf(value)) 	return true;		
			else if(operator.equals("<") && Integer.valueOf(columnData) < Integer.valueOf(value))	return true;
			else if(operator.equals(">") && Integer.valueOf(columnData) > Integer.valueOf(value))	return true;
			else if(operator.equals("!=") && Integer.valueOf(columnData) != Integer.valueOf(value))	return true;
			else return false;
			}	
		else if (type.equals("char")) {
			if(operator.equals("==") && columnData.equals(value))	return true;
			else if(operator.equals("!=") && !columnData.equals(value))	return true;
			else return false;
		}
		else if (type.equals("String")) {
			if(operator.equals("==") && columnData.equals(value))return true;
			else if(operator.equals("!=") && !columnData.equals(value))return true;
			else return false;
		}
		}
		
		catch (NumberFormatException nfe) {
	        return false;
	   }
		
		
		return false;
	}
	
	
	public DataFrame subset(String columnName, String operator, String value) {
		int ii=0;
		String newLines="";
		DataFrame newDataFrame = new DataFrame(headers, types);

		boolean foundSubset=false;
		for(ii=0; ii<headers.length; ii++) {
			if(columnName.equals(headers[ii])&& numRows>0) {
					for(int i=0; i<numRows;i++) {
						if(checkOperatorValue(data[i][ii], types[ii], operator, value)) {
							for(int j=0; j<headers.length-1;j++) {
								newLines+=data[i][j]+",";
								if(j==headers.length-2)	{	
									newLines+=data[i][j+1];								
								}
							}
							newDataFrame.append(newLines);
							newLines="";
						
							
						}
						foundSubset=true;
					}
					break;
				
			}
			
		}		
			
		if(foundSubset) return newDataFrame;
		else return null;
		}
	
	

	public String toString() {
		String temp = "";
		for (int i=0;i<numCols; i++) {
			temp=temp+headers[i];
			if (i<headers.length-1) temp=temp+",";
		}
		return "RowCount="+numRows+" ColumnHeaders="+temp;
	}
}

