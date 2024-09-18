package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.restaurant.kitchen.Course;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.CourseType;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.MultiCourseMeal;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;
import com.github.hannotify.structuredconcurrency.staff.Waiter;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiWaiterInvokeAllRestaurant implements Restaurant {
    @Override
    public MultiCourseMeal announceMenu() throws ExecutionException, InterruptedException {
        Waiter grover = new Waiter("Grover");
        Waiter zoe = new Waiter("Zoe");
        Waiter rosita = new Waiter("Rosita");

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Future<Course>> futures = executor.invokeAll(List.of(
                    () -> grover.announceCourse(CourseType.STARTER),
                    () -> zoe.announceCourse(CourseType.MAIN),
                    () -> rosita.announceCourse(CourseType.DESSERT)
            ));

            return new MultiCourseMeal(futures.stream().map(f -> {
                try {
                    return f.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).toArray(Course[]::new));
        }
    }
}
