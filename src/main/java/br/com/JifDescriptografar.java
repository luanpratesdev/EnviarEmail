package br.com;

public class JifDescriptografar extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1019506953219194124L;
	
	private javax.swing.JLabel jLabelMsgCriptografada;
	private javax.swing.JLabel jLabelMsgDescriptografada;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jTextAreaMsgDescriptografada;
	private javax.swing.JTextArea jTextAreaMsgCriptografada;
	private javax.swing.JButton jbDescriptografar;
	private javax.swing.JButton jbLimpar;
	private javax.swing.JButton jbNovo;

	public JifDescriptografar() {
		initComponents();
		setLocation(100, 50);
		setSize(500, 400);
		setTitle("Descriptografar Mensagens");
	}

	private void initComponents() {

		jLabelMsgCriptografada = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextAreaMsgDescriptografada = new javax.swing.JTextArea();
		jbNovo = new javax.swing.JButton();
		jbDescriptografar = new javax.swing.JButton();
		jbLimpar = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextAreaMsgCriptografada = new javax.swing.JTextArea();
		jLabelMsgDescriptografada = new javax.swing.JLabel();
		
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
		
        
        
        jLabelMsgCriptografada.setText("Mensagem Criptografada:");

		jTextAreaMsgCriptografada.setEnabled(false);
		jTextAreaMsgCriptografada.setColumns(20);
		jTextAreaMsgCriptografada.setRows(5);
		jTextAreaMsgCriptografada.setLineWrap(true);
		jScrollPane2.setViewportView(jTextAreaMsgCriptografada);
  
        jLabelMsgDescriptografada.setText("Mensagem Descriptografada:");
        
		jTextAreaMsgDescriptografada.setEnabled(false);
		jTextAreaMsgDescriptografada.setColumns(20);
		jTextAreaMsgDescriptografada.setRows(5);
		jTextAreaMsgDescriptografada.setLineWrap(true);
		jScrollPane1.setViewportView(jTextAreaMsgDescriptografada);

		jbNovo.setText("Novo");
		jbNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbNovoActionPerformed(evt);
			}
		});

		jbDescriptografar.setText("Descriptografar");
		jbDescriptografar.setEnabled(false);
		jbDescriptografar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbCalcularActionPerformed(evt);
			}
		});

		jbLimpar.setText("Limpar");
		jbLimpar.setEnabled(false);
		jbLimpar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbLimparActionPerformed(evt);
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 103, Short.MAX_VALUE)
                                .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbDescriptografar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMsgCriptografada)
                            .addComponent(jLabelMsgDescriptografada))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNovo)
                    .addComponent(jbDescriptografar)
                    .addComponent(jbLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelMsgCriptografada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jLabelMsgDescriptografada, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

	private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {
		jbDescriptografar.setEnabled(true);
		jbLimpar.setEnabled(true);
		jTextAreaMsgDescriptografada.setEnabled(true);	
		jTextAreaMsgDescriptografada.setEditable(false);
		jTextAreaMsgCriptografada.setEnabled(true);
		jTextAreaMsgCriptografada.setEditable(true);
		jbNovo.setEnabled(false);

	}

	private void jbCalcularActionPerformed(java.awt.event.ActionEvent evt) {
		jTextAreaMsgDescriptografada.setText(DescriptografarMensagem.ordemDescriptografia(jTextAreaMsgCriptografada.getText()));
	}

	private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {
		jTextAreaMsgDescriptografada.setText("");
		jTextAreaMsgCriptografada.setText("");
	}

}
