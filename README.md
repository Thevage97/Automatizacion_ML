# 🧪 Proyecto de Automatización - Mercado Libre

Este proyecto realiza pruebas automatizadas de extremo a extremo sobre el sitio web de [Mercado Libre México](https://www.mercadolibre.com.mx), utilizando el stack de automatización:

- **Java 17**
- **Selenium WebDriver**
- **Cucumber + Gherkin**
- **JUnit**
- **ExtentReports**
- **Log4j2**
- **Maven**

---

## 📁 Estructura del Proyecto

```
test/
├── pom.xml
├── src/
│ ├── main/
│ │ └── java/
│ │ ├── engine/
│ │ ├── pages/
│ │ ├── pages/elements/
│ │ └── utils/
│ ├── test/
│ │ └── java/
│ │ ├── hooks/
│ │ ├── runner/
│ │ └── steps/
│ └── test/
│ └── resources/
│ └── features/
├── target/
│ └── ExtentReports/
│ └── ExtentReport.html
├── TestReport/
│ └── ExtentReports_YYYY-MM-DD_HH-mm-ss/
└── screenshots/
```

---

## 🚀 ¿Cómo ejecutar las pruebas?

1. Clona el repositorio y navega al directorio:

```
bash
git clone https://github.com/tu_usuario/automatizacion-e2e-ml.git
cd automatizacion-e2e-ml
```
2. **Asegúrate de tener:**
- Java 17+
- Maven
3. **Descargar y descomprimir Chrome for testing en la raiz del proyecto**
```
https://storage.googleapis.com/chrome-for-testing-public/137.0.7151.55/win64/chrome-win64.zip
```
4. **Ejecuta los tests:**
```
mvn clean test
```
## 📊 Reportes de ejecución
Se generan automáticamente en:
- target/ExtentReports/ExtentReport.html
- Copia con timestamp en TestReport/ExtentReports_YYYY-MM-DD_HH-mm-ss
- Incluyen:
- Resultados paso a paso
- Capturas de pantalla embebidas
- Escenarios ejecutados
- Información del entorno

## 👨‍💻 Autor
Desarrollado por: [Carlos Ivan Perez]


