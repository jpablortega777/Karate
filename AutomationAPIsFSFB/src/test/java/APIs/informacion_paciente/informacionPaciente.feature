Feature: Obtener informacion del paciente
  Background:
    * url baseURL
    * path "/agendamiento/informacion-paciente"
    * def tipo_documento = "4"
    * def numero_documento = "80084711"
    * def privateKey = "395e06b3-0c0b-47f2-a526-371691616f82"
    * def security_class = Java.type('security_informacion_pacientes')
    * def payload = security_class.encryptMD5(tipo_documento, numero_documento, timestamp, privateKey)
    * header Authorization = 'FSB:'+ payload
    * header Content-Type = 'application/json'

  Scenario: probando
    When request { "paciente": { "tipo_documento": #(tipo_documento), "numero_documento": #(numero_documento) }, "timestamp": #(timestamp) }
    And method post
    Then status 200



