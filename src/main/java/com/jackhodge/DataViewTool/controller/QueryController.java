package com.jackhodge.DataViewTool.controller;

import com.jackhodge.DataViewTool.model.Person;
import com.jackhodge.DataViewTool.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.util.ArrayList;


@Controller
public class QueryController {


    QueryService service;
    // Autowire query service to be injected here
    @Autowired
    public QueryController(QueryService queryService){
        this.service = queryService;
    }

    @GetMapping("/query")
    public String search(@RequestParam String query, Model model){
        ArrayList<Person> queryResult = service.performSearch(query);
        model.addAttribute("items", queryResult);
        model.addAttribute("orig_query", query);

        return "query_result";
    }
}