package com.battleface.quotationservice.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteDto{
    @JsonProperty("age")
    String age;
    @JsonProperty("currency_id")
    String currencyId;
    @JsonProperty("start_date")
    String startDate;
    @JsonProperty("end_date")
    String endDate;
    

    public QuoteDto() {
    }

    public QuoteDto(String age, String currencyId, String startDate, String endDate) {
        this.age = age;
        this.currencyId = currencyId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public QuoteDto age(String age) {
        setAge(age);
        return this;
    }

    public QuoteDto currencyId(String currencyId) {
        setCurrencyId(currencyId);
        return this;
    }

    public QuoteDto startDate(String startDate) {
        setStartDate(startDate);
        return this;
    }

    public QuoteDto endDate(String endDate) {
        setEndDate(endDate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof QuoteDto)) {
            return false;
        }
        QuoteDto quoteDto = (QuoteDto) o;
        return Objects.equals(age, quoteDto.age) && Objects.equals(currencyId, quoteDto.currencyId) && Objects.equals(startDate, quoteDto.startDate) && Objects.equals(endDate, quoteDto.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, currencyId, startDate, endDate);
    }

    @Override
    public String toString() {
        return "{" +
            " age='" + getAge() + "'" +
            ", currencyId='" + getCurrencyId() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            "}";
    }



   
}