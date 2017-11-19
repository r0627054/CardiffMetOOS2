package uk.ac.cardiffmet.st20131041.ui;

import javax.swing.JPanel;

import uk.ac.cardiffmet.st20131041.domain.service.EventService;

/**
 * JFrame that is used as Facade class for the ui. It holds all the used panels.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class AppFrame extends javax.swing.JFrame {

    /**
     * The service that is used for the events.
     */
    private EventService service;

    /**
     * Creates new AppFrame and initializes all its components. This constructor
     * is not used in the program execution. It is only used in the Netbeans
     * idea, for the designing.
     */
    public AppFrame() {
        initComponents();
        addListeners();
    }

    /**
     * Creates new AppFrame it adds all the listeners to the navigation bar.
     * -sets all the listeners -initialises the compontens -sets the title of
     * the frame
     *
     * @param service
     */
    public AppFrame(EventService service) {
        this.setService(service);
        this.initComponents();
        this.addListeners();
        this.getSideBarPanel1().setAddEventPanelClickedColor();
        this.setTitle("Timeline application of Dries Janse");
    }

    /**
     * Creates all the listeners used in the navigation bar.
     */
    public void addListeners() {
        this.getSideBarPanel1().getAddEventPanel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addEventPanelMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addEventPanelMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                addEventPanelMouseExited(evt);
            }
        });
        this.getSideBarPanel1().getAddPersonPanel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPersonPanelMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addPersonPanelMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                addPersonPanelMouseExited(evt);
            }
        });
        this.getSideBarPanel1().getShowTimeLinePanel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                showTimeLinePanelMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showTimeLinePanelMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                showTimeLinePanelMouseExited(evt);
            }
        });
        this.getSideBarPanel1().getInformationPanel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                informationPanelMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                informationPanelMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                informationPanelMouseExited(evt);
            }
        });
    }

    /**
     * When the addEventPanel is selected, color all the other panels in their
     * default colour. Put the button in the default clicked color. Swap the
     * panels
     *
     * @param evt
     */
    private void addEventPanelMouseClicked(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAllPanelsDefaultColor();
        this.getSideBarPanel1().setAddEventPanelClickedColor();
        this.swapPanel(addEventPanel);
        addEventPanel.loadComboBoxNicknames();
    }

    /**
     * When the mouse enters the panel, the panel will be set to the default
     * hover color.
     *
     * @param evt
     */
    private void addEventPanelMouseEntered(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAddEventPanelDefaultHoverColor();
    }

    /**
     * When the mouse enters the panel, the panel will be set to the default
     * hover color.
     *
     * @param evt
     */
    private void addEventPanelMouseExited(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAddEventPanelDefaultColor();
    }

    /**
     * When the addPersonPanel is selected, color all the other panels in their
     * default colour. Put the button in the default clicked color. Swap the
     * panels
     *
     * @param evt
     */
    private void addPersonPanelMouseClicked(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAllPanelsDefaultColor();
        this.getSideBarPanel1().setAddPersonPanelClickedColor();
        this.swapPanel(addPersonPanel);
    }

    /**
     * When the mouse enters the panel, the panel will be set to the default
     * hover color.
     *
     * @param evt
     */
    private void addPersonPanelMouseEntered(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAddPersonPanelDefaultHoverColor();
    }

    /**
     * When the mouse enters the panel, the panel will be set to the default
     * hover color.
     *
     * @param evt
     */
    private void addPersonPanelMouseExited(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAddPersonPanelDefaultColor();
    }

    /**
     * When the showTimeLinePanel is selected, color all the other panels in
     * their default colour. Put the button in the default clicked color. Swap
     * the panels Load all the years into the panel Draw an up to date timeline
     *
     * @param evt
     */
    private void showTimeLinePanelMouseClicked(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAllPanelsDefaultColor();
        this.getSideBarPanel1().setShowTimeLinePanelClickedColor();
        this.swapPanel(timeLinePanel);
        timeLinePanel.loadYearsInComboBox();
        timeLinePanel.drawNewTimeLineWithLastSelectedYear();
    }

    /**
     * When the mouse enters the panel, the panel will be set to the default
     * hover color.
     *
     * @param evt
     */
    private void showTimeLinePanelMouseEntered(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setShowTimeLinePanelDefaultHoverColor();
    }

    /**
     * When the mouse enters the panel, the panel will be set to the default
     * hover color.
     *
     * @param evt
     */
    private void showTimeLinePanelMouseExited(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setShowTimeLinePanelDefaultColor();
    }

    /**
     * When the showTimeLinePanel is selected, color all the other panels in
     * their default colour. Put the button in the default clicked color. Swap
     * the panels
     *
     * @param evt
     */
    private void informationPanelMouseClicked(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAllPanelsDefaultColor();
        this.getSideBarPanel1().setInformationPanelClickedColor();
        this.swapPanel(informationPanel);
    }

    /**
     * When the mouse enters the panel, the panel will be set to the default
     * hover color.
     *
     * @param evt
     */
    private void informationPanelMouseEntered(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setInformationPanelDefaultHoverColor();
    }

    /**
     * When the mouse enters the panel, the panel will be set to the default
     * hover color.
     *
     * @param evt
     */
    private void informationPanelMouseExited(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setInformationPanelDefaultColor();
    }

    /**
     * Gets the headerPanel
     *
     * @return the headerPanel
     */
    public HeaderPanel getHeaderPanel1() {
        return headerPanel;
    }

    /**
     * Gets the sideBarPanel
     *
     * @return gets the sideBarPanel
     */
    public SideBarPanel getSideBarPanel1() {
        return sideBarPanel;
    }

    /**
     * Gets the addPersonPanel
     *
     * @return the addPersonPanel
     */
    public AddPersonPanel getAddPersonPanel1() {
        return addPersonPanel;
    }

    /**
     * Gets the service (model)
     *
     * @return the service (model)
     */
    public EventService getService() {
        return service;
    }

    /**
     * Sets the service
     *
     * @param service
     */
    private void setService(EventService service) {
        this.service = service;
    }

    /**
     * SwapPanel will set the given panel visible and put the others to the
     * background.
     *
     * @param p
     */
    private void swapPanel(JPanel p) {
        this.mainAreaPanel.removeAll();
        this.mainAreaPanel.add(p);
        this.mainAreaPanel.repaint();
        this.mainAreaPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBarPanel = new uk.ac.cardiffmet.st20131041.ui.SideBarPanel();
        headerPanel = new uk.ac.cardiffmet.st20131041.ui.HeaderPanel();
        mainAreaPanel = new javax.swing.JPanel();
        addEventPanel = new uk.ac.cardiffmet.st20131041.ui.AddEventPanel(this.getService());
        addPersonPanel = new uk.ac.cardiffmet.st20131041.ui.AddPersonPanel(this.getService());
        timeLinePanel = new uk.ac.cardiffmet.st20131041.ui.TimeLinePanel(this.getService());
        informationPanel = new uk.ac.cardiffmet.st20131041.ui.InformationPanel(this.getService());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 875));
        setPreferredSize(new java.awt.Dimension(1200, 875));

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        mainAreaPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainAreaPanel.setMinimumSize(new java.awt.Dimension(880, 640));
        mainAreaPanel.setLayout(new java.awt.CardLayout());

        addEventPanel.setMinimumSize(new java.awt.Dimension(1000, 736));
        addEventPanel.setPreferredSize(new java.awt.Dimension(1000, 744));
        mainAreaPanel.add(addEventPanel, "card3");
        mainAreaPanel.add(addPersonPanel, "card2");
        mainAreaPanel.add(timeLinePanel, "card5");
        mainAreaPanel.add(informationPanel, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainAreaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(mainAreaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE))
                    .addComponent(sideBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private uk.ac.cardiffmet.st20131041.ui.AddEventPanel addEventPanel;
    private uk.ac.cardiffmet.st20131041.ui.AddPersonPanel addPersonPanel;
    private uk.ac.cardiffmet.st20131041.ui.HeaderPanel headerPanel;
    private uk.ac.cardiffmet.st20131041.ui.InformationPanel informationPanel;
    private javax.swing.JPanel mainAreaPanel;
    private uk.ac.cardiffmet.st20131041.ui.SideBarPanel sideBarPanel;
    private uk.ac.cardiffmet.st20131041.ui.TimeLinePanel timeLinePanel;
    // End of variables declaration//GEN-END:variables
}
