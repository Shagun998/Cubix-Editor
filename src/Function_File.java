import java.awt.FileDialog;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
public class Function_File {
	Main gui;
	String fileName, fileAddress;
public Function_File(Main gui){
	this.gui = gui;
}
//file method
public void newFile() {
	gui.textarea.setText("");
	gui.window.setTitle("Untitled -Cubix");
	fileName = null;
	fileAddress = null;
}
//open method
public void open() {
	FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
	     fd.setVisible(true);
	 if(fd.getFile()!=null) {
		 fileName = fd.getFile();
		 fileAddress = fd.getDirectory();
		 gui.window.setTitle(fileName);
	 }
	 try {
		 BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress +fileName));
	        gui.textarea.setText("");
	        String line = null;
	while ((line = bufferedReader.readLine())!=null) {
		gui.textarea.append(line + "\n");
	}
	    bufferedReader.close();
	 }catch(Exception e) {
		 System.out.println("Invalid file!");
	 }
}
//save method
public void save() {
	if(fileName==null) {
		saveAs();
	}else {
		try {
			FileWriter fw = new FileWriter(fileAddress +fileName);
			fw.write(gui.textarea.getText());
			gui.window.setTitle(fileName);
			fw.close();
		}catch(Exception e){
			System.out.println("Something went wrong!");
		}
	}
}
//save as method
public void saveAs() {
	FileDialog fd = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
	fd.setVisible(true);
	if(fd.getFile()!=null) {
		fileName = fd.getFile();
		fileAddress = fd.getDirectory();
		gui.window.setTitle(fileName);
	}try {
	FileWriter fw = new FileWriter(fileAddress +fileName);
	fw.write(gui.textarea.getText());
	fw.close();
	}catch(Exception e){
		System.out.println("Something went wrong!");
	}
}
//Print method
public void createPrint() {
	try {
		Boolean printer = gui.textarea.print();
		if(printer) {
			JOptionPane.showMessageDialog(null, "Printing done!");
		}else {
			JOptionPane.showMessageDialog(null, "Printing Cancelled!");
		}
		}catch(PrinterException event) {
         Logger.getLogger(gui.textarea.getName()).log(Level.SEVERE, null, event);
		}
	}
//exit method
public void exit() {
	System.exit(0);
}
}
