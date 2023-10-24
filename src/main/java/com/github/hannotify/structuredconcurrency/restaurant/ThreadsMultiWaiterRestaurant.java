package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.restaurant.kitchen.Course;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.CourseType;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.MultiCourseMeal;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;
import com.github.hannotify.structuredconcurrency.staff.Waiter;

import java.util.concurrent.ExecutionException;

public class ThreadsMultiWaiterRestaurant implements Restaurant {
    class WaiterAnnounceCourseThread extends Thread {
        private final Waiter waiter;
        private final CourseType courseType;
        private Course announcedCourse;

        public WaiterAnnounceCourseThread(Waiter waiter, CourseType courseType) {
            this.waiter = waiter;
            this.courseType = courseType;
        }

        @Override
        public void run() {
            try {
                announcedCourse = waiter.announceCourse(courseType);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public Course getAnnouncedCourse() {
            return announcedCourse;
        }
    }

    @Override
    public MultiCourseMeal announceMenu() throws ExecutionException, InterruptedException, OutOfStockException {
        Waiter grover = new Waiter("Grover");
        Waiter zoe = new Waiter("Zoe");
        Waiter rosita = new Waiter("Rosita");

        var starterThread = new WaiterAnnounceCourseThread(grover, CourseType.STARTER);
        var mainThread = new WaiterAnnounceCourseThread(zoe, CourseType.MAIN);
        var dessertThread = new WaiterAnnounceCourseThread(rosita, CourseType.DESSERT);

        starterThread.start();
        mainThread.start();
        dessertThread.start();

        starterThread.join();
        mainThread.join();
        dessertThread.join();

        return new MultiCourseMeal(starterThread.getAnnouncedCourse(),
                                   mainThread.getAnnouncedCourse(),
                                   dessertThread.getAnnouncedCourse());
    }
}
