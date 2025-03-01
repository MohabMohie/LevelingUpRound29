package pomTestPackage.advanced;

import org.testng.Assert;
import org.testng.annotations.Test;
import w3schools.advanced.AbstractFluentTables;

@Test public class W3SchoolsTableAbstractFluentTests extends TestCase {

    public void checkContactNameForErnstHandelInAustria(){
        String contactNameText = new AbstractFluentTables(driver).navigate().getContactNameUsingCompanyAndCountry("Ernst Handel", "Austria");
        Assert.assertEquals(contactNameText, "Roland Mendel");
    }

    public void checkContactNameForAlfredsFutterkisteInGermany(){
        String contactNameText = new AbstractFluentTables(driver).navigate().getContactNameUsingCompanyAndCountry("Alfreds Futterkiste", "Germany");
        Assert.assertEquals(contactNameText, "Maria Anders");
    }

}
