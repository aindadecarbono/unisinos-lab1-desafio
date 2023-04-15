public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        
        int[] data = verificarData(dia, mes, ano);

        this.dia = data[0];
        this.mes = data[1];
        this.ano = data[2];
    }

    private int[] verificarData(int dia, int mes, int ano) {

        int[] data = new int[3];

        if(dia <= 0 || dia >= 32 || mes <= 0 || mes >= 13){

            retornarDataInvalida(data);

        }

        if ((dia == 31) && (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 10)){

            retornarDataInvalida(data);

        }

        if(!verificarAnoBissexto(ano)){

            if (dia == 29 && mes == 2){
                  retornarDataInvalida(data);
            }
        }

        return data;
    }

    private int[] retornarDataInvalida(int[] data) {
        System.out.println("Data inválida. \nData padrão: 1/1/2000");
        dia = 1;
        mes = 1;
        ano = 2000;

        data[0] = dia;
        data[1] = mes;
        data[2] = ano;

        return data;
    }

    private Boolean verificarAnoBissexto(int ano) {

        if(ano % 4 == 0){
            return true;
        }
        else {
            return false;
        }

    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return dia + "\\/" + mes + "\\/" + ano;
    }
}
