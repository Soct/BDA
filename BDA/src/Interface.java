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
	
	JButton btnRecupNbEtuAStage = new JButton("Nombre d'�tudiant(s) avec stage ");
	JButton btnRecupNbEtuSStage = new JButton("Nombre d'�tudiant(s) sans stage ");
	JButton btnRecupNbEtuSStageDate = new JButton("Nombre d'�tudiant(s) sans stage � une date");
	JButton btnNbStagiaireParEntrepriseAnnee = new JButton("Nombre de stagiaire(s) pris par "
			+ "chaque entreprise durant les N derni�res ann�es");
	JButton btnNbStagiaireParEntrepriseAnneeMoy = new JButton("Moyenne du nombre de stagiaire"
			+ "(s) pris par chaque entreprise durant les N derni�res ann�es");
	JButton btnNbStageZoneGeoChoix = new JButton ("Nombre de stages par zone choisi");
	JButton btnNbStageZoneGeo = new JButton ("Nombre de stages pour toute les zones");
	JButton btnEntrepriseAStageAnnee = new JButton ("Les entreprises et leur contact ayant eu "
			+ "un stage dans les n derni�res ann�es");
	JButton btnStats = new JButton ("Statistiques");
	JButton btnRetour = new JButton ("Retour");


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

		Interface i = new Interface("Projet Base de Donn�es Avanc�es");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Ouvrir connexion base de donn�es
		
		 Object source = e.getSource();
		 
		if (source == btnRecupNbEtuAStage){
			 nettoyer();
		}else if(source == btnRecupNbEtuSStage){
			nettoyer();
		}else if(source == btnRecupNbEtuSStageDate){
			nettoyer();
		}else if(source == btnNbStageZoneGeo){
			nettoyer();
		}else if(source == btnNbStageZoneGeoChoix){
			nettoyer();
		}else if(source == btnNbStagiaireParEntrepriseAnnee){
			nettoyer();
		}else if(source == btnNbStagiaireParEntrepriseAnneeMoy){
			nettoyer();
		}else if(source == btnEntrepriseAStageAnnee){
			nettoyer();
		}else if(source == btnStats){
			nettoyer();
		}else if(source == btnRetour){
			nettoyer();
			menu();
		}
		
		//Fermer connexion bdd
		
	}

}
