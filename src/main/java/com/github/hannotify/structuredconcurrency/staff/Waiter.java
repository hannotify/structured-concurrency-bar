package com.github.hannotify.structuredconcurrency.staff;

import com.github.hannotify.structuredconcurrency.bar.Drink;
import com.github.hannotify.structuredconcurrency.bar.DrinkCategory;
import com.github.hannotify.structuredconcurrency.restaurant.Course;
import com.github.hannotify.structuredconcurrency.restaurant.CourseType;

import java.util.List;
import java.util.Objects;

public final class Waiter {
    private final String name;
    private int courseCount;

    public Waiter(String name) {
        this.name = name;
        this.courseCount = 0;
    }

    public List<Drink> announceDrinks(DrinkCategory drinkCategory) {
        // TODO: implement
        return null;
    }

    public void introduce() {
        System.out.format("Hello, my name is %s. I'll wait your table today.%n", name);
    }

    public Course announceCourse(CourseType courseType) {
        Course pickedCourse = Chef.pickCourse(courseType);
        System.out.format("[%s] Course #%d will be '%s'.%n", name, ++courseCount, pickedCourse);
        return pickedCourse;
    }

    public String name() {
        return name;
    }
}
