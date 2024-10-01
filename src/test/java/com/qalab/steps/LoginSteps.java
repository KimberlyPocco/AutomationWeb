package com.qalab.steps;

import com.qalab.page.LoginPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void cargarPagina() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://qalab.bensg.com/store/pe");
    }

    public void iniciarSesion(String email, String password) {
        driver.findElement(LoginPage.irAIniciarSesion).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement emailInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.emailInput));
        emailInputElement.sendKeys(email);

        WebElement passwordInputElement = driver.findElement(LoginPage.passwordInput);
        passwordInputElement.sendKeys(password);

        WebElement btnInicioSesion =driver.findElement(LoginPage.btnInicioSesion);
        btnInicioSesion.click();
    }



    public String comprobarLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.mensajelogin));
            WebElement errorElement = driver.findElement(LoginPage.errorLogin);
            String errorMessage = errorElement.getText();

            if (errorMessage.equals("Error de autenticación.")) {
                return errorMessage;
            } else {
                throw new AssertionError("Error de login inesperado: " + errorMessage);
            }

        } catch (NoSuchElementException e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.categoriaLogin));
            WebElement categoria = driver.findElement(LoginPage.categoriaLogin);
            return categoria.getText();
        } catch (Exception e) {
            throw new RuntimeException("Se produjo un error al comprobar el login: " + e.getMessage());
        }
    }
}
