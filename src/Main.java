
public class Main {
    public static void main(String[] args) {
        cadastroVIEW cadView = new cadastroVIEW();
        cadView.setVisible(true);
        ProdutosDAO prodDAO = new ProdutosDAO();
        
        prodDAO.cadastrarProduto();
    }
    
}
