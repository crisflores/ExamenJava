import java.util.ArrayList;

public class Matriz {
	
	public static int solucion (int filas, int columnas, int [] [] matriz) {
		ArrayList<Integer> resultados = new ArrayList<Integer>();
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				calcular(1, matriz, i, j, filas, columnas, 0, 0, resultados);
			}
		}
		return mayor(resultados);
	}

	private static void calcular(int res, int [] [] matriz,int filas, int columnas, int fil, int col, int mod, int sentido, ArrayList<Integer> resultados) {
		if(filas < 0 || filas > fil-1 || columnas < 0 || columnas > col-1 || sentido >= 2) {
			return;
		}
		if(mod == 1) {
			calcular(res*matriz[filas][columnas], matriz, filas-1, columnas, fil, col, 1, sentido, resultados);
			calcular(res*matriz[filas][columnas], matriz, filas, columnas-1, fil, col, 2, sentido+1, resultados);
			calcular(res*matriz[filas][columnas], matriz, filas, columnas+1, fil, col, 4, sentido+1, resultados);
		}
		if(mod == 2) {
			calcular(res*matriz[filas][columnas], matriz, filas-1, columnas, fil, col, 1, sentido+1, resultados);
			calcular(res*matriz[filas][columnas], matriz, filas, columnas-1, fil, col, 2, sentido, resultados);
			calcular(res*matriz[filas][columnas], matriz, filas+1, columnas, fil, col, 3, sentido+1, resultados);
		}
		if(mod == 3) {
			calcular(res*matriz[filas][columnas], matriz, filas, columnas-1, fil, col, 2, sentido+1, resultados);
			calcular(res*matriz[filas][columnas], matriz, filas+1, columnas, fil, col, 3, sentido, resultados);
			calcular(res*matriz[filas][columnas], matriz, filas, columnas+1, fil, col, 4, sentido+1, resultados);
		}
		if(mod == 4) {
			calcular(res*matriz[filas][columnas], matriz, filas-1, columnas, fil, col, 1, sentido+1, resultados);
			calcular(res*matriz[filas][columnas], matriz, filas+1, columnas, fil, col, 3, sentido+1, resultados);
			calcular(res*matriz[filas][columnas], matriz, filas, columnas+1, fil, col, 4, sentido, resultados);
		}
		if(mod == 0) {
			calcular(res*matriz[filas][columnas], matriz, filas-1, columnas, fil, col, 1, sentido, resultados);
			calcular(res*matriz[filas][columnas], matriz, filas, columnas-1, fil, col, 2, sentido, resultados);
			calcular(res*matriz[filas][columnas], matriz, filas+1, columnas, fil, col, 3, sentido, resultados);
			calcular(res*matriz[filas][columnas], matriz, filas, columnas+1, fil, col, 4, sentido, resultados);
		}
		resultados.add(cantidad_ceros(res*matriz[filas][columnas]));
		return;
	}

	private static int mayor(ArrayList<Integer> resultados) {
	    int mayor=resultados.get(0);
		for(int i : resultados)
	        if(i > mayor)
	            mayor = i;
		return mayor;
	}

	private static int cantidad_ceros(int i) {
		int j=0;
		while(i % 10 == 0) {
			i = i/10;
			j++;
		}
		return j;
	}
}
