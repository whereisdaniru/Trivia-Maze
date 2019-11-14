import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;

enum TypeOfQuestion{
	TrueFalse, MultipleChoice, ShortAnswer;
}
public class GameManager {
	public static Connection connectionDB() throws Exception {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:Question.db");
			System.out.println("Connect database successfully");
			return conn;
	   }catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
	   }
		return null;
	}
	public static void insertQuestion(String question, String correctAns, String wrAns1, String wrAns2, String wrAns3, int type, int status) {
		Connection c = null;
		Statement stmt = null;
		try {
			c = connectionDB();
			stmt = c.createStatement();
			String sql = "INSERT INTO Question(Question,CorrectAnswer,WrongAnswer1,WrongAnswer2,WrongAnswer3,TypeOfQuestion,Status)"+
							"VALUES ('"+question+"','"+correctAns+"','"+wrAns1+"','"+wrAns2+"','"+wrAns3+"',"+type+","+status+")";
			stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");
			stmt.close();
		    c.close();
	   }catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
	   }
	}
	public static void selectData() {
		Connection c = null;
		Statement stmt = null;
		try {
			c = connectionDB();
			stmt = c.createStatement();
			String sql = "SELECT * FROM Question";
			ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("QuestionID");
		         String question = rs.getString("Question");
		         String correctAns = rs.getString("CorrectAnswer");
		         String wrongAns1 = rs.getString("WrongAnswer1");
		         String wrongAns2 = rs.getString("WrongAnswer2");
		         String wrongAns3 = rs.getString("WrongAnswer3");
		         int type = rs.getInt("TypeOfQuestion");
		         int status = rs.getInt("Status");

		         //Display values
		         System.out.print("QuestionID: " + id);
		         System.out.print(", Question: " + question);
		         System.out.print(", Correct Answer: " + correctAns);
		         System.out.print(", Wrong Answer 1: " + wrongAns1);
		         System.out.print(", Wrong Answer 2: " + wrongAns2);
		         System.out.print(", Wrong Answer 3: " + wrongAns3);
		         System.out.print(", Type Of Question: " + type);
		         System.out.println(", Status: " + status);
		      }
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//insertQuestion("Where can you find London bridge today", "USA","England","France","Gemany",TypeOfQuestion.MultipleChoice.ordinal(),0);
		//selectData();
		
		//Creating the Frame
        JFrame frame = new JFrame("Trivial Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 520);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Admin");
        JMenu m3 = new JMenu("About");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        JMenuItem m11 = new JMenuItem("New Game");
        JMenuItem m12 = new JMenuItem("Save as");
        JMenuItem m13 = new JMenuItem("Load Game");
        JMenuItem m14 = new JMenuItem("Exit");
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        m1.add(m14);

        JMenuItem m21 = new JMenuItem("Log In");
        JMenuItem m22 = new JMenuItem("Add Question");
        m2.add(m21);
        m2.add(m22); 
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        panel.setMaximumSize(new Dimension(400, 400));
        JButton btn;
        for (int i=1; i<=4; i++) {
            for (int j=1; j<=4; j++) {
                btn = new JButton();
                btn.setPreferredSize(new Dimension(100, 100));
                panel.add(btn);
            }
        }

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setVisible(true);
	}

}
