package algo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaUsage {
    public static void main(String[] args) {
        List<Apple> inventory1 = new ArrayList<>();
        inventory1.addAll(Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"), new Apple(120, "red")));
        inventory1.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        System.out.println(inventory1);

        Comparator<Apple> comp = (a1, a2)->a1.getWeight().compareTo(a2.getWeight());
        inventory1.sort(comp);
        System.out.println(inventory1);

        inventory1.sort(Comparator.comparing(apple -> apple.getWeight()));
        System.out.println(inventory1);

        inventory1.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory1);

        inventory1.forEach(new Consumer<Apple>() {
            @Override
            public void accept(Apple apple) {
                System.out.println(apple.getWeight());
            }
        });

        inventory1.forEach(a -> System.out.println(a.getWeight()));

    }
}
