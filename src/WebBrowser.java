import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.*;

public class WebBrowser extends JApplet {
	private JEditorPane jeb = new JEditorPane();
	
	private JLabel jlbURL = new JLabel("URL");
	
	private JTextField jtfURL = new JTextField();
	
	public void init() {
		JPanel jpURL = new JPanel();
		jpURL.setLayout(new BorderLayout());
		jpURL.add(jlbURL, BorderLayout.WEST);
		jpURL.add(jtfURL, BorderLayout.CENTER);
		
		//add(new JScrollPane(jspViewer), BorderLayout.CENTER);
		add(jpURL, BorderLayout.NORTH);
		
		jeb.setEditable(false);
		
		jeb.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				try {
					jeb.setPage(e.getURL());
				}
				catch (IOException ex){
					System.out.println(ex);
				}
			}
		});
		jtfURL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = new URL(jtfURL.getText().trim());
					
					jeb.setPage(url);
				}
				catch (IOException ex){
					System.out.println(ex);
				}
			}
		});
	}
	public static void main(String[] args) {
		WebBrowser eb = new WebBrowser();
		eb.setVisible(true);
	}
}