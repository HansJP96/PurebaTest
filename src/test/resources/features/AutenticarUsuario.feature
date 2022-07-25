
Feature: Login de usuario
  Yo como usuario
  me voy a loguear
  para ingresar

  Background:
    Given que entro al sitio web

  Scenario: Validar login exitoso
    When ingreso mis credenciales
    Then puedo entrar a la pagina a comprar

  Scenario: Validar login de usuario bloqueado
    When ingreso mis credenciales bloqueadas
    Then me aparece un mensaje de error
