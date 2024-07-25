package com.sharp.direct;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-06-07 09:21:04
 */
@Data
public class Person implements Serializable {
    private String name;

    private Integer age;

    private String sex;

    private LocalDateTime time;
}
