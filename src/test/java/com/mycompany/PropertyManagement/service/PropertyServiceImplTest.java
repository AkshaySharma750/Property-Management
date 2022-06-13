package com.mycompany.PropertyManagement.service;

import com.mycompany.PropertyManagement.converter.PropertyConverter;
import com.mycompany.PropertyManagement.dto.PropertyDTO;
import com.mycompany.PropertyManagement.entity.PropertyEntity;
import com.mycompany.PropertyManagement.entity.UserEntity;
import com.mycompany.PropertyManagement.exception.BusinessException;
import com.mycompany.PropertyManagement.exception.ErrorModel;
import com.mycompany.PropertyManagement.repository.PropertyRepository;
import com.mycompany.PropertyManagement.repository.UserRepository;
import com.mycompany.PropertyManagement.service.impl.PropertyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceImplTest {

    @InjectMocks
    private PropertyServiceImpl propertyServiceImpl;

    @Mock
    private PropertyConverter propertyConverter;

    @Mock
    private PropertyRepository propertyRepository;

    @Mock
    private UserRepository userRepository;




    @Test
    void testSaveProperty_Success(){

        PropertyDTO dto = new PropertyDTO();
        dto.setTitle("Dummy");
        dto.setUserId(11L);

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle("Dummy");

        PropertyEntity savedEntity = new PropertyEntity();
        savedEntity.setTitle("Dummy");
        savedEntity.setId(1234L);

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setId(1234L);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(11L);
        userEntity.setOwnerName("xyz");

        Mockito.when(userRepository.findById(11L)).thenReturn(Optional.of(userEntity));
        Mockito.when(propertyConverter.convertDTOtoEntity(Mockito.any())).thenReturn(propertyEntity);
        Mockito.when(propertyRepository.save(Mockito.any())).thenReturn(savedEntity);
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);


        PropertyDTO result = propertyServiceImpl.saveProperty(dto);
        Assertions.assertEquals("Dummy", result.getTitle());
        Assertions.assertNotNull(result.getId());
    }

    @Test
    void testGetAllProperties_Success(){

        List<PropertyEntity> propertyEntities = new ArrayList<>();
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setId(1L);
        propertyEntity.setTitle("Dummy");
        propertyEntities.add(propertyEntity);

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setId(1L);

        Mockito.when(propertyRepository.findAll()).thenReturn(propertyEntities);
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);

        List<PropertyDTO> listPropDTO = propertyServiceImpl.getAllProperties();
        Assertions.assertEquals(1, listPropDTO.size());
    }

    @Test
    void testUpdateProperty_Success(){

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setPrice(234455.4);
        savedDTO.setDescription("abc");
        savedDTO.setAddress("xyz");

        PropertyEntity pe = new PropertyEntity();
        pe.setTitle("Dummy");
        pe.setPrice(234455.4);
        pe.setDescription("abc");
        pe.setAddress("xyz");


        when(propertyRepository.findById(Mockito.any())).thenReturn(Optional.of(pe));
        when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);

        PropertyDTO updatedProperty = propertyServiceImpl.updateProperty(savedDTO, 1L);
        Assertions.assertEquals(savedDTO.getTitle(), updatedProperty.getTitle());
        Assertions.assertEquals(savedDTO.getPrice(), updatedProperty.getPrice());
    }

    @Test
    void testUpdatePropertyDescription_Success(){

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setPrice(234455.4);
        savedDTO.setAddress("xyz");
        savedDTO.setDescription("updated abc");

        PropertyEntity pe = new PropertyEntity();
        pe.setTitle("Dummy");
        pe.setPrice(234455.4);
        pe.setDescription("updated abc");
        pe.setAddress("xyz");


        when(propertyRepository.findById(Mockito.any())).thenReturn(Optional.of(pe));
        when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);

        PropertyDTO updatedProperty = propertyServiceImpl.updatePropertyDescription(savedDTO, 1L);
        Assertions.assertEquals(savedDTO.getDescription(), updatedProperty.getDescription());

    }

    @Test
    void testUpdatePropertyDescription_Failure(){

        PropertyDTO savedDTO = new PropertyDTO();

        when(propertyRepository.findById(Mockito.any())).thenReturn(Optional.empty());


            BusinessException exception = Assertions.assertThrows(BusinessException.class, () -> {
                PropertyDTO updatedProperty = propertyServiceImpl.updatePropertyDescription(savedDTO, 1L);
            });

            Assertions.assertEquals("No property found for Update", exception.getMessage());
            }
    }


