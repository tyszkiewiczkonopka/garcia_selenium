package chapters.chapter3;

import baseTest.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import providers.UrlProvider;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class DatepickerTest extends BaseTest {

    @Test
    public void should_choose_same_day_and_month_previous_year() {
        driver.get(UrlProvider.WEB_FORM);
        openDatePicker();
        chooseLastYear();
        chooseCurrentDayAndMonth();

        String pickedDateText = driver.findElement(By.cssSelector("input[name='my-date']")).getAttribute("value");
        log.debug("Picked date: " + pickedDateText);

        String expectedDate = LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        log.debug("Expected date: " + expectedDate);

        assertThat(pickedDateText).isEqualTo(expectedDate);
    }

    private void chooseCurrentDayAndMonth() {
        WebElement currentMonth = driver.findElement(By.xpath(".//*[@class='month focused']"));
        currentMonth.click();
        WebElement currentDay = driver.findElement(By.xpath("//td[@class='day' and text()='" + LocalDate.now().getDayOfMonth() + "']"));
        currentDay.click();
    }

    private void chooseLastYear() {
        driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).click();
        driver.findElement(By.cssSelector(".datepicker-months .datepicker-switch")).click();
        WebElement previousYear = driver.findElement(By.xpath(".//*[@class='year focused']/preceding-sibling::span[1]"));
        previousYear.click();
    }

    private void openDatePicker() {
        WebElement dateInput = driver.findElement(By.cssSelector("input[name='my-date']"));
        dateInput.click();
    }
}
