import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 824, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		frame.getContentPane().add(textArea);
		
		//creacción elementos
		JMenu file, edit, help;
		JMenuItem cut, copy, paste, selectAll, openFile;
		
		//creamos la barra de menú
		JMenuBar menuBar = new JMenuBar();
		
		//creamos las opciones del menú
		file = new JMenu("File");
		edit = new JMenu("Edit");
		help = new JMenu("Help");
		
		//creamos los menuItem
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		selectAll = new JMenuItem("SelectAll");
		openFile = new JMenuItem("OpenFile");
		
		//Añadimos las subOpciones a la opcion edit 
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectAll);
		
		//Añadimos las subOpciones a la opcion file
		file.add(openFile);
		
		//Añadimos las opciones a la barra de menu
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		
		//Añadimos al frame la barra de menú creada
		frame.setJMenuBar(menuBar);
		
		ActionListener editorAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JMenuItem item = (JMenuItem)e.getSource();
				if(item.getText().equals("Cut")) {
					textArea.cut();
				}else if (item.getText().equals("Copy")) {
					textArea.copy();
				}else if (item.getText().equals("Paste")) {
					textArea.paste();
				}else if (item.getText().equals("SelectAll")) {
					textArea.selectAll();
				}
			}
		};
		cut.addActionListener(editorAction);
		copy.addActionListener(editorAction);
		paste.addActionListener(editorAction);
		selectAll.addActionListener(editorAction);
		
	}
}
