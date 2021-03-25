package com.exam5.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@XmlRootElement(name = "request")
public class Request {
    private Long id;
    private Date requestDateTime;
    private String name;
    private Integer birthYear;
    private String gender;
}
