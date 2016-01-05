import java.awt.GridLayout;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

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
	public static void RecupEtuAvecStage(Interface gui) throws SQLException
	{
		gui.nettoyer();
		gui.setTitle("Nombre d'étudiant(s) avec stage");
		gui.setSize(300, 300);
		gui.panel.setLayout(new GridLayout(2, 2));
		// On appelle la fonction stockée
		CallableStatement cst = co.prepareCall("{? = call nbEtudiantsAvecStage()}");
		cst.registerOutParameter(1, java.sql.Types.INTEGER);
		cst.execute();
		System.out.println(cst.getInt(1));
		gui.lblResult = new JLabel(Integer.toString(cst.getInt(1)));
		gui.panel.add(gui.lblResult);
		gui.panel.add(gui.btnRetour);
	}
	// ***************************************
	// **** QUESTION 2 ***********************
	// ***************************************
	public void RecupEtuSansStage(Interface gui) throws SQLException
	{
		gui.nettoyer();
		gui.setTitle("Nombre d'étudiant(s) avec stage");
		gui.setSize(300, 300);
		gui.panel.setLayout(new GridLayout(2, 2));
		// On appelle la fonction stockée
		CallableStatement cst = co.prepareCall("{? = call nbEtudiantsSansStage()}");
		cst.registerOutParameter(1, java.sql.Types.INTEGER);
		cst.execute();
		gui.lblResult = new JLabel(Integer.toString(cst.getInt(1)));
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
		gui.btnValider.addActionListener(gui);
		gui.panel.add(gui.btnValider);
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
