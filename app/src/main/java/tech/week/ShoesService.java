package tech.week;

import com.linecorp.armeria.server.annotation.Get;

public final class ShoesService {

    private double discount;

    ShoesService() {
        discount = 0.1;
    }

    @Get("/shoes/price")
    public String getPriceInYen() {
        return "The price is " + (int) (10000 * (1 - discount)) + " yen.";
    }
}
