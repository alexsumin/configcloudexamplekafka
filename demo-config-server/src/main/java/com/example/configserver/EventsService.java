package com.example.configserver;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.bus.endpoint.RefreshBusEndpoint;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventsService {
    private final RefreshBusEndpoint refreshBusEndpoint;

    public void fire() {
        refreshBusEndpoint.busRefresh();
    }
}
