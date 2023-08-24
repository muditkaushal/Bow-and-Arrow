import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.*;    
public class FrmStatistics extends JFrame {  
	private static final long serialVersionUID = 1L;
	JLabel scoreCompliment,scoreLabel,scoreBoard,lblNewHighScore;
	FileOutputStream fos;
	JButton resume,nextLevel,quit,mainMenu,nextGame,scorePoint;
	int GameOverFrameWidth=500,GameOverFrameHeight=500;
	Font fontStyle;
	Color fontClr;
	JPanel p1;
	Insets gapBtwMenuQuitNext;
	static int level=0;
	FrmStatistics(BowArrow obj,int level){
		FrmStatistics.level=level;
		setSize(GameOverFrameWidth,GameOverFrameHeight);
		Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
		d.width=(d.width-getSize().width)/2;
		d.height=(d.height-getSize().height)/2;
		setLocation(d.width,d.height);      // to locate at center of screen
		setResizable(false);
		setUndecorated(true);
	    setLayout(null);
		setContentPane(new JLabel((new ImageIcon(new ImageIcon("images/GameOver.png").getImage().getScaledInstance(GameOverFrameWidth,GameOverFrameHeight,Image.SCALE_DEFAULT)))));  // to add image in back ground
	    fontStyle= new Font("Chiller",Font.BOLD,44);  // chiller to give text style
	    scoreCompliment = new JLabel();
	    if(BowArrow.score[BowArrow.level-1]>=750)
	    	scoreCompliment.setText("You Played Excellent!!!");
	    else if(BowArrow.score[BowArrow.level-1]>=500 && BowArrow.score[BowArrow.level-1]<750)
		    scoreCompliment.setText("Well Done!!!");
	    else if(BowArrow.score[BowArrow.level-1]>100 && BowArrow.score[BowArrow.level-1]<=500)
		    scoreCompliment.setText("You can do Better!!!");
	    else 
	    	scoreCompliment.setText("You need a Eye Check-Up");
	    
		scoreCompliment.setBounds(10,10,500,150);
		scoreCompliment.setFont( fontStyle);
		fontClr= new Color(0,0,255);
		scoreCompliment.setForeground(Color.blue);
		add(scoreCompliment,BorderLayout.NORTH);
//--------------------------------------------------------------------------------------------------		
	    scoreLabel= new JLabel("Your Score :");
	    fontStyle= new Font("Chiller",Font.BOLD,44);
	    scoreLabel.setFont(fontStyle);
	    fontClr= new Color(187,182,165);
	    scoreLabel.setForeground(fontClr);
	    scoreLabel.setBounds(20,100,200,100);
	    add(scoreLabel);
//-------------------------------------------------------------------------------------------------------	    
	    scoreBoard = new JLabel(""+BowArrow.score[BowArrow.level-1]);
	    fontStyle= new Font("Chiller",Font.BOLD,44);
	    scoreBoard.setFont(fontStyle);
	    fontClr= new Color(147,82,115);
	    scoreBoard.setForeground(Color.RED); 
	    scoreBoard.setBounds(300,100,200,100);
	    add(scoreBoard);
//---------------------------------------------------------------------------------------------------
	    int rank;	
	    if(BowArrow.score[BowArrow.level-1]> Integer.parseInt(MainMenuOfGame.p1.getProperty("rank1-"+BowArrow.level))){
	    		rank=1;
	    		MainMenuOfGame.p1.setProperty("rank4-"+BowArrow.level,MainMenuOfGame.p1.getProperty("rank3-"+BowArrow.level));
	    		MainMenuOfGame.p1.setProperty("rank3-"+BowArrow.level,MainMenuOfGame.p1.getProperty("rank2-"+BowArrow.level));
	    		MainMenuOfGame.p1.setProperty("rank2-"+BowArrow.level,MainMenuOfGame.p1.getProperty("rank1-"+BowArrow.level));	    			    		
	    }
	    else if(BowArrow.score[BowArrow.level-1]> Integer.parseInt(MainMenuOfGame.p1.getProperty("rank2-"+BowArrow.level))){
	    		rank=2;
	    		MainMenuOfGame.p1.setProperty("rank4-"+BowArrow.level,MainMenuOfGame.p1.getProperty("rank3-"+BowArrow.level));
	    		MainMenuOfGame.p1.setProperty("rank3-"+BowArrow.level,MainMenuOfGame.p1.getProperty("rank2-"+BowArrow.level));	    		
	    }
	    else if(BowArrow.score[BowArrow.level-1]> Integer.parseInt(MainMenuOfGame.p1.getProperty("rank3-"+BowArrow.level))){
    		rank=3;
    		MainMenuOfGame.p1.setProperty("rank4-"+BowArrow.level,MainMenuOfGame.p1.getProperty("rank3-"+BowArrow.level));
	    }
	    else if(BowArrow.score[BowArrow.level-1]> Integer.parseInt(MainMenuOfGame.p1.getProperty("rank4-"+BowArrow.level)))
    		rank=4;
	    else
	    	rank=0;
	    if(rank>0){
	    		lblNewHighScore= new JLabel("<html>New High Score<br> Your rank is: "+rank+"</html>");
	    		fontStyle= new Font("Chiller",Font.BOLD,44);
	    		lblNewHighScore.setFont(fontStyle);
	    	    fontClr= new Color(147,82,115);
	    	    lblNewHighScore.setForeground(Color.white); 
	    	    lblNewHighScore.setBounds(100,200,400,100);
	    	    add(lblNewHighScore);
	    	    MainMenuOfGame.p1.setProperty("rank"+rank+"-"+BowArrow.level,BowArrow.score[BowArrow.level-1]+"" );
	    	    writeScores();
	    	}
	    
	    
//-------------------------------------------------------------------------------------------------------	    
	    mainMenu= new JButton("Main Menu");
	    fontStyle= new Font("Chiller",Font.BOLD,44);
	    mainMenu.setFont(fontStyle);
	    fontClr= new Color(147,82,115);
	    mainMenu.setForeground(Color.RED); 
	    mainMenu.setBounds(0,400,205,100);
	    mainMenu.setFocusPainted(false);
	
	    mainMenu.setContentAreaFilled(false);
		mainMenu.setBorderPainted(false);
		add(mainMenu);
	    mainMenu.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae){	
	    		dispose();
	    		obj.dispose();  // to dipose game Screen
	    		new MainMenuOfGame(); // to go main menu after playing game   
	    	}
	    });
