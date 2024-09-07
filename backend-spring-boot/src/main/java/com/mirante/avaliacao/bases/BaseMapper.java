package com.mirante.avaliacao.bases;

public abstract class BaseMapper<Entity, EntityDto> {

//    public abstract Entity filterToEntity(EntityFilter filter);

    public abstract Entity dtoToEntity(EntityDto EntityDto);

//    public abstract EntityFilter entityToFilter(Entity entity);
//
//    public abstract EntityFilter dtoToFilter(EntityDto EntityDto);

    public abstract EntityDto entityDto(Entity entity);

//    public abstract EntityDto filterToDto(EntityFilter entityFilter);

}
