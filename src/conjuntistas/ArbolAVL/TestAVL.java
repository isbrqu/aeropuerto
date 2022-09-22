package conjuntistas.ArbolAVL;
import conjuntistas.ArbolAVL.test.RotacionSimple;
import conjuntistas.ArbolAVL.test.RotacionDoble;
import conjuntistas.ArbolAVL.test.TestInsertar;
import conjuntistas.ArbolAVL.test.TestEliminar;
import conjuntistas.ArbolAVL.test.CrearArbol;

public class TestAVL {

  public static void main(String[] args) throws Exception {
    Nodo raiz = CrearArbol.inclinado(3, -1);
    ArbolAVL arbol = new ArbolAVL();
    arbol.setRaiz(raiz);
    arbol.rellenarNodos();
    System.out.println(arbol);
  }

}
