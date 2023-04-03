package Lesson06.ddt;

import org.testng.annotations.DataProvider;

public class DataProviderSource {
    @DataProvider(name = "data-search")
    public static Object[][] getDataObject() {
        return new Object[][] {
                {"Israel", "Israel"},
                {"Automation", "Automation"},
                {"BlahBlah", "Search results"}
        };
    }
}
