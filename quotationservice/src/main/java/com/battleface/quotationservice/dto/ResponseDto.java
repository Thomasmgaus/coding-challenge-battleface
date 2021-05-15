package com.battleface.quotationservice.dto;

import java.util.Objects;


public class ResponseDto{
    double total;

    String currency_id;

    int quotation_id;


    public ResponseDto() {
    }

    public ResponseDto(double total, String currency_id, int quotation_id) {
        this.total = total;
        this.currency_id = currency_id;
        this.quotation_id = quotation_id;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCurrency_id() {
        return this.currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public int getQuotation_id() {
        return this.quotation_id;
    }

    public void setQuotation_id(int quotation_id) {
        this.quotation_id = quotation_id;
    }

    public ResponseDto total(double total) {
        setTotal(total);
        return this;
    }

    public ResponseDto currency_id(String currency_id) {
        setCurrency_id(currency_id);
        return this;
    }

    public ResponseDto quotation_id(int quotation_id) {
        setQuotation_id(quotation_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ResponseDto)) {
            return false;
        }
        ResponseDto responseDto = (ResponseDto) o;
        return total == responseDto.total && Objects.equals(currency_id, responseDto.currency_id) && quotation_id == responseDto.quotation_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, currency_id, quotation_id);
    }

    @Override
    public String toString() {
        return "{" +
            " total='" + getTotal() + "'" +
            ", currency_id='" + getCurrency_id() + "'" +
            ", quotation_id='" + getQuotation_id() + "'" +
            "}";
    }


}