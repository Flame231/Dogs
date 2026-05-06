package DTO;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String login;

    private LocalDateTime registrationTime;

    private LocalDateTime authorizationTime;

}
