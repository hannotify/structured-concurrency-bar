package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.staff.Waiter;

public record SingleWaiterRestaurant(Waiter waiter) implements Restaurant {

    @Override
    public MultiCourseMeal announceMenu() {
        waiter.introduce();

        Course entree = waiter.announceCourse(CourseType.ENTREE);
        Course main = waiter.announceCourse(CourseType.MAIN);
        Course dessert = waiter.announceCourse(CourseType.DESSERT);

        return new MultiCourseMeal(entree, main, dessert);
    }
}
