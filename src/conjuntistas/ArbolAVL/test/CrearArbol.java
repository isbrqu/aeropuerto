package conjuntistas.ArbolAVL.test;
import conjuntistas.ArbolAVL.ArbolAVL;
import conjuntistas.ArbolAVL.Nodo;

public class CrearArbol {

  public static void print(Object object) {
    System.out.println(object.toString());
  }

  public static Nodo rotacionDerecha() throws Exception {
    // RR
    Nodo izquierdo = new Nodo(null, new Nodo(null), null);
    Nodo derecho = new Nodo(null);
    Nodo raiz = new Nodo(null, izquierdo, derecho);
    return raiz;
  }

  public static Nodo rotacionIzquierda() throws Exception {
    // LR
    Nodo izquierdo = new Nodo(null);
    Nodo derecho = new Nodo(null, null, new Nodo(null));
    Nodo raiz = new Nodo(null, izquierdo, derecho);
    return raiz;
  }

  public static Nodo rotacionIzquierdaDerecha() throws Exception {
    // LRR
    Nodo izquierdo = new Nodo(null, null, new Nodo(null));
    Nodo derecho = new Nodo(null);
    Nodo raiz = new Nodo(null, izquierdo, derecho);
    return raiz;
  }

  public static Nodo rotacionDerechaIzquierda() throws Exception {
    // RLR
    Nodo izquierdo = new Nodo(null);
    Nodo derecho = new Nodo(null, new Nodo(null), null);
    Nodo raiz = new Nodo(null, izquierdo, derecho);
    return raiz;
  }

}
