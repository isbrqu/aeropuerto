package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.ArbolAVL;
import conjuntistas.arbol.manipulador.Llenador;
import svgtree.Tree;

public class TestArbolAVL {

  public static void main(String[] args) {
    try {
      TestInsertar.callAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

} 
