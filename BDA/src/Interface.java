import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.nio.file.ExtendedCopyOption;

@SuppressWarnings("serial")
public class Interface extends JFrame implements ActionListener
{
	public JPanel panel = new JPanel();
	public JLabel label = new JLabel("");

	public static JButton btnRecupNbEtuAStage = new JButton("Nombre d'étudiant(s) avec stage ");
	public static JButton btnRecupNbEtuSStage = new JButton("Nombre d'étudiant(s) sans stage ");
	public static JButton btnRecupNbEtuSStageDate = new JButton("Nombre d'étudiant(s) sans stage à une date");
	public static JButton btnNbStagiaireParEntrepriseAnnee = new JButton(
	                    "Nombre de stagiaire(s) pris par " + "chaque entreprise durant les N dernières années");
	public static JButton btnNbStagiaireParEntrepriseAnneeMoy = new JButton("Moyenne du nombre de stagiaire"
	                    + "(s) pris par chaque entreprise durant les N dernières années");
	public static JButton btnNbStageZoneGeoChoix = new JButton("Nombre de stages par zone choisi");
	public static JButton btnNbStageZoneGeo = new JButton("Nombre de stages pour toute les zones");
	public static JButton btnEntrepriseAStageAnnee = new JButton(
	                    "Les entreprises et leur contact ayant eu " + "un stage dans les n dernières années");
	public static JButton btnStats = new JButton("Statistiques");
	public static JButton btnRetour = new JButton("Retour");

	public static JButton btnValider = new JButton("Valider");

	public static JLabel lblDate = new JLabel("Date :");
	public static JTextField txtDate = new JTextField();

	public static JLabel lblResult;

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
		this.setTitle("Projet Base de Données Avancées");
		this.setSize(600, 600);
		panel.setLayout(new GridLayout(9, 2));
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




	public void RecupEtuSansStage(Connection co) throws SQLException
	{
		nettoyer();
		this.setTitle("Nombre d'étudiant(s) avec stage");
		this.setSize(300, 300);
		panel.setLayout(new GridLayout(2, 2));
		// On appelle la fonction stockée
		CallableStatement cst = co.prepareCall("{? = call nbEtudiantsSansStage()}");
		cst.registerOutParameter(1, java.sql.Types.INTEGER);
		cst.execute();
		lblResult = new JLabel(Integer.toString(cst.getInt(1)));
		this.panel.add(lblResult);
		this.panel.add(btnRetour);
	}
	public void recupererEtudiantSStage()
	{
		nettoyer();
		this.setTitle("Nombre d'étudiant(s) sans stage à une date");
		this.setSize(600, 300);

		btnRetour.addActionListener(this);
		this.panel.add(btnRetour);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if (source == btnRecupNbEtuAStage)
		{
			try
			{
				Execution.RecupEtuAvecStage(this);
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}else if(source == btnRecupNbEtuSStage){
			try {
				Execution.RecupEtuSansStage(this);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(source == btnRecupNbEtuSStageDate){
		}
		else if (source == btnRecupNbEtuSStage)
		{
			nettoyer();
		}
		else if (source == btnRecupNbEtuSStageDate)
		{
			recupererEtudiantSStage();
		}
		else if (source == btnNbStageZoneGeo)
		{
			nettoyer();
		}
		else if (source == btnNbStageZoneGeoChoix)
		{
			Execution.choixZoneGeo(this);
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
			menu();
		}
		/*	
			try {
				co.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
	}
	public static void main(String[] args) throws InterruptedException, IOException
	{
		Interface i = new Interface("Projet Base de Données Avancées");
	}
}