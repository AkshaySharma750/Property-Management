package com.mycompany.PropertyManagement.controller;

import com.mycompany.PropertyManagement.dto.PropertyDTO;
import com.mycompany.PropertyManagement.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @InjectMocks
    private PropertyController propertyController;//Mockito is going to create a proxy/dummy object of PropertyController and inject it to our PropertyControllerTest

    @Mock//mpckito will give memory to PropertyService and will inject this dummy/proxy PropertyService object inside the proxy object of PropertyCOntroller
    private PropertyService propertyService;

    @Test
    @DisplayName("Test Success Scenario for saving new Property")
    void testSaveProperty(){
        PropertyDTO dto = new PropertyDTO();
        dto.setTitle("Dummy property");

        PropertyDTO savedProperty = new PropertyDTO();
        savedProperty.setId(1L);
        savedProperty.setTitle(dto.getTitle());

        //Do not make the actual call for propertyService.saveProperty(dto) inside controller rather return dummy object which is savedProperty
        Mockito.when(propertyService.saveProperty(dto)).thenReturn(savedProperty);
        ResponseEntity<PropertyDTO> resposeEntity = propertyController.saveProperty(dto);
        Assertions.assertNotNull(resposeEntity.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED.value(), resposeEntity.getStatusCodeValue());

    }
    @Test
    @DisplayName("Test Success Scenario for Fetching All Properties")
    void testGetProperties(){
        List<PropertyDTO> propertyList = new ArrayList<>();
        PropertyDTO dto = new PropertyDTO();
        dto.setId(1L);
        dto.setTitle("Dummy Property");
        propertyList.add(dto);

        //Do not make the actual call for propertyService.getAllProperties() inside controller rather return dummy List<PropertyDTO> in the controller
        Mockito.when(propertyService.getAllProperties()).thenReturn(propertyList);
        ResponseEntity<List<PropertyDTO>> responseEntity = propertyController.getAllProperties();
        assertEquals(1, responseEntity.getBody().size());
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
    }
    @Test
    @DisplayName("Test Success Scenario for updating only price of the Property")
    void testUpdatePropertyPrice(){

        PropertyDTO dto = new PropertyDTO();
        dto.setPrice(67676.78);

        Mockito.when(propertyService.updatePropertyPrice(Mockito.any(), Mockito.anyLong())).thenReturn(dto);
        ResponseEntity<PropertyDTO> responseEntity = propertyController.updatePropertyPrice(dto, 1L);

        assertEquals(67676.78, responseEntity.getBody().getPrice());
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
    }
}
