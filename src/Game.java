import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class Game extends JFrame implements Runnable{
	Thread t;
	JButton btnArcher;
	JLabel lblBoard;
	int x=720,y=315,signy=1,signx=1,level;
	public Game(int level)
	{
		super("Archer Level-"+level);
		setLayout(null);
		this.level=level;
		setContentPane(new JLabel(new ImageIcon("game2.jpg")));
		setBounds(100,100,500,500);
		addWindowListener(new WindowAdapter() {
			public void windowClosng(WindowEvent we)
			{
				t.stop();
				dispose();
			}
		});
		
		btnArcher=new JButton(new ImageIcon("archer.gif"));
		btnArcher.setBounds(20, 315, 200, 200);
		btnArcher.setContentAreaFilled(false);
		btnArcher.setBorderPainted(false);
		btnArcher.setFocusPainted(false);
		add(btnArcher);
		
		lblBoard=new JLabel(new ImageIcon("board.png"));
		lblBoard.setBounds(x, y, 200, 200);
		lblBoard.setBackground(Color.BLACK);
		add(lblBoard);
		
		setVisible(true);
		t=new Thread(this);
		t.start();
	}

public void run(){
	try {
		while(true)
		{
			Thread.sleep((8/level));
			lblBoard.setLocation(x,y);
			y+=signy;
			if(y==650 | y==0)
			{
				signy=-signy;
			}
		}
	}
	catch(Exception e) {}
	}
}