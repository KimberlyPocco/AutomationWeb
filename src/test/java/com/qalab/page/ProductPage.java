package com.qalab.page;

import org.openqa.selenium.By;

public class ProductPage {

    public static By cantidadProducto = By.id("quantity_wanted");
    public static By precioProducto = By.xpath("//span[@class='price' and @aria-label='Precio']");
    public static By btnAñadirCarrito = By.xpath("//button[@data-button-action='add-to-cart']");
    public static By precioPopUp = By.xpath("//p[@class='product-price']");
    public static By totalPopUp = By.xpath("//p[contains(text(), 'Total (impuestos incl.)')]/following-sibling::span[@class='value']");
    public static By subTotalCarrito = By.xpath("//div[@id='cart-subtotal-products']//span[@class='value']");
    public static By obtenerTotalCarrito = By.xpath("//div[contains(@class, 'cart-summary-line cart-total')]//span[@class='value']");
    public static By btnFinalizarCompra = By.linkText("Finalizar compra");
    public static By imagenProducto = By.xpath("//div[@class='thumbnail product-thumbnail']//picture");
    public static By tituloCarrito = By.xpath("//h1[@class='h1' and text()='CARRITO']");


    public static By obtenerCategoria(String categoria) {
        return By.xpath("//span[contains(text(),' "+ categoria +" ')]");
    }

    public static By obtenerSubCategoria(String subcategoria) {
        return By.xpath("//ul[contains(@class,'category-sub-menu')]//a[contains(text(), '" + subcategoria + "')]");
    }
}
