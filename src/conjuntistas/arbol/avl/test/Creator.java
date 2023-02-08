package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.NodoAVL;
import lineales.dinamicas.Cola;

public class Creator {

  public static void main(String[] args) {
    root("10()");
  }

  public static NodoAVL base(String c) {
    return (c.equals("0")) ? null : new NodoAVL(null);
  }

  public static NodoAVL root(String pattern) {
    String binaries = "01";
    String bracket = "()";
    String c;
    boolean flag = true;
    NodoAVL root = null;
    NodoAVL child = null;
    for (int i = 0; i < pattern.length(); i++) {
      c = Character.toString(pattern.charAt(i));
      if (binaries.contains(c)) {
        if (flag) {
          root = base(c);
          flag = false;
        } else {
          child = root;
          root = new NodoAVL(null, child, base(c));
        }
      } else if (bracket.contains(c)) {
        System.out.println("es ( o )");
      }
    }
    return root;
  }

}
