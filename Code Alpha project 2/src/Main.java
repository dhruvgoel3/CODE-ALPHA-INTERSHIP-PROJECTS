import java.util.HashMap;
import java.util.Map;

// Stock class to represent a stock with symbol and price
class Stock {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// Portfolio class to manage stock holdings and cash balance
class Portfolio {
    private Map<String, Integer> stocks;
    private double cashBalance;

    public Portfolio(double initialCash) {
        this.stocks = new HashMap<>();
        this.cashBalance = initialCash;
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (cost <= cashBalance) {
            cashBalance -= cost;
            stocks.put(stock.getSymbol(), stocks.getOrDefault(stock.getSymbol(), 0) + quantity);
            System.out.println("Bought " + quantity + " of " + stock.getSymbol());
        } else {
            System.out.println("Not enough cash to buy " + quantity + " of " + stock.getSymbol());
        }
    }

    public void sellStock(Stock stock, int quantity) {
        int currentQuantity = stocks.getOrDefault(stock.getSymbol(), 0);
        if (currentQuantity >= quantity) {
            double saleProceeds = stock.getPrice() * quantity;
            cashBalance += saleProceeds;
            stocks.put(stock.getSymbol(), currentQuantity - quantity);
            System.out.println("Sold " + quantity + " of " + stock.getSymbol());
        } else {
            System.out.println("Not enough stock to sell " + quantity + " of " + stock.getSymbol());
        }
    }

    public void printPortfolio() {
        System.out.println("Portfolio:");
        for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
            System.out.println("Stock: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
        System.out.println("Cash Balance: $" + cashBalance);
    }
}

// MarketData class to manage stock prices
class MarketData {
    private Map<String, Stock> stockMap;

    public MarketData() {
        stockMap = new HashMap<>();
    }

    public void addStock(Stock stock) {
        stockMap.put(stock.getSymbol(), stock);
    }

    public Stock getStock(String symbol) {
        return stockMap.get(symbol);
    }

    public void updateStockPrice(String symbol, double newPrice) {
        Stock stock = stockMap.get(symbol);
        if (stock != null) {
            stock.setPrice(newPrice);
        }
    }

    public void printMarketData() {
        System.out.println("Market Data:");
        for (Stock stock : stockMap.values()) {
            System.out.println("Symbol: " + stock.getSymbol() + ", Price: $" + stock.getPrice());
        }
    }
}

// Trade class to execute buy and sell operations
class Trade {
    public static void executeBuy(Portfolio portfolio, Stock stock, int quantity) {
        portfolio.buyStock(stock, quantity);
    }

    public static void executeSell(Portfolio portfolio, Stock stock, int quantity) {
        portfolio.sellStock(stock, quantity);
    }
}

// Main class to run the simulation
class StockTradingPlatform {

    public static void main(String[] args) {
        MarketData marketData = new MarketData();
        Portfolio portfolio = new Portfolio(10000); // Initial cash balance

        // Initialize market data
        Stock apple = new Stock("AAPL", 150.0);
        Stock google = new Stock("GOOGL", 2800.0);
        marketData.addStock(apple);
        marketData.addStock(google);

        // Print initial market data
        marketData.printMarketData();

        // Perform trades
        Trade.executeBuy(portfolio, apple, 10);
        Trade.executeSell(portfolio, apple, 5);

        // Print portfolio
        portfolio.printPortfolio();

        // Update market data and perform another trade
        marketData.updateStockPrice("AAPL", 160.0);
        Trade.executeBuy(portfolio, apple, 20);

        // Print updated portfolio
        portfolio.printPortfolio();
    }
}
