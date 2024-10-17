public class LambdaExample {

    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.print();

        printThing(dog);

        //-------------------------------
        //Lambada expression-1 (Instead of passing a class that implements method of a functional interface , pass implementation itself
        printThing(
        () -> {
            System.out.println("I am a dog");
              }
        );

        //Lambada expression-2 curly braces can be omitted if its a single line expression
        printThing(() -> System.out.println("I am a dog"));

        //Lamda Expression-3
        Printable lambdaPrintable = () -> System.out.println("I am a dog");
        printThing(lambdaPrintable);
        //-----------------------------------
        //Lambda expression with parameterized methods
        //Way-1
        printThingWithParam((s)-> System.out.println("Hello "+s));
        //Way-2 Round braces can be omitted in case of single param
        printThingWithParam((s-> System.out.println("Hello "+s)));

        //----------------------------
        //Lambda expression with return types
        //way-1
        printThingwithParamAndReturn((s)->{return s;});
        //way-2 (in case of a single return statement both curly brace and return keyword can be removed
        printThingwithParamAndReturn(s->s);
    }

    private static void printThing(Printable thing)
    {
        thing.print();
    }

    private static void printThingWithParam(PrintableWithParam thing)
    {
        thing.print("!");
    }

    private  static  void printThingwithParamAndReturn(PrintableWithParamAndReturn thing)
    {
        String print = thing.print("Hello world");
        System.out.println(print);
    }
}

@FunctionalInterface
interface Printable
{
    void print();
}
class Dog implements Printable
{
    String name;
    int age;


    @Override
    public void print() {
        System.out.println("I am a dog");
    }
}

@FunctionalInterface
interface PrintableWithParam
{
    void print(String suffix);
}
@FunctionalInterface
interface PrintableWithParamAndReturn
{
    String print(String suffix);
}
