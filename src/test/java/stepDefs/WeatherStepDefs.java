package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import model.Weather;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;
import sun.rmi.server.WeakClassHashMap;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherStepDefs {
    private String cityName;
    private String country;
    private Response response;

    @Given("show test name")
    public void show_test_name() {
        System.out.println("Hello, ogurjiec");
    }

    @Given("city {string}")
    public void set_city(String cityName) {
        this.cityName = cityName;

    }

    @Given("country {string}")
    public void set_country(String country) {
        this.country = country;

    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityName, country);
        //System.out.println(response.getCoord().getLat());
        //System.out.println(requester.requestWeather(cityName, country));
    }

    @Then("lon is {float}")
    public void check_lon(float lon) {
        assertEquals(lon, response.getCoord().getLon(), "Wrong lon");
    }

    @Then("lat is {float}")
    public void check_lat(float lat) {
        assertEquals(lat, response.getCoord().getLat(), "Wrong lat");
    }

    @Then("weather is:")
    public void check_weather(Map<String, String> params) {
        Weather weather = response.getWeathers().get(0);

        assertEquals(Long.parseLong(params.get("id")), weather.getId(), "Wrong weather ID");
        assertEquals(params.get("main"), weather.getMain(), "Wrong Main info");
        assertEquals(params.get("description"), weather.getDescription(), "Wrong weather Description");
        assertEquals(params.get("icon"), weather.getIcon(), "Wrong weather Icon");
    }

    @Then("base is: {string}")
    public void check_base (String base) {
        assertEquals(base, response.getBase(), "Wrong base");
    }

}