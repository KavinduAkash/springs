package com.kavinduakash.springs.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonResponseDTO {
    private boolean success;
    private String msg;
}
