@Test
    Feature: Prueba automatizada para mercado Libre utilizando las herramientas(Selenium, JUnit 4, Cucumber, JAVA)

@Prueba_Uno
    Scenario: Prueba uno de automatizacion del Ecommerce ML
        Given Abrir la pagina web www.mercadolibre.com.mx
        When Cerrar todas las ventanas y popoops
        Then Buscar en la barra de busqueda playstation
        Then Filtrar producto por condicion nuevo
        Then Filtrar producto por localizacion CDMX
        Then Filtrar producto por menor precio
        And Obtener los nombres y precios de los cinco primeros productos