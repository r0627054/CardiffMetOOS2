package uk.ac.cardiffmet.st20131041.ui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import uk.ac.cardiffmet.st20131041.domain.model.Event;
import uk.ac.cardiffmet.st20131041.domain.model.Person;
import uk.ac.cardiffmet.st20131041.domain.service.EventService;

/**
 * Panel used for showing the time line and the information of the clicked
 * event.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class TimeLinePanel extends javax.swing.JPanel {

    private EventService service;
    private int selectedYear = 0;
    private ArrayList<Event> EventsOfYear;
    private ArrayList<JLabel> allEventLabels = new ArrayList<JLabel>();

    /**
     * Creates new form TimeLinePanel and initializes all its components. This
     * constructor is not used in the program execution. It is only used in the
     * Netbeans idea, for the designing.
     */
    public TimeLinePanel() {
        this.setService(new EventService("MEMORY"));
        this.setEventsOfYear(service.getAllEventsOfYear(this.getInitialYear()));
        this.setSelectedYear(this.getInitialYear());
        initComponents();
        loadYearsInComboBox();
        drawEvents(this.getEventsOfYear());
    }

    /**
     * Creates new form TimeLinePanel and initializes all its components.
     *
     * @param service
     */
    public TimeLinePanel(EventService service) {
        this.setService(service);
        this.setEventsOfYear(service.getAllEventsOfYear(this.getInitialYear()));
        this.setSelectedYear(this.getInitialYear());
        initComponents();
        loadYearsInComboBox();
        drawEvents(this.getEventsOfYear());
    }

    /**
     * Gets the initial year. This is the first year of all the different years.
     * If there are no event the timeline for 2017 will be drawn.
     *
     * @return
     */
    public int getInitialYear() {
        if (this.getService().getAllDifferentYears().size() == 0) {
            return 2017;
        } else {
            return this.getService().getAllDifferentYears().get(0);
        }
    }

    /**
     * Gets the service (model)
     *
     * @return
     */
    private EventService getService() {
        return service;
    }

    /**
     * Sets the service (model)
     *
     * @param service
     */
    private void setService(EventService service) {
        this.service = service;
    }

    /**
     * Gets the ArrayList that holds all the Event of the selected year.
     *
     * @return ArrayList of Event of that year
     */
    public ArrayList<Event> getEventsOfYear() {
        return EventsOfYear;
    }

    /**
     * Sets the ArrayList that holds all the Event of the selected year.
     *
     * @param EventsOfYear ArrayList of Event of that year
     */
    public void setEventsOfYear(ArrayList<Event> EventsOfYear) {
        this.EventsOfYear = EventsOfYear;
    }

    /**
     * Load all the possible years into the combobox.
     */
    public void loadYearsInComboBox() {
        this.getYearComboBox().removeAllItems();
        for (int s : this.getService().getAllDifferentYears()) {
            this.getYearComboBox().addItem(Integer.toString(s));
        }
    }

    /**
     * Gets the yearComboBox
     *
     * @return
     */
    private JComboBox<String> getYearComboBox() {
        return yearComboBox;
    }

    /**
     * Sets the yearCombox
     *
     * @param yearComboBox
     */
    private void setYearComboBox(JComboBox<String> yearComboBox) {
        this.yearComboBox = yearComboBox;
    }

    /**
     * Draws all the events on the time line.
     *
     */
    private void drawEvents(ArrayList<Event> allEvents) {

        int i = 0;
        for (Event e : allEvents) {
            JLabel label = new JLabel(e.getTitle(), SwingConstants.CENTER);
            label.setFont(new java.awt.Font("Yu Gothic UI", 3, 17));
            this.getTimeline().add(label);
            int nrDays = this.getTimeline().numberOfBlocks(e.getStartDate(), e.getEndDate());
            int offset = this.getTimeline().numberOfBlocks(new Date(this.getTimeline().getYear(), 00, 01), e.getStartDate()) - 1;
            int numberOfOverlaps = this.getTimeline().numberOfOverlaps(i);
            if (numberOfOverlaps < this.getTimeline().numberOfCumulativeOverlaps(i)) {
                numberOfOverlaps = this.getTimeline().numberOfCumulativeOverlaps(i);
            }
            label.setLocation(40 + (offset * this.getTimeline().getDayWidth()), this.getTimeline().getOriginY() - this.getTimeline().getLabelHeight() - (numberOfOverlaps * this.getTimeline().getLabelHeight()));
            label.setSize((nrDays) * this.getTimeline().getDayWidth(), this.getTimeline().getLabelHeight());
            label.setOpaque(true);
            label.setBackground(new Color(119, 171, 89));
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            label.setBorder(border);
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    Event e = service.getEvent(label.getText());
                    getTitleValueLabel().setText(e.getTitle());
                    getDescriptionValueLabel().setText(e.getDescription());
                    SimpleDateFormat format = new SimpleDateFormat("dd MMMM");
                    getStartDateValueLabel().setText(format.format(e.getStartDate()));
                    getEndDateValueLabel().setText(format.format(e.getEndDate()));
                    getCountryValueLabel().setText(e.getLocation().getCountry());
                    getPostcodeValueLabel().setText(e.getLocation().getPostcode());
                    getStreetNameValueLabel().setText(e.getLocation().getStreetName());
                    getHouseNumberValueLabel().setText(e.getLocation().getHouseNumber());

                    //show persons which are linked with the event
                    deletePersonLinkTableContents();
                    for (Entry<Person, String> entry : e.getEveryPersonWithLink().entrySet()) {
                        insertRowInPersonLinkTable(entry.getKey().getForename() + " " + entry.getKey().getSurname(), entry.getValue());
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    label.setBackground(new Color(201, 223, 138));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setBackground(new Color(119, 171, 89));
                }
            });
            allEventLabels.add(label);
            i++;
        }
    }

    /**
     * Gets the time line object.
     *
     * @return
     */
    public Timeline getTimeline() {
        return timeline;
    }

    /**
     * Gets the selected year.
     *
     * @return the selected year
     */
    private int getSelectedYear() {
        return selectedYear;
    }

    /**
     * Sets the selected year
     *
     * @param selectedYear
     */
    private void setSelectedYear(int selectedYear) {
        this.selectedYear = selectedYear;
    }

    /**
     * Gets the descriptionValueLabel
     *
     * @return the descriptionValueLabel
     */
    public JLabel getDescriptionValueLabel() {
        return descriptionValueLabel;
    }

    /**
     * Gets the TitleValueLabel
     *
     * @return the titleValueLabel
     */
    public JLabel getTitleValueLabel() {
        return titleValueLabel;
    }

    /**
     * Gets the countryValueLabel
     *
     * @return the countryValueLabel
     */
    public JLabel getCountryValueLabel() {
        return countryValueLabel;
    }

    /**
     * Gets the endDateValueLabel
     *
     * @return the endDateValue
     */
    public JLabel getEndDateValueLabel() {
        return endDateValueLabel;
    }

    /**
     * Gets the houseNumberValueLabel
     *
     * @return houseNumberValueLabel
     */
    public JLabel getHouseNumberValueLabel() {
        return houseNumberValueLabel;
    }

    /**
     * Gets the postcodeValueLabel
     *
     * @return postcodeValueLabel
     */
    public JLabel getPostcodeValueLabel() {
        return postcodeValueLabel;
    }

    /**
     * Gets the StartDateValueLabel
     *
     * @return StartDateValueLabel
     */
    public JLabel getStartDateValueLabel() {
        return startDateValueLabel;
    }

    /**
     * Gets the streetNameValueLabel
     *
     * @return streetNameValueLabel
     */
    public JLabel getStreetNameValueLabel() {
        return streetNameValueLabel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        timeline = new uk.ac.cardiffmet.st20131041.ui.Timeline(this.getEventsOfYear(), this.getSelectedYear());
        yearComboBox = new javax.swing.JComboBox<>();
        titleLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        countryValueLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        titleValueLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        endDateValueLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        startDateValueLabel = new javax.swing.JLabel();
        PostcodeLabel = new javax.swing.JLabel();
        streetNameLabel = new javax.swing.JLabel();
        houseNumberLabel = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        houseNumberValueLabel = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        descriptionValueLabel = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        postcodeValueLabel = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        streetNameValueLabel = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        PersonLinkTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(timeline);

        yearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboBoxActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        titleLabel.setText("Title");

        descriptionLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        descriptionLabel.setText("Description");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        countryValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        countryValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jScrollPane2.setViewportView(countryValueLabel);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        titleValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jScrollPane3.setViewportView(titleValueLabel);

        endDateLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        endDateLabel.setText("End Date");

        startDateLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        startDateLabel.setText("Start date");

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        endDateValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        endDateValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jScrollPane4.setViewportView(endDateValueLabel);

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        startDateValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        startDateValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jScrollPane5.setViewportView(startDateValueLabel);

        PostcodeLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        PostcodeLabel.setText("Postcode");

        streetNameLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        streetNameLabel.setText("Street name");

        houseNumberLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        houseNumberLabel.setText("House number");

        countryLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        countryLabel.setText("Country");

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));

        houseNumberValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        houseNumberValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jScrollPane6.setViewportView(houseNumberValueLabel);

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));

        descriptionValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        descriptionValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jScrollPane8.setViewportView(descriptionValueLabel);

        jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));

        postcodeValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        postcodeValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jScrollPane9.setViewportView(postcodeValueLabel);

        jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));

        streetNameValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        streetNameValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jScrollPane10.setViewportView(streetNameValueLabel);

        PersonLinkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person", "Link"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PersonLinkTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(PersonLinkTable);
        if (PersonLinkTable.getColumnModel().getColumnCount() > 0) {
            PersonLinkTable.getColumnModel().getColumn(1).setMinWidth(400);
        }

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 17)); // NOI18N
        jButton1.setText("Delete Event");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(endDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(countryLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PostcodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(streetNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(houseNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(descriptionLabel)
                    .addComponent(startDateLabel)
                    .addComponent(endDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addComponent(jScrollPane5)
                        .addComponent(jScrollPane4)
                        .addComponent(jScrollPane3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryLabel)
                            .addComponent(PostcodeLabel)
                            .addComponent(streetNameLabel)
                            .addComponent(houseNumberLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(jScrollPane9)
                            .addComponent(jScrollPane6)))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * If another year gets selected redraw the time line.
     *
     * @param evt
     */
    private void yearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBoxActionPerformed
        if (this.getYearComboBox().getSelectedItem() != null && this.selectedYear != 0 && Integer.parseInt((String) this.getYearComboBox().getSelectedItem()) != this.selectedYear) {
            drawNewTimeLine(Integer.parseInt((String) this.getYearComboBox().getSelectedItem()));
            deleteAllInformationOfLabels();
        }
    }//GEN-LAST:event_yearComboBoxActionPerformed

    /**
     * When the person clickes the deleteButton, than the selected event will be
     * deleted.
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (getTitleValueLabel() != null && this.getTitleValueLabel().getText() != null && !this.getTitleValueLabel().getText().trim().isEmpty()) {
            this.getService().removeEvent(getTitleValueLabel().getText());
            //drawNewTimeLine(Integer.parseInt((String) this.getYearComboBox().getSelectedItem()));
            drawNewTimeLineWithLastSelectedYear();
            JOptionPane.showMessageDialog(null, "Event is deleted", "Event deleted now.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Draws a new time line with the last selected year.
     */
    public void drawNewTimeLineWithLastSelectedYear() {
        this.drawNewTimeLine(Integer.parseInt((String) this.getYearComboBox().getSelectedItem()));
    }

    /**
     * Draws a new time line of the given year
     *
     * @param year
     */
    private void drawNewTimeLine(int year) {
        this.setSelectedYear(year);
        this.setEventsOfYear(service.getAllEventsOfYear(year));
        this.getTimeline().setYear(this.getSelectedYear());
        this.getTimeline().setAllEvents(this.getEventsOfYear());
        this.getTimeline().repaint();
        for (JLabel label : this.allEventLabels) {
            this.getTimeline().remove(label);
        }
        this.allEventLabels = new ArrayList<>();
        this.drawEvents(this.getEventsOfYear());
    }

    /**
     * Gets the table with persons and their link to the event.
     *
     * @return JTable with persons and their links
     */
    private JTable getPersonLinkTable() {
        return PersonLinkTable;
    }

    /**
     * Sets the personLinkTable.
     *
     * @param PersonLinkTable
     */
    private void setPersonLinkTable(JTable PersonLinkTable) {
        this.PersonLinkTable = PersonLinkTable;
    }

    /**
     * Inserts a row in the personLinkTable
     *
     * @param person person for the first column
     * @param link link with the person and the event in the second column
     */
    public void insertRowInPersonLinkTable(String person, String link) {
        DefaultTableModel model = (DefaultTableModel) this.getPersonLinkTable().getModel();
        model.addRow(new Object[]{person, link});
    }

    /**
     * Delete all the contents of the personLinktable
     */
    public void deletePersonLinkTableContents() {
        DefaultTableModel dm = (DefaultTableModel) this.getPersonLinkTable().getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }

    /**
     * Deletes all the contents in the information labels.
     */
    private void deleteAllInformationOfLabels() {
        getTitleValueLabel().setText("");
        getDescriptionValueLabel().setText("");
        getStartDateValueLabel().setText("");
        getEndDateValueLabel().setText("");
        getCountryValueLabel().setText("");
        getPostcodeValueLabel().setText("");
        getStreetNameValueLabel().setText("");
        getHouseNumberValueLabel().setText("");
        deletePersonLinkTableContents();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PersonLinkTable;
    private javax.swing.JLabel PostcodeLabel;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JLabel countryValueLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel descriptionValueLabel;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JLabel endDateValueLabel;
    private javax.swing.JLabel houseNumberLabel;
    private javax.swing.JLabel houseNumberValueLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel postcodeValueLabel;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JLabel startDateValueLabel;
    private javax.swing.JLabel streetNameLabel;
    private javax.swing.JLabel streetNameValueLabel;
    private uk.ac.cardiffmet.st20131041.ui.Timeline timeline;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel titleValueLabel;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables
}
