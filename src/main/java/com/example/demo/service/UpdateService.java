package com.example.demo.service;

import com.example.demo.model.Update;
import com.example.demo.repository.UpdateRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UpdateService {
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String timeStamp = date.format(new Date());
    UpdateRepository updateRepository = new UpdateRepository();

    // 예시 SQL : UPDATE EMPLOYEE SET SALARY = 70000 WHERE Ssn = 111111111;
    private String updateQuery = "UPDATE EMPLOYEE SET modified="+change(timeStamp)+", ";

    public boolean update(Update updateInfo){
        return updateRepository.update(makeUpdateQuery(updateInfo));
    }

    private ArrayList<String> makeUpdateQuery(Update updateInfo){
        String uq = updateQuery + updateInfo.getUpdateCategory().toUpperCase() + "=" + change(updateInfo.getUpdateText()) + " WHERE Ssn = ";
        ArrayList<String> queries = new ArrayList<>();
        for(String ssn : updateInfo.getSsn()){
            queries.add(uq + ssn);
        }
        return queries;
    }

    private String change(String str){
        return "'" + str + "'";
    }


}
