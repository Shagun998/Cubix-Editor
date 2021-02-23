import java.awt.Font;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Function_Format {
     Main gui;
     Font  iArial, iTimesRoman, iCalibri, iCambria, iAgency, iSitkaSmall;
     String selectedFont;
public Function_Format(Main gui) {
      this.gui = gui;
}
//wordwrap mehtod
	 public void wordWrap() {
		 if(gui.wordWrap==false) {
			 gui.wordWrap=true;
			 gui.textarea.setLineWrap(true);
			 gui.textarea.setWrapStyleWord(true);
			 gui.iWordwrap.setText("Word Wrap: On");
		 }else if(gui.wordWrap==true) {
			 gui.wordWrap = false;
			 gui.textarea.setLineWrap(false);
			 gui.textarea.setWrapStyleWord(false);
			 gui.iWordwrap.setText("Word Wrap: Off");
		 }
	 }
	 //create font method
	 public void createFont(int fontSize) {
		 iArial = new Font("Arial", Font.PLAIN, fontSize);
		 iTimesRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
		 iCalibri = new Font("Calibri", Font.PLAIN, fontSize);
		 iCambria = new Font("Cambria", Font.PLAIN, fontSize);
		 iSitkaSmall = new Font("Sitka Small", Font.PLAIN, fontSize);
		 iAgency = new Font("Agency FB", Font.PLAIN, fontSize);
		 setFont(selectedFont);
	 }
	 //set font method
	 public void setFont(String font) {
		  selectedFont = font;
		 switch(selectedFont) {
		 case "Arial":
			 gui.textarea.setFont(iArial);
			 break;
		 case "Times New Roman" :
			 gui.textarea.setFont(iTimesRoman);
			 break;
		 case "Calibri" :
			 gui.textarea.setFont(iCalibri);
			 break;
		 case "Cambria":
			 gui.textarea.setFont(iCambria);
			 break;
		 case "Sitka Small":
			 gui.textarea.setFont(iSitkaSmall);
			 break;
		 case "Agency":
			 gui.textarea.setFont(iAgency);
			 break;
		 }
		
	 }
}
