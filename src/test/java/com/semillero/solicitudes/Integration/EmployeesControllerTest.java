package com.semillero.solicitudes.Integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
                        .content("{\"documento\" : \"1010\", \"tipoDocumento\": \"cedula\", \"nombre\":\"Juan\", \"apellido\":\"carvajal\", \"telefono\":\"3245678798\", \"direccion\":\"crra 24 sur # 15a-113\", \"cargo\":\"supervisor\", \"fechaIngreso\":\"2023:21:12\", \"fechaRetiro\":\"\", \"tipoContrato\":\"laboral\", \"estado\":\"activo\", \"Supervisor\":\"0\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
