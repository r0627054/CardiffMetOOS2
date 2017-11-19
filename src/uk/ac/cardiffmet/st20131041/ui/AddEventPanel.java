package uk.ac.cardiffmet.st20131041.ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXDatePicker;
import uk.ac.cardiffmet.st20131041.domain.db.DatabaseException;
import uk.ac.cardiffmet.st20131041.domain.model.DomainException;
import uk.ac.cardiffmet.st20131041.domain.model.Event;
import uk.ac.cardiffmet.st20131041.domain.model.Location;
import uk.ac.cardiffmet.st20131041.domain.service.EventService;

/**
 * Panel used for adding a person object to the model (service)
 *
 * @author Dries Janse
 * @Version 1.0
 */
public class AddEventPanel extends javax.swing.JPanel {

    /**
     * The service that is used for the events.
     */
    private EventService service;

    /**
     * Creates new form AddEventPanel and initializes all its components. This
     * constructor is not used in the program execution. It is only used in the
     * Netbeans idea, for the designing.
     */
    public AddEventPanel() {
        initComponents();
    }

    /**
     * Creates new form AddEventPanel and initializes all its components. It
     * loads the all the nicknames in the combobox.
     *
     * @param service
     */
    public AddEventPanel(EventService service) {
        this.setService(service);
        this.initComponents();
        this.loadComboBoxNicknames();
    }

    /**
     * Gets the service.
     *
     * @return the service class
     */
    public EventService getService() {
        return service;
    }

    /**
     * Sets the service
     *
     * @param service
     */
    public void setService(EventService service) {
        this.service = service;
    }

    /**
     * Removes all the items of the personCombobox. Otherwise same person
     * nicknames can be present. Load all the person person names in the
     * combobox.
     *
     */
    public void loadComboBoxNicknames() {
        this.getPersonComboBox().removeAllItems();
        for (String s : this.getService().getAllPersonNames()) {
            this.getPersonComboBox().addItem(s);
        }
    }

    /**
     * Gets the ComboBox object that holds the names of all the people.
     *
     * @return the ComboBox that holds the names of all the people.
     */
    public JComboBox<String> getPersonComboBox() {
        return personComboBox;
    }

    /**
     * Gets the JTextArea that holds the description of the event.
     *
     * @return the JTextArea that holds the description of the event.
     */
    public JTextArea getDescriptionArea() {
        return descriptionArea;
    }

