import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Frame extends javax.swing.JFrame {

	static String path = "\\C:\\Users\\Dylan\\workspace\\Password_Strength\\src\\Password_List";
	static String horrible = "horrible";
	static String bad = "bad";
	static String ok = "ok";
	static String strong = "strong";
	static boolean onList = false;
	static String gPassword = "argHRTHER4566!@#";
	
    /**
     * Creates new form Password_Strength
     */
    public Frame() {
        initComponents();
        initilize();
    }

    private void initilize(){
    	horribleTextField.setEnabled(true);
    	badTextField.setEnabled(true);
    	okTextField.setEnabled(true);
    	strongTextField.setEnabled(true);
    	
    	resultLabel.setText("");
    	
    	horribleTextField.setBackground(new java.awt.Color(219, 229, 241));
    	badTextField.setBackground(new java.awt.Color(219, 229, 241));
    	okTextField.setBackground(new java.awt.Color(219, 229, 241));
    	strongTextField.setBackground(new java.awt.Color(219, 229, 241));
    	
    	clearButton.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			passwordTextField.setText("");
    			resultLabel.setText("");
    			
    			horribleTextField.setBackground(new java.awt.Color(219, 229, 241));
    	    	badTextField.setBackground(new java.awt.Color(219, 229, 241));
    	    	okTextField.setBackground(new java.awt.Color(219, 229, 241));
    	    	strongTextField.setBackground(new java.awt.Color(219, 229, 241));
    		}
    	});
    	
    	submitButton.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			gPassword = passwordTextField.getText().trim();
    			
    			start(gPassword);
    		}
    	});
    }
    
    private static void start(String password){
    	String strength = horrible;
		try {
			checkList(gPassword);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(onList == false){
			strength = checkPasswordStrength(gPassword);
			System.out.println("Your password strength is " + strength + " [checked]");
		}
		else{
			if(strength.equals(horrible)){
				horribleTextField.setBackground(Color.RED);
				resultLabel.setText("Your Password strength is " + horrible + ".");
			}
		}
    }
    
    private static boolean checkList(String password) throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader reader = new BufferedReader(fr);
		
		int lines = readLines();
		String[] data = new String[lines];
		
		int i;
		for(i=0; i<lines; i++){
			data[i] = reader.readLine();
			if(data[i].equals(password.trim())){
				onList = true;
			}
		}
		
		reader.close();
		return onList;
	}
	
	private static int readLines() throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader bf = new BufferedReader(fr);
		
		String line;
		int lines = 0;
		
		while(( line = bf.readLine()) != null){
			lines++;
		}
		bf.close();
		return lines;
	}
	
    private static String checkPasswordStrength(String password) {
                String  strengthPercentage = "";
        String[] partialRegexChecks = { ".*[a-z]+.*", // lower
                ".*[A-Z]+.*", // upper
                ".*[\\d]+.*", // digits
                ".*[@#$%]+.*" // symbols
        };

        if(password.trim().equals("")){   
            return strengthPercentage = "You must enter a password";
        }
        
        if (password.matches(partialRegexChecks[0])) {
        strengthPercentage = horrible;
        }
        if (password.matches(partialRegexChecks[1])) {
        strengthPercentage = bad;
        }
        if (password.matches(partialRegexChecks[2])) {
        strengthPercentage = ok;
        }
        if (password.matches(partialRegexChecks[3])) {
        strengthPercentage = strong;
        }

        return strengthPercentage;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        masterPanel = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        horribleTextField = new javax.swing.JTextField();
        okTextField = new javax.swing.JTextField();
        badTextField = new javax.swing.JTextField();
        strongTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        masterPanel.setBackground(new java.awt.Color(219, 229, 241));
        masterPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        submitButton.setBackground(new java.awt.Color(149, 179, 215));
        submitButton.setText("Submit");

        clearButton.setBackground(new java.awt.Color(149, 179, 215));
        clearButton.setText("clear");

        resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultLabel.setText("result goes here");

        passwordTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Please enter a password to check its strength");

        javax.swing.GroupLayout masterPanelLayout = new javax.swing.GroupLayout(masterPanel);
        masterPanel.setLayout(masterPanelLayout);
        masterPanelLayout.setHorizontalGroup(
            masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(masterPanelLayout.createSequentialGroup()
                        .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(masterPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(masterPanelLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearButton)
                    .addComponent(submitButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, masterPanelLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addGroup(masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(masterPanelLayout.createSequentialGroup()
                        .addComponent(horribleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(badTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(strongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(123, 123, 123))
        );

        masterPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {clearButton, submitButton});

        masterPanelLayout.setVerticalGroup(
            masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, masterPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horribleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(badTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(submitButton)
                .addGap(18, 18, 18)
                .addComponent(clearButton)
                .addGap(31, 31, 31))
        );

        masterPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {clearButton, submitButton});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(masterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(masterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Password_Strength.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Password_Strength.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Password_Strength.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Password_Strength.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField badTextField;
    private javax.swing.JButton clearButton;
    private static javax.swing.JTextField horribleTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel masterPanel;
    private javax.swing.JTextField okTextField;
    private javax.swing.JTextField passwordTextField;
    private static javax.swing.JLabel resultLabel;
    private javax.swing.JTextField strongTextField;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}