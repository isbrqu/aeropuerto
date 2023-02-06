package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.ArbolAVL;
import svgtree.Html;

public class TestArbolAVLVer {

  public static void main(String[] args) {
    try {
      ArbolAVL arbol = new ArbolAVL();
      String filename = "out/arbol.html";
      arbol.insertar(1);
      arbol.insertar(2);
      arbol.insertar(3);
      Html html = new Html();
      html.draw(arbol, "Test Árbol");
      arbol.insertar(5);
      arbol.insertar(4);
      arbol.insertar(-1);
      arbol.insertar(-3);
      html.draw(arbol, "Agrega -3");
      arbol.insertar(-5);
      arbol.insertar(7);
      arbol.insertar(8);
      arbol.insertar(10);
      html.draw(arbol, "Agrega el 10");
      arbol.insertar(11);
      arbol.insertar(21);
      html.draw(arbol, "Agrega el 5");
      html.save(filename);
      startTree(filename);
      System.out.println(arbol);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void startTree(String name) throws Exception {
    ProcessBuilder processBuilder = new ProcessBuilder();
    processBuilder.command("cmd.exe", "/c", "start " + name);
    Process p = processBuilder.start();
    System.out.println("Exito: " + p.waitFor());
  }

} 
