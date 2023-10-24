package com.github.hannotify.structuredconcurrency.restaurant.announcement;

import java.util.concurrent.atomic.AtomicInteger;

public class AnnouncementId {
    private static final AtomicInteger nextId = new AtomicInteger(1);
    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(AnnouncementId::nextId);
    private static final ScopedValue<Integer> scopedValue = ScopedValue.newInstance();

    public static int nextId() {
        return nextId.getAndIncrement();
    }

    public static ThreadLocal<Integer> threadLocal() {
        return threadLocal;
    }

    public static ScopedValue<Integer> scopedValue() {
        return scopedValue;
    }
}

