package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.ArbolAVL;
import conjuntistas.arbol.manipulador.Llenador;
import svgtree.Tree;

public class TestArbolAVL {

  public static void main(String[] args) {
    try {
      ArbolAVL arbol = new ArbolAVL();
      Tree tree = new Tree(arbol);
      int[] num = {2, 3, 4, 1, 5, 6, 19, 19};
      int i = 1;
      for (int n: num) {
        arbol.insertar(n);
        tree.drawTree();
        tree.save("out/" + i + ".svg");
        i++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

} 
