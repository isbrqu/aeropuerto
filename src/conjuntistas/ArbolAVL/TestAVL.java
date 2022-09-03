package conjuntistas.ArbolAVL;

public class TestAVL {

  public static void print(Object object) {
    System.out.println(object.toString());
  }

  public static void main(String[] args) {
    testSet1();
  }

  public static void testSet1() {
    print("TEST SET 1");
    ArbolAVL arbol = new ArbolAVL();
    int[] num = {1, 5, 9};
    arbol.llenar(num);
    print(arbol);
  }

}
