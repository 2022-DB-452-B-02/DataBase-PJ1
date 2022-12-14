package com.example.demo.controller;

import com.example.demo.model.Update;
import com.example.demo.service.DeleteService;
import com.example.demo.service.ShowDependentService;
import com.example.demo.service.ShowDependentService;
import com.example.demo.service.UpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class UpdateController {
    private DeleteService deleteService = new DeleteService();
    private UpdateService updateService = new UpdateService();

    private ShowDependentService showDependent = new ShowDependentService();
    @PostMapping("/updates")
    private String updates(@ModelAttribute Update update){
        log.info("update : "+update.getUpdate());

        if(checkSsn(update)) { // ssn 에러 페이지
            return "/jsp/noSsn.jsp";
        }
        if(update.getUpdate().equals("DELETE")){ // delete
            deleteService.delete(update);
        }
        else{ // update
            if(updateService.update(update) == false) return "/jsp/updateFail.jsp";
        }
        return "/jsp/home.jsp";
    }

    private boolean checkSsn(Update update){
        boolean ret = true;
        for(String ssn : update.getSsn()) {
            if(!ssn.equals("")) ret = false;
        }
        return ret;
    }
}
