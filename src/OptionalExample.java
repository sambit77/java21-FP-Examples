import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<Cat> myCat = findCatByName("kitty");


        //Print age of cat
        //Way-1
        int catAge = myCat.map(Cat::getAge).orElse(-1);
        System.out.println("cat's age "+catAge);
        //Way-2
        if(myCat.isPresent())
        {
            System.out.println("cat's age "+myCat.get().getAge());
        }
        else
        {
            System.out.println("cat not found");
        }

        //other functions
        //orElseThrow() etc.

    }

    private static Optional<Cat> findCatByName(String name)
    {
        Cat mycat = null;
        if(name == "kitty") {
            mycat = new Cat(name, 3);
        }

        return Optional.ofNullable(mycat); //if myCat is null it will create empty optional

        //following can be used if you are sure the object passed is never null
        //return  Optional.of(mycat); //--if my cat is null it will throw Exception

    }


}

class Cat
{
    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}