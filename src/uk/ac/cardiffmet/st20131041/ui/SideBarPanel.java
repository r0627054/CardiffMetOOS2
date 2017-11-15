package uk.ac.cardiffmet.st20131041.ui;

import java.util.ArrayList;

/**
 * Panel used as side bar in the application Frame.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class SideBarPanel extends javax.swing.JPanel {

    /**
     * Creates new form SideBarPanel -initialises all the components
     * -initialises all the panels
     */
    public SideBarPanel() {
        initComponents();
        initAllPanels();
    }

    /**
     * Gets the addEventPanel
     *
     * @return addEventPanel
     */
    public OptionPanel getAddEventPanel() {
        return addEventPanel;
    }

    /**
     * Gets the addPersonPanel
     *
     * @return addPersonPanel
     */
    public OptionPanel getAddPersonPanel() {
        return addPersonPanel;
    }

    /**
     * Gets the informationPanel
     *
     * @return InformationPanel
     */
    public OptionPanel getInformationPanel() {
        return informationPanel;
    }

    /**
     * Gets the showTimeLinePanel
     *
     * @return showTimeLinePanel
     */
    public OptionPanel getShowTimeLinePanel() {
        return showTimeLinePanel;
    }

    /**
     * Sets the addEventPanel to its default color.
     */
    public void setAddEventPanelDefaultColor() {
        this.setDefaultPanelColor(this.getAddEventPanel());
    }

    /**
     * Sets the addEventPanel to its default hover color.
     */
    public void setAddEventPanelDefaultHoverColor() {
        this.setDefaultHoverPanelColor(this.getAddEventPanel());
    }

    /**
     * Sets the addEventPanel to its default clicked color.
     */
    public void setAddEventPanelClickedColor() {
        this.getAddEventPanel().setDefaultClickedPanelColor();
    }

    /**
     * Sets the addPersonPanel to its default color.
     */
    public void setAddPersonPanelDefaultColor() {
        this.setDefaultPanelColor(this.getAddPersonPanel());
    }

    /**
     * Sets the addPersonPanel to its default hover color.
     */
    public void setAddPersonPanelDefaultHoverColor() {
        this.setDefaultHoverPanelColor(this.getAddPersonPanel());
    }

    /**
     * Sets the addPersonPanel to its default clicked color.
     */
    public void setAddPersonPanelClickedColor() {
        this.getAddPersonPanel().setDefaultClickedPanelColor();
    }

    /**
     * Sets the informationPanel to its default color.
     */
    public void setInformationPanelDefaultColor() {
        this.setDefaultPanelColor(this.getInformationPanel());
    }

    /**
     * Sets the informationPanel to its default hover color.
     */
    public void setInformationPanelDefaultHoverColor() {
        this.setDefaultHoverPanelColor(this.getInformationPanel());
    }

    /**
     * Sets the informationPanel to its default clicked color.
     */
    public void setInformationPanelClickedColor() {
        this.getInformationPanel().setDefaultClickedPanelColor();
    }

    /**
     * Sets the showTimeLinePanel to its default color.
     */
    public void setShowTimeLinePanelDefaultColor() {
        this.setDefaultPanelColor(this.getShowTimeLinePanel());
    }

    /**
     * Sets the showTimeLinePanel to its default hover color.
     */
    public void setShowTimeLinePanelDefaultHoverColor() {
        this.setDefaultHoverPanelColor(this.getShowTimeLinePanel());
    }

    /**
     * Sets the showTimeLinePanel to its default clicked color.
     */
    public void setShowTimeLinePanelClickedColor() {
        this.getShowTimeLinePanel().setDefaultClickedPanelColor();
    }

    /**
     * add all panels to the allPanelsArray.
     */
    private void initAllPanels() {
        allPanels = new ArrayList();
        allPanels.add(this.getAddEventPanel());
        allPanels.add(this.getAddPersonPanel());
        allPanels.add(this.getInformationPanel());
        allPanels.add(this.getShowTimeLinePanel());
    }

    /**
     * Get all the panels in the ArrayList
     *
     * @return the allPanels ArrayList
     */
    private ArrayList<OptionPanel> getAllPanels() {
        return this.allPanels;
    }

    /**
     * Sets all the panels to their default color.
     */
    public void setAllPanelsDefaultColor() {
        for (OptionPanel panel : this.getAllPanels()) {
            panel.setDefaultColor();
        }
    }

    /**
     * Sets the given panel to their default color.
     *
     * @param p the given panel to set to their default color.
     */
    private void setDefaultPanelColor(OptionPanel p) {
        if (p.getDefaultClickedPanelColor() != p.getBackground()) {
            p.setDefaultColor();
        }
    }

    /**
     * Sets the given panel to their default hover color.
     *
     * @param p the given panel to set their default hover color.
     */
    private void setDefaultHoverPanelColor(OptionPanel p) {
        if (p.getDefaultClickedPanelColor() != p.getBackground()) {
            p.setDefaultHoverColor();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        addEventPanel = new uk.ac.cardiffmet.st20131041.ui.OptionPanel("Add Event", "uk/ac/cardiffmet/st20131041/resources/square-add-button.png");
        addPersonPanel = new uk.ac.cardiffmet.st20131041.ui.OptionPanel("Add Person", "uk/ac/cardiffmet/st20131041/resources/add-contacts.png");
        showTimeLinePanel = new uk.ac.cardiffmet.st20131041.ui.OptionPanel("Show Timeline", "uk/ac/cardiffmet/st20131041/resources/timeline.png");
        informationPanel = new uk.ac.cardiffmet.st20131041.ui.OptionPanel("Extra information", "uk/ac/cardiffmet/st20131041/resources/information.png");

        setBackground(new java.awt.Color(35, 77, 32));

        appTitle.setBackground(new java.awt.Color(213, 213, 213));
        appTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        appTitle.setForeground(new java.awt.Color(38, 38, 38));
        appTitle.setText("Dries App");

        jLabel1.setText("________________________");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(appTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addGap(59, 59, 59))))
            .addComponent(addPersonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(showTimeLinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addEventPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(appTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addComponent(addEventPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addPersonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showTimeLinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(informationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private ArrayList<OptionPanel> allPanels;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private uk.ac.cardiffmet.st20131041.ui.OptionPanel addEventPanel;
    private uk.ac.cardiffmet.st20131041.ui.OptionPanel addPersonPanel;
    private javax.swing.JLabel appTitle;
    private uk.ac.cardiffmet.st20131041.ui.OptionPanel informationPanel;
    private javax.swing.JLabel jLabel1;
    private uk.ac.cardiffmet.st20131041.ui.OptionPanel showTimeLinePanel;
    // End of variables declaration//GEN-END:variables
}
