package conjuntistas.ArbolAVL.test;
import conjuntistas.ArbolAVL.ArbolAVL;

public class TestInsertar {

  public static void print(Object object) {
    System.out.println(object.toString());
  }

  public static void repetidoEnRaiz() throws Exception {
    print("TEST SET 1 - Repetido en raiz");
    ArbolAVL arbol = new ArbolAVL();
    print("inserta 0: " + arbol.insertar(0));
    print("inserta 0: " + arbol.insertar(0));
    print(arbol);
  }

  public static void repetidoEnHijoDerechoRaiz() throws Exception {
    print("TEST SET 2 - Repetido en hijo raiz derecho");
    ArbolAVL arbol = new ArbolAVL();
    print("inserta 2: " + arbol.insertar(2));
    print("inserta 1: " + arbol.insertar(1));
    print("inserta 3: " + arbol.insertar(3));
    print("inserta 3: " + arbol.insertar(3));
    print(arbol);
  }

  public static void repetidoEnHijoIzquierdoRaiz() throws Exception {
    print("TEST SET 2 - Repetido en hijo raiz derecho");
    ArbolAVL arbol = new ArbolAVL();
    print("inserta 2: " + arbol.insertar(2));
    print("inserta 1: " + arbol.insertar(1));
    print("inserta 3: " + arbol.insertar(3));
    print("inserta 4: " + arbol.insertar(2));
    print(arbol);
  }

}
