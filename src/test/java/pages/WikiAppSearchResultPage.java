package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;

public class WikiAppSearchResultPage {

    private final ElementsCollection titlesCollection = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Открытие статьи")
    public void openSearchedArticle(String value) {
        titlesCollection.find(text(value)).click();
    }

    @Step("Проверка результатов поиска")
    public void checkResultPos() {
        titlesCollection.shouldHave(sizeGreaterThan(0));
    }

}