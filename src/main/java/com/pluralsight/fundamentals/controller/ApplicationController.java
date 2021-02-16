package com.pluralsight.fundamentals.controller;

import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.exception.ApplicationNotFoundException;
import com.pluralsight.fundamentals.repository.ApplicationRepository;
import com.pluralsight.fundamentals.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/api/v1/applications")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Application> getApplications() {
        return applicationService.listApplications();
    }

    @GetMapping(value="/{id}", produces = "application/json")
    public @ResponseBody Application getApplication(@PathVariable Long id) {
        try {
            return applicationService.getApplication(id);
        } catch(ApplicationNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Application not found.");
        }
    }

}
