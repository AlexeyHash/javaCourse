import core.Line;
import core.Station;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase
{
    List<Station> route;
    StationIndex stationIndex;
    List<Station> connections;
    List<Station> connections2;
    RouteCalculator calculator;
    Line line1;
    Line line2;
    Line line3;
    Station station1line1;
    Station station2line1;
    Station station3line1;
    Station station1line2;
    Station station2line2;
    Station station3line2;
    Station station1line3;
    Station station2line3;
    Station station3line3;
    /**
     * A - line_1
     * B - line_2
     * C - line_3
     *
     * A1 - Василеостровская,  A2 - Гостинный двор,  А3 - Маяковская
     * В1 - Горьковская,  В2 - Невский проспект,  В3 - Сенная площадь
     * С1 - Чернышевская, С2 - Площадь восстания, С3 - Владимировская
     *
     *             B1             C1
     *              |             |
     *              |             |
     *  A1-------(A2_B2)-------(A3_C2)
     *              |             |
     *              |             |
     *             B3            C3
     */
    @Override
    protected void setUp() throws Exception
    {
        route = new ArrayList<>();
        stationIndex = new StationIndex();
         line1 = new Line(1,"Первая");
         line2 = new Line(2,"Вторая");
         line3 = new Line(3,"Третья");

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);


         station1line1 = new Station("Василеостровская",line1);
         station2line1 = new Station("Гостинный двор",line1);
         station3line1 = new Station("Маяковская",line1);

         line1.addStation(station1line1);
         line1.addStation(station2line1);
         line1.addStation(station3line1);

         station1line2 = new Station("Горьковская", line2);
         station2line2 = new Station("Невский проспект", line2);
         station3line2 = new Station("Сенная площадь", line2);

         line2.addStation(station1line2);
         line2.addStation(station2line2);
         line2.addStation(station3line2);

         station1line3 = new Station("Чернышевская", line3);
         station2line3 = new Station("Площадь восстания", line3);
         station3line3 = new Station("Владимирская", line3);

         line3.addStation(station1line3);
         line3.addStation(station2line3);
         line3.addStation(station3line3);

        stationIndex.addStation(station1line1);
        stationIndex.addStation(station2line1);
        stationIndex.addStation(station3line1);

        stationIndex.addStation(station1line2);
        stationIndex.addStation(station2line2);
        stationIndex.addStation(station3line2);

        stationIndex.addStation(station1line3);
        stationIndex.addStation(station2line3);
        stationIndex.addStation(station3line3);

        connections = new ArrayList<>();
        connections.add(station2line1);
        connections.add(station2line2);
        stationIndex.addConnection(connections);

        connections2 = new ArrayList<>();
        connections2.add(station3line1);
        connections2.add(station2line3);
        stationIndex.addConnection(connections2);

        route.add(station1line1);
        route.add(station2line1);
        route.add(station3line1);
        route.add(station1line2);
        route.add(station2line2);
        route.add(station3line2);
        route.add(station1line3);
        route.add(station2line3);
        route.add(station3line3);

    }

    public void testCalculateDuration()
    {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 22;
        assertEquals(expected,actual);
    }

    public void test_stations_route_on_one_line(){
        calculator = new RouteCalculator(stationIndex);
        List<Station> actual = calculator.getShortestRoute(station1line1,station3line1);
        List<Station> expected = new ArrayList<>();
        expected.add(station1line1);
        expected.add(station2line1);
        expected.add(station3line1);

        assertEquals(expected,actual);
    }
    public void test_stations_route_on_same_station(){
        calculator = new RouteCalculator(stationIndex);
        List<Station> actual = calculator.getShortestRoute(station1line1,station1line1);
        List<Station> expected = new ArrayList<>();
        expected.add(station1line1);

        assertEquals(expected,actual);
    }
    public void test_stations_route_with_one_connection(){
        calculator = new RouteCalculator(stationIndex);
        List<Station> actual = calculator.getShortestRoute(station1line1,station1line2);
        List<Station> expected = new ArrayList<>();
        expected.add(station1line1);
        expected.add(station2line1);
        expected.add(station2line2);
        expected.add(station1line2);

        assertEquals(expected,actual);
    }
    public void test_stations_route_with_two_connection(){
        calculator = new RouteCalculator(stationIndex);
        List<Station> actual = calculator.getShortestRoute(station1line2,station3line3);
        List<Station> expected = new ArrayList<>();
        expected.add(station1line2);
        expected.add(station2line2);
        expected.add(station2line1);
        expected.add(station3line1);
        expected.add(station2line3);
        expected.add(station3line3);

        assertEquals(expected,actual);
    }
}
