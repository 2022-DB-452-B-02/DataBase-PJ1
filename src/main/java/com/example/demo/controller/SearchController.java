package com.example.demo.controller;

import com.example.demo.model.Search;
import com.example.demo.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

@Slf4j
@Controller
public class SearchController {
    private SearchService searchService = new SearchService();

    @GetMapping("/search")
    private String search(Model model, @RequestParam Map<String, String> params){
        log.info(params.toString());
        ArrayList<Search> searches = searchService.search(params);
        ArrayList<String> searches_2 = new ArrayList<>(10);

        model.addAttribute("check", searchService.getCheck());
        model.addAttribute("tableHeaders", searchService.getHeader());
        model.addAttribute("searches", searches);
        model.addAttribute("tableChild", searches_2);

        return "/jsp/search.jsp";
    }
}
