package Locators;

public class ProductPageLocators {
	// Locator for the filter dropdown
    public static final String filterDropdown = "product_sort_container"; // ClassName

    // Locator for all product prices
    public static final String productPrices = "inventory_item_price"; // ClassName

    // Locator for all product names
    public static final String productNames = "inventory_item_name"; // ClassName

    // Locator for all "Add to Cart" buttons
    public static final String addToCartButtons = ".inventory_item button.btn_primary"; // CSS Selector

    // Locator for all "Remove from Cart" buttons
    public static final String removeFromCartButtons = ".inventory_item button.btn_secondary"; // CSS Selector

    // Locator for the cart badge that shows the number of items in the cart
    public static final String cartBadge = "shopping_cart_badge"; // ClassName
}
