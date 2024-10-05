package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.restaurant.kitchen.CourseType;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.MultiCourseMeal;
import com.github.hannotify.structuredconcurrency.staff.Waiter;

public class SingleWaiterRestaurant implements Restaurant {
    @Override
    public MultiCourseMeal announceMenu() throws Exception {
        var elmo = new Waiter("Elmo");

        var starter = elmo.announceCourse(CourseType.STARTER);
        var main = elmo.announceCourse(CourseType.MAIN);
        var dessert = elmo.announceCourse(CourseType.DESSERT);

        return new MultiCourseMeal(starter, main, dessert);
    }
}
