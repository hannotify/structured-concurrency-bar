import com.github.hannotify.structuredconcurrency.restaurant.Restaurant;
import com.github.hannotify.structuredconcurrency.restaurant.SingleWaiterRestaurant;

void main() throws Exception {
    Restaurant restaurant = new SingleWaiterRestaurant();
    restaurant.announceMenu();
}
