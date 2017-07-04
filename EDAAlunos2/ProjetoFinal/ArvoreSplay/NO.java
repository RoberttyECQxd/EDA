package ArvoreSplay;

public class NO <T, Info> {
	
	private T chave;
	private NO<T, Info> esq;
	private NO<T, Info> dir;
	private Info info;
	
	public NO(T chave){
		this.chave = chave;
		this.esq = null;
		this.dir = null;
	}

	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
	}

	public NO<T, Info> getEsq() {
		return esq;
	}

	public void setEsq(NO<T, Info> esq) {
		this.esq = esq;
	}

	public NO<T, Info> getDir() {
		return dir;
	}

	public void setDir(NO<T, Info> dir) {
		this.dir = dir;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
}
