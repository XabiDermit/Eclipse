package Interfaze;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Salbuespenak.ErabiltzaileaEzDaExistitzenException;
import Salbuespenak.KargaMotaEzDaExistitzenException;
import Salbuespenak.PelikulaEzDaExistitzenException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Lehio_Nagusia extends JFrame {

	private JPanel contentPane;
	private static Lehio_Nagusia nNagusi=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lehio_Nagusia frame = Lehio_Nagusia.getNagusia();
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
	private Lehio_Nagusia() {
		setTitle("Datuen karga");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		
		JButton btnDatuakKargatu = new JButton("Datuak Kargatu");
		btnDatuakKargatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MVC.getNireDatuak().Datuak_Kargatu();
				} catch (ErabiltzaileaEzDaExistitzenException | PelikulaEzDaExistitzenException
						| KargaMotaEzDaExistitzenException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDatuakKargatu.setBounds(70, 62, 209, 23);
		contentPane.add(btnDatuakKargatu);
		
		JButton btnNewButton = new JButton("Datuak Ezabatu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MVC.getNireDatuak().datuakEzabatu();
			}
		});
		btnNewButton.setBounds(70, 138, 209, 23);
		contentPane.add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(275, 220, 33, 21);
		contentPane.add(menuBar);
		
		JMenu mnIkusi = new JMenu("Ikusi");
		mnIkusi.setBounds(194, 219, 209, 22);
		
		JMenuItem mntmPelikulak = new JMenuItem("Pelikulak");
		mntmPelikulak.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setVisible(false);
				Datu_Lehioa.getDatuLehioa().setVisible(true);
				Datu_Lehioa.getDatuLehioa().pelikulakIkusi();
			}
		});
		mntmPelikulak.setBounds(29, 277, 129, 22);
		
		JMenuItem mntmErabiltzaileak = new JMenuItem("Erabiltzaileak");
		mntmErabiltzaileak.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Datu_Lehioa.getDatuLehioa().setVisible(true);
				try {
					Datu_Lehioa.getDatuLehioa().erabiltzaileakIkusi();
				} catch (ErabiltzaileaEzDaExistitzenException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmErabiltzaileak.setBounds(0, 315, 129, 22);
		
		mnIkusi.add(mntmPelikulak);
		mnIkusi.add(mntmErabiltzaileak);
		
		menuBar.add(mnIkusi);
		
		JButton btnIragazteMotaAukera = new JButton("Iragazte mota aukera");
		btnIragazteMotaAukera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					IragazteaAukeratu.getIragaztea().setVisible(true);
					setVisible(false);
				} catch (ErabiltzaileaEzDaExistitzenException | PelikulaEzDaExistitzenException
						| KargaMotaEzDaExistitzenException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnIragazteMotaAukera.setBounds(70, 295, 209, 23);
		contentPane.add(btnIragazteMotaAukera);

	}
	public static synchronized Lehio_Nagusia getNagusia() {
		if (nNagusi==null) {
			nNagusi=new Lehio_Nagusia();
		}
		return nNagusi;
	}
}