package uk.ac.cardiffmet.st20131041.ui;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import uk.ac.cardiffmet.st20131041.domain.model.DomainException;
import uk.ac.cardiffmet.st20131041.domain.service.EventService;

/**
 * Panel with information, you can upload and download the data.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class InformationPanel extends javax.swing.JPanel {

    /**
     * The service that is used for the events.
     */
    private EventService service;

    /**
     * Creates new InformationPanel and initializes all its components. This
     * constructor is not used in the program execution. It is only used in the
     * Netbeans idea, for the designing.
     */
    public InformationPanel() {
        this.service = new EventService("MEMORY");
        initComponents();
        this.fileChoosersInitialise();
    }

    public InformationPanel(EventService service) {
        this.service = service;
        initComponents();
        this.fileChoosersInitialise();
    }

    private EventService getService() {
        return service;
    }

    private void fileChoosersInitialise() {
        this.saveFileChooser.setDialogTitle("Save all events!");
        this.saveFileChooser.setAcceptAllFileFilterUsed(false);
        this.saveFileChooser.addChoosableFileFilter(new FileTypeFilter(".json", "JSON file"));
        this.uploadFileChooser.setDialogTitle("Upload a data file!");
        FileNameExtensionFilter jsonFilter = new FileNameExtensionFilter("json files (*.json)", "json");
        this.uploadFileChooser.addChoosableFileFilter(jsonFilter);
        this.uploadFileChooser.setFileFilter(jsonFilter);
        this.uploadFileChooser.setAcceptAllFileFilterUsed(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uploadFileChooser = new javax.swing.JFileChooser();
        saveFileChooser = new javax.swing.JFileChooser();
        titleLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        titleLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        titleLabel.setText("Export event/user data");

        saveButton.setFont(new java.awt.Font("Yu Gothic UI", 3, 18)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        uploadButton.setFont(new java.awt.Font("Yu Gothic UI", 3, 18)); // NOI18N
        uploadButton.setText("Upload");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        titleLabel1.setFont(new java.awt.Font("Yu Gothic UI", 3, 17)); // NOI18N
        titleLabel1.setText("Import event/user data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uploadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(333, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(titleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed

        try {
            this.uploadFileChooser.showOpenDialog(null);
            File f;
            f = this.uploadFileChooser.getSelectedFile();
            //this.getService().getAllEventsOfFile(f);
            this.getService().saveAllEventsOfFile(f);
            JOptionPane.showMessageDialog(null, "Events where successfully uploaded!", "Upload success", JOptionPane.INFORMATION_MESSAGE);
        } catch (DomainException e) {
            JOptionPane.showMessageDialog(null, "We could not upload the file, please try again!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_uploadButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        this.saveFileChooser.showSaveDialog(null);
        try {
            File file = this.saveFileChooser.getSelectedFile();
            File fileWithExtension = new File(file.toString() + ".json");

            FileWriter fw = new FileWriter(fileWithExtension.getPath());
            fw.write(service.writeAllEvents());
            fw.flush();
            fw.close();
            JOptionPane.showMessageDialog(null, "File successfully saved", "Saving success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "We could not save the file, please try again!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton saveButton;
    private javax.swing.JFileChooser saveFileChooser;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JButton uploadButton;
    private javax.swing.JFileChooser uploadFileChooser;
    // End of variables declaration//GEN-END:variables
}
