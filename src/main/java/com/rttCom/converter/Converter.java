package com.rttCom.converter;

public interface Converter<Entity, DTO> {

	public Entity convertToEntity(DTO dto);
	
	public DTO convertToDTO(Entity entity);
}