package com.andrei.myapp;

import com.andrei.myapp.dto.AutoBaseDto;
import com.andrei.myapp.model.entity.AutoBase;
import com.andrei.myapp.service.impl.AutoBaseDtoServiceImpl;
import com.andrei.myapp.service.interfaces.AutoBaseDtoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class AutoBaseControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private AutoBaseDtoService autoBaseDtoService;
    private List<AutoBaseDto> autoBaseList;

   /* @BeforeEach
    void setUp() {
        this.autoBaseList = new ArrayList<>();
        AutoBaseDto autoBase1 = new AutoBaseDto();
        AutoBaseDto autoBase2 = new AutoBaseDto();
        AutoBaseDto autoBase3 = new AutoBaseDto();
        autoBase1.setAutoBaseId(1L);
        autoBase1.setAddress("x");
        autoBase2.setAutoBaseId(2L);
        autoBase2.setAddress("y");
        autoBase3.setAutoBaseId(3L);
        autoBase3.setAddress("z");
        autoBaseList.add(autoBase1);
        autoBaseList.add(autoBase2);
        autoBaseList.add(autoBase3);
    }*/

    @Test
    public void givenAutoBase_whenAdd_thenStatus201andPersonReturned() throws Exception {

        AutoBase autoBase = new AutoBase();
        Mockito.when(autoBaseDtoService.save(Mockito.any())).thenReturn(autoBase);

        mockMvc.perform(
                post("/admin/autoBaseDto/save")
                        .content(objectMapper.writeValueAsString(autoBase))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(autoBase)));
    }
}















     /*   @Test

        public void shouldFetchAllAutoBases () throws Exception {
            given(autoBaseDtoServiceImpl.getAll()).willReturn(autoBaseList);
            this.mockMvc

                    .perform(MockMvcRequestBuilders.get("admin/autoBaseDtos"))
                    .andExpect(status().isOk())
                    .andExpect(model().attributeExists("autoBaseDtos"));

        }
    }*/





















    /* @Test
     public void givenAutoBase_whenAdd_thenReturnedReturned() throws Exception {
         AutoBase autoBase = new AutoBase();
         autoBase.setAutoBaseId(1L);
         autoBase.setAddress("Piushkina,21");
         Mockito.when(autoBaseDao.save(Mockito.any())).thenReturn(autoBase);
         mockMvc.perform(
                 post("/admin/autoBaseDto/save")
                         .content(objectMapper.writeValueAsString(autoBase))
                         .contentType(MediaType.APPLICATION_JSON)

         )

                 .andExpect((ResultMatcher) content().json(objectMapper.writeValueAsString(autoBase)));
     }
    @Test
    public void givenId_whenGetExistingPerson_thenStatus200andPersonReturned() throws Exception {

        AutoBase autoBase = new AutoBase();
        autoBase.setAutoBaseId(1L);
        autoBase.setAddress("Piushkina,21");
        Mockito.when(autoBaseDao.findById(Mockito.any())).thenReturn(Optional.of(autoBase));

        mockMvc.perform(
                get("admin/autoBaseDtos/edit/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.address").value("Piushkina,21"));
    }
    @Test
    public void givenId_whenGetNotExistingPerson_thenStatus404anExceptionThrown() throws Exception {


        Mockito.when(autoBaseDao.findById(Mockito.any())).
                thenReturn(Optional.empty());

        mockMvc.perform(
                get("admin/autoBaseDtos/edit/{autoBaseId}"))
                .andExpect(status().isNotFound())
                .andExpect(mvcResult -> mvcResult.getResolvedException().getClass().equals(EntityNotFoundException.class));

    }*/


