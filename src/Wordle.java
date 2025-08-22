/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author Shakthi Weerawansa
 */
public class Wordle extends JFrame{

    JTextField test = new JTextField();

    JTextField[] a = new JTextField[5];
    JTextField[] b = new JTextField[5];
    JTextField[] c = new JTextField[5];
    JTextField[] d = new JTextField[5];
    JTextField[] e = new JTextField[5];
    JTextField[] f = new JTextField[5];

    JButton giveup=new JButton("I Give Up");

    int wordMaxIndex = 0;
    int track = 0;
    int blank = 0;

    boolean aDone, bDone, cDone, dDone, eDone, fDone, gaveup = false;

    Border redB = BorderFactory.createLineBorder(Color.red);
    Border blackB = UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border");

    String chosenWord = "";

    ArrayList<String> wordList = new ArrayList<>();
    ArrayList<String> dict = new ArrayList<>();

    Font defaultFont = new Font("Verdana", Font.PLAIN, 40);
    Wordle(){
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Wordle");

        setResizable(false);

//        test.setBounds(20, 20, 200, 20);
//        add(test);
//        test.addKeyListener(new KeyAdapter(){
//            public void keyPressed(KeyEvent k){
//                int key = k.getKeyCode();
//                if(key == KeyEvent.VK_ENTER){
//                    chooseWord();
//                    String theWord = test.getText();
//                    if(wordList.contains(theWord)){
//                        System.out.println("Yep");
//                    }
//                    if(dict.contains(theWord)){
//                        System.out.println("Dictionary approved!");
//                    }
//                }
//            }
//        });

        for(int i =0; i < 5; i++){
            a[i] = new JTextField(SwingConstants.CENTER);
            a[i].setBounds(8+ i*74,30, 70, 70);
            add(a[i]);
            a[i].requestFocus();
            a[i].setEditable(false);
            a[i].setBackground(Color.white);
            a[i].setHorizontalAlignment(JTextField.CENTER);
            a[i].setFont(defaultFont);
            a[i].setDocument(new JTextFieldLimit(1));
            a[i].addKeyListener(new KeyAdapter() {

                public void keyTyped(KeyEvent e) {
                    char keyChar = e.getKeyChar();
                    if (Character.isLowerCase(keyChar)) {
                        e.setKeyChar(Character.toUpperCase(keyChar));
                    }
                }
                public void keyReleased(KeyEvent e){
                    // if(a[i].getText() )
                    process(e.getKeyCode());
                    System.out.println(e.getKeyCode());
                }
            });
        }

        for(int i =0; i < 5; i++){
            b[i] = new JTextField(SwingConstants.CENTER);
            b[i].setBounds(8+ i*74,30+74*1, 70, 70);
            add(b[i]);
            b[i].requestFocus();
            b[i].setEditable(false);
            b[i].setBackground(Color.white);
            b[i].setHorizontalAlignment(JTextField.CENTER);
            b[i].setFont(defaultFont);
            b[i].setDocument(new JTextFieldLimit(1));
            b[i].addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char keyChar = e.getKeyChar();
                    if (Character.isLowerCase(keyChar)) {
                        e.setKeyChar(Character.toUpperCase(keyChar));
                    }
                }
                public void keyReleased(KeyEvent e){
                    process(e.getKeyCode());
                    System.out.println(e.getKeyCode());
                }
            });
        }

        for(int i =0; i < 5; i++){
            c[i] = new JTextField(SwingConstants.CENTER);
            c[i].setBounds(8+ i*74,30+74*2, 70, 70);
            add(c[i]);
            c[i].requestFocus();
            c[i].setEditable(false);
            c[i].setBackground(Color.white);
            c[i].setHorizontalAlignment(JTextField.CENTER);
            c[i].setFont(defaultFont);
            c[i].setDocument(new JTextFieldLimit(1));
            c[i].addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char keyChar = e.getKeyChar();
                    if (Character.isLowerCase(keyChar)) {
                        e.setKeyChar(Character.toUpperCase(keyChar));
                    }
                }
                public void keyReleased(KeyEvent e){
                    process(e.getKeyCode());
                    System.out.println(e.getKeyCode());
                }
            });
        }

        for(int i =0; i < 5; i++){
            d[i] = new JTextField(SwingConstants.CENTER);
            d[i].setBounds(8+ i*74,30+74*3, 70, 70);
            add(d[i]);
            d[i].requestFocus();
            d[i].setEditable(false);
            d[i].setBackground(Color.white);
            d[i].setHorizontalAlignment(JTextField.CENTER);
            d[i].setFont(defaultFont);
            d[i].setDocument(new JTextFieldLimit(1));
            d[i].addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char keyChar = e.getKeyChar();
                    if (Character.isLowerCase(keyChar)) {
                        e.setKeyChar(Character.toUpperCase(keyChar));
                    }
                }
                public void keyReleased(KeyEvent e){
                    process(e.getKeyCode());
                    System.out.println(e.getKeyCode());
                }
            });
        }

        for(int i =0; i < 5; i++){
            e[i] = new JTextField(SwingConstants.CENTER);
            e[i].setBounds(8+ i*74,30+74*4, 70, 70);
            add(e[i]);
            e[i].requestFocus();
            e[i].setEditable(false);
            e[i].setBackground(Color.white);
            e[i].setHorizontalAlignment(JTextField.CENTER);
            e[i].setFont(defaultFont);
            e[i].setDocument(new JTextFieldLimit(1));
            e[i].addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char keyChar = e.getKeyChar();
                    if (Character.isLowerCase(keyChar)) {
                        e.setKeyChar(Character.toUpperCase(keyChar));
                    }
                }
                public void keyReleased(KeyEvent e){
                    process(e.getKeyCode());
                    System.out.println(e.getKeyCode());
                }
            });
        }

        for(int i =0; i < 5; i++){
            f[i] = new JTextField(SwingConstants.CENTER);
            f[i].setBounds(8+ i*74,30+74*5, 70, 70);
            add(f[i]);
            f[i].requestFocus();
            f[i].setEditable(false);
            f[i].setBackground(Color.white);
            f[i].setHorizontalAlignment(JTextField.CENTER);
            f[i].setFont(defaultFont);
            f[i].setDocument(new JTextFieldLimit(1));
            f[i].addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char keyChar = e.getKeyChar();
                    if (Character.isLowerCase(keyChar)) {
                        e.setKeyChar(Character.toUpperCase(keyChar));
                    }
                }
                public void keyReleased(KeyEvent e){
                    process(e.getKeyCode());
                    System.out.println(e.getKeyCode());
                }
            });
        }

        giveup.setBounds(140,490,100,50);
        giveup.setFont(new Font("Arial", Font.PLAIN, 15));
        giveup.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                revealword();
            }

        });
        giveup.setHorizontalAlignment(CENTER);
        add(giveup);

        getWords();
        loadDictionary();
        chooseWord();
        a[0].setEditable(true);
        a[0].requestFocus();
        setVisible(true);
    }

    private void revealword(){
        JOptionPane.showMessageDialog(null, "THE WORD WAS "+chosenWord.toUpperCase());
        gaveup=true;
    }

    private void getWords(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/resources/word_list.txt"));


            String line = br.readLine();
            while (line != null) {
                wordList.add(line);
                line = br.readLine();
            }
            br.close();
            wordMaxIndex = wordList.size() - 1;

            // System.out.println(wordList);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Wordle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Wordle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDictionary(){
        test.setText("Loading dictionary...");
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/resources/dictionary.txt"));


            String line = br.readLine();
            while (line != null) {
                if(line.length() == 5)
                    dict.add(line);
                line = br.readLine();
            }
            br.close();

            System.out.println(dict.size());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Wordle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Wordle.class.getName()).log(Level.SEVERE, null, ex);
        }
        test.setText("");
        test.requestFocus();
    }
    private void chooseWord(){
        Random r = new Random();
        int choice = r.nextInt(wordMaxIndex);
        // System.out.println(wordList.get(choice));
        chosenWord = wordList.get(choice);
        System.out.println(chosenWord);
    }

    private void process(int key){

        if(key == KeyEvent.VK_BACK_SPACE){
            if(track != 0 && track != 5 && track != 10 &&track != 15 && track !=20 && track != 25){

                if(track < 5 && aDone == false){
                    track = track - 1;
                    a[track+1].setEditable(false);
                    a[track].setEditable(true);
                    a[track].requestFocus();
                }else if(track < 10 &&  track > 4 && bDone == false){
                    track = track - 1;
                    b[track-4].setEditable(false);
                    b[track-5].setEditable(true);
                    b[track-5].requestFocus();
                }else if(track <15 && track > 9 && cDone == false){
                    track = track - 1;
                    c[track-9].setEditable(false);
                    c[track-10].setEditable(true);
                    c[track-10].requestFocus();
                }else if(track < 20 && track > 14 && dDone == false){
                    track = track - 1;
                    d[track-14].setEditable(false);
                    d[track-15].setEditable(true);
                    d[track-15].requestFocus();
                }else if(track < 25 && track > 19 && eDone == false){
                    track = track - 1;
                    e[track-19].setEditable(false);
                    e[track-20].setEditable(true);
                    e[track-20].requestFocus();
                }else if(track < 30 && track > 24 && fDone == false){
                    track = track - 1;
                    f[track-24].setEditable(false);
                    f[track-25].setEditable(true);
                    f[track-25].requestFocus();
                }
            }
        }else if(key == KeyEvent.VK_ENTER){
            validation();
        }else if (key<91 && key > 64){
            if(track != 4 && track != 9 && track != 14 &&track != 19 && track !=24 && track != 29){

                if(track < 5 && aDone == false){
                    track = track + 1;
                    a[track-1].setEditable(false);
                    a[track].setEditable(true);
                    a[track].requestFocus();
                }else if(track < 10 && track > 4 && bDone == false){
                    track = track + 1;
                    b[track-6].setEditable(false);
                    b[track-5].setEditable(true);
                    b[track-5].requestFocus();
                }else if(track <15 && track > 9 && cDone == false){
                    track = track + 1;
                    c[track-11].setEditable(false);
                    c[track-10].setEditable(true);
                    c[track-10].requestFocus();
                }else if(track < 20 && track > 14&& dDone == false){
                    track = track + 1;
                    d[track-16].setEditable(false);
                    d[track-15].setEditable(true);
                    d[track-15].requestFocus();
                }else if(track < 25 && track > 19 && eDone == false){
                    track = track + 1;
                    e[track-21].setEditable(false);
                    e[track-20].setEditable(true);
                    e[track-20].requestFocus();
                }else if(track < 30 && track > 24 && fDone == false){
                    track = track + 1;
                    f[track-26].setEditable(false);
                    f[track-25].setEditable(true);
                    f[track-25].requestFocus();
                }
            }
        }
    }

    public  void validation(){
        String input = new String();
        if(track == 4){
            a[4].setEditable(false);
            for(int i = 0; i < 5; i++){
                input = input + a[i].getText().toLowerCase();
            }
            System.out.println(input);
            if(dicCheck(input) == true){

                aDone = true;
                b[0].setEditable(true);
                b[0].requestFocus();
                compareWord(input);
                System.out.println("In dictionary");

            }else{
                a[4].setEditable(true);
                a[4].requestFocus();
            }
        }else if(track == 9){
            b[4].setEditable(false);
            for(int i = 0; i < 5; i++){
                input = input + b[i].getText().toLowerCase();
            }
            System.out.println(input);
            if(dicCheck(input) == true){

                bDone = true;
                c[0].setEditable(true);
                c[0].requestFocus();
                compareWord(input);
                System.out.println("In dictionary");

            }else{
                b[4].setEditable(true);
                b[4].requestFocus();
            }
        }else if(track == 14){
            c[4].setEditable(false);
            for(int i = 0; i < 5; i++){
                input = input + c[i].getText().toLowerCase();
            }
            System.out.println(input);
            if(dicCheck(input) == true){

                cDone = true;
                d[0].setEditable(true);
                d[0].requestFocus();
                compareWord(input);
                System.out.println("In dictionary");

            }else{
                c[4].setEditable(true);
                c[4].requestFocus();
            }
        }else if(track == 19){
            d[4].setEditable(false);
            for(int i = 0; i < 5; i++){
                input = input + d[i].getText().toLowerCase();
            }
            System.out.println(input);
            if(dicCheck(input) == true){

                dDone = true;
                e[0].setEditable(true);
                e[0].requestFocus();
                compareWord(input);
                System.out.println("In dictionary");

            }else{
                d[4].setEditable(true);
                d[4].requestFocus();
            }
        }else if(track == 24){
            e[4].setEditable(false);
            for(int i = 0; i < 5; i++){
                input = input + e[i].getText().toLowerCase();
            }
            System.out.println(input);
            if(dicCheck(input) == true){

                eDone = true;
                f[0].setEditable(true);
                f[0].requestFocus();
                compareWord(input);
                System.out.println("In dictionary");

            }else{
                e[4].setEditable(true);
                e[4].requestFocus();
            }
        }else if(track == 29){
            f[4].setEditable(false);
            for(int i = 0; i < 5; i++){
                input = input + f[i].getText().toLowerCase();
            }
            System.out.println(input);
            if(dicCheck(input) == true){

                fDone = true;
                compareWord(input);
                System.out.println("In dictionary");

            }else{
                f[4].setEditable(true);
                f[4].requestFocus();
            }
        }
    }



    public void compareWord(String input){
        String chara = "";
        if(track == 4){
            int fin = 0;
            for(int i = 0; i < 5; i ++){
                chara = Character.toString(input.charAt(i));
                if(chosenWord.contains(chara)){
                    a[i].setBackground(Color.yellow);
                }else{
                    a[i].setBackground(Color.gray);
                }
                if(input.charAt(i) == chosenWord.charAt(i)){
                    a[i].setBackground(Color.GREEN);
                    fin++;
                }
            }
            if(fin == 5 && gaveup == false){
                JOptionPane.showMessageDialog(null, "YOU LUCKY THING!");
            }else if(fin == 5 && gaveup == true){
                JOptionPane.showMessageDialog(null, "YOU CHEATED! 😒");
            }
        }else if(track == 9){
            int bla = 0;
            for(int i = 0; i < 5; i ++){
                chara = Character.toString(input.charAt(i));
                if(chosenWord.contains(chara)){
                    b[i].setBackground(Color.yellow);
                }else{
                    b[i].setBackground(Color.gray);
                }
                if(input.charAt(i) == chosenWord.charAt(i)){
                    b[i].setBackground(Color.GREEN);
                    bla++;
                }
            }
            if(bla == 5 && gaveup == false){
                JOptionPane.showMessageDialog(null, "AMAZING!");

            }
            else if(bla == 5 && gaveup == true){
                JOptionPane.showMessageDialog(null, "YOU CHEATING STUPID LIL ASS");
            }
        }else if(track == 14){
            int fin = 0;
            for(int i = 0; i < 5; i ++){
                chara = Character.toString(input.charAt(i));
                if(chosenWord.contains(chara)){
                    c[i].setBackground(Color.yellow);
                }else{
                    c[i].setBackground(Color.gray);
                }
                if(input.charAt(i) == chosenWord.charAt(i)){
                    c[i].setBackground(Color.GREEN);
                    fin++;
                }
            }

            if(fin == 5 && gaveup == false){
                JOptionPane.showMessageDialog(null, "SPLENDID!");
            }else if(fin == 5 && gaveup == true){
                JOptionPane.showMessageDialog(null, "YOU CHEATING STUPID LIL ASS");
            }
        }else if(track == 19){
            int fin = 0;
            for(int i = 0; i < 5; i ++){
                chara = Character.toString(input.charAt(i));
                if(chosenWord.contains(chara)){
                    d[i].setBackground(Color.yellow);
                }else{
                    d[i].setBackground(Color.gray);
                }
                if(input.charAt(i) == chosenWord.charAt(i)){
                    d[i].setBackground(Color.GREEN);
                    fin++;
                }
            }
            if(fin == 5 && gaveup == false){
                JOptionPane.showMessageDialog(null, "GREAT!");
            }else if(fin == 5 && gaveup == true){
                JOptionPane.showMessageDialog(null, "YOU CHEATING STUPID LIL ASS");
            }
        }else if(track == 24){
            int fin = 0;
            for(int i = 0; i < 5; i ++){
                chara = Character.toString(input.charAt(i));
                if(chosenWord.contains(chara)){
                    e[i].setBackground(Color.yellow);
                }else{
                    e[i].setBackground(Color.gray);
                }
                if(input.charAt(i) == chosenWord.charAt(i)){
                    e[i].setBackground(Color.GREEN);
                    fin++;
                }
            }
            if(fin == 5 && gaveup == false){
                JOptionPane.showMessageDialog(null, "YOU GOT IT!");
            }else if(fin == 5 && gaveup == true){
                JOptionPane.showMessageDialog(null, "YOU CHEATING STUPID LIL ASS");
            }
        }else if(track == 29){
            int fin = 0;
            for(int i = 0; i < 5; i ++){
                chara = Character.toString(input.charAt(i));
                if(chosenWord.contains(chara)){
                    f[i].setBackground(Color.yellow);
                }else{
                    f[i].setBackground(Color.gray);
                }
                if(input.charAt(i) == chosenWord.charAt(i)){
                    f[i].setBackground(Color.GREEN);
                    fin++;
                }
            }
            if(fin ==5 && gaveup == false){
                JOptionPane.showMessageDialog(null, "PHEW THAT WAS CLOSE");
            }else if(fin == 5 && gaveup == true){
                JOptionPane.showMessageDialog(null, "YOU CHEATING STUPID LIL ASS");
            }else{
                JOptionPane.showMessageDialog(null, "THE WORD WAS "+chosenWord.toUpperCase());
            }
        }
        track = track + 1;
    }



    private boolean dicCheck(String input){
        if(dict.contains(input)){
            return true;
        }else
            return false;

    }
    public static void main(String[] args) {
        Wordle w = new Wordle();
    }
}
