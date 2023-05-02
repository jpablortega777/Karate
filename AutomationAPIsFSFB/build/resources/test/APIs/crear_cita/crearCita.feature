Feature: Crear cita paciente
  Background:
    * url baseURL
    * path "/agendamiento/agendar-cita"
    * def privateKey = "7a075e0e-f5ad-45aa-84be-2df3be7adce0"
    * def id_transaccion = "QA-PRU-AUT1";
    * def cod_servicio = "018"
    * def rut_profesional = "21068802"
    * def fecha = "02-05-2023"
    * def hora = "08:45"
    * def correl_hora = "1"
    * def cod_prestacion = "890276"
    * def cod_paciente = "68033"
    * def sedacion = "0"
    * def cod_centro_atencion = "FSFB"
    * def cod_clasificacion = " "
    * def telemedicina = "N"
    * def security_class = Java.type('security_crear_cita')
    * def payload = security_class.encryptMD5(id_transaccion, cod_servicio, rut_profesional, fecha, hora, correl_hora, cod_prestacion, cod_paciente, sedacion, cod_centro_atencion, cod_clasificacion, telemedicina, timestamp, privateKey)
    * header Content-Type = 'application/json'
    * header Authorization = 'FSB:'+ payload

  Scenario: probando
    When request { "agendar_cita_request": { "id_transaccion": #(id_transaccion), "cod_servicio": #(cod_servicio), "rut_profesional": #(rut_profesional), "fecha": #(fecha), "hora": #(hora), "correl_hora": #(correl_hora), "cod_prestacion": #(cod_prestacion), "cod_paciente": #(cod_paciente), "sedacion": #(sedacion), "cod_centro_atencion": #(cod_centro_atencion), "cod_clasificacion": #(cod_clasificacion), "telemedicina": #(telemedicina), "timestamp": #(timestamp) } }
    And method post
    Then status 200