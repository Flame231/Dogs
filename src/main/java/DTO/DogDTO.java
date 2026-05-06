package DTO;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DogDTO {

    private Long id;

    private String name;

    private String type;
}
