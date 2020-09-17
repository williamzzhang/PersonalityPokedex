package main.ui;

import main.model.Personality;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

// Myers-Briggs application that provides Myers-Briggs type and complementary Pokemon
public class MyersBriggsApp extends JPanel {

    public Personality personality;
    private JFrame main;

    // EFFECTS: runs the Myers-Briggs application
    public MyersBriggsApp() {
        init();

        main = new JFrame("Personality Pokedex");
        main.setFont(new Font("Arial", Font.PLAIN, 40));
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setPreferredSize(new Dimension(300, 400));
        main.setLocationRelativeTo(null); //centers in middle of screen
        main.getContentPane().setLayout(new BoxLayout(main.getContentPane(), BoxLayout.Y_AXIS));

        startUpMain();

        makeTakeTestButton();
        makeGetIndicesButton();
        makeCalculatePersonalityButton();
        makePersonalityTypesButton();

        main.pack();
        main.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: initializes a personality with 0 for each index
    private void init() {
        personality = new Personality(0,0,0, 0);
    }

    // MODIFIES: this
    // EFFECTS: Generates the background image for main along with the initialize sound
    public void startUpMain() {
        ImageIcon icon = new ImageIcon("./data/Pokemon-GO-GEN-4-Pokedex.png");
        JLabel accountImage = new JLabel(icon);
        accountImage.setPreferredSize(new Dimension(300, 229));
        main.add(accountImage);
        playSound("./data/whos-that-pokemon_.wav");
    }

    // MODIFIES: this
    // EFFECTS: Constructs the take test button for the application
    public void makeTakeTestButton() {
        JButton taketest = new JButton("Take the Test!");
        new Button(taketest, main);
        taketest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doQ1();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Constructs the personality types button for the application
    public void makeGetIndicesButton() {
        JButton personalityTypes = new JButton("Get your current indices");
        new Button(personalityTypes, main);
        personalityTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doGetIndices();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Constructs the personality types button for the application
    public void makeCalculatePersonalityButton() {
        JButton personalityTypes = new JButton("Calculate your Type!");
        new Button(personalityTypes, main);
        personalityTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doCalculatePersonality();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Constructs the personality types button for the application
    public void makePersonalityTypesButton() {
        JButton personalityTypes = new JButton("View Personality Types");
        new Button(personalityTypes, main);
        personalityTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doViewPersonalityTypes();
            }
        });
    }

    // REQUIRES: a string "Agree" or "Disagree" for the answer
    // MODIFIES: this
    // EFFECTS: Increments the relevant index by 1 depending on if the answer aligns with the question
    private void doQ1() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateQ1Fields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doQ1()
    private void initiateQ1Fields(JFrame frame) {
        JLabel q1 = new JLabel("You enjoy large social events (Type Agree or Disagree)");
        new Label(q1);
        frame.add(q1);

        JTextField answer1 = new JTextField();
        new TextField(answer1);
        frame.add(answer1);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateQ1Enter(frame, answer1);
    }

    // EFFECTS: initiates enter button in doQ1() and increments the corresponding field if appropriate
    private void initiateQ1Enter(JFrame frame, JTextField answer1) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    if (answer1.getText().equals("Agree")) {
                        personality.incrementEi();
                        doQ2();
                    }
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // REQUIRES: a string "Agree" or "Disagree" for the answer
    // MODIFIES: this
    // EFFECTS: Increments the relevant index by 1 depending on if the answer aligns with the question
    private void doQ2() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateQ2Fields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doQ2()
    private void initiateQ2Fields(JFrame frame) {
        JLabel q = new JLabel("Spontaneous vacation is better than planned (Type Agree or Disagree)");
        new Label(q);
        frame.add(q);

        JTextField answer = new JTextField();
        new TextField(answer);
        frame.add(answer);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateQ2Enter(frame, answer);
    }

    // EFFECTS: initiates enter button in doQ2() and increments the corresponding field if appropriate
    private void initiateQ2Enter(JFrame frame, JTextField answer) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (answer.getText().equals("Disagree")) {
                    personality.incrementJp();
                    doQ3();
                }
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // REQUIRES: a string "Agree" or "Disagree" for the answer
    // MODIFIES: this
    // EFFECTS: Increments the relevant index by 1 depending on if the answer aligns with the question
    private void doQ3() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateQ3Fields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doQ3()
    private void initiateQ3Fields(JFrame frame) {
        JLabel q = new JLabel("People rarely upset you (Type Agree or Disagree)");
        new Label(q);
        frame.add(q);

        JTextField answer = new JTextField();
        new TextField(answer);
        frame.add(answer);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateQ3Enter(frame, answer);
    }

    // EFFECTS: initiates enter button in doQ3() and increments the corresponding field if appropriate
    private void initiateQ3Enter(JFrame frame, JTextField answer) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (answer.getText().equals("Disagree")) {
                    personality.incrementTf();
                    doQ4();
                }
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // REQUIRES: a string "Agree" or "Disagree" for the answer
    // MODIFIES: this
    // EFFECTS: Increments the relevant index by 1 depending on if the answer aligns with the question
    private void doQ4() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateQ4Fields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doQ4()
    private void initiateQ4Fields(JFrame frame) {
        JLabel q = new JLabel("You get bored easily by yourself (Type Agree or Disagree)");
        new Label(q);
        frame.add(q);

        JTextField answer = new JTextField();
        new TextField(answer);
        frame.add(answer);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateQ4Enter(frame, answer);
    }

    // EFFECTS: initiates enter button in doQ4() and increments the corresponding field if appropriate
    private void initiateQ4Enter(JFrame frame, JTextField answer) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (answer.getText().equals("Agree")) {
                    personality.incrementEi();
                    doQ5();
                }
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // REQUIRES: a string "Agree" or "Disagree" for the answer
    // MODIFIES: this
    // EFFECTS: Increments the relevant index by 1 depending on if the answer aligns with the question
    private void doQ5() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateQ5Fields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doQ5()
    private void initiateQ5Fields(JFrame frame) {
        JLabel q = new JLabel("You are detail-oriented over big picture (Type Agree or Disagree)");
        new Label(q);
        frame.add(q);

        JTextField answer = new JTextField();
        new TextField(answer);
        frame.add(answer);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateQ5Enter(frame, answer);
    }

    // EFFECTS: initiates enter button in doQ5() and increments the corresponding field if appropriate
    private void initiateQ5Enter(JFrame frame, JTextField answer) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (answer.getText().equals("Agree")) {
                    personality.incrementSn();
                    doQ6();
                }
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // REQUIRES: a string "Agree" or "Disagree" for the answer
    // MODIFIES: this
    // EFFECTS: Increments the relevant index by 1 depending on if the answer aligns with the question
    private void doQ6() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateQ6Fields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doQ6()
    private void initiateQ6Fields(JFrame frame) {
        JLabel q = new JLabel("You are affectionate with those close to you (Type Agree or Disagree)");
        new Label(q);
        frame.add(q);

        JTextField answer = new JTextField();
        new TextField(answer);
        frame.add(answer);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateQ6Enter(frame, answer);
    }

    // EFFECTS: initiates enter button in doQ6() and increments the corresponding field if appropriate
    private void initiateQ6Enter(JFrame frame, JTextField answer) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (answer.getText().equals("Disagree")) {
                    personality.incrementTf();
                    doQ7();
                }
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // REQUIRES: a string "Agree" or "Disagree" for the answer
    // MODIFIES: this
    // EFFECTS: Increments the relevant index by 1 depending on if the answer aligns with the question
    private void doQ7() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateQ7Fields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doQ7()
    private void initiateQ7Fields(JFrame frame) {
        JLabel q = new JLabel("You are careful and methodical when it comes to life (Type Agree or Disagree)");
        new Label(q);
        frame.add(q);

        JTextField answer = new JTextField();
        new TextField(answer);
        frame.add(answer);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateQ7Enter(frame, answer);
    }

    // EFFECTS: initiates enter button in doQ7() and increments the corresponding field if appropriate
    private void initiateQ7Enter(JFrame frame, JTextField answer) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (answer.getText().equals("Agree")) {
                    personality.incrementTf();
                    doQ8();
                }
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // REQUIRES: a string "Agree" or "Disagree" for the answer
    // MODIFIES: this
    // EFFECTS: Increments the relevant index by 1 depending on if the answer aligns with the question
    private void doQ8() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateQ8Fields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doQ8()
    private void initiateQ8Fields(JFrame frame) {
        JLabel q = new JLabel("You have wild/fantastical dreams (Type Agree or Disagree)");
        new Label(q);
        frame.add(q);

        JTextField answer = new JTextField();
        new TextField(answer);
        frame.add(answer);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateQ8Enter(frame, answer);
    }

    // EFFECTS: initiates enter button in doQ8() and increments the corresponding field if appropriate
    private void initiateQ8Enter(JFrame frame, JTextField answer) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (answer.getText().equals("Disagree")) {
                    personality.incrementSn();
                    doQ9();
                }
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // REQUIRES: a string "Agree" or "Disagree" for the answer
    // MODIFIES: this
    // EFFECTS: Increments the relevant index by 1 depending on if the answer aligns with the question
    private void doQ9() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateQ9Fields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doQ9()
    private void initiateQ9Fields(JFrame frame) {
        JLabel q = new JLabel("You only shop with a purchase in mind beforehand (Type Agree or Disagree)");
        new Label(q);
        frame.add(q);

        JTextField answer = new JTextField();
        new TextField(answer);
        frame.add(answer);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateQ9Enter(frame, answer);
    }

    // EFFECTS: initiates enter button in doQ9() and increments the corresponding field if appropriate
    private void initiateQ9Enter(JFrame frame, JTextField answer) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (answer.getText().equals("Agree")) {
                    personality.incrementJp();
                    doQ10();
                }
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // REQUIRES: a string "Agree" or "Disagree" for the answer
    // MODIFIES: this
    // EFFECTS: Increments the relevant index by 1 depending on if the answer aligns with the question
    private void doQ10() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateQ10Fields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doQ10()
    private void initiateQ10Fields(JFrame frame) {
        JLabel q = new JLabel("You focus on present realities over future possibilities (Type Agree or Disagree)");
        new Label(q);
        frame.add(q);

        JTextField answer = new JTextField();
        new TextField(answer);
        frame.add(answer);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateQ10Enter(frame, answer);
    }

    // EFFECTS: initiates enter button in doQ10() and increments the corresponding field if appropriate
    private void initiateQ10Enter(JFrame frame, JTextField answer) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (answer.getText().equals("Disagree")) {
                    personality.incrementSn();
                    doQ11();
                }
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // REQUIRES: a string "Agree" or "Disagree" for the answer
    // MODIFIES: this
    // EFFECTS: Increments the relevant index by 1 depending on if the answer aligns with the question
    private void doQ11() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateQ11Fields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doQ11()
    private void initiateQ11Fields(JFrame frame) {
        JLabel q = new JLabel("You prefer others to start conversations (Type Agree or Disagree)");
        new Label(q);
        frame.add(q);

        JTextField answer = new JTextField();
        new TextField(answer);
        frame.add(answer);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateQ11Enter(frame, answer);
    }

    // EFFECTS: initiates enter button in doQ11() and increments the corresponding field if appropriate
    private void initiateQ11Enter(JFrame frame, JTextField answer) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (answer.getText().equals("Disagree")) {
                    personality.incrementEi();
                    doQ12();
                }
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // REQUIRES: a string "Agree" or "Disagree" for the answer
    // MODIFIES: this
    // EFFECTS: Increments the relevant index by 1 depending on if the answer aligns with the question
    private void doQ12() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateQ12Fields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doQ12()
    private void initiateQ12Fields(JFrame frame) {
        JLabel q = new JLabel("Rules are meant to be broken (Type Agree or Disagree)");
        new Label(q);
        frame.add(q);

        JTextField answer = new JTextField();
        new TextField(answer);
        frame.add(answer);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateQ12Enter(frame, answer);
    }

    // EFFECTS: initiates enter button in doQ12() and increments the corresponding field if appropriate
    private void initiateQ12Enter(JFrame frame, JTextField answer) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (answer.getText().equals("Disagree")) {
                    personality.incrementJp();
                }
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // EFFECTS: displays current standing in each MBTI index
    private void doGetIndices() {
        displayMessage("All factors range from 0-3, 3 = close to 1st letter 0 = close to 2nd letter, " +
                "I.e. 3 in EI is most E. " +
                "YOUR CURRENT INDICES ARE: EI " + personality.getEi()
                + ", SN " + personality.getSn()
                + ", TF " + personality.getTf()
                + ", JP " + personality.getJp());
    }

    // EFFECTS: calculates MBTI type based on indices
    private void doCalculatePersonality() {
        displayMessage("Your MBTI type is " + personality.evaluateMBTI());
    }

    // REQUIRES: a string that is a valid MBTI type
    // EFFECTS: provides a profile for that type that includes the name a complementary Pokemon and some characteristics
    //          of that MBTI type
    private void doViewPersonalityTypes() {
        JFrame recordWindow = new JFrame("Take the Test!");

        initiateMBTIFields(recordWindow);
        new Frame(recordWindow);
    }

    // EFFECTS: Initiates texts fields for doViewPersonalityTypes()
    private void initiateMBTIFields(JFrame frame) {
        JLabel q = new JLabel("Please enter your MBTI type in all caps (i.e. ENTJ)");
        new Label(q);
        frame.add(q);

        JTextField answer = new JTextField();
        new TextField(answer);
        frame.add(answer);

        ImageIcon icon = new ImageIcon("./data/download (2).png");
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(225, 225));
        frame.add(label);

        initiateMBTIEnter(frame, answer);
    }

