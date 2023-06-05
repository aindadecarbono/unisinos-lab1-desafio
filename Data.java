public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        verificarData(dia, mes, ano);
    }

    public void verificarData(int dia, int mes, int ano) {

        if(dia <= 0 || dia >= 32 || mes <= 0 || mes >= 13){

            retornarDataInvalida();

        }

        if ((dia == 31) && (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 10)){

            retornarDataInvalida();

        }

        if(!verificarAnoBissexto(ano)){

            if (dia == 29 && mes == 2){
                  retornarDataInvalida();
            }
        }

    }

    private void retornarDataInvalida() {
        System.out.println("DATA INVÁLIDA. \nData padrão: 1/1/2023");

        setDia(1);
        setMes(1);
        setAno(2023);

    }

    public Boolean verificarAnoBissexto(int ano) {

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
        return dia + "/" + mes + "/" + ano;
    }
}
