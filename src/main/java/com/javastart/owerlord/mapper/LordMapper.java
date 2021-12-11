package com.javastart.owerlord.mapper;

import com.javastart.owerlord.dto.request.LordCreateRequest;
import com.javastart.owerlord.dto.response.LordView;
import com.javastart.owerlord.entity.Lord;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LordMapper {

    LordView convert(Lord lord);

    List<LordView> convert(List<Lord> lord);

    Lord convert(LordCreateRequest request);
}