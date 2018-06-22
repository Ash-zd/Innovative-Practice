package com.ashzd.blog.aync;

import java.util.List;

public interface EventHandler {
    void doHandler(EventModel model);

    List<EventType> getSupportEventTypes();
}
