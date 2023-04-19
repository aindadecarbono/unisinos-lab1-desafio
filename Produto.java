public class Produto {
    private String nome;

    private double preco;

    private Data dataValidade;

    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public boolean estaVencido(Data dataAtual){

        if (dataAtual.getAno() > this.dataValidade.getAno()){

            return true;

        } else if (dataAtual.getAno() < this.dataValidade.getAno()){

            return false;

        } else if(dataAtual.getMes() > this.dataValidade.getMes()){

            return true;

        } else if (dataAtual.getMes() < this.dataValidade.getMes()){

            return false;

        } else if (dataAtual.getDia() > this.dataValidade.getDia()){

            return true;

        } else {

            return false;

        }
    }
}
