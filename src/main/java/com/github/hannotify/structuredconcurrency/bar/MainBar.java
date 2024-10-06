import com.github.hannotify.structuredconcurrency.bar.Bar;
import com.github.hannotify.structuredconcurrency.bar.Drink;
import com.github.hannotify.structuredconcurrency.bar.DrinkCategory;
import com.github.hannotify.structuredconcurrency.bar.Guest;
import com.github.hannotify.structuredconcurrency.bar.StructuredConcurrencyBar;

void main() throws Exception {
    Bar bar = new StructuredConcurrencyBar();

    Guest hanno = new Guest("Hanno", List.of(
            new Drink("Espresso", DrinkCategory.COFFEE),
            new Drink("Westmalle Dubbel", DrinkCategory.BEER)
    ));

    Guest rianne = new Guest("Rianne", List.of(
            new Drink("Cappuccino", DrinkCategory.COFFEE),
            new Drink("Green tea", DrinkCategory.TEA)
    ));

    bar.determineDrinkOrder(hanno);
    bar.determineDrinkOrder(rianne);
}