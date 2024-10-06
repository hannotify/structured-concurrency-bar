import com.github.hannotify.structuredconcurrency.restaurant.MultiWaiterExecutorServiceRestaurant;
import com.github.hannotify.structuredconcurrency.restaurant.MultiWaiterThreadsRestaurant;
import com.github.hannotify.structuredconcurrency.restaurant.Restaurant;
import com.github.hannotify.structuredconcurrency.restaurant.SingleWaiterRestaurant;
import com.github.hannotify.structuredconcurrency.restaurant.StructuredConcurrencyRestaurant;

void main() throws Exception {
    Restaurant restaurant = new StructuredConcurrencyRestaurant();
    restaurant.announceMenu();
}
