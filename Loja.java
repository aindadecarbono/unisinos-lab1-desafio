public class Loja {

    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;

    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, int estoqueProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[estoqueProdutos];

    }

    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int estoqueProdutos){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[estoqueProdutos];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Data getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    public double gastosComSalarios(){
        if (salarioBaseFuncionario == -1){
            return -1;
        }
        return quantidadeFuncionarios * salarioBaseFuncionario;
    }

    public char tamanhoDaLoja(){
        if (quantidadeFuncionarios < 10){
            return 'P';
        } else if (quantidadeFuncionarios >= 10 && quantidadeFuncionarios <= 30) {
            return 'M';
        } else{
            return 'G';
        }

    }

    public String imprimeProdutos(){
        String produto = "";
        for (Produto produtoArray:estoqueProdutos) {
            produto = produto + produtoArray + "|";
        }
        return produto;
    }

    public boolean insereProduto(Produto produto){
            int indexNulo = confereIndexNuloArrayEstoque();
            if (indexNulo == -1) {
                System.out.println("Não há espaço no estoque para inserir novo produto.");
                return false;
            } else {
                estoqueProdutos[indexNulo] = produto;
                System.out.println("Produto inserido no estoque.");
                return true;
            }
        }

        public boolean removeProduto(String nomeProduto){
            for (int i = 0; i < estoqueProdutos.length; i++){
                if (nomeProduto.toLowerCase() == estoqueProdutos[i].getNome().toLowerCase()){
                    estoqueProdutos[i] = null;
                    System.out.println(nomeProduto + " removido do estoque.");
                    return true;
                }
            }

            System.out.println(nomeProduto + " não está no estoque e, portanto, não foi removido");
            return false;

        }

    private int confereIndexNuloArrayEstoque() {
        int indexNulo = -1;

        for (int i = 0; i < estoqueProdutos.length; i++){
            if (estoqueProdutos[i] == null) indexNulo = i;
        }

        return indexNulo;
    }

    @Override
    public String toString() {
        return "Loja{" + "\n" +
                "nome = " + nome + "\n" +
                "quantidadeFuncionarios = " + quantidadeFuncionarios + "\n" +
                "salarioBaseFuncionario = " + salarioBaseFuncionario + "\n" +
                "endereco = " + endereco + "\n" +
                "dataFundacao = " + dataFundacao + "\n" +
                "estoqueProdutos = " + imprimeProdutos() +
                "\n}";
    }

}
