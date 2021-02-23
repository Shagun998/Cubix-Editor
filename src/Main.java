import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.undo.UndoManager;
public class Main extends JFrame implements ActionListener {
	JFrame window;
	JTextArea textarea;
	JScrollPane scrollbar;
	boolean wordWrap = false;
	JMenuBar menubar;
	//Menus under MenuBar
    JMenu menuFile, menuEdit, menuFormat,  menuMode;
    //MenuItems for File Menu
    JMenuItem iNew, iOpen, iSave, iSaveAs,iPrint, iExit;
    //Wordwrap menuItem for Format
    JMenuItem iWordwrap;
   JMenuItem lightMode, darkMode;
    //Menu for Font and FontSize in Format
    JMenu menuFont, menuFontSize;
   
    //Menu items for fonts
    JMenuItem iArial, iTimesRoman, iCalibri, iCambria, iAgency, iSitkaSmall;
   
    //Menu items for font Size
    JMenuItem iFontSize12, iFontSize14,iFontSize16, iFontSize18, iFontSize20, iFontSize22, iFontSize24, iFontSize26, iFontSize28, iFontSize36, iFontSize42, iFontSize56, iFontSize72;
	
    //Menu items for Edit
    JMenuItem iundo, iredo , icut, icopy, ipaste;
    
