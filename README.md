# ecommerce_selenium_demo

# Automatización de Pruebas con Selenium, JUnit y Cucumber
Este repositorio contiene una suite de pruebas automatizadas utilizando Selenium WebDriver junto con JUnit y Cucumber para realizar pruebas de comportamiento (BDD) utilizando Gherkin. La aplicación de demostración simula un sistema bancario para pruebas automatizadas.

## Detalles de la Aplicación

La aplicación de demostración bancaria incluye varias funcionalidades clave que se prueban a través de estos frameworks de automatización:

- **Apertura de cuentas:** Verificación de la creación las cuentas para un cliente.
- **Pagos servicio:** Validación de pagos de fondos entre cuentas.
- **Registro cliente:** Prueba de registro de un cliente.
- **Gestion de cuentas:** Validacion de cuentas de un cliente

## Frameworks Utilizados

### Selenium WebDriver
Selenium WebDriver se utiliza para la automatización de navegadores web. 
### JUnit
JUnit es un framework de prueba unitaria para Java. En este proyecto, JUnit se utiliza para organizar y ejecutar las pruebas integración de manera estructurada.

### Cucumber y Gherkin
Cucumber es una herramienta que facilita la escritura de pruebas BDD. Utiliza el lenguaje de especificación Gherkin para describir el comportamiento esperado en un formato legible por humanos. Las historias y escenarios escritos en Gherkin son ejecutados por Cucumber, haciendo que las pruebas sean más accesibles y comprensibles para todas las partes interesadas.

## Page Object Model (POM)

El proyecto sigue el patrón Page Object Model (POM) para organizar las pruebas de manera eficiente y mantenible. En el POM, cada página o componente de la interfaz de usuario tiene su propia clase Java que encapsula el comportamiento y los elementos de esa página.

## Integración con Jenkins

Jenkins es un servidor open source para la integración continua. Es una herramienta que se utiliza para compilar y probar proyectos de software de forma continua, lo que facilita a los desarrolladores integrar cambios en un proyecto y entregar nuevas versiones a los usuarios. Escrito en Java, es multiplataforma y accesible mediante interfaz web. Es el software más utilizado en la actualidad para este propósito.
## Estructura del Repositorio

- **`src/test/java`**: Contiene las clases de prueba JUnit y los Page Objects que representan las páginas de la aplicación.
- **`src/test/resources`**: Incluye los archivos de características escritos en Gherkin para Cucumber.
- **`drivers`**: Carpeta para almacenar los controladores de Selenium WebDriver para diferentes navegadores.

## Configuración y Ejecución

Para ejecutar las pruebas desde este repositorio:

1. Clonar el repositorio en tu máquina local:
   ```bash
   https://github.com/Andresh95/ecommerce_selenium_demo.git
2. Tener Maven instalado y configurado en tu sistema.

3. Ejecuta las pruebas con Maven:
   ```bash
   mvn test
