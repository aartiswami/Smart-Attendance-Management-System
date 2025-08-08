
package forms;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import dao.ConnectionProvider;
import utility.BDUtility;
import javax.swing.JLabel;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MarkAttendance extends javax.swing.JFrame implements Runnable,ThreadFactory {

            private WebcamPanel panel = null;
            private Webcam webcam = null;
            private ExecutorService executor = Executors.newSingleThreadExecutor(this);
            private volatile boolean running = true;
            private Map<String, String> resultMap = new HashMap<>();
            private BufferedImage imagee = null; 
   
    public MarkAttendance() {
            initComponents();
            BDUtility.setImage(this, "images/abc1.jpg", 1366, 768);
            this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
            initWebcam();

            Timer timer = new Timer(1000, e -> updateTime());
            timer.start();
    }
    
    private void updateTime(){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            lblTime.setText(simpleDateFormat.format(new Date()));
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        webCamPanel = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblCheckInCheckOut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mark Attendance");

        btnExit.setBackground(new java.awt.Color(240, 240, 240));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExit.setText("x");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        webCamPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Date");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Time");

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTime.setText("Time");

        lblName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lblCheckInCheckOut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(webCamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCheckInCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(173, 173, 173))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 603, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnExit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCheckInCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(webCamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        running = false;
        stopWebcam();
        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();
        }
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarkAttendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCheckInCheckOut;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel webCamPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
            while (running) {
        try {
            Thread.sleep(1000); // Sleep to reduce load
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        try {
            Result result = null;
            BufferedImage image = null;
            
            if (webcam != null && webcam.isOpen()) {
                image = webcam.getImage();
                
                // Check if the image is null
                if (image == null) {
                    continue;  // Skip this iteration if no image is captured
                }
            }
            
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
                // Handle exception if QR code is not found
            }

            if (result != null) {
                String jsonString = result.getText();
                Gson gson = new Gson();
                resultMap = gson.fromJson(jsonString, new TypeToken<Map<String, String>>() {}.getType());

                // If the result is valid, display the QR code details
                String finalPath = BDUtility.getPath("images\\" + resultMap.get("email") + ".jpg");
                CircularImageFrame(finalPath); // Show the image in a circular frame
                lblName.setText(resultMap.get("name"));
                lblCheckInCheckOut.setText(resultMap.get("status"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }

    @Override
    public Thread newThread(Runnable r) {
       Thread t = new Thread(r, "QR Thread");
        t.setDaemon(true); // Make it a daemon thread
        return t;
    }

    private void initWebcam() {
        webcam = Webcam.getDefault();
        if (webcam != null) {
            Dimension[] resolutions = webcam.getViewSizes();
            Dimension maxResolution = resolutions[resolutions.length - 1];
            
            if (webcam.isOpen()) {
                webcam.close();
            }
            webcam.setViewSize(maxResolution);
            webcam.open();
            
            panel = new WebcamPanel(webcam);
            panel.setPreferredSize(maxResolution);
            panel.setFPSDisplayed(true);
            
            webCamPanel.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 689, 518));
            executor.execute(this);
        } else {
            System.err.println("No webcam found.");
        }
    }
    
    private void stopWebcam(){
         if (webcam != null && webcam.isOpen()) {
            webcam.close();
        }
    }

    
    private void CircularImageFrame(String imagePath) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM userdetails WHERE email='" + resultMap.get("email") + "';");
            if (!rs.next()) {
                showPopUpForCertainDuration("User is not Registered or Deleted", "Invalid QR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            imagee = null;
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                try {
                    imagee = ImageIO.read(imageFile);
                    imagee = createCircularImage(imagee);
                    ImageIcon icon = new ImageIcon(imagee);
                    lblImage.setIcon(icon);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                BufferedImage placeholderImage = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = placeholderImage.createGraphics();
                g2d.setColor(Color.BLACK);
                g2d.fillOval(25, 25, 250, 250);
                g2d.setFont(new Font("Serif", Font.BOLD, 250));
                g2d.setColor(Color.WHITE);
                g2d.drawString(String.valueOf(resultMap.get("name").charAt(0)).toUpperCase(), 75, 255);
                g2d.dispose();
                
                ImageIcon imageIcon = new ImageIcon(placeholderImage);
                lblImage.setIcon(imageIcon);
            }
            lblName.setHorizontalAlignment(JLabel.CENTER);
            lblName.setText(resultMap.get("name"));
            checkInCheckOut();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showPopUpForCertainDuration(String popUpMessage, String popUpHeader, Integer iconId)throws HeadlessException {
        final JOptionPane optionPane = new JOptionPane(popUpMessage, iconId);
        final JDialog dialog = optionPane.createDialog(popUpHeader);
        
        Timer timer = new Timer(5000, e -> dialog.dispose());
        timer.setRepeats(false);
        timer.start();
        
        dialog.setVisible(true);
    }

            private void clearUserDetails() {
                lblCheckInCheckOut.setText("");
                lblCheckInCheckOut.setBackground(null);
                lblCheckInCheckOut.setForeground(null);
                lblCheckInCheckOut.setOpaque(false);
                lblName.setText("");
                lblImage.setIcon(null);
            }
 
    private BufferedImage createCircularImage(BufferedImage image) {
      int diameter = 285;
        BufferedImage resizedImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImage.createGraphics();
        
        // Use bilinear interpolation for smooth resizing
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, diameter, diameter, null);
        g2.dispose();
        
        BufferedImage circularImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        g2 = circularImage.createGraphics();
        
        // Create circular clipping path
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, diameter, diameter);
        g2.setClip(circle);
        g2.drawImage(resizedImage, 0, 0, null);
        g2.dispose();
        
        return circularImage;
    }

    private boolean checkInCheckOut() throws HeadlessException,SQLException {
         String popUpHeader = null;
        String popUpMessage = null;
        Color color = null;
        
        Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Check if the user has already checked in today
        ResultSet rs = st.executeQuery("SELECT * FROM userattendance WHERE date='" + currentDate.format(dateFormatter) + "' AND userid=" + Integer.valueOf(resultMap.get("id")) + ";");
        
        if (rs.next()) {
            String checkOutDateTime = rs.getString(4);
            if (checkOutDateTime != null) {
                popUpMessage = "Already Checked Out For the Day";
                popUpHeader = "Invalid CheckOut";
                showPopUpForCertainDuration(popUpMessage, popUpHeader, JOptionPane.ERROR_MESSAGE);
                return false;
            }

            String checkInDateTime = rs.getString(3);
            LocalDateTime checkInLocalDateTime = LocalDateTime.parse(checkInDateTime, dateTimeFormatter);
            Duration duration = Duration.between(checkInLocalDateTime, currentDateTime);

            long hours = duration.toHours();
            long minutes = duration.minusHours(hours).toMinutes();
            long seconds = duration.minusHours(hours).minusMinutes(minutes).getSeconds();

            if (!(hours > 0 || (hours == 0 && minutes >= 5))) {
                long remainingMinutes = 4 - minutes;
                long remainingSeconds = 60 - seconds;

                popUpMessage = String.format("Your work duration is less than 5 minutes\nYou can check out after: %d minutes and %d seconds", remainingMinutes, remainingSeconds);
                popUpHeader = "Duration Warning";
                showPopUpForCertainDuration(popUpMessage, popUpHeader, JOptionPane.WARNING_MESSAGE);
                return false;
            }

            String updateQuery = "UPDATE userattendance SET checkout=?, workduration=? WHERE date=? AND userid=?";
            PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
            preparedStatement.setString(1, currentDateTime.format(dateTimeFormatter));
            preparedStatement.setString(2, hours + " Hours and " + minutes + " Minutes");
            preparedStatement.setString(3, currentDate.format(dateFormatter));
            preparedStatement.setString(4, resultMap.get("id"));
            preparedStatement.executeUpdate();

            popUpHeader = "CheckOut";
            popUpMessage = "Checked Out at " + currentDateTime.format(dateTimeFormatter) + "\nWork Duration " + hours + " Hours and " + minutes + " Minutes";
            color = Color.RED;

        } else {
            String insertQuery = "INSERT INTO userattendance (userid, date, checkin) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
            preparedStatement.setString(1, resultMap.get("id"));
            preparedStatement.setString(2, currentDate.format(dateFormatter));
            preparedStatement.setString(3, currentDateTime.format(dateTimeFormatter));
            preparedStatement.executeUpdate();

            popUpHeader = "CheckIn";
            popUpMessage = "Checked In at " + currentDateTime.format(dateTimeFormatter);
            color = Color.GREEN;
        }

        lblCheckInCheckOut.setHorizontalAlignment(JLabel.CENTER);
        lblCheckInCheckOut.setText(popUpHeader);
        lblCheckInCheckOut.setForeground(color);
        lblCheckInCheckOut.setBackground(Color.DARK_GRAY);
        lblCheckInCheckOut.setOpaque(true);

        showPopUpForCertainDuration(popUpMessage, popUpHeader, JOptionPane.INFORMATION_MESSAGE);

        return true;
        
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
    if (imagee != null) {
        g.drawImage(imagee, 0, 0, null);
    }
    }
    
}

    
