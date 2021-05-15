package com.battleface.quotationservice.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.battleface.quotationservice.dto.QuoteDto;
import com.battleface.quotationservice.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/quotation")
public class QuoteController{

    int quoteId = 0;

    @RequestMapping(
        method = RequestMethod.POST,
        headers = "Accept=application/json",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> getQuote(@RequestBody QuoteDto msg){
        ResponseDto response = new ResponseDto();
        try{
            Double total = totalQuote(msg);
            response.setTotal(total);
            response.setCurrency_id(msg.getCurrencyId());
            response.setQuotation_id(++quoteId);
        }catch(ParseException pe){
            System.out.println("Error parsing dates, format isn't in Start date of trip in ISO 8601 format. Error: " + pe);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Date isn't in ISO 8601 format");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Starting age must be 18 or older");
        }

       return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }

    private Double totalQuote(QuoteDto msg) throws Exception{
        Double total = 1.0;
        List<String> ages = Arrays.asList(msg.getAge().split(","));
        Double lengthOfTrip = getTripLength(msg.getStartDate(), msg.getEndDate());
        Double fixedRate = 3.0;
        if(Integer.parseInt(ages.get(0)) < 18){
            throw new Exception("First age must be over 18");
        }
        for(String age: ages){
            Double load = getLoad(Integer.parseInt(age));
            total += load * fixedRate * lengthOfTrip;
        }
        return total;
    }   

    private Double getLoad(int age){
        if(age >= 18 && age <= 30){
            return 0.6;
        }
        if(age >= 31 && age <= 40){
            return 0.7;
        }
        if(age >= 41 && age <= 50){
            return 0.8;
        }
        if(age >= 51 && age <= 60){
            return 0.9;
        }
        return 1.0;
    }

    private Double getTripLength(String startDate, String endDate) throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       
        Date start = dateFormat.parse(startDate);
        Date end = dateFormat.parse(endDate);

        long diffMilli = Math.abs(end.getTime() - start.getTime());
        long diff = TimeUnit.DAYS.convert(diffMilli, TimeUnit.MILLISECONDS);
        return (double) diff;
    }



}