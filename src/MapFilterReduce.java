import java.util.Arrays;

public class MapFilterReduce {
    public static void main(String[] args) {

        int[] profits = {100,2000,6000,8000,9000,1240};

        //Apply tax on profits @25% where profit > 5000

        Double taxCollection = Arrays.stream(profits)
                .filter(profit -> profit > 5000)
                .mapToDouble(profit -> profit*0.25)
                .reduce(0,(a,b) -> a+b);

        System.out.println(taxCollection);


    }
}
