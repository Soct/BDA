import java.io.IOException;
import java.sql.*;
// Classe de connexion pour JDBC
// Corentin Filoche
public class OutilsJDBC
{
	// ************************************************************
	// ***** CONNEXION ********************************************
	// ************************************************************
	// Permet de créer une connexion à la BDD passée en paramètre
	public static Connection connexion(String url)
	{
		// On définit la connexion
		Connection co = null;
		// On essaye de se connecter
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			co = DriverManager.getConnection(url);
		}
		// On traite les erreurs si on a pas réussi à se connecter
		catch (ClassNotFoundException e)
		{
			System.out.println("il manque le driver oracle");
			System.exit(1);
		}
		catch (SQLException e)
		{
			System.out.println("impossible de se connecter");
			return null;
		}
		return co;
	}
	// Permet de fermer une connexion
	public static void closeConnection(Connection co)
	{
		try
		{
			co.close();
		}
		catch (SQLException e)
		{
			System.out.println("Impossible de fermer la connexion");
		}
	}
	// ************************************************************
	// ***** RESULTAT * ********************************************
	// ************************************************************
	// Permet d'exécuter une requête en createStatement
	public static ResultSet exec1Requete(String requete, Connection co, int type)
	{
		ResultSet res = null;
		try
		{
			Statement st;
			if (type == 0)
			{
				st = co.createStatement();
			}
			else
			{
				st = co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				                    ResultSet.CONCUR_READ_ONLY);
			};
			res = st.executeQuery(requete);
		}
		catch (SQLException e)
		{
			System.out.println("Problème lors de l'exécution de la requete : " + requete);
		};
		return res;
	}
	// Permet d'afficher le résultat complet d'un résultSet
	public static void afficherTout(ResultSet res) throws SQLException
	{
		ResultSetMetaData rsmd = res.getMetaData();
		int nbColonne = rsmd.getColumnCount();
		while (res.next())
		{
			for (int i = 1; i < nbColonne + 1; i++)
			{
				System.out.print(res.getString(i) + "\t");
			}
			System.out.println();
		}
	}
	// ************************************************************
	// ***** PRESENTATION *****************************************
	// ************************************************************
	// Faire tout droit
	public static String completerString(String s, int tailleMax)
	{
		while (s.length() < tailleMax+1)
		{
			s += " ";
		}
		return s;
	}
	// Faire tout droit trait
	public static String completerStringTrait(String s, int tailleMax)
	{
		while (s.length() < tailleMax)
		{
			s += "-";
		}
		return s;
	}
	// Permet d'afficher une tableau complete avec NAME - NULL? - TYPE
	public static void afficherInfosTable(ResultSet res) throws SQLException
	{
		ResultSetMetaData rsmd = res.getMetaData();
		int nbColonne = rsmd.getColumnCount();
		String nul = "";
		int tailleMax = 0;
		// Récupere la taileMax
		for (int i = 1; i < nbColonne + 1; i++)
		{
			if (tailleMax < rsmd.getColumnName(i).length())
			{
				tailleMax = rsmd.getColumnName(i).length();
			}
		}
		// Affiche les noms des colonnes
		System.out.println(completerString("Name", tailleMax) + completerString("Null", 9) +
		                    completerString("Type", 12));
		//
		System.out.println(completerStringTrait("", tailleMax) + " " +completerStringTrait("", 9) + " " +
		                    completerStringTrait("", 12));

		for (int i = 1; i < nbColonne + 1; i++)
		{
			nul = "";
			if (rsmd.isNullable(i) != 0)
			{
				nul = "NOT NULL";
			}
			System.out.println(completerString(rsmd.getColumnName(i), tailleMax) + completerString(nul, 9) +
			                    completerString(rsmd.getColumnTypeName(i)+"("+rsmd.getColumnType(i)+")", 12));
		}
		System.out.println();
	}
	// Permet de nettoyer la console
	public static void clear() throws InterruptedException, IOException
	{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
	// Permet d'afficher une requete 
	public static void afficherRequete(String r)
	{
		System.out.println("########################################");
		System.out.println("La requête est : " + r);
		System.out.println("########################################");
	}
	// Permet d'afficher le numéro de la question
	public static void afficherQuestion(int x, int y)
	{
		System.out.println("*****************************************");
		System.out.println("TP" + x + " -- " + "Question " + y);
		System.out.println("*****************************************");
	}
}
