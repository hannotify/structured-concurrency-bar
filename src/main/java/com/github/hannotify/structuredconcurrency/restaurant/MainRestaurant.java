import com.github.hannotify.structuredconcurrency.restaurant.MultiWaiterInvokeAllRestaurant;
import com.github.hannotify.structuredconcurrency.restaurant.Restaurant;
import com.github.hannotify.structuredconcurrency.restaurant.StructuredConcurrencyRestaurant;

void main() throws Exception {
    Restaurant restaurant = new StructuredConcurrencyRestaurant();
    restaurant.announceMenu();
}
