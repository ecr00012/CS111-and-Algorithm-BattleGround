package lab3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class StockTest {

	public static List<String> getShortNames(List<Stock> x) {
		return x.stream().map(Stock::getShortName).collect(Collectors.toList());
	}

	private static List<Stock> StockList() {
		return Arrays.asList(new Stock("GameStop", "GME", 219.01), new Stock("AMC", "AMC", 105.01),
				new Stock("Salem Media Group", "SALM", 2.61), new Stock("Apple", "AAPL", 137.09));
	}

	@Test
	void Constructor_WorksAsExpected() {
		var gme = new Stock("GameStop", "GME", 219.01);

		assertNotNull(gme);
	}

	@Test
	void CompareTo_HigherMarketValue_ExpectNegative1() {
		var amc = new Stock("AMC", "AMC", 100.05);
		var gme = new Stock("GameStop", "GME", 219.01);

		assertEquals(amc.compareTo(gme), -1);
	}

	@Test
	void CompareTo_LowerMarketValue_Expect1() {
		var amc = new Stock("AMC", "AMC", 100.05);
		var gme = new Stock("GameStop", "GME", 219.01);

		assertEquals(gme.compareTo(amc), 1);
	}

	@Test
	void CompareTo_SameMarketValue_Expect0() {
		var gme = new Stock("GameStop", "GME", 219.01);

		assertEquals(gme.compareTo(gme), 0);
	}

	@Test
	void StockList_SortListOfStocks_UsingCompareTo() {
		var stocks = StockList();

		Collections.sort(stocks);
		Utils.assertListHasBeenSorted(StockList(), stocks);
	}

	@Test
	void StockShortNameComparator_ExpectListToBeSorted() {
		var stocks = StockList();

		stocks.sort(new StockShortNameComparator());
		System.out.println("Stocks Sorted by ShortName: " + stocks);

		var sortedStockNames = getShortNames(stocks); // Easier to map to shortNames then compare those list
		var stockNames = getShortNames(StockList());
		Utils.assertListHasBeenSorted(stockNames, sortedStockNames);
	}
}
