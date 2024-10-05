package com.github.hannotify.structuredconcurrency.staff;

import com.github.hannotify.structuredconcurrency.restaurant.kitchen.Course;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.CourseType;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.Ingredient;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.github.hannotify.structuredconcurrency.restaurant.kitchen.CourseType.DESSERT;
import static com.github.hannotify.structuredconcurrency.restaurant.kitchen.CourseType.MAIN;
import static com.github.hannotify.structuredconcurrency.restaurant.kitchen.CourseType.STARTER;
import static com.github.hannotify.structuredconcurrency.restaurant.kitchen.FoodGroup.*;

public class Chef {
    private static final Map<CourseType, List<Course>> MENU = Map.of(
            STARTER, List.of(
                new Course("Creamy tomato soup", List.of(
                        new Ingredient("Tomato", VEGETABLES),
                        new Ingredient("Garlic", VEGETABLES),
                        new Ingredient("Cream", DAIRY))),
                new Course("Carpaccio", List.of(
                        new Ingredient("Raw beef", MEAT),
                        new Ingredient("Parmigiano-Reggiano cheese", DAIRY)))),
        MAIN, List.of(
                new Course("Lasagna", List.of(
                        new Ingredient("Minced meat", MEAT),
                        new Ingredient("Tomato", VEGETABLES),
                        new Ingredient("Garlic", VEGETABLES),
                        new Ingredient("Parmezan cheese", DAIRY))),
                new Course("Ratatouille", List.of(
                        new Ingredient("Eggplant", VEGETABLES),
                        new Ingredient("Zucchini", VEGETABLES),
                        new Ingredient("Onion", VEGETABLES))),
                new Course("Salmon, asparagus and potato gratin", List.of(
                        new Ingredient("Salmon", SEAFOOD),
                        new Ingredient("Asparagus", VEGETABLES),
                        new Ingredient("Potato", GRAINS)))),
        DESSERT, List.of(
                new Course("Dame blanche", List.of(
                        new Ingredient("Vanilla ice cream", DAIRY),
                        new Ingredient("Chocolate sauce", CONFECTIONERY))),
                new Course("Apple pie", List.of(
                        new Ingredient("Apple", FRUITS),
                        new Ingredient("Flour", GRAINS),
                        new Ingredient("Sugar", CONFECTIONERY)))));

    public static Course pickCourse(String waiterName, CourseType courseType) throws OutOfStockException {
        var courses = MENU.get(courseType);

        Course pickedCourse = courses.get(new Random().nextInt(courses.size()));

        System.out.format("\t[Chef] %s asked me to pick a %s, so that announcement #%d can take place. So I picked '%s'!%n",
                waiterName, courseType.name().toLowerCase(), 1, pickedCourse);

        pickedCourse.checkStock();
        return pickedCourse;
    }
}
