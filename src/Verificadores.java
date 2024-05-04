import java.util.ArrayList;
public class Verificadores {
    public boolean existeItem(ArrayList<Produto> listaProdutos){
        int tamanhoLista = listaProdutos.size();
        boolean existe = true;
        if(tamanhoLista == 0){
            existe = false;
        }
        return existe;
    }
}
