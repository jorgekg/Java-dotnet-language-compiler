package View;

import controller.OpenController;
import controller.SaveController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Archive;

public final class ComBirlder extends JFrame{
    
    private Archive archive;

    public ComBirlder() {
        initComponents();
        this.editor.setBorder(new NumberedBorder());
        this.action.setText("");
        this.initEvents();
    }
    
    private void initEvents() {
        this.keyCrtlN();
        this.keyCrtlO();
        this.keyCrtlS();
        this.keyCrtlF9();
        this.keyCrtlF1();
    }
    
    private void keyCrtlN() {
        Action action = new AbstractAction("doSomething") {
            @Override
            public void actionPerformed(ActionEvent e) {
                btNewActionPerformed(e);
            }
        };
        action.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control N"));
        btNew.getActionMap().put("new", action);
        btNew.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        (KeyStroke) action.getValue(Action.ACCELERATOR_KEY), "new");
    }
    
    private void keyCrtlO() {
        Action action = new AbstractAction("doSomething") {
            @Override
            public void actionPerformed(ActionEvent e) {
                btOpenActionPerformed(e);
            }
        };
        action.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control O"));
        btNew.getActionMap().put("open", action);
        btNew.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        (KeyStroke) action.getValue(Action.ACCELERATOR_KEY), "open");
    }
    
    private void keyCrtlS() {
        Action action = new AbstractAction("doSomething") {
            @Override
            public void actionPerformed(ActionEvent e) {
                btSaveActionPerformed(e);
            }
        };
        action.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));
        btNew.getActionMap().put("save", action);
        btNew.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        (KeyStroke) action.getValue(Action.ACCELERATOR_KEY), "save");
    }
    
    private void keyCrtlF9() {
        Action action = new AbstractAction("doSomething") {
            @Override
            public void actionPerformed(ActionEvent e) {
                btCompileActionPerformed(e);
            }
        };
        action.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("F9"));
        btNew.getActionMap().put("compiler", action);
        btNew.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        (KeyStroke) action.getValue(Action.ACCELERATOR_KEY), "compiler");
    }
    
    private void keyCrtlF1() {
        Action action = new AbstractAction("doSomething") {
            @Override
            public void actionPerformed(ActionEvent e) {
                btAboutActionPerformed(e);
            }
        };
        action.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("F1"));
        btNew.getActionMap().put("about", action);
        btNew.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        (KeyStroke) action.getValue(Action.ACCELERATOR_KEY), "about");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMenu = new javax.swing.JPanel();
        btNew = new javax.swing.JButton();
        btOpen = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btCopy = new javax.swing.JButton();
        btPaste = new javax.swing.JButton();
        btCut = new javax.swing.JButton();
        btCompile = new javax.swing.JButton();
        btAbout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        notify = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        editor = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        action = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ComBirld");
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(900, 660));
        setPreferredSize(new java.awt.Dimension(900, 660));

        jpMenu.setBackground(new java.awt.Color(255, 255, 255));
        jpMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpMenu.setMinimumSize(new java.awt.Dimension(145, 590));
        jpMenu.setPreferredSize(new java.awt.Dimension(145, 590));
        jpMenu.setVerifyInputWhenFocusTarget(false);

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/new.PNG"))); // NOI18N
        btNew.setText("New [Ctrl+N]");
        btNew.setAlignmentY(0.0F);
        btNew.setFocusable(false);
        btNew.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btNew.setPreferredSize(new java.awt.Dimension(29, 20));
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/open.PNG"))); // NOI18N
        btOpen.setText("Open [Ctrl+O]");
        btOpen.setFocusable(false);
        btOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpenActionPerformed(evt);
            }
        });

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/save.PNG"))); // NOI18N
        btSave.setText("Save [Ctrl+S]");
        btSave.setFocusable(false);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/copy.PNG"))); // NOI18N
        btCopy.setText("Copy [Ctrl+C]");
        btCopy.setFocusable(false);
        btCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCopyActionPerformed(evt);
            }
        });

        btPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/past.PNG"))); // NOI18N
        btPaste.setText("Paste [Ctrl+V]");
        btPaste.setFocusable(false);
        btPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPasteActionPerformed(evt);
            }
        });

        btCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/cut.PNG"))); // NOI18N
        btCut.setText("Cut [Ctrl+X]");
        btCut.setFocusable(false);
        btCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCutActionPerformed(evt);
            }
        });

        btCompile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/compiler.png"))); // NOI18N
        btCompile.setText("Compile [F9]");
        btCompile.setFocusable(false);
        btCompile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCompileActionPerformed(evt);
            }
        });

        btAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/about.png"))); // NOI18N
        btAbout.setText("About [F1]");
        btAbout.setFocusable(false);
        btAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAboutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpMenuLayout = new javax.swing.GroupLayout(jpMenu);
        jpMenu.setLayout(jpMenuLayout);
        jpMenuLayout.setHorizontalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btCopy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btPaste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btCut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btCompile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpMenuLayout.setVerticalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btPaste, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btCut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btCompile, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notify)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(notify)
                .addContainerGap())
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 0));
        jScrollPane1.setWheelScrollingEnabled(false);

        editor.setColumns(20);
        editor.setLineWrap(true);
        editor.setRows(5);
        editor.setFocusCycleRoot(true);
        editor.setFocusTraversalPolicyProvider(true);
        jScrollPane1.setViewportView(editor);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        action.setEditable(false);
        action.setColumns(20);
        action.setRows(5);
        jScrollPane2.setViewportView(action);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        this.editor.setText("");
        this.action.setText("");
        this.notify.setText("");
        this.archive = null;
    }//GEN-LAST:event_btNewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        SaveController saveController = null;
        if (this.archive != null) {
            saveController = new SaveController(this.archive.getDir(), 
                        this.archive.getName(), this.editor.getText());
        } else {
            JFileChooser chooser = this.chooser();
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                saveController = new SaveController(chooser.getSelectedFile().getPath(), 
                        chooser.getSelectedFile().getName(), this.editor.getText());
            }
        }
        if (saveController != null) {
            this.archive = saveController.save();
            if (this.archive == null) {
                this.action.setText(saveController.getError());
            } else {
                this.action.append("Salvo com sucesso! \n");
                this.notify.setText(this.archive.getDir() + ".birl");
            }
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOpenActionPerformed
        JFileChooser chooser = this.chooser();
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            OpenController openController = new OpenController(chooser.getSelectedFile().getPath());
            this.archive = openController.getArchive();
            if (this.archive == null) {
                JOptionPane.showMessageDialog(null, openController.GetError());
            } else {
                this.editor.setText(this.archive.getCode());
                this.notify.setText(this.archive.getDir());
            }
        }
    }//GEN-LAST:event_btOpenActionPerformed

    private void btPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPasteActionPerformed
        this.editor.paste();
        this.action.append("Colado!\n");
    }//GEN-LAST:event_btPasteActionPerformed

    private void btCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCopyActionPerformed
        this.editor.copy();
        this.action.append("Copiado!\n");
    }//GEN-LAST:event_btCopyActionPerformed

    private void btCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCutActionPerformed
        this.editor.cut();
        this.action.append("Recordado!\n");
    }//GEN-LAST:event_btCutActionPerformed

    private void btCompileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCompileActionPerformed
        this.action.append("Compilação de programas ainda não implementado!\n");
    }//GEN-LAST:event_btCompileActionPerformed

    private void btAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAboutActionPerformed
        this.action.append("Jorge Guilherme Kohn e Felipe Anselmo \n");
    }//GEN-LAST:event_btAboutActionPerformed

    private JFileChooser chooser() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Salvar codigo ComBilder");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Birl", "birl");
        chooser.setFileFilter(filter);
        return chooser;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ComBirlder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComBirlder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComBirlder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComBirlder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComBirlder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea action;
    private javax.swing.JButton btAbout;
    private javax.swing.JButton btCompile;
    private javax.swing.JButton btCopy;
    private javax.swing.JButton btCut;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btOpen;
    private javax.swing.JButton btPaste;
    private javax.swing.JButton btSave;
    private javax.swing.JTextArea editor;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JLabel notify;
    // End of variables declaration//GEN-END:variables
}
