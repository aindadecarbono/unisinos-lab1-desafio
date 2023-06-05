import java.util.Arrays;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int quantidadeLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeLojas];
    }

    public boolean insereLoja(Loja loja){
        int indexNulo = confereIndexNuloArrayEstoque();
        if (indexNulo == -1) {
            System.out.println("Não há espaço para inserir nova loja.");
            return false;
        } else {
            lojas[indexNulo] = loja;
            System.out.println("Loja inserida no shopping.");
            return true;
        }
    }

    public boolean removeLoja(String nomeLoja){
        for (int i = 0; i < lojas.length; i++){
            if (nomeLoja.equalsIgnoreCase(lojas[i].getNome())){
                lojas[i] = null;
                System.out.println("Loja '" + nomeLoja + "' removida do estoque.");
                return true;
            }
        }

        System.out.println("Loja '" + nomeLoja + "' não está na lista e, portanto, não foi removida");
        return false;

    }

    public int quantidadeLojasPorTipo(String tipoLoja){
        int quantidadeLoja = 0;
        for (int i = 0; i<lojas.length; i++){
            if (lojas[i].getClass().getSimpleName().equalsIgnoreCase(tipoLoja)) quantidadeLoja++;
        }

        if (quantidadeLoja == 0) return -1;
        else return quantidadeLoja;
    }

    public Informatica lojaSeguroMaisCaro(){

        double maiorSeguro = 0.0;

        if (quantidadeLojasPorTipo("Informatica") == -1) return null;

        Informatica lojaInfo = null;

        for (int i = 0; i<lojas.length; i++){
            if (lojas[i] instanceof Informatica){
               double lojaInfoSeguro = ((Informatica) lojas[i]).getSeguroEletronicos();
                if (lojaInfoSeguro > maiorSeguro){
                    maiorSeguro = lojaInfoSeguro;
                    lojaInfo = (Informatica) lojas[i];
                }

            }
        }
        return lojaInfo;
    }

    private int confereIndexNuloArrayEstoque() {
        int indexNulo = -1;

        for (int i = 0; i < lojas.length; i++){
            if (lojas[i] == null){
                indexNulo = i;
                break;
            }
        }
        return indexNulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "nome = " + nome + "\n" +
                "endereco = " + endereco + "\n" +
                "lojas = " + Arrays.toString(lojas) +
                '}';
    }
}
