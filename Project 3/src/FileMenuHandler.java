import java.awt.event.*;
import java.io.File;

import javax.swing.*;
public class FileMenuHandler implements ActionListener {//ActionListener in Java is a class that is responsible for handling all action events such as when the user clicks on a component.
DateGUI DGUI;
final String               Open =        "Open";//The values can't be changed
final String               Quit =        "Quit";
public FileMenuHandler (DateGUI d) {
	DGUI = d;
}
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
			if(name.equals(Open)) { //Checks what action is performed and more actioncommand can be added depending on the programmer
				Openkey();
			}
			else if (name.equals(Quit)) {
					System.exit(0);
			}

}
		

	public void Openkey() { //Gives "Open" an Action to do 
		final JFileChooser Pick = new JFileChooser();
		Pick.showOpenDialog(null);
		File selected = Pick.getSelectedFile();
		try {
		String nameoffile = selected+"";
		System.out.println("THE DIRECTORY OF FILE: "+nameoffile);
		DGUI.FileRead(nameoffile);
		}
		catch(Exception e){//if the files ur looking for exist
			
			System.out.println("Please make sure the file exist");
		//Pick.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//	LIST_ALL(selected,"");
			
		}
		
	}
	public static void LIST_ALL(File f, String indent) {//Checks all the files in Directory
		File files[]=f.listFiles();
		int l = (int) f.length();
		
		for(int i = 0; i<l;i++) {
			File f2 = files[i];
			System.out.print(indent+f2.getName());
			System.out.print("...");
			System.out.print(f2.lastModified());
			System.out.print("...");
			System.out.print(f2.length());
			if(f2.isDirectory())
				LIST_ALL(f2,indent+" ");
			
		}
	}
}


