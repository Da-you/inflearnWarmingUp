package com.group.libearyapp.homework4;

import java.time.LocalDate;

public class FruitDto {

    public static class Input{
        private String name;
        private Long price;
        private LocalDate warehousingDate;


        public String getName() {
            return name;
        }

        public LocalDate getWarehousingDate() {
            return warehousingDate;
        }

        public Long getPrice() {
            return price;
        }
    }

    public static class Salse{
        private Long id;

        public Long getId() {
            return id;
        }
    }
    public static class Response{
        private Long salesAmount;
        private Long notSalesAmount;

        public Long getSalesAmount() {
            return salesAmount;
        }

        public Long getNotSalesAmount() {
            return notSalesAmount;
        }

        public Response(){}
        public Response(Long salesAmount, Long notSalesAmount) {
            this.salesAmount = salesAmount;
            this.notSalesAmount = notSalesAmount;
        }
    }

}
