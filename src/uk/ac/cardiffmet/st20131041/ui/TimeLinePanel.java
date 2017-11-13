/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.cardiffmet.st20131041.ui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import uk.ac.cardiffmet.st20131041.domain.model.Event;
import uk.ac.cardiffmet.st20131041.domain.service.EventService;

/**
 *
 * @author Dries Janse
 */
public class TimeLinePanel extends javax.swing.JPanel {

    private EventService service;
    private int selectedYear = 0;
    private ArrayList<Event> EventsOfYear;
    private ArrayList<JLabel> allEventLabels = new ArrayList<JLabel>();

    /**
     * Creates new form TimeLinePanel
     */
    public TimeLinePanel() {
        initComponents();
        loadYearsInComboBox();
    }

    public TimeLinePanel(EventService service) {
        this.setService(service);
        this.setEventsOfYear(service.getAllEventsOfYear(this.getInitialYear()));
        this.setSelectedYear(this.getInitialYear());
        initComponents();
        loadYearsInComboBox();
        drawEvents(this.getEventsOfYear());
    }

    public int getInitialYear() {
        if (this.getService().getAllDifferentYears().size() == 0) {
            return 2017;
        } else {
            return this.getService().getAllDifferentYears().get(0);
        }
    }

    private EventService getService() {
        return service;
    }

    private void setService(EventService service) {
        this.service = service;
    }

    public ArrayList<Event> getEventsOfYear() {
        return EventsOfYear;
    }

    public void setEventsOfYear(ArrayList<Event> EventsOfYear) {
        this.EventsOfYear = EventsOfYear;
    }

    public void loadYearsInComboBox() {
        this.getYearComboBox().removeAllItems();
        for (int s : this.getService().getAllDifferentYears()) {
            this.getYearComboBox().addItem(Integer.toString(s));
        }
    }

    private JComboBox<String> getYearComboBox() {
        return yearComboBox;
    }

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

    public Timeline getTimeline() {
        return timeline;
    }

    private int getSelectedYear() {
        return selectedYear;
    }

    private void setSelectedYear(int selectedYear) {
        this.selectedYear = selectedYear;
    }

    public JLabel getDescriptionValueLabel() {
        return descriptionValueLabel;
    }

    public JLabel getTitleValueLabel() {
        return titleValueLabel;
    }

    public JLabel getCountryValueLabel() {
        return countryValueLabel;
    }

    public JLabel getEndDateValueLabel() {
        return endDateValueLabel;
    }

    public JLabel getHouseNumberValueLabel() {
        return houseNumberValueLabel;
    }

    public JLabel getPostcodeValueLabel() {
        return postcodeValueLabel;
    }

    public JLabel getStartDateValueLabel() {
        return startDateValueLabel;
    }

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

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout timelineLayout = new javax.swing.GroupLayout(timeline);
        timeline.setLayout(timelineLayout);
        timelineLayout.setHorizontalGroup(
            timelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9000, Short.MAX_VALUE)
        );
        timelineLayout.setVerticalGroup(
            timelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9000, Short.MAX_VALUE)
        );

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
        countryValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        jScrollPane2.setViewportView(countryValueLabel);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        titleValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        jScrollPane3.setViewportView(titleValueLabel);

        endDateLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        endDateLabel.setText("End Date");

        startDateLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        startDateLabel.setText("Start date");

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        endDateValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        endDateValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        jScrollPane4.setViewportView(endDateValueLabel);

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        startDateValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        startDateValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
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
        houseNumberValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        jScrollPane6.setViewportView(houseNumberValueLabel);

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));

        descriptionValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        descriptionValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        jScrollPane8.setViewportView(descriptionValueLabel);

        jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));

        postcodeValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        postcodeValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        jScrollPane9.setViewportView(postcodeValueLabel);

        jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));

        streetNameValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        streetNameValueLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        jScrollPane10.setViewportView(streetNameValueLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(countryLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(PostcodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(startDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(endDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(streetNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(houseNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(descriptionLabel)
                    .addComponent(startDateLabel)
                    .addComponent(endDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PostcodeLabel)
                            .addComponent(countryLabel)
                            .addComponent(streetNameLabel)
                            .addComponent(houseNumberLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void yearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBoxActionPerformed
        if (this.getYearComboBox().getSelectedItem() != null && this.selectedYear != 0 && Integer.parseInt((String) this.getYearComboBox().getSelectedItem()) != this.selectedYear) {
            drawNewTimeLine(Integer.parseInt((String) this.getYearComboBox().getSelectedItem()));
        }
    }//GEN-LAST:event_yearComboBoxActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PostcodeLabel;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JLabel countryValueLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel descriptionValueLabel;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JLabel endDateValueLabel;
    private javax.swing.JLabel houseNumberLabel;
    private javax.swing.JLabel houseNumberValueLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
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
