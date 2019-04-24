package Interfaze;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Salbuespenak.AukeraBatEginBeharDaException;
import Salbuespenak.ErabiltzaileaEzDaExistitzenException;
import Salbuespenak.KargaMotaEzDaExistitzenException;
import Salbuespenak.PelikulaEzDaExistitzenException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IragazteaAukeratu extends JFrame {

	private JPanel contentPane;
	private JTextField txtIderabiltzailea;
	private JTextField txtIdpelikula;
	private static IragazteaAukeratu nIragaztea=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IragazteaAukeratu frame = new IragazteaAukeratu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws KargaMotaEzDaExistitzenException 
	 * @throws PelikulaEzDaExistitzenException 
	 * @throws ErabiltzaileaEzDaExistitzenException 
	 */
	private IragazteaAukeratu() throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException, KargaMotaEzDaExistitzenException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JRadioButton ErabIr = new JRadioButton("Erabiltzaileetan oinarritutako iragazte kolaboratiboa");
		ErabIr.setBounds(95, 105, 279, 23);
		contentPane.add(ErabIr);
		
		JRadioButton ProdIr = new JRadioButton("Produktuetan oinarritutako iragazte kolaboratiboa");
		ProdIr.setBounds(95, 131, 265, 23);
		contentPane.add(ProdIr);
		
		JRadioButton EzaIr = new JRadioButton("Ezaugarrietan oinarritutako iragaztea");
		EzaIr.setBounds(95, 157, 265, 23);
		contentPane.add(EzaIr);
		
		ButtonGroup taldea = new ButtonGroup();
			taldea.add(ErabIr);
			taldea.add(ProdIr);
			taldea.add(EzaIr);
			
		JLabel ErabID = new JLabel("Erabiltzailearen IDa sartu:");
		ErabID.setBounds(79, 26, 138, 14);
		contentPane.add(ErabID);
			
		JLabel ProdID = new JLabel("Pelikularen IDa sartu:");
		ProdID.setBounds(79, 51, 138, 14);
		contentPane.add(ProdID);
			
		txtIderabiltzailea = new JTextField();
		txtIderabiltzailea.setBounds(227, 23, 120, 20);
		contentPane.add(txtIderabiltzailea);
		txtIderabiltzailea.setColumns(10);
			
		txtIdpelikula = new JTextField();
		txtIdpelikula.setBounds(227, 48, 120, 20);
		contentPane.add(txtIdpelikula);
		txtIdpelikula.setColumns(10);
			
		JLabel lblIragazteMotaAukeratu = new JLabel("Iragazte mota aukeratu:");
		lblIragazteMotaAukeratu.setBounds(79, 84, 138, 14);
		contentPane.add(lblIragazteMotaAukeratu);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(227, 226, 120, 22);
		contentPane.add(textArea);
		
		JButton btnBalorazioaEstimatu = new JButton("Balorazioa estimatu");
		btnBalorazioaEstimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					int eID = Integer.parseInt(txtIderabiltzailea.getText());
					int pID = Integer.parseInt(txtIdpelikula.getText());
					Double b = null;
					if (ErabIr.isSelected()) {
						b = MVC.getNireDatuak().erabiltzaileaBalorazioaEstimazioa(eID, pID);
					}
					else if (ProdIr.isSelected()) {
						b = MVC.getNireDatuak().produktuaBalorazioaEstimazioa(eID, pID);
					}
					else if (EzaIr.isSelected()) {
						b = MVC.getNireDatuak().ezaugarriaBalorazioaEstimazioa(eID, pID);
					}
					else {
							try {
								throw new AukeraBatEginBeharDaException();
							} catch (AukeraBatEginBeharDaException e1) {}
					}
					String emaitza = b.toString();
					textArea.setText(emaitza);
				} catch(NumberFormatException excep) {
					System.out.println("Zenbaki bat sartu behar da.");
				} catch (ErabiltzaileaEzDaExistitzenException | PelikulaEzDaExistitzenException e1) {}
			}
		});
		btnBalorazioaEstimatu.setBounds(135, 192, 177, 23);
		contentPane.add(btnBalorazioaEstimatu);
		
		
		JLabel lblBalorazioEstimatua = new JLabel("Balorazio estimatua:");
		lblBalorazioEstimatua.setBounds(79, 231, 102, 14);
		contentPane.add(lblBalorazioEstimatua);
		
		JButton button = new JButton("<--");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Lehio_Nagusia.getNagusia().setVisible(true);
			}
		});
		button.setBounds(10, 11, 59, 23);
		contentPane.add(button);
		
	}
	
	public static synchronized IragazteaAukeratu getIragaztea() throws ErabiltzaileaEzDaExistitzenException, PelikulaEzDaExistitzenException, KargaMotaEzDaExistitzenException {
		if (nIragaztea==null) {
			nIragaztea= new IragazteaAukeratu();
		}
		return nIragaztea;
		
	}
}