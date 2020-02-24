import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {   // System.out::println

        LocalDateTime date = LocalDateTime.now();
        String formatPattern = "dd MMMM yyyy HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);


        Airport airport = Airport.getInstance();
        List terminals = airport.getTerminals();

        for (int i = 0; i < terminals.size(); i++){

            airport.getTerminals().get(i).getFlights()
                    .stream().filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                    .filter(flight -> convertToLocalDateTime(flight.getDate())
                            .isAfter(date))
                    .filter(flight -> convertToLocalDateTime(flight.getDate())
                            .isBefore(date.plusHours(2)))
                    .map(flight -> flight.getAircraft().toString() + "\t" +
                            convertToLocalDateTime(flight.getDate()).format(formatter))
                    .forEach(System.out::println);
        }

    }
    private static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
