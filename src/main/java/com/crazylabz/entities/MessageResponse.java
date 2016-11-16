package com.crazylabz.entities;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class MessageResponse {
    private String message;
}
