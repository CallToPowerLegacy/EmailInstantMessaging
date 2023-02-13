/**
 * EIM, Copyright 2014 Denis Meyer
 */
package com.eim.ui;

import com.eim.util.EIMConstants;
import com.eim.util.EIMUtility;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * EIMNotificationUI
 *
 * @author Denis Meyer
 */
public abstract class EIMNotificationUI extends JFrame {

    private static final Logger logger = LogManager.getLogger(EIMNotificationUI.class.getName());
    private Timer timer = null;
    private String from = "";
    private String msg = "";
    private final int thisWidth = 359;
    private final int thisHeight = 75;
    private final Color color_information = new Color(202, 240, 255);
    private final Color color_error = new Color(255, 208, 203);
    private final Color color_message = new Color(238, 238, 238);

    public static enum TYPE {

        INFORMATION,
        ERROR,
        MESSAGE
    };

    public abstract void onClick();

    public abstract void onWindowClose();

    public EIMNotificationUI(
            String header,
            String from,
            String msg,
            int offset,
            TYPE type) {
        if (logger.isDebugEnabled()) {
            logger.debug("Initializing EIMNewMessageNotificationUI");
        }
        this.from = from;
        this.msg = msg;

        this.setUndecorated(true);
        this.setShape(new RoundRectangle2D.Double(0, 0, thisWidth, thisHeight, 20, 20));
        this.setAlwaysOnTop(true);

        setPosition(offset);

        initComponents();
        setColor(type);

        this.setTitle(header);
        this.label_header.setText(header);
        this.label_mid.setText(this.from);
        this.label_message.setText(this.msg);

        addListener();

        startQuitTimer();
    }

    private void disposeNotification() {
        if (timer != null) {
            timer.cancel();
        }
        timer = null;
        this.dispose();
    }

    private void addListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                onWindowClose();
            }
        });
        this.panel_main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                onClick();
            }
        });
    }

    private void startQuitTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                disposeNotification();
            }
        }, EIMConstants.NEW_MESSAGE_DISPLAY_TIME);
    }

    private void setColor(TYPE type) {
        switch (type) {
            default:
            case INFORMATION:
                panel_main.setBackground(color_information);
                panel_message.setBackground(color_information);
                label_content.setBackground(color_information);
                break;
            case ERROR:
                panel_main.setBackground(color_error);
                panel_message.setBackground(color_error);
                label_content.setBackground(color_error);
                break;
            case MESSAGE:
                panel_main.setBackground(color_message);
                panel_message.setBackground(color_message);
                label_content.setBackground(color_message);
                break;
        }
    }

    private void setPosition(int offset) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

        int screenHeight = (int) rect.getMaxY();
        int offsetMin = offset;

        int x = (int) rect.getMaxX() - thisWidth;
        int y = 0;
        if ((thisHeight * offsetMin) > 0) {
            double nrOfObjOnDisplay = (screenHeight / thisHeight) - 1;
            while ((offset / nrOfObjOnDisplay) > 1) {
                offset -= nrOfObjOnDisplay;
                x -= thisWidth;
            }
            y = (offset - 1) * thisHeight;
        }

        if (EIMUtility.getInstance().platformIsMac()) {
            y += EIMConstants.MAC_OS_X_MENUBAR_HEIGHT;
        }

        this.setLocation(x, y);
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
        label_header = new javax.swing.JLabel();
        panel_message = new javax.swing.JPanel();
        label_mid = new javax.swing.JLabel();
        label_content = new javax.swing.JPanel();
        label_message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("New message");
        setMaximumSize(new java.awt.Dimension(415, 75));
        setMinimumSize(new java.awt.Dimension(415, 75));
        setUndecorated(true);
        setOpacity(0.8F);
        setPreferredSize(new java.awt.Dimension(415, 75));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        panel_main.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel_main.setLayout(new java.awt.GridBagLayout());

        label_header.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_header.setText("HEADER");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panel_main.add(label_header, gridBagConstraints);

        panel_message.setLayout(new java.awt.GridBagLayout());

        label_mid.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        label_mid.setText("MID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        panel_message.add(label_mid, gridBagConstraints);

        label_content.setLayout(new java.awt.GridLayout(1, 0));

        label_message.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        label_message.setForeground(new java.awt.Color(102, 102, 102));
        label_message.setText("MESSAGE");
        label_content.add(label_message);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        panel_message.add(label_content, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        panel_main.add(panel_message, gridBagConstraints);

        getContentPane().add(panel_main);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel label_content;
    private javax.swing.JLabel label_header;
    private javax.swing.JLabel label_message;
    private javax.swing.JLabel label_mid;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_message;
    // End of variables declaration//GEN-END:variables
}