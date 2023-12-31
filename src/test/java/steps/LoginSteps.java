package steps;

import lombok.extern.log4j.Log4j2;
import pages.MainPage;
import pages.SignUpLoginPage;

import static com.codeborne.selenide.Selenide.$x;
import static constants.SignUpLoginPageLocators.ERROR_NOTIFICATION;
import static java.lang.String.format;

@Log4j2
public class LoginSteps {
    MainPage mainPage;
    SignUpLoginPage signUpLoginPage;

    public LoginSteps() {
        mainPage = new MainPage();
        signUpLoginPage = new SignUpLoginPage();
    }

    public LoginSteps loginWithCreds(String email, String password) {
        signUpLoginPage
                .login(email, password);
        log.info(format("Login with email --> %s and password --> %s", email, password));
        mainPage
                .isOpened();
        return this;
    }

    public void checkNotificationAndColor(String notificationText) {
        signUpLoginPage
                .checkErrorNotification(notificationText)
                .getCssValue($x(format(ERROR_NOTIFICATION, notificationText)), "color");
    }
}
