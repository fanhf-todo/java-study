package com.fanhf.javastudy.builderreplcnew.test;

import lombok.*;

/**
 * @author fanhf
 * @date 2021-01-25 09:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class School {
    private String schoolName;
    private String major;
}
