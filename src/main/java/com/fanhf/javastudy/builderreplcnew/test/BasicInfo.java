package com.fanhf.javastudy.builderreplcnew.test;

import com.fanhf.javastudy.builderreplcnew.Builder;
import lombok.*;

/**
 * @author fanhf
 * @date 2021-01-25 10:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class BasicInfo {
    private String name;
    private Integer age;
    private String address;
    private Job job;

    public void setJob(String company,Double salary){
        this.job = Builder.of(Job::new)
                .with(Job::setCompany,company)
                .with(Job::setSalary,salary)
                .build();
    }
}
