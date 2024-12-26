import javax.swing.JButton;
import javax.swing.JFrame;


public class MaFenetre extends JFrame {
	public JButton btn;

	public MaFenetre() {
		// TODO Auto-generated constructor stub
		setTitle("Fenêtre");
		setBounds(10,40,300,200);
		btn=new JButton("btn1");
		getContentPane().add(btn);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame fn=new MaFenetre();
		fn.setVisible(true);

	}

}
