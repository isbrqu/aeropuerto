package conjuntistas.ArbolAVL;

public class TestAVL {

  public static void print(Object object) {
    System.out.println(object.toString());
  }

  public static void main(String[] args) {
    rotarIzquierda1();
    rotarIzquierda2();
  }

  public static void rotarIzquierda1() {
    print("TEST SET 1 - Rotacion izquierda");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {1, 5, 9};
    arbol.llenar(serie);
    print(arbol);
  }

  public static void rotarIzquierda2() {
    print("TEST SET 2 - Rotacion izquierda");
    ArbolAVL arbol = new ArbolAVL();
    int[] serie = {3, 2, 5, 1, 8};
    arbol.llenar(serie);
    print(arbol);
  }

  // public static void rotarDerecha() {
  //   print("TEST SET 2 - Rotacion derecha");
  //   ArbolAVL arbol = new ArbolAVL();
  //   int[] num = {9, 5, 1};
  //   arbol.llenar(num);
  //   print(arbol);
  // }

  // public static void rotarDerechaIzquierda() {
  //   print("TEST SET n - Rotacion derecha-izquierda");
  //   ArbolAVL arbol = new ArbolAVL();
  //   int[] num = {1, 5, 9, 7, 9, 8};
  //   arbol.llenar(num);
  //   print(arbol);
  // }

}
