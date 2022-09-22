package conjuntistas.ArbolAVL.test;
import conjuntistas.ArbolAVL.ArbolAVL;
import conjuntistas.ArbolAVL.Nodo;

public class CrearArbol {

  public static void print(Object object) {
    System.out.println(object.toString());
  }

  public static Nodo rotacionDerecha(Nodo hijo) throws Exception {
    // RR
    Nodo raiz = null;
    if (hijo == null) {
      raiz = inclinado(2, 1);
    } else { 
      raiz = new Nodo(null);
      int altura = hijo.getAltura();
      Nodo izquierdo = inclinado(altura + 1, 1);
      Nodo derecho = hijo;
      raiz.setIzquierdo(izquierdo);
      raiz.setDerecho(derecho);
      raiz.recalcularAltura();
    }
    return raiz;
  }

  public static Nodo rotacionIzquierda(Nodo hijo) throws Exception {
    // LR
    Nodo raiz = null;
    if (hijo == null) {
      raiz = inclinado(2, -1);
    } else { 
      raiz = new Nodo(null);
      int altura = hijo.getAltura();
      Nodo izquierdo = hijo;
      Nodo derecho = inclinado(altura + 1, -1);
      raiz.setIzquierdo(izquierdo);
      raiz.setDerecho(derecho);
      raiz.recalcularAltura();
    }
    return raiz;
  }

  public static Nodo rotacionIzquierdaDerecha(Nodo hijo) throws Exception {
    // LRR
    Nodo raiz = null;
    Nodo izquierdo = null;
    Nodo derecho = null;
    if (hijo == null) {
      izquierdo = inclinado(1, -1);
      derecho = inclinado(0, 1);
      raiz = new Nodo(null, izquierdo, derecho);
    } else { 
      int altura = hijo.getAltura();
      izquierdo = inclinado(altura, -1);
      derecho = hijo;
      raiz = new Nodo(null, izquierdo, derecho);
    }
    return raiz;
  }

  public static Nodo rotacionDerechaIzquierda() throws Exception {
    // RLR
    Nodo izquierdo = new Nodo(null);
    Nodo derecho = new Nodo(null, new Nodo(null), null);
    Nodo raiz = new Nodo(null, izquierdo, derecho);
    return raiz;
  }

  public static Nodo inclinado(int altura, int inclinacion) throws Exception {
    Nodo raiz = null;
    if (altura >= 0) {
      raiz = new Nodo(null);
      Nodo izquierdo = null;
      Nodo derecho = null;
      // determinan si se debe restar -1 o -2 a la altura
      izquierdo = inclinado(altura + (inclinacion - 3) / 2, 1);
      derecho = inclinado(altura + (inclinacion + 3) / -2, -1);
      raiz.setIzquierdo(izquierdo);
      raiz.setDerecho(derecho);
      raiz.recalcularAltura();
    }
    return raiz;
  }

  public static Nodo neutro(int altura) throws Exception {
    Nodo raiz = new Nodo(null);
    if (altura != 0) {
      Nodo izquierdo = neutro(altura - 1);
      Nodo derecho = neutro(altura - 1);
      raiz.setIzquierdo(izquierdo);
      raiz.setDerecho(derecho);
    }
    return raiz;
  }

  public static Nodo rotacionMultiple(String[] patron, int altura) throws Exception {
    Nodo raiz = null;
    Nodo izquierdo = null;
    Nodo derecho = null;
    Nodo hijo = null;
    for (String rotacion : patron) {
      switch (rotacion) {
        case "RR":
          raiz = rotacionDerecha(hijo);
          break;
        case "LR":
          raiz = rotacionIzquierda(hijo);
          break;
        case "LRR":
          raiz = rotacionIzquierdaDerecha(hijo);
          break;
        case "RLR":
          izquierdo = inclinado(altura - 2, 1);
          derecho = inclinado(altura - 1, 1);
          raiz = new Nodo(null, izquierdo, derecho);
          break;
        case "-":
          raiz = neutro(altura);
          break;
      }
      hijo = raiz;
    }
    return raiz;
  }

}
