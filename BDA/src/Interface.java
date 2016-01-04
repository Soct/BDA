import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Interface  extends JFrame implements ActionListener {
	
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel labelCoureur = new JLabel();
	JButton btnRecupNbEtuAStage = new JButton("Nombre d'étudiant(s) avec stage ");
	JButton btnRecupNbEtuSStage = new JButton("Nombre d'étudiant(s) sans stage ");
	JButton btnRecupNbEtuSStageDate = new JButton("Nombre d'étudiant(s) sans stage à une date");
	JButton btnNbStagiaireParEntrepriseAnnee = new JButton("Nombre de stagiaire(s) pris par chaque entreprise durant les N dernières années");
	JButton btnNbStagiaireParEntrepriseAnneeMoy = new JButton("Moyenne du nombre de stagiaire(s) pris par chaque entreprise durant les N dernières années");
	JTextField txtRecherche = new JTextField();
	JButton btnNbStageZoneGeoChoix = new JButton ("Nombre de stages par zone choisi");
	JButton btnNbStageZoneGeo = new JButton ("Nombre de stages pour toute les zones");
	JButton btnEntrepriseAStageAnnee = new JButton ("Les entreprises et leur contact ayant eu un stage dans les n dernières années");
	JButton btnStats = new JButton ("Statistiques");
	JButton btnRetour = new JButton ("Retour");
	JButton btnConsulterInscrit = new JButton ("Consulter inscrit");
	JButton btnSinscire = new JButton ("S'inscrire");
	JButton btnPrecisionParcours = new JButton ("Afficher precision Parcours");
	JButton btnInfoCourse = new JButton ("Afficher info course");
	JButton btnValider = new JButton("Valider");
	JLabel prenom = new JLabel("prenom");
	JLabel sexe = new JLabel("sexe");
	JLabel nom = new JLabel("nom");
	JTextField txtNom= new JTextField();
	JLabel annee = new JLabel("anne de naissance");
	JTextField txtAnnee= new JTextField();
	
public Interface (String titre){
		
		super(titre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setVisible(true);
		panel.setLayout(new GridLayout(9, 2));
		menu();
		
	}
	
	public void menu(){
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
	
	public void nettoyer(){
		panel.removeAll();
		panel.repaint();
		panel.revalidate();
	}

	
	public static void main(String[] args) {

		Interface i = new Interface("Projet Base de Données Avancées");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		 Object source = e.getSource();
		 
		if (source == btnRecupNbEtuAStage){
			 nettoyer();
			 
		 }
		
	}

}
