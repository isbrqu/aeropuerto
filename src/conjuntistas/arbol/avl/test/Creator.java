package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.NodoAVL;
import lineales.dinamicas.Pila;
import java.util.Arrays;

public class Creator {

  public static void main(String[] args) {
    System.out.println("test");
  }
  
  public static NodoAVL base(String c) {
    return (c.equals("0")) ? null : new NodoAVL(null);
  }

  public static NodoAVL sequence(String[] sequence) {
    boolean flag = true;
    NodoAVL root = null;
    NodoAVL child = null;
    String c;
    for (int i = 0; i < sequence.length; i++) {
      c = sequence[i];
      if (flag) {
        root = base(c);
        flag = false;
      } else {
        child = root;
        root = new NodoAVL(null, child, base(c));
      }
    }
    return root;
  }

  public static NodoAVL root(String pattern) {
    NodoAVL root = null;
    Integer index = 0;
    return root(pattern, index);
  }

  public static NodoAVL root(String pattern, Integer index) {
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
      } else if (token == '(') {
        child = root(pattern, index);
      } else if (token == ')') {
        index++;
        break;
      } 
      index++;
    }
    return node;
  }

}
