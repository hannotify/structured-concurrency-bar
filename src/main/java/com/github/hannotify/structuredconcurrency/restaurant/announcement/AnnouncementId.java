package com.github.hannotify.structuredconcurrency.restaurant.announcement;

import java.util.concurrent.atomic.AtomicInteger;

public class AnnouncementId {
    private static final AtomicInteger nextId = new AtomicInteger(1);
    private static final ThreadLocal<Integer> announcementId = ThreadLocal.withInitial(nextId::getAndIncrement);

    public static int get() {
        return announcementId.get();
    }
}
