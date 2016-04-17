package com.br.com.projetocg2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class MetodosDeImagem {
	private static BufferedImage buffer;
	private static Graphics g;
	
	public static ImageIcon criarImagem(){
		
		int width = 600;
		int height = 600;
		buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);// Cria um buffer Fundo preto
		
		
		g = buffer.createGraphics();
		desenharPlano();
		return new ImageIcon(buffer);
	}
	
	public static void setPixel(double x, double y){
		buffer.setRGB(300 + (int)(Math.round(x)), 300 - (int)(Math.round(y)) , Color.red.getRGB());// plotar pixel primeira coordenada é coluna y e a segunda é a linha x
		
	}//Fim do método setPixel() com parâmetro
	
	
	public static void limparTela(){
		for(int i = 0; i < 600; i++){
			for(int j = 0; j<600; j++){
				buffer.setRGB(i, j, Color.BLACK.getRGB());
			}
		}
		desenharPlano();
	}
	
	public static void desenharPlano(){
		g.setColor(Color.WHITE);
		g.drawLine(300, 0,300 , 600);
		g.drawLine(0, 300,600 ,300);
	}
	
}
