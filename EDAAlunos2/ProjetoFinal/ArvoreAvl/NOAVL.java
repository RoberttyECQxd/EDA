package ArvoreAvl;

public class NOAVL <T, Info> {
	
	private T valor;
	private int altura;
	private NOAVL<T, Info> direito;
	private NOAVL<T, Info> esquerdo;
	private Info infor;
	
	public NOAVL(T valor) {
		this.valor = valor;
		this.setAltura(1);
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public NOAVL<T, Info> getDireito() {
		return direito;
	}

	public void setDireito(NOAVL<T, Info> direito) {
		this.direito = direito;
	}

	public NOAVL<T, Info> getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(NOAVL<T, Info> esquerdo) {
		this.esquerdo = esquerdo;
	}

	public Info getInfor() {
		return infor;
	}

	public void setInfor(Info infor) {
		this.infor = infor;
	}
		
}
