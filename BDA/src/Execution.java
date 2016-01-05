import java.awt.GridLayout;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Execution
{
	// VARIABLES
	public static Connection co;
	// ***************************************
	// **** IDENTIFICATION *******************
	// ***************************************
	public static void connexionID()
	{
		boolean oneTime = false;
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
		do
		{
			if (oneTime)
			{
				Object[] options2 = {"OK"};
				int n = JOptionPane.showOptionDialog(null, "Identification échouée ou connexion inexistante. Veuillez réessayer", "Connexion échouée !",
				                    JOptionPane.PLAIN_MESSAGE, JOptionPane.WARNING_MESSAGE,
				                    null, options2, options2[0]);
			}
			int selectedOption = JOptionPane.showOptionDialog(null, panel, "Connexion à la BDD",
			                    JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
			                    options[0]);
			int selectedOption2 = JOptionPane.showOptionDialog(null, panel2, "Connexion à la BDD",
			                    JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
			                    options[0]);
			// CONNEXION A LA BASE DE DONNEES
			String url = "jdbc:oracle:thin:" + txt.getText() + "/" + txt2.getText()
			                    + "@oracle.iut-orsay.fr:1521:etudom";
			co = OutilsJDBC.connexion(url);
			oneTime = true;
		}
		while (co == null);
	}
	// ***************************************
	// **** QUESTION 1 ***********************
	// ***************************************
	public static void RecupEtuAvecStage(Interface gui)
	{
		gui.nettoyer();
		gui.setTitle("Nombre d'étudiant(s) avec stage");
		gui.setSize(300, 300);
		gui.panel.setLayout(new GridLayout(2, 2));
		// On appelle la fonction stockée
<<<<<<< HEAD
		CallableStatement cst = co.prepareCall("{? = call nbEtudiantsAvecStage}");
		cst.registerOutParameter(1, java.sql.Types.INTEGER);
		cst.execute();
		System.out.println(cst.getInt(1));
		gui.lblResult = new JLabel("Resultat : " + Integer.toString(cst.getInt(1)), JLabel.CENTER);

		gui.btnRetour.addActionListener(gui);
=======
		CallableStatement cst;
		try
		{
			cst = co.prepareCall("{? = call nbEtudiantsAvecStage}");
			cst.registerOutParameter(1, java.sql.Types.INTEGER);
			cst.execute();
			gui.lblResult = new JLabel(Integer.toString(cst.getInt(1)));
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
>>>>>>> origin/master
		gui.panel.add(gui.lblResult);
		gui.btnRetour.addActionListener(gui);
		gui.panel.add(gui.btnRetour);
	}
	// ***************************************
	// **** QUESTION 2 ***********************
	// ***************************************
<<<<<<< HEAD
	public static void RecupEtuSansStage(Interface gui) throws SQLException
=======
	public static void RecupEtuSansStage(Interface gui)
>>>>>>> origin/master
	{
		gui.nettoyer();
		gui.setTitle("Nombre d'étudiant(s) sans stage");
		gui.setSize(300, 300);
		gui.panel.setLayout(new GridLayout(2, 2));
		// On appelle la fonction stockée
<<<<<<< HEAD
		CallableStatement cst = co.prepareCall("{? = call nbEtudiantsSansStage}");
		cst.registerOutParameter(1, java.sql.Types.INTEGER);
		cst.execute();
		gui.lblResult = new JLabel("Resultat : " + Integer.toString(cst.getInt(1)), JLabel.CENTER);
		gui.btnRetour.addActionListener(gui);
=======
		CallableStatement cst;
		try
		{
			cst = co.prepareCall("{? = call nbEtudiantsSansStage}");
			cst.registerOutParameter(1, java.sql.Types.INTEGER);
			cst.execute();
			gui.lblResult = new JLabel(Integer.toString(cst.getInt(1)));
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
>>>>>>> origin/master
		gui.panel.add(gui.lblResult);
		gui.btnRetour.addActionListener(gui);
		gui.panel.add(gui.btnRetour);
	}
	// ***************************************
	// **** QUESTION 3 ***********************
	// ***************************************
	
	public static void recupererEtudiantSStage(Interface gui){
		gui.nettoyer();
		gui.setTitle("Nombre d'étudiant(s) sans stage à une date précise");
		gui.setSize(300, 300);

		gui.panel.setLayout(new GridLayout(2, 2));
		gui.panel.add(gui.lblDate);
		gui.panel.add(gui.txtDate);
		gui.btnValiderDate.addActionListener(gui);
		gui.panel.add(gui.btnValiderDate);
		gui.btnRetour.addActionListener(gui);
		gui.panel.add(gui.btnRetour);
	}
	public static void recupererEtudiantSStageResul(Interface gui, java.sql.Date d) throws SQLException{
		gui.nettoyer();
		gui.setTitle("Nombre d'étudiant(s) sans stage à une date précise");
		gui.setSize(300, 300);
		// On appelle la fonction stockée
				CallableStatement cst = co.prepareCall("{? = call nbEtudiantsSansStageAvecDate(?)}");
				Date date = new Date(2000, 01, 01);
				cst.setDate(2, date);
				cst.registerOutParameter(1, java.sql.Types.INTEGER);
				cst.execute();
				gui.lblResult = new JLabel("Resultat : " + Integer.toString(cst.getInt(1)), JLabel.CENTER);
				gui.btnRetour.addActionListener(gui);
				gui.panel.add(gui.lblResult);
				gui.panel.add(gui.btnRetour);
	}
	// ***************************************
	// **** QUESTION X ***********************
	// ***************************************
	public static void choixZoneGeo(Interface gui)
	{
		gui.nettoyer();
		gui.setTitle("Nombre de stages par zone géo choisi");
		gui.setSize(600, 300);
		gui.panel.setLayout(new GridLayout(5, 2));
		gui.panel.add(gui.lblDate);
		gui.panel.add(gui.txtDate);
		gui.btnValiderZone.addActionListener(gui);
		gui.panel.add(gui.btnValiderZone);
		gui.panel.add(gui.label);
		gui.btnRetour.addActionListener(gui);
		gui.panel.add(gui.btnRetour);
	}
	// ***************************************
	// **** MAIN *****************************
	// ***************************************
	public static void main(String[] args)
	{
		connexionID();
		Interface gui=new Interface("Sisi la famille");
	}
	
}
