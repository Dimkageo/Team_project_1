package fremes;

import logic.Controller;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextField inputField;
    private JLabel computerResponseLabel;
    private JLabel userScoreLabel;
    private JLabel scoreLabel;
    private JLabel computerScoreLabel;
    Controller controller = new Controller();

    public MainFrame() {
        setTitle("МІСТА УКРАЇНИ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon logo = new ImageIcon("src/main/resources/LOGO_2.png");
        setIconImage(logo.getImage());

        /**
         * Main conainer of frame
         *
         */
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        /**
         * Input pannel
         *
         */
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        JLabel inputLabel = new JLabel("Введіть місто:");
        inputField = new JTextField(15);
        JButton submitButton = new JButton("Зробити хід");
        JButton submitButton2 = new JButton("Здатися");

        /**
         * font enlargement for input components
         *
          */
        Font labelFont = inputLabel.getFont();
        Font largerLabelFont = labelFont.deriveFont(labelFont.getSize() + 15f);
        inputLabel.setFont(largerLabelFont);

        Font fieldFont = inputField.getFont();
        Font largerFieldFont = fieldFont.deriveFont(fieldFont.getSize() + 15f);
        inputField.setFont(largerFieldFont);

        Font buttonFont = submitButton.getFont();
        Font largerButtonFont = buttonFont.deriveFont(buttonFont.getSize() + 15f);
        submitButton.setFont(largerButtonFont);
        Font buttonFont2 = submitButton2.getFont();
        submitButton2.setFont(largerButtonFont);

        /**
         *Add components to the input panel
         *
         */
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0); // Відступи вниз
        inputPanel.add(inputLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0); // Нульові відступи
        inputPanel.add(inputField, gbc);

        /**
         *Panel for button centering
         *
         */
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);
        buttonPanel.add(submitButton2);

        /**
         *Add components to the input panel
         */
        gbc.gridy = 2;
        inputPanel.add(buttonPanel, gbc);

        /**
         *Computer answer panel
         */
        JPanel responsePanel = new JPanel();
        responsePanel.setLayout(new FlowLayout());

        computerResponseLabel = new JLabel();
        Font responseLabelFont = computerResponseLabel.getFont();
        Font largerResponseLabelFont = responseLabelFont.deriveFont(responseLabelFont.getSize() + 15f);
        computerResponseLabel.setFont(largerResponseLabelFont);

        userScoreLabel = new JLabel("0");
        Font userScoreLabelFont = userScoreLabel.getFont();
        Font largerUserScoreLabelFont = userScoreLabelFont.deriveFont(userScoreLabelFont.getSize() + 15f);
        userScoreLabel.setFont(largerUserScoreLabelFont);
        computerScoreLabel = new JLabel("0");
        Font computerScoreLabelFont = computerScoreLabel.getFont();
        Font largerСomputerScoreLabelFont = computerScoreLabelFont.deriveFont(computerScoreLabelFont.getSize() + 15f);
        computerScoreLabel.setFont(largerСomputerScoreLabelFont);

        JLabel responseLabel = new JLabel("Відповідь комп'ютера:");
        responseLabel.setFont(largerLabelFont);
        responsePanel.add(responseLabel);
        responsePanel.add(computerResponseLabel);

        /**
         * Score panel
         */
        JPanel scorePanel = new JPanel(new BorderLayout());
        JPanel scoreNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel userScoreNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel computerScoreNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        scoreLabel = new JLabel("Кількість названих міст");
        scoreLabel.setFont(largerLabelFont);
        scorePanel.add(scoreNamePanel, BorderLayout.NORTH);
        scoreNamePanel.add(scoreLabel);

        scorePanel.add(userScoreNamePanel, BorderLayout.WEST);
        userScoreNamePanel.add(userScoreLabel);
        scorePanel.add(computerScoreNamePanel, BorderLayout.EAST);
        computerScoreNamePanel.add(computerScoreLabel);

        /**
         * Indentation on the right forcomputerScoreLabel
         */
        computerScoreLabel.setBorder(new EmptyBorder(0, 0, 0, 100));
        userScoreLabel.setBorder(new EmptyBorder(0, 100, 0, 0));
        scorePanel.setBorder(new EmptyBorder(0, 0, 50, 0));

        /**
         * Add panels to the container
         */
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(responsePanel, BorderLayout.CENTER);
        mainPanel.add(scorePanel, BorderLayout.SOUTH);
        container.add(mainPanel, BorderLayout.CENTER);

        /**
         *Add an event handler for the "Make a move" button
         */
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputCity = inputField.getText();
                controller.getCityValidation(inputCity, computerResponseLabel, inputField, userScoreLabel, computerScoreLabel);
            }
        });
        submitButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.reactionToButton();
            }
        });
    }
}