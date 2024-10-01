package com.qalab.stepsdefinitions;

import com.qalab.steps.ProductSteps;
import com.qalab.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.qalab.core.DriverManager.getDriver;

public class ProductStepsDef {

    private LoginSteps loginSteps;
    private ProductSteps productSteps;

    public ProductStepsDef() {
        WebDriver driver = getDriver();
        this.loginSteps = new LoginSteps(driver);
        this.productSteps = new ProductSteps(driver);
    }

    @Given("estoy en la página de la tienda")
    public void estoy_en_la_pagina_de_la_tienda() {
        loginSteps.cargarPagina();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void me_logueo_con_mi_usuario_y_clave(String user, String password) {
        loginSteps.iniciarSesion(user, password);
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navego_a_la_categoria_y_subcategoria(String categoria, String subcategoria) {
        loginSteps.comprobarLogin();
        productSteps.seleccionarCategoriaYsubCategoria(categoria, subcategoria);
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agrego_unidades_del_primer_producto_al_carrito(int cantidad) {
        productSteps.seleccionarProducto();
        productSteps.agregarProductoCarrito(cantidad);
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void valido_en_el_popup_la_confirmacion_del_producto_agregado() {
        productSteps.validarConfirmacionProductoAgregado();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void valido_en_el_popup_que_el_monto_total_sea_calculado_correctamente() {
        productSteps.validarCalculoPreciosCarrito();
    }

    @When("finalizo la compra")
    public void finalizo_la_compra() {
        productSteps.finalizarCompra();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void valido_el_titulo_de_la_pagina_del_carrito() {
        productSteps.validarTituloCarrito();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvo_a_validar_el_calculo_de_precios_en_el_carrito() {
        productSteps.validarCalculoPreciosCarrito();
    }
}