    // EFFECTS: initiates enter button in doQ2() and increments the corresponding field if appropriate
    private void initiateMBTIEnter(JFrame frame, JTextField answer) {
        JButton enter = new JButton("Confirm");
        new Confirm(enter);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selected(answer.getText());
                frame.setVisible(false);
            }
        });
        frame.add(enter);
    }

    // EFFECTS: finds the appropriate Pokemon to display for the given MBTI type
    private void selected(String mbti) {
        if (mbti.equals("INTJ")) {
            displayPersonality("Squirtle");
        } else if (mbti.equals("INTP")) {
            displayPersonality("Mudkip");
        } else if (mbti.equals("ENTJ")) {
            displayPersonality("Piplup");
        } else if (mbti.equals("ENTP")) {
            displayPersonality("Totodile");
        } else if (mbti.equals("INFJ")) {
            displayPersonality("Turtwig");
        } else if (mbti.equals("INFP")) {
            displayPersonality("Bulbasaur");
        } else if (mbti.equals("ENFJ")) {
            displayPersonality("Treecko");
        } else if (mbti.equals("ENFP")) {
            displayPersonality("Chikorita");
        } else if (mbti.equals("ISTJ")) {
            displayPersonality("Cyndaquil");
        } else if (mbti.equals("ISFJ")) {
            displayPersonality("Torchic");
        } else if (mbti.equals("ESTJ")) {
            displayPersonality("Charmander");
        } else if (mbti.equals("ESFJ")) {
            displayPersonality("Chimchar");
        } else if (mbti.equals("ISTP")) {
            displayPersonality("Elekid");
        } else if (mbti.equals("ISFP")) {
            displayPersonality("Shinx");
        } else if (mbti.equals("ESTP")) {
            displayPersonality("Pikachu");
        } else if (mbti.equals("ESFP")) {
            displayPersonality("Voltorb");
        }
    }

    // EFFECTS: creates the display frame for the complementary MBTI type Pokemon
    private void displayPersonality(String pokemon) {
            JFrame recordWindow = new JFrame("View Personality!");
            recordWindow.setPreferredSize(new Dimension(373,580));
            new Frame(recordWindow);

            ImageIcon icon = new ImageIcon(("./data/" + pokemon + ".jpg"));
            JLabel label = new JLabel(icon);
            label.setPreferredSize(new Dimension(373, 580));
            recordWindow.add(label);
    }

    // Displays a message on to the screen
    private void displayMessage(String str) {
        JFrame window = new JFrame("Message");
        window.setPreferredSize(new Dimension(1000, 500));
        window.setFont(new Font("Arial", Font.PLAIN, 40));
        window.setLayout(new BorderLayout(5, 5));

        JLabel msg = new JLabel("<html>" + str + "</html>", SwingConstants.CENTER);
        msg.setPreferredSize(new Dimension(750, 250));
        msg.setFont(new Font("Arial", Font.PLAIN, 40));
        window.add(msg, BorderLayout.CENTER);
        window.pack();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error while trying to play sound");
            e.printStackTrace();
        }
    }
}
