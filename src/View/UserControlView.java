/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author samyc
 */
public class UserControlView extends javax.swing.JPanel {

    /**
     * Creates new form UserControlView
     */
    public UserControlView() {
        initComponents();
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

        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        graph1 = new javax.swing.JPanel();
        graph2 = new javax.swing.JPanel();
        graph3 = new javax.swing.JPanel();
        jPanelLastAcces = new javax.swing.JPanel();
        lastAcces = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        pick = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        header.setLayout(new java.awt.BorderLayout());

        title.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        title.setText("User Control");
        header.add(title, java.awt.BorderLayout.PAGE_END);

        add(header, java.awt.BorderLayout.PAGE_START);

        container.setLayout(new java.awt.GridLayout(2, 2));

        graph1.setLayout(new java.awt.BorderLayout());
        container.add(graph1);

        graph2.setLayout(new java.awt.BorderLayout());
        container.add(graph2);

        graph3.setLayout(new java.awt.BorderLayout());
        container.add(graph3);

        jPanelLastAcces.setLayout(new java.awt.GridBagLayout());

        lastAcces.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lastAcces.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lastAcces.setText("Last Access");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        jPanelLastAcces.add(lastAcces, gridBagConstraints);

        date.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        date.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        jPanelLastAcces.add(date, gridBagConstraints);

        name.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        name.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        jPanelLastAcces.add(name, gridBagConstraints);

        pick.setBorderPainted(false);
        pick.setFocusable(false);
        pick.setPreferredSize(new java.awt.Dimension(192, 192));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        jPanelLastAcces.add(pick, gridBagConstraints);

        container.add(jPanelLastAcces);

        add(container, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel container;
    public javax.swing.JLabel date;
    public javax.swing.JPanel graph1;
    public javax.swing.JPanel graph2;
    public javax.swing.JPanel graph3;
    public javax.swing.JPanel header;
    public javax.swing.JPanel jPanelLastAcces;
    public javax.swing.JLabel lastAcces;
    public javax.swing.JLabel name;
    public javax.swing.JButton pick;
    public javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
