package pojo;

public class BookinResponsePojo {

     /*
    "bookingId": 11
     "booking": {
                    "firstname": "Selim ",
                    "lastname": "Ak",
                    "totalprice": 1500,
                    "depositpaid": true,
                    "bookingdates": {
                                    "checkin": "2022-03-01",
                                    "checkout": "2022-03-11"
                              }
                          }
                      }

     */

    private int bookingId;
    private BookingPojo booking;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    public BookinResponsePojo(int bookingId, BookingPojo booking) {
        this.bookingId = bookingId;
        this.booking = booking;
    }

    public BookinResponsePojo() {
    }

    @Override
    public String toString() {
        return "BookinResponsePojo{" +
                "bookingId=" + bookingId +
                ", booking=" + booking +
                '}';
    }
}
