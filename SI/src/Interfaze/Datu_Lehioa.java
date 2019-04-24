package Interfaze;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

import Salbuespenak.ErabiltzaileaEzDaExistitzenException;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Datu_Lehioa extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private static Datu_Lehioa nDatu = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Datu_Lehioa frame = Datu_Lehioa.getDatuLehioa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private Datu_Lehioa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 564, 350);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Datu_Lehioa.class.getResource("/Fitxategiak/back_icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				try {
					datuakEzabatu();
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Lehio_Nagusia.getNagusia().setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 0, 50, 50);
		contentPane.add(btnNewButton);
	}
	public void pelikulakIkusi() {
		this.setTitle("Pelikulak");
		if (MVC.getNireDatuak() != null) {
			ArrayList<String> pelikulak = MVC.getNireDatuak().getPelikulak();
			for (int i=0; i<pelikulak.size();i++) {
				textArea.append(pelikulak.get(i) + "\n");
			}
		}
	}
	
	public void erabiltzaileakIkusi() throws ErabiltzaileaEzDaExistitzenException {
		this.setTitle("Erabiltzaileak");
		if (MVC.getNireDatuak() != null) {
			ArrayList<String> erabiltzaileak = MVC.getNireDatuak().getErabiltzaileak();
			for (int i=0; i<erabiltzaileak.size(); i++) {
				textArea.append(erabiltzaileak.get(i) +"\n");
			}
		}
	}
	
	private void datuakEzabatu() throws BadLocationException {
		this.textArea.getDocument().remove(0,textArea.getDocument().getLength());
	}
	public static synchronized Datu_Lehioa getDatuLehioa() {
		if (nDatu==null) {
			nDatu= new Datu_Lehioa();
		}
		return nDatu;
	}
	
}