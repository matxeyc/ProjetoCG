package com.br.com.projetocg2;

import java.awt.image.BufferedImage;

public class MetodosDeDesenho {
	
	static void MidPointCircle( int raio) {

		int r = raio;
		int x;
		int y;
		float d;
		/* Valores iniciais */
		x = 0;
		y = r;
		d = 5 / 4 - r;
		CirclePoints(x, y);
		while (y > x) {
			if (d < 0) {
				/* Selecione E */
				d = d + 2 * x + 3;
				x++;
			} else {
				/* Selecione SE */
				d = d + 2 * (x - y) + 5;
				x++;
				y--;
			} /* end if */
			CirclePoints(x, y);
		} /* end while */

	}/* end MidpointCircle */

	static void CirclePoints(int x, int y) {
		MetodosDeImagem.setPixel(x, y);
		MetodosDeImagem.setPixel(x, -y);
		MetodosDeImagem.setPixel(-x, y);
		MetodosDeImagem.setPixel(-x, -y);
		MetodosDeImagem.setPixel(y, x);
		MetodosDeImagem.setPixel(y, -x);
		MetodosDeImagem.setPixel(-y, x);
		MetodosDeImagem.setPixel(-y, -x);
	}/* end CirclePoints */
	
public static  void dda(BufferedImage buffer, int X1, int X2, int Y1, int Y2){
		
		double    Length=0;
		double X=0,Y=0,Xinc=0.0,Yinc=0;
		
		Length = Math.abs(X2 - X1);
		if ( Math.abs(Y2 - Y1)  > Length){
			Length = Math.abs(Y2-Y1);
		}
		Xinc = (X2 - X1)/Length;
		Yinc = (Y2 - Y1)/Length;
		X = X1;
		Y = Y1;
		MetodosDeImagem.setPixel(X, Y);

		while(X<X2){
		  X = X + Xinc;
		  Y = Y + Yinc;
		  MetodosDeImagem.setPixel(X, Y);
		 
		  }
	}//Fim do método dda()
	
	public static void inc_line(int X1, int X2, int Y1, int Y2){
		
		int dx, dy, incE, incNE, d, x, y;
		dx = X2 - X1;
		dy = Y2 - Y1;
		d = 2 * dy - dx; /* Valor inicial de d */
		incE = 2 * dy; /* Incremento de E */
		incNE = 2 * (dy - dx); /* Incremento de NE */
		x = X1;
		y = Y1;
		MetodosDeImagem.setPixel(x, y);
		while (x < X2){
			if (d <= 0){
				/* Escolhe E */
				d = d + incE;
				x = x + 1;
			}else{
				/* Escolhe NE */
				d = d + incNE;
				x = x + 1;
				y = y + 1;
			}/* end if */
			MetodosDeImagem.setPixel(x, y);
		}/* end while */
	}/* end inc_line */
}
