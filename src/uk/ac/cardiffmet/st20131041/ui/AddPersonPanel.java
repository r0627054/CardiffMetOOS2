package uk.ac.cardiffmet.st20131041.ui;

import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;
import uk.ac.cardiffmet.st20131041.domain.db.DatabaseException;
import uk.ac.cardiffmet.st20131041.domain.model.DomainException;
import uk.ac.cardiffmet.st20131041.domain.model.Person;
import uk.ac.cardiffmet.st20131041.domain.service.EventService;

/**
 * Panel used for adding a person object to the model (service)
 *
 * @author Dries Janse
 * @version 1.0
 */
public class AddPersonPanel extends javax.swing.JPanel {

    /**
     * The service that is used for the events.
     */
    private EventService service;

    /**
     * Creates new form AddPersonPanel and initializes the components. This
     * constructor is not used in the program execution. It is only used in the
     * Netbeans idea, for the designing.
     */
    public AddPersonPanel() {
        initComponents();
    }

    /**
     * Creates new form AddPersonPanel and initializes the components. It sets
     * the service.
     *
     * @param service
     */
    public AddPersonPanel(EventService service) {
        this.setService(service);
        this.initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        addPersonButton = new javax.swing.JButton();
        firstNameField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        nicknameLabel = new javax.swing.JLabel();
        birthdayPicker = new org.jdesktop.swingx.JXDatePicker();
        surnameField = new javax.swing.JTextField();
        birthdayLabel1 = new javax.swing.JLabel();
        nicknameField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        firstNameLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        firstNameLabel.setText("First name");

        addPersonButton.setBackground(new java.awt.Color(54, 128, 45));
        addPersonButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        addPersonButton.setText("Add Person");
        addPersonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersonButtonActionPerformed(evt);
            }
        });

        firstNameField.setText("Enter first name.");
        firstNameField.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        surnameLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        surnameLabel.setText("Surname");

        nicknameLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        nicknameLabel.setText("Nickname");

        surnameField.setText("Enter sur name.");
        surnameField.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        birthdayLabel1.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        birthdayLabel1.setText("Birthday");

        nicknameField.setText("Enter nickname.");
        nicknameField.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addPersonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nicknameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nicknameField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthdayPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthdayLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nicknameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthdayLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdayPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nicknameField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(addPersonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * When the button is clicked the person and all the information will be
     * checked. If fields are wrongly filled in, the error message will be
     * displayed. If all fields are correctly filled in, the person will be
     * added to the model (service)
     *
     * @param evt
     */
    private void addPersonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersonButtonActionPerformed
        this.resetAllBorders();
        Person p = new Person();
        String errors = "";
        try {
            p.setForename(this.getFirstNameText());
        } catch (DomainException e) {
            errors += e.getMessage() + "\n";
            this.getFirstNameField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.red, null));
        }
        try {
            p.setSurname(this.getSurnameText());
        } catch (DomainException e) {
            errors += e.getMessage() + "\n";
            this.getSurnameField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.red, null));
        }
        try {
            p.setBirthday(this.getBirthday());
        } catch (DomainException e) {
            errors += e.getMessage() + "\n";
            this.getBirthdayPicker().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.red, null));
        }
        try {
            p.setNickname(this.getNicknameText());
        } catch (DomainException e) {
            errors += e.getMessage() + "\n";
            this.getNicknameField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.red, null));
        }
        if (!errors.isEmpty()) {
            JOptionPane.showMessageDialog(null, errors, "Something went wrong.", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                this.getService().addPerson(p);
                JOptionPane.showMessageDialog(null, this.getFirstNameText() + " " + this.getSurnameText() + " was successfully added.", "Person successfully added.", JOptionPane.INFORMATION_MESSAGE);
            } catch (DatabaseException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Something went wrong.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addPersonButtonActionPerformed

    /**
     * Put all the field borders of the panel back to light gray.
     */
    private void resetAllBorders() {
        this.getFirstNameField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        this.getSurnameField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        this.getNicknameField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        this.getBirthdayPicker().setBorder(BorderFactory.createEmptyBorder());
    }

    /**
     * Gets the first name that is entered.
     *
     * @return first name that is entered.
     */
    private String getFirstNameText() {
        return this.getFirstNameField().getText();
    }

    /**
     * Gets the surname that is entered.
     *
     * @return surname that is entered.
     */
    private String getSurnameText() {
        return this.getSurnameField().getText();
    }

    /**
     * Gets the nickname that is entered.
     *
     * @return nickname that is entered.
     */
    private String getNicknameText() {
        return this.getNicknameField().getText();
    }

    /**
     * Gets the (birth) date object that is entered.
     *
     * @return birthday that is entered.
     */
    private Date getBirthday() {
        return this.getBirthdayPicker().getDate();
    }

    /**
     * Gets the birthdayPicker.
     *
     * @return the JX Birthday picker.
     */
    private JXDatePicker getBirthdayPicker() {
        return birthdayPicker;
    }

    /**
     * Gets the firstNameField.
     *
     * @return the firstNameField
     */
    private JTextField getFirstNameField() {
        return firstNameField;
    }

    /**
     * Gets the surnameField.
     *
     * @return surnameField
     */
    private JTextField getSurnameField() {
        return surnameField;
    }

    /**
     * Gets the nicknameField
     *
     * @return nicknameField
     */
    private JTextField getNicknameField() {
        return nicknameField;
    }

    /**
     * Gets the addPersonButton.
     *
     * @return the addPersonButton
     */
    private JButton getAddPersonButton() {
        return addPersonButton;
    }

    /**
     * Gets the (model) service
     *
     * @return the model (service)
     */
    private EventService getService() {
        return service;
    }

    /**
     * Sets the (model) service.
     *
     * @param service
     */
    private void setService(EventService service) {
        this.service = service;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPersonButton;
    private javax.swing.JLabel birthdayLabel1;
    private org.jdesktop.swingx.JXDatePicker birthdayPicker;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField nicknameField;
    private javax.swing.JLabel nicknameLabel;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    // End of variables declaration//GEN-END:variables
}
