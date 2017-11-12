package uk.ac.cardiffmet.st20131041.ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import uk.ac.cardiffmet.st20131041.domain.model.DomainException;
import uk.ac.cardiffmet.st20131041.domain.model.Person;
import uk.ac.cardiffmet.st20131041.domain.service.EventService;

/**
 *
 * @author Dries Janse
 */
public class AppFrame extends javax.swing.JFrame {

    private EventService service;
    
    /**
     * Creates new form AppFrame
     */
    public AppFrame() {
        initComponents();
        addListeners();
    }
    
    public AppFrame(EventService service){
        this.setService(service);
        this.initComponents();
        this.addListeners();
        this.getSideBarPanel1().setAddEventPanelClickedColor();
    }

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
    
    private void addEventPanelMouseClicked(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAllPanelsDefaultColor();
        this.getSideBarPanel1().setAddEventPanelClickedColor();
        this.swapPanel(addEventPanel);
        addEventPanel.loadComboBoxNicknames();
    }

    private void addEventPanelMouseEntered(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAddEventPanelDefaultHoverColor();
    }

    private void addEventPanelMouseExited(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAddEventPanelDefaultColor();
    }

    private void addPersonPanelMouseClicked(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAllPanelsDefaultColor();
        this.getSideBarPanel1().setAddPersonPanelClickedColor();
        this.swapPanel(addPersonPanel);
    }
        
    private void addPersonPanelMouseEntered(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAddPersonPanelDefaultHoverColor();
    }

    private void addPersonPanelMouseExited(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAddPersonPanelDefaultColor();
    }

    private void showTimeLinePanelMouseClicked(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAllPanelsDefaultColor();
        this.getSideBarPanel1().setShowTimeLinePanelClickedColor();
        this.swapPanel(timeLinePanel);
        timeLinePanel.loadYearsInComboBox();
    }

    private void showTimeLinePanelMouseEntered(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setShowTimeLinePanelDefaultHoverColor();
    }

    private void showTimeLinePanelMouseExited(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setShowTimeLinePanelDefaultColor();
    }

    private void informationPanelMouseClicked(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setAllPanelsDefaultColor();
        this.getSideBarPanel1().setInformationPanelClickedColor();
        this.swapPanel(informationPanel);
    }

    private void informationPanelMouseEntered(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setInformationPanelDefaultHoverColor();
    }

    private void informationPanelMouseExited(java.awt.event.MouseEvent evt) {
       this.getSideBarPanel1().setInformationPanelDefaultColor();
    }

    public HeaderPanel getHeaderPanel1() {
        return headerPanel;
    }

    public SideBarPanel getSideBarPanel1() {
        return sideBarPanel;
    }

    public AddPersonPanel getAddPersonPanel1() {
        return addPersonPanel;
    }

    public EventService getService() {
        return service;
    }

    private void setService(EventService service) {
        this.service = service;
    }
    
    private void swapPanel(JPanel p){
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
        informationPanel = new uk.ac.cardiffmet.st20131041.ui.InformationPanel();
        timeLinePanel = new uk.ac.cardiffmet.st20131041.ui.TimeLinePanel(this.getService());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(857, 587));

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
        mainAreaPanel.setLayout(new java.awt.CardLayout());
        mainAreaPanel.add(addEventPanel, "card3");
        mainAreaPanel.add(addPersonPanel, "card2");
        mainAreaPanel.add(informationPanel, "card5");
        mainAreaPanel.add(timeLinePanel, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainAreaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(mainAreaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
