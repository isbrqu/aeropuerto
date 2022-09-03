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
    ArbolAVL a = new ArbolAVL();
    int[] num = {15, 9, 4, 3, 7, 12, 13, 50, 24, 17, 57, 53, 67};
    a.llenar(num);
    print(a);
    print("listar: " + a.listar());
    print("pertenece: " + a.pertenece(3));
    print("elemento minimo: " + a.minimoElem());
    print("elemento maximo: " + a.maximoElem());
    print("listar rango: " + a.listarRango(2, 9));
    int n = 9;
    print("elimina: " + n);
    print("eliminar: " + a.eliminar(n));
    print(a);
  }

}
