package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class TicketsPage {

    private final By createTicketButton = By.xpath("//button[@data-id='tickets_listview_createticket']");

    private final SHAFT.GUI.WebDriver driver;

    public TicketsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public TicketsPage clickCreateNewTicket(){

        return this;
    }
}
