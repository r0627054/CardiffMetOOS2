package uk.ac.cardiffmet.st20131041.ui;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Panel is used for displaying one option. This panel is used in the navigation
 * bar panel.
 *
 * @author Dries Janse
 * @version 1.0
 */
public class OptionPanel extends javax.swing.JPanel {

    /**
     * The default color the panel has.
     */
    private final Color defaultPanelColor = new Color(119, 171, 89);
    
    /**
     * The default color the panel has when hovering
     */
    private final Color defaultHoverPanelColor = new Color(201, 223, 138);
    
    /**
     * The default color the panel has when clicked.
     */
    private final Color defaultClickedPanelColor = new Color(54, 128, 45);
    
    /**
     * The default text the panel has.
     */
    private String labelText = "Label text";
    
    /**
     * The default Icon the panel has.
     */
    private ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("uk/ac/cardiffmet/st20131041/resources/add-contacts.png"));

    /**
     * Creates new form OptionPanel and initializes all its components. This
     * constructor is not used in the program execution. It is only used in the
     * Netbeans idea, for the designing.
     */
    public OptionPanel() {
        createIcon("uk/ac/cardiffmet/st20131041/resources/add-contacts.png");
        initComponents();
    }

    /**
     * Creates new form OptionPanel and initializes all its components. It uses
     * the text for displaying it in the label, and the sourcepath of the image.
     *
     * @param labelText text used for displaying the option.
     * @param path path to the image
     */
    public OptionPanel(String labelText, String path) {
        this.setLabelText(labelText);
        this.createIcon(path);
        this.initComponents();
    }

    /**
     * Sets the default color as background.
     */
    public void setDefaultColor() {
        this.setBackground(this.defaultPanelColor);
    }

    /**
     * Sets the default hover color as background.
     */
    public void setDefaultHoverColor() {
        this.setBackground(this.defaultHoverPanelColor);
    }

    /**
     * Sets the default clicked color as default
     */
    public void setDefaultClickedPanelColor() {
        this.setBackground(this.defaultClickedPanelColor);
    }

    /**
     * Gets the labelText.
     */
    public String getLabelText() {
        return labelText;
    }

    /**
     * Sets the labelText
     *
     * @param labelText
     */
    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    /**
     * Gets the ImageIcon
     *
     * @return the ImageIcon
     */
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Sets the ImageIcon
     *
     * @param icon
     */
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    /**
     * Sets the icon that can be found with the following relative path.
     *
     * @param path
     */
    private void createIcon(String path) {
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(path)));
    }

    /**
     * Gets the default Color.
     *
     * @return the default Color
     */
    public Color getDefaultPanelColor() {
        return defaultPanelColor;
    }

    /**
     * Gets the default hover color.
     *
     * @return the default hover color.
     */
    public Color getDefaultHoverPanelColor() {
        return defaultHoverPanelColor;
    }

    /**
     * Gets the default Clicked color.
     *
     * @return the default clicked color.
     */
    public Color getDefaultClickedPanelColor() {
        return defaultClickedPanelColor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addEventIcon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(119, 171, 89));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText(this.getLabelText());

        addEventIcon.setIcon(this.getIcon());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(addEventIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(addEventIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addEventIcon;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
