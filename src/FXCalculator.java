import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class FXCalculator {

    private static Map<String, BigDecimal> fxRates;
    private static Map<String, String> fxLookUp;
    private static BigDecimal finalAmount;

    static {
        fxRates = new HashMap<>();
        fxRates.put("AUDUSD", new BigDecimal(0.8371));
        fxRates.put("EURUSD", new BigDecimal(1.2315));
        fxRates.put("EURDKK", new BigDecimal(7.4405));
        fxRates.put("USDJPY", new BigDecimal(119.95));

        fxLookUp = new HashMap<>();
        fxLookUp.put("AUDDKK", "USD");
        fxLookUp.put("AUDJPY", "USD");
        fxLookUp.put("USDDKK", "EUR");
        fxLookUp.put("EURDKK", "D");
        fxLookUp.put("USDJPY", "D");
        fxLookUp.put("USDEUR", "I");
    }

    public static void main(String[] args) {
        System.out.println(getConvertedRate(new BigDecimal(1), "AUD", "DKK"));
    }

    private static BigDecimal getConvertedRate(BigDecimal quantity, String fromCurrency, String toCurrency) {
        String termCurrency = fxLookUp.get(fromCurrency + toCurrency);

        if ("D".equalsIgnoreCase(termCurrency)) {
            return fxRates.get(fromCurrency + toCurrency).multiply(quantity).setScale(4, RoundingMode.HALF_UP);
        } else if ("I".equalsIgnoreCase(fxLookUp.get(fromCurrency + termCurrency))) {
            BigDecimal interimQuantity =
                    BigDecimal.ONE.divide(fxRates.get(termCurrency + fromCurrency), 2, RoundingMode.HALF_EVEN).multiply(quantity);
            finalAmount = getConvertedRate(interimQuantity, termCurrency, toCurrency);
        } else {
            BigDecimal interimQuantity = fxRates.get(fromCurrency + termCurrency).multiply(quantity).setScale(4, RoundingMode.HALF_UP);
            finalAmount = getConvertedRate(interimQuantity, termCurrency, toCurrency);
        }
        return finalAmount;
    }
}
