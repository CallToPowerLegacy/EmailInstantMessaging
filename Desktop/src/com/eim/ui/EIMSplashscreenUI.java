/**
 * EIM, Copyright 2014 Denis Meyer
 */
package com.eim.ui;

import com.eim.db.EIMI18N;
import com.eim.img.EIMImage;
import com.eim.ui.components.EIMBubbleBorder;
import com.eim.util.EIMConstants;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * EIMSplashscreenUI
 *
 * @author Denis Meyer
 */
public final class EIMSplashscreenUI extends javax.swing.JDialog {

    private static final Logger logger = LogManager.getLogger(EIMSplashscreenUI.class.getName());
    private int progress = 0;
    private ImageIcon imageIcon = null;

    public EIMSplashscreenUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        if (logger.isDebugEnabled()) {
            logger.debug("Initializing EIMSplashscreenUI");
        }
        this.setTitle(EIMI18N.getInstance().getString("EIM"));

        this.setUndecorated(true);

        initComponents();

        try {
            this.setBackground(new Color(255, 255, 255));
            this.panel_main.setBackground(new Color(255, 255, 255));
            this.label_logo.setBorder(new EIMBubbleBorder(new Color(92, 172, 238), 1, 3, 5));
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
        }

        try {
            imageIcon = EIMImage.getInstance().getImageIcon(EIMConstants.getImagePath(EIMConstants.IMAGE.IMG_LOGO_BIG));
            this.label_logo.setIcon(imageIcon);
            this.setIconImage(imageIcon.getImage());
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException: " + e.getMessage());
            this.label_logo.setText(EIMI18N.getInstance().getString("EIM"));
        }

        this.progressbar.setStringPainted(true);
        update(0, "", false);

        this.setLocationRelativeTo(null);
    }

    public void update(int progress, String s, boolean showPercentage) {
        if ((progress >= 0) && (progress <= 100)) {
            this.progress = progress;
        }
        if (showPercentage) {
            this.progressbar.setString(progress + "% - " + s);
        } else {
            this.progressbar.setString(s);
        }
        this.progressbar.setValue(progress);
    }

    public int getProgress() {
        return progress;
    }

    public void setVisible() {
        setVisible(true);
    }

    public void quit() {
        final JDialog _this = this;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                _this.dispose();
            }
        }, EIMConstants.SPLASHSCREEN_QUIT);
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
        label_logo = new javax.swing.JLabel();
        progressbar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EIM");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        setMaximumSize(new java.awt.Dimension(479, 252));
        setMinimumSize(new java.awt.Dimension(479, 252));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setPreferredSize(new java.awt.Dimension(479, 252));
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        panel_main.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel_main.setLayout(new java.awt.GridBagLayout());

        label_logo.setText("LOGO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panel_main.add(label_logo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panel_main.add(progressbar, gridBagConstraints);

        getContentPane().add(panel_main);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label_logo;
    private javax.swing.JPanel panel_main;
    private javax.swing.JProgressBar progressbar;
    // End of variables declaration//GEN-END:variables
}