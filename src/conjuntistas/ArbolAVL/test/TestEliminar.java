package conjuntistas.ArbolAVL.test;
import conjuntistas.ArbolAVL.ArbolAVL;

public class TestEliminar {

  public static void print(Object object) {
    System.out.println(object.toString());
  }

  public static void rotandoDerechaBalanceNeutroEnRaiz() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {4, 2, 5, 1, 3};
    arbol.llenar(serie);
    arbol.eliminar(5);
    print(arbol);
  }

  public static void rotandoDerechaBalancePositivoEnRaiz() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {3, 2, 4, 1};
    arbol.llenar(serie);
    arbol.eliminar(4);
    print(arbol);
  }

  public static void rotandoDerechaBalanceNegativoEnRaiz() throws Exception {
    String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    print("TEST - " + methodName);
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {3, 1, 4, 2};
    arbol.llenar(serie);
    arbol.eliminar(4);
    print(arbol);
  }

}
