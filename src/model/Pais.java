package model;

public class Pais implements Comparable<Pais>{
	
	private String name;
	private int mOro;
	private int mPlata;
	private int mBronce;
	private int fOro;
	private int fPlata;
	private int fBronce;
	private int cOro;
	private int cPlata;
	private int cBronce;
	
	public Pais(String name, int mOro, int mPlata, int mBronce, int fOro, int fPlata, int fBronce) {
		this.name = name;
		this.mOro = mOro;
		this.mPlata = mPlata;
		this.mBronce = mBronce;
		this.fOro = fOro;
		this.fPlata = fPlata;
		this.fBronce = fBronce;
	}
	
	public Pais(String name, int cOro, int cPlata, int cBronce) {
		this.name = name;
		this.cOro = cOro;
		this.cPlata = cPlata;
		this.cBronce = cBronce;
		
	}
	
	public String getName() {
		return name;
	}

	public int getmOro() {
		return mOro;
	}

	public int getmPlata() {
		return mPlata;
	}

	public int getmBronce() {
		return mBronce;
	}

	public int getfOro() {
		return fOro;
	}

	public int getfPlata() {
		return fPlata;
	}

	public int getfBronce() {
		return fBronce;
	}

	public int getcOro() {
		return cOro;
	}

	public int getcPlata() {
		return cPlata;
	}

	public int getcBronce() {
		return cBronce;
	}

	// 0 si son iguales, 1 si es mayor a o, -1 si es menor a o
	@Override
	public int compareTo(Pais o) {
		//aqui compara por medalla de oro
				if(fOro > o.getfOro()) {
					return 1;
				}else if (fOro < o.getfOro()) {
					return -1;
				}else {
					//aqui compara por medalla de plata
					if(fPlata > o.getfPlata()) {
						return 1;
					}else if(fPlata < o.getfPlata()) {
						return -1;
					}else {
						//aqui compara por medalla de bronce
						if(fBronce > o.getfBronce()) {
							return 1;
						}else if(fBronce < o.getfBronce()) {
							return -1;
						}else {
							//finalmente compara por nombre
							return name.compareTo(o.getName());
						}
					}
				}
	}
	
	
	
}
