package com.github.hannotify.structuredconcurrency.staff;

import com.github.hannotify.structuredconcurrency.restaurant.Course;
import com.github.hannotify.structuredconcurrency.restaurant.CourseType;
import com.github.hannotify.structuredconcurrency.restaurant.Ingredient;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.github.hannotify.structuredconcurrency.restaurant.CourseType.DESSERT;
import static com.github.hannotify.structuredconcurrency.restaurant.CourseType.STARTER;
import static com.github.hannotify.structuredconcurrency.restaurant.CourseType.MAIN;
import static com.github.hannotify.structuredconcurrency.restaurant.FoodGroup.*;

public class Chef {
    private static Map<CourseType, List<Course>> menu = Map.of(
            STARTER, List.of(
                new Course("Tomato soup", List.of(
                        new Ingredient("Tomato", VEGETABLES),
                        new Ingredient("Garlic", VEGETABLES))),
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

    public static Course pickCourse(CourseType courseType) {
        var courses = menu.get(courseType);
        return courses.get(new Random().nextInt(courses.size()));
    }
}
