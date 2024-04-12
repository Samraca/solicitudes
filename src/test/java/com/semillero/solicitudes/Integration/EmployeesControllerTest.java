package com.semillero.solicitudes.Integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("when obtaining employees returns JSON media and responds with 200 http status")
    @Test
    void whenCallEmployeesThenStatusIs200AndReturnsJsonMediaType() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/empleados/getAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @DisplayName("when creating employees returns JSON media and responds with 200 http status")
    @Test
    void whenCreateEmployeesThenStatusIs200AndReturnsJsonMediaType() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/empleados/create")
                        .content("{\n" +
                                "        \"id\": 1,\n" +
                                "        \"documento\": 38924324,\n" +
                                "        \"tipoDocumento\": \"Cédula\",\n" +
                                "        \"nombre\": \"Ricardo\",\n" +
                                "        \"apellido\": \"Sanchez\",\n" +
                                "        \"telefono\": \"3452341232\",\n" +
                                "        \"direccion\": \"Calle 50 #50-30\",\n" +
                                "        \"fechaIngreso\": \"2023-09-09T05:00:00.000+00:00\",\n" +
                                "        \"fechaRetiro\": null,\n" +
                                "        \"tipoContrato\": \"Laboral\",\n" +
                                "        \"estado\": \"Activo\",\n" +
                                "        \"supervisor\": null,\n" +
                                "        \"cargo\": {\n" +
                                "            \"id\": 1,\n" +
                                "            \"cargo\": \"Gerente\",\n" +
                                "            \"descripcion\": \"Responsable de la gestión general de la empresa\",\n" +
                                "            \"fechaCreacion\": \"2024-03-17T15:13:59.000+00:00\",\n" +
                                "            \"activo\": \"activo\"\n" +
                                "        }\n" +
                                "    }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @DisplayName("when updating employee return JSON media and responds with 200 http status")
    @Test
    void whenUpdateEmployeeThenStatusIs200AndReturnsJsonMediaType() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/empleados/update")
                        .content("{\n" +
                                "        \"id\": 1,\n" +
                                "        \"documento\": 38924324,\n" +
                                "        \"tipoDocumento\": \"Cédula\",\n" +
                                "        \"nombre\": \"Ricardo\",\n" +
                                "        \"apellido\": \"Sanchez\",\n" +
                                "        \"telefono\": \"3452341232\",\n" +
                                "        \"direccion\": \"Calle 50 #50-30\",\n" +
                                "        \"fechaIngreso\": \"2023-09-09T05:00:00.000+00:00\",\n" +
                                "        \"fechaRetiro\": null,\n" +
                                "        \"tipoContrato\": \"Laboral\",\n" +
                                "        \"estado\": \"Activo\",\n" +
                                "        \"supervisor\": null,\n" +
                                "        \"cargo\": {\n" +
                                "            \"id\": 1,\n" +
                                "            \"cargo\": \"Gerente\",\n" +
                                "            \"descripcion\": \"Responsable de la gestión general de la empresa\",\n" +
                                "            \"fechaCreacion\": \"2024-03-17T15:13:59.000+00:00\",\n" +
                                "            \"activo\": \"activo\"\n" +
                                "        }\n" +
                                "    }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));


    }

    @DisplayName("when deleting employee return status 200")
    @Test
    void whenDeletingEmployeeThen200Status() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/empleados/delete")
                        .param("id", ""+Mockito.anyInt())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