    //Calling of other classes
    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this); 
    Function_Format createFont = new Function_Format(this); 
    Function_Edit edit = new Function_Edit(this);
    Function_Light mode = new Function_Light(this);
    UndoManager um = new UndoManager();
    //Main Method
    public static void main(String args[]) {
	new Main();
}
public  Main() {
	//default Font
	format.selectedFont = "Nunito";
	format.createFont(10);
//	format.wordWrap();
	//Window Method
	createWindow();
	//method for text area
	createTextArea();
	//method for menubar
	createMenuBar();
	//method for FileMenu
	createFileMenu();
	//method for FormatMenu
	createFormatMenu();
	//method for editMenu
	createEditMenu();
	//method For Light and Dark Mode
	createMode();
	window.setVisible(true);
		textarea.setVisible(true);
}
public void createWindow(){
	window = new JFrame("Untitled -Cubix");
	window.setSize(600,600);
	Color col = new Color(48,48,48);
	window.setLocationRelativeTo(null);
	window.getContentPane().setBackground(col);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
}
public void createTextArea() {
	textarea = new JTextArea();
	textarea.setForeground(Color.WHITE);
	Color col = new Color(50,50,50);
	textarea.setBackground(col);
Font font = new Font("Consolas",Font.PLAIN,12);
textarea.setFont(font);
textarea.getDocument().addUndoableEditListener(new UndoableEditListener() {

	@Override
	public void undoableEditHappened(UndoableEditEvent e) {
		// TODO Auto-generated method stub
		um.addEdit(e.getEdit());
	}

});

scrollbar = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrollbar.setBorder(BorderFactory.createEmptyBorder());
scrollbar.getVerticalScrollBar().setBackground(Color.BLACK);
scrollbar.getHorizontalScrollBar().setBackground(Color.BLACK);
window.add(scrollbar,BorderLayout.CENTER);
scrollbar.getVerticalScrollBar().setUI(new BasicScrollBarUI(){
protected void configureScrollBarColors() {
		this.thumbColor = Color.GRAY;
	}
	});
scrollbar.getHorizontalScrollBar().setUI(new BasicScrollBarUI(){
	
	protected void configureScrollBarColors() {
		this.thumbColor = Color.GRAY;
	   }
   });
}
public void createMenuBar(){
menubar = new JMenuBar();
menubar.setBackground(Color.BLACK);
menubar.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
window.setJMenuBar(menubar);
menuFile = new JMenu("File");
menuFile.setForeground(Color.GRAY);
menuFile.setBorder(BorderFactory.createEmptyBorder());
menuFile.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
menubar.add(menuFile);

menuEdit = new JMenu("Edit");
menuEdit.setForeground(Color.GRAY);
menuEdit.setBorder(BorderFactory.createEmptyBorder());
menuEdit.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
menubar.add(menuEdit);

menuFormat = new JMenu("Format");
menuFormat.setForeground(Color.GRAY);
menuFormat.setBorder(BorderFactory.createEmptyBorder());
menuFormat.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
menubar.add(menuFormat);



menuMode = new JMenu("Mode");
menuMode.setForeground(Color.GRAY);
menuMode.setBorder(BorderFactory.createEmptyBorder());
menuMode.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
menubar.add(menuMode);
}
public void createFileMenu() {
	//Initialization of new MenuItem
	iNew = new JMenuItem("New");
	iNew.addActionListener(this);
	iNew.setActionCommand("New");
	iNew.setBackground(Color.BLACK);
	iNew.setForeground(Color.WHITE);
	iNew.setBorder(BorderFactory.createEmptyBorder());
	menuFile.add(iNew);
	
	//Initialization of Open MenuItem
	iOpen = new JMenuItem("Open");
	iOpen.addActionListener(this);
	iOpen.setActionCommand("Open");
	iOpen.setBackground(Color.BLACK);
	iOpen.setForeground(Color.WHITE);
	iOpen.setBorder(BorderFactory.createEmptyBorder());
	menuFile.add(iOpen);
	
	//Initialization of Save MenuItem
	iSave = new JMenuItem("Save");
	iSave.setBackground(Color.BLACK);
	iSave.addActionListener(this);
	iSave.setActionCommand("save");
	iSave.setForeground(Color.WHITE);
	iSave.setBorder(BorderFactory.createEmptyBorder());
	menuFile.add(iSave);
	
	//Initialization of SaveAs MenuItem
	iSaveAs = new JMenuItem("Save As");
	iSaveAs.setBackground(Color.BLACK);
	iSaveAs.addActionListener(this);
	iSaveAs.setActionCommand("saveAs");
	iSaveAs.setForeground(Color.WHITE);
	iSaveAs.setBorder(BorderFactory.createEmptyBorder());
	menuFile.add(iSaveAs);
	
	//Initialization of Print Menu Item
	iPrint = new JMenuItem("Print");
	iPrint.setForeground(Color.WHITE);
	iPrint.setBorder(BorderFactory.createEmptyBorder());
	iPrint.addActionListener(this);
	iPrint.setBackground(Color.BLACK);
	iPrint.setActionCommand("print");
	menuFile.add(iPrint);
	//Initialization of Exit MenuItem
	iExit = new JMenuItem("Exit");
	iExit.setBackground(Color.BLACK);
	iExit.setForeground(Color.WHITE);
	iExit.addActionListener(this);
	iExit.setActionCommand("exit");
	iExit.setBorder(BorderFactory.createEmptyBorder());
	menuFile.add(iExit);

}


