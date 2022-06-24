package pojo;

public class BookingPojo {

    /*
    "booking": {
                    "firstname": "Ali",
                    "lastname": "Can",
                    "totalprice": 500,
                    "depositpaid": true,
                    "bookingdates": {
                                    "checkin": "2022-03-01",
                                    "checkout": "2022-03-11"
                              }
                          }
                      }

     */

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingdatesPojo bookingdates ;  // onceden ayri class'ta olusturdgumuz pojo kalibini burada yeni kaliba ekledik


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingdatesPojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingdatesPojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    public BookingPojo(String firstname, String lastname, int totalprice, boolean depositpaid, BookingdatesPojo bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
    }

    public BookingPojo() {
    }

    @Override
    public String toString() {
        return "BookingPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                '}';
    }

}
