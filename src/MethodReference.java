import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReference {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("sambit","badshah","Manoj","Virat","MS Gobi");

        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s+" ");
            }
        };
        names.forEach(con);
        System.out.println();
        names.forEach(name -> System.out.print(name+" "));

        System.out.println();
        //<Method reference>
        names.forEach(System.out::print);

        //--------------------
        System.out.println();
        System.out.println("---------Method reference using user defined methods-----");

        String name = "Sam";
        MyPrinter printer = new MyPrinter();
        //Normal Java
        printer.print(name, new Parser() {
            @Override
            public String parse(String s) {
                if(s.length() <= 3)
                {
                    s=s.toUpperCase();
                }
                else {
                    s= s.toLowerCase();
                }
                return s;
            }
        });

        //Lambda Expression
        printer.print(name, (s) -> {
                if(s.length() <= 3)
                {
                    s=s.toUpperCase();
                }
                else {
                    s= s.toLowerCase();
                }
                return s;
            });

        //Method reference
        printer.print(name, StringParser::convert);



    }
}

interface Parser
{
    String parse(String s);
}

class StringParser{
    public static String convert(String s)
    {
        if(s.length() <= 3)
        {
            s=s.toUpperCase();
        }
        else {
            s= s.toLowerCase();
        }

        return s;
    }
}

class MyPrinter{
    public void print(String str,Parser p)
    {
        str = p.parse(str);
        System.out.println(str);
    }
}
