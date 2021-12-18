import java.awt.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class DateGUI extends JFrame implements DateGUIInterface{// Inheritance of another class
	private String             DateinFile;
	private StringTokenizer    myToken;
	protected JFrame           DateJframe;
	static UnsortedDate212List Unsorted = new UnsortedDate212List();// Inheritance of another class Date212List
	static SortedDate212List   sorted = new SortedDate212List();// Inheritance of another class Date212List
	private String 		       DateinToken;
	static JMenuBar            MenuBar;
	static JMenu               FileMenu;
	static JMenuItem           item,item1;
	Date212                    date;
	final String               Open =        "Open";
	final String               Quit =        "Quit";
	
	public DateGUI(String File) throws Exception {
		//GUI 
		DateJframe = new JFrame();
		DateJframe.setSize(400, 400);
		DateJframe.setLocation(500, 100);
		DateJframe.setTitle("Date/Sorted/Unsorted/Treemap");
		DateJframe.setLayout(new GridLayout(1, 3, 5, 5));
		DateJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FileMenu = new JMenu("File");
		MenuBar = new JMenuBar();
		FileMenuHandler fmh = new FileMenuHandler(this);
		
		item = new JMenuItem(Open);
		item1 = new JMenuItem(Quit);
		
		
		FileMenu.add(item);
		FileMenu.addSeparator();
		FileMenu.add(item1);
		
		
		
		item.addActionListener(fmh);//ActionListener in Java is a class that is responsible for handling all action events such as when the user clicks on a component.
		item1.addActionListener(fmh);
		
		
		DateJframe.setJMenuBar(MenuBar);
		MenuBar.add(FileMenu);
			
		DateJframe.setVisible(true);
		
	
	     
		

	}

	/**
	 * @param file takes a string value from main which reads the file Uses the
	 *             String tokenizer delimiters "," to separate each dates Date212
	 *             constructor takes every string in the tokenizer turns them into
	 *             integers Then the Date212 date is assigned to call unsorted and
	 *             sorted which is an Inheritance of another class Date212List Then
	 *             it's prints from the values from file to the textarea
	 *             
	 *             Uses a TreeMap to sort the Dates to the GUI 
	 * 
	 * @exception RuntimeException if an IOException is thrown when attempting to
	 *                             read from the file.
	 * 
	 */
	public void FileRead(String File) {
		TextFileInput F = new TextFileInput(File);
		TreeMap<Date212,String> tm = new TreeMap<Date212, String>(new ComDates());//TreeMap Declaration
		
		Container Content = DateJframe.getContentPane();// Container the interface between a component and the
				
		
		TextArea UnsortedTextArea = new TextArea();// multi-line region that displays text.
		TextArea SortedTextArea = new TextArea(); // text Display for sorted on the EAST side of JFRAME
		TextArea myTreeMapSorted = new TextArea();
		
		Content.add(myTreeMapSorted, BorderLayout.WEST);
		Content.add(UnsortedTextArea, BorderLayout.WEST);
		Content.add(SortedTextArea, BorderLayout.EAST);
		
		DateinFile = F.readLine();
		
		while (DateinFile != null) {
			
			myToken = new StringTokenizer(DateinFile, ",");
			while (myToken.hasMoreTokens()) {
				DateinToken = myToken.nextToken();
				
				try {
					
					date = new Date212(DateinToken);
					Unsorted.add(date);// .add calls the append method in the Date212List and adds another Node as the
					tm.put(new Date212(DateinToken), "null");//Adding new keys to the treemap
					sorted.add(date);// .add calls the append Sorted in the Date212List and adds another Node as the
										// loop is being called but it sorts it out
				} catch (Exception Error) {
					
					System.out.println(DateinToken+" : #isnt a valid date#");
				}
				  	      
			}
			DateinFile = F.readLine(); 
			
			

		}
		   
				
		try {//Output Dates to the GUI 
			
			   String TreeMapSort = "";
			   myTreeMapSorted.append("TreeMapSort"+"\n"+"\n");
			   Set<Date212> keys = tm.keySet();
			   
		        for(Date212 key:keys)
		        {
		        	TreeMapSort = key+" key value: "+tm.get(key)+"\n";
		           // System.out.println(key+" value: "+tm.get(key));
		            myTreeMapSorted.append(TreeMapSort);
		        }
		        
			UnsortedTextArea.append("Unsorted with Linked List"+"\n"+"\n");
			UnsortedTextArea.append(Unsorted.toString());
		  	    // System.out.println(Unsorted.toString());// Debugger
		  	     
		  	  SortedTextArea.append("Sorted with Linked List"+"\n"+"\n");
			  SortedTextArea.append(sorted.toString());
			    // System.out.println(sorted.toString());
			     
		} catch (Exception Error) 
		{
			System.out.println("#Program Unable to Output Invalid Dates..Please check the .txt file#");// makes sure the try {} is a valid
																				
		}
		DateJframe.pack();  

	}
}