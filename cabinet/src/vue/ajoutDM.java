package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class ajoutDM extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoutDM frame = new ajoutDM();
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
	public ajoutDM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GestPane pane=new GestPane();
		//contentPane.add(pane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		pane.setLayout(null);
		setContentPane(pane);
		
		JLabel lblNewLabel = new JLabel("Entrez les donn\u00E9es du dossier m\u00E9dical");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(31, 11, 374, 31);
		pane.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("ID_Patient");
		lblNewLabel1.setBounds(10, 76, 89, 14);
		pane.add(lblNewLabel1);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setBounds(350, 401, 141, 23);
		pane.add(btnNewButton);
		
		JTextField id_pat = new JTextField();
		id_pat.setBounds(186, 73, 159, 20);
		pane.add(id_pat);
		id_pat.setColumns(10);
		
		JLabel lblNomComplet = new JLabel(" Nom Complet Patient");
		lblNomComplet.setBounds(10, 113, 118, 14);
		pane.add(lblNomComplet);
		
		JLabel lblDate = new JLabel("ID_M\u00E9dcin");
		lblDate.setBounds(10, 155, 89, 14);
		pane.add(lblDate);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(186, 110, 159, 20);
		pane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(186, 152, 159, 20);
		pane.add(textField_1);
		
		JLabel lblNomCompletMdcin = new JLabel("Nom Complet M\u00E9dcin");
		lblNomCompletMdcin.setBounds(10, 206, 135, 14);
		pane.add(lblNomCompletMdcin);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(186, 200, 159, 20);
		pane.add(textField_2);
		
		JLabel lblRemarques = new JLabel("Remarques");
		lblRemarques.setBounds(10, 261, 89, 14);
		pane.add(lblRemarques);
		
		JLabel lblMdicaments = new JLabel("M\u00E9dicaments");
		lblMdicaments.setBounds(10, 296, 89, 14);
		pane.add(lblMdicaments);
		
		JLabel lblDateconsultation = new JLabel(" Date_Consultation");
		lblDateconsultation.setBounds(10, 336, 89, 14);
		pane.add(lblDateconsultation);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(186, 243, 159, 20);
		pane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(186, 293, 159, 20);
		pane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(186, 333, 159, 20);
		pane.add(textField_5);
		
	
	}

}
