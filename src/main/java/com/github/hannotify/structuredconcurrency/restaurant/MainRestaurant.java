import com.github.hannotify.structuredconcurrency.restaurant.Restaurant;
import com.github.hannotify.structuredconcurrency.restaurant.StructuredConcurrencyRestaurant;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;

import java.util.concurrent.ExecutionException;

void main() throws ExecutionException, InterruptedException, OutOfStockException {
    Restaurant restaurant = new StructuredConcurrencyRestaurant();
    restaurant.announceMenu();
}
