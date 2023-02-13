/**
 * EIM, Copyright 2014 Denis Meyer
 */
package com.eim.ui;

import com.eim.util.EIMConstants;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.eim.db.EIMI18N;
import com.eim.img.EIMImage;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

/**
 * EIMAboutUI
 *
 * @author Denis Meyer
 */
public class EIMAboutUI extends JDialog {

    private static final Logger logger = LogManager.getLogger(EIMAboutUI.class.getName());

    public EIMAboutUI(JFrame owner) {
        super(owner);

        if (logger.isDebugEnabled()) {
            logger.debug("Initializing EIMAbout");
        }

        this.setUndecorated(true);

        initComponents();

        this.setTitle(EIMI18N.getInstance().getString("About"));
        this.label_copyright.setText(EIMI18N.getInstance().getString("Copyright"));
        this.label_version.setText(EIMI18N.getInstance().getString("Version"));
        this.label_versionNumber.setText(EIMConstants.VERSION);

        try {
            this.setIconImage(EIMImage.getInstance().getImageIcon(EIMConstants.getImagePath(EIMConstants.IMAGE.IMG_ICON)).getImage());
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException: " + e.getMessage());
        }

        try {
            this.label_logo.setText("");
            this.label_logo.setIcon(EIMImage.getInstance().getImageIcon(EIMConstants.getImagePath(EIMConstants.IMAGE.IMG_LOGO_WO_BG)));
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException: " + e.getMessage());
            this.label_logo.setText(EIMI18N.getInstance().getString("EIM"));
        }

        this.setLocationRelativeTo(null);

        addListener();
    }

    private void addListener() {
        final JDialog _this = this;
        KeyAdapter escapePressed = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                _this.setVisible(false);
            }
        };
        MouseAdapter mouseReleased = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                _this.setVisible(false);
            }
        };
        this.addKeyListener(escapePressed);
        this.addMouseListener(mouseReleased);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_main = new javax.swing.JPanel();
        panel_logo = new javax.swing.JPanel();
        label_logo = new javax.swing.JLabel();
        panel_version = new javax.swing.JPanel();
        label_version = new javax.swing.JLabel();
        label_versionNumber = new javax.swing.JLabel();
        panel_copyright = new javax.swing.JPanel();
        label_copyright = new javax.swing.JLabel();
        label_copyrightNames = new javax.swing.JLabel();

        setTitle("About");
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(290, 231));
        setMinimumSize(new java.awt.Dimension(290, 231));
        setModal(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(290, 231));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        panel_main.setBackground(new java.awt.Color(200, 200, 200));
        panel_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_main.setLayout(new java.awt.GridBagLayout());

        panel_logo.setBackground(new java.awt.Color(200, 200, 200));

        label_logo.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        label_logo.setText("LOGO");
        label_logo.setMaximumSize(new java.awt.Dimension(190, 90));
        label_logo.setMinimumSize(new java.awt.Dimension(190, 90));
        label_logo.setPreferredSize(new java.awt.Dimension(190, 90));
        panel_logo.add(label_logo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panel_main.add(panel_logo, gridBagConstraints);

        panel_version.setBackground(new java.awt.Color(200, 200, 200));
        panel_version.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        panel_version.setLayout(new java.awt.GridBagLayout());

        label_version.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        label_version.setText("Version");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        panel_version.add(label_version, gridBagConstraints);

        label_versionNumber.setText("VERSION");
        label_versionNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_version.add(label_versionNumber, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 5.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panel_main.add(panel_version, gridBagConstraints);

        panel_copyright.setBackground(new java.awt.Color(200, 200, 200));
        panel_copyright.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        panel_copyright.setLayout(new java.awt.GridBagLayout());

        label_copyright.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        label_copyright.setText("Copyright");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        panel_copyright.add(label_copyright, gridBagConstraints);

        label_copyrightNames.setText("2014 Denis Meyer");
        label_copyrightNames.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panel_copyright.add(label_copyrightNames, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 5.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panel_main.add(panel_copyright, gridBagConstraints);

        getContentPane().add(panel_main);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label_copyright;
    private javax.swing.JLabel label_copyrightNames;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_version;
    private javax.swing.JLabel label_versionNumber;
    private javax.swing.JPanel panel_copyright;
    private javax.swing.JPanel panel_logo;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_version;
    // End of variables declaration//GEN-END:variables
}