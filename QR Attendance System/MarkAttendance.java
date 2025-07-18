/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import utility.BDUtility;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class MarkAttendance extends javax.swing.JFrame implements Runnable , ThreadFactory  {

    
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private ExecutorService executor = Executors.newSingleThreadExecutor(this);
    private volatile boolean running = true;
    
    
    public MarkAttendance() {
        initComponents();
        BDUtility.setImage(this,"images/classroom.jpg",1366, 751);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(6,6,6,6, Color.GRAY));
        initWebcam();
        Timer timer  = new Timer(1,e->updateTime());
        timer.start();
    }
    
    private  void updateTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        lblTime.setText(simpleDateFormat.format(new Date()));
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
        btnExit = new javax.swing.JButton();
        webCamPanel = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblCheckinCheckout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Mark Attendance");

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExit.setText("x");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        webCamPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Time");

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(0, 255, 255));

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));

        lblCheckinCheckout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCheckinCheckout.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(webCamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(110, 110, 110)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(111, 111, 111))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(579, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(543, 543, 543)
                        .addComponent(btnExit)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCheckinCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(182, 182, 182))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExit)
                            .addComponent(jLabel1))
                        .addGap(43, 43, 43)
                        .addComponent(webCamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lblCheckinCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        running = false;
        stopWebcam();
        
        if(executor != null && !executor.isShutdown()){
            executor.shutdown();
        }
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JLabel lblCheckinCheckout;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel webCamPanel;
    // End of variables declaration//GEN-END:variables

    Map<String,String> resultMap = new HashMap<String,String>();
    
    
    @Override
    public void run() {
    
        do{
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                
            }
            
            try{
                Result result = null;
                BufferedImage image = null;
                if(webcam.isOpen()){
                    if((image=webcam.getImage())==null){
                        continue;
                    }
                }
                
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                
                try{
                    result = new MultiFormatReader().decode(bitmap);
                }catch(NotFoundException ex){
                    
                }
                
                if(result != null){
                    String jsonString = result.getText();
                    Gson gson = new Gson();
                    java.lang.reflect.Type type = new TypeToken<Map<String,String>>(){
                    }.getType(); 
                     
                    resultMap = gson.fromJson(jsonString, type);
                    
                    String finalPath = BDUtility.getPath("images\\"+resultMap.get("email")+".jpg");
                    CircularImageFrame(finalPath);
                    
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }while(running);
        
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,"my thread" );
        t.setDaemon(running);
        return t; 
    }
    
    private void stopWebcam(){
        if(webcam!=null && webcam.isOpen()){
            webcam.close();
            
        }
    }

    private void initWebcam() {
    webcam = Webcam.getDefault();
    if(webcam != null){
        Dimension[] resolutions =  webcam.getViewSizes();
        Dimension maxResolution = resolutions[resolutions.length-1];
        
        if(webcam.isOpen()){
            webcam.close();
        }
        
        webcam.setViewSize(maxResolution);
        webcam.open();
         
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(maxResolution);
        panel.setFPSDisplayed(true);
        
        webCamPanel.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,689,518));
        executor.execute(this);
        executor.shutdown();
    }else{
        System.out.println("Issue  with webcam.");
    }
    
    }
    private BufferedImage imagee = null;
    private void CircularImageFrame(String imagePath) {
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from userdetails where email = '"+resultMap.get("email")+"';");
            if(!rs.next()){
                showPopUpForCertainDuration("User is not Registered or Deleted","Invalid QR0",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            imagee = null;
            File imageFile = new File(imagePath);
            if(imageFile.exists()){
                try{
                    imagee = ImageIO.read(new File(imagePath));
                    imagee = createCircularImage(imagee);
                    ImageIcon icon = new ImageIcon(imagee);
                    lblImage.setIcon(icon);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }else{
                BufferedImage imageeee = new BufferedImage(300,300,BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = imageeee.createGraphics();
                
                g2d.setColor(Color.BLACK);
                g2d.fillOval(25, 25, 250, 250);
                g2d.setFont(new Font("Serif",Font.BOLD,250));
                g2d.setColor(Color.WHITE);
                g2d.drawString(String.valueOf(resultMap.get("name").charAt(0)).toUpperCase(), 75, 225);
                g2d.dispose();
                
                ImageIcon imageIconn = new ImageIcon(imageeee);
                lblImage.setIcon(imageIconn);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.pack();
                this.setLocationRelativeTo(null);
                this.setVisible(true);
            }
            lblName.setHorizontalAlignment(JLabel.CENTER);
            lblName.setText(resultMap.get("name"));
            if(!checkInCheckOut()){
                return;
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void showPopUpForCertainDuration(String popUpMessage, String popUpHeader, Integer iconId)throws Exception {
        
        final JOptionPane optionPane = new JOptionPane(popUpMessage,iconId);
        final JDialog dialog= optionPane.createDialog(popUpHeader);
        Timer timer = new Timer(5000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               dialog.dispose();
               clearUserDetails();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
        
    }
    
    private void clearUserDetails(){
        lblCheckinCheckout.setText("");
        lblCheckinCheckout.setBackground(null);
        lblCheckinCheckout.setForeground(null);
        lblCheckinCheckout.setOpaque(false);
        lblName.setText("");
        lblImage.setIcon(null);
    }

    private BufferedImage createCircularImage(BufferedImage image) {
        int diameter = 285;
        BufferedImage resizedImage = new BufferedImage(diameter,diameter,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2= resizedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image,0,0,diameter,diameter,null);
        g2.dispose();
        BufferedImage circularImage = new BufferedImage(diameter,diameter,BufferedImage.TYPE_INT_ARGB);
        g2 = circularImage.createGraphics();
        Ellipse2D.Double circle = new Ellipse2D.Double(0,0,diameter,diameter);
        g2.setClip(circle);
        g2.drawImage(resizedImage,0,0,null);
        g2.dispose();
        return circularImage;
    }

    private boolean checkInCheckOut() throws Exception {
    String popUpHeader = null;
    String popUpMessage = null;
    Color color = null;

    LocalDate currentDate = LocalDate.now();
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    try (Connection con = ConnectionProvider.getCon();
         PreparedStatement psCheck = con.prepareStatement(
             "SELECT * FROM userattendance WHERE date = '"+currentDate.format(dateFormatter)+"' AND userid = '"+Integer.valueOf(resultMap.get("id"))+"'");
         
            ){

        // Check if the user has already checked in for the day
/*        psCheck.setString(1, currentDate.format(dateFormatter));
        psCheck.setInt(2, Integer.valueOf(resultMap.get("id")));
*/
        ResultSet rs = psCheck.executeQuery();

        if (rs.next()) {
            // User has already checked in
            String checkOutDateTime = rs.getString("checkout");
            if (checkOutDateTime != null) {
                popUpMessage = "Already checked out for the day.";
                popUpHeader = "Invalid Checkout";
                showPopUpForCertainDuration(popUpMessage, popUpHeader, JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Calculate work duration
            String checkInDateTime = rs.getString("checkin");
            LocalDateTime checkInLocalDateTime = LocalDateTime.parse(checkInDateTime, dateTimeFormatter);
            Duration duration = Duration.between(checkInLocalDateTime, currentDateTime);

            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;
            long seconds = duration.getSeconds() % 60;

            if (hours == 0 && minutes < 1) {
                long remainingMinutes = 1 - minutes;
                long remainingSeconds = 60 - seconds;
                popUpMessage = String.format(
                    "Your work duration is less than 1 minute.\nYou can check out after: %d minutes and %d seconds",
                    remainingMinutes, remainingSeconds);
                popUpHeader = "Duration Warning";
                showPopUpForCertainDuration(popUpMessage, popUpHeader, JOptionPane.WARNING_MESSAGE);
                return false;
            }

            // Update checkout time and work duration
            String workDuration = String.format("%d Hours and %d Minutes", hours, minutes);
            PreparedStatement psUpdate = con.prepareStatement(
             "UPDATE userattendance SET checkout = '"+currentDateTime.format(dateTimeFormatter)+"', workduration = '"+workDuration+"' WHERE date = '"+currentDate.format(dateFormatter)+"' AND userid = '"+Integer.valueOf(resultMap.get("id"))+"'");
/*            psUpdate.setString(1, currentDateTime.format(dateTimeFormatter));
            psUpdate.setString(2, workDuration);
            psUpdate.setString(3, currentDate.format(dateFormatter));
            psUpdate.setInt(4, Integer.valueOf(resultMap.get("id")));
*/
            psUpdate.executeUpdate();

            popUpHeader = "Checkout";
            popUpMessage = String.format(
                "Checked out at %s\nWork Duration: %d Hours and %d Minutes",
                currentDateTime.format(dateTimeFormatter), hours, minutes);
            color = Color.RED;
        } else {
            // Insert new check-in record
            PreparedStatement psInsert = con.prepareStatement(
             "INSERT INTO userattendance (userid, date, checkin) VALUES ('"+Integer.valueOf(resultMap.get("id"))+"', '"+currentDate.format(dateFormatter)+"', '"+currentDateTime.format(dateTimeFormatter)+"')");
/*            psInsert.setInt(1, Integer.valueOf(resultMap.get("id")));
            psInsert.setString(2, currentDate.format(dateFormatter));
            psInsert.setString(3, currentDateTime.format(dateTimeFormatter));
*/
            psInsert.executeUpdate();

            popUpHeader = "Checkin";
            popUpMessage = "Checked in at " + currentDateTime.format(dateTimeFormatter);
            color = Color.GREEN;
        }

        // Update UI
        lblCheckinCheckout.setHorizontalAlignment(JLabel.CENTER);
        lblCheckinCheckout.setText(popUpHeader);
        lblCheckinCheckout.setForeground(color);
        lblCheckinCheckout.setBackground(Color.DARK_GRAY);
        lblCheckinCheckout.setOpaque(true);
        showPopUpForCertainDuration(popUpMessage, popUpHeader, JOptionPane.INFORMATION_MESSAGE);

        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        throw new Exception("Database error: " + e.getMessage());
    }
}

    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(imagee!=null){
            g.drawImage(imagee, 0, 0, null);
        }
    }
}
