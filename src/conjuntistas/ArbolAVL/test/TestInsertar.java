package conjuntistas.ArbolAVL.test;
import conjuntistas.ArbolAVL.ArbolAVL;

public class TestInsertar {

  public static void print(Object object) {
    System.out.println(object.toString());
  }

  public static void repetidoIterativo() throws Exception {
    print("TEST - repetido iterativo");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {4, 2, 6, 1, 3, 5, 7};
    arbol.llenar(serie);
    for (int num : serie)
      System.out.println("inserta " + num + ": " + arbol.insertar(num));
    print(arbol);
  }

}
