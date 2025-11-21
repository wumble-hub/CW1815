import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class DesktopGUI {
    private JPanel mainPanel;
    private JTextField nameField;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField vIDField;
    private JTextField vNameField;
    private JTextField vAddressField;
    private JTextField vCapacityField;
    private JButton goButton;
    private JTextField idField;

    public static void main(String[] args) {
        JFrame frame = new JFrame("DesktopGUI");
        frame.setContentPane(new DesktopGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        SaveSystem saveSystem = new SaveSystem();
        saveSystem.establishConnection();
        saveSystem.createTable();

    }

    public DesktopGUI() {
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Event event = new Event(
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        dateField.getText(),
                        Integer.parseInt(timeField.getText())
                );

                Venue venue = new Venue(
                        Integer.parseInt(vIDField.getText()),
                        vNameField.getText(),
                        vAddressField.getText(),
                        Integer.parseInt(vCapacityField.getText())
                );

                InformationControl infoCtrl = new InformationControl();
                infoCtrl.concatenateInfo(event, venue);










            }
        });
    }
}
