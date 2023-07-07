package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    public void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    public void testSaveNewBeer() {
        BeerDto dto = BeerDto.builder().id(UUID.randomUUID()).beerName("BEER").build();
        URI uri = client.saveNewBeer(dto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    public void testUpdateBeer() {
        BeerDto dto = BeerDto.builder().id(UUID.randomUUID()).beerName("BEER_2").build();
        client.updateBeerById(UUID.randomUUID(), dto);
    }

    @Test
    public void testDeleteBeer() {
        client.deleteBeerById(UUID.randomUUID());
    }

    @Test
    public void testGetCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    public void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("VALERI TOTEV").build();
        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    public void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    public void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}