package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.staff.Waiter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public record MultiWaiterRestaurant(Waiter... waiters) implements Restaurant {
    @Override
    public MultiCourseMeal announceMenu() throws ExecutionException, InterruptedException {
        Waiter grover = new Waiter("Grover");
        Waiter zoe = new Waiter("Zoe");
        Waiter rosita = new Waiter("Rosita");

        Future<Course> starter;
        Future<Course> main;
        Future<Course> dessert;

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            starter = executor.submit(() -> grover.announceCourse(CourseType.STARTER));
            main = executor.submit(() -> zoe.announceCourse(CourseType.MAIN));
            dessert = executor.submit(() -> rosita.announceCourse(CourseType.DESSERT));
        }

        return new MultiCourseMeal(starter.get(), main.get(), dessert.get());
    }
}