public void createFormatMenu() {
	//Initialization of WordWrap MenuItem
	iWordwrap = new JMenuItem("WordWrap: Off");
	iWordwrap.setBackground(Color.BLACK);
	iWordwrap.setForeground(Color.WHITE);
	iWordwrap.setBorder(BorderFactory.createEmptyBorder());
	iWordwrap.setActionCommand("wrap");
	iWordwrap.addActionListener(this);
	menuFormat.add(iWordwrap);
	//Initialization of Format MenuItem
	
	menuFont = new JMenu("Font Family");
	menuFont.setOpaque(true);
	menuFont.setBackground(Color.BLACK);
	menuFont.setForeground(Color.WHITE);
	menuFont.setBorder(BorderFactory.createEmptyBorder());
	menuFont.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	menuFont.addActionListener(this);
	menuFont.setActionCommand("font");
    menuFormat.add(menuFont);
 
    //Initialization of Font Size MenuItem
    menuFontSize = new JMenu("Font Size");
    menuFontSize.setBackground(Color.BLACK);
    menuFontSize.setForeground(Color.WHITE);
    menuFontSize.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    menuFontSize.setBorder(BorderFactory.createEmptyBorder());
    menuFontSize.setActionCommand("fontSize");
    menuFontSize.addActionListener(this);
    menuFontSize.setOpaque(true);
    menuFormat.add(menuFontSize);

//Initialization of  Arial font
iArial = new JMenuItem("Arial");
iArial.addActionListener(this);
iArial.setActionCommand("Arial");
iArial.setBackground(Color.BLACK);
iArial.setForeground(Color.WHITE);
iArial.setBorder(BorderFactory.createEmptyBorder());
menuFont.add(iArial);

//Initialization of Calibri Font
iCalibri  = new JMenuItem("Calibri");
iCalibri.addActionListener(this);
iCalibri.setActionCommand("Calibri");
iCalibri.setForeground(Color.WHITE);
iCalibri.setBackground(Color.BLACK);
iCalibri.setBorder(BorderFactory.createEmptyBorder());
menuFont.add(iCalibri);

//Initialization of Times New Roman Font
iTimesRoman = new JMenuItem("Times New Roman");
iTimesRoman.setActionCommand("Times New Roman");
iTimesRoman.addActionListener(this);
iTimesRoman.setBackground(Color.BLACK);
iTimesRoman.setForeground(Color.WHITE);
iTimesRoman.setBorder(BorderFactory.createEmptyBorder());
menuFont.add(iTimesRoman);

//Initialization of Cambria Font
iCambria = new JMenuItem("Cambria");
iCambria.addActionListener(this);
iCambria.setActionCommand("Cambria");
iCambria.setBackground(Color.BLACK);
iCambria.setForeground(Color.WHITE);
iCambria.setBorder(BorderFactory.createEmptyBorder());
menuFont.add(iCambria);

//Initialization of Agency Font
iAgency = new JMenuItem("Agency FB");
iAgency.setActionCommand("Agency");
iAgency.addActionListener(this);
iAgency.setBackground(Color.BLACK);
iAgency.setForeground(Color.WHITE);
iAgency.setBorder(BorderFactory.createEmptyBorder());
menuFont.add(iAgency);

//Initialization of Sitka Small Font 
iSitkaSmall = new JMenuItem("Sitka Small");
iSitkaSmall.addActionListener(this);
iSitkaSmall.setActionCommand("Sitka Small");
iSitkaSmall.setBackground(Color.BLACK);
iSitkaSmall.setForeground(Color.WHITE);
iSitkaSmall.setBorder(BorderFactory.createEmptyBorder());
menuFont.add(iSitkaSmall);

//Initialization of FontSize12
iFontSize12 = new JMenuItem("12");
iFontSize12.setBackground(Color.BLACK);
iFontSize12.setForeground(Color.WHITE);
iFontSize12.addActionListener(this);
iFontSize12.setActionCommand("iFontSize12");
iFontSize12.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize12);

//Initialization of FontSize14
iFontSize14 = new JMenuItem("14");
iFontSize14.addActionListener(this);
iFontSize14.setActionCommand("iFontSize14");
iFontSize14.setBackground(Color.BLACK);
iFontSize14.setForeground(Color.white);
iFontSize14.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize14);

//Initalization of iFontSize16
iFontSize16 = new JMenuItem("16");
iFontSize16.setBackground(Color.BLACK);
iFontSize16.setForeground(Color.WHITE);
iFontSize16.setActionCommand("iFontSize16");
iFontSize16.addActionListener(this);
iFontSize16.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize16);

//Initalization of iFontSize18
iFontSize18 = new JMenuItem("18");
iFontSize18.setBackground(Color.BLACK);
iFontSize18.setForeground(Color.WHITE);
iFontSize18.addActionListener(this);
iFontSize18.setActionCommand("iFontSize18");
iFontSize18.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize18);

