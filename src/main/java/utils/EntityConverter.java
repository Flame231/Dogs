package utils;

public interface EntityConverter <DTO,ENTITY>{
    DTO convertToDTO(ENTITY entity);

    ENTITY convertToEntity(DTO dto);
}
