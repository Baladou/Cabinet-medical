
package vue;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/***
 * la classe InterfMédcin permet d'affiche à un ytilisateur de type médcin une fenêtre qui contient les différences
 * tâches qu'il peut faire.
 * @author zineb
 *
 */
public class InterfMédcin extends JFrame {

	private JPanel contentPane;

	
	
	/**
	 * Create the frame.
	 */
	public InterfMédcin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		Panne pan= new Panne();
		setContentPane(pan);
		getContentPane().setLayout(null);
		/****
		 * Consultation du Plage Horraire: ce bouton permet à un medcin de consuleter les plages horaires
		 */
		JButton btnNewButton = new JButton("Consultation du Plage Horraire");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***
				 * appel de la fenêtre qui contient les informations.
				 */
				GestionPHmed m= new GestionPHmed();
				m.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setBounds(99, 154, 248, 23);
		pan.add(btnNewButton);
		/**
		 * ce bouton pert à un medcin de consulter les dossiers médicaux.
		 */
		JButton btnNewButton_1 = new JButton("Consultation des Dossiers M\u00E9dicaux");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//appel de la fenêtre qui contient les informations.
				GestionDMmed g=new GestionDMmed();
				g.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setBounds(99, 223, 248, 23);
		pan.add(btnNewButton_1);
		
		JLabel lblBienvenu = new JLabel("Bienvenue");
		lblBienvenu.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 36));
		lblBienvenu.setForeground(new Color(148, 0, 211));
		lblBienvenu.setBounds(29, 22, 260, 67);
		pan.add(lblBienvenu);
	}
}
