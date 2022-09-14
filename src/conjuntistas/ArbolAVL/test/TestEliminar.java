package conjuntistas.ArbolAVL.test;
import conjuntistas.ArbolAVL.ArbolAVL;

public class TestEliminar {

  public static void print(Object object) {
    System.out.println(object.toString());
  }

  public static void eliminarRotandoDerecha() throws Exception {
    print("TEST - eliminarRotandoDerecha");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {4, 2, 5, 1, 3};
    arbol.llenar(serie);
    arbol.eliminar(5);
    print(arbol);
  }

}
