import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;
import java.io.*;
import java.util.Properties;
public class MainMenuOfGame extends JFrame {
	JButton btnStart,btnLevel,btnHighScore,btnHelp,btnQuit,btnLevel1,btnLevel2,btnLevel3,btnLevel4,btnBackLevel,btnBackHigh,btnBackHelp,btnBackScore,btnScore1,btnScore2,btnScore3,btnScore4;
	JLabel lblMainMenu,lblHelp,lblLevel,lblHighScore,lblRank1,lblRank2,lblRank3,lblRank4,lblScore1,lblScore2,lblScore3,lblScore4;
	int level=1,fwidth=500,fheight=700;
	static Properties p1;
	static FileInputStream fis;
	Toolkit t1;
	Font btnFont,lblFont,txtFont;
	Dimension desktop,frame;
	MainMenuOfGame()
	{
		setSize(fwidth,fheight);
		desktop=Toolkit.getDefaultToolkit().getScreenSize();
		frame=getSize();
		int x=(desktop.width-frame.width)/2;
		int y=(desktop.height-frame.height)/2;
		setLayout(null);
		setContentPane(new JLabel(new ImageIcon("main2.gif")));
		readScores();
		
		lblFont=new Font("chiller",Font.BOLD,50);
		txtFont=new Font(Font.MONOSPACED,Font.BOLD,25);
		btnFont=new Font("Ravie",Font.BOLD,20);
		btnStart=new JButton("START");
		btnStart.setBounds(150,175,200,100);
		btnStart.setBackground(Color.WHITE);
		btnStart.setFont(btnFont);
		btnStart.setBorderPainted(false);
		btnStart.setFocusPainted(false);
		btnStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				new BowArrow(level);
				dispose();
			}
		});
		add(btnStart);
		
		btnLevel=new JButton("LEVEL");
		btnLevel.setBounds(150,308,200,100);
		btnLevel.setBackground(Color.WHITE);
		btnLevel.setFont(btnFont);
		btnLevel.setBorderPainted(false);
		btnLevel.setFocusPainted(false);
		btnLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				activateMain(false);
				activateLevel(true);
			}
		});
		add(btnLevel);
		
		btnHighScore=new JButton("HIGH SCORE");
		btnHighScore.setBounds(150,441,200,100);
		btnHighScore.setBackground(Color.WHITE);
		btnHighScore.setFont(btnFont);
		btnHighScore.setBorderPainted(false);
		btnHighScore.setFocusPainted(false);
		btnHighScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				activateMain(false);
				activateHighScore(true);
			}
		});
		add(btnHighScore);
		
		btnHelp=new JButton("HELP");
		btnHelp.setBounds(150,574,200,100);
		btnHelp.setBackground(Color.WHITE);
		btnHelp.setFont(btnFont);
		btnHelp.setBorderPainted(false);
		btnHelp.setFocusPainted(false);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				activateMain(false);
				btnHelp.setVisible(true);
				lblHelp.setVisible(true);
				btnBackHelp.setVisible(true);
			}
		});
		add(btnHelp);
		
		btnQuit=new JButton("Quit");
		btnQuit.setBounds(25,500,100,150);
		btnQuit.setForeground(Color.WHITE);
		btnQuit.setFont(new Font("chiller",Font.BOLD,40));
		btnQuit.setBorderPainted(false);
		btnQuit.setFocusPainted(false);
		btnQuit.setContentAreaFilled(false);
		btnQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
			}
		});
		add(btnQuit);
		
		lblMainMenu=new JLabel("Main Menu",SwingConstants.CENTER);
		lblMainMenu.setBounds(150,25,200,100);
		lblMainMenu.setForeground(Color.WHITE);
		lblMainMenu.setFont(lblFont);
		add(lblMainMenu);
		
		lblHelp=new JLabel(new ImageIcon("help.gif"),SwingConstants.CENTER);
		lblHelp.setBounds(25,25,450,550);
		lblHelp.setForeground(Color.WHITE);
		lblHelp.setFont(lblFont);
		lblHelp.setVisible(false);
		add(lblHelp);
		
		lblLevel=new JLabel("Level",SwingConstants.CENTER);
		lblLevel.setBounds(150,25,200,100);
		lblLevel.setForeground(Color.WHITE);
		lblLevel.setFont(lblFont);
		lblLevel.setVisible(false);
		add(lblLevel);
		
		lblHighScore=new JLabel("High Score",SwingConstants.CENTER);
		lblHighScore.setBounds(150,25,200,100);
		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setFont(lblFont);
		lblHighScore.setVisible(false);
		add(lblHighScore);
		
		btnLevel1=new JButton("Level 1");
		btnLevel1.setBounds(150,175,200,100);
		btnLevel1.setBackground(Color.WHITE);
		btnLevel1.setFont(btnFont);
		btnLevel1.setBorderPainted(false);
		btnLevel1.setFocusPainted(false);
		btnLevel1.setVisible(false);
		btnLevel1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				btnLevel2.setBackground(Color.WHITE);
				btnLevel3.setBackground(Color.WHITE);
				btnLevel4.setBackground(Color.WHITE);
				btnLevel1.setBackground(Color.LIGHT_GRAY);
				level=1;
			}
		});
		add(btnLevel1);
		
		btnLevel2=new JButton("Level 2");
		btnLevel2.setBounds(150,308,200,100);
		btnLevel2.setBackground(Color.WHITE);
		btnLevel2.setFont(btnFont);
		btnLevel2.setBorderPainted(false);
		btnLevel2.setFocusPainted(false);
		btnLevel2.setVisible(false);
		btnLevel2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				btnLevel1.setBackground(Color.WHITE);
				btnLevel3.setBackground(Color.WHITE);
				btnLevel4.setBackground(Color.WHITE);
				btnLevel2.setBackground(Color.LIGHT_GRAY);
				level=2;
			}
		});
		add(btnLevel2);
		
		btnLevel3=new JButton("Level 3");
		btnLevel3.setBounds(150,441,200,100);
		btnLevel3.setBackground(Color.WHITE);
		btnLevel3.setFont(btnFont);
		btnLevel3.setBorderPainted(false);
		btnLevel3.setFocusPainted(false);
		btnLevel3.setVisible(false);
		btnLevel3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				btnLevel1.setBackground(Color.WHITE);
				btnLevel2.setBackground(Color.WHITE);
				btnLevel4.setBackground(Color.WHITE);
				btnLevel3.setBackground(Color.LIGHT_GRAY);
				level=3;
			}
		});
		add(btnLevel3);
		
		btnLevel4=new JButton("Level 4");
		btnLevel4.setBounds(150,574,200,100);
		btnLevel4.setBackground(Color.WHITE);
		btnLevel4.setFont(btnFont);
		btnLevel4.setBorderPainted(false);
		btnLevel4.setFocusPainted(false);
		btnLevel4.setVisible(false);
		btnLevel4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				btnLevel1.setBackground(Color.WHITE);
				btnLevel2.setBackground(Color.WHITE);
				btnLevel3.setBackground(Color.WHITE);
				btnLevel4.setBackground(Color.LIGHT_GRAY);
				level=4;
			}
		});
		add(btnLevel4);
		
		btnBackLevel=new JButton("Back");
		btnBackLevel.setBounds(375,500,100,150);
		btnBackLevel.setForeground(Color.WHITE);
		btnBackLevel.setFont(new Font("chiller",Font.BOLD,40));
		btnBackLevel.setContentAreaFilled(false);
		btnBackLevel.setFocusPainted(false);
		btnBackLevel.setBorderPainted(false);
		btnBackLevel.setVisible(false);
		btnBackLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				activateLevel(false);
				activateMain(true);
			}
		});
		add(btnBackLevel);
		
		btnBackHigh=new JButton("Back");
		btnBackHigh.setBounds(375,500,100,150);
		btnBackHigh.setForeground(Color.WHITE);
		btnBackHigh.setFont(new Font("chiller",Font.BOLD,40));
		btnBackHigh.setContentAreaFilled(false);
		btnBackHigh.setFocusPainted(false);
		btnBackHigh.setBorderPainted(false);
		btnBackHigh.setVisible(false);
		btnBackHigh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				activateHighScore(false);
				activateMain(true);
			}
		});
		add(btnBackHigh);
		
		btnBackScore=new JButton("Back");
		btnBackScore.setBounds(375,500,100,150);
		btnBackScore.setForeground(Color.WHITE);
		btnBackScore.setFont(new Font("chiller",Font.BOLD,40));
		btnBackScore.setContentAreaFilled(false);
		btnBackScore.setFocusPainted(false);
		btnBackScore.setBorderPainted(false);
		btnBackScore.setVisible(false);
		btnBackScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				activateScore(false);
				activateHighScore(true);			
			}
		});
		add(btnBackScore);

		btnBackHelp=new JButton("Back");
		btnBackHelp.setBounds(375,500,100,150);
		btnBackHelp.setForeground(Color.WHITE);
		btnBackHelp.setFont(new Font("chiller",Font.BOLD,40));
		btnBackHelp.setContentAreaFilled(false);
		btnBackHelp.setFocusPainted(false);
		btnBackHelp.setBorderPainted(false);
		btnBackHelp.setVisible(false);
		btnBackHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				activateMain(true);
				lblHelp.setVisible(false);
				btnBackHelp.setVisible(false);
			}
		});
		add(btnBackHelp);

		btnScore1=new JButton("Score L1");
		btnScore1.setBounds(150,175,200,100);
		btnScore1.setBackground(Color.WHITE);
		btnScore1.setFont(btnFont);
		btnScore1.setBorderPainted(false);
		btnScore1.setFocusPainted(false);
		btnScore1.setVisible(false);
		btnScore1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				activateHighScore(false);
				rankDisplay(1);
				activateScore(true);
				lblHighScore.setVisible(true);
			}
		});
		add(btnScore1);
		
		btnScore2=new JButton("Score L2");
		btnScore2.setBounds(150,308,200,100);
		btnScore2.setBackground(Color.WHITE);
		btnScore2.setFont(btnFont);
		btnScore2.setBorderPainted(false);
		btnScore2.setFocusPainted(false);
		btnScore2.setVisible(false);
		btnScore2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				activateHighScore(false);
				rankDisplay(2);
				activateScore(true);
				lblHighScore.setVisible(true);
			}
		});
		add(btnScore2);
		
		btnScore3=new JButton("Score L3");
		btnScore3.setBounds(150,441,200,100);
		btnScore3.setBackground(Color.WHITE);
		btnScore3.setFont(btnFont);
		btnScore3.setBorderPainted(false);
		btnScore3.setFocusPainted(false);
		btnScore3.setVisible(false);
		btnScore3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				activateHighScore(false);
				rankDisplay(3);
				activateScore(true);
				lblHighScore.setVisible(true);
			}
		});
		add(btnScore3);
		
		btnScore4=new JButton("Score L4");
		btnScore4.setBounds(150,574,200,100);
		btnScore4.setBackground(Color.WHITE);
		btnScore4.setFont(btnFont);
		btnScore4.setBorderPainted(false);
		btnScore4.setFocusPainted(false);
		btnScore4.setVisible(false);
		btnScore4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				activateHighScore(false);
				rankDisplay(4);
				activateScore(true);
				lblHighScore.setVisible(true);
			}
		});
		add(btnScore4);
		
		lblRank1=new JLabel("Rank-1",SwingConstants.CENTER);
		lblRank1.setBounds(150,175,100,100);
		lblRank1.setFont(txtFont);
		lblRank1.setForeground(Color.RED);
		lblRank1.setVisible(false);
		add(lblRank1);
		
		lblRank2=new JLabel("Rank-2",SwingConstants.CENTER);
		lblRank2.setBounds(150,308,100,100);
		lblRank2.setFont(txtFont);
		lblRank2.setForeground(Color.RED);
		lblRank2.setVisible(false);
		add(lblRank2);
		
		lblRank3=new JLabel("Rank-3",SwingConstants.CENTER);
		lblRank3.setBounds(150,441,100,100);
		lblRank3.setFont(txtFont);
		lblRank3.setForeground(Color.RED);
		lblRank3.setVisible(false);
		add(lblRank3);
		
		lblRank4=new JLabel("Rank-4",SwingConstants.CENTER);
		lblRank4.setBounds(150,574,100,100);
		lblRank4.setFont(txtFont);
		lblRank4.setForeground(Color.RED);
		lblRank4.setVisible(false);
		add(lblRank4);
		
		lblScore1=new JLabel();
		lblScore1.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore1.setBounds(250,175,100,100);
		lblScore1.setFont(new Font("chiller",Font.BOLD,30));
		lblScore1.setForeground(Color.RED);
		lblScore1.setVisible(false);
		add(lblScore1);
		
		lblScore2=new JLabel();
		lblScore2.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore2.setBounds(250,308,100,100);
		lblScore2.setFont(new Font("chiller",Font.BOLD,30));
		lblScore2.setForeground(Color.RED);
		lblScore2.setVisible(false);
		add(lblScore2);
		
		lblScore3=new JLabel();
		lblScore3.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore3.setBounds(250,441,100,100);
		lblScore3.setFont(new Font("chiller",Font.BOLD,30));
		lblScore3.setForeground(Color.RED);
		lblScore3.setVisible(false);
		add(lblScore3);
		
		lblScore4=new JLabel();
		lblScore4.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore4.setBounds(250,574,100,100);
		lblScore4.setFont(new Font("chiller",Font.BOLD,30));
		lblScore4.setForeground(Color.RED);
		lblScore4.setVisible(false);
		add(lblScore4);
		
		setLocation(x,y);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MainMenuOfGame();
	}
	public void activateMain(boolean b)
	{
		btnStart.setVisible(b);
		btnLevel.setVisible(b);
		btnHighScore.setVisible(b);
		btnHelp.setVisible(b);
		lblMainMenu.setVisible(b);
	}
	public void activateLevel(boolean b)
	{
		btnLevel1.setVisible(b);
		btnLevel2.setVisible(b);
		btnLevel3.setVisible(b);
		btnLevel4.setVisible(b);
		btnBackLevel.setVisible(b);
		lblLevel.setVisible(b);
	}
	public void activateHighScore(boolean b)
	{
		btnScore1.setVisible(b);
		btnScore2.setVisible(b);
		btnScore3.setVisible(b);
		btnScore4.setVisible(b);
		btnBackHigh.setVisible(b);
		lblHighScore.setVisible(b);

	}
	public void activateScore(boolean b)
	{
		lblRank1.setVisible(b);
		lblRank2.setVisible(b);
		lblRank3.setVisible(b);
		lblRank4.setVisible(b);
		lblScore1.setVisible(b);
		lblScore2.setVisible(b);
		lblScore3.setVisible(b);
		lblScore4.setVisible(b);
		btnBackScore.setVisible(b);
	}
	 public static void readScores(){
			try{
				p1 =new Properties();
				fis= new FileInputStream("score.txt");  //do not give space after = as we need int
				p1.load(fis);
				fis.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
	    }
	    public void rankDisplay(int n){
	    
			lblScore1.setText(p1.getProperty("rank1-"+n));  // to set the rank score
			lblScore2.setText(p1.getProperty("rank2-"+n));
			lblScore3.setText(p1.getProperty("rank3-"+n));
			lblScore4.setText(p1.getProperty("rank4-"+n)); 
		}
}
