package br.com;

public class JifEnviarEmail extends javax.swing.JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4412620779277626974L;
	private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelMsg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaMsg;
    private javax.swing.JButton jbEnviar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JTextField jtEmail;
	
	public JifEnviarEmail() {
        initComponents();
        setLocation(100, 50);
        setSize(500, 400);
        setTitle("Enviar Email");
	}

    private void initComponents() {

        jbNovo = new javax.swing.JButton();
        jbEnviar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jLabelEmail = new javax.swing.JLabel();
        jtEmail = new javax.swing.JTextField();
        jLabelMsg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMsg = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbEnviar.setText("Enviar");
        jbEnviar.setEnabled(false);
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });

        jbLimpar.setText("Limpar");
        jbLimpar.setEnabled(false);
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jLabelEmail.setText("Email:");

        jtEmail.setEnabled(false);
        jtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEmailActionPerformed(evt);
            }
        });

        jLabelMsg.setText("Mensagem:");
        
        jTextAreaMsg.setEnabled(false);
        jTextAreaMsg.setColumns(20);
        jTextAreaMsg.setRows(5);
        jTextAreaMsg.setLineWrap(true);
        jScrollPane1.setViewportView(jTextAreaMsg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbLimpar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelMsg)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbEnviar)
                        .addComponent(jbLimpar)
                        .addComponent(jbNovo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }       

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {                                       
        jbEnviar.setEnabled(true);
        jbLimpar.setEnabled(true);
        jtEmail.setEnabled(true);
        jbNovo.setEnabled(false);
        jTextAreaMsg.setEnabled(true);
    }                                      

    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	if(EnviarEmail.validEmail(jtEmail.getText())){    	
	    	EnviarEmail.enviarEmail(EnviarEmail.CriptogafarTexto(jTextAreaMsg.getText(), jtEmail.getText()));
	    	jtEmail.setText("");
	        jTextAreaMsg.setText("");
    	} else {
    		jtEmail.setText("E-mail inválido");
    	}
    	
    }                                          

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jtEmail.setText("");
        jTextAreaMsg.setText("");
    }                                        

    private void jtEmailActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                        
                       
}