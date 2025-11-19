package com.ms_reserva.dto;

import com.ms_reserva.entity.OrdenItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrdenDto {
    private List<OrdenItem> ordenItems;
}
