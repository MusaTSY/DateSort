import java.util.Comparator;

class Date212  {

private int year;//Declaration of the dates 
private int month;
private int day;

public Date212(String yyyymmdd) throws Exception{//Date212 Construction that take string parameters
	if(yyyymmdd.length()>8|| yyyymmdd.length()<8) {
		throw new IllegalDateException("not valid amount of dates");
	}//Calls my IllegalDateException Class
	
	this.year =  yeartoInt(yyyymmdd);//Call the to interger function which converts from string to int
	this.month = MonthtoInt(yyyymmdd);
	this.day = daytoInt(yyyymmdd);
	

}//Constructor

//Getters 
public int getDay(){return day;}

public int getMonth(){return month;}

public int getYear(){return year;}
//Setters
public void setDay(int day){this.day = day;}

public void setMonth(int month){this.month = month;}

public void setYear(int year){this.year = year;}

public String toString() {	//Method to change the date to desired String format to the GUI 
	return Zellercongruence(day, month, year)+", "+toNamesofMonth(month) + " " + day + ", " + year;
	
}

private String toNamesofMonth(int month){ // changes to name of month
	if(month <=0 )
	throw new IllegalArgumentException("Month is invalid");
	switch(month){
		case 1:
			return "January"; 
		case 2:
			return "February";
		case 3:
			return "March";
		case 4: 
			return "April";
		case 5:
			return "May";
		case 6: 
			return "June";
		case 7: 
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return"December";
	}
	return "DNE";
}
	
public int compareTo(Date212 o2) {
	 //This Checks the year 
		if (this.year < o2.year)
		{
			return -1;
		}
		else if (this.year > o2.year)
		{
			return 1;
		}
		//This Checks the month if years are the same 
		else
	  	{
			if (this.month < o2.month)
			{
				return -1;
			}
			else if (this.month > o2.month)
			{
				return 1;
			}
			//if Months are also the Same it checks the Days 
		 else
	    {
			 if (this.day < o2.day)
			 {
				 return -1;
			 }
			 else if (this.day > o2.day)
			 {
				 return 1;
			 }
	    }
	  }
	  return 0;
}

private int yeartoInt(String year) {
	
	int nYear= Integer.parseInt(year.substring(0,4));
	return nYear;
	
}
private int MonthtoInt(String month) {
	int nMonth= Integer.parseInt(month.substring(4,6));
	if(nMonth > 12) {
		throw new IllegalDateException("Month is not valid");
	}
	else 
	return nMonth;
}
private int daytoInt(String day) {
	
	int nDay= Integer.parseInt(day.substring(6));
	if(nDay > 31) {
		throw new IllegalDateException("Month is not valid");
	}
	return nDay;
}

public boolean equals (Object Other) {
	if(Other!= null) {
		if(Other instanceof Date212) {
			Date212 Date =(Date212)Other;
			if(this.year==Date.getYear()&&this.month==Date.getMonth()&&this.day==Date.getDay()) {
				return true;
			}
		}
	}
	return false;
}

public String Zellercongruence(int day, int month, int year)
{
    if (month == 1) {
        month = 13;
        year--;
    }
    if (month == 2) {
        month = 14;
        year--;
    }
    int q = day;
    int m = month;
    int k = year % 100;
    int j = year / 100;
    
    int h = q + 13 * (m + 1) / 5 + k + k / 4 +
                              j / 4 + 5 * j;
    h = h % 7;
    switch (h) {
    case 0:
        return "Saturday";
	case 1:
        return "Sunday";
	case 2:
        return "Monday";
	case 3:
        return "Tuesday";
	case 4:
        return "Wednesday";
	case 5:
        return "Thursday";
	case 6:
        return "Friday";
    }
    return "DNE";
}}
class ComDates implements Comparator<Date212>{//A comparator interface is used to order the objects of user-defined classes.
 
    @Override
    //checks year is valid
    public int compare(Date212 e1, Date212 e2) {
        if(e1.getYear() < e2.getYear()){
            return -1;
        } else if (e1.getYear() > e2.getYear())
        {
            return 1;
        }
        else {
        	if (e1.getMonth() < e2.getMonth())
			{
				return -1;
			}
			else if (e1.getMonth() > e2.getMonth())
			{
				return 1;
			}
			//if Months are also the Same it checks the Days 
		 else
	    {
			 if (e1.getDay() <e2.getDay())
			 {
				 return -1;
			 }
			 else if (e1.getDay()> e2.getDay())
			 {
				 return 1;
			 }
	    }
	  }
	  return 0;
        }
    }

//Class 
