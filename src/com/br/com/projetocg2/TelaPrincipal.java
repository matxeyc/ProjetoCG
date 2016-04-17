package com.br.com.projetocg2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField_x1_reta;
	private JTextField textField_y1_reta;
	private JTextField textField_y2_reta;
	private JTextField textField_x2_reta;
	private JTextField textField_Raio;
	static BufferedImage buffer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		this.setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1350, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 1350, 730));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		tabbedPane.addTab("Reta", null, panel_1, null);
		
		textField_x1_reta = new JTextField();
		textField_x1_reta.setColumns(10);
		
		textField_y1_reta = new JTextField();
		textField_y1_reta.setColumns(10);
		
		textField_y2_reta = new JTextField();
		textField_y2_reta.setColumns(10);
		
		textField_x2_reta = new JTextField();
		textField_x2_reta.setColumns(10);
		
		/*
		 * Botão DDA: Calcula a reta com o algoritmo DDA Simples.
		 * */
		JButton btn_Dda = new JButton("DDA");
		btn_Dda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int X1 = Integer.parseInt(textField_x1_reta.getText());
				int X2 = Integer.parseInt(textField_x2_reta.getText());
				int Y1 = Integer.parseInt(textField_y1_reta.getText());
				int Y2 = Integer.parseInt(textField_y2_reta.getText());
				
				MetodosDeImagem.limparTela();
				repaint();
				MetodosDeDesenho.dda(buffer, X1, X2, Y1, Y2);
			}
		});
		/*
		 * Botão Ponto Médio: Calcula a reta com o algoritmo de ponto médio.
		 * */
		JButton btn_pontoMedio = new JButton("Ponto M\u00E9dio");
		btn_pontoMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int X1 = Integer.parseInt(textField_x1_reta.getText());
				int X2 = Integer.parseInt(textField_x2_reta.getText());
				int Y1 = Integer.parseInt(textField_y1_reta.getText());
				int Y2 = Integer.parseInt(textField_y2_reta.getText());
				
				MetodosDeImagem.limparTela();
				repaint(); // atualiza a tela
				MetodosDeDesenho.inc_line(X1, X2, Y1, Y2);
			}
		});
		
		JLabel lblValorDeX = new JLabel("Valor de X1:");
		lblValorDeX.setFont(new Font("Consolas", Font.ITALIC, 14));
		
		JLabel lblValorDeX_1 = new JLabel("Valor de X2:");
		lblValorDeX_1.setFont(new Font("Consolas", Font.ITALIC, 14));
		
		JLabel lblValorDeY = new JLabel("Valor de Y1:");
		lblValorDeY.setFont(new Font("Consolas", Font.ITALIC, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Valor de Y2:");
		lblNewLabel_1.setFont(new Font("Consolas", Font.ITALIC, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblValorDeX)
						.addComponent(lblValorDeX_1))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(btn_Dda))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_x2_reta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_x1_reta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(31)
							.addComponent(btn_pontoMedio))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_y2_reta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblValorDeY)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_y1_reta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorDeX)
						.addComponent(textField_x1_reta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValorDeY)
						.addComponent(textField_y1_reta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorDeX_1)
						.addComponent(textField_x2_reta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_y2_reta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_pontoMedio)
						.addComponent(btn_Dda))
					.addContainerGap(518, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel(MetodosDeImagem.criarImagem());
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("C\u00EDrculo", null, panel, null);
		
		JLabel label = new JLabel("Desenhar C\u00EDrculo");
		panel.add(label);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setText("Raio da Circunfer\u00EAncia:");
		panel.add(textArea_4);
		
		textField_Raio = new JTextField();
		textField_Raio.setColumns(10);
		panel.add(textField_Raio);
		
		JButton btn_Circulo = new JButton("C\u00EDrculo");
		btn_Circulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int raio = Integer.parseInt(textField_Raio.getText());
				MetodosDeImagem.limparTela();
				repaint();
				MetodosDeDesenho.MidPointCircle(raio);
			}
		});
		panel.add(btn_Circulo);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
					.addGap(156)
					.addComponent(lblNewLabel)
					.addGap(50))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 659, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(59, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