//---------------------------------------------------------------------------------------------------------	    
	    quit= new JButton("Quit");
	    fontStyle= new Font("Chiller",Font.BOLD,44);
	    quit.setFont(fontStyle);
	    fontClr= new Color(147,82,115);
	    quit.setForeground(Color.RED); 
	    quit.setBounds(210,400,165,100);
	    quit.setContentAreaFilled(false);
	    quit.setBorderPainted(false);
	    quit.setFocusPainted(false);
	  	quit.addActionListener(new ActionListener() {
	  	   	public void actionPerformed(ActionEvent ae){
	  	   		System.exit(0);
	  	   	}
	  	});
	    add(quit);
//-------------------------------------------------------------------------------------------------	   
	    nextLevel= new JButton("Next");
	    fontStyle= new Font("Chiller",Font.BOLD,44);
	    nextLevel.setFont(fontStyle);
	    nextLevel.setForeground(Color.white); 
	    nextLevel.setBounds(400,300,110,100); 
	    nextLevel.setContentAreaFilled(false);
	  	nextLevel.setBorderPainted(false);
	  	nextLevel.setFocusPainted(false);
	  	nextLevel.addActionListener(new ActionListener() {
	  	   	public void actionPerformed(ActionEvent ae){
	  	   		FrmStatistics.level++;
	  	   		obj.dispose();   // close BowArrow frame
	  	   		dispose();   // close FrmStatistics frame
	  	   		System.out.println("Level after adding"+FrmStatistics.level);
	  	   		new BowArrow(FrmStatistics.level);  // start new BowArrow game   //max 4
	  	   	}
	  	});
	  	if(level<4)
	  	{
	  		
	  		//if(level!=4)
	  		System.out.println("Local level"+level);
	  		add(nextLevel);
	  			
	  	}
//---------------------------------------------------------------------------------------------------
	  	    resume= new JButton("Resume");
		    fontStyle= new Font("Chiller",Font.BOLD,44);
		    resume.setFont(fontStyle);
		    resume.setForeground(Color.white); 
		    resume.setBounds(0,300,150,100); 
		    resume.setContentAreaFilled(false);
		    resume.setBorderPainted(false);
		    resume.setFocusPainted(false);
		    resume.addActionListener(new ActionListener() {
		  	   	public void actionPerformed(ActionEvent ae){
		  	        	obj.dispose();   // close BowArrow frame
	  	   		        dispose();   // close FrmStatistics frame
	  	   	        	new BowArrow(FrmStatistics.level);  // start new BowArrow game 
		  	   	}  
		  	}); 
		    add(resume);
	  	
	    setVisible(true);
    }   
	public void writeScores(){
			try{
				fos= new FileOutputStream("score.txt");  
				MainMenuOfGame.p1.store(fos,"");
				fos.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
	}
} 
