package com.andy.attire.dto.response;

import com.andy.attire.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private long total;
    private List<ProductDto> products;
}
