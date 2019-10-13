@FunctionalInterface
interface Foo
{
    public int add(int x, int y);

    default  int div(int x, int y)
    {
        return x/y;
    }

    static int mul(int x ,int y)
    {
        return x * y;
    };
}
public class LambdaExpressionDemo {
    public static void main(String[] args) {
       /* Foo foo = new Foo() {
            @Override
            public void add() {
                System.out.println("*****测试匿名内部类*****");
            }
        };
        foo.add();*/

       Foo foo = ((int x, int y)->{
           System.out.println("*****come in add method*****");
           return x + y;
       });

       foo.add(3,5);

        System.out.println(foo.div(10,2));

        //静态方法直接用接口名.方法名调用
        System.out.println(Foo.mul(2,3));
    }
}
