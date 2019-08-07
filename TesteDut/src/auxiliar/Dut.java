package auxiliar;

public class Dut {
	String nomeComprador;
	String valor;
	String rg;
	String cpf;
	String endereco;
	String localData;
	
	public String getNomeComprador() {
		return nomeComprador;
	}
	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getLocalData() {
		return localData;
	}
	public void setLocalData(String localData) {
		this.localData = localData;
	}
	@Override
	public String toString() {
		return "Dut [nomeComprador=" + nomeComprador + ", valor=" + valor + ", rg=" + rg + ", cpf=" + cpf
				+ ", endereco=" + endereco + ", localData=" + localData + "]";
	}
	
	
	
}
