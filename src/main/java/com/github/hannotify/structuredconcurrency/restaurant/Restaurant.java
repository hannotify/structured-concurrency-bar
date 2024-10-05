package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.restaurant.kitchen.MultiCourseMeal;

public interface Restaurant {
    MultiCourseMeal announceMenu() throws Exception;
}
