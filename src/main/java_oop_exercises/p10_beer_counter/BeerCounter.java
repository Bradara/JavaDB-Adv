package p10_beer_counter;

public class BeerCounter {
    private static int beerInStock = 0;
    private static int beerDrank = 0;

    public static void buyBeer(int beerBought) {
        BeerCounter.beerInStock += beerBought;
    }

    public static void drinkBeer(int beerDrank) {
        BeerCounter.beerDrank += beerDrank;
        BeerCounter.beerInStock -= beerDrank;
    }

    public static int getBeerInStock() {
        return beerInStock;
    }

    public static int getBeerDrank() {
        return beerDrank;
    }
}
