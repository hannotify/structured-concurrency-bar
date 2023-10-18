package com.github.hannotify.structuredconcurrency.staff;

import com.github.hannotify.structuredconcurrency.bar.Drink;
import com.github.hannotify.structuredconcurrency.bar.DrinkCategory;
import com.github.hannotify.structuredconcurrency.bar.DrinkOrder;
import com.github.hannotify.structuredconcurrency.bar.DrinksMenu;
import com.github.hannotify.structuredconcurrency.bar.Guest;
import com.github.hannotify.structuredconcurrency.bar.GuestDoesntLikeAnyOfTheseDrinksException;
import com.github.hannotify.structuredconcurrency.restaurant.announcement.AnnouncementId;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.Course;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.CourseType;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;

public final class Waiter {
    private final String name;
    private boolean introduced;

    public Waiter(String name) {
        this.name = name;
        this.introduced = false;
    }

    public DrinkOrder getDrinkOrder(final Guest guest, DrinkCategory... drinkCategories) throws GuestDoesntLikeAnyOfTheseDrinksException, InterruptedException {
        if (!introduced) introduce(guest.name());

        var drinksMenu = DrinksMenu.getDrinksMenu();

        for (DrinkCategory drinkCategory : drinkCategories) {
            var drinksForThisCategory = drinksMenu.stream().filter(drink -> drink.drinkCategory() == drinkCategory).toList();

            if (!drinksForThisCategory.isEmpty()) {
                System.out.format("[%s] In the '%s' category, we have the following drinks on offer teday:%n", name, drinkCategory);
            }

            for (Drink drink : drinksForThisCategory) {
                // Listing drinks is hard work!
                Thread.sleep(350);
                System.out.format("[%s] '%s'.%n", name, drink);

                if (guest.favoriteDrinks().contains(drink)) {
                    System.out.format("[%s] 🤤Hey, I like '%s'! %n", guest.name(), drink);
                    System.out.format("[%s] 🍷Ordering '%s' for guest '%s'!%n", name, drink, guest.name());

                    return new DrinkOrder(guest, drink);
                }
            }
        }

        throw new GuestDoesntLikeAnyOfTheseDrinksException("This guest doesn't like any drinks from this drink category.");
    }

    private void introduce() {
        introduce("");
    }

    private void introduce(String guestName) {
        System.out.format("Hello%s, my name is %s. I'll wait your table today.%n", guestName.isEmpty() ? "" : " " + guestName, name);
        introduced = true;
    }

    public Course announceCourse(CourseType courseType) throws OutOfStockException {
        if (!introduced) introduce();

        Course pickedCourse;

        try {
            System.out.format("\t[%s] Talking to the Chef to determine today's %s course.%n", name, courseType.name().toLowerCase());
            pickedCourse = Chef.pickCourse(name, courseType);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.format("[%s] Announcement #%d: Today's %s will be '%s'.%n", name, AnnouncementId.get(),
                courseType.name().toLowerCase(), pickedCourse);
        return pickedCourse;
    }

    public String name() {
        return name;
    }
}
