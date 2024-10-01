package com.qalab.steps;

import com.qalab.page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductSteps {

    private WebDriver driver;

    public ProductSteps(WebDriver driver) {
        this.driver = driver;
    }

    public ProductSteps seleccionarCategoriaYsubCategoria(String categoria, String subcategoria) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.obtenerCategoria(categoria)));

        WebElement categoriaElement = driver.findElement(ProductPage.obtenerCategoria(categoria));
        categoriaElement.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.obtenerSubCategoria(subcategoria)));

        WebElement subcategoriaElement = driver.findElement(ProductPage.obtenerSubCategoria(subcategoria));
        subcategoriaElement.click();

        return new ProductSteps(driver);
    }

    public ProductSteps seleccionarProducto() {
        driver.findElement(ProductPage.imagenProducto).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.precioPopUp));

        return this;
    }

    public ProductSteps agregarProductoCarrito(int cantidad) {
        WebElement campoCantidad = driver.findElement(ProductPage.cantidadProducto);
        campoCantidad.clear();
        campoCantidad.sendKeys(String.valueOf(cantidad));
        driver.findElement(ProductPage.btnAñadirCarrito).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.precioPopUp));

        return this;
    }

    public ProductSteps validarConfirmacionProductoAgregado() {
        String precioProducto = driver.findElement(ProductPage.precioProducto).getText().trim();
        String precioPopUp = driver.findElement(ProductPage.precioPopUp).getText().trim();
        String totalPopUp = driver.findElement(ProductPage.totalPopUp).getText().trim();

        if (!precioProducto.equals(precioPopUp)) {
            throw new AssertionError("El precio del producto y el precio en el popup no coinciden");
        }

        return this;
    }

    public ProductSteps finalizarCompra() {
        driver.findElement(ProductPage.btnFinalizarCompra).click();
        return this;
    }

    public ProductSteps validarCalculoPreciosCarrito() {
        String subTotalCarrito = driver.findElement(ProductPage.subTotalCarrito).getText().trim();
        String totalCarrito = driver.findElement(ProductPage.obtenerTotalCarrito).getText().trim();

        if (!subTotalCarrito.equals(totalCarrito)) {
            throw new AssertionError("El subtotal y el total en el carrito no coinciden");
        }

        return this;
    }

    public ProductSteps validarTituloCarrito() {
        WebElement tituloCarrito = driver.findElement(ProductPage.tituloCarrito);
        if (!tituloCarrito.getText().equals("CARRITO")) {
            throw new AssertionError("El título de la página del carrito no es correcto: " + tituloCarrito.getText());
        }

        return this;
    }
}
