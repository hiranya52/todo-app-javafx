package model.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompletedTask {

    private String date;
    private String title;
    private String Description;

}
