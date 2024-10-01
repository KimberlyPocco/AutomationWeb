package com.qalab.page;

import org.openqa.selenium.By;

public class LoginPage {

    public static By irAIniciarSesion = By.xpath("//a[contains(text(), 'Iniciar sesión')]");
    public static By emailInput = By.id("field-email");
    public static By passwordInput = By.id("field-password");
    public static By btnInicioSesion = By.id("submit-login");

public static By categoriaLogin = By.xpath("//div[@id='category-3']");
public static By errorLogin = By.xpath("//li[contains(@class, 'alert')]");

   public static By mensajelogin = By.xpath(errorLogin + "|" + categoriaLogin);
}
