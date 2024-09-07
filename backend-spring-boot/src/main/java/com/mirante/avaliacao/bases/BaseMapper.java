package com.mirante.avaliacao.bases;

public abstract class BaseMapper<Entity, EntityDto> {

    public abstract Entity dtoToEntity(EntityDto EntityDto);

    public abstract EntityDto entityDto(Entity entity);

}
