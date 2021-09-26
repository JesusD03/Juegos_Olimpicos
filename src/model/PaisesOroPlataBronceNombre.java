package model;

import java.util.Comparator;

public class PaisesOroPlataBronceNombre implements Comparator<Pais>{

	// 0 si son iguales, 1 si o1 es mayor al o2, -1 si o1 es menor a o2
	//en esta caso inverti los resultados 1 y -1 ya que la salida tienen que estar de manera desendente
	@Override
	public int compare(Pais o1, Pais o2) {
		//aqui compara por medalla de oro
		if(o1.getmOro() > o2.getmOro()) {
			return -1;
		}else if (o1.getmOro() < o2.getmOro()) {
			return 1;
		}else {
			//aqui compara por medalla de plata
			if(o1.getmPlata() > o2.getmPlata()) {
				return -1;
			}else if(o1.getmPlata() < o2.getmPlata()) {
				return 1;
			}else {
				//aqui compara por medalla de bronce
				if(o1.getmBronce() > o2.getmBronce()) {
					return -1;
				}else if(o1.getmBronce() < o2.getmBronce()) {
					return 1;
				}else {
					//finalmente compara por nombre
					return o1.getName().compareTo(o2.getName());
				}
			}
		}
	}
	
}
