import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyWindow extends JFrame{
	private static final long serialVersionUID = -4939544011287453046L;
	public JButton jb;
	public MyWindow() {
		super("My first swing application");
		//setTitle("My First swing application");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		jb=new JButton("Appuyez");
		
		Container contenu=getContentPane();
		contenu.add(jb);
	}
	public static void main(String[] args) {
		MyWindow mW=new MyWindow();
		mW.setVisible(true);
	}

}
