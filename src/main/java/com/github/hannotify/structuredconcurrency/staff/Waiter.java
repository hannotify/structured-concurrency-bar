package com.github.hannotify.structuredconcurrency.staff;

import com.github.hannotify.structuredconcurrency.bar.Drink;
import com.github.hannotify.structuredconcurrency.bar.DrinkCategory;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.Course;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.CourseType;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;

import java.util.List;

public final class Waiter {
    private final String name;
    private boolean introduced;

    public Waiter(String name) {
        this.name = name;
        this.introduced = false;
    }

    public List<Drink> announceDrinks(DrinkCategory drinkCategory) {
        // TODO: implement
        return null;
    }

    private void introduce() {
        System.out.format("Hello, my name is %s. I'll wait your table today.%n", name);
        introduced = true;
    }

    public Course announceCourse(CourseType courseType) throws OutOfStockException {
        if (!introduced) introduce();

        Course pickedCourse = Chef.pickCourse(courseType);
        System.out.format("[%s] Today's %s will be '%s'.%n", name, courseType.name().toLowerCase(), pickedCourse);
        return pickedCourse;
    }

    public String name() {
        return name;
    }
}