//Initalization of iFontSize20
iFontSize20 = new JMenuItem("20");
iFontSize20.setBackground(Color.BLACK);
iFontSize20.setForeground(Color.WHITE);
iFontSize20.addActionListener(this);
iFontSize20.setActionCommand("iFontSize20");
iFontSize20.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize20);

//Initalization of iFontSize22
iFontSize22 = new JMenuItem("22");
iFontSize22.setBackground(Color.BLACK);
iFontSize22.setForeground(Color.WHITE);
iFontSize22.addActionListener(this);
iFontSize22.setActionCommand("iFontSize22");
iFontSize22.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize22);

//Initalization of iFontSize24
iFontSize24 = new JMenuItem("24");
iFontSize24.setBackground(Color.BLACK);
iFontSize24.setForeground(Color.WHITE);
iFontSize24.addActionListener(this);
iFontSize24.setActionCommand("iFontSize24");
iFontSize24.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize24);

//Initalization of iFontSize26
iFontSize26 = new JMenuItem("26");
iFontSize26.setBackground(Color.BLACK);
iFontSize26.setForeground(Color.WHITE);
iFontSize26.addActionListener(this);
iFontSize26.setActionCommand("iFontSize26");
iFontSize26.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize26);

//Initalization of iFontSize28
iFontSize28 = new JMenuItem("28");
iFontSize28.setBackground(Color.BLACK);
iFontSize28.setForeground(Color.WHITE);
iFontSize28.addActionListener(this);
iFontSize28.setActionCommand("iFontSize28");
iFontSize28.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize28);

//Initalization of iFontSize36
iFontSize36 = new JMenuItem("36");
iFontSize36.addActionListener(this);
iFontSize36.setActionCommand("iFontSize36");
iFontSize36.setBackground(Color.BLACK);
iFontSize36.setForeground(Color.WHITE);
iFontSize36.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize36);

//Initalization of iFontSize42
iFontSize42 = new JMenuItem("42");
iFontSize42.addActionListener(this);
iFontSize42.setActionCommand("iFontSize42");
iFontSize42.setBackground(Color.BLACK);
iFontSize42.setForeground(Color.WHITE);
iFontSize42.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize42);

//Initalization of iFontSize56
iFontSize56 = new JMenuItem("56");
iFontSize56.setBackground(Color.BLACK);
iFontSize56.setForeground(Color.WHITE);
iFontSize56.addActionListener(this);
iFontSize56.setActionCommand("iFontSize56");
iFontSize56.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize56);

//Initalization of iFontSize72
iFontSize72 = new JMenuItem("72");
iFontSize72.setBackground(Color.BLACK);
iFontSize72.setForeground(Color.WHITE);
iFontSize72.addActionListener(this);
iFontSize72.setActionCommand("iFontSize72");
iFontSize72.setBorder(BorderFactory.createEmptyBorder());
menuFontSize.add(iFontSize72);
}

