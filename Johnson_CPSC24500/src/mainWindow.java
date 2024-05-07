import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class mainWindow extends JFrame {
    private JMenuItem miLogin;
    private JMenuItem miSave;
    private JMenuItem miLogout;
    private JButton btnAdd;
    private JTextArea tarSummary;
    private JTextField txtName;
    private JComboBox<String> cboType;
    private JTextField txtDate;
    private JTextField txtDuration;
    private JTextField txtDistance;
    private JTextArea tarComments;
    private JDialog passDialog;
    private boolean loggedIn = false;

    public mainWindow() {
        setupGUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center frame
        setSize(700, 300);
        passDialog = new JDialog();
        passDialog.setTitle("login");
        passDialog.setSize(300, 200);
        setupLoginDialog();
        disableExerciseTrackerFeatures();
    }

    private void disableExerciseTrackerFeatures() {
        // Disable components here
        btnAdd.setEnabled(false);
        // Disable other components as needed
    }

    private void enableExerciseTrackerFeatures() {
        // Enable components here
        btnAdd.setEnabled(true);
        // Enable other components as needed
    }

    private void setupLoginDialog() {
        passDialog = new JDialog(this, "Login");
        passDialog.setSize(300, 150);
        passDialog.setLayout(new GridLayout(3, 2));

        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JTextField txtUsername = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JButton btnLogin = new JButton("Login");

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = txtUsername.getText();
                String enteredPassword = new String(txtPassword.getPassword());

                if (enteredUsername.equals("healthy") && enteredPassword.equals("donuts")) {
                    passDialog.setVisible(false);
                    loggedIn = true;
                    enableExerciseTrackerFeatures(); // Enable features after successful login
                } else {
                    JOptionPane.showMessageDialog(passDialog, "Invalid username or password. Please try again.");
                }
            }
        });

        passDialog.add(lblUsername);
        passDialog.add(txtUsername);
        passDialog.add(lblPassword);
        passDialog.add(txtPassword);
        passDialog.add(btnLogin);
    }

    public void setupMenu() {
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);

        JMenu mnuFile = new JMenu("File");
        mbar.add(mnuFile);

        miLogin = new JMenuItem("Log in");
        miLogin.addActionListener(e -> passDialog.setVisible(true));
        mnuFile.add(miLogin);

        miSave = new JMenuItem("Save Exercises");
        miSave.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int returnValue = chooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write(tarSummary.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(null, "File saved successfully.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mnuFile.add(miSave);

        miLogout = new JMenuItem("Log Out");
        miLogout.addActionListener(e -> disableExerciseTrackerFeatures()); // Disable exercise tracker when log out is clicked
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(e -> System.exit(0));
        mnuFile.add(miLogout);
        mnuFile.add(miExit);

        JMenu mnuTools = new JMenu("Help");
        mbar.add(mnuTools);

        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(e -> JOptionPane.showMessageDialog(null, "Exercise Tracker, Spring 2024"));
        mnuTools.add(miAbout);
    }


    public void setupGUI() {
        setTitle("Exercise Tracker");

        setupMenu();

        Container c = getContentPane();
        c.setLayout(new BorderLayout(25, 25));

        JPanel pnlLeft = new JPanel();
        setupLeftPanel(pnlLeft);

        JPanel pnlRight = new JPanel();
        setupRightPanel(pnlRight);

        c.add(pnlLeft, BorderLayout.WEST);
        c.add(pnlRight, BorderLayout.CENTER);

        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        c.add(panSouth, BorderLayout.SOUTH);

        btnAdd = new JButton("Add Exercise");
        btnAdd.addActionListener(e -> {
            String text = tarSummary.getText();
                text += "\n";
            
            text += cboType.getSelectedItem().toString() + "\t";
            text += txtName.getText().trim() + "\t";
            text += txtDate.getText().trim() + "\t";
            text += txtDuration.getText().trim() + "\t";
            text += txtDistance.getText().trim() + "\t";
            text += tarComments.getText().trim() + "\t";
                tarSummary.setText(text);
            
        });

        panSouth.add(btnAdd);
        // disableAll();
    }

    private void setupLeftPanel(JPanel pnlLeft) {
        pnlLeft.setLayout(new GridLayout(6, 2, 5, 5));

        pnlLeft.add(new JLabel("Name:"));
        txtName = new JTextField();
        pnlLeft.add(txtName);

        pnlLeft.add(new JLabel("Type:"));
        String[] exerciseTypes = {"Run/Walk", "Weightlifting", "Rock Climbing"};
        cboType = new JComboBox<>(exerciseTypes);
        pnlLeft.add(cboType);

        pnlLeft.add(new JLabel("Date:"));
        txtDate = new JTextField();
        pnlLeft.add(txtDate);

        pnlLeft.add(new JLabel("Duration:"));
        txtDuration = new JTextField();
        pnlLeft.add(txtDuration);

        pnlLeft.add(new JLabel("Distance:"));
        txtDistance = new JTextField();
        pnlLeft.add(txtDistance);

        pnlLeft.add(new JLabel("Comments:"));
        tarComments = new JTextArea();
        pnlLeft.add(new JScrollPane(tarComments));
    }

    private void setupRightPanel(JPanel pnlRight) {
        pnlRight.setLayout(new BorderLayout());

        tarSummary = new JTextArea();
        pnlRight.add(new JScrollPane(tarSummary), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            mainWindow window = new mainWindow();
            window.setVisible(true);
        });
    }
}
