/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab23;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import yazlab23.MaxFlow;
import yazlab23.arayuz;
import yazlab23.mincutGraph;

/**
 *
 * @author K4RK1N
 */
public class arayuzGraph extends javax.swing.JFrame {

    static String gelendugumlerbilgi1[][];
    static int graph[][];
    static String baslangicNode1;
    static String bitisNode1;
    int gelendugumsayisi1;
    int gelenkenarsayisi1;
    ArrayList<Integer> kenarKordinatlarX = new ArrayList<>();
    ArrayList<Integer> kenarKordinatlarY = new ArrayList<>();
    ArrayList<Integer> drawkordinatX1 = new ArrayList<>();
    ArrayList<Integer> drawkordinatY1 = new ArrayList<>();
    ArrayList<Integer> drawkordinatX2 = new ArrayList<>();
    ArrayList<Integer> drawkordinatY2 = new ArrayList<>();
    boolean MaxFlowbutonaBasildimi = false;
    boolean MinCutBasildimi = false;
    int R = 70;
    int r = R / 2;
    int Rr = 27;
    int maxflowSayaci = 0;
    int mincutSayaci = 0;
    String[] harfler = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "Y", "Z", "W", "X", "Q"};

    public arayuzGraph(String gelendugumlerbilgi[][], String baslangicNode, String bitisNode, int gelendugumsayisi, int gelenkenarsayisi) {
        initComponents();
        vedat.setBackground(new Color(0, 150, 128));
        hatbilgisiLabel.setForeground(new Color(224, 255, 255));

        this.gelendugumlerbilgi1 = gelendugumlerbilgi;
        this.gelendugumsayisi1 = gelendugumsayisi;
        this.gelenkenarsayisi1 = gelenkenarsayisi;
        this.baslangicNode1 = baslangicNode;
        this.bitisNode1 = bitisNode;

    }

    int toplamKenarsayilari = gelenkenarsayisi1;

    private arayuzGraph() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void noktaCiz(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillOval(25, 150 + r, R, R);     //İLK NODE
        kenarKordinatlarX.add(25);
        kenarKordinatlarY.add(150 + r);
        g.setColor(Color.cyan);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString(harfler[0], 25 + Rr, 150 + 45 + r);
        g.setColor(Color.BLACK);

        if (gelendugumsayisi1 == 2) {
            g.fillOval(25 + 125, 150 - 125 + r, R, R); // 2GENE ÖZEL
            kenarKordinatlarX.add(25 + 125);
            kenarKordinatlarY.add(150 - 125 + r);
            g.setColor(Color.cyan);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString(harfler[1], 25 + 125 + Rr, 150 - 125 + 45 + r);
            g.setColor(Color.BLACK);

        } else if (gelendugumsayisi1 == 3) {
            g.fillOval(25 + 125, 150 - 125 + r, R, R); // 3GENE ÖZEL
            kenarKordinatlarX.add(25 + 125);
            kenarKordinatlarY.add(150 - 125 + r);
            g.setColor(Color.cyan);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString(harfler[1], 25 + 125 + Rr, 150 - 125 + 45 + r);
            g.setColor(Color.BLACK);
            g.fillOval(25 + (125 * ((gelendugumsayisi1 / 2) + 1)), 150 + r, R, R);
            kenarKordinatlarX.add(25 + (125 * ((gelendugumsayisi1 / 2) + 1)));
            kenarKordinatlarY.add(150 + r);
            g.setColor(Color.cyan);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString(harfler[2], 25 + (125 * ((gelendugumsayisi1 / 2) + 1)) + Rr, 150 + 45 + r);
            g.setColor(Color.BLACK);

        } else if (gelendugumsayisi1 == 4) {
            g.fillOval(25 + 125, 150 - 125 + r, R, R); // 4GENE ÖZEL
            kenarKordinatlarX.add(25 + 125);
            kenarKordinatlarY.add(150 - 125 + r);
            g.setColor(Color.cyan);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString(harfler[1], 25 + 125 + Rr, 150 - 125 + 45 + r);
            g.setColor(Color.BLACK);

            g.fillOval(25 + 125, 150 + 125 + r, R, R);
            kenarKordinatlarX.add(25 + 125);
            kenarKordinatlarY.add(150 + 125 + r);
            g.setColor(Color.cyan);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString(harfler[2], 25 + 125 + Rr, 150 + 125 + 45 + r);
            g.setColor(Color.BLACK);

            g.fillOval(25 + 125 * 2, 150 + r, R, R);
            kenarKordinatlarX.add(25 + 125 * 2);
            kenarKordinatlarY.add(150 + r);
            g.setColor(Color.cyan);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString(harfler[3], 25 + (125 * ((gelendugumsayisi1 / 2))) + Rr, 150 + 45 + r);
            g.setColor(Color.BLACK);
        } else if (gelendugumsayisi1 > 4) {

            if (gelendugumsayisi1 % 2 == 0) {
                int gelendugumsayisi1Ozel = gelendugumsayisi1 - 1;
                int k = 0;

                for (int i = 0; i < ((gelendugumsayisi1Ozel / 2)); i++) {
                    k = k + 1;
                    g.fillOval(25 + 125 * (i + 1), 150 - 125 + r, R, R);
                    kenarKordinatlarX.add(25 + 125 * (i + 1));
                    kenarKordinatlarY.add(150 - 125 + r);
                    g.setColor(Color.cyan);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                    g.drawString(harfler[k], 25 + 125 * (i + 1) + Rr, 150 - 125 + 45 + r);
                    g.setColor(Color.BLACK);
                    k = k + 1;
                    g.fillOval(25 + 125 * (i + 1), 150 + 125 + r, R, R);
                    kenarKordinatlarX.add(25 + 125 * (i + 1));
                    kenarKordinatlarY.add(150 + 125 + r);
                    g.setColor(Color.cyan);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                    g.drawString(harfler[k], 25 + 125 * (i + 1) + Rr, 150 + 125 + 45 + r);
                    g.setColor(Color.BLACK);

                }
                g.fillOval(25 + 125 * (gelendugumsayisi1Ozel / 2 + 1), 150 + r, R, R); //SON NODE
                kenarKordinatlarX.add(25 + 125 * (gelendugumsayisi1Ozel / 2 + 1));
                kenarKordinatlarY.add(150 + r);
                g.setColor(Color.cyan);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                g.drawString(harfler[gelendugumsayisi1Ozel], 25 + 125 * (gelendugumsayisi1Ozel / 2 + 1) + Rr, 150 + 45 + r);
                g.setColor(Color.BLACK);
            } else if (gelendugumsayisi1 % 2 == 1) {
                int k = 0;
                for (int i = 0; i < ((gelendugumsayisi1 / 2)); i++) {
                    k = k + 1;
                    g.fillOval(25 + 125 * (i + 1), 150 - 125 + r, R, R);
                    kenarKordinatlarX.add(25 + 125 * (i + 1));
                    kenarKordinatlarY.add(150 - 125 + r);
                    g.setColor(Color.cyan);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                    g.drawString(harfler[k], 25 + 125 * (i + 1) + Rr, 150 - 125 + 45 + r);
                    g.setColor(Color.BLACK);
                    k = k + 1;
                    g.fillOval(25 + 125 * (i + 1), 150 + 125 + r, R, R);
                    kenarKordinatlarX.add(25 + 125 * (i + 1));
                    kenarKordinatlarY.add(150 + 125 + r);
                    g.setColor(Color.cyan);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                    g.drawString(harfler[k], 25 + 125 * (i + 1) + Rr, 150 + 125 + 45 + r);
                    g.setColor(Color.BLACK);

                }
            }
        }
        for (int i = 0; i < gelendugumsayisi1; i++) {
            if (harfler[i].equals(baslangicNode1)) {

                g.setColor(new Color(0, 100, 200));
                g.fillOval(kenarKordinatlarX.get(i), kenarKordinatlarY.get(i), R, R);
                g.setColor(Color.cyan);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                g.drawString(harfler[i], kenarKordinatlarX.get(i) + Rr, kenarKordinatlarY.get(i) + 45);
                g.setColor(Color.BLACK);

            }
            if (harfler[i].equals(bitisNode1)) {

                g.setColor(new Color(205, 85, 85));
                g.fillOval(kenarKordinatlarX.get(i), kenarKordinatlarY.get(i), R, R);
                g.setColor(Color.cyan);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                g.drawString(harfler[i], kenarKordinatlarX.get(i) + Rr, kenarKordinatlarY.get(i) + 45);
                g.setColor(Color.BLACK);
            }

        }

    }

    public void cizgiCiz(Graphics g) {
        g.setColor(Color.BLACK);
        graph = new int[gelendugumsayisi1][gelendugumsayisi1];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = 0;

            }
        }

        for (int i = 0; i < gelendugumlerbilgi1.length; i++) {
            for (int j = 0; j < gelendugumsayisi1; j++) {
                if (harfler[j].equals(gelendugumlerbilgi1[i][0])) {
                    drawkordinatX1.add(kenarKordinatlarX.get(j) + r);
                    drawkordinatY1.add(kenarKordinatlarY.get(j) + r);
                    int graphX = Arrays.binarySearch(harfler, gelendugumlerbilgi1[i][0]);
                    int graphY = Arrays.binarySearch(harfler, gelendugumlerbilgi1[i][1]);
                    int graphSonuc = Integer.parseInt(gelendugumlerbilgi1[i][2]);

                    graph[graphX][graphY] = graphSonuc;
                }

            }

        }
        for (int i = 0; i < gelendugumlerbilgi1.length; i++) {
            for (int j = 0; j < gelendugumsayisi1; j++) {

                if (harfler[j].equals(gelendugumlerbilgi1[i][1])) {
                    drawkordinatX2.add(kenarKordinatlarX.get(j) + r);
                    drawkordinatY2.add(kenarKordinatlarY.get(j) + r);
                }

            }

        }
    }

    public void sifirla() {

        drawkordinatX1.clear();
        drawkordinatY1.clear();
        drawkordinatX2.clear();
        drawkordinatY2.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vedat = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        hatbilgisiLabel = new javax.swing.JLabel();
        maxflowButon = new javax.swing.JButton();
        maxflowsayisi = new javax.swing.JLabel();
        mincutButon = new javax.swing.JButton();
        flowsayisi = new javax.swing.JLabel();
        mincutsayisi = new javax.swing.JLabel();
        orjinalgraphButon = new javax.swing.JButton();
        yenihavuzproblemiButon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HAVUZ PROBLEMİ");
        setLocation(new java.awt.Point(275, 75));
        setResizable(false);

        vedat.setPreferredSize(new java.awt.Dimension(1100, 720));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        hatbilgisiLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        hatbilgisiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hatbilgisiLabel.setText("BAŞLANGIÇ - BİTİŞ - KAPASİTE");

        javax.swing.GroupLayout vedatLayout = new javax.swing.GroupLayout(vedat);
        vedat.setLayout(vedatLayout);
        vedatLayout.setHorizontalGroup(
            vedatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vedatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(vedatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vedatLayout.createSequentialGroup()
                        .addComponent(hatbilgisiLabel)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vedatLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(285, 285, 285))))
        );
        vedatLayout.setVerticalGroup(
            vedatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vedatLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(hatbilgisiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        maxflowButon.setBackground(new java.awt.Color(136, 189, 0));
        maxflowButon.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        maxflowButon.setForeground(new java.awt.Color(0, 0, 0));
        maxflowButon.setText("MAX-FLOW");
        maxflowButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxflowButonActionPerformed(evt);
            }
        });

        maxflowsayisi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        maxflowsayisi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        mincutButon.setBackground(new java.awt.Color(136, 189, 0));
        mincutButon.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mincutButon.setForeground(new java.awt.Color(0, 0, 0));
        mincutButon.setText("MIN-CUT");
        mincutButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mincutButonActionPerformed(evt);
            }
        });

        flowsayisi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        flowsayisi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        mincutsayisi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mincutsayisi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        orjinalgraphButon.setBackground(new java.awt.Color(136, 189, 0));
        orjinalgraphButon.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        orjinalgraphButon.setForeground(new java.awt.Color(0, 0, 0));
        orjinalgraphButon.setText("ORJİNAL GRAPH");
        orjinalgraphButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orjinalgraphButonActionPerformed(evt);
            }
        });

        yenihavuzproblemiButon.setBackground(new java.awt.Color(255, 192, 0));
        yenihavuzproblemiButon.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        yenihavuzproblemiButon.setForeground(new java.awt.Color(0, 0, 0));
        yenihavuzproblemiButon.setText("YENİ HAVUZ PROBLEMİ");
        yenihavuzproblemiButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yenihavuzproblemiButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vedat, javax.swing.GroupLayout.DEFAULT_SIZE, 1312, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(flowsayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxflowButon, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxflowsayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mincutButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mincutsayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orjinalgraphButon, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(yenihavuzproblemiButon)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(vedat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(orjinalgraphButon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(yenihavuzproblemiButon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(maxflowButon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mincutButon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(flowsayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(maxflowsayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(mincutsayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maxflowButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxflowButonActionPerformed
        // TODO add your handling code here:
        MaxFlowbutonaBasildimi = true;
        int starter = Arrays.binarySearch(harfler, baslangicNode1);
        int finisher = Arrays.binarySearch(harfler, bitisNode1);

        MaxFlow m = new MaxFlow();
        m.setV(gelendugumsayisi1);
        m.fordFulkerson(graph, starter, finisher);
        flowsayisi.setText("YolSayısı:" + m.getK());
        maxflowsayisi.setText("Max Flow:" + m.fordFulkerson(graph, starter, finisher));

        String[] yollar = m.getSonoooo().substring(0, m.getSonoooo().length() / 2).split("" + finisher);

        for (int i = 0; i < yollar.length; i++) {
            yollar[i] = yollar[i].concat("" + finisher);

        }

        if (maxflowSayaci >= m.getK() / 2) {
            maxflowSayaci = 0;

        }

        for (int j = 1; j < yollar[maxflowSayaci].length(); j++) {

            int deger11 = Integer.parseInt(yollar[maxflowSayaci].substring(j - 1, j));
            drawkordinatX1.add(kenarKordinatlarX.get(deger11) + r);
            drawkordinatY1.add(kenarKordinatlarY.get(deger11) + r);

            if (j == yollar[maxflowSayaci].length() - 1) {

                int deger22 = Integer.parseInt(yollar[maxflowSayaci].substring(j));
                drawkordinatX2.add(kenarKordinatlarX.get(deger22) + r);
                drawkordinatY2.add(kenarKordinatlarY.get(deger22) + r);
            } else {

                int deger22 = Integer.parseInt(yollar[maxflowSayaci].substring(j, j + 1));
                drawkordinatX2.add(kenarKordinatlarX.get(deger22) + r);
                drawkordinatY2.add(kenarKordinatlarY.get(deger22) + r);
            }
        }

        System.out.println("XY1: " + drawkordinatX1 + drawkordinatY1 + " XY2: " + drawkordinatX2 + drawkordinatY2);
        toplamKenarsayilari = gelenkenarsayisi1 + yollar[maxflowSayaci].length() - 1;

        maxflowSayaci++;

        repaint();


    }//GEN-LAST:event_maxflowButonActionPerformed

    private void mincutButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mincutButonActionPerformed
        // TODO add your handling code here:
        MinCutBasildimi = true;
        int starter = Arrays.binarySearch(harfler, baslangicNode1);
        int finisher = Arrays.binarySearch(harfler, bitisNode1);

        mincutGraph gr = new mincutGraph();
        gr.minCut(graph, starter, finisher);
        mincutsayisi.setText("Kesilen Yol Sayısı:" + gr.getP());
        int fordakullanacagimizP = gr.getP();

        String[] gelenKesilecekYollarX = gr.getKesilecekYollarX();
        gr.setP(0);
        String[] gelenKesilecekYollarY = gr.getKesilecekYollarY();
        gr.setP(0);

        if (mincutSayaci >= gr.getP()) {
            mincutSayaci = 0;
        }

        for (int i = 0; i < fordakullanacagimizP; i++) {

            int deger11 = Integer.parseInt(gelenKesilecekYollarX[i]);
            drawkordinatX1.add(kenarKordinatlarX.get(deger11) + r);
            drawkordinatY1.add(kenarKordinatlarY.get(deger11) + r);

            int deger22 = Integer.parseInt(gelenKesilecekYollarY[i]);
            drawkordinatX2.add(kenarKordinatlarX.get(deger22) + r);
            drawkordinatY2.add(kenarKordinatlarY.get(deger22) + r);

        }
        System.out.println("mincutXY1: " + drawkordinatX1 + drawkordinatY1 + " minutXY2: " + drawkordinatX2 + drawkordinatY2);
        toplamKenarsayilari = gelenkenarsayisi1 + gelenKesilecekYollarX.length;

        mincutSayaci++;

        repaint();
    }//GEN-LAST:event_mincutButonActionPerformed

    private void orjinalgraphButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orjinalgraphButonActionPerformed
        // TODO add your handling code here:
        MaxFlowbutonaBasildimi = false;
        MinCutBasildimi = false;
        repaint();

    }//GEN-LAST:event_orjinalgraphButonActionPerformed

    private void yenihavuzproblemiButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yenihavuzproblemiButonActionPerformed
        // TODO add your handling code here:
        kenarKordinatlarX.clear();
        kenarKordinatlarY.clear();
        drawkordinatX1.clear();
        drawkordinatY1.clear();
        drawkordinatX2.clear();
        drawkordinatY2.clear();

        setVisible(false);
        new arayuz().setVisible(true);
    }//GEN-LAST:event_yenihavuzproblemiButonActionPerformed

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
            java.util.logging.Logger.getLogger(arayuzGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(arayuzGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(arayuzGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(arayuzGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new arayuzGraph().setVisible(true);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        noktaCiz(g);
        g.setColor(new Color(224, 255, 255));
        int xAdım = 0;
        int yAdım = 0;
        for (int i = 0; i < gelenkenarsayisi1; i++) {
            for (int j = 0; j < 3; j++) {

                g.setFont(new Font("TimesRoman", Font.PLAIN, 45 - gelenkenarsayisi1 * 15 / 10));
                g.drawString(gelendugumlerbilgi1[i][j], 1095 + xAdım, 220 - gelenkenarsayisi1 * 7 + yAdım);

                if (j < 2) {
                    g.drawString("-", 1130 + xAdım, 220 - gelenkenarsayisi1 * 7 + yAdım);
                }

                xAdım = xAdım + 70;
            }
            xAdım = 0;
            yAdım = yAdım + 50;
        }
        g.setColor(Color.BLACK);

        cizgiCiz(g);

        if (!MaxFlowbutonaBasildimi && !MinCutBasildimi) {
            g.setColor(Color.BLACK);
            for (int i = 0; i < gelenkenarsayisi1; i++) {
                g.drawLine(drawkordinatX1.get(i), drawkordinatY1.get(i), drawkordinatX2.get(i), drawkordinatY2.get(i));

            }
        }

        if (MaxFlowbutonaBasildimi) {
            g.setColor(Color.BLACK);
            for (int i = 0; i < toplamKenarsayilari; i++) {
                g.drawLine(drawkordinatX1.get(i), drawkordinatY1.get(i), drawkordinatX2.get(i), drawkordinatY2.get(i));

            }
            g.setColor(Color.YELLOW);

            for (int i = 0; i < toplamKenarsayilari - gelenkenarsayisi1; i++) {
                g.drawLine(drawkordinatX1.get(i), drawkordinatY1.get(i), drawkordinatX2.get(i), drawkordinatY2.get(i));

            }

            MaxFlowbutonaBasildimi = false;
            toplamKenarsayilari = 0;

        }

        if (MinCutBasildimi) {

            g.setColor(Color.BLACK);
            for (int i = 0; i < toplamKenarsayilari; i++) {
                g.drawLine(drawkordinatX1.get(i), drawkordinatY1.get(i), drawkordinatX2.get(i), drawkordinatY2.get(i));

            }

            g.setColor(Color.CYAN);

            for (int i = 0; i < toplamKenarsayilari - gelenkenarsayisi1; i++) {
                g.drawLine(drawkordinatX1.get(i), drawkordinatY1.get(i), drawkordinatX2.get(i), drawkordinatY2.get(i));

            }
            MinCutBasildimi = false;
            toplamKenarsayilari = 0;
        }

        noktaCiz(g);

        System.out.println("Düğümlerin Koordinatları: " + kenarKordinatlarX + " " + kenarKordinatlarY);
        System.out.println("Kenar Başlangıç Koordinatları: " + drawkordinatX1 + " " + drawkordinatY1);
        System.out.println("Kenar Bitiş Koordinatları: " + drawkordinatX2 + " " + drawkordinatY2);
        System.out.println("===============================================");
        //kenarKordinatlarX.clear();
        //kenarKordinatlarY.clear();
        sifirla();

        System.out.println("Graph_Matris Gösterimi:");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + "   ");

            }
            System.out.println(" ");
        }
        System.out.println("======================");

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel flowsayisi;
    private javax.swing.JLabel hatbilgisiLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton maxflowButon;
    private javax.swing.JLabel maxflowsayisi;
    private javax.swing.JButton mincutButon;
    private javax.swing.JLabel mincutsayisi;
    private javax.swing.JButton orjinalgraphButon;
    private javax.swing.JPanel vedat;
    private javax.swing.JButton yenihavuzproblemiButon;
    // End of variables declaration//GEN-END:variables

}
