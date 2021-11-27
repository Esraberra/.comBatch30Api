package com.techproed.pojos;

public class BookingDatesPojo {
/*
  {  "bookingid": 11,
            "booking": {
        "firstname": "Selim",
                "lastname": "Ak",
                "totalprice": 15000,
                "depositpaid": true,
                "bookingdates": {
            "checkin": "2020-09-09",
                    "checkout": "2020-09-21"
        } }
 */


   private String checkin;
   private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public BookingDatesPojo() {
    }

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }



}
