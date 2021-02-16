package com.pluralsight.fundamentals.controller;

import com.pluralsight.fundamentals.entity.Release;
import com.pluralsight.fundamentals.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/releases")
public class ReleaseController {
    @Autowired
    private ReleaseService releaseService;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Release> getReleases() {
        return releaseService.listReleases();
    }
}