public void createEditMenu() {
	
	//Initialization of Undo MenuItem
		iundo = new JMenuItem("Undo");
		iundo.setOpaque(true);
		iundo.setBackground(Color.BLACK);
		iundo.setForeground(Color.WHITE);
		iundo.setBorder(BorderFactory.createEmptyBorder());
		iundo.addActionListener(this);
		iundo.setActionCommand("undo");
		menuEdit.add(iundo);
	
		//Initialization Redo MenuItem
		iredo = new JMenuItem("Redo");
		iredo.setOpaque(true);
		iredo.setBackground(Color.BLACK);
		iredo.setForeground(Color.WHITE);
		iredo.setBorder(BorderFactory.createEmptyBorder());
		iredo.addActionListener(this);
		iredo.setActionCommand("redo");
		menuEdit.add(iredo);
		
	    //Initialization of cut MenuItem
	    icut = new JMenuItem("Cut");
	    icut.setBackground(Color.BLACK);
	    icut.setForeground(Color.WHITE);
	    icut.setOpaque(true);
	    icut.setBorder(BorderFactory.createEmptyBorder());
	    icut.addActionListener(this);
	    icut.setActionCommand("Cut");
	    menuEdit.add(icut);
	
	    //Initialization of copy MenuItem
	    icopy = new JMenuItem("Copy");
	    icopy.setBackground(Color.BLACK);
	    icopy.setForeground(Color.WHITE);
	    icopy.setBorder(BorderFactory.createEmptyBorder());
	    icopy.addActionListener(this);
	    icopy.setActionCommand("Copy");
	    icopy.setOpaque(true);
	    menuEdit.add(icopy);
	
	    //Initialization of Paste MenuItem
	    ipaste = new JMenuItem("Paste");
	    ipaste.setBackground(Color.BLACK);
	    ipaste.setForeground(Color.WHITE);
	    ipaste.setBorder(BorderFactory.createEmptyBorder());
	    ipaste.addActionListener(this);
	    ipaste.setActionCommand("Paste");
	    ipaste.setOpaque(true);
	    menuEdit.add(ipaste);
}
public void createMode() {
	darkMode = new JMenuItem("Dark Mode");
	darkMode.setBackground(Color.BLACK);
	darkMode.setForeground(Color.WHITE);
	darkMode.setBorder(BorderFactory.createEmptyBorder());
	darkMode.addActionListener(this);
	darkMode.setActionCommand("dark");
	menuMode.add(darkMode);
	
	lightMode = new JMenuItem("Light Mode");
	lightMode.setBackground(Color.BLACK);
	lightMode.setForeground(Color.WHITE);
	lightMode.setBorder(BorderFactory.createEmptyBorder());
	lightMode.addActionListener(this);
	lightMode.setActionCommand("light");
	menuMode.add(lightMode);
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String command = e.getActionCommand();
	switch(command) {
	case "New":
	file.newFile();
	break;
	case "Open": 
	file.open();
	break;
	case "save":
		file.save();
		break;
	case "saveAs":
		file.saveAs();
		break;
	case "print" :
	file.createPrint();
	break;
	case "exit":
		file.exit();
		break;
	case "wrap":
		format.wordWrap();
		break;
	case "iFontSize12":
		format.createFont(12);
		break;
	case "iFontSize14":
		format.createFont(14);
		break;
	case "iFontSize16" :
		format.createFont(16);
		break;
	case "iFontSize18" :
		format.createFont(18);
		break;
	case "iFontSize20" :
		format.createFont(20);
		break;
	case "iFontSize22" :
		format.createFont(22);
		break;
	case "iFontSize24":
		format.createFont(24);
		break;
	case "iFontSize26":
		format.createFont(26);
		break;
	case "iFontSize28" :
		format.createFont(28);
		break;
	case "iFontSize36" :
		format.createFont(36);
		break;
	case "iFontSize42" :
		format.createFont(42);
		break;
	case "iFontSize56" :
		format.createFont(56);
		break;
	case "iFontSize72" :
		format.createFont(72);
		break;
	case "Arial":
		format.setFont("Arial");
		break;
	case "Cambria":
		format.setFont("Cambria");
		break;
	case "Agency" :
		format.setFont("Agency");
		break;
	case "Times New Roman" :   
		format.setFont("Times New Roman");
		break;
	case "Calibri" :
		format.setFont("Calibri");
		break;
	case "Sitka Small" :
		format.setFont( "Sitka Small");
		break;	
	case "light" :
		mode.createMode(command);
		break;
	case "dark":
		mode.createMode(command);
		break;
	case "undo":
		edit.undo();
		break;
	case "redo":
		edit.redo();
		break;
	case "Copy":
		edit.copy();
		break;
	case "Cut":
		edit.cut();
		break;
	case "Paste":
		edit.paste();
		break;
	}	
		
  }

}
