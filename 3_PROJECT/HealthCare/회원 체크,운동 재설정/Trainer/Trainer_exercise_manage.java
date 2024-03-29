﻿package Trainer;

/**
 *
 * @author 20173189 김예진
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class Trainer_exercise_manage extends javax.swing.JFrame {

    frame_values trainerframevalues = new frame_values();

    // 테이블에서 선탣된 값이 텍스트에 뿌려진다.
    public void getselectedtable() {

        // 선택한 테이블의 내용을 텍스트에 뿌린다.
        DefaultTableModel model = (DefaultTableModel) trainer_screen_trainertable.getModel();

        int rIndex = trainer_screen_trainertable.getSelectedRow();

        jTextField_health_name.setText(model.getValueAt(rIndex, 2).toString());

        jTextField_health_set.setText(model.getValueAt(rIndex, 3).toString());

        jTextField_health_count.setText(model.getValueAt(rIndex, 4).toString());

        jTextField_health_time.setText(model.getValueAt(rIndex, 5).toString());

    }

// 텍스트에 입력된 값을 가지고 와서  테이블 데이터에 수정하게한다.
// 수정 버튼에 실행되는 함수
    public void editMemberhealth(JTextField healthnamefield, JTextField healthsetfield, JTextField healthcountfield, JTextField healthtimefield) {

        try {
            DefaultTableModel model = (DefaultTableModel) trainer_screen_trainertable.getModel();

            int rIndex = trainer_screen_trainertable.getSelectedRow();

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sedb?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "yejin123");

            String user_name = model.getValueAt(rIndex, 1).toString();
            String healthnamebefore = model.getValueAt(rIndex, 2).toString();

            String healthnameafter = healthnamefield.getText();
            String healthset = healthsetfield.getText();
            String healtcount = healthcountfield.getText();
            String healthtime = healthtimefield.getText();

            PreparedStatement update = con.prepareStatement("Update sedb.trainer Set health_name = ?, health_set = ?, health_count = ?, health_time = ? Where health_name = ? and  user_name = ?");

            update.setString(1, healthnameafter);
            update.setString(2, healthset);
            update.setString(3, healtcount);
            update.setString(4, healthtime);
            update.setString(5, healthnamebefore);
            update.setString(6, user_name);

            update.executeUpdate();
            System.out.println("데이터가 변경되었습니다.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public Trainer_exercise_manage() throws ClassNotFoundException, SQLException {

        initComponents();

        trainerframevalues.setTable(trainer_screen_trainertable);

        Display_table displaytrainer = new Display_trainer_all();
        displaytrainer.startdisplay(trainerframevalues);

        trainerframevalues.setTable(exercise_type);

        Display_table displayhealth = new Display_health_all();
        displayhealth.startdisplay(trainerframevalues);

        setLocationRelativeTo(null);// 창이 가운데로 온다.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manage_member_exercise = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        trainer_screen_trainertable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jTextField_user_name = new javax.swing.JTextField();
        SearchMember = new javax.swing.JButton();
        EditMemberExercisebutton = new javax.swing.JButton();
        jTextField_health_name = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField_health_set = new javax.swing.JTextField();
        jTextField_health_count = new javax.swing.JTextField();
        jTextField_health_time = new javax.swing.JTextField();
        ResetTable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        exercise_type = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        manage_member_exercise.setPreferredSize(new java.awt.Dimension(621, 399));

        trainer_screen_trainertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "user_id", "user_name", "health_name", "health_set", "health_count", "health_time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        trainer_screen_trainertable.getTableHeader().setReorderingAllowed(false);
        trainer_screen_trainertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trainer_screen_trainertableMouseClicked(evt);
            }
        });
        trainer_screen_trainertable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                trainer_screen_trainertableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(trainer_screen_trainertable);
        if (trainer_screen_trainertable.getColumnModel().getColumnCount() > 0) {
            trainer_screen_trainertable.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel10.setText("회원 이름:");

        jTextField_user_name.setText("jTextField1");

        SearchMember.setText("회원 검색");
        SearchMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchMemberActionPerformed(evt);
            }
        });

        EditMemberExercisebutton.setText("수정");
        EditMemberExercisebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMemberExercisebuttonActionPerformed(evt);
            }
        });

        jTextField_health_name.setText("jTextField3");

        jLabel11.setText("health_name :");

        jLabel12.setText("health_set : ");

        jLabel13.setText("health_count : ");

        jLabel14.setText("health_time : ");

        jTextField_health_set.setText("jTextField5");

        jTextField_health_count.setText("jTextField6");

        jTextField_health_time.setText("jTextField7");

        ResetTable.setText("테이블 새로고침");
        ResetTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manage_member_exerciseLayout = new javax.swing.GroupLayout(manage_member_exercise);
        manage_member_exercise.setLayout(manage_member_exerciseLayout);
        manage_member_exerciseLayout.setHorizontalGroup(
            manage_member_exerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manage_member_exerciseLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(manage_member_exerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(manage_member_exerciseLayout.createSequentialGroup()
                        .addComponent(jTextField_health_name, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jTextField_health_set, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jTextField_health_count, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jTextField_health_time, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EditMemberExercisebutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(ResetTable))
                    .addGroup(manage_member_exerciseLayout.createSequentialGroup()
                        .addGroup(manage_member_exerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(manage_member_exerciseLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jTextField_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(SearchMember, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(manage_member_exerciseLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        manage_member_exerciseLayout.setVerticalGroup(
            manage_member_exerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manage_member_exerciseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(manage_member_exerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(manage_member_exerciseLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(manage_member_exerciseLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(manage_member_exerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchMember))))
                .addGap(18, 18, 18)
                .addGroup(manage_member_exerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(5, 5, 5)
                .addGroup(manage_member_exerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_health_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_health_set, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_health_count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(manage_member_exerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_health_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EditMemberExercisebutton)
                        .addComponent(ResetTable)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        exercise_type.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "health_name"
            }
        ));
        jScrollPane1.setViewportView(exercise_type);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(manage_member_exercise, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(manage_member_exercise, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditMemberExercisebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMemberExercisebuttonActionPerformed
        // TODO add your handling code here:

        editMemberhealth(jTextField_health_name, jTextField_health_set, jTextField_health_count, jTextField_health_time);
    }//GEN-LAST:event_EditMemberExercisebuttonActionPerformed

    private void SearchMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchMemberActionPerformed

        // 회원 검색을 누르면 동작
        // 검색에 해당되는 내용만 보여준다.
        try {
         
            // 어떤 테이블에 보일지, 사람이름을 먼저 설정한다.
            trainerframevalues.setTable(trainer_screen_trainertable);
            trainerframevalues.setUser_name(jTextField_user_name);

            // 해당 내용으로 테이블에 보이도록한다.
            Display_table doselect = new Display_trainer_member();
            doselect.startdisplay(trainerframevalues);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trainer_exercise_manage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trainer_exercise_manage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_SearchMemberActionPerformed

    private void trainer_screen_trainertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainer_screen_trainertableMouseClicked
        getselectedtable();
    }//GEN-LAST:event_trainer_screen_trainertableMouseClicked

    private void trainer_screen_trainertableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trainer_screen_trainertableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_trainer_screen_trainertableKeyPressed

    private void ResetTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetTableActionPerformed
        try {
            // 화면의 어느테이블에 데이터를 보여줄것인지 설정
            trainerframevalues.setTable(trainer_screen_trainertable);
            // 해당 테이블에 trainer 데이터베이스의 모든 내용을 보여준다. 
            Display_table displaytrainer = new Display_trainer_all();
            displaytrainer.startdisplay(trainerframevalues);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trainer_exercise_manage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trainer_exercise_manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ResetTableActionPerformed

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
            java.util.logging.Logger.getLogger(Trainer_exercise_manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trainer_exercise_manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trainer_exercise_manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trainer_exercise_manage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Trainer_exercise_manage().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Trainer_exercise_manage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Trainer_exercise_manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditMemberExercisebutton;
    private javax.swing.JButton ResetTable;
    private javax.swing.JButton SearchMember;
    private javax.swing.JTable exercise_type;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_health_count;
    private javax.swing.JTextField jTextField_health_name;
    private javax.swing.JTextField jTextField_health_set;
    private javax.swing.JTextField jTextField_health_time;
    private javax.swing.JTextField jTextField_user_name;
    private javax.swing.JPanel manage_member_exercise;
    private javax.swing.JTable trainer_screen_trainertable;
    // End of variables declaration//GEN-END:variables
}
