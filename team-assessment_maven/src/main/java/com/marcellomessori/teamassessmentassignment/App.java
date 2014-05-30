package com.marcellomessori.teamassessmentassignment;

public class App 
{
    public static void main( String[] args )
    {
		String resourceFileName = "persons.csv";
		
		if (args.length > 0) {
			resourceFileName = args[0];
		}
		
		try {
			MyCsv myCsv = new MyCsv(resourceFileName);
			System.out.println(myCsv.view());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
    }
}
