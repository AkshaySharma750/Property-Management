package com.mycompany.PropertyManagement.converter;

import com.mycompany.PropertyManagement.dto.PropertyDTO;
import com.mycompany.PropertyManagement.entity.PropertyEntity;
import com.mycompany.PropertyManagement.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyConverterTest {

    @InjectMocks
    private PropertyConverter propertyConverter;

    @Test
    void testConvertDTOtoEntity_Success() {

        PropertyDTO dto = new PropertyDTO();
        dto.setTitle("Dummy");
        dto.setPrice(12345.55);

        PropertyEntity propertyEntity = propertyConverter.convertDTOtoEntity(dto);

        Assertions.assertEquals(dto.getPrice(), propertyEntity.getPrice());
        Assertions.assertEquals(dto.getTitle(), propertyEntity.getTitle());
    }

    @Test
    void testConvertEntityToDTO_Success() {

        PropertyEntity entity = new PropertyEntity();
        entity.setTitle("Dummy");
        entity.setPrice(12345.55);

        UserEntity ue = new UserEntity();
        entity.setUserEntity(ue);

        PropertyDTO dto = propertyConverter.convertEntityToDTO(entity);

        Assertions.assertEquals(entity.getPrice(), dto.getPrice());
        Assertions.assertEquals(entity.getTitle(), dto.getTitle());
    }

}

