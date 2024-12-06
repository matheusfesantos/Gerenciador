package entites.produtos.Deletar;

public class Deletar {

    static String deletar;
    public Deletar(String deletar){
        this.deletar = deletar;
    }

    @Override
    public String toString(){

        if (deletar != null){
         return deletar + " foi deletado";
        }
        else{
            return "Esse produto não existe";
        }
    }
}
