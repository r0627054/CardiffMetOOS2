/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.cardiffmet.st20131041.ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Dries Janse
 */
public class AppFrame extends javax.swing.JFrame {

    /**
     * Creates new form AppFrame
     */
    public AppFrame() {
        initComponents();
        addListeners();
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
    }

    private void informationPanelMouseEntered(java.awt.event.MouseEvent evt) {
        this.getSideBarPanel1().setInformationPanelDefaultHoverColor();
    }

    private void informationPanelMouseExited(java.awt.event.MouseEvent evt) {
       this.getSideBarPanel1().setInformationPanelDefaultColor();
    }

    public HeaderPanel getHeaderPanel1() {
        return headerPanel1;
    }

    public SideBarPanel getSideBarPanel1() {
        return sideBarPanel1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBarPanel1 = new uk.ac.cardiffmet.st20131041.ui.SideBarPanel();
        headerPanel1 = new uk.ac.cardiffmet.st20131041.ui.HeaderPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(857, 587));

        javax.swing.GroupLayout headerPanel1Layout = new javax.swing.GroupLayout(headerPanel1);
        headerPanel1.setLayout(headerPanel1Layout);
        headerPanel1Layout.setHorizontalGroup(
            headerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
        headerPanel1Layout.setVerticalGroup(
            headerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideBarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(headerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sideBarPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private uk.ac.cardiffmet.st20131041.ui.HeaderPanel headerPanel1;
    private uk.ac.cardiffmet.st20131041.ui.SideBarPanel sideBarPanel1;
    // End of variables declaration//GEN-END:variables
}
