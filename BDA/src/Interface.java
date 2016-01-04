import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Interface extends JFrame implements ActionListener
{
	public static String id="";
	public static String mdp="";
	
	public JPanel panel = new JPanel();
	public JLabel label = new JLabel();

	public JButton btnRecupNbEtuAStage = new JButton("Nombre d'étudiant(s) avec stage ");
	public JButton btnRecupNbEtuSStage = new JButton("Nombre d'étudiant(s) sans stage ");
	public JButton btnRecupNbEtuSStageDate = new JButton("Nombre d'étudiant(s) sans stage à une date");
	public JButton btnNbStagiaireParEntrepriseAnnee = new JButton(
	                    "Nombre de stagiaire(s) pris par " + "chaque entreprise durant les N dernières années");
	public JButton btnNbStagiaireParEntrepriseAnneeMoy = new JButton("Moyenne du nombre de stagiaire"
	                    + "(s) pris par chaque entreprise durant les N dernières années");
	public JButton btnNbStageZoneGeoChoix = new JButton("Nombre de stages par zone choisi");
	public JButton btnNbStageZoneGeo = new JButton("Nombre de stages pour toute les zones");
	public JButton btnEntrepriseAStageAnnee = new JButton(
	                    "Les entreprises et leur contact ayant eu " + "un stage dans les n dernières années");
	public JButton btnStats = new JButton("Statistiques");
	public JButton btnRetour = new JButton("Retour");

	public Interface(String titre)
	{
		super(titre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setVisible(true);
		panel.setLayout(new GridLayout(9, 2));
		menu();
	}

	public void menu()
	{
		nettoyer();
		btnRecupNbEtuAStage.addActionListener(this);
		this.panel.add(btnRecupNbEtuAStage);
		btnRecupNbEtuSStage.addActionListener(this);
		this.panel.add(btnRecupNbEtuSStage);
		btnRecupNbEtuSStageDate.addActionListener(this);
		this.panel.add(btnRecupNbEtuSStageDate);
		btnNbStagiaireParEntrepriseAnnee.addActionListener(this);
		this.panel.add(btnNbStagiaireParEntrepriseAnnee);
		btnNbStagiaireParEntrepriseAnneeMoy.addActionListener(this);
		this.panel.add(btnNbStagiaireParEntrepriseAnneeMoy);
		btnNbStageZoneGeo.addActionListener(this);
		this.panel.add(btnNbStageZoneGeo);
		btnNbStageZoneGeoChoix.addActionListener(this);
		this.panel.add(btnNbStageZoneGeoChoix);
		btnEntrepriseAStageAnnee.addActionListener(this);
		this.panel.add(btnEntrepriseAStageAnnee);
		btnStats.addActionListener(this);
		this.panel.add(btnStats);
		this.add(panel);
	}
	public void nettoyer()
	{
		panel.removeAll();
		panel.repaint();
		panel.revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// On se connecte à la base de données
		String url = "jdbc:oracle:thin:" + id + "/" + mdp + "@oracle.iut-orsay.fr:1521:etudom";
		Connection co = OutilsJDBC.connexion(url);

		Object source = e.getSource();

		if (source == btnRecupNbEtuAStage)
		{
			nettoyer();
		}
		else if (source == btnRecupNbEtuSStage)
		{
			nettoyer();
		}
		else if (source == btnRecupNbEtuSStageDate)
		{
			nettoyer();
		}
		else if (source == btnNbStageZoneGeo)
		{
			nettoyer();
		}
		else if (source == btnNbStageZoneGeoChoix)
		{
			nettoyer();
		}
		else if (source == btnNbStagiaireParEntrepriseAnnee)
		{
			nettoyer();
		}
		else if (source == btnNbStagiaireParEntrepriseAnneeMoy)
		{
			nettoyer();
		}
		else if (source == btnEntrepriseAStageAnnee)
		{
			nettoyer();
		}
		else if (source == btnStats)
		{
			nettoyer();
		}
		else if (source == btnRetour)
		{
			nettoyer();
			menu();
		}
	}
	public static void main(String[] args) throws InterruptedException, IOException
	{
		String[] options = {"OK"};
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel lbl = new JLabel("Entrez votre identifiant : ");
		JLabel lbl2 = new JLabel("Entrez votre mot de passe : ");
		JTextField txt = new JTextField(10);
		JTextField txt2 = new JTextField(10);
		panel.add(lbl);
		panel.add(txt);
		panel2.add(lbl2);
		panel2.add(txt2);
		int selectedOption = JOptionPane.showOptionDialog(null, panel, "Connexion à la BDD", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
		int selectedOption2 = JOptionPane.showOptionDialog(null, panel2, "Connexion à la BDD", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
		id=txt.getText();
		mdp=txt2.getText();
		
		Interface i = new Interface("Projet Base de Données Avancées");
	}
}

