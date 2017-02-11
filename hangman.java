package project1;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Project1 {

      public static String repeat(String s, int times) {
    if (times <= 0) return "";
    else return s + repeat(s, times-1);
}        
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Hangman\n\n"+"How to play:\n"+"Guess letters and try to solve the word!\n\n"+"Notice: please do not enter more than one letter at a time.\n\n"+"When you are ready, press OK to start!"); 
        String difficulty = JOptionPane.showInputDialog("What difficulty would you like? (normal, hard, extreme)");
        if(difficulty.equals("normal")){
        String again;
        do{
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(900,650);
        JPanel panel = new StructureJPanel();
        frame.add(panel);
        frame.validate();
        frame.repaint();
        panel.setVisible(true);
        
        JFrame headframe = new JFrame();
        headframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        headframe.setVisible(false);
        headframe.setSize(900,650);
        JPanel headpanel = new HeadJPanel();
        headframe.add(headpanel);
        headpanel.setVisible(false);   

        
        JFrame faceframe = new JFrame();
        faceframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        faceframe.setVisible(false);
        faceframe.setSize(900,650);
        JPanel facepanel = new FaceJPanel();
        faceframe.add(facepanel);
        facepanel.setVisible(false);
        
        
        JFrame bodyframe = new JFrame();
        JPanel bodypanel = new BodyJPanel();
        bodyframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bodyframe.setVisible(false);
        bodyframe.setSize(900,650);
        bodyframe.add(bodypanel);
        bodypanel.setVisible(false);
        
        
        JFrame leftlegframe = new JFrame();
        leftlegframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leftlegframe.setVisible(false);
        leftlegframe.setSize(900,650);
        JPanel leftlegpanel = new LeftLJPanel();
        leftlegframe.add(leftlegpanel);
        leftlegpanel.setVisible(false);

        
        JFrame rightlegframe = new JFrame();
        rightlegframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rightlegframe.setVisible(false);
        rightlegframe.setSize(900,650);
        JPanel rightlegpanel = new RightLJPanel();
        rightlegframe.add(rightlegpanel);
        rightlegpanel.setVisible(false);
        
        
        JFrame leftarmframe = new JFrame();
        leftarmframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leftarmframe.setVisible(false);
        leftarmframe.setSize(900,650);
        JPanel leftarmpanel = new LeftAJPanel();
        leftarmframe.add(leftarmpanel);
        leftarmpanel.setVisible(false);
        
        
        JFrame rightarmframe = new JFrame();
        rightarmframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rightarmframe.setVisible(false);
        rightarmframe.setSize(900,650);
        JPanel rightarmpanel = new RightAJPanel();
        rightarmframe.add(rightarmpanel);
        rightarmpanel.setVisible(false);
        
        
       int lives = 7;
       String input; 
       String[] listofguesses = {"glasses","computer","banana","keyboard","education","lizard","wonder","normal","lake","snack","direction","lovable","money","event","animal","paragraph","week","wake","farm","sweat"};
               
       //System.out.println(listofguesses.length);   
       int num =  (int)(Math.random()*5);
       String word = listofguesses[num];
       
       
       JOptionPane.showMessageDialog(null, "The word has " + word.length() + " letters"); 
       String board = repeat("-" , word.length());
       StringBuffer ayy = new StringBuffer(board);
       ArrayList<String> listofguessestheyhavetried = new ArrayList<String>();
       int total = 0;
       do{
          //System.out.println(word);
            int correct = 0;
            
          
       
       String guess = JOptionPane.showInputDialog("Guess a letter!");
       
       
       
       for(int i =0 ; i<listofguessestheyhavetried.size(); i++){
           if(guess.equals(listofguessestheyhavetried.get(i))){
             
             listofguessestheyhavetried.remove(i);
             
             JOptionPane.showMessageDialog(null, "You already guessed that; stop cheating!");

             total--;
             lives++;
           } 
       }
         if(guess.isEmpty()||guess.length()>1){
         JOptionPane.showMessageDialog(null, "Please enter a letter.");

         correct--;
         total--;
         lives++;
         }
       listofguessestheyhavetried.add(guess);
           
       for (int i=0; i<word.length(); i++)
       { 
           if((guess.substring(0)).equals(word.substring(i, i+1))){
           correct++;
           total++;
           ayy = ayy.replace(i, i+1, guess);      
           }
       }
       
       if(correct > 0){
           JOptionPane.showMessageDialog(null, "There are " + " " + correct + " " + guess +"'s");
       }
       
       else{
         JOptionPane.showMessageDialog(null, "There are no" + " " + guess + "'s"); 
         lives--;
       }
       
       if(lives==6){
           headpanel.setVisible(true);
           headframe.setVisible(true);
           frame.setVisible(false);
       }
       
       if(lives==5){
           bodypanel.setVisible(true);
           bodyframe.setVisible(true);
           headframe.setVisible(false);
       }
       
       if(lives==4){
           leftarmpanel.setVisible(true);
           leftarmframe.setVisible(true);
           bodyframe.setVisible(false);
       }
       
       if(lives==3){
           rightarmpanel.setVisible(true);
           rightarmframe.setVisible(true);
           leftarmframe.setVisible(false);
       }
       
       if(lives==2){
           leftlegpanel.setVisible(true);
           leftlegframe.setVisible(true);
           rightarmframe.setVisible(false);
       }
       
       if(lives==1){
           rightlegpanel.setVisible(true);
           rightlegframe.setVisible(true);
           leftarmframe.setVisible(false);
       }
       
       if(lives==0){
           facepanel.setVisible(true);
           faceframe.setVisible(true);
           rightlegframe.setVisible(false);
       }
       
        JOptionPane.showMessageDialog(null,ayy);
        JOptionPane.showMessageDialog(null, "you have guessed these letters " + (listofguessestheyhavetried.toString() ) + " so don't guess them again!!");
       }while(lives > 0 && total < word.length());
       
       if(lives > 0){
           JOptionPane.showMessageDialog(null,"Good Job! You got the word!");
       }
       
       else{
       JOptionPane.showMessageDialog(null,"Awww, you didnt get the word :( \n"+"The word was: "+word);
       }
       
       again = JOptionPane.showInputDialog("Do you want to play again?");
        }while(again.equals("yes"));
        System.exit(0);
        
        }
        
        if(difficulty.equals("hard")){
            String again;
        do{
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(900,650);
        JPanel panel = new StructureJPanel();
        frame.add(panel);
        frame.validate();
        frame.repaint();
        panel.setVisible(true);
        
        JFrame headframe = new JFrame();
        headframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        headframe.setVisible(false);
        headframe.setSize(900,650);
        JPanel headpanel = new HeadJPanel();
        headframe.add(headpanel);
        headpanel.setVisible(false);   

        
        JFrame faceframe = new JFrame();
        faceframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        faceframe.setVisible(false);
        faceframe.setSize(900,650);
        JPanel facepanel = new FaceJPanel();
        faceframe.add(facepanel);
        facepanel.setVisible(false);
        
        
        JFrame bodyframe = new JFrame();
        JPanel bodypanel = new BodyJPanel();
        bodyframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bodyframe.setVisible(false);
        bodyframe.setSize(900,650);
        bodyframe.add(bodypanel);
        bodypanel.setVisible(false);
        
        
        JFrame leftlegframe = new JFrame();
        leftlegframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leftlegframe.setVisible(false);
        leftlegframe.setSize(900,650);
        JPanel leftlegpanel = new LeftLJPanel();
        leftlegframe.add(leftlegpanel);
        leftlegpanel.setVisible(false);

        
        JFrame rightlegframe = new JFrame();
        rightlegframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rightlegframe.setVisible(false);
        rightlegframe.setSize(900,650);
        JPanel rightlegpanel = new RightLJPanel();
        rightlegframe.add(rightlegpanel);
        rightlegpanel.setVisible(false);
        
        
        JFrame leftarmframe = new JFrame();
        leftarmframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leftarmframe.setVisible(false);
        leftarmframe.setSize(900,650);
        JPanel leftarmpanel = new LeftAJPanel();
        leftarmframe.add(leftarmpanel);
        leftarmpanel.setVisible(false);
        
        
        JFrame rightarmframe = new JFrame();
        rightarmframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rightarmframe.setVisible(false);
        rightarmframe.setSize(900,650);
        JPanel rightarmpanel = new RightAJPanel();
        rightarmframe.add(rightarmpanel);
        rightarmpanel.setVisible(false);
        
        
       int lives = 7;
       String input; 

       String[] listofguesses = {"allowance","cologne","compensate","chronological","bewitched","discrimination","domestic","discontinue","unsatisfied","misunderstood","perilous","pilgrim","penmanship","tambourine","caribbean","consigned","predominately","chimpanzee","silverware","establish"};
       
       //System.out.println(listofguesses.length);   
       int num =  (int)(Math.random()*5);
       String word = listofguesses[num];
       
       
       JOptionPane.showMessageDialog(null, "The word has " + word.length() + " letters"); 
       String board = repeat("-" , word.length());
       StringBuffer ayy = new StringBuffer(board);
       ArrayList<String> listofguessestheyhavetried = new ArrayList<String>();
       int total = 0;
       do{
          //System.out.println(word);
            int correct = 0;
            
          
       
       String guess = JOptionPane.showInputDialog("Guess a letter!");
       
       
       
       for(int i =0 ; i<listofguessestheyhavetried.size(); i++){
           if(guess.equals(listofguessestheyhavetried.get(i))){
             
             listofguessestheyhavetried.remove(i);
             
             JOptionPane.showMessageDialog(null, "You already guessed that; stop cheating!");

             total--;
             lives++;
           } 
       }
         if(guess.isEmpty()||guess.length()>1){
         JOptionPane.showMessageDialog(null, "Please enter a letter.");

         correct--;
         total--;
         lives++;
         }
       listofguessestheyhavetried.add(guess);
           
       for (int i=0; i<word.length(); i++)
       { 
           if((guess.substring(0)).equals(word.substring(i, i+1))){
           correct++;
           total++;
           ayy = ayy.replace(i, i+1, guess);      
           }
       }
       
       if(correct > 0){
           JOptionPane.showMessageDialog(null, "There are " + " " + correct + " " + guess +"'s");
       }
       
       else{
         JOptionPane.showMessageDialog(null, "There are no" + " " + guess + "'s"); 
         lives--;
       }
       
       if(lives==6){
           headpanel.setVisible(true);
           headframe.setVisible(true);
           frame.setVisible(false);
       }
       
       if(lives==5){
           bodypanel.setVisible(true);
           bodyframe.setVisible(true);
           headframe.setVisible(false);
       }
       
       if(lives==4){
           leftarmpanel.setVisible(true);
           leftarmframe.setVisible(true);
           bodyframe.setVisible(false);
       }
       
       if(lives==3){
           rightarmpanel.setVisible(true);
           rightarmframe.setVisible(true);
           leftarmframe.setVisible(false);
       }
       
       if(lives==2){
           leftlegpanel.setVisible(true);
           leftlegframe.setVisible(true);
           rightarmframe.setVisible(false);
       }
       
       if(lives==1){
           rightlegpanel.setVisible(true);
           rightlegframe.setVisible(true);
           leftarmframe.setVisible(false);
       }
       
       if(lives==0){
           facepanel.setVisible(true);
           faceframe.setVisible(true);
           rightlegframe.setVisible(false);
       }
       
        JOptionPane.showMessageDialog(null,ayy);
        JOptionPane.showMessageDialog(null, "you have guessed these letters " + (listofguessestheyhavetried.toString() ) + " so don't guess them again!!");
       }while(lives > 0 && total < word.length());
       
       if(lives > 0){
           JOptionPane.showMessageDialog(null,"Good Job! You got the word!");
       }
       
       else{
       JOptionPane.showMessageDialog(null,"Awww, you didnt get the word :( \n"+"The word was: "+word);
       }
       
       again = JOptionPane.showInputDialog("Do you want to play again?");
        }while(again.equals("yes"));
        System.exit(0);
        }
        
        if(difficulty.equals("extreme")){
            String again;
        do{
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(900,650);
        JPanel panel = new StructureJPanel();
        frame.add(panel);
        frame.validate();
        frame.repaint();
        panel.setVisible(true);
        
        JFrame headframe = new JFrame();
        headframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        headframe.setVisible(false);
        headframe.setSize(900,650);
        JPanel headpanel = new HeadJPanel();
        headframe.add(headpanel);
        headpanel.setVisible(false);   

        
        JFrame faceframe = new JFrame();
        faceframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        faceframe.setVisible(false);
        faceframe.setSize(900,650);
        JPanel facepanel = new FaceJPanel();
        faceframe.add(facepanel);
        facepanel.setVisible(false);
        
        
        JFrame bodyframe = new JFrame();
        JPanel bodypanel = new BodyJPanel();
        bodyframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bodyframe.setVisible(false);
        bodyframe.setSize(900,650);
        bodyframe.add(bodypanel);
        bodypanel.setVisible(false);
        
        
        JFrame leftlegframe = new JFrame();
        leftlegframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leftlegframe.setVisible(false);
        leftlegframe.setSize(900,650);
        JPanel leftlegpanel = new LeftLJPanel();
        leftlegframe.add(leftlegpanel);
        leftlegpanel.setVisible(false);

        
        JFrame rightlegframe = new JFrame();
        rightlegframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rightlegframe.setVisible(false);
        rightlegframe.setSize(900,650);
        JPanel rightlegpanel = new RightLJPanel();
        rightlegframe.add(rightlegpanel);
        rightlegpanel.setVisible(false);
        
        
        JFrame leftarmframe = new JFrame();
        leftarmframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leftarmframe.setVisible(false);
        leftarmframe.setSize(900,650);
        JPanel leftarmpanel = new LeftAJPanel();
        leftarmframe.add(leftarmpanel);
        leftarmpanel.setVisible(false);
        
        
        JFrame rightarmframe = new JFrame();
        rightarmframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rightarmframe.setVisible(false);
        rightarmframe.setSize(900,650);
        JPanel rightarmpanel = new RightAJPanel();
        rightarmframe.add(rightarmpanel);
        rightarmpanel.setVisible(false);
        
        
       int lives = 7;
       String input; 

       String[] listofguesses = {"acerbic","cajol","enervate","ignominious","morass","ubiquitous","umbrague","vituperate","vicissitudes","variegated","sycophants","surreptitious","sanctimonious","sacrosanct","recalcitrant","quagmire","punctilious","pulchritude","querulous","rectitude"};
       
       //System.out.println(listofguesses.length);   
       int num =  (int)(Math.random()*20);
       String word = listofguesses[num];
       
       
       JOptionPane.showMessageDialog(null, "The word has " + word.length() + " letters"); 
       String board = repeat("-" , word.length());
       StringBuffer ayy = new StringBuffer(board);
       ArrayList<String> listofguessestheyhavetried = new ArrayList<String>();
       int total = 0;
       do{
          //System.out.println(word);
            int correct = 0;
            
          
       
       String guess = JOptionPane.showInputDialog("Guess a letter!");
       
       
       
       for(int i = 0 ; i<listofguessestheyhavetried.size(); i++){
           if(guess.equals(listofguessestheyhavetried.get(i))){
             
             listofguessestheyhavetried.remove(i);
             
             JOptionPane.showMessageDialog(null, "You already guessed that; stop cheating!");

             total--;
             lives++;
           } 

       }
       
         if(guess.isEmpty()||guess.length()>1){
         JOptionPane.showMessageDialog(null, "Please enter a letter.");

         correct--;
         total--;
         lives++;
         }
                  
       listofguessestheyhavetried.add(guess);
           
       for (int i=0; i<word.length(); i++)
       { 
           if((guess.substring(0)).equals(word.substring(i, i+1))){
           correct++;
           total++;
           ayy = ayy.replace(i, i+1, guess);      
           }
       }
       
       if(correct > 0){
           JOptionPane.showMessageDialog(null, "There are " + " " + correct + " " + guess +"'s");
       }
       
       else{
         JOptionPane.showMessageDialog(null, "There are no" + " " + guess + "'s"); 
         lives--;
       }
       
       if(lives==6){
           headpanel.setVisible(true);
           headframe.setVisible(true);
           frame.setVisible(false);
       }
       
       if(lives==5){
           bodypanel.setVisible(true);
           bodyframe.setVisible(true);
           headframe.setVisible(false);
       }
       
       if(lives==4){
           leftarmpanel.setVisible(true);
           leftarmframe.setVisible(true);
           bodyframe.setVisible(false);
       }
       
       if(lives==3){
           rightarmpanel.setVisible(true);
           rightarmframe.setVisible(true);
           leftarmframe.setVisible(false);
       }
       
       if(lives==2){
           leftlegpanel.setVisible(true);
           leftlegframe.setVisible(true);
           rightarmframe.setVisible(false);
       }
       
       if(lives==1){
           rightlegpanel.setVisible(true);
           rightlegframe.setVisible(true);
           leftarmframe.setVisible(false);
       }
       
       if(lives==0){
           facepanel.setVisible(true);
           faceframe.setVisible(true);
           rightlegframe.setVisible(false);
       }
       
        JOptionPane.showMessageDialog(null,ayy);
        JOptionPane.showMessageDialog(null, "you have guessed these letters " + (listofguessestheyhavetried.toString() ) + " so don't guess them again!!");
       }while(lives > 0 && total < word.length());
       
       if(lives > 0){
           JOptionPane.showMessageDialog(null,"Good Job! You got the word!");
       }
       
       else{
       JOptionPane.showMessageDialog(null,"Awww, you didnt get the word :( \n"+"The word was: "+word);
       }
       
       again = JOptionPane.showInputDialog("Do you want to play again?");
        }while(again.equals("yes"));
        System.exit(0);
        
        
        }
    }
}

class HeadJPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 900, 650);        
        g.setColor(Color.GREEN);
        g.fillRect(0, 520, 900, 100);
        g.setColor(Color.YELLOW);
        g.fillOval(25, 25, 100, 100);   
        g.drawLine(125, 125, 150, 150); //bottom right
        g.drawLine(135, 80, 175, 80); //right
        g.drawLine(68, 135, 68, 170); //bottom
        g.drawLine(125, 35, 160, 15); //top right
        g.drawLine(22, 126, 0, 150); //bottom left
        g.drawLine(18, 80, -5, 80); //left
        g.drawLine(23, 35, 2, 10); //top right
        g.drawLine(70, -5, 70, 20); //top
        g.drawLine(127, 127, 152, 152); //bottom right//////
        g.drawLine(136, 81, 176, 81); //right
        g.drawLine(69, 136, 69, 171); //bottom
        g.drawLine(126, 36, 161, 16); //top right
        g.drawLine(23, 127, 1, 151); //bottom left
        g.drawLine(19, 81, -4, 81); //left
        g.drawLine(24, 36, 3, 11); //top right
        g.drawLine(71, -4, 71, 21); //top
        g.setColor(Color.BLACK);
        g.fillRect(40, 55, 27, 15); //Sun glasses left
        g.fillRect(85, 55, 27, 15); //Sun glasses right
        g.drawArc(0, 80, 200, 20, 250, 20); //Sun mouth
        g.setColor(Color.WHITE);
        g.fillOval(665, 50, 100, 100); //Cloud Right1
        g.fillOval(710, 25, 130, 130); //Cloud Right2
        g.fillOval(770, 50, 100, 100); //Cloud Right3
        g.fillOval(135, 220, 100, 100); //Cloud Left1
        g.fillOval(180, 195, 130, 130); //Cloud Left2
        g.fillOval(240, 220, 100, 100); //Cloud Left3
        g.fillOval(500, 300, 100, 100); //Cloud Middle1
        g.fillOval(545, 275, 130, 130); //Cloud Middle2
        g.fillOval(605, 300, 100, 100); //Cloud Middle3
        g.setColor(Color.BLACK);
        g.drawOval(400, 150, 100, 100); //Head
        g.drawLine(450, 125, 450, 150);
        g.drawLine(450, 125, 450, 75);
        g.drawLine(450, 75, 650, 75);
        g.drawLine(650,75,650,550);
        g.drawLine(800, 550, 500, 550);
    }
}

class BodyJPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 900, 650);        
        g.setColor(Color.GREEN);
        g.fillRect(0, 520, 900, 100);
        g.setColor(Color.YELLOW);
        g.fillOval(25, 25, 100, 100);   
        g.drawLine(125, 125, 150, 150); //bottom right
        g.drawLine(135, 80, 175, 80); //right
        g.drawLine(68, 135, 68, 170); //bottom
        g.drawLine(125, 35, 160, 15); //top right
        g.drawLine(22, 126, 0, 150); //bottom left
        g.drawLine(18, 80, -5, 80); //left
        g.drawLine(23, 35, 2, 10); //top right
        g.drawLine(70, -5, 70, 20); //top
        g.drawLine(127, 127, 152, 152); //bottom right//////
        g.drawLine(136, 81, 176, 81); //right
        g.drawLine(69, 136, 69, 171); //bottom
        g.drawLine(126, 36, 161, 16); //top right
        g.drawLine(23, 127, 1, 151); //bottom left
        g.drawLine(19, 81, -4, 81); //left
        g.drawLine(24, 36, 3, 11); //top right
        g.drawLine(71, -4, 71, 21); //top
        g.setColor(Color.BLACK);
        g.fillRect(40, 55, 27, 15); //Sun glasses left
        g.fillRect(85, 55, 27, 15); //Sun glasses right
        g.drawArc(0, 80, 200, 20, 250, 20); //Sun mouth
        g.setColor(Color.WHITE);
        g.fillOval(665, 50, 100, 100); //Cloud Right1
        g.fillOval(710, 25, 130, 130); //Cloud Right2
        g.fillOval(770, 50, 100, 100); //Cloud Right3
        g.fillOval(135, 220, 100, 100); //Cloud Left1
        g.fillOval(180, 195, 130, 130); //Cloud Left2
        g.fillOval(240, 220, 100, 100); //Cloud Left3
        g.fillOval(500, 300, 100, 100); //Cloud Middle1
        g.fillOval(545, 275, 130, 130); //Cloud Middle2
        g.fillOval(605, 300, 100, 100); //Cloud Middle3
        g.setColor(Color.BLACK);
        g.drawOval(400, 150, 100, 100); //Head
        g.drawLine(450, 250, 450, 400); //Body
        g.drawLine(450, 125, 450,150);
        g.drawLine(450, 125, 450, 75);
        g.drawLine(450, 75, 650, 75);
        g.drawLine(650,75,650,550);
        g.drawLine(800, 550, 500, 550);
    }
}

class LeftLJPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 900, 650);        
        g.setColor(Color.GREEN);
        g.fillRect(0, 520, 900, 100);
        g.setColor(Color.YELLOW);
        g.fillOval(25, 25, 100, 100);   
        g.drawLine(125, 125, 150, 150); //bottom right
        g.drawLine(135, 80, 175, 80); //right
        g.drawLine(68, 135, 68, 170); //bottom
        g.drawLine(125, 35, 160, 15); //top right
        g.drawLine(22, 126, 0, 150); //bottom left
        g.drawLine(18, 80, -5, 80); //left
        g.drawLine(23, 35, 2, 10); //top right
        g.drawLine(70, -5, 70, 20); //top
        g.drawLine(127, 127, 152, 152); //bottom right//////
        g.drawLine(136, 81, 176, 81); //right
        g.drawLine(69, 136, 69, 171); //bottom
        g.drawLine(126, 36, 161, 16); //top right
        g.drawLine(23, 127, 1, 151); //bottom left
        g.drawLine(19, 81, -4, 81); //left
        g.drawLine(24, 36, 3, 11); //top right
        g.drawLine(71, -4, 71, 21); //top
        g.setColor(Color.BLACK);
        g.fillRect(40, 55, 27, 15); //Sun glasses left
        g.fillRect(85, 55, 27, 15); //Sun glasses right
        g.drawArc(0, 80, 200, 20, 250, 20); //Sun mouth
        g.setColor(Color.WHITE);
        g.fillOval(665, 50, 100, 100); //Cloud Right1
        g.fillOval(710, 25, 130, 130); //Cloud Right2
        g.fillOval(770, 50, 100, 100); //Cloud Right3
        g.fillOval(135, 220, 100, 100); //Cloud Left1
        g.fillOval(180, 195, 130, 130); //Cloud Left2
        g.fillOval(240, 220, 100, 100); //Cloud Left3
        g.fillOval(500, 300, 100, 100); //Cloud Middle1
        g.fillOval(545, 275, 130, 130); //Cloud Middle2
        g.fillOval(605, 300, 100, 100); //Cloud Middle3
        g.setColor(Color.BLACK);
        g.drawOval(400, 150, 100, 100); //Head
        g.drawLine(450, 250, 450, 400); //Body
        g.drawLine(450, 400, 350, 500 ); //Left Leg
        g.drawLine(450, 300, 300, 250); //Left Arm
        g.drawLine(450, 300, 600, 250); //Right Arm
        g.drawLine(450, 125, 450,150);
        g.drawLine(450, 125, 450, 75);
        g.drawLine(450, 75, 650, 75);
        g.drawLine(650,75,650,550);
        g.drawLine(800, 550, 500, 550);
    }
}

class RightLJPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 900, 650);        
        g.setColor(Color.GREEN);
        g.fillRect(0, 520, 900, 100);
        g.setColor(Color.YELLOW);
        g.fillOval(25, 25, 100, 100);   
        g.drawLine(125, 125, 150, 150); //bottom right
        g.drawLine(135, 80, 175, 80); //right
        g.drawLine(68, 135, 68, 170); //bottom
        g.drawLine(125, 35, 160, 15); //top right
        g.drawLine(22, 126, 0, 150); //bottom left
        g.drawLine(18, 80, -5, 80); //left
        g.drawLine(23, 35, 2, 10); //top right
        g.drawLine(70, -5, 70, 20); //top
        g.drawLine(127, 127, 152, 152); //bottom right//////
        g.drawLine(136, 81, 176, 81); //right
        g.drawLine(69, 136, 69, 171); //bottom
        g.drawLine(126, 36, 161, 16); //top right
        g.drawLine(23, 127, 1, 151); //bottom left
        g.drawLine(19, 81, -4, 81); //left
        g.drawLine(24, 36, 3, 11); //top right
        g.drawLine(71, -4, 71, 21); //top
        g.setColor(Color.BLACK);
        g.fillRect(40, 55, 27, 15); //Sun glasses left
        g.fillRect(85, 55, 27, 15); //Sun glasses right
        g.drawArc(0, 80, 200, 20, 250, 20); //Sun mouth
        g.setColor(Color.WHITE);
        g.fillOval(665, 50, 100, 100); //Cloud Right1
        g.fillOval(710, 25, 130, 130); //Cloud Right2
        g.fillOval(770, 50, 100, 100); //Cloud Right3
        g.fillOval(135, 220, 100, 100); //Cloud Left1
        g.fillOval(180, 195, 130, 130); //Cloud Left2
        g.fillOval(240, 220, 100, 100); //Cloud Left3
        g.fillOval(500, 300, 100, 100); //Cloud Middle1
        g.fillOval(545, 275, 130, 130); //Cloud Middle2
        g.fillOval(605, 300, 100, 100); //Cloud Middle3
        g.setColor(Color.BLACK);
        g.drawOval(400, 150, 100, 100); //Head
        g.drawLine(450, 250, 450, 400); //Body
        g.drawLine(450, 400, 350, 500 ); //Left Leg
        g.drawLine(450, 400, 550, 500 ); //Right Leg
        g.drawLine(450, 300, 300, 250); //Left Arm
        g.drawLine(450, 300, 600, 250); //Right Arm
        g.drawLine(450, 125, 450,150);
        g.drawLine(450, 125, 450, 75);
        g.drawLine(450, 75, 650, 75);
        g.drawLine(650,75,650,550);
        g.drawLine(800, 550, 500, 550);
    }
}

class LeftAJPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 900, 650);        
        g.setColor(Color.GREEN);
        g.fillRect(0, 520, 900, 100);
        g.setColor(Color.YELLOW);
        g.fillOval(25, 25, 100, 100);   
        g.drawLine(125, 125, 150, 150); //bottom right
        g.drawLine(135, 80, 175, 80); //right
        g.drawLine(68, 135, 68, 170); //bottom
        g.drawLine(125, 35, 160, 15); //top right
        g.drawLine(22, 126, 0, 150); //bottom left
        g.drawLine(18, 80, -5, 80); //left
        g.drawLine(23, 35, 2, 10); //top right
        g.drawLine(70, -5, 70, 20); //top
        g.drawLine(127, 127, 152, 152); //bottom right//////
        g.drawLine(136, 81, 176, 81); //right
        g.drawLine(69, 136, 69, 171); //bottom
        g.drawLine(126, 36, 161, 16); //top right
        g.drawLine(23, 127, 1, 151); //bottom left
        g.drawLine(19, 81, -4, 81); //left
        g.drawLine(24, 36, 3, 11); //top right
        g.drawLine(71, -4, 71, 21); //top
        g.setColor(Color.BLACK);
        g.fillRect(40, 55, 27, 15); //Sun glasses left
        g.fillRect(85, 55, 27, 15); //Sun glasses right
        g.drawArc(0, 80, 200, 20, 250, 20); //Sun mouth
        g.setColor(Color.WHITE);
        g.fillOval(665, 50, 100, 100); //Cloud Right1
        g.fillOval(710, 25, 130, 130); //Cloud Right2
        g.fillOval(770, 50, 100, 100); //Cloud Right3
        g.fillOval(135, 220, 100, 100); //Cloud Left1
        g.fillOval(180, 195, 130, 130); //Cloud Left2
        g.fillOval(240, 220, 100, 100); //Cloud Left3
        g.fillOval(500, 300, 100, 100); //Cloud Middle1
        g.fillOval(545, 275, 130, 130); //Cloud Middle2
        g.fillOval(605, 300, 100, 100); //Cloud Middle3
        g.setColor(Color.BLACK);
        g.drawOval(400, 150, 100, 100); //Head
        g.drawLine(450, 250, 450, 400); //Body
        g.drawLine(450, 300, 300, 250); //Left Arm
        g.drawLine(450, 125, 450,150);
        g.drawLine(450, 125, 450, 75);
        g.drawLine(450, 75, 650, 75);
        g.drawLine(650,75,650,550);
        g.drawLine(800, 550, 500, 550);  
    }
}

class FaceJPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 900, 650);        
        g.setColor(Color.GREEN);
        g.fillRect(0, 520, 900, 100);
        g.setColor(Color.YELLOW);
        g.fillOval(25, 25, 100, 100);   
        g.drawLine(125, 125, 150, 150); //bottom right
        g.drawLine(135, 80, 175, 80); //right
        g.drawLine(68, 135, 68, 170); //bottom
        g.drawLine(125, 35, 160, 15); //top right
        g.drawLine(22, 126, 0, 150); //bottom left
        g.drawLine(18, 80, -5, 80); //left
        g.drawLine(23, 35, 2, 10); //top right
        g.drawLine(70, -5, 70, 20); //top
        g.drawLine(127, 127, 152, 152); //bottom right//////
        g.drawLine(136, 81, 176, 81); //right
        g.drawLine(69, 136, 69, 171); //bottom
        g.drawLine(126, 36, 161, 16); //top right
        g.drawLine(23, 127, 1, 151); //bottom left
        g.drawLine(19, 81, -4, 81); //left
        g.drawLine(24, 36, 3, 11); //top right
        g.drawLine(71, -4, 71, 21); //top