    /**
     * Gets the JTable that holds all added user to the event and their link.
     *
     * @return the JTable that holds all added user to the event and their link.
     */
    public JTable getUserTable() {
        return userTable;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descriptionLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        titleField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        postcodeLabel = new javax.swing.JLabel();
        personRoleLabel = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        houseNumberLabel = new javax.swing.JLabel();
        postcodeField = new javax.swing.JTextField();
        streeteNameField = new javax.swing.JTextField();
        houseNumberField = new javax.swing.JTextField();
        countryField = new javax.swing.JTextField();
        participantsLabel = new javax.swing.JLabel();
        personComboBox = new javax.swing.JComboBox<>();
        streetNameLabel1 = new javax.swing.JLabel();
        choosePersonLabel1 = new javax.swing.JLabel();
        personRoleField = new javax.swing.JTextField();
        addEventButton = new javax.swing.JButton();
        addPersonToEventButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        startDatePicker = new org.jdesktop.swingx.JXDatePicker();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        endDatePicker = new org.jdesktop.swingx.JXDatePicker();

        setBackground(new java.awt.Color(255, 255, 255));

        descriptionLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        descriptionLabel.setText("Description");

        locationLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 24)); // NOI18N
        locationLabel.setForeground(new java.awt.Color(0, 51, 0));
        locationLabel.setText("Location");

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        descriptionArea.setText("Enter event description.");
        descriptionArea.setToolTipText("");
        descriptionArea.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        jScrollPane1.setViewportView(descriptionArea);

        titleField.setText("Enter event title.");
        titleField.setToolTipText("");
        titleField.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        titleLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        titleLabel.setText("Title");

        postcodeLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        postcodeLabel.setText("Postcode");

        personRoleLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        personRoleLabel.setText("Person role?");

        countryLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        countryLabel.setText("Country");

        houseNumberLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        houseNumberLabel.setText("House number");

        postcodeField.setText("Enter event postcode.");
        postcodeField.setToolTipText("");
        postcodeField.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        streeteNameField.setText("Enter event street name.");
        streeteNameField.setToolTipText("");
        streeteNameField.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        houseNumberField.setText("number.");
        houseNumberField.setToolTipText("");
        houseNumberField.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        houseNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                houseNumberFieldActionPerformed(evt);
            }
        });

        countryField.setText("Enter event country.");
        countryField.setToolTipText("");
        countryField.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        participantsLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 24)); // NOI18N
        participantsLabel.setForeground(new java.awt.Color(0, 51, 0));
        participantsLabel.setText("Participants");

        personComboBox.setModel(new javax.swing.DefaultComboBoxModel<>());

        streetNameLabel1.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        streetNameLabel1.setText("Street name");

        choosePersonLabel1.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        choosePersonLabel1.setText("Choose person");

        personRoleField.setText("Enter person role.");
        personRoleField.setToolTipText("");
        personRoleField.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        addEventButton.setBackground(new java.awt.Color(54, 128, 45));
        addEventButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        addEventButton.setText("Add Event");
        addEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEventButtonActionPerformed(evt);
            }
        });

        addPersonToEventButton.setBackground(new java.awt.Color(54, 128, 45));
        addPersonToEventButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        addPersonToEventButton.setText("Add Person");
        addPersonToEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersonToEventButtonActionPerformed(evt);
            }
        });

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person nickname", "Role description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(userTable);
        if (userTable.getColumnModel().getColumnCount() > 0) {
            userTable.getColumnModel().getColumn(1).setResizable(false);
        }

        startDateLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        startDateLabel.setText("End Date");

        endDateLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        endDateLabel.setText("Start Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(participantsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(countryLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(countryField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(personRoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(postcodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(postcodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(streeteNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(locationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(endDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(startDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(streetNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(houseNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(houseNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(personComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(personRoleField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addPersonToEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(choosePersonLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(locationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(postcodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(streetNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(houseNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(countryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postcodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countryField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streeteNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(houseNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(participantsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choosePersonLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personRoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personRoleField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addPersonToEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Button that will add the entered name and their link to the person table.
     *
     * @param evt
     */
    private void addPersonToEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersonToEventButtonActionPerformed
        String selectedNickname = (String) this.getPersonComboBox().getSelectedItem();
        String description = this.getPersonRoleField().getText();
        if (!getAllUsernamesAdded().contains(selectedNickname)) {
            DefaultTableModel model = (DefaultTableModel) this.getUserTable().getModel();
            model.addRow(new Object[]{selectedNickname, description});
        }
    }//GEN-LAST:event_addPersonToEventButtonActionPerformed

    /**
     * When the button is clicked the event and all the information will be
     * checked. If fields are wrongly filled in, the error message will be
     * displayed. If all fields are correctly filled in, the event will be added
     * to the model (service)
     *
     * @param evt
     */
    private void addEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventButtonActionPerformed
        this.allDefaultBorders();
        Event event = new Event();
        Location location = new Location();
        String errors = "";
        try {
            event.setDescription(this.getDescriptionArea().getText());
        } catch (DomainException e) {
            errors += e.getMessage() + "\n";
            this.getDescriptionArea().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.red, null));
        }
        try {
            event.setTitle(this.getTitleField().getText());
        } catch (DomainException e) {
            errors += e.getMessage() + "\n";
            this.getTitleField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.red, null));
        }
        try {
            event.setStartDate(this.getStartDatePicker().getDate());
            Date date1 = this.getStartDatePicker().getDate();
            Calendar cal = new GregorianCalendar();
            cal.setTimeInMillis(date1.getTime());
            SimpleDateFormat fmt = new SimpleDateFormat("EE dd MMM yyyy");
            fmt.setCalendar(cal);
            String dateFormatted = fmt.format(cal.getTime());

        } catch (Exception e) {
            errors += e.getMessage() + "\n";
            this.getStartDatePicker().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.red, null));
        }
        try {
            event.setEndDate(this.getEndDatePicker().getDate());
        } catch (Exception e) {
            errors += e.getMessage() + "\n";
            this.getEndDatePicker().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.red, null));
        }
        try {
            location.setCountry(this.getCountryField().getText());
        } catch (DomainException e) {
            errors += e.getMessage() + "\n";
            this.getCountryField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.red, null));
        }
        try {
            location.setPostcode(this.getPostcodeField().getText());
        } catch (DomainException e) {
            errors += e.getMessage() + "\n";
            this.getPostcodeField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.red, null));
        }
        try {
            location.setStreetName(this.getStreeteNameField().getText());
        } catch (DomainException e) {
            errors += e.getMessage() + "\n";
            this.getStreeteNameField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.red, null));
        }
        try {
            location.setHouseNumber(this.getHouseNumberField().getText());
        } catch (DomainException e) {
            errors += e.getMessage() + "\n";
            this.getHouseNumberField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.red, null));
        }
        try {
            int rows = this.getUserTable().getRowCount();
            int columns = this.getUserTable().getColumnCount();
            for (int i = 0; i < rows; i++) {
                ArrayList<String> result = new ArrayList<>();
                for (int j = 0; j < columns; j++) {
                    result.add((String) this.getUserTable().getValueAt(i, j));
                }
                event.addPerson(service.getPerson(result.get(0)), result.get(1));
            }
        } catch (DomainException e) {
            errors += e.getMessage() + "\n";
        }
        try {
            event.setLocation(location);
        } catch (DomainException e) {
            errors += e.getMessage() + "\n";
        }
        if (!errors.isEmpty()) {
            JOptionPane.showMessageDialog(null, errors, "Something went wrong.", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                service.addEvent(event);
                JOptionPane.showMessageDialog(null, "Event is successfully added.", "Event successfully added.", JOptionPane.INFORMATION_MESSAGE);
            } catch (DatabaseException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Something went wrong.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addEventButtonActionPerformed

    private void houseNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_houseNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_houseNumberFieldActionPerformed

    /**
     * Gets an ArrayList with all the usernamesthat were added to the event.
     *
     * @return
     */
    private ArrayList<String> getAllUsernamesAdded() {
        ArrayList<String> addedUsers = new ArrayList<>();
        int rows = this.getUserTable().getRowCount();
        for (int i = 0; i < rows; i++) {
            addedUsers.add((String) this.getUserTable().getValueAt(i, 0));
        }
        return addedUsers;
    }

    /**
     * Gets the personRoleField
     *
     * @return the personRoleField
     */
    private JTextField getPersonRoleField() {
        return personRoleField;
    }

    /**
     * Gets the countryField
     *
     * @return the countryField
     */
    private JTextField getCountryField() {
        return countryField;
    }

    /**
     * Gets the houseNumberField
     *
     * @return the houseNumberField
     */
    private JTextField getHouseNumberField() {
        return houseNumberField;
    }

    /**
     * Gets the postcodeField
     *
     * @return the postcodeField
     */
    private JTextField getPostcodeField() {
        return postcodeField;
    }

    /**
     * Gets the streetNameField.
     *
     * @return the streetNameField
     */
    private JTextField getStreeteNameField() {
        return streeteNameField;
    }

    /**
     * Gets the titleField
     *
     * @return the titleField
     */
    private JTextField getTitleField() {
        return titleField;
    }

    /**
     * Gets the EndDatePicker
     *
     * @return the endDatePicker
     */
    private JXDatePicker getEndDatePicker() {
        return endDatePicker;
    }

    /**
     * Gets the StartDatePicker
     *
     * @return the StartDatePicker
     */
    private JXDatePicker getStartDatePicker() {
        return startDatePicker;
    }

    /**
     * Put all the field borders of the panel back to light gray.
     */
    private void allDefaultBorders() {
        this.getTitleField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        this.getDescriptionArea().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        this.getCountryField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        this.getPostcodeField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        this.getStreeteNameField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        this.getHouseNumberField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        this.getPersonRoleField().setBorder(BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        this.getStartDatePicker().setBorder(BorderFactory.createEmptyBorder());
        this.getEndDatePicker().setBorder(BorderFactory.createEmptyBorder());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEventButton;
    private javax.swing.JButton addPersonToEventButton;
    private javax.swing.JLabel choosePersonLabel1;
    private javax.swing.JTextField countryField;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel endDateLabel;
    private org.jdesktop.swingx.JXDatePicker endDatePicker;
    private javax.swing.JTextField houseNumberField;
    private javax.swing.JLabel houseNumberLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JLabel participantsLabel;
    private javax.swing.JComboBox<String> personComboBox;
    private javax.swing.JTextField personRoleField;
    private javax.swing.JLabel personRoleLabel;
    private javax.swing.JTextField postcodeField;
    private javax.swing.JLabel postcodeLabel;
    private javax.swing.JLabel startDateLabel;
    private org.jdesktop.swingx.JXDatePicker startDatePicker;
    private javax.swing.JLabel streetNameLabel1;
    private javax.swing.JTextField streeteNameField;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
