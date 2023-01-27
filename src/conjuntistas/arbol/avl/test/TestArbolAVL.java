package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.ArbolAVL;
import conjuntistas.arbol.manipulador.Llenador;
import svgtree.Tree;

public class TestArbolAVL {

  public static void main(String[] args) {
    try {
      ArbolAVL a = new ArbolAVL();
      Llenador l = new Llenador(a);
      int[] num = {2, 3, 4, 1, 5, 6, 19, 19};
      l.llenar(num);
      System.out.println(a);
      Tree b = new Tree(a);
      b.drawTree();
      b.save("out/test.svg");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

} 
