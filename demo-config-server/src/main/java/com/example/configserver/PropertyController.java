package com.example.configserver;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PropertyController implements ApplicationEventPublisher {


    private final PropertyRepository repository;
    private final EventsService eventsService;

    @GetMapping("/properties/")
    public List<PropertyDO> list() {
        return repository.findAll();
    }

    @PostMapping("/properties/")
    public PropertyDO create(@RequestBody PropertyDO propertyDO) {
        PropertyDO save = repository.save(propertyDO);
        eventsService.fire();
        return save;
    }

    @PutMapping("/properties/")
    public ResponseEntity<PropertyDO> update(@RequestBody PropertyDO propertyDO) {
        var optionalPropertyDO = repository.findById(propertyDO.getId());
        if (optionalPropertyDO.isPresent()){
            PropertyDO updProp = optionalPropertyDO.get();
            updProp.setKey(propertyDO.getKey());
            updProp.setApplication(propertyDO.getApplication());
            updProp.setLabel(propertyDO.getLabel());
            updProp.setProfile(propertyDO.getProfile());
            updProp.setKey(propertyDO.getKey());
            updProp.setValue(propertyDO.getValue());
            return new ResponseEntity<>(repository.save(updProp), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @Override
    public void publishEvent(Object event) {

    }
}
