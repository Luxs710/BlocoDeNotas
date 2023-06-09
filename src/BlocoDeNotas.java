import java.io.*;
import java.util.ArrayList;




// é necessário colocar o implements Serializable porque sim 💀
// o mesmo se aplica à classe Anotacao
public class BlocoDeNotas implements Serializable{
    private ArrayList<Anotacao> anotacoes = new ArrayList<>();


    public void adicionar(Anotacao anotacaoParaAdicionar){
        anotacoes.add(anotacaoParaAdicionar);
        anotacaoParaAdicionar.setNumero(anotacoes.indexOf(anotacaoParaAdicionar));
    }

    public void editar(int numero){
        Anotacao anotacaoParaEditar = anotacoes.get(numero);

        try {
            anotacaoParaEditar.editar();
        } catch (AnotacaoException e) {
            System.err.println(e.getMessage());
        }
    }

    public void apagar(int numero){
        Anotacao anotacaoParaApagar = anotacoes.get(numero);

        try {
            anotacaoParaApagar.apagar();
        } catch (Exception e) {
            System.err.println(e.getMessage());;
        }
    }

    public void buscar(String textoParaBuscar){

        for(int i = 0; i<anotacoes.size(); i++){
            Anotacao anotacaoAtual = anotacoes.get(i);

            if(anotacaoAtual.temTexto(textoParaBuscar) && !anotacaoAtual.getApagada()){
                System.out.println(anotacaoAtual.getNumero()+" "+ anotacaoAtual.getTexto()+" "+anotacaoAtual.getData());
            }
        }

    }

    public void verAnotacoes(){
        for(int i = 0; i<anotacoes.size(); i++){
            Anotacao anotacaoAtual = anotacoes.get(i);
            if(!anotacaoAtual.getApagada()) {
                System.out.println(anotacaoAtual.getNumero() + " " + anotacaoAtual.getTexto() + " " + anotacaoAtual.getData());
            }
        }
    }

    public ArrayList<Anotacao> getAnotacoes(){
        return anotacoes;
    }

    //[anotacao1, anotacao2, anotacao3, anotacao4]
    //    0          1           2         3
}
