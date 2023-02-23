package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.NodoAVL;

public class Creator {

  public static int index;

  public static NodoAVL generate(String pattern) {
    NodoAVL node = null;
    try {
      index = 0;
      node = root(pattern);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return node;
  }

  public static NodoAVL root(String pattern) throws Exception {
    NodoAVL node = null;
    NodoAVL child = null;
    boolean flag = false;
    while (index < pattern.length()) {
      char token = pattern.charAt(index);
      if (token == '0' || token == '1') {
        if (flag) {
          child = node;
          node = (token == '0') ? null : new NodoAVL(null);
          node = new NodoAVL(null, child, node);
        } else {
          node = (token == '0') ? null : new NodoAVL(null);
          flag = true;
        }
        index++;
      } else if (token == '(') {
        index++;
        if (flag) {
          child = node;
          node = root(pattern);
          node = new NodoAVL(null, child, node);
        } else {
          node = root(pattern);
          flag = true;
        }
      } else if (token == ')') {
        if (!flag) {
          throw new Exception("No hay contenido en la posición "
            + --index 
            + " del patrón: " + pattern);
        }
        index++;
        break;
      }
    }
    return node;
  }

}
