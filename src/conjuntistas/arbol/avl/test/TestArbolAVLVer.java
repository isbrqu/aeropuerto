package conjuntistas.arbol.avl.test;

import conjuntistas.arbol.avl.ArbolAVL;
import conjuntistas.arbol.avl.test.Creator;
import svgtree.Html;

public class TestArbolAVLVer {

  public static void main(String[] args) {
    try {
      System.out.println("hola");
      // ArbolAVL arbol = new ArbolAVL();
      // String filename = "out/arbol.html";
      // Html html = new Html();
      // html.save(filename);
      // startTree(filename);
      // System.out.println(arbol);
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
