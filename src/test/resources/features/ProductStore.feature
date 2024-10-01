Feature: Product - Store

  @precio-producto
  Scenario Outline: Validación del precio de un producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "<user>" y clave "<password>"
    When navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    And agrego <cantidad> unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

    Examples:
      | user                    | password  | categoria | subcategoria | cantidad |
      | kimberlypocco@gmail.com | qalab123/ | Clothes   | Men          | 2        |
      | kimberlypocco@gmail.com | 123456/$m | Clothes   | Women        | 1        |
      | kimberlypocco@gmail.com | qalab123/ | Autos   | Autos        | 1        |

