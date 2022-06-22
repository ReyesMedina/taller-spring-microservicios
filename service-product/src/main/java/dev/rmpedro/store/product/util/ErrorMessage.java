package dev.rmpedro.store.product.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class ErrorMessage {
    private String code;
    private List<Map<String,String>> messages;


}
