package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.staff.Waiter;

public record SingleWaiterRestaurant(Waiter waiter) implements Restaurant {

    @Override
    public MultiCourseMeal announceMenu() throws OutOfStockException {
        Course starter = waiter.announceCourse(CourseType.STARTER);
        Course main = waiter.announceCourse(CourseType.MAIN);
        Course dessert = waiter.announceCourse(CourseType.DESSERT);

        return new MultiCourseMeal(starter, main, dessert);
    }
}